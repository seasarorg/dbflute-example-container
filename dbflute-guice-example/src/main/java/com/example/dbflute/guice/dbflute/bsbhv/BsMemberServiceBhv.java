package com.example.dbflute.guice.dbflute.bsbhv;

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
import com.example.dbflute.guice.dbflute.exbhv.*;
import com.example.dbflute.guice.dbflute.bsbhv.loader.*;
import com.example.dbflute.guice.dbflute.exentity.*;
import com.example.dbflute.guice.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.guice.dbflute.cbean.*;

/**
 * The behavior of (会員サービス)MEMBER_SERVICE as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_SERVICE_ID
 *
 * [column]
 *     MEMBER_SERVICE_ID, MEMBER_ID, SERVICE_POINT_COUNT, SERVICE_RANK_CODE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     MEMBER_SERVICE_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     MEMBER, SERVICE_RANK
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     member, serviceRank
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberServiceBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "MEMBER_SERVICE"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** {@inheritDoc} */
    public DBMeta getDBMeta() { return MemberServiceDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public MemberService newEntity() { return new MemberService(); }

    /** {@inheritDoc} */
    public MemberServiceCB newConditionBean() { return new MemberServiceCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * int count = memberServiceBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberServiceCB cb) {
        return facadeSelectCount(cb);
    }

    protected int facadeSelectCount(MemberServiceCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberServiceCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberServiceCB cb) { // called by selectPage(cb)
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
     * Select the entity by the condition-bean. <br />
     * It returns not-null optional entity, so you should ... <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, get() without check.</span> <br />
     * <span style="color: #AD4747; font-size: 120%">If it might be no data, get() after check by isPresent() or orElse(), ...</span>
     * <pre>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * OptionalEntity&lt;MemberService&gt; entity = memberServiceBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     *
     * <span style="color: #3F7E5E">// if the data always exists as your business rule</span>
     * entity.<span style="color: #DD4747">required</span>(memberService -&gt; {
     *     ...
     * });
     * MemberService memberService = entity.entity.<span style="color: #DD4747">get()</span>;
     *
     * <span style="color: #3F7E5E">// if it might be no data, ifPresent(), isPresent(), ...</span>
     * entity.<span style="color: #DD4747">ifPresent</span>(memberService -&gt; {
     *     ...
     * });
     * if (entity.entity.<span style="color: #DD4747">isPresent()</span>) {
     *     MemberService memberService = entity.entity.<span style="color: #DD4747">get()</span>;
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<MemberService> selectEntity(MemberServiceCB cb) {
        return facadeSelectEntity(cb);
    }

    protected OptionalEntity<MemberService> facadeSelectEntity(MemberServiceCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberService> ENTITY doSelectEntity(MemberServiceCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, MemberServiceCB>() {
            public List<ENTITY> callbackSelectList(MemberServiceCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends MemberService> OptionalEntity<ENTITY> doSelectOptionalEntity(MemberServiceCB cb, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return facadeSelectEntity(downcast(cb)).orElseNull();
    }

    /**
     * Select the entity by the condition-bean with deleted check. <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, this method is good.</span>
     * <pre>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * MemberService memberService = memberServiceBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberService.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberService selectEntityWithDeletedCheck(MemberServiceCB cb) {
        return facadeSelectEntityWithDeletedCheck(cb);
    }

    protected MemberService facadeSelectEntityWithDeletedCheck(MemberServiceCB cb) {
        return doSelectEntityWithDeletedCheck(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberService> ENTITY doSelectEntityWithDeletedCheck(MemberServiceCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberServiceCB>() {
            public List<ENTITY> callbackSelectList(MemberServiceCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return facadeSelectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param memberServiceId (会員サービスID): PK, ID, NotNull, INTEGER(10). (NotNull)
     * @return The optional entity selected by the PK. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<MemberService> selectByPK(Integer memberServiceId) {
        return facadeSelectByPK(memberServiceId);
    }

    protected OptionalEntity<MemberService> facadeSelectByPK(Integer memberServiceId) {
        return doSelectOptionalByPK(memberServiceId, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberService> ENTITY doSelectByPK(Integer memberServiceId, Class<ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(memberServiceId), tp);
    }

    protected <ENTITY extends MemberService> OptionalEntity<ENTITY> doSelectOptionalByPK(Integer memberServiceId, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(memberServiceId, tp), memberServiceId);
    }

    protected MemberServiceCB xprepareCBAsPK(Integer memberServiceId) {
        assertObjectNotNull("memberServiceId", memberServiceId);
        return newConditionBean().acceptPK(memberServiceId);
    }

    /**
     * Select the entity by the unique-key value.
     * @param memberId (会員ID): UQ, IX, NotNull, INTEGER(10), FK to MEMBER. (NotNull)
     * @return The optional entity selected by the unique key. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<MemberService> selectByUniqueOf(Integer memberId) {
        return facadeSelectByUniqueOf(memberId);
    }

    protected OptionalEntity<MemberService> facadeSelectByUniqueOf(Integer memberId) {
        return doSelectByUniqueOf(memberId, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberService> OptionalEntity<ENTITY> doSelectByUniqueOf(Integer memberId, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(xprepareCBAsUniqueOf(memberId), tp), memberId);
    }

    protected MemberServiceCB xprepareCBAsUniqueOf(Integer memberId) {
        assertObjectNotNull("memberId", memberId);
        return newConditionBean().acceptUniqueOf(memberId);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;MemberService&gt; memberServiceList = memberServiceBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (MemberService memberService : memberServiceList) {
     *     ... = memberService.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberService> selectList(MemberServiceCB cb) {
        return facadeSelectList(cb);
    }

    protected ListResultBean<MemberService> facadeSelectList(MemberServiceCB cb) {
        return doSelectList(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberService> ListResultBean<ENTITY> doSelectList(MemberServiceCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, MemberServiceCB>() {
            public List<ENTITY> callbackSelectList(MemberServiceCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberService&gt; page = memberServiceBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (MemberService memberService : page) {
     *     ... = memberService.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberService> selectPage(MemberServiceCB cb) {
        return facadeSelectPage(cb);
    }

    protected PagingResultBean<MemberService> facadeSelectPage(MemberServiceCB cb) {
        return doSelectPage(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberService> PagingResultBean<ENTITY> doSelectPage(MemberServiceCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, MemberServiceCB>() {
            public int callbackSelectCount(MemberServiceCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberServiceCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * memberServiceBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberService&gt;() {
     *     public void handle(MemberService entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberService. (NotNull)
     */
    public void selectCursor(MemberServiceCB cb, EntityRowHandler<MemberService> entityRowHandler) {
        facadeSelectCursor(cb, entityRowHandler);
    }

    protected void facadeSelectCursor(MemberServiceCB cb, EntityRowHandler<MemberService> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberService> void doSelectCursor(MemberServiceCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, MemberServiceCB>() {
            public void callbackSelectCursor(MemberServiceCB lcb, EntityRowHandler<ENTITY> lhandler, Class<ENTITY> ltp) { delegateSelectCursor(lcb, lhandler, ltp); }
            public List<ENTITY> callbackSelectList(MemberServiceCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberServiceBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberServiceCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<MemberServiceCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return facadeScalarSelect(resultType);
    }

    protected <RESULT> HpSLSFunction<MemberServiceCB, RESULT> facadeScalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newConditionBean());
    }

    protected <RESULT, CB extends MemberServiceCB> HpSLSFunction<CB, RESULT> doScalarSelect(final Class<RESULT> tp, final CB cb) {
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
     * @param memberServiceList The entity list of memberService. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<MemberService> memberServiceList, ReferrerLoaderHandler<LoaderOfMemberService> handler) {
        xassLRArg(memberServiceList, handler);
        handler.handle(new LoaderOfMemberService().ready(memberServiceList, _behaviorSelector));
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
     * @param memberService The entity of memberService. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(MemberService memberService, ReferrerLoaderHandler<LoaderOfMemberService> handler) {
        xassLRArg(memberService, handler);
        handler.handle(new LoaderOfMemberService().ready(xnewLRAryLs(memberService), _behaviorSelector));
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Member'.
     * @param memberServiceList The list of memberService. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMember(List<MemberService> memberServiceList) {
        return helpPulloutInternally(memberServiceList, new InternalPulloutCallback<MemberService, Member>() {
            public Member getFr(MemberService et)
            { return et.getMember().orElseNull(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member et, List<MemberService> ls)
            { if (!ls.isEmpty()) { et.setMemberServiceAsOne(OptionalEntity.of(ls.get(0))); } }
        });
    }

    /**
     * Pull out the list of foreign table 'ServiceRank'.
     * @param memberServiceList The list of memberService. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<ServiceRank> pulloutServiceRank(List<MemberService> memberServiceList) {
        return helpPulloutInternally(memberServiceList, new InternalPulloutCallback<MemberService, ServiceRank>() {
            public ServiceRank getFr(MemberService et)
            { return et.getServiceRank().orElseNull(); }
            public boolean hasRf() { return true; }
            public void setRfLs(ServiceRank et, List<MemberService> ls)
            { et.setMemberServiceList(ls); }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberServiceId.
     * @param memberServiceList The list of memberService. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractMemberServiceIdList(List<MemberService> memberServiceList) {
        return helpExtractListInternally(memberServiceList, new InternalExtractCallback<MemberService, Integer>() {
            public Integer getCV(MemberService et) { return et.getMemberServiceId(); }
        });
    }

    /**
     * Extract the value list of (single) unique key memberId.
     * @param memberServiceList The list of memberService. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractMemberIdList(List<MemberService> memberServiceList) {
        return helpExtractListInternally(memberServiceList, new InternalExtractCallback<MemberService, Integer>() {
            public Integer getCV(MemberService et) { return et.getMemberId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * MemberService memberService = new MemberService();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberService.setFoo...(value);
     * memberService.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberService.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberService.set...;</span>
     * memberServiceBhv.<span style="color: #DD4747">insert</span>(memberService);
     * ... = memberService.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberService The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberService memberService) {
        doInsert(memberService, null);
    }

    protected void doInsert(MemberService et, InsertOption<MemberServiceCB> op) {
        assertObjectNotNull("memberService", et);
        prepareInsertOption(op);
        delegateInsert(et, op);
    }

    protected void prepareInsertOption(InsertOption<MemberServiceCB> op) {
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
     * Update the entity modified-only. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberService.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberService.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberService.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberService.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     memberServiceBhv.<span style="color: #DD4747">update</span>(memberService);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberService The entity of update. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(MemberService memberService) {
        doUpdate(memberService, null);
    }

    protected void doUpdate(MemberService et, final UpdateOption<MemberServiceCB> op) {
        assertObjectNotNull("memberService", et);
        prepareUpdateOption(op);
        helpUpdateInternally(et, new InternalUpdateCallback<MemberService>() {
            public int callbackDelegateUpdate(MemberService let) { return delegateUpdate(let, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberServiceCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) { op.resolveSelfSpecification(createCBForVaryingUpdate()); }
        if (op.hasSpecifiedUpdateColumn()) { op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected MemberServiceCB createCBForVaryingUpdate()
    { MemberServiceCB cb = newConditionBean(); cb.xsetupForVaryingUpdate(); return cb; }

    protected MemberServiceCB createCBForSpecifiedUpdate()
    { MemberServiceCB cb = newConditionBean(); cb.xsetupForSpecifiedUpdate(); return cb; }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        doUpdate(downcast(et), downcast(op));
    }

    /**
     * Update the entity non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberService.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberService.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberService.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * memberServiceBhv.<span style="color: #DD4747">updateNonstrict</span>(memberService);
     * </pre>
     * @param memberService The entity of update. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(MemberService memberService) {
        doUpdateNonstrict(memberService, null);
    }

    protected void doUpdateNonstrict(MemberService et, final UpdateOption<MemberServiceCB> op) {
        assertObjectNotNull("memberService", et);
        prepareUpdateOption(op);
        helpUpdateNonstrictInternally(et, new InternalUpdateNonstrictCallback<MemberService>() {
            public int callbackDelegateUpdateNonstrict(MemberService let) { return delegateUpdateNonstrict(let, op); } });
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        doUpdateNonstrict(downcast(et), downcast(op));
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, ExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberService The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberService memberService) {
        doInsertOrUpdate(memberService, null, null);
    }

    protected void doInsertOrUpdate(MemberService et, final InsertOption<MemberServiceCB> iop, final UpdateOption<MemberServiceCB> uop) {
        assertObjectNotNull("memberService", et);
        helpInsertOrUpdateInternally(et, new InternalInsertOrUpdateCallback<MemberService, MemberServiceCB>() {
            public void callbackInsert(MemberService let) { doInsert(let, iop); }
            public void callbackUpdate(MemberService let) { doUpdate(let, uop); }
            public MemberServiceCB callbackNewMyConditionBean() { return newConditionBean(); }
            public int callbackSelectCount(MemberServiceCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doInsertOrUpdate(downcast(et), downcast(iop), downcast(uop));
    }

    /**
     * Insert or update the entity non-strictly modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() }
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberService The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(MemberService memberService) {
        doInsertOrUpdateNonstrict(memberService, null, null);
    }

    protected void doInsertOrUpdateNonstrict(MemberService et, final InsertOption<MemberServiceCB> iop, final UpdateOption<MemberServiceCB> uop) {
        assertObjectNotNull("memberService", et);
        helpInsertOrUpdateInternally(et, new InternalInsertOrUpdateNonstrictCallback<MemberService>() {
            public void callbackInsert(MemberService let) { doInsert(let, iop); }
            public void callbackUpdateNonstrict(MemberService let) { doUpdateNonstrict(let, uop); }
        });
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doInsertOrUpdateNonstrict(downcast(et), downcast(iop), downcast(uop));
    }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberService.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     memberServiceBhv.<span style="color: #DD4747">delete</span>(memberService);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberService The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberService memberService) {
        doDelete(memberService, null);
    }

    protected void doDelete(MemberService et, final DeleteOption<MemberServiceCB> op) {
        assertObjectNotNull("memberService", et);
        prepareDeleteOption(op);
        helpDeleteInternally(et, new InternalDeleteCallback<MemberService>() {
            public int callbackDelegateDelete(MemberService let) { return delegateDelete(let, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberServiceCB> op)
    { if (op != null) { assertDeleteOptionStatus(op); } }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        doDelete(downcast(et), downcast(op));
    }

    /**
     * Delete the entity non-strictly. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * memberServiceBhv.<span style="color: #DD4747">deleteNonstrict</span>(memberService);
     * </pre>
     * @param memberService The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(MemberService memberService) {
        doDeleteNonstrict(memberService, null);
    }

    protected void doDeleteNonstrict(MemberService et, final DeleteOption<MemberServiceCB> op) {
        assertObjectNotNull("memberService", et);
        prepareDeleteOption(op);
        helpDeleteNonstrictInternally(et, new InternalDeleteNonstrictCallback<MemberService>() {
            public int callbackDelegateDeleteNonstrict(MemberService let) { return delegateDeleteNonstrict(let, op); } });
    }

    @Override
    protected void doRemoveNonstrict(Entity et, DeleteOption<? extends ConditionBean> op) {
        doDeleteNonstrict(downcast(et), downcast(op));
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
     *     MemberService memberService = new MemberService();
     *     memberService.setFooName("foo");
     *     if (...) {
     *         memberService.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberServiceList.add(memberService);
     * }
     * memberServiceBhv.<span style="color: #DD4747">batchInsert</span>(memberServiceList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberService> memberServiceList) {
        return doBatchInsert(memberServiceList, null);
    }

    protected int[] doBatchInsert(List<MemberService> ls, InsertOption<MemberServiceCB> op) {
        assertObjectNotNull("memberServiceList", ls);
        InsertOption<MemberServiceCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainInsertOption(); }
        prepareBatchInsertOption(ls, rlop); // required
        return delegateBatchInsert(ls, rlop);
    }

    protected void prepareBatchInsertOption(List<MemberService> ls, InsertOption<MemberServiceCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(ls);
        prepareInsertOption(op);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) {
        return doBatchInsert(downcast(ls), downcast(op));
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     MemberService memberService = new MemberService();
     *     memberService.setFooName("foo");
     *     if (...) {
     *         memberService.setFooPrice(123);
     *     } else {
     *         memberService.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberService.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberServiceList.add(memberService);
     * }
     * memberServiceBhv.<span style="color: #DD4747">batchUpdate</span>(memberServiceList);
     * </pre>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<MemberService> memberServiceList) {
        return doBatchUpdate(memberServiceList, null);
    }

    protected int[] doBatchUpdate(List<MemberService> ls, UpdateOption<MemberServiceCB> op) {
        assertObjectNotNull("memberServiceList", ls);
        UpdateOption<MemberServiceCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop); // required
        return delegateBatchUpdate(ls, rlop);
    }

    protected void prepareBatchUpdateOption(List<MemberService> ls, UpdateOption<MemberServiceCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(ls);
        prepareUpdateOption(op);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doBatchUpdate(downcast(ls), downcast(op));
    }

    /**
     * Batch-update the entity list specified-only. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * memberServiceBhv.<span style="color: #DD4747">batchUpdate</span>(memberServiceList, new SpecifyQuery<MemberServiceCB>() {
     *     public void specify(MemberServiceCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * memberServiceBhv.<span style="color: #DD4747">batchUpdate</span>(memberServiceList, new SpecifyQuery<MemberServiceCB>() {
     *     public void specify(MemberServiceCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<MemberService> memberServiceList, SpecifyQuery<MemberServiceCB> updateColumnSpec) {
        return doBatchUpdate(memberServiceList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 140%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     MemberService memberService = new MemberService();
     *     memberService.setFooName("foo");
     *     if (...) {
     *         memberService.setFooPrice(123);
     *     } else {
     *         memberService.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberService.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberServiceList.add(memberService);
     * }
     * memberServiceBhv.<span style="color: #DD4747">batchUpdate</span>(memberServiceList);
     * </pre>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<MemberService> memberServiceList) {
        return doBatchUpdateNonstrict(memberServiceList, null);
    }

    protected int[] doBatchUpdateNonstrict(List<MemberService> ls, UpdateOption<MemberServiceCB> op) {
        assertObjectNotNull("memberServiceList", ls);
        UpdateOption<MemberServiceCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop);
        return delegateBatchUpdateNonstrict(ls, rlop);
    }

    /**
     * Batch-update the entity list non-strictly specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * memberServiceBhv.<span style="color: #DD4747">batchUpdateNonstrict</span>(memberServiceList, new SpecifyQuery<MemberServiceCB>() {
     *     public void specify(MemberServiceCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * memberServiceBhv.<span style="color: #DD4747">batchUpdateNonstrict</span>(memberServiceList, new SpecifyQuery<MemberServiceCB>() {
     *     public void specify(MemberServiceCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).</p>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<MemberService> memberServiceList, SpecifyQuery<MemberServiceCB> updateColumnSpec) {
        return doBatchUpdateNonstrict(memberServiceList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doBatchUpdateNonstrict(downcast(ls), downcast(op));
    }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(List<MemberService> memberServiceList) {
        return doBatchDelete(memberServiceList, null);
    }

    protected int[] doBatchDelete(List<MemberService> ls, DeleteOption<MemberServiceCB> op) {
        assertObjectNotNull("memberServiceList", ls);
        prepareDeleteOption(op);
        return delegateBatchDelete(ls, op);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        return doBatchDelete(downcast(ls), downcast(op));
    }

    /**
     * Batch-delete the entity list non-strictly. {NonExclusiveControl} <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(List<MemberService> memberServiceList) {
        return doBatchDeleteNonstrict(memberServiceList, null);
    }

    protected int[] doBatchDeleteNonstrict(List<MemberService> ls, DeleteOption<MemberServiceCB> op) {
        assertObjectNotNull("memberServiceList", ls);
        prepareDeleteOption(op);
        return delegateBatchDeleteNonstrict(ls, op);
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        return doBatchDeleteNonstrict(downcast(ls), downcast(op));
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * memberServiceBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberService, MemberServiceCB&gt;() {
     *     public ConditionBean setup(memberService entity, MemberServiceCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<MemberService, MemberServiceCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberService, MemberServiceCB> sp, InsertOption<MemberServiceCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        MemberService et = newEntity();
        MemberServiceCB cb = createCBForQueryInsert();
        return delegateQueryInsert(et, cb, sp.setup(et, cb), op);
    }

    protected MemberServiceCB createCBForQueryInsert()
    { MemberServiceCB cb = newConditionBean(); cb.xsetupForQueryInsert(); return cb; }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> op) {
        return doQueryInsert(downcast(setupper), downcast(op));
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * MemberService memberService = new MemberService();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberService.setPK...(value);</span>
     * memberService.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberService.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberService.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * memberServiceBhv.<span style="color: #DD4747">queryUpdate</span>(memberService, cb);
     * </pre>
     * @param memberService The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberService memberService, MemberServiceCB cb) {
        return doQueryUpdate(memberService, cb, null);
    }

    protected int doQueryUpdate(MemberService et, MemberServiceCB cb, UpdateOption<MemberServiceCB> op) {
        assertObjectNotNull("memberService", et); assertCBStateValid(cb);
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
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * memberServiceBhv.<span style="color: #DD4747">queryDelete</span>(memberService, cb);
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberServiceCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberServiceCB cb, DeleteOption<MemberServiceCB> op) {
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
     * MemberService memberService = new MemberService();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberService.setFoo...(value);
     * memberService.setBar...(value);
     * InsertOption<MemberServiceCB> option = new InsertOption<MemberServiceCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberServiceBhv.<span style="color: #DD4747">varyingInsert</span>(memberService, option);
     * ... = memberService.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberService The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(MemberService memberService, InsertOption<MemberServiceCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(memberService, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, ExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberService.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberService.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberServiceCB&gt; option = new UpdateOption&lt;MemberServiceCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberServiceCB&gt;() {
     *         public void specify(MemberServiceCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberServiceBhv.<span style="color: #DD4747">varyingUpdate</span>(memberService, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberService The entity of update. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(MemberService memberService, UpdateOption<MemberServiceCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(memberService, option);
    }

    /**
     * Update the entity with varying requests non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as updateNonstrict(entity).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberService.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * UpdateOption&lt;MemberServiceCB&gt; option = new UpdateOption&lt;MemberServiceCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberServiceCB&gt;() {
     *     public void specify(MemberServiceCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberServiceBhv.<span style="color: #DD4747">varyingUpdateNonstrict</span>(memberService, option);
     * </pre>
     * @param memberService The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(MemberService memberService, UpdateOption<MemberServiceCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(memberService, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberService The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberService memberService, InsertOption<MemberServiceCB> insertOption, UpdateOption<MemberServiceCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdate(memberService, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param memberService The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(MemberService memberService, InsertOption<MemberServiceCB> insertOption, UpdateOption<MemberServiceCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdateNonstrict(memberService, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberService The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberService memberService, DeleteOption<MemberServiceCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberService, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param memberService The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDeleteNonstrict(MemberService memberService, DeleteOption<MemberServiceCB> option) {
        assertDeleteOptionNotNull(option);
        doDeleteNonstrict(memberService, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<MemberService> memberServiceList, InsertOption<MemberServiceCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberServiceList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<MemberService> memberServiceList, UpdateOption<MemberServiceCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberServiceList, option);
    }

    /**
     * Batch-update the list with varying requests non-strictly. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdateNonstrict(List<MemberService> memberServiceList, UpdateOption<MemberServiceCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdateNonstrict(memberServiceList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<MemberService> memberServiceList, DeleteOption<MemberServiceCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberServiceList, option);
    }

    /**
     * Batch-delete the list with varying requests non-strictly. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDeleteNonstrict(entityList).
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDeleteNonstrict(List<MemberService> memberServiceList, DeleteOption<MemberServiceCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDeleteNonstrict(memberServiceList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<MemberService, MemberServiceCB> setupper, InsertOption<MemberServiceCB> option) {
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
     * MemberService memberService = new MemberService();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberService.setPK...(value);</span>
     * memberService.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberServiceCB&gt; option = new UpdateOption&lt;MemberServiceCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberServiceCB&gt;() {
     *     public void specify(MemberServiceCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberServiceBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(memberService, cb, option);
     * </pre>
     * @param memberService The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberService. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(MemberService memberService, MemberServiceCB cb, UpdateOption<MemberServiceCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(memberService, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of MemberService. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberServiceCB cb, DeleteOption<MemberServiceCB> option) {
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
    public OutsideSqlBasicExecutor<MemberServiceBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(MemberServiceCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(MemberServiceCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends MemberService> void delegateSelectCursor(MemberServiceCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends MemberService> List<ENTITY> delegateSelectList(MemberServiceCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(MemberService et, InsertOption<MemberServiceCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(MemberService et, UpdateOption<MemberServiceCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateEntityCommand(et, op)); }
    protected int delegateUpdateNonstrict(MemberService et, UpdateOption<MemberServiceCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(MemberService et, DeleteOption<MemberServiceCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteEntityCommand(et, op)); }
    protected int delegateDeleteNonstrict(MemberService et, DeleteOption<MemberServiceCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<MemberService> ls, InsertOption<MemberServiceCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<MemberService> ls, UpdateOption<MemberServiceCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchUpdateNonstrict(List<MemberService> ls, UpdateOption<MemberServiceCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<MemberService> ls, DeleteOption<MemberServiceCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchDeleteNonstrict(List<MemberService> ls, DeleteOption<MemberServiceCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(MemberService et, MemberServiceCB inCB, ConditionBean resCB, InsertOption<MemberServiceCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(MemberService et, MemberServiceCB cb, UpdateOption<MemberServiceCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(MemberServiceCB cb, DeleteOption<MemberServiceCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity et) {
        return !(downcast(et).getVersionNo() + "").equals("null"); // for primitive type
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
    protected Class<MemberService> typeOfSelectedEntity()
    { return MemberService.class; }

    protected MemberService downcast(Entity et)
    { return helpEntityDowncastInternally(et, MemberService.class); }

    protected MemberServiceCB downcast(ConditionBean cb)
    { return helpConditionBeanDowncastInternally(cb, MemberServiceCB.class); }

    @SuppressWarnings("unchecked")
    protected List<MemberService> downcast(List<? extends Entity> ls)
    { return (List<MemberService>)ls; }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberServiceCB> downcast(InsertOption<? extends ConditionBean> op)
    { return (InsertOption<MemberServiceCB>)op; }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberServiceCB> downcast(UpdateOption<? extends ConditionBean> op)
    { return (UpdateOption<MemberServiceCB>)op; }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberServiceCB> downcast(DeleteOption<? extends ConditionBean> op)
    { return (DeleteOption<MemberServiceCB>)op; }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberService, MemberServiceCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp)
    { return (QueryInsertSetupper<MemberService, MemberServiceCB>)sp; }
}
