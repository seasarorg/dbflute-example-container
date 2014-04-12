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
package com.example.dbflute.spring.dbflute.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.outsidesql.executor.*;
import com.example.dbflute.spring.dbflute.exbhv.*;
import com.example.dbflute.spring.dbflute.exentity.*;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.spring.dbflute.cbean.*;

/**
 * The behavior of (会員セキュリティ情報)MEMBER_SECURITY as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_ID
 *
 * [column]
 *     MEMBER_ID, LOGIN_PASSWORD, REMINDER_QUESTION, REMINDER_ANSWER, REMINDER_USE_COUNT, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     MEMBER
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     member
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberSecurityBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "MEMBER_SECURITY"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return MemberSecurityDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberSecurityDbm getMyDBMeta() { return MemberSecurityDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public MemberSecurity newMyEntity() { return new MemberSecurity(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberSecurityCB newMyConditionBean() { return new MemberSecurityCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * int count = memberSecurityBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberSecurityCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberSecurityCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberSecurityCB cb) { // called by selectPage(cb)
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
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * MemberSecurity memberSecurity = memberSecurityBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (memberSecurity != null) {
     *     ... = memberSecurity.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberSecurity selectEntity(MemberSecurityCB cb) {
        return doSelectEntity(cb, MemberSecurity.class);
    }

    protected <ENTITY extends MemberSecurity> ENTITY doSelectEntity(MemberSecurityCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, MemberSecurityCB>() {
            public List<ENTITY> callbackSelectList(MemberSecurityCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * MemberSecurity memberSecurity = memberSecurityBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberSecurity.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberSecurity selectEntityWithDeletedCheck(MemberSecurityCB cb) {
        return doSelectEntityWithDeletedCheck(cb, MemberSecurity.class);
    }

    protected <ENTITY extends MemberSecurity> ENTITY doSelectEntityWithDeletedCheck(MemberSecurityCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberSecurityCB>() {
            public List<ENTITY> callbackSelectList(MemberSecurityCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param memberId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberSecurity selectByPKValue(Integer memberId) {
        return doSelectByPKValue(memberId, MemberSecurity.class);
    }

    protected <ENTITY extends MemberSecurity> ENTITY doSelectByPKValue(Integer memberId, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(memberId), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param memberId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberSecurity selectByPKValueWithDeletedCheck(Integer memberId) {
        return doSelectByPKValueWithDeletedCheck(memberId, MemberSecurity.class);
    }

    protected <ENTITY extends MemberSecurity> ENTITY doSelectByPKValueWithDeletedCheck(Integer memberId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(memberId), entityType);
    }

    private MemberSecurityCB buildPKCB(Integer memberId) {
        assertObjectNotNull("memberId", memberId);
        MemberSecurityCB cb = newMyConditionBean();
        cb.query().setMemberId_Equal(memberId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;MemberSecurity&gt; memberSecurityList = memberSecurityBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (MemberSecurity memberSecurity : memberSecurityList) {
     *     ... = memberSecurity.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberSecurity> selectList(MemberSecurityCB cb) {
        return doSelectList(cb, MemberSecurity.class);
    }

    protected <ENTITY extends MemberSecurity> ListResultBean<ENTITY> doSelectList(MemberSecurityCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, MemberSecurityCB>() {
            public List<ENTITY> callbackSelectList(MemberSecurityCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberSecurity&gt; page = memberSecurityBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (MemberSecurity memberSecurity : page) {
     *     ... = memberSecurity.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberSecurity> selectPage(MemberSecurityCB cb) {
        return doSelectPage(cb, MemberSecurity.class);
    }

    protected <ENTITY extends MemberSecurity> PagingResultBean<ENTITY> doSelectPage(MemberSecurityCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, MemberSecurityCB>() {
            public int callbackSelectCount(MemberSecurityCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberSecurityCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * memberSecurityBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberSecurity&gt;() {
     *     public void handle(MemberSecurity entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberSecurity. (NotNull)
     */
    public void selectCursor(MemberSecurityCB cb, EntityRowHandler<MemberSecurity> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, MemberSecurity.class);
    }

    protected <ENTITY extends MemberSecurity> void doSelectCursor(MemberSecurityCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, MemberSecurityCB>() {
            public void callbackSelectCursor(MemberSecurityCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(MemberSecurityCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberSecurityBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberSecurityCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<MemberSecurityCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends MemberSecurityCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends MemberSecurityCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
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
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Member'.
     * @param memberSecurityList The list of memberSecurity. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMember(List<MemberSecurity> memberSecurityList) {
        return helpPulloutInternally(memberSecurityList, new InternalPulloutCallback<MemberSecurity, Member>() {
            public Member getFr(MemberSecurity et) { return et.getMember(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member et, List<MemberSecurity> ls)
            { if (!ls.isEmpty()) { et.setMemberSecurityAsOne(ls.get(0)); } }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberId.
     * @param memberSecurityList The list of memberSecurity. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractMemberIdList(List<MemberSecurity> memberSecurityList) {
        return helpExtractListInternally(memberSecurityList, new InternalExtractCallback<MemberSecurity, Integer>() {
            public Integer getCV(MemberSecurity et) { return et.getMemberId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * MemberSecurity memberSecurity = new MemberSecurity();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberSecurity.setFoo...(value);
     * memberSecurity.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberSecurity.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberSecurity.set...;</span>
     * memberSecurityBhv.<span style="color: #FD4747">insert</span>(memberSecurity);
     * ... = memberSecurity.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberSecurity The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberSecurity memberSecurity) {
        doInsert(memberSecurity, null);
    }

    protected void doInsert(MemberSecurity memberSecurity, InsertOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurity", memberSecurity);
        prepareInsertOption(op);
        delegateInsert(memberSecurity, op);
    }

    protected void prepareInsertOption(InsertOption<MemberSecurityCB> op) {
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
     * Update the entity modified-only. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * MemberSecurity memberSecurity = new MemberSecurity();
     * memberSecurity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberSecurity.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberSecurity.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberSecurity.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberSecurity.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberSecurityBhv.<span style="color: #FD4747">update</span>(memberSecurity);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberSecurity The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final MemberSecurity memberSecurity) {
        doUpdate(memberSecurity, null);
    }

    protected void doUpdate(MemberSecurity memberSecurity, final UpdateOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurity", memberSecurity);
        prepareUpdateOption(op);
        helpUpdateInternally(memberSecurity, new InternalUpdateCallback<MemberSecurity>() {
            public int callbackDelegateUpdate(MemberSecurity et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberSecurityCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected MemberSecurityCB createCBForVaryingUpdate() {
        MemberSecurityCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected MemberSecurityCB createCBForSpecifiedUpdate() {
        MemberSecurityCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { update(downcast(et)); }
        else { varyingUpdate(downcast(et), downcast(op)); }
    }

    /**
     * Update the entity non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * MemberSecurity memberSecurity = new MemberSecurity();
     * memberSecurity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberSecurity.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberSecurity.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberSecurity.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberSecurity.setVersionNo(value);</span>
     * memberSecurityBhv.<span style="color: #FD4747">updateNonstrict</span>(memberSecurity);
     * </pre>
     * @param memberSecurity The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(final MemberSecurity memberSecurity) {
        doUpdateNonstrict(memberSecurity, null);
    }

    protected void doUpdateNonstrict(MemberSecurity memberSecurity, final UpdateOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurity", memberSecurity);
        prepareUpdateOption(op);
        helpUpdateNonstrictInternally(memberSecurity, new InternalUpdateNonstrictCallback<MemberSecurity>() {
            public int callbackDelegateUpdateNonstrict(MemberSecurity et) { return delegateUpdateNonstrict(et, op); } });
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { updateNonstrict(downcast(et)); }
        else { varyingUpdateNonstrict(downcast(et), downcast(op)); }
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, ExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberSecurity The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberSecurity memberSecurity) {
        doInesrtOrUpdate(memberSecurity, null, null);
    }

    protected void doInesrtOrUpdate(MemberSecurity memberSecurity, final InsertOption<MemberSecurityCB> iop, final UpdateOption<MemberSecurityCB> uop) {
        helpInsertOrUpdateInternally(memberSecurity, new InternalInsertOrUpdateCallback<MemberSecurity, MemberSecurityCB>() {
            public void callbackInsert(MemberSecurity et) { doInsert(et, iop); }
            public void callbackUpdate(MemberSecurity et) { doUpdate(et, uop); }
            public MemberSecurityCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(MemberSecurityCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<MemberSecurityCB>();
            uop = uop != null ? uop : new UpdateOption<MemberSecurityCB>();
            varyingInsertOrUpdate(downcast(et), downcast(iop), downcast(uop));
        }
    }

    /**
     * Insert or update the entity non-strictly modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() }
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberSecurity The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(MemberSecurity memberSecurity) {
        doInesrtOrUpdateNonstrict(memberSecurity, null, null);
    }

    protected void doInesrtOrUpdateNonstrict(MemberSecurity memberSecurity, final InsertOption<MemberSecurityCB> iop, final UpdateOption<MemberSecurityCB> uop) {
        helpInsertOrUpdateInternally(memberSecurity, new InternalInsertOrUpdateNonstrictCallback<MemberSecurity>() {
            public void callbackInsert(MemberSecurity et) { doInsert(et, iop); }
            public void callbackUpdateNonstrict(MemberSecurity et) { doUpdateNonstrict(et, uop); }
        });
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdateNonstrict(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<MemberSecurityCB>();
            uop = uop != null ? uop : new UpdateOption<MemberSecurityCB>();
            varyingInsertOrUpdateNonstrict(downcast(et), downcast(iop), downcast(uop));
        }
    }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * MemberSecurity memberSecurity = new MemberSecurity();
     * memberSecurity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberSecurity.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberSecurityBhv.<span style="color: #FD4747">delete</span>(memberSecurity);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberSecurity The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberSecurity memberSecurity) {
        doDelete(memberSecurity, null);
    }

    protected void doDelete(MemberSecurity memberSecurity, final DeleteOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurity", memberSecurity);
        prepareDeleteOption(op);
        helpDeleteInternally(memberSecurity, new InternalDeleteCallback<MemberSecurity>() {
            public int callbackDelegateDelete(MemberSecurity et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberSecurityCB> op) {
        if (op == null) { return; }
        assertDeleteOptionStatus(op);
    }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { delete(downcast(et)); }
        else { varyingDelete(downcast(et), downcast(op)); }
    }

    /**
     * Delete the entity non-strictly. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * MemberSecurity memberSecurity = new MemberSecurity();
     * memberSecurity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberSecurity.setVersionNo(value);</span>
     * memberSecurityBhv.<span style="color: #FD4747">deleteNonstrict</span>(memberSecurity);
     * </pre>
     * @param memberSecurity The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(MemberSecurity memberSecurity) {
        doDeleteNonstrict(memberSecurity, null);
    }

    protected void doDeleteNonstrict(MemberSecurity memberSecurity, final DeleteOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurity", memberSecurity);
        prepareDeleteOption(op);
        helpDeleteNonstrictInternally(memberSecurity, new InternalDeleteNonstrictCallback<MemberSecurity>() {
            public int callbackDelegateDeleteNonstrict(MemberSecurity et) { return delegateDeleteNonstrict(et, op); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * MemberSecurity memberSecurity = new MemberSecurity();
     * memberSecurity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberSecurity.setVersionNo(value);</span>
     * memberSecurityBhv.<span style="color: #FD4747">deleteNonstrictIgnoreDeleted</span>(memberSecurity);
     * <span style="color: #3F7E5E">// if the target entity doesn't exist, no exception</span>
     * </pre>
     * @param memberSecurity The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(MemberSecurity memberSecurity) {
        doDeleteNonstrictIgnoreDeleted(memberSecurity, null);
    }

    protected void doDeleteNonstrictIgnoreDeleted(MemberSecurity memberSecurity, final DeleteOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurity", memberSecurity);
        prepareDeleteOption(op);
        helpDeleteNonstrictIgnoreDeletedInternally(memberSecurity, new InternalDeleteNonstrictIgnoreDeletedCallback<MemberSecurity>() {
            public int callbackDelegateDeleteNonstrict(MemberSecurity et) { return delegateDeleteNonstrict(et, op); } });
    }

    @Override
    protected void doRemoveNonstrict(Entity et, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { deleteNonstrict(downcast(et)); }
        else { varyingDeleteNonstrict(downcast(et), downcast(op)); }
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
     *     MemberSecurity memberSecurity = new MemberSecurity();
     *     memberSecurity.setFooName("foo");
     *     if (...) {
     *         memberSecurity.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberSecurityList.add(memberSecurity);
     * }
     * memberSecurityBhv.<span style="color: #FD4747">batchInsert</span>(memberSecurityList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberSecurity> memberSecurityList) {
        InsertOption<MemberSecurityCB> op = createInsertUpdateOption();
        return doBatchInsert(memberSecurityList, op);
    }

    protected int[] doBatchInsert(List<MemberSecurity> memberSecurityList, InsertOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurityList", memberSecurityList);
        prepareBatchInsertOption(memberSecurityList, op);
        return delegateBatchInsert(memberSecurityList, op);
    }

    protected void prepareBatchInsertOption(List<MemberSecurity> memberSecurityList, InsertOption<MemberSecurityCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(memberSecurityList);
        prepareInsertOption(op);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) {
        if (op == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     MemberSecurity memberSecurity = new MemberSecurity();
     *     memberSecurity.setFooName("foo");
     *     if (...) {
     *         memberSecurity.setFooPrice(123);
     *     } else {
     *         memberSecurity.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberSecurity.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberSecurityList.add(memberSecurity);
     * }
     * memberSecurityBhv.<span style="color: #FD4747">batchUpdate</span>(memberSecurityList);
     * </pre>
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<MemberSecurity> memberSecurityList) {
        UpdateOption<MemberSecurityCB> op = createPlainUpdateOption();
        return doBatchUpdate(memberSecurityList, op);
    }

    protected int[] doBatchUpdate(List<MemberSecurity> memberSecurityList, UpdateOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurityList", memberSecurityList);
        prepareBatchUpdateOption(memberSecurityList, op);
        return delegateBatchUpdate(memberSecurityList, op);
    }

    protected void prepareBatchUpdateOption(List<MemberSecurity> memberSecurityList, UpdateOption<MemberSecurityCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(memberSecurityList);
        prepareUpdateOption(op);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list specified-only. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * memberSecurityBhv.<span style="color: #FD4747">batchUpdate</span>(memberSecurityList, new SpecifyQuery<MemberSecurityCB>() {
     *     public void specify(MemberSecurityCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * memberSecurityBhv.<span style="color: #FD4747">batchUpdate</span>(memberSecurityList, new SpecifyQuery<MemberSecurityCB>() {
     *     public void specify(MemberSecurityCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<MemberSecurity> memberSecurityList, SpecifyQuery<MemberSecurityCB> updateColumnSpec) {
        return doBatchUpdate(memberSecurityList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 140%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     MemberSecurity memberSecurity = new MemberSecurity();
     *     memberSecurity.setFooName("foo");
     *     if (...) {
     *         memberSecurity.setFooPrice(123);
     *     } else {
     *         memberSecurity.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberSecurity.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberSecurityList.add(memberSecurity);
     * }
     * memberSecurityBhv.<span style="color: #FD4747">batchUpdate</span>(memberSecurityList);
     * </pre>
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<MemberSecurity> memberSecurityList) {
        UpdateOption<MemberSecurityCB> option = createPlainUpdateOption();
        return doBatchUpdateNonstrict(memberSecurityList, option);
    }

    protected int[] doBatchUpdateNonstrict(List<MemberSecurity> memberSecurityList, UpdateOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurityList", memberSecurityList);
        prepareBatchUpdateOption(memberSecurityList, op);
        return delegateBatchUpdateNonstrict(memberSecurityList, op);
    }

    /**
     * Batch-update the entity list non-strictly specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * memberSecurityBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(memberSecurityList, new SpecifyQuery<MemberSecurityCB>() {
     *     public void specify(MemberSecurityCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * memberSecurityBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(memberSecurityList, new SpecifyQuery<MemberSecurityCB>() {
     *     public void specify(MemberSecurityCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).</p>
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<MemberSecurity> memberSecurityList, SpecifyQuery<MemberSecurityCB> updateColumnSpec) {
        return doBatchUpdateNonstrict(memberSecurityList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return batchUpdateNonstrict(downcast(ls)); }
        else { return varyingBatchUpdateNonstrict(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(List<MemberSecurity> memberSecurityList) {
        return doBatchDelete(memberSecurityList, null);
    }

    protected int[] doBatchDelete(List<MemberSecurity> memberSecurityList, DeleteOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurityList", memberSecurityList);
        prepareDeleteOption(op);
        return delegateBatchDelete(memberSecurityList, op);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-delete the entity list non-strictly. {NonExclusiveControl} <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(List<MemberSecurity> memberSecurityList) {
        return doBatchDeleteNonstrict(memberSecurityList, null);
    }

    protected int[] doBatchDeleteNonstrict(List<MemberSecurity> memberSecurityList, DeleteOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurityList", memberSecurityList);
        prepareDeleteOption(op);
        return delegateBatchDeleteNonstrict(memberSecurityList, op);
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return batchDeleteNonstrict(downcast(ls)); }
        else { return varyingBatchDeleteNonstrict(downcast(ls), downcast(op)); }
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * memberSecurityBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberSecurity, MemberSecurityCB&gt;() {
     *     public ConditionBean setup(memberSecurity entity, MemberSecurityCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<MemberSecurity, MemberSecurityCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberSecurity, MemberSecurityCB> sp, InsertOption<MemberSecurityCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        MemberSecurity e = new MemberSecurity();
        MemberSecurityCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected MemberSecurityCB createCBForQueryInsert() {
        MemberSecurityCB cb = newMyConditionBean();
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
     * MemberSecurity memberSecurity = new MemberSecurity();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberSecurity.setPK...(value);</span>
     * memberSecurity.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberSecurity.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberSecurity.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberSecurity.setVersionNo(value);</span>
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * memberSecurityBhv.<span style="color: #FD4747">queryUpdate</span>(memberSecurity, cb);
     * </pre>
     * @param memberSecurity The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberSecurity memberSecurity, MemberSecurityCB cb) {
        return doQueryUpdate(memberSecurity, cb, null);
    }

    protected int doQueryUpdate(MemberSecurity memberSecurity, MemberSecurityCB cb, UpdateOption<MemberSecurityCB> op) {
        assertObjectNotNull("memberSecurity", memberSecurity); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(memberSecurity, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (MemberSecurityCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (MemberSecurityCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * memberSecurityBhv.<span style="color: #FD4747">queryDelete</span>(memberSecurity, cb);
     * </pre>
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberSecurityCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberSecurityCB cb, DeleteOption<MemberSecurityCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((MemberSecurityCB)cb); }
        else { return varyingQueryDelete((MemberSecurityCB)cb, downcast(op)); }
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
     * MemberSecurity memberSecurity = new MemberSecurity();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberSecurity.setFoo...(value);
     * memberSecurity.setBar...(value);
     * InsertOption<MemberSecurityCB> option = new InsertOption<MemberSecurityCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberSecurityBhv.<span style="color: #FD4747">varyingInsert</span>(memberSecurity, option);
     * ... = memberSecurity.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberSecurity The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(MemberSecurity memberSecurity, InsertOption<MemberSecurityCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(memberSecurity, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, ExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * MemberSecurity memberSecurity = new MemberSecurity();
     * memberSecurity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberSecurity.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberSecurity.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberSecurityCB&gt; option = new UpdateOption&lt;MemberSecurityCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberSecurityCB&gt;() {
     *         public void specify(MemberSecurityCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberSecurityBhv.<span style="color: #FD4747">varyingUpdate</span>(memberSecurity, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberSecurity The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(MemberSecurity memberSecurity, UpdateOption<MemberSecurityCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(memberSecurity, option);
    }

    /**
     * Update the entity with varying requests non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as updateNonstrict(entity).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * MemberSecurity memberSecurity = new MemberSecurity();
     * memberSecurity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberSecurity.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberSecurity.setVersionNo(value);</span>
     * UpdateOption&lt;MemberSecurityCB&gt; option = new UpdateOption&lt;MemberSecurityCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberSecurityCB&gt;() {
     *     public void specify(MemberSecurityCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberSecurityBhv.<span style="color: #FD4747">varyingUpdateNonstrict</span>(memberSecurity, option);
     * </pre>
     * @param memberSecurity The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(MemberSecurity memberSecurity, UpdateOption<MemberSecurityCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(memberSecurity, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberSecurity The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberSecurity memberSecurity, InsertOption<MemberSecurityCB> insertOption, UpdateOption<MemberSecurityCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(memberSecurity, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param memberSecurity The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(MemberSecurity memberSecurity, InsertOption<MemberSecurityCB> insertOption, UpdateOption<MemberSecurityCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdateNonstrict(memberSecurity, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberSecurity The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberSecurity memberSecurity, DeleteOption<MemberSecurityCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberSecurity, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param memberSecurity The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDeleteNonstrict(MemberSecurity memberSecurity, DeleteOption<MemberSecurityCB> option) {
        assertDeleteOptionNotNull(option);
        doDeleteNonstrict(memberSecurity, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<MemberSecurity> memberSecurityList, InsertOption<MemberSecurityCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberSecurityList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<MemberSecurity> memberSecurityList, UpdateOption<MemberSecurityCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberSecurityList, option);
    }

    /**
     * Batch-update the list with varying requests non-strictly. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdateNonstrict(List<MemberSecurity> memberSecurityList, UpdateOption<MemberSecurityCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdateNonstrict(memberSecurityList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<MemberSecurity> memberSecurityList, DeleteOption<MemberSecurityCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberSecurityList, option);
    }

    /**
     * Batch-delete the list with varying requests non-strictly. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDeleteNonstrict(entityList).
     * @param memberSecurityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDeleteNonstrict(List<MemberSecurity> memberSecurityList, DeleteOption<MemberSecurityCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDeleteNonstrict(memberSecurityList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<MemberSecurity, MemberSecurityCB> setupper, InsertOption<MemberSecurityCB> option) {
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
     * MemberSecurity memberSecurity = new MemberSecurity();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberSecurity.setPK...(value);</span>
     * memberSecurity.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberSecurity.setVersionNo(value);</span>
     * MemberSecurityCB cb = new MemberSecurityCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberSecurityCB&gt; option = new UpdateOption&lt;MemberSecurityCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberSecurityCB&gt;() {
     *     public void specify(MemberSecurityCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberSecurityBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(memberSecurity, cb, option);
     * </pre>
     * @param memberSecurity The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(MemberSecurity memberSecurity, MemberSecurityCB cb, UpdateOption<MemberSecurityCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(memberSecurity, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of MemberSecurity. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberSecurityCB cb, DeleteOption<MemberSecurityCB> option) {
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
    public OutsideSqlBasicExecutor<MemberSecurityBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(MemberSecurityCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(MemberSecurityCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends MemberSecurity> void delegateSelectCursor(MemberSecurityCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends MemberSecurity> List<ENTITY> delegateSelectList(MemberSecurityCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(MemberSecurity et, InsertOption<MemberSecurityCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(MemberSecurity et, UpdateOption<MemberSecurityCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateEntityCommand(et, op)); }
    protected int delegateUpdateNonstrict(MemberSecurity et, UpdateOption<MemberSecurityCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(MemberSecurity et, DeleteOption<MemberSecurityCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteEntityCommand(et, op)); }
    protected int delegateDeleteNonstrict(MemberSecurity et, DeleteOption<MemberSecurityCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<MemberSecurity> ls, InsertOption<MemberSecurityCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<MemberSecurity> ls, UpdateOption<MemberSecurityCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchUpdateNonstrict(List<MemberSecurity> ls, UpdateOption<MemberSecurityCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<MemberSecurity> ls, DeleteOption<MemberSecurityCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchDeleteNonstrict(List<MemberSecurity> ls, DeleteOption<MemberSecurityCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(MemberSecurity et, MemberSecurityCB inCB, ConditionBean resCB, InsertOption<MemberSecurityCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(MemberSecurity et, MemberSecurityCB cb, UpdateOption<MemberSecurityCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(MemberSecurityCB cb, DeleteOption<MemberSecurityCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity et) {
        return !(downcast(et).getVersionNo() + "").equals("null");// For primitive type
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
    protected MemberSecurity downcast(Entity et) {
        return helpEntityDowncastInternally(et, MemberSecurity.class);
    }

    protected MemberSecurityCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, MemberSecurityCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<MemberSecurity> downcast(List<? extends Entity> ls) {
        return (List<MemberSecurity>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberSecurityCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<MemberSecurityCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberSecurityCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<MemberSecurityCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberSecurityCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<MemberSecurityCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberSecurity, MemberSecurityCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<MemberSecurity, MemberSecurityCB>)sp;
    }
}
