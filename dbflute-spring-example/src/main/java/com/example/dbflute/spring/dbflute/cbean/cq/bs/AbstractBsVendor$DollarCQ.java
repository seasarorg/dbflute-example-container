/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.spring.dbflute.cbean.cq.bs;

import java.util.*;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import com.example.dbflute.spring.dbflute.allcommon.*;
import com.example.dbflute.spring.dbflute.cbean.*;
import com.example.dbflute.spring.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of VENDOR_$_DOLLAR.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVendor$DollarCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVendor$DollarCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "VENDOR_$_DOLLAR";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param vendor$DollarId The value of vendor$DollarId as equal. (NullAllowed: if null, no condition)
     */
    public void setVendor$DollarId_Equal(Integer vendor$DollarId) {
        doSetVendor$DollarId_Equal(vendor$DollarId);
    }

    protected void doSetVendor$DollarId_Equal(Integer vendor$DollarId) {
        regVendor$DollarId(CK_EQ, vendor$DollarId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param vendor$DollarId The value of vendor$DollarId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setVendor$DollarId_NotEqual(Integer vendor$DollarId) {
        doSetVendor$DollarId_NotEqual(vendor$DollarId);
    }

    protected void doSetVendor$DollarId_NotEqual(Integer vendor$DollarId) {
        regVendor$DollarId(CK_NES, vendor$DollarId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param vendor$DollarId The value of vendor$DollarId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setVendor$DollarId_GreaterThan(Integer vendor$DollarId) {
        regVendor$DollarId(CK_GT, vendor$DollarId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param vendor$DollarId The value of vendor$DollarId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setVendor$DollarId_LessThan(Integer vendor$DollarId) {
        regVendor$DollarId(CK_LT, vendor$DollarId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param vendor$DollarId The value of vendor$DollarId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setVendor$DollarId_GreaterEqual(Integer vendor$DollarId) {
        regVendor$DollarId(CK_GE, vendor$DollarId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param vendor$DollarId The value of vendor$DollarId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setVendor$DollarId_LessEqual(Integer vendor$DollarId) {
        regVendor$DollarId(CK_LE, vendor$DollarId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param minNumber The min number of vendor$DollarId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of vendor$DollarId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setVendor$DollarId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueVendor$DollarId(), "VENDOR_$_DOLLAR_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param vendor$DollarIdList The collection of vendor$DollarId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarId_InScope(Collection<Integer> vendor$DollarIdList) {
        doSetVendor$DollarId_InScope(vendor$DollarIdList);
    }

    protected void doSetVendor$DollarId_InScope(Collection<Integer> vendor$DollarIdList) {
        regINS(CK_INS, cTL(vendor$DollarIdList), getCValueVendor$DollarId(), "VENDOR_$_DOLLAR_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     * @param vendor$DollarIdList The collection of vendor$DollarId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarId_NotInScope(Collection<Integer> vendor$DollarIdList) {
        doSetVendor$DollarId_NotInScope(vendor$DollarIdList);
    }

    protected void doSetVendor$DollarId_NotInScope(Collection<Integer> vendor$DollarIdList) {
        regINS(CK_NINS, cTL(vendor$DollarIdList), getCValueVendor$DollarId(), "VENDOR_$_DOLLAR_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     */
    public void setVendor$DollarId_IsNull() { regVendor$DollarId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_ID: {PK, NotNull, INTEGER(10)}
     */
    public void setVendor$DollarId_IsNotNull() { regVendor$DollarId(CK_ISNN, DOBJ); }

    protected void regVendor$DollarId(ConditionKey k, Object v) { regQ(k, v, getCValueVendor$DollarId(), "VENDOR_$_DOLLAR_ID"); }
    abstract protected ConditionValue getCValueVendor$DollarId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarName The value of vendor$DollarName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_Equal(String vendor$DollarName) {
        doSetVendor$DollarName_Equal(fRES(vendor$DollarName));
    }

    protected void doSetVendor$DollarName_Equal(String vendor$DollarName) {
        regVendor$DollarName(CK_EQ, vendor$DollarName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarName The value of vendor$DollarName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_NotEqual(String vendor$DollarName) {
        doSetVendor$DollarName_NotEqual(fRES(vendor$DollarName));
    }

    protected void doSetVendor$DollarName_NotEqual(String vendor$DollarName) {
        regVendor$DollarName(CK_NES, vendor$DollarName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarName The value of vendor$DollarName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_GreaterThan(String vendor$DollarName) {
        regVendor$DollarName(CK_GT, fRES(vendor$DollarName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarName The value of vendor$DollarName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_LessThan(String vendor$DollarName) {
        regVendor$DollarName(CK_LT, fRES(vendor$DollarName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarName The value of vendor$DollarName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_GreaterEqual(String vendor$DollarName) {
        regVendor$DollarName(CK_GE, fRES(vendor$DollarName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarName The value of vendor$DollarName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_LessEqual(String vendor$DollarName) {
        regVendor$DollarName(CK_LE, fRES(vendor$DollarName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarNameList The collection of vendor$DollarName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_InScope(Collection<String> vendor$DollarNameList) {
        doSetVendor$DollarName_InScope(vendor$DollarNameList);
    }

    public void doSetVendor$DollarName_InScope(Collection<String> vendor$DollarNameList) {
        regINS(CK_INS, cTL(vendor$DollarNameList), getCValueVendor$DollarName(), "VENDOR_$_DOLLAR_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarNameList The collection of vendor$DollarName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_NotInScope(Collection<String> vendor$DollarNameList) {
        doSetVendor$DollarName_NotInScope(vendor$DollarNameList);
    }

    public void doSetVendor$DollarName_NotInScope(Collection<String> vendor$DollarNameList) {
        regINS(CK_NINS, cTL(vendor$DollarNameList), getCValueVendor$DollarName(), "VENDOR_$_DOLLAR_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarName The value of vendor$DollarName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setVendor$DollarName_PrefixSearch(String vendor$DollarName) {
        setVendor$DollarName_LikeSearch(vendor$DollarName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)} <br />
     * <pre>e.g. setVendor$DollarName_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param vendor$DollarName The value of vendor$DollarName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setVendor$DollarName_LikeSearch(String vendor$DollarName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(vendor$DollarName), getCValueVendor$DollarName(), "VENDOR_$_DOLLAR_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     * @param vendor$DollarName The value of vendor$DollarName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setVendor$DollarName_NotLikeSearch(String vendor$DollarName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(vendor$DollarName), getCValueVendor$DollarName(), "VENDOR_$_DOLLAR_NAME", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     */
    public void setVendor$DollarName_IsNull() { regVendor$DollarName(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     */
    public void setVendor$DollarName_IsNullOrEmpty() { regVendor$DollarName(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * VENDOR_$_DOLLAR_NAME: {VARCHAR(32)}
     */
    public void setVendor$DollarName_IsNotNull() { regVendor$DollarName(CK_ISNN, DOBJ); }

    protected void regVendor$DollarName(ConditionKey k, Object v) { regQ(k, v, getCValueVendor$DollarName(), "VENDOR_$_DOLLAR_NAME"); }
    abstract protected ConditionValue getCValueVendor$DollarName();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_Equal()</span>.max(new SubQuery&lt;Vendor$DollarCB&gt;() {
     *     public void query(Vendor$DollarCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<Vendor$DollarCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand());
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;Vendor$DollarCB&gt;() {
     *     public void query(Vendor$DollarCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<Vendor$DollarCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;Vendor$DollarCB&gt;() {
     *     public void query(Vendor$DollarCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<Vendor$DollarCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessThan()</span>.max(new SubQuery&lt;Vendor$DollarCB&gt;() {
     *     public void query(Vendor$DollarCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<Vendor$DollarCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;Vendor$DollarCB&gt;() {
     *     public void query(Vendor$DollarCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<Vendor$DollarCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;Vendor$DollarCB&gt;() {
     *     public void query(Vendor$DollarCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<Vendor$DollarCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand());
    }

    protected HpSSQFunction<Vendor$DollarCB> xcreateSSQFunction(final String operand) {
        return new HpSSQFunction<Vendor$DollarCB>(new HpSSQSetupper<Vendor$DollarCB>() {
            public void setup(String function, SubQuery<Vendor$DollarCB> subQuery, HpSSQOption<Vendor$DollarCB> option) {
                xscalarCondition(function, subQuery, operand, option);
            }
        });
    }

    protected void xscalarCondition(String function, SubQuery<Vendor$DollarCB> subQuery, String operand, HpSSQOption<Vendor$DollarCB> option) {
        assertObjectNotNull("subQuery<Vendor$DollarCB>", subQuery);
        Vendor$DollarCB cb = xcreateScalarConditionCB(); subQuery.query(cb);
        String subQueryPropertyName = keepScalarCondition(cb.query()); // for saving query-value
        option.setPartitionByCBean(xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(function, cb.query(), subQueryPropertyName, operand, option);
    }
    public abstract String keepScalarCondition(Vendor$DollarCQ subQuery);

    protected Vendor$DollarCB xcreateScalarConditionCB() {
        Vendor$DollarCB cb = new Vendor$DollarCB();
        cb.xsetupForScalarCondition(this);
        return cb;
    }

    protected Vendor$DollarCB xcreateScalarConditionPartitionByCB() {
        Vendor$DollarCB cb = new Vendor$DollarCB();
        cb.xsetupForScalarConditionPartitionBy(this);
        return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String function, SubQuery<Vendor$DollarCB> subQuery, String aliasName, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<Vendor$DollarCB>", subQuery);
        Vendor$DollarCB cb = new Vendor$DollarCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepSpecifyMyselfDerived(cb.query()); // for saving query-value.
        registerSpecifyMyselfDerived(function, cb.query(), "VENDOR_$_DOLLAR_ID", "VENDOR_$_DOLLAR_ID", subQueryPropertyName, "myselfDerived", aliasName, option);
    }
    public abstract String keepSpecifyMyselfDerived(Vendor$DollarCQ subQuery);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<Vendor$DollarCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived();
    }
    protected HpQDRFunction<Vendor$DollarCB> xcreateQDRFunctionMyselfDerived() {
        return new HpQDRFunction<Vendor$DollarCB>(new HpQDRSetupper<Vendor$DollarCB>() {
            public void setup(String function, SubQuery<Vendor$DollarCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
                xqderiveMyselfDerived(function, subQuery, operand, value, option);
            }
        });
    }
    public void xqderiveMyselfDerived(String function, SubQuery<Vendor$DollarCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<Vendor$DollarCB>", subQuery);
        Vendor$DollarCB cb = new Vendor$DollarCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String parameterPropertyName = keepQueryMyselfDerivedParameter(value);
        registerQueryMyselfDerived(function, cb.query(), "VENDOR_$_DOLLAR_ID", "VENDOR_$_DOLLAR_ID", subQueryPropertyName, "myselfDerived", operand, value, parameterPropertyName, option);
    }
    public abstract String keepQueryMyselfDerived(Vendor$DollarCQ subQuery);
    public abstract String keepQueryMyselfDerivedParameter(Object parameterValue);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(SubQuery<Vendor$DollarCB> subQuery) {
        assertObjectNotNull("subQuery<Vendor$DollarCB>", subQuery);
        Vendor$DollarCB cb = new Vendor$DollarCB(); cb.xsetupForMyselfExists(this); subQuery.query(cb);
        String subQueryPropertyName = keepMyselfExists(cb.query()); // for saving query-value.
        registerMyselfExists(cb.query(), subQueryPropertyName);
    }
    public abstract String keepMyselfExists(Vendor$DollarCQ subQuery);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(SubQuery<Vendor$DollarCB> subQuery) {
        assertObjectNotNull("subQuery<Vendor$DollarCB>", subQuery);
        Vendor$DollarCB cb = new Vendor$DollarCB(); cb.xsetupForMyselfInScope(this); subQuery.query(cb);
        String subQueryPropertyName = keepMyselfInScope(cb.query()); // for saving query-value.
        registerMyselfInScope(cb.query(), subQueryPropertyName);
    }
    public abstract String keepMyselfInScope(Vendor$DollarCQ subQuery);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCB() { return Vendor$DollarCB.class.getName(); }
    protected String xabCQ() { return Vendor$DollarCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
