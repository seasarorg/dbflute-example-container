/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import com.example.dbflute.cdi.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.cdi.dbflute.exentity.*;

/**
 * The entity of VENDOR_CHECK as TABLE. <br />
 * <pre>
 * [primary-key]
 *     VENDOR_CHECK_ID
 * 
 * [column]
 *     VENDOR_CHECK_ID, TYPE_OF_CHAR, TYPE_OF_VARCHAR, TYPE_OF_TEXT, TYPE_OF_NUMERIC_INTEGER, TYPE_OF_NUMERIC_BIGINT, TYPE_OF_NUMERIC_DECIMAL, TYPE_OF_NUMERIC_INTEGER_MIN, TYPE_OF_NUMERIC_INTEGER_MAX, TYPE_OF_NUMERIC_BIGINT_MIN, TYPE_OF_NUMERIC_BIGINT_MAX, TYPE_OF_NUMERIC_SUPERINT_MIN, TYPE_OF_NUMERIC_SUPERINT_MAX, TYPE_OF_NUMERIC_MAXDECIMAL, TYPE_OF_BOOLEAN, TYPE_OF_BLOB, U_Y_TEXT
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
 * String typeOfChar = entity.getTypeOfChar();
 * String typeOfVarchar = entity.getTypeOfVarchar();
 * String typeOfText = entity.getTypeOfText();
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
 * Boolean typeOfBoolean = entity.getTypeOfBoolean();
 * byte[] typeOfBlob = entity.getTypeOfBlob();
 * String uYText = entity.getUYText();
 * entity.setVendorCheckId(vendorCheckId);
 * entity.setTypeOfChar(typeOfChar);
 * entity.setTypeOfVarchar(typeOfVarchar);
 * entity.setTypeOfText(typeOfText);
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
 * entity.setTypeOfBoolean(typeOfBoolean);
 * entity.setTypeOfBlob(typeOfBlob);
 * entity.setUYText(uYText);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVendorCheck extends AbstractEntity {

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
    /** VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)} */
    protected Long _vendorCheckId;

    /** TYPE_OF_CHAR: {CHAR(2147483647)} */
    protected String _typeOfChar;

    /** TYPE_OF_VARCHAR: {VARCHAR(2147483647)} */
    protected String _typeOfVarchar;

    /** TYPE_OF_TEXT: {CLOB(2147483647)} */
    protected String _typeOfText;

    /** TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)} */
    protected Integer _typeOfNumericInteger;

    /** TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)} */
    protected Long _typeOfNumericBigint;

    /** TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)} */
    protected java.math.BigDecimal _typeOfNumericDecimal;

    /** TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)} */
    protected Integer _typeOfNumericIntegerMin;

    /** TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)} */
    protected Integer _typeOfNumericIntegerMax;

    /** TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)} */
    protected Long _typeOfNumericBigintMin;

    /** TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)} */
    protected Long _typeOfNumericBigintMax;

    /** TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)} */
    protected java.math.BigDecimal _typeOfNumericSuperintMin;

    /** TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)} */
    protected java.math.BigDecimal _typeOfNumericSuperintMax;

    /** TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)} */
    protected java.math.BigDecimal _typeOfNumericMaxdecimal;

    /** TYPE_OF_BOOLEAN: {BOOLEAN(1)} */
    protected Boolean _typeOfBoolean;

    /** TYPE_OF_BLOB: {BLOB(2147483647)} */
    protected byte[] _typeOfBlob;

    /** U_Y_TEXT: {CLOB(2147483647)} */
    protected String _uYText;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "VENDOR_CHECK";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "vendorCheck";
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
        if (getVendorCheckId() == null) { return false; }
        return true;
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
        if (obj instanceof BsVendorCheck) {
            BsVendorCheck other = (BsVendorCheck)obj;
            if (!xSV(_vendorCheckId, other._vendorCheckId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, _vendorCheckId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_vendorCheckId));
        sb.append(dm).append(xfND(_typeOfChar));
        sb.append(dm).append(xfND(_typeOfVarchar));
        sb.append(dm).append(xfND(_typeOfText));
        sb.append(dm).append(xfND(_typeOfNumericInteger));
        sb.append(dm).append(xfND(_typeOfNumericBigint));
        sb.append(dm).append(xfND(_typeOfNumericDecimal));
        sb.append(dm).append(xfND(_typeOfNumericIntegerMin));
        sb.append(dm).append(xfND(_typeOfNumericIntegerMax));
        sb.append(dm).append(xfND(_typeOfNumericBigintMin));
        sb.append(dm).append(xfND(_typeOfNumericBigintMax));
        sb.append(dm).append(xfND(_typeOfNumericSuperintMin));
        sb.append(dm).append(xfND(_typeOfNumericSuperintMax));
        sb.append(dm).append(xfND(_typeOfNumericMaxdecimal));
        sb.append(dm).append(xfND(_typeOfBoolean));
        sb.append(dm).append(xfBA(_typeOfBlob));
        sb.append(dm).append(xfND(_uYText));
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
    public VendorCheck clone() {
        return (VendorCheck)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)} <br />
     * @return The value of the column 'VENDOR_CHECK_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getVendorCheckId() {
        checkSpecifiedProperty("vendorCheckId");
        return _vendorCheckId;
    }

    /**
     * [set] VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)} <br />
     * @param vendorCheckId The value of the column 'VENDOR_CHECK_ID'. (basically NotNull if update: for the constraint)
     */
    public void setVendorCheckId(Long vendorCheckId) {
        registerModifiedProperty("vendorCheckId");
        _vendorCheckId = vendorCheckId;
    }

    /**
     * [get] TYPE_OF_CHAR: {CHAR(2147483647)} <br />
     * @return The value of the column 'TYPE_OF_CHAR'. (NullAllowed even if selected: for no constraint)
     */
    public String getTypeOfChar() {
        checkSpecifiedProperty("typeOfChar");
        return _typeOfChar;
    }

    /**
     * [set] TYPE_OF_CHAR: {CHAR(2147483647)} <br />
     * @param typeOfChar The value of the column 'TYPE_OF_CHAR'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfChar(String typeOfChar) {
        registerModifiedProperty("typeOfChar");
        _typeOfChar = typeOfChar;
    }

    /**
     * [get] TYPE_OF_VARCHAR: {VARCHAR(2147483647)} <br />
     * @return The value of the column 'TYPE_OF_VARCHAR'. (NullAllowed even if selected: for no constraint)
     */
    public String getTypeOfVarchar() {
        checkSpecifiedProperty("typeOfVarchar");
        return _typeOfVarchar;
    }

    /**
     * [set] TYPE_OF_VARCHAR: {VARCHAR(2147483647)} <br />
     * @param typeOfVarchar The value of the column 'TYPE_OF_VARCHAR'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfVarchar(String typeOfVarchar) {
        registerModifiedProperty("typeOfVarchar");
        _typeOfVarchar = typeOfVarchar;
    }

    /**
     * [get] TYPE_OF_TEXT: {CLOB(2147483647)} <br />
     * @return The value of the column 'TYPE_OF_TEXT'. (NullAllowed even if selected: for no constraint)
     */
    public String getTypeOfText() {
        checkSpecifiedProperty("typeOfText");
        return _typeOfText;
    }

    /**
     * [set] TYPE_OF_TEXT: {CLOB(2147483647)} <br />
     * @param typeOfText The value of the column 'TYPE_OF_TEXT'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfText(String typeOfText) {
        registerModifiedProperty("typeOfText");
        _typeOfText = typeOfText;
    }

    /**
     * [get] TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_INTEGER'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTypeOfNumericInteger() {
        checkSpecifiedProperty("typeOfNumericInteger");
        return _typeOfNumericInteger;
    }

    /**
     * [set] TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)} <br />
     * @param typeOfNumericInteger The value of the column 'TYPE_OF_NUMERIC_INTEGER'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericInteger(Integer typeOfNumericInteger) {
        registerModifiedProperty("typeOfNumericInteger");
        _typeOfNumericInteger = typeOfNumericInteger;
    }

    /**
     * [get] TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_BIGINT'. (NullAllowed even if selected: for no constraint)
     */
    public Long getTypeOfNumericBigint() {
        checkSpecifiedProperty("typeOfNumericBigint");
        return _typeOfNumericBigint;
    }

    /**
     * [set] TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)} <br />
     * @param typeOfNumericBigint The value of the column 'TYPE_OF_NUMERIC_BIGINT'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericBigint(Long typeOfNumericBigint) {
        registerModifiedProperty("typeOfNumericBigint");
        _typeOfNumericBigint = typeOfNumericBigint;
    }

    /**
     * [get] TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_DECIMAL'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTypeOfNumericDecimal() {
        checkSpecifiedProperty("typeOfNumericDecimal");
        return _typeOfNumericDecimal;
    }

    /**
     * [set] TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)} <br />
     * @param typeOfNumericDecimal The value of the column 'TYPE_OF_NUMERIC_DECIMAL'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericDecimal(java.math.BigDecimal typeOfNumericDecimal) {
        registerModifiedProperty("typeOfNumericDecimal");
        _typeOfNumericDecimal = typeOfNumericDecimal;
    }

    /**
     * [get] TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_INTEGER_MIN'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTypeOfNumericIntegerMin() {
        checkSpecifiedProperty("typeOfNumericIntegerMin");
        return _typeOfNumericIntegerMin;
    }

    /**
     * [set] TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)} <br />
     * @param typeOfNumericIntegerMin The value of the column 'TYPE_OF_NUMERIC_INTEGER_MIN'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericIntegerMin(Integer typeOfNumericIntegerMin) {
        registerModifiedProperty("typeOfNumericIntegerMin");
        _typeOfNumericIntegerMin = typeOfNumericIntegerMin;
    }

    /**
     * [get] TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_INTEGER_MAX'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getTypeOfNumericIntegerMax() {
        checkSpecifiedProperty("typeOfNumericIntegerMax");
        return _typeOfNumericIntegerMax;
    }

    /**
     * [set] TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)} <br />
     * @param typeOfNumericIntegerMax The value of the column 'TYPE_OF_NUMERIC_INTEGER_MAX'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericIntegerMax(Integer typeOfNumericIntegerMax) {
        registerModifiedProperty("typeOfNumericIntegerMax");
        _typeOfNumericIntegerMax = typeOfNumericIntegerMax;
    }

    /**
     * [get] TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_BIGINT_MIN'. (NullAllowed even if selected: for no constraint)
     */
    public Long getTypeOfNumericBigintMin() {
        checkSpecifiedProperty("typeOfNumericBigintMin");
        return _typeOfNumericBigintMin;
    }

    /**
     * [set] TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)} <br />
     * @param typeOfNumericBigintMin The value of the column 'TYPE_OF_NUMERIC_BIGINT_MIN'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericBigintMin(Long typeOfNumericBigintMin) {
        registerModifiedProperty("typeOfNumericBigintMin");
        _typeOfNumericBigintMin = typeOfNumericBigintMin;
    }

    /**
     * [get] TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_BIGINT_MAX'. (NullAllowed even if selected: for no constraint)
     */
    public Long getTypeOfNumericBigintMax() {
        checkSpecifiedProperty("typeOfNumericBigintMax");
        return _typeOfNumericBigintMax;
    }

    /**
     * [set] TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)} <br />
     * @param typeOfNumericBigintMax The value of the column 'TYPE_OF_NUMERIC_BIGINT_MAX'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericBigintMax(Long typeOfNumericBigintMax) {
        registerModifiedProperty("typeOfNumericBigintMax");
        _typeOfNumericBigintMax = typeOfNumericBigintMax;
    }

    /**
     * [get] TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_SUPERINT_MIN'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTypeOfNumericSuperintMin() {
        checkSpecifiedProperty("typeOfNumericSuperintMin");
        return _typeOfNumericSuperintMin;
    }

    /**
     * [set] TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)} <br />
     * @param typeOfNumericSuperintMin The value of the column 'TYPE_OF_NUMERIC_SUPERINT_MIN'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericSuperintMin(java.math.BigDecimal typeOfNumericSuperintMin) {
        registerModifiedProperty("typeOfNumericSuperintMin");
        _typeOfNumericSuperintMin = typeOfNumericSuperintMin;
    }

    /**
     * [get] TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_SUPERINT_MAX'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTypeOfNumericSuperintMax() {
        checkSpecifiedProperty("typeOfNumericSuperintMax");
        return _typeOfNumericSuperintMax;
    }

    /**
     * [set] TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)} <br />
     * @param typeOfNumericSuperintMax The value of the column 'TYPE_OF_NUMERIC_SUPERINT_MAX'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericSuperintMax(java.math.BigDecimal typeOfNumericSuperintMax) {
        registerModifiedProperty("typeOfNumericSuperintMax");
        _typeOfNumericSuperintMax = typeOfNumericSuperintMax;
    }

    /**
     * [get] TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)} <br />
     * @return The value of the column 'TYPE_OF_NUMERIC_MAXDECIMAL'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getTypeOfNumericMaxdecimal() {
        checkSpecifiedProperty("typeOfNumericMaxdecimal");
        return _typeOfNumericMaxdecimal;
    }

    /**
     * [set] TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)} <br />
     * @param typeOfNumericMaxdecimal The value of the column 'TYPE_OF_NUMERIC_MAXDECIMAL'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfNumericMaxdecimal(java.math.BigDecimal typeOfNumericMaxdecimal) {
        registerModifiedProperty("typeOfNumericMaxdecimal");
        _typeOfNumericMaxdecimal = typeOfNumericMaxdecimal;
    }

    /**
     * [get] TYPE_OF_BOOLEAN: {BOOLEAN(1)} <br />
     * @return The value of the column 'TYPE_OF_BOOLEAN'. (NullAllowed even if selected: for no constraint)
     */
    public Boolean getTypeOfBoolean() {
        checkSpecifiedProperty("typeOfBoolean");
        return _typeOfBoolean;
    }

    /**
     * [set] TYPE_OF_BOOLEAN: {BOOLEAN(1)} <br />
     * @param typeOfBoolean The value of the column 'TYPE_OF_BOOLEAN'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfBoolean(Boolean typeOfBoolean) {
        registerModifiedProperty("typeOfBoolean");
        _typeOfBoolean = typeOfBoolean;
    }

    /**
     * [get] TYPE_OF_BLOB: {BLOB(2147483647)} <br />
     * @return The value of the column 'TYPE_OF_BLOB'. (NullAllowed even if selected: for no constraint)
     */
    public byte[] getTypeOfBlob() {
        checkSpecifiedProperty("typeOfBlob");
        return _typeOfBlob;
    }

    /**
     * [set] TYPE_OF_BLOB: {BLOB(2147483647)} <br />
     * @param typeOfBlob The value of the column 'TYPE_OF_BLOB'. (NullAllowed: null update allowed for no constraint)
     */
    public void setTypeOfBlob(byte[] typeOfBlob) {
        registerModifiedProperty("typeOfBlob");
        _typeOfBlob = typeOfBlob;
    }

    /**
     * [get] U_Y_TEXT: {CLOB(2147483647)} <br />
     * @return The value of the column 'U_Y_TEXT'. (NullAllowed even if selected: for no constraint)
     */
    public String getUYText() {
        checkSpecifiedProperty("UYText");
        return _uYText;
    }

    /**
     * [set] U_Y_TEXT: {CLOB(2147483647)} <br />
     * @param uYText The value of the column 'U_Y_TEXT'. (NullAllowed: null update allowed for no constraint)
     */
    public void setUYText(String uYText) {
        registerModifiedProperty("UYText");
        _uYText = uYText;
    }
}
