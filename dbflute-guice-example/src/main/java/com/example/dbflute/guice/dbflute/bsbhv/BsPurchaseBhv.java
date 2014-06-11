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
 * The behavior of (購入)PURCHASE as TABLE. <br />
 * <pre>
 * [primary key]
 *     PURCHASE_ID
 *
 * [column]
 *     PURCHASE_ID, MEMBER_ID, PRODUCT_ID, PURCHASE_DATETIME, PURCHASE_COUNT, PURCHASE_PRICE, PAYMENT_COMPLETE_FLG, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 *
 * [sequence]
 *     PUBLIC.SEQ_PURCHASE
 *
 * [identity]
 *     PURCHASE_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     MEMBER, PRODUCT, SUMMARY_PRODUCT, MEMBER_LOGIN(AsBizManyToOne)
 *
 * [referrer table]
 *     PURCHASE_PAYMENT
 *
 * [foreign property]
 *     member, product, summaryProduct, memberLoginAsBizManyToOne
 *
 * [referrer property]
 *     purchasePaymentList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPurchaseBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "PURCHASE"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** {@inheritDoc} */
    public DBMeta getDBMeta() { return PurchaseDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Purchase newEntity() { return new Purchase(); }

    /** {@inheritDoc} */
    public PurchaseCB newConditionBean() { return new PurchaseCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * int count = purchaseBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of Purchase. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(PurchaseCB cb) {
        return facadeSelectCount(cb);
    }

    protected int facadeSelectCount(PurchaseCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(PurchaseCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(PurchaseCB cb) { // called by selectPage(cb)
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
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * OptionalEntity&lt;Purchase&gt; entity = purchaseBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     *
     * <span style="color: #3F7E5E">// if the data always exists as your business rule</span>
     * entity.<span style="color: #DD4747">required</span>(purchase -&gt; {
     *     ...
     * });
     * Purchase purchase = entity.entity.<span style="color: #DD4747">get()</span>;
     *
     * <span style="color: #3F7E5E">// if it might be no data, ifPresent(), isPresent(), ...</span>
     * entity.<span style="color: #DD4747">ifPresent</span>(purchase -&gt; {
     *     ...
     * });
     * if (entity.entity.<span style="color: #DD4747">isPresent()</span>) {
     *     Purchase purchase = entity.entity.<span style="color: #DD4747">get()</span>;
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of Purchase. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<Purchase> selectEntity(PurchaseCB cb) {
        return facadeSelectEntity(cb);
    }

    protected OptionalEntity<Purchase> facadeSelectEntity(PurchaseCB cb) {
        return doSelectOptionalEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends Purchase> ENTITY doSelectEntity(PurchaseCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, PurchaseCB>() {
            public List<ENTITY> callbackSelectList(PurchaseCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends Purchase> OptionalEntity<ENTITY> doSelectOptionalEntity(PurchaseCB cb, Class<ENTITY> tp) {
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
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * Purchase purchase = purchaseBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = purchase.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of Purchase. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public Purchase selectEntityWithDeletedCheck(PurchaseCB cb) {
        return facadeSelectEntityWithDeletedCheck(cb);
    }

    protected Purchase facadeSelectEntityWithDeletedCheck(PurchaseCB cb) {
        return doSelectEntityWithDeletedCheck(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends Purchase> ENTITY doSelectEntityWithDeletedCheck(PurchaseCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, PurchaseCB>() {
            public List<ENTITY> callbackSelectList(PurchaseCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return facadeSelectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param purchaseId : PK, ID, NotNull, BIGINT(19). (NotNull)
     * @return The optional entity selected by the PK. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<Purchase> selectByPK(Long purchaseId) {
        return facadeSelectByPK(purchaseId);
    }

    protected OptionalEntity<Purchase> facadeSelectByPK(Long purchaseId) {
        return doSelectOptionalByPK(purchaseId, typeOfSelectedEntity());
    }

    protected <ENTITY extends Purchase> ENTITY doSelectByPK(Long purchaseId, Class<ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(purchaseId), tp);
    }

    protected <ENTITY extends Purchase> OptionalEntity<ENTITY> doSelectOptionalByPK(Long purchaseId, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(purchaseId, tp), purchaseId);
    }

    protected PurchaseCB xprepareCBAsPK(Long purchaseId) {
        assertObjectNotNull("purchaseId", purchaseId);
        PurchaseCB cb = newConditionBean(); cb.acceptPrimaryKey(purchaseId);
        return cb;
    }

    /**
     * Select the entity by the unique-key value.
     * @param memberId (会員ID): UQ+, IX+, NotNull, INTEGER(10), FK to MEMBER. (NotNull)
     * @param productId (商品ID): +UQ, IX+, NotNull, INTEGER(10), FK to PRODUCT. (NotNull)
     * @param purchaseDatetime (購入日時): +UQ, IX+, NotNull, TIMESTAMP(23, 10). (NotNull)
     * @return The optional entity selected by the unique key. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<Purchase> selectByUniqueOf(Integer memberId, Integer productId, java.sql.Timestamp purchaseDatetime) {
        return facadeSelectByUniqueOf(memberId, productId, purchaseDatetime);
    }

    protected OptionalEntity<Purchase> facadeSelectByUniqueOf(Integer memberId, Integer productId, java.sql.Timestamp purchaseDatetime) {
        return doSelectByUniqueOf(memberId, productId, purchaseDatetime, typeOfSelectedEntity());
    }

    protected <ENTITY extends Purchase> OptionalEntity<ENTITY> doSelectByUniqueOf(Integer memberId, Integer productId, java.sql.Timestamp purchaseDatetime, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(xprepareCBAsUniqueOf(memberId, productId, purchaseDatetime), tp), memberId, productId, purchaseDatetime);
    }

    protected PurchaseCB xprepareCBAsUniqueOf(Integer memberId, Integer productId, java.sql.Timestamp purchaseDatetime) {
        assertObjectNotNull("memberId", memberId);assertObjectNotNull("productId", productId);assertObjectNotNull("purchaseDatetime", purchaseDatetime);
        PurchaseCB cb = newConditionBean(); cb.acceptUniqueOf(memberId, productId, purchaseDatetime);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;Purchase&gt; purchaseList = purchaseBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (Purchase purchase : purchaseList) {
     *     ... = purchase.get...();
     * }
     * </pre>
     * @param cb The condition-bean of Purchase. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<Purchase> selectList(PurchaseCB cb) {
        return facadeSelectList(cb);
    }

    protected ListResultBean<Purchase> facadeSelectList(PurchaseCB cb) {
        return doSelectList(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends Purchase> ListResultBean<ENTITY> doSelectList(PurchaseCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, PurchaseCB>() {
            public List<ENTITY> callbackSelectList(PurchaseCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;Purchase&gt; page = purchaseBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (Purchase purchase : page) {
     *     ... = purchase.get...();
     * }
     * </pre>
     * @param cb The condition-bean of Purchase. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<Purchase> selectPage(PurchaseCB cb) {
        return facadeSelectPage(cb);
    }

    protected PagingResultBean<Purchase> facadeSelectPage(PurchaseCB cb) {
        return doSelectPage(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends Purchase> PagingResultBean<ENTITY> doSelectPage(PurchaseCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, PurchaseCB>() {
            public int callbackSelectCount(PurchaseCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(PurchaseCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * purchaseBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;Purchase&gt;() {
     *     public void handle(Purchase entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of Purchase. (NotNull)
     * @param entityRowHandler The handler of entity row of Purchase. (NotNull)
     */
    public void selectCursor(PurchaseCB cb, EntityRowHandler<Purchase> entityRowHandler) {
        facadeSelectCursor(cb, entityRowHandler);
    }

    protected void facadeSelectCursor(PurchaseCB cb, EntityRowHandler<Purchase> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, typeOfSelectedEntity());
    }

    protected <ENTITY extends Purchase> void doSelectCursor(PurchaseCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, PurchaseCB>() {
            public void callbackSelectCursor(PurchaseCB lcb, EntityRowHandler<ENTITY> lhandler, Class<ENTITY> ltp) { delegateSelectCursor(lcb, lhandler, ltp); }
            public List<ENTITY> callbackSelectList(PurchaseCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * purchaseBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(PurchaseCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<PurchaseCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return facadeScalarSelect(resultType);
    }

    protected <RESULT> SLFunction<PurchaseCB, RESULT> facadeScalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newConditionBean());
    }

    protected <RESULT, CB extends PurchaseCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends PurchaseCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
        return new SLFunction<CB, RESULT>(cb, tp);
    }

    protected <RESULT> SLFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> tp) {
        return facadeScalarSelect(tp);
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    /**
     * Select the next value as sequence. <br />
     * This method is called when insert() and set to primary-key automatically.
     * So you don't need to call this as long as you need to get next value before insert().
     * @return The next value. (NotNull)
     */
    public Long selectNextVal() {
        return facadeSelectNextVal();
    }

    protected Long facadeSelectNextVal() {
        return doSelectNextVal(Long.class);
    }

    protected <RESULT> RESULT doSelectNextVal(Class<RESULT> tp) {
        return delegateSelectNextVal(tp);
    }

    @Override
    protected Number doReadNextVal() {
        return facadeSelectNextVal();
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * Load referrer of purchasePaymentList by the set-upper of referrer. <br />
     * (購入支払)PURCHASE_PAYMENT by PURCHASE_ID, named 'purchasePaymentList'.
     * <pre>
     * purchaseBhv.<span style="color: #DD4747">loadPurchasePaymentList</span>(purchaseList, new ReferrerConditionSetupper&lt;PurchasePaymentCB&gt;() {
     *     public void setup(PurchasePaymentCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * for (Purchase purchase : purchaseList) {
     *     ... = purchase.<span style="color: #DD4747">getPurchasePaymentList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setPurchaseId_InScope(pkList);
     * cb.query().addOrderBy_PurchaseId_Asc();
     * </pre>
     * @param purchaseList The entity list of purchase. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<PurchasePayment> loadPurchasePaymentList(List<Purchase> purchaseList, ReferrerConditionSetupper<PurchasePaymentCB> setupper) {
        xassLRArg(purchaseList, setupper);
        return doLoadPurchasePaymentList(purchaseList, new LoadReferrerOption<PurchasePaymentCB, PurchasePayment>().xinit(setupper));
    }

    /**
     * Load referrer of purchasePaymentList by the set-upper of referrer. <br />
     * (購入支払)PURCHASE_PAYMENT by PURCHASE_ID, named 'purchasePaymentList'.
     * <pre>
     * purchaseBhv.<span style="color: #DD4747">loadPurchasePaymentList</span>(purchaseList, new ReferrerConditionSetupper&lt;PurchasePaymentCB&gt;() {
     *     public void setup(PurchasePaymentCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = purchase.<span style="color: #DD4747">getPurchasePaymentList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setPurchaseId_InScope(pkList);
     * cb.query().addOrderBy_PurchaseId_Asc();
     * </pre>
     * @param purchase The entity of purchase. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<PurchasePayment> loadPurchasePaymentList(Purchase purchase, ReferrerConditionSetupper<PurchasePaymentCB> setupper) {
        xassLRArg(purchase, setupper);
        return doLoadPurchasePaymentList(xnewLRLs(purchase), new LoadReferrerOption<PurchasePaymentCB, PurchasePayment>().xinit(setupper));
    }

    protected NestedReferrerLoader<PurchasePayment> doLoadPurchasePaymentList(List<Purchase> purchaseList, LoadReferrerOption<PurchasePaymentCB, PurchasePayment> option) {
        final PurchasePaymentBhv referrerBhv = xgetBSFLR().select(PurchasePaymentBhv.class);
        return helpLoadReferrerInternally(purchaseList, option, new InternalLoadReferrerCallback<Purchase, Long, PurchasePaymentCB, PurchasePayment>() {
            public Long getPKVal(Purchase et)
            { return et.getPurchaseId(); }
            public void setRfLs(Purchase et, List<PurchasePayment> ls)
            { et.setPurchasePaymentList(ls); }
            public PurchasePaymentCB newMyCB() { return referrerBhv.newConditionBean(); }
            public void qyFKIn(PurchasePaymentCB cb, List<Long> ls)
            { cb.query().setPurchaseId_InScope(ls); }
            public void qyOdFKAsc(PurchasePaymentCB cb) { cb.query().addOrderBy_PurchaseId_Asc(); }
            public void spFKCol(PurchasePaymentCB cb) { cb.specify().columnPurchaseId(); }
            public List<PurchasePayment> selRfLs(PurchasePaymentCB cb) { return referrerBhv.selectList(cb); }
            public Long getFKVal(PurchasePayment re) { return re.getPurchaseId(); }
            public void setlcEt(PurchasePayment re, Purchase le)
            { re.setPurchase(OptionalEntity.of(le)); }
            public String getRfPrNm() { return "purchasePaymentList"; }
        });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Member'.
     * @param purchaseList The list of purchase. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMember(List<Purchase> purchaseList) {
        return helpPulloutInternally(purchaseList, new InternalPulloutCallback<Purchase, Member>() {
            public Member getFr(Purchase et)
            { return et.getMember().orElseNull(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member et, List<Purchase> ls)
            { et.setPurchaseList(ls); }
        });
    }

    /**
     * Pull out the list of foreign table 'Product'.
     * @param purchaseList The list of purchase. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Product> pulloutProduct(List<Purchase> purchaseList) {
        return helpPulloutInternally(purchaseList, new InternalPulloutCallback<Purchase, Product>() {
            public Product getFr(Purchase et)
            { return et.getProduct().orElseNull(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Product et, List<Purchase> ls)
            { et.setPurchaseList(ls); }
        });
    }

    /**
     * Pull out the list of foreign table 'SummaryProduct'.
     * @param purchaseList The list of purchase. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<SummaryProduct> pulloutSummaryProduct(List<Purchase> purchaseList) {
        return helpPulloutInternally(purchaseList, new InternalPulloutCallback<Purchase, SummaryProduct>() {
            public SummaryProduct getFr(Purchase et)
            { return et.getSummaryProduct().orElseNull(); }
            public boolean hasRf() { return true; }
            public void setRfLs(SummaryProduct et, List<Purchase> ls)
            { et.setPurchaseList(ls); }
        });
    }

    /**
     * Pull out the list of foreign table 'MemberLogin'.
     * @param purchaseList The list of purchase. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<MemberLogin> pulloutMemberLoginAsBizManyToOne(List<Purchase> purchaseList) {
        return helpPulloutInternally(purchaseList, new InternalPulloutCallback<Purchase, MemberLogin>() {
            public MemberLogin getFr(Purchase et)
            { return et.getMemberLoginAsBizManyToOne().orElseNull(); }
            public boolean hasRf() { return false; }
            public void setRfLs(MemberLogin et, List<Purchase> ls)
            { throw new UnsupportedOperationException(); }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key purchaseId.
     * @param purchaseList The list of purchase. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractPurchaseIdList(List<Purchase> purchaseList) {
        return helpExtractListInternally(purchaseList, new InternalExtractCallback<Purchase, Long>() {
            public Long getCV(Purchase et) { return et.getPurchaseId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * Purchase purchase = new Purchase();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * purchase.setFoo...(value);
     * purchase.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//purchase.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//purchase.set...;</span>
     * purchaseBhv.<span style="color: #DD4747">insert</span>(purchase);
     * ... = purchase.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param purchase The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(Purchase purchase) {
        doInsert(purchase, null);
    }

    protected void doInsert(Purchase et, InsertOption<PurchaseCB> op) {
        assertObjectNotNull("purchase", et);
        prepareInsertOption(op);
        delegateInsert(et, op);
    }

    protected void prepareInsertOption(InsertOption<PurchaseCB> op) {
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
     * Purchase purchase = new Purchase();
     * purchase.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * purchase.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//purchase.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//purchase.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * purchase.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     purchaseBhv.<span style="color: #DD4747">update</span>(purchase);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param purchase The entity of update. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(Purchase purchase) {
        doUpdate(purchase, null);
    }

    protected void doUpdate(Purchase et, final UpdateOption<PurchaseCB> op) {
        assertObjectNotNull("purchase", et);
        prepareUpdateOption(op);
        helpUpdateInternally(et, new InternalUpdateCallback<Purchase>() {
            public int callbackDelegateUpdate(Purchase let) { return delegateUpdate(let, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<PurchaseCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) { op.resolveSelfSpecification(createCBForVaryingUpdate()); }
        if (op.hasSpecifiedUpdateColumn()) { op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected PurchaseCB createCBForVaryingUpdate()
    { PurchaseCB cb = newConditionBean(); cb.xsetupForVaryingUpdate(); return cb; }

    protected PurchaseCB createCBForSpecifiedUpdate()
    { PurchaseCB cb = newConditionBean(); cb.xsetupForSpecifiedUpdate(); return cb; }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        doUpdate(downcast(et), downcast(op));
    }

    /**
     * Update the entity non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * Purchase purchase = new Purchase();
     * purchase.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * purchase.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//purchase.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//purchase.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//purchase.setVersionNo(value);</span>
     * purchaseBhv.<span style="color: #DD4747">updateNonstrict</span>(purchase);
     * </pre>
     * @param purchase The entity of update. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(Purchase purchase) {
        doUpdateNonstrict(purchase, null);
    }

    protected void doUpdateNonstrict(Purchase et, final UpdateOption<PurchaseCB> op) {
        assertObjectNotNull("purchase", et);
        prepareUpdateOption(op);
        helpUpdateNonstrictInternally(et, new InternalUpdateNonstrictCallback<Purchase>() {
            public int callbackDelegateUpdateNonstrict(Purchase let) { return delegateUpdateNonstrict(let, op); } });
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        doUpdateNonstrict(downcast(et), downcast(op));
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, ExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param purchase The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(Purchase purchase) {
        doInsertOrUpdate(purchase, null, null);
    }

    protected void doInsertOrUpdate(Purchase et, final InsertOption<PurchaseCB> iop, final UpdateOption<PurchaseCB> uop) {
        assertObjectNotNull("purchase", et);
        helpInsertOrUpdateInternally(et, new InternalInsertOrUpdateCallback<Purchase, PurchaseCB>() {
            public void callbackInsert(Purchase let) { doInsert(let, iop); }
            public void callbackUpdate(Purchase let) { doUpdate(let, uop); }
            public PurchaseCB callbackNewMyConditionBean() { return newConditionBean(); }
            public int callbackSelectCount(PurchaseCB cb) { return selectCount(cb); }
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
     * @param purchase The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(Purchase purchase) {
        doInsertOrUpdateNonstrict(purchase, null, null);
    }

    protected void doInsertOrUpdateNonstrict(Purchase et, final InsertOption<PurchaseCB> iop, final UpdateOption<PurchaseCB> uop) {
        assertObjectNotNull("purchase", et);
        helpInsertOrUpdateInternally(et, new InternalInsertOrUpdateNonstrictCallback<Purchase>() {
            public void callbackInsert(Purchase let) { doInsert(let, iop); }
            public void callbackUpdateNonstrict(Purchase let) { doUpdateNonstrict(let, uop); }
        });
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doInsertOrUpdateNonstrict(downcast(et), downcast(iop), downcast(uop));
    }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * Purchase purchase = new Purchase();
     * purchase.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * purchase.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     purchaseBhv.<span style="color: #DD4747">delete</span>(purchase);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param purchase The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(Purchase purchase) {
        doDelete(purchase, null);
    }

    protected void doDelete(Purchase et, final DeleteOption<PurchaseCB> op) {
        assertObjectNotNull("purchase", et);
        prepareDeleteOption(op);
        helpDeleteInternally(et, new InternalDeleteCallback<Purchase>() {
            public int callbackDelegateDelete(Purchase let) { return delegateDelete(let, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<PurchaseCB> op)
    { if (op != null) { assertDeleteOptionStatus(op); } }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        doDelete(downcast(et), downcast(op));
    }

    /**
     * Delete the entity non-strictly. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * Purchase purchase = new Purchase();
     * purchase.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//purchase.setVersionNo(value);</span>
     * purchaseBhv.<span style="color: #DD4747">deleteNonstrict</span>(purchase);
     * </pre>
     * @param purchase The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(Purchase purchase) {
        doDeleteNonstrict(purchase, null);
    }

    protected void doDeleteNonstrict(Purchase et, final DeleteOption<PurchaseCB> op) {
        assertObjectNotNull("purchase", et);
        prepareDeleteOption(op);
        helpDeleteNonstrictInternally(et, new InternalDeleteNonstrictCallback<Purchase>() {
            public int callbackDelegateDeleteNonstrict(Purchase let) { return delegateDeleteNonstrict(let, op); } });
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
     *     Purchase purchase = new Purchase();
     *     purchase.setFooName("foo");
     *     if (...) {
     *         purchase.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     purchaseList.add(purchase);
     * }
     * purchaseBhv.<span style="color: #DD4747">batchInsert</span>(purchaseList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<Purchase> purchaseList) {
        return doBatchInsert(purchaseList, null);
    }

    protected int[] doBatchInsert(List<Purchase> ls, InsertOption<PurchaseCB> op) {
        assertObjectNotNull("purchaseList", ls);
        InsertOption<PurchaseCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainInsertOption(); }
        prepareBatchInsertOption(ls, rlop); // required
        return delegateBatchInsert(ls, rlop);
    }

    protected void prepareBatchInsertOption(List<Purchase> ls, InsertOption<PurchaseCB> op) {
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
     *     Purchase purchase = new Purchase();
     *     purchase.setFooName("foo");
     *     if (...) {
     *         purchase.setFooPrice(123);
     *     } else {
     *         purchase.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//purchase.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     purchaseList.add(purchase);
     * }
     * purchaseBhv.<span style="color: #DD4747">batchUpdate</span>(purchaseList);
     * </pre>
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<Purchase> purchaseList) {
        return doBatchUpdate(purchaseList, null);
    }

    protected int[] doBatchUpdate(List<Purchase> ls, UpdateOption<PurchaseCB> op) {
        assertObjectNotNull("purchaseList", ls);
        UpdateOption<PurchaseCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop); // required
        return delegateBatchUpdate(ls, rlop);
    }

    protected void prepareBatchUpdateOption(List<Purchase> ls, UpdateOption<PurchaseCB> op) {
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
     * purchaseBhv.<span style="color: #DD4747">batchUpdate</span>(purchaseList, new SpecifyQuery<PurchaseCB>() {
     *     public void specify(PurchaseCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * purchaseBhv.<span style="color: #DD4747">batchUpdate</span>(purchaseList, new SpecifyQuery<PurchaseCB>() {
     *     public void specify(PurchaseCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<Purchase> purchaseList, SpecifyQuery<PurchaseCB> updateColumnSpec) {
        return doBatchUpdate(purchaseList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 140%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     Purchase purchase = new Purchase();
     *     purchase.setFooName("foo");
     *     if (...) {
     *         purchase.setFooPrice(123);
     *     } else {
     *         purchase.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//purchase.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     purchaseList.add(purchase);
     * }
     * purchaseBhv.<span style="color: #DD4747">batchUpdate</span>(purchaseList);
     * </pre>
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<Purchase> purchaseList) {
        return doBatchUpdateNonstrict(purchaseList, null);
    }

    protected int[] doBatchUpdateNonstrict(List<Purchase> ls, UpdateOption<PurchaseCB> op) {
        assertObjectNotNull("purchaseList", ls);
        UpdateOption<PurchaseCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop);
        return delegateBatchUpdateNonstrict(ls, rlop);
    }

    /**
     * Batch-update the entity list non-strictly specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * purchaseBhv.<span style="color: #DD4747">batchUpdateNonstrict</span>(purchaseList, new SpecifyQuery<PurchaseCB>() {
     *     public void specify(PurchaseCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * purchaseBhv.<span style="color: #DD4747">batchUpdateNonstrict</span>(purchaseList, new SpecifyQuery<PurchaseCB>() {
     *     public void specify(PurchaseCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).</p>
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<Purchase> purchaseList, SpecifyQuery<PurchaseCB> updateColumnSpec) {
        return doBatchUpdateNonstrict(purchaseList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doBatchUpdateNonstrict(downcast(ls), downcast(op));
    }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(List<Purchase> purchaseList) {
        return doBatchDelete(purchaseList, null);
    }

    protected int[] doBatchDelete(List<Purchase> ls, DeleteOption<PurchaseCB> op) {
        assertObjectNotNull("purchaseList", ls);
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
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(List<Purchase> purchaseList) {
        return doBatchDeleteNonstrict(purchaseList, null);
    }

    protected int[] doBatchDeleteNonstrict(List<Purchase> ls, DeleteOption<PurchaseCB> op) {
        assertObjectNotNull("purchaseList", ls);
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
     * purchaseBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;Purchase, PurchaseCB&gt;() {
     *     public ConditionBean setup(purchase entity, PurchaseCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<Purchase, PurchaseCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<Purchase, PurchaseCB> sp, InsertOption<PurchaseCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        Purchase et = newEntity();
        PurchaseCB cb = createCBForQueryInsert();
        return delegateQueryInsert(et, cb, sp.setup(et, cb), op);
    }

    protected PurchaseCB createCBForQueryInsert()
    { PurchaseCB cb = newConditionBean(); cb.xsetupForQueryInsert(); return cb; }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> op) {
        return doQueryInsert(downcast(setupper), downcast(op));
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * Purchase purchase = new Purchase();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//purchase.setPK...(value);</span>
     * purchase.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//purchase.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//purchase.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//purchase.setVersionNo(value);</span>
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * purchaseBhv.<span style="color: #DD4747">queryUpdate</span>(purchase, cb);
     * </pre>
     * @param purchase The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of Purchase. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(Purchase purchase, PurchaseCB cb) {
        return doQueryUpdate(purchase, cb, null);
    }

    protected int doQueryUpdate(Purchase et, PurchaseCB cb, UpdateOption<PurchaseCB> op) {
        assertObjectNotNull("purchase", et); assertCBStateValid(cb);
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
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * purchaseBhv.<span style="color: #DD4747">queryDelete</span>(purchase, cb);
     * </pre>
     * @param cb The condition-bean of Purchase. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(PurchaseCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(PurchaseCB cb, DeleteOption<PurchaseCB> op) {
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
     * Purchase purchase = new Purchase();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * purchase.setFoo...(value);
     * purchase.setBar...(value);
     * InsertOption<PurchaseCB> option = new InsertOption<PurchaseCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * purchaseBhv.<span style="color: #DD4747">varyingInsert</span>(purchase, option);
     * ... = purchase.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param purchase The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(Purchase purchase, InsertOption<PurchaseCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(purchase, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, ExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * Purchase purchase = new Purchase();
     * purchase.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * purchase.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * purchase.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;PurchaseCB&gt; option = new UpdateOption&lt;PurchaseCB&gt;();
     *     option.self(new SpecifyQuery&lt;PurchaseCB&gt;() {
     *         public void specify(PurchaseCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     purchaseBhv.<span style="color: #DD4747">varyingUpdate</span>(purchase, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param purchase The entity of update. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(Purchase purchase, UpdateOption<PurchaseCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(purchase, option);
    }

    /**
     * Update the entity with varying requests non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as updateNonstrict(entity).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * Purchase purchase = new Purchase();
     * purchase.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * purchase.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//purchase.setVersionNo(value);</span>
     * UpdateOption&lt;PurchaseCB&gt; option = new UpdateOption&lt;PurchaseCB&gt;();
     * option.self(new SpecifyQuery&lt;PurchaseCB&gt;() {
     *     public void specify(PurchaseCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * purchaseBhv.<span style="color: #DD4747">varyingUpdateNonstrict</span>(purchase, option);
     * </pre>
     * @param purchase The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(Purchase purchase, UpdateOption<PurchaseCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(purchase, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param purchase The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(Purchase purchase, InsertOption<PurchaseCB> insertOption, UpdateOption<PurchaseCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdate(purchase, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param purchase The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(Purchase purchase, InsertOption<PurchaseCB> insertOption, UpdateOption<PurchaseCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdateNonstrict(purchase, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param purchase The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(Purchase purchase, DeleteOption<PurchaseCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(purchase, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param purchase The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDeleteNonstrict(Purchase purchase, DeleteOption<PurchaseCB> option) {
        assertDeleteOptionNotNull(option);
        doDeleteNonstrict(purchase, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<Purchase> purchaseList, InsertOption<PurchaseCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(purchaseList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<Purchase> purchaseList, UpdateOption<PurchaseCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(purchaseList, option);
    }

    /**
     * Batch-update the list with varying requests non-strictly. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdateNonstrict(List<Purchase> purchaseList, UpdateOption<PurchaseCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdateNonstrict(purchaseList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<Purchase> purchaseList, DeleteOption<PurchaseCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(purchaseList, option);
    }

    /**
     * Batch-delete the list with varying requests non-strictly. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDeleteNonstrict(entityList).
     * @param purchaseList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDeleteNonstrict(List<Purchase> purchaseList, DeleteOption<PurchaseCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDeleteNonstrict(purchaseList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<Purchase, PurchaseCB> setupper, InsertOption<PurchaseCB> option) {
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
     * Purchase purchase = new Purchase();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//purchase.setPK...(value);</span>
     * purchase.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//purchase.setVersionNo(value);</span>
     * PurchaseCB cb = new PurchaseCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;PurchaseCB&gt; option = new UpdateOption&lt;PurchaseCB&gt;();
     * option.self(new SpecifyQuery&lt;PurchaseCB&gt;() {
     *     public void specify(PurchaseCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * purchaseBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(purchase, cb, option);
     * </pre>
     * @param purchase The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of Purchase. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(Purchase purchase, PurchaseCB cb, UpdateOption<PurchaseCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(purchase, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of Purchase. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(PurchaseCB cb, DeleteOption<PurchaseCB> option) {
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
    public OutsideSqlBasicExecutor<PurchaseBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(PurchaseCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(PurchaseCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends Purchase> void delegateSelectCursor(PurchaseCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends Purchase> List<ENTITY> delegateSelectList(PurchaseCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }
    protected <RESULT> RESULT delegateSelectNextVal(Class<RESULT> tp) { return invoke(createSelectNextValCommand(tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(Purchase et, InsertOption<PurchaseCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(Purchase et, UpdateOption<PurchaseCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateEntityCommand(et, op)); }
    protected int delegateUpdateNonstrict(Purchase et, UpdateOption<PurchaseCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(Purchase et, DeleteOption<PurchaseCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteEntityCommand(et, op)); }
    protected int delegateDeleteNonstrict(Purchase et, DeleteOption<PurchaseCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<Purchase> ls, InsertOption<PurchaseCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<Purchase> ls, UpdateOption<PurchaseCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchUpdateNonstrict(List<Purchase> ls, UpdateOption<PurchaseCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<Purchase> ls, DeleteOption<PurchaseCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchDeleteNonstrict(List<Purchase> ls, DeleteOption<PurchaseCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(Purchase et, PurchaseCB inCB, ConditionBean resCB, InsertOption<PurchaseCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(Purchase et, PurchaseCB cb, UpdateOption<PurchaseCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(PurchaseCB cb, DeleteOption<PurchaseCB> op)
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
    protected Class<Purchase> typeOfSelectedEntity()
    { return Purchase.class; }

    protected Purchase downcast(Entity et)
    { return helpEntityDowncastInternally(et, Purchase.class); }

    protected PurchaseCB downcast(ConditionBean cb)
    { return helpConditionBeanDowncastInternally(cb, PurchaseCB.class); }

    @SuppressWarnings("unchecked")
    protected List<Purchase> downcast(List<? extends Entity> ls)
    { return (List<Purchase>)ls; }

    @SuppressWarnings("unchecked")
    protected InsertOption<PurchaseCB> downcast(InsertOption<? extends ConditionBean> op)
    { return (InsertOption<PurchaseCB>)op; }

    @SuppressWarnings("unchecked")
    protected UpdateOption<PurchaseCB> downcast(UpdateOption<? extends ConditionBean> op)
    { return (UpdateOption<PurchaseCB>)op; }

    @SuppressWarnings("unchecked")
    protected DeleteOption<PurchaseCB> downcast(DeleteOption<? extends ConditionBean> op)
    { return (DeleteOption<PurchaseCB>)op; }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<Purchase, PurchaseCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp)
    { return (QueryInsertSetupper<Purchase, PurchaseCB>)sp; }
}
