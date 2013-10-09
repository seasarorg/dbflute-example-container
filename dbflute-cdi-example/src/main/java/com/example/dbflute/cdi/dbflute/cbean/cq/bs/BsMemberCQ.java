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
 * The base condition-query of MEMBER.
 * @author DBFlute(AutoGenerator)
 */
public class BsMemberCQ extends AbstractBsMemberCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from MEMBER) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public MemberCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected MemberCIQ xcreateCIQ() {
        MemberCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected MemberCIQ xnewCIQ() {
        return new MemberCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join MEMBER on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public MemberCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        MemberCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    protected ConditionValue _memberId;
    public ConditionValue getMemberId() {
        if (_memberId == null) { _memberId = nCV(); }
        return _memberId;
    }
    protected ConditionValue getCValueMemberId() { return getMemberId(); }

    protected Map<String, MemberAddressCQ> _memberId_ExistsReferrer_MemberAddressListMap;
    public Map<String, MemberAddressCQ> getMemberId_ExistsReferrer_MemberAddressList() { return _memberId_ExistsReferrer_MemberAddressListMap; }
    public String keepMemberId_ExistsReferrer_MemberAddressList(MemberAddressCQ subQuery) {
        if (_memberId_ExistsReferrer_MemberAddressListMap == null) { _memberId_ExistsReferrer_MemberAddressListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_ExistsReferrer_MemberAddressListMap.size() + 1);
        _memberId_ExistsReferrer_MemberAddressListMap.put(key, subQuery); return "memberId_ExistsReferrer_MemberAddressList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberId_ExistsReferrer_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberId_ExistsReferrer_MemberLoginList() { return _memberId_ExistsReferrer_MemberLoginListMap; }
    public String keepMemberId_ExistsReferrer_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberId_ExistsReferrer_MemberLoginListMap == null) { _memberId_ExistsReferrer_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_ExistsReferrer_MemberLoginListMap.size() + 1);
        _memberId_ExistsReferrer_MemberLoginListMap.put(key, subQuery); return "memberId_ExistsReferrer_MemberLoginList." + key;
    }

    protected Map<String, MemberSecurityCQ> _memberId_ExistsReferrer_MemberSecurityAsOneMap;
    public Map<String, MemberSecurityCQ> getMemberId_ExistsReferrer_MemberSecurityAsOne() { return _memberId_ExistsReferrer_MemberSecurityAsOneMap; }
    public String keepMemberId_ExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ subQuery) {
        if (_memberId_ExistsReferrer_MemberSecurityAsOneMap == null) { _memberId_ExistsReferrer_MemberSecurityAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_ExistsReferrer_MemberSecurityAsOneMap.size() + 1);
        _memberId_ExistsReferrer_MemberSecurityAsOneMap.put(key, subQuery); return "memberId_ExistsReferrer_MemberSecurityAsOne." + key;
    }

    protected Map<String, MemberServiceCQ> _memberId_ExistsReferrer_MemberServiceAsOneMap;
    public Map<String, MemberServiceCQ> getMemberId_ExistsReferrer_MemberServiceAsOne() { return _memberId_ExistsReferrer_MemberServiceAsOneMap; }
    public String keepMemberId_ExistsReferrer_MemberServiceAsOne(MemberServiceCQ subQuery) {
        if (_memberId_ExistsReferrer_MemberServiceAsOneMap == null) { _memberId_ExistsReferrer_MemberServiceAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_ExistsReferrer_MemberServiceAsOneMap.size() + 1);
        _memberId_ExistsReferrer_MemberServiceAsOneMap.put(key, subQuery); return "memberId_ExistsReferrer_MemberServiceAsOne." + key;
    }

    protected Map<String, MemberWithdrawalCQ> _memberId_ExistsReferrer_MemberWithdrawalAsOneMap;
    public Map<String, MemberWithdrawalCQ> getMemberId_ExistsReferrer_MemberWithdrawalAsOne() { return _memberId_ExistsReferrer_MemberWithdrawalAsOneMap; }
    public String keepMemberId_ExistsReferrer_MemberWithdrawalAsOne(MemberWithdrawalCQ subQuery) {
        if (_memberId_ExistsReferrer_MemberWithdrawalAsOneMap == null) { _memberId_ExistsReferrer_MemberWithdrawalAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_ExistsReferrer_MemberWithdrawalAsOneMap.size() + 1);
        _memberId_ExistsReferrer_MemberWithdrawalAsOneMap.put(key, subQuery); return "memberId_ExistsReferrer_MemberWithdrawalAsOne." + key;
    }

    protected Map<String, PurchaseCQ> _memberId_ExistsReferrer_PurchaseListMap;
    public Map<String, PurchaseCQ> getMemberId_ExistsReferrer_PurchaseList() { return _memberId_ExistsReferrer_PurchaseListMap; }
    public String keepMemberId_ExistsReferrer_PurchaseList(PurchaseCQ subQuery) {
        if (_memberId_ExistsReferrer_PurchaseListMap == null) { _memberId_ExistsReferrer_PurchaseListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_ExistsReferrer_PurchaseListMap.size() + 1);
        _memberId_ExistsReferrer_PurchaseListMap.put(key, subQuery); return "memberId_ExistsReferrer_PurchaseList." + key;
    }

    protected Map<String, MemberAddressCQ> _memberId_NotExistsReferrer_MemberAddressListMap;
    public Map<String, MemberAddressCQ> getMemberId_NotExistsReferrer_MemberAddressList() { return _memberId_NotExistsReferrer_MemberAddressListMap; }
    public String keepMemberId_NotExistsReferrer_MemberAddressList(MemberAddressCQ subQuery) {
        if (_memberId_NotExistsReferrer_MemberAddressListMap == null) { _memberId_NotExistsReferrer_MemberAddressListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotExistsReferrer_MemberAddressListMap.size() + 1);
        _memberId_NotExistsReferrer_MemberAddressListMap.put(key, subQuery); return "memberId_NotExistsReferrer_MemberAddressList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberId_NotExistsReferrer_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberId_NotExistsReferrer_MemberLoginList() { return _memberId_NotExistsReferrer_MemberLoginListMap; }
    public String keepMemberId_NotExistsReferrer_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberId_NotExistsReferrer_MemberLoginListMap == null) { _memberId_NotExistsReferrer_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotExistsReferrer_MemberLoginListMap.size() + 1);
        _memberId_NotExistsReferrer_MemberLoginListMap.put(key, subQuery); return "memberId_NotExistsReferrer_MemberLoginList." + key;
    }

    protected Map<String, MemberSecurityCQ> _memberId_NotExistsReferrer_MemberSecurityAsOneMap;
    public Map<String, MemberSecurityCQ> getMemberId_NotExistsReferrer_MemberSecurityAsOne() { return _memberId_NotExistsReferrer_MemberSecurityAsOneMap; }
    public String keepMemberId_NotExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ subQuery) {
        if (_memberId_NotExistsReferrer_MemberSecurityAsOneMap == null) { _memberId_NotExistsReferrer_MemberSecurityAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotExistsReferrer_MemberSecurityAsOneMap.size() + 1);
        _memberId_NotExistsReferrer_MemberSecurityAsOneMap.put(key, subQuery); return "memberId_NotExistsReferrer_MemberSecurityAsOne." + key;
    }

    protected Map<String, MemberServiceCQ> _memberId_NotExistsReferrer_MemberServiceAsOneMap;
    public Map<String, MemberServiceCQ> getMemberId_NotExistsReferrer_MemberServiceAsOne() { return _memberId_NotExistsReferrer_MemberServiceAsOneMap; }
    public String keepMemberId_NotExistsReferrer_MemberServiceAsOne(MemberServiceCQ subQuery) {
        if (_memberId_NotExistsReferrer_MemberServiceAsOneMap == null) { _memberId_NotExistsReferrer_MemberServiceAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotExistsReferrer_MemberServiceAsOneMap.size() + 1);
        _memberId_NotExistsReferrer_MemberServiceAsOneMap.put(key, subQuery); return "memberId_NotExistsReferrer_MemberServiceAsOne." + key;
    }

    protected Map<String, MemberWithdrawalCQ> _memberId_NotExistsReferrer_MemberWithdrawalAsOneMap;
    public Map<String, MemberWithdrawalCQ> getMemberId_NotExistsReferrer_MemberWithdrawalAsOne() { return _memberId_NotExistsReferrer_MemberWithdrawalAsOneMap; }
    public String keepMemberId_NotExistsReferrer_MemberWithdrawalAsOne(MemberWithdrawalCQ subQuery) {
        if (_memberId_NotExistsReferrer_MemberWithdrawalAsOneMap == null) { _memberId_NotExistsReferrer_MemberWithdrawalAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotExistsReferrer_MemberWithdrawalAsOneMap.size() + 1);
        _memberId_NotExistsReferrer_MemberWithdrawalAsOneMap.put(key, subQuery); return "memberId_NotExistsReferrer_MemberWithdrawalAsOne." + key;
    }

    protected Map<String, PurchaseCQ> _memberId_NotExistsReferrer_PurchaseListMap;
    public Map<String, PurchaseCQ> getMemberId_NotExistsReferrer_PurchaseList() { return _memberId_NotExistsReferrer_PurchaseListMap; }
    public String keepMemberId_NotExistsReferrer_PurchaseList(PurchaseCQ subQuery) {
        if (_memberId_NotExistsReferrer_PurchaseListMap == null) { _memberId_NotExistsReferrer_PurchaseListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotExistsReferrer_PurchaseListMap.size() + 1);
        _memberId_NotExistsReferrer_PurchaseListMap.put(key, subQuery); return "memberId_NotExistsReferrer_PurchaseList." + key;
    }

    protected Map<String, MemberAddressCQ> _memberId_SpecifyDerivedReferrer_MemberAddressListMap;
    public Map<String, MemberAddressCQ> getMemberId_SpecifyDerivedReferrer_MemberAddressList() { return _memberId_SpecifyDerivedReferrer_MemberAddressListMap; }
    public String keepMemberId_SpecifyDerivedReferrer_MemberAddressList(MemberAddressCQ subQuery) {
        if (_memberId_SpecifyDerivedReferrer_MemberAddressListMap == null) { _memberId_SpecifyDerivedReferrer_MemberAddressListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_SpecifyDerivedReferrer_MemberAddressListMap.size() + 1);
        _memberId_SpecifyDerivedReferrer_MemberAddressListMap.put(key, subQuery); return "memberId_SpecifyDerivedReferrer_MemberAddressList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberId_SpecifyDerivedReferrer_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberId_SpecifyDerivedReferrer_MemberLoginList() { return _memberId_SpecifyDerivedReferrer_MemberLoginListMap; }
    public String keepMemberId_SpecifyDerivedReferrer_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberId_SpecifyDerivedReferrer_MemberLoginListMap == null) { _memberId_SpecifyDerivedReferrer_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_SpecifyDerivedReferrer_MemberLoginListMap.size() + 1);
        _memberId_SpecifyDerivedReferrer_MemberLoginListMap.put(key, subQuery); return "memberId_SpecifyDerivedReferrer_MemberLoginList." + key;
    }

    protected Map<String, PurchaseCQ> _memberId_SpecifyDerivedReferrer_PurchaseListMap;
    public Map<String, PurchaseCQ> getMemberId_SpecifyDerivedReferrer_PurchaseList() { return _memberId_SpecifyDerivedReferrer_PurchaseListMap; }
    public String keepMemberId_SpecifyDerivedReferrer_PurchaseList(PurchaseCQ subQuery) {
        if (_memberId_SpecifyDerivedReferrer_PurchaseListMap == null) { _memberId_SpecifyDerivedReferrer_PurchaseListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_SpecifyDerivedReferrer_PurchaseListMap.size() + 1);
        _memberId_SpecifyDerivedReferrer_PurchaseListMap.put(key, subQuery); return "memberId_SpecifyDerivedReferrer_PurchaseList." + key;
    }

    protected Map<String, MemberAddressCQ> _memberId_InScopeRelation_MemberAddressListMap;
    public Map<String, MemberAddressCQ> getMemberId_InScopeRelation_MemberAddressList() { return _memberId_InScopeRelation_MemberAddressListMap; }
    public String keepMemberId_InScopeRelation_MemberAddressList(MemberAddressCQ subQuery) {
        if (_memberId_InScopeRelation_MemberAddressListMap == null) { _memberId_InScopeRelation_MemberAddressListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_InScopeRelation_MemberAddressListMap.size() + 1);
        _memberId_InScopeRelation_MemberAddressListMap.put(key, subQuery); return "memberId_InScopeRelation_MemberAddressList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberId_InScopeRelation_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberId_InScopeRelation_MemberLoginList() { return _memberId_InScopeRelation_MemberLoginListMap; }
    public String keepMemberId_InScopeRelation_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberId_InScopeRelation_MemberLoginListMap == null) { _memberId_InScopeRelation_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_InScopeRelation_MemberLoginListMap.size() + 1);
        _memberId_InScopeRelation_MemberLoginListMap.put(key, subQuery); return "memberId_InScopeRelation_MemberLoginList." + key;
    }

    protected Map<String, MemberSecurityCQ> _memberId_InScopeRelation_MemberSecurityAsOneMap;
    public Map<String, MemberSecurityCQ> getMemberId_InScopeRelation_MemberSecurityAsOne() { return _memberId_InScopeRelation_MemberSecurityAsOneMap; }
    public String keepMemberId_InScopeRelation_MemberSecurityAsOne(MemberSecurityCQ subQuery) {
        if (_memberId_InScopeRelation_MemberSecurityAsOneMap == null) { _memberId_InScopeRelation_MemberSecurityAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_InScopeRelation_MemberSecurityAsOneMap.size() + 1);
        _memberId_InScopeRelation_MemberSecurityAsOneMap.put(key, subQuery); return "memberId_InScopeRelation_MemberSecurityAsOne." + key;
    }

    protected Map<String, MemberServiceCQ> _memberId_InScopeRelation_MemberServiceAsOneMap;
    public Map<String, MemberServiceCQ> getMemberId_InScopeRelation_MemberServiceAsOne() { return _memberId_InScopeRelation_MemberServiceAsOneMap; }
    public String keepMemberId_InScopeRelation_MemberServiceAsOne(MemberServiceCQ subQuery) {
        if (_memberId_InScopeRelation_MemberServiceAsOneMap == null) { _memberId_InScopeRelation_MemberServiceAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_InScopeRelation_MemberServiceAsOneMap.size() + 1);
        _memberId_InScopeRelation_MemberServiceAsOneMap.put(key, subQuery); return "memberId_InScopeRelation_MemberServiceAsOne." + key;
    }

    protected Map<String, MemberWithdrawalCQ> _memberId_InScopeRelation_MemberWithdrawalAsOneMap;
    public Map<String, MemberWithdrawalCQ> getMemberId_InScopeRelation_MemberWithdrawalAsOne() { return _memberId_InScopeRelation_MemberWithdrawalAsOneMap; }
    public String keepMemberId_InScopeRelation_MemberWithdrawalAsOne(MemberWithdrawalCQ subQuery) {
        if (_memberId_InScopeRelation_MemberWithdrawalAsOneMap == null) { _memberId_InScopeRelation_MemberWithdrawalAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_InScopeRelation_MemberWithdrawalAsOneMap.size() + 1);
        _memberId_InScopeRelation_MemberWithdrawalAsOneMap.put(key, subQuery); return "memberId_InScopeRelation_MemberWithdrawalAsOne." + key;
    }

    protected Map<String, PurchaseCQ> _memberId_InScopeRelation_PurchaseListMap;
    public Map<String, PurchaseCQ> getMemberId_InScopeRelation_PurchaseList() { return _memberId_InScopeRelation_PurchaseListMap; }
    public String keepMemberId_InScopeRelation_PurchaseList(PurchaseCQ subQuery) {
        if (_memberId_InScopeRelation_PurchaseListMap == null) { _memberId_InScopeRelation_PurchaseListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_InScopeRelation_PurchaseListMap.size() + 1);
        _memberId_InScopeRelation_PurchaseListMap.put(key, subQuery); return "memberId_InScopeRelation_PurchaseList." + key;
    }

    protected Map<String, MemberAddressCQ> _memberId_NotInScopeRelation_MemberAddressListMap;
    public Map<String, MemberAddressCQ> getMemberId_NotInScopeRelation_MemberAddressList() { return _memberId_NotInScopeRelation_MemberAddressListMap; }
    public String keepMemberId_NotInScopeRelation_MemberAddressList(MemberAddressCQ subQuery) {
        if (_memberId_NotInScopeRelation_MemberAddressListMap == null) { _memberId_NotInScopeRelation_MemberAddressListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotInScopeRelation_MemberAddressListMap.size() + 1);
        _memberId_NotInScopeRelation_MemberAddressListMap.put(key, subQuery); return "memberId_NotInScopeRelation_MemberAddressList." + key;
    }

    protected Map<String, MemberLoginCQ> _memberId_NotInScopeRelation_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberId_NotInScopeRelation_MemberLoginList() { return _memberId_NotInScopeRelation_MemberLoginListMap; }
    public String keepMemberId_NotInScopeRelation_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberId_NotInScopeRelation_MemberLoginListMap == null) { _memberId_NotInScopeRelation_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotInScopeRelation_MemberLoginListMap.size() + 1);
        _memberId_NotInScopeRelation_MemberLoginListMap.put(key, subQuery); return "memberId_NotInScopeRelation_MemberLoginList." + key;
    }

    protected Map<String, MemberSecurityCQ> _memberId_NotInScopeRelation_MemberSecurityAsOneMap;
    public Map<String, MemberSecurityCQ> getMemberId_NotInScopeRelation_MemberSecurityAsOne() { return _memberId_NotInScopeRelation_MemberSecurityAsOneMap; }
    public String keepMemberId_NotInScopeRelation_MemberSecurityAsOne(MemberSecurityCQ subQuery) {
        if (_memberId_NotInScopeRelation_MemberSecurityAsOneMap == null) { _memberId_NotInScopeRelation_MemberSecurityAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotInScopeRelation_MemberSecurityAsOneMap.size() + 1);
        _memberId_NotInScopeRelation_MemberSecurityAsOneMap.put(key, subQuery); return "memberId_NotInScopeRelation_MemberSecurityAsOne." + key;
    }

    protected Map<String, MemberServiceCQ> _memberId_NotInScopeRelation_MemberServiceAsOneMap;
    public Map<String, MemberServiceCQ> getMemberId_NotInScopeRelation_MemberServiceAsOne() { return _memberId_NotInScopeRelation_MemberServiceAsOneMap; }
    public String keepMemberId_NotInScopeRelation_MemberServiceAsOne(MemberServiceCQ subQuery) {
        if (_memberId_NotInScopeRelation_MemberServiceAsOneMap == null) { _memberId_NotInScopeRelation_MemberServiceAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotInScopeRelation_MemberServiceAsOneMap.size() + 1);
        _memberId_NotInScopeRelation_MemberServiceAsOneMap.put(key, subQuery); return "memberId_NotInScopeRelation_MemberServiceAsOne." + key;
    }

    protected Map<String, MemberWithdrawalCQ> _memberId_NotInScopeRelation_MemberWithdrawalAsOneMap;
    public Map<String, MemberWithdrawalCQ> getMemberId_NotInScopeRelation_MemberWithdrawalAsOne() { return _memberId_NotInScopeRelation_MemberWithdrawalAsOneMap; }
    public String keepMemberId_NotInScopeRelation_MemberWithdrawalAsOne(MemberWithdrawalCQ subQuery) {
        if (_memberId_NotInScopeRelation_MemberWithdrawalAsOneMap == null) { _memberId_NotInScopeRelation_MemberWithdrawalAsOneMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotInScopeRelation_MemberWithdrawalAsOneMap.size() + 1);
        _memberId_NotInScopeRelation_MemberWithdrawalAsOneMap.put(key, subQuery); return "memberId_NotInScopeRelation_MemberWithdrawalAsOne." + key;
    }

    protected Map<String, PurchaseCQ> _memberId_NotInScopeRelation_PurchaseListMap;
    public Map<String, PurchaseCQ> getMemberId_NotInScopeRelation_PurchaseList() { return _memberId_NotInScopeRelation_PurchaseListMap; }
    public String keepMemberId_NotInScopeRelation_PurchaseList(PurchaseCQ subQuery) {
        if (_memberId_NotInScopeRelation_PurchaseListMap == null) { _memberId_NotInScopeRelation_PurchaseListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_NotInScopeRelation_PurchaseListMap.size() + 1);
        _memberId_NotInScopeRelation_PurchaseListMap.put(key, subQuery); return "memberId_NotInScopeRelation_PurchaseList." + key;
    }

    protected Map<String, MemberAddressCQ> _memberId_QueryDerivedReferrer_MemberAddressListMap;
    public Map<String, MemberAddressCQ> getMemberId_QueryDerivedReferrer_MemberAddressList() { return _memberId_QueryDerivedReferrer_MemberAddressListMap; }
    public String keepMemberId_QueryDerivedReferrer_MemberAddressList(MemberAddressCQ subQuery) {
        if (_memberId_QueryDerivedReferrer_MemberAddressListMap == null) { _memberId_QueryDerivedReferrer_MemberAddressListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_QueryDerivedReferrer_MemberAddressListMap.size() + 1);
        _memberId_QueryDerivedReferrer_MemberAddressListMap.put(key, subQuery); return "memberId_QueryDerivedReferrer_MemberAddressList." + key;
    }
    protected Map<String, Object> _memberId_QueryDerivedReferrer_MemberAddressListParameterMap;
    public Map<String, Object> getMemberId_QueryDerivedReferrer_MemberAddressListParameter() { return _memberId_QueryDerivedReferrer_MemberAddressListParameterMap; }
    public String keepMemberId_QueryDerivedReferrer_MemberAddressListParameter(Object parameterValue) {
        if (_memberId_QueryDerivedReferrer_MemberAddressListParameterMap == null) { _memberId_QueryDerivedReferrer_MemberAddressListParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_memberId_QueryDerivedReferrer_MemberAddressListParameterMap.size() + 1);
        _memberId_QueryDerivedReferrer_MemberAddressListParameterMap.put(key, parameterValue); return "memberId_QueryDerivedReferrer_MemberAddressListParameter." + key;
    }

    protected Map<String, MemberLoginCQ> _memberId_QueryDerivedReferrer_MemberLoginListMap;
    public Map<String, MemberLoginCQ> getMemberId_QueryDerivedReferrer_MemberLoginList() { return _memberId_QueryDerivedReferrer_MemberLoginListMap; }
    public String keepMemberId_QueryDerivedReferrer_MemberLoginList(MemberLoginCQ subQuery) {
        if (_memberId_QueryDerivedReferrer_MemberLoginListMap == null) { _memberId_QueryDerivedReferrer_MemberLoginListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_QueryDerivedReferrer_MemberLoginListMap.size() + 1);
        _memberId_QueryDerivedReferrer_MemberLoginListMap.put(key, subQuery); return "memberId_QueryDerivedReferrer_MemberLoginList." + key;
    }
    protected Map<String, Object> _memberId_QueryDerivedReferrer_MemberLoginListParameterMap;
    public Map<String, Object> getMemberId_QueryDerivedReferrer_MemberLoginListParameter() { return _memberId_QueryDerivedReferrer_MemberLoginListParameterMap; }
    public String keepMemberId_QueryDerivedReferrer_MemberLoginListParameter(Object parameterValue) {
        if (_memberId_QueryDerivedReferrer_MemberLoginListParameterMap == null) { _memberId_QueryDerivedReferrer_MemberLoginListParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_memberId_QueryDerivedReferrer_MemberLoginListParameterMap.size() + 1);
        _memberId_QueryDerivedReferrer_MemberLoginListParameterMap.put(key, parameterValue); return "memberId_QueryDerivedReferrer_MemberLoginListParameter." + key;
    }

    protected Map<String, PurchaseCQ> _memberId_QueryDerivedReferrer_PurchaseListMap;
    public Map<String, PurchaseCQ> getMemberId_QueryDerivedReferrer_PurchaseList() { return _memberId_QueryDerivedReferrer_PurchaseListMap; }
    public String keepMemberId_QueryDerivedReferrer_PurchaseList(PurchaseCQ subQuery) {
        if (_memberId_QueryDerivedReferrer_PurchaseListMap == null) { _memberId_QueryDerivedReferrer_PurchaseListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberId_QueryDerivedReferrer_PurchaseListMap.size() + 1);
        _memberId_QueryDerivedReferrer_PurchaseListMap.put(key, subQuery); return "memberId_QueryDerivedReferrer_PurchaseList." + key;
    }
    protected Map<String, Object> _memberId_QueryDerivedReferrer_PurchaseListParameterMap;
    public Map<String, Object> getMemberId_QueryDerivedReferrer_PurchaseListParameter() { return _memberId_QueryDerivedReferrer_PurchaseListParameterMap; }
    public String keepMemberId_QueryDerivedReferrer_PurchaseListParameter(Object parameterValue) {
        if (_memberId_QueryDerivedReferrer_PurchaseListParameterMap == null) { _memberId_QueryDerivedReferrer_PurchaseListParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_memberId_QueryDerivedReferrer_PurchaseListParameterMap.size() + 1);
        _memberId_QueryDerivedReferrer_PurchaseListParameterMap.put(key, parameterValue); return "memberId_QueryDerivedReferrer_PurchaseListParameter." + key;
    }

    /** 
     * Add order-by as ascend. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberId_Asc() { regOBA("MEMBER_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * (会員ID)MEMBER_ID: {PK, ID, NotNull, INTEGER(10), FK to MEMBER_ADDRESS}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberId_Desc() { regOBD("MEMBER_ID"); return this; }

    protected ConditionValue _memberName;
    public ConditionValue getMemberName() {
        if (_memberName == null) { _memberName = nCV(); }
        return _memberName;
    }
    protected ConditionValue getCValueMemberName() { return getMemberName(); }

    /** 
     * Add order-by as ascend. <br />
     * (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberName_Asc() { regOBA("MEMBER_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberName_Desc() { regOBD("MEMBER_NAME"); return this; }

    protected ConditionValue _memberAccount;
    public ConditionValue getMemberAccount() {
        if (_memberAccount == null) { _memberAccount = nCV(); }
        return _memberAccount;
    }
    protected ConditionValue getCValueMemberAccount() { return getMemberAccount(); }

    /** 
     * Add order-by as ascend. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberAccount_Asc() { regOBA("MEMBER_ACCOUNT"); return this; }

    /**
     * Add order-by as descend. <br />
     * (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberAccount_Desc() { regOBD("MEMBER_ACCOUNT"); return this; }

    protected ConditionValue _memberStatusCode;
    public ConditionValue getMemberStatusCode() {
        if (_memberStatusCode == null) { _memberStatusCode = nCV(); }
        return _memberStatusCode;
    }
    protected ConditionValue getCValueMemberStatusCode() { return getMemberStatusCode(); }

    protected Map<String, MemberStatusCQ> _memberStatusCode_InScopeRelation_MemberStatusMap;
    public Map<String, MemberStatusCQ> getMemberStatusCode_InScopeRelation_MemberStatus() { return _memberStatusCode_InScopeRelation_MemberStatusMap; }
    public String keepMemberStatusCode_InScopeRelation_MemberStatus(MemberStatusCQ subQuery) {
        if (_memberStatusCode_InScopeRelation_MemberStatusMap == null) { _memberStatusCode_InScopeRelation_MemberStatusMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_InScopeRelation_MemberStatusMap.size() + 1);
        _memberStatusCode_InScopeRelation_MemberStatusMap.put(key, subQuery); return "memberStatusCode_InScopeRelation_MemberStatus." + key;
    }

    protected Map<String, MemberStatusCQ> _memberStatusCode_NotInScopeRelation_MemberStatusMap;
    public Map<String, MemberStatusCQ> getMemberStatusCode_NotInScopeRelation_MemberStatus() { return _memberStatusCode_NotInScopeRelation_MemberStatusMap; }
    public String keepMemberStatusCode_NotInScopeRelation_MemberStatus(MemberStatusCQ subQuery) {
        if (_memberStatusCode_NotInScopeRelation_MemberStatusMap == null) { _memberStatusCode_NotInScopeRelation_MemberStatusMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_memberStatusCode_NotInScopeRelation_MemberStatusMap.size() + 1);
        _memberStatusCode_NotInScopeRelation_MemberStatusMap.put(key, subQuery); return "memberStatusCode_NotInScopeRelation_MemberStatus." + key;
    }

    /** 
     * Add order-by as ascend. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberStatusCode_Asc() { regOBA("MEMBER_STATUS_CODE"); return this; }

    /**
     * Add order-by as descend. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to MEMBER_STATUS, classification=MemberStatus}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberStatusCode_Desc() { regOBD("MEMBER_STATUS_CODE"); return this; }

    protected ConditionValue _formalizedDatetime;
    public ConditionValue getFormalizedDatetime() {
        if (_formalizedDatetime == null) { _formalizedDatetime = nCV(); }
        return _formalizedDatetime;
    }
    protected ConditionValue getCValueFormalizedDatetime() { return getFormalizedDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_FormalizedDatetime_Asc() { regOBA("FORMALIZED_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (正式会員日時)FORMALIZED_DATETIME: {IX, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_FormalizedDatetime_Desc() { regOBD("FORMALIZED_DATETIME"); return this; }

    protected ConditionValue _birthdate;
    public ConditionValue getBirthdate() {
        if (_birthdate == null) { _birthdate = nCV(); }
        return _birthdate;
    }
    protected ConditionValue getCValueBirthdate() { return getBirthdate(); }

    /** 
     * Add order-by as ascend. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_Birthdate_Asc() { regOBA("BIRTHDATE"); return this; }

    /**
     * Add order-by as descend. <br />
     * (生年月日)BIRTHDATE: {DATE(8)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_Birthdate_Desc() { regOBD("BIRTHDATE"); return this; }

    protected ConditionValue _registerDatetime;
    public ConditionValue getRegisterDatetime() {
        if (_registerDatetime == null) { _registerDatetime = nCV(); }
        return _registerDatetime;
    }
    protected ConditionValue getCValueRegisterDatetime() { return getRegisterDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * (登録日時)REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (登録日時)REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

    protected ConditionValue _registerUser;
    public ConditionValue getRegisterUser() {
        if (_registerUser == null) { _registerUser = nCV(); }
        return _registerUser;
    }
    protected ConditionValue getCValueRegisterUser() { return getRegisterUser(); }

    /** 
     * Add order-by as ascend. <br />
     * (登録ユーザ)REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_RegisterUser_Asc() { regOBA("REGISTER_USER"); return this; }

    /**
     * Add order-by as descend. <br />
     * (登録ユーザ)REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_RegisterUser_Desc() { regOBD("REGISTER_USER"); return this; }

    protected ConditionValue _updateDatetime;
    public ConditionValue getUpdateDatetime() {
        if (_updateDatetime == null) { _updateDatetime = nCV(); }
        return _updateDatetime;
    }
    protected ConditionValue getCValueUpdateDatetime() { return getUpdateDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * (更新日時)UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (更新日時)UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

    protected ConditionValue _updateUser;
    public ConditionValue getUpdateUser() {
        if (_updateUser == null) { _updateUser = nCV(); }
        return _updateUser;
    }
    protected ConditionValue getCValueUpdateUser() { return getUpdateUser(); }

    /** 
     * Add order-by as ascend. <br />
     * (更新ユーザ)UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UpdateUser_Asc() { regOBA("UPDATE_USER"); return this; }

    /**
     * Add order-by as descend. <br />
     * (更新ユーザ)UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UpdateUser_Desc() { regOBD("UPDATE_USER"); return this; }

    protected ConditionValue _versionNo;
    public ConditionValue getVersionNo() {
        if (_versionNo == null) { _versionNo = nCV(); }
        return _versionNo;
    }
    protected ConditionValue getCValueVersionNo() { return getVersionNo(); }

    /** 
     * Add order-by as ascend. <br />
     * (バージョンNO)VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }

    /**
     * Add order-by as descend. <br />
     * (バージョンNO)VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

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
    public BsMemberCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
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
    public BsMemberCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(ConditionQuery baseQueryAsSuper, ConditionQuery unionQueryAsSuper) {
        MemberCQ baseQuery = (MemberCQ)baseQueryAsSuper;
        MemberCQ unionQuery = (MemberCQ)unionQueryAsSuper;
        if (baseQuery.hasConditionQueryMemberStatus()) {
            unionQuery.queryMemberStatus().reflectRelationOnUnionQuery(baseQuery.queryMemberStatus(), unionQuery.queryMemberStatus());
        }
        if (baseQuery.hasConditionQueryMemberAddressAsValid()) {
            unionQuery.xsetParameterMapMemberAddressAsValid(baseQuery.getParameterMapMemberAddressAsValid());
            unionQuery.getConditionQueryMemberAddressAsValid().reflectRelationOnUnionQuery(baseQuery.getConditionQueryMemberAddressAsValid(), unionQuery.getConditionQueryMemberAddressAsValid());
        }
        if (baseQuery.hasConditionQueryMemberSecurityAsOne()) {
            unionQuery.queryMemberSecurityAsOne().reflectRelationOnUnionQuery(baseQuery.queryMemberSecurityAsOne(), unionQuery.queryMemberSecurityAsOne());
        }
        if (baseQuery.hasConditionQueryMemberServiceAsOne()) {
            unionQuery.queryMemberServiceAsOne().reflectRelationOnUnionQuery(baseQuery.queryMemberServiceAsOne(), unionQuery.queryMemberServiceAsOne());
        }
        if (baseQuery.hasConditionQueryMemberWithdrawalAsOne()) {
            unionQuery.queryMemberWithdrawalAsOne().reflectRelationOnUnionQuery(baseQuery.queryMemberWithdrawalAsOne(), unionQuery.queryMemberWithdrawalAsOne());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * (会員ステータス)MEMBER_STATUS by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberStatusCQ queryMemberStatus() {
        return getConditionQueryMemberStatus();
    }
    protected MemberStatusCQ _conditionQueryMemberStatus;
    public MemberStatusCQ getConditionQueryMemberStatus() {
        if (_conditionQueryMemberStatus == null) {
            _conditionQueryMemberStatus = xcreateQueryMemberStatus();
            xsetupOuterJoinMemberStatus();
        }
        return _conditionQueryMemberStatus;
    }
    protected MemberStatusCQ xcreateQueryMemberStatus() {
        String nrp = resolveNextRelationPath("MEMBER", "memberStatus");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberStatusCQ cq = new MemberStatusCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberStatus");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberStatus() {
        MemberStatusCQ cq = getConditionQueryMemberStatus();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE");
        registerOuterJoin(cq, joinOnMap, "memberStatus");
    }
    public boolean hasConditionQueryMemberStatus() {
        return _conditionQueryMemberStatus != null;
    }

    /**
     * Get the condition-query for relation table. <br />
     * (会員住所情報)MEMBER_ADDRESS by my MEMBER_ID, named 'memberAddressAsValid'.
     * @param targetDate The bind parameter of fixed condition for targetDate. (NotNull)
     * @return The instance of condition-query. (NotNull)
     */
    public MemberAddressCQ queryMemberAddressAsValid(java.util.Date targetDate) {
        Map<String, Object> parameterMap = getParameterMapMemberAddressAsValid();
        parameterMap.put("targetDate", fCTPD(targetDate));
        assertFixedConditionDynamicParameter("memberAddressAsValid", parameterMap);
        return getConditionQueryMemberAddressAsValid();
    }
    protected MemberAddressCQ _conditionQueryMemberAddressAsValid;
    public MemberAddressCQ getConditionQueryMemberAddressAsValid() {
        if (_conditionQueryMemberAddressAsValid == null) {
            _conditionQueryMemberAddressAsValid = xcreateQueryMemberAddressAsValid();
            xsetupOuterJoinMemberAddressAsValid();
        }
        return _conditionQueryMemberAddressAsValid;
    }
    protected Map<String, Object> _parameterMapMemberAddressAsValid;
    public Map<String, Object> getParameterMapMemberAddressAsValid() {
        if (_parameterMapMemberAddressAsValid == null) {
            _parameterMapMemberAddressAsValid = newLinkedHashMapSized(4);
        }
        return _parameterMapMemberAddressAsValid;
    }
    public void xsetParameterMapMemberAddressAsValid(Map<String, Object> parameterMap) {
        _parameterMapMemberAddressAsValid = parameterMap; // for UnionQuery
    }
    protected MemberAddressCQ xcreateQueryMemberAddressAsValid() {
        String nrp = resolveNextRelationPath("MEMBER", "memberAddressAsValid");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberAddressCQ cq = new MemberAddressCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberAddressAsValid");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberAddressAsValid() {
        MemberAddressCQ cq = getConditionQueryMemberAddressAsValid();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "memberAddressAsValid");
    }
    public boolean hasConditionQueryMemberAddressAsValid() {
        return _conditionQueryMemberAddressAsValid != null;
    }

    /**
     * Get the condition-query for relation table. <br />
     * (会員セキュリティ情報)MEMBER_SECURITY by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberSecurityCQ queryMemberSecurityAsOne() {
        return getConditionQueryMemberSecurityAsOne();
    }
    protected MemberSecurityCQ _conditionQueryMemberSecurityAsOne;
    public MemberSecurityCQ getConditionQueryMemberSecurityAsOne() {
        if (_conditionQueryMemberSecurityAsOne == null) {
            _conditionQueryMemberSecurityAsOne = xcreateQueryMemberSecurityAsOne();
            xsetupOuterJoinMemberSecurityAsOne();
        }
        return _conditionQueryMemberSecurityAsOne;
    }
    protected MemberSecurityCQ xcreateQueryMemberSecurityAsOne() {
        String nrp = resolveNextRelationPath("MEMBER", "memberSecurityAsOne");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberSecurityCQ cq = new MemberSecurityCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberSecurityAsOne");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberSecurityAsOne() {
        MemberSecurityCQ cq = getConditionQueryMemberSecurityAsOne();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "memberSecurityAsOne");
    }
    public boolean hasConditionQueryMemberSecurityAsOne() {
        return _conditionQueryMemberSecurityAsOne != null;
    }

    /**
     * Get the condition-query for relation table. <br />
     * (会員サービス)MEMBER_SERVICE by MEMBER_ID, named 'memberServiceAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberServiceCQ queryMemberServiceAsOne() {
        return getConditionQueryMemberServiceAsOne();
    }
    protected MemberServiceCQ _conditionQueryMemberServiceAsOne;
    public MemberServiceCQ getConditionQueryMemberServiceAsOne() {
        if (_conditionQueryMemberServiceAsOne == null) {
            _conditionQueryMemberServiceAsOne = xcreateQueryMemberServiceAsOne();
            xsetupOuterJoinMemberServiceAsOne();
        }
        return _conditionQueryMemberServiceAsOne;
    }
    protected MemberServiceCQ xcreateQueryMemberServiceAsOne() {
        String nrp = resolveNextRelationPath("MEMBER", "memberServiceAsOne");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberServiceCQ cq = new MemberServiceCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberServiceAsOne");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberServiceAsOne() {
        MemberServiceCQ cq = getConditionQueryMemberServiceAsOne();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "memberServiceAsOne");
    }
    public boolean hasConditionQueryMemberServiceAsOne() {
        return _conditionQueryMemberServiceAsOne != null;
    }

    /**
     * Get the condition-query for relation table. <br />
     * (会員退会情報)MEMBER_WITHDRAWAL by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberWithdrawalCQ queryMemberWithdrawalAsOne() {
        return getConditionQueryMemberWithdrawalAsOne();
    }
    protected MemberWithdrawalCQ _conditionQueryMemberWithdrawalAsOne;
    public MemberWithdrawalCQ getConditionQueryMemberWithdrawalAsOne() {
        if (_conditionQueryMemberWithdrawalAsOne == null) {
            _conditionQueryMemberWithdrawalAsOne = xcreateQueryMemberWithdrawalAsOne();
            xsetupOuterJoinMemberWithdrawalAsOne();
        }
        return _conditionQueryMemberWithdrawalAsOne;
    }
    protected MemberWithdrawalCQ xcreateQueryMemberWithdrawalAsOne() {
        String nrp = resolveNextRelationPath("MEMBER", "memberWithdrawalAsOne");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberWithdrawalCQ cq = new MemberWithdrawalCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberWithdrawalAsOne");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberWithdrawalAsOne() {
        MemberWithdrawalCQ cq = getConditionQueryMemberWithdrawalAsOne();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "memberWithdrawalAsOne");
    }
    public boolean hasConditionQueryMemberWithdrawalAsOne() {
        return _conditionQueryMemberWithdrawalAsOne != null;
    }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        if ("memberAddressAsValid".equalsIgnoreCase(property)) {
            return _parameterMapMemberAddressAsValid;
        }
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    protected Map<String, MemberCQ> _scalarConditionMap;
    public Map<String, MemberCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(MemberCQ subQuery) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(key, subQuery); return "scalarCondition." + key;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, MemberCQ> _specifyMyselfDerivedMap;
    public Map<String, MemberCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(MemberCQ subQuery) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(key, subQuery); return "specifyMyselfDerived." + key;
    }

    protected Map<String, MemberCQ> _queryMyselfDerivedMap;
    public Map<String, MemberCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(MemberCQ subQuery) {
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
    protected Map<String, MemberCQ> _myselfExistsMap;
    public Map<String, MemberCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(MemberCQ subQuery) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(key, subQuery); return "myselfExists." + key;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, MemberCQ> _myselfInScopeMap;
    public Map<String, MemberCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(MemberCQ subQuery) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(key, subQuery); return "myselfInScope." + key;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return MemberCB.class.getName(); }
    protected String xCQ() { return MemberCQ.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
