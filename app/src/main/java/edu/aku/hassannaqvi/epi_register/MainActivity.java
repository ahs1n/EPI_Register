package edu.aku.hassannaqvi.epi_register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Validator;

import edu.aku.hassannaqvi.epi_register.core.MainApp;
import edu.aku.hassannaqvi.epi_register.database.AndroidManager;
import edu.aku.hassannaqvi.epi_register.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.epi_register.ui.ChangePasswordActivity;
import edu.aku.hassannaqvi.epi_register.ui.SyncActivity;
import edu.aku.hassannaqvi.epi_register.ui.sections.SectionCRActivity;
import edu.aku.hassannaqvi.epi_register.ui.sections.SectionWRActivity;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(bi.toolbar);
        bi.toolbar.setSubtitle("Welcome, " + MainApp.user.getFullname() + (MainApp.admin ? " (Admin)" : "") + "!");
        bi.setCallback(this);

        bi.adminView.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);
        bi.username.setText("Welcome, " + MainApp.user.getFullname() + "!");

        MainApp.crAddress = "";
        MainApp.wrAddress = "";

    }

    public void sectionPress(View view) {
        if (!Validator.emptyCheckingContainer(this, bi.llregno)) return;

        switch (view.getId()) {

            case R.id.openChildForm:
//                MainApp.cr = new FormCR();
                finish();
                startActivity(new Intent(this, SectionCRActivity.class)
                        .putExtra("dmureg", bi.dmureg.getText().toString())
                        .putExtra("reg", bi.reg.getText().toString()));
                break;
            case R.id.openWomenForm:
                //MainApp.wr = new FormWR();
                finish();
                startActivity(new Intent(this, SectionWRActivity.class)
                        .putExtra("dmureg", bi.dmureg.getText().toString())
                        .putExtra("reg", bi.reg.getText().toString()));
                break;
            case R.id.dbm:
                startActivity(new Intent(this, AndroidManager.class));
                break;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.action_database:
                intent = new Intent(MainActivity.this, AndroidManager.class);
                startActivity(intent);
                break;
            case R.id.action_data_sync:
                intent = new Intent(MainActivity.this, SyncActivity.class);
                startActivity(intent);
                break;
            case R.id.changePassword:
                intent = new Intent(MainActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem action_database = menu.findItem(R.id.action_database);

//        action_database.setVisible(MainApp.admin);
        action_database.setVisible(true);
        return true;

    }
}