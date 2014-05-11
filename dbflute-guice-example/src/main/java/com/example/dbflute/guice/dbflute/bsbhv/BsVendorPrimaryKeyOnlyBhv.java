package com.example.dbflute.guice.dbflute.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.optional.*;
import org.seasar.dbflute.outsidesql.executor.*;
import com.example.dbflute.guice.dbflute.exbhv.*;
import com.example.dbflute.guice.dbflute.exentity.*;
import com.example.dbflute.guice.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.guice.dbflute.cbean.*;

/**
 * The behavior of VENDOR_PRIMARY_KEY_ONLY as TABLE. <br />
 * <pre>
 * [primary key]
 *     PRIMARY_KEY_ONLY_ID
 *
 * [column]
 *     PRIMARY_KEY_ONLY_ID
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
public abstract class BsVendorPrimaryKeyOnlyBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "VENDOR_PRIMARY_KEY_ONLY"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return VendorPrimaryKeyOnlyDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public VendorPrimaryKeyOnlyDbm getMyDBMeta() { return VendorPrimaryKeyOnlyDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public VendorPrimaryKeyOnly newMyEntity() { return new VendorPrimaryKeyOnly(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public VendorPrimaryKeyOnlyCB newMyConditionBean() { return new VendorPrimaryKeyOnlyCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * int count = vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(VendorPrimaryKeyOnlyCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(VendorPrimaryKeyOnlyCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(VendorPrimaryKeyOnlyCB cb) { // called by selectPage(cb)
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
     * It returns not-null optional entity, so you should ... <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, get() without check.</span> <br />
     * <span style="color: #AD4747; font-size: 120%">If it might be no data, get() after check by isPresent() or orElse(), ...</span>
     * <pre>
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * OptionalEntity&lt;VendorPrimaryKeyOnly&gt; entity = vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     *
     * <span style="color: #3F7E5E">// if the data always exists as your business rule</span>
     * entity.<span style="color: #DD4747">required</span>(vendorPrimaryKeyOnly -&gt; {
     *     ...
     * });
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = entity.entity.<span style="color: #DD4747">get()</span>;
     *
     * <span style="color: #3F7E5E">// if it might be no data, ifPresent(), isPresent(), ...</span>
     * entity.<span style="color: #DD4747">ifPresent</span>(vendorPrimaryKeyOnly -&gt; {
     *     ...
     * });
     * if (entity.entity.<span style="color: #DD4747">isPresent()</span>) {
     *     VendorPrimaryKeyOnly vendorPrimaryKeyOnly = entity.entity.<span style="color: #DD4747">get()</span>;
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get() of return value is called and the value is null, which means entity has already been deleted (point is not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<VendorPrimaryKeyOnly> selectEntity(VendorPrimaryKeyOnlyCB cb) {
        return doSelectOptionalEntity(cb, VendorPrimaryKeyOnly.class);
    }

    protected <ENTITY extends VendorPrimaryKeyOnly> ENTITY doSelectEntity(VendorPrimaryKeyOnlyCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, VendorPrimaryKeyOnlyCB>() {
            public List<ENTITY> callbackSelectList(VendorPrimaryKeyOnlyCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends VendorPrimaryKeyOnly> OptionalEntity<ENTITY> doSelectOptionalEntity(VendorPrimaryKeyOnlyCB cb, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb)).orElseNull();
    }

    /**
     * Select the entity by the condition-bean with deleted check. <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, this method is good.</span>
     * <pre>
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = vendorPrimaryKeyOnly.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (point is not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorPrimaryKeyOnly selectEntityWithDeletedCheck(VendorPrimaryKeyOnlyCB cb) {
        return doSelectEntityWithDeletedCheck(cb, VendorPrimaryKeyOnly.class);
    }

    protected <ENTITY extends VendorPrimaryKeyOnly> ENTITY doSelectEntityWithDeletedCheck(VendorPrimaryKeyOnlyCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, VendorPrimaryKeyOnlyCB>() {
            public List<ENTITY> callbackSelectList(VendorPrimaryKeyOnlyCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param primaryKeyOnlyId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorPrimaryKeyOnly selectByPKValue(Long primaryKeyOnlyId) {
        return doSelectByPKValue(primaryKeyOnlyId, VendorPrimaryKeyOnly.class);
    }

    protected <ENTITY extends VendorPrimaryKeyOnly> ENTITY doSelectByPKValue(Long primaryKeyOnlyId, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(primaryKeyOnlyId), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param primaryKeyOnlyId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorPrimaryKeyOnly selectByPKValueWithDeletedCheck(Long primaryKeyOnlyId) {
        return doSelectByPKValueWithDeletedCheck(primaryKeyOnlyId, VendorPrimaryKeyOnly.class);
    }

    protected <ENTITY extends VendorPrimaryKeyOnly> ENTITY doSelectByPKValueWithDeletedCheck(Long primaryKeyOnlyId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(primaryKeyOnlyId), entityType);
    }

    private VendorPrimaryKeyOnlyCB buildPKCB(Long primaryKeyOnlyId) {
        assertObjectNotNull("primaryKeyOnlyId", primaryKeyOnlyId);
        VendorPrimaryKeyOnlyCB cb = newMyConditionBean();
        cb.query().setPrimaryKeyOnlyId_Equal(primaryKeyOnlyId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;VendorPrimaryKeyOnly&gt; vendorPrimaryKeyOnlyList = vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (VendorPrimaryKeyOnly vendorPrimaryKeyOnly : vendorPrimaryKeyOnlyList) {
     *     ... = vendorPrimaryKeyOnly.get...();
     * }
     * </pre>
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<VendorPrimaryKeyOnly> selectList(VendorPrimaryKeyOnlyCB cb) {
        return doSelectList(cb, VendorPrimaryKeyOnly.class);
    }

    protected <ENTITY extends VendorPrimaryKeyOnly> ListResultBean<ENTITY> doSelectList(VendorPrimaryKeyOnlyCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, VendorPrimaryKeyOnlyCB>() {
            public List<ENTITY> callbackSelectList(VendorPrimaryKeyOnlyCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;VendorPrimaryKeyOnly&gt; page = vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (VendorPrimaryKeyOnly vendorPrimaryKeyOnly : page) {
     *     ... = vendorPrimaryKeyOnly.get...();
     * }
     * </pre>
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<VendorPrimaryKeyOnly> selectPage(VendorPrimaryKeyOnlyCB cb) {
        return doSelectPage(cb, VendorPrimaryKeyOnly.class);
    }

    protected <ENTITY extends VendorPrimaryKeyOnly> PagingResultBean<ENTITY> doSelectPage(VendorPrimaryKeyOnlyCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, VendorPrimaryKeyOnlyCB>() {
            public int callbackSelectCount(VendorPrimaryKeyOnlyCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(VendorPrimaryKeyOnlyCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;VendorPrimaryKeyOnly&gt;() {
     *     public void handle(VendorPrimaryKeyOnly entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @param entityRowHandler The handler of entity row of VendorPrimaryKeyOnly. (NotNull)
     */
    public void selectCursor(VendorPrimaryKeyOnlyCB cb, EntityRowHandler<VendorPrimaryKeyOnly> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, VendorPrimaryKeyOnly.class);
    }

    protected <ENTITY extends VendorPrimaryKeyOnly> void doSelectCursor(VendorPrimaryKeyOnlyCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, VendorPrimaryKeyOnlyCB>() {
            public void callbackSelectCursor(VendorPrimaryKeyOnlyCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(VendorPrimaryKeyOnlyCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(VendorPrimaryKeyOnlyCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<VendorPrimaryKeyOnlyCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends VendorPrimaryKeyOnlyCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends VendorPrimaryKeyOnlyCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
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

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key primaryKeyOnlyId.
     * @param vendorPrimaryKeyOnlyList The list of vendorPrimaryKeyOnly. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractPrimaryKeyOnlyIdList(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList) {
        return helpExtractListInternally(vendorPrimaryKeyOnlyList, new InternalExtractCallback<VendorPrimaryKeyOnly, Long>() {
            public Long getCV(VendorPrimaryKeyOnly et) { return et.getPrimaryKeyOnlyId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * vendorPrimaryKeyOnly.setFoo...(value);
     * vendorPrimaryKeyOnly.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.set...;</span>
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">insert</span>(vendorPrimaryKeyOnly);
     * ... = vendorPrimaryKeyOnly.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param vendorPrimaryKeyOnly The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(VendorPrimaryKeyOnly vendorPrimaryKeyOnly) {
        doInsert(vendorPrimaryKeyOnly, null);
    }

    protected void doInsert(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, InsertOption<VendorPrimaryKeyOnlyCB> op) {
        assertObjectNotNull("vendorPrimaryKeyOnly", vendorPrimaryKeyOnly);
        prepareInsertOption(op);
        delegateInsert(vendorPrimaryKeyOnly, op);
    }

    protected void prepareInsertOption(InsertOption<VendorPrimaryKeyOnlyCB> op) {
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
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     * vendorPrimaryKeyOnly.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * vendorPrimaryKeyOnly.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorPrimaryKeyOnly.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">update</span>(vendorPrimaryKeyOnly);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param vendorPrimaryKeyOnly The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final VendorPrimaryKeyOnly vendorPrimaryKeyOnly) {
        doUpdate(vendorPrimaryKeyOnly, null);
    }

    protected void doUpdate(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, final UpdateOption<VendorPrimaryKeyOnlyCB> op) {
        assertObjectNotNull("vendorPrimaryKeyOnly", vendorPrimaryKeyOnly);
        prepareUpdateOption(op);
        helpUpdateInternally(vendorPrimaryKeyOnly, new InternalUpdateCallback<VendorPrimaryKeyOnly>() {
            public int callbackDelegateUpdate(VendorPrimaryKeyOnly et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<VendorPrimaryKeyOnlyCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected VendorPrimaryKeyOnlyCB createCBForVaryingUpdate() {
        VendorPrimaryKeyOnlyCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected VendorPrimaryKeyOnlyCB createCBForSpecifiedUpdate() {
        VendorPrimaryKeyOnlyCB cb = newMyConditionBean();
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
     * @param vendorPrimaryKeyOnly The entity of insert or update target. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(VendorPrimaryKeyOnly vendorPrimaryKeyOnly) {
        doInesrtOrUpdate(vendorPrimaryKeyOnly, null, null);
    }

    protected void doInesrtOrUpdate(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, final InsertOption<VendorPrimaryKeyOnlyCB> iop, final UpdateOption<VendorPrimaryKeyOnlyCB> uop) {
        helpInsertOrUpdateInternally(vendorPrimaryKeyOnly, new InternalInsertOrUpdateCallback<VendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB>() {
            public void callbackInsert(VendorPrimaryKeyOnly et) { doInsert(et, iop); }
            public void callbackUpdate(VendorPrimaryKeyOnly et) { doUpdate(et, uop); }
            public VendorPrimaryKeyOnlyCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(VendorPrimaryKeyOnlyCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<VendorPrimaryKeyOnlyCB>();
            uop = uop != null ? uop : new UpdateOption<VendorPrimaryKeyOnlyCB>();
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
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     * vendorPrimaryKeyOnly.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorPrimaryKeyOnly.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">delete</span>(vendorPrimaryKeyOnly);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param vendorPrimaryKeyOnly The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(VendorPrimaryKeyOnly vendorPrimaryKeyOnly) {
        doDelete(vendorPrimaryKeyOnly, null);
    }

    protected void doDelete(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, final DeleteOption<VendorPrimaryKeyOnlyCB> op) {
        assertObjectNotNull("vendorPrimaryKeyOnly", vendorPrimaryKeyOnly);
        prepareDeleteOption(op);
        helpDeleteInternally(vendorPrimaryKeyOnly, new InternalDeleteCallback<VendorPrimaryKeyOnly>() {
            public int callbackDelegateDelete(VendorPrimaryKeyOnly et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<VendorPrimaryKeyOnlyCB> op) {
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
     *     VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     *     vendorPrimaryKeyOnly.setFooName("foo");
     *     if (...) {
     *         vendorPrimaryKeyOnly.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     vendorPrimaryKeyOnlyList.add(vendorPrimaryKeyOnly);
     * }
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">batchInsert</span>(vendorPrimaryKeyOnlyList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param vendorPrimaryKeyOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList) {
        InsertOption<VendorPrimaryKeyOnlyCB> op = createInsertUpdateOption();
        return doBatchInsert(vendorPrimaryKeyOnlyList, op);
    }

    protected int[] doBatchInsert(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, InsertOption<VendorPrimaryKeyOnlyCB> op) {
        assertObjectNotNull("vendorPrimaryKeyOnlyList", vendorPrimaryKeyOnlyList);
        prepareBatchInsertOption(vendorPrimaryKeyOnlyList, op);
        return delegateBatchInsert(vendorPrimaryKeyOnlyList, op);
    }

    protected void prepareBatchInsertOption(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, InsertOption<VendorPrimaryKeyOnlyCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(vendorPrimaryKeyOnlyList);
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
     *     VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     *     vendorPrimaryKeyOnly.setFooName("foo");
     *     if (...) {
     *         vendorPrimaryKeyOnly.setFooPrice(123);
     *     } else {
     *         vendorPrimaryKeyOnly.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     vendorPrimaryKeyOnlyList.add(vendorPrimaryKeyOnly);
     * }
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">batchUpdate</span>(vendorPrimaryKeyOnlyList);
     * </pre>
     * @param vendorPrimaryKeyOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList) {
        UpdateOption<VendorPrimaryKeyOnlyCB> op = createPlainUpdateOption();
        return doBatchUpdate(vendorPrimaryKeyOnlyList, op);
    }

    protected int[] doBatchUpdate(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, UpdateOption<VendorPrimaryKeyOnlyCB> op) {
        assertObjectNotNull("vendorPrimaryKeyOnlyList", vendorPrimaryKeyOnlyList);
        prepareBatchUpdateOption(vendorPrimaryKeyOnlyList, op);
        return delegateBatchUpdate(vendorPrimaryKeyOnlyList, op);
    }

    protected void prepareBatchUpdateOption(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, UpdateOption<VendorPrimaryKeyOnlyCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(vendorPrimaryKeyOnlyList);
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
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">batchUpdate</span>(vendorPrimaryKeyOnlyList, new SpecifyQuery<VendorPrimaryKeyOnlyCB>() {
     *     public void specify(VendorPrimaryKeyOnlyCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">batchUpdate</span>(vendorPrimaryKeyOnlyList, new SpecifyQuery<VendorPrimaryKeyOnlyCB>() {
     *     public void specify(VendorPrimaryKeyOnlyCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param vendorPrimaryKeyOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, SpecifyQuery<VendorPrimaryKeyOnlyCB> updateColumnSpec) {
        return doBatchUpdate(vendorPrimaryKeyOnlyList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param vendorPrimaryKeyOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList) {
        return doBatchDelete(vendorPrimaryKeyOnlyList, null);
    }

    protected int[] doBatchDelete(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, DeleteOption<VendorPrimaryKeyOnlyCB> op) {
        assertObjectNotNull("vendorPrimaryKeyOnlyList", vendorPrimaryKeyOnlyList);
        prepareDeleteOption(op);
        return delegateBatchDelete(vendorPrimaryKeyOnlyList, op);
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
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;VendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB&gt;() {
     *     public ConditionBean setup(vendorPrimaryKeyOnly entity, VendorPrimaryKeyOnlyCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<VendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<VendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB> sp, InsertOption<VendorPrimaryKeyOnlyCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        VendorPrimaryKeyOnly e = new VendorPrimaryKeyOnly();
        VendorPrimaryKeyOnlyCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected VendorPrimaryKeyOnlyCB createCBForQueryInsert() {
        VendorPrimaryKeyOnlyCB cb = newMyConditionBean();
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
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.setPK...(value);</span>
     * vendorPrimaryKeyOnly.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.setVersionNo(value);</span>
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">queryUpdate</span>(vendorPrimaryKeyOnly, cb);
     * </pre>
     * @param vendorPrimaryKeyOnly The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB cb) {
        return doQueryUpdate(vendorPrimaryKeyOnly, cb, null);
    }

    protected int doQueryUpdate(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB cb, UpdateOption<VendorPrimaryKeyOnlyCB> op) {
        assertObjectNotNull("vendorPrimaryKeyOnly", vendorPrimaryKeyOnly); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(vendorPrimaryKeyOnly, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (VendorPrimaryKeyOnlyCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (VendorPrimaryKeyOnlyCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">queryDelete</span>(vendorPrimaryKeyOnly, cb);
     * </pre>
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(VendorPrimaryKeyOnlyCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(VendorPrimaryKeyOnlyCB cb, DeleteOption<VendorPrimaryKeyOnlyCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((VendorPrimaryKeyOnlyCB)cb); }
        else { return varyingQueryDelete((VendorPrimaryKeyOnlyCB)cb, downcast(op)); }
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
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * vendorPrimaryKeyOnly.setFoo...(value);
     * vendorPrimaryKeyOnly.setBar...(value);
     * InsertOption<VendorPrimaryKeyOnlyCB> option = new InsertOption<VendorPrimaryKeyOnlyCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">varyingInsert</span>(vendorPrimaryKeyOnly, option);
     * ... = vendorPrimaryKeyOnly.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param vendorPrimaryKeyOnly The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, InsertOption<VendorPrimaryKeyOnlyCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(vendorPrimaryKeyOnly, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     * vendorPrimaryKeyOnly.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * vendorPrimaryKeyOnly.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorPrimaryKeyOnly.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;VendorPrimaryKeyOnlyCB&gt; option = new UpdateOption&lt;VendorPrimaryKeyOnlyCB&gt;();
     *     option.self(new SpecifyQuery&lt;VendorPrimaryKeyOnlyCB&gt;() {
     *         public void specify(VendorPrimaryKeyOnlyCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">varyingUpdate</span>(vendorPrimaryKeyOnly, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param vendorPrimaryKeyOnly The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, UpdateOption<VendorPrimaryKeyOnlyCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(vendorPrimaryKeyOnly, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param vendorPrimaryKeyOnly The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, InsertOption<VendorPrimaryKeyOnlyCB> insertOption, UpdateOption<VendorPrimaryKeyOnlyCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(vendorPrimaryKeyOnly, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param vendorPrimaryKeyOnly The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, DeleteOption<VendorPrimaryKeyOnlyCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(vendorPrimaryKeyOnly, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param vendorPrimaryKeyOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, InsertOption<VendorPrimaryKeyOnlyCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(vendorPrimaryKeyOnlyList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param vendorPrimaryKeyOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, UpdateOption<VendorPrimaryKeyOnlyCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(vendorPrimaryKeyOnlyList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param vendorPrimaryKeyOnlyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<VendorPrimaryKeyOnly> vendorPrimaryKeyOnlyList, DeleteOption<VendorPrimaryKeyOnlyCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(vendorPrimaryKeyOnlyList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<VendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB> setupper, InsertOption<VendorPrimaryKeyOnlyCB> option) {
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
     * VendorPrimaryKeyOnly vendorPrimaryKeyOnly = new VendorPrimaryKeyOnly();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.setPK...(value);</span>
     * vendorPrimaryKeyOnly.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//vendorPrimaryKeyOnly.setVersionNo(value);</span>
     * VendorPrimaryKeyOnlyCB cb = new VendorPrimaryKeyOnlyCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;VendorPrimaryKeyOnlyCB&gt; option = new UpdateOption&lt;VendorPrimaryKeyOnlyCB&gt;();
     * option.self(new SpecifyQuery&lt;VendorPrimaryKeyOnlyCB&gt;() {
     *     public void specify(VendorPrimaryKeyOnlyCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * vendorPrimaryKeyOnlyBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(vendorPrimaryKeyOnly, cb, option);
     * </pre>
     * @param vendorPrimaryKeyOnly The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(VendorPrimaryKeyOnly vendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB cb, UpdateOption<VendorPrimaryKeyOnlyCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(vendorPrimaryKeyOnly, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of VendorPrimaryKeyOnly. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(VendorPrimaryKeyOnlyCB cb, DeleteOption<VendorPrimaryKeyOnlyCB> option) {
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
    public OutsideSqlBasicExecutor<VendorPrimaryKeyOnlyBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(VendorPrimaryKeyOnlyCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(VendorPrimaryKeyOnlyCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends VendorPrimaryKeyOnly> void delegateSelectCursor(VendorPrimaryKeyOnlyCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends VendorPrimaryKeyOnly> List<ENTITY> delegateSelectList(VendorPrimaryKeyOnlyCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(VendorPrimaryKeyOnly et, InsertOption<VendorPrimaryKeyOnlyCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(VendorPrimaryKeyOnly et, UpdateOption<VendorPrimaryKeyOnlyCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(VendorPrimaryKeyOnly et, UpdateOption<VendorPrimaryKeyOnlyCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(VendorPrimaryKeyOnly et, DeleteOption<VendorPrimaryKeyOnlyCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(VendorPrimaryKeyOnly et, DeleteOption<VendorPrimaryKeyOnlyCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<VendorPrimaryKeyOnly> ls, InsertOption<VendorPrimaryKeyOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<VendorPrimaryKeyOnly> ls, UpdateOption<VendorPrimaryKeyOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<VendorPrimaryKeyOnly> ls, UpdateOption<VendorPrimaryKeyOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<VendorPrimaryKeyOnly> ls, DeleteOption<VendorPrimaryKeyOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<VendorPrimaryKeyOnly> ls, DeleteOption<VendorPrimaryKeyOnlyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(VendorPrimaryKeyOnly et, VendorPrimaryKeyOnlyCB inCB, ConditionBean resCB, InsertOption<VendorPrimaryKeyOnlyCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(VendorPrimaryKeyOnly et, VendorPrimaryKeyOnlyCB cb, UpdateOption<VendorPrimaryKeyOnlyCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(VendorPrimaryKeyOnlyCB cb, DeleteOption<VendorPrimaryKeyOnlyCB> op)
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
    protected VendorPrimaryKeyOnly downcast(Entity et) {
        return helpEntityDowncastInternally(et, VendorPrimaryKeyOnly.class);
    }

    protected VendorPrimaryKeyOnlyCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, VendorPrimaryKeyOnlyCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<VendorPrimaryKeyOnly> downcast(List<? extends Entity> ls) {
        return (List<VendorPrimaryKeyOnly>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<VendorPrimaryKeyOnlyCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<VendorPrimaryKeyOnlyCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<VendorPrimaryKeyOnlyCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<VendorPrimaryKeyOnlyCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<VendorPrimaryKeyOnlyCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<VendorPrimaryKeyOnlyCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<VendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<VendorPrimaryKeyOnly, VendorPrimaryKeyOnlyCB>)sp;
    }
}
