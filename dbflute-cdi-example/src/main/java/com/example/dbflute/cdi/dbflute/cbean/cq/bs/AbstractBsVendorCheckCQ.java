/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.cq.bs;

import java.util.*;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import com.example.dbflute.cdi.dbflute.allcommon.*;
import com.example.dbflute.cdi.dbflute.cbean.*;
import com.example.dbflute.cdi.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of VENDOR_CHECK.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVendorCheckCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVendorCheckCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "VENDOR_CHECK";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param vendorCheckId The value of vendorCheckId as equal. (NullAllowed: if null, no condition)
     */
    public void setVendorCheckId_Equal(Long vendorCheckId) {
        doSetVendorCheckId_Equal(vendorCheckId);
    }

    protected void doSetVendorCheckId_Equal(Long vendorCheckId) {
        regVendorCheckId(CK_EQ, vendorCheckId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param vendorCheckId The value of vendorCheckId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setVendorCheckId_NotEqual(Long vendorCheckId) {
        doSetVendorCheckId_NotEqual(vendorCheckId);
    }

    protected void doSetVendorCheckId_NotEqual(Long vendorCheckId) {
        regVendorCheckId(CK_NES, vendorCheckId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param vendorCheckId The value of vendorCheckId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setVendorCheckId_GreaterThan(Long vendorCheckId) {
        regVendorCheckId(CK_GT, vendorCheckId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param vendorCheckId The value of vendorCheckId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setVendorCheckId_LessThan(Long vendorCheckId) {
        regVendorCheckId(CK_LT, vendorCheckId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param vendorCheckId The value of vendorCheckId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setVendorCheckId_GreaterEqual(Long vendorCheckId) {
        regVendorCheckId(CK_GE, vendorCheckId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param vendorCheckId The value of vendorCheckId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setVendorCheckId_LessEqual(Long vendorCheckId) {
        regVendorCheckId(CK_LE, vendorCheckId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param minNumber The min number of vendorCheckId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of vendorCheckId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setVendorCheckId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueVendorCheckId(), "VENDOR_CHECK_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param vendorCheckIdList The collection of vendorCheckId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendorCheckId_InScope(Collection<Long> vendorCheckIdList) {
        doSetVendorCheckId_InScope(vendorCheckIdList);
    }

    protected void doSetVendorCheckId_InScope(Collection<Long> vendorCheckIdList) {
        regINS(CK_INS, cTL(vendorCheckIdList), getCValueVendorCheckId(), "VENDOR_CHECK_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @param vendorCheckIdList The collection of vendorCheckId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendorCheckId_NotInScope(Collection<Long> vendorCheckIdList) {
        doSetVendorCheckId_NotInScope(vendorCheckIdList);
    }

    protected void doSetVendorCheckId_NotInScope(Collection<Long> vendorCheckIdList) {
        regINS(CK_NINS, cTL(vendorCheckIdList), getCValueVendorCheckId(), "VENDOR_CHECK_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     */
    public void setVendorCheckId_IsNull() { regVendorCheckId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     */
    public void setVendorCheckId_IsNotNull() { regVendorCheckId(CK_ISNN, DOBJ); }

    protected void regVendorCheckId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueVendorCheckId(), "VENDOR_CHECK_ID"); }
    protected abstract ConditionValue getCValueVendorCheckId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     * @param typeOfChar The value of typeOfChar as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfChar_Equal(String typeOfChar) {
        doSetTypeOfChar_Equal(fRES(typeOfChar));
    }

    protected void doSetTypeOfChar_Equal(String typeOfChar) {
        regTypeOfChar(CK_EQ, typeOfChar);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     * @param typeOfChar The value of typeOfChar as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfChar_NotEqual(String typeOfChar) {
        doSetTypeOfChar_NotEqual(fRES(typeOfChar));
    }

    protected void doSetTypeOfChar_NotEqual(String typeOfChar) {
        regTypeOfChar(CK_NES, typeOfChar);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     * @param typeOfCharList The collection of typeOfChar as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfChar_InScope(Collection<String> typeOfCharList) {
        doSetTypeOfChar_InScope(typeOfCharList);
    }

    public void doSetTypeOfChar_InScope(Collection<String> typeOfCharList) {
        regINS(CK_INS, cTL(typeOfCharList), getCValueTypeOfChar(), "TYPE_OF_CHAR");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     * @param typeOfCharList The collection of typeOfChar as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfChar_NotInScope(Collection<String> typeOfCharList) {
        doSetTypeOfChar_NotInScope(typeOfCharList);
    }

    public void doSetTypeOfChar_NotInScope(Collection<String> typeOfCharList) {
        regINS(CK_NINS, cTL(typeOfCharList), getCValueTypeOfChar(), "TYPE_OF_CHAR");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     * @param typeOfChar The value of typeOfChar as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfChar_PrefixSearch(String typeOfChar) {
        setTypeOfChar_LikeSearch(typeOfChar, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)} <br />
     * <pre>e.g. setTypeOfChar_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param typeOfChar The value of typeOfChar as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setTypeOfChar_LikeSearch(String typeOfChar, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(typeOfChar), getCValueTypeOfChar(), "TYPE_OF_CHAR", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     * @param typeOfChar The value of typeOfChar as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setTypeOfChar_NotLikeSearch(String typeOfChar, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(typeOfChar), getCValueTypeOfChar(), "TYPE_OF_CHAR", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     */
    public void setTypeOfChar_IsNull() { regTypeOfChar(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     */
    public void setTypeOfChar_IsNullOrEmpty() { regTypeOfChar(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     */
    public void setTypeOfChar_IsNotNull() { regTypeOfChar(CK_ISNN, DOBJ); }

    protected void regTypeOfChar(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfChar(), "TYPE_OF_CHAR"); }
    protected abstract ConditionValue getCValueTypeOfChar();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     * @param typeOfVarchar The value of typeOfVarchar as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfVarchar_Equal(String typeOfVarchar) {
        doSetTypeOfVarchar_Equal(fRES(typeOfVarchar));
    }

    protected void doSetTypeOfVarchar_Equal(String typeOfVarchar) {
        regTypeOfVarchar(CK_EQ, typeOfVarchar);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     * @param typeOfVarchar The value of typeOfVarchar as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfVarchar_NotEqual(String typeOfVarchar) {
        doSetTypeOfVarchar_NotEqual(fRES(typeOfVarchar));
    }

    protected void doSetTypeOfVarchar_NotEqual(String typeOfVarchar) {
        regTypeOfVarchar(CK_NES, typeOfVarchar);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     * @param typeOfVarcharList The collection of typeOfVarchar as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfVarchar_InScope(Collection<String> typeOfVarcharList) {
        doSetTypeOfVarchar_InScope(typeOfVarcharList);
    }

    public void doSetTypeOfVarchar_InScope(Collection<String> typeOfVarcharList) {
        regINS(CK_INS, cTL(typeOfVarcharList), getCValueTypeOfVarchar(), "TYPE_OF_VARCHAR");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     * @param typeOfVarcharList The collection of typeOfVarchar as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfVarchar_NotInScope(Collection<String> typeOfVarcharList) {
        doSetTypeOfVarchar_NotInScope(typeOfVarcharList);
    }

    public void doSetTypeOfVarchar_NotInScope(Collection<String> typeOfVarcharList) {
        regINS(CK_NINS, cTL(typeOfVarcharList), getCValueTypeOfVarchar(), "TYPE_OF_VARCHAR");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     * @param typeOfVarchar The value of typeOfVarchar as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfVarchar_PrefixSearch(String typeOfVarchar) {
        setTypeOfVarchar_LikeSearch(typeOfVarchar, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)} <br />
     * <pre>e.g. setTypeOfVarchar_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param typeOfVarchar The value of typeOfVarchar as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setTypeOfVarchar_LikeSearch(String typeOfVarchar, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(typeOfVarchar), getCValueTypeOfVarchar(), "TYPE_OF_VARCHAR", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     * @param typeOfVarchar The value of typeOfVarchar as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setTypeOfVarchar_NotLikeSearch(String typeOfVarchar, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(typeOfVarchar), getCValueTypeOfVarchar(), "TYPE_OF_VARCHAR", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     */
    public void setTypeOfVarchar_IsNull() { regTypeOfVarchar(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     */
    public void setTypeOfVarchar_IsNullOrEmpty() { regTypeOfVarchar(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     */
    public void setTypeOfVarchar_IsNotNull() { regTypeOfVarchar(CK_ISNN, DOBJ); }

    protected void regTypeOfVarchar(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfVarchar(), "TYPE_OF_VARCHAR"); }
    protected abstract ConditionValue getCValueTypeOfVarchar();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     * @param typeOfText The value of typeOfText as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfText_Equal(String typeOfText) {
        doSetTypeOfText_Equal(fRES(typeOfText));
    }

    protected void doSetTypeOfText_Equal(String typeOfText) {
        regTypeOfText(CK_EQ, typeOfText);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     * @param typeOfText The value of typeOfText as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfText_NotEqual(String typeOfText) {
        doSetTypeOfText_NotEqual(fRES(typeOfText));
    }

    protected void doSetTypeOfText_NotEqual(String typeOfText) {
        regTypeOfText(CK_NES, typeOfText);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     * @param typeOfTextList The collection of typeOfText as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfText_InScope(Collection<String> typeOfTextList) {
        doSetTypeOfText_InScope(typeOfTextList);
    }

    public void doSetTypeOfText_InScope(Collection<String> typeOfTextList) {
        regINS(CK_INS, cTL(typeOfTextList), getCValueTypeOfText(), "TYPE_OF_TEXT");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     * @param typeOfTextList The collection of typeOfText as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfText_NotInScope(Collection<String> typeOfTextList) {
        doSetTypeOfText_NotInScope(typeOfTextList);
    }

    public void doSetTypeOfText_NotInScope(Collection<String> typeOfTextList) {
        regINS(CK_NINS, cTL(typeOfTextList), getCValueTypeOfText(), "TYPE_OF_TEXT");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     * @param typeOfText The value of typeOfText as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfText_PrefixSearch(String typeOfText) {
        setTypeOfText_LikeSearch(typeOfText, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)} <br />
     * <pre>e.g. setTypeOfText_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param typeOfText The value of typeOfText as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setTypeOfText_LikeSearch(String typeOfText, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(typeOfText), getCValueTypeOfText(), "TYPE_OF_TEXT", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     * @param typeOfText The value of typeOfText as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setTypeOfText_NotLikeSearch(String typeOfText, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(typeOfText), getCValueTypeOfText(), "TYPE_OF_TEXT", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     */
    public void setTypeOfText_IsNull() { regTypeOfText(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     */
    public void setTypeOfText_IsNullOrEmpty() { regTypeOfText(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     */
    public void setTypeOfText_IsNotNull() { regTypeOfText(CK_ISNN, DOBJ); }

    protected void regTypeOfText(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfText(), "TYPE_OF_TEXT"); }
    protected abstract ConditionValue getCValueTypeOfText();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param typeOfNumericInteger The value of typeOfNumericInteger as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericInteger_Equal(Integer typeOfNumericInteger) {
        doSetTypeOfNumericInteger_Equal(typeOfNumericInteger);
    }

    protected void doSetTypeOfNumericInteger_Equal(Integer typeOfNumericInteger) {
        regTypeOfNumericInteger(CK_EQ, typeOfNumericInteger);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param typeOfNumericInteger The value of typeOfNumericInteger as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericInteger_NotEqual(Integer typeOfNumericInteger) {
        doSetTypeOfNumericInteger_NotEqual(typeOfNumericInteger);
    }

    protected void doSetTypeOfNumericInteger_NotEqual(Integer typeOfNumericInteger) {
        regTypeOfNumericInteger(CK_NES, typeOfNumericInteger);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param typeOfNumericInteger The value of typeOfNumericInteger as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericInteger_GreaterThan(Integer typeOfNumericInteger) {
        regTypeOfNumericInteger(CK_GT, typeOfNumericInteger);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param typeOfNumericInteger The value of typeOfNumericInteger as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericInteger_LessThan(Integer typeOfNumericInteger) {
        regTypeOfNumericInteger(CK_LT, typeOfNumericInteger);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param typeOfNumericInteger The value of typeOfNumericInteger as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericInteger_GreaterEqual(Integer typeOfNumericInteger) {
        regTypeOfNumericInteger(CK_GE, typeOfNumericInteger);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param typeOfNumericInteger The value of typeOfNumericInteger as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericInteger_LessEqual(Integer typeOfNumericInteger) {
        regTypeOfNumericInteger(CK_LE, typeOfNumericInteger);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param minNumber The min number of typeOfNumericInteger. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericInteger. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericInteger_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericInteger(), "TYPE_OF_NUMERIC_INTEGER", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param typeOfNumericIntegerList The collection of typeOfNumericInteger as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericInteger_InScope(Collection<Integer> typeOfNumericIntegerList) {
        doSetTypeOfNumericInteger_InScope(typeOfNumericIntegerList);
    }

    protected void doSetTypeOfNumericInteger_InScope(Collection<Integer> typeOfNumericIntegerList) {
        regINS(CK_INS, cTL(typeOfNumericIntegerList), getCValueTypeOfNumericInteger(), "TYPE_OF_NUMERIC_INTEGER");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @param typeOfNumericIntegerList The collection of typeOfNumericInteger as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericInteger_NotInScope(Collection<Integer> typeOfNumericIntegerList) {
        doSetTypeOfNumericInteger_NotInScope(typeOfNumericIntegerList);
    }

    protected void doSetTypeOfNumericInteger_NotInScope(Collection<Integer> typeOfNumericIntegerList) {
        regINS(CK_NINS, cTL(typeOfNumericIntegerList), getCValueTypeOfNumericInteger(), "TYPE_OF_NUMERIC_INTEGER");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     */
    public void setTypeOfNumericInteger_IsNull() { regTypeOfNumericInteger(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     */
    public void setTypeOfNumericInteger_IsNotNull() { regTypeOfNumericInteger(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericInteger(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericInteger(), "TYPE_OF_NUMERIC_INTEGER"); }
    protected abstract ConditionValue getCValueTypeOfNumericInteger();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param typeOfNumericBigint The value of typeOfNumericBigint as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigint_Equal(Long typeOfNumericBigint) {
        doSetTypeOfNumericBigint_Equal(typeOfNumericBigint);
    }

    protected void doSetTypeOfNumericBigint_Equal(Long typeOfNumericBigint) {
        regTypeOfNumericBigint(CK_EQ, typeOfNumericBigint);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param typeOfNumericBigint The value of typeOfNumericBigint as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigint_NotEqual(Long typeOfNumericBigint) {
        doSetTypeOfNumericBigint_NotEqual(typeOfNumericBigint);
    }

    protected void doSetTypeOfNumericBigint_NotEqual(Long typeOfNumericBigint) {
        regTypeOfNumericBigint(CK_NES, typeOfNumericBigint);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param typeOfNumericBigint The value of typeOfNumericBigint as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigint_GreaterThan(Long typeOfNumericBigint) {
        regTypeOfNumericBigint(CK_GT, typeOfNumericBigint);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param typeOfNumericBigint The value of typeOfNumericBigint as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigint_LessThan(Long typeOfNumericBigint) {
        regTypeOfNumericBigint(CK_LT, typeOfNumericBigint);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param typeOfNumericBigint The value of typeOfNumericBigint as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigint_GreaterEqual(Long typeOfNumericBigint) {
        regTypeOfNumericBigint(CK_GE, typeOfNumericBigint);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param typeOfNumericBigint The value of typeOfNumericBigint as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigint_LessEqual(Long typeOfNumericBigint) {
        regTypeOfNumericBigint(CK_LE, typeOfNumericBigint);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param minNumber The min number of typeOfNumericBigint. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericBigint. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericBigint_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericBigint(), "TYPE_OF_NUMERIC_BIGINT", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param typeOfNumericBigintList The collection of typeOfNumericBigint as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericBigint_InScope(Collection<Long> typeOfNumericBigintList) {
        doSetTypeOfNumericBigint_InScope(typeOfNumericBigintList);
    }

    protected void doSetTypeOfNumericBigint_InScope(Collection<Long> typeOfNumericBigintList) {
        regINS(CK_INS, cTL(typeOfNumericBigintList), getCValueTypeOfNumericBigint(), "TYPE_OF_NUMERIC_BIGINT");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @param typeOfNumericBigintList The collection of typeOfNumericBigint as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericBigint_NotInScope(Collection<Long> typeOfNumericBigintList) {
        doSetTypeOfNumericBigint_NotInScope(typeOfNumericBigintList);
    }

    protected void doSetTypeOfNumericBigint_NotInScope(Collection<Long> typeOfNumericBigintList) {
        regINS(CK_NINS, cTL(typeOfNumericBigintList), getCValueTypeOfNumericBigint(), "TYPE_OF_NUMERIC_BIGINT");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     */
    public void setTypeOfNumericBigint_IsNull() { regTypeOfNumericBigint(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     */
    public void setTypeOfNumericBigint_IsNotNull() { regTypeOfNumericBigint(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericBigint(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericBigint(), "TYPE_OF_NUMERIC_BIGINT"); }
    protected abstract ConditionValue getCValueTypeOfNumericBigint();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param typeOfNumericDecimal The value of typeOfNumericDecimal as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericDecimal_Equal(java.math.BigDecimal typeOfNumericDecimal) {
        doSetTypeOfNumericDecimal_Equal(typeOfNumericDecimal);
    }

    protected void doSetTypeOfNumericDecimal_Equal(java.math.BigDecimal typeOfNumericDecimal) {
        regTypeOfNumericDecimal(CK_EQ, typeOfNumericDecimal);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param typeOfNumericDecimal The value of typeOfNumericDecimal as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericDecimal_NotEqual(java.math.BigDecimal typeOfNumericDecimal) {
        doSetTypeOfNumericDecimal_NotEqual(typeOfNumericDecimal);
    }

    protected void doSetTypeOfNumericDecimal_NotEqual(java.math.BigDecimal typeOfNumericDecimal) {
        regTypeOfNumericDecimal(CK_NES, typeOfNumericDecimal);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param typeOfNumericDecimal The value of typeOfNumericDecimal as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericDecimal_GreaterThan(java.math.BigDecimal typeOfNumericDecimal) {
        regTypeOfNumericDecimal(CK_GT, typeOfNumericDecimal);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param typeOfNumericDecimal The value of typeOfNumericDecimal as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericDecimal_LessThan(java.math.BigDecimal typeOfNumericDecimal) {
        regTypeOfNumericDecimal(CK_LT, typeOfNumericDecimal);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param typeOfNumericDecimal The value of typeOfNumericDecimal as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericDecimal_GreaterEqual(java.math.BigDecimal typeOfNumericDecimal) {
        regTypeOfNumericDecimal(CK_GE, typeOfNumericDecimal);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param typeOfNumericDecimal The value of typeOfNumericDecimal as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericDecimal_LessEqual(java.math.BigDecimal typeOfNumericDecimal) {
        regTypeOfNumericDecimal(CK_LE, typeOfNumericDecimal);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param minNumber The min number of typeOfNumericDecimal. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericDecimal. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericDecimal_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericDecimal(), "TYPE_OF_NUMERIC_DECIMAL", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param typeOfNumericDecimalList The collection of typeOfNumericDecimal as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericDecimal_InScope(Collection<java.math.BigDecimal> typeOfNumericDecimalList) {
        doSetTypeOfNumericDecimal_InScope(typeOfNumericDecimalList);
    }

    protected void doSetTypeOfNumericDecimal_InScope(Collection<java.math.BigDecimal> typeOfNumericDecimalList) {
        regINS(CK_INS, cTL(typeOfNumericDecimalList), getCValueTypeOfNumericDecimal(), "TYPE_OF_NUMERIC_DECIMAL");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @param typeOfNumericDecimalList The collection of typeOfNumericDecimal as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericDecimal_NotInScope(Collection<java.math.BigDecimal> typeOfNumericDecimalList) {
        doSetTypeOfNumericDecimal_NotInScope(typeOfNumericDecimalList);
    }

    protected void doSetTypeOfNumericDecimal_NotInScope(Collection<java.math.BigDecimal> typeOfNumericDecimalList) {
        regINS(CK_NINS, cTL(typeOfNumericDecimalList), getCValueTypeOfNumericDecimal(), "TYPE_OF_NUMERIC_DECIMAL");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     */
    public void setTypeOfNumericDecimal_IsNull() { regTypeOfNumericDecimal(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     */
    public void setTypeOfNumericDecimal_IsNotNull() { regTypeOfNumericDecimal(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericDecimal(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericDecimal(), "TYPE_OF_NUMERIC_DECIMAL"); }
    protected abstract ConditionValue getCValueTypeOfNumericDecimal();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param typeOfNumericIntegerMin The value of typeOfNumericIntegerMin as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMin_Equal(Integer typeOfNumericIntegerMin) {
        doSetTypeOfNumericIntegerMin_Equal(typeOfNumericIntegerMin);
    }

    protected void doSetTypeOfNumericIntegerMin_Equal(Integer typeOfNumericIntegerMin) {
        regTypeOfNumericIntegerMin(CK_EQ, typeOfNumericIntegerMin);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param typeOfNumericIntegerMin The value of typeOfNumericIntegerMin as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMin_NotEqual(Integer typeOfNumericIntegerMin) {
        doSetTypeOfNumericIntegerMin_NotEqual(typeOfNumericIntegerMin);
    }

    protected void doSetTypeOfNumericIntegerMin_NotEqual(Integer typeOfNumericIntegerMin) {
        regTypeOfNumericIntegerMin(CK_NES, typeOfNumericIntegerMin);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param typeOfNumericIntegerMin The value of typeOfNumericIntegerMin as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMin_GreaterThan(Integer typeOfNumericIntegerMin) {
        regTypeOfNumericIntegerMin(CK_GT, typeOfNumericIntegerMin);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param typeOfNumericIntegerMin The value of typeOfNumericIntegerMin as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMin_LessThan(Integer typeOfNumericIntegerMin) {
        regTypeOfNumericIntegerMin(CK_LT, typeOfNumericIntegerMin);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param typeOfNumericIntegerMin The value of typeOfNumericIntegerMin as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMin_GreaterEqual(Integer typeOfNumericIntegerMin) {
        regTypeOfNumericIntegerMin(CK_GE, typeOfNumericIntegerMin);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param typeOfNumericIntegerMin The value of typeOfNumericIntegerMin as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMin_LessEqual(Integer typeOfNumericIntegerMin) {
        regTypeOfNumericIntegerMin(CK_LE, typeOfNumericIntegerMin);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param minNumber The min number of typeOfNumericIntegerMin. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericIntegerMin. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericIntegerMin_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericIntegerMin(), "TYPE_OF_NUMERIC_INTEGER_MIN", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param typeOfNumericIntegerMinList The collection of typeOfNumericIntegerMin as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericIntegerMin_InScope(Collection<Integer> typeOfNumericIntegerMinList) {
        doSetTypeOfNumericIntegerMin_InScope(typeOfNumericIntegerMinList);
    }

    protected void doSetTypeOfNumericIntegerMin_InScope(Collection<Integer> typeOfNumericIntegerMinList) {
        regINS(CK_INS, cTL(typeOfNumericIntegerMinList), getCValueTypeOfNumericIntegerMin(), "TYPE_OF_NUMERIC_INTEGER_MIN");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @param typeOfNumericIntegerMinList The collection of typeOfNumericIntegerMin as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericIntegerMin_NotInScope(Collection<Integer> typeOfNumericIntegerMinList) {
        doSetTypeOfNumericIntegerMin_NotInScope(typeOfNumericIntegerMinList);
    }

    protected void doSetTypeOfNumericIntegerMin_NotInScope(Collection<Integer> typeOfNumericIntegerMinList) {
        regINS(CK_NINS, cTL(typeOfNumericIntegerMinList), getCValueTypeOfNumericIntegerMin(), "TYPE_OF_NUMERIC_INTEGER_MIN");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     */
    public void setTypeOfNumericIntegerMin_IsNull() { regTypeOfNumericIntegerMin(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     */
    public void setTypeOfNumericIntegerMin_IsNotNull() { regTypeOfNumericIntegerMin(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericIntegerMin(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericIntegerMin(), "TYPE_OF_NUMERIC_INTEGER_MIN"); }
    protected abstract ConditionValue getCValueTypeOfNumericIntegerMin();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param typeOfNumericIntegerMax The value of typeOfNumericIntegerMax as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMax_Equal(Integer typeOfNumericIntegerMax) {
        doSetTypeOfNumericIntegerMax_Equal(typeOfNumericIntegerMax);
    }

    protected void doSetTypeOfNumericIntegerMax_Equal(Integer typeOfNumericIntegerMax) {
        regTypeOfNumericIntegerMax(CK_EQ, typeOfNumericIntegerMax);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param typeOfNumericIntegerMax The value of typeOfNumericIntegerMax as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMax_NotEqual(Integer typeOfNumericIntegerMax) {
        doSetTypeOfNumericIntegerMax_NotEqual(typeOfNumericIntegerMax);
    }

    protected void doSetTypeOfNumericIntegerMax_NotEqual(Integer typeOfNumericIntegerMax) {
        regTypeOfNumericIntegerMax(CK_NES, typeOfNumericIntegerMax);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param typeOfNumericIntegerMax The value of typeOfNumericIntegerMax as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMax_GreaterThan(Integer typeOfNumericIntegerMax) {
        regTypeOfNumericIntegerMax(CK_GT, typeOfNumericIntegerMax);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param typeOfNumericIntegerMax The value of typeOfNumericIntegerMax as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMax_LessThan(Integer typeOfNumericIntegerMax) {
        regTypeOfNumericIntegerMax(CK_LT, typeOfNumericIntegerMax);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param typeOfNumericIntegerMax The value of typeOfNumericIntegerMax as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMax_GreaterEqual(Integer typeOfNumericIntegerMax) {
        regTypeOfNumericIntegerMax(CK_GE, typeOfNumericIntegerMax);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param typeOfNumericIntegerMax The value of typeOfNumericIntegerMax as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericIntegerMax_LessEqual(Integer typeOfNumericIntegerMax) {
        regTypeOfNumericIntegerMax(CK_LE, typeOfNumericIntegerMax);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param minNumber The min number of typeOfNumericIntegerMax. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericIntegerMax. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericIntegerMax_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericIntegerMax(), "TYPE_OF_NUMERIC_INTEGER_MAX", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param typeOfNumericIntegerMaxList The collection of typeOfNumericIntegerMax as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericIntegerMax_InScope(Collection<Integer> typeOfNumericIntegerMaxList) {
        doSetTypeOfNumericIntegerMax_InScope(typeOfNumericIntegerMaxList);
    }

    protected void doSetTypeOfNumericIntegerMax_InScope(Collection<Integer> typeOfNumericIntegerMaxList) {
        regINS(CK_INS, cTL(typeOfNumericIntegerMaxList), getCValueTypeOfNumericIntegerMax(), "TYPE_OF_NUMERIC_INTEGER_MAX");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @param typeOfNumericIntegerMaxList The collection of typeOfNumericIntegerMax as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericIntegerMax_NotInScope(Collection<Integer> typeOfNumericIntegerMaxList) {
        doSetTypeOfNumericIntegerMax_NotInScope(typeOfNumericIntegerMaxList);
    }

    protected void doSetTypeOfNumericIntegerMax_NotInScope(Collection<Integer> typeOfNumericIntegerMaxList) {
        regINS(CK_NINS, cTL(typeOfNumericIntegerMaxList), getCValueTypeOfNumericIntegerMax(), "TYPE_OF_NUMERIC_INTEGER_MAX");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     */
    public void setTypeOfNumericIntegerMax_IsNull() { regTypeOfNumericIntegerMax(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     */
    public void setTypeOfNumericIntegerMax_IsNotNull() { regTypeOfNumericIntegerMax(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericIntegerMax(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericIntegerMax(), "TYPE_OF_NUMERIC_INTEGER_MAX"); }
    protected abstract ConditionValue getCValueTypeOfNumericIntegerMax();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param typeOfNumericBigintMin The value of typeOfNumericBigintMin as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMin_Equal(Long typeOfNumericBigintMin) {
        doSetTypeOfNumericBigintMin_Equal(typeOfNumericBigintMin);
    }

    protected void doSetTypeOfNumericBigintMin_Equal(Long typeOfNumericBigintMin) {
        regTypeOfNumericBigintMin(CK_EQ, typeOfNumericBigintMin);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param typeOfNumericBigintMin The value of typeOfNumericBigintMin as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMin_NotEqual(Long typeOfNumericBigintMin) {
        doSetTypeOfNumericBigintMin_NotEqual(typeOfNumericBigintMin);
    }

    protected void doSetTypeOfNumericBigintMin_NotEqual(Long typeOfNumericBigintMin) {
        regTypeOfNumericBigintMin(CK_NES, typeOfNumericBigintMin);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param typeOfNumericBigintMin The value of typeOfNumericBigintMin as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMin_GreaterThan(Long typeOfNumericBigintMin) {
        regTypeOfNumericBigintMin(CK_GT, typeOfNumericBigintMin);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param typeOfNumericBigintMin The value of typeOfNumericBigintMin as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMin_LessThan(Long typeOfNumericBigintMin) {
        regTypeOfNumericBigintMin(CK_LT, typeOfNumericBigintMin);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param typeOfNumericBigintMin The value of typeOfNumericBigintMin as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMin_GreaterEqual(Long typeOfNumericBigintMin) {
        regTypeOfNumericBigintMin(CK_GE, typeOfNumericBigintMin);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param typeOfNumericBigintMin The value of typeOfNumericBigintMin as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMin_LessEqual(Long typeOfNumericBigintMin) {
        regTypeOfNumericBigintMin(CK_LE, typeOfNumericBigintMin);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param minNumber The min number of typeOfNumericBigintMin. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericBigintMin. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericBigintMin_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericBigintMin(), "TYPE_OF_NUMERIC_BIGINT_MIN", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param typeOfNumericBigintMinList The collection of typeOfNumericBigintMin as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericBigintMin_InScope(Collection<Long> typeOfNumericBigintMinList) {
        doSetTypeOfNumericBigintMin_InScope(typeOfNumericBigintMinList);
    }

    protected void doSetTypeOfNumericBigintMin_InScope(Collection<Long> typeOfNumericBigintMinList) {
        regINS(CK_INS, cTL(typeOfNumericBigintMinList), getCValueTypeOfNumericBigintMin(), "TYPE_OF_NUMERIC_BIGINT_MIN");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @param typeOfNumericBigintMinList The collection of typeOfNumericBigintMin as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericBigintMin_NotInScope(Collection<Long> typeOfNumericBigintMinList) {
        doSetTypeOfNumericBigintMin_NotInScope(typeOfNumericBigintMinList);
    }

    protected void doSetTypeOfNumericBigintMin_NotInScope(Collection<Long> typeOfNumericBigintMinList) {
        regINS(CK_NINS, cTL(typeOfNumericBigintMinList), getCValueTypeOfNumericBigintMin(), "TYPE_OF_NUMERIC_BIGINT_MIN");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     */
    public void setTypeOfNumericBigintMin_IsNull() { regTypeOfNumericBigintMin(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     */
    public void setTypeOfNumericBigintMin_IsNotNull() { regTypeOfNumericBigintMin(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericBigintMin(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericBigintMin(), "TYPE_OF_NUMERIC_BIGINT_MIN"); }
    protected abstract ConditionValue getCValueTypeOfNumericBigintMin();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param typeOfNumericBigintMax The value of typeOfNumericBigintMax as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMax_Equal(Long typeOfNumericBigintMax) {
        doSetTypeOfNumericBigintMax_Equal(typeOfNumericBigintMax);
    }

    protected void doSetTypeOfNumericBigintMax_Equal(Long typeOfNumericBigintMax) {
        regTypeOfNumericBigintMax(CK_EQ, typeOfNumericBigintMax);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param typeOfNumericBigintMax The value of typeOfNumericBigintMax as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMax_NotEqual(Long typeOfNumericBigintMax) {
        doSetTypeOfNumericBigintMax_NotEqual(typeOfNumericBigintMax);
    }

    protected void doSetTypeOfNumericBigintMax_NotEqual(Long typeOfNumericBigintMax) {
        regTypeOfNumericBigintMax(CK_NES, typeOfNumericBigintMax);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param typeOfNumericBigintMax The value of typeOfNumericBigintMax as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMax_GreaterThan(Long typeOfNumericBigintMax) {
        regTypeOfNumericBigintMax(CK_GT, typeOfNumericBigintMax);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param typeOfNumericBigintMax The value of typeOfNumericBigintMax as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMax_LessThan(Long typeOfNumericBigintMax) {
        regTypeOfNumericBigintMax(CK_LT, typeOfNumericBigintMax);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param typeOfNumericBigintMax The value of typeOfNumericBigintMax as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMax_GreaterEqual(Long typeOfNumericBigintMax) {
        regTypeOfNumericBigintMax(CK_GE, typeOfNumericBigintMax);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param typeOfNumericBigintMax The value of typeOfNumericBigintMax as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericBigintMax_LessEqual(Long typeOfNumericBigintMax) {
        regTypeOfNumericBigintMax(CK_LE, typeOfNumericBigintMax);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param minNumber The min number of typeOfNumericBigintMax. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericBigintMax. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericBigintMax_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericBigintMax(), "TYPE_OF_NUMERIC_BIGINT_MAX", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param typeOfNumericBigintMaxList The collection of typeOfNumericBigintMax as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericBigintMax_InScope(Collection<Long> typeOfNumericBigintMaxList) {
        doSetTypeOfNumericBigintMax_InScope(typeOfNumericBigintMaxList);
    }

    protected void doSetTypeOfNumericBigintMax_InScope(Collection<Long> typeOfNumericBigintMaxList) {
        regINS(CK_INS, cTL(typeOfNumericBigintMaxList), getCValueTypeOfNumericBigintMax(), "TYPE_OF_NUMERIC_BIGINT_MAX");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @param typeOfNumericBigintMaxList The collection of typeOfNumericBigintMax as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericBigintMax_NotInScope(Collection<Long> typeOfNumericBigintMaxList) {
        doSetTypeOfNumericBigintMax_NotInScope(typeOfNumericBigintMaxList);
    }

    protected void doSetTypeOfNumericBigintMax_NotInScope(Collection<Long> typeOfNumericBigintMaxList) {
        regINS(CK_NINS, cTL(typeOfNumericBigintMaxList), getCValueTypeOfNumericBigintMax(), "TYPE_OF_NUMERIC_BIGINT_MAX");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     */
    public void setTypeOfNumericBigintMax_IsNull() { regTypeOfNumericBigintMax(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     */
    public void setTypeOfNumericBigintMax_IsNotNull() { regTypeOfNumericBigintMax(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericBigintMax(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericBigintMax(), "TYPE_OF_NUMERIC_BIGINT_MAX"); }
    protected abstract ConditionValue getCValueTypeOfNumericBigintMax();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param typeOfNumericSuperintMin The value of typeOfNumericSuperintMin as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMin_Equal(java.math.BigDecimal typeOfNumericSuperintMin) {
        doSetTypeOfNumericSuperintMin_Equal(typeOfNumericSuperintMin);
    }

    protected void doSetTypeOfNumericSuperintMin_Equal(java.math.BigDecimal typeOfNumericSuperintMin) {
        regTypeOfNumericSuperintMin(CK_EQ, typeOfNumericSuperintMin);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param typeOfNumericSuperintMin The value of typeOfNumericSuperintMin as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMin_NotEqual(java.math.BigDecimal typeOfNumericSuperintMin) {
        doSetTypeOfNumericSuperintMin_NotEqual(typeOfNumericSuperintMin);
    }

    protected void doSetTypeOfNumericSuperintMin_NotEqual(java.math.BigDecimal typeOfNumericSuperintMin) {
        regTypeOfNumericSuperintMin(CK_NES, typeOfNumericSuperintMin);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param typeOfNumericSuperintMin The value of typeOfNumericSuperintMin as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMin_GreaterThan(java.math.BigDecimal typeOfNumericSuperintMin) {
        regTypeOfNumericSuperintMin(CK_GT, typeOfNumericSuperintMin);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param typeOfNumericSuperintMin The value of typeOfNumericSuperintMin as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMin_LessThan(java.math.BigDecimal typeOfNumericSuperintMin) {
        regTypeOfNumericSuperintMin(CK_LT, typeOfNumericSuperintMin);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param typeOfNumericSuperintMin The value of typeOfNumericSuperintMin as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMin_GreaterEqual(java.math.BigDecimal typeOfNumericSuperintMin) {
        regTypeOfNumericSuperintMin(CK_GE, typeOfNumericSuperintMin);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param typeOfNumericSuperintMin The value of typeOfNumericSuperintMin as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMin_LessEqual(java.math.BigDecimal typeOfNumericSuperintMin) {
        regTypeOfNumericSuperintMin(CK_LE, typeOfNumericSuperintMin);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param minNumber The min number of typeOfNumericSuperintMin. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericSuperintMin. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericSuperintMin_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericSuperintMin(), "TYPE_OF_NUMERIC_SUPERINT_MIN", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param typeOfNumericSuperintMinList The collection of typeOfNumericSuperintMin as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericSuperintMin_InScope(Collection<java.math.BigDecimal> typeOfNumericSuperintMinList) {
        doSetTypeOfNumericSuperintMin_InScope(typeOfNumericSuperintMinList);
    }

    protected void doSetTypeOfNumericSuperintMin_InScope(Collection<java.math.BigDecimal> typeOfNumericSuperintMinList) {
        regINS(CK_INS, cTL(typeOfNumericSuperintMinList), getCValueTypeOfNumericSuperintMin(), "TYPE_OF_NUMERIC_SUPERINT_MIN");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @param typeOfNumericSuperintMinList The collection of typeOfNumericSuperintMin as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericSuperintMin_NotInScope(Collection<java.math.BigDecimal> typeOfNumericSuperintMinList) {
        doSetTypeOfNumericSuperintMin_NotInScope(typeOfNumericSuperintMinList);
    }

    protected void doSetTypeOfNumericSuperintMin_NotInScope(Collection<java.math.BigDecimal> typeOfNumericSuperintMinList) {
        regINS(CK_NINS, cTL(typeOfNumericSuperintMinList), getCValueTypeOfNumericSuperintMin(), "TYPE_OF_NUMERIC_SUPERINT_MIN");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     */
    public void setTypeOfNumericSuperintMin_IsNull() { regTypeOfNumericSuperintMin(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     */
    public void setTypeOfNumericSuperintMin_IsNotNull() { regTypeOfNumericSuperintMin(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericSuperintMin(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericSuperintMin(), "TYPE_OF_NUMERIC_SUPERINT_MIN"); }
    protected abstract ConditionValue getCValueTypeOfNumericSuperintMin();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param typeOfNumericSuperintMax The value of typeOfNumericSuperintMax as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMax_Equal(java.math.BigDecimal typeOfNumericSuperintMax) {
        doSetTypeOfNumericSuperintMax_Equal(typeOfNumericSuperintMax);
    }

    protected void doSetTypeOfNumericSuperintMax_Equal(java.math.BigDecimal typeOfNumericSuperintMax) {
        regTypeOfNumericSuperintMax(CK_EQ, typeOfNumericSuperintMax);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param typeOfNumericSuperintMax The value of typeOfNumericSuperintMax as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMax_NotEqual(java.math.BigDecimal typeOfNumericSuperintMax) {
        doSetTypeOfNumericSuperintMax_NotEqual(typeOfNumericSuperintMax);
    }

    protected void doSetTypeOfNumericSuperintMax_NotEqual(java.math.BigDecimal typeOfNumericSuperintMax) {
        regTypeOfNumericSuperintMax(CK_NES, typeOfNumericSuperintMax);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param typeOfNumericSuperintMax The value of typeOfNumericSuperintMax as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMax_GreaterThan(java.math.BigDecimal typeOfNumericSuperintMax) {
        regTypeOfNumericSuperintMax(CK_GT, typeOfNumericSuperintMax);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param typeOfNumericSuperintMax The value of typeOfNumericSuperintMax as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMax_LessThan(java.math.BigDecimal typeOfNumericSuperintMax) {
        regTypeOfNumericSuperintMax(CK_LT, typeOfNumericSuperintMax);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param typeOfNumericSuperintMax The value of typeOfNumericSuperintMax as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMax_GreaterEqual(java.math.BigDecimal typeOfNumericSuperintMax) {
        regTypeOfNumericSuperintMax(CK_GE, typeOfNumericSuperintMax);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param typeOfNumericSuperintMax The value of typeOfNumericSuperintMax as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericSuperintMax_LessEqual(java.math.BigDecimal typeOfNumericSuperintMax) {
        regTypeOfNumericSuperintMax(CK_LE, typeOfNumericSuperintMax);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param minNumber The min number of typeOfNumericSuperintMax. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericSuperintMax. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericSuperintMax_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericSuperintMax(), "TYPE_OF_NUMERIC_SUPERINT_MAX", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param typeOfNumericSuperintMaxList The collection of typeOfNumericSuperintMax as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericSuperintMax_InScope(Collection<java.math.BigDecimal> typeOfNumericSuperintMaxList) {
        doSetTypeOfNumericSuperintMax_InScope(typeOfNumericSuperintMaxList);
    }

    protected void doSetTypeOfNumericSuperintMax_InScope(Collection<java.math.BigDecimal> typeOfNumericSuperintMaxList) {
        regINS(CK_INS, cTL(typeOfNumericSuperintMaxList), getCValueTypeOfNumericSuperintMax(), "TYPE_OF_NUMERIC_SUPERINT_MAX");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @param typeOfNumericSuperintMaxList The collection of typeOfNumericSuperintMax as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericSuperintMax_NotInScope(Collection<java.math.BigDecimal> typeOfNumericSuperintMaxList) {
        doSetTypeOfNumericSuperintMax_NotInScope(typeOfNumericSuperintMaxList);
    }

    protected void doSetTypeOfNumericSuperintMax_NotInScope(Collection<java.math.BigDecimal> typeOfNumericSuperintMaxList) {
        regINS(CK_NINS, cTL(typeOfNumericSuperintMaxList), getCValueTypeOfNumericSuperintMax(), "TYPE_OF_NUMERIC_SUPERINT_MAX");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     */
    public void setTypeOfNumericSuperintMax_IsNull() { regTypeOfNumericSuperintMax(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     */
    public void setTypeOfNumericSuperintMax_IsNotNull() { regTypeOfNumericSuperintMax(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericSuperintMax(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericSuperintMax(), "TYPE_OF_NUMERIC_SUPERINT_MAX"); }
    protected abstract ConditionValue getCValueTypeOfNumericSuperintMax();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param typeOfNumericMaxdecimal The value of typeOfNumericMaxdecimal as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericMaxdecimal_Equal(java.math.BigDecimal typeOfNumericMaxdecimal) {
        doSetTypeOfNumericMaxdecimal_Equal(typeOfNumericMaxdecimal);
    }

    protected void doSetTypeOfNumericMaxdecimal_Equal(java.math.BigDecimal typeOfNumericMaxdecimal) {
        regTypeOfNumericMaxdecimal(CK_EQ, typeOfNumericMaxdecimal);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param typeOfNumericMaxdecimal The value of typeOfNumericMaxdecimal as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericMaxdecimal_NotEqual(java.math.BigDecimal typeOfNumericMaxdecimal) {
        doSetTypeOfNumericMaxdecimal_NotEqual(typeOfNumericMaxdecimal);
    }

    protected void doSetTypeOfNumericMaxdecimal_NotEqual(java.math.BigDecimal typeOfNumericMaxdecimal) {
        regTypeOfNumericMaxdecimal(CK_NES, typeOfNumericMaxdecimal);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param typeOfNumericMaxdecimal The value of typeOfNumericMaxdecimal as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericMaxdecimal_GreaterThan(java.math.BigDecimal typeOfNumericMaxdecimal) {
        regTypeOfNumericMaxdecimal(CK_GT, typeOfNumericMaxdecimal);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param typeOfNumericMaxdecimal The value of typeOfNumericMaxdecimal as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericMaxdecimal_LessThan(java.math.BigDecimal typeOfNumericMaxdecimal) {
        regTypeOfNumericMaxdecimal(CK_LT, typeOfNumericMaxdecimal);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param typeOfNumericMaxdecimal The value of typeOfNumericMaxdecimal as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericMaxdecimal_GreaterEqual(java.math.BigDecimal typeOfNumericMaxdecimal) {
        regTypeOfNumericMaxdecimal(CK_GE, typeOfNumericMaxdecimal);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param typeOfNumericMaxdecimal The value of typeOfNumericMaxdecimal as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTypeOfNumericMaxdecimal_LessEqual(java.math.BigDecimal typeOfNumericMaxdecimal) {
        regTypeOfNumericMaxdecimal(CK_LE, typeOfNumericMaxdecimal);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param minNumber The min number of typeOfNumericMaxdecimal. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of typeOfNumericMaxdecimal. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTypeOfNumericMaxdecimal_RangeOf(java.math.BigDecimal minNumber, java.math.BigDecimal maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTypeOfNumericMaxdecimal(), "TYPE_OF_NUMERIC_MAXDECIMAL", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param typeOfNumericMaxdecimalList The collection of typeOfNumericMaxdecimal as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericMaxdecimal_InScope(Collection<java.math.BigDecimal> typeOfNumericMaxdecimalList) {
        doSetTypeOfNumericMaxdecimal_InScope(typeOfNumericMaxdecimalList);
    }

    protected void doSetTypeOfNumericMaxdecimal_InScope(Collection<java.math.BigDecimal> typeOfNumericMaxdecimalList) {
        regINS(CK_INS, cTL(typeOfNumericMaxdecimalList), getCValueTypeOfNumericMaxdecimal(), "TYPE_OF_NUMERIC_MAXDECIMAL");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @param typeOfNumericMaxdecimalList The collection of typeOfNumericMaxdecimal as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTypeOfNumericMaxdecimal_NotInScope(Collection<java.math.BigDecimal> typeOfNumericMaxdecimalList) {
        doSetTypeOfNumericMaxdecimal_NotInScope(typeOfNumericMaxdecimalList);
    }

    protected void doSetTypeOfNumericMaxdecimal_NotInScope(Collection<java.math.BigDecimal> typeOfNumericMaxdecimalList) {
        regINS(CK_NINS, cTL(typeOfNumericMaxdecimalList), getCValueTypeOfNumericMaxdecimal(), "TYPE_OF_NUMERIC_MAXDECIMAL");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     */
    public void setTypeOfNumericMaxdecimal_IsNull() { regTypeOfNumericMaxdecimal(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     */
    public void setTypeOfNumericMaxdecimal_IsNotNull() { regTypeOfNumericMaxdecimal(CK_ISNN, DOBJ); }

    protected void regTypeOfNumericMaxdecimal(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfNumericMaxdecimal(), "TYPE_OF_NUMERIC_MAXDECIMAL"); }
    protected abstract ConditionValue getCValueTypeOfNumericMaxdecimal();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TYPE_OF_BOOLEAN: {BOOLEAN(1)}
     * @param typeOfBoolean The value of typeOfBoolean as equal. (NullAllowed: if null, no condition)
     */
    public void setTypeOfBoolean_Equal(Boolean typeOfBoolean) {
        regTypeOfBoolean(CK_EQ, typeOfBoolean);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_BOOLEAN: {BOOLEAN(1)}
     */
    public void setTypeOfBoolean_IsNull() { regTypeOfBoolean(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_BOOLEAN: {BOOLEAN(1)}
     */
    public void setTypeOfBoolean_IsNotNull() { regTypeOfBoolean(CK_ISNN, DOBJ); }

    protected void regTypeOfBoolean(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfBoolean(), "TYPE_OF_BOOLEAN"); }
    protected abstract ConditionValue getCValueTypeOfBoolean();

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_BLOB: {BLOB(2147483647)}
     */
    public void setTypeOfBlob_IsNull() { regTypeOfBlob(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TYPE_OF_BLOB: {BLOB(2147483647)}
     */
    public void setTypeOfBlob_IsNotNull() { regTypeOfBlob(CK_ISNN, DOBJ); }

    protected void regTypeOfBlob(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTypeOfBlob(), "TYPE_OF_BLOB"); }
    protected abstract ConditionValue getCValueTypeOfBlob();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     * @param uYText The value of uYText as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUYText_Equal(String uYText) {
        doSetUYText_Equal(fRES(uYText));
    }

    protected void doSetUYText_Equal(String uYText) {
        regUYText(CK_EQ, uYText);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     * @param uYText The value of uYText as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUYText_NotEqual(String uYText) {
        doSetUYText_NotEqual(fRES(uYText));
    }

    protected void doSetUYText_NotEqual(String uYText) {
        regUYText(CK_NES, uYText);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     * @param uYTextList The collection of uYText as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUYText_InScope(Collection<String> uYTextList) {
        doSetUYText_InScope(uYTextList);
    }

    public void doSetUYText_InScope(Collection<String> uYTextList) {
        regINS(CK_INS, cTL(uYTextList), getCValueUYText(), "U_Y_TEXT");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     * @param uYTextList The collection of uYText as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUYText_NotInScope(Collection<String> uYTextList) {
        doSetUYText_NotInScope(uYTextList);
    }

    public void doSetUYText_NotInScope(Collection<String> uYTextList) {
        regINS(CK_NINS, cTL(uYTextList), getCValueUYText(), "U_Y_TEXT");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     * @param uYText The value of uYText as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setUYText_PrefixSearch(String uYText) {
        setUYText_LikeSearch(uYText, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)} <br />
     * <pre>e.g. setUYText_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param uYText The value of uYText as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setUYText_LikeSearch(String uYText, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(uYText), getCValueUYText(), "U_Y_TEXT", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     * @param uYText The value of uYText as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setUYText_NotLikeSearch(String uYText, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(uYText), getCValueUYText(), "U_Y_TEXT", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     */
    public void setUYText_IsNull() { regUYText(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     */
    public void setUYText_IsNullOrEmpty() { regUYText(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     */
    public void setUYText_IsNotNull() { regUYText(CK_ISNN, DOBJ); }

    protected void regUYText(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUYText(), "U_Y_TEXT"); }
    protected abstract ConditionValue getCValueUYText();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_Equal()</span>.max(new SubQuery&lt;VendorCheckCB&gt;() {
     *     public void query(VendorCheckCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorCheckCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand(), VendorCheckCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;VendorCheckCB&gt;() {
     *     public void query(VendorCheckCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorCheckCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand(), VendorCheckCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;VendorCheckCB&gt;() {
     *     public void query(VendorCheckCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorCheckCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand(), VendorCheckCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessThan()</span>.max(new SubQuery&lt;VendorCheckCB&gt;() {
     *     public void query(VendorCheckCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorCheckCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand(), VendorCheckCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;VendorCheckCB&gt;() {
     *     public void query(VendorCheckCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorCheckCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand(), VendorCheckCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VendorCheckCB&gt;() {
     *     public void query(VendorCheckCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorCheckCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand(), VendorCheckCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        VendorCheckCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(VendorCheckCQ sq);

    protected VendorCheckCB xcreateScalarConditionCB() {
        VendorCheckCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VendorCheckCB xcreateScalarConditionPartitionByCB() {
        VendorCheckCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<VendorCheckCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VendorCheckCB cb = new VendorCheckCB(); cb.xsetupForDerivedReferrer(this); sq.query(cb);
        String pk = "VENDOR_CHECK_ID";
        String pp = keepSpecifyMyselfDerived(cb.query()); // for saving query-value.
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(VendorCheckCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VendorCheckCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(VendorCheckCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VendorCheckCB cb = new VendorCheckCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "VENDOR_CHECK_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(VendorCheckCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(SubQuery<VendorCheckCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        VendorCheckCB cb = new VendorCheckCB(); cb.xsetupForMyselfExists(this); subQuery.query(cb);
        String pp = keepMyselfExists(cb.query()); // for saving query-value.
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(VendorCheckCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(SubQuery<VendorCheckCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        VendorCheckCB cb = new VendorCheckCB(); cb.xsetupForMyselfInScope(this); subQuery.query(cb);
        String pp = keepMyselfInScope(cb.query()); // for saving query-value.
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(VendorCheckCQ sq);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected VendorCheckCB newMyCB() {
        return new VendorCheckCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return VendorCheckCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
