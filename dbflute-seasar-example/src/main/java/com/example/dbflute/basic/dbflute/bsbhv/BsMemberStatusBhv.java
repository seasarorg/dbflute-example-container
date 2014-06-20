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
 * The behavior of (会員ステータス)MEMBER_STATUS as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_STATUS_CODE
 *
 * [column]
 *     MEMBER_STATUS_CODE, MEMBER_STATUS_NAME, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER, MEMBER_LOGIN
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     memberList, memberLoginList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberStatusBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /** The example for out of target in Sql2Entity */
    public static final String PATH_truncateMemberStatusInitialized = "truncateMemberStatusInitialized";
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "MEMBER_STATUS"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** {@inheritDoc} */
    public DBMeta getDBMeta() { return MemberStatusDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberStatusDbm getMyDBMeta() { return MemberStatusDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public MemberStatus newEntity() { return new MemberStatus(); }

    /** {@inheritDoc} */
    public MemberStatusCB newConditionBean() { return new MemberStatusCB(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public MemberStatus newMyEntity() { return new MemberStatus(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberStatusCB newMyConditionBean() { return new MemberStatusCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * int count = memberStatusBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberStatusCB cb) {
        return facadeSelectCount(cb);
    }

    protected int facadeSelectCount(MemberStatusCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberStatusCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberStatusCB cb) { // called by selectPage(cb)
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
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * MemberStatus memberStatus = memberStatusBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (memberStatus != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = memberStatus.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberStatus selectEntity(MemberStatusCB cb) {
        return facadeSelectEntity(cb);
    }

    protected MemberStatus facadeSelectEntity(MemberStatusCB cb) {
        return doSelectEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberStatus> ENTITY doSelectEntity(MemberStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, MemberStatusCB>() {
            public List<ENTITY> callbackSelectList(MemberStatusCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends MemberStatus> OptionalEntity<ENTITY> doSelectOptionalEntity(MemberStatusCB cb, Class<ENTITY> tp) {
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
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * MemberStatus memberStatus = memberStatusBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberStatus.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberStatus selectEntityWithDeletedCheck(MemberStatusCB cb) {
        return facadeSelectEntityWithDeletedCheck(cb);
    }

    protected MemberStatus facadeSelectEntityWithDeletedCheck(MemberStatusCB cb) {
        return doSelectEntityWithDeletedCheck(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberStatus> ENTITY doSelectEntityWithDeletedCheck(MemberStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberStatusCB>() {
            public List<ENTITY> callbackSelectList(MemberStatusCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return facadeSelectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param memberStatusCode (会員ステータスコード): PK, NotNull, CHAR(3), classification=MemberStatus. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberStatus selectByPKValue(CDef.MemberStatus memberStatusCode) {
        return facadeSelectByPKValue(memberStatusCode);
    }

    protected MemberStatus facadeSelectByPKValue(CDef.MemberStatus memberStatusCode) {
        return doSelectByPK(memberStatusCode, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberStatus> ENTITY doSelectByPK(CDef.MemberStatus memberStatusCode, Class<ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(memberStatusCode), tp);
    }

    protected <ENTITY extends MemberStatus> OptionalEntity<ENTITY> doSelectOptionalByPK(CDef.MemberStatus memberStatusCode, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(memberStatusCode, tp), memberStatusCode);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param memberStatusCode (会員ステータスコード): PK, NotNull, CHAR(3), classification=MemberStatus. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberStatus selectByPKValueWithDeletedCheck(CDef.MemberStatus memberStatusCode) {
        return doSelectByPKWithDeletedCheck(memberStatusCode, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberStatus> ENTITY doSelectByPKWithDeletedCheck(CDef.MemberStatus memberStatusCode, Class<ENTITY> tp) {
        return doSelectEntityWithDeletedCheck(xprepareCBAsPK(memberStatusCode), tp);
    }

    protected MemberStatusCB xprepareCBAsPK(CDef.MemberStatus memberStatusCode) {
        assertObjectNotNull("memberStatusCode", memberStatusCode);
        return newConditionBean().acceptPK(memberStatusCode);
    }

    /**
     * Select the entity by the unique-key value.
     * @param displayOrder (表示順): UQ, NotNull, INTEGER(10). (NotNull)
     * @return The optional entity selected by the unique key. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<MemberStatus> selectByUniqueOf(Integer displayOrder) {
        return facadeSelectByUniqueOf(displayOrder);
    }

    protected OptionalEntity<MemberStatus> facadeSelectByUniqueOf(Integer displayOrder) {
        return doSelectByUniqueOf(displayOrder, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberStatus> OptionalEntity<ENTITY> doSelectByUniqueOf(Integer displayOrder, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(xprepareCBAsUniqueOf(displayOrder), tp), displayOrder);
    }

    protected MemberStatusCB xprepareCBAsUniqueOf(Integer displayOrder) {
        assertObjectNotNull("displayOrder", displayOrder);
        return newConditionBean().acceptUniqueOf(displayOrder);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;MemberStatus&gt; memberStatusList = memberStatusBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (MemberStatus memberStatus : memberStatusList) {
     *     ... = memberStatus.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberStatus> selectList(MemberStatusCB cb) {
        return facadeSelectList(cb);
    }

    protected ListResultBean<MemberStatus> facadeSelectList(MemberStatusCB cb) {
        return doSelectList(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberStatus> ListResultBean<ENTITY> doSelectList(MemberStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, MemberStatusCB>() {
            public List<ENTITY> callbackSelectList(MemberStatusCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberStatus&gt; page = memberStatusBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (MemberStatus memberStatus : page) {
     *     ... = memberStatus.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberStatus> selectPage(MemberStatusCB cb) {
        return facadeSelectPage(cb);
    }

    protected PagingResultBean<MemberStatus> facadeSelectPage(MemberStatusCB cb) {
        return doSelectPage(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberStatus> PagingResultBean<ENTITY> doSelectPage(MemberStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, MemberStatusCB>() {
            public int callbackSelectCount(MemberStatusCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberStatusCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * memberStatusBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberStatus&gt;() {
     *     public void handle(MemberStatus entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberStatus. (NotNull)
     */
    public void selectCursor(MemberStatusCB cb, EntityRowHandler<MemberStatus> entityRowHandler) {
        facadeSelectCursor(cb, entityRowHandler);
    }

    protected void facadeSelectCursor(MemberStatusCB cb, EntityRowHandler<MemberStatus> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberStatus> void doSelectCursor(MemberStatusCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, MemberStatusCB>() {
            public void callbackSelectCursor(MemberStatusCB lcb, EntityRowHandler<ENTITY> lhandler, Class<ENTITY> ltp) { delegateSelectCursor(lcb, lhandler, ltp); }
            public List<ENTITY> callbackSelectList(MemberStatusCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberStatusBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberStatusCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<MemberStatusCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return facadeScalarSelect(resultType);
    }

    protected <RESULT> HpSLSFunction<MemberStatusCB, RESULT> facadeScalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newConditionBean());
    }

    protected <RESULT, CB extends MemberStatusCB> HpSLSFunction<CB, RESULT> doScalarSelect(final Class<RESULT> tp, final CB cb) {
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
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<MemberStatus> memberStatusList, ReferrerLoaderHandler<LoaderOfMemberStatus> handler) {
        xassLRArg(memberStatusList, handler);
        handler.handle(new LoaderOfMemberStatus().ready(memberStatusList, _behaviorSelector));
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
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(MemberStatus memberStatus, ReferrerLoaderHandler<LoaderOfMemberStatus> handler) {
        xassLRArg(memberStatus, handler);
        handler.handle(new LoaderOfMemberStatus().ready(xnewLRAryLs(memberStatus), _behaviorSelector));
    }

    /**
     * Load referrer of memberList by the set-upper of referrer. <br />
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberList'.
     * <pre>
     * memberStatusBhv.<span style="color: #DD4747">loadMemberList</span>(memberStatusList, new ConditionBeanSetupper&lt;MemberCB&gt;() {
     *     public void setup(MemberCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * for (MemberStatus memberStatus : memberStatusList) {
     *     ... = memberStatus.<span style="color: #DD4747">getMemberList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setMemberStatusCode_InScope(pkList);
     * cb.query().addOrderBy_MemberStatusCode_Asc();
     * </pre>
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Member> loadMemberList(List<MemberStatus> memberStatusList, ConditionBeanSetupper<MemberCB> setupper) {
        xassLRArg(memberStatusList, setupper);
        return doLoadMemberList(memberStatusList, new LoadReferrerOption<MemberCB, Member>().xinit(setupper));
    }

    /**
     * Load referrer of memberList by the set-upper of referrer. <br />
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberList'.
     * <pre>
     * memberStatusBhv.<span style="color: #DD4747">loadMemberList</span>(memberStatusList, new ConditionBeanSetupper&lt;MemberCB&gt;() {
     *     public void setup(MemberCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = memberStatus.<span style="color: #DD4747">getMemberList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setMemberStatusCode_InScope(pkList);
     * cb.query().addOrderBy_MemberStatusCode_Asc();
     * </pre>
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Member> loadMemberList(MemberStatus memberStatus, ConditionBeanSetupper<MemberCB> setupper) {
        xassLRArg(memberStatus, setupper);
        return doLoadMemberList(xnewLRLs(memberStatus), new LoadReferrerOption<MemberCB, Member>().xinit(setupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.} #beforejava8
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<Member> loadMemberList(MemberStatus memberStatus, LoadReferrerOption<MemberCB, Member> loadReferrerOption) {
        xassLRArg(memberStatus, loadReferrerOption);
        return loadMemberList(xnewLRLs(memberStatus), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.} #beforejava8
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    @SuppressWarnings("unchecked")
    public NestedReferrerListGateway<Member> loadMemberList(List<MemberStatus> memberStatusList, LoadReferrerOption<MemberCB, Member> loadReferrerOption) {
        xassLRArg(memberStatusList, loadReferrerOption);
        if (memberStatusList.isEmpty()) { return (NestedReferrerListGateway<Member>)EMPTY_NREF_LGWAY; }
        return doLoadMemberList(memberStatusList, loadReferrerOption);
    }

    protected NestedReferrerListGateway<Member> doLoadMemberList(List<MemberStatus> memberStatusList, LoadReferrerOption<MemberCB, Member> option) {
        final MemberBhv referrerBhv = xgetBSFLR().select(MemberBhv.class);
        return helpLoadReferrerInternally(memberStatusList, option, new InternalLoadReferrerCallback<MemberStatus, String, MemberCB, Member>() {
            public String getPKVal(MemberStatus et)
            { return et.getMemberStatusCode(); }
            public void setRfLs(MemberStatus et, List<Member> ls)
            { et.setMemberList(ls); }
            public MemberCB newMyCB() { return referrerBhv.newConditionBean(); }
            public void qyFKIn(MemberCB cb, List<String> ls)
            { cb.query().setMemberStatusCode_InScope(ls); }
            public void qyOdFKAsc(MemberCB cb) { cb.query().addOrderBy_MemberStatusCode_Asc(); }
            public void spFKCol(MemberCB cb) { cb.specify().columnMemberStatusCode(); }
            public List<Member> selRfLs(MemberCB cb) { return referrerBhv.selectList(cb); }
            public String getFKVal(Member re) { return re.getMemberStatusCode(); }
            public void setlcEt(Member re, MemberStatus le)
            { re.setMemberStatus(le); }
            public String getRfPrNm() { return "memberList"; }
        });
    }

    /**
     * Load referrer of memberLoginList by the set-upper of referrer. <br />
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginList'.
     * <pre>
     * memberStatusBhv.<span style="color: #DD4747">loadMemberLoginList</span>(memberStatusList, new ConditionBeanSetupper&lt;MemberLoginCB&gt;() {
     *     public void setup(MemberLoginCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * for (MemberStatus memberStatus : memberStatusList) {
     *     ... = memberStatus.<span style="color: #DD4747">getMemberLoginList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setLoginMemberStatusCode_InScope(pkList);
     * cb.query().addOrderBy_LoginMemberStatusCode_Asc();
     * </pre>
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<MemberLogin> loadMemberLoginList(List<MemberStatus> memberStatusList, ConditionBeanSetupper<MemberLoginCB> setupper) {
        xassLRArg(memberStatusList, setupper);
        return doLoadMemberLoginList(memberStatusList, new LoadReferrerOption<MemberLoginCB, MemberLogin>().xinit(setupper));
    }

    /**
     * Load referrer of memberLoginList by the set-upper of referrer. <br />
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginList'.
     * <pre>
     * memberStatusBhv.<span style="color: #DD4747">loadMemberLoginList</span>(memberStatusList, new ConditionBeanSetupper&lt;MemberLoginCB&gt;() {
     *     public void setup(MemberLoginCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = memberStatus.<span style="color: #DD4747">getMemberLoginList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setLoginMemberStatusCode_InScope(pkList);
     * cb.query().addOrderBy_LoginMemberStatusCode_Asc();
     * </pre>
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<MemberLogin> loadMemberLoginList(MemberStatus memberStatus, ConditionBeanSetupper<MemberLoginCB> setupper) {
        xassLRArg(memberStatus, setupper);
        return doLoadMemberLoginList(xnewLRLs(memberStatus), new LoadReferrerOption<MemberLoginCB, MemberLogin>().xinit(setupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.} #beforejava8
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerListGateway<MemberLogin> loadMemberLoginList(MemberStatus memberStatus, LoadReferrerOption<MemberLoginCB, MemberLogin> loadReferrerOption) {
        xassLRArg(memberStatus, loadReferrerOption);
        return loadMemberLoginList(xnewLRLs(memberStatus), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.} #beforejava8
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    @SuppressWarnings("unchecked")
    public NestedReferrerListGateway<MemberLogin> loadMemberLoginList(List<MemberStatus> memberStatusList, LoadReferrerOption<MemberLoginCB, MemberLogin> loadReferrerOption) {
        xassLRArg(memberStatusList, loadReferrerOption);
        if (memberStatusList.isEmpty()) { return (NestedReferrerListGateway<MemberLogin>)EMPTY_NREF_LGWAY; }
        return doLoadMemberLoginList(memberStatusList, loadReferrerOption);
    }

    protected NestedReferrerListGateway<MemberLogin> doLoadMemberLoginList(List<MemberStatus> memberStatusList, LoadReferrerOption<MemberLoginCB, MemberLogin> option) {
        final MemberLoginBhv referrerBhv = xgetBSFLR().select(MemberLoginBhv.class);
        return helpLoadReferrerInternally(memberStatusList, option, new InternalLoadReferrerCallback<MemberStatus, String, MemberLoginCB, MemberLogin>() {
            public String getPKVal(MemberStatus et)
            { return et.getMemberStatusCode(); }
            public void setRfLs(MemberStatus et, List<MemberLogin> ls)
            { et.setMemberLoginList(ls); }
            public MemberLoginCB newMyCB() { return referrerBhv.newConditionBean(); }
            public void qyFKIn(MemberLoginCB cb, List<String> ls)
            { cb.query().setLoginMemberStatusCode_InScope(ls); }
            public void qyOdFKAsc(MemberLoginCB cb) { cb.query().addOrderBy_LoginMemberStatusCode_Asc(); }
            public void spFKCol(MemberLoginCB cb) { cb.specify().columnLoginMemberStatusCode(); }
            public List<MemberLogin> selRfLs(MemberLoginCB cb) { return referrerBhv.selectList(cb); }
            public String getFKVal(MemberLogin re) { return re.getLoginMemberStatusCode(); }
            public void setlcEt(MemberLogin re, MemberStatus le)
            { re.setMemberStatus(le); }
            public String getRfPrNm() { return "memberLoginList"; }
        });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberStatusCode.
     * @param memberStatusList The list of memberStatus. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractMemberStatusCodeList(List<MemberStatus> memberStatusList) {
        return helpExtractListInternally(memberStatusList, new InternalExtractCallback<MemberStatus, String>() {
            public String getCV(MemberStatus et) { return et.getMemberStatusCode(); }
        });
    }

    /**
     * Extract the value list of (single) unique key displayOrder.
     * @param memberStatusList The list of memberStatus. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractDisplayOrderList(List<MemberStatus> memberStatusList) {
        return helpExtractListInternally(memberStatusList, new InternalExtractCallback<MemberStatus, Integer>() {
            public Integer getCV(MemberStatus et) { return et.getDisplayOrder(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * MemberStatus memberStatus = new MemberStatus();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberStatus.setFoo...(value);
     * memberStatus.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberStatus.set...;</span>
     * memberStatusBhv.<span style="color: #DD4747">insert</span>(memberStatus);
     * ... = memberStatus.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberStatus The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberStatus memberStatus) {
        doInsert(memberStatus, null);
    }

    protected void doInsert(MemberStatus et, InsertOption<MemberStatusCB> op) {
        assertObjectNotNull("memberStatus", et);
        prepareInsertOption(op);
        delegateInsert(et, op);
    }

    protected void prepareInsertOption(InsertOption<MemberStatusCB> op) {
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
     * MemberStatus memberStatus = new MemberStatus();
     * memberStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberStatus.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberStatus.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     memberStatusBhv.<span style="color: #DD4747">update</span>(memberStatus);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberStatus The entity of update. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(MemberStatus memberStatus) {
        doUpdate(memberStatus, null);
    }

    protected void doUpdate(MemberStatus et, final UpdateOption<MemberStatusCB> op) {
        assertObjectNotNull("memberStatus", et);
        prepareUpdateOption(op);
        helpUpdateInternally(et, new InternalUpdateCallback<MemberStatus>() {
            public int callbackDelegateUpdate(MemberStatus let) { return delegateUpdate(let, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberStatusCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) { op.resolveSelfSpecification(createCBForVaryingUpdate()); }
        if (op.hasSpecifiedUpdateColumn()) { op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected MemberStatusCB createCBForVaryingUpdate()
    { MemberStatusCB cb = newConditionBean(); cb.xsetupForVaryingUpdate(); return cb; }

    protected MemberStatusCB createCBForSpecifiedUpdate()
    { MemberStatusCB cb = newConditionBean(); cb.xsetupForSpecifiedUpdate(); return cb; }

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
     * @param memberStatus The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberStatus memberStatus) {
        doInsertOrUpdate(memberStatus, null, null);
    }

    protected void doInsertOrUpdate(MemberStatus et, final InsertOption<MemberStatusCB> iop, final UpdateOption<MemberStatusCB> uop) {
        assertObjectNotNull("memberStatus", et);
        helpInsertOrUpdateInternally(et, new InternalInsertOrUpdateCallback<MemberStatus, MemberStatusCB>() {
            public void callbackInsert(MemberStatus let) { doInsert(let, iop); }
            public void callbackUpdate(MemberStatus let) { doUpdate(let, uop); }
            public MemberStatusCB callbackNewMyConditionBean() { return newConditionBean(); }
            public int callbackSelectCount(MemberStatusCB cb) { return selectCount(cb); }
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
     * MemberStatus memberStatus = new MemberStatus();
     * memberStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     memberStatusBhv.<span style="color: #DD4747">delete</span>(memberStatus);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberStatus The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberStatus memberStatus) {
        doDelete(memberStatus, null);
    }

    protected void doDelete(MemberStatus et, final DeleteOption<MemberStatusCB> op) {
        assertObjectNotNull("memberStatus", et);
        prepareDeleteOption(op);
        helpDeleteInternally(et, new InternalDeleteCallback<MemberStatus>() {
            public int callbackDelegateDelete(MemberStatus let) { return delegateDelete(let, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberStatusCB> op)
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
     *     MemberStatus memberStatus = new MemberStatus();
     *     memberStatus.setFooName("foo");
     *     if (...) {
     *         memberStatus.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberStatusList.add(memberStatus);
     * }
     * memberStatusBhv.<span style="color: #DD4747">batchInsert</span>(memberStatusList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberStatus> memberStatusList) {
        return doBatchInsert(memberStatusList, null);
    }

    protected int[] doBatchInsert(List<MemberStatus> ls, InsertOption<MemberStatusCB> op) {
        assertObjectNotNull("memberStatusList", ls);
        InsertOption<MemberStatusCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainInsertOption(); }
        prepareBatchInsertOption(ls, rlop); // required
        return delegateBatchInsert(ls, rlop);
    }

    protected void prepareBatchInsertOption(List<MemberStatus> ls, InsertOption<MemberStatusCB> op) {
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
     *     MemberStatus memberStatus = new MemberStatus();
     *     memberStatus.setFooName("foo");
     *     if (...) {
     *         memberStatus.setFooPrice(123);
     *     } else {
     *         memberStatus.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberStatus.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberStatusList.add(memberStatus);
     * }
     * memberStatusBhv.<span style="color: #DD4747">batchUpdate</span>(memberStatusList);
     * </pre>
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberStatus> memberStatusList) {
        return doBatchUpdate(memberStatusList, null);
    }

    protected int[] doBatchUpdate(List<MemberStatus> ls, UpdateOption<MemberStatusCB> op) {
        assertObjectNotNull("memberStatusList", ls);
        UpdateOption<MemberStatusCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop); // required
        return delegateBatchUpdate(ls, rlop);
    }

    protected void prepareBatchUpdateOption(List<MemberStatus> ls, UpdateOption<MemberStatusCB> op) {
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
     * memberStatusBhv.<span style="color: #DD4747">batchUpdate</span>(memberStatusList, new SpecifyQuery<MemberStatusCB>() {
     *     public void specify(MemberStatusCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * memberStatusBhv.<span style="color: #DD4747">batchUpdate</span>(memberStatusList, new SpecifyQuery<MemberStatusCB>() {
     *     public void specify(MemberStatusCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberStatus> memberStatusList, SpecifyQuery<MemberStatusCB> updateColumnSpec) {
        return doBatchUpdate(memberStatusList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<MemberStatus> memberStatusList) {
        return doBatchDelete(memberStatusList, null);
    }

    protected int[] doBatchDelete(List<MemberStatus> ls, DeleteOption<MemberStatusCB> op) {
        assertObjectNotNull("memberStatusList", ls);
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
     * memberStatusBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberStatus, MemberStatusCB&gt;() {
     *     public ConditionBean setup(memberStatus entity, MemberStatusCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<MemberStatus, MemberStatusCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberStatus, MemberStatusCB> sp, InsertOption<MemberStatusCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        MemberStatus et = newEntity();
        MemberStatusCB cb = createCBForQueryInsert();
        return delegateQueryInsert(et, cb, sp.setup(et, cb), op);
    }

    protected MemberStatusCB createCBForQueryInsert()
    { MemberStatusCB cb = newConditionBean(); cb.xsetupForQueryInsert(); return cb; }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> op) {
        return doQueryInsert(downcast(setupper), downcast(op));
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * MemberStatus memberStatus = new MemberStatus();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberStatus.setPK...(value);</span>
     * memberStatus.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberStatus.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberStatus.setVersionNo(value);</span>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * memberStatusBhv.<span style="color: #DD4747">queryUpdate</span>(memberStatus, cb);
     * </pre>
     * @param memberStatus The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberStatus memberStatus, MemberStatusCB cb) {
        return doQueryUpdate(memberStatus, cb, null);
    }

    protected int doQueryUpdate(MemberStatus et, MemberStatusCB cb, UpdateOption<MemberStatusCB> op) {
        assertObjectNotNull("memberStatus", et); assertCBStateValid(cb);
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
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * memberStatusBhv.<span style="color: #DD4747">queryDelete</span>(memberStatus, cb);
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberStatusCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberStatusCB cb, DeleteOption<MemberStatusCB> op) {
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
     * MemberStatus memberStatus = new MemberStatus();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberStatus.setFoo...(value);
     * memberStatus.setBar...(value);
     * InsertOption<MemberStatusCB> option = new InsertOption<MemberStatusCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberStatusBhv.<span style="color: #DD4747">varyingInsert</span>(memberStatus, option);
     * ... = memberStatus.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberStatus The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(MemberStatus memberStatus, InsertOption<MemberStatusCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(memberStatus, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * MemberStatus memberStatus = new MemberStatus();
     * memberStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberStatus.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberStatusCB&gt; option = new UpdateOption&lt;MemberStatusCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberStatusCB&gt;() {
     *         public void specify(MemberStatusCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberStatusBhv.<span style="color: #DD4747">varyingUpdate</span>(memberStatus, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberStatus The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(MemberStatus memberStatus, UpdateOption<MemberStatusCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(memberStatus, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberStatus The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberStatus memberStatus, InsertOption<MemberStatusCB> insertOption, UpdateOption<MemberStatusCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdate(memberStatus, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberStatus The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberStatus memberStatus, DeleteOption<MemberStatusCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberStatus, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<MemberStatus> memberStatusList, InsertOption<MemberStatusCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberStatusList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<MemberStatus> memberStatusList, UpdateOption<MemberStatusCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberStatusList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<MemberStatus> memberStatusList, DeleteOption<MemberStatusCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberStatusList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<MemberStatus, MemberStatusCB> setupper, InsertOption<MemberStatusCB> option) {
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
     * MemberStatus memberStatus = new MemberStatus();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberStatus.setPK...(value);</span>
     * memberStatus.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberStatus.setVersionNo(value);</span>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberStatusCB&gt; option = new UpdateOption&lt;MemberStatusCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberStatusCB&gt;() {
     *     public void specify(MemberStatusCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberStatusBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(memberStatus, cb, option);
     * </pre>
     * @param memberStatus The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(MemberStatus memberStatus, MemberStatusCB cb, UpdateOption<MemberStatusCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(memberStatus, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberStatusCB cb, DeleteOption<MemberStatusCB> option) {
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
    public OutsideSqlBasicExecutor<MemberStatusBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(MemberStatusCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(MemberStatusCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends MemberStatus> void delegateSelectCursor(MemberStatusCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends MemberStatus> List<ENTITY> delegateSelectList(MemberStatusCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(MemberStatus et, InsertOption<MemberStatusCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(MemberStatus et, UpdateOption<MemberStatusCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(MemberStatus et, UpdateOption<MemberStatusCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(MemberStatus et, DeleteOption<MemberStatusCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(MemberStatus et, DeleteOption<MemberStatusCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<MemberStatus> ls, InsertOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<MemberStatus> ls, UpdateOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<MemberStatus> ls, UpdateOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<MemberStatus> ls, DeleteOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<MemberStatus> ls, DeleteOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(MemberStatus et, MemberStatusCB inCB, ConditionBean resCB, InsertOption<MemberStatusCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(MemberStatus et, MemberStatusCB cb, UpdateOption<MemberStatusCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(MemberStatusCB cb, DeleteOption<MemberStatusCB> op)
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
    protected Class<MemberStatus> typeOfSelectedEntity()
    { return MemberStatus.class; }

    protected MemberStatus downcast(Entity et)
    { return helpEntityDowncastInternally(et, MemberStatus.class); }

    protected MemberStatusCB downcast(ConditionBean cb)
    { return helpConditionBeanDowncastInternally(cb, MemberStatusCB.class); }

    @SuppressWarnings("unchecked")
    protected List<MemberStatus> downcast(List<? extends Entity> ls)
    { return (List<MemberStatus>)ls; }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberStatusCB> downcast(InsertOption<? extends ConditionBean> op)
    { return (InsertOption<MemberStatusCB>)op; }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberStatusCB> downcast(UpdateOption<? extends ConditionBean> op)
    { return (UpdateOption<MemberStatusCB>)op; }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberStatusCB> downcast(DeleteOption<? extends ConditionBean> op)
    { return (DeleteOption<MemberStatusCB>)op; }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberStatus, MemberStatusCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp)
    { return (QueryInsertSetupper<MemberStatus, MemberStatusCB>)sp; }
}
