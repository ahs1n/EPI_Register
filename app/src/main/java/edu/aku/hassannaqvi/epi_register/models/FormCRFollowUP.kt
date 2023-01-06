package edu.aku.hassannaqvi.epi_register.models

import android.database.Cursor
import edu.aku.hassannaqvi.epi_register.contracts.TableContracts.FormCRFollowUPTable
import org.apache.commons.lang3.StringUtils
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by muhammad.hussain on 03/01/2023.
 */
class FormCRFollowUP {
    var ID: Long = 0
    var uID: String = StringUtils.EMPTY
    var userName: String = StringUtils.EMPTY
    var sysDate: String = StringUtils.EMPTY
    var deviceId: String = StringUtils.EMPTY
    var iStatus: String = StringUtils.EMPTY
    var endTime: String = StringUtils.EMPTY
    var startTime: String = StringUtils.EMPTY
    var cr_dmu_register: String = StringUtils.EMPTY
    var cr_reg_number: String = StringUtils.EMPTY
    var cr_page_number: String = StringUtils.EMPTY
    var cr_rsno: String = StringUtils.EMPTY
    var cr_card_number: String = StringUtils.EMPTY
    var cr_child_name: String = StringUtils.EMPTY
    var cr_father_name: String = StringUtils.EMPTY
    var cr_age_months: String = StringUtils.EMPTY
    var cr_age_years: String = StringUtils.EMPTY
    var cr_age_days: String = StringUtils.EMPTY
    var cr_gender: String = StringUtils.EMPTY
    var cr_address: String = StringUtils.EMPTY
    var cr_phone: String = StringUtils.EMPTY
    var cr_phone_na: String = StringUtils.EMPTY
    var cr_bcg: String = StringUtils.EMPTY
    var cr_bcg_d1: String = StringUtils.EMPTY
    var cr_bcg_d2: String = StringUtils.EMPTY
    var cr_bcg_na: String = StringUtils.EMPTY
    var cr_hep_b: String = StringUtils.EMPTY
    var cr_hep_b1: String = StringUtils.EMPTY
    var cr_hep_b2: String = StringUtils.EMPTY
    var cr_hep_bna: String = StringUtils.EMPTY
    var cr_opv0: String = StringUtils.EMPTY
    var cr_opv0_d1: String = StringUtils.EMPTY
    var cr_opv0_d2: String = StringUtils.EMPTY
    var cr_opv0_na: String = StringUtils.EMPTY
    var cr_opv1: String = StringUtils.EMPTY
    var cr_opv1_d1: String = StringUtils.EMPTY
    var cr_opv1_d2: String = StringUtils.EMPTY
    var cr_opv1_na: String = StringUtils.EMPTY
    var cr_opv2: String = StringUtils.EMPTY
    var cr_opv2_d1: String = StringUtils.EMPTY
    var cr_opv2_d2: String = StringUtils.EMPTY
    var cr_opv2_na: String = StringUtils.EMPTY
    var cr_opv3: String = StringUtils.EMPTY
    var cr_opv3_d1: String = StringUtils.EMPTY
    var cr_opv3_d2: String = StringUtils.EMPTY
    var cr_opv3_na: String = StringUtils.EMPTY
    var cr_rota1: String = StringUtils.EMPTY
    var cr_rota1_d1: String = StringUtils.EMPTY
    var cr_rota1_d2: String = StringUtils.EMPTY
    var cr_rota1_na: String = StringUtils.EMPTY
    var cr_rota2: String = StringUtils.EMPTY
    var cr_rota2_d1: String = StringUtils.EMPTY
    var cr_rota2_d2: String = StringUtils.EMPTY
    var cr_rota2_na: String = StringUtils.EMPTY
    var cr_ipv: String = StringUtils.EMPTY
    var cr_ipv_d1: String = StringUtils.EMPTY
    var cr_ipv_d2: String = StringUtils.EMPTY
    var cr_ipv_na: String = StringUtils.EMPTY
    var cr_pcv1: String = StringUtils.EMPTY
    var cr_pcv1_d1: String = StringUtils.EMPTY
    var cr_pcv1_d2: String = StringUtils.EMPTY
    var cr_pcv1_na: String = StringUtils.EMPTY
    var cr_pcv2: String = StringUtils.EMPTY
    var cr_pcv2_d1: String = StringUtils.EMPTY
    var cr_pcv2_d2: String = StringUtils.EMPTY
    var cr_pcv2_na: String = StringUtils.EMPTY
    var cr_pcv3: String = StringUtils.EMPTY
    var cr_pcv3_d1: String = StringUtils.EMPTY
    var cr_pcv3_d2: String = StringUtils.EMPTY
    var cr_pcv3_na: String = StringUtils.EMPTY
    var cr_penta1: String = StringUtils.EMPTY
    var cr_penta1_d1: String = StringUtils.EMPTY
    var cr_penta1_d2: String = StringUtils.EMPTY
    var cr_penta1_na: String = StringUtils.EMPTY
    var cr_penta2: String = StringUtils.EMPTY
    var cr_penta2_d1: String = StringUtils.EMPTY
    var cr_penta2_d2: String = StringUtils.EMPTY
    var cr_penta2_na: String = StringUtils.EMPTY
    var cr_penta3: String = StringUtils.EMPTY
    var cr_penta3_d1: String = StringUtils.EMPTY
    var cr_penta3_d2: String = StringUtils.EMPTY
    var cr_penta3_na: String = StringUtils.EMPTY
    var cr_measles1: String = StringUtils.EMPTY
    var cr_measles1_d1: String = StringUtils.EMPTY
    var cr_measles1_d2: String = StringUtils.EMPTY
    var cr_measles1_na: String = StringUtils.EMPTY
    var cr_measles2: String = StringUtils.EMPTY
    var cr_measles2_d1: String = StringUtils.EMPTY
    var cr_measles2_d2: String = StringUtils.EMPTY
    var cr_measles2_na: String = StringUtils.EMPTY
    var cr_birth_status: String = StringUtils.EMPTY
    var cr_comments: String = StringUtils.EMPTY

    constructor() {
        // Default Constructor
    }

    @Throws(JSONException::class)
    fun sync(jsonObject: JSONObject): FormCRFollowUP {
        uID = jsonObject.getString(FormCRFollowUPTable.COLUMN_UID)
        userName = jsonObject.getString(FormCRFollowUPTable.COLUMN_USERNAME)
        sysDate = jsonObject.getString(FormCRFollowUPTable.COLUMN_SYSDATE)
        deviceId = jsonObject.getString(FormCRFollowUPTable.COLUMN_DEVICEID)
        iStatus = jsonObject.getString(FormCRFollowUPTable.COLUMN_ISTATUS)
        endTime = jsonObject.getString(FormCRFollowUPTable.COLUMN_END_TIME)
        startTime = jsonObject.getString(FormCRFollowUPTable.COLUMN_START_TIME)
        cr_dmu_register = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_DMU_REGISTER)
        cr_reg_number = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_REG_NUMBER)
        cr_page_number = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PAGE_NUMBER)
        cr_rsno = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_RSNO)
        cr_card_number = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_CARD_NUMBER)
        cr_child_name = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_CHILD_NAME)
        cr_father_name = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_FATHER_NAME)
        cr_age_months = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_AGE_MONTHS)
        cr_age_years = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_AGE_YEARS)
        cr_age_days = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_AGE_DAYS)
        cr_gender = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_GENDER)
        cr_address = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ADDRESS)
        cr_phone = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PHONE)
        cr_phone_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PHONE_NA)
        cr_bcg = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_BCG)
        cr_bcg_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_BCG_D1)
        cr_bcg_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_BCG_D2)
        cr_bcg_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_BCG_NA)
        cr_hep_b = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_HEP_B)
        cr_hep_b1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_HEP_B1)
        cr_hep_b2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_HEP_B2)
        cr_hep_bna = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_HEP_BNA)
        cr_opv0 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV0)
        cr_opv0_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV0_D1)
        cr_opv0_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV0_D2)
        cr_opv0_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV0_NA)
        cr_opv1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV1)
        cr_opv1_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV1_D1)
        cr_opv1_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV1_D2)
        cr_opv1_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV1_NA)
        cr_opv2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV2)
        cr_opv2_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV2_D1)
        cr_opv2_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV2_D2)
        cr_opv2_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV2_NA)
        cr_opv3 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV3)
        cr_opv3_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV3_D1)
        cr_opv3_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV3_D2)
        cr_opv3_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_OPV3_NA)
        cr_rota1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ROTA1)
        cr_rota1_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ROTA1_D1)
        cr_rota1_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ROTA1_D2)
        cr_rota1_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ROTA1_NA)
        cr_rota2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ROTA2)
        cr_rota2_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ROTA2_D1)
        cr_rota2_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ROTA2_D2)
        cr_rota2_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_ROTA2_NA)
        cr_ipv = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_IPV)
        cr_ipv_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_IPV_D1)
        cr_ipv_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_IPV_D2)
        cr_ipv_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_IPV_NA)
        cr_pcv1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV1)
        cr_pcv1_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV1_D1)
        cr_pcv1_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV1_D2)
        cr_pcv1_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV1_NA)
        cr_pcv2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV2)
        cr_pcv2_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV2_D1)
        cr_pcv2_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV2_D2)
        cr_pcv2_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV2_NA)
        cr_pcv3 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV3)
        cr_pcv3_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV3_D1)
        cr_pcv3_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV3_D2)
        cr_pcv3_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PCV3_NA)
        cr_penta1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA1)
        cr_penta1_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA1_D1)
        cr_penta1_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA1_D2)
        cr_penta1_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA1_NA)
        cr_penta2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA2)
        cr_penta2_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA2_D1)
        cr_penta2_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA2_D2)
        cr_penta2_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA2_NA)
        cr_penta3 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA3)
        cr_penta3_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA3_D1)
        cr_penta3_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA3_D2)
        cr_penta3_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_PENTA3_NA)
        cr_measles1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_MEASLES1)
        cr_measles1_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_MEASLES1_D1)
        cr_measles1_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_MEASLES1_D2)
        cr_measles1_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_MEASLES1_NA)
        cr_measles2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_MEASLES2)
        cr_measles2_d1 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_MEASLES2_D1)
        cr_measles2_d2 = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_MEASLES2_D2)
        cr_measles2_na = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_MEASLES2_NA)
        cr_birth_status = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_BIRTH_STATUS)
        cr_comments = jsonObject.getString(FormCRFollowUPTable.COLUMN_CR_COMMENTS)
        return this
    }

    fun hydrate(cursor: Cursor): FormCRFollowUP {
        ID = cursor.getLong(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_ID))
        uID =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_UID))
        userName =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_USERNAME))
        sysDate =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_SYSDATE))
        deviceId =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_DEVICEID))
        iStatus =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_ISTATUS))
        endTime =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_END_TIME))
        startTime =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_START_TIME))
        cr_dmu_register =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_DMU_REGISTER))
        cr_reg_number =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_REG_NUMBER))
        cr_page_number =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PAGE_NUMBER))
        cr_rsno = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_RSNO))
        cr_card_number =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_CARD_NUMBER))
        cr_child_name =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_CHILD_NAME))
        cr_father_name =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_FATHER_NAME))
        cr_age_months =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_AGE_MONTHS))
        cr_age_years =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_AGE_YEARS))
        cr_age_days =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_AGE_DAYS))
        cr_gender =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_GENDER))
        cr_address =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ADDRESS))
        cr_phone =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PHONE))
        cr_phone_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PHONE_NA))
        cr_bcg = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_BCG))
        cr_bcg_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_BCG_D1))
        cr_bcg_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_BCG_D2))
        cr_bcg_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_BCG_NA))
        cr_hep_b =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_HEP_B))
        cr_hep_b1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_HEP_B1))
        cr_hep_b2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_HEP_B2))
        cr_hep_bna =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_HEP_BNA))
        cr_opv0 = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV0))
        cr_opv0_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV0_D1))
        cr_opv0_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV0_D2))
        cr_opv0_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV0_NA))
        cr_opv1 = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV1))
        cr_opv1_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV1_D1))
        cr_opv1_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV1_D2))
        cr_opv1_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV1_NA))
        cr_opv2 = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV2))
        cr_opv2_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV2_D1))
        cr_opv2_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV2_D2))
        cr_opv2_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV2_NA))
        cr_opv3 = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV3))
        cr_opv3_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV3_D1))
        cr_opv3_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV3_D2))
        cr_opv3_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_OPV3_NA))
        cr_rota1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ROTA1))
        cr_rota1_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ROTA1_D1))
        cr_rota1_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ROTA1_D2))
        cr_rota1_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ROTA1_NA))
        cr_rota2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ROTA2))
        cr_rota2_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ROTA2_D1))
        cr_rota2_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ROTA2_D2))
        cr_rota2_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_ROTA2_NA))
        cr_ipv = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_IPV))
        cr_ipv_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_IPV_D1))
        cr_ipv_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_IPV_D2))
        cr_ipv_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_IPV_NA))
        cr_pcv1 = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV1))
        cr_pcv1_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV1_D1))
        cr_pcv1_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV1_D2))
        cr_pcv1_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV1_NA))
        cr_pcv2 = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV2))
        cr_pcv2_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV2_D1))
        cr_pcv2_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV2_D2))
        cr_pcv2_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV2_NA))
        cr_pcv3 = cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV3))
        cr_pcv3_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV3_D1))
        cr_pcv3_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV3_D2))
        cr_pcv3_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PCV3_NA))
        cr_penta1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA1))
        cr_penta1_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA1_D1))
        cr_penta1_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA1_D2))
        cr_penta1_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA1_NA))
        cr_penta2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA2))
        cr_penta2_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA2_D1))
        cr_penta2_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA2_D2))
        cr_penta2_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA2_NA))
        cr_penta3 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA3))
        cr_penta3_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA3_D1))
        cr_penta3_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA3_D2))
        cr_penta3_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_PENTA3_NA))
        cr_measles1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_MEASLES1))
        cr_measles1_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_MEASLES1_D1))
        cr_measles1_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_MEASLES1_D2))
        cr_measles1_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_MEASLES1_NA))
        cr_measles2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_MEASLES2))
        cr_measles2_d1 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_MEASLES2_D1))
        cr_measles2_d2 =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_MEASLES2_D2))
        cr_measles2_na =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_MEASLES2_NA))
        cr_birth_status =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_BIRTH_STATUS))
        cr_comments =
            cursor.getString(cursor.getColumnIndexOrThrow(FormCRFollowUPTable.COLUMN_CR_COMMENTS))
        return this
    }
}