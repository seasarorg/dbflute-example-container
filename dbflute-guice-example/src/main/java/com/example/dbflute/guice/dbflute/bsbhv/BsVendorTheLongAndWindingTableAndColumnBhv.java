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
 * The behavior of VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN as TABLE. <br />
 * <pre>
 * [primary key]
 *     THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID
 *
 * [column]
 *     THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME, SHORT_NAME, SHORT_SIZE
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
 *     VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     vendorTheLongAndWindingTableAndColumnRefList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVendorTheLongAndWindingTableAndColumnBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return VendorTheLongAndWindingTableAndColumnDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public VendorTheLongAndWindingTableAndColumnDbm getMyDBMeta() { return VendorTheLongAndWindingTableAndColumnDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public VendorTheLongAndWindingTableAndColumn newMyEntity() { return new VendorTheLongAndWindingTableAndColumn(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public VendorTheLongAndWindingTableAndColumnCB newMyConditionBean() { return new VendorTheLongAndWindingTableAndColumnCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * int count = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(VendorTheLongAndWindingTableAndColumnCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(VendorTheLongAndWindingTableAndColumnCB cb) { // called by selectPage(cb)
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
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * OptionalEntity&lt;VendorTheLongAndWindingTableAndColumn&gt; entity = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     *
     * <span style="color: #3F7E5E">// if the data always exists as your business rule</span>
     * entity.<span style="color: #DD4747">required</span>(vendorTheLongAndWindingTableAndColumn -&gt; {
     *     ...
     * });
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = entity.entity.<span style="color: #DD4747">get()</span>;
     *
     * <span style="color: #3F7E5E">// if it might be no data, ifPresent(), isPresent(), ...</span>
     * entity.<span style="color: #DD4747">ifPresent</span>(vendorTheLongAndWindingTableAndColumn -&gt; {
     *     ...
     * });
     * if (entity.entity.<span style="color: #DD4747">isPresent()</span>) {
     *     VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = entity.entity.<span style="color: #DD4747">get()</span>;
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The optional entity selected by the condition. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get() of return value is called and the value is null, which means entity has already been deleted (point is not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<VendorTheLongAndWindingTableAndColumn> selectEntity(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectOptionalEntity(cb, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> ENTITY doSelectEntity(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> OptionalEntity<ENTITY> doSelectOptionalEntity(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> tp) {
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
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = vendorTheLongAndWindingTableAndColumn.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (point is not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorTheLongAndWindingTableAndColumn selectEntityWithDeletedCheck(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectEntityWithDeletedCheck(cb, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> ENTITY doSelectEntityWithDeletedCheck(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param theLongAndWindingTableAndColumnId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorTheLongAndWindingTableAndColumn selectByPKValue(Long theLongAndWindingTableAndColumnId) {
        return doSelectByPKValue(theLongAndWindingTableAndColumnId, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> ENTITY doSelectByPKValue(Long theLongAndWindingTableAndColumnId, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(theLongAndWindingTableAndColumnId), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param theLongAndWindingTableAndColumnId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorTheLongAndWindingTableAndColumn selectByPKValueWithDeletedCheck(Long theLongAndWindingTableAndColumnId) {
        return doSelectByPKValueWithDeletedCheck(theLongAndWindingTableAndColumnId, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> ENTITY doSelectByPKValueWithDeletedCheck(Long theLongAndWindingTableAndColumnId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(theLongAndWindingTableAndColumnId), entityType);
    }

    private VendorTheLongAndWindingTableAndColumnCB buildPKCB(Long theLongAndWindingTableAndColumnId) {
        assertObjectNotNull("theLongAndWindingTableAndColumnId", theLongAndWindingTableAndColumnId);
        VendorTheLongAndWindingTableAndColumnCB cb = newMyConditionBean();
        cb.query().setTheLongAndWindingTableAndColumnId_Equal(theLongAndWindingTableAndColumnId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;VendorTheLongAndWindingTableAndColumn&gt; vendorTheLongAndWindingTableAndColumnList = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn : vendorTheLongAndWindingTableAndColumnList) {
     *     ... = vendorTheLongAndWindingTableAndColumn.get...();
     * }
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<VendorTheLongAndWindingTableAndColumn> selectList(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectList(cb, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> ListResultBean<ENTITY> doSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;VendorTheLongAndWindingTableAndColumn&gt; page = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn : page) {
     *     ... = vendorTheLongAndWindingTableAndColumn.get...();
     * }
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<VendorTheLongAndWindingTableAndColumn> selectPage(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectPage(cb, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> PagingResultBean<ENTITY> doSelectPage(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public int callbackSelectCount(VendorTheLongAndWindingTableAndColumnCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;VendorTheLongAndWindingTableAndColumn&gt;() {
     *     public void handle(VendorTheLongAndWindingTableAndColumn entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param entityRowHandler The handler of entity row of VendorTheLongAndWindingTableAndColumn. (NotNull)
     */
    public void selectCursor(VendorTheLongAndWindingTableAndColumnCB cb, EntityRowHandler<VendorTheLongAndWindingTableAndColumn> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> void doSelectCursor(VendorTheLongAndWindingTableAndColumnCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public void callbackSelectCursor(VendorTheLongAndWindingTableAndColumnCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(VendorTheLongAndWindingTableAndColumnCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<VendorTheLongAndWindingTableAndColumnCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends VendorTheLongAndWindingTableAndColumnCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends VendorTheLongAndWindingTableAndColumnCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
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
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * Load referrer of vendorTheLongAndWindingTableAndColumnRefList by the set-upper of referrer. <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF by THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumnRefList'.
     * <pre>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">loadVendorTheLongAndWindingTableAndColumnRefList</span>(vendorTheLongAndWindingTableAndColumnList, new ConditionBeanSetupper&lt;VendorTheLongAndWindingTableAndColumnRefCB&gt;() {
     *     public void setup(VendorTheLongAndWindingTableAndColumnRefCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here by calling like '}).withNestedList(new ...)'</span>
     * for (VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn : vendorTheLongAndWindingTableAndColumnList) {
     *     ... = vendorTheLongAndWindingTableAndColumn.<span style="color: #DD4747">getVendorTheLongAndWindingTableAndColumnRefList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTheLongAndWindingTableAndColumnId_InScope(pkList);
     * cb.query().addOrderBy_TheLongAndWindingTableAndColumnId_Asc();
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of vendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<VendorTheLongAndWindingTableAndColumnRef> loadVendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, ConditionBeanSetupper<VendorTheLongAndWindingTableAndColumnRefCB> conditionBeanSetupper) {
        xassLRArg(vendorTheLongAndWindingTableAndColumn, conditionBeanSetupper);
        return loadVendorTheLongAndWindingTableAndColumnRefList(xnewLRLs(vendorTheLongAndWindingTableAndColumn), conditionBeanSetupper);
    }

    /**
     * Load referrer of vendorTheLongAndWindingTableAndColumnRefList by the set-upper of referrer. <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF by THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumnRefList'.
     * <pre>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">loadVendorTheLongAndWindingTableAndColumnRefList</span>(vendorTheLongAndWindingTableAndColumnList, new ConditionBeanSetupper&lt;VendorTheLongAndWindingTableAndColumnRefCB&gt;() {
     *     public void setup(VendorTheLongAndWindingTableAndColumnRefCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here by calling like '}).withNestedList(new ...)'</span>
     * for (VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn : vendorTheLongAndWindingTableAndColumnList) {
     *     ... = vendorTheLongAndWindingTableAndColumn.<span style="color: #DD4747">getVendorTheLongAndWindingTableAndColumnRefList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setTheLongAndWindingTableAndColumnId_InScope(pkList);
     * cb.query().addOrderBy_TheLongAndWindingTableAndColumnId_Asc();
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumnList The entity list of vendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<VendorTheLongAndWindingTableAndColumnRef> loadVendorTheLongAndWindingTableAndColumnRefList(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, ConditionBeanSetupper<VendorTheLongAndWindingTableAndColumnRefCB> conditionBeanSetupper) {
        xassLRArg(vendorTheLongAndWindingTableAndColumnList, conditionBeanSetupper);
        return loadVendorTheLongAndWindingTableAndColumnRefList(vendorTheLongAndWindingTableAndColumnList, new LoadReferrerOption<VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef>().xinit(conditionBeanSetupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param vendorTheLongAndWindingTableAndColumn The entity of vendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<VendorTheLongAndWindingTableAndColumnRef> loadVendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, LoadReferrerOption<VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef> loadReferrerOption) {
        xassLRArg(vendorTheLongAndWindingTableAndColumn, loadReferrerOption);
        return loadVendorTheLongAndWindingTableAndColumnRefList(xnewLRLs(vendorTheLongAndWindingTableAndColumn), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param vendorTheLongAndWindingTableAndColumnList The entity list of vendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    @SuppressWarnings("unchecked")
    public NestedReferrerLoader<VendorTheLongAndWindingTableAndColumnRef> loadVendorTheLongAndWindingTableAndColumnRefList(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, LoadReferrerOption<VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef> loadReferrerOption) {
        xassLRArg(vendorTheLongAndWindingTableAndColumnList, loadReferrerOption);
        if (vendorTheLongAndWindingTableAndColumnList.isEmpty()) { return (NestedReferrerLoader<VendorTheLongAndWindingTableAndColumnRef>)EMPTY_LOADER; }
        return doLoadVendorTheLongAndWindingTableAndColumnRefList(vendorTheLongAndWindingTableAndColumnList, loadReferrerOption);
    }

    protected NestedReferrerLoader<VendorTheLongAndWindingTableAndColumnRef> doLoadVendorTheLongAndWindingTableAndColumnRefList(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, LoadReferrerOption<VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef> option) {
        final VendorTheLongAndWindingTableAndColumnRefBhv referrerBhv = xgetBSFLR().select(VendorTheLongAndWindingTableAndColumnRefBhv.class);
        return helpLoadReferrerInternally(vendorTheLongAndWindingTableAndColumnList, option, new InternalLoadReferrerCallback<VendorTheLongAndWindingTableAndColumn, Long, VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef>() {
            public Long getPKVal(VendorTheLongAndWindingTableAndColumn et)
            { return et.getTheLongAndWindingTableAndColumnId(); }
            public void setRfLs(VendorTheLongAndWindingTableAndColumn et, List<VendorTheLongAndWindingTableAndColumnRef> ls)
            { et.setVendorTheLongAndWindingTableAndColumnRefList(ls); }
            public VendorTheLongAndWindingTableAndColumnRefCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(VendorTheLongAndWindingTableAndColumnRefCB cb, List<Long> ls)
            { cb.query().setTheLongAndWindingTableAndColumnId_InScope(ls); }
            public void qyOdFKAsc(VendorTheLongAndWindingTableAndColumnRefCB cb) { cb.query().addOrderBy_TheLongAndWindingTableAndColumnId_Asc(); }
            public void spFKCol(VendorTheLongAndWindingTableAndColumnRefCB cb) { cb.specify().columnTheLongAndWindingTableAndColumnId(); }
            public List<VendorTheLongAndWindingTableAndColumnRef> selRfLs(VendorTheLongAndWindingTableAndColumnRefCB cb) { return referrerBhv.selectList(cb); }
            public Long getFKVal(VendorTheLongAndWindingTableAndColumnRef re) { return re.getTheLongAndWindingTableAndColumnId(); }
            public void setlcEt(VendorTheLongAndWindingTableAndColumnRef re, VendorTheLongAndWindingTableAndColumn le)
            { re.setVendorTheLongAndWindingTableAndColumn(le); }
            public String getRfPrNm() { return "vendorTheLongAndWindingTableAndColumnRefList"; }
        });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key theLongAndWindingTableAndColumnId.
     * @param vendorTheLongAndWindingTableAndColumnList The list of vendorTheLongAndWindingTableAndColumn. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractTheLongAndWindingTableAndColumnIdList(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        return helpExtractListInternally(vendorTheLongAndWindingTableAndColumnList, new InternalExtractCallback<VendorTheLongAndWindingTableAndColumn, Long>() {
            public Long getCV(VendorTheLongAndWindingTableAndColumn et) { return et.getTheLongAndWindingTableAndColumnId(); }
        });
    }

    /**
     * Extract the value list of (single) unique key theLongAndWindingTableAndColumnName.
     * @param vendorTheLongAndWindingTableAndColumnList The list of vendorTheLongAndWindingTableAndColumn. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractTheLongAndWindingTableAndColumnNameList(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        return helpExtractListInternally(vendorTheLongAndWindingTableAndColumnList, new InternalExtractCallback<VendorTheLongAndWindingTableAndColumn, String>() {
            public String getCV(VendorTheLongAndWindingTableAndColumn et) { return et.getTheLongAndWindingTableAndColumnName(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * vendorTheLongAndWindingTableAndColumn.setFoo...(value);
     * vendorTheLongAndWindingTableAndColumn.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.set...;</span>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">insert</span>(vendorTheLongAndWindingTableAndColumn);
     * ... = vendorTheLongAndWindingTableAndColumn.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param vendorTheLongAndWindingTableAndColumn The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn) {
        doInsert(vendorTheLongAndWindingTableAndColumn, null);
    }

    protected void doInsert(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumn", vendorTheLongAndWindingTableAndColumn);
        prepareInsertOption(op);
        delegateInsert(vendorTheLongAndWindingTableAndColumn, op);
    }

    protected void prepareInsertOption(InsertOption<VendorTheLongAndWindingTableAndColumnCB> op) {
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
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * vendorTheLongAndWindingTableAndColumn.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * vendorTheLongAndWindingTableAndColumn.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorTheLongAndWindingTableAndColumn.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">update</span>(vendorTheLongAndWindingTableAndColumn);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn) {
        doUpdate(vendorTheLongAndWindingTableAndColumn, null);
    }

    protected void doUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, final UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumn", vendorTheLongAndWindingTableAndColumn);
        prepareUpdateOption(op);
        helpUpdateInternally(vendorTheLongAndWindingTableAndColumn, new InternalUpdateCallback<VendorTheLongAndWindingTableAndColumn>() {
            public int callbackDelegateUpdate(VendorTheLongAndWindingTableAndColumn et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected VendorTheLongAndWindingTableAndColumnCB createCBForVaryingUpdate() {
        VendorTheLongAndWindingTableAndColumnCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected VendorTheLongAndWindingTableAndColumnCB createCBForSpecifiedUpdate() {
        VendorTheLongAndWindingTableAndColumnCB cb = newMyConditionBean();
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
     * @param vendorTheLongAndWindingTableAndColumn The entity of insert or update target. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn) {
        doInesrtOrUpdate(vendorTheLongAndWindingTableAndColumn, null, null);
    }

    protected void doInesrtOrUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, final InsertOption<VendorTheLongAndWindingTableAndColumnCB> iop, final UpdateOption<VendorTheLongAndWindingTableAndColumnCB> uop) {
        helpInsertOrUpdateInternally(vendorTheLongAndWindingTableAndColumn, new InternalInsertOrUpdateCallback<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB>() {
            public void callbackInsert(VendorTheLongAndWindingTableAndColumn et) { doInsert(et, iop); }
            public void callbackUpdate(VendorTheLongAndWindingTableAndColumn et) { doUpdate(et, uop); }
            public VendorTheLongAndWindingTableAndColumnCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(VendorTheLongAndWindingTableAndColumnCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<VendorTheLongAndWindingTableAndColumnCB>();
            uop = uop != null ? uop : new UpdateOption<VendorTheLongAndWindingTableAndColumnCB>();
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
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * vendorTheLongAndWindingTableAndColumn.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorTheLongAndWindingTableAndColumn.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">delete</span>(vendorTheLongAndWindingTableAndColumn);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn) {
        doDelete(vendorTheLongAndWindingTableAndColumn, null);
    }

    protected void doDelete(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, final DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumn", vendorTheLongAndWindingTableAndColumn);
        prepareDeleteOption(op);
        helpDeleteInternally(vendorTheLongAndWindingTableAndColumn, new InternalDeleteCallback<VendorTheLongAndWindingTableAndColumn>() {
            public int callbackDelegateDelete(VendorTheLongAndWindingTableAndColumn et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op) {
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
     *     VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     *     vendorTheLongAndWindingTableAndColumn.setFooName("foo");
     *     if (...) {
     *         vendorTheLongAndWindingTableAndColumn.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     vendorTheLongAndWindingTableAndColumnList.add(vendorTheLongAndWindingTableAndColumn);
     * }
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">batchInsert</span>(vendorTheLongAndWindingTableAndColumnList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        InsertOption<VendorTheLongAndWindingTableAndColumnCB> op = createInsertUpdateOption();
        return doBatchInsert(vendorTheLongAndWindingTableAndColumnList, op);
    }

    protected int[] doBatchInsert(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumnList", vendorTheLongAndWindingTableAndColumnList);
        prepareBatchInsertOption(vendorTheLongAndWindingTableAndColumnList, op);
        return delegateBatchInsert(vendorTheLongAndWindingTableAndColumnList, op);
    }

    protected void prepareBatchInsertOption(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(vendorTheLongAndWindingTableAndColumnList);
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
     *     VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     *     vendorTheLongAndWindingTableAndColumn.setFooName("foo");
     *     if (...) {
     *         vendorTheLongAndWindingTableAndColumn.setFooPrice(123);
     *     } else {
     *         vendorTheLongAndWindingTableAndColumn.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     vendorTheLongAndWindingTableAndColumnList.add(vendorTheLongAndWindingTableAndColumn);
     * }
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">batchUpdate</span>(vendorTheLongAndWindingTableAndColumnList);
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op = createPlainUpdateOption();
        return doBatchUpdate(vendorTheLongAndWindingTableAndColumnList, op);
    }

    protected int[] doBatchUpdate(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumnList", vendorTheLongAndWindingTableAndColumnList);
        prepareBatchUpdateOption(vendorTheLongAndWindingTableAndColumnList, op);
        return delegateBatchUpdate(vendorTheLongAndWindingTableAndColumnList, op);
    }

    protected void prepareBatchUpdateOption(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(vendorTheLongAndWindingTableAndColumnList);
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">batchUpdate</span>(vendorTheLongAndWindingTableAndColumnList, new SpecifyQuery<VendorTheLongAndWindingTableAndColumnCB>() {
     *     public void specify(VendorTheLongAndWindingTableAndColumnCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">batchUpdate</span>(vendorTheLongAndWindingTableAndColumnList, new SpecifyQuery<VendorTheLongAndWindingTableAndColumnCB>() {
     *     public void specify(VendorTheLongAndWindingTableAndColumnCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, SpecifyQuery<VendorTheLongAndWindingTableAndColumnCB> updateColumnSpec) {
        return doBatchUpdate(vendorTheLongAndWindingTableAndColumnList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        return doBatchDelete(vendorTheLongAndWindingTableAndColumnList, null);
    }

    protected int[] doBatchDelete(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumnList", vendorTheLongAndWindingTableAndColumnList);
        prepareDeleteOption(op);
        return delegateBatchDelete(vendorTheLongAndWindingTableAndColumnList, op);
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *     public ConditionBean setup(vendorTheLongAndWindingTableAndColumn entity, VendorTheLongAndWindingTableAndColumnCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB> sp, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        VendorTheLongAndWindingTableAndColumn e = new VendorTheLongAndWindingTableAndColumn();
        VendorTheLongAndWindingTableAndColumnCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected VendorTheLongAndWindingTableAndColumnCB createCBForQueryInsert() {
        VendorTheLongAndWindingTableAndColumnCB cb = newMyConditionBean();
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
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setPK...(value);</span>
     * vendorTheLongAndWindingTableAndColumn.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setVersionNo(value);</span>
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">queryUpdate</span>(vendorTheLongAndWindingTableAndColumn, cb);
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB cb) {
        return doQueryUpdate(vendorTheLongAndWindingTableAndColumn, cb, null);
    }

    protected int doQueryUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB cb, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumn", vendorTheLongAndWindingTableAndColumn); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(vendorTheLongAndWindingTableAndColumn, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (VendorTheLongAndWindingTableAndColumnCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (VendorTheLongAndWindingTableAndColumnCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">queryDelete</span>(vendorTheLongAndWindingTableAndColumn, cb);
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(VendorTheLongAndWindingTableAndColumnCB cb, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((VendorTheLongAndWindingTableAndColumnCB)cb); }
        else { return varyingQueryDelete((VendorTheLongAndWindingTableAndColumnCB)cb, downcast(op)); }
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
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * vendorTheLongAndWindingTableAndColumn.setFoo...(value);
     * vendorTheLongAndWindingTableAndColumn.setBar...(value);
     * InsertOption<VendorTheLongAndWindingTableAndColumnCB> option = new InsertOption<VendorTheLongAndWindingTableAndColumnCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">varyingInsert</span>(vendorTheLongAndWindingTableAndColumn, option);
     * ... = vendorTheLongAndWindingTableAndColumn.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, InsertOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(vendorTheLongAndWindingTableAndColumn, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * vendorTheLongAndWindingTableAndColumn.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * vendorTheLongAndWindingTableAndColumn.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorTheLongAndWindingTableAndColumn.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;VendorTheLongAndWindingTableAndColumnCB&gt; option = new UpdateOption&lt;VendorTheLongAndWindingTableAndColumnCB&gt;();
     *     option.self(new SpecifyQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *         public void specify(VendorTheLongAndWindingTableAndColumnCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">varyingUpdate</span>(vendorTheLongAndWindingTableAndColumn, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(vendorTheLongAndWindingTableAndColumn, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param vendorTheLongAndWindingTableAndColumn The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, InsertOption<VendorTheLongAndWindingTableAndColumnCB> insertOption, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(vendorTheLongAndWindingTableAndColumn, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param vendorTheLongAndWindingTableAndColumn The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(vendorTheLongAndWindingTableAndColumn, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, InsertOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(vendorTheLongAndWindingTableAndColumnList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(vendorTheLongAndWindingTableAndColumnList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(vendorTheLongAndWindingTableAndColumnList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB> setupper, InsertOption<VendorTheLongAndWindingTableAndColumnCB> option) {
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
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setPK...(value);</span>
     * vendorTheLongAndWindingTableAndColumn.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setVersionNo(value);</span>
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;VendorTheLongAndWindingTableAndColumnCB&gt; option = new UpdateOption&lt;VendorTheLongAndWindingTableAndColumnCB&gt;();
     * option.self(new SpecifyQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *     public void specify(VendorTheLongAndWindingTableAndColumnCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(vendorTheLongAndWindingTableAndColumn, cb, option);
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB cb, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(vendorTheLongAndWindingTableAndColumn, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(VendorTheLongAndWindingTableAndColumnCB cb, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> option) {
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
    public OutsideSqlBasicExecutor<VendorTheLongAndWindingTableAndColumnBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(VendorTheLongAndWindingTableAndColumnCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(VendorTheLongAndWindingTableAndColumnCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> void delegateSelectCursor(VendorTheLongAndWindingTableAndColumnCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> List<ENTITY> delegateSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(VendorTheLongAndWindingTableAndColumn et, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(VendorTheLongAndWindingTableAndColumn et, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(VendorTheLongAndWindingTableAndColumn et, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(VendorTheLongAndWindingTableAndColumn et, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(VendorTheLongAndWindingTableAndColumn et, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<VendorTheLongAndWindingTableAndColumn> ls, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<VendorTheLongAndWindingTableAndColumn> ls, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<VendorTheLongAndWindingTableAndColumn> ls, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<VendorTheLongAndWindingTableAndColumn> ls, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<VendorTheLongAndWindingTableAndColumn> ls, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(VendorTheLongAndWindingTableAndColumn et, VendorTheLongAndWindingTableAndColumnCB inCB, ConditionBean resCB, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(VendorTheLongAndWindingTableAndColumn et, VendorTheLongAndWindingTableAndColumnCB cb, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(VendorTheLongAndWindingTableAndColumnCB cb, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op)
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
    protected VendorTheLongAndWindingTableAndColumn downcast(Entity et) {
        return helpEntityDowncastInternally(et, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected VendorTheLongAndWindingTableAndColumnCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, VendorTheLongAndWindingTableAndColumnCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<VendorTheLongAndWindingTableAndColumn> downcast(List<? extends Entity> ls) {
        return (List<VendorTheLongAndWindingTableAndColumn>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<VendorTheLongAndWindingTableAndColumnCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<VendorTheLongAndWindingTableAndColumnCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<VendorTheLongAndWindingTableAndColumnCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<VendorTheLongAndWindingTableAndColumnCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<VendorTheLongAndWindingTableAndColumnCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<VendorTheLongAndWindingTableAndColumnCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB>)sp;
    }
}
