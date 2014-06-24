/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;
import com.example.dbflute.cdi.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.cdi.dbflute.allcommon.CDef;
import com.example.dbflute.cdi.dbflute.exentity.*;

/**
 * The entity of (地域)REGION as TABLE. <br />
 * 主に会員の住所に対応する地域。<br />
 * かなりざっくりした感じではある。<br />
 * 業務的one-to-oneの親テーブル。
 * <pre>
 * [primary-key]
 *     REGION_ID
 * 
 * [column]
 *     REGION_ID, REGION_NAME
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
 *     MEMBER_ADDRESS
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     memberAddressList
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer regionId = entity.getRegionId();
 * String regionName = entity.getRegionName();
 * entity.setRegionId(regionId);
 * entity.setRegionName(regionName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsRegion implements Entity, Serializable, Cloneable {

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
    /** (地域ID)REGION_ID: {PK, NotNull, INTEGER(10), classification=Region} */
    protected Integer _regionId;

    /** (地域名称)REGION_NAME: {NotNull, VARCHAR(50)} */
    protected String _regionName;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The unique-driven properties for this entity. (NotNull) */
    protected final EntityUniqueDrivenProperties __uniqueDrivenProperties = newUniqueDrivenProperties();

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
        return "REGION";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "region";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        if (getRegionId() == null) { return false; }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public Set<String> myuniqueDrivenProperties() {
        return __uniqueDrivenProperties.getPropertyNames();
    }

    protected EntityUniqueDrivenProperties newUniqueDrivenProperties() {
        return new EntityUniqueDrivenProperties();
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of regionId as the classification of Region. <br />
     * (地域ID)REGION_ID: {PK, NotNull, INTEGER(10), classification=Region} <br />
     * 主に会員の住んでいる地域を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Region getRegionIdAsRegion() {
        return CDef.Region.codeOf(getRegionId());
    }

    /**
     * Set the value of regionId as the classification of Region. <br />
     * (地域ID)REGION_ID: {PK, NotNull, INTEGER(10), classification=Region} <br />
     * 主に会員の住んでいる地域を示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setRegionIdAsRegion(CDef.Region cdef) {
        setRegionId(cdef != null ? FunCustodial.toNumber(cdef.code(), Integer.class) : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of regionId as アメリカ (1). <br />
     * アメリカ
     */
    public void setRegionId_アメリカ() {
        setRegionIdAsRegion(CDef.Region.アメリカ);
    }

    /**
     * Set the value of regionId as カナダ (2). <br />
     * カナダ
     */
    public void setRegionId_カナダ() {
        setRegionIdAsRegion(CDef.Region.カナダ);
    }

    /**
     * Set the value of regionId as 中国 (3). <br />
     * 中国
     */
    public void setRegionId_中国() {
        setRegionIdAsRegion(CDef.Region.中国);
    }

    /**
     * Set the value of regionId as 千葉 (4). <br />
     * 千葉
     */
    public void setRegionId_千葉() {
        setRegionIdAsRegion(CDef.Region.千葉);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of regionId アメリカ? <br />
     * アメリカ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRegionIdアメリカ() {
        CDef.Region cdef = getRegionIdAsRegion();
        return cdef != null ? cdef.equals(CDef.Region.アメリカ) : false;
    }

    /**
     * Is the value of regionId カナダ? <br />
     * カナダ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRegionIdカナダ() {
        CDef.Region cdef = getRegionIdAsRegion();
        return cdef != null ? cdef.equals(CDef.Region.カナダ) : false;
    }

    /**
     * Is the value of regionId 中国? <br />
     * 中国
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRegionId中国() {
        CDef.Region cdef = getRegionIdAsRegion();
        return cdef != null ? cdef.equals(CDef.Region.中国) : false;
    }

    /**
     * Is the value of regionId 千葉? <br />
     * 千葉
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isRegionId千葉() {
        CDef.Region cdef = getRegionIdAsRegion();
        return cdef != null ? cdef.equals(CDef.Region.千葉) : false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** (会員住所情報)MEMBER_ADDRESS by REGION_ID, named 'memberAddressList'. */
    protected List<MemberAddress> _memberAddressList;

    /**
     * [get] (会員住所情報)MEMBER_ADDRESS by REGION_ID, named 'memberAddressList'.
     * @return The entity list of referrer property 'memberAddressList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MemberAddress> getMemberAddressList() {
        if (_memberAddressList == null) { _memberAddressList = newReferrerList(); }
        return _memberAddressList;
    }

    /**
     * [set] (会員住所情報)MEMBER_ADDRESS by REGION_ID, named 'memberAddressList'.
     * @param memberAddressList The entity list of referrer property 'memberAddressList'. (NullAllowed)
     */
    public void setMemberAddressList(List<MemberAddress> memberAddressList) {
        _memberAddressList = memberAddressList;
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
     * @param obj The object as other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BsRegion)) { return false; }
        BsRegion other = (BsRegion)obj;
        if (!xSV(getRegionId(), other.getRegionId())) { return false; }
        return true;
    }
    protected boolean xSV(Object v1, Object v2) {
        return FunCustodial.isSameValue(v1, v2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    public int hashCode() {
        int hs = 17;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, getRegionId());
        return hs;
    }
    protected int xCH(int hs, Object vl) {
        return FunCustodial.calculateHashcode(hs, vl);
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
        return buildDisplayString(FunCustodial.toClassTitle(this), true, true);
    }

    /**
     * {@inheritDoc}
     */
    public String toStringWithRelation() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        String li = "\n  ";
        if (_memberAddressList != null) { for (Entity et : _memberAddressList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "memberAddressList")); } } }
        return sb.toString();
    }
    protected String xbRDS(Entity et, String name) { // buildRelationDisplayString()
        return et.buildDisplayString(name, true, true);
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
        String dm = ", ";
        sb.append(dm).append(getRegionId());
        sb.append(dm).append(getRegionName());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_memberAddressList != null && !_memberAddressList.isEmpty())
        { sb.append(cm).append("memberAddressList"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public Region clone() {
        try {
            return (Region)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (地域ID)REGION_ID: {PK, NotNull, INTEGER(10), classification=Region} <br />
     * 地域を識別するID。<br />
     * 珍しく(固定的な)マスタテーブルとしては数値だが、<br />
     * Exampleなのでやはり色々なパターンがないと。
     * @return The value of the column 'REGION_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getRegionId() {
        return _regionId;
    }

    /**
     * [set] (地域ID)REGION_ID: {PK, NotNull, INTEGER(10), classification=Region} <br />
     * 地域を識別するID。<br />
     * 珍しく(固定的な)マスタテーブルとしては数値だが、<br />
     * Exampleなのでやはり色々なパターンがないと。
     * @param regionId The value of the column 'REGION_ID'. (basically NotNull if update: for the constraint)
     */
    public void setRegionId(Integer regionId) {
        __modifiedProperties.addPropertyName("regionId");
        _regionId = regionId;
    }

    /**
     * [get] (地域名称)REGION_NAME: {NotNull, VARCHAR(50)} <br />
     * 地域を表す名称。
     * @return The value of the column 'REGION_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getRegionName() {
        return _regionName;
    }

    /**
     * [set] (地域名称)REGION_NAME: {NotNull, VARCHAR(50)} <br />
     * 地域を表す名称。
     * @param regionName The value of the column 'REGION_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setRegionName(String regionName) {
        __modifiedProperties.addPropertyName("regionName");
        _regionName = regionName;
    }
}
