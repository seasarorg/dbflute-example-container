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
 * The behavior of VENDOR_IDENTITY_ONLY as TABLE. <br />
 * <pre>
 * [primary key]
 *     IDENTITY_ONLY_ID
 * 
 * [column]
 *     IDENTITY_ONLY_ID
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     IDENTITY_ONLY_ID
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVendorIdentityOnlyBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "VENDOR_IDENTITY_ONLY"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return VendorIdentityOnlyDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public VendorIdentityOnlyDbm getMyDBMeta() { return VendorIdentityOnlyDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public VendorIdentityOnly newMyEntity() { return new VendorIdentityOnly(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public VendorIdentityOnlyCB newMyConditionBean() { return new VendorIdentityOnlyCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * int count = vendorIdentityOnlyBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(VendorIdentityOnlyCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(VendorIdentityOnlyCB cb) { // called by selectCount(cb) 
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(VendorIdentityOnlyCB cb) { // called by selectPage(cb)
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
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * VendorIdentityOnly vendorIdentityOnly = vendorIdentityOnlyBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (vendorIdentityOnly != null) {
     *     ... = vendorIdentityOnly.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorIdentityOnly selectEntity(VendorIdentityOnlyCB cb) {
        return doSelectEntity(cb, VendorIdentityOnly.class);
    }

    protected <ENTITY extends VendorIdentityOnly> ENTITY doSelectEntity(final VendorIdentityOnlyCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType, new InternalSelectEntityCallback<ENTITY, VendorIdentityOnlyCB>() {
            public List<ENTITY> callbackSelectList(VendorIdentityOnlyCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * VendorIdentityOnly vendorIdentityOnly = vendorIdentityOnlyBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = vendorIdentityOnly.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorIdentityOnly selectEntityWithDeletedCheck(VendorIdentityOnlyCB cb) {
        return doSelectEntityWithDeletedCheck(cb, VendorIdentityOnly.class);
    }

    protected <ENTITY extends VendorIdentityOnly> ENTITY doSelectEntityWithDeletedCheck(final VendorIdentityOnlyCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(cb, entityType, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, VendorIdentityOnlyCB>() {
            public List<ENTITY> callbackSelectList(VendorIdentityOnlyCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param identityOnlyId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorIdentityOnly selectByPKValue(Long identityOnlyId) {
        return doSelectByPKValue(identityOnlyId, VendorIdentityOnly.class);
    }

    protected <ENTITY extends VendorIdentityOnly> ENTITY doSelectByPKValue(Long identityOnlyId, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(identityOnlyId), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param identityOnlyId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorIdentityOnly selectByPKValueWithDeletedCheck(Long identityOnlyId) {
        return doSelectByPKValueWithDeletedCheck(identityOnlyId, VendorIdentityOnly.class);
    }

    protected <ENTITY extends VendorIdentityOnly> ENTITY doSelectByPKValueWithDeletedCheck(Long identityOnlyId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(identityOnlyId), entityType);
    }

    private VendorIdentityOnlyCB buildPKCB(Long identityOnlyId) {
        assertObjectNotNull("identityOnlyId", identityOnlyId);
        VendorIdentityOnlyCB cb = newMyConditionBean();
        cb.query().setIdentityOnlyId_Equal(identityOnlyId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;VendorIdentityOnly&gt; vendorIdentityOnlyList = vendorIdentityOnlyBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (VendorIdentityOnly vendorIdentityOnly : vendorIdentityOnlyList) {
     *     ... = vendorIdentityOnly.get...();
     * }
     * </pre>
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<VendorIdentityOnly> selectList(VendorIdentityOnlyCB cb) {
        return doSelectList(cb, VendorIdentityOnly.class);
    }

    protected <ENTITY extends VendorIdentityOnly> ListResultBean<ENTITY> doSelectList(VendorIdentityOnlyCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType, new InternalSelectListCallback<ENTITY, VendorIdentityOnlyCB>() {
            public List<ENTITY> callbackSelectList(VendorIdentityOnlyCB cb, Class<ENTITY> entityType) { return delegateSelectList(cb, entityType); } });
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
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;VendorIdentityOnly&gt; page = vendorIdentityOnlyBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (VendorIdentityOnly vendorIdentityOnly : page) {
     *     ... = vendorIdentityOnly.get...();
     * }
     * </pre>
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<VendorIdentityOnly> selectPage(VendorIdentityOnlyCB cb) {
        return doSelectPage(cb, VendorIdentityOnly.class);
    }

    protected <ENTITY extends VendorIdentityOnly> PagingResultBean<ENTITY> doSelectPage(VendorIdentityOnlyCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType, new InternalSelectPageCallback<ENTITY, VendorIdentityOnlyCB>() {
            public int callbackSelectCount(VendorIdentityOnlyCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(VendorIdentityOnlyCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
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
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;VendorIdentityOnly&gt;() {
     *     public void handle(VendorIdentityOnly entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @param entityRowHandler The handler of entity row of VendorIdentityOnly. (NotNull)
     */
    public void selectCursor(VendorIdentityOnlyCB cb, EntityRowHandler<VendorIdentityOnly> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, VendorIdentityOnly.class);
    }

    protected <ENTITY extends VendorIdentityOnly> void doSelectCursor(VendorIdentityOnlyCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler<VendorIdentityOnly>", entityRowHandler); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType, new InternalSelectCursorCallback<ENTITY, VendorIdentityOnlyCB>() {
            public void callbackSelectCursor(VendorIdentityOnlyCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) { delegateSelectCursor(cb, entityRowHandler, entityType); }
            public List<ENTITY> callbackSelectList(VendorIdentityOnlyCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(VendorIdentityOnlyCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar value derived by a function. (NullAllowed)
     */
    public <RESULT> SLFunction<VendorIdentityOnlyCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends VendorIdentityOnlyCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> resultType, CB cb) {
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

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key identityOnlyId.
     * @param vendorIdentityOnlyList The list of vendorIdentityOnly. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractIdentityOnlyIdList(List<VendorIdentityOnly> vendorIdentityOnlyList) {
        return helpExtractListInternally(vendorIdentityOnlyList, new InternalExtractCallback<VendorIdentityOnly, Long>() {
            public Long getCV(VendorIdentityOnly e) { return e.getIdentityOnlyId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * vendorIdentityOnly.setFoo...(value);
     * vendorIdentityOnly.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.set...;</span>
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">insert</span>(vendorIdentityOnly);
     * ... = vendorIdentityOnly.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param vendorIdentityOnly The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(VendorIdentityOnly vendorIdentityOnly) {
        doInsert(vendorIdentityOnly, null);
    }

    protected void doInsert(VendorIdentityOnly vendorIdentityOnly, InsertOption<VendorIdentityOnlyCB> option) {
        assertObjectNotNull("vendorIdentityOnly", vendorIdentityOnly);
        prepareInsertOption(option);
        delegateInsert(vendorIdentityOnly, option);
    }

    protected void prepareInsertOption(InsertOption<VendorIdentityOnlyCB> option) {
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
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     * vendorIdentityOnly.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * vendorIdentityOnly.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorIdentityOnly.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     vendorIdentityOnlyBhv.<span style="color: #FD4747">update</span>(vendorIdentityOnly);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param vendorIdentityOnly The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final VendorIdentityOnly vendorIdentityOnly) {
        doUpdate(vendorIdentityOnly, null);
    }

    protected void doUpdate(VendorIdentityOnly vendorIdentityOnly, final UpdateOption<VendorIdentityOnlyCB> option) {
        assertObjectNotNull("vendorIdentityOnly", vendorIdentityOnly);
        prepareUpdateOption(option);
        helpUpdateInternally(vendorIdentityOnly, new InternalUpdateCallback<VendorIdentityOnly>() {
            public int callbackDelegateUpdate(VendorIdentityOnly entity) { return delegateUpdate(entity, option); } });
    }

    protected void prepareUpdateOption(UpdateOption<VendorIdentityOnlyCB> option) {
        if (option == null) { return; }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected VendorIdentityOnlyCB createCBForVaryingUpdate() {
        VendorIdentityOnlyCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected VendorIdentityOnlyCB createCBForSpecifiedUpdate() {
        VendorIdentityOnlyCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity entity, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { update(downcast(entity)); }
        else { varyingUpdate(downcast(entity), downcast(option)); }
    }

    @Override
    protected void doModifyNonstrict(Entity entity, UpdateOption<? extends ConditionBean> option) {
        doModify(entity, option);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param vendorIdentityOnly The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(VendorIdentityOnly vendorIdentityOnly) {
        doInesrtOrUpdate(vendorIdentityOnly, null, null);
    }

    protected void doInesrtOrUpdate(VendorIdentityOnly vendorIdentityOnly, final InsertOption<VendorIdentityOnlyCB> insertOption, final UpdateOption<VendorIdentityOnlyCB> updateOption) {
        helpInsertOrUpdateInternally(vendorIdentityOnly, new InternalInsertOrUpdateCallback<VendorIdentityOnly, VendorIdentityOnlyCB>() {
            public void callbackInsert(VendorIdentityOnly entity) { doInsert(entity, insertOption); }
            public void callbackUpdate(VendorIdentityOnly entity) { doUpdate(entity, updateOption); }
            public VendorIdentityOnlyCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(VendorIdentityOnlyCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdate(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<VendorIdentityOnlyCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<VendorIdentityOnlyCB>() : updateOption;
            varyingInsertOrUpdate(downcast(entity), downcast(insertOption), downcast(updateOption));
        }
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        doCreateOrModify(entity, insertOption, updateOption);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     * vendorIdentityOnly.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorIdentityOnly.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     vendorIdentityOnlyBhv.<span style="color: #FD4747">delete</span>(vendorIdentityOnly);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param vendorIdentityOnly The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(VendorIdentityOnly vendorIdentityOnly) {
        doDelete(vendorIdentityOnly, null);
    }

    protected void doDelete(VendorIdentityOnly vendorIdentityOnly, final DeleteOption<VendorIdentityOnlyCB> option) {
        assertObjectNotNull("vendorIdentityOnly", vendorIdentityOnly);
        prepareDeleteOption(option);
        helpDeleteInternally(vendorIdentityOnly, new InternalDeleteCallback<VendorIdentityOnly>() {
            public int callbackDelegateDelete(VendorIdentityOnly entity) { return delegateDelete(entity, option); } });
    }

    protected void prepareDeleteOption(DeleteOption<VendorIdentityOnlyCB> option) {
        if (option == null) { return; }
        assertDeleteOptionStatus(option);
    }

    @Override
    protected void doRemove(Entity entity, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { delete(downcast(entity)); }
        else { varyingDelete(downcast(entity), downcast(option)); }
    }

    @Override
    protected void doRemoveNonstrict(Entity entity, DeleteOption<? extends ConditionBean> option) {
        doRemove(entity, option);
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
     *     VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     *     vendorIdentityOnly.setFooName("foo");
     *     if (...) {
     *         vendorIdentityOnly.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     vendorIdentityOnlyList.add(vendorIdentityOnly);
     * }
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">batchInsert</span>(vendorIdentityOnlyList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param vendorIdentityOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<VendorIdentityOnly> vendorIdentityOnlyList) {
        InsertOption<VendorIdentityOnlyCB> option = createInsertUpdateOption();
        return doBatchInsert(vendorIdentityOnlyList, option);
    }

    protected int[] doBatchInsert(List<VendorIdentityOnly> vendorIdentityOnlyList, InsertOption<VendorIdentityOnlyCB> option) {
        assertObjectNotNull("vendorIdentityOnlyList", vendorIdentityOnlyList);
        prepareBatchInsertOption(vendorIdentityOnlyList, option);
        return delegateBatchInsert(vendorIdentityOnlyList, option);
    }

    protected void prepareBatchInsertOption(List<VendorIdentityOnly> vendorIdentityOnlyList, InsertOption<VendorIdentityOnlyCB> option) {
        option.xallowInsertColumnModifiedPropertiesFragmented();
        option.xacceptInsertColumnModifiedPropertiesIfNeeds(vendorIdentityOnlyList);
        prepareInsertOption(option);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> option) {
        if (option == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     *     vendorIdentityOnly.setFooName("foo");
     *     if (...) {
     *         vendorIdentityOnly.setFooPrice(123);
     *     } else {
     *         vendorIdentityOnly.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//vendorIdentityOnly.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     vendorIdentityOnlyList.add(vendorIdentityOnly);
     * }
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">batchUpdate</span>(vendorIdentityOnlyList);
     * </pre>
     * @param vendorIdentityOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VendorIdentityOnly> vendorIdentityOnlyList) {
        UpdateOption<VendorIdentityOnlyCB> option = createPlainUpdateOption();
        return doBatchUpdate(vendorIdentityOnlyList, option);
    }

    protected int[] doBatchUpdate(List<VendorIdentityOnly> vendorIdentityOnlyList, UpdateOption<VendorIdentityOnlyCB> option) {
        assertObjectNotNull("vendorIdentityOnlyList", vendorIdentityOnlyList);
        prepareBatchUpdateOption(vendorIdentityOnlyList, option);
        return delegateBatchUpdate(vendorIdentityOnlyList, option);
    }

    protected void prepareBatchUpdateOption(List<VendorIdentityOnly> vendorIdentityOnlyList, UpdateOption<VendorIdentityOnlyCB> option) {
        option.xacceptUpdateColumnModifiedPropertiesIfNeeds(vendorIdentityOnlyList);
        prepareUpdateOption(option);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-update the entity list specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span> 
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">batchUpdate</span>(vendorIdentityOnlyList, new SpecifyQuery<VendorIdentityOnlyCB>() {
     *     public void specify(VendorIdentityOnlyCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">batchUpdate</span>(vendorIdentityOnlyList, new SpecifyQuery<VendorIdentityOnlyCB>() {
     *     public void specify(VendorIdentityOnlyCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param vendorIdentityOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VendorIdentityOnly> vendorIdentityOnlyList, SpecifyQuery<VendorIdentityOnlyCB> updateColumnSpec) {
        return doBatchUpdate(vendorIdentityOnlyList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        return doLumpModify(ls, option);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param vendorIdentityOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<VendorIdentityOnly> vendorIdentityOnlyList) {
        return doBatchDelete(vendorIdentityOnlyList, null);
    }

    protected int[] doBatchDelete(List<VendorIdentityOnly> vendorIdentityOnlyList, DeleteOption<VendorIdentityOnlyCB> option) {
        assertObjectNotNull("vendorIdentityOnlyList", vendorIdentityOnlyList);
        prepareDeleteOption(option);
        return delegateBatchDelete(vendorIdentityOnlyList, option);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(option)); }
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> option) {
        return doLumpRemove(ls, option);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;VendorIdentityOnly, VendorIdentityOnlyCB&gt;() {
     *     public ConditionBean setup(vendorIdentityOnly entity, VendorIdentityOnlyCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<VendorIdentityOnly, VendorIdentityOnlyCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<VendorIdentityOnly, VendorIdentityOnlyCB> setupper, InsertOption<VendorIdentityOnlyCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        VendorIdentityOnly entity = new VendorIdentityOnly();
        VendorIdentityOnlyCB intoCB = createCBForQueryInsert();
        ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected VendorIdentityOnlyCB createCBForQueryInsert() {
        VendorIdentityOnlyCB cb = newMyConditionBean();
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
     * VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.setPK...(value);</span>
     * vendorIdentityOnly.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.setVersionNo(value);</span>
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">queryUpdate</span>(vendorIdentityOnly, cb);
     * </pre>
     * @param vendorIdentityOnly The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(VendorIdentityOnly vendorIdentityOnly, VendorIdentityOnlyCB cb) {
        return doQueryUpdate(vendorIdentityOnly, cb, null);
    }

    protected int doQueryUpdate(VendorIdentityOnly vendorIdentityOnly, VendorIdentityOnlyCB cb, UpdateOption<VendorIdentityOnlyCB> option) {
        assertObjectNotNull("vendorIdentityOnly", vendorIdentityOnly); assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(vendorIdentityOnly, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(Entity entity, ConditionBean cb, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return queryUpdate(downcast(entity), (VendorIdentityOnlyCB)cb); }
        else { return varyingQueryUpdate(downcast(entity), (VendorIdentityOnlyCB)cb, downcast(option)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">queryDelete</span>(vendorIdentityOnly, cb);
     * </pre>
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(VendorIdentityOnlyCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(VendorIdentityOnlyCB cb, DeleteOption<VendorIdentityOnlyCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, option) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return queryDelete((VendorIdentityOnlyCB)cb); }
        else { return varyingQueryDelete((VendorIdentityOnlyCB)cb, downcast(option)); }
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
     * VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * vendorIdentityOnly.setFoo...(value);
     * vendorIdentityOnly.setBar...(value);
     * InsertOption<VendorIdentityOnlyCB> option = new InsertOption<VendorIdentityOnlyCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">varyingInsert</span>(vendorIdentityOnly, option);
     * ... = vendorIdentityOnly.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param vendorIdentityOnly The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(VendorIdentityOnly vendorIdentityOnly, InsertOption<VendorIdentityOnlyCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(vendorIdentityOnly, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     * vendorIdentityOnly.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * vendorIdentityOnly.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorIdentityOnly.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;VendorIdentityOnlyCB&gt; option = new UpdateOption&lt;VendorIdentityOnlyCB&gt;();
     *     option.self(new SpecifyQuery&lt;VendorIdentityOnlyCB&gt;() {
     *         public void specify(VendorIdentityOnlyCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     vendorIdentityOnlyBhv.<span style="color: #FD4747">varyingUpdate</span>(vendorIdentityOnly, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param vendorIdentityOnly The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(VendorIdentityOnly vendorIdentityOnly, UpdateOption<VendorIdentityOnlyCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(vendorIdentityOnly, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param vendorIdentityOnly The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(VendorIdentityOnly vendorIdentityOnly, InsertOption<VendorIdentityOnlyCB> insertOption, UpdateOption<VendorIdentityOnlyCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(vendorIdentityOnly, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param vendorIdentityOnly The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(VendorIdentityOnly vendorIdentityOnly, DeleteOption<VendorIdentityOnlyCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(vendorIdentityOnly, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param vendorIdentityOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<VendorIdentityOnly> vendorIdentityOnlyList, InsertOption<VendorIdentityOnlyCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(vendorIdentityOnlyList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param vendorIdentityOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<VendorIdentityOnly> vendorIdentityOnlyList, UpdateOption<VendorIdentityOnlyCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(vendorIdentityOnlyList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param vendorIdentityOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<VendorIdentityOnly> vendorIdentityOnlyList, DeleteOption<VendorIdentityOnlyCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(vendorIdentityOnlyList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<VendorIdentityOnly, VendorIdentityOnlyCB> setupper, InsertOption<VendorIdentityOnlyCB> option) {
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
     * VendorIdentityOnly vendorIdentityOnly = new VendorIdentityOnly();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.setPK...(value);</span>
     * vendorIdentityOnly.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//vendorIdentityOnly.setVersionNo(value);</span>
     * VendorIdentityOnlyCB cb = new VendorIdentityOnlyCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;VendorIdentityOnlyCB&gt; option = new UpdateOption&lt;VendorIdentityOnlyCB&gt;();
     * option.self(new SpecifyQuery&lt;VendorIdentityOnlyCB&gt;() {
     *     public void specify(VendorIdentityOnlyCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * vendorIdentityOnlyBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(vendorIdentityOnly, cb, option);
     * </pre>
     * @param vendorIdentityOnly The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(VendorIdentityOnly vendorIdentityOnly, VendorIdentityOnlyCB cb, UpdateOption<VendorIdentityOnlyCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(vendorIdentityOnly, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of VendorIdentityOnly. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(VendorIdentityOnlyCB cb, DeleteOption<VendorIdentityOnlyCB> option) {
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
    public OutsideSqlBasicExecutor<VendorIdentityOnlyBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(VendorIdentityOnlyCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(VendorIdentityOnlyCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends VendorIdentityOnly> void delegateSelectCursor(VendorIdentityOnlyCB cb, EntityRowHandler<ENTITY> erh, Class<ENTITY> et)
    { invoke(createSelectCursorCBCommand(cb, erh, et)); }
    protected <ENTITY extends VendorIdentityOnly> List<ENTITY> delegateSelectList(VendorIdentityOnlyCB cb, Class<ENTITY> et)
    { return invoke(createSelectListCBCommand(cb, et)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(VendorIdentityOnly e, InsertOption<VendorIdentityOnlyCB> op)
    { if (!processBeforeInsert(e, op)) { return 0; }
      return invoke(createInsertEntityCommand(e, op)); }
    protected int delegateUpdate(VendorIdentityOnly e, UpdateOption<VendorIdentityOnlyCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return delegateUpdateNonstrict(e, op); }
    protected int delegateUpdateNonstrict(VendorIdentityOnly e, UpdateOption<VendorIdentityOnlyCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(e, op)); }
    protected int delegateDelete(VendorIdentityOnly e, DeleteOption<VendorIdentityOnlyCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return delegateDeleteNonstrict(e, op); }
    protected int delegateDeleteNonstrict(VendorIdentityOnly e, DeleteOption<VendorIdentityOnlyCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(e, op)); }

    protected int[] delegateBatchInsert(List<VendorIdentityOnly> ls, InsertOption<VendorIdentityOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<VendorIdentityOnly> ls, UpdateOption<VendorIdentityOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<VendorIdentityOnly> ls, UpdateOption<VendorIdentityOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<VendorIdentityOnly> ls, DeleteOption<VendorIdentityOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<VendorIdentityOnly> ls, DeleteOption<VendorIdentityOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(VendorIdentityOnly e, VendorIdentityOnlyCB inCB, ConditionBean resCB, InsertOption<VendorIdentityOnlyCB> op)
    { if (!processBeforeQueryInsert(e, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));  }
    protected int delegateQueryUpdate(VendorIdentityOnly e, VendorIdentityOnlyCB cb, UpdateOption<VendorIdentityOnlyCB> op)
    { if (!processBeforeQueryUpdate(e, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(e, cb, op));  }
    protected int delegateQueryDelete(VendorIdentityOnlyCB cb, DeleteOption<VendorIdentityOnlyCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity entity) {
        return false;
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
    protected VendorIdentityOnly downcast(Entity entity) {
        return helpEntityDowncastInternally(entity, VendorIdentityOnly.class);
    }

    protected VendorIdentityOnlyCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, VendorIdentityOnlyCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<VendorIdentityOnly> downcast(List<? extends Entity> entityList) {
        return (List<VendorIdentityOnly>)entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<VendorIdentityOnlyCB> downcast(InsertOption<? extends ConditionBean> option) {
        return (InsertOption<VendorIdentityOnlyCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<VendorIdentityOnlyCB> downcast(UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<VendorIdentityOnlyCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<VendorIdentityOnlyCB> downcast(DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<VendorIdentityOnlyCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<VendorIdentityOnly, VendorIdentityOnlyCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<VendorIdentityOnly, VendorIdentityOnlyCB>)option;
    }
}
