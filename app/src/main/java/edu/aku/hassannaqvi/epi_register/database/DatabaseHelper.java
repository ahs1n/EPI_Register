package edu.aku.hassannaqvi.epi_register.database;

import static edu.aku.hassannaqvi.epi_register.core.MainApp.IBAHC;
import static edu.aku.hassannaqvi.epi_register.core.UserAuth.checkPassword;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.DATABASE_NAME;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.DATABASE_VERSION;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_ALTER_USERS_ENABLED;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_ALTER_USERS_ISNEW_USER;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_ALTER_USERS_PWD_EXPIRY;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_CREATE_ENTRYLOGS;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_CREATE_FORMCR;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_CREATE_FORMCRFollowUP;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_CREATE_FORMWR;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_CREATE_USERS;
import static edu.aku.hassannaqvi.epi_register.database.CreateTable.SQL_CREATE_VERSIONAPP;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.util.Log;
import android.widget.Toast;

import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.epi_register.contracts.TableContracts.EntryLogTable;
import edu.aku.hassannaqvi.epi_register.contracts.TableContracts.FormCRFollowUPTable;
import edu.aku.hassannaqvi.epi_register.contracts.TableContracts.FormCRTable;
import edu.aku.hassannaqvi.epi_register.contracts.TableContracts.FormWRTable;
import edu.aku.hassannaqvi.epi_register.contracts.TableContracts.UsersTable;
import edu.aku.hassannaqvi.epi_register.core.MainApp;
import edu.aku.hassannaqvi.epi_register.models.EntryLog;
import edu.aku.hassannaqvi.epi_register.models.FormCR;
import edu.aku.hassannaqvi.epi_register.models.FormCRFollowUP;
import edu.aku.hassannaqvi.epi_register.models.FormWR;
import edu.aku.hassannaqvi.epi_register.models.Users;



/*import edu.aku.hassannaqvi.naunehal.models.Immunization;*/

/**
 * @author hassan.naqvi on 11/30/2016.
 * @update ali azaz on 01/07/21
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_PASSWORD = IBAHC;
    private final String TAG = "DatabaseHelper";
    private final Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMCR);
        db.execSQL(SQL_CREATE_FORMCRFollowUP);
        db.execSQL(SQL_CREATE_FORMWR);
        db.execSQL(SQL_CREATE_VERSIONAPP);
        db.execSQL(SQL_CREATE_ENTRYLOGS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion) {
            case 1:
                db.execSQL(SQL_ALTER_USERS_ENABLED);
                db.execSQL(SQL_ALTER_USERS_ISNEW_USER);
                db.execSQL(SQL_ALTER_USERS_PWD_EXPIRY);
        }
    }


    //ADDITION in DB
    public Long addCR(FormCR cr) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(FormCRTable.COLUMN_PROJECT_NAME, cr.getProjectName());
        values.put(FormCRTable.COLUMN_UID, cr.getUid());
        values.put(FormCRTable.COLUMN_UUID, cr.getUuid());
        values.put(FormCRTable.COLUMN_USERNAME, cr.getUserName());
        values.put(FormCRTable.COLUMN_SYSDATE, cr.getSysDate());
        values.put(FormCRTable.COLUMN_ISTATUS, cr.getiStatus());
        values.put(FormCRTable.COLUMN_DEVICETAGID, cr.getDeviceTag());
        values.put(FormCRTable.COLUMN_DEVICEID, cr.getDeviceId());
        values.put(FormCRTable.COLUMN_APPVERSION, cr.getAppver());
        values.put(FormCRTable.COLUMN_START_TIME, cr.getStartTime());
        values.put(FormCRTable.COLUMN_END_TIME, cr.getEndTime());
        values.put(FormCRTable.COLUMN_CR, cr.cRtoString());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormCRTable.TABLE_NAME,
                FormCRTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addWR(FormWR wr) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(FormWRTable.COLUMN_PROJECT_NAME, wr.getProjectName());
        values.put(FormWRTable.COLUMN_UID, wr.getUid());
        values.put(FormWRTable.COLUMN_USERNAME, wr.getUserName());
        values.put(FormWRTable.COLUMN_SYSDATE, wr.getSysDate());
        values.put(FormWRTable.COLUMN_ISTATUS, wr.getiStatus());
        values.put(FormWRTable.COLUMN_DEVICETAGID, wr.getDeviceTag());
        values.put(FormWRTable.COLUMN_DEVICEID, wr.getDeviceId());
        values.put(FormWRTable.COLUMN_APPVERSION, wr.getAppver());
        values.put(FormWRTable.COLUMN_START_TIME, wr.getStartTime());
        values.put(FormWRTable.COLUMN_END_TIME, wr.getEndTime());
        values.put(FormWRTable.COLUMN_WR, wr.wRtoString());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormWRTable.TABLE_NAME,
                FormWRTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addEntryLog(EntryLog entryLog) throws SQLiteException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_PROJECT_NAME, entryLog.getProjectName());
        values.put(EntryLogTable.COLUMN_UUID, entryLog.getUuid());
        values.put(EntryLogTable.COLUMN_USERNAME, entryLog.getUserName());
        values.put(EntryLogTable.COLUMN_SYSDATE, entryLog.getSysDate());
        values.put(EntryLogTable.COLUMN_ISTATUS, entryLog.getiStatus());
        values.put(EntryLogTable.COLUMN_ISTATUS96x, entryLog.getiStatus96x());
        values.put(EntryLogTable.COLUMN_ENTRY_DATE, entryLog.getEntryDate());
        values.put(EntryLogTable.COLUMN_DEVICEID, entryLog.getDeviceId());
        values.put(EntryLogTable.COLUMN_SYNCED, entryLog.getSynced());
        values.put(EntryLogTable.COLUMN_SYNC_DATE, entryLog.getSyncDate());
        values.put(EntryLogTable.COLUMN_APPVERSION, entryLog.getAppver());

        long newRowId;
        newRowId = db.insertOrThrow(
                EntryLogTable.TABLE_NAME,
                EntryLogTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    //UPDATE in DB
    public int updateCrColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormCRTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.cr.getId())};

        return db.update(FormCRTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateWrColumn(String column, String value) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = FormWRTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.wr.getId())};

        return db.update(FormWRTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    public int updatesEntryLogColumn(String column, String value, String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(column, value);

        String selection = EntryLogTable._ID + " =? ";
        String[] selectionArgs = {id};

        return db.update(EntryLogTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(FormCRTable.COLUMN_ISTATUS, MainApp.cr.getiStatus());

        // Which row to update, based on the ID
        String selection = FormCRTable.COLUMN_ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.cr.getId())};

        return db.update(FormCRTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }


    /*
     * Functions that dealing with table data
     * */
    public boolean doLogin(String username, String password) throws InvalidKeySpecException, NoSuchAlgorithmException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = UsersTable.COLUMN_USERNAME + "=? ";
        String[] whereArgs = {username};
        String groupBy = null;
        String having = null;
        String orderBy = UsersTable.COLUMN_ID + " ASC";

        Users loggedInUser = new Users();
        c = db.query(
                UsersTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            loggedInUser = new Users().hydrate(c);

        }

        c.close();

        if (loggedInUser.getPassword().equals("")) {
            Toast.makeText(mContext, "Stored password is invalid", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (checkPassword(password, loggedInUser.getPassword())) {
            MainApp.user = loggedInUser;
            //  MainApp.selectedDistrict = loggedInUser.getDist_id();
            return c.getCount() > 0;
        } else {
            return false;
        }
    }


    public ArrayList<FormCR> getFormsByDate(String sysdate) {

        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = {
                FormCRTable._ID,
                FormCRTable.COLUMN_UID,
                FormCRTable.COLUMN_SYSDATE,
                FormCRTable.COLUMN_USERNAME,
                FormCRTable.COLUMN_ISTATUS,
                FormCRTable.COLUMN_SYNCED,

        };
        String whereClause = FormCRTable.COLUMN_SYSDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + sysdate + " %"};
        String groupBy = null;
        String having = null;
        String orderBy = FormCRTable.COLUMN_ID + " ASC";
        ArrayList<FormCR> allForms = new ArrayList<>();
        try {
            c = db.query(
                    FormCRTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormCR forms = new FormCR();
                forms.setId(c.getString(c.getColumnIndexOrThrow(FormCRTable.COLUMN_ID)));
                forms.setUid(c.getString(c.getColumnIndexOrThrow(FormCRTable.COLUMN_UID)));
                forms.setSysDate(c.getString(c.getColumnIndexOrThrow(FormCRTable.COLUMN_SYSDATE)));
                forms.setUserName(c.getString(c.getColumnIndexOrThrow(FormCRTable.COLUMN_USERNAME)));
                allForms.add(forms);
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return allForms;
    }


    // istatus examples: (1) or (1,9) or (1,3,5)
    public FormCR getFormByAssessNo(String uid, String istatus) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormCRTable.COLUMN_UID + "=? AND " +
                FormCRTable.COLUMN_ISTATUS + " in " + istatus;

        String[] whereArgs = {uid};

        String groupBy = null;
        String having = null;

        String orderBy = FormCRTable.COLUMN_ID + " ASC";

        FormCR allFC = null;
        try {
            c = db.query(
                    FormCRTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allFC = new FormCR().Hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return allFC;
    }

    public ArrayList<Cursor> getDatabaseManagerData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(Query, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (Exception sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    /*public int updateTemp(String assessNo, String temp) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD)

        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_TSF305, temp);
        values.put(FormsTable.COLUMN_SYSDATE, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()) + "-Updated");
        values.put(FormsTable.COLUMN_ISTATUS, "1");
        values.put(FormsTable.COLUMN_SYNCED, (byte[]) null);

        String selection = FormsTable.COLUMN_ASSESMENT_NO + " =? AND " + FormsTable.COLUMN_ISTATUS + " =? ";
        // String selection = FormsTable.COLUMN_ASSESMENT_NO + " =? ";
        String[] selectionArgs = {assessNo, "9"};
        // String[] selectionArgs = {assessNo};

        return db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }*/


    public int syncVersionApp(JSONArray VersionList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        long count = 0;

        JSONObject jsonObjectVersion = ((JSONArray) VersionList.getJSONObject(0).get("elements")).getJSONObject(0);

        String appPath = jsonObjectVersion.getString("outputFile");
        String versionCode = jsonObjectVersion.getString("versionCode");

        MainApp.editor.putString("outputFile", jsonObjectVersion.getString("outputFile"));
        MainApp.editor.putString("versionCode", jsonObjectVersion.getString("versionCode"));
        MainApp.editor.putString("versionName", jsonObjectVersion.getString("versionName") + ".");
        MainApp.editor.apply();
        count++;
          /*  VersionApp Vc = new VersionApp();
            Vc.sync(jsonObjectVersion);

            ContentValues values = new ContentValues();

            values.put(VersionTable.COLUMN_PATH_NAME, Vc.getPathname());
            values.put(VersionTable.COLUMN_VERSION_CODE, Vc.getVersioncode());
            values.put(VersionTable.COLUMN_VERSION_NAME, Vc.getVersionname());

            count = db.insert(VersionTable.TABLE_NAME, null, values);
            if (count > 0) count = 1;

        } catch (Exception ignored) {
        } finally {
            db.close();
        }*/

        return (int) count;
    }

    public int syncusers(JSONArray userList) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(UsersTable.TABLE_NAME, null, null);
        int insertCount = 0;
        for (int i = 0; i < userList.length(); i++) {

            JSONObject jsonObjectUser = userList.getJSONObject(i);

            Users user = new Users();
            user.sync(jsonObjectUser);
            ContentValues values = new ContentValues();

            values.put(UsersTable.COLUMN_USERNAME, user.getUserName());
            values.put(UsersTable.COLUMN_PASSWORD, user.getPassword());
            values.put(UsersTable.COLUMN_FULLNAME, user.getFullname());
            values.put(UsersTable.COLUMN_ENABLED, user.getEnabled());
            values.put(UsersTable.COLUMN_ISNEW_USER, user.getNewUser());
            values.put(UsersTable.COLUMN_PWD_EXPIRY, user.getPwdExpiry());
            long rowID = db.insert(UsersTable.TABLE_NAME, null, values);
            if (rowID != -1) insertCount++;
        }
        return insertCount;
    }

    /*Sync FormCR*/
    public int syncFormCR(JSONArray formCR) throws JSONException {
        SQLiteDatabase db = this.getWritableDatabase(DATABASE_PASSWORD);
        db.delete(FormCRFollowUPTable.TABLE_NAME, null, null);
        int insertCount = 0;
        for (int i = 0; i < formCR.length(); i++) {

            JSONObject jsonObjectUser = formCR.getJSONObject(i);

            FormCRFollowUP formCRFollowUP = new FormCRFollowUP();
            formCRFollowUP.sync(jsonObjectUser);
            ContentValues values = new ContentValues();

            values.put(FormCRFollowUPTable.COLUMN_UID, formCRFollowUP.getUID());
            values.put(FormCRFollowUPTable.COLUMN_USERNAME, formCRFollowUP.getUserName());
            values.put(FormCRFollowUPTable.COLUMN_SYSDATE, formCRFollowUP.getSysDate());
            values.put(FormCRFollowUPTable.COLUMN_DEVICEID, formCRFollowUP.getDeviceId());
            values.put(FormCRFollowUPTable.COLUMN_ISTATUS, formCRFollowUP.getIStatus());
            values.put(FormCRFollowUPTable.COLUMN_START_TIME, formCRFollowUP.getStartTime());
            values.put(FormCRFollowUPTable.COLUMN_END_TIME, formCRFollowUP.getEndTime());
            values.put(FormCRFollowUPTable.COLUMN_CR_DMU_REGISTER, formCRFollowUP.getCr_dmu_register());
            values.put(FormCRFollowUPTable.COLUMN_CR_REG_NUMBER, formCRFollowUP.getCr_reg_number());
            values.put(FormCRFollowUPTable.COLUMN_CR_PAGE_NUMBER, formCRFollowUP.getCr_page_number());
            values.put(FormCRFollowUPTable.COLUMN_CR_RSNO, formCRFollowUP.getCr_rsno());
            values.put(FormCRFollowUPTable.COLUMN_CR_CARD_NUMBER, formCRFollowUP.getCr_card_number());
            values.put(FormCRFollowUPTable.COLUMN_CR_CHILD_NAME, formCRFollowUP.getCr_child_name());
            values.put(FormCRFollowUPTable.COLUMN_CR_FATHER_NAME, formCRFollowUP.getCr_father_name());
            values.put(FormCRFollowUPTable.COLUMN_CR_AGE_MONTHS, formCRFollowUP.getCr_age_months());
            values.put(FormCRFollowUPTable.COLUMN_CR_AGE_YEARS, formCRFollowUP.getCr_age_years());
            values.put(FormCRFollowUPTable.COLUMN_CR_AGE_DAYS, formCRFollowUP.getCr_age_days());
            values.put(FormCRFollowUPTable.COLUMN_CR_GENDER, formCRFollowUP.getCr_gender());
            values.put(FormCRFollowUPTable.COLUMN_CR_ADDRESS, formCRFollowUP.getCr_address());
            values.put(FormCRFollowUPTable.COLUMN_CR_PHONE, formCRFollowUP.getCr_phone());
            values.put(FormCRFollowUPTable.COLUMN_CR_PHONE_NA, formCRFollowUP.getCr_phone_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_BCG, formCRFollowUP.getCr_bcg());
            values.put(FormCRFollowUPTable.COLUMN_CR_BCG_D1, formCRFollowUP.getCr_bcg_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_BCG_D2, formCRFollowUP.getCr_bcg_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_BCG_NA, formCRFollowUP.getCr_bcg_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_HEP_B, formCRFollowUP.getCr_hep_b());
            values.put(FormCRFollowUPTable.COLUMN_CR_HEP_B1, formCRFollowUP.getCr_hep_b1());
            values.put(FormCRFollowUPTable.COLUMN_CR_HEP_B2, formCRFollowUP.getCr_hep_b2());
            values.put(FormCRFollowUPTable.COLUMN_CR_HEP_BNA, formCRFollowUP.getCr_hep_bna());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV0, formCRFollowUP.getCr_opv0());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV0_D1, formCRFollowUP.getCr_opv0_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV0_D2, formCRFollowUP.getCr_opv0_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV0_NA, formCRFollowUP.getCr_opv0_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV1, formCRFollowUP.getCr_opv1());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV1_D1, formCRFollowUP.getCr_opv1_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV1_D2, formCRFollowUP.getCr_opv1_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV1_NA, formCRFollowUP.getCr_opv1_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV2, formCRFollowUP.getCr_opv2());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV2_D1, formCRFollowUP.getCr_opv2_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV2_D2, formCRFollowUP.getCr_opv2_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV2_NA, formCRFollowUP.getCr_opv2_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV3, formCRFollowUP.getCr_opv3());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV3_D1, formCRFollowUP.getCr_opv3_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV3_D2, formCRFollowUP.getCr_opv3_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_OPV3_NA, formCRFollowUP.getCr_opv3_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_ROTA1, formCRFollowUP.getCr_rota1());
            values.put(FormCRFollowUPTable.COLUMN_CR_ROTA1_D1, formCRFollowUP.getCr_rota1_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_ROTA1_D2, formCRFollowUP.getCr_rota1_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_ROTA1_NA, formCRFollowUP.getCr_rota1_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_ROTA2, formCRFollowUP.getCr_rota2());
            values.put(FormCRFollowUPTable.COLUMN_CR_ROTA2_D1, formCRFollowUP.getCr_rota2_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_ROTA2_D2, formCRFollowUP.getCr_rota2_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_ROTA2_NA, formCRFollowUP.getCr_rota2_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_IPV, formCRFollowUP.getCr_ipv());
            values.put(FormCRFollowUPTable.COLUMN_CR_IPV_D1, formCRFollowUP.getCr_ipv_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_IPV_D2, formCRFollowUP.getCr_ipv_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_IPV_NA, formCRFollowUP.getCr_ipv_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV1, formCRFollowUP.getCr_pcv1());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV1_D1, formCRFollowUP.getCr_pcv1_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV1_D2, formCRFollowUP.getCr_pcv1_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV1_NA, formCRFollowUP.getCr_pcv1_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV2, formCRFollowUP.getCr_pcv2());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV2_D1, formCRFollowUP.getCr_pcv2_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV2_D2, formCRFollowUP.getCr_pcv2_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV2_NA, formCRFollowUP.getCr_pcv2_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV3, formCRFollowUP.getCr_pcv3());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV3_D1, formCRFollowUP.getCr_pcv3_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV3_D2, formCRFollowUP.getCr_pcv3_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_PCV3_NA, formCRFollowUP.getCr_pcv3_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA1, formCRFollowUP.getCr_penta1());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA1_D1, formCRFollowUP.getCr_penta1_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA1_D2, formCRFollowUP.getCr_penta1_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA1_NA, formCRFollowUP.getCr_penta1_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA2, formCRFollowUP.getCr_penta2());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA2_D1, formCRFollowUP.getCr_penta2_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA2_D2, formCRFollowUP.getCr_penta2_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA2_NA, formCRFollowUP.getCr_penta2_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA3, formCRFollowUP.getCr_penta3());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA3_D1, formCRFollowUP.getCr_penta3_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA3_D2, formCRFollowUP.getCr_penta3_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_PENTA3_NA, formCRFollowUP.getCr_penta3_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_MEASLES1, formCRFollowUP.getCr_measles1());
            values.put(FormCRFollowUPTable.COLUMN_CR_MEASLES1_D1, formCRFollowUP.getCr_measles1_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_MEASLES1_D2, formCRFollowUP.getCr_measles1_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_MEASLES1_NA, formCRFollowUP.getCr_measles1_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_MEASLES2, formCRFollowUP.getCr_measles2());
            values.put(FormCRFollowUPTable.COLUMN_CR_MEASLES2_D1, formCRFollowUP.getCr_measles2_d1());
            values.put(FormCRFollowUPTable.COLUMN_CR_MEASLES2_D2, formCRFollowUP.getCr_measles2_d2());
            values.put(FormCRFollowUPTable.COLUMN_CR_MEASLES2_NA, formCRFollowUP.getCr_measles2_na());
            values.put(FormCRFollowUPTable.COLUMN_CR_BIRTH_STATUS, formCRFollowUP.getCr_birth_status());
            values.put(FormCRFollowUPTable.COLUMN_CR_COMMENTS, formCRFollowUP.getCr_comments());

            long rowID = db.insert(FormCRFollowUPTable.TABLE_NAME, null, values);
            if (rowID != -1) insertCount++;
        }
        return insertCount;
    }


    //get UnSyncedTables
    public JSONArray getUnsyncedFormCR() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormCRTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FormCRTable.COLUMN_ID + " ASC";

        JSONArray allCR = new JSONArray();
        c = db.query(
                FormCRTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*Form fc = new Form();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedFormCR: " + c.getCount());
            FormCR cr = new FormCR();
            allCR.put(cr.Hydrate(c).toJSONObject());
        }
        Log.d(TAG, "getUnsyncedFormCR: " + allCR.toString().length());
        Log.d(TAG, "getUnsyncedFormCR: " + allCR);
        return allCR;
    }

    public JSONArray getUnsyncedFormWR() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;

        String whereClause;
        whereClause = FormWRTable.COLUMN_SYNCED + " is null ";

        String[] whereArgs = null;

        String groupBy = null;
        String having = null;

        String orderBy = FormWRTable.COLUMN_ID + " ASC";

        JSONArray allWR = new JSONArray();
        c = db.query(
                FormWRTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            /** WorkManager Upload
             /*Form fc = new Form();
             allFC.add(fc.Hydrate(c));*/
            Log.d(TAG, "getUnsyncedFormWR: " + c.getCount());
            FormWR wr = new FormWR();
            allWR.put(wr.Hydrate(c).toJSONObject());
        }
        Log.d(TAG, "getUnsyncedFormWR: " + allWR.toString().length());
        Log.d(TAG, "getUnsyncedFormWR: " + allWR);
        return allWR;
    }


    public JSONArray getUnsyncedEntryLog() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause;
        whereClause = EntryLogTable.COLUMN_SYNCED + " = '' ";

        String[] whereArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = EntryLogTable.COLUMN_ID + " ASC";

        JSONArray all = new JSONArray();
        c = db.query(
                EntryLogTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            Log.d(TAG, "getUnsyncedEntryLog: " + c.getCount());
            EntryLog entryLog = new EntryLog();
            all.put(entryLog.Hydrate(c).toJSONObject());
        }
        Log.d(TAG, "getUnsyncedEntryLog: " + all.toString().length());
        Log.d(TAG, "getUnsyncedEntryLog: " + all);
        return all;
    }

    //update SyncedTables
    public void updateSyncedFormCRV2(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormCRTable.COLUMN_SYNCED, true);
        values.put(FormCRTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormCRTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormCRTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedFormWR(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormWRTable.COLUMN_SYNCED, true);
        values.put(FormWRTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormWRTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormWRTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }

    public void updateSyncedEntryLog(String id) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(EntryLogTable.COLUMN_SYNCED, true);
        values.put(EntryLogTable.COLUMN_SYNC_DATE, new Date().toString());

        String where = EntryLogTable.COLUMN_ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                EntryLogTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase(DATABASE_PASSWORD);
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {
            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }


    public int updatePassword(String hashedPassword) {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);

        ContentValues values = new ContentValues();
        values.put(UsersTable.COLUMN_PASSWORD, hashedPassword);
        values.put(UsersTable.COLUMN_ISNEW_USER, "");

        String selection = UsersTable.COLUMN_USERNAME + " =? ";
        String[] selectionArgs = {MainApp.user.getUserName()};

        return db.update(UsersTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
    }

    /*Get all forms in list from FormCRFollowUP*/
    public List<FormCRFollowUP> getAllChilds() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = FormCRFollowUPTable.COLUMN_ID + " ASC";
        List<FormCRFollowUP> allForm = new ArrayList<>();

        c = db.query(
                FormCRFollowUPTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            FormCRFollowUP formCRFollowUP = new FormCRFollowUP().hydrate(c);
            allForm.add(formCRFollowUP);
        }
        c.close();
        return allForm;
    }

    /*Open form from list OnClick*/
    public FormCRFollowUP getSelectedMembers(String uid, String cardNo, String dmuReg, String pageNo) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;
        String whereClause = FormCRFollowUPTable.COLUMN_UID + " = ? AND " + FormCRFollowUPTable.COLUMN_CR_CARD_NUMBER + " = ? AND " +
                FormCRFollowUPTable.COLUMN_CR_DMU_REGISTER + " = ? AND " + FormCRFollowUPTable.COLUMN_CR_PAGE_NUMBER + " = ? ";
        String[] whereArgs = new String[]{uid, cardNo, dmuReg, pageNo};
        String groupBy = null;
        String having = null;
        String orderBy = FormCRFollowUPTable.COLUMN_ID + " ASC";
        FormCRFollowUP formCRFollowUP = new FormCRFollowUP();
        c = db.query(
                FormCRFollowUPTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) formCRFollowUP = new FormCRFollowUP().hydrate(c);
        c.close();
        return formCRFollowUP;
    }

    /*Search Child from list by Name*/
    public List<FormCRFollowUP> getAllChildsByName(String childName) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause = FormCRFollowUPTable.COLUMN_CR_CHILD_NAME + " = ? ";
        String[] whereArgs = new String[]{childName};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormCRFollowUPTable.COLUMN_ID + " ASC";

        List<FormCRFollowUP> allForm = new ArrayList<>();

        c = db.query(
                FormCRFollowUPTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            FormCRFollowUP formCRFollowUP = new FormCRFollowUP().hydrate(c);
            allForm.add(formCRFollowUP);
        }
        c.close();
        return allForm;
    }

    /*Search Child from list by Card No*/
    public List<FormCRFollowUP> getAllChildsByCardNo(String cardNo) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;

        String whereClause = FormCRFollowUPTable.COLUMN_CR_CARD_NUMBER + " = ? ";
        String[] whereArgs = new String[]{cardNo};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormCRFollowUPTable.COLUMN_ID + " ASC";

        List<FormCRFollowUP> allForm = new ArrayList<>();

        c = db.query(
                FormCRFollowUPTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            FormCRFollowUP cr = new FormCRFollowUP().hydrate(c);
            allForm.add(cr);
        }
        c.close();
        return allForm;
    }

    /*Update entered member from FormCRFollowUP Table*/
    public List<FormCR> getRegisteredMembers(String uid, String cardNo, String dmuReg, String pageNo) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormCRFollowUPTable.COLUMN_UID + " = ? AND " + FormCRFollowUPTable.COLUMN_CR_CARD_NUMBER + " = ? AND " +
                FormCRFollowUPTable.COLUMN_CR_DMU_REGISTER + " = ? AND " + FormCRFollowUPTable.COLUMN_CR_PAGE_NUMBER + " = ? ";
        String[] whereArgs = {uid, cardNo, dmuReg, pageNo};
        String groupBy = null;
        String having = null;
        String orderBy = FormCRFollowUPTable.COLUMN_ID + " ASC";

        List<FormCR> formCRFollowUPS = new ArrayList<>();
        c = db.query(
                FormCRFollowUPTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            formCRFollowUPS.add(new FormCR().HydrateFup(c));
        }

        if (c != null && !c.isClosed()) {
            c.close();
        }
        c.close();
        return formCRFollowUPS;
    }

    /*Update entered member from FormCR Table*/
    public FormCR getRegisteredMembersFormCR(String uuid) throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c = null;
        String[] columns = null;
        String whereClause = FormCRTable.COLUMN_UUID + " = ? ";
        String[] whereArgs = {uuid};
        String groupBy = null;
        String having = null;
        String orderBy = FormCRTable.COLUMN_ID + " ASC";

        FormCR formCRFollowUPS = null;
        c = db.query(
                FormCRTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            formCRFollowUPS = new FormCR().Hydrate(c);
        }

        if (c != null && !c.isClosed()) {
            c.close();
        }
        c.close();
        return formCRFollowUPS;
    }

    /*Get all formCR*/
    public List<FormCR> getAllFormCR() throws JSONException {
        SQLiteDatabase db = this.getReadableDatabase(DATABASE_PASSWORD);
        Cursor c;
        String[] columns = null;
        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy = FormCRTable.COLUMN_ID + " ASC";
        List<FormCR> allForm = new ArrayList<>();

        c = db.query(
                FormCRTable.TABLE_NAME,  // The table to query
                columns,                   // The columns to return
                whereClause,               // The columns for the WHERE clause
                whereArgs,                 // The values for the WHERE clause
                groupBy,                   // don't group the rows
                having,                    // don't filter by row groups
                orderBy                    // The sort order
        );
        while (c.moveToNext()) {
            allForm.add(new FormCR().Hydrate(c));
        }
        c.close();
        return allForm;
    }

}