/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.cbean.cq.bs;

import java.util.Map;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import com.example.dbflute.cdi.dbflute.cbean.cq.ciq.*;
import com.example.dbflute.cdi.dbflute.cbean.*;
import com.example.dbflute.cdi.dbflute.cbean.cq.*;

/**
 * The base condition-query of MEMBER_STATUS.
 * @author DBFlute(AutoGenerator)
 */
public class BsMemberStatusCQ extends AbstractBsMemberStatusCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberStatusCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberStatusCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from MEMBER_STATUS) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public MemberStatusCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected MemberStatusCIQ xcreateCIQ() {
        MemberStatusCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected MemberStatusCIQ xnewCIQ() {
        return new MemberStatusCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join MEMBER_STATUS on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public MemberStatusCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        MemberStatusCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    protected ConditionValue _memberStatusCode;
    public ConditionValue getMemberStatusCode() {
        if (_memberStatusCode == null) { _memberStatusCode = nCV(); }
        return _memberStatusCode;
    }
    protected ConditionValue getCValueMemberStatusCode() { return getMemberStatusCode(); }

    protected Map<String, MemberCQ> _memberStatusCode_ExistsReferrer_MemberListMap;
    public Map<String, MemberCQ> getMemberStatusCode_ExistsReferrer_MemberList() { return _memberStatusCode_ExistsReferrer_MemberListMap; }
    public String keepMemberStatusCode_ExistsReferrer_MemberList(MemberCQ subQuery) {
        if (_memberStatusCode_ExistsReferrer_MemberListMap == null) { _memberStatusCode_ExistsReferrer_MemberListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_ExistsReferrer_MemberListMap.size() + 1);
        _memberStatusCode_ExistsReferrer_MemberListMap.put(key, subQuery); return "memberStatusCode_ExistsReferrer_MemberList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberStatusCode_ExistsReferrer_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberStatusCode_ExistsReferrer_MemberLoginList() { return _memberStatusCode_ExistsReferrer_MemberLoginListMap; }
    public String keepMemberStatusCode_ExistsReferrer_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberStatusCode_ExistsReferrer_MemberLoginListMap == null) { _memberStatusCode_ExistsReferrer_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_ExistsReferrer_MemberLoginListMap.size() + 1);
        _memberStatusCode_ExistsReferrer_MemberLoginListMap.put(key, subQuery); return "memberStatusCode_ExistsReferrer_MemberLoginList." + key;
    }

    protected Map<String, MemberCQ> _memberStatusCode_NotExistsReferrer_MemberListMap;
    public Map<String, MemberCQ> getMemberStatusCode_NotExistsReferrer_MemberList() { return _memberStatusCode_NotExistsReferrer_MemberListMap; }
    public String keepMemberStatusCode_NotExistsReferrer_MemberList(MemberCQ subQuery) {
        if (_memberStatusCode_NotExistsReferrer_MemberListMap == null) { _memberStatusCode_NotExistsReferrer_MemberListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_NotExistsReferrer_MemberListMap.size() + 1);
        _memberStatusCode_NotExistsReferrer_MemberListMap.put(key, subQuery); return "memberStatusCode_NotExistsReferrer_MemberList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberStatusCode_NotExistsReferrer_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberStatusCode_NotExistsReferrer_MemberLoginList() { return _memberStatusCode_NotExistsReferrer_MemberLoginListMap; }
    public String keepMemberStatusCode_NotExistsReferrer_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberStatusCode_NotExistsReferrer_MemberLoginListMap == null) { _memberStatusCode_NotExistsReferrer_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_NotExistsReferrer_MemberLoginListMap.size() + 1);
        _memberStatusCode_NotExistsReferrer_MemberLoginListMap.put(key, subQuery); return "memberStatusCode_NotExistsReferrer_MemberLoginList." + key;
    }

    protected Map<String, MemberCQ> _memberStatusCode_InScopeRelation_MemberListMap;
    public Map<String, MemberCQ> getMemberStatusCode_InScopeRelation_MemberList() { return _memberStatusCode_InScopeRelation_MemberListMap; }
    public String keepMemberStatusCode_InScopeRelation_MemberList(MemberCQ subQuery) {
        if (_memberStatusCode_InScopeRelation_MemberListMap == null) { _memberStatusCode_InScopeRelation_MemberListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_InScopeRelation_MemberListMap.size() + 1);
        _memberStatusCode_InScopeRelation_MemberListMap.put(key, subQuery); return "memberStatusCode_InScopeRelation_MemberList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberStatusCode_InScopeRelation_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberStatusCode_InScopeRelation_MemberLoginList() { return _memberStatusCode_InScopeRelation_MemberLoginListMap; }
    public String keepMemberStatusCode_InScopeRelation_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberStatusCode_InScopeRelation_MemberLoginListMap == null) { _memberStatusCode_InScopeRelation_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_InScopeRelation_MemberLoginListMap.size() + 1);
        _memberStatusCode_InScopeRelation_MemberLoginListMap.put(key, subQuery); return "memberStatusCode_InScopeRelation_MemberLoginList." + key;
    }

    protected Map<String, MemberCQ> _memberStatusCode_NotInScopeRelation_MemberListMap;
    public Map<String, MemberCQ> getMemberStatusCode_NotInScopeRelation_MemberList() { return _memberStatusCode_NotInScopeRelation_MemberListMap; }
    public String keepMemberStatusCode_NotInScopeRelation_MemberList(MemberCQ subQuery) {
        if (_memberStatusCode_NotInScopeRelation_MemberListMap == null) { _memberStatusCode_NotInScopeRelation_MemberListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_NotInScopeRelation_MemberListMap.size() + 1);
        _memberStatusCode_NotInScopeRelation_MemberListMap.put(key, subQuery); return "memberStatusCode_NotInScopeRelation_MemberList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberStatusCode_NotInScopeRelation_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberStatusCode_NotInScopeRelation_MemberLoginList() { return _memberStatusCode_NotInScopeRelation_MemberLoginListMap; }
    public String keepMemberStatusCode_NotInScopeRelation_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberStatusCode_NotInScopeRelation_MemberLoginListMap == null) { _memberStatusCode_NotInScopeRelation_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_NotInScopeRelation_MemberLoginListMap.size() + 1);
        _memberStatusCode_NotInScopeRelation_MemberLoginListMap.put(key, subQuery); return "memberStatusCode_NotInScopeRelation_MemberLoginList." + key;
    }

    protected Map<String, MemberCQ> _memberStatusCode_SpecifyDerivedReferrer_MemberListMap;
    public Map<String, MemberCQ> getMemberStatusCode_SpecifyDerivedReferrer_MemberList() { return _memberStatusCode_SpecifyDerivedReferrer_MemberListMap; }
    public String keepMemberStatusCode_SpecifyDerivedReferrer_MemberList(MemberCQ subQuery) {
        if (_memberStatusCode_SpecifyDerivedReferrer_MemberListMap == null) { _memberStatusCode_SpecifyDerivedReferrer_MemberListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_SpecifyDerivedReferrer_MemberListMap.size() + 1);
        _memberStatusCode_SpecifyDerivedReferrer_MemberListMap.put(key, subQuery); return "memberStatusCode_SpecifyDerivedReferrer_MemberList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberStatusCode_SpecifyDerivedReferrer_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberStatusCode_SpecifyDerivedReferrer_MemberLoginList() { return _memberStatusCode_SpecifyDerivedReferrer_MemberLoginListMap; }
    public String keepMemberStatusCode_SpecifyDerivedReferrer_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberStatusCode_SpecifyDerivedReferrer_MemberLoginListMap == null) { _memberStatusCode_SpecifyDerivedReferrer_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_SpecifyDerivedReferrer_MemberLoginListMap.size() + 1);
        _memberStatusCode_SpecifyDerivedReferrer_MemberLoginListMap.put(key, subQuery); return "memberStatusCode_SpecifyDerivedReferrer_MemberLoginList." + key;
    }

    protected Map<String, MemberCQ> _memberStatusCode_QueryDerivedReferrer_MemberListMap;
    public Map<String, MemberCQ> getMemberStatusCode_QueryDerivedReferrer_MemberList() { return _memberStatusCode_QueryDerivedReferrer_MemberListMap; }
    public String keepMemberStatusCode_QueryDerivedReferrer_MemberList(MemberCQ subQuery) {
        if (_memberStatusCode_QueryDerivedReferrer_MemberListMap == null) { _memberStatusCode_QueryDerivedReferrer_MemberListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_QueryDerivedReferrer_MemberListMap.size() + 1);
        _memberStatusCode_QueryDerivedReferrer_MemberListMap.put(key, subQuery); return "memberStatusCode_QueryDerivedReferrer_MemberList." + key;
    }
    protected Map<String, Object> _memberStatusCode_QueryDerivedReferrer_MemberListParameterMap;
    public Map<String, Object> getMemberStatusCode_QueryDerivedReferrer_MemberListParameter() { return _memberStatusCode_QueryDerivedReferrer_MemberListParameterMap; }
    public String keepMemberStatusCode_QueryDerivedReferrer_MemberListParameter(Object parameterValue) {
        if (_memberStatusCode_QueryDerivedReferrer_MemberListParameterMap == null) { _memberStatusCode_QueryDerivedReferrer_MemberListParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_memberStatusCode_QueryDerivedReferrer_MemberListParameterMap.size() + 1);
        _memberStatusCode_QueryDerivedReferrer_MemberListParameterMap.put(key, parameterValue); return "memberStatusCode_QueryDerivedReferrer_MemberListParameter." + key;
    }

    protected Map<String, MemberLoginCQ> _memberStatusCode_QueryDerivedReferrer_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberStatusCode_QueryDerivedReferrer_MemberLoginList() { return _memberStatusCode_QueryDerivedReferrer_MemberLoginListMap; }
    public String keepMemberStatusCode_QueryDerivedReferrer_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberStatusCode_QueryDerivedReferrer_MemberLoginListMap == null) { _memberStatusCode_QueryDerivedReferrer_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_QueryDerivedReferrer_MemberLoginListMap.size() + 1);
        _memberStatusCode_QueryDerivedReferrer_MemberLoginListMap.put(key, subQuery); return "memberStatusCode_QueryDerivedReferrer_MemberLoginList." + key;
    }
    protected Map<String, Object> _memberStatusCode_QueryDerivedReferrer_MemberLoginListParameterMap;
    public Map<String, Object> getMemberStatusCode_QueryDerivedReferrer_MemberLoginListParameter() { return _memberStatusCode_QueryDerivedReferrer_MemberLoginListParameterMap; }
    public String keepMemberStatusCode_QueryDerivedReferrer_MemberLoginListParameter(Object parameterValue) {
        if (_memberStatusCode_QueryDerivedReferrer_MemberLoginListParameterMap == null) { _memberStatusCode_QueryDerivedReferrer_MemberLoginListParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_memberStatusCode_QueryDerivedReferrer_MemberLoginListParameterMap.size() + 1);
        _memberStatusCode_QueryDerivedReferrer_MemberLoginListParameterMap.put(key, parameterValue); return "memberStatusCode_QueryDerivedReferrer_MemberLoginListParameter." + key;
    }

    /** 
     * Add order-by as ascend. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus}
     * @return this. (NotNull)
     */
    public BsMemberStatusCQ addOrderBy_MemberStatusCode_Asc() { regOBA("MEMBER_STATUS_CODE"); return this; }

    /**
     * Add order-by as descend. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {PK, NotNull, CHAR(3), classification=MemberStatus}
     * @return this. (NotNull)
     */
    public BsMemberStatusCQ addOrderBy_MemberStatusCode_Desc() { regOBD("MEMBER_STATUS_CODE"); return this; }

    protected ConditionValue _memberStatusName;
    public ConditionValue getMemberStatusName() {
        if (_memberStatusName == null) { _memberStatusName = nCV(); }
        return _memberStatusName;
    }
    protected ConditionValue getCValueMemberStatusName() { return getMemberStatusName(); }

    /** 
     * Add order-by as ascend. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsMemberStatusCQ addOrderBy_MemberStatusName_Asc() { regOBA("MEMBER_STATUS_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (会員ステータス名称)MEMBER_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsMemberStatusCQ addOrderBy_MemberStatusName_Desc() { regOBD("MEMBER_STATUS_NAME"); return this; }

    protected ConditionValue _description;
    public ConditionValue getDescription() {
        if (_description == null) { _description = nCV(); }
        return _description;
    }
    protected ConditionValue getCValueDescription() { return getDescription(); }

    /** 
     * Add order-by as ascend. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberStatusCQ addOrderBy_Description_Asc() { regOBA("DESCRIPTION"); return this; }

    /**
     * Add order-by as descend. <br />
     * (説明)DESCRIPTION: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberStatusCQ addOrderBy_Description_Desc() { regOBD("DESCRIPTION"); return this; }

    protected ConditionValue _displayOrder;
    public ConditionValue getDisplayOrder() {
        if (_displayOrder == null) { _displayOrder = nCV(); }
        return _displayOrder;
    }
    protected ConditionValue getCValueDisplayOrder() { return getDisplayOrder(); }

    /** 
     * Add order-by as ascend. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @return this. (NotNull)
     */
    public BsMemberStatusCQ addOrderBy_DisplayOrder_Asc() { regOBA("DISPLAY_ORDER"); return this; }

    /**
     * Add order-by as descend. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @return this. (NotNull)
     */
    public BsMemberStatusCQ addOrderBy_DisplayOrder_Desc() { regOBD("DISPLAY_ORDER"); return this; }

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
    public BsMemberStatusCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
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
    public BsMemberStatusCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(ConditionQuery baseQueryAsSuper, ConditionQuery unionQueryAsSuper) {
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
    protected Map<String, MemberStatusCQ> _scalarConditionMap;
    public Map<String, MemberStatusCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(MemberStatusCQ subQuery) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(key, subQuery); return "scalarCondition." + key;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, MemberStatusCQ> _specifyMyselfDerivedMap;
    public Map<String, MemberStatusCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(MemberStatusCQ subQuery) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(key, subQuery); return "specifyMyselfDerived." + key;
    }

    protected Map<String, MemberStatusCQ> _queryMyselfDerivedMap;
    public Map<String, MemberStatusCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(MemberStatusCQ subQuery) {
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
    protected Map<String, MemberStatusCQ> _myselfExistsMap;
    public Map<String, MemberStatusCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(MemberStatusCQ subQuery) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(key, subQuery); return "myselfExists." + key;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, MemberStatusCQ> _myselfInScopeMap;
    public Map<String, MemberStatusCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(MemberStatusCQ subQuery) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(key, subQuery); return "myselfInScope." + key;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return MemberStatusCB.class.getName(); }
    protected String xCQ() { return MemberStatusCQ.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
