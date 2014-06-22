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

import java.util.Map;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import com.example.dbflute.spring.dbflute.cbean.cq.ciq.*;
import com.example.dbflute.spring.dbflute.cbean.*;
import com.example.dbflute.spring.dbflute.cbean.cq.*;

/**
 * The base condition-query of PURCHASE_PAYMENT.
 * @author DBFlute(AutoGenerator)
 */
public class BsPurchasePaymentCQ extends AbstractBsPurchasePaymentCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected PurchasePaymentCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPurchasePaymentCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from PURCHASE_PAYMENT) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public PurchasePaymentCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected PurchasePaymentCIQ xcreateCIQ() {
        PurchasePaymentCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected PurchasePaymentCIQ xnewCIQ() {
        return new PurchasePaymentCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join PURCHASE_PAYMENT on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public PurchasePaymentCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        PurchasePaymentCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _purchasePaymentId;
    public ConditionValue getPurchasePaymentId() {
        if (_purchasePaymentId == null) { _purchasePaymentId = nCV(); }
        return _purchasePaymentId;
    }
    protected ConditionValue getCValuePurchasePaymentId() { return getPurchasePaymentId(); }

    /** 
     * Add order-by as ascend. <br />
     * (購入支払ID)PURCHASE_PAYMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PurchasePaymentId_Asc() { regOBA("PURCHASE_PAYMENT_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * (購入支払ID)PURCHASE_PAYMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PurchasePaymentId_Desc() { regOBD("PURCHASE_PAYMENT_ID"); return this; }

    protected ConditionValue _purchaseId;
    public ConditionValue getPurchaseId() {
        if (_purchaseId == null) { _purchaseId = nCV(); }
        return _purchaseId;
    }
    protected ConditionValue getCValuePurchaseId() { return getPurchaseId(); }

    protected Map<String, PurchaseCQ> _purchaseId_InScopeRelation_PurchaseMap;
    public Map<String, PurchaseCQ> getPurchaseId_InScopeRelation_Purchase() { return _purchaseId_InScopeRelation_PurchaseMap; }
    public String keepPurchaseId_InScopeRelation_Purchase(PurchaseCQ sq) {
        if (_purchaseId_InScopeRelation_PurchaseMap == null) { _purchaseId_InScopeRelation_PurchaseMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_purchaseId_InScopeRelation_PurchaseMap.size() + 1);
        _purchaseId_InScopeRelation_PurchaseMap.put(ky, sq); return "purchaseId_InScopeRelation_Purchase." + ky;
    }

    protected Map<String, PurchaseCQ> _purchaseId_NotInScopeRelation_PurchaseMap;
    public Map<String, PurchaseCQ> getPurchaseId_NotInScopeRelation_Purchase() { return _purchaseId_NotInScopeRelation_PurchaseMap; }
    public String keepPurchaseId_NotInScopeRelation_Purchase(PurchaseCQ sq) {
        if (_purchaseId_NotInScopeRelation_PurchaseMap == null) { _purchaseId_NotInScopeRelation_PurchaseMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_purchaseId_NotInScopeRelation_PurchaseMap.size() + 1);
        _purchaseId_NotInScopeRelation_PurchaseMap.put(ky, sq); return "purchaseId_NotInScopeRelation_Purchase." + ky;
    }

    /** 
     * Add order-by as ascend. <br />
     * (購入ID)PURCHASE_ID: {IX, NotNull, BIGINT(19), FK to PURCHASE}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PurchaseId_Asc() { regOBA("PURCHASE_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * (購入ID)PURCHASE_ID: {IX, NotNull, BIGINT(19), FK to PURCHASE}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PurchaseId_Desc() { regOBD("PURCHASE_ID"); return this; }

    protected ConditionValue _paymentAmount;
    public ConditionValue getPaymentAmount() {
        if (_paymentAmount == null) { _paymentAmount = nCV(); }
        return _paymentAmount;
    }
    protected ConditionValue getCValuePaymentAmount() { return getPaymentAmount(); }

    /** 
     * Add order-by as ascend. <br />
     * (支払金額)PAYMENT_AMOUNT: {NotNull, DECIMAL(10, 2)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PaymentAmount_Asc() { regOBA("PAYMENT_AMOUNT"); return this; }

    /**
     * Add order-by as descend. <br />
     * (支払金額)PAYMENT_AMOUNT: {NotNull, DECIMAL(10, 2)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PaymentAmount_Desc() { regOBD("PAYMENT_AMOUNT"); return this; }

    protected ConditionValue _paymentDatetime;
    public ConditionValue getPaymentDatetime() {
        if (_paymentDatetime == null) { _paymentDatetime = nCV(); }
        return _paymentDatetime;
    }
    protected ConditionValue getCValuePaymentDatetime() { return getPaymentDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * (支払日時)PAYMENT_DATETIME: {IX+, NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PaymentDatetime_Asc() { regOBA("PAYMENT_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (支払日時)PAYMENT_DATETIME: {IX+, NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PaymentDatetime_Desc() { regOBD("PAYMENT_DATETIME"); return this; }

    protected ConditionValue _paymentMethodCode;
    public ConditionValue getPaymentMethodCode() {
        if (_paymentMethodCode == null) { _paymentMethodCode = nCV(); }
        return _paymentMethodCode;
    }
    protected ConditionValue getCValuePaymentMethodCode() { return getPaymentMethodCode(); }

    /** 
     * Add order-by as ascend. <br />
     * (支払方法コード)PAYMENT_METHOD_CODE: {NotNull, CHAR(3), classification=PaymentMethod}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PaymentMethodCode_Asc() { regOBA("PAYMENT_METHOD_CODE"); return this; }

    /**
     * Add order-by as descend. <br />
     * (支払方法コード)PAYMENT_METHOD_CODE: {NotNull, CHAR(3), classification=PaymentMethod}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_PaymentMethodCode_Desc() { regOBD("PAYMENT_METHOD_CODE"); return this; }

    protected ConditionValue _registerDatetime;
    public ConditionValue getRegisterDatetime() {
        if (_registerDatetime == null) { _registerDatetime = nCV(); }
        return _registerDatetime;
    }
    protected ConditionValue getCValueRegisterDatetime() { return getRegisterDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_RegisterDatetime_Asc() { regOBA("REGISTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_RegisterDatetime_Desc() { regOBD("REGISTER_DATETIME"); return this; }

    protected ConditionValue _registerUser;
    public ConditionValue getRegisterUser() {
        if (_registerUser == null) { _registerUser = nCV(); }
        return _registerUser;
    }
    protected ConditionValue getCValueRegisterUser() { return getRegisterUser(); }

    /** 
     * Add order-by as ascend. <br />
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_RegisterUser_Asc() { regOBA("REGISTER_USER"); return this; }

    /**
     * Add order-by as descend. <br />
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_RegisterUser_Desc() { regOBD("REGISTER_USER"); return this; }

    protected ConditionValue _updateDatetime;
    public ConditionValue getUpdateDatetime() {
        if (_updateDatetime == null) { _updateDatetime = nCV(); }
        return _updateDatetime;
    }
    protected ConditionValue getCValueUpdateDatetime() { return getUpdateDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

    protected ConditionValue _updateUser;
    public ConditionValue getUpdateUser() {
        if (_updateUser == null) { _updateUser = nCV(); }
        return _updateUser;
    }
    protected ConditionValue getCValueUpdateUser() { return getUpdateUser(); }

    /** 
     * Add order-by as ascend. <br />
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_UpdateUser_Asc() { regOBA("UPDATE_USER"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsPurchasePaymentCQ addOrderBy_UpdateUser_Desc() { regOBD("UPDATE_USER"); return this; }

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
    public BsPurchasePaymentCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsPurchasePaymentCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        PurchasePaymentCQ bq = (PurchasePaymentCQ)bqs;
        PurchasePaymentCQ uq = (PurchasePaymentCQ)uqs;
        if (bq.hasConditionQueryPurchase()) {
            uq.queryPurchase().reflectRelationOnUnionQuery(bq.queryPurchase(), uq.queryPurchase());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * (購入)PURCHASE by my PURCHASE_ID, named 'purchase'.
     * @return The instance of condition-query. (NotNull)
     */
    public PurchaseCQ queryPurchase() {
        return getConditionQueryPurchase();
    }
    protected PurchaseCQ _conditionQueryPurchase;
    public PurchaseCQ getConditionQueryPurchase() {
        if (_conditionQueryPurchase == null) {
            _conditionQueryPurchase = xcreateQueryPurchase();
            xsetupOuterJoinPurchase();
        }
        return _conditionQueryPurchase;
    }
    protected PurchaseCQ xcreateQueryPurchase() {
        String nrp = resolveNextRelationPath("PURCHASE_PAYMENT", "purchase");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        return xinitRelCQ(new PurchaseCQ(this, xgetSqlClause(), jan, xgetNextNestLevel()), _baseCB, "purchase", nrp);
    }
    protected void xsetupOuterJoinPurchase() {
        PurchaseCQ cq = getConditionQueryPurchase();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("PURCHASE_ID", "PURCHASE_ID");
        registerOuterJoin(cq, joinOnMap, "purchase");
    }
    public boolean hasConditionQueryPurchase() { return _conditionQueryPurchase != null; }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    protected Map<String, PurchasePaymentCQ> _scalarConditionMap;
    public Map<String, PurchasePaymentCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(PurchasePaymentCQ sq) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(ky, sq); return "scalarCondition." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, PurchasePaymentCQ> _specifyMyselfDerivedMap;
    public Map<String, PurchasePaymentCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(PurchasePaymentCQ sq) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(ky, sq); return "specifyMyselfDerived." + ky;
    }

    protected Map<String, PurchasePaymentCQ> _queryMyselfDerivedMap;
    public Map<String, PurchasePaymentCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(PurchasePaymentCQ sq) {
        if (_queryMyselfDerivedMap == null) { _queryMyselfDerivedMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_queryMyselfDerivedMap.size() + 1);
        _queryMyselfDerivedMap.put(ky, sq); return "queryMyselfDerived." + ky;
    }
    protected Map<String, Object> _qyeryMyselfDerivedParameterMap;
    public Map<String, Object> getQueryMyselfDerivedParameter() { return _qyeryMyselfDerivedParameterMap; }
    public String keepQueryMyselfDerivedParameter(Object vl) {
        if (_qyeryMyselfDerivedParameterMap == null) { _qyeryMyselfDerivedParameterMap = newLinkedHashMapSized(4); }
        String ky = "subQueryParameterKey" + (_qyeryMyselfDerivedParameterMap.size() + 1);
        _qyeryMyselfDerivedParameterMap.put(ky, vl); return "queryMyselfDerivedParameter." + ky;
    }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, PurchasePaymentCQ> _myselfExistsMap;
    public Map<String, PurchasePaymentCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(PurchasePaymentCQ sq) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(ky, sq); return "myselfExists." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, PurchasePaymentCQ> _myselfInScopeMap;
    public Map<String, PurchasePaymentCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(PurchasePaymentCQ sq) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(ky, sq); return "myselfInScope." + ky;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return PurchasePaymentCB.class.getName(); }
    protected String xCQ() { return PurchasePaymentCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
