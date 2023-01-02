package edu.aku.hassannaqvi.epi_register.ui.sections;

import static edu.aku.hassannaqvi.epi_register.core.MainApp.cbCheck;
import static edu.aku.hassannaqvi.epi_register.core.MainApp.cr;

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
import edu.aku.hassannaqvi.epi_register.databinding.ActivitySectionCrBinding;

public class SectionCRActivity extends AppCompatActivity {
    private static final String TAG = "SectionCRActivity";
    ActivitySectionCrBinding bi;
    String st = "";
    private DatabaseHelper db;
    boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_cr);
        bi.setCallback(this);
        st = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime());
        setupSkips();
//        bi.setForm(cr);
        /*if (cr == null)
            cr = new FormCR();*/
        bi.setForm(cr);
        setSupportActionBar(bi.toolbar);
        db = MainApp.appInfo.dbHelper;
        String dmuReg = getIntent().getStringExtra("dmureg");
        String reg = getIntent().getStringExtra("reg");
        bi.crDmuRegister.setText(dmuReg);
        bi.crRegNumber.setText(reg);
        cr.setCr_dmu_register(dmuReg);
        cr.setCr_reg_number(reg);

        if (MainApp.crAddress.trim().equals(""))
            bi.crAddressPrevious.setVisibility(View.GONE);
        bi.crAddressPrevious.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.crAddress.setText(MainApp.crAddress);
                } else {
                    bi.crAddress.setText("");

                }
            }
        });

    }


    private void setupSkips() {

        bi.crAddressPrevious.setOnCheckedChangeListener((compoundButton, b) -> {
            Clear.clearAllFields(bi.crAddress, !b);
        });

        bi.crPhoneNa.setOnCheckedChangeListener((compoundButton, b) -> {
            Clear.clearAllFields(bi.crPhone, !b);
        });

        cbCheck(bi.crBcgD1, bi.crBcgD2, bi.crBcgNa, bi.crBcg);
        cbCheck(bi.crBcgD2, bi.crBcgD1, bi.crBcgNa, bi.crBcg);
        cbCheck(bi.crBcgNa, bi.crBcgD2, bi.crBcgD1, bi.crBcg);

        cbCheck(bi.crHepB1, bi.crHepB2, bi.crHepBna, bi.crHepB);
        cbCheck(bi.crHepB2, bi.crHepB1, bi.crHepBna, bi.crHepB);
        cbCheck(bi.crHepBna, bi.crHepB2, bi.crHepB1, bi.crHepB);

        cbCheck(bi.crOpv0D1, bi.crOpv0D2, bi.crOpv0Na, bi.crOpv0);
        cbCheck(bi.crOpv0D2, bi.crOpv0D1, bi.crOpv0Na, bi.crOpv0);
        cbCheck(bi.crOpv0Na, bi.crOpv0D2, bi.crOpv0D1, bi.crOpv0);

        cbCheck(bi.crOpv1D1, bi.crOpv1D2, bi.crOpv1Na, bi.crOpv1);
        cbCheck(bi.crOpv1D2, bi.crOpv1D1, bi.crOpv1Na, bi.crOpv1);
        cbCheck(bi.crOpv1Na, bi.crOpv1D2, bi.crOpv1D1, bi.crOpv1);

        cbCheck(bi.crOpv2D1, bi.crOpv2D2, bi.crOpv2Na, bi.crOpv2);
        cbCheck(bi.crOpv2D2, bi.crOpv2D1, bi.crOpv2Na, bi.crOpv2);
        cbCheck(bi.crOpv2Na, bi.crOpv2D2, bi.crOpv2D1, bi.crOpv2);

        cbCheck(bi.crOpv3D1, bi.crOpv3D2, bi.crOpv3Na, bi.crOpv3);
        cbCheck(bi.crOpv3D2, bi.crOpv3D1, bi.crOpv3Na, bi.crOpv3);
        cbCheck(bi.crOpv3Na, bi.crOpv3D2, bi.crOpv3D1, bi.crOpv3);

        cbCheck(bi.crRota1D1, bi.crRota1D2, bi.crRota1Na, bi.crRota1);
        cbCheck(bi.crRota1D2, bi.crRota1D1, bi.crRota1Na, bi.crRota1);
        cbCheck(bi.crRota1Na, bi.crRota1D2, bi.crRota1D1, bi.crRota1);

        cbCheck(bi.crRota2D1, bi.crRota2D2, bi.crRota2Na, bi.crRota2);
        cbCheck(bi.crRota2D2, bi.crRota2D1, bi.crRota2Na, bi.crRota2);
        cbCheck(bi.crRota2Na, bi.crRota2D2, bi.crRota2D1, bi.crRota2);

        cbCheck(bi.crIpvD1, bi.crIpvD2, bi.crIpvNa, bi.crIpv);
        cbCheck(bi.crIpvD2, bi.crIpvD1, bi.crIpvNa, bi.crIpv);
        cbCheck(bi.crIpvNa, bi.crIpvD2, bi.crIpvD1, bi.crIpv);

        cbCheck(bi.crPcv1D1, bi.crPcv1D2, bi.crPcv1Na, bi.crPcv1);
        cbCheck(bi.crPcv1D2, bi.crPcv1D1, bi.crPcv1Na, bi.crPcv1);
        cbCheck(bi.crPcv1Na, bi.crPcv1D2, bi.crPcv1D1, bi.crPcv1);

        cbCheck(bi.crPcv2D1, bi.crPcv2D2, bi.crPcv2Na, bi.crPcv2);
        cbCheck(bi.crPcv2D2, bi.crPcv2D1, bi.crPcv2Na, bi.crPcv2);
        cbCheck(bi.crPcv2Na, bi.crPcv2D2, bi.crPcv2D1, bi.crPcv2);

        cbCheck(bi.crPcv3D1, bi.crPcv3D2, bi.crPcv3Na, bi.crPcv3);
        cbCheck(bi.crPcv3D2, bi.crPcv3D1, bi.crPcv3Na, bi.crPcv3);
        cbCheck(bi.crPcv3Na, bi.crPcv3D2, bi.crPcv3D1, bi.crPcv3);

        cbCheck(bi.crPenta1D1, bi.crPenta1D2, bi.crPenta1Na, bi.crPenta1);
        cbCheck(bi.crPenta1D2, bi.crPenta1D1, bi.crPenta1Na, bi.crPenta1);
        cbCheck(bi.crPenta1Na, bi.crPenta1D2, bi.crPenta1D1, bi.crPenta1);

        cbCheck(bi.crPenta2D1, bi.crPenta2D2, bi.crPenta2Na, bi.crPenta2);
        cbCheck(bi.crPenta2D2, bi.crPenta2D1, bi.crPenta2Na, bi.crPenta2);
        cbCheck(bi.crPenta2Na, bi.crPenta2D2, bi.crPenta2D1, bi.crPenta2);

        cbCheck(bi.crPenta3D1, bi.crPenta3D2, bi.crPenta3Na, bi.crPenta3);
        cbCheck(bi.crPenta3D2, bi.crPenta3D1, bi.crPenta3Na, bi.crPenta3);
        cbCheck(bi.crPenta3Na, bi.crPenta3D2, bi.crPenta3D1, bi.crPenta3);

        cbCheck(bi.crMeasles1D1, bi.crMeasles1D2, bi.crMeasles1Na, bi.crMeasles1);
        cbCheck(bi.crMeasles1D2, bi.crMeasles1D1, bi.crMeasles1Na, bi.crMeasles1);
        cbCheck(bi.crMeasles1Na, bi.crMeasles1D2, bi.crMeasles1D1, bi.crMeasles1);

        cbCheck(bi.crMeasles2D1, bi.crMeasles2D2, bi.crMeasles2Na, bi.crMeasles2);
        cbCheck(bi.crMeasles2D2, bi.crMeasles2D1, bi.crMeasles2Na, bi.crMeasles2);
        cbCheck(bi.crMeasles2Na, bi.crMeasles2D2, bi.crMeasles2D1, bi.crMeasles2);

    }


    private boolean insertNewRecord() {
        if (!cr.getUid().equals("") || MainApp.superuser) return true;
        MainApp.cr.populateMeta();
        long rowId = 0;
        try {
            rowId = db.addCR(cr);
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.db_excp_error, Toast.LENGTH_SHORT).show();
            return false;
        }
        MainApp.cr.setId(String.valueOf(rowId));
        if (rowId > 0) {
            MainApp.cr.setUid(MainApp.cr.getDeviceId() + MainApp.cr.getId());
            db.updateCrColumn(TableContracts.FormCRTable.COLUMN_UID, MainApp.cr.getUid());
            return true;
        } else {
            Toast.makeText(this, R.string.upd_db_error, Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private boolean updateDB() {
        if (MainApp.superuser) return true;

        db = MainApp.appInfo.getDbHelper();
//        cr.setStartTime(st);
        long updcount = 0;
        try {
            updcount = db.updateCrColumn(TableContracts.FormCRTable.COLUMN_CR, cr.cRtoString());
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
        MainApp.crAddress = bi.crAddress.getText().toString();
        cr.setStartTime(st);
        if (!insertNewRecord()) return;
        if (updateDB()) {
            finish();
            startActivity(new Intent(this, SectionCRActivity.class)
                    .putExtra("dmureg", bi.crDmuRegister.getText().toString())
                    .putExtra("reg", bi.crRegNumber.getText().toString()).putExtra("b", false));
        } else Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
    }


    public void btnEnd(View view) {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }


    private boolean formValidation() {
        if (!Validator.emptyCheckingContainer(this, bi.GrpName))
            return false;

        if (Integer.parseInt(bi.crAgeDays.getText().toString())
                + Integer.parseInt(bi.crAgeMonths.getText().toString())
                + Integer.parseInt(bi.crAgeYears.getText().toString()) == 0) {
            return Validator.emptyCustomTextBox(this, bi.crAgeYears, "Age Cannot be 0", false);
        }
        return true;
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