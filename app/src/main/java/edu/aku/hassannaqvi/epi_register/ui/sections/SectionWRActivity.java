package edu.aku.hassannaqvi.epi_register.ui.sections;

import static edu.aku.hassannaqvi.epi_register.core.MainApp.cbCheck;
import static edu.aku.hassannaqvi.epi_register.core.MainApp.wr;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

import org.json.JSONException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.epi_register.MainActivity;
import edu.aku.hassannaqvi.epi_register.R;
import edu.aku.hassannaqvi.epi_register.contracts.TableContracts;
import edu.aku.hassannaqvi.epi_register.core.MainApp;
import edu.aku.hassannaqvi.epi_register.database.DatabaseHelper;
import edu.aku.hassannaqvi.epi_register.databinding.ActivitySectionWrBinding;
import edu.aku.hassannaqvi.epi_register.models.FormWR;

public class SectionWRActivity extends AppCompatActivity {
    private static final String TAG = "SectionWRActivity";
    ActivitySectionWrBinding bi;
    String st = "";
    private DatabaseHelper db;
    boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppThemeUrdu);
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_wr);
        bi.setCallback(this);
        setupSkips();
        st = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime());
       /* bi.setForm(form);
        if (form == null) form = new Form();*/
//        bi.setForm(form);
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;

        b = getIntent().getBooleanExtra("b", false);
        if (b) wr = new FormWR();
        bi.setForm(wr);

        String dmuReg = getIntent().getStringExtra("dmureg");
        String reg = getIntent().getStringExtra("reg");
        bi.wrDmuRegister.setText(dmuReg);
        bi.wrRegNumber.setText(reg);
        wr.setWr_dmu_register(dmuReg);
        wr.setWr_reg_number(reg);

        if (MainApp.wrAddress.trim().equals(""))
            bi.wrAddressPrevious.setVisibility(View.GONE);
        bi.wrAddressPrevious.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.wrAddress.setText(MainApp.wrAddress);
                } else {
                    bi.wrAddress.setText("");

                }
            }
        });
    }


    private void setupSkips() {

        bi.wrAddressPrevious.setOnCheckedChangeListener((compoundButton, b) -> {
            Clear.clearAllFields(bi.wrAddress, !b);
        });

        bi.wrPhoneNa.setOnCheckedChangeListener((compoundButton, b) -> {
            Clear.clearAllFields(bi.wrPhone, !b);
        });

        cbCheck(bi.wrTtd1ds1, bi.wrTtd1ds2, bi.wrTtd1na, bi.wrTtd1);
        cbCheck(bi.wrTtd1ds2, bi.wrTtd1ds1, bi.wrTtd1na, bi.wrTtd1);
        cbCheck(bi.wrTtd1na, bi.wrTtd1ds2, bi.wrTtd1ds1, bi.wrTtd1);

        cbCheck(bi.wrTtd2ds1, bi.wrTtd2ds2, bi.wrTtd2na, bi.wrTtd2);
        cbCheck(bi.wrTtd2ds2, bi.wrTtd2ds1, bi.wrTtd2na, bi.wrTtd2);
        cbCheck(bi.wrTtd2na, bi.wrTtd2ds2, bi.wrTtd2ds1, bi.wrTtd2);

        cbCheck(bi.wrTtd3ds1, bi.wrTtd3ds2, bi.wrTtd3na, bi.wrTtd3);
        cbCheck(bi.wrTtd3ds2, bi.wrTtd3ds1, bi.wrTtd3na, bi.wrTtd3);
        cbCheck(bi.wrTtd3na, bi.wrTtd3ds2, bi.wrTtd3ds1, bi.wrTtd3);

        cbCheck(bi.wrTtd4ds1, bi.wrTtd4ds2, bi.wrTtd4na, bi.wrTtd4);
        cbCheck(bi.wrTtd4ds2, bi.wrTtd4ds1, bi.wrTtd4na, bi.wrTtd4);
        cbCheck(bi.wrTtd4na, bi.wrTtd4ds2, bi.wrTtd4ds1, bi.wrTtd4);

        cbCheck(bi.wrTtd5ds1, bi.wrTtd5ds2, bi.wrTtd5na, bi.wrTtd5);
        cbCheck(bi.wrTtd5ds2, bi.wrTtd5ds1, bi.wrTtd5na, bi.wrTtd5);
        cbCheck(bi.wrTtd5na, bi.wrTtd5ds2, bi.wrTtd5ds1, bi.wrTtd5);
    }


    private boolean insertNewRecord() {
        if (!wr.getUid().equals("") || MainApp.superuser) return true;
        MainApp.wr.populateMeta();
        long rowId = 0;
        try {
            rowId = db.addWR(wr);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.wr.setId(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.wr.setUid(MainApp.wr.getDeviceId() + MainApp.wr.getId());
            db.updateWrColumn(TableContracts.FormWRTable.COLUMN_UID, MainApp.wr.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private boolean updateDB() {
        if (MainApp.superuser) return true;

        db = MainApp.appInfo.getDbHelper();
        long updcount = 0;
        try {
            updcount = db.updateWrColumn(TableContracts.FormWRTable.COLUMN_WR, wr.wRtoString());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, R.string.upd_db + e.getMessage());
            Toast.makeText(this, R.string.upd_db + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        if (updcount > 0) return true;
        else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public void btnContinue(View view) {
        if (!formValidation()) return;
        MainApp.wrAddress = bi.wrAddress.getText().toString();
        wr.setStartTime(st);
        if (!insertNewRecord()) return;
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionWRActivity.class)
                    .putExtra("dmureg", bi.wrDmuRegister.getText().toString())
                    .putExtra("reg", bi.wrRegNumber.getText().toString()).putExtra("b", true));
        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }


    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }


    @Override
    public void onBackPressed() {
        // Toast.makeText(getApplicationContext(), "Back Press Not Allowed", Toast.LENGTH_LONG).show();
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainApp.lockScreen(this);
    }
}