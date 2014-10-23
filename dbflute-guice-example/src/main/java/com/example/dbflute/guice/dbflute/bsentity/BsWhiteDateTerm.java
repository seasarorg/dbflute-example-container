package com.example.dbflute.guice.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.DerivedMappable;
import com.example.dbflute.guice.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.guice.dbflute.exentity.*;

/**
 * The entity of WHITE_DATE_TERM as TABLE. <br />
 * <pre>
 * [primary-key]
 *     DATE_TERM_ID
 * 
 * [column]
 *     DATE_TERM_ID, DATE_TERM_VALUE, BEGIN_DATE, END_DATE
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
 * Long dateTermId = entity.getDateTermId();
 * String dateTermValue = entity.getDateTermValue();
 * org.joda.time.LocalDate beginDate = entity.getBeginDate();
 * org.joda.time.LocalDate endDate = entity.getEndDate();
 * entity.setDateTermId(dateTermId);
 * entity.setDateTermValue(dateTermValue);
 * entity.setBeginDate(beginDate);
 * entity.setEndDate(endDate);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsWhiteDateTerm implements Entity, Serializable, Cloneable, DerivedMappable {

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
    /** DATE_TERM_ID: {PK, NotNull, DECIMAL(16)} */
    protected Long _dateTermId;

    /** DATE_TERM_VALUE: {NotNull, VARCHAR(200)} */
    protected String _dateTermValue;

    /** BEGIN_DATE: {NotNull, DATE(8)} */
    protected org.joda.time.LocalDate _beginDate;

    /** END_DATE: {NotNull, DATE(8)} */
    protected org.joda.time.LocalDate _endDate;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The unique-driven properties for this entity. (NotNull) */
    protected final EntityUniqueDrivenProperties __uniqueDrivenProperties = newUniqueDrivenProperties();

    /** The modified properties for this entity. (NotNull) */
    protected final EntityModifiedProperties __modifiedProperties = newModifiedProperties();

    /** The map of derived value, key is alias name. (NullAllowed: lazy-loaded) */
    protected EntityDerivedMap __derivedMap;

    /** Is the entity created by DBFlute select process? */
    protected boolean __createdBySelect;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "WHITE_DATE_TERM";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "whiteDateTerm";
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
        if (getDateTermId() == null) { return false; }
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
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
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
    //                                                                    Derived Mappable
    //                                                                    ================
    /**
     * {@inheritDoc}
     */
    public void registerDerivedValue(String aliasName, Object selectedValue) {
        if (__derivedMap == null) { __derivedMap = newDerivedMap(); }
        __derivedMap.registerDerivedValue(aliasName, selectedValue);
    }

    /**
     * Find the derived value from derived map.
     * <pre>
     * mapping type:
     *  count()      : Integer
     *  max(), min() : (same as property type of the column)
     *  sum(), avg() : BigDecimal
     *
     * e.g. use count()
     *  Integer loginCount = member.derived("$LOGIN_COUNT");
     * </pre>
     * @param <VALUE> The type of the value.
     * @param aliasName The alias name of derived-referrer. (NotNull)
     * @return The derived value found in the map. (NullAllowed: when null selected)
     */
    public <VALUE> VALUE derived(String aliasName) {
        if (__derivedMap == null) { __derivedMap = newDerivedMap(); }
        return __derivedMap.findDerivedValue(aliasName);
    }

    protected EntityDerivedMap newDerivedMap() {
        return new EntityDerivedMap();
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
        if (obj == null || !(obj instanceof BsWhiteDateTerm)) { return false; }
        BsWhiteDateTerm other = (BsWhiteDateTerm)obj;
        if (!xSV(getDateTermId(), other.getDateTermId())) { return false; }
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
        hs = xCH(hs, getDateTermId());
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
        String dm = ", ";
        sb.append(dm).append(getDateTermId());
        sb.append(dm).append(getDateTermValue());
        sb.append(dm).append(getBeginDate());
        sb.append(dm).append(getEndDate());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
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
    public WhiteDateTerm clone() {
        try {
            return (WhiteDateTerm)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] DATE_TERM_ID: {PK, NotNull, DECIMAL(16)} <br />
     * @return The value of the column 'DATE_TERM_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getDateTermId() {
        return _dateTermId;
    }

    /**
     * [set] DATE_TERM_ID: {PK, NotNull, DECIMAL(16)} <br />
     * @param dateTermId The value of the column 'DATE_TERM_ID'. (basically NotNull if update: for the constraint)
     */
    public void setDateTermId(Long dateTermId) {
        __modifiedProperties.addPropertyName("dateTermId");
        _dateTermId = dateTermId;
    }

    /**
     * [get] DATE_TERM_VALUE: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'DATE_TERM_VALUE'. (basically NotNull if selected: for the constraint)
     */
    public String getDateTermValue() {
        return convertEmptyToNull(_dateTermValue);
    }

    /**
     * [set] DATE_TERM_VALUE: {NotNull, VARCHAR(200)} <br />
     * @param dateTermValue The value of the column 'DATE_TERM_VALUE'. (basically NotNull if update: for the constraint)
     */
    public void setDateTermValue(String dateTermValue) {
        __modifiedProperties.addPropertyName("dateTermValue");
        _dateTermValue = dateTermValue;
    }

    /**
     * [get] BEGIN_DATE: {NotNull, DATE(8)} <br />
     * @return The value of the column 'BEGIN_DATE'. (basically NotNull if selected: for the constraint)
     */
    public org.joda.time.LocalDate getBeginDate() {
        return _beginDate;
    }

    /**
     * [set] BEGIN_DATE: {NotNull, DATE(8)} <br />
     * @param beginDate The value of the column 'BEGIN_DATE'. (basically NotNull if update: for the constraint)
     */
    public void setBeginDate(org.joda.time.LocalDate beginDate) {
        __modifiedProperties.addPropertyName("beginDate");
        _beginDate = beginDate;
    }

    /**
     * [get] END_DATE: {NotNull, DATE(8)} <br />
     * @return The value of the column 'END_DATE'. (basically NotNull if selected: for the constraint)
     */
    public org.joda.time.LocalDate getEndDate() {
        return _endDate;
    }

    /**
     * [set] END_DATE: {NotNull, DATE(8)} <br />
     * @param endDate The value of the column 'END_DATE'. (basically NotNull if update: for the constraint)
     */
    public void setEndDate(org.joda.time.LocalDate endDate) {
        __modifiedProperties.addPropertyName("endDate");
        _endDate = endDate;
    }

    protected String convertEmptyToNull(String value) {
        return FunCustodial.convertEmptyToNull(value);
    }
}
