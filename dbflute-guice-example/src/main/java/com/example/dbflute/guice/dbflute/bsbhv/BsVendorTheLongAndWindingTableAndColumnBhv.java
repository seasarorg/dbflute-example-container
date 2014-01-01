package com.example.dbflute.guice.dbflute.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
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
     * int count = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">selectCount</span>(cb);
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
     * Select the entity by the condition-bean.
     * <pre>
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (vendorTheLongAndWindingTableAndColumn != null) {
     *     ... = vendorTheLongAndWindingTableAndColumn.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorTheLongAndWindingTableAndColumn selectEntity(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectEntity(cb, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> ENTITY doSelectEntity(final VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType, new InternalSelectEntityCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = vendorTheLongAndWindingTableAndColumn.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public VendorTheLongAndWindingTableAndColumn selectEntityWithDeletedCheck(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectEntityWithDeletedCheck(cb, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> ENTITY doSelectEntityWithDeletedCheck(final VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(cb, entityType, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param theLongAndWindingTableAndColumnId The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
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
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
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
     * ListResultBean&lt;VendorTheLongAndWindingTableAndColumn&gt; vendorTheLongAndWindingTableAndColumnList = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn : vendorTheLongAndWindingTableAndColumnList) {
     *     ... = vendorTheLongAndWindingTableAndColumn.get...();
     * }
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<VendorTheLongAndWindingTableAndColumn> selectList(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectList(cb, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> ListResultBean<ENTITY> doSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType, new InternalSelectListCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) { return delegateSelectList(cb, entityType); } });
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
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;VendorTheLongAndWindingTableAndColumn&gt; page = vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">selectPage</span>(cb);
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
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<VendorTheLongAndWindingTableAndColumn> selectPage(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doSelectPage(cb, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> PagingResultBean<ENTITY> doSelectPage(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType, new InternalSelectPageCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public int callbackSelectCount(VendorTheLongAndWindingTableAndColumnCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;VendorTheLongAndWindingTableAndColumn&gt;() {
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

    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> void doSelectCursor(VendorTheLongAndWindingTableAndColumnCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler<VendorTheLongAndWindingTableAndColumn>", entityRowHandler); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType, new InternalSelectCursorCallback<ENTITY, VendorTheLongAndWindingTableAndColumnCB>() {
            public void callbackSelectCursor(VendorTheLongAndWindingTableAndColumnCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) { delegateSelectCursor(cb, entityRowHandler, entityType); }
            public List<ENTITY> callbackSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(VendorTheLongAndWindingTableAndColumnCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
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

    protected <RESULT, CB extends VendorTheLongAndWindingTableAndColumnCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> resultType, CB cb) {
        assertObjectNotNull("resultType", resultType); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, resultType);
    }

    protected <RESULT, CB extends VendorTheLongAndWindingTableAndColumnCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> resultType) {
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
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param vendorTheLongAndWindingTableAndColumn The entity of vendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadVendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, ConditionBeanSetupper<VendorTheLongAndWindingTableAndColumnRefCB> conditionBeanSetupper) {
        xassLRArg(vendorTheLongAndWindingTableAndColumn, conditionBeanSetupper);
        loadVendorTheLongAndWindingTableAndColumnRefList(xnewLRLs(vendorTheLongAndWindingTableAndColumn), conditionBeanSetupper);
    }
    /**
     * Load referrer of vendorTheLongAndWindingTableAndColumnRefList with the set-upper for condition-bean of referrer. <br />
     * VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF by THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, named 'vendorTheLongAndWindingTableAndColumnRefList'.
     * <pre>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">loadVendorTheLongAndWindingTableAndColumnRefList</span>(vendorTheLongAndWindingTableAndColumnList, new ConditionBeanSetupper&lt;VendorTheLongAndWindingTableAndColumnRefCB&gt;() {
     *     public void setup(VendorTheLongAndWindingTableAndColumnRefCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn : vendorTheLongAndWindingTableAndColumnList) {
     *     ... = vendorTheLongAndWindingTableAndColumn.<span style="color: #FD4747">getVendorTheLongAndWindingTableAndColumnRefList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setTheLongAndWindingTableAndColumnId_InScope(pkList);
     * cb.query().addOrderBy_TheLongAndWindingTableAndColumnId_Asc();
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumnList The entity list of vendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadVendorTheLongAndWindingTableAndColumnRefList(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, ConditionBeanSetupper<VendorTheLongAndWindingTableAndColumnRefCB> conditionBeanSetupper) {
        xassLRArg(vendorTheLongAndWindingTableAndColumnList, conditionBeanSetupper);
        loadVendorTheLongAndWindingTableAndColumnRefList(vendorTheLongAndWindingTableAndColumnList, new LoadReferrerOption<VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef>().xinit(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param vendorTheLongAndWindingTableAndColumn The entity of vendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadVendorTheLongAndWindingTableAndColumnRefList(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, LoadReferrerOption<VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef> loadReferrerOption) {
        xassLRArg(vendorTheLongAndWindingTableAndColumn, loadReferrerOption);
        loadVendorTheLongAndWindingTableAndColumnRefList(xnewLRLs(vendorTheLongAndWindingTableAndColumn), loadReferrerOption);
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param vendorTheLongAndWindingTableAndColumnList The entity list of vendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadVendorTheLongAndWindingTableAndColumnRefList(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, LoadReferrerOption<VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef> loadReferrerOption) {
        xassLRArg(vendorTheLongAndWindingTableAndColumnList, loadReferrerOption);
        if (vendorTheLongAndWindingTableAndColumnList.isEmpty()) { return; }
        final VendorTheLongAndWindingTableAndColumnRefBhv referrerBhv = xgetBSFLR().select(VendorTheLongAndWindingTableAndColumnRefBhv.class);
        helpLoadReferrerInternally(vendorTheLongAndWindingTableAndColumnList, loadReferrerOption, new InternalLoadReferrerCallback<VendorTheLongAndWindingTableAndColumn, Long, VendorTheLongAndWindingTableAndColumnRefCB, VendorTheLongAndWindingTableAndColumnRef>() {
            public Long getPKVal(VendorTheLongAndWindingTableAndColumn e)
            { return e.getTheLongAndWindingTableAndColumnId(); }
            public void setRfLs(VendorTheLongAndWindingTableAndColumn e, List<VendorTheLongAndWindingTableAndColumnRef> ls)
            { e.setVendorTheLongAndWindingTableAndColumnRefList(ls); }
            public VendorTheLongAndWindingTableAndColumnRefCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(VendorTheLongAndWindingTableAndColumnRefCB cb, List<Long> ls)
            { cb.query().setTheLongAndWindingTableAndColumnId_InScope(ls); }
            public void qyOdFKAsc(VendorTheLongAndWindingTableAndColumnRefCB cb) { cb.query().addOrderBy_TheLongAndWindingTableAndColumnId_Asc(); }
            public void spFKCol(VendorTheLongAndWindingTableAndColumnRefCB cb) { cb.specify().columnTheLongAndWindingTableAndColumnId(); }
            public List<VendorTheLongAndWindingTableAndColumnRef> selRfLs(VendorTheLongAndWindingTableAndColumnRefCB cb) { return referrerBhv.selectList(cb); }
            public Long getFKVal(VendorTheLongAndWindingTableAndColumnRef e) { return e.getTheLongAndWindingTableAndColumnId(); }
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
            public Long getCV(VendorTheLongAndWindingTableAndColumn e) { return e.getTheLongAndWindingTableAndColumnId(); }
        });
    }

    /**
     * Extract the value list of (single) unique key theLongAndWindingTableAndColumnName.
     * @param vendorTheLongAndWindingTableAndColumnList The list of vendorTheLongAndWindingTableAndColumn. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractTheLongAndWindingTableAndColumnNameList(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        return helpExtractListInternally(vendorTheLongAndWindingTableAndColumnList, new InternalExtractCallback<VendorTheLongAndWindingTableAndColumn, String>() {
            public String getCV(VendorTheLongAndWindingTableAndColumn e) { return e.getTheLongAndWindingTableAndColumnName(); }
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">insert</span>(vendorTheLongAndWindingTableAndColumn);
     * ... = vendorTheLongAndWindingTableAndColumn.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param vendorTheLongAndWindingTableAndColumn The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn) {
        doInsert(vendorTheLongAndWindingTableAndColumn, null);
    }

    protected void doInsert(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, InsertOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumn", vendorTheLongAndWindingTableAndColumn);
        prepareInsertOption(option);
        delegateInsert(vendorTheLongAndWindingTableAndColumn, option);
    }

    protected void prepareInsertOption(InsertOption<VendorTheLongAndWindingTableAndColumnCB> option) {
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
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * vendorTheLongAndWindingTableAndColumn.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * vendorTheLongAndWindingTableAndColumn.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//vendorTheLongAndWindingTableAndColumn.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorTheLongAndWindingTableAndColumn.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">update</span>(vendorTheLongAndWindingTableAndColumn);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn) {
        doUpdate(vendorTheLongAndWindingTableAndColumn, null);
    }

    protected void doUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, final UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumn", vendorTheLongAndWindingTableAndColumn);
        prepareUpdateOption(option);
        helpUpdateInternally(vendorTheLongAndWindingTableAndColumn, new InternalUpdateCallback<VendorTheLongAndWindingTableAndColumn>() {
            public int callbackDelegateUpdate(VendorTheLongAndWindingTableAndColumn entity) { return delegateUpdate(entity, option); } });
    }

    protected void prepareUpdateOption(UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        if (option == null) { return; }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
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
     * @param vendorTheLongAndWindingTableAndColumn The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn) {
        doInesrtOrUpdate(vendorTheLongAndWindingTableAndColumn, null, null);
    }

    protected void doInesrtOrUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, final InsertOption<VendorTheLongAndWindingTableAndColumnCB> insertOption, final UpdateOption<VendorTheLongAndWindingTableAndColumnCB> updateOption) {
        helpInsertOrUpdateInternally(vendorTheLongAndWindingTableAndColumn, new InternalInsertOrUpdateCallback<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB>() {
            public void callbackInsert(VendorTheLongAndWindingTableAndColumn entity) { doInsert(entity, insertOption); }
            public void callbackUpdate(VendorTheLongAndWindingTableAndColumn entity) { doUpdate(entity, updateOption); }
            public VendorTheLongAndWindingTableAndColumnCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(VendorTheLongAndWindingTableAndColumnCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdate(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<VendorTheLongAndWindingTableAndColumnCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<VendorTheLongAndWindingTableAndColumnCB>() : updateOption;
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
     * VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn = new VendorTheLongAndWindingTableAndColumn();
     * vendorTheLongAndWindingTableAndColumn.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * vendorTheLongAndWindingTableAndColumn.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">delete</span>(vendorTheLongAndWindingTableAndColumn);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn) {
        doDelete(vendorTheLongAndWindingTableAndColumn, null);
    }

    protected void doDelete(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, final DeleteOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumn", vendorTheLongAndWindingTableAndColumn);
        prepareDeleteOption(option);
        helpDeleteInternally(vendorTheLongAndWindingTableAndColumn, new InternalDeleteCallback<VendorTheLongAndWindingTableAndColumn>() {
            public int callbackDelegateDelete(VendorTheLongAndWindingTableAndColumn entity) { return delegateDelete(entity, option); } });
    }

    protected void prepareDeleteOption(DeleteOption<VendorTheLongAndWindingTableAndColumnCB> option) {
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">batchInsert</span>(vendorTheLongAndWindingTableAndColumnList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        InsertOption<VendorTheLongAndWindingTableAndColumnCB> option = createInsertUpdateOption();
        return doBatchInsert(vendorTheLongAndWindingTableAndColumnList, option);
    }

    protected int[] doBatchInsert(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, InsertOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumnList", vendorTheLongAndWindingTableAndColumnList);
        prepareBatchInsertOption(vendorTheLongAndWindingTableAndColumnList, option);
        return delegateBatchInsert(vendorTheLongAndWindingTableAndColumnList, option);
    }

    protected void prepareBatchInsertOption(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, InsertOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        option.xallowInsertColumnModifiedPropertiesFragmented();
        option.xacceptInsertColumnModifiedPropertiesIfNeeds(vendorTheLongAndWindingTableAndColumnList);
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">batchUpdate</span>(vendorTheLongAndWindingTableAndColumnList);
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option = createPlainUpdateOption();
        return doBatchUpdate(vendorTheLongAndWindingTableAndColumnList, option);
    }

    protected int[] doBatchUpdate(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumnList", vendorTheLongAndWindingTableAndColumnList);
        prepareBatchUpdateOption(vendorTheLongAndWindingTableAndColumnList, option);
        return delegateBatchUpdate(vendorTheLongAndWindingTableAndColumnList, option);
    }

    protected void prepareBatchUpdateOption(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        option.xacceptUpdateColumnModifiedPropertiesIfNeeds(vendorTheLongAndWindingTableAndColumnList);
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">batchUpdate</span>(vendorTheLongAndWindingTableAndColumnList, new SpecifyQuery<VendorTheLongAndWindingTableAndColumnCB>() {
     *     public void specify(VendorTheLongAndWindingTableAndColumnCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">batchUpdate</span>(vendorTheLongAndWindingTableAndColumnList, new SpecifyQuery<VendorTheLongAndWindingTableAndColumnCB>() {
     *     public void specify(VendorTheLongAndWindingTableAndColumnCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
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
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, SpecifyQuery<VendorTheLongAndWindingTableAndColumnCB> updateColumnSpec) {
        return doBatchUpdate(vendorTheLongAndWindingTableAndColumnList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        return doLumpModify(ls, option);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param vendorTheLongAndWindingTableAndColumnList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList) {
        return doBatchDelete(vendorTheLongAndWindingTableAndColumnList, null);
    }

    protected int[] doBatchDelete(List<VendorTheLongAndWindingTableAndColumn> vendorTheLongAndWindingTableAndColumnList, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumnList", vendorTheLongAndWindingTableAndColumnList);
        prepareDeleteOption(option);
        return delegateBatchDelete(vendorTheLongAndWindingTableAndColumnList, option);
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB&gt;() {
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

    protected int doQueryInsert(QueryInsertSetupper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB> setupper, InsertOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        VendorTheLongAndWindingTableAndColumn entity = new VendorTheLongAndWindingTableAndColumn();
        VendorTheLongAndWindingTableAndColumnCB intoCB = createCBForQueryInsert();
        ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">queryUpdate</span>(vendorTheLongAndWindingTableAndColumn, cb);
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB cb) {
        return doQueryUpdate(vendorTheLongAndWindingTableAndColumn, cb, null);
    }

    protected int doQueryUpdate(VendorTheLongAndWindingTableAndColumn vendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB cb, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertObjectNotNull("vendorTheLongAndWindingTableAndColumn", vendorTheLongAndWindingTableAndColumn); assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(vendorTheLongAndWindingTableAndColumn, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(Entity entity, ConditionBean cb, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return queryUpdate(downcast(entity), (VendorTheLongAndWindingTableAndColumnCB)cb); }
        else { return varyingQueryUpdate(downcast(entity), (VendorTheLongAndWindingTableAndColumnCB)cb, downcast(option)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * VendorTheLongAndWindingTableAndColumnCB cb = new VendorTheLongAndWindingTableAndColumnCB();
     * cb.query().setFoo...(value);
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">queryDelete</span>(vendorTheLongAndWindingTableAndColumn, cb);
     * </pre>
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(VendorTheLongAndWindingTableAndColumnCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(VendorTheLongAndWindingTableAndColumnCB cb, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, option) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return queryDelete((VendorTheLongAndWindingTableAndColumnCB)cb); }
        else { return varyingQueryDelete((VendorTheLongAndWindingTableAndColumnCB)cb, downcast(option)); }
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
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">varyingInsert</span>(vendorTheLongAndWindingTableAndColumn, option);
     * ... = vendorTheLongAndWindingTableAndColumn.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
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
     * vendorTheLongAndWindingTableAndColumn.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;VendorTheLongAndWindingTableAndColumnCB&gt; option = new UpdateOption&lt;VendorTheLongAndWindingTableAndColumnCB&gt;();
     *     option.self(new SpecifyQuery&lt;VendorTheLongAndWindingTableAndColumnCB&gt;() {
     *         public void specify(VendorTheLongAndWindingTableAndColumnCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">varyingUpdate</span>(vendorTheLongAndWindingTableAndColumn, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
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
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
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
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
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
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * vendorTheLongAndWindingTableAndColumnBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(vendorTheLongAndWindingTableAndColumn, cb, option);
     * </pre>
     * @param vendorTheLongAndWindingTableAndColumn The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of VendorTheLongAndWindingTableAndColumn. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
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
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
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
    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> void delegateSelectCursor(VendorTheLongAndWindingTableAndColumnCB cb, EntityRowHandler<ENTITY> erh, Class<ENTITY> et)
    { invoke(createSelectCursorCBCommand(cb, erh, et)); }
    protected <ENTITY extends VendorTheLongAndWindingTableAndColumn> List<ENTITY> delegateSelectList(VendorTheLongAndWindingTableAndColumnCB cb, Class<ENTITY> et)
    { return invoke(createSelectListCBCommand(cb, et)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(VendorTheLongAndWindingTableAndColumn e, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeInsert(e, op)) { return 0; }
      return invoke(createInsertEntityCommand(e, op)); }
    protected int delegateUpdate(VendorTheLongAndWindingTableAndColumn e, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return delegateUpdateNonstrict(e, op); }
    protected int delegateUpdateNonstrict(VendorTheLongAndWindingTableAndColumn e, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(e, op)); }
    protected int delegateDelete(VendorTheLongAndWindingTableAndColumn e, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return delegateDeleteNonstrict(e, op); }
    protected int delegateDeleteNonstrict(VendorTheLongAndWindingTableAndColumn e, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(e, op)); }

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

    protected int delegateQueryInsert(VendorTheLongAndWindingTableAndColumn e, VendorTheLongAndWindingTableAndColumnCB inCB, ConditionBean resCB, InsertOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeQueryInsert(e, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));  }
    protected int delegateQueryUpdate(VendorTheLongAndWindingTableAndColumn e, VendorTheLongAndWindingTableAndColumnCB cb, UpdateOption<VendorTheLongAndWindingTableAndColumnCB> op)
    { if (!processBeforeQueryUpdate(e, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(e, cb, op));  }
    protected int delegateQueryDelete(VendorTheLongAndWindingTableAndColumnCB cb, DeleteOption<VendorTheLongAndWindingTableAndColumnCB> op)
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
    protected VendorTheLongAndWindingTableAndColumn downcast(Entity entity) {
        return helpEntityDowncastInternally(entity, VendorTheLongAndWindingTableAndColumn.class);
    }

    protected VendorTheLongAndWindingTableAndColumnCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, VendorTheLongAndWindingTableAndColumnCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<VendorTheLongAndWindingTableAndColumn> downcast(List<? extends Entity> entityList) {
        return (List<VendorTheLongAndWindingTableAndColumn>)entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<VendorTheLongAndWindingTableAndColumnCB> downcast(InsertOption<? extends ConditionBean> option) {
        return (InsertOption<VendorTheLongAndWindingTableAndColumnCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<VendorTheLongAndWindingTableAndColumnCB> downcast(UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<VendorTheLongAndWindingTableAndColumnCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<VendorTheLongAndWindingTableAndColumnCB> downcast(DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<VendorTheLongAndWindingTableAndColumnCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnCB>)option;
    }
}
