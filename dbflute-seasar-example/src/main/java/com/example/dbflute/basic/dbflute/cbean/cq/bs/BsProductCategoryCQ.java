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
package com.example.dbflute.basic.dbflute.cbean.cq.bs;

import java.util.Map;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import com.example.dbflute.basic.dbflute.cbean.cq.ciq.*;
import com.example.dbflute.basic.dbflute.cbean.*;
import com.example.dbflute.basic.dbflute.cbean.cq.*;

/**
 * The base condition-query of PRODUCT_CATEGORY.
 * @author DBFlute(AutoGenerator)
 */
public class BsProductCategoryCQ extends AbstractBsProductCategoryCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected ProductCategoryCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsProductCategoryCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from PRODUCT_CATEGORY) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public ProductCategoryCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected ProductCategoryCIQ xcreateCIQ() {
        ProductCategoryCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected ProductCategoryCIQ xnewCIQ() {
        return new ProductCategoryCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join PRODUCT_CATEGORY on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #FD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public ProductCategoryCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        ProductCategoryCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    protected ConditionValue _productCategoryCode;
    public ConditionValue getProductCategoryCode() {
        if (_productCategoryCode == null) { _productCategoryCode = nCV(); }
        return _productCategoryCode;
    }
    protected ConditionValue getCValueProductCategoryCode() { return getProductCategoryCode(); }

    protected Map<String, ProductCQ> _productCategoryCode_ExistsReferrer_ProductListMap;
    public Map<String, ProductCQ> getProductCategoryCode_ExistsReferrer_ProductList() { return _productCategoryCode_ExistsReferrer_ProductListMap; }
    public String keepProductCategoryCode_ExistsReferrer_ProductList(ProductCQ subQuery) {
        if (_productCategoryCode_ExistsReferrer_ProductListMap == null) { _productCategoryCode_ExistsReferrer_ProductListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_ExistsReferrer_ProductListMap.size() + 1);
        _productCategoryCode_ExistsReferrer_ProductListMap.put(key, subQuery); return "productCategoryCode_ExistsReferrer_ProductList." + key;
    }

    protected Map<String, ProductCategoryCQ> _productCategoryCode_ExistsReferrer_ProductCategorySelfListMap;
    public Map<String, ProductCategoryCQ> getProductCategoryCode_ExistsReferrer_ProductCategorySelfList() { return _productCategoryCode_ExistsReferrer_ProductCategorySelfListMap; }
    public String keepProductCategoryCode_ExistsReferrer_ProductCategorySelfList(ProductCategoryCQ subQuery) {
        if (_productCategoryCode_ExistsReferrer_ProductCategorySelfListMap == null) { _productCategoryCode_ExistsReferrer_ProductCategorySelfListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_ExistsReferrer_ProductCategorySelfListMap.size() + 1);
        _productCategoryCode_ExistsReferrer_ProductCategorySelfListMap.put(key, subQuery); return "productCategoryCode_ExistsReferrer_ProductCategorySelfList." + key;
    }

    protected Map<String, ProductCQ> _productCategoryCode_NotExistsReferrer_ProductListMap;
    public Map<String, ProductCQ> getProductCategoryCode_NotExistsReferrer_ProductList() { return _productCategoryCode_NotExistsReferrer_ProductListMap; }
    public String keepProductCategoryCode_NotExistsReferrer_ProductList(ProductCQ subQuery) {
        if (_productCategoryCode_NotExistsReferrer_ProductListMap == null) { _productCategoryCode_NotExistsReferrer_ProductListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_NotExistsReferrer_ProductListMap.size() + 1);
        _productCategoryCode_NotExistsReferrer_ProductListMap.put(key, subQuery); return "productCategoryCode_NotExistsReferrer_ProductList." + key;
    }

    protected Map<String, ProductCategoryCQ> _productCategoryCode_NotExistsReferrer_ProductCategorySelfListMap;
    public Map<String, ProductCategoryCQ> getProductCategoryCode_NotExistsReferrer_ProductCategorySelfList() { return _productCategoryCode_NotExistsReferrer_ProductCategorySelfListMap; }
    public String keepProductCategoryCode_NotExistsReferrer_ProductCategorySelfList(ProductCategoryCQ subQuery) {
        if (_productCategoryCode_NotExistsReferrer_ProductCategorySelfListMap == null) { _productCategoryCode_NotExistsReferrer_ProductCategorySelfListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_NotExistsReferrer_ProductCategorySelfListMap.size() + 1);
        _productCategoryCode_NotExistsReferrer_ProductCategorySelfListMap.put(key, subQuery); return "productCategoryCode_NotExistsReferrer_ProductCategorySelfList." + key;
    }

    protected Map<String, ProductCQ> _productCategoryCode_InScopeRelation_ProductListMap;
    public Map<String, ProductCQ> getProductCategoryCode_InScopeRelation_ProductList() { return _productCategoryCode_InScopeRelation_ProductListMap; }
    public String keepProductCategoryCode_InScopeRelation_ProductList(ProductCQ subQuery) {
        if (_productCategoryCode_InScopeRelation_ProductListMap == null) { _productCategoryCode_InScopeRelation_ProductListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_InScopeRelation_ProductListMap.size() + 1);
        _productCategoryCode_InScopeRelation_ProductListMap.put(key, subQuery); return "productCategoryCode_InScopeRelation_ProductList." + key;
    }

    protected Map<String, ProductCategoryCQ> _productCategoryCode_InScopeRelation_ProductCategorySelfListMap;
    public Map<String, ProductCategoryCQ> getProductCategoryCode_InScopeRelation_ProductCategorySelfList() { return _productCategoryCode_InScopeRelation_ProductCategorySelfListMap; }
    public String keepProductCategoryCode_InScopeRelation_ProductCategorySelfList(ProductCategoryCQ subQuery) {
        if (_productCategoryCode_InScopeRelation_ProductCategorySelfListMap == null) { _productCategoryCode_InScopeRelation_ProductCategorySelfListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_InScopeRelation_ProductCategorySelfListMap.size() + 1);
        _productCategoryCode_InScopeRelation_ProductCategorySelfListMap.put(key, subQuery); return "productCategoryCode_InScopeRelation_ProductCategorySelfList." + key;
    }

    protected Map<String, ProductCQ> _productCategoryCode_NotInScopeRelation_ProductListMap;
    public Map<String, ProductCQ> getProductCategoryCode_NotInScopeRelation_ProductList() { return _productCategoryCode_NotInScopeRelation_ProductListMap; }
    public String keepProductCategoryCode_NotInScopeRelation_ProductList(ProductCQ subQuery) {
        if (_productCategoryCode_NotInScopeRelation_ProductListMap == null) { _productCategoryCode_NotInScopeRelation_ProductListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_NotInScopeRelation_ProductListMap.size() + 1);
        _productCategoryCode_NotInScopeRelation_ProductListMap.put(key, subQuery); return "productCategoryCode_NotInScopeRelation_ProductList." + key;
    }

    protected Map<String, ProductCategoryCQ> _productCategoryCode_NotInScopeRelation_ProductCategorySelfListMap;
    public Map<String, ProductCategoryCQ> getProductCategoryCode_NotInScopeRelation_ProductCategorySelfList() { return _productCategoryCode_NotInScopeRelation_ProductCategorySelfListMap; }
    public String keepProductCategoryCode_NotInScopeRelation_ProductCategorySelfList(ProductCategoryCQ subQuery) {
        if (_productCategoryCode_NotInScopeRelation_ProductCategorySelfListMap == null) { _productCategoryCode_NotInScopeRelation_ProductCategorySelfListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_NotInScopeRelation_ProductCategorySelfListMap.size() + 1);
        _productCategoryCode_NotInScopeRelation_ProductCategorySelfListMap.put(key, subQuery); return "productCategoryCode_NotInScopeRelation_ProductCategorySelfList." + key;
    }

    protected Map<String, ProductCQ> _productCategoryCode_SpecifyDerivedReferrer_ProductListMap;
    public Map<String, ProductCQ> getProductCategoryCode_SpecifyDerivedReferrer_ProductList() { return _productCategoryCode_SpecifyDerivedReferrer_ProductListMap; }
    public String keepProductCategoryCode_SpecifyDerivedReferrer_ProductList(ProductCQ subQuery) {
        if (_productCategoryCode_SpecifyDerivedReferrer_ProductListMap == null) { _productCategoryCode_SpecifyDerivedReferrer_ProductListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_SpecifyDerivedReferrer_ProductListMap.size() + 1);
        _productCategoryCode_SpecifyDerivedReferrer_ProductListMap.put(key, subQuery); return "productCategoryCode_SpecifyDerivedReferrer_ProductList." + key;
    }

    protected Map<String, ProductCategoryCQ> _productCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfListMap;
    public Map<String, ProductCategoryCQ> getProductCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfList() { return _productCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfListMap; }
    public String keepProductCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfList(ProductCategoryCQ subQuery) {
        if (_productCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfListMap == null) { _productCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfListMap.size() + 1);
        _productCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfListMap.put(key, subQuery); return "productCategoryCode_SpecifyDerivedReferrer_ProductCategorySelfList." + key;
    }

    protected Map<String, ProductCQ> _productCategoryCode_QueryDerivedReferrer_ProductListMap;
    public Map<String, ProductCQ> getProductCategoryCode_QueryDerivedReferrer_ProductList() { return _productCategoryCode_QueryDerivedReferrer_ProductListMap; }
    public String keepProductCategoryCode_QueryDerivedReferrer_ProductList(ProductCQ subQuery) {
        if (_productCategoryCode_QueryDerivedReferrer_ProductListMap == null) { _productCategoryCode_QueryDerivedReferrer_ProductListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_QueryDerivedReferrer_ProductListMap.size() + 1);
        _productCategoryCode_QueryDerivedReferrer_ProductListMap.put(key, subQuery); return "productCategoryCode_QueryDerivedReferrer_ProductList." + key;
    }
    protected Map<String, Object> _productCategoryCode_QueryDerivedReferrer_ProductListParameterMap;
    public Map<String, Object> getProductCategoryCode_QueryDerivedReferrer_ProductListParameter() { return _productCategoryCode_QueryDerivedReferrer_ProductListParameterMap; }
    public String keepProductCategoryCode_QueryDerivedReferrer_ProductListParameter(Object parameterValue) {
        if (_productCategoryCode_QueryDerivedReferrer_ProductListParameterMap == null) { _productCategoryCode_QueryDerivedReferrer_ProductListParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_productCategoryCode_QueryDerivedReferrer_ProductListParameterMap.size() + 1);
        _productCategoryCode_QueryDerivedReferrer_ProductListParameterMap.put(key, parameterValue); return "productCategoryCode_QueryDerivedReferrer_ProductListParameter." + key;
    }

    protected Map<String, ProductCategoryCQ> _productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListMap;
    public Map<String, ProductCategoryCQ> getProductCategoryCode_QueryDerivedReferrer_ProductCategorySelfList() { return _productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListMap; }
    public String keepProductCategoryCode_QueryDerivedReferrer_ProductCategorySelfList(ProductCategoryCQ subQuery) {
        if (_productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListMap == null) { _productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListMap.size() + 1);
        _productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListMap.put(key, subQuery); return "productCategoryCode_QueryDerivedReferrer_ProductCategorySelfList." + key;
    }
    protected Map<String, Object> _productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameterMap;
    public Map<String, Object> getProductCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameter() { return _productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameterMap; }
    public String keepProductCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameter(Object parameterValue) {
        if (_productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameterMap == null) { _productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameterMap = newLinkedHashMapSized(4); }
        String key = "subQueryParameterKey" + (_productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameterMap.size() + 1);
        _productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameterMap.put(key, parameterValue); return "productCategoryCode_QueryDerivedReferrer_ProductCategorySelfListParameter." + key;
    }

    /** 
     * Add order-by as ascend. <br />
     * (商品カテゴリコード)PRODUCT_CATEGORY_CODE: {PK, NotNull, CHAR(3)}
     * @return this. (NotNull)
     */
    public BsProductCategoryCQ addOrderBy_ProductCategoryCode_Asc() { regOBA("PRODUCT_CATEGORY_CODE"); return this; }

    /**
     * Add order-by as descend. <br />
     * (商品カテゴリコード)PRODUCT_CATEGORY_CODE: {PK, NotNull, CHAR(3)}
     * @return this. (NotNull)
     */
    public BsProductCategoryCQ addOrderBy_ProductCategoryCode_Desc() { regOBD("PRODUCT_CATEGORY_CODE"); return this; }

    protected ConditionValue _productCategoryName;
    public ConditionValue getProductCategoryName() {
        if (_productCategoryName == null) { _productCategoryName = nCV(); }
        return _productCategoryName;
    }
    protected ConditionValue getCValueProductCategoryName() { return getProductCategoryName(); }

    /** 
     * Add order-by as ascend. <br />
     * (商品カテゴリ名称)PRODUCT_CATEGORY_NAME: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsProductCategoryCQ addOrderBy_ProductCategoryName_Asc() { regOBA("PRODUCT_CATEGORY_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * (商品カテゴリ名称)PRODUCT_CATEGORY_NAME: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsProductCategoryCQ addOrderBy_ProductCategoryName_Desc() { regOBD("PRODUCT_CATEGORY_NAME"); return this; }

    protected ConditionValue _parentCategoryCode;
    public ConditionValue getParentCategoryCode() {
        if (_parentCategoryCode == null) { _parentCategoryCode = nCV(); }
        return _parentCategoryCode;
    }
    protected ConditionValue getCValueParentCategoryCode() { return getParentCategoryCode(); }

    protected Map<String, ProductCategoryCQ> _parentCategoryCode_InScopeRelation_ProductCategorySelfMap;
    public Map<String, ProductCategoryCQ> getParentCategoryCode_InScopeRelation_ProductCategorySelf() { return _parentCategoryCode_InScopeRelation_ProductCategorySelfMap; }
    public String keepParentCategoryCode_InScopeRelation_ProductCategorySelf(ProductCategoryCQ subQuery) {
        if (_parentCategoryCode_InScopeRelation_ProductCategorySelfMap == null) { _parentCategoryCode_InScopeRelation_ProductCategorySelfMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_parentCategoryCode_InScopeRelation_ProductCategorySelfMap.size() + 1);
        _parentCategoryCode_InScopeRelation_ProductCategorySelfMap.put(key, subQuery); return "parentCategoryCode_InScopeRelation_ProductCategorySelf." + key;
    }

    protected Map<String, ProductCategoryCQ> _parentCategoryCode_NotInScopeRelation_ProductCategorySelfMap;
    public Map<String, ProductCategoryCQ> getParentCategoryCode_NotInScopeRelation_ProductCategorySelf() { return _parentCategoryCode_NotInScopeRelation_ProductCategorySelfMap; }
    public String keepParentCategoryCode_NotInScopeRelation_ProductCategorySelf(ProductCategoryCQ subQuery) {
        if (_parentCategoryCode_NotInScopeRelation_ProductCategorySelfMap == null) { _parentCategoryCode_NotInScopeRelation_ProductCategorySelfMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_parentCategoryCode_NotInScopeRelation_ProductCategorySelfMap.size() + 1);
        _parentCategoryCode_NotInScopeRelation_ProductCategorySelfMap.put(key, subQuery); return "parentCategoryCode_NotInScopeRelation_ProductCategorySelf." + key;
    }

    /** 
     * Add order-by as ascend. <br />
     * (親カテゴリコード)PARENT_CATEGORY_CODE: {IX, CHAR(3), FK to PRODUCT_CATEGORY}
     * @return this. (NotNull)
     */
    public BsProductCategoryCQ addOrderBy_ParentCategoryCode_Asc() { regOBA("PARENT_CATEGORY_CODE"); return this; }

    /**
     * Add order-by as descend. <br />
     * (親カテゴリコード)PARENT_CATEGORY_CODE: {IX, CHAR(3), FK to PRODUCT_CATEGORY}
     * @return this. (NotNull)
     */
    public BsProductCategoryCQ addOrderBy_ParentCategoryCode_Desc() { regOBD("PARENT_CATEGORY_CODE"); return this; }

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
    public BsProductCategoryCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
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
    public BsProductCategoryCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    protected void reflectRelationOnUnionQuery(ConditionQuery baseQueryAsSuper, ConditionQuery unionQueryAsSuper) {
        ProductCategoryCQ baseQuery = (ProductCategoryCQ)baseQueryAsSuper;
        ProductCategoryCQ unionQuery = (ProductCategoryCQ)unionQueryAsSuper;
        if (baseQuery.hasConditionQueryProductCategorySelf()) {
            unionQuery.queryProductCategorySelf().reflectRelationOnUnionQuery(baseQuery.queryProductCategorySelf(), unionQuery.queryProductCategorySelf());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * (商品カテゴリ)PRODUCT_CATEGORY by my PARENT_CATEGORY_CODE, named 'productCategorySelf'.
     * @return The instance of condition-query. (NotNull)
     */
    public ProductCategoryCQ queryProductCategorySelf() {
        return getConditionQueryProductCategorySelf();
    }
    protected ProductCategoryCQ _conditionQueryProductCategorySelf;
    public ProductCategoryCQ getConditionQueryProductCategorySelf() {
        if (_conditionQueryProductCategorySelf == null) {
            _conditionQueryProductCategorySelf = xcreateQueryProductCategorySelf();
            xsetupOuterJoinProductCategorySelf();
        }
        return _conditionQueryProductCategorySelf;
    }
    protected ProductCategoryCQ xcreateQueryProductCategorySelf() {
        String nrp = resolveNextRelationPath("PRODUCT_CATEGORY", "productCategorySelf");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        ProductCategoryCQ cq = new ProductCategoryCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("productCategorySelf");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinProductCategorySelf() {
        ProductCategoryCQ cq = getConditionQueryProductCategorySelf();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("PARENT_CATEGORY_CODE", "PRODUCT_CATEGORY_CODE");
        registerOuterJoin(cq, joinOnMap, "productCategorySelf");
    }
    public boolean hasConditionQueryProductCategorySelf() {
        return _conditionQueryProductCategorySelf != null;
    }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    protected Map<String, ProductCategoryCQ> _scalarConditionMap;
    public Map<String, ProductCategoryCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(ProductCategoryCQ subQuery) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(key, subQuery); return "scalarCondition." + key;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, ProductCategoryCQ> _specifyMyselfDerivedMap;
    public Map<String, ProductCategoryCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(ProductCategoryCQ subQuery) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(key, subQuery); return "specifyMyselfDerived." + key;
    }

    protected Map<String, ProductCategoryCQ> _queryMyselfDerivedMap;
    public Map<String, ProductCategoryCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(ProductCategoryCQ subQuery) {
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
    protected Map<String, ProductCategoryCQ> _myselfExistsMap;
    public Map<String, ProductCategoryCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(ProductCategoryCQ subQuery) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(key, subQuery); return "myselfExists." + key;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, ProductCategoryCQ> _myselfInScopeMap;
    public Map<String, ProductCategoryCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(ProductCategoryCQ subQuery) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String key = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(key, subQuery); return "myselfInScope." + key;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return ProductCategoryCB.class.getName(); }
    protected String xCQ() { return ProductCategoryCQ.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
