package edu.aku.hassannaqvi.epi_register.ui.lists;

import static edu.aku.hassannaqvi.epi_register.core.MainApp.crFollowUP;
import static edu.aku.hassannaqvi.epi_register.core.MainApp.formCRFupList;
import static edu.aku.hassannaqvi.epi_register.core.MainApp.formCRList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import edu.aku.hassannaqvi.epi_register.MainActivity;
import edu.aku.hassannaqvi.epi_register.R;
import edu.aku.hassannaqvi.epi_register.adapters.RegisteredMembersAdapter;
import edu.aku.hassannaqvi.epi_register.core.MainApp;
import edu.aku.hassannaqvi.epi_register.database.DatabaseHelper;
import edu.aku.hassannaqvi.epi_register.databinding.ActivityRegisteredListChildBinding;
import edu.aku.hassannaqvi.epi_register.models.FormCR;
import edu.aku.hassannaqvi.epi_register.models.FormCRFollowUP;
import edu.aku.hassannaqvi.epi_register.ui.sections.SectionCRActivity;


public class RegisteredChildListActivity extends AppCompatActivity {


    private static final String TAG = "RegisteredChildListActivity";
    ActivityRegisteredListChildBinding bi;
    DatabaseHelper db;
    ActivityResultLauncher<Intent> MemberInfoLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && !MainApp.superuser) {
                    Intent data = result.getData();
                    formCRFupList.add(MainApp.crFollowUP);
                }

                if (result.getResultCode() == Activity.RESULT_CANCELED) {
                    Toast.makeText(RegisteredChildListActivity.this, "No member added.", Toast.LENGTH_SHORT).show();
                }
            });
    private RegisteredMembersAdapter registeredMembersAdapter;

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_registered_list_child);
        bi.setCallback(this);
        db = MainApp.appInfo.dbHelper;
        try {
            formCRFupList = db.getAllChilds();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        initSearchFilter();

        try {
            MainApp.formCRList = db.getAllFormCR();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        int count = 0;
        if (formCRFupList != null && formCRFupList.size() > 0 &&
                formCRList != null && formCRList.size() > 0) {
            List<FormCRFollowUP> _tempList = new ArrayList<>(formCRFupList);
            for (int i = 0; i < formCRFupList.size(); i++) {
                if (count == formCRList.size()) break;
                for (int j = 0; j < formCRList.size(); j++) {
                    if (formCRFupList.get(i).getUID().equals(formCRList.get(j).getUuid())) {
                        _tempList.remove(formCRFupList.get(i));
                        count++;
                        break;
                    }
                }
            }
            formCRFupList = _tempList;
        }

        registeredMembersAdapter = new RegisteredMembersAdapter(this, formCRFupList, member -> {
            try {
                MainApp.crFollowUP = db.getSelectedMembers(member.getUID(), member.getCr_card_number(), member.getCr_dmu_register(), member.getCr_page_number());
                Toast.makeText(RegisteredChildListActivity.this,
                        "Selected Member\n Card No: "
                                + member.getCr_card_number() + "\nName: "
                                + member.getCr_child_name(),
                        Toast.LENGTH_LONG).show();
                RegisteredChildListActivity.this.startActivity(new Intent(RegisteredChildListActivity.this, SectionCRActivity.class).putExtra("b", false));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
        bi.rvMember.setAdapter(registeredMembersAdapter);

        registeredMembersAdapter.notifyDataSetChanged();
        bi.rvMember.setLayoutManager(new LinearLayoutManager(this));

        bi.fab.setOnClickListener(view -> {
            addMoreMember();
        });


        bi.searchBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.searchByName.isChecked()) {
                    bi.memberId.setText(null);
                    bi.memberId.setHint("Name");
                } else if (bi.searchByPageNo.isChecked()) {
                    bi.memberId.setText(null);
                    bi.memberId.setHint("Page No");
                } else {
                    bi.memberId.setText(null);
                    bi.memberId.setHint("Card No");
                }
            }
        });

        /*String dmuReg = getIntent().getStringExtra("dmureg");
        String reg = getIntent().getStringExtra("reg");*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainApp.lockScreen(this);
        Toast.makeText(this, "Activity Resumed!", Toast.LENGTH_SHORT).show();
    }

    private void addMoreMember() {
        MainApp.cr = new FormCR();
        Intent intent = new Intent(this, SectionCRActivity.class)
                .putExtra("new", true);
        finish();
        MemberInfoLauncher.launch(intent);
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterForms(View view) throws JSONException {

        if (bi.searchByName.isChecked()) {
            Toast.makeText(this, "Searched", Toast.LENGTH_SHORT).show();

            formCRFupList = db.getAllChildsByName(bi.memberId.getText().toString());
            registeredMembersAdapter = new RegisteredMembersAdapter(this, formCRFupList, member -> {

                try {
                    crFollowUP = db.getSelectedMembers(member.getUID(), member.getCr_card_number(), member.getCr_dmu_register(), member.getCr_page_number());
                    Toast.makeText(RegisteredChildListActivity.this,
                            "Selected Member\n Card No: "
                                    + member.getCr_card_number() + "\nName: "
                                    + member.getCr_child_name(),
                            Toast.LENGTH_LONG).show();
                    RegisteredChildListActivity.this.startActivity(new Intent(RegisteredChildListActivity.this, SectionCRActivity.class).putExtra("b", false));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });
            registeredMembersAdapter.notifyDataSetChanged();
            bi.rvMember.setAdapter(registeredMembersAdapter);
        } else {
            Toast.makeText(this, "Searched", Toast.LENGTH_SHORT).show();

            formCRFupList = db.getAllChildsByCardNo(bi.memberId.getText().toString());
            registeredMembersAdapter = new RegisteredMembersAdapter(this, formCRFupList, member -> {

                try {
                    crFollowUP = db.getSelectedMembers(member.getUID(), member.getCr_card_number(), member.getCr_dmu_register(), member.getCr_page_number());
                    Toast.makeText(RegisteredChildListActivity.this,
                            "Selected Member\n Card No: "
                                    + member.getCr_card_number() + "\nName: "
                                    + member.getCr_child_name(),
                            Toast.LENGTH_LONG).show();
                    RegisteredChildListActivity.this.startActivity(new Intent(RegisteredChildListActivity.this, SectionCRActivity.class).putExtra("b", false));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            });
            registeredMembersAdapter.notifyDataSetChanged();
            bi.rvMember.setAdapter(registeredMembersAdapter);
        }

    }

    public void btnEnd(View view) {

        finish();
    }

    @Override
    public void onBackPressed() {
        // Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }


    // Search Filter
    private void initSearchFilter() {
        bi.memberId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (bi.searchByPageNo.isChecked()) {
                    registeredMembersAdapter.filterPageNo(s.toString());
                } else if (bi.searchByName.isChecked()) {
                    registeredMembersAdapter.filterChildName(s.toString());
                } else registeredMembersAdapter.filterCardNo(s.toString());
            }
        });

        bi.memberId.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (bi.searchByPageNo.isChecked()) {
                    registeredMembersAdapter.filterPageNo(v.getText().toString());
                } else if (bi.searchByName.isChecked()) {
                    registeredMembersAdapter.filterChildName(v.getText().toString());
                } else registeredMembersAdapter.filterCardNo(v.getText().toString());

                return true;
            }
        });
    }
}