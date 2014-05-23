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
 * The abstract condition-query of VENDOR_IDENTITY_ONLY.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsVendorIdentityOnlyCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsVendorIdentityOnlyCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
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
        return "VENDOR_IDENTITY_ONLY";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param identityOnlyId The value of identityOnlyId as equal. (NullAllowed: if null, no condition)
     */
    public void setIdentityOnlyId_Equal(Long identityOnlyId) {
        doSetIdentityOnlyId_Equal(identityOnlyId);
    }

    protected void doSetIdentityOnlyId_Equal(Long identityOnlyId) {
        regIdentityOnlyId(CK_EQ, identityOnlyId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param identityOnlyId The value of identityOnlyId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setIdentityOnlyId_NotEqual(Long identityOnlyId) {
        doSetIdentityOnlyId_NotEqual(identityOnlyId);
    }

    protected void doSetIdentityOnlyId_NotEqual(Long identityOnlyId) {
        regIdentityOnlyId(CK_NES, identityOnlyId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param identityOnlyId The value of identityOnlyId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setIdentityOnlyId_GreaterThan(Long identityOnlyId) {
        regIdentityOnlyId(CK_GT, identityOnlyId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param identityOnlyId The value of identityOnlyId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setIdentityOnlyId_LessThan(Long identityOnlyId) {
        regIdentityOnlyId(CK_LT, identityOnlyId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param identityOnlyId The value of identityOnlyId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setIdentityOnlyId_GreaterEqual(Long identityOnlyId) {
        regIdentityOnlyId(CK_GE, identityOnlyId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param identityOnlyId The value of identityOnlyId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setIdentityOnlyId_LessEqual(Long identityOnlyId) {
        regIdentityOnlyId(CK_LE, identityOnlyId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of identityOnlyId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of identityOnlyId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setIdentityOnlyId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueIdentityOnlyId(), "IDENTITY_ONLY_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param identityOnlyIdList The collection of identityOnlyId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setIdentityOnlyId_InScope(Collection<Long> identityOnlyIdList) {
        doSetIdentityOnlyId_InScope(identityOnlyIdList);
    }

    protected void doSetIdentityOnlyId_InScope(Collection<Long> identityOnlyIdList) {
        regINS(CK_INS, cTL(identityOnlyIdList), getCValueIdentityOnlyId(), "IDENTITY_ONLY_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param identityOnlyIdList The collection of identityOnlyId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setIdentityOnlyId_NotInScope(Collection<Long> identityOnlyIdList) {
        doSetIdentityOnlyId_NotInScope(identityOnlyIdList);
    }

    protected void doSetIdentityOnlyId_NotInScope(Collection<Long> identityOnlyIdList) {
        regINS(CK_NINS, cTL(identityOnlyIdList), getCValueIdentityOnlyId(), "IDENTITY_ONLY_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setIdentityOnlyId_IsNull() { regIdentityOnlyId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * IDENTITY_ONLY_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setIdentityOnlyId_IsNotNull() { regIdentityOnlyId(CK_ISNN, DOBJ); }

    protected void regIdentityOnlyId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueIdentityOnlyId(), "IDENTITY_ONLY_ID"); }
    protected abstract ConditionValue getCValueIdentityOnlyId();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;VendorIdentityOnlyCB&gt;() {
     *     public void query(VendorIdentityOnlyCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorIdentityOnlyCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand(), VendorIdentityOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;VendorIdentityOnlyCB&gt;() {
     *     public void query(VendorIdentityOnlyCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorIdentityOnlyCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand(), VendorIdentityOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;VendorIdentityOnlyCB&gt;() {
     *     public void query(VendorIdentityOnlyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorIdentityOnlyCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand(), VendorIdentityOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;VendorIdentityOnlyCB&gt;() {
     *     public void query(VendorIdentityOnlyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorIdentityOnlyCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand(), VendorIdentityOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;VendorIdentityOnlyCB&gt;() {
     *     public void query(VendorIdentityOnlyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorIdentityOnlyCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand(), VendorIdentityOnlyCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;VendorIdentityOnlyCB&gt;() {
     *     public void query(VendorIdentityOnlyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<VendorIdentityOnlyCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand(), VendorIdentityOnlyCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        VendorIdentityOnlyCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(VendorIdentityOnlyCQ sq);

    protected VendorIdentityOnlyCB xcreateScalarConditionCB() {
        VendorIdentityOnlyCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected VendorIdentityOnlyCB xcreateScalarConditionPartitionByCB() {
        VendorIdentityOnlyCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<VendorIdentityOnlyCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "IDENTITY_ONLY_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(VendorIdentityOnlyCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<VendorIdentityOnlyCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(VendorIdentityOnlyCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "IDENTITY_ONLY_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(VendorIdentityOnlyCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(SubQuery<VendorIdentityOnlyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(VendorIdentityOnlyCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(SubQuery<VendorIdentityOnlyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(VendorIdentityOnlyCQ sq);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected VendorIdentityOnlyCB newMyCB() {
        return new VendorIdentityOnlyCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return VendorIdentityOnlyCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
