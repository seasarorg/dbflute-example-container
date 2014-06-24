/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.cq.bs;

import java.util.Map;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import com.example.dbflute.cdi.dbflute.cbean.cq.ciq.*;
import com.example.dbflute.cdi.dbflute.cbean.*;
import com.example.dbflute.cdi.dbflute.cbean.cq.*;

/**
 * The base condition-query of VENDOR_CHECK.
 * @author DBFlute(AutoGenerator)
 */
public class BsVendorCheckCQ extends AbstractBsVendorCheckCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected VendorCheckCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVendorCheckCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from VENDOR_CHECK) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public VendorCheckCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected VendorCheckCIQ xcreateCIQ() {
        VendorCheckCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected VendorCheckCIQ xnewCIQ() {
        return new VendorCheckCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join VENDOR_CHECK on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public VendorCheckCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        VendorCheckCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _vendorCheckId;
    public ConditionValue getVendorCheckId()
    { if (_vendorCheckId == null) { _vendorCheckId = nCV(); }
      return _vendorCheckId; }
    protected ConditionValue getCValueVendorCheckId() { return getVendorCheckId(); }

    /** 
     * Add order-by as ascend. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_VendorCheckId_Asc() { regOBA("VENDOR_CHECK_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * VENDOR_CHECK_ID: {PK, NotNull, DECIMAL(16)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_VendorCheckId_Desc() { regOBD("VENDOR_CHECK_ID"); return this; }

    protected ConditionValue _typeOfChar;
    public ConditionValue getTypeOfChar()
    { if (_typeOfChar == null) { _typeOfChar = nCV(); }
      return _typeOfChar; }
    protected ConditionValue getCValueTypeOfChar() { return getTypeOfChar(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfChar_Asc() { regOBA("TYPE_OF_CHAR"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_CHAR: {CHAR(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfChar_Desc() { regOBD("TYPE_OF_CHAR"); return this; }

    protected ConditionValue _typeOfVarchar;
    public ConditionValue getTypeOfVarchar()
    { if (_typeOfVarchar == null) { _typeOfVarchar = nCV(); }
      return _typeOfVarchar; }
    protected ConditionValue getCValueTypeOfVarchar() { return getTypeOfVarchar(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfVarchar_Asc() { regOBA("TYPE_OF_VARCHAR"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_VARCHAR: {VARCHAR(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfVarchar_Desc() { regOBD("TYPE_OF_VARCHAR"); return this; }

    protected ConditionValue _typeOfText;
    public ConditionValue getTypeOfText()
    { if (_typeOfText == null) { _typeOfText = nCV(); }
      return _typeOfText; }
    protected ConditionValue getCValueTypeOfText() { return getTypeOfText(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfText_Asc() { regOBA("TYPE_OF_TEXT"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_TEXT: {CLOB(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfText_Desc() { regOBD("TYPE_OF_TEXT"); return this; }

    protected ConditionValue _typeOfNumericInteger;
    public ConditionValue getTypeOfNumericInteger()
    { if (_typeOfNumericInteger == null) { _typeOfNumericInteger = nCV(); }
      return _typeOfNumericInteger; }
    protected ConditionValue getCValueTypeOfNumericInteger() { return getTypeOfNumericInteger(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericInteger_Asc() { regOBA("TYPE_OF_NUMERIC_INTEGER"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_INTEGER: {DECIMAL(5)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericInteger_Desc() { regOBD("TYPE_OF_NUMERIC_INTEGER"); return this; }

    protected ConditionValue _typeOfNumericBigint;
    public ConditionValue getTypeOfNumericBigint()
    { if (_typeOfNumericBigint == null) { _typeOfNumericBigint = nCV(); }
      return _typeOfNumericBigint; }
    protected ConditionValue getCValueTypeOfNumericBigint() { return getTypeOfNumericBigint(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericBigint_Asc() { regOBA("TYPE_OF_NUMERIC_BIGINT"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_BIGINT: {DECIMAL(12)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericBigint_Desc() { regOBD("TYPE_OF_NUMERIC_BIGINT"); return this; }

    protected ConditionValue _typeOfNumericDecimal;
    public ConditionValue getTypeOfNumericDecimal()
    { if (_typeOfNumericDecimal == null) { _typeOfNumericDecimal = nCV(); }
      return _typeOfNumericDecimal; }
    protected ConditionValue getCValueTypeOfNumericDecimal() { return getTypeOfNumericDecimal(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericDecimal_Asc() { regOBA("TYPE_OF_NUMERIC_DECIMAL"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_DECIMAL: {DECIMAL(5, 3)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericDecimal_Desc() { regOBD("TYPE_OF_NUMERIC_DECIMAL"); return this; }

    protected ConditionValue _typeOfNumericIntegerMin;
    public ConditionValue getTypeOfNumericIntegerMin()
    { if (_typeOfNumericIntegerMin == null) { _typeOfNumericIntegerMin = nCV(); }
      return _typeOfNumericIntegerMin; }
    protected ConditionValue getCValueTypeOfNumericIntegerMin() { return getTypeOfNumericIntegerMin(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericIntegerMin_Asc() { regOBA("TYPE_OF_NUMERIC_INTEGER_MIN"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_INTEGER_MIN: {DECIMAL(1)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericIntegerMin_Desc() { regOBD("TYPE_OF_NUMERIC_INTEGER_MIN"); return this; }

    protected ConditionValue _typeOfNumericIntegerMax;
    public ConditionValue getTypeOfNumericIntegerMax()
    { if (_typeOfNumericIntegerMax == null) { _typeOfNumericIntegerMax = nCV(); }
      return _typeOfNumericIntegerMax; }
    protected ConditionValue getCValueTypeOfNumericIntegerMax() { return getTypeOfNumericIntegerMax(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericIntegerMax_Asc() { regOBA("TYPE_OF_NUMERIC_INTEGER_MAX"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_INTEGER_MAX: {DECIMAL(9)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericIntegerMax_Desc() { regOBD("TYPE_OF_NUMERIC_INTEGER_MAX"); return this; }

    protected ConditionValue _typeOfNumericBigintMin;
    public ConditionValue getTypeOfNumericBigintMin()
    { if (_typeOfNumericBigintMin == null) { _typeOfNumericBigintMin = nCV(); }
      return _typeOfNumericBigintMin; }
    protected ConditionValue getCValueTypeOfNumericBigintMin() { return getTypeOfNumericBigintMin(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericBigintMin_Asc() { regOBA("TYPE_OF_NUMERIC_BIGINT_MIN"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_BIGINT_MIN: {DECIMAL(10)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericBigintMin_Desc() { regOBD("TYPE_OF_NUMERIC_BIGINT_MIN"); return this; }

    protected ConditionValue _typeOfNumericBigintMax;
    public ConditionValue getTypeOfNumericBigintMax()
    { if (_typeOfNumericBigintMax == null) { _typeOfNumericBigintMax = nCV(); }
      return _typeOfNumericBigintMax; }
    protected ConditionValue getCValueTypeOfNumericBigintMax() { return getTypeOfNumericBigintMax(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericBigintMax_Asc() { regOBA("TYPE_OF_NUMERIC_BIGINT_MAX"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_BIGINT_MAX: {DECIMAL(18)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericBigintMax_Desc() { regOBD("TYPE_OF_NUMERIC_BIGINT_MAX"); return this; }

    protected ConditionValue _typeOfNumericSuperintMin;
    public ConditionValue getTypeOfNumericSuperintMin()
    { if (_typeOfNumericSuperintMin == null) { _typeOfNumericSuperintMin = nCV(); }
      return _typeOfNumericSuperintMin; }
    protected ConditionValue getCValueTypeOfNumericSuperintMin() { return getTypeOfNumericSuperintMin(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericSuperintMin_Asc() { regOBA("TYPE_OF_NUMERIC_SUPERINT_MIN"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MIN: {DECIMAL(19)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericSuperintMin_Desc() { regOBD("TYPE_OF_NUMERIC_SUPERINT_MIN"); return this; }

    protected ConditionValue _typeOfNumericSuperintMax;
    public ConditionValue getTypeOfNumericSuperintMax()
    { if (_typeOfNumericSuperintMax == null) { _typeOfNumericSuperintMax = nCV(); }
      return _typeOfNumericSuperintMax; }
    protected ConditionValue getCValueTypeOfNumericSuperintMax() { return getTypeOfNumericSuperintMax(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericSuperintMax_Asc() { regOBA("TYPE_OF_NUMERIC_SUPERINT_MAX"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_SUPERINT_MAX: {DECIMAL(38)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericSuperintMax_Desc() { regOBD("TYPE_OF_NUMERIC_SUPERINT_MAX"); return this; }

    protected ConditionValue _typeOfNumericMaxdecimal;
    public ConditionValue getTypeOfNumericMaxdecimal()
    { if (_typeOfNumericMaxdecimal == null) { _typeOfNumericMaxdecimal = nCV(); }
      return _typeOfNumericMaxdecimal; }
    protected ConditionValue getCValueTypeOfNumericMaxdecimal() { return getTypeOfNumericMaxdecimal(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericMaxdecimal_Asc() { regOBA("TYPE_OF_NUMERIC_MAXDECIMAL"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_NUMERIC_MAXDECIMAL: {DECIMAL(38, 38)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfNumericMaxdecimal_Desc() { regOBD("TYPE_OF_NUMERIC_MAXDECIMAL"); return this; }

    protected ConditionValue _typeOfBoolean;
    public ConditionValue getTypeOfBoolean()
    { if (_typeOfBoolean == null) { _typeOfBoolean = nCV(); }
      return _typeOfBoolean; }
    protected ConditionValue getCValueTypeOfBoolean() { return getTypeOfBoolean(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_BOOLEAN: {BOOLEAN(1)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfBoolean_Asc() { regOBA("TYPE_OF_BOOLEAN"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_BOOLEAN: {BOOLEAN(1)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfBoolean_Desc() { regOBD("TYPE_OF_BOOLEAN"); return this; }

    protected ConditionValue _typeOfBlob;
    public ConditionValue getTypeOfBlob()
    { if (_typeOfBlob == null) { _typeOfBlob = nCV(); }
      return _typeOfBlob; }
    protected ConditionValue getCValueTypeOfBlob() { return getTypeOfBlob(); }

    /** 
     * Add order-by as ascend. <br />
     * TYPE_OF_BLOB: {BLOB(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfBlob_Asc() { regOBA("TYPE_OF_BLOB"); return this; }

    /**
     * Add order-by as descend. <br />
     * TYPE_OF_BLOB: {BLOB(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_TypeOfBlob_Desc() { regOBD("TYPE_OF_BLOB"); return this; }

    protected ConditionValue _uYText;
    public ConditionValue getUYText()
    { if (_uYText == null) { _uYText = nCV(); }
      return _uYText; }
    protected ConditionValue getCValueUYText() { return getUYText(); }

    /** 
     * Add order-by as ascend. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_UYText_Asc() { regOBA("U_Y_TEXT"); return this; }

    /**
     * Add order-by as descend. <br />
     * U_Y_TEXT: {CLOB(2147483647)}
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addOrderBy_UYText_Desc() { regOBD("U_Y_TEXT"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #DD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #DD4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #DD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #DD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #DD4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #DD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsVendorCheckCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, VendorCheckCQ> getScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(VendorCheckCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, VendorCheckCQ> getSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(VendorCheckCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, VendorCheckCQ> getQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(VendorCheckCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> getQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, VendorCheckCQ> _myselfExistsMap;
    public Map<String, VendorCheckCQ> getMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(VendorCheckCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, VendorCheckCQ> getMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(VendorCheckCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return VendorCheckCB.class.getName(); }
    protected String xCQ() { return VendorCheckCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
