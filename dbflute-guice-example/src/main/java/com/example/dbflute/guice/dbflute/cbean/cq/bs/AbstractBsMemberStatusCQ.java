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
 * The abstract condition-query of MEMBER_STATUS.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsMemberStatusCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsMemberStatusCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "MEMBER_STATUS";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus}
     * @param memberStatusCode The value of memberStatusCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    protected void setMemberStatusCode_Equal(String memberStatusCode) {
        doSetMemberStatusCode_Equal(fRES(memberStatusCode));
    }

    /**
     * Equal(=). As MemberStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} <br />
     * status of member from entry to withdrawal
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus cdef) {
        doSetMemberStatusCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As Formalized (FML). And OnlyOnceRegistered. <br />
     * Formalized: as formal member, allowed to use all service
     */
    public void setMemberStatusCode_Equal_Formalized() {
        setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus.Formalized);
    }

    /**
     * Equal(=). As Withdrawal (WDL). And OnlyOnceRegistered. <br />
     * Withdrawal: withdrawal is fixed, not allowed to use service
     */
    public void setMemberStatusCode_Equal_Withdrawal() {
        setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus.Withdrawal);
    }

    /**
     * Equal(=). As Provisional (PRV). And OnlyOnceRegistered. <br />
     * Provisional: first status after entry, allowed to use only part of service
     */
    public void setMemberStatusCode_Equal_Provisional() {
        setMemberStatusCode_Equal_AsMemberStatus(CDef.MemberStatus.Provisional);
    }

    protected void doSetMemberStatusCode_Equal(String memberStatusCode) {
        regMemberStatusCode(CK_EQ, hSC("MEMBER_STATUS_CODE", memberStatusCode, 3, "E"));
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus}
     * @param memberStatusCode The value of memberStatusCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    protected void setMemberStatusCode_NotEqual(String memberStatusCode) {
        doSetMemberStatusCode_NotEqual(fRES(memberStatusCode));
    }

    /**
     * NotEqual(&lt;&gt;). As MemberStatus. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} <br />
     * status of member from entry to withdrawal
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_NotEqual_AsMemberStatus(CDef.MemberStatus cdef) {
        doSetMemberStatusCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As Formalized (FML). And OnlyOnceRegistered. <br />
     * Formalized: as formal member, allowed to use all service
     */
    public void setMemberStatusCode_NotEqual_Formalized() {
        setMemberStatusCode_NotEqual_AsMemberStatus(CDef.MemberStatus.Formalized);
    }

    /**
     * NotEqual(&lt;&gt;). As Withdrawal (WDL). And OnlyOnceRegistered. <br />
     * Withdrawal: withdrawal is fixed, not allowed to use service
     */
    public void setMemberStatusCode_NotEqual_Withdrawal() {
        setMemberStatusCode_NotEqual_AsMemberStatus(CDef.MemberStatus.Withdrawal);
    }

    /**
     * NotEqual(&lt;&gt;). As Provisional (PRV). And OnlyOnceRegistered. <br />
     * Provisional: first status after entry, allowed to use only part of service
     */
    public void setMemberStatusCode_NotEqual_Provisional() {
        setMemberStatusCode_NotEqual_AsMemberStatus(CDef.MemberStatus.Provisional);
    }

    protected void doSetMemberStatusCode_NotEqual(String memberStatusCode) {
        regMemberStatusCode(CK_NES, hSC("MEMBER_STATUS_CODE", memberStatusCode, 3, "E"));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus}
     * @param memberStatusCodeList The collection of memberStatusCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_InScope(Collection<String> memberStatusCodeList) {
        doSetMemberStatusCode_InScope(memberStatusCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As MemberStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} <br />
     * status of member from entry to withdrawal
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_InScope_AsMemberStatus(Collection<CDef.MemberStatus> cdefList) {
        doSetMemberStatusCode_InScope(cTStrL(cdefList));
    }

    public void doSetMemberStatusCode_InScope(Collection<String> memberStatusCodeList) {
        regINS(CK_INS, cTL(memberStatusCodeList), getCValueMemberStatusCode(), "MEMBER_STATUS_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus}
     * @param memberStatusCodeList The collection of memberStatusCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_NotInScope(Collection<String> memberStatusCodeList) {
        doSetMemberStatusCode_NotInScope(memberStatusCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As MemberStatus. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus} <br />
     * status of member from entry to withdrawal
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_NotInScope_AsMemberStatus(Collection<CDef.MemberStatus> cdefList) {
        doSetMemberStatusCode_NotInScope(cTStrL(cdefList));
    }

    public void doSetMemberStatusCode_NotInScope(Collection<String> memberStatusCodeList) {
        regINS(CK_NINS, cTL(memberStatusCodeList), getCValueMemberStatusCode(), "MEMBER_STATUS_CODE");
    }

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select MEMBER_STATUS_CODE from MEMBER where ...)} <br />
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsMemberList</span>(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberList for 'exists'. (NotNull)
     */
    public void existsMemberList(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery<MemberCB>", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_ExistsReferrer_MemberList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", subQueryPropertyName, "memberList");
    }
    public abstract String keepMemberStatusCode_ExistsReferrer_MemberList(MemberCQ subQuery);

    /**
     * Set up ExistsReferrer (co-related sub-query). <br />
     * {exists (select LOGIN_MEMBER_STATUS_CODE from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">existsMemberLoginList</span>(new SubQuery&lt;MemberLoginCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberLoginList for 'exists'. (NotNull)
     */
    public void existsMemberLoginList(SubQuery<MemberLoginCB> subQuery) {
        assertObjectNotNull("subQuery<MemberLoginCB>", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_ExistsReferrer_MemberLoginList(cb.query()); // for saving query-value.
        registerExistsReferrer(cb.query(), "MEMBER_STATUS_CODE", "LOGIN_MEMBER_STATUS_CODE", subQueryPropertyName, "memberLoginList");
    }
    public abstract String keepMemberStatusCode_ExistsReferrer_MemberLoginList(MemberLoginCQ subQuery);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select MEMBER_STATUS_CODE from MEMBER where ...)} <br />
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsMemberList</span>(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberStatusCode_NotExistsReferrer_MemberList for 'not exists'. (NotNull)
     */
    public void notExistsMemberList(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery<MemberCB>", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_NotExistsReferrer_MemberList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", subQueryPropertyName, "memberList");
    }
    public abstract String keepMemberStatusCode_NotExistsReferrer_MemberList(MemberCQ subQuery);

    /**
     * Set up NotExistsReferrer (co-related sub-query). <br />
     * {not exists (select LOGIN_MEMBER_STATUS_CODE from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">notExistsMemberLoginList</span>(new SubQuery&lt;MemberLoginCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberStatusCode_NotExistsReferrer_MemberLoginList for 'not exists'. (NotNull)
     */
    public void notExistsMemberLoginList(SubQuery<MemberLoginCB> subQuery) {
        assertObjectNotNull("subQuery<MemberLoginCB>", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForExistsReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_NotExistsReferrer_MemberLoginList(cb.query()); // for saving query-value.
        registerNotExistsReferrer(cb.query(), "MEMBER_STATUS_CODE", "LOGIN_MEMBER_STATUS_CODE", subQueryPropertyName, "memberLoginList");
    }
    public abstract String keepMemberStatusCode_NotExistsReferrer_MemberLoginList(MemberLoginCQ subQuery);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_STATUS_CODE from MEMBER where ...)} <br />
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * @param subQuery The sub-query of MemberList for 'in-scope'. (NotNull)
     */
    public void inScopeMemberList(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery<MemberCB>", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_InScopeRelation_MemberList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", subQueryPropertyName, "memberList");
    }
    public abstract String keepMemberStatusCode_InScopeRelation_MemberList(MemberCQ subQuery);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select LOGIN_MEMBER_STATUS_CODE from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginAsOne'.
     * @param subQuery The sub-query of MemberLoginList for 'in-scope'. (NotNull)
     */
    public void inScopeMemberLoginList(SubQuery<MemberLoginCB> subQuery) {
        assertObjectNotNull("subQuery<MemberLoginCB>", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_InScopeRelation_MemberLoginList(cb.query()); // for saving query-value.
        registerInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "LOGIN_MEMBER_STATUS_CODE", subQueryPropertyName, "memberLoginList");
    }
    public abstract String keepMemberStatusCode_InScopeRelation_MemberLoginList(MemberLoginCQ subQuery);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_STATUS_CODE from MEMBER where ...)} <br />
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * @param subQuery The sub-query of MemberList for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberList(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery<MemberCB>", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_NotInScopeRelation_MemberList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", subQueryPropertyName, "memberList");
    }
    public abstract String keepMemberStatusCode_NotInScopeRelation_MemberList(MemberCQ subQuery);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select LOGIN_MEMBER_STATUS_CODE from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginAsOne'.
     * @param subQuery The sub-query of MemberLoginList for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberLoginList(SubQuery<MemberLoginCB> subQuery) {
        assertObjectNotNull("subQuery<MemberLoginCB>", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForInScopeRelation(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_NotInScopeRelation_MemberLoginList(cb.query()); // for saving query-value.
        registerNotInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "LOGIN_MEMBER_STATUS_CODE", subQueryPropertyName, "memberLoginList");
    }
    public abstract String keepMemberStatusCode_NotInScopeRelation_MemberLoginList(MemberLoginCQ subQuery);

    public void xsderiveMemberList(String function, SubQuery<MemberCB> subQuery, String aliasName, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<MemberCB>", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_SpecifyDerivedReferrer_MemberList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(function, cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", subQueryPropertyName, "memberList", aliasName, option);
    }
    public abstract String keepMemberStatusCode_SpecifyDerivedReferrer_MemberList(MemberCQ subQuery);

    public void xsderiveMemberLoginList(String function, SubQuery<MemberLoginCB> subQuery, String aliasName, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<MemberLoginCB>", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_SpecifyDerivedReferrer_MemberLoginList(cb.query()); // for saving query-value.
        registerSpecifyDerivedReferrer(function, cb.query(), "MEMBER_STATUS_CODE", "LOGIN_MEMBER_STATUS_CODE", subQueryPropertyName, "memberLoginList", aliasName, option);
    }
    public abstract String keepMemberStatusCode_SpecifyDerivedReferrer_MemberLoginList(MemberLoginCQ subQuery);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from MEMBER where ...)} <br />
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">derivedMemberList()</span>.<span style="color: #FD4747">max</span>(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().<span style="color: #FD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #FD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MemberCB> derivedMemberList() {
        return xcreateQDRFunctionMemberList();
    }
    protected HpQDRFunction<MemberCB> xcreateQDRFunctionMemberList() {
        return new HpQDRFunction<MemberCB>(new HpQDRSetupper<MemberCB>() {
            public void setup(String function, SubQuery<MemberCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
                xqderiveMemberList(function, subQuery, operand, value, option);
            }
        });
    }
    public void xqderiveMemberList(String function, SubQuery<MemberCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<MemberCB>", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_QueryDerivedReferrer_MemberList(cb.query()); // for saving query-value.
        String parameterPropertyName = keepMemberStatusCode_QueryDerivedReferrer_MemberListParameter(value);
        registerQueryDerivedReferrer(function, cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", subQueryPropertyName, "memberList", operand, value, parameterPropertyName, option);
    }
    public abstract String keepMemberStatusCode_QueryDerivedReferrer_MemberList(MemberCQ subQuery);
    public abstract String keepMemberStatusCode_QueryDerivedReferrer_MemberListParameter(Object parameterValue);

    /**
     * Prepare for (Query)DerivedReferrer. <br />
     * {FOO &lt;= (select max(BAR) from MEMBER_LOGIN where ...)} <br />
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginAsOne'.
     * <pre>
     * cb.query().<span style="color: #FD4747">derivedMemberLoginList()</span>.<span style="color: #FD4747">max</span>(new SubQuery&lt;MemberLoginCB&gt;() {
     *     public void query(MemberLoginCB subCB) {
     *         subCB.specify().<span style="color: #FD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #FD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MemberLoginCB> derivedMemberLoginList() {
        return xcreateQDRFunctionMemberLoginList();
    }
    protected HpQDRFunction<MemberLoginCB> xcreateQDRFunctionMemberLoginList() {
        return new HpQDRFunction<MemberLoginCB>(new HpQDRSetupper<MemberLoginCB>() {
            public void setup(String function, SubQuery<MemberLoginCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
                xqderiveMemberLoginList(function, subQuery, operand, value, option);
            }
        });
    }
    public void xqderiveMemberLoginList(String function, SubQuery<MemberLoginCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<MemberLoginCB>", subQuery);
        MemberLoginCB cb = new MemberLoginCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepMemberStatusCode_QueryDerivedReferrer_MemberLoginList(cb.query()); // for saving query-value.
        String parameterPropertyName = keepMemberStatusCode_QueryDerivedReferrer_MemberLoginListParameter(value);
        registerQueryDerivedReferrer(function, cb.query(), "MEMBER_STATUS_CODE", "LOGIN_MEMBER_STATUS_CODE", subQueryPropertyName, "memberLoginList", operand, value, parameterPropertyName, option);
    }
    public abstract String keepMemberStatusCode_QueryDerivedReferrer_MemberLoginList(MemberLoginCQ subQuery);
    public abstract String keepMemberStatusCode_QueryDerivedReferrer_MemberLoginListParameter(Object parameterValue);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus}
     */
    public void setMemberStatusCode_IsNull() { regMemberStatusCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus}
     */
    public void setMemberStatusCode_IsNotNull() { regMemberStatusCode(CK_ISNN, DOBJ); }

    protected void regMemberStatusCode(ConditionKey k, Object v) { regQ(k, v, getCValueMemberStatusCode(), "MEMBER_STATUS_CODE"); }
    abstract protected ConditionValue getCValueMemberStatusCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusName The value of memberStatusName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_Equal(String memberStatusName) {
        doSetMemberStatusName_Equal(fRES(memberStatusName));
    }

    protected void doSetMemberStatusName_Equal(String memberStatusName) {
        regMemberStatusName(CK_EQ, memberStatusName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusName The value of memberStatusName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_NotEqual(String memberStatusName) {
        doSetMemberStatusName_NotEqual(fRES(memberStatusName));
    }

    protected void doSetMemberStatusName_NotEqual(String memberStatusName) {
        regMemberStatusName(CK_NES, memberStatusName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusName The value of memberStatusName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_GreaterThan(String memberStatusName) {
        regMemberStatusName(CK_GT, fRES(memberStatusName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusName The value of memberStatusName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_LessThan(String memberStatusName) {
        regMemberStatusName(CK_LT, fRES(memberStatusName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusName The value of memberStatusName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_GreaterEqual(String memberStatusName) {
        regMemberStatusName(CK_GE, fRES(memberStatusName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusName The value of memberStatusName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_LessEqual(String memberStatusName) {
        regMemberStatusName(CK_LE, fRES(memberStatusName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusNameList The collection of memberStatusName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_InScope(Collection<String> memberStatusNameList) {
        doSetMemberStatusName_InScope(memberStatusNameList);
    }

    public void doSetMemberStatusName_InScope(Collection<String> memberStatusNameList) {
        regINS(CK_INS, cTL(memberStatusNameList), getCValueMemberStatusName(), "MEMBER_STATUS_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusNameList The collection of memberStatusName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_NotInScope(Collection<String> memberStatusNameList) {
        doSetMemberStatusName_NotInScope(memberStatusNameList);
    }

    public void doSetMemberStatusName_NotInScope(Collection<String> memberStatusNameList) {
        regINS(CK_NINS, cTL(memberStatusNameList), getCValueMemberStatusName(), "MEMBER_STATUS_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusName The value of memberStatusName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_PrefixSearch(String memberStatusName) {
        setMemberStatusName_LikeSearch(memberStatusName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)} <br />
     * <pre>e.g. setMemberStatusName_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param memberStatusName The value of memberStatusName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setMemberStatusName_LikeSearch(String memberStatusName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(memberStatusName), getCValueMemberStatusName(), "MEMBER_STATUS_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @param memberStatusName The value of memberStatusName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setMemberStatusName_NotLikeSearch(String memberStatusName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(memberStatusName), getCValueMemberStatusName(), "MEMBER_STATUS_NAME", likeSearchOption);
    }

    protected void regMemberStatusName(ConditionKey k, Object v) { regQ(k, v, getCValueMemberStatusName(), "MEMBER_STATUS_NAME"); }
    abstract protected ConditionValue getCValueMemberStatusName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param description The value of description as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_Equal(String description) {
        doSetDescription_Equal(fRES(description));
    }

    protected void doSetDescription_Equal(String description) {
        regDescription(CK_EQ, description);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param description The value of description as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_NotEqual(String description) {
        doSetDescription_NotEqual(fRES(description));
    }

    protected void doSetDescription_NotEqual(String description) {
        regDescription(CK_NES, description);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param description The value of description as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_GreaterThan(String description) {
        regDescription(CK_GT, fRES(description));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param description The value of description as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_LessThan(String description) {
        regDescription(CK_LT, fRES(description));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param description The value of description as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_GreaterEqual(String description) {
        regDescription(CK_GE, fRES(description));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param description The value of description as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_LessEqual(String description) {
        regDescription(CK_LE, fRES(description));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param descriptionList The collection of description as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_InScope(Collection<String> descriptionList) {
        doSetDescription_InScope(descriptionList);
    }

    public void doSetDescription_InScope(Collection<String> descriptionList) {
        regINS(CK_INS, cTL(descriptionList), getCValueDescription(), "DESCRIPTION");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param descriptionList The collection of description as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_NotInScope(Collection<String> descriptionList) {
        doSetDescription_NotInScope(descriptionList);
    }

    public void doSetDescription_NotInScope(Collection<String> descriptionList) {
        regINS(CK_NINS, cTL(descriptionList), getCValueDescription(), "DESCRIPTION");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param description The value of description as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setDescription_PrefixSearch(String description) {
        setDescription_LikeSearch(description, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * <pre>e.g. setDescription_LikeSearch("xxx", new <span style="color: #FD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param description The value of description as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setDescription_LikeSearch(String description, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(description), getCValueDescription(), "DESCRIPTION", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @param description The value of description as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setDescription_NotLikeSearch(String description, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(description), getCValueDescription(), "DESCRIPTION", likeSearchOption);
    }

    protected void regDescription(ConditionKey k, Object v) { regQ(k, v, getCValueDescription(), "DESCRIPTION"); }
    abstract protected ConditionValue getCValueDescription();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as equal. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_Equal(Integer displayOrder) {
        doSetDisplayOrder_Equal(displayOrder);
    }

    protected void doSetDisplayOrder_Equal(Integer displayOrder) {
        regDisplayOrder(CK_EQ, displayOrder);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as notEqual. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_NotEqual(Integer displayOrder) {
        doSetDisplayOrder_NotEqual(displayOrder);
    }

    protected void doSetDisplayOrder_NotEqual(Integer displayOrder) {
        regDisplayOrder(CK_NES, displayOrder);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_GreaterThan(Integer displayOrder) {
        regDisplayOrder(CK_GT, displayOrder);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as lessThan. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_LessThan(Integer displayOrder) {
        regDisplayOrder(CK_LT, displayOrder);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_GreaterEqual(Integer displayOrder) {
        regDisplayOrder(CK_GE, displayOrder);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_LessEqual(Integer displayOrder) {
        regDisplayOrder(CK_LE, displayOrder);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param minNumber The min number of displayOrder. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of displayOrder. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setDisplayOrder_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueDisplayOrder(), "DISPLAY_ORDER", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrderList The collection of displayOrder as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDisplayOrder_InScope(Collection<Integer> displayOrderList) {
        doSetDisplayOrder_InScope(displayOrderList);
    }

    protected void doSetDisplayOrder_InScope(Collection<Integer> displayOrderList) {
        regINS(CK_INS, cTL(displayOrderList), getCValueDisplayOrder(), "DISPLAY_ORDER");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrderList The collection of displayOrder as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDisplayOrder_NotInScope(Collection<Integer> displayOrderList) {
        doSetDisplayOrder_NotInScope(displayOrderList);
    }

    protected void doSetDisplayOrder_NotInScope(Collection<Integer> displayOrderList) {
        regINS(CK_NINS, cTL(displayOrderList), getCValueDisplayOrder(), "DISPLAY_ORDER");
    }

    protected void regDisplayOrder(ConditionKey k, Object v) { regQ(k, v, getCValueDisplayOrder(), "DISPLAY_ORDER"); }
    abstract protected ConditionValue getCValueDisplayOrder();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_Equal()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand());
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessThan()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand());
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand());
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #FD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand());
    }

    protected HpSSQFunction<MemberStatusCB> xcreateSSQFunction(final String operand) {
        return new HpSSQFunction<MemberStatusCB>(new HpSSQSetupper<MemberStatusCB>() {
            public void setup(String function, SubQuery<MemberStatusCB> subQuery, HpSSQOption<MemberStatusCB> option) {
                xscalarCondition(function, subQuery, operand, option);
            }
        });
    }

    protected void xscalarCondition(String function, SubQuery<MemberStatusCB> subQuery, String operand, HpSSQOption<MemberStatusCB> option) {
        assertObjectNotNull("subQuery<MemberStatusCB>", subQuery);
        MemberStatusCB cb = xcreateScalarConditionCB(); subQuery.query(cb);
        String subQueryPropertyName = keepScalarCondition(cb.query()); // for saving query-value
        option.setPartitionByCBean(xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(function, cb.query(), subQueryPropertyName, operand, option);
    }
    public abstract String keepScalarCondition(MemberStatusCQ subQuery);

    protected MemberStatusCB xcreateScalarConditionCB() {
        MemberStatusCB cb = new MemberStatusCB();
        cb.xsetupForScalarCondition(this);
        return cb;
    }

    protected MemberStatusCB xcreateScalarConditionPartitionByCB() {
        MemberStatusCB cb = new MemberStatusCB();
        cb.xsetupForScalarConditionPartitionBy(this);
        return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String function, SubQuery<MemberStatusCB> subQuery, String aliasName, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<MemberStatusCB>", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepSpecifyMyselfDerived(cb.query()); // for saving query-value.
        registerSpecifyMyselfDerived(function, cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", subQueryPropertyName, "myselfDerived", aliasName, option);
    }
    public abstract String keepSpecifyMyselfDerived(MemberStatusCQ subQuery);

    /**
     * Prepare for (Query)MyselfDerived (SubQuery).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<MemberStatusCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived();
    }
    protected HpQDRFunction<MemberStatusCB> xcreateQDRFunctionMyselfDerived() {
        return new HpQDRFunction<MemberStatusCB>(new HpQDRSetupper<MemberStatusCB>() {
            public void setup(String function, SubQuery<MemberStatusCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
                xqderiveMyselfDerived(function, subQuery, operand, value, option);
            }
        });
    }
    public void xqderiveMyselfDerived(String function, SubQuery<MemberStatusCB> subQuery, String operand, Object value, DerivedReferrerOption option) {
        assertObjectNotNull("subQuery<MemberStatusCB>", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForDerivedReferrer(this); subQuery.query(cb);
        String subQueryPropertyName = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String parameterPropertyName = keepQueryMyselfDerivedParameter(value);
        registerQueryMyselfDerived(function, cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", subQueryPropertyName, "myselfDerived", operand, value, parameterPropertyName, option);
    }
    public abstract String keepQueryMyselfDerived(MemberStatusCQ subQuery);
    public abstract String keepQueryMyselfDerivedParameter(Object parameterValue);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfExists(SubQuery<MemberStatusCB> subQuery) {
        assertObjectNotNull("subQuery<MemberStatusCB>", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForMyselfExists(this); subQuery.query(cb);
        String subQueryPropertyName = keepMyselfExists(cb.query()); // for saving query-value.
        registerMyselfExists(cb.query(), subQueryPropertyName);
    }
    public abstract String keepMyselfExists(MemberStatusCQ subQuery);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (SubQuery).
     * @param subQuery The implementation of sub query. (NotNull)
     */
    public void myselfInScope(SubQuery<MemberStatusCB> subQuery) {
        assertObjectNotNull("subQuery<MemberStatusCB>", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForMyselfInScope(this); subQuery.query(cb);
        String subQueryPropertyName = keepMyselfInScope(cb.query()); // for saving query-value.
        registerMyselfInScope(cb.query(), subQueryPropertyName);
    }
    public abstract String keepMyselfInScope(MemberStatusCQ subQuery);

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCB() { return MemberStatusCB.class.getName(); }
    protected String xabCQ() { return MemberStatusCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
