package com.example.dbflute.guice.dbflute.cbean.cq.bs;

import java.util.*;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import com.example.dbflute.guice.dbflute.allcommon.*;
import com.example.dbflute.guice.dbflute.cbean.*;
import com.example.dbflute.guice.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of VENDOR_PRIMARY_KEY_ONLY.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVendorPrimaryKeyOnlyCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVendorPrimaryKeyOnlyCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "VENDOR_PRIMARY_KEY_ONLY";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param primaryKeyOnlyId The value of primaryKeyOnlyId as equal. (NullAllowed: if null, no condition)
     */
    public void setPrimaryKeyOnlyId_Equal(Long primaryKeyOnlyId) {
        doSetPrimaryKeyOnlyId_Equal(primaryKeyOnlyId);
    }

    protected void doSetPrimaryKeyOnlyId_Equal(Long primaryKeyOnlyId) {
        regPrimaryKeyOnlyId(CK_EQ, primaryKeyOnlyId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param primaryKeyOnlyId The value of primaryKeyOnlyId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setPrimaryKeyOnlyId_NotEqual(Long primaryKeyOnlyId) {
        doSetPrimaryKeyOnlyId_NotEqual(primaryKeyOnlyId);
    }

    protected void doSetPrimaryKeyOnlyId_NotEqual(Long primaryKeyOnlyId) {
        regPrimaryKeyOnlyId(CK_NES, primaryKeyOnlyId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param primaryKeyOnlyId The value of primaryKeyOnlyId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setPrimaryKeyOnlyId_GreaterThan(Long primaryKeyOnlyId) {
        regPrimaryKeyOnlyId(CK_GT, primaryKeyOnlyId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param primaryKeyOnlyId The value of primaryKeyOnlyId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setPrimaryKeyOnlyId_LessThan(Long primaryKeyOnlyId) {
        regPrimaryKeyOnlyId(CK_LT, primaryKeyOnlyId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param primaryKeyOnlyId The value of primaryKeyOnlyId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setPrimaryKeyOnlyId_GreaterEqual(Long primaryKeyOnlyId) {
        regPrimaryKeyOnlyId(CK_GE, primaryKeyOnlyId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param primaryKeyOnlyId The value of primaryKeyOnlyId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setPrimaryKeyOnlyId_LessEqual(Long primaryKeyOnlyId) {
        regPrimaryKeyOnlyId(CK_LE, primaryKeyOnlyId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param minNumber The min number of primaryKeyOnlyId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of primaryKeyOnlyId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setPrimaryKeyOnlyId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValuePrimaryKeyOnlyId(), "PRIMARY_KEY_ONLY_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param primaryKeyOnlyIdList The collection of primaryKeyOnlyId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setPrimaryKeyOnlyId_InScope(Collection<Long> primaryKeyOnlyIdList) {
        doSetPrimaryKeyOnlyId_InScope(primaryKeyOnlyIdList);
    }

    protected void doSetPrimaryKeyOnlyId_InScope(Collection<Long> primaryKeyOnlyIdList) {
        regINS(CK_INS, cTL(primaryKeyOnlyIdList), getCValuePrimaryKeyOnlyId(), "PRIMARY_KEY_ONLY_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     * @param primaryKeyOnlyIdList The collection of primaryKeyOnlyId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setPrimaryKeyOnlyId_NotInScope(Collection<Long> primaryKeyOnlyIdList) {
        doSetPrimaryKeyOnlyId_NotInScope(primaryKeyOnlyIdList);
    }

    protected void doSetPrimaryKeyOnlyId_NotInScope(Collection<Long> primaryKeyOnlyIdList) {
        regINS(CK_NINS, cTL(primaryKeyOnlyIdList), getCValuePrimaryKeyOnlyId(), "PRIMARY_KEY_ONLY_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     */
    public void setPrimaryKeyOnlyId_IsNull() { regPrimaryKeyOnlyId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * PRIMARY_KEY_ONLY_ID: {PK, NotNull, BIGINT(19)}
     */
    public void setPrimaryKeyOnlyId_IsNotNull() { regPrimaryKeyOnlyId(CK_ISNN, DOBJ); }

    protected void regPrimaryKeyOnlyId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValuePrimaryKeyOnlyId(), "PRIMARY_KEY_ONLY_ID"); }
    protected abstract ConditionValue getCValuePrimaryKeyOnlyId();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;VendorPrimaryKeyOnlyCB&gt;() {
     *     public void query(VendorPrimaryKeyOnlyCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorPrimaryKeyOnlyCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand(), VendorPrimaryKeyOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;VendorPrimaryKeyOnlyCB&gt;() {
     *     public void query(VendorPrimaryKeyOnlyCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorPrimaryKeyOnlyCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand(), VendorPrimaryKeyOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;VendorPrimaryKeyOnlyCB&gt;() {
     *     public void query(VendorPrimaryKeyOnlyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorPrimaryKeyOnlyCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand(), VendorPrimaryKeyOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;VendorPrimaryKeyOnlyCB&gt;() {
     *     public void query(VendorPrimaryKeyOnlyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorPrimaryKeyOnlyCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand(), VendorPrimaryKeyOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;VendorPrimaryKeyOnlyCB&gt;() {
     *     public void query(VendorPrimaryKeyOnlyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorPrimaryKeyOnlyCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand(), VendorPrimaryKeyOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VendorPrimaryKeyOnlyCB&gt;() {
     *     public void query(VendorPrimaryKeyOnlyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorPrimaryKeyOnlyCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand(), VendorPrimaryKeyOnlyCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        VendorPrimaryKeyOnlyCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(VendorPrimaryKeyOnlyCQ sq);

    protected VendorPrimaryKeyOnlyCB xcreateScalarConditionCB() {
        VendorPrimaryKeyOnlyCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VendorPrimaryKeyOnlyCB xcreateScalarConditionPartitionByCB() {
        VendorPrimaryKeyOnlyCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<VendorPrimaryKeyOnlyCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); } String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "PRIMARY_KEY_ONLY_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(VendorPrimaryKeyOnlyCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VendorPrimaryKeyOnlyCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(VendorPrimaryKeyOnlyCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "PRIMARY_KEY_ONLY_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(VendorPrimaryKeyOnlyCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(SubQuery<VendorPrimaryKeyOnlyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); } String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(VendorPrimaryKeyOnlyCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(SubQuery<VendorPrimaryKeyOnlyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); } String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(VendorPrimaryKeyOnlyCQ sq);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected VendorPrimaryKeyOnlyCB newMyCB() {
        return new VendorPrimaryKeyOnlyCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return VendorPrimaryKeyOnlyCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
