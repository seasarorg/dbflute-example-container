/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
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
 * The abstract condition-query of VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVendorTheLongAndWindingTableAndColumnCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVendorTheLongAndWindingTableAndColumnCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param theLongAndWindingTableAndColumnId The value of theLongAndWindingTableAndColumnId as equal. (NullAllowed: if null, no condition)
     */
    public void setTheLongAndWindingTableAndColumnId_Equal(Long theLongAndWindingTableAndColumnId) {
        doSetTheLongAndWindingTableAndColumnId_Equal(theLongAndWindingTableAndColumnId);
    }

    protected void doSetTheLongAndWindingTableAndColumnId_Equal(Long theLongAndWindingTableAndColumnId) {
        regTheLongAndWindingTableAndColumnId(CK_EQ, theLongAndWindingTableAndColumnId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param theLongAndWindingTableAndColumnId The value of theLongAndWindingTableAndColumnId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTheLongAndWindingTableAndColumnId_NotEqual(Long theLongAndWindingTableAndColumnId) {
        doSetTheLongAndWindingTableAndColumnId_NotEqual(theLongAndWindingTableAndColumnId);
    }

    protected void doSetTheLongAndWindingTableAndColumnId_NotEqual(Long theLongAndWindingTableAndColumnId) {
        regTheLongAndWindingTableAndColumnId(CK_NES, theLongAndWindingTableAndColumnId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param theLongAndWindingTableAndColumnId The value of theLongAndWindingTableAndColumnId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTheLongAndWindingTableAndColumnId_GreaterThan(Long theLongAndWindingTableAndColumnId) {
        regTheLongAndWindingTableAndColumnId(CK_GT, theLongAndWindingTableAndColumnId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param theLongAndWindingTableAndColumnId The value of theLongAndWindingTableAndColumnId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTheLongAndWindingTableAndColumnId_LessThan(Long theLongAndWindingTableAndColumnId) {
        regTheLongAndWindingTableAndColumnId(CK_LT, theLongAndWindingTableAndColumnId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param theLongAndWindingTableAndColumnId The value of theLongAndWindingTableAndColumnId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTheLongAndWindingTableAndColumnId_GreaterEqual(Long theLongAndWindingTableAndColumnId) {
        regTheLongAndWindingTableAndColumnId(CK_GE, theLongAndWindingTableAndColumnId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param theLongAndWindingTableAndColumnId The value of theLongAndWindingTableAndColumnId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTheLongAndWindingTableAndColumnId_LessEqual(Long theLongAndWindingTableAndColumnId) {
        regTheLongAndWindingTableAndColumnId(CK_LE, theLongAndWindingTableAndColumnId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param minNumber The min number of theLongAndWindingTableAndColumnId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of theLongAndWindingTableAndColumnId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTheLongAndWindingTableAndColumnId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTheLongAndWindingTableAndColumnId(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param theLongAndWindingTableAndColumnIdList The collection of theLongAndWindingTableAndColumnId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnId_InScope(Collection<Long> theLongAndWindingTableAndColumnIdList) {
        doSetTheLongAndWindingTableAndColumnId_InScope(theLongAndWindingTableAndColumnIdList);
    }

    protected void doSetTheLongAndWindingTableAndColumnId_InScope(Collection<Long> theLongAndWindingTableAndColumnIdList) {
        regINS(CK_INS, cTL(theLongAndWindingTableAndColumnIdList), getCValueTheLongAndWindingTableAndColumnId(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     * @param theLongAndWindingTableAndColumnIdList The collection of theLongAndWindingTableAndColumnId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnId_NotInScope(Collection<Long> theLongAndWindingTableAndColumnIdList) {
        doSetTheLongAndWindingTableAndColumnId_NotInScope(theLongAndWindingTableAndColumnIdList);
    }

    protected void doSetTheLongAndWindingTableAndColumnId_NotInScope(Collection<Long> theLongAndWindingTableAndColumnIdList) {
        regINS(CK_NINS, cTL(theLongAndWindingTableAndColumnIdList), getCValueTheLongAndWindingTableAndColumnId(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID");
    }

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID from VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF where ...)} <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF by THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumnRefAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsVendorTheLongAndWindingTableAndColumnRefList</span>(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnRefCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnRefCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of VendorTheLongAndWindingTableAndColumnRefList for 'exists'. (NotNull)
     */
    public void existsVendorTheLongAndWindingTableAndColumnRefList(SubQuery<VendorTheLongAndWindingTableAndColumnRefCB> subQuery) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnRefCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnRefCB cb = new VendorTheLongAndWindingTableAndColumnRefCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepTheLongAndWindingTableAndColumnId_ExistsReferrer_VendorTheLongAndWindingTableAndColumnRefList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", subQueryPropertyName, "vendorTheLongAndWindingTableAndColumnRefList");
    }
    public abstract String keepTheLongAndWindingTableAndColumnId_ExistsReferrer_VendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumnRefCQ subQuery);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID from VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF where ...)} <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF by THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumnRefAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsVendorTheLongAndWindingTableAndColumnRefList</span>(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnRefCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnRefCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of TheLongAndWindingTableAndColumnId_NotExistsReferrer_VendorTheLongAndWindingTableAndColumnRefList for 'not exists'. (NotNull)
     */
    public void notExistsVendorTheLongAndWindingTableAndColumnRefList(SubQuery<VendorTheLongAndWindingTableAndColumnRefCB> subQuery) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnRefCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnRefCB cb = new VendorTheLongAndWindingTableAndColumnRefCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepTheLongAndWindingTableAndColumnId_NotExistsReferrer_VendorTheLongAndWindingTableAndColumnRefList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", subQueryPropertyName, "vendorTheLongAndWindingTableAndColumnRefList");
    }
    public abstract String keepTheLongAndWindingTableAndColumnId_NotExistsReferrer_VendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumnRefCQ subQuery);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID from VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF where ...)} <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF by THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumnRefAsOne'.
     * @param subQuery The sub-query of VendorTheLongAndWindingTableAndColumnRefList for 'in-scope'. (NotNull)
     */
    public void inScopeVendorTheLongAndWindingTableAndColumnRefList(SubQuery<VendorTheLongAndWindingTableAndColumnRefCB> subQuery) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnRefCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnRefCB cb = new VendorTheLongAndWindingTableAndColumnRefCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String subQueryPropertyName = keepTheLongAndWindingTableAndColumnId_InScopeRelation_VendorTheLongAndWindingTableAndColumnRefList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", subQueryPropertyName, "vendorTheLongAndWindingTableAndColumnRefList");
    }
    public abstract String keepTheLongAndWindingTableAndColumnId_InScopeRelation_VendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumnRefCQ subQuery);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID from VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF where ...)} <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF by THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumnRefAsOne'.
     * @param subQuery The sub-query of VendorTheLongAndWindingTableAndColumnRefList for 'not in-scope'. (NotNull)
     */
    public void notInScopeVendorTheLongAndWindingTableAndColumnRefList(SubQuery<VendorTheLongAndWindingTableAndColumnRefCB> subQuery) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnRefCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnRefCB cb = new VendorTheLongAndWindingTableAndColumnRefCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String subQueryPropertyName = keepTheLongAndWindingTableAndColumnId_NotInScopeRelation_VendorTheLongAndWindingTableAndColumnRefList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", subQueryPropertyName, "vendorTheLongAndWindingTableAndColumnRefList");
    }
    public abstract String keepTheLongAndWindingTableAndColumnId_NotInScopeRelation_VendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumnRefCQ subQuery);

    public void xsderiveVendorTheLongAndWindingTableAndColumnRefList(String function, SubQuery<VendorTheLongAndWindingTableAndColumnRefCB> subQuery, String aliasName, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnRefCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnRefCB cb = new VendorTheLongAndWindingTableAndColumnRefCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepTheLongAndWindingTableAndColumnId_SpecifyDerivedReferrer_VendorTheLongAndWindingTableAndColumnRefList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(function, cb.query(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", subQueryPropertyName, "vendorTheLongAndWindingTableAndColumnRefList", aliasName, option);
    }
    public abstract String keepTheLongAndWindingTableAndColumnId_SpecifyDerivedReferrer_VendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumnRefCQ subQuery);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF where ...)} <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF by THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumnRefAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">derivedVendorTheLongAndWindingTableAndColumnRefList()</span>.<span style="color: #FD4747">max</span>(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnRefCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnRefCB subCB) {
     *         subCB.specify().<span style="color: #FD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #FD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<VendorTheLongAndWindingTableAndColumnRefCB> derivedVendorTheLongAndWindingTableAndColumnRefList() {
        return xcreateQDRFunctionVendorTheLongAndWindingTableAndColumnRefList();
    }
    protected HpQDRFunction<VendorTheLongAndWindingTableAndColumnRefCB> xcreateQDRFunctionVendorTheLongAndWindingTableAndColumnRefList() {
        return new HpQDRFunction<VendorTheLongAndWindingTableAndColumnRefCB>(new HpQDRSetupper<VendorTheLongAndWindingTableAndColumnRefCB>() {
            public void setup(String function, SubQuery<VendorTheLongAndWindingTableAndColumnRefCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
                xqderiveVendorTheLongAndWindingTableAndColumnRefList(function, subQuery, operand, value, option);
            }
        });
    }
    public void xqderiveVendorTheLongAndWindingTableAndColumnRefList(String function, SubQuery<VendorTheLongAndWindingTableAndColumnRefCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnRefCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnRefCB cb = new VendorTheLongAndWindingTableAndColumnRefCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepTheLongAndWindingTableAndColumnId_QueryDerivedReferrer_VendorTheLongAndWindingTableAndColumnRefList(cb.query()); // for saving query-value.
        String parameterPropertyName = keepTheLongAndWindingTableAndColumnId_QueryDerivedReferrer_VendorTheLongAndWindingTableAndColumnRefListParameter(value);
        registerQueryDerivedReferrer(function, cb.query(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", subQueryPropertyName, "vendorTheLongAndWindingTableAndColumnRefList", operand, value, parameterPropertyName, option);
    }
    public abstract String keepTheLongAndWindingTableAndColumnId_QueryDerivedReferrer_VendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumnRefCQ subQuery);
    public abstract String keepTheLongAndWindingTableAndColumnId_QueryDerivedReferrer_VendorTheLongAndWindingTableAndColumnRefListParameter(Object parameterValue);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     */
    public void setTheLongAndWindingTableAndColumnId_IsNull() { regTheLongAndWindingTableAndColumnId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID: {PK, NotNull, BIGINT(19)}
     */
    public void setTheLongAndWindingTableAndColumnId_IsNotNull() { regTheLongAndWindingTableAndColumnId(CK_ISNN, DOBJ); }

    protected void regTheLongAndWindingTableAndColumnId(ConditionKey k, Object v) { regQ(k, v, getCValueTheLongAndWindingTableAndColumnId(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID"); }
    abstract protected ConditionValue getCValueTheLongAndWindingTableAndColumnId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_Equal(String theLongAndWindingTableAndColumnName) {
        doSetTheLongAndWindingTableAndColumnName_Equal(fRES(theLongAndWindingTableAndColumnName));
    }

    protected void doSetTheLongAndWindingTableAndColumnName_Equal(String theLongAndWindingTableAndColumnName) {
        regTheLongAndWindingTableAndColumnName(CK_EQ, theLongAndWindingTableAndColumnName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_NotEqual(String theLongAndWindingTableAndColumnName) {
        doSetTheLongAndWindingTableAndColumnName_NotEqual(fRES(theLongAndWindingTableAndColumnName));
    }

    protected void doSetTheLongAndWindingTableAndColumnName_NotEqual(String theLongAndWindingTableAndColumnName) {
        regTheLongAndWindingTableAndColumnName(CK_NES, theLongAndWindingTableAndColumnName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_GreaterThan(String theLongAndWindingTableAndColumnName) {
        regTheLongAndWindingTableAndColumnName(CK_GT, fRES(theLongAndWindingTableAndColumnName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_LessThan(String theLongAndWindingTableAndColumnName) {
        regTheLongAndWindingTableAndColumnName(CK_LT, fRES(theLongAndWindingTableAndColumnName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_GreaterEqual(String theLongAndWindingTableAndColumnName) {
        regTheLongAndWindingTableAndColumnName(CK_GE, fRES(theLongAndWindingTableAndColumnName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_LessEqual(String theLongAndWindingTableAndColumnName) {
        regTheLongAndWindingTableAndColumnName(CK_LE, fRES(theLongAndWindingTableAndColumnName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnNameList The collection of theLongAndWindingTableAndColumnName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_InScope(Collection<String> theLongAndWindingTableAndColumnNameList) {
        doSetTheLongAndWindingTableAndColumnName_InScope(theLongAndWindingTableAndColumnNameList);
    }

    public void doSetTheLongAndWindingTableAndColumnName_InScope(Collection<String> theLongAndWindingTableAndColumnNameList) {
        regINS(CK_INS, cTL(theLongAndWindingTableAndColumnNameList), getCValueTheLongAndWindingTableAndColumnName(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnNameList The collection of theLongAndWindingTableAndColumnName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_NotInScope(Collection<String> theLongAndWindingTableAndColumnNameList) {
        doSetTheLongAndWindingTableAndColumnName_NotInScope(theLongAndWindingTableAndColumnNameList);
    }

    public void doSetTheLongAndWindingTableAndColumnName_NotInScope(Collection<String> theLongAndWindingTableAndColumnNameList) {
        regINS(CK_NINS, cTL(theLongAndWindingTableAndColumnNameList), getCValueTheLongAndWindingTableAndColumnName(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setTheLongAndWindingTableAndColumnName_PrefixSearch(String theLongAndWindingTableAndColumnName) {
        setTheLongAndWindingTableAndColumnName_LikeSearch(theLongAndWindingTableAndColumnName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)} <br />
     * <pre>e.g. setTheLongAndWindingTableAndColumnName_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setTheLongAndWindingTableAndColumnName_LikeSearch(String theLongAndWindingTableAndColumnName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(theLongAndWindingTableAndColumnName), getCValueTheLongAndWindingTableAndColumnName(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME: {UQ, NotNull, VARCHAR(200)}
     * @param theLongAndWindingTableAndColumnName The value of theLongAndWindingTableAndColumnName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setTheLongAndWindingTableAndColumnName_NotLikeSearch(String theLongAndWindingTableAndColumnName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(theLongAndWindingTableAndColumnName), getCValueTheLongAndWindingTableAndColumnName(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME", likeSearchOption);
    }

    protected void regTheLongAndWindingTableAndColumnName(ConditionKey k, Object v) { regQ(k, v, getCValueTheLongAndWindingTableAndColumnName(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME"); }
    abstract protected ConditionValue getCValueTheLongAndWindingTableAndColumnName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortName The value of shortName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_Equal(String shortName) {
        doSetShortName_Equal(fRES(shortName));
    }

    protected void doSetShortName_Equal(String shortName) {
        regShortName(CK_EQ, shortName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortName The value of shortName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_NotEqual(String shortName) {
        doSetShortName_NotEqual(fRES(shortName));
    }

    protected void doSetShortName_NotEqual(String shortName) {
        regShortName(CK_NES, shortName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortName The value of shortName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_GreaterThan(String shortName) {
        regShortName(CK_GT, fRES(shortName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortName The value of shortName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_LessThan(String shortName) {
        regShortName(CK_LT, fRES(shortName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortName The value of shortName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_GreaterEqual(String shortName) {
        regShortName(CK_GE, fRES(shortName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortName The value of shortName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_LessEqual(String shortName) {
        regShortName(CK_LE, fRES(shortName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortNameList The collection of shortName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_InScope(Collection<String> shortNameList) {
        doSetShortName_InScope(shortNameList);
    }

    public void doSetShortName_InScope(Collection<String> shortNameList) {
        regINS(CK_INS, cTL(shortNameList), getCValueShortName(), "SHORT_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortNameList The collection of shortName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_NotInScope(Collection<String> shortNameList) {
        doSetShortName_NotInScope(shortNameList);
    }

    public void doSetShortName_NotInScope(Collection<String> shortNameList) {
        regINS(CK_NINS, cTL(shortNameList), getCValueShortName(), "SHORT_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortName The value of shortName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortName_PrefixSearch(String shortName) {
        setShortName_LikeSearch(shortName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)} <br />
     * <pre>e.g. setShortName_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param shortName The value of shortName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setShortName_LikeSearch(String shortName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(shortName), getCValueShortName(), "SHORT_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * SHORT_NAME: {NotNull, VARCHAR(200)}
     * @param shortName The value of shortName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setShortName_NotLikeSearch(String shortName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(shortName), getCValueShortName(), "SHORT_NAME", likeSearchOption);
    }

    protected void regShortName(ConditionKey k, Object v) { regQ(k, v, getCValueShortName(), "SHORT_NAME"); }
    abstract protected ConditionValue getCValueShortName();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param shortSize The value of shortSize as equal. (NullAllowed: if null, no condition)
     */
    public void setShortSize_Equal(Integer shortSize) {
        doSetShortSize_Equal(shortSize);
    }

    protected void doSetShortSize_Equal(Integer shortSize) {
        regShortSize(CK_EQ, shortSize);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param shortSize The value of shortSize as notEqual. (NullAllowed: if null, no condition)
     */
    public void setShortSize_NotEqual(Integer shortSize) {
        doSetShortSize_NotEqual(shortSize);
    }

    protected void doSetShortSize_NotEqual(Integer shortSize) {
        regShortSize(CK_NES, shortSize);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param shortSize The value of shortSize as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setShortSize_GreaterThan(Integer shortSize) {
        regShortSize(CK_GT, shortSize);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param shortSize The value of shortSize as lessThan. (NullAllowed: if null, no condition)
     */
    public void setShortSize_LessThan(Integer shortSize) {
        regShortSize(CK_LT, shortSize);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param shortSize The value of shortSize as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setShortSize_GreaterEqual(Integer shortSize) {
        regShortSize(CK_GE, shortSize);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param shortSize The value of shortSize as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setShortSize_LessEqual(Integer shortSize) {
        regShortSize(CK_LE, shortSize);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param minNumber The min number of shortSize. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of shortSize. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setShortSize_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueShortSize(), "SHORT_SIZE", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param shortSizeList The collection of shortSize as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortSize_InScope(Collection<Integer> shortSizeList) {
        doSetShortSize_InScope(shortSizeList);
    }

    protected void doSetShortSize_InScope(Collection<Integer> shortSizeList) {
        regINS(CK_INS, cTL(shortSizeList), getCValueShortSize(), "SHORT_SIZE");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * SHORT_SIZE: {NotNull, INTEGER(10)}
     * @param shortSizeList The collection of shortSize as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setShortSize_NotInScope(Collection<Integer> shortSizeList) {
        doSetShortSize_NotInScope(shortSizeList);
    }

    protected void doSetShortSize_NotInScope(Collection<Integer> shortSizeList) {
        regINS(CK_NINS, cTL(shortSizeList), getCValueShortSize(), "SHORT_SIZE");
    }

    protected void regShortSize(ConditionKey k, Object v) { regQ(k, v, getCValueShortSize(), "SHORT_SIZE"); }
    abstract protected ConditionValue getCValueShortSize();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_Equal()</span>.max(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorTheLongAndWindingTableAndColumnCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand());
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorTheLongAndWindingTableAndColumnCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorTheLongAndWindingTableAndColumnCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessThan()</span>.max(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorTheLongAndWindingTableAndColumnCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorTheLongAndWindingTableAndColumnCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *     public void query(VendorTheLongAndWindingTableAndColumnCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorTheLongAndWindingTableAndColumnCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand());
    }

    protected HpSSQFunction<VendorTheLongAndWindingTableAndColumnCB> xcreateSSQFunction(final String operand) {
        return new HpSSQFunction<VendorTheLongAndWindingTableAndColumnCB>(new HpSSQSetupper<VendorTheLongAndWindingTableAndColumnCB>() {
            public void setup(String function, SubQuery<VendorTheLongAndWindingTableAndColumnCB> subQuery, HpSSQOption<VendorTheLongAndWindingTableAndColumnCB> option) {
                xscalarCondition(function, subQuery, operand, option);
            }
        });
    }

    protected void xscalarCondition(String function, SubQuery<VendorTheLongAndWindingTableAndColumnCB> subQuery, String operand, HpSSQOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnCB cb = xcreateScalarConditionCB(); subQuery.query(cb);
        String subQueryPropertyName = keepScalarCondition(cb.query()); // for saving query-value
        option.setPartitionByCBean(xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(function, cb.query(), subQueryPropertyName, operand, option);
    }
    public abstract String keepScalarCondition(VendorTheLongAndWindingTableAndColumnCQ subQuery);

    protected VendorTheLongAndWindingTableAndColumnCB xcreateScalarConditionCB() {
        VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
        cb.xsetupForScalarCondition(this);
        return cb;
    }

    protected VendorTheLongAndWindingTableAndColumnCB xcreateScalarConditionPartitionByCB() {
        VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
        cb.xsetupForScalarConditionPartitionBy(this);
        return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String function, SubQuery<VendorTheLongAndWindingTableAndColumnCB> subQuery, String aliasName, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepSpecifyMyselfDerived(cb.query()); // for saving query-value.
        registerSpecifyMyselfDerived(function, cb.query(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", subQueryPropertyName, "myselfDerived", aliasName, option);
    }
    public abstract String keepSpecifyMyselfDerived(VendorTheLongAndWindingTableAndColumnCQ subQuery);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VendorTheLongAndWindingTableAndColumnCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived();
    }
    protected HpQDRFunction<VendorTheLongAndWindingTableAndColumnCB> xcreateQDRFunctionMyselfDerived() {
        return new HpQDRFunction<VendorTheLongAndWindingTableAndColumnCB>(new HpQDRSetupper<VendorTheLongAndWindingTableAndColumnCB>() {
            public void setup(String function, SubQuery<VendorTheLongAndWindingTableAndColumnCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
                xqderiveMyselfDerived(function, subQuery, operand, value, option);
            }
        });
    }
    public void xqderiveMyselfDerived(String function, SubQuery<VendorTheLongAndWindingTableAndColumnCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String parameterPropertyName = keepQueryMyselfDerivedParameter(value);
        registerQueryMyselfDerived(function, cb.query(), "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", "THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID", subQueryPropertyName, "myselfDerived", operand, value, parameterPropertyName, option);
    }
    public abstract String keepQueryMyselfDerived(VendorTheLongAndWindingTableAndColumnCQ subQuery);
    public abstract String keepQueryMyselfDerivedParameter(Object parameterValue);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(SubQuery<VendorTheLongAndWindingTableAndColumnCB> subQuery) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB(); cb.xsetupForMyselfExists(this); subQuery.query(cb);
        String subQueryPropertyName = keepMyselfExists(cb.query()); // for saving query-value.
        registerMyselfExists(cb.query(), subQueryPropertyName);
    }
    public abstract String keepMyselfExists(VendorTheLongAndWindingTableAndColumnCQ subQuery);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(SubQuery<VendorTheLongAndWindingTableAndColumnCB> subQuery) {
        assertObjectNotNull("subQuery<VendorTheLongAndWindingTableAndColumnCB>", subQuery);
        VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB(); cb.xsetupForMyselfInScope(this); subQuery.query(cb);
        String subQueryPropertyName = keepMyselfInScope(cb.query()); // for saving query-value.
        registerMyselfInScope(cb.query(), subQueryPropertyName);
    }
    public abstract String keepMyselfInScope(VendorTheLongAndWindingTableAndColumnCQ subQuery);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCB() { return VendorTheLongAndWindingTableAndColumnCB.class.getName(); }
    protected String xabCQ() { return VendorTheLongAndWindingTableAndColumnCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
