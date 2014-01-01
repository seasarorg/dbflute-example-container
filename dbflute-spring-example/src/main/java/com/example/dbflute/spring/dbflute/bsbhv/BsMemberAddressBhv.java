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
 * The behavior of (会員住所情報)MEMBER_ADDRESS as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_ADDRESS_ID
 * 
 * [column]
 *     MEMBER_ADDRESS_ID, MEMBER_ID, VALID_BEGIN_DATE, VALID_END_DATE, ADDRESS, REGION_ID, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ADDRESS_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign table]
 *     MEMBER, REGION
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     member, region
 * 
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberAddressBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "MEMBER_ADDRESS"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return MemberAddressDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberAddressDbm getMyDBMeta() { return MemberAddressDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public MemberAddress newMyEntity() { return new MemberAddress(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberAddressCB newMyConditionBean() { return new MemberAddressCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * int count = memberAddressBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberAddressCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberAddressCB cb) { // called by selectCount(cb) 
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberAddressCB cb) { // called by selectPage(cb)
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
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * MemberAddress memberAddress = memberAddressBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (memberAddress != null) {
     *     ... = memberAddress.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberAddress selectEntity(MemberAddressCB cb) {
        return doSelectEntity(cb, MemberAddress.class);
    }

    protected <ENTITY extends MemberAddress> ENTITY doSelectEntity(final MemberAddressCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType, new InternalSelectEntityCallback<ENTITY, MemberAddressCB>() {
            public List<ENTITY> callbackSelectList(MemberAddressCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * MemberAddress memberAddress = memberAddressBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberAddress.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberAddress selectEntityWithDeletedCheck(MemberAddressCB cb) {
        return doSelectEntityWithDeletedCheck(cb, MemberAddress.class);
    }

    protected <ENTITY extends MemberAddress> ENTITY doSelectEntityWithDeletedCheck(final MemberAddressCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(cb, entityType, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberAddressCB>() {
            public List<ENTITY> callbackSelectList(MemberAddressCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param memberAddressId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberAddress selectByPKValue(Integer memberAddressId) {
        return doSelectByPKValue(memberAddressId, MemberAddress.class);
    }

    protected <ENTITY extends MemberAddress> ENTITY doSelectByPKValue(Integer memberAddressId, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(memberAddressId), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param memberAddressId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberAddress selectByPKValueWithDeletedCheck(Integer memberAddressId) {
        return doSelectByPKValueWithDeletedCheck(memberAddressId, MemberAddress.class);
    }

    protected <ENTITY extends MemberAddress> ENTITY doSelectByPKValueWithDeletedCheck(Integer memberAddressId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(memberAddressId), entityType);
    }

    private MemberAddressCB buildPKCB(Integer memberAddressId) {
        assertObjectNotNull("memberAddressId", memberAddressId);
        MemberAddressCB cb = newMyConditionBean();
        cb.query().setMemberAddressId_Equal(memberAddressId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;MemberAddress&gt; memberAddressList = memberAddressBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (MemberAddress memberAddress : memberAddressList) {
     *     ... = memberAddress.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberAddress> selectList(MemberAddressCB cb) {
        return doSelectList(cb, MemberAddress.class);
    }

    protected <ENTITY extends MemberAddress> ListResultBean<ENTITY> doSelectList(MemberAddressCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType, new InternalSelectListCallback<ENTITY, MemberAddressCB>() {
            public List<ENTITY> callbackSelectList(MemberAddressCB cb, Class<ENTITY> entityType) { return delegateSelectList(cb, entityType); } });
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
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberAddress&gt; page = memberAddressBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (MemberAddress memberAddress : page) {
     *     ... = memberAddress.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberAddress> selectPage(MemberAddressCB cb) {
        return doSelectPage(cb, MemberAddress.class);
    }

    protected <ENTITY extends MemberAddress> PagingResultBean<ENTITY> doSelectPage(MemberAddressCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType, new InternalSelectPageCallback<ENTITY, MemberAddressCB>() {
            public int callbackSelectCount(MemberAddressCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberAddressCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
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
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * memberAddressBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberAddress&gt;() {
     *     public void handle(MemberAddress entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberAddress. (NotNull)
     */
    public void selectCursor(MemberAddressCB cb, EntityRowHandler<MemberAddress> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, MemberAddress.class);
    }

    protected <ENTITY extends MemberAddress> void doSelectCursor(MemberAddressCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler<MemberAddress>", entityRowHandler); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType, new InternalSelectCursorCallback<ENTITY, MemberAddressCB>() {
            public void callbackSelectCursor(MemberAddressCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) { delegateSelectCursor(cb, entityRowHandler, entityType); }
            public List<ENTITY> callbackSelectList(MemberAddressCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberAddressBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberAddressCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<MemberAddressCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends MemberAddressCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> resultType, CB cb) {
        assertObjectNotNull("resultType", resultType); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, resultType);
    }

    protected <RESULT, CB extends MemberAddressCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> resultType) {
        return new SLFunction<CB, RESULT>(cb, resultType);
    }

    protected <RESULT> SLFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
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
     * @param memberAddressList The list of memberAddress. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMember(List<MemberAddress> memberAddressList) {
        return helpPulloutInternally(memberAddressList, new InternalPulloutCallback<MemberAddress, Member>() {
            public Member getFr(MemberAddress e) { return e.getMember(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member e, List<MemberAddress> ls)
            { e.setMemberAddressList(ls); }
        });
    }
    /**
     * Pull out the list of foreign table 'Region'.
     * @param memberAddressList The list of memberAddress. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Region> pulloutRegion(List<MemberAddress> memberAddressList) {
        return helpPulloutInternally(memberAddressList, new InternalPulloutCallback<MemberAddress, Region>() {
            public Region getFr(MemberAddress e) { return e.getRegion(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Region e, List<MemberAddress> ls)
            { e.setMemberAddressList(ls); }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberAddressId.
     * @param memberAddressList The list of memberAddress. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractMemberAddressIdList(List<MemberAddress> memberAddressList) {
        return helpExtractListInternally(memberAddressList, new InternalExtractCallback<MemberAddress, Integer>() {
            public Integer getCV(MemberAddress e) { return e.getMemberAddressId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * MemberAddress memberAddress = new MemberAddress();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberAddress.setFoo...(value);
     * memberAddress.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberAddress.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberAddress.set...;</span>
     * memberAddressBhv.<span style="color: #FD4747">insert</span>(memberAddress);
     * ... = memberAddress.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberAddress The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberAddress memberAddress) {
        doInsert(memberAddress, null);
    }

    protected void doInsert(MemberAddress memberAddress, InsertOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddress", memberAddress);
        prepareInsertOption(option);
        delegateInsert(memberAddress, option);
    }

    protected void prepareInsertOption(InsertOption<MemberAddressCB> option) {
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
     * MemberAddress memberAddress = new MemberAddress();
     * memberAddress.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberAddress.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberAddress.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberAddress.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberAddress.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberAddressBhv.<span style="color: #FD4747">update</span>(memberAddress);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param memberAddress The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final MemberAddress memberAddress) {
        doUpdate(memberAddress, null);
    }

    protected void doUpdate(MemberAddress memberAddress, final UpdateOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddress", memberAddress);
        prepareUpdateOption(option);
        helpUpdateInternally(memberAddress, new InternalUpdateCallback<MemberAddress>() {
            public int callbackDelegateUpdate(MemberAddress entity) { return delegateUpdate(entity, option); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberAddressCB> option) {
        if (option == null) { return; }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected MemberAddressCB createCBForVaryingUpdate() {
        MemberAddressCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected MemberAddressCB createCBForSpecifiedUpdate() {
        MemberAddressCB cb = newMyConditionBean();
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
     * MemberAddress memberAddress = new MemberAddress();
     * memberAddress.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberAddress.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberAddress.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberAddress.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberAddress.setVersionNo(value);</span>
     * memberAddressBhv.<span style="color: #FD4747">updateNonstrict</span>(memberAddress);
     * </pre>
     * @param memberAddress The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(final MemberAddress memberAddress) {
        doUpdateNonstrict(memberAddress, null);
    }

    protected void doUpdateNonstrict(MemberAddress memberAddress, final UpdateOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddress", memberAddress);
        prepareUpdateOption(option);
        helpUpdateNonstrictInternally(memberAddress, new InternalUpdateNonstrictCallback<MemberAddress>() {
            public int callbackDelegateUpdateNonstrict(MemberAddress entity) { return delegateUpdateNonstrict(entity, option); } });
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
     * @param memberAddress The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberAddress memberAddress) {
        doInesrtOrUpdate(memberAddress, null, null);
    }

    protected void doInesrtOrUpdate(MemberAddress memberAddress, final InsertOption<MemberAddressCB> insertOption, final UpdateOption<MemberAddressCB> updateOption) {
        helpInsertOrUpdateInternally(memberAddress, new InternalInsertOrUpdateCallback<MemberAddress, MemberAddressCB>() {
            public void callbackInsert(MemberAddress entity) { doInsert(entity, insertOption); }
            public void callbackUpdate(MemberAddress entity) { doUpdate(entity, updateOption); }
            public MemberAddressCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(MemberAddressCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdate(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<MemberAddressCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<MemberAddressCB>() : updateOption;
            varyingInsertOrUpdate(downcast(entity), downcast(insertOption), downcast(updateOption));
        }
    }

    /**
     * Insert or update the entity non-strictly modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() }
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberAddress The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(MemberAddress memberAddress) {
        doInesrtOrUpdateNonstrict(memberAddress, null, null);
    }

    protected void doInesrtOrUpdateNonstrict(MemberAddress memberAddress, final InsertOption<MemberAddressCB> insertOption, final UpdateOption<MemberAddressCB> updateOption) {
        helpInsertOrUpdateInternally(memberAddress, new InternalInsertOrUpdateNonstrictCallback<MemberAddress>() {
            public void callbackInsert(MemberAddress entity) { doInsert(entity, insertOption); }
            public void callbackUpdateNonstrict(MemberAddress entity) { doUpdateNonstrict(entity, updateOption); }
        });
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdateNonstrict(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<MemberAddressCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<MemberAddressCB>() : updateOption;
            varyingInsertOrUpdateNonstrict(downcast(entity), downcast(insertOption), downcast(updateOption));
        }
    }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * MemberAddress memberAddress = new MemberAddress();
     * memberAddress.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberAddress.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberAddressBhv.<span style="color: #FD4747">delete</span>(memberAddress);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param memberAddress The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberAddress memberAddress) {
        doDelete(memberAddress, null);
    }

    protected void doDelete(MemberAddress memberAddress, final DeleteOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddress", memberAddress);
        prepareDeleteOption(option);
        helpDeleteInternally(memberAddress, new InternalDeleteCallback<MemberAddress>() {
            public int callbackDelegateDelete(MemberAddress entity) { return delegateDelete(entity, option); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberAddressCB> option) {
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
     * MemberAddress memberAddress = new MemberAddress();
     * memberAddress.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberAddress.setVersionNo(value);</span>
     * memberAddressBhv.<span style="color: #FD4747">deleteNonstrict</span>(memberAddress);
     * </pre>
     * @param memberAddress The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(MemberAddress memberAddress) {
        doDeleteNonstrict(memberAddress, null);
    }

    protected void doDeleteNonstrict(MemberAddress memberAddress, final DeleteOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddress", memberAddress);
        prepareDeleteOption(option);
        helpDeleteNonstrictInternally(memberAddress, new InternalDeleteNonstrictCallback<MemberAddress>() {
            public int callbackDelegateDeleteNonstrict(MemberAddress entity) { return delegateDeleteNonstrict(entity, option); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * MemberAddress memberAddress = new MemberAddress();
     * memberAddress.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberAddress.setVersionNo(value);</span>
     * memberAddressBhv.<span style="color: #FD4747">deleteNonstrictIgnoreDeleted</span>(memberAddress);
     * <span style="color: #3F7E5E">// if the target entity doesn't exist, no exception</span>
     * </pre>
     * @param memberAddress The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(MemberAddress memberAddress) {
        doDeleteNonstrictIgnoreDeleted(memberAddress, null);
    }

    protected void doDeleteNonstrictIgnoreDeleted(MemberAddress memberAddress, final DeleteOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddress", memberAddress);
        prepareDeleteOption(option);
        helpDeleteNonstrictIgnoreDeletedInternally(memberAddress, new InternalDeleteNonstrictIgnoreDeletedCallback<MemberAddress>() {
            public int callbackDelegateDeleteNonstrict(MemberAddress entity) { return delegateDeleteNonstrict(entity, option); } });
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
     *     MemberAddress memberAddress = new MemberAddress();
     *     memberAddress.setFooName("foo");
     *     if (...) {
     *         memberAddress.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberAddressList.add(memberAddress);
     * }
     * memberAddressBhv.<span style="color: #FD4747">batchInsert</span>(memberAddressList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberAddress> memberAddressList) {
        InsertOption<MemberAddressCB> option = createInsertUpdateOption();
        return doBatchInsert(memberAddressList, option);
    }

    protected int[] doBatchInsert(List<MemberAddress> memberAddressList, InsertOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddressList", memberAddressList);
        prepareBatchInsertOption(memberAddressList, option);
        return delegateBatchInsert(memberAddressList, option);
    }

    protected void prepareBatchInsertOption(List<MemberAddress> memberAddressList, InsertOption<MemberAddressCB> option) {
        option.xallowInsertColumnModifiedPropertiesFragmented();
        option.xacceptInsertColumnModifiedPropertiesIfNeeds(memberAddressList);
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
     *     MemberAddress memberAddress = new MemberAddress();
     *     memberAddress.setFooName("foo");
     *     if (...) {
     *         memberAddress.setFooPrice(123);
     *     } else {
     *         memberAddress.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberAddress.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberAddressList.add(memberAddress);
     * }
     * memberAddressBhv.<span style="color: #FD4747">batchUpdate</span>(memberAddressList);
     * </pre>
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<MemberAddress> memberAddressList) {
        UpdateOption<MemberAddressCB> option = createPlainUpdateOption();
        return doBatchUpdate(memberAddressList, option);
    }

    protected int[] doBatchUpdate(List<MemberAddress> memberAddressList, UpdateOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddressList", memberAddressList);
        prepareBatchUpdateOption(memberAddressList, option);
        return delegateBatchUpdate(memberAddressList, option);
    }

    protected void prepareBatchUpdateOption(List<MemberAddress> memberAddressList, UpdateOption<MemberAddressCB> option) {
        option.xacceptUpdateColumnModifiedPropertiesIfNeeds(memberAddressList);
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
     * memberAddressBhv.<span style="color: #FD4747">batchUpdate</span>(memberAddressList, new SpecifyQuery<MemberAddressCB>() {
     *     public void specify(MemberAddressCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * memberAddressBhv.<span style="color: #FD4747">batchUpdate</span>(memberAddressList, new SpecifyQuery<MemberAddressCB>() {
     *     public void specify(MemberAddressCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<MemberAddress> memberAddressList, SpecifyQuery<MemberAddressCB> updateColumnSpec) {
        return doBatchUpdate(memberAddressList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 140%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     MemberAddress memberAddress = new MemberAddress();
     *     memberAddress.setFooName("foo");
     *     if (...) {
     *         memberAddress.setFooPrice(123);
     *     } else {
     *         memberAddress.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberAddress.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberAddressList.add(memberAddress);
     * }
     * memberAddressBhv.<span style="color: #FD4747">batchUpdate</span>(memberAddressList);
     * </pre>
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<MemberAddress> memberAddressList) {
        UpdateOption<MemberAddressCB> option = createPlainUpdateOption();
        return doBatchUpdateNonstrict(memberAddressList, option);
    }

    protected int[] doBatchUpdateNonstrict(List<MemberAddress> memberAddressList, UpdateOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddressList", memberAddressList);
        prepareBatchUpdateOption(memberAddressList, option);
        return delegateBatchUpdateNonstrict(memberAddressList, option);
    }

    /**
     * Batch-update the entity list non-strictly specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span> 
     * memberAddressBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(memberAddressList, new SpecifyQuery<MemberAddressCB>() {
     *     public void specify(MemberAddressCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * memberAddressBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(memberAddressList, new SpecifyQuery<MemberAddressCB>() {
     *     public void specify(MemberAddressCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).</p>
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<MemberAddress> memberAddressList, SpecifyQuery<MemberAddressCB> updateColumnSpec) {
        return doBatchUpdateNonstrict(memberAddressList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return batchUpdateNonstrict(downcast(ls)); }
        else { return varyingBatchUpdateNonstrict(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(List<MemberAddress> memberAddressList) {
        return doBatchDelete(memberAddressList, null);
    }

    protected int[] doBatchDelete(List<MemberAddress> memberAddressList, DeleteOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddressList", memberAddressList);
        prepareDeleteOption(option);
        return delegateBatchDelete(memberAddressList, option);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-delete the entity list non-strictly. {NonExclusiveControl} <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(List<MemberAddress> memberAddressList) {
        return doBatchDeleteNonstrict(memberAddressList, null);
    }

    protected int[] doBatchDeleteNonstrict(List<MemberAddress> memberAddressList, DeleteOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddressList", memberAddressList);
        prepareDeleteOption(option);
        return delegateBatchDeleteNonstrict(memberAddressList, option);
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
     * memberAddressBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberAddress, MemberAddressCB&gt;() {
     *     public ConditionBean setup(memberAddress entity, MemberAddressCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<MemberAddress, MemberAddressCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberAddress, MemberAddressCB> setupper, InsertOption<MemberAddressCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        MemberAddress entity = new MemberAddress();
        MemberAddressCB intoCB = createCBForQueryInsert();
        ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected MemberAddressCB createCBForQueryInsert() {
        MemberAddressCB cb = newMyConditionBean();
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
     * MemberAddress memberAddress = new MemberAddress();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberAddress.setPK...(value);</span>
     * memberAddress.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberAddress.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberAddress.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberAddress.setVersionNo(value);</span>
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * memberAddressBhv.<span style="color: #FD4747">queryUpdate</span>(memberAddress, cb);
     * </pre>
     * @param memberAddress The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberAddress memberAddress, MemberAddressCB cb) {
        return doQueryUpdate(memberAddress, cb, null);
    }

    protected int doQueryUpdate(MemberAddress memberAddress, MemberAddressCB cb, UpdateOption<MemberAddressCB> option) {
        assertObjectNotNull("memberAddress", memberAddress); assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(memberAddress, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(Entity entity, ConditionBean cb, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return queryUpdate(downcast(entity), (MemberAddressCB)cb); }
        else { return varyingQueryUpdate(downcast(entity), (MemberAddressCB)cb, downcast(option)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * memberAddressBhv.<span style="color: #FD4747">queryDelete</span>(memberAddress, cb);
     * </pre>
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberAddressCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberAddressCB cb, DeleteOption<MemberAddressCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, option) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return queryDelete((MemberAddressCB)cb); }
        else { return varyingQueryDelete((MemberAddressCB)cb, downcast(option)); }
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
     * MemberAddress memberAddress = new MemberAddress();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberAddress.setFoo...(value);
     * memberAddress.setBar...(value);
     * InsertOption<MemberAddressCB> option = new InsertOption<MemberAddressCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberAddressBhv.<span style="color: #FD4747">varyingInsert</span>(memberAddress, option);
     * ... = memberAddress.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberAddress The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(MemberAddress memberAddress, InsertOption<MemberAddressCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(memberAddress, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, ExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * MemberAddress memberAddress = new MemberAddress();
     * memberAddress.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberAddress.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberAddress.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberAddressCB&gt; option = new UpdateOption&lt;MemberAddressCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberAddressCB&gt;() {
     *         public void specify(MemberAddressCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberAddressBhv.<span style="color: #FD4747">varyingUpdate</span>(memberAddress, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberAddress The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(MemberAddress memberAddress, UpdateOption<MemberAddressCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(memberAddress, option);
    }

    /**
     * Update the entity with varying requests non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as updateNonstrict(entity).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * MemberAddress memberAddress = new MemberAddress();
     * memberAddress.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberAddress.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberAddress.setVersionNo(value);</span>
     * UpdateOption&lt;MemberAddressCB&gt; option = new UpdateOption&lt;MemberAddressCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberAddressCB&gt;() {
     *     public void specify(MemberAddressCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberAddressBhv.<span style="color: #FD4747">varyingUpdateNonstrict</span>(memberAddress, option);
     * </pre>
     * @param memberAddress The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(MemberAddress memberAddress, UpdateOption<MemberAddressCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(memberAddress, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberAddress The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberAddress memberAddress, InsertOption<MemberAddressCB> insertOption, UpdateOption<MemberAddressCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(memberAddress, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param memberAddress The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(MemberAddress memberAddress, InsertOption<MemberAddressCB> insertOption, UpdateOption<MemberAddressCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdateNonstrict(memberAddress, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberAddress The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberAddress memberAddress, DeleteOption<MemberAddressCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberAddress, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param memberAddress The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDeleteNonstrict(MemberAddress memberAddress, DeleteOption<MemberAddressCB> option) {
        assertDeleteOptionNotNull(option);
        doDeleteNonstrict(memberAddress, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<MemberAddress> memberAddressList, InsertOption<MemberAddressCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberAddressList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<MemberAddress> memberAddressList, UpdateOption<MemberAddressCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberAddressList, option);
    }

    /**
     * Batch-update the list with varying requests non-strictly. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdateNonstrict(List<MemberAddress> memberAddressList, UpdateOption<MemberAddressCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdateNonstrict(memberAddressList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<MemberAddress> memberAddressList, DeleteOption<MemberAddressCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberAddressList, option);
    }

    /**
     * Batch-delete the list with varying requests non-strictly. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDeleteNonstrict(entityList).
     * @param memberAddressList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDeleteNonstrict(List<MemberAddress> memberAddressList, DeleteOption<MemberAddressCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDeleteNonstrict(memberAddressList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<MemberAddress, MemberAddressCB> setupper, InsertOption<MemberAddressCB> option) {
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
     * MemberAddress memberAddress = new MemberAddress();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberAddress.setPK...(value);</span>
     * memberAddress.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberAddress.setVersionNo(value);</span>
     * MemberAddressCB cb = new MemberAddressCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberAddressCB&gt; option = new UpdateOption&lt;MemberAddressCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberAddressCB&gt;() {
     *     public void specify(MemberAddressCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberAddressBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(memberAddress, cb, option);
     * </pre>
     * @param memberAddress The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(MemberAddress memberAddress, MemberAddressCB cb, UpdateOption<MemberAddressCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(memberAddress, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of MemberAddress. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberAddressCB cb, DeleteOption<MemberAddressCB> option) {
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
    public OutsideSqlBasicExecutor<MemberAddressBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(MemberAddressCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(MemberAddressCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends MemberAddress> void delegateSelectCursor(MemberAddressCB cb, EntityRowHandler<ENTITY> erh, Class<ENTITY> et)
    { invoke(createSelectCursorCBCommand(cb, erh, et)); }
    protected <ENTITY extends MemberAddress> List<ENTITY> delegateSelectList(MemberAddressCB cb, Class<ENTITY> et)
    { return invoke(createSelectListCBCommand(cb, et)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(MemberAddress e, InsertOption<MemberAddressCB> op)
    { if (!processBeforeInsert(e, op)) { return 0; }
      return invoke(createInsertEntityCommand(e, op)); }
    protected int delegateUpdate(MemberAddress e, UpdateOption<MemberAddressCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateEntityCommand(e, op)); }
    protected int delegateUpdateNonstrict(MemberAddress e, UpdateOption<MemberAddressCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(e, op)); }
    protected int delegateDelete(MemberAddress e, DeleteOption<MemberAddressCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteEntityCommand(e, op)); }
    protected int delegateDeleteNonstrict(MemberAddress e, DeleteOption<MemberAddressCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(e, op)); }

    protected int[] delegateBatchInsert(List<MemberAddress> ls, InsertOption<MemberAddressCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<MemberAddress> ls, UpdateOption<MemberAddressCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchUpdateNonstrict(List<MemberAddress> ls, UpdateOption<MemberAddressCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<MemberAddress> ls, DeleteOption<MemberAddressCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchDeleteNonstrict(List<MemberAddress> ls, DeleteOption<MemberAddressCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(MemberAddress e, MemberAddressCB inCB, ConditionBean resCB, InsertOption<MemberAddressCB> op)
    { if (!processBeforeQueryInsert(e, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));  }
    protected int delegateQueryUpdate(MemberAddress e, MemberAddressCB cb, UpdateOption<MemberAddressCB> op)
    { if (!processBeforeQueryUpdate(e, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(e, cb, op));  }
    protected int delegateQueryDelete(MemberAddressCB cb, DeleteOption<MemberAddressCB> op)
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
    protected MemberAddress downcast(Entity entity) {
        return helpEntityDowncastInternally(entity, MemberAddress.class);
    }

    protected MemberAddressCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, MemberAddressCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<MemberAddress> downcast(List<? extends Entity> entityList) {
        return (List<MemberAddress>)entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberAddressCB> downcast(InsertOption<? extends ConditionBean> option) {
        return (InsertOption<MemberAddressCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberAddressCB> downcast(UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<MemberAddressCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberAddressCB> downcast(DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<MemberAddressCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberAddress, MemberAddressCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<MemberAddress, MemberAddressCB>)option;
    }
}
