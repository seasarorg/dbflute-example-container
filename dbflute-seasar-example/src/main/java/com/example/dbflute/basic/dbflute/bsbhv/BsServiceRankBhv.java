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
import org.seasar.dbflute.cbean.chelper.HpSLSExecutor;
import org.seasar.dbflute.cbean.chelper.HpSLSFunction;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.optional.OptionalEntity;
import org.seasar.dbflute.outsidesql.executor.*;
import com.example.dbflute.basic.dbflute.allcommon.CDef;
import com.example.dbflute.basic.dbflute.exbhv.*;
import com.example.dbflute.basic.dbflute.bsbhv.loader.*;
import com.example.dbflute.basic.dbflute.exentity.*;
import com.example.dbflute.basic.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.basic.dbflute.cbean.*;

/**
 * The behavior of (サービスランク)SERVICE_RANK as TABLE. <br />
 * <pre>
 * [primary key]
 *     SERVICE_RANK_CODE
 *
 * [column]
 *     SERVICE_RANK_CODE, SERVICE_RANK_NAME, SERVICE_POINT_INCIDENCE, NEW_ACCEPTABLE_FLG, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER_SERVICE
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     memberServiceList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsServiceRankBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "SERVICE_RANK"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** {@inheritDoc} */
    public DBMeta getDBMeta() { return ServiceRankDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public ServiceRankDbm getMyDBMeta() { return ServiceRankDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public ServiceRank newEntity() { return new ServiceRank(); }

    /** {@inheritDoc} */
    public ServiceRankCB newConditionBean() { return new ServiceRankCB(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public ServiceRank newMyEntity() { return new ServiceRank(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public ServiceRankCB newMyConditionBean() { return new ServiceRankCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * int count = serviceRankBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(ServiceRankCB cb) {
        return facadeSelectCount(cb);
    }

    protected int facadeSelectCount(ServiceRankCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(ServiceRankCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(ServiceRankCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    @Override
    protected int doReadCount(ConditionBean cb) {
        return facadeSelectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean. #beforejava8 <br />
     * <span style="color: #AD4747; font-size: 120%">The return might be null if no data, so you should have null check.</span> <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, use selectEntityWithDeletedCheck().</span>
     * <pre>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * ServiceRank serviceRank = serviceRankBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (serviceRank != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = serviceRank.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ServiceRank selectEntity(ServiceRankCB cb) {
        return facadeSelectEntity(cb);
    }

    protected ServiceRank facadeSelectEntity(ServiceRankCB cb) {
        return doSelectEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends ServiceRank> ENTITY doSelectEntity(ServiceRankCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, ServiceRankCB>() {
            public List<ENTITY> callbackSelectList(ServiceRankCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends ServiceRank> OptionalEntity<ENTITY> doSelectOptionalEntity(ServiceRankCB cb, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return facadeSelectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check. <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, this method is good.</span>
     * <pre>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * ServiceRank serviceRank = serviceRankBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = serviceRank.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ServiceRank selectEntityWithDeletedCheck(ServiceRankCB cb) {
        return facadeSelectEntityWithDeletedCheck(cb);
    }

    protected ServiceRank facadeSelectEntityWithDeletedCheck(ServiceRankCB cb) {
        return doSelectEntityWithDeletedCheck(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends ServiceRank> ENTITY doSelectEntityWithDeletedCheck(ServiceRankCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, ServiceRankCB>() {
            public List<ENTITY> callbackSelectList(ServiceRankCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return facadeSelectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param serviceRankCode (サービスランクコード): PK, NotNull, CHAR(3), classification=ServiceRank. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ServiceRank selectByPKValue(CDef.ServiceRank serviceRankCode) {
        return facadeSelectByPKValue(serviceRankCode);
    }

    protected ServiceRank facadeSelectByPKValue(CDef.ServiceRank serviceRankCode) {
        return doSelectByPK(serviceRankCode, typeOfSelectedEntity());
    }

    protected <ENTITY extends ServiceRank> ENTITY doSelectByPK(CDef.ServiceRank serviceRankCode, Class<ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(serviceRankCode), tp);
    }

    protected <ENTITY extends ServiceRank> OptionalEntity<ENTITY> doSelectOptionalByPK(CDef.ServiceRank serviceRankCode, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(serviceRankCode, tp), serviceRankCode);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param serviceRankCode (サービスランクコード): PK, NotNull, CHAR(3), classification=ServiceRank. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ServiceRank selectByPKValueWithDeletedCheck(CDef.ServiceRank serviceRankCode) {
        return doSelectByPKWithDeletedCheck(serviceRankCode, typeOfSelectedEntity());
    }

    protected <ENTITY extends ServiceRank> ENTITY doSelectByPKWithDeletedCheck(CDef.ServiceRank serviceRankCode, Class<ENTITY> tp) {
        return doSelectEntityWithDeletedCheck(xprepareCBAsPK(serviceRankCode), tp);
    }

    protected ServiceRankCB xprepareCBAsPK(CDef.ServiceRank serviceRankCode) {
        assertObjectNotNull("serviceRankCode", serviceRankCode);
        return newConditionBean().acceptPK(serviceRankCode);
    }

    /**
     * Select the entity by the unique-key value.
     * @param displayOrder (表示順): UQ, NotNull, INTEGER(10). (NotNull)
     * @return The optional entity selected by the unique key. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<ServiceRank> selectByUniqueOf(Integer displayOrder) {
        return facadeSelectByUniqueOf(displayOrder);
    }

    protected OptionalEntity<ServiceRank> facadeSelectByUniqueOf(Integer displayOrder) {
        return doSelectByUniqueOf(displayOrder, typeOfSelectedEntity());
    }

    protected <ENTITY extends ServiceRank> OptionalEntity<ENTITY> doSelectByUniqueOf(Integer displayOrder, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(xprepareCBAsUniqueOf(displayOrder), tp), displayOrder);
    }

    protected ServiceRankCB xprepareCBAsUniqueOf(Integer displayOrder) {
        assertObjectNotNull("displayOrder", displayOrder);
        return newConditionBean().acceptUniqueOf(displayOrder);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;ServiceRank&gt; serviceRankList = serviceRankBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (ServiceRank serviceRank : serviceRankList) {
     *     ... = serviceRank.get...();
     * }
     * </pre>
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<ServiceRank> selectList(ServiceRankCB cb) {
        return facadeSelectList(cb);
    }

    protected ListResultBean<ServiceRank> facadeSelectList(ServiceRankCB cb) {
        return doSelectList(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends ServiceRank> ListResultBean<ENTITY> doSelectList(ServiceRankCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, ServiceRankCB>() {
            public List<ENTITY> callbackSelectList(ServiceRankCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
    }

    @Override
    protected ListResultBean<? extends Entity> doReadList(ConditionBean cb) {
        return facadeSelectList(downcast(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;ServiceRank&gt; page = serviceRankBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (ServiceRank serviceRank : page) {
     *     ... = serviceRank.get...();
     * }
     * </pre>
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<ServiceRank> selectPage(ServiceRankCB cb) {
        return facadeSelectPage(cb);
    }

    protected PagingResultBean<ServiceRank> facadeSelectPage(ServiceRankCB cb) {
        return doSelectPage(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends ServiceRank> PagingResultBean<ENTITY> doSelectPage(ServiceRankCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, ServiceRankCB>() {
            public int callbackSelectCount(ServiceRankCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(ServiceRankCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    @Override
    protected PagingResultBean<? extends Entity> doReadPage(ConditionBean cb) {
        return facadeSelectPage(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * serviceRankBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;ServiceRank&gt;() {
     *     public void handle(ServiceRank entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @param entityRowHandler The handler of entity row of ServiceRank. (NotNull)
     */
    public void selectCursor(ServiceRankCB cb, EntityRowHandler<ServiceRank> entityRowHandler) {
        facadeSelectCursor(cb, entityRowHandler);
    }

    protected void facadeSelectCursor(ServiceRankCB cb, EntityRowHandler<ServiceRank> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, typeOfSelectedEntity());
    }

    protected <ENTITY extends ServiceRank> void doSelectCursor(ServiceRankCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, ServiceRankCB>() {
            public void callbackSelectCursor(ServiceRankCB lcb, EntityRowHandler<ENTITY> lhandler, Class<ENTITY> ltp) { delegateSelectCursor(lcb, lhandler, ltp); }
            public List<ENTITY> callbackSelectList(ServiceRankCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * serviceRankBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(ServiceRankCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<ServiceRankCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return facadeScalarSelect(resultType);
    }

    protected <RESULT> HpSLSFunction<ServiceRankCB, RESULT> facadeScalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newConditionBean());
    }

    protected <RESULT, CB extends ServiceRankCB> HpSLSFunction<CB, RESULT> doScalarSelect(final Class<RESULT> tp, final CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        HpSLSExecutor<CB, RESULT> executor = createHpSLSExecutor(); // variable to resolve generic
        return createSLSFunction(cb, tp, executor);
    }

    protected <RESULT> HpSLSFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> tp) {
        return facadeScalarSelect(tp);
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
     * Load referrer by the the referrer loader. <br />
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.query().set...
     * List&lt;Member&gt; memberList = memberBhv.selectList(cb);
     * memberBhv.<span style="color: #DD4747">load</span>(memberList, loader -&gt; {
     *     loader.<span style="color: #DD4747">loadPurchaseList</span>(purchaseCB -&gt; {
     *         purchaseCB.query().set...
     *         purchaseCB.query().addOrderBy_PurchasePrice_Desc();
     *     }); <span style="color: #3F7E5E">// you can also load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedList(purchaseLoader -&gt {</span>
     *     <span style="color: #3F7E5E">//    purchaseLoader.loadPurchasePaymentList(...);</span>
     *     <span style="color: #3F7E5E">//});</span>
     *
     *     <span style="color: #3F7E5E">// you can also pull out foreign table and load its referrer</span>
     *     <span style="color: #3F7E5E">// (setupSelect of the foreign table should be called)</span>
     *     <span style="color: #3F7E5E">//loader.pulloutMemberStatus().loadMemberLoginList(...)</span>
     * }
     * for (Member member : memberList) {
     *     List&lt;Purchase&gt; purchaseList = member.<span style="color: #DD4747">getPurchaseList()</span>;
     *     for (Purchase purchase : purchaseList) {
     *         ...
     *     }
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has order by FK before callback.
     * @param serviceRankList The entity list of serviceRank. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<ServiceRank> serviceRankList, ReferrerLoaderHandler<LoaderOfServiceRank> handler) {
        xassLRArg(serviceRankList, handler);
        handler.handle(new LoaderOfServiceRank().ready(serviceRankList, _behaviorSelector));
    }

    /**
     * Load referrer of ${referrer.referrerJavaBeansRulePropertyName} by the referrer loader. <br />
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.query().set...
     * Member member = memberBhv.selectEntityWithDeletedCheck(cb);
     * memberBhv.<span style="color: #DD4747">load</span>(member, loader -&gt; {
     *     loader.<span style="color: #DD4747">loadPurchaseList</span>(purchaseCB -&gt; {
     *         purchaseCB.query().set...
     *         purchaseCB.query().addOrderBy_PurchasePrice_Desc();
     *     }); <span style="color: #3F7E5E">// you can also load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedList(purchaseLoader -&gt {</span>
     *     <span style="color: #3F7E5E">//    purchaseLoader.loadPurchasePaymentList(...);</span>
     *     <span style="color: #3F7E5E">//});</span>
     *
     *     <span style="color: #3F7E5E">// you can also pull out foreign table and load its referrer</span>
     *     <span style="color: #3F7E5E">// (setupSelect of the foreign table should be called)</span>
     *     <span style="color: #3F7E5E">//loader.pulloutMemberStatus().loadMemberLoginList(...)</span>
     * }
     * for (Member member : memberList) {
     *     List&lt;Purchase&gt; purchaseList = member.<span style="color: #DD4747">getPurchaseList()</span>;
     *     for (Purchase purchase : purchaseList) {
     *         ...
     *     }
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has order by FK before callback.
     * @param serviceRank The entity of serviceRank. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(ServiceRank serviceRank, ReferrerLoaderHandler<LoaderOfServiceRank> handler) {
        xassLRArg(serviceRank, handler);
        handler.handle(new LoaderOfServiceRank().ready(xnewLRAryLs(serviceRank), _behaviorSelector));
    }

    /**
     * Load referrer of memberServiceList by the set-upper of referrer. <br />
     * (会員サービス)MEMBER_SERVICE by SERVICE_RANK_CODE, named 'memberServiceList'.
     * <pre>
     * serviceRankBhv.<span style="color: #DD4747">loadMemberServiceList</span>(serviceRankList, new ConditionBeanSetupper&lt;MemberServiceCB&gt;() {
     *     public void setup(MemberServiceCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * for (ServiceRank serviceRank : serviceRankList) {
     *     ... = serviceRank.<span style="color: #DD4747">getMemberServiceList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setServiceRankCode_InScope(pkList);
     * cb.query().addOrderBy_ServiceRankCode_Asc();
     * </pre>
     * @param serviceRankList The entity list of serviceRank. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<MemberService> loadMemberServiceList(List<ServiceRank> serviceRankList, ConditionBeanSetupper<MemberServiceCB> setupper) {
        xassLRArg(serviceRankList, setupper);
        return doLoadMemberServiceList(serviceRankList, new LoadReferrerOption<MemberServiceCB, MemberService>().xinit(setupper));
    }

    /**
     * Load referrer of memberServiceList by the set-upper of referrer. <br />
     * (会員サービス)MEMBER_SERVICE by SERVICE_RANK_CODE, named 'memberServiceList'.
     * <pre>
     * serviceRankBhv.<span style="color: #DD4747">loadMemberServiceList</span>(serviceRankList, new ConditionBeanSetupper&lt;MemberServiceCB&gt;() {
     *     public void setup(MemberServiceCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = serviceRank.<span style="color: #DD4747">getMemberServiceList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setServiceRankCode_InScope(pkList);
     * cb.query().addOrderBy_ServiceRankCode_Asc();
     * </pre>
     * @param serviceRank The entity of serviceRank. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<MemberService> loadMemberServiceList(ServiceRank serviceRank, ConditionBeanSetupper<MemberServiceCB> setupper) {
        xassLRArg(serviceRank, setupper);
        return doLoadMemberServiceList(xnewLRLs(serviceRank), new LoadReferrerOption<MemberServiceCB, MemberService>().xinit(setupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.} #beforejava8
     * @param serviceRank The entity of serviceRank. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<MemberService> loadMemberServiceList(ServiceRank serviceRank, LoadReferrerOption<MemberServiceCB, MemberService> loadReferrerOption) {
        xassLRArg(serviceRank, loadReferrerOption);
        return loadMemberServiceList(xnewLRLs(serviceRank), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.} #beforejava8
     * @param serviceRankList The entity list of serviceRank. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    @SuppressWarnings("unchecked")
    public NestedReferrerListGateway<MemberService> loadMemberServiceList(List<ServiceRank> serviceRankList, LoadReferrerOption<MemberServiceCB, MemberService> loadReferrerOption) {
        xassLRArg(serviceRankList, loadReferrerOption);
        if (serviceRankList.isEmpty()) { return (NestedReferrerListGateway<MemberService>)EMPTY_NREF_LGWAY; }
        return doLoadMemberServiceList(serviceRankList, loadReferrerOption);
    }

    protected NestedReferrerListGateway<MemberService> doLoadMemberServiceList(List<ServiceRank> serviceRankList, LoadReferrerOption<MemberServiceCB, MemberService> option) {
        final MemberServiceBhv referrerBhv = xgetBSFLR().select(MemberServiceBhv.class);
        return helpLoadReferrerInternally(serviceRankList, option, new InternalLoadReferrerCallback<ServiceRank, String, MemberServiceCB, MemberService>() {
            public String getPKVal(ServiceRank et)
            { return et.getServiceRankCode(); }
            public void setRfLs(ServiceRank et, List<MemberService> ls)
            { et.setMemberServiceList(ls); }
            public MemberServiceCB newMyCB() { return referrerBhv.newConditionBean(); }
            public void qyFKIn(MemberServiceCB cb, List<String> ls)
            { cb.query().setServiceRankCode_InScope(ls); }
            public void qyOdFKAsc(MemberServiceCB cb) { cb.query().addOrderBy_ServiceRankCode_Asc(); }
            public void spFKCol(MemberServiceCB cb) { cb.specify().columnServiceRankCode(); }
            public List<MemberService> selRfLs(MemberServiceCB cb) { return referrerBhv.selectList(cb); }
            public String getFKVal(MemberService re) { return re.getServiceRankCode(); }
            public void setlcEt(MemberService re, ServiceRank le)
            { re.setServiceRank(le); }
            public String getRfPrNm() { return "memberServiceList"; }
        });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key serviceRankCode.
     * @param serviceRankList The list of serviceRank. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractServiceRankCodeList(List<ServiceRank> serviceRankList) {
        return helpExtractListInternally(serviceRankList, new InternalExtractCallback<ServiceRank, String>() {
            public String getCV(ServiceRank et) { return et.getServiceRankCode(); }
        });
    }

    /**
     * Extract the value list of (single) unique key displayOrder.
     * @param serviceRankList The list of serviceRank. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractDisplayOrderList(List<ServiceRank> serviceRankList) {
        return helpExtractListInternally(serviceRankList, new InternalExtractCallback<ServiceRank, Integer>() {
            public Integer getCV(ServiceRank et) { return et.getDisplayOrder(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * ServiceRank serviceRank = new ServiceRank();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * serviceRank.setFoo...(value);
     * serviceRank.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//serviceRank.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//serviceRank.set...;</span>
     * serviceRankBhv.<span style="color: #DD4747">insert</span>(serviceRank);
     * ... = serviceRank.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param serviceRank The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(ServiceRank serviceRank) {
        doInsert(serviceRank, null);
    }

    protected void doInsert(ServiceRank et, InsertOption<ServiceRankCB> op) {
        assertObjectNotNull("serviceRank", et);
        prepareInsertOption(op);
        delegateInsert(et, op);
    }

    protected void prepareInsertOption(InsertOption<ServiceRankCB> op) {
        if (op == null) { return; }
        assertInsertOptionStatus(op);
        if (op.hasSpecifiedInsertColumn()) {
            op.resolveInsertColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    @Override
    protected void doCreate(Entity et, InsertOption<? extends ConditionBean> op) {
        doInsert(downcast(et), downcast(op));
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * ServiceRank serviceRank = new ServiceRank();
     * serviceRank.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * serviceRank.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//serviceRank.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//serviceRank.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * serviceRank.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     serviceRankBhv.<span style="color: #DD4747">update</span>(serviceRank);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param serviceRank The entity of update. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(ServiceRank serviceRank) {
        doUpdate(serviceRank, null);
    }

    protected void doUpdate(ServiceRank et, final UpdateOption<ServiceRankCB> op) {
        assertObjectNotNull("serviceRank", et);
        prepareUpdateOption(op);
        helpUpdateInternally(et, new InternalUpdateCallback<ServiceRank>() {
            public int callbackDelegateUpdate(ServiceRank let) { return delegateUpdate(let, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<ServiceRankCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) { op.resolveSelfSpecification(createCBForVaryingUpdate()); }
        if (op.hasSpecifiedUpdateColumn()) { op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected ServiceRankCB createCBForVaryingUpdate()
    { ServiceRankCB cb = newConditionBean(); cb.xsetupForVaryingUpdate(); return cb; }

    protected ServiceRankCB createCBForSpecifiedUpdate()
    { ServiceRankCB cb = newConditionBean(); cb.xsetupForSpecifiedUpdate(); return cb; }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        doUpdate(downcast(et), downcast(op));
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        doModify(et, op);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param serviceRank The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(ServiceRank serviceRank) {
        doInsertOrUpdate(serviceRank, null, null);
    }

    protected void doInsertOrUpdate(ServiceRank et, final InsertOption<ServiceRankCB> iop, final UpdateOption<ServiceRankCB> uop) {
        assertObjectNotNull("serviceRank", et);
        helpInsertOrUpdateInternally(et, new InternalInsertOrUpdateCallback<ServiceRank, ServiceRankCB>() {
            public void callbackInsert(ServiceRank let) { doInsert(let, iop); }
            public void callbackUpdate(ServiceRank let) { doUpdate(let, uop); }
            public ServiceRankCB callbackNewMyConditionBean() { return newConditionBean(); }
            public int callbackSelectCount(ServiceRankCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doInsertOrUpdate(downcast(et), downcast(iop), downcast(uop));
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doCreateOrModify(et, iop, uop);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * ServiceRank serviceRank = new ServiceRank();
     * serviceRank.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * serviceRank.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     serviceRankBhv.<span style="color: #DD4747">delete</span>(serviceRank);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param serviceRank The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(ServiceRank serviceRank) {
        doDelete(serviceRank, null);
    }

    protected void doDelete(ServiceRank et, final DeleteOption<ServiceRankCB> op) {
        assertObjectNotNull("serviceRank", et);
        prepareDeleteOption(op);
        helpDeleteInternally(et, new InternalDeleteCallback<ServiceRank>() {
            public int callbackDelegateDelete(ServiceRank let) { return delegateDelete(let, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<ServiceRankCB> op)
    { if (op != null) { assertDeleteOptionStatus(op); } }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        doDelete(downcast(et), downcast(op));
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
     *     ServiceRank serviceRank = new ServiceRank();
     *     serviceRank.setFooName("foo");
     *     if (...) {
     *         serviceRank.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     serviceRankList.add(serviceRank);
     * }
     * serviceRankBhv.<span style="color: #DD4747">batchInsert</span>(serviceRankList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param serviceRankList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<ServiceRank> serviceRankList) {
        return doBatchInsert(serviceRankList, null);
    }

    protected int[] doBatchInsert(List<ServiceRank> ls, InsertOption<ServiceRankCB> op) {
        assertObjectNotNull("serviceRankList", ls);
        InsertOption<ServiceRankCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainInsertOption(); }
        prepareBatchInsertOption(ls, rlop); // required
        return delegateBatchInsert(ls, rlop);
    }

    protected void prepareBatchInsertOption(List<ServiceRank> ls, InsertOption<ServiceRankCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(ls);
        prepareInsertOption(op);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) {
        return doBatchInsert(downcast(ls), downcast(op));
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     ServiceRank serviceRank = new ServiceRank();
     *     serviceRank.setFooName("foo");
     *     if (...) {
     *         serviceRank.setFooPrice(123);
     *     } else {
     *         serviceRank.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//serviceRank.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     serviceRankList.add(serviceRank);
     * }
     * serviceRankBhv.<span style="color: #DD4747">batchUpdate</span>(serviceRankList);
     * </pre>
     * @param serviceRankList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<ServiceRank> serviceRankList) {
        return doBatchUpdate(serviceRankList, null);
    }

    protected int[] doBatchUpdate(List<ServiceRank> ls, UpdateOption<ServiceRankCB> op) {
        assertObjectNotNull("serviceRankList", ls);
        UpdateOption<ServiceRankCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop); // required
        return delegateBatchUpdate(ls, rlop);
    }

    protected void prepareBatchUpdateOption(List<ServiceRank> ls, UpdateOption<ServiceRankCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(ls);
        prepareUpdateOption(op);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doBatchUpdate(downcast(ls), downcast(op));
    }

    /**
     * Batch-update the entity list specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * serviceRankBhv.<span style="color: #DD4747">batchUpdate</span>(serviceRankList, new SpecifyQuery<ServiceRankCB>() {
     *     public void specify(ServiceRankCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * serviceRankBhv.<span style="color: #DD4747">batchUpdate</span>(serviceRankList, new SpecifyQuery<ServiceRankCB>() {
     *     public void specify(ServiceRankCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param serviceRankList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<ServiceRank> serviceRankList, SpecifyQuery<ServiceRankCB> updateColumnSpec) {
        return doBatchUpdate(serviceRankList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param serviceRankList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<ServiceRank> serviceRankList) {
        return doBatchDelete(serviceRankList, null);
    }

    protected int[] doBatchDelete(List<ServiceRank> ls, DeleteOption<ServiceRankCB> op) {
        assertObjectNotNull("serviceRankList", ls);
        prepareDeleteOption(op);
        return delegateBatchDelete(ls, op);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        return doBatchDelete(downcast(ls), downcast(op));
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
     * serviceRankBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;ServiceRank, ServiceRankCB&gt;() {
     *     public ConditionBean setup(serviceRank entity, ServiceRankCB intoCB) {
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
     *         <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<ServiceRank, ServiceRankCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<ServiceRank, ServiceRankCB> sp, InsertOption<ServiceRankCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        ServiceRank et = newEntity();
        ServiceRankCB cb = createCBForQueryInsert();
        return delegateQueryInsert(et, cb, sp.setup(et, cb), op);
    }

    protected ServiceRankCB createCBForQueryInsert()
    { ServiceRankCB cb = newConditionBean(); cb.xsetupForQueryInsert(); return cb; }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> op) {
        return doQueryInsert(downcast(setupper), downcast(op));
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * ServiceRank serviceRank = new ServiceRank();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//serviceRank.setPK...(value);</span>
     * serviceRank.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//serviceRank.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//serviceRank.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//serviceRank.setVersionNo(value);</span>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * serviceRankBhv.<span style="color: #DD4747">queryUpdate</span>(serviceRank, cb);
     * </pre>
     * @param serviceRank The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(ServiceRank serviceRank, ServiceRankCB cb) {
        return doQueryUpdate(serviceRank, cb, null);
    }

    protected int doQueryUpdate(ServiceRank et, ServiceRankCB cb, UpdateOption<ServiceRankCB> op) {
        assertObjectNotNull("serviceRank", et); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(et, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        return doQueryUpdate(downcast(et), downcast(cb), downcast(op));
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * serviceRankBhv.<span style="color: #DD4747">queryDelete</span>(serviceRank, cb);
     * </pre>
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(ServiceRankCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(ServiceRankCB cb, DeleteOption<ServiceRankCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        return doQueryDelete(downcast(cb), downcast(op));
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
     * ServiceRank serviceRank = new ServiceRank();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * serviceRank.setFoo...(value);
     * serviceRank.setBar...(value);
     * InsertOption<ServiceRankCB> option = new InsertOption<ServiceRankCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * serviceRankBhv.<span style="color: #DD4747">varyingInsert</span>(serviceRank, option);
     * ... = serviceRank.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param serviceRank The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(ServiceRank serviceRank, InsertOption<ServiceRankCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(serviceRank, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * ServiceRank serviceRank = new ServiceRank();
     * serviceRank.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * serviceRank.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * serviceRank.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;ServiceRankCB&gt; option = new UpdateOption&lt;ServiceRankCB&gt;();
     *     option.self(new SpecifyQuery&lt;ServiceRankCB&gt;() {
     *         public void specify(ServiceRankCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     serviceRankBhv.<span style="color: #DD4747">varyingUpdate</span>(serviceRank, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param serviceRank The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(ServiceRank serviceRank, UpdateOption<ServiceRankCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(serviceRank, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param serviceRank The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(ServiceRank serviceRank, InsertOption<ServiceRankCB> insertOption, UpdateOption<ServiceRankCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdate(serviceRank, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param serviceRank The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(ServiceRank serviceRank, DeleteOption<ServiceRankCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(serviceRank, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param serviceRankList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<ServiceRank> serviceRankList, InsertOption<ServiceRankCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(serviceRankList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param serviceRankList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<ServiceRank> serviceRankList, UpdateOption<ServiceRankCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(serviceRankList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param serviceRankList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<ServiceRank> serviceRankList, DeleteOption<ServiceRankCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(serviceRankList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<ServiceRank, ServiceRankCB> setupper, InsertOption<ServiceRankCB> option) {
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
     * ServiceRank serviceRank = new ServiceRank();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//serviceRank.setPK...(value);</span>
     * serviceRank.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//serviceRank.setVersionNo(value);</span>
     * ServiceRankCB cb = new ServiceRankCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;ServiceRankCB&gt; option = new UpdateOption&lt;ServiceRankCB&gt;();
     * option.self(new SpecifyQuery&lt;ServiceRankCB&gt;() {
     *     public void specify(ServiceRankCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * serviceRankBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(serviceRank, cb, option);
     * </pre>
     * @param serviceRank The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(ServiceRank serviceRank, ServiceRankCB cb, UpdateOption<ServiceRankCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(serviceRank, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of ServiceRank. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(ServiceRankCB cb, DeleteOption<ServiceRankCB> option) {
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
    public OutsideSqlBasicExecutor<ServiceRankBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(ServiceRankCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(ServiceRankCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends ServiceRank> void delegateSelectCursor(ServiceRankCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends ServiceRank> List<ENTITY> delegateSelectList(ServiceRankCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(ServiceRank et, InsertOption<ServiceRankCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(ServiceRank et, UpdateOption<ServiceRankCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(ServiceRank et, UpdateOption<ServiceRankCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(ServiceRank et, DeleteOption<ServiceRankCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(ServiceRank et, DeleteOption<ServiceRankCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<ServiceRank> ls, InsertOption<ServiceRankCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<ServiceRank> ls, UpdateOption<ServiceRankCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<ServiceRank> ls, UpdateOption<ServiceRankCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<ServiceRank> ls, DeleteOption<ServiceRankCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<ServiceRank> ls, DeleteOption<ServiceRankCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(ServiceRank et, ServiceRankCB inCB, ConditionBean resCB, InsertOption<ServiceRankCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(ServiceRank et, ServiceRankCB cb, UpdateOption<ServiceRankCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(ServiceRankCB cb, DeleteOption<ServiceRankCB> op)
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
    //                                                                       Assist Helper
    //                                                                       =============
    protected Class<ServiceRank> typeOfSelectedEntity()
    { return ServiceRank.class; }

    protected ServiceRank downcast(Entity et)
    { return helpEntityDowncastInternally(et, ServiceRank.class); }

    protected ServiceRankCB downcast(ConditionBean cb)
    { return helpConditionBeanDowncastInternally(cb, ServiceRankCB.class); }

    @SuppressWarnings("unchecked")
    protected List<ServiceRank> downcast(List<? extends Entity> ls)
    { return (List<ServiceRank>)ls; }

    @SuppressWarnings("unchecked")
    protected InsertOption<ServiceRankCB> downcast(InsertOption<? extends ConditionBean> op)
    { return (InsertOption<ServiceRankCB>)op; }

    @SuppressWarnings("unchecked")
    protected UpdateOption<ServiceRankCB> downcast(UpdateOption<? extends ConditionBean> op)
    { return (UpdateOption<ServiceRankCB>)op; }

    @SuppressWarnings("unchecked")
    protected DeleteOption<ServiceRankCB> downcast(DeleteOption<? extends ConditionBean> op)
    { return (DeleteOption<ServiceRankCB>)op; }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<ServiceRank, ServiceRankCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp)
    { return (QueryInsertSetupper<ServiceRank, ServiceRankCB>)sp; }
}
