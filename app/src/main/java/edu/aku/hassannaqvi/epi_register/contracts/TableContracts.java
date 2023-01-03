package edu.aku.hassannaqvi.epi_register.contracts;

import android.provider.BaseColumns;

public class TableContracts {

    public static abstract class FormCRTable implements BaseColumns {
        public static final String TABLE_NAME = "FormCR";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_CR = "cR";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_END_TIME = "end_time";
        public static final String COLUMN_START_TIME = "start_time";
    }

    public static abstract class FormCRFollowUPTable implements BaseColumns {
        public static final String TABLE_NAME = "FormCRFollowUP";
        public static final String TABLE_NAME_API = "FormCR";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_CR_DMU_REGISTER = "cr_dmu_register";
        public static final String COLUMN_CR_REG_NUMBER = "cr_reg_number";
        public static final String COLUMN_CR_PAGE_NUMBER = "cr_page_number";
        public static final String COLUMN_CR_RSNO = "cr_rsno";
        public static final String COLUMN_CR_CARD_NUMBER = "cr_card_number";
        public static final String COLUMN_CR_CHILD_NAME = "cr_child_name";
        public static final String COLUMN_CR_FATHER_NAME = "cr_father_name";
        public static final String COLUMN_CR_AGE_MONTHS = "cr_age_months";
        public static final String COLUMN_CR_AGE_YEARS = "cr_age_years";
        public static final String COLUMN_CR_AGE_DAYS = "cr_age_days";
        public static final String COLUMN_CR_GENDER = "cr_gender";
        public static final String COLUMN_CR_ADDRESS = "cr_address";
        public static final String COLUMN_CR_PHONE = "cr_phone";
        public static final String COLUMN_CR_PHONE_NA = "cr_phone_na";
        public static final String COLUMN_CR_BCG = "cr_bcg";
        public static final String COLUMN_CR_BCG_D1 = "cr_bcg_d1";
        public static final String COLUMN_CR_BCG_D2 = "cr_bcg_d2";
        public static final String COLUMN_CR_BCG_NA = "cr_bcg_na";
        public static final String COLUMN_CR_HEP_B = "cr_hep_b";
        public static final String COLUMN_CR_HEP_B1 = "cr_hep_b1";
        public static final String COLUMN_CR_HEP_B2 = "cr_hep_b2";
        public static final String COLUMN_CR_HEP_BNA = "cr_hep_bna";
        public static final String COLUMN_CR_OPV0 = "cr_opv0";
        public static final String COLUMN_CR_OPV0_D1 = "cr_opv0_d1";
        public static final String COLUMN_CR_OPV0_D2 = "cr_opv0_d2";
        public static final String COLUMN_CR_OPV0_NA = "cr_opv0_na";
        public static final String COLUMN_CR_OPV1 = "cr_opv1";
        public static final String COLUMN_CR_OPV1_D1 = "cr_opv1_d1";
        public static final String COLUMN_CR_OPV1_D2 = "cr_opv1_d2";
        public static final String COLUMN_CR_OPV1_NA = "cr_opv1_na";
        public static final String COLUMN_CR_OPV2 = "cr_opv2";
        public static final String COLUMN_CR_OPV2_D1 = "cr_opv2_d1";
        public static final String COLUMN_CR_OPV2_D2 = "cr_opv2_d2";
        public static final String COLUMN_CR_OPV2_NA = "cr_opv2_na";
        public static final String COLUMN_CR_OPV3 = "cr_opv3";
        public static final String COLUMN_CR_OPV3_D1 = "cr_opv3_d1";
        public static final String COLUMN_CR_OPV3_D2 = "cr_opv3_d2";
        public static final String COLUMN_CR_OPV3_NA = "cr_opv3_na";
        public static final String COLUMN_CR_ROTA1 = "cr_rota1";
        public static final String COLUMN_CR_ROTA1_D1 = "cr_rota1_d1";
        public static final String COLUMN_CR_ROTA1_D2 = "cr_rota1_d2";
        public static final String COLUMN_CR_ROTA1_NA = "cr_rota1_na";
        public static final String COLUMN_CR_ROTA2 = "cr_rota2";
        public static final String COLUMN_CR_ROTA2_D1 = "cr_rota2_d1";
        public static final String COLUMN_CR_ROTA2_D2 = "cr_rota2_d2";
        public static final String COLUMN_CR_ROTA2_NA = "cr_rota2_na";
        public static final String COLUMN_CR_IPV = "cr_ipv";
        public static final String COLUMN_CR_IPV_D1 = "cr_ipv_d1";
        public static final String COLUMN_CR_IPV_D2 = "cr_ipv_d2";
        public static final String COLUMN_CR_IPV_NA = "cr_ipv_na";
        public static final String COLUMN_CR_PCV1 = "cr_pcv1";
        public static final String COLUMN_CR_PCV1_D1 = "cr_pcv1_d1";
        public static final String COLUMN_CR_PCV1_D2 = "cr_pcv1_d2";
        public static final String COLUMN_CR_PCV1_NA = "cr_pcv1_na";
        public static final String COLUMN_CR_PCV2 = "cr_pcv2";
        public static final String COLUMN_CR_PCV2_D1 = "cr_pcv2_d1";
        public static final String COLUMN_CR_PCV2_D2 = "cr_pcv2_d2";
        public static final String COLUMN_CR_PCV2_NA = "cr_pcv2_na";
        public static final String COLUMN_CR_PCV3 = "cr_pcv3";
        public static final String COLUMN_CR_PCV3_D1 = "cr_pcv3_d1";
        public static final String COLUMN_CR_PCV3_D2 = "cr_pcv3_d2";
        public static final String COLUMN_CR_PCV3_NA = "cr_pcv3_na";
        public static final String COLUMN_CR_PENTA1 = "cr_penta1";
        public static final String COLUMN_CR_PENTA1_D1 = "cr_penta1_d1";
        public static final String COLUMN_CR_PENTA1_D2 = "cr_penta1_d2";
        public static final String COLUMN_CR_PENTA1_NA = "cr_penta1_na";
        public static final String COLUMN_CR_PENTA2 = "cr_penta2";
        public static final String COLUMN_CR_PENTA2_D1 = "cr_penta2_d1";
        public static final String COLUMN_CR_PENTA2_D2 = "cr_penta2_d2";
        public static final String COLUMN_CR_PENTA2_NA = "cr_penta2_na";
        public static final String COLUMN_CR_PENTA3 = "cr_penta3";
        public static final String COLUMN_CR_PENTA3_D1 = "cr_penta3_d1";
        public static final String COLUMN_CR_PENTA3_D2 = "cr_penta3_d2";
        public static final String COLUMN_CR_PENTA3_NA = "cr_penta3_na";
        public static final String COLUMN_CR_MEASLES1 = "cr_measles1";
        public static final String COLUMN_CR_MEASLES1_D1 = "cr_measles1_d1";
        public static final String COLUMN_CR_MEASLES1_D2 = "cr_measles1_d2";
        public static final String COLUMN_CR_MEASLES1_NA = "cr_measles1_na";
        public static final String COLUMN_CR_MEASLES2 = "cr_measles2";
        public static final String COLUMN_CR_MEASLES2_D1 = "cr_measles2_d1";
        public static final String COLUMN_CR_MEASLES2_D2 = "cr_measles2_d2";
        public static final String COLUMN_CR_MEASLES2_NA = "cr_measles2_na";
        public static final String COLUMN_CR_BIRTH_STATUS = "cr_birth_status";
        public static final String COLUMN_CR_COMMENTS = "cr_comments";
    }

    public static abstract class FormWRTable implements BaseColumns {
        public static final String TABLE_NAME = "FormWR";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_WR = "wR";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_END_TIME = "end_time";
        public static final String COLUMN_START_TIME = "start_time";
    }

    public static abstract class UsersTable implements BaseColumns {
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_PASSWORD = "passwordEnc";
        public static final String COLUMN_FULLNAME = "full_name";
        public static final String COLUMN_ENABLED = "enabled";
        public static final String COLUMN_ISNEW_USER = "isNewUser";
        public static final String COLUMN_PWD_EXPIRY = "pwdExpiry";

    }

    public static abstract class VersionTable implements BaseColumns {
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String TABLE_NAME = "versionApp";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_VERSION_PATH = "elements";
        public static final String COLUMN_VERSION_CODE = "versionCode";
        public static final String COLUMN_VERSION_NAME = "versionName";
        public static final String COLUMN_PATH_NAME = "outputFile";
        public static final String SERVER_URI = "output-metadata.json";

    }

    public static abstract class EntryLogTable implements BaseColumns {
        public static final String TABLE_NAME = "EntryLog";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectName";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_UUID = "_uuid";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_SYSDATE = "sysdate";
        public static final String COLUMN_ENTRY_DATE = "entryDate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNC_DATE = "sync_date";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS96x = "istatus96x";
    }
}
