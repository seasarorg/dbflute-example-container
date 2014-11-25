/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.bsentity.customize;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import org.seasar.dbflute.dbmeta.accessory.CustomizeEntity;
import com.example.dbflute.cdi.dbflute.allcommon.CDef;
import com.example.dbflute.cdi.dbflute.exentity.customize.*;

/**
 * The entity of OptionMember. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, BIRTHDATE, FORMALIZED_DATETIME, MEMBER_STATUS_CODE, MEMBER_STATUS_NAME, STATUS_DISPLAY_ORDER, DUMMY_FLG, DUMMY_NOFLG
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer memberId = entity.getMemberId();
 * String memberName = entity.getMemberName();
 * java.util.Date birthdate = entity.getBirthdate();
 * java.sql.Timestamp formalizedDatetime = entity.getFormalizedDatetime();
 * String memberStatusCode = entity.getMemberStatusCode();
 * String memberStatusName = entity.getMemberStatusName();
 * Integer statusDisplayOrder = entity.getStatusDisplayOrder();
 * Integer dummyFlg = entity.getDummyFlg();
 * Integer dummyNoflg = entity.getDummyNoflg();
 * entity.setMemberId(memberId);
 * entity.setMemberName(memberName);
 * entity.setBirthdate(birthdate);
 * entity.setFormalizedDatetime(formalizedDatetime);
 * entity.setMemberStatusCode(memberStatusCode);
 * entity.setMemberStatusName(memberStatusName);
 * entity.setStatusDisplayOrder(statusDisplayOrder);
 * entity.setDummyFlg(dummyFlg);
 * entity.setDummyNoflg(dummyNoflg);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsOptionMember extends AbstractEntity implements CustomizeEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** (会員ID)MEMBER_ID: {INTEGER(10), refers to MEMBER.MEMBER_ID} */
    protected Integer _memberId;

    /** (会員名称)MEMBER_NAME: {VARCHAR(200), refers to MEMBER.MEMBER_NAME} */
    protected String _memberName;

    /** (生年月日)BIRTHDATE: {DATE(8), refers to MEMBER.BIRTHDATE} */
    protected java.util.Date _birthdate;

    /** (正式会員日時)FORMALIZED_DATETIME: {TIMESTAMP(23, 10), refers to MEMBER.FORMALIZED_DATETIME} */
    protected java.sql.Timestamp _formalizedDatetime;

    /** (会員ステータスコード)MEMBER_STATUS_CODE: {CHAR(3), refers to MEMBER.MEMBER_STATUS_CODE, classification=MemberStatus} */
    protected String _memberStatusCode;

    /** (会員ステータス名称)MEMBER_STATUS_NAME: {VARCHAR(50), refers to MEMBER_STATUS.MEMBER_STATUS_NAME} */
    protected String _memberStatusName;

    /** (表示順)STATUS_DISPLAY_ORDER: {INTEGER(10), refers to MEMBER_STATUS.DISPLAY_ORDER} */
    protected Integer _statusDisplayOrder;

    /** DUMMY_FLG: {INTEGER(10), classification=Flg} */
    protected Integer _dummyFlg;

    /** DUMMY_NOFLG: {INTEGER(10)} */
    protected Integer _dummyNoflg;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "OptionMember";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "optionMember";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return com.example.dbflute.cdi.dbflute.bsentity.customize.dbmeta.OptionMemberDbm.getInstance();
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        return false;
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of memberStatusCode as the classification of MemberStatus. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {CHAR(3), refers to MEMBER.MEMBER_STATUS_CODE, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.MemberStatus getMemberStatusCodeAsMemberStatus() {
        return CDef.MemberStatus.codeOf(getMemberStatusCode());
    }

    /**
     * Set the value of memberStatusCode as the classification of MemberStatus. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {CHAR(3), refers to MEMBER.MEMBER_STATUS_CODE, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setMemberStatusCodeAsMemberStatus(CDef.MemberStatus cdef) {
        setMemberStatusCode(cdef != null ? cdef.code() : null);
    }

    /**
     * Get the value of dummyFlg as the classification of Flg. <br />
     * DUMMY_FLG: {INTEGER(10), classification=Flg} <br />
     * フラグを示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Flg getDummyFlgAsFlg() {
        return CDef.Flg.codeOf(getDummyFlg());
    }

    /**
     * Set the value of dummyFlg as the classification of Flg. <br />
     * DUMMY_FLG: {INTEGER(10), classification=Flg} <br />
     * フラグを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setDummyFlgAsFlg(CDef.Flg cdef) {
        setDummyFlg(cdef != null ? toNumber(cdef.code(), Integer.class) : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of memberStatusCode as 正式会員 (FML). <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     */
    public void setMemberStatusCode_正式会員() {
        setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.正式会員);
    }

    /**
     * Set the value of memberStatusCode as 退会会員 (WDL). <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     */
    public void setMemberStatusCode_退会会員() {
        setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.退会会員);
    }

    /**
     * Set the value of memberStatusCode as 仮会員 (PRV). <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     */
    public void setMemberStatusCode_仮会員() {
        setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.仮会員);
    }

    /**
     * Set the value of dummyFlg as True (1). <br />
     * はい: 有効を示す
     */
    public void setDummyFlg_True() {
        setDummyFlgAsFlg(CDef.Flg.True);
    }

    /**
     * Set the value of dummyFlg as False (0). <br />
     * いいえ: 無効を示す
     */
    public void setDummyFlg_False() {
        setDummyFlgAsFlg(CDef.Flg.False);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of memberStatusCode 正式会員? <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCode正式会員() {
        CDef.MemberStatus cdef = getMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.正式会員) : false;
    }

    /**
     * Is the value of memberStatusCode 退会会員? <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCode退会会員() {
        CDef.MemberStatus cdef = getMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.退会会員) : false;
    }

    /**
     * Is the value of memberStatusCode 仮会員? <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCode仮会員() {
        CDef.MemberStatus cdef = getMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.仮会員) : false;
    }

    /**
     * Is the value of dummyFlg True? <br />
     * はい: 有効を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isDummyFlgTrue() {
        CDef.Flg cdef = getDummyFlgAsFlg();
        return cdef != null ? cdef.equals(CDef.Flg.True) : false;
    }

    /**
     * Is the value of dummyFlg False? <br />
     * いいえ: 無効を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isDummyFlgFalse() {
        CDef.Flg cdef = getDummyFlgAsFlg();
        return cdef != null ? cdef.equals(CDef.Flg.False) : false;
    }

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
    /**
     * Get the value of the column 'dummyFlg' as classification name.
     * @return The string of classification name. (NullAllowed: when the column value is null)
     */
    public String getDummyFlgName() {
        CDef.Flg cdef = getDummyFlgAsFlg();
        return cdef != null ? cdef.name() : null;
    }

    /**
     * Get the value of the column 'dummyFlg' as classification alias.
     * @return The string of classification alias. (NullAllowed: when the column value is null)
     */
    public String getDummyFlgAlias() {
        CDef.Flg cdef = getDummyFlgAsFlg();
        return cdef != null ? cdef.alias() : null;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsOptionMember) {
            BsOptionMember other = (BsOptionMember)obj;
            if (!xSV(_memberId, other._memberId)) { return false; }
            if (!xSV(_memberName, other._memberName)) { return false; }
            if (!xSV(_birthdate, other._birthdate)) { return false; }
            if (!xSV(_formalizedDatetime, other._formalizedDatetime)) { return false; }
            if (!xSV(_memberStatusCode, other._memberStatusCode)) { return false; }
            if (!xSV(_memberStatusName, other._memberStatusName)) { return false; }
            if (!xSV(_statusDisplayOrder, other._statusDisplayOrder)) { return false; }
            if (!xSV(_dummyFlg, other._dummyFlg)) { return false; }
            if (!xSV(_dummyNoflg, other._dummyNoflg)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, _memberId);
        hs = xCH(hs, _memberName);
        hs = xCH(hs, _birthdate);
        hs = xCH(hs, _formalizedDatetime);
        hs = xCH(hs, _memberStatusCode);
        hs = xCH(hs, _memberStatusName);
        hs = xCH(hs, _statusDisplayOrder);
        hs = xCH(hs, _dummyFlg);
        hs = xCH(hs, _dummyNoflg);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_memberId));
        sb.append(dm).append(xfND(_memberName));
        sb.append(dm).append(xfUD(_birthdate));
        sb.append(dm).append(xfND(_formalizedDatetime));
        sb.append(dm).append(xfND(_memberStatusCode));
        sb.append(dm).append(xfND(_memberStatusName));
        sb.append(dm).append(xfND(_statusDisplayOrder));
        sb.append(dm).append(xfND(_dummyFlg));
        sb.append(dm).append(xfND(_dummyNoflg));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        return "";
    }

    @Override
    public OptionMember clone() {
        return (OptionMember)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ID)MEMBER_ID: {INTEGER(10), refers to MEMBER.MEMBER_ID} <br />
     * 会員を識別するID。連番として自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMS次第。
     * @return The value of the column 'MEMBER_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getMemberId() {
        checkSpecifiedProperty("memberId");
        return _memberId;
    }

    /**
     * [set] (会員ID)MEMBER_ID: {INTEGER(10), refers to MEMBER.MEMBER_ID} <br />
     * 会員を識別するID。連番として自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMS次第。
     * @param memberId The value of the column 'MEMBER_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberId(Integer memberId) {
        registerModifiedProperty("memberId");
        _memberId = memberId;
    }

    /**
     * [get] (会員名称)MEMBER_NAME: {VARCHAR(200), refers to MEMBER.MEMBER_NAME} <br />
     * 会員のフルネームの名称。<br />
     * 苗字と名前を分けて管理することも多いが、ここでは Example なので単純にひとまとめ。
     * @return The value of the column 'MEMBER_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getMemberName() {
        checkSpecifiedProperty("memberName");
        return _memberName;
    }

    /**
     * [set] (会員名称)MEMBER_NAME: {VARCHAR(200), refers to MEMBER.MEMBER_NAME} <br />
     * 会員のフルネームの名称。<br />
     * 苗字と名前を分けて管理することも多いが、ここでは Example なので単純にひとまとめ。
     * @param memberName The value of the column 'MEMBER_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberName(String memberName) {
        registerModifiedProperty("memberName");
        _memberName = memberName;
    }

    /**
     * [get] (生年月日)BIRTHDATE: {DATE(8), refers to MEMBER.BIRTHDATE} <br />
     * 必須項目ではないので、このデータがない会員もいる。
     * @return The value of the column 'BIRTHDATE'. (NullAllowed even if selected: for no constraint)
     */
    public java.util.Date getBirthdate() {
        checkSpecifiedProperty("birthdate");
        return _birthdate;
    }

    /**
     * [set] (生年月日)BIRTHDATE: {DATE(8), refers to MEMBER.BIRTHDATE} <br />
     * 必須項目ではないので、このデータがない会員もいる。
     * @param birthdate The value of the column 'BIRTHDATE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setBirthdate(java.util.Date birthdate) {
        registerModifiedProperty("birthdate");
        _birthdate = birthdate;
    }

    /**
     * [get] (正式会員日時)FORMALIZED_DATETIME: {TIMESTAMP(23, 10), refers to MEMBER.FORMALIZED_DATETIME} <br />
     * 会員が正式に確定した日時。<br />
     * 一度確定したら更新されない。
     * @return The value of the column 'FORMALIZED_DATETIME'. (NullAllowed even if selected: for no constraint)
     */
    public java.sql.Timestamp getFormalizedDatetime() {
        checkSpecifiedProperty("formalizedDatetime");
        return _formalizedDatetime;
    }

    /**
     * [set] (正式会員日時)FORMALIZED_DATETIME: {TIMESTAMP(23, 10), refers to MEMBER.FORMALIZED_DATETIME} <br />
     * 会員が正式に確定した日時。<br />
     * 一度確定したら更新されない。
     * @param formalizedDatetime The value of the column 'FORMALIZED_DATETIME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setFormalizedDatetime(java.sql.Timestamp formalizedDatetime) {
        registerModifiedProperty("formalizedDatetime");
        _formalizedDatetime = formalizedDatetime;
    }

    /**
     * [get] (会員ステータスコード)MEMBER_STATUS_CODE: {CHAR(3), refers to MEMBER.MEMBER_STATUS_CODE, classification=MemberStatus} <br />
     * 会員ステータスを参照するコード。<br />
     * ステータスが変わるたびに、このカラムが更新される。
     * @return The value of the column 'MEMBER_STATUS_CODE'. (NullAllowed even if selected: for no constraint)
     */
    public String getMemberStatusCode() {
        checkSpecifiedProperty("memberStatusCode");
        return _memberStatusCode;
    }

    /**
     * [set] (会員ステータスコード)MEMBER_STATUS_CODE: {CHAR(3), refers to MEMBER.MEMBER_STATUS_CODE, classification=MemberStatus} <br />
     * 会員ステータスを参照するコード。<br />
     * ステータスが変わるたびに、このカラムが更新される。
     * @param memberStatusCode The value of the column 'MEMBER_STATUS_CODE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberStatusCode(String memberStatusCode) {
        registerModifiedProperty("memberStatusCode");
        _memberStatusCode = memberStatusCode;
    }

    /**
     * [get] (会員ステータス名称)MEMBER_STATUS_NAME: {VARCHAR(50), refers to MEMBER_STATUS.MEMBER_STATUS_NAME} <br />
     * @return The value of the column 'MEMBER_STATUS_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getMemberStatusName() {
        checkSpecifiedProperty("memberStatusName");
        return _memberStatusName;
    }

    /**
     * [set] (会員ステータス名称)MEMBER_STATUS_NAME: {VARCHAR(50), refers to MEMBER_STATUS.MEMBER_STATUS_NAME} <br />
     * @param memberStatusName The value of the column 'MEMBER_STATUS_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberStatusName(String memberStatusName) {
        registerModifiedProperty("memberStatusName");
        _memberStatusName = memberStatusName;
    }

    /**
     * [get] (表示順)STATUS_DISPLAY_ORDER: {INTEGER(10), refers to MEMBER_STATUS.DISPLAY_ORDER} <br />
     * UI上のステータスの表示順を示すNO。<br />
     * 並べるときは、このカラムに対して昇順のソート条件にする。
     * @return The value of the column 'STATUS_DISPLAY_ORDER'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getStatusDisplayOrder() {
        checkSpecifiedProperty("statusDisplayOrder");
        return _statusDisplayOrder;
    }

    /**
     * [set] (表示順)STATUS_DISPLAY_ORDER: {INTEGER(10), refers to MEMBER_STATUS.DISPLAY_ORDER} <br />
     * UI上のステータスの表示順を示すNO。<br />
     * 並べるときは、このカラムに対して昇順のソート条件にする。
     * @param statusDisplayOrder The value of the column 'STATUS_DISPLAY_ORDER'. (NullAllowed: null update allowed for no constraint)
     */
    public void setStatusDisplayOrder(Integer statusDisplayOrder) {
        registerModifiedProperty("statusDisplayOrder");
        _statusDisplayOrder = statusDisplayOrder;
    }

    /**
     * [get] DUMMY_FLG: {INTEGER(10), classification=Flg} <br />
     * @return The value of the column 'DUMMY_FLG'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getDummyFlg() {
        checkSpecifiedProperty("dummyFlg");
        return _dummyFlg;
    }

    /**
     * [set] DUMMY_FLG: {INTEGER(10), classification=Flg} <br />
     * @param dummyFlg The value of the column 'DUMMY_FLG'. (NullAllowed: null update allowed for no constraint)
     */
    public void setDummyFlg(Integer dummyFlg) {
        registerModifiedProperty("dummyFlg");
        _dummyFlg = dummyFlg;
    }

    /**
     * [get] DUMMY_NOFLG: {INTEGER(10)} <br />
     * @return The value of the column 'DUMMY_NOFLG'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getDummyNoflg() {
        checkSpecifiedProperty("dummyNoflg");
        return _dummyNoflg;
    }

    /**
     * [set] DUMMY_NOFLG: {INTEGER(10)} <br />
     * @param dummyNoflg The value of the column 'DUMMY_NOFLG'. (NullAllowed: null update allowed for no constraint)
     */
    public void setDummyNoflg(Integer dummyNoflg) {
        registerModifiedProperty("dummyNoflg");
        _dummyNoflg = dummyNoflg;
    }
}
