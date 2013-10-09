/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.bsbhv;

import java.util.List;
import javax.inject.Inject;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.bhv.core.BehaviorCommandInvoker;
import org.seasar.dbflute.bhv.core.CommonColumnAutoSetupper;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.outsidesql.executor.*;
import com.example.dbflute.cdi.dbflute.exbhv.*;
import com.example.dbflute.cdi.dbflute.exentity.*;
import com.example.dbflute.cdi.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.cdi.dbflute.cbean.*;

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
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return MemberServiceDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberServiceDbm getMyDBMeta() { return MemberServiceDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public MemberService newMyEntity() { return new MemberService(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberServiceCB newMyConditionBean() { return new MemberServiceCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * int count = memberServiceBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberServiceCB cb) {
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
        return selectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean.
     * <pre>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * MemberService memberService = memberServiceBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (memberService != null) {
     *     ... = memberService.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberService selectEntity(MemberServiceCB cb) {
        return doSelectEntity(cb, MemberService.class);
    }

    protected <ENTITY extends MemberService> ENTITY doSelectEntity(final MemberServiceCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType, new InternalSelectEntityCallback<ENTITY, MemberServiceCB>() {
            public List<ENTITY> callbackSelectList(MemberServiceCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * MemberService memberService = memberServiceBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberService.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberService selectEntityWithDeletedCheck(MemberServiceCB cb) {
        return doSelectEntityWithDeletedCheck(cb, MemberService.class);
    }

    protected <ENTITY extends MemberService> ENTITY doSelectEntityWithDeletedCheck(final MemberServiceCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(cb, entityType, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberServiceCB>() {
            public List<ENTITY> callbackSelectList(MemberServiceCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param memberServiceId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberService selectByPKValue(Integer memberServiceId) {
        return doSelectByPKValue(memberServiceId, MemberService.class);
    }

    protected <ENTITY extends MemberService> ENTITY doSelectByPKValue(Integer memberServiceId, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(memberServiceId), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param memberServiceId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberService selectByPKValueWithDeletedCheck(Integer memberServiceId) {
        return doSelectByPKValueWithDeletedCheck(memberServiceId, MemberService.class);
    }

    protected <ENTITY extends MemberService> ENTITY doSelectByPKValueWithDeletedCheck(Integer memberServiceId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(memberServiceId), entityType);
    }

    private MemberServiceCB buildPKCB(Integer memberServiceId) {
        assertObjectNotNull("memberServiceId", memberServiceId);
        MemberServiceCB cb = newMyConditionBean();
        cb.query().setMemberServiceId_Equal(memberServiceId);
        return cb;
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
     * ListResultBean&lt;MemberService&gt; memberServiceList = memberServiceBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (MemberService memberService : memberServiceList) {
     *     ... = memberService.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberService> selectList(MemberServiceCB cb) {
        return doSelectList(cb, MemberService.class);
    }

    protected <ENTITY extends MemberService> ListResultBean<ENTITY> doSelectList(MemberServiceCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType, new InternalSelectListCallback<ENTITY, MemberServiceCB>() {
            public List<ENTITY> callbackSelectList(MemberServiceCB cb, Class<ENTITY> entityType) { return delegateSelectList(cb, entityType); } });
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
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberService&gt; page = memberServiceBhv.<span style="color: #FD4747">selectPage</span>(cb);
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
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberService> selectPage(MemberServiceCB cb) {
        return doSelectPage(cb, MemberService.class);
    }

    protected <ENTITY extends MemberService> PagingResultBean<ENTITY> doSelectPage(MemberServiceCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType, new InternalSelectPageCallback<ENTITY, MemberServiceCB>() {
            public int callbackSelectCount(MemberServiceCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberServiceCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
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
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * memberServiceBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberService&gt;() {
     *     public void handle(MemberService entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberService. (NotNull)
     */
    public void selectCursor(MemberServiceCB cb, EntityRowHandler<MemberService> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, MemberService.class);
    }

    protected <ENTITY extends MemberService> void doSelectCursor(MemberServiceCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler<MemberService>", entityRowHandler); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType, new InternalSelectCursorCallback<ENTITY, MemberServiceCB>() {
            public void callbackSelectCursor(MemberServiceCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) { delegateSelectCursor(cb, entityRowHandler, entityType); }
            public List<ENTITY> callbackSelectList(MemberServiceCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberServiceBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberServiceCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar value derived by a function. (NullAllowed)
     */
    public <RESULT> SLFunction<MemberServiceCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends MemberServiceCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> resultType, CB cb) {
        assertObjectNotNull("resultType", resultType); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return new SLFunction<CB, RESULT>(cb, resultType);
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
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Member'.
     * @param memberServiceList The list of memberService. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMember(List<MemberService> memberServiceList) {
        return helpPulloutInternally(memberServiceList, new InternalPulloutCallback<MemberService, Member>() {
            public Member getFr(MemberService e) { return e.getMember(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member e, List<MemberService> ls)
            { if (!ls.isEmpty()) { e.setMemberServiceAsOne(ls.get(0)); } }
        });
    }
    /**
     * Pull out the list of foreign table 'ServiceRank'.
     * @param memberServiceList The list of memberService. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<ServiceRank> pulloutServiceRank(List<MemberService> memberServiceList) {
        return helpPulloutInternally(memberServiceList, new InternalPulloutCallback<MemberService, ServiceRank>() {
            public ServiceRank getFr(MemberService e) { return e.getServiceRank(); }
            public boolean hasRf() { return true; }
            public void setRfLs(ServiceRank e, List<MemberService> ls)
            { e.setMemberServiceList(ls); }
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
            public Integer getCV(MemberService e) { return e.getMemberServiceId(); }
        });
    }

    /**
     * Extract the value list of (single) unique key memberId.
     * @param memberServiceList The list of memberService. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractMemberIdList(List<MemberService> memberServiceList) {
        return helpExtractListInternally(memberServiceList, new InternalExtractCallback<MemberService, Integer>() {
            public Integer getCV(MemberService e) { return e.getMemberId(); }
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
     * memberServiceBhv.<span style="color: #FD4747">insert</span>(memberService);
     * ... = memberService.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberService The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberService memberService) {
        doInsert(memberService, null);
    }

    protected void doInsert(MemberService memberService, InsertOption<MemberServiceCB> option) {
        assertObjectNotNull("memberService", memberService);
        prepareInsertOption(option);
        delegateInsert(memberService, option);
    }

    protected void prepareInsertOption(InsertOption<MemberServiceCB> option) {
        if (option == null) { return; }
        assertInsertOptionStatus(option);
        if (option.hasSpecifiedInsertColumn()) {
            option.resolveInsertColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    @Override
    protected void doCreate(Entity entity, InsertOption<? extends ConditionBean> option) {
        if (option == null) { insert(downcast(entity)); }
        else { varyingInsert(downcast(entity), downcast(option)); }
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
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberService.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberServiceBhv.<span style="color: #FD4747">update</span>(memberService);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param memberService The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final MemberService memberService) {
        doUpdate(memberService, null);
    }

    protected void doUpdate(MemberService memberService, final UpdateOption<MemberServiceCB> option) {
        assertObjectNotNull("memberService", memberService);
        prepareUpdateOption(option);
        helpUpdateInternally(memberService, new InternalUpdateCallback<MemberService>() {
            public int callbackDelegateUpdate(MemberService entity) { return delegateUpdate(entity, option); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberServiceCB> option) {
        if (option == null) { return; }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected MemberServiceCB createCBForVaryingUpdate() {
        MemberServiceCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected MemberServiceCB createCBForSpecifiedUpdate() {
        MemberServiceCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity entity, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { update(downcast(entity)); }
        else { varyingUpdate(downcast(entity), downcast(option)); }
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
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * memberServiceBhv.<span style="color: #FD4747">updateNonstrict</span>(memberService);
     * </pre>
     * @param memberService The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(final MemberService memberService) {
        doUpdateNonstrict(memberService, null);
    }

    protected void doUpdateNonstrict(MemberService memberService, final UpdateOption<MemberServiceCB> option) {
        assertObjectNotNull("memberService", memberService);
        prepareUpdateOption(option);
        helpUpdateNonstrictInternally(memberService, new InternalUpdateNonstrictCallback<MemberService>() {
            public int callbackDelegateUpdateNonstrict(MemberService entity) { return delegateUpdateNonstrict(entity, option); } });
    }

    @Override
    protected void doModifyNonstrict(Entity entity, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { updateNonstrict(downcast(entity)); }
        else { varyingUpdateNonstrict(downcast(entity), downcast(option)); }
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, ExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberService The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberService memberService) {
        doInesrtOrUpdate(memberService, null, null);
    }

    protected void doInesrtOrUpdate(MemberService memberService, final InsertOption<MemberServiceCB> insertOption, final UpdateOption<MemberServiceCB> updateOption) {
        helpInsertOrUpdateInternally(memberService, new InternalInsertOrUpdateCallback<MemberService, MemberServiceCB>() {
            public void callbackInsert(MemberService entity) { doInsert(entity, insertOption); }
            public void callbackUpdate(MemberService entity) { doUpdate(entity, updateOption); }
            public MemberServiceCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(MemberServiceCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdate(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<MemberServiceCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<MemberServiceCB>() : updateOption;
            varyingInsertOrUpdate(downcast(entity), downcast(insertOption), downcast(updateOption));
        }
    }

    /**
     * Insert or update the entity non-strictly modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() }
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberService The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(MemberService memberService) {
        doInesrtOrUpdateNonstrict(memberService, null, null);
    }

    protected void doInesrtOrUpdateNonstrict(MemberService memberService, final InsertOption<MemberServiceCB> insertOption, final UpdateOption<MemberServiceCB> updateOption) {
        helpInsertOrUpdateInternally(memberService, new InternalInsertOrUpdateNonstrictCallback<MemberService>() {
            public void callbackInsert(MemberService entity) { doInsert(entity, insertOption); }
            public void callbackUpdateNonstrict(MemberService entity) { doUpdateNonstrict(entity, updateOption); }
        });
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdateNonstrict(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<MemberServiceCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<MemberServiceCB>() : updateOption;
            varyingInsertOrUpdateNonstrict(downcast(entity), downcast(insertOption), downcast(updateOption));
        }
    }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberService.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberServiceBhv.<span style="color: #FD4747">delete</span>(memberService);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param memberService The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberService memberService) {
        doDelete(memberService, null);
    }

    protected void doDelete(MemberService memberService, final DeleteOption<MemberServiceCB> option) {
        assertObjectNotNull("memberService", memberService);
        prepareDeleteOption(option);
        helpDeleteInternally(memberService, new InternalDeleteCallback<MemberService>() {
            public int callbackDelegateDelete(MemberService entity) { return delegateDelete(entity, option); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberServiceCB> option) {
        if (option == null) { return; }
        assertDeleteOptionStatus(option);
    }

    @Override
    protected void doRemove(Entity entity, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { delete(downcast(entity)); }
        else { varyingDelete(downcast(entity), downcast(option)); }
    }

    /**
     * Delete the entity non-strictly. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * memberServiceBhv.<span style="color: #FD4747">deleteNonstrict</span>(memberService);
     * </pre>
     * @param memberService The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(MemberService memberService) {
        doDeleteNonstrict(memberService, null);
    }

    protected void doDeleteNonstrict(MemberService memberService, final DeleteOption<MemberServiceCB> option) {
        assertObjectNotNull("memberService", memberService);
        prepareDeleteOption(option);
        helpDeleteNonstrictInternally(memberService, new InternalDeleteNonstrictCallback<MemberService>() {
            public int callbackDelegateDeleteNonstrict(MemberService entity) { return delegateDeleteNonstrict(entity, option); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * MemberService memberService = new MemberService();
     * memberService.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * memberServiceBhv.<span style="color: #FD4747">deleteNonstrictIgnoreDeleted</span>(memberService);
     * <span style="color: #3F7E5E">// if the target entity doesn't exist, no exception</span>
     * </pre>
     * @param memberService The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(MemberService memberService) {
        doDeleteNonstrictIgnoreDeleted(memberService, null);
    }

    protected void doDeleteNonstrictIgnoreDeleted(MemberService memberService, final DeleteOption<MemberServiceCB> option) {
        assertObjectNotNull("memberService", memberService);
        prepareDeleteOption(option);
        helpDeleteNonstrictIgnoreDeletedInternally(memberService, new InternalDeleteNonstrictIgnoreDeletedCallback<MemberService>() {
            public int callbackDelegateDeleteNonstrict(MemberService entity) { return delegateDeleteNonstrict(entity, option); } });
    }

    @Override
    protected void doRemoveNonstrict(Entity entity, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { deleteNonstrict(downcast(entity)); }
        else { varyingDeleteNonstrict(downcast(entity), downcast(option)); }
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <p><span style="color: #FD4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
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
     * memberServiceBhv.<span style="color: #FD4747">batchInsert</span>(memberServiceList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberService> memberServiceList) {
        InsertOption<MemberServiceCB> option = createInsertUpdateOption();
        return doBatchInsert(memberServiceList, option);
    }

    protected int[] doBatchInsert(List<MemberService> memberServiceList, InsertOption<MemberServiceCB> option) {
        assertObjectNotNull("memberServiceList", memberServiceList);
        prepareBatchInsertOption(memberServiceList, option);
        return delegateBatchInsert(memberServiceList, option);
    }

    protected void prepareBatchInsertOption(List<MemberService> memberServiceList, InsertOption<MemberServiceCB> option) {
        option.xallowInsertColumnModifiedPropertiesFragmented();
        option.xacceptInsertColumnModifiedPropertiesIfNeeds(memberServiceList);
        prepareInsertOption(option);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> option) {
        if (option == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
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
     * memberServiceBhv.<span style="color: #FD4747">batchUpdate</span>(memberServiceList);
     * </pre>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<MemberService> memberServiceList) {
        UpdateOption<MemberServiceCB> option = createPlainUpdateOption();
        return doBatchUpdate(memberServiceList, option);
    }

    protected int[] doBatchUpdate(List<MemberService> memberServiceList, UpdateOption<MemberServiceCB> option) {
        assertObjectNotNull("memberServiceList", memberServiceList);
        prepareBatchUpdateOption(memberServiceList, option);
        return delegateBatchUpdate(memberServiceList, option);
    }

    protected void prepareBatchUpdateOption(List<MemberService> memberServiceList, UpdateOption<MemberServiceCB> option) {
        option.xacceptUpdateColumnModifiedPropertiesIfNeeds(memberServiceList);
        prepareUpdateOption(option);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-update the entity list specified-only. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span> 
     * memberServiceBhv.<span style="color: #FD4747">batchUpdate</span>(memberServiceList, new SpecifyQuery<MemberServiceCB>() {
     *     public void specify(MemberServiceCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * memberServiceBhv.<span style="color: #FD4747">batchUpdate</span>(memberServiceList, new SpecifyQuery<MemberServiceCB>() {
     *     public void specify(MemberServiceCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<MemberService> memberServiceList, SpecifyQuery<MemberServiceCB> updateColumnSpec) {
        return doBatchUpdate(memberServiceList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 140%">You should specify same-set columns to all entities like this:</span>
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
     * memberServiceBhv.<span style="color: #FD4747">batchUpdate</span>(memberServiceList);
     * </pre>
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<MemberService> memberServiceList) {
        UpdateOption<MemberServiceCB> option = createPlainUpdateOption();
        return doBatchUpdateNonstrict(memberServiceList, option);
    }

    protected int[] doBatchUpdateNonstrict(List<MemberService> memberServiceList, UpdateOption<MemberServiceCB> option) {
        assertObjectNotNull("memberServiceList", memberServiceList);
        prepareBatchUpdateOption(memberServiceList, option);
        return delegateBatchUpdateNonstrict(memberServiceList, option);
    }

    /**
     * Batch-update the entity list non-strictly specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span> 
     * memberServiceBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(memberServiceList, new SpecifyQuery<MemberServiceCB>() {
     *     public void specify(MemberServiceCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * memberServiceBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(memberServiceList, new SpecifyQuery<MemberServiceCB>() {
     *     public void specify(MemberServiceCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
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
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<MemberService> memberServiceList, SpecifyQuery<MemberServiceCB> updateColumnSpec) {
        return doBatchUpdateNonstrict(memberServiceList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return batchUpdateNonstrict(downcast(ls)); }
        else { return varyingBatchUpdateNonstrict(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(List<MemberService> memberServiceList) {
        return doBatchDelete(memberServiceList, null);
    }

    protected int[] doBatchDelete(List<MemberService> memberServiceList, DeleteOption<MemberServiceCB> option) {
        assertObjectNotNull("memberServiceList", memberServiceList);
        prepareDeleteOption(option);
        return delegateBatchDelete(memberServiceList, option);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-delete the entity list non-strictly. {NonExclusiveControl} <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberServiceList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(List<MemberService> memberServiceList) {
        return doBatchDeleteNonstrict(memberServiceList, null);
    }

    protected int[] doBatchDeleteNonstrict(List<MemberService> memberServiceList, DeleteOption<MemberServiceCB> option) {
        assertObjectNotNull("memberServiceList", memberServiceList);
        prepareDeleteOption(option);
        return delegateBatchDeleteNonstrict(memberServiceList, option);
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return batchDeleteNonstrict(downcast(ls)); }
        else { return varyingBatchDeleteNonstrict(downcast(ls), downcast(option)); }
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * memberServiceBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberService, MemberServiceCB&gt;() {
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
    public int queryInsert(QueryInsertSetupper<MemberService, MemberServiceCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberService, MemberServiceCB> setupper, InsertOption<MemberServiceCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        MemberService entity = new MemberService();
        MemberServiceCB intoCB = createCBForQueryInsert();
        ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected MemberServiceCB createCBForQueryInsert() {
        MemberServiceCB cb = newMyConditionBean();
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
     * MemberService memberService = new MemberService();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberService.setPK...(value);</span>
     * memberService.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberService.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberService.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * memberServiceBhv.<span style="color: #FD4747">queryUpdate</span>(memberService, cb);
     * </pre>
     * @param memberService The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberService memberService, MemberServiceCB cb) {
        return doQueryUpdate(memberService, cb, null);
    }

    protected int doQueryUpdate(MemberService memberService, MemberServiceCB cb, UpdateOption<MemberServiceCB> option) {
        assertObjectNotNull("memberService", memberService); assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(memberService, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(Entity entity, ConditionBean cb, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return queryUpdate(downcast(entity), (MemberServiceCB)cb); }
        else { return varyingQueryUpdate(downcast(entity), (MemberServiceCB)cb, downcast(option)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * memberServiceBhv.<span style="color: #FD4747">queryDelete</span>(memberService, cb);
     * </pre>
     * @param cb The condition-bean of MemberService. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberServiceCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberServiceCB cb, DeleteOption<MemberServiceCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, option) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return queryDelete((MemberServiceCB)cb); }
        else { return varyingQueryDelete((MemberServiceCB)cb, downcast(option)); }
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
     * memberServiceBhv.<span style="color: #FD4747">varyingInsert</span>(memberService, option);
     * ... = memberService.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberService The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
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
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberService.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberServiceCB&gt; option = new UpdateOption&lt;MemberServiceCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberServiceCB&gt;() {
     *         public void specify(MemberServiceCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberServiceBhv.<span style="color: #FD4747">varyingUpdate</span>(memberService, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberService The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
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
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * UpdateOption&lt;MemberServiceCB&gt; option = new UpdateOption&lt;MemberServiceCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberServiceCB&gt;() {
     *     public void specify(MemberServiceCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberServiceBhv.<span style="color: #FD4747">varyingUpdateNonstrict</span>(memberService, option);
     * </pre>
     * @param memberService The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(MemberService memberService, UpdateOption<MemberServiceCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(memberService, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberService The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberService memberService, InsertOption<MemberServiceCB> insertOption, UpdateOption<MemberServiceCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(memberService, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param memberService The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(MemberService memberService, InsertOption<MemberServiceCB> insertOption, UpdateOption<MemberServiceCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdateNonstrict(memberService, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberService The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberService memberService, DeleteOption<MemberServiceCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberService, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param memberService The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
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
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberService.setVersionNo(value);</span>
     * MemberServiceCB cb = new MemberServiceCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberServiceCB&gt; option = new UpdateOption&lt;MemberServiceCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberServiceCB&gt;() {
     *     public void specify(MemberServiceCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberServiceBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(memberService, cb, option);
     * </pre>
     * @param memberService The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberService. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
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
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
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
    protected <ENTITY extends MemberService> void delegateSelectCursor(MemberServiceCB cb, EntityRowHandler<ENTITY> erh, Class<ENTITY> et)
    { invoke(createSelectCursorCBCommand(cb, erh, et)); }
    protected <ENTITY extends MemberService> List<ENTITY> delegateSelectList(MemberServiceCB cb, Class<ENTITY> et)
    { return invoke(createSelectListCBCommand(cb, et)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(MemberService e, InsertOption<MemberServiceCB> op)
    { if (!processBeforeInsert(e, op)) { return 0; }
      return invoke(createInsertEntityCommand(e, op)); }
    protected int delegateUpdate(MemberService e, UpdateOption<MemberServiceCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateEntityCommand(e, op)); }
    protected int delegateUpdateNonstrict(MemberService e, UpdateOption<MemberServiceCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(e, op)); }
    protected int delegateDelete(MemberService e, DeleteOption<MemberServiceCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteEntityCommand(e, op)); }
    protected int delegateDeleteNonstrict(MemberService e, DeleteOption<MemberServiceCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(e, op)); }

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

    protected int delegateQueryInsert(MemberService e, MemberServiceCB inCB, ConditionBean resCB, InsertOption<MemberServiceCB> op)
    { if (!processBeforeQueryInsert(e, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));  }
    protected int delegateQueryUpdate(MemberService e, MemberServiceCB cb, UpdateOption<MemberServiceCB> op)
    { if (!processBeforeQueryUpdate(e, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(e, cb, op));  }
    protected int delegateQueryDelete(MemberServiceCB cb, DeleteOption<MemberServiceCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity entity) {
        return !(downcast(entity).getVersionNo() + "").equals("null");// For primitive type
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasUpdateDateValue(Entity entity) {
        return false;
    }

    // ===================================================================================
    //                                                                     Downcast Helper
    //                                                                     ===============
    protected MemberService downcast(Entity entity) {
        return helpEntityDowncastInternally(entity, MemberService.class);
    }

    protected MemberServiceCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, MemberServiceCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<MemberService> downcast(List<? extends Entity> entityList) {
        return (List<MemberService>)entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberServiceCB> downcast(InsertOption<? extends ConditionBean> option) {
        return (InsertOption<MemberServiceCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberServiceCB> downcast(UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<MemberServiceCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberServiceCB> downcast(DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<MemberServiceCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberService, MemberServiceCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<MemberService, MemberServiceCB>)option;
    }

    /**
     * Set the auto set-upper of common column.
     * @param commonColumnAutoSetupper The auto set-upper of common column. (NotNull)
     */
    @Override @Inject
    public void setCommonColumnAutoSetupper(CommonColumnAutoSetupper commonColumnAutoSetupper) {
        this._commonColumnAutoSetupper = commonColumnAutoSetupper;
    }

    /**
     * Set the selector of behavior.
     * @param behaviorSelector The selector of behavior. (NotNull)
     */
    @Override @Inject
    public void setBehaviorSelector(BehaviorSelector behaviorSelector) {
        this._behaviorSelector = behaviorSelector;
    }

    /**
     * Set the invoker of behavior command.
     * @param behaviorCommandInvoker The invoker of behavior command. (NotNull)
     */
    @Override @Inject
    public void setBehaviorCommandInvoker(BehaviorCommandInvoker behaviorCommandInvoker) {
        this._behaviorCommandInvoker = behaviorCommandInvoker;
    }
}
