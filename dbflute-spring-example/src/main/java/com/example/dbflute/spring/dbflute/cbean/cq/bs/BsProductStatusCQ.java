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
 * The base condition-query of PRODUCT_STATUS.
 * @author DBFlute(AutoGenerator)
 */
public class BsProductStatusCQ extends AbstractBsProductStatusCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected ProductStatusCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsProductStatusCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from PRODUCT_STATUS) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public ProductStatusCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected ProductStatusCIQ xcreateCIQ() {
        ProductStatusCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected ProductStatusCIQ xnewCIQ() {
        return new ProductStatusCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join PRODUCT_STATUS on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public ProductStatusCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        ProductStatusCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    protected ConditionValue _productStatusCode;
    public ConditionValue getProductStatusCode() {
        if (_productStatusCode == null) { _productStatusCode = nCV(); }
        return _productStatusCode;
    }
    protected ConditionValue getCValueProductStatusCode() { return getProductStatusCode(); }

    protected Map<String, ProductCQ> _productStatusCode_ExistsReferrer_ProductListMap;
    public Map<String, ProductCQ> getProductStatusCode_ExistsReferrer_ProductList() { return _productStatusCode_ExistsReferrer_ProductListMap; }
    public String keepProductStatusCode_ExistsReferrer_ProductList(ProductCQ sq) {
        if (_productStatusCode_ExistsReferrer_ProductListMap == null) { _productStatusCode_ExistsReferrer_ProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_ExistsReferrer_ProductListMap.size() + 1);
        _productStatusCode_ExistsReferrer_ProductListMap.put(ky, sq); return "productStatusCode_ExistsReferrer_ProductList." + ky;
    }

    protected Map<String, SummaryProductCQ> _productStatusCode_ExistsReferrer_SummaryProductListMap;
    public Map<String, SummaryProductCQ> getProductStatusCode_ExistsReferrer_SummaryProductList() { return _productStatusCode_ExistsReferrer_SummaryProductListMap; }
    public String keepProductStatusCode_ExistsReferrer_SummaryProductList(SummaryProductCQ sq) {
        if (_productStatusCode_ExistsReferrer_SummaryProductListMap == null) { _productStatusCode_ExistsReferrer_SummaryProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_ExistsReferrer_SummaryProductListMap.size() + 1);
        _productStatusCode_ExistsReferrer_SummaryProductListMap.put(ky, sq); return "productStatusCode_ExistsReferrer_SummaryProductList." + ky;
    }

    protected Map<String, ProductCQ> _productStatusCode_NotExistsReferrer_ProductListMap;
    public Map<String, ProductCQ> getProductStatusCode_NotExistsReferrer_ProductList() { return _productStatusCode_NotExistsReferrer_ProductListMap; }
    public String keepProductStatusCode_NotExistsReferrer_ProductList(ProductCQ sq) {
        if (_productStatusCode_NotExistsReferrer_ProductListMap == null) { _productStatusCode_NotExistsReferrer_ProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_NotExistsReferrer_ProductListMap.size() + 1);
        _productStatusCode_NotExistsReferrer_ProductListMap.put(ky, sq); return "productStatusCode_NotExistsReferrer_ProductList." + ky;
    }

    protected Map<String, SummaryProductCQ> _productStatusCode_NotExistsReferrer_SummaryProductListMap;
    public Map<String, SummaryProductCQ> getProductStatusCode_NotExistsReferrer_SummaryProductList() { return _productStatusCode_NotExistsReferrer_SummaryProductListMap; }
    public String keepProductStatusCode_NotExistsReferrer_SummaryProductList(SummaryProductCQ sq) {
        if (_productStatusCode_NotExistsReferrer_SummaryProductListMap == null) { _productStatusCode_NotExistsReferrer_SummaryProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_NotExistsReferrer_SummaryProductListMap.size() + 1);
        _productStatusCode_NotExistsReferrer_SummaryProductListMap.put(ky, sq); return "productStatusCode_NotExistsReferrer_SummaryProductList." + ky;
    }

    protected Map<String, ProductCQ> _productStatusCode_InScopeRelation_ProductListMap;
    public Map<String, ProductCQ> getProductStatusCode_InScopeRelation_ProductList() { return _productStatusCode_InScopeRelation_ProductListMap; }
    public String keepProductStatusCode_InScopeRelation_ProductList(ProductCQ sq) {
        if (_productStatusCode_InScopeRelation_ProductListMap == null) { _productStatusCode_InScopeRelation_ProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_InScopeRelation_ProductListMap.size() + 1);
        _productStatusCode_InScopeRelation_ProductListMap.put(ky, sq); return "productStatusCode_InScopeRelation_ProductList." + ky;
    }

    protected Map<String, SummaryProductCQ> _productStatusCode_InScopeRelation_SummaryProductListMap;
    public Map<String, SummaryProductCQ> getProductStatusCode_InScopeRelation_SummaryProductList() { return _productStatusCode_InScopeRelation_SummaryProductListMap; }
    public String keepProductStatusCode_InScopeRelation_SummaryProductList(SummaryProductCQ sq) {
        if (_productStatusCode_InScopeRelation_SummaryProductListMap == null) { _productStatusCode_InScopeRelation_SummaryProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_InScopeRelation_SummaryProductListMap.size() + 1);
        _productStatusCode_InScopeRelation_SummaryProductListMap.put(ky, sq); return "productStatusCode_InScopeRelation_SummaryProductList." + ky;
    }

    protected Map<String, ProductCQ> _productStatusCode_NotInScopeRelation_ProductListMap;
    public Map<String, ProductCQ> getProductStatusCode_NotInScopeRelation_ProductList() { return _productStatusCode_NotInScopeRelation_ProductListMap; }
    public String keepProductStatusCode_NotInScopeRelation_ProductList(ProductCQ sq) {
        if (_productStatusCode_NotInScopeRelation_ProductListMap == null) { _productStatusCode_NotInScopeRelation_ProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_NotInScopeRelation_ProductListMap.size() + 1);
        _productStatusCode_NotInScopeRelation_ProductListMap.put(ky, sq); return "productStatusCode_NotInScopeRelation_ProductList." + ky;
    }

    protected Map<String, SummaryProductCQ> _productStatusCode_NotInScopeRelation_SummaryProductListMap;
    public Map<String, SummaryProductCQ> getProductStatusCode_NotInScopeRelation_SummaryProductList() { return _productStatusCode_NotInScopeRelation_SummaryProductListMap; }
    public String keepProductStatusCode_NotInScopeRelation_SummaryProductList(SummaryProductCQ sq) {
        if (_productStatusCode_NotInScopeRelation_SummaryProductListMap == null) { _productStatusCode_NotInScopeRelation_SummaryProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_NotInScopeRelation_SummaryProductListMap.size() + 1);
        _productStatusCode_NotInScopeRelation_SummaryProductListMap.put(ky, sq); return "productStatusCode_NotInScopeRelation_SummaryProductList." + ky;
    }

    protected Map<String, ProductCQ> _productStatusCode_SpecifyDerivedReferrer_ProductListMap;
    public Map<String, ProductCQ> getProductStatusCode_SpecifyDerivedReferrer_ProductList() { return _productStatusCode_SpecifyDerivedReferrer_ProductListMap; }
    public String keepProductStatusCode_SpecifyDerivedReferrer_ProductList(ProductCQ sq) {
        if (_productStatusCode_SpecifyDerivedReferrer_ProductListMap == null) { _productStatusCode_SpecifyDerivedReferrer_ProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_SpecifyDerivedReferrer_ProductListMap.size() + 1);
        _productStatusCode_SpecifyDerivedReferrer_ProductListMap.put(ky, sq); return "productStatusCode_SpecifyDerivedReferrer_ProductList." + ky;
    }

    protected Map<String, SummaryProductCQ> _productStatusCode_SpecifyDerivedReferrer_SummaryProductListMap;
    public Map<String, SummaryProductCQ> getProductStatusCode_SpecifyDerivedReferrer_SummaryProductList() { return _productStatusCode_SpecifyDerivedReferrer_SummaryProductListMap; }
    public String keepProductStatusCode_SpecifyDerivedReferrer_SummaryProductList(SummaryProductCQ sq) {
        if (_productStatusCode_SpecifyDerivedReferrer_SummaryProductListMap == null) { _productStatusCode_SpecifyDerivedReferrer_SummaryProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_SpecifyDerivedReferrer_SummaryProductListMap.size() + 1);
        _productStatusCode_SpecifyDerivedReferrer_SummaryProductListMap.put(ky, sq); return "productStatusCode_SpecifyDerivedReferrer_SummaryProductList." + ky;
    }

    protected Map<String, ProductCQ> _productStatusCode_QueryDerivedReferrer_ProductListMap;
    public Map<String, ProductCQ> getProductStatusCode_QueryDerivedReferrer_ProductList() { return _productStatusCode_QueryDerivedReferrer_ProductListMap; }
    public String keepProductStatusCode_QueryDerivedReferrer_ProductList(ProductCQ sq) {
        if (_productStatusCode_QueryDerivedReferrer_ProductListMap == null) { _productStatusCode_QueryDerivedReferrer_ProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_QueryDerivedReferrer_ProductListMap.size() + 1);
        _productStatusCode_QueryDerivedReferrer_ProductListMap.put(ky, sq); return "productStatusCode_QueryDerivedReferrer_ProductList." + ky;
    }
    protected Map<String, Object> _productStatusCode_QueryDerivedReferrer_ProductListParameterMap;
    public Map<String, Object> getProductStatusCode_QueryDerivedReferrer_ProductListParameter() { return _productStatusCode_QueryDerivedReferrer_ProductListParameterMap; }
    public String keepProductStatusCode_QueryDerivedReferrer_ProductListParameter(Object vl) {
        if (_productStatusCode_QueryDerivedReferrer_ProductListParameterMap == null) { _productStatusCode_QueryDerivedReferrer_ProductListParameterMap = newLinkedHashMapSized(4); }
        String ky = "subQueryParameterKey" + (_productStatusCode_QueryDerivedReferrer_ProductListParameterMap.size() + 1);
        _productStatusCode_QueryDerivedReferrer_ProductListParameterMap.put(ky, vl); return "productStatusCode_QueryDerivedReferrer_ProductListParameter." + ky;
    }

    protected Map<String, SummaryProductCQ> _productStatusCode_QueryDerivedReferrer_SummaryProductListMap;
    public Map<String, SummaryProductCQ> getProductStatusCode_QueryDerivedReferrer_SummaryProductList() { return _productStatusCode_QueryDerivedReferrer_SummaryProductListMap; }
    public String keepProductStatusCode_QueryDerivedReferrer_SummaryProductList(SummaryProductCQ sq) {
        if (_productStatusCode_QueryDerivedReferrer_SummaryProductListMap == null) { _productStatusCode_QueryDerivedReferrer_SummaryProductListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_productStatusCode_QueryDerivedReferrer_SummaryProductListMap.size() + 1);
        _productStatusCode_QueryDerivedReferrer_SummaryProductListMap.put(ky, sq); return "productStatusCode_QueryDerivedReferrer_SummaryProductList." + ky;
    }
    protected Map<String, Object> _productStatusCode_QueryDerivedReferrer_SummaryProductListParameterMap;
    public Map<String, Object> getProductStatusCode_QueryDerivedReferrer_SummaryProductListParameter() { return _productStatusCode_QueryDerivedReferrer_SummaryProductListParameterMap; }
    public String keepProductStatusCode_QueryDerivedReferrer_SummaryProductListParameter(Object vl) {
        if (_productStatusCode_QueryDerivedReferrer_SummaryProductListParameterMap == null) { _productStatusCode_QueryDerivedReferrer_SummaryProductListParameterMap = newLinkedHashMapSized(4); }
        String ky = "subQueryParameterKey" + (_productStatusCode_QueryDerivedReferrer_SummaryProductListParameterMap.size() + 1);
        _productStatusCode_QueryDerivedReferrer_SummaryProductListParameterMap.put(ky, vl); return "productStatusCode_QueryDerivedReferrer_SummaryProductListParameter." + ky;
    }

    /** 
     * Add order-by as ascend. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus}
     * @return this. (NotNull)
     */
    public BsProductStatusCQ addOrderBy_ProductStatusCode_Asc() { regOBA("PRODUCT_STATUS_CODE"); return this; }

    /**
     * Add order-by as descend. <br />
     * (商品ステータスコード)PRODUCT_STATUS_CODE: {PK, NotNull, CHAR(3), classification=ProductStatus}
     * @return this. (NotNull)
     */
    public BsProductStatusCQ addOrderBy_ProductStatusCode_Desc() { regOBD("PRODUCT_STATUS_CODE"); return this; }

    protected ConditionValue _productStatusName;
    public ConditionValue getProductStatusName() {
        if (_productStatusName == null) { _productStatusName = nCV(); }
        return _productStatusName;
    }
    protected ConditionValue getCValueProductStatusName() { return getProductStatusName(); }

    /** 
     * Add order-by as ascend. <br />
     * (商品ステータス名称)PRODUCT_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsProductStatusCQ addOrderBy_ProductStatusName_Asc() { regOBA("PRODUCT_STATUS_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (商品ステータス名称)PRODUCT_STATUS_NAME: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsProductStatusCQ addOrderBy_ProductStatusName_Desc() { regOBD("PRODUCT_STATUS_NAME"); return this; }

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
    public BsProductStatusCQ addOrderBy_DisplayOrder_Asc() { regOBA("DISPLAY_ORDER"); return this; }

    /**
     * Add order-by as descend. <br />
     * (表示順)DISPLAY_ORDER: {UQ, NotNull, INTEGER(10)}
     * @return this. (NotNull)
     */
    public BsProductStatusCQ addOrderBy_DisplayOrder_Desc() { regOBD("DISPLAY_ORDER"); return this; }

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
    public BsProductStatusCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
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
    public BsProductStatusCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
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
    protected Map<String, ProductStatusCQ> _scalarConditionMap;
    public Map<String, ProductStatusCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(ProductStatusCQ sq) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(ky, sq); return "scalarCondition." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, ProductStatusCQ> _specifyMyselfDerivedMap;
    public Map<String, ProductStatusCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(ProductStatusCQ sq) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(ky, sq); return "specifyMyselfDerived." + ky;
    }

    protected Map<String, ProductStatusCQ> _queryMyselfDerivedMap;
    public Map<String, ProductStatusCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(ProductStatusCQ sq) {
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
    protected Map<String, ProductStatusCQ> _myselfExistsMap;
    public Map<String, ProductStatusCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(ProductStatusCQ sq) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(ky, sq); return "myselfExists." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, ProductStatusCQ> _myselfInScopeMap;
    public Map<String, ProductStatusCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(ProductStatusCQ sq) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(ky, sq); return "myselfInScope." + ky;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return ProductStatusCB.class.getName(); }
    protected String xCQ() { return ProductStatusCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
