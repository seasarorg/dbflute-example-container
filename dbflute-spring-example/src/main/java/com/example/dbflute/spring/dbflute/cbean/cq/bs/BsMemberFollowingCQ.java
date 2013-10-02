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

import java.util.Map;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import com.example.dbflute.spring.dbflute.cbean.cq.ciq.*;
import com.example.dbflute.spring.dbflute.cbean.*;
import com.example.dbflute.spring.dbflute.cbean.cq.*;

/**
 * The base condition-query of MEMBER_FOLLOWING.
 * @author DBFlute(AutoGenerator)
 */
public class BsMemberFollowingCQ extends AbstractBsMemberFollowingCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberFollowingCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberFollowingCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from MEMBER_FOLLOWING) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public MemberFollowingCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected MemberFollowingCIQ xcreateCIQ() {
        MemberFollowingCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected MemberFollowingCIQ xnewCIQ() {
        return new MemberFollowingCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join MEMBER_FOLLOWING on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public MemberFollowingCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        MemberFollowingCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    protected ConditionValue _memberFollowingId;
    public ConditionValue getMemberFollowingId() {
        if (_memberFollowingId == null) { _memberFollowingId = nCV(); }
        return _memberFollowingId;
    }
    protected ConditionValue getCValueMemberFollowingId() { return getMemberFollowingId(); }

    /** 
     * Add order-by as ascend. <br />
     * (会員フォローイングID)MEMBER_FOLLOWING_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addOrderBy_MemberFollowingId_Asc() { regOBA("MEMBER_FOLLOWING_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * (会員フォローイングID)MEMBER_FOLLOWING_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addOrderBy_MemberFollowingId_Desc() { regOBD("MEMBER_FOLLOWING_ID"); return this; }

    protected ConditionValue _myMemberId;
    public ConditionValue getMyMemberId() {
        if (_myMemberId == null) { _myMemberId = nCV(); }
        return _myMemberId;
    }
    protected ConditionValue getCValueMyMemberId() { return getMyMemberId(); }

    protected Map<String, MemberCQ> _myMemberId_InScopeRelation_MemberByMyMemberIdMap;
    public Map<String, MemberCQ> getMyMemberId_InScopeRelation_MemberByMyMemberId() { return _myMemberId_InScopeRelation_MemberByMyMemberIdMap; }
    public String keepMyMemberId_InScopeRelation_MemberByMyMemberId(MemberCQ subQuery) {
        if (_myMemberId_InScopeRelation_MemberByMyMemberIdMap == null) { _myMemberId_InScopeRelation_MemberByMyMemberIdMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myMemberId_InScopeRelation_MemberByMyMemberIdMap.size() + 1);
        _myMemberId_InScopeRelation_MemberByMyMemberIdMap.put(key, subQuery); return "myMemberId_InScopeRelation_MemberByMyMemberId." + key;
    }

    protected Map<String, MemberCQ> _myMemberId_NotInScopeRelation_MemberByMyMemberIdMap;
    public Map<String, MemberCQ> getMyMemberId_NotInScopeRelation_MemberByMyMemberId() { return _myMemberId_NotInScopeRelation_MemberByMyMemberIdMap; }
    public String keepMyMemberId_NotInScopeRelation_MemberByMyMemberId(MemberCQ subQuery) {
        if (_myMemberId_NotInScopeRelation_MemberByMyMemberIdMap == null) { _myMemberId_NotInScopeRelation_MemberByMyMemberIdMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myMemberId_NotInScopeRelation_MemberByMyMemberIdMap.size() + 1);
        _myMemberId_NotInScopeRelation_MemberByMyMemberIdMap.put(key, subQuery); return "myMemberId_NotInScopeRelation_MemberByMyMemberId." + key;
    }

    /** 
     * Add order-by as ascend. <br />
     * (わたし)MY_MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER}
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addOrderBy_MyMemberId_Asc() { regOBA("MY_MEMBER_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * (わたし)MY_MEMBER_ID: {UQ, IX, NotNull, INTEGER(10), FK to MEMBER}
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addOrderBy_MyMemberId_Desc() { regOBD("MY_MEMBER_ID"); return this; }

    protected ConditionValue _yourMemberId;
    public ConditionValue getYourMemberId() {
        if (_yourMemberId == null) { _yourMemberId = nCV(); }
        return _yourMemberId;
    }
    protected ConditionValue getCValueYourMemberId() { return getYourMemberId(); }

    protected Map<String, MemberCQ> _yourMemberId_InScopeRelation_MemberByYourMemberIdMap;
    public Map<String, MemberCQ> getYourMemberId_InScopeRelation_MemberByYourMemberId() { return _yourMemberId_InScopeRelation_MemberByYourMemberIdMap; }
    public String keepYourMemberId_InScopeRelation_MemberByYourMemberId(MemberCQ subQuery) {
        if (_yourMemberId_InScopeRelation_MemberByYourMemberIdMap == null) { _yourMemberId_InScopeRelation_MemberByYourMemberIdMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_yourMemberId_InScopeRelation_MemberByYourMemberIdMap.size() + 1);
        _yourMemberId_InScopeRelation_MemberByYourMemberIdMap.put(key, subQuery); return "yourMemberId_InScopeRelation_MemberByYourMemberId." + key;
    }

    protected Map<String, MemberCQ> _yourMemberId_NotInScopeRelation_MemberByYourMemberIdMap;
    public Map<String, MemberCQ> getYourMemberId_NotInScopeRelation_MemberByYourMemberId() { return _yourMemberId_NotInScopeRelation_MemberByYourMemberIdMap; }
    public String keepYourMemberId_NotInScopeRelation_MemberByYourMemberId(MemberCQ subQuery) {
        if (_yourMemberId_NotInScopeRelation_MemberByYourMemberIdMap == null) { _yourMemberId_NotInScopeRelation_MemberByYourMemberIdMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_yourMemberId_NotInScopeRelation_MemberByYourMemberIdMap.size() + 1);
        _yourMemberId_NotInScopeRelation_MemberByYourMemberIdMap.put(key, subQuery); return "yourMemberId_NotInScopeRelation_MemberByYourMemberId." + key;
    }

    /** 
     * Add order-by as ascend. <br />
     * (あなた)YOUR_MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER}
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addOrderBy_YourMemberId_Asc() { regOBA("YOUR_MEMBER_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * (あなた)YOUR_MEMBER_ID: {UQ+, IX, NotNull, INTEGER(10), FK to MEMBER}
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addOrderBy_YourMemberId_Desc() { regOBD("YOUR_MEMBER_ID"); return this; }

    protected ConditionValue _followDatetime;
    public ConditionValue getFollowDatetime() {
        if (_followDatetime == null) { _followDatetime = nCV(); }
        return _followDatetime;
    }
    protected ConditionValue getCValueFollowDatetime() { return getFollowDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * (その瞬間)FOLLOW_DATETIME: {IX, NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addOrderBy_FollowDatetime_Asc() { regOBA("FOLLOW_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (その瞬間)FOLLOW_DATETIME: {IX, NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addOrderBy_FollowDatetime_Desc() { regOBD("FOLLOW_DATETIME"); return this; }

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
     * }, <span style="color: #FD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #FD4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #FD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #FD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #FD4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #FD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsMemberFollowingCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(ConditionQuery baseQueryAsSuper, ConditionQuery unionQueryAsSuper) {
        MemberFollowingCQ baseQuery = (MemberFollowingCQ)baseQueryAsSuper;
        MemberFollowingCQ unionQuery = (MemberFollowingCQ)unionQueryAsSuper;
        if (baseQuery.hasConditionQueryMemberByMyMemberId()) {
            unionQuery.queryMemberByMyMemberId().reflectRelationOnUnionQuery(baseQuery.queryMemberByMyMemberId(), unionQuery.queryMemberByMyMemberId());
        }
        if (baseQuery.hasConditionQueryMemberByYourMemberId()) {
            unionQuery.queryMemberByYourMemberId().reflectRelationOnUnionQuery(baseQuery.queryMemberByYourMemberId(), unionQuery.queryMemberByYourMemberId());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * (会員)MEMBER by my MY_MEMBER_ID, named 'memberByMyMemberId'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMemberByMyMemberId() {
        return getConditionQueryMemberByMyMemberId();
    }
    protected MemberCQ _conditionQueryMemberByMyMemberId;
    public MemberCQ getConditionQueryMemberByMyMemberId() {
        if (_conditionQueryMemberByMyMemberId == null) {
            _conditionQueryMemberByMyMemberId = xcreateQueryMemberByMyMemberId();
            xsetupOuterJoinMemberByMyMemberId();
        }
        return _conditionQueryMemberByMyMemberId;
    }
    protected MemberCQ xcreateQueryMemberByMyMemberId() {
        String nrp = resolveNextRelationPath("MEMBER_FOLLOWING", "memberByMyMemberId");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberCQ cq = new MemberCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberByMyMemberId");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberByMyMemberId() {
        MemberCQ cq = getConditionQueryMemberByMyMemberId();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MY_MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "memberByMyMemberId");
    }
    public boolean hasConditionQueryMemberByMyMemberId() {
        return _conditionQueryMemberByMyMemberId != null;
    }

    /**
     * Get the condition-query for relation table. <br />
     * (会員)MEMBER by my YOUR_MEMBER_ID, named 'memberByYourMemberId'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMemberByYourMemberId() {
        return getConditionQueryMemberByYourMemberId();
    }
    protected MemberCQ _conditionQueryMemberByYourMemberId;
    public MemberCQ getConditionQueryMemberByYourMemberId() {
        if (_conditionQueryMemberByYourMemberId == null) {
            _conditionQueryMemberByYourMemberId = xcreateQueryMemberByYourMemberId();
            xsetupOuterJoinMemberByYourMemberId();
        }
        return _conditionQueryMemberByYourMemberId;
    }
    protected MemberCQ xcreateQueryMemberByYourMemberId() {
        String nrp = resolveNextRelationPath("MEMBER_FOLLOWING", "memberByYourMemberId");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberCQ cq = new MemberCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberByYourMemberId");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberByYourMemberId() {
        MemberCQ cq = getConditionQueryMemberByYourMemberId();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("YOUR_MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "memberByYourMemberId");
    }
    public boolean hasConditionQueryMemberByYourMemberId() {
        return _conditionQueryMemberByYourMemberId != null;
    }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    protected Map<String, MemberFollowingCQ> _scalarConditionMap;
    public Map<String, MemberFollowingCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(MemberFollowingCQ subQuery) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(key, subQuery); return "scalarCondition." + key;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, MemberFollowingCQ> _specifyMyselfDerivedMap;
    public Map<String, MemberFollowingCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(MemberFollowingCQ subQuery) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(key, subQuery); return "specifyMyselfDerived." + key;
    }

    protected Map<String, MemberFollowingCQ> _queryMyselfDerivedMap;
    public Map<String, MemberFollowingCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(MemberFollowingCQ subQuery) {
        if (_queryMyselfDerivedMap == null) { _queryMyselfDerivedMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_queryMyselfDerivedMap.size() + 1);
        _queryMyselfDerivedMap.put(key, subQuery); return "queryMyselfDerived." + key;
    }
    protected Map<String, Object> _qyeryMyselfDerivedParameterMap;
    public Map<String, Object> getQueryMyselfDerivedParameter() { return _qyeryMyselfDerivedParameterMap; }
    public String keepQueryMyselfDerivedParameter(Object parameterValue) {
        if (_qyeryMyselfDerivedParameterMap == null) { _qyeryMyselfDerivedParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_qyeryMyselfDerivedParameterMap.size() + 1);
        _qyeryMyselfDerivedParameterMap.put(key, parameterValue); return "queryMyselfDerivedParameter." + key;
    }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, MemberFollowingCQ> _myselfExistsMap;
    public Map<String, MemberFollowingCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(MemberFollowingCQ subQuery) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(key, subQuery); return "myselfExists." + key;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, MemberFollowingCQ> _myselfInScopeMap;
    public Map<String, MemberFollowingCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(MemberFollowingCQ subQuery) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(key, subQuery); return "myselfInScope." + key;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return MemberFollowingCB.class.getName(); }
    protected String xCQ() { return MemberFollowingCQ.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
