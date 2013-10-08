package com.example.dbflute.guice.dbflute.bsentity.customize;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.Entity;
import com.example.dbflute.guice.dbflute.exentity.customize.*;

/**
 * The entity of SimpleVendorCheck. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     VENDOR_CHECK_ID, TYPE_OF_TEXT, TYPE_OF_BOOLEAN, TYPE_OF_NUMERIC_INTEGER, TYPE_OF_NUMERIC_BIGINT, TYPE_OF_NUMERIC_DECIMAL, TYPE_OF_NUMERIC_INTEGER_MIN, TYPE_OF_NUMERIC_INTEGER_MAX, TYPE_OF_NUMERIC_BIGINT_MIN, TYPE_OF_NUMERIC_BIGINT_MAX, TYPE_OF_NUMERIC_SUPERINT_MIN, TYPE_OF_NUMERIC_SUPERINT_MAX, TYPE_OF_NUMERIC_MAXDECIMAL, TYPE_OF_BLOB
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
 * Long vendorCheckId = entity.getVendorCheckId();
 * String typeOfText = entity.getTypeOfText();
 * Boolean typeOfBoolean = entity.getTypeOfBoolean();
 * Integer typeOfNumericInteger = entity.getTypeOfNumericInteger();
 * Long typeOfNumericBigint = entity.getTypeOfNumericBigint();
 * java.math.BigDecimal typeOfNumericDecimal = entity.getTypeOfNumericDecimal();
 * Integer typeOfNumericIntegerMin = entity.getTypeOfNumericIntegerMin();
 * Integer typeOfNumericIntegerMax = entity.getTypeOfNumericIntegerMax();
 * Long typeOfNumericBigintMin = entity.getTypeOfNumericBigintMin();
 * Long typeOfNumericBigintMax = entity.getTypeOfNumericBigintMax();
 * java.math.BigDecimal typeOfNumericSuperintMin = entity.getTypeOfNumericSuperintMin();
 * java.math.BigDecimal typeOfNumericSuperintMax = entity.getTypeOfNumericSuperintMax();
 * java.math.BigDecimal typeOfNumericMaxdecimal = entity.getTypeOfNumericMaxdecimal();
 * byte[] typeOfBlob = entity.getTypeOfBlob();
 * entity.setVendorCheckId(vendorCheckId);
 * entity.setTypeOfText(typeOfText);
 * entity.setTypeOfBoolean(typeOfBoolean);
 * entity.setTypeOfNumericInteger(typeOfNumericInteger);
 * entity.setTypeOfNumericBigint(typeOfNumericBigint);
 * entity.setTypeOfNumericDecimal(typeOfNumericDecimal);
 * entity.setTypeOfNumericIntegerMin(typeOfNumericIntegerMin);
 * entity.setTypeOfNumericIntegerMax(typeOfNumericIntegerMax);
 * entity.setTypeOfNumericBigintMin(typeOfNumericBigintMin);
 * entity.setTypeOfNumericBigintMax(typeOfNumericBigintMax);
 * entity.setTypeOfNumericSuperintMin(typeOfNumericSuperintMin);
 * entity.setTypeOfNumericSuperintMax(typeOfNumericSuperintMax);
 * entity.setTypeOfNumericMaxdecimal(typeOfNumericMaxdecimal);
 * entity.setTypeOfBlob(typeOfBlob);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsSimpleVendorCheck implements Entity, Serializable, Cloneable {

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
    /** VENDOR_CHECK_ID: {DECIMAL(16), refers to VENDOR_CHECK.VENDOR_CHECK_ID} */
    protected Long _vendorCheckId;

    /** TYPE_OF_TEXT: {CLOB(2147483647), refers to VENDOR_CHECK.TYPE_OF_TEXT} */
    protected String _typeOfText;

    /** TYPE_OF_BOOLEAN: {BOOLEAN(1), refers to VENDOR_CHECK.TYPE_OF_BOOLEAN} */
    protected Boolean _typeOfBoolean;

    /** TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER} */
    protected Integer _typeOfNumericInteger;

    /** TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT} */
    protected Long _typeOfNumericBigint;

    /** TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_DECIMAL} */
    protected java.math.BigDecimal _typeOfNumericDecimal;

    /** TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER_MIN} */
    protected Integer _typeOfNumericIntegerMin;

    /** TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER_MAX} */
    protected Integer _typeOfNumericIntegerMax;

    /** TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT_MIN} */
    protected Long _typeOfNumericBigintMin;

    /** TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT_MAX} */
    protected Long _typeOfNumericBigintMax;

    /** TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_SUPERINT_MIN} */
    protected java.math.BigDecimal _typeOfNumericSuperintMin;

    /** TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_SUPERINT_MAX} */
    protected java.math.BigDecimal _typeOfNumericSuperintMax;

    /** TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_MAXDECIMAL} */
    protected java.math.BigDecimal _typeOfNumericMaxdecimal;

    /** TYPE_OF_BLOB: {BLOB(2147483647), refers to VENDOR_CHECK.TYPE_OF_BLOB} */
    protected byte[] _typeOfBlob;

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
        return "SimpleVendorCheck";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "simpleVendorCheck";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return com.example.dbflute.guice.dbflute.bsentity.customize.dbmeta.SimpleVendorCheckDbm.getInstance();
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
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * Determine the object is equal with this. <br />
     * If primary-keys or columns of the other are same as this one, returns true.
     * @param other The other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsSimpleVendorCheck)) { return false; }
        BsSimpleVendorCheck otherEntity = (BsSimpleVendorCheck)other;
        if (!xSV(getVendorCheckId(), otherEntity.getVendorCheckId())) { return false; }
        if (!xSV(getTypeOfText(), otherEntity.getTypeOfText())) { return false; }
        if (!xSV(getTypeOfBoolean(), otherEntity.getTypeOfBoolean())) { return false; }
        if (!xSV(getTypeOfNumericInteger(), otherEntity.getTypeOfNumericInteger())) { return false; }
        if (!xSV(getTypeOfNumericBigint(), otherEntity.getTypeOfNumericBigint())) { return false; }
        if (!xSV(getTypeOfNumericDecimal(), otherEntity.getTypeOfNumericDecimal())) { return false; }
        if (!xSV(getTypeOfNumericIntegerMin(), otherEntity.getTypeOfNumericIntegerMin())) { return false; }
        if (!xSV(getTypeOfNumericIntegerMax(), otherEntity.getTypeOfNumericIntegerMax())) { return false; }
        if (!xSV(getTypeOfNumericBigintMin(), otherEntity.getTypeOfNumericBigintMin())) { return false; }
        if (!xSV(getTypeOfNumericBigintMax(), otherEntity.getTypeOfNumericBigintMax())) { return false; }
        if (!xSV(getTypeOfNumericSuperintMin(), otherEntity.getTypeOfNumericSuperintMin())) { return false; }
        if (!xSV(getTypeOfNumericSuperintMax(), otherEntity.getTypeOfNumericSuperintMax())) { return false; }
        if (!xSV(getTypeOfNumericMaxdecimal(), otherEntity.getTypeOfNumericMaxdecimal())) { return false; }
        if (!xSV(getTypeOfBlob(), otherEntity.getTypeOfBlob())) { return false; }
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
        result = xCH(result, getVendorCheckId());
        result = xCH(result, getTypeOfText());
        result = xCH(result, getTypeOfBoolean());
        result = xCH(result, getTypeOfNumericInteger());
        result = xCH(result, getTypeOfNumericBigint());
        result = xCH(result, getTypeOfNumericDecimal());
        result = xCH(result, getTypeOfNumericIntegerMin());
        result = xCH(result, getTypeOfNumericIntegerMax());
        result = xCH(result, getTypeOfNumericBigintMin());
        result = xCH(result, getTypeOfNumericBigintMax());
        result = xCH(result, getTypeOfNumericSuperintMin());
        result = xCH(result, getTypeOfNumericSuperintMax());
        result = xCH(result, getTypeOfNumericMaxdecimal());
        result = xCH(result, getTypeOfBlob());
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
        sb.append(delimiter).append(getVendorCheckId());
        sb.append(delimiter).append(getTypeOfText());
        sb.append(delimiter).append(getTypeOfBoolean());
        sb.append(delimiter).append(getTypeOfNumericInteger());
        sb.append(delimiter).append(getTypeOfNumericBigint());
        sb.append(delimiter).append(getTypeOfNumericDecimal());
        sb.append(delimiter).append(getTypeOfNumericIntegerMin());
        sb.append(delimiter).append(getTypeOfNumericIntegerMax());
        sb.append(delimiter).append(getTypeOfNumericBigintMin());
        sb.append(delimiter).append(getTypeOfNumericBigintMax());
        sb.append(delimiter).append(getTypeOfNumericSuperintMin());
        sb.append(delimiter).append(getTypeOfNumericSuperintMax());
        sb.append(delimiter).append(getTypeOfNumericMaxdecimal());
        sb.append(delimiter).append(xfBA(getTypeOfBlob()));
        if (sb.length() > delimiter.length()) {
            sb.delete(0, delimiter.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String xfBA(byte[] bytes) { // formatByteArray()
        return InternalUtil.toString(bytes);
    }
    protected String buildRelationString() {
        return "";
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public SimpleVendorCheck clone() {
        try {
            return (SimpleVendorCheck)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VENDOR_CHECK_ID: {DECIMAL(16), refers to VENDOR_CHECK.VENDOR_CHECK_ID} <br />
     * @return The value of the column 'VENDOR_CHECK_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Long getVendorCheckId() {
        return _vendorCheckId;
    }

    /**
     * [set] VENDOR_CHECK_ID: {DECIMAL(16), refers to VENDOR_CHECK.VENDOR_CHECK_ID} <br />
     * @param vendorCheckId The value of the column 'VENDOR_CHECK_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setVendorCheckId(Long vendorCheckId) {
        __modifiedProperties.addPropertyName("vendorCheckId");
        this._vendorCheckId = vendorCheckId;
    }

    /**
     * [get] TYPE_OF_TEXT: {CLOB(2147483647), refers to VENDOR_CHECK.TYPE_OF_TEXT} <br />
     * @return The value of the column 'TYPE_OF_TEXT'. (NullAllowed even if selected: for no constraint)
     */
    public String getTypeOfText() {
        return convertEmptyToNull(_typeOfText);
    }

    /**
     * [set] TYPE_OF_TEXT: {CLOB(2147483647), refers to VENDOR_CHECK.TYPE_OF_TEXT} <br />
     * @param typeOfText The value of the column 'TYPE_OF_TEXT'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfText(String typeOfText) {
        __modifiedProperties.addPropertyName("typeOfText");
        this._typeOfText = typeOfText;
    }

    /**
     * [get] TYPE_OF_BOOLEAN: {BOOLEAN(1), refers to VENDOR_CHECK.TYPE_OF_BOOLEAN} <br />
     * @return The value of the column 'TYPE_OF_BOOLEAN'. (NullAllowed even if selected: for no constraint)
     */
    public Boolean getTypeOfBoolean() {
        return _typeOfBoolean;
    }

    /**
     * [set] TYPE_OF_BOOLEAN: {BOOLEAN(1), refers to VENDOR_CHECK.TYPE_OF_BOOLEAN} <br />
     * @param typeOfBoolean The value of the column 'TYPE_OF_BOOLEAN'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfBoolean(Boolean typeOfBoolean) {
        __modifiedProperties.addPropertyName("typeOfBoolean");
        this._typeOfBoolean = typeOfBoolean;
    }

    /**
     * [get] TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_INTEGER'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTypeOfNumericInteger() {
        return _typeOfNumericInteger;
    }

    /**
     * [set] TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER} <br />
     * @param typeOfNumericInteger The value of the column 'TYPE_OF_NUMERIC_INTEGER'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericInteger(Integer typeOfNumericInteger) {
        __modifiedProperties.addPropertyName("typeOfNumericInteger");
        this._typeOfNumericInteger = typeOfNumericInteger;
    }

    /**
     * [get] TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_BIGINT'. (NullAllowed even if selected: for no constraint)
     */
    public Long getTypeOfNumericBigint() {
        return _typeOfNumericBigint;
    }

    /**
     * [set] TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT} <br />
     * @param typeOfNumericBigint The value of the column 'TYPE_OF_NUMERIC_BIGINT'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericBigint(Long typeOfNumericBigint) {
        __modifiedProperties.addPropertyName("typeOfNumericBigint");
        this._typeOfNumericBigint = typeOfNumericBigint;
    }

    /**
     * [get] TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_DECIMAL} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_DECIMAL'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTypeOfNumericDecimal() {
        return _typeOfNumericDecimal;
    }

    /**
     * [set] TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_DECIMAL} <br />
     * @param typeOfNumericDecimal The value of the column 'TYPE_OF_NUMERIC_DECIMAL'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericDecimal(java.math.BigDecimal typeOfNumericDecimal) {
        __modifiedProperties.addPropertyName("typeOfNumericDecimal");
        this._typeOfNumericDecimal = typeOfNumericDecimal;
    }

    /**
     * [get] TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER_MIN} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_INTEGER_MIN'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTypeOfNumericIntegerMin() {
        return _typeOfNumericIntegerMin;
    }

    /**
     * [set] TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER_MIN} <br />
     * @param typeOfNumericIntegerMin The value of the column 'TYPE_OF_NUMERIC_INTEGER_MIN'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericIntegerMin(Integer typeOfNumericIntegerMin) {
        __modifiedProperties.addPropertyName("typeOfNumericIntegerMin");
        this._typeOfNumericIntegerMin = typeOfNumericIntegerMin;
    }

    /**
     * [get] TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER_MAX} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_INTEGER_MAX'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTypeOfNumericIntegerMax() {
        return _typeOfNumericIntegerMax;
    }

    /**
     * [set] TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_INTEGER_MAX} <br />
     * @param typeOfNumericIntegerMax The value of the column 'TYPE_OF_NUMERIC_INTEGER_MAX'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericIntegerMax(Integer typeOfNumericIntegerMax) {
        __modifiedProperties.addPropertyName("typeOfNumericIntegerMax");
        this._typeOfNumericIntegerMax = typeOfNumericIntegerMax;
    }

    /**
     * [get] TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT_MIN} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_BIGINT_MIN'. (NullAllowed even if selected: for no constraint)
     */
    public Long getTypeOfNumericBigintMin() {
        return _typeOfNumericBigintMin;
    }

    /**
     * [set] TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT_MIN} <br />
     * @param typeOfNumericBigintMin The value of the column 'TYPE_OF_NUMERIC_BIGINT_MIN'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericBigintMin(Long typeOfNumericBigintMin) {
        __modifiedProperties.addPropertyName("typeOfNumericBigintMin");
        this._typeOfNumericBigintMin = typeOfNumericBigintMin;
    }

    /**
     * [get] TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT_MAX} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_BIGINT_MAX'. (NullAllowed even if selected: for no constraint)
     */
    public Long getTypeOfNumericBigintMax() {
        return _typeOfNumericBigintMax;
    }

    /**
     * [set] TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_BIGINT_MAX} <br />
     * @param typeOfNumericBigintMax The value of the column 'TYPE_OF_NUMERIC_BIGINT_MAX'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericBigintMax(Long typeOfNumericBigintMax) {
        __modifiedProperties.addPropertyName("typeOfNumericBigintMax");
        this._typeOfNumericBigintMax = typeOfNumericBigintMax;
    }

    /**
     * [get] TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_SUPERINT_MIN} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_SUPERINT_MIN'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTypeOfNumericSuperintMin() {
        return _typeOfNumericSuperintMin;
    }

    /**
     * [set] TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_SUPERINT_MIN} <br />
     * @param typeOfNumericSuperintMin The value of the column 'TYPE_OF_NUMERIC_SUPERINT_MIN'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericSuperintMin(java.math.BigDecimal typeOfNumericSuperintMin) {
        __modifiedProperties.addPropertyName("typeOfNumericSuperintMin");
        this._typeOfNumericSuperintMin = typeOfNumericSuperintMin;
    }

    /**
     * [get] TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_SUPERINT_MAX} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_SUPERINT_MAX'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTypeOfNumericSuperintMax() {
        return _typeOfNumericSuperintMax;
    }

    /**
     * [set] TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_SUPERINT_MAX} <br />
     * @param typeOfNumericSuperintMax The value of the column 'TYPE_OF_NUMERIC_SUPERINT_MAX'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericSuperintMax(java.math.BigDecimal typeOfNumericSuperintMax) {
        __modifiedProperties.addPropertyName("typeOfNumericSuperintMax");
        this._typeOfNumericSuperintMax = typeOfNumericSuperintMax;
    }

    /**
     * [get] TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_MAXDECIMAL} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_MAXDECIMAL'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTypeOfNumericMaxdecimal() {
        return _typeOfNumericMaxdecimal;
    }

    /**
     * [set] TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38), refers to VENDOR_CHECK.TYPE_OF_NUMERIC_MAXDECIMAL} <br />
     * @param typeOfNumericMaxdecimal The value of the column 'TYPE_OF_NUMERIC_MAXDECIMAL'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericMaxdecimal(java.math.BigDecimal typeOfNumericMaxdecimal) {
        __modifiedProperties.addPropertyName("typeOfNumericMaxdecimal");
        this._typeOfNumericMaxdecimal = typeOfNumericMaxdecimal;
    }

    /**
     * [get] TYPE_OF_BLOB: {BLOB(2147483647), refers to VENDOR_CHECK.TYPE_OF_BLOB} <br />
     * @return The value of the column 'TYPE_OF_BLOB'. (NullAllowed even if selected: for no constraint)
     */
    public byte[] getTypeOfBlob() {
        return _typeOfBlob;
    }

    /**
     * [set] TYPE_OF_BLOB: {BLOB(2147483647), refers to VENDOR_CHECK.TYPE_OF_BLOB} <br />
     * @param typeOfBlob The value of the column 'TYPE_OF_BLOB'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfBlob(byte[] typeOfBlob) {
        __modifiedProperties.addPropertyName("typeOfBlob");
        this._typeOfBlob = typeOfBlob;
    }

    protected String convertEmptyToNull(String value) {
        return InternalUtil.convertEmptyToNull(value);
    }
}
