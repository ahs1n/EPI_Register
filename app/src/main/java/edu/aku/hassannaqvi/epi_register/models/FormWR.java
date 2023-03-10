package edu.aku.hassannaqvi.epi_register.models;

import static edu.aku.hassannaqvi.epi_register.core.MainApp.PROJECT_NAME;
import static edu.aku.hassannaqvi.epi_register.core.MainApp._EMPTY_;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.PropertyChangeRegistry;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import edu.aku.hassannaqvi.epi_register.BR;
import edu.aku.hassannaqvi.epi_register.contracts.TableContracts.FormWRTable;
import edu.aku.hassannaqvi.epi_register.core.MainApp;

public class FormWR extends BaseObservable {

    private final String TAG = "FormWR";
    private final transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();
    // APP VARIABLES
    private String projectName = PROJECT_NAME;
    // APP VARIABLES
    private String id = _EMPTY_;
    private String uid = _EMPTY_;
    private String userName = _EMPTY_;
    private String sysDate = _EMPTY_;
    private String deviceId = _EMPTY_;
    private String deviceTag = _EMPTY_;
    private String appver = _EMPTY_;
    private String startTime = _EMPTY_;
    private String endTime = _EMPTY_;
    private String iStatus = _EMPTY_;
    private String iStatus96x = _EMPTY_;
    private String synced = _EMPTY_;
    private String syncDate = _EMPTY_;

    // FIELD VARIABLES
    // Section WR
    private String wr_dmu_register = _EMPTY_;
    private String wr_reg_number = _EMPTY_;
    private String wr_page_number = _EMPTY_;
    private String wr_rsno = _EMPTY_;
    private String wr_card_number = _EMPTY_;
    private String wr_women_name = _EMPTY_;
    private String wr_husband_name = _EMPTY_;
    private String wr_age_years = _EMPTY_;
    private String wr_address = _EMPTY_;
    private String wr_address_previous = _EMPTY_;
    private String wr_phone = _EMPTY_;
    private String wr_phone_na = _EMPTY_;
    private String wr_ttd1 = _EMPTY_;
    private String wr_ttd1ds = _EMPTY_;
    private String wr_ttd1ds1 = _EMPTY_;
    private String wr_ttd1ds2 = _EMPTY_;
    private String wr_ttd1na = _EMPTY_;
    private String wr_ttd2 = _EMPTY_;
    private String wr_ttd2ds = _EMPTY_;
    private String wr_ttd2ds1 = _EMPTY_;
    private String wr_ttd2ds2 = _EMPTY_;
    private String wr_ttd2na = _EMPTY_;
    private String wr_ttd3 = _EMPTY_;
    private String wr_ttd3ds = _EMPTY_;
    private String wr_ttd3ds1 = _EMPTY_;
    private String wr_ttd3ds2 = _EMPTY_;
    private String wr_ttd3na = _EMPTY_;
    private String wr_ttd4 = _EMPTY_;
    private String wr_ttd4ds = _EMPTY_;
    private String wr_ttd4ds1 = _EMPTY_;
    private String wr_ttd4ds2 = _EMPTY_;
    private String wr_ttd4na = _EMPTY_;
    private String wr_ttd5 = _EMPTY_;
    private String wr_ttd5ds = _EMPTY_;
    private String wr_ttd5ds1 = _EMPTY_;
    private String wr_ttd5ds2 = _EMPTY_;
    private String wr_ttd5na = _EMPTY_;
    private String wr_comments = _EMPTY_;
    private String wR = _EMPTY_;


    public void populateMeta() {
        setSysDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
        setUserName(MainApp.user.getUserName());
        setDeviceId(MainApp.deviceid);
        setDeviceTag(MainApp.appInfo.getTagName());
        setAppver(MainApp.appInfo.getAppVersion());
        setProjectName(PROJECT_NAME);
        setEndTime(new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(new Date().getTime()));
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSysDate() {
        return sysDate;
    }

    public void setSysDate(String sysDate) {
        this.sysDate = sysDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceTag() {
        return deviceTag;
    }

    public void setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
    }

    public String getAppver() {
        return appver;
    }

    public void setAppver(String appver) {
        this.appver = appver;
    }

    public String getiStatus() {
        return iStatus;
    }

    public void setiStatus(String iStatus) {
        this.iStatus = iStatus;
    }

    public String getiStatus96x() {
        return iStatus96x;
    }

    public void setiStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(String syncDate) {
        this.syncDate = syncDate;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getwR() {
        return wR;
    }

    public void setwR(String wR) {
        this.wR = wR;
    }


    @Bindable
    public String getWr_dmu_register() {
        return wr_dmu_register;
    }

    public void setWr_dmu_register(String wr_dmu_register) {
        this.wr_dmu_register = wr_dmu_register;
        notifyPropertyChanged(BR.wr_dmu_register);
    }

    @Bindable
    public String getWr_reg_number() {
        return wr_reg_number;
    }

    public void setWr_reg_number(String wr_reg_number) {
        this.wr_reg_number = wr_reg_number;
        notifyPropertyChanged(BR.wr_reg_number);
    }

    @Bindable
    public String getWr_page_number() {
        return wr_page_number;
    }

    public void setWr_page_number(String wr_page_number) {
        this.wr_page_number = wr_page_number;
        notifyPropertyChanged(BR.wr_page_number);
    }

    @Bindable
    public String getWr_rsno() {
        return wr_rsno;
    }

    public void setWr_rsno(String wr_rsno) {
        this.wr_rsno = wr_rsno;
        notifyPropertyChanged(BR.wr_rsno);
    }

    @Bindable
    public String getWr_card_number() {
        return wr_card_number;
    }

    public void setWr_card_number(String wr_card_number) {
        this.wr_card_number = wr_card_number;
        notifyPropertyChanged(BR.wr_card_number);
    }

    @Bindable
    public String getWr_women_name() {
        return wr_women_name;
    }

    public void setWr_women_name(String wr_women_name) {
        this.wr_women_name = wr_women_name;
        notifyPropertyChanged(BR.wr_women_name);
    }

    @Bindable
    public String getWr_husband_name() {
        return wr_husband_name;
    }

    public void setWr_husband_name(String wr_husband_name) {
        this.wr_husband_name = wr_husband_name;
        notifyPropertyChanged(BR.wr_husband_name);
    }

    @Bindable
    public String getWr_age_years() {
        return wr_age_years;
    }

    public void setWr_age_years(String wr_age_years) {
        this.wr_age_years = wr_age_years;
        notifyPropertyChanged(BR.wr_age_years);
    }

    @Bindable
    public String getWr_address() {
        return wr_address;
    }

    public void setWr_address(String wr_address) {
        this.wr_address = wr_address;
        notifyPropertyChanged(BR.wr_address);
    }

    @Bindable
    public String getWr_address_previous() {
        return wr_address_previous;
    }

    public void setWr_address_previous(String wr_address_previous) {
        this.wr_address_previous = wr_address_previous;
        notifyPropertyChanged(BR.wr_address_previous);
    }

    @Bindable
    public String getWr_phone() {
        return wr_phone;
    }

    public void setWr_phone(String wr_phone) {
        this.wr_phone = wr_phone;
        notifyPropertyChanged(BR.wr_phone);
    }

    @Bindable
    public String getWr_phone_na() {
        return wr_phone_na;
    }

    public void setWr_phone_na(String wr_phone_na) {
        if (this.wr_phone_na.equals(wr_phone_na)) return; // for all checkboxes
        this.wr_phone_na = wr_phone_na;
        notifyPropertyChanged(BR.wr_phone_na);
    }

    @Bindable
    public String getWr_ttd1() {
        return wr_ttd1;
    }

    public void setWr_ttd1(String wr_ttd1) {
        this.wr_ttd1 = wr_ttd1;
        notifyPropertyChanged(BR.wr_ttd1);
    }

    @Bindable
    public String getWr_ttd1ds() {
        return wr_ttd1ds;
    }

    public void setWr_ttd1ds(String wr_ttd1ds) {
        this.wr_ttd1ds = wr_ttd1ds;
        notifyPropertyChanged(BR.wr_ttd1ds);
    }

    @Bindable
    public String getWr_ttd1ds1() {
        return wr_ttd1ds1;
    }

    public void setWr_ttd1ds1(String wr_ttd1ds1) {
        if (this.wr_ttd1ds1.equals(wr_ttd1ds1)) return; // for all checkboxes
        this.wr_ttd1ds1 = wr_ttd1ds1;
        notifyPropertyChanged(BR.wr_ttd1ds1);
    }

    @Bindable
    public String getWr_ttd1ds2() {
        return wr_ttd1ds2;
    }

    public void setWr_ttd1ds2(String wr_ttd1ds2) {
        if (this.wr_ttd1ds2.equals(wr_ttd1ds2)) return; // for all checkboxes
        this.wr_ttd1ds2 = wr_ttd1ds2;
        notifyPropertyChanged(BR.wr_ttd1ds2);
    }

    @Bindable
    public String getWr_ttd2() {
        return wr_ttd2;
    }

    public void setWr_ttd2(String wr_ttd2) {
        this.wr_ttd2 = wr_ttd2;
        notifyPropertyChanged(BR.wr_ttd2);
    }

    @Bindable
    public String getWr_ttd2ds() {
        return wr_ttd2ds;
    }

    public void setWr_ttd2ds(String wr_ttd2ds) {
        this.wr_ttd2ds = wr_ttd2ds;
        notifyPropertyChanged(BR.wr_ttd2ds);
    }

    @Bindable
    public String getWr_ttd2ds1() {
        return wr_ttd2ds1;
    }

    public void setWr_ttd2ds1(String wr_ttd2ds1) {
        if (this.wr_ttd2ds1.equals(wr_ttd2ds1)) return; // for all checkboxes
        this.wr_ttd2ds1 = wr_ttd2ds1;
        notifyPropertyChanged(BR.wr_ttd2ds1);
    }

    @Bindable
    public String getWr_ttd2ds2() {
        return wr_ttd2ds2;
    }

    public void setWr_ttd2ds2(String wr_ttd2ds2) {
        if (this.wr_ttd2ds2.equals(wr_ttd2ds2)) return; // for all checkboxes
        this.wr_ttd2ds2 = wr_ttd2ds2;
        notifyPropertyChanged(BR.wr_ttd2ds2);
    }

    @Bindable
    public String getWr_ttd3() {
        return wr_ttd3;
    }

    public void setWr_ttd3(String wr_ttd3) {
        this.wr_ttd3 = wr_ttd3;
        notifyPropertyChanged(BR.wr_ttd3);
    }

    @Bindable
    public String getWr_ttd3ds() {
        return wr_ttd3ds;
    }

    public void setWr_ttd3ds(String wr_ttd3ds) {
        this.wr_ttd3ds = wr_ttd3ds;
        notifyPropertyChanged(BR.wr_ttd3ds);
    }

    @Bindable
    public String getWr_ttd3ds1() {
        return wr_ttd3ds1;
    }

    public void setWr_ttd3ds1(String wr_ttd3ds1) {
        if (this.wr_ttd3ds1.equals(wr_ttd3ds1)) return; // for all checkboxes
        this.wr_ttd3ds1 = wr_ttd3ds1;
        notifyPropertyChanged(BR.wr_ttd3ds1);
    }

    @Bindable
    public String getWr_ttd3ds2() {
        return wr_ttd3ds2;
    }

    public void setWr_ttd3ds2(String wr_ttd3ds2) {
        if (this.wr_ttd3ds2.equals(wr_ttd3ds2)) return; // for all checkboxes
        this.wr_ttd3ds2 = wr_ttd3ds2;
        notifyPropertyChanged(BR.wr_ttd3ds2);
    }

    @Bindable
    public String getWr_ttd4() {
        return wr_ttd4;
    }

    public void setWr_ttd4(String wr_ttd4) {
        this.wr_ttd4 = wr_ttd4;
        notifyPropertyChanged(BR.wr_ttd4);
    }

    @Bindable
    public String getWr_ttd4ds() {
        return wr_ttd4ds;
    }

    public void setWr_ttd4ds(String wr_ttd4ds) {
        this.wr_ttd4ds = wr_ttd4ds;
        notifyPropertyChanged(BR.wr_ttd4ds);
    }

    @Bindable
    public String getWr_ttd4ds1() {
        return wr_ttd4ds1;
    }

    public void setWr_ttd4ds1(String wr_ttd4ds1) {
        if (this.wr_ttd4ds1.equals(wr_ttd4ds1)) return; // for all checkboxes
        this.wr_ttd4ds1 = wr_ttd4ds1;
        notifyPropertyChanged(BR.wr_ttd4ds1);
    }

    @Bindable
    public String getWr_ttd4ds2() {
        return wr_ttd4ds2;
    }

    public void setWr_ttd4ds2(String wr_ttd4ds2) {
        if (this.wr_ttd4ds2.equals(wr_ttd4ds2)) return; // for all checkboxes
        this.wr_ttd4ds2 = wr_ttd4ds2;
        notifyPropertyChanged(BR.wr_ttd4ds2);
    }

    @Bindable
    public String getWr_ttd5() {
        return wr_ttd5;
    }

    public void setWr_ttd5(String wr_ttd5) {
        this.wr_ttd5 = wr_ttd5;
        notifyPropertyChanged(BR.wr_ttd5);
    }

    @Bindable
    public String getWr_ttd5ds() {
        return wr_ttd5ds;
    }

    public void setWr_ttd5ds(String wr_ttd5ds) {
        this.wr_ttd5ds = wr_ttd5ds;
        notifyPropertyChanged(BR.wr_ttd5ds);
    }

    @Bindable
    public String getWr_ttd5ds1() {
        return wr_ttd5ds1;
    }

    public void setWr_ttd5ds1(String wr_ttd5ds1) {
        if (this.wr_ttd5ds1.equals(wr_ttd5ds1)) return; // for all checkboxes
        this.wr_ttd5ds1 = wr_ttd5ds1;
        notifyPropertyChanged(BR.wr_ttd5ds1);
    }

    @Bindable
    public String getWr_ttd5ds2() {
        return wr_ttd5ds2;
    }

    public void setWr_ttd5ds2(String wr_ttd5ds2) {
        if (this.wr_ttd5ds2.equals(wr_ttd5ds2)) return; // for all checkboxes
        this.wr_ttd5ds2 = wr_ttd5ds2;
        notifyPropertyChanged(BR.wr_ttd5ds2);
    }

    @Bindable
    public String getWr_comments() {
        return wr_comments;
    }

    public void setWr_comments(String wr_comments) {
        this.wr_comments = wr_comments;
        notifyPropertyChanged(BR.wr_comments);
    }

    @Bindable
    public String getWr_ttd1na() {
        return wr_ttd1na;
    }

    public void setWr_ttd1na(String wr_ttd1na) {
        if (this.wr_ttd1na.equals(wr_ttd1na)) return; // for all checkboxes
        this.wr_ttd1na = wr_ttd1na;
        notifyPropertyChanged(BR.wr_ttd1na);
    }

    @Bindable
    public String getWr_ttd2na() {
        return wr_ttd2na;
    }

    public void setWr_ttd2na(String wr_ttd2na) {
        if (this.wr_ttd2na.equals(wr_ttd2na)) return; // for all checkboxes
        this.wr_ttd2na = wr_ttd2na;
        notifyPropertyChanged(BR.wr_ttd2na);
    }

    @Bindable
    public String getWr_ttd3na() {
        return wr_ttd3na;
    }

    public void setWr_ttd3na(String wr_ttd3na) {
        if (this.wr_ttd3na.equals(wr_ttd3na)) return; // for all checkboxes
        this.wr_ttd3na = wr_ttd3na;
        notifyPropertyChanged(BR.wr_ttd3na);
    }

    @Bindable
    public String getWr_ttd4na() {
        return wr_ttd4na;
    }

    public void setWr_ttd4na(String wr_ttd4na) {
        if (this.wr_ttd4na.equals(wr_ttd4na)) return; // for all checkboxes
        this.wr_ttd4na = wr_ttd4na;
        notifyPropertyChanged(BR.wr_ttd4na);
    }

    @Bindable
    public String getWr_ttd5na() {
        return wr_ttd5na;
    }

    public void setWr_ttd5na(String wr_ttd5na) {
        if (this.wr_ttd5na.equals(wr_ttd5na)) return; // for all checkboxes
        this.wr_ttd5na = wr_ttd5na;
        notifyPropertyChanged(BR.wr_ttd5na);
    }

    public FormWR Hydrate(Cursor cursor) throws JSONException {
        this.id = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_SYSDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_APPVERSION));
        this.iStatus = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_ISTATUS));
        this.synced = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_SYNCED_DATE));
        this.endTime = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_END_TIME));
        this.startTime = cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_START_TIME));
        wRHydrate(cursor.getString(cursor.getColumnIndexOrThrow(FormWRTable.COLUMN_WR)));

        return this;
    }


    public void wRHydrate(String string) throws JSONException {
        Log.d(TAG, "wRHydrate: " + string);
        if (string != null) {
            JSONObject json = null;
            json = new JSONObject(string);
            this.wr_dmu_register = json.getString("wr_dmu_register");
            this.wr_reg_number = json.getString("wr_reg_number");
            this.wr_page_number = json.getString("wr_page_number");
            this.wr_rsno = json.getString("wr_rsno");
            this.wr_card_number = json.getString("wr_card_number");
            this.wr_women_name = json.getString("wr_women_name");
            this.wr_husband_name = json.getString("wr_husband_name");
            this.wr_age_years = json.getString("wr_age_years");
            this.wr_address = json.getString("wr_address");
            this.wr_phone = json.getString("wr_phone");
            this.wr_phone_na = json.getString("wr_phone_na");
            this.wr_ttd1 = json.getString("wr_ttd1");
            this.wr_ttd1ds1 = json.getString("wr_ttd1ds1");
            this.wr_ttd1ds2 = json.getString("wr_ttd1ds2");
            this.wr_ttd1na = json.getString("wr_ttd1na");
            this.wr_ttd2 = json.getString("wr_ttd2");
            this.wr_ttd2ds1 = json.getString("wr_ttd2ds1");
            this.wr_ttd2ds2 = json.getString("wr_ttd2ds2");
            this.wr_ttd2na = json.getString("wr_ttd2na");
            this.wr_ttd3 = json.getString("wr_ttd3");
            this.wr_ttd3ds1 = json.getString("wr_ttd3ds1");
            this.wr_ttd3ds2 = json.getString("wr_ttd3ds2");
            this.wr_ttd3na = json.getString("wr_ttd3na");
            this.wr_ttd4 = json.getString("wr_ttd4");
            this.wr_ttd4ds1 = json.getString("wr_ttd4ds1");
            this.wr_ttd4ds2 = json.getString("wr_ttd4ds2");
            this.wr_ttd4na = json.getString("wr_ttd4na");
            this.wr_ttd5 = json.getString("wr_ttd5");
            this.wr_ttd5ds1 = json.getString("wr_ttd5ds1");
            this.wr_ttd5ds2 = json.getString("wr_ttd5ds2");
            this.wr_ttd5na = json.getString("wr_ttd5na");
            this.wr_comments = json.getString("wr_comments");

        }
    }


    public String wRtoString() throws JSONException {
        Log.d(TAG, "wRtoString: ");
        JSONObject json = new JSONObject();
        json.put("wr_dmu_register", wr_dmu_register)
                .put("wr_reg_number", wr_reg_number)
                .put("wr_page_number", wr_page_number)
                .put("wr_rsno", wr_rsno)
                .put("wr_card_number", wr_card_number)
                .put("wr_women_name", wr_women_name)
                .put("wr_husband_name", wr_husband_name)
                .put("wr_age_years", wr_age_years)
                .put("wr_address", wr_address)
                .put("wr_phone", wr_phone)
                .put("wr_phone_na", wr_phone_na)
                .put("wr_ttd1", wr_ttd1)
                .put("wr_ttd1ds1", wr_ttd1ds1)
                .put("wr_ttd1ds2", wr_ttd1ds2)
                .put("wr_ttd1na", wr_ttd1na)
                .put("wr_ttd2", wr_ttd2)
                .put("wr_ttd2ds1", wr_ttd2ds1)
                .put("wr_ttd2ds2", wr_ttd2ds2)
                .put("wr_ttd2na", wr_ttd2na)
                .put("wr_ttd3", wr_ttd3)
                .put("wr_ttd3ds1", wr_ttd3ds1)
                .put("wr_ttd3ds2", wr_ttd3ds2)
                .put("wr_ttd3na", wr_ttd3na)
                .put("wr_ttd4", wr_ttd4)
                .put("wr_ttd4ds1", wr_ttd4ds1)
                .put("wr_ttd4ds2", wr_ttd4ds2)
                .put("wr_ttd4na", wr_ttd4na)
                .put("wr_ttd5", wr_ttd5)
                .put("wr_ttd5ds1", wr_ttd5ds1)
                .put("wr_ttd5ds2", wr_ttd5ds2)
                .put("wr_ttd5na", wr_ttd5na)
                .put("wr_comments", wr_comments);

        return json.toString();
    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormWRTable.COLUMN_ID, this.id);
        json.put(FormWRTable.COLUMN_UID, this.uid);
        json.put(FormWRTable.COLUMN_USERNAME, this.userName);
        json.put(FormWRTable.COLUMN_SYSDATE, this.sysDate);
        json.put(FormWRTable.COLUMN_DEVICEID, this.deviceId);
        json.put(FormWRTable.COLUMN_DEVICETAGID, this.deviceTag);
        json.put(FormWRTable.COLUMN_ISTATUS, this.iStatus);
        json.put(FormWRTable.COLUMN_SYNCED, this.synced);
        json.put(FormWRTable.COLUMN_SYNCED_DATE, this.syncDate);
        json.put(FormWRTable.COLUMN_START_TIME, this.startTime);
        json.put(FormWRTable.COLUMN_END_TIME, this.endTime);
        json.put(FormWRTable.COLUMN_WR, new JSONObject(wRtoString()));

        return json;

    }
}
