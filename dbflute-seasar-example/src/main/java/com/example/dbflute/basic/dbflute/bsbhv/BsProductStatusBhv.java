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
package com.example.dbflute.basic.dbflute.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.optional.*;
import org.seasar.dbflute.outsidesql.executor.*;
import com.example.dbflute.basic.dbflute.allcommon.CDef;
import com.example.dbflute.basic.dbflute.exbhv.*;
import com.example.dbflute.basic.dbflute.exentity.*;
import com.example.dbflute.basic.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.basic.dbflute.cbean.*;

/**
 * The behavior of (商品ステータス)PRODUCT_STATUS as TABLE. <br />
 * <pre>
 * [primary key]
 *     PRODUCT_STATUS_CODE
 *
 * [column]
 *     PRODUCT_STATUS_CODE, PRODUCT_STATUS_NAME, DISPLAY_ORDER
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     PRODUCT, SUMMARY_PRODUCT
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     productList, summaryProductList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsProductStatusBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "PRODUCT_STATUS"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return ProductStatusDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public ProductStatusDbm getMyDBMeta() { return ProductStatusDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public ProductStatus newMyEntity() { return new ProductStatus(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public ProductStatusCB newMyConditionBean() { return new ProductStatusCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * int count = productStatusBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(ProductStatusCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(ProductStatusCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(ProductStatusCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    @Override
    protected int doReadCount(ConditionBean cb) {
        return selectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean. <br />
     * <span style="color: #AD4747; font-size: 120%">The return might be null if no data, so you should have null check.</span> <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, use selectEntityWithDeletedCheck().</span>
     * <pre>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * ProductStatus productStatus = productStatusBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (productStatus != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = productStatus.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ProductStatus selectEntity(ProductStatusCB cb) {
        return doSelectEntity(cb, ProductStatus.class);
    }

    protected <ENTITY extends ProductStatus> ENTITY doSelectEntity(ProductStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, ProductStatusCB>() {
            public List<ENTITY> callbackSelectList(ProductStatusCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends ProductStatus> OptionalEntity<ENTITY> doSelectOptionalEntity(ProductStatusCB cb, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check. <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, this method is good.</span>
     * <pre>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * ProductStatus productStatus = productStatusBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = productStatus.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (point is not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ProductStatus selectEntityWithDeletedCheck(ProductStatusCB cb) {
        return doSelectEntityWithDeletedCheck(cb, ProductStatus.class);
    }

    protected <ENTITY extends ProductStatus> ENTITY doSelectEntityWithDeletedCheck(ProductStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, ProductStatusCB>() {
            public List<ENTITY> callbackSelectList(ProductStatusCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param productStatusCode The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ProductStatus selectByPKValue(CDef.ProductStatus productStatusCode) {
        return doSelectByPKValue(productStatusCode, ProductStatus.class);
    }

    protected <ENTITY extends ProductStatus> ENTITY doSelectByPKValue(CDef.ProductStatus productStatusCode, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(productStatusCode), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param productStatusCode The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ProductStatus selectByPKValueWithDeletedCheck(CDef.ProductStatus productStatusCode) {
        return doSelectByPKValueWithDeletedCheck(productStatusCode, ProductStatus.class);
    }

    protected <ENTITY extends ProductStatus> ENTITY doSelectByPKValueWithDeletedCheck(CDef.ProductStatus productStatusCode, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(productStatusCode), entityType);
    }

    private ProductStatusCB buildPKCB(CDef.ProductStatus productStatusCode) {
        assertObjectNotNull("productStatusCode", productStatusCode);
        ProductStatusCB cb = newMyConditionBean();
        cb.query().setProductStatusCode_Equal_AsProductStatus(productStatusCode);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;ProductStatus&gt; productStatusList = productStatusBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (ProductStatus productStatus : productStatusList) {
     *     ... = productStatus.get...();
     * }
     * </pre>
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<ProductStatus> selectList(ProductStatusCB cb) {
        return doSelectList(cb, ProductStatus.class);
    }

    protected <ENTITY extends ProductStatus> ListResultBean<ENTITY> doSelectList(ProductStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, ProductStatusCB>() {
            public List<ENTITY> callbackSelectList(ProductStatusCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
    }

    @Override
    protected ListResultBean<? extends Entity> doReadList(ConditionBean cb) {
        return selectList(downcast(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;ProductStatus&gt; page = productStatusBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (ProductStatus productStatus : page) {
     *     ... = productStatus.get...();
     * }
     * </pre>
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<ProductStatus> selectPage(ProductStatusCB cb) {
        return doSelectPage(cb, ProductStatus.class);
    }

    protected <ENTITY extends ProductStatus> PagingResultBean<ENTITY> doSelectPage(ProductStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, ProductStatusCB>() {
            public int callbackSelectCount(ProductStatusCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(ProductStatusCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    @Override
    protected PagingResultBean<? extends Entity> doReadPage(ConditionBean cb) {
        return selectPage(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * productStatusBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;ProductStatus&gt;() {
     *     public void handle(ProductStatus entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @param entityRowHandler The handler of entity row of ProductStatus. (NotNull)
     */
    public void selectCursor(ProductStatusCB cb, EntityRowHandler<ProductStatus> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, ProductStatus.class);
    }

    protected <ENTITY extends ProductStatus> void doSelectCursor(ProductStatusCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, ProductStatusCB>() {
            public void callbackSelectCursor(ProductStatusCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(ProductStatusCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * productStatusBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(ProductStatusCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<ProductStatusCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends ProductStatusCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends ProductStatusCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
        return new SLFunction<CB, RESULT>(cb, tp);
    }

    protected <RESULT> SLFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> tp) {
        return doScalarSelect(tp, newMyConditionBean());
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    @Override
    protected Number doReadNextVal() {
        String msg = "This table is NOT related to sequence: " + getTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * Load referrer of productList by the set-upper of referrer. <br />
     * (商品)PRODUCT by PRODUCT_STATUS_CODE, named 'productList'.
     * <pre>
     * productStatusBhv.<span style="color: #DD4747">loadProductList</span>(productStatusList, new ConditionBeanSetupper&lt;ProductCB&gt;() {
     *     public void setup(ProductCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here by calling like '}).withNestedList(new ...)'</span>
     * for (ProductStatus productStatus : productStatusList) {
     *     ... = productStatus.<span style="color: #DD4747">getProductList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setProductStatusCode_InScope(pkList);
     * cb.query().addOrderBy_ProductStatusCode_Asc();
     * </pre>
     * @param productStatus The entity of productStatus. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<Product> loadProductList(ProductStatus productStatus, ConditionBeanSetupper<ProductCB> conditionBeanSetupper) {
        xassLRArg(productStatus, conditionBeanSetupper);
        return loadProductList(xnewLRLs(productStatus), conditionBeanSetupper);
    }

    /**
     * Load referrer of productList by the set-upper of referrer. <br />
     * (商品)PRODUCT by PRODUCT_STATUS_CODE, named 'productList'.
     * <pre>
     * productStatusBhv.<span style="color: #DD4747">loadProductList</span>(productStatusList, new ConditionBeanSetupper&lt;ProductCB&gt;() {
     *     public void setup(ProductCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here by calling like '}).withNestedList(new ...)'</span>
     * for (ProductStatus productStatus : productStatusList) {
     *     ... = productStatus.<span style="color: #DD4747">getProductList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setProductStatusCode_InScope(pkList);
     * cb.query().addOrderBy_ProductStatusCode_Asc();
     * </pre>
     * @param productStatusList The entity list of productStatus. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<Product> loadProductList(List<ProductStatus> productStatusList, ConditionBeanSetupper<ProductCB> conditionBeanSetupper) {
        xassLRArg(productStatusList, conditionBeanSetupper);
        return loadProductList(productStatusList, new LoadReferrerOption<ProductCB, Product>().xinit(conditionBeanSetupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param productStatus The entity of productStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<Product> loadProductList(ProductStatus productStatus, LoadReferrerOption<ProductCB, Product> loadReferrerOption) {
        xassLRArg(productStatus, loadReferrerOption);
        return loadProductList(xnewLRLs(productStatus), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param productStatusList The entity list of productStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    @SuppressWarnings("unchecked")
    public NestedReferrerLoader<Product> loadProductList(List<ProductStatus> productStatusList, LoadReferrerOption<ProductCB, Product> loadReferrerOption) {
        xassLRArg(productStatusList, loadReferrerOption);
        if (productStatusList.isEmpty()) { return (NestedReferrerLoader<Product>)EMPTY_LOADER; }
        return doLoadProductList(productStatusList, loadReferrerOption);
    }

    protected NestedReferrerLoader<Product> doLoadProductList(List<ProductStatus> productStatusList, LoadReferrerOption<ProductCB, Product> option) {
        final ProductBhv referrerBhv = xgetBSFLR().select(ProductBhv.class);
        return helpLoadReferrerInternally(productStatusList, option, new InternalLoadReferrerCallback<ProductStatus, String, ProductCB, Product>() {
            public String getPKVal(ProductStatus et)
            { return et.getProductStatusCode(); }
            public void setRfLs(ProductStatus et, List<Product> ls)
            { et.setProductList(ls); }
            public ProductCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(ProductCB cb, List<String> ls)
            { cb.query().setProductStatusCode_InScope(ls); }
            public void qyOdFKAsc(ProductCB cb) { cb.query().addOrderBy_ProductStatusCode_Asc(); }
            public void spFKCol(ProductCB cb) { cb.specify().columnProductStatusCode(); }
            public List<Product> selRfLs(ProductCB cb) { return referrerBhv.selectList(cb); }
            public String getFKVal(Product re) { return re.getProductStatusCode(); }
            public void setlcEt(Product re, ProductStatus le)
            { re.setProductStatus(le); }
            public String getRfPrNm() { return "productList"; }
        });
    }

    /**
     * Load referrer of summaryProductList by the set-upper of referrer. <br />
     * SUMMARY_PRODUCT by PRODUCT_STATUS_CODE, named 'summaryProductList'.
     * <pre>
     * productStatusBhv.<span style="color: #DD4747">loadSummaryProductList</span>(productStatusList, new ConditionBeanSetupper&lt;SummaryProductCB&gt;() {
     *     public void setup(SummaryProductCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here by calling like '}).withNestedList(new ...)'</span>
     * for (ProductStatus productStatus : productStatusList) {
     *     ... = productStatus.<span style="color: #DD4747">getSummaryProductList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setProductStatusCode_InScope(pkList);
     * cb.query().addOrderBy_ProductStatusCode_Asc();
     * </pre>
     * @param productStatus The entity of productStatus. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<SummaryProduct> loadSummaryProductList(ProductStatus productStatus, ConditionBeanSetupper<SummaryProductCB> conditionBeanSetupper) {
        xassLRArg(productStatus, conditionBeanSetupper);
        return loadSummaryProductList(xnewLRLs(productStatus), conditionBeanSetupper);
    }

    /**
     * Load referrer of summaryProductList by the set-upper of referrer. <br />
     * SUMMARY_PRODUCT by PRODUCT_STATUS_CODE, named 'summaryProductList'.
     * <pre>
     * productStatusBhv.<span style="color: #DD4747">loadSummaryProductList</span>(productStatusList, new ConditionBeanSetupper&lt;SummaryProductCB&gt;() {
     *     public void setup(SummaryProductCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here by calling like '}).withNestedList(new ...)'</span>
     * for (ProductStatus productStatus : productStatusList) {
     *     ... = productStatus.<span style="color: #DD4747">getSummaryProductList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setProductStatusCode_InScope(pkList);
     * cb.query().addOrderBy_ProductStatusCode_Asc();
     * </pre>
     * @param productStatusList The entity list of productStatus. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<SummaryProduct> loadSummaryProductList(List<ProductStatus> productStatusList, ConditionBeanSetupper<SummaryProductCB> conditionBeanSetupper) {
        xassLRArg(productStatusList, conditionBeanSetupper);
        return loadSummaryProductList(productStatusList, new LoadReferrerOption<SummaryProductCB, SummaryProduct>().xinit(conditionBeanSetupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param productStatus The entity of productStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<SummaryProduct> loadSummaryProductList(ProductStatus productStatus, LoadReferrerOption<SummaryProductCB, SummaryProduct> loadReferrerOption) {
        xassLRArg(productStatus, loadReferrerOption);
        return loadSummaryProductList(xnewLRLs(productStatus), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param productStatusList The entity list of productStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    @SuppressWarnings("unchecked")
    public NestedReferrerLoader<SummaryProduct> loadSummaryProductList(List<ProductStatus> productStatusList, LoadReferrerOption<SummaryProductCB, SummaryProduct> loadReferrerOption) {
        xassLRArg(productStatusList, loadReferrerOption);
        if (productStatusList.isEmpty()) { return (NestedReferrerLoader<SummaryProduct>)EMPTY_LOADER; }
        return doLoadSummaryProductList(productStatusList, loadReferrerOption);
    }

    protected NestedReferrerLoader<SummaryProduct> doLoadSummaryProductList(List<ProductStatus> productStatusList, LoadReferrerOption<SummaryProductCB, SummaryProduct> option) {
        final SummaryProductBhv referrerBhv = xgetBSFLR().select(SummaryProductBhv.class);
        return helpLoadReferrerInternally(productStatusList, option, new InternalLoadReferrerCallback<ProductStatus, String, SummaryProductCB, SummaryProduct>() {
            public String getPKVal(ProductStatus et)
            { return et.getProductStatusCode(); }
            public void setRfLs(ProductStatus et, List<SummaryProduct> ls)
            { et.setSummaryProductList(ls); }
            public SummaryProductCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(SummaryProductCB cb, List<String> ls)
            { cb.query().setProductStatusCode_InScope(ls); }
            public void qyOdFKAsc(SummaryProductCB cb) { cb.query().addOrderBy_ProductStatusCode_Asc(); }
            public void spFKCol(SummaryProductCB cb) { cb.specify().columnProductStatusCode(); }
            public List<SummaryProduct> selRfLs(SummaryProductCB cb) { return referrerBhv.selectList(cb); }
            public String getFKVal(SummaryProduct re) { return re.getProductStatusCode(); }
            public void setlcEt(SummaryProduct re, ProductStatus le)
            { re.setProductStatus(le); }
            public String getRfPrNm() { return "summaryProductList"; }
        });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key productStatusCode.
     * @param productStatusList The list of productStatus. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractProductStatusCodeList(List<ProductStatus> productStatusList) {
        return helpExtractListInternally(productStatusList, new InternalExtractCallback<ProductStatus, String>() {
            public String getCV(ProductStatus et) { return et.getProductStatusCode(); }
        });
    }

    /**
     * Extract the value list of (single) unique key displayOrder.
     * @param productStatusList The list of productStatus. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractDisplayOrderList(List<ProductStatus> productStatusList) {
        return helpExtractListInternally(productStatusList, new InternalExtractCallback<ProductStatus, Integer>() {
            public Integer getCV(ProductStatus et) { return et.getDisplayOrder(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * ProductStatus productStatus = new ProductStatus();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * productStatus.setFoo...(value);
     * productStatus.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//productStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//productStatus.set...;</span>
     * productStatusBhv.<span style="color: #DD4747">insert</span>(productStatus);
     * ... = productStatus.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param productStatus The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(ProductStatus productStatus) {
        doInsert(productStatus, null);
    }

    protected void doInsert(ProductStatus productStatus, InsertOption<ProductStatusCB> op) {
        assertObjectNotNull("productStatus", productStatus);
        prepareInsertOption(op);
        delegateInsert(productStatus, op);
    }

    protected void prepareInsertOption(InsertOption<ProductStatusCB> op) {
        if (op == null) { return; }
        assertInsertOptionStatus(op);
        if (op.hasSpecifiedInsertColumn()) {
            op.resolveInsertColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    @Override
    protected void doCreate(Entity et, InsertOption<? extends ConditionBean> op) {
        if (op == null) { insert(downcast(et)); }
        else { varyingInsert(downcast(et), downcast(op)); }
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * ProductStatus productStatus = new ProductStatus();
     * productStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * productStatus.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//productStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//productStatus.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * productStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     productStatusBhv.<span style="color: #DD4747">update</span>(productStatus);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param productStatus The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final ProductStatus productStatus) {
        doUpdate(productStatus, null);
    }

    protected void doUpdate(ProductStatus productStatus, final UpdateOption<ProductStatusCB> op) {
        assertObjectNotNull("productStatus", productStatus);
        prepareUpdateOption(op);
        helpUpdateInternally(productStatus, new InternalUpdateCallback<ProductStatus>() {
            public int callbackDelegateUpdate(ProductStatus et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<ProductStatusCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected ProductStatusCB createCBForVaryingUpdate() {
        ProductStatusCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected ProductStatusCB createCBForSpecifiedUpdate() {
        ProductStatusCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { update(downcast(et)); }
        else { varyingUpdate(downcast(et), downcast(op)); }
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        doModify(et, op);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param productStatus The entity of insert or update target. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(ProductStatus productStatus) {
        doInesrtOrUpdate(productStatus, null, null);
    }

    protected void doInesrtOrUpdate(ProductStatus productStatus, final InsertOption<ProductStatusCB> iop, final UpdateOption<ProductStatusCB> uop) {
        helpInsertOrUpdateInternally(productStatus, new InternalInsertOrUpdateCallback<ProductStatus, ProductStatusCB>() {
            public void callbackInsert(ProductStatus et) { doInsert(et, iop); }
            public void callbackUpdate(ProductStatus et) { doUpdate(et, uop); }
            public ProductStatusCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(ProductStatusCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<ProductStatusCB>();
            uop = uop != null ? uop : new UpdateOption<ProductStatusCB>();
            varyingInsertOrUpdate(downcast(et), downcast(iop), downcast(uop));
        }
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doCreateOrModify(et, iop, uop);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * ProductStatus productStatus = new ProductStatus();
     * productStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * productStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     productStatusBhv.<span style="color: #DD4747">delete</span>(productStatus);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param productStatus The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(ProductStatus productStatus) {
        doDelete(productStatus, null);
    }

    protected void doDelete(ProductStatus productStatus, final DeleteOption<ProductStatusCB> op) {
        assertObjectNotNull("productStatus", productStatus);
        prepareDeleteOption(op);
        helpDeleteInternally(productStatus, new InternalDeleteCallback<ProductStatus>() {
            public int callbackDelegateDelete(ProductStatus et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<ProductStatusCB> op) {
        if (op == null) { return; }
        assertDeleteOptionStatus(op);
    }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { delete(downcast(et)); }
        else { varyingDelete(downcast(et), downcast(op)); }
    }

    @Override
    protected void doRemoveNonstrict(Entity et, DeleteOption<? extends ConditionBean> op) {
        doRemove(et, op);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <p><span style="color: #DD4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
     * <pre>
     * for (... : ...) {
     *     ProductStatus productStatus = new ProductStatus();
     *     productStatus.setFooName("foo");
     *     if (...) {
     *         productStatus.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     productStatusList.add(productStatus);
     * }
     * productStatusBhv.<span style="color: #DD4747">batchInsert</span>(productStatusList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param productStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<ProductStatus> productStatusList) {
        InsertOption<ProductStatusCB> op = createInsertUpdateOption();
        return doBatchInsert(productStatusList, op);
    }

    protected int[] doBatchInsert(List<ProductStatus> productStatusList, InsertOption<ProductStatusCB> op) {
        assertObjectNotNull("productStatusList", productStatusList);
        prepareBatchInsertOption(productStatusList, op);
        return delegateBatchInsert(productStatusList, op);
    }

    protected void prepareBatchInsertOption(List<ProductStatus> productStatusList, InsertOption<ProductStatusCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(productStatusList);
        prepareInsertOption(op);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) {
        if (op == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     ProductStatus productStatus = new ProductStatus();
     *     productStatus.setFooName("foo");
     *     if (...) {
     *         productStatus.setFooPrice(123);
     *     } else {
     *         productStatus.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//productStatus.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     productStatusList.add(productStatus);
     * }
     * productStatusBhv.<span style="color: #DD4747">batchUpdate</span>(productStatusList);
     * </pre>
     * @param productStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<ProductStatus> productStatusList) {
        UpdateOption<ProductStatusCB> op = createPlainUpdateOption();
        return doBatchUpdate(productStatusList, op);
    }

    protected int[] doBatchUpdate(List<ProductStatus> productStatusList, UpdateOption<ProductStatusCB> op) {
        assertObjectNotNull("productStatusList", productStatusList);
        prepareBatchUpdateOption(productStatusList, op);
        return delegateBatchUpdate(productStatusList, op);
    }

    protected void prepareBatchUpdateOption(List<ProductStatus> productStatusList, UpdateOption<ProductStatusCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(productStatusList);
        prepareUpdateOption(op);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * productStatusBhv.<span style="color: #DD4747">batchUpdate</span>(productStatusList, new SpecifyQuery<ProductStatusCB>() {
     *     public void specify(ProductStatusCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * productStatusBhv.<span style="color: #DD4747">batchUpdate</span>(productStatusList, new SpecifyQuery<ProductStatusCB>() {
     *     public void specify(ProductStatusCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param productStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<ProductStatus> productStatusList, SpecifyQuery<ProductStatusCB> updateColumnSpec) {
        return doBatchUpdate(productStatusList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param productStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<ProductStatus> productStatusList) {
        return doBatchDelete(productStatusList, null);
    }

    protected int[] doBatchDelete(List<ProductStatus> productStatusList, DeleteOption<ProductStatusCB> op) {
        assertObjectNotNull("productStatusList", productStatusList);
        prepareDeleteOption(op);
        return delegateBatchDelete(productStatusList, op);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(op)); }
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        return doLumpRemove(ls, op);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * productStatusBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;ProductStatus, ProductStatusCB&gt;() {
     *     public ConditionBean setup(productStatus entity, ProductStatusCB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     *
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<ProductStatus, ProductStatusCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<ProductStatus, ProductStatusCB> sp, InsertOption<ProductStatusCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        ProductStatus e = new ProductStatus();
        ProductStatusCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected ProductStatusCB createCBForQueryInsert() {
        ProductStatusCB cb = newMyConditionBean();
        cb.xsetupForQueryInsert();
        return cb;
    }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> option) {
        if (option == null) { return queryInsert(downcast(setupper)); }
        else { return varyingQueryInsert(downcast(setupper), downcast(option)); }
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * ProductStatus productStatus = new ProductStatus();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//productStatus.setPK...(value);</span>
     * productStatus.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//productStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//productStatus.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//productStatus.setVersionNo(value);</span>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * productStatusBhv.<span style="color: #DD4747">queryUpdate</span>(productStatus, cb);
     * </pre>
     * @param productStatus The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(ProductStatus productStatus, ProductStatusCB cb) {
        return doQueryUpdate(productStatus, cb, null);
    }

    protected int doQueryUpdate(ProductStatus productStatus, ProductStatusCB cb, UpdateOption<ProductStatusCB> op) {
        assertObjectNotNull("productStatus", productStatus); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(productStatus, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (ProductStatusCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (ProductStatusCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * productStatusBhv.<span style="color: #DD4747">queryDelete</span>(productStatus, cb);
     * </pre>
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(ProductStatusCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(ProductStatusCB cb, DeleteOption<ProductStatusCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((ProductStatusCB)cb); }
        else { return varyingQueryDelete((ProductStatusCB)cb, downcast(op)); }
    }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as insert(entity).
     * <pre>
     * ProductStatus productStatus = new ProductStatus();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * productStatus.setFoo...(value);
     * productStatus.setBar...(value);
     * InsertOption<ProductStatusCB> option = new InsertOption<ProductStatusCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * productStatusBhv.<span style="color: #DD4747">varyingInsert</span>(productStatus, option);
     * ... = productStatus.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param productStatus The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(ProductStatus productStatus, InsertOption<ProductStatusCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(productStatus, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * ProductStatus productStatus = new ProductStatus();
     * productStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * productStatus.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * productStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;ProductStatusCB&gt; option = new UpdateOption&lt;ProductStatusCB&gt;();
     *     option.self(new SpecifyQuery&lt;ProductStatusCB&gt;() {
     *         public void specify(ProductStatusCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     productStatusBhv.<span style="color: #DD4747">varyingUpdate</span>(productStatus, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param productStatus The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(ProductStatus productStatus, UpdateOption<ProductStatusCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(productStatus, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param productStatus The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(ProductStatus productStatus, InsertOption<ProductStatusCB> insertOption, UpdateOption<ProductStatusCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(productStatus, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param productStatus The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(ProductStatus productStatus, DeleteOption<ProductStatusCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(productStatus, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param productStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<ProductStatus> productStatusList, InsertOption<ProductStatusCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(productStatusList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param productStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<ProductStatus> productStatusList, UpdateOption<ProductStatusCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(productStatusList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param productStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<ProductStatus> productStatusList, DeleteOption<ProductStatusCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(productStatusList, option);
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as queryInsert(entity, setupper).
     * @param setupper The setup-per of query-insert. (NotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(QueryInsertSetupper<ProductStatus, ProductStatusCB> setupper, InsertOption<ProductStatusCB> option) {
        assertInsertOptionNotNull(option);
        return doQueryInsert(setupper, option);
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br />
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * ProductStatus productStatus = new ProductStatus();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//productStatus.setPK...(value);</span>
     * productStatus.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//productStatus.setVersionNo(value);</span>
     * ProductStatusCB cb = new ProductStatusCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;ProductStatusCB&gt; option = new UpdateOption&lt;ProductStatusCB&gt;();
     * option.self(new SpecifyQuery&lt;ProductStatusCB&gt;() {
     *     public void specify(ProductStatusCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * productStatusBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(productStatus, cb, option);
     * </pre>
     * @param productStatus The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(ProductStatus productStatus, ProductStatusCB cb, UpdateOption<ProductStatusCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(productStatus, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of ProductStatus. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(ProductStatusCB cb, DeleteOption<ProductStatusCB> option) {
        assertDeleteOptionNotNull(option);
        return doQueryDelete(cb, option);
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the basic executor of outside-SQL to execute it. <br />
     * The invoker of behavior command should be not null when you call this method.
     * <pre>
     * You can use the methods for outside-SQL are as follows:
     * {Basic}
     *   o selectList()
     *   o execute()
     *   o call()
     *
     * {Entity}
     *   o entityHandling().selectEntity()
     *   o entityHandling().selectEntityWithDeletedCheck()
     *
     * {Paging}
     *   o autoPaging().selectList()
     *   o autoPaging().selectPage()
     *   o manualPaging().selectList()
     *   o manualPaging().selectPage()
     *
     * {Cursor}
     *   o cursorHandling().selectCursor()
     *
     * {Option}
     *   o dynamicBinding().selectList()
     *   o removeBlockComment().selectList()
     *   o removeLineComment().selectList()
     *   o formatSql().selectList()
     * </pre>
     * @return The basic executor of outside-SQL. (NotNull)
     */
    public OutsideSqlBasicExecutor<ProductStatusBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(ProductStatusCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(ProductStatusCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends ProductStatus> void delegateSelectCursor(ProductStatusCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends ProductStatus> List<ENTITY> delegateSelectList(ProductStatusCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(ProductStatus et, InsertOption<ProductStatusCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(ProductStatus et, UpdateOption<ProductStatusCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(ProductStatus et, UpdateOption<ProductStatusCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(ProductStatus et, DeleteOption<ProductStatusCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(ProductStatus et, DeleteOption<ProductStatusCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<ProductStatus> ls, InsertOption<ProductStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<ProductStatus> ls, UpdateOption<ProductStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<ProductStatus> ls, UpdateOption<ProductStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<ProductStatus> ls, DeleteOption<ProductStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<ProductStatus> ls, DeleteOption<ProductStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(ProductStatus et, ProductStatusCB inCB, ConditionBean resCB, InsertOption<ProductStatusCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(ProductStatus et, ProductStatusCB cb, UpdateOption<ProductStatusCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(ProductStatusCB cb, DeleteOption<ProductStatusCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity et) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasUpdateDateValue(Entity et) {
        return false;
    }

    // ===================================================================================
    //                                                                     Downcast Helper
    //                                                                     ===============
    protected ProductStatus downcast(Entity et) {
        return helpEntityDowncastInternally(et, ProductStatus.class);
    }

    protected ProductStatusCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, ProductStatusCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<ProductStatus> downcast(List<? extends Entity> ls) {
        return (List<ProductStatus>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<ProductStatusCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<ProductStatusCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<ProductStatusCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<ProductStatusCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<ProductStatusCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<ProductStatusCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<ProductStatus, ProductStatusCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<ProductStatus, ProductStatusCB>)sp;
    }
}
