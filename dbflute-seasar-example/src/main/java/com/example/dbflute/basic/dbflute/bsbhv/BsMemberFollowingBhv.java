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
import com.example.dbflute.basic.dbflute.exbhv.*;
import com.example.dbflute.basic.dbflute.bsbhv.loader.*;
import com.example.dbflute.basic.dbflute.exentity.*;
import com.example.dbflute.basic.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.basic.dbflute.cbean.*;

/**
 * The behavior of (会員フォローイング)MEMBER_FOLLOWING as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_FOLLOWING_ID
 *
 * [column]
 *     MEMBER_FOLLOWING_ID, MY_MEMBER_ID, YOUR_MEMBER_ID, FOLLOW_DATETIME
 *
 * [sequence]
 *     
 *
 * [identity]
 *     MEMBER_FOLLOWING_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     MEMBER
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     memberByMyMemberId, memberByYourMemberId
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberFollowingBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "MEMBER_FOLLOWING"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** {@inheritDoc} */
    public DBMeta getDBMeta() { return MemberFollowingDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberFollowingDbm getMyDBMeta() { return MemberFollowingDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public MemberFollowing newEntity() { return new MemberFollowing(); }

    /** {@inheritDoc} */
    public MemberFollowingCB newConditionBean() { return new MemberFollowingCB(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public MemberFollowing newMyEntity() { return new MemberFollowing(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberFollowingCB newMyConditionBean() { return new MemberFollowingCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * int count = memberFollowingBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberFollowingCB cb) {
        return facadeSelectCount(cb);
    }

    protected int facadeSelectCount(MemberFollowingCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberFollowingCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberFollowingCB cb) { // called by selectPage(cb)
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
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * MemberFollowing memberFollowing = memberFollowingBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (memberFollowing != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = memberFollowing.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberFollowing selectEntity(MemberFollowingCB cb) {
        return facadeSelectEntity(cb);
    }

    protected MemberFollowing facadeSelectEntity(MemberFollowingCB cb) {
        return doSelectEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberFollowing> ENTITY doSelectEntity(MemberFollowingCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, MemberFollowingCB>() {
            public List<ENTITY> callbackSelectList(MemberFollowingCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends MemberFollowing> OptionalEntity<ENTITY> doSelectOptionalEntity(MemberFollowingCB cb, Class<ENTITY> tp) {
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
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * MemberFollowing memberFollowing = memberFollowingBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberFollowing.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberFollowing selectEntityWithDeletedCheck(MemberFollowingCB cb) {
        return facadeSelectEntityWithDeletedCheck(cb);
    }

    protected MemberFollowing facadeSelectEntityWithDeletedCheck(MemberFollowingCB cb) {
        return doSelectEntityWithDeletedCheck(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberFollowing> ENTITY doSelectEntityWithDeletedCheck(MemberFollowingCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberFollowingCB>() {
            public List<ENTITY> callbackSelectList(MemberFollowingCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return facadeSelectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param memberFollowingId (会員フォローイングID): PK, ID, NotNull, BIGINT(19). (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberFollowing selectByPKValue(Long memberFollowingId) {
        return facadeSelectByPKValue(memberFollowingId);
    }

    protected MemberFollowing facadeSelectByPKValue(Long memberFollowingId) {
        return doSelectByPK(memberFollowingId, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberFollowing> ENTITY doSelectByPK(Long memberFollowingId, Class<ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(memberFollowingId), tp);
    }

    protected <ENTITY extends MemberFollowing> OptionalEntity<ENTITY> doSelectOptionalByPK(Long memberFollowingId, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(memberFollowingId, tp), memberFollowingId);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param memberFollowingId (会員フォローイングID): PK, ID, NotNull, BIGINT(19). (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberFollowing selectByPKValueWithDeletedCheck(Long memberFollowingId) {
        return doSelectByPKWithDeletedCheck(memberFollowingId, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberFollowing> ENTITY doSelectByPKWithDeletedCheck(Long memberFollowingId, Class<ENTITY> tp) {
        return doSelectEntityWithDeletedCheck(xprepareCBAsPK(memberFollowingId), tp);
    }

    protected MemberFollowingCB xprepareCBAsPK(Long memberFollowingId) {
        assertObjectNotNull("memberFollowingId", memberFollowingId);
        return newConditionBean().acceptPK(memberFollowingId);
    }

    /**
     * Select the entity by the unique-key value.
     * @param myMemberId (わたし): UQ+, IX+, NotNull, INTEGER(10), FK to MEMBER. (NotNull)
     * @param yourMemberId (あなた): +UQ, IX+, NotNull, INTEGER(10), FK to MEMBER. (NotNull)
     * @return The optional entity selected by the unique key. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<MemberFollowing> selectByUniqueOf(Integer myMemberId, Integer yourMemberId) {
        return facadeSelectByUniqueOf(myMemberId, yourMemberId);
    }

    protected OptionalEntity<MemberFollowing> facadeSelectByUniqueOf(Integer myMemberId, Integer yourMemberId) {
        return doSelectByUniqueOf(myMemberId, yourMemberId, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberFollowing> OptionalEntity<ENTITY> doSelectByUniqueOf(Integer myMemberId, Integer yourMemberId, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(xprepareCBAsUniqueOf(myMemberId, yourMemberId), tp), myMemberId, yourMemberId);
    }

    protected MemberFollowingCB xprepareCBAsUniqueOf(Integer myMemberId, Integer yourMemberId) {
        assertObjectNotNull("myMemberId", myMemberId);assertObjectNotNull("yourMemberId", yourMemberId);
        return newConditionBean().acceptUniqueOf(myMemberId, yourMemberId);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;MemberFollowing&gt; memberFollowingList = memberFollowingBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (MemberFollowing memberFollowing : memberFollowingList) {
     *     ... = memberFollowing.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberFollowing> selectList(MemberFollowingCB cb) {
        return facadeSelectList(cb);
    }

    protected ListResultBean<MemberFollowing> facadeSelectList(MemberFollowingCB cb) {
        return doSelectList(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberFollowing> ListResultBean<ENTITY> doSelectList(MemberFollowingCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, MemberFollowingCB>() {
            public List<ENTITY> callbackSelectList(MemberFollowingCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberFollowing&gt; page = memberFollowingBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (MemberFollowing memberFollowing : page) {
     *     ... = memberFollowing.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberFollowing> selectPage(MemberFollowingCB cb) {
        return facadeSelectPage(cb);
    }

    protected PagingResultBean<MemberFollowing> facadeSelectPage(MemberFollowingCB cb) {
        return doSelectPage(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberFollowing> PagingResultBean<ENTITY> doSelectPage(MemberFollowingCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, MemberFollowingCB>() {
            public int callbackSelectCount(MemberFollowingCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberFollowingCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * memberFollowingBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberFollowing&gt;() {
     *     public void handle(MemberFollowing entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberFollowing. (NotNull)
     */
    public void selectCursor(MemberFollowingCB cb, EntityRowHandler<MemberFollowing> entityRowHandler) {
        facadeSelectCursor(cb, entityRowHandler);
    }

    protected void facadeSelectCursor(MemberFollowingCB cb, EntityRowHandler<MemberFollowing> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberFollowing> void doSelectCursor(MemberFollowingCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, MemberFollowingCB>() {
            public void callbackSelectCursor(MemberFollowingCB lcb, EntityRowHandler<ENTITY> lhandler, Class<ENTITY> ltp) { delegateSelectCursor(lcb, lhandler, ltp); }
            public List<ENTITY> callbackSelectList(MemberFollowingCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberFollowingBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberFollowingCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<MemberFollowingCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return facadeScalarSelect(resultType);
    }

    protected <RESULT> HpSLSFunction<MemberFollowingCB, RESULT> facadeScalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newConditionBean());
    }

    protected <RESULT, CB extends MemberFollowingCB> HpSLSFunction<CB, RESULT> doScalarSelect(final Class<RESULT> tp, final CB cb) {
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
     * @param memberFollowingList The entity list of memberFollowing. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<MemberFollowing> memberFollowingList, ReferrerLoaderHandler<LoaderOfMemberFollowing> handler) {
        xassLRArg(memberFollowingList, handler);
        handler.handle(new LoaderOfMemberFollowing().ready(memberFollowingList, _behaviorSelector));
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
     * @param memberFollowing The entity of memberFollowing. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(MemberFollowing memberFollowing, ReferrerLoaderHandler<LoaderOfMemberFollowing> handler) {
        xassLRArg(memberFollowing, handler);
        handler.handle(new LoaderOfMemberFollowing().ready(xnewLRAryLs(memberFollowing), _behaviorSelector));
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Member'.
     * @param memberFollowingList The list of memberFollowing. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMemberByMyMemberId(List<MemberFollowing> memberFollowingList) {
        return helpPulloutInternally(memberFollowingList, new InternalPulloutCallback<MemberFollowing, Member>() {
            public Member getFr(MemberFollowing et)
            { return et.getMemberByMyMemberId(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member et, List<MemberFollowing> ls)
            { et.setMemberFollowingByMyMemberIdList(ls); }
        });
    }

    /**
     * Pull out the list of foreign table 'Member'.
     * @param memberFollowingList The list of memberFollowing. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMemberByYourMemberId(List<MemberFollowing> memberFollowingList) {
        return helpPulloutInternally(memberFollowingList, new InternalPulloutCallback<MemberFollowing, Member>() {
            public Member getFr(MemberFollowing et)
            { return et.getMemberByYourMemberId(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member et, List<MemberFollowing> ls)
            { et.setMemberFollowingByYourMemberIdList(ls); }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberFollowingId.
     * @param memberFollowingList The list of memberFollowing. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractMemberFollowingIdList(List<MemberFollowing> memberFollowingList) {
        return helpExtractListInternally(memberFollowingList, new InternalExtractCallback<MemberFollowing, Long>() {
            public Long getCV(MemberFollowing et) { return et.getMemberFollowingId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * MemberFollowing memberFollowing = new MemberFollowing();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberFollowing.setFoo...(value);
     * memberFollowing.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberFollowing.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberFollowing.set...;</span>
     * memberFollowingBhv.<span style="color: #DD4747">insert</span>(memberFollowing);
     * ... = memberFollowing.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberFollowing The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberFollowing memberFollowing) {
        doInsert(memberFollowing, null);
    }

    protected void doInsert(MemberFollowing et, InsertOption<MemberFollowingCB> op) {
        assertObjectNotNull("memberFollowing", et);
        prepareInsertOption(op);
        delegateInsert(et, op);
    }

    protected void prepareInsertOption(InsertOption<MemberFollowingCB> op) {
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
     * MemberFollowing memberFollowing = new MemberFollowing();
     * memberFollowing.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberFollowing.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberFollowing.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberFollowing.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberFollowing.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     memberFollowingBhv.<span style="color: #DD4747">update</span>(memberFollowing);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberFollowing The entity of update. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(MemberFollowing memberFollowing) {
        doUpdate(memberFollowing, null);
    }

    protected void doUpdate(MemberFollowing et, final UpdateOption<MemberFollowingCB> op) {
        assertObjectNotNull("memberFollowing", et);
        prepareUpdateOption(op);
        helpUpdateInternally(et, new InternalUpdateCallback<MemberFollowing>() {
            public int callbackDelegateUpdate(MemberFollowing let) { return delegateUpdate(let, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberFollowingCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) { op.resolveSelfSpecification(createCBForVaryingUpdate()); }
        if (op.hasSpecifiedUpdateColumn()) { op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected MemberFollowingCB createCBForVaryingUpdate()
    { MemberFollowingCB cb = newConditionBean(); cb.xsetupForVaryingUpdate(); return cb; }

    protected MemberFollowingCB createCBForSpecifiedUpdate()
    { MemberFollowingCB cb = newConditionBean(); cb.xsetupForSpecifiedUpdate(); return cb; }

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
     * @param memberFollowing The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberFollowing memberFollowing) {
        doInsertOrUpdate(memberFollowing, null, null);
    }

    protected void doInsertOrUpdate(MemberFollowing et, final InsertOption<MemberFollowingCB> iop, final UpdateOption<MemberFollowingCB> uop) {
        assertObjectNotNull("memberFollowing", et);
        helpInsertOrUpdateInternally(et, new InternalInsertOrUpdateCallback<MemberFollowing, MemberFollowingCB>() {
            public void callbackInsert(MemberFollowing let) { doInsert(let, iop); }
            public void callbackUpdate(MemberFollowing let) { doUpdate(let, uop); }
            public MemberFollowingCB callbackNewMyConditionBean() { return newConditionBean(); }
            public int callbackSelectCount(MemberFollowingCB cb) { return selectCount(cb); }
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
     * MemberFollowing memberFollowing = new MemberFollowing();
     * memberFollowing.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberFollowing.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     memberFollowingBhv.<span style="color: #DD4747">delete</span>(memberFollowing);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberFollowing The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberFollowing memberFollowing) {
        doDelete(memberFollowing, null);
    }

    protected void doDelete(MemberFollowing et, final DeleteOption<MemberFollowingCB> op) {
        assertObjectNotNull("memberFollowing", et);
        prepareDeleteOption(op);
        helpDeleteInternally(et, new InternalDeleteCallback<MemberFollowing>() {
            public int callbackDelegateDelete(MemberFollowing let) { return delegateDelete(let, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberFollowingCB> op)
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
     *     MemberFollowing memberFollowing = new MemberFollowing();
     *     memberFollowing.setFooName("foo");
     *     if (...) {
     *         memberFollowing.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberFollowingList.add(memberFollowing);
     * }
     * memberFollowingBhv.<span style="color: #DD4747">batchInsert</span>(memberFollowingList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberFollowingList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberFollowing> memberFollowingList) {
        return doBatchInsert(memberFollowingList, null);
    }

    protected int[] doBatchInsert(List<MemberFollowing> ls, InsertOption<MemberFollowingCB> op) {
        assertObjectNotNull("memberFollowingList", ls);
        InsertOption<MemberFollowingCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainInsertOption(); }
        prepareBatchInsertOption(ls, rlop); // required
        return delegateBatchInsert(ls, rlop);
    }

    protected void prepareBatchInsertOption(List<MemberFollowing> ls, InsertOption<MemberFollowingCB> op) {
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
     *     MemberFollowing memberFollowing = new MemberFollowing();
     *     memberFollowing.setFooName("foo");
     *     if (...) {
     *         memberFollowing.setFooPrice(123);
     *     } else {
     *         memberFollowing.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberFollowing.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberFollowingList.add(memberFollowing);
     * }
     * memberFollowingBhv.<span style="color: #DD4747">batchUpdate</span>(memberFollowingList);
     * </pre>
     * @param memberFollowingList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberFollowing> memberFollowingList) {
        return doBatchUpdate(memberFollowingList, null);
    }

    protected int[] doBatchUpdate(List<MemberFollowing> ls, UpdateOption<MemberFollowingCB> op) {
        assertObjectNotNull("memberFollowingList", ls);
        UpdateOption<MemberFollowingCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop); // required
        return delegateBatchUpdate(ls, rlop);
    }

    protected void prepareBatchUpdateOption(List<MemberFollowing> ls, UpdateOption<MemberFollowingCB> op) {
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
     * memberFollowingBhv.<span style="color: #DD4747">batchUpdate</span>(memberFollowingList, new SpecifyQuery<MemberFollowingCB>() {
     *     public void specify(MemberFollowingCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * memberFollowingBhv.<span style="color: #DD4747">batchUpdate</span>(memberFollowingList, new SpecifyQuery<MemberFollowingCB>() {
     *     public void specify(MemberFollowingCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberFollowingList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberFollowing> memberFollowingList, SpecifyQuery<MemberFollowingCB> updateColumnSpec) {
        return doBatchUpdate(memberFollowingList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberFollowingList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<MemberFollowing> memberFollowingList) {
        return doBatchDelete(memberFollowingList, null);
    }

    protected int[] doBatchDelete(List<MemberFollowing> ls, DeleteOption<MemberFollowingCB> op) {
        assertObjectNotNull("memberFollowingList", ls);
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
     * memberFollowingBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberFollowing, MemberFollowingCB&gt;() {
     *     public ConditionBean setup(memberFollowing entity, MemberFollowingCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<MemberFollowing, MemberFollowingCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberFollowing, MemberFollowingCB> sp, InsertOption<MemberFollowingCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        MemberFollowing et = newEntity();
        MemberFollowingCB cb = createCBForQueryInsert();
        return delegateQueryInsert(et, cb, sp.setup(et, cb), op);
    }

    protected MemberFollowingCB createCBForQueryInsert()
    { MemberFollowingCB cb = newConditionBean(); cb.xsetupForQueryInsert(); return cb; }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> op) {
        return doQueryInsert(downcast(setupper), downcast(op));
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * MemberFollowing memberFollowing = new MemberFollowing();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberFollowing.setPK...(value);</span>
     * memberFollowing.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberFollowing.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberFollowing.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberFollowing.setVersionNo(value);</span>
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * memberFollowingBhv.<span style="color: #DD4747">queryUpdate</span>(memberFollowing, cb);
     * </pre>
     * @param memberFollowing The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberFollowing memberFollowing, MemberFollowingCB cb) {
        return doQueryUpdate(memberFollowing, cb, null);
    }

    protected int doQueryUpdate(MemberFollowing et, MemberFollowingCB cb, UpdateOption<MemberFollowingCB> op) {
        assertObjectNotNull("memberFollowing", et); assertCBStateValid(cb);
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
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * memberFollowingBhv.<span style="color: #DD4747">queryDelete</span>(memberFollowing, cb);
     * </pre>
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberFollowingCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberFollowingCB cb, DeleteOption<MemberFollowingCB> op) {
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
     * MemberFollowing memberFollowing = new MemberFollowing();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberFollowing.setFoo...(value);
     * memberFollowing.setBar...(value);
     * InsertOption<MemberFollowingCB> option = new InsertOption<MemberFollowingCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberFollowingBhv.<span style="color: #DD4747">varyingInsert</span>(memberFollowing, option);
     * ... = memberFollowing.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberFollowing The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(MemberFollowing memberFollowing, InsertOption<MemberFollowingCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(memberFollowing, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * MemberFollowing memberFollowing = new MemberFollowing();
     * memberFollowing.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberFollowing.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberFollowing.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberFollowingCB&gt; option = new UpdateOption&lt;MemberFollowingCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberFollowingCB&gt;() {
     *         public void specify(MemberFollowingCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberFollowingBhv.<span style="color: #DD4747">varyingUpdate</span>(memberFollowing, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberFollowing The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(MemberFollowing memberFollowing, UpdateOption<MemberFollowingCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(memberFollowing, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberFollowing The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberFollowing memberFollowing, InsertOption<MemberFollowingCB> insertOption, UpdateOption<MemberFollowingCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdate(memberFollowing, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberFollowing The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberFollowing memberFollowing, DeleteOption<MemberFollowingCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberFollowing, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberFollowingList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<MemberFollowing> memberFollowingList, InsertOption<MemberFollowingCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberFollowingList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberFollowingList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<MemberFollowing> memberFollowingList, UpdateOption<MemberFollowingCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberFollowingList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberFollowingList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<MemberFollowing> memberFollowingList, DeleteOption<MemberFollowingCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberFollowingList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<MemberFollowing, MemberFollowingCB> setupper, InsertOption<MemberFollowingCB> option) {
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
     * MemberFollowing memberFollowing = new MemberFollowing();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberFollowing.setPK...(value);</span>
     * memberFollowing.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberFollowing.setVersionNo(value);</span>
     * MemberFollowingCB cb = new MemberFollowingCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberFollowingCB&gt; option = new UpdateOption&lt;MemberFollowingCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberFollowingCB&gt;() {
     *     public void specify(MemberFollowingCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberFollowingBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(memberFollowing, cb, option);
     * </pre>
     * @param memberFollowing The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(MemberFollowing memberFollowing, MemberFollowingCB cb, UpdateOption<MemberFollowingCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(memberFollowing, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of MemberFollowing. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberFollowingCB cb, DeleteOption<MemberFollowingCB> option) {
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
    public OutsideSqlBasicExecutor<MemberFollowingBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(MemberFollowingCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(MemberFollowingCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends MemberFollowing> void delegateSelectCursor(MemberFollowingCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends MemberFollowing> List<ENTITY> delegateSelectList(MemberFollowingCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(MemberFollowing et, InsertOption<MemberFollowingCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(MemberFollowing et, UpdateOption<MemberFollowingCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(MemberFollowing et, UpdateOption<MemberFollowingCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(MemberFollowing et, DeleteOption<MemberFollowingCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(MemberFollowing et, DeleteOption<MemberFollowingCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<MemberFollowing> ls, InsertOption<MemberFollowingCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<MemberFollowing> ls, UpdateOption<MemberFollowingCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<MemberFollowing> ls, UpdateOption<MemberFollowingCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<MemberFollowing> ls, DeleteOption<MemberFollowingCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<MemberFollowing> ls, DeleteOption<MemberFollowingCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(MemberFollowing et, MemberFollowingCB inCB, ConditionBean resCB, InsertOption<MemberFollowingCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(MemberFollowing et, MemberFollowingCB cb, UpdateOption<MemberFollowingCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(MemberFollowingCB cb, DeleteOption<MemberFollowingCB> op)
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
    protected Class<MemberFollowing> typeOfSelectedEntity()
    { return MemberFollowing.class; }

    protected MemberFollowing downcast(Entity et)
    { return helpEntityDowncastInternally(et, MemberFollowing.class); }

    protected MemberFollowingCB downcast(ConditionBean cb)
    { return helpConditionBeanDowncastInternally(cb, MemberFollowingCB.class); }

    @SuppressWarnings("unchecked")
    protected List<MemberFollowing> downcast(List<? extends Entity> ls)
    { return (List<MemberFollowing>)ls; }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberFollowingCB> downcast(InsertOption<? extends ConditionBean> op)
    { return (InsertOption<MemberFollowingCB>)op; }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberFollowingCB> downcast(UpdateOption<? extends ConditionBean> op)
    { return (UpdateOption<MemberFollowingCB>)op; }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberFollowingCB> downcast(DeleteOption<? extends ConditionBean> op)
    { return (DeleteOption<MemberFollowingCB>)op; }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberFollowing, MemberFollowingCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp)
    { return (QueryInsertSetupper<MemberFollowing, MemberFollowingCB>)sp; }
}
