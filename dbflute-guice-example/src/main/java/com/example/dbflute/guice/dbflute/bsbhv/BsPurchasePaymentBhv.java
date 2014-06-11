package com.example.dbflute.guice.dbflute.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.optional.OptionalEntity;
import org.seasar.dbflute.outsidesql.executor.*;
import com.example.dbflute.guice.dbflute.exbhv.*;
import com.example.dbflute.guice.dbflute.exentity.*;
import com.example.dbflute.guice.dbflute.bsentity.dbmeta.*;
import com.example.dbflute.guice.dbflute.cbean.*;

/**
 * The behavior of (購入支払)PURCHASE_PAYMENT as TABLE. <br />
 * <pre>
 * [primary key]
 *     PURCHASE_PAYMENT_ID
 *
 * [column]
 *     PURCHASE_PAYMENT_ID, PURCHASE_ID, PAYMENT_AMOUNT, PAYMENT_DATETIME, PAYMENT_METHOD_CODE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER
 *
 * [sequence]
 *     
 *
 * [identity]
 *     PURCHASE_PAYMENT_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     PURCHASE
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     purchase
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPurchasePaymentBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "PURCHASE_PAYMENT"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** {@inheritDoc} */
    public DBMeta getDBMeta() { return PurchasePaymentDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public PurchasePayment newEntity() { return new PurchasePayment(); }

    /** {@inheritDoc} */
    public PurchasePaymentCB newConditionBean() { return new PurchasePaymentCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * int count = purchasePaymentBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(PurchasePaymentCB cb) {
        return facadeSelectCount(cb);
    }

    protected int facadeSelectCount(PurchasePaymentCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(PurchasePaymentCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(PurchasePaymentCB cb) { // called by selectPage(cb)
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
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * OptionalEntity&lt;PurchasePayment&gt; entity = purchasePaymentBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     *
     * <span style="color: #3F7E5E">// if the data always exists as your business rule</span>
     * entity.<span style="color: #DD4747">required</span>(purchasePayment -&gt; {
     *     ...
     * });
     * PurchasePayment purchasePayment = entity.entity.<span style="color: #DD4747">get()</span>;
     *
     * <span style="color: #3F7E5E">// if it might be no data, ifPresent(), isPresent(), ...</span>
     * entity.<span style="color: #DD4747">ifPresent</span>(purchasePayment -&gt; {
     *     ...
     * });
     * if (entity.entity.<span style="color: #DD4747">isPresent()</span>) {
     *     PurchasePayment purchasePayment = entity.entity.<span style="color: #DD4747">get()</span>;
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<PurchasePayment> selectEntity(PurchasePaymentCB cb) {
        return facadeSelectEntity(cb);
    }

    protected OptionalEntity<PurchasePayment> facadeSelectEntity(PurchasePaymentCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends PurchasePayment> ENTITY doSelectEntity(PurchasePaymentCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, PurchasePaymentCB>() {
            public List<ENTITY> callbackSelectList(PurchasePaymentCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends PurchasePayment> OptionalEntity<ENTITY> doSelectOptionalEntity(PurchasePaymentCB cb, Class<ENTITY> tp) {
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
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * PurchasePayment purchasePayment = purchasePaymentBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = purchasePayment.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public PurchasePayment selectEntityWithDeletedCheck(PurchasePaymentCB cb) {
        return facadeSelectEntityWithDeletedCheck(cb);
    }

    protected PurchasePayment facadeSelectEntityWithDeletedCheck(PurchasePaymentCB cb) {
        return doSelectEntityWithDeletedCheck(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends PurchasePayment> ENTITY doSelectEntityWithDeletedCheck(PurchasePaymentCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, PurchasePaymentCB>() {
            public List<ENTITY> callbackSelectList(PurchasePaymentCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return facadeSelectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param purchasePaymentId (購入支払ID): PK, ID, NotNull, BIGINT(19). (NotNull)
     * @return The optional entity selected by the PK. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<PurchasePayment> selectByPK(Long purchasePaymentId) {
        return facadeSelectByPK(purchasePaymentId);
    }

    protected OptionalEntity<PurchasePayment> facadeSelectByPK(Long purchasePaymentId) {
        return doSelectOptionalByPK(purchasePaymentId, typeOfSelectedEntity());
    }

    protected <ENTITY extends PurchasePayment> ENTITY doSelectByPK(Long purchasePaymentId, Class<ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(purchasePaymentId), tp);
    }

    protected <ENTITY extends PurchasePayment> OptionalEntity<ENTITY> doSelectOptionalByPK(Long purchasePaymentId, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(purchasePaymentId, tp), purchasePaymentId);
    }

    protected PurchasePaymentCB xprepareCBAsPK(Long purchasePaymentId) {
        assertObjectNotNull("purchasePaymentId", purchasePaymentId);
        PurchasePaymentCB cb = newConditionBean(); cb.acceptPrimaryKey(purchasePaymentId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;PurchasePayment&gt; purchasePaymentList = purchasePaymentBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (PurchasePayment purchasePayment : purchasePaymentList) {
     *     ... = purchasePayment.get...();
     * }
     * </pre>
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<PurchasePayment> selectList(PurchasePaymentCB cb) {
        return facadeSelectList(cb);
    }

    protected ListResultBean<PurchasePayment> facadeSelectList(PurchasePaymentCB cb) {
        return doSelectList(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends PurchasePayment> ListResultBean<ENTITY> doSelectList(PurchasePaymentCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, PurchasePaymentCB>() {
            public List<ENTITY> callbackSelectList(PurchasePaymentCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;PurchasePayment&gt; page = purchasePaymentBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (PurchasePayment purchasePayment : page) {
     *     ... = purchasePayment.get...();
     * }
     * </pre>
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<PurchasePayment> selectPage(PurchasePaymentCB cb) {
        return facadeSelectPage(cb);
    }

    protected PagingResultBean<PurchasePayment> facadeSelectPage(PurchasePaymentCB cb) {
        return doSelectPage(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends PurchasePayment> PagingResultBean<ENTITY> doSelectPage(PurchasePaymentCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, PurchasePaymentCB>() {
            public int callbackSelectCount(PurchasePaymentCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(PurchasePaymentCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * purchasePaymentBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;PurchasePayment&gt;() {
     *     public void handle(PurchasePayment entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @param entityRowHandler The handler of entity row of PurchasePayment. (NotNull)
     */
    public void selectCursor(PurchasePaymentCB cb, EntityRowHandler<PurchasePayment> entityRowHandler) {
        facadeSelectCursor(cb, entityRowHandler);
    }

    protected void facadeSelectCursor(PurchasePaymentCB cb, EntityRowHandler<PurchasePayment> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, typeOfSelectedEntity());
    }

    protected <ENTITY extends PurchasePayment> void doSelectCursor(PurchasePaymentCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, PurchasePaymentCB>() {
            public void callbackSelectCursor(PurchasePaymentCB lcb, EntityRowHandler<ENTITY> lhandler, Class<ENTITY> ltp) { delegateSelectCursor(lcb, lhandler, ltp); }
            public List<ENTITY> callbackSelectList(PurchasePaymentCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * purchasePaymentBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(PurchasePaymentCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<PurchasePaymentCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return facadeScalarSelect(resultType);
    }

    protected <RESULT> SLFunction<PurchasePaymentCB, RESULT> facadeScalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newConditionBean());
    }

    protected <RESULT, CB extends PurchasePaymentCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends PurchasePaymentCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
        return new SLFunction<CB, RESULT>(cb, tp);
    }

    protected <RESULT> SLFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> tp) {
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
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Purchase'.
     * @param purchasePaymentList The list of purchasePayment. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Purchase> pulloutPurchase(List<PurchasePayment> purchasePaymentList) {
        return helpPulloutInternally(purchasePaymentList, new InternalPulloutCallback<PurchasePayment, Purchase>() {
            public Purchase getFr(PurchasePayment et)
            { return et.getPurchase().orElseNull(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Purchase et, List<PurchasePayment> ls)
            { et.setPurchasePaymentList(ls); }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key purchasePaymentId.
     * @param purchasePaymentList The list of purchasePayment. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractPurchasePaymentIdList(List<PurchasePayment> purchasePaymentList) {
        return helpExtractListInternally(purchasePaymentList, new InternalExtractCallback<PurchasePayment, Long>() {
            public Long getCV(PurchasePayment et) { return et.getPurchasePaymentId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * PurchasePayment purchasePayment = new PurchasePayment();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * purchasePayment.setFoo...(value);
     * purchasePayment.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//purchasePayment.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//purchasePayment.set...;</span>
     * purchasePaymentBhv.<span style="color: #DD4747">insert</span>(purchasePayment);
     * ... = purchasePayment.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param purchasePayment The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(PurchasePayment purchasePayment) {
        doInsert(purchasePayment, null);
    }

    protected void doInsert(PurchasePayment et, InsertOption<PurchasePaymentCB> op) {
        assertObjectNotNull("purchasePayment", et);
        prepareInsertOption(op);
        delegateInsert(et, op);
    }

    protected void prepareInsertOption(InsertOption<PurchasePaymentCB> op) {
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
     * PurchasePayment purchasePayment = new PurchasePayment();
     * purchasePayment.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * purchasePayment.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//purchasePayment.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//purchasePayment.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * purchasePayment.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     purchasePaymentBhv.<span style="color: #DD4747">update</span>(purchasePayment);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param purchasePayment The entity of update. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(PurchasePayment purchasePayment) {
        doUpdate(purchasePayment, null);
    }

    protected void doUpdate(PurchasePayment et, final UpdateOption<PurchasePaymentCB> op) {
        assertObjectNotNull("purchasePayment", et);
        prepareUpdateOption(op);
        helpUpdateInternally(et, new InternalUpdateCallback<PurchasePayment>() {
            public int callbackDelegateUpdate(PurchasePayment let) { return delegateUpdate(let, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<PurchasePaymentCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) { op.resolveSelfSpecification(createCBForVaryingUpdate()); }
        if (op.hasSpecifiedUpdateColumn()) { op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected PurchasePaymentCB createCBForVaryingUpdate()
    { PurchasePaymentCB cb = newConditionBean(); cb.xsetupForVaryingUpdate(); return cb; }

    protected PurchasePaymentCB createCBForSpecifiedUpdate()
    { PurchasePaymentCB cb = newConditionBean(); cb.xsetupForSpecifiedUpdate(); return cb; }

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
     * @param purchasePayment The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(PurchasePayment purchasePayment) {
        doInsertOrUpdate(purchasePayment, null, null);
    }

    protected void doInsertOrUpdate(PurchasePayment et, final InsertOption<PurchasePaymentCB> iop, final UpdateOption<PurchasePaymentCB> uop) {
        assertObjectNotNull("purchasePayment", et);
        helpInsertOrUpdateInternally(et, new InternalInsertOrUpdateCallback<PurchasePayment, PurchasePaymentCB>() {
            public void callbackInsert(PurchasePayment let) { doInsert(let, iop); }
            public void callbackUpdate(PurchasePayment let) { doUpdate(let, uop); }
            public PurchasePaymentCB callbackNewMyConditionBean() { return newConditionBean(); }
            public int callbackSelectCount(PurchasePaymentCB cb) { return selectCount(cb); }
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
     * PurchasePayment purchasePayment = new PurchasePayment();
     * purchasePayment.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * purchasePayment.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     purchasePaymentBhv.<span style="color: #DD4747">delete</span>(purchasePayment);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param purchasePayment The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(PurchasePayment purchasePayment) {
        doDelete(purchasePayment, null);
    }

    protected void doDelete(PurchasePayment et, final DeleteOption<PurchasePaymentCB> op) {
        assertObjectNotNull("purchasePayment", et);
        prepareDeleteOption(op);
        helpDeleteInternally(et, new InternalDeleteCallback<PurchasePayment>() {
            public int callbackDelegateDelete(PurchasePayment let) { return delegateDelete(let, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<PurchasePaymentCB> op)
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
     *     PurchasePayment purchasePayment = new PurchasePayment();
     *     purchasePayment.setFooName("foo");
     *     if (...) {
     *         purchasePayment.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     purchasePaymentList.add(purchasePayment);
     * }
     * purchasePaymentBhv.<span style="color: #DD4747">batchInsert</span>(purchasePaymentList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param purchasePaymentList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<PurchasePayment> purchasePaymentList) {
        return doBatchInsert(purchasePaymentList, null);
    }

    protected int[] doBatchInsert(List<PurchasePayment> ls, InsertOption<PurchasePaymentCB> op) {
        assertObjectNotNull("purchasePaymentList", ls);
        InsertOption<PurchasePaymentCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainInsertOption(); }
        prepareBatchInsertOption(ls, rlop); // required
        return delegateBatchInsert(ls, rlop);
    }

    protected void prepareBatchInsertOption(List<PurchasePayment> ls, InsertOption<PurchasePaymentCB> op) {
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
     *     PurchasePayment purchasePayment = new PurchasePayment();
     *     purchasePayment.setFooName("foo");
     *     if (...) {
     *         purchasePayment.setFooPrice(123);
     *     } else {
     *         purchasePayment.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//purchasePayment.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     purchasePaymentList.add(purchasePayment);
     * }
     * purchasePaymentBhv.<span style="color: #DD4747">batchUpdate</span>(purchasePaymentList);
     * </pre>
     * @param purchasePaymentList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<PurchasePayment> purchasePaymentList) {
        return doBatchUpdate(purchasePaymentList, null);
    }

    protected int[] doBatchUpdate(List<PurchasePayment> ls, UpdateOption<PurchasePaymentCB> op) {
        assertObjectNotNull("purchasePaymentList", ls);
        UpdateOption<PurchasePaymentCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop); // required
        return delegateBatchUpdate(ls, rlop);
    }

    protected void prepareBatchUpdateOption(List<PurchasePayment> ls, UpdateOption<PurchasePaymentCB> op) {
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
     * purchasePaymentBhv.<span style="color: #DD4747">batchUpdate</span>(purchasePaymentList, new SpecifyQuery<PurchasePaymentCB>() {
     *     public void specify(PurchasePaymentCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * purchasePaymentBhv.<span style="color: #DD4747">batchUpdate</span>(purchasePaymentList, new SpecifyQuery<PurchasePaymentCB>() {
     *     public void specify(PurchasePaymentCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param purchasePaymentList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<PurchasePayment> purchasePaymentList, SpecifyQuery<PurchasePaymentCB> updateColumnSpec) {
        return doBatchUpdate(purchasePaymentList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param purchasePaymentList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<PurchasePayment> purchasePaymentList) {
        return doBatchDelete(purchasePaymentList, null);
    }

    protected int[] doBatchDelete(List<PurchasePayment> ls, DeleteOption<PurchasePaymentCB> op) {
        assertObjectNotNull("purchasePaymentList", ls);
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
     * purchasePaymentBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;PurchasePayment, PurchasePaymentCB&gt;() {
     *     public ConditionBean setup(purchasePayment entity, PurchasePaymentCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<PurchasePayment, PurchasePaymentCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<PurchasePayment, PurchasePaymentCB> sp, InsertOption<PurchasePaymentCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        PurchasePayment et = newEntity();
        PurchasePaymentCB cb = createCBForQueryInsert();
        return delegateQueryInsert(et, cb, sp.setup(et, cb), op);
    }

    protected PurchasePaymentCB createCBForQueryInsert()
    { PurchasePaymentCB cb = newConditionBean(); cb.xsetupForQueryInsert(); return cb; }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> op) {
        return doQueryInsert(downcast(setupper), downcast(op));
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * PurchasePayment purchasePayment = new PurchasePayment();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//purchasePayment.setPK...(value);</span>
     * purchasePayment.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//purchasePayment.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//purchasePayment.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//purchasePayment.setVersionNo(value);</span>
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * purchasePaymentBhv.<span style="color: #DD4747">queryUpdate</span>(purchasePayment, cb);
     * </pre>
     * @param purchasePayment The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(PurchasePayment purchasePayment, PurchasePaymentCB cb) {
        return doQueryUpdate(purchasePayment, cb, null);
    }

    protected int doQueryUpdate(PurchasePayment et, PurchasePaymentCB cb, UpdateOption<PurchasePaymentCB> op) {
        assertObjectNotNull("purchasePayment", et); assertCBStateValid(cb);
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
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * purchasePaymentBhv.<span style="color: #DD4747">queryDelete</span>(purchasePayment, cb);
     * </pre>
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(PurchasePaymentCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(PurchasePaymentCB cb, DeleteOption<PurchasePaymentCB> op) {
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
     * PurchasePayment purchasePayment = new PurchasePayment();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * purchasePayment.setFoo...(value);
     * purchasePayment.setBar...(value);
     * InsertOption<PurchasePaymentCB> option = new InsertOption<PurchasePaymentCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * purchasePaymentBhv.<span style="color: #DD4747">varyingInsert</span>(purchasePayment, option);
     * ... = purchasePayment.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param purchasePayment The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(PurchasePayment purchasePayment, InsertOption<PurchasePaymentCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(purchasePayment, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * PurchasePayment purchasePayment = new PurchasePayment();
     * purchasePayment.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * purchasePayment.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * purchasePayment.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;PurchasePaymentCB&gt; option = new UpdateOption&lt;PurchasePaymentCB&gt;();
     *     option.self(new SpecifyQuery&lt;PurchasePaymentCB&gt;() {
     *         public void specify(PurchasePaymentCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     purchasePaymentBhv.<span style="color: #DD4747">varyingUpdate</span>(purchasePayment, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param purchasePayment The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(PurchasePayment purchasePayment, UpdateOption<PurchasePaymentCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(purchasePayment, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param purchasePayment The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(PurchasePayment purchasePayment, InsertOption<PurchasePaymentCB> insertOption, UpdateOption<PurchasePaymentCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdate(purchasePayment, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param purchasePayment The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(PurchasePayment purchasePayment, DeleteOption<PurchasePaymentCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(purchasePayment, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param purchasePaymentList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<PurchasePayment> purchasePaymentList, InsertOption<PurchasePaymentCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(purchasePaymentList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param purchasePaymentList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<PurchasePayment> purchasePaymentList, UpdateOption<PurchasePaymentCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(purchasePaymentList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param purchasePaymentList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<PurchasePayment> purchasePaymentList, DeleteOption<PurchasePaymentCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(purchasePaymentList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<PurchasePayment, PurchasePaymentCB> setupper, InsertOption<PurchasePaymentCB> option) {
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
     * PurchasePayment purchasePayment = new PurchasePayment();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//purchasePayment.setPK...(value);</span>
     * purchasePayment.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//purchasePayment.setVersionNo(value);</span>
     * PurchasePaymentCB cb = new PurchasePaymentCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;PurchasePaymentCB&gt; option = new UpdateOption&lt;PurchasePaymentCB&gt;();
     * option.self(new SpecifyQuery&lt;PurchasePaymentCB&gt;() {
     *     public void specify(PurchasePaymentCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * purchasePaymentBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(purchasePayment, cb, option);
     * </pre>
     * @param purchasePayment The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(PurchasePayment purchasePayment, PurchasePaymentCB cb, UpdateOption<PurchasePaymentCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(purchasePayment, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of PurchasePayment. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(PurchasePaymentCB cb, DeleteOption<PurchasePaymentCB> option) {
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
    public OutsideSqlBasicExecutor<PurchasePaymentBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(PurchasePaymentCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(PurchasePaymentCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends PurchasePayment> void delegateSelectCursor(PurchasePaymentCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends PurchasePayment> List<ENTITY> delegateSelectList(PurchasePaymentCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(PurchasePayment et, InsertOption<PurchasePaymentCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(PurchasePayment et, UpdateOption<PurchasePaymentCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(PurchasePayment et, UpdateOption<PurchasePaymentCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(PurchasePayment et, DeleteOption<PurchasePaymentCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(PurchasePayment et, DeleteOption<PurchasePaymentCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<PurchasePayment> ls, InsertOption<PurchasePaymentCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<PurchasePayment> ls, UpdateOption<PurchasePaymentCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<PurchasePayment> ls, UpdateOption<PurchasePaymentCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<PurchasePayment> ls, DeleteOption<PurchasePaymentCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<PurchasePayment> ls, DeleteOption<PurchasePaymentCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(PurchasePayment et, PurchasePaymentCB inCB, ConditionBean resCB, InsertOption<PurchasePaymentCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(PurchasePayment et, PurchasePaymentCB cb, UpdateOption<PurchasePaymentCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(PurchasePaymentCB cb, DeleteOption<PurchasePaymentCB> op)
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
    protected Class<PurchasePayment> typeOfSelectedEntity()
    { return PurchasePayment.class; }

    protected PurchasePayment downcast(Entity et)
    { return helpEntityDowncastInternally(et, PurchasePayment.class); }

    protected PurchasePaymentCB downcast(ConditionBean cb)
    { return helpConditionBeanDowncastInternally(cb, PurchasePaymentCB.class); }

    @SuppressWarnings("unchecked")
    protected List<PurchasePayment> downcast(List<? extends Entity> ls)
    { return (List<PurchasePayment>)ls; }

    @SuppressWarnings("unchecked")
    protected InsertOption<PurchasePaymentCB> downcast(InsertOption<? extends ConditionBean> op)
    { return (InsertOption<PurchasePaymentCB>)op; }

    @SuppressWarnings("unchecked")
    protected UpdateOption<PurchasePaymentCB> downcast(UpdateOption<? extends ConditionBean> op)
    { return (UpdateOption<PurchasePaymentCB>)op; }

    @SuppressWarnings("unchecked")
    protected DeleteOption<PurchasePaymentCB> downcast(DeleteOption<? extends ConditionBean> op)
    { return (DeleteOption<PurchasePaymentCB>)op; }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<PurchasePayment, PurchasePaymentCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp)
    { return (QueryInsertSetupper<PurchasePayment, PurchasePaymentCB>)sp; }
}
