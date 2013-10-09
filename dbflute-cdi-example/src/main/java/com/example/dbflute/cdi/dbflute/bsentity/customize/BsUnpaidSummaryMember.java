/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.bsentity.customize;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.Entity;
import com.example.dbflute.cdi.dbflute.exentity.customize.*;
import com.example.dbflute.cdi.dbflute.exentity.*;

/**
 * The entity of UnpaidSummaryMember. <br />
 * <pre>
 * [primary-key]
 *     UNPAID_MAN_ID
 * 
 * [column]
 *     UNPAID_MAN_ID, UNPAID_MAN_NAME, UNPAID_PRICE_SUMMARY, STATUS_NAME
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
 * Integer unpaidManId = entity.getUnpaidManId();
 * String unpaidManName = entity.getUnpaidManName();
 * Long unpaidPriceSummary = entity.getUnpaidPriceSummary();
 * String statusName = entity.getStatusName();
 * entity.setUnpaidManId(unpaidManId);
 * entity.setUnpaidManName(unpaidManName);
 * entity.setUnpaidPriceSummary(unpaidPriceSummary);
 * entity.setStatusName(statusName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsUnpaidSummaryMember implements Entity, Serializable, Cloneable {

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
    /** (会員ID)UNPAID_MAN_ID: {PK, INTEGER(10), refers to MEMBER.MEMBER_ID} */
    protected Integer _unpaidManId;

    /** (会員名称)UNPAID_MAN_NAME: {VARCHAR(200), refers to MEMBER.MEMBER_NAME} */
    protected String _unpaidManName;

    /** UNPAID_PRICE_SUMMARY: {BIGINT(10)} */
    protected Long _unpaidPriceSummary;

    /** (会員ステータス名称)STATUS_NAME: {VARCHAR(50), refers to MEMBER_STATUS.MEMBER_STATUS_NAME} */
    protected String _statusName;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this entity. (NotNull) */
    protected final EntityModifiedProperties __modifiedProperties = newModifiedProperties();

    /** Is the entity created by DBFlute select process? */
    protected boolean __createdBySelect;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "UnpaidSummaryMember";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "unpaidSummaryMember";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return com.example.dbflute.cdi.dbflute.bsentity.customize.dbmeta.UnpaidSummaryMemberDbm.getInstance();
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        if (getUnpaidManId() == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected Member __innerDomain;

    protected Member innerDomain() {
        if (__innerDomain == null) {
            __innerDomain = new Member();
        }
        return __innerDomain;
    }

    /**
     * Prepare the inner instance of domain entity (basically for LoadReferrer).
     * <pre>
     * List&lt;UnpaidSummaryMember&gt; memberList = memberBhv.outsideSql()...;
     * List&lt;Member&gt; domainList = new ArrayList&lt;Member&gt;();
     * for (UnpaidSummaryMember member : memberList) {
     *     domainList.add(member.<span style="color: #FD4747">prepareDomain()</span>);
     * }
     * memberBhv.<span style="color: #FD4747">loadPurchaseList</span>(domainList, new ConditionBeanSetupper...);
     * for (UnpaidSummaryMember member : memberList) {
     *     Purchase purchase = member.<span style="color: #FD4747">getPurchaseList()</span>; <span style="color: #3F7E5E">// you can get it</span>
     *     ...
     * }
     * </pre>
     * @return The domain entity for this customize entity. (NotNull)
     */
    public Member prepareDomain() {
        innerDomain().setMemberId(getUnpaidManId());
        return innerDomain();
    }

    /**
     * (会員住所情報)MEMBER_ADDRESS by MEMBER_ID, named 'memberAddressList'.
     * @return The entity list of referrer property 'memberAddressList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<MemberAddress> getMemberAddressList() {
        return innerDomain().getMemberAddressList();
    }

    /**
     * (会員ログイン)MEMBER_LOGIN by MEMBER_ID, named 'memberLoginList'.
     * @return The entity list of referrer property 'memberLoginList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<MemberLogin> getMemberLoginList() {
        return innerDomain().getMemberLoginList();
    }

    /**
     * (購入)PURCHASE by MEMBER_ID, named 'purchaseList'.
     * @return The entity list of referrer property 'purchaseList'. (NotNull: If it's not loaded yet, initializes the list instance of referrer as empty and returns it.)
     */
    public List<Purchase> getPurchaseList() {
        return innerDomain().getPurchaseList();
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    /**
     * {@inheritDoc}
     */
    public Set<String> modifiedProperties() {
        return __modifiedProperties.getPropertyNames();
    }

    /**
     * {@inheritDoc}
     */
    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    protected EntityModifiedProperties newModifiedProperties() {
        return new EntityModifiedProperties();
    }

    // ===================================================================================
    //                                                                     Birthplace Mark
    //                                                                     ===============
    /**
     * {@inheritDoc}
     */
    public void markAsSelect() {
        __createdBySelect = true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean createdBySelect() {
        return __createdBySelect;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * Determine the object is equal with this. <br />
     * If primary-keys or columns of the other are same as this one, returns true.
     * @param other The other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsUnpaidSummaryMember)) { return false; }
        BsUnpaidSummaryMember otherEntity = (BsUnpaidSummaryMember)other;
        if (!xSV(getUnpaidManId(), otherEntity.getUnpaidManId())) { return false; }
        return true;
    }
    protected boolean xSV(Object value1, Object value2) { // isSameValue()
        return InternalUtil.isSameValue(value1, value2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    public int hashCode() {
        int result = 17;
        result = xCH(result, getTableDbName());
        result = xCH(result, getUnpaidManId());
        return result;
    }
    protected int xCH(int result, Object value) { // calculateHashcode()
        return InternalUtil.calculateHashcode(result, value);
    }

    /**
     * {@inheritDoc}
     */
    public int instanceHash() {
        return super.hashCode();
    }

    /**
     * Convert to display string of entity's data. (no relation data)
     * @return The display string of all columns and relation existences. (NotNull)
     */
    public String toString() {
        return buildDisplayString(InternalUtil.toClassTitle(this), true, true);
    }

    /**
     * {@inheritDoc}
     */
    public String toStringWithRelation() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public String buildDisplayString(String name, boolean column, boolean relation) {
        StringBuilder sb = new StringBuilder();
        if (name != null) { sb.append(name).append(column || relation ? ":" : ""); }
        if (column) { sb.append(buildColumnString()); }
        if (relation) { sb.append(buildRelationString()); }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }
    protected String buildColumnString() {
        StringBuilder sb = new StringBuilder();
        String delimiter = ", ";
        sb.append(delimiter).append(getUnpaidManId());
        sb.append(delimiter).append(getUnpaidManName());
        sb.append(delimiter).append(getUnpaidPriceSummary());
        sb.append(delimiter).append(getStatusName());
        if (sb.length() > delimiter.length()) {
            sb.delete(0, delimiter.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        return "";
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public UnpaidSummaryMember clone() {
        try {
            return (UnpaidSummaryMember)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ID)UNPAID_MAN_ID: {PK, INTEGER(10), refers to MEMBER.MEMBER_ID} <br />
     * 会員を識別するID。連番として自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMS次第。
     * @return The value of the column 'UNPAID_MAN_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getUnpaidManId() {
        return _unpaidManId;
    }

    /**
     * [set] (会員ID)UNPAID_MAN_ID: {PK, INTEGER(10), refers to MEMBER.MEMBER_ID} <br />
     * 会員を識別するID。連番として自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMS次第。
     * @param unpaidManId The value of the column 'UNPAID_MAN_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setUnpaidManId(Integer unpaidManId) {
        __modifiedProperties.addPropertyName("unpaidManId");
        this._unpaidManId = unpaidManId;
    }

    /**
     * [get] (会員名称)UNPAID_MAN_NAME: {VARCHAR(200), refers to MEMBER.MEMBER_NAME} <br />
     * 会員のフルネームの名称。<br />
     * 苗字と名前を分けて管理することも多いが、ここでは Example なので単純にひとまとめ。
     * @return The value of the column 'UNPAID_MAN_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getUnpaidManName() {
        return _unpaidManName;
    }

    /**
     * [set] (会員名称)UNPAID_MAN_NAME: {VARCHAR(200), refers to MEMBER.MEMBER_NAME} <br />
     * 会員のフルネームの名称。<br />
     * 苗字と名前を分けて管理することも多いが、ここでは Example なので単純にひとまとめ。
     * @param unpaidManName The value of the column 'UNPAID_MAN_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setUnpaidManName(String unpaidManName) {
        __modifiedProperties.addPropertyName("unpaidManName");
        this._unpaidManName = unpaidManName;
    }

    /**
     * [get] UNPAID_PRICE_SUMMARY: {BIGINT(10)} <br />
     * @return The value of the column 'UNPAID_PRICE_SUMMARY'. (NullAllowed even if selected: for no constraint)
     */
    public Long getUnpaidPriceSummary() {
        return _unpaidPriceSummary;
    }

    /**
     * [set] UNPAID_PRICE_SUMMARY: {BIGINT(10)} <br />
     * @param unpaidPriceSummary The value of the column 'UNPAID_PRICE_SUMMARY'. (NullAllowed: null update allowed for no constraint)
     */
    public void setUnpaidPriceSummary(Long unpaidPriceSummary) {
        __modifiedProperties.addPropertyName("unpaidPriceSummary");
        this._unpaidPriceSummary = unpaidPriceSummary;
    }

    /**
     * [get] (会員ステータス名称)STATUS_NAME: {VARCHAR(50), refers to MEMBER_STATUS.MEMBER_STATUS_NAME} <br />
     * @return The value of the column 'STATUS_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getStatusName() {
        return _statusName;
    }

    /**
     * [set] (会員ステータス名称)STATUS_NAME: {VARCHAR(50), refers to MEMBER_STATUS.MEMBER_STATUS_NAME} <br />
     * @param statusName The value of the column 'STATUS_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setStatusName(String statusName) {
        __modifiedProperties.addPropertyName("statusName");
        this._statusName = statusName;
    }
}
