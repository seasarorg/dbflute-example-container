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
package com.example.dbflute.basic.dbflute.cbean.cq.bs;

import java.util.*;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import com.example.dbflute.basic.dbflute.allcommon.*;
import com.example.dbflute.basic.dbflute.cbean.*;
import com.example.dbflute.basic.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of WITHDRAWAL_REASON.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsWithdrawalReasonCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsWithdrawalReasonCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "WITHDRAWAL_REASON";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason}
     * @param withdrawalReasonCode The value of withdrawalReasonCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    protected void setWithdrawalReasonCode_Equal(String withdrawalReasonCode) {
        doSetWithdrawalReasonCode_Equal(fRES(withdrawalReasonCode));
    }

    /**
     * Equal(=). As WithdrawalReason. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason} <br />
     * 会員の退会理由。なのでちょっとねがてぃぶ
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setWithdrawalReasonCode_Equal_AsWithdrawalReason(CDef.WithdrawalReason cdef) {
        doSetWithdrawalReasonCode_Equal(cdef != null ? cdef.code() : null);
    }

    /**
     * Equal(=). As Sit (SIT). And OnlyOnceRegistered. <br />
     * SIT: サイトが使いにくいから
     */
    public void setWithdrawalReasonCode_Equal_Sit() {
        setWithdrawalReasonCode_Equal_AsWithdrawalReason(CDef.WithdrawalReason.Sit);
    }

    /**
     * Equal(=). As Prd (PRD). And OnlyOnceRegistered. <br />
     * PRD: 商品に魅力がないから
     */
    public void setWithdrawalReasonCode_Equal_Prd() {
        setWithdrawalReasonCode_Equal_AsWithdrawalReason(CDef.WithdrawalReason.Prd);
    }

    /**
     * Equal(=). As Frt (FRT). And OnlyOnceRegistered. <br />
     * FRT: フリテンだから
     */
    public void setWithdrawalReasonCode_Equal_Frt() {
        setWithdrawalReasonCode_Equal_AsWithdrawalReason(CDef.WithdrawalReason.Frt);
    }

    /**
     * Equal(=). As Oth (OTH). And OnlyOnceRegistered. <br />
     * OTH: その他理由
     */
    public void setWithdrawalReasonCode_Equal_Oth() {
        setWithdrawalReasonCode_Equal_AsWithdrawalReason(CDef.WithdrawalReason.Oth);
    }

    protected void doSetWithdrawalReasonCode_Equal(String withdrawalReasonCode) {
        regWithdrawalReasonCode(CK_EQ, withdrawalReasonCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason}
     * @param withdrawalReasonCode The value of withdrawalReasonCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    protected void setWithdrawalReasonCode_NotEqual(String withdrawalReasonCode) {
        doSetWithdrawalReasonCode_NotEqual(fRES(withdrawalReasonCode));
    }

    /**
     * NotEqual(&lt;&gt;). As WithdrawalReason. And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason} <br />
     * 会員の退会理由。なのでちょっとねがてぃぶ
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, no condition)
     */
    public void setWithdrawalReasonCode_NotEqual_AsWithdrawalReason(CDef.WithdrawalReason cdef) {
        doSetWithdrawalReasonCode_NotEqual(cdef != null ? cdef.code() : null);
    }

    /**
     * NotEqual(&lt;&gt;). As Sit (SIT). And OnlyOnceRegistered. <br />
     * SIT: サイトが使いにくいから
     */
    public void setWithdrawalReasonCode_NotEqual_Sit() {
        setWithdrawalReasonCode_NotEqual_AsWithdrawalReason(CDef.WithdrawalReason.Sit);
    }

    /**
     * NotEqual(&lt;&gt;). As Prd (PRD). And OnlyOnceRegistered. <br />
     * PRD: 商品に魅力がないから
     */
    public void setWithdrawalReasonCode_NotEqual_Prd() {
        setWithdrawalReasonCode_NotEqual_AsWithdrawalReason(CDef.WithdrawalReason.Prd);
    }

    /**
     * NotEqual(&lt;&gt;). As Frt (FRT). And OnlyOnceRegistered. <br />
     * FRT: フリテンだから
     */
    public void setWithdrawalReasonCode_NotEqual_Frt() {
        setWithdrawalReasonCode_NotEqual_AsWithdrawalReason(CDef.WithdrawalReason.Frt);
    }

    /**
     * NotEqual(&lt;&gt;). As Oth (OTH). And OnlyOnceRegistered. <br />
     * OTH: その他理由
     */
    public void setWithdrawalReasonCode_NotEqual_Oth() {
        setWithdrawalReasonCode_NotEqual_AsWithdrawalReason(CDef.WithdrawalReason.Oth);
    }

    protected void doSetWithdrawalReasonCode_NotEqual(String withdrawalReasonCode) {
        regWithdrawalReasonCode(CK_NES, withdrawalReasonCode);
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason}
     * @param withdrawalReasonCodeList The collection of withdrawalReasonCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonCode_InScope(Collection<String> withdrawalReasonCodeList) {
        doSetWithdrawalReasonCode_InScope(withdrawalReasonCodeList);
    }

    /**
     * InScope {in ('a', 'b')}. As WithdrawalReason. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason} <br />
     * 会員の退会理由。なのでちょっとねがてぃぶ
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonCode_InScope_AsWithdrawalReason(Collection<CDef.WithdrawalReason> cdefList) {
        doSetWithdrawalReasonCode_InScope(cTStrL(cdefList));
    }

    public void doSetWithdrawalReasonCode_InScope(Collection<String> withdrawalReasonCodeList) {
        regINS(CK_INS, cTL(withdrawalReasonCodeList), getCValueWithdrawalReasonCode(), "WITHDRAWAL_REASON_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason}
     * @param withdrawalReasonCodeList The collection of withdrawalReasonCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonCode_NotInScope(Collection<String> withdrawalReasonCodeList) {
        doSetWithdrawalReasonCode_NotInScope(withdrawalReasonCodeList);
    }

    /**
     * NotInScope {not in ('a', 'b')}. As WithdrawalReason. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason} <br />
     * 会員の退会理由。なのでちょっとねがてぃぶ
     * @param cdefList The list of classification definition (as ENUM type). (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonCode_NotInScope_AsWithdrawalReason(Collection<CDef.WithdrawalReason> cdefList) {
        doSetWithdrawalReasonCode_NotInScope(cTStrL(cdefList));
    }

    public void doSetWithdrawalReasonCode_NotInScope(Collection<String> withdrawalReasonCodeList) {
        regINS(CK_NINS, cTL(withdrawalReasonCodeList), getCValueWithdrawalReasonCode(), "WITHDRAWAL_REASON_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select WITHDRAWAL_REASON_CODE from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by WITHDRAWAL_REASON_CODE, named 'memberWithdrawalAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsMemberWithdrawalList</span>(new SubQuery&lt;MemberWithdrawalCB&gt;() {
     *     public void query(MemberWithdrawalCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberWithdrawalList for 'exists'. (NotNull)
     */
    public void existsMemberWithdrawalList(SubQuery<MemberWithdrawalCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepWithdrawalReasonCode_ExistsReferrer_MemberWithdrawalList(cb.query());
        registerExistsReferrer(cb.query(), "WITHDRAWAL_REASON_CODE", "WITHDRAWAL_REASON_CODE", pp, "memberWithdrawalList");
    }
    public abstract String keepWithdrawalReasonCode_ExistsReferrer_MemberWithdrawalList(MemberWithdrawalCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select WITHDRAWAL_REASON_CODE from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by WITHDRAWAL_REASON_CODE, named 'memberWithdrawalAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsMemberWithdrawalList</span>(new SubQuery&lt;MemberWithdrawalCB&gt;() {
     *     public void query(MemberWithdrawalCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of WithdrawalReasonCode_NotExistsReferrer_MemberWithdrawalList for 'not exists'. (NotNull)
     */
    public void notExistsMemberWithdrawalList(SubQuery<MemberWithdrawalCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepWithdrawalReasonCode_NotExistsReferrer_MemberWithdrawalList(cb.query());
        registerNotExistsReferrer(cb.query(), "WITHDRAWAL_REASON_CODE", "WITHDRAWAL_REASON_CODE", pp, "memberWithdrawalList");
    }
    public abstract String keepWithdrawalReasonCode_NotExistsReferrer_MemberWithdrawalList(MemberWithdrawalCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select WITHDRAWAL_REASON_CODE from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by WITHDRAWAL_REASON_CODE, named 'memberWithdrawalAsOne'.
     * @param subQuery The sub-query of MemberWithdrawalList for 'in-scope'. (NotNull)
     */
    public void inScopeMemberWithdrawalList(SubQuery<MemberWithdrawalCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepWithdrawalReasonCode_InScopeRelation_MemberWithdrawalList(cb.query());
        registerInScopeRelation(cb.query(), "WITHDRAWAL_REASON_CODE", "WITHDRAWAL_REASON_CODE", pp, "memberWithdrawalList");
    }
    public abstract String keepWithdrawalReasonCode_InScopeRelation_MemberWithdrawalList(MemberWithdrawalCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select WITHDRAWAL_REASON_CODE from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by WITHDRAWAL_REASON_CODE, named 'memberWithdrawalAsOne'.
     * @param subQuery The sub-query of MemberWithdrawalList for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberWithdrawalList(SubQuery<MemberWithdrawalCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepWithdrawalReasonCode_NotInScopeRelation_MemberWithdrawalList(cb.query());
        registerNotInScopeRelation(cb.query(), "WITHDRAWAL_REASON_CODE", "WITHDRAWAL_REASON_CODE", pp, "memberWithdrawalList");
    }
    public abstract String keepWithdrawalReasonCode_NotInScopeRelation_MemberWithdrawalList(MemberWithdrawalCQ sq);

    public void xsderiveMemberWithdrawalList(String fn, SubQuery<MemberWithdrawalCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepWithdrawalReasonCode_SpecifyDerivedReferrer_MemberWithdrawalList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "WITHDRAWAL_REASON_CODE", "WITHDRAWAL_REASON_CODE", pp, "memberWithdrawalList", al, op);
    }
    public abstract String keepWithdrawalReasonCode_SpecifyDerivedReferrer_MemberWithdrawalList(MemberWithdrawalCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br />
     * {FOO &lt;= (select max(BAR) from MEMBER_WITHDRAWAL where ...)} <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by WITHDRAWAL_REASON_CODE, named 'memberWithdrawalAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedMemberWithdrawalList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;MemberWithdrawalCB&gt;() {
     *     public void query(MemberWithdrawalCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MemberWithdrawalCB> derivedMemberWithdrawalList() {
        return xcreateQDRFunctionMemberWithdrawalList();
    }
    protected HpQDRFunction<MemberWithdrawalCB> xcreateQDRFunctionMemberWithdrawalList() {
        return new HpQDRFunction<MemberWithdrawalCB>(new HpQDRSetupper<MemberWithdrawalCB>() {
            public void setup(String fn, SubQuery<MemberWithdrawalCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveMemberWithdrawalList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveMemberWithdrawalList(String fn, SubQuery<MemberWithdrawalCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberWithdrawalCB cb = new MemberWithdrawalCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepWithdrawalReasonCode_QueryDerivedReferrer_MemberWithdrawalList(cb.query()); String prpp = keepWithdrawalReasonCode_QueryDerivedReferrer_MemberWithdrawalListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "WITHDRAWAL_REASON_CODE", "WITHDRAWAL_REASON_CODE", sqpp, "memberWithdrawalList", rd, vl, prpp, op);
    }
    public abstract String keepWithdrawalReasonCode_QueryDerivedReferrer_MemberWithdrawalList(MemberWithdrawalCQ sq);
    public abstract String keepWithdrawalReasonCode_QueryDerivedReferrer_MemberWithdrawalListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason}
     */
    public void setWithdrawalReasonCode_IsNull() { regWithdrawalReasonCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * (退会理由コード)WITHDRAWAL_REASON_CODE: {PK, NotNull, CHAR(3), classification=WithdrawalReason}
     */
    public void setWithdrawalReasonCode_IsNotNull() { regWithdrawalReasonCode(CK_ISNN, DOBJ); }

    protected void regWithdrawalReasonCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueWithdrawalReasonCode(), "WITHDRAWAL_REASON_CODE"); }
    protected abstract ConditionValue getCValueWithdrawalReasonCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonText The value of withdrawalReasonText as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_Equal(String withdrawalReasonText) {
        doSetWithdrawalReasonText_Equal(fRES(withdrawalReasonText));
    }

    protected void doSetWithdrawalReasonText_Equal(String withdrawalReasonText) {
        regWithdrawalReasonText(CK_EQ, withdrawalReasonText);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonText The value of withdrawalReasonText as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_NotEqual(String withdrawalReasonText) {
        doSetWithdrawalReasonText_NotEqual(fRES(withdrawalReasonText));
    }

    protected void doSetWithdrawalReasonText_NotEqual(String withdrawalReasonText) {
        regWithdrawalReasonText(CK_NES, withdrawalReasonText);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonText The value of withdrawalReasonText as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_GreaterThan(String withdrawalReasonText) {
        regWithdrawalReasonText(CK_GT, fRES(withdrawalReasonText));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonText The value of withdrawalReasonText as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_LessThan(String withdrawalReasonText) {
        regWithdrawalReasonText(CK_LT, fRES(withdrawalReasonText));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonText The value of withdrawalReasonText as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_GreaterEqual(String withdrawalReasonText) {
        regWithdrawalReasonText(CK_GE, fRES(withdrawalReasonText));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonText The value of withdrawalReasonText as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_LessEqual(String withdrawalReasonText) {
        regWithdrawalReasonText(CK_LE, fRES(withdrawalReasonText));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonTextList The collection of withdrawalReasonText as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_InScope(Collection<String> withdrawalReasonTextList) {
        doSetWithdrawalReasonText_InScope(withdrawalReasonTextList);
    }

    public void doSetWithdrawalReasonText_InScope(Collection<String> withdrawalReasonTextList) {
        regINS(CK_INS, cTL(withdrawalReasonTextList), getCValueWithdrawalReasonText(), "WITHDRAWAL_REASON_TEXT");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonTextList The collection of withdrawalReasonText as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_NotInScope(Collection<String> withdrawalReasonTextList) {
        doSetWithdrawalReasonText_NotInScope(withdrawalReasonTextList);
    }

    public void doSetWithdrawalReasonText_NotInScope(Collection<String> withdrawalReasonTextList) {
        regINS(CK_NINS, cTL(withdrawalReasonTextList), getCValueWithdrawalReasonText(), "WITHDRAWAL_REASON_TEXT");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonText The value of withdrawalReasonText as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setWithdrawalReasonText_PrefixSearch(String withdrawalReasonText) {
        setWithdrawalReasonText_LikeSearch(withdrawalReasonText, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)} <br />
     * <pre>e.g. setWithdrawalReasonText_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param withdrawalReasonText The value of withdrawalReasonText as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setWithdrawalReasonText_LikeSearch(String withdrawalReasonText, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(withdrawalReasonText), getCValueWithdrawalReasonText(), "WITHDRAWAL_REASON_TEXT", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * (退会理由テキスト)WITHDRAWAL_REASON_TEXT: {NotNull, CLOB(2147483647)}
     * @param withdrawalReasonText The value of withdrawalReasonText as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setWithdrawalReasonText_NotLikeSearch(String withdrawalReasonText, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(withdrawalReasonText), getCValueWithdrawalReasonText(), "WITHDRAWAL_REASON_TEXT", likeSearchOption);
    }

    protected void regWithdrawalReasonText(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueWithdrawalReasonText(), "WITHDRAWAL_REASON_TEXT"); }
    protected abstract ConditionValue getCValueWithdrawalReasonText();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
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
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
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
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_GreaterThan(Integer displayOrder) {
        regDisplayOrder(CK_GT, displayOrder);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as lessThan. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_LessThan(Integer displayOrder) {
        regDisplayOrder(CK_LT, displayOrder);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_GreaterEqual(Integer displayOrder) {
        regDisplayOrder(CK_GE, displayOrder);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrder The value of displayOrder as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setDisplayOrder_LessEqual(Integer displayOrder) {
        regDisplayOrder(CK_LE, displayOrder);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param minNumber The min number of displayOrder. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of displayOrder. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setDisplayOrder_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueDisplayOrder(), "DISPLAY_ORDER", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
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
     * DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @param displayOrderList The collection of displayOrder as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setDisplayOrder_NotInScope(Collection<Integer> displayOrderList) {
        doSetDisplayOrder_NotInScope(displayOrderList);
    }

    protected void doSetDisplayOrder_NotInScope(Collection<Integer> displayOrderList) {
        regINS(CK_NINS, cTL(displayOrderList), getCValueDisplayOrder(), "DISPLAY_ORDER");
    }

    protected void regDisplayOrder(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueDisplayOrder(), "DISPLAY_ORDER"); }
    protected abstract ConditionValue getCValueDisplayOrder();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;WithdrawalReasonCB&gt;() {
     *     public void query(WithdrawalReasonCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WithdrawalReasonCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ, WithdrawalReasonCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;WithdrawalReasonCB&gt;() {
     *     public void query(WithdrawalReasonCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WithdrawalReasonCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES, WithdrawalReasonCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;WithdrawalReasonCB&gt;() {
     *     public void query(WithdrawalReasonCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WithdrawalReasonCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT, WithdrawalReasonCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;WithdrawalReasonCB&gt;() {
     *     public void query(WithdrawalReasonCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WithdrawalReasonCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT, WithdrawalReasonCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;WithdrawalReasonCB&gt;() {
     *     public void query(WithdrawalReasonCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WithdrawalReasonCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE, WithdrawalReasonCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;WithdrawalReasonCB&gt;() {
     *     public void query(WithdrawalReasonCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<WithdrawalReasonCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE, WithdrawalReasonCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        WithdrawalReasonCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(WithdrawalReasonCQ sq);

    protected WithdrawalReasonCB xcreateScalarConditionCB() {
        WithdrawalReasonCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected WithdrawalReasonCB xcreateScalarConditionPartitionByCB() {
        WithdrawalReasonCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<WithdrawalReasonCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        WithdrawalReasonCB cb = new WithdrawalReasonCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "WITHDRAWAL_REASON_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(WithdrawalReasonCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<WithdrawalReasonCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(WithdrawalReasonCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        WithdrawalReasonCB cb = new WithdrawalReasonCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "WITHDRAWAL_REASON_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(WithdrawalReasonCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<WithdrawalReasonCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        WithdrawalReasonCB cb = new WithdrawalReasonCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(WithdrawalReasonCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(SubQuery<WithdrawalReasonCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        WithdrawalReasonCB cb = new WithdrawalReasonCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(WithdrawalReasonCQ sq);

    // ===================================================================================
    //                                                                        Manual Order
    //                                                                        ============
    /**
     * Order along manual ordering information.
     * <pre>
     * MemberCB cb = new MemberCB();
     * ManualOrderBean mob = new ManualOrderBean();
     * mob.<span style="color: #DD4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #DD4747">withManualOrder(mob)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * MemberCB cb = new MemberCB();
     * ManualOrderBean mob = new ManualOrderBean();
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #DD4747">withManualOrder(mob)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param mob The bean of manual order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderBean mob) { // is user public!
        xdoWithManualOrder(mob);
    }

    // ===================================================================================
    //                                                                    Small Adjustment
    //                                                                    ================
    /**
     * Order along the list of manual values. #beforejava8 <br />
     * This function with Union is unsupported! <br />
     * The order values are bound (treated as bind parameter).
     * <pre>
     * MemberCB cb = new MemberCB();
     * List&lt;CDef.MemberStatus&gt; orderValueList = new ArrayList&lt;CDef.MemberStatus&gt;();
     * orderValueList.add(CDef.MemberStatus.Withdrawal);
     * orderValueList.add(CDef.MemberStatus.Formalized);
     * orderValueList.add(CDef.MemberStatus.Provisional);
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #DD4747">withManualOrder(orderValueList)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * @param orderValueList The list of order values for manual ordering. (NotNull)
     */
    public void withManualOrder(List<? extends Object> orderValueList) { // is user public!
        assertObjectNotNull("withManualOrder(orderValueList)", orderValueList);
        final ManualOrderBean manualOrderBean = new ManualOrderBean();
        manualOrderBean.acceptOrderValueList(orderValueList);
        withManualOrder(manualOrderBean);
    }

    @Override
    protected void filterFromToOption(FromToOption option) {
        option.allowOneSide();
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected WithdrawalReasonCB newMyCB() {
        return new WithdrawalReasonCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabUDT() { return Date.class.getName(); }
    protected String xabCQ() { return WithdrawalReasonCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
