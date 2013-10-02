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
 * The behavior of (会員ステータス)MEMBER_STATUS as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_STATUS_CODE
 * 
 * [column]
 *     MEMBER_STATUS_CODE, MEMBER_STATUS_NAME, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER, MEMBER_LOGIN
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     memberList, memberLoginList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberStatusBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /** The example for out of target in Sql2Entity */
    public static final String PATH_truncateMemberStatusInitialized = "truncateMemberStatusInitialized";
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "MEMBER_STATUS"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return MemberStatusDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberStatusDbm getMyDBMeta() { return MemberStatusDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public MemberStatus newMyEntity() { return new MemberStatus(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberStatusCB newMyConditionBean() { return new MemberStatusCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * int count = memberStatusBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberStatusCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberStatusCB cb) { // called by selectCount(cb) 
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberStatusCB cb) { // called by selectPage(cb)
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
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * MemberStatus memberStatus = memberStatusBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (memberStatus != null) {
     *     ... = memberStatus.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberStatus selectEntity(MemberStatusCB cb) {
        return doSelectEntity(cb, MemberStatus.class);
    }

    protected <ENTITY extends MemberStatus> ENTITY doSelectEntity(final MemberStatusCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType, new InternalSelectEntityCallback<ENTITY, MemberStatusCB>() {
            public List<ENTITY> callbackSelectList(MemberStatusCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * MemberStatus memberStatus = memberStatusBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberStatus.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberStatus selectEntityWithDeletedCheck(MemberStatusCB cb) {
        return doSelectEntityWithDeletedCheck(cb, MemberStatus.class);
    }

    protected <ENTITY extends MemberStatus> ENTITY doSelectEntityWithDeletedCheck(final MemberStatusCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(cb, entityType, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberStatusCB>() {
            public List<ENTITY> callbackSelectList(MemberStatusCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param memberStatusCode The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberStatus selectByPKValue(String memberStatusCode) {
        return doSelectByPKValue(memberStatusCode, MemberStatus.class);
    }

    protected <ENTITY extends MemberStatus> ENTITY doSelectByPKValue(String memberStatusCode, Class<ENTITY> entityType) {
        return doSelectEntity(buildPKCB(memberStatusCode), entityType);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param memberStatusCode The one of primary key. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberStatus selectByPKValueWithDeletedCheck(String memberStatusCode) {
        return doSelectByPKValueWithDeletedCheck(memberStatusCode, MemberStatus.class);
    }

    protected <ENTITY extends MemberStatus> ENTITY doSelectByPKValueWithDeletedCheck(String memberStatusCode, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(memberStatusCode), entityType);
    }

    private MemberStatusCB buildPKCB(String memberStatusCode) {
        assertObjectNotNull("memberStatusCode", memberStatusCode);
        MemberStatusCB cb = newMyConditionBean();
        cb.query().setMemberStatusCode_Equal(memberStatusCode);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;MemberStatus&gt; memberStatusList = memberStatusBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (MemberStatus memberStatus : memberStatusList) {
     *     ... = memberStatus.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberStatus> selectList(MemberStatusCB cb) {
        return doSelectList(cb, MemberStatus.class);
    }

    protected <ENTITY extends MemberStatus> ListResultBean<ENTITY> doSelectList(MemberStatusCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType, new InternalSelectListCallback<ENTITY, MemberStatusCB>() {
            public List<ENTITY> callbackSelectList(MemberStatusCB cb, Class<ENTITY> entityType) { return delegateSelectList(cb, entityType); } });
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
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberStatus&gt; page = memberStatusBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (MemberStatus memberStatus : page) {
     *     ... = memberStatus.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberStatus> selectPage(MemberStatusCB cb) {
        return doSelectPage(cb, MemberStatus.class);
    }

    protected <ENTITY extends MemberStatus> PagingResultBean<ENTITY> doSelectPage(MemberStatusCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType, new InternalSelectPageCallback<ENTITY, MemberStatusCB>() {
            public int callbackSelectCount(MemberStatusCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberStatusCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
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
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * memberStatusBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberStatus&gt;() {
     *     public void handle(MemberStatus entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberStatus. (NotNull)
     */
    public void selectCursor(MemberStatusCB cb, EntityRowHandler<MemberStatus> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, MemberStatus.class);
    }

    protected <ENTITY extends MemberStatus> void doSelectCursor(MemberStatusCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler<MemberStatus>", entityRowHandler); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType, new InternalSelectCursorCallback<ENTITY, MemberStatusCB>() {
            public void callbackSelectCursor(MemberStatusCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) { delegateSelectCursor(cb, entityRowHandler, entityType); }
            public List<ENTITY> callbackSelectList(MemberStatusCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberStatusBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberStatusCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar value derived by a function. (NullAllowed)
     */
    public <RESULT> SLFunction<MemberStatusCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends MemberStatusCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> resultType, CB cb) {
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
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberList(MemberStatus memberStatus, ConditionBeanSetupper<MemberCB> conditionBeanSetupper) {
        xassLRArg(memberStatus, conditionBeanSetupper);
        loadMemberList(xnewLRLs(memberStatus), conditionBeanSetupper);
    }
    /**
     * Load referrer of memberList with the set-upper for condition-bean of referrer. <br />
     * (会員)MEMBER by MEMBER_STATUS_CODE, named 'memberList'.
     * <pre>
     * memberStatusBhv.<span style="color: #FD4747">loadMemberList</span>(memberStatusList, new ConditionBeanSetupper&lt;MemberCB&gt;() {
     *     public void setup(MemberCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (MemberStatus memberStatus : memberStatusList) {
     *     ... = memberStatus.<span style="color: #FD4747">getMemberList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setMemberStatusCode_InScope(pkList);
     * cb.query().addOrderBy_MemberStatusCode_Asc();
     * </pre>
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberList(List<MemberStatus> memberStatusList, ConditionBeanSetupper<MemberCB> conditionBeanSetupper) {
        xassLRArg(memberStatusList, conditionBeanSetupper);
        loadMemberList(memberStatusList, new LoadReferrerOption<MemberCB, Member>().xinit(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberList(MemberStatus memberStatus, LoadReferrerOption<MemberCB, Member> loadReferrerOption) {
        xassLRArg(memberStatus, loadReferrerOption);
        loadMemberList(xnewLRLs(memberStatus), loadReferrerOption);
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberList(List<MemberStatus> memberStatusList, LoadReferrerOption<MemberCB, Member> loadReferrerOption) {
        xassLRArg(memberStatusList, loadReferrerOption);
        if (memberStatusList.isEmpty()) { return; }
        final MemberBhv referrerBhv = xgetBSFLR().select(MemberBhv.class);
        helpLoadReferrerInternally(memberStatusList, loadReferrerOption, new InternalLoadReferrerCallback<MemberStatus, String, MemberCB, Member>() {
            public String getPKVal(MemberStatus e)
            { return e.getMemberStatusCode(); }
            public void setRfLs(MemberStatus e, List<Member> ls)
            { e.setMemberList(ls); }
            public MemberCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(MemberCB cb, List<String> ls)
            { cb.query().setMemberStatusCode_InScope(ls); }
            public void qyOdFKAsc(MemberCB cb) { cb.query().addOrderBy_MemberStatusCode_Asc(); }
            public void spFKCol(MemberCB cb) { cb.specify().columnMemberStatusCode(); }
            public List<Member> selRfLs(MemberCB cb) { return referrerBhv.selectList(cb); }
            public String getFKVal(Member e) { return e.getMemberStatusCode(); }
            public void setlcEt(Member re, MemberStatus le)
            { re.setMemberStatus(le); }
            public String getRfPrNm() { return "memberList"; }
        });
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberLoginList(MemberStatus memberStatus, ConditionBeanSetupper<MemberLoginCB> conditionBeanSetupper) {
        xassLRArg(memberStatus, conditionBeanSetupper);
        loadMemberLoginList(xnewLRLs(memberStatus), conditionBeanSetupper);
    }
    /**
     * Load referrer of memberLoginList with the set-upper for condition-bean of referrer. <br />
     * (会員ログイン)MEMBER_LOGIN by LOGIN_MEMBER_STATUS_CODE, named 'memberLoginList'.
     * <pre>
     * memberStatusBhv.<span style="color: #FD4747">loadMemberLoginList</span>(memberStatusList, new ConditionBeanSetupper&lt;MemberLoginCB&gt;() {
     *     public void setup(MemberLoginCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (MemberStatus memberStatus : memberStatusList) {
     *     ... = memberStatus.<span style="color: #FD4747">getMemberLoginList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setLoginMemberStatusCode_InScope(pkList);
     * cb.query().addOrderBy_LoginMemberStatusCode_Asc();
     * </pre>
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberLoginList(List<MemberStatus> memberStatusList, ConditionBeanSetupper<MemberLoginCB> conditionBeanSetupper) {
        xassLRArg(memberStatusList, conditionBeanSetupper);
        loadMemberLoginList(memberStatusList, new LoadReferrerOption<MemberLoginCB, MemberLogin>().xinit(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param memberStatus The entity of memberStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberLoginList(MemberStatus memberStatus, LoadReferrerOption<MemberLoginCB, MemberLogin> loadReferrerOption) {
        xassLRArg(memberStatus, loadReferrerOption);
        loadMemberLoginList(xnewLRLs(memberStatus), loadReferrerOption);
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param memberStatusList The entity list of memberStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberLoginList(List<MemberStatus> memberStatusList, LoadReferrerOption<MemberLoginCB, MemberLogin> loadReferrerOption) {
        xassLRArg(memberStatusList, loadReferrerOption);
        if (memberStatusList.isEmpty()) { return; }
        final MemberLoginBhv referrerBhv = xgetBSFLR().select(MemberLoginBhv.class);
        helpLoadReferrerInternally(memberStatusList, loadReferrerOption, new InternalLoadReferrerCallback<MemberStatus, String, MemberLoginCB, MemberLogin>() {
            public String getPKVal(MemberStatus e)
            { return e.getMemberStatusCode(); }
            public void setRfLs(MemberStatus e, List<MemberLogin> ls)
            { e.setMemberLoginList(ls); }
            public MemberLoginCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(MemberLoginCB cb, List<String> ls)
            { cb.query().setLoginMemberStatusCode_InScope(ls); }
            public void qyOdFKAsc(MemberLoginCB cb) { cb.query().addOrderBy_LoginMemberStatusCode_Asc(); }
            public void spFKCol(MemberLoginCB cb) { cb.specify().columnLoginMemberStatusCode(); }
            public List<MemberLogin> selRfLs(MemberLoginCB cb) { return referrerBhv.selectList(cb); }
            public String getFKVal(MemberLogin e) { return e.getLoginMemberStatusCode(); }
            public void setlcEt(MemberLogin re, MemberStatus le)
            { re.setMemberStatus(le); }
            public String getRfPrNm() { return "memberLoginList"; }
        });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberStatusCode.
     * @param memberStatusList The list of memberStatus. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractMemberStatusCodeList(List<MemberStatus> memberStatusList) {
        return helpExtractListInternally(memberStatusList, new InternalExtractCallback<MemberStatus, String>() {
            public String getCV(MemberStatus e) { return e.getMemberStatusCode(); }
        });
    }

    /**
     * Extract the value list of (single) unique key displayOrder.
     * @param memberStatusList The list of memberStatus. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractDisplayOrderList(List<MemberStatus> memberStatusList) {
        return helpExtractListInternally(memberStatusList, new InternalExtractCallback<MemberStatus, Integer>() {
            public Integer getCV(MemberStatus e) { return e.getDisplayOrder(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * MemberStatus memberStatus = new MemberStatus();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberStatus.setFoo...(value);
     * memberStatus.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberStatus.set...;</span>
     * memberStatusBhv.<span style="color: #FD4747">insert</span>(memberStatus);
     * ... = memberStatus.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberStatus The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberStatus memberStatus) {
        doInsert(memberStatus, null);
    }

    protected void doInsert(MemberStatus memberStatus, InsertOption<MemberStatusCB> option) {
        assertObjectNotNull("memberStatus", memberStatus);
        prepareInsertOption(option);
        delegateInsert(memberStatus, option);
    }

    protected void prepareInsertOption(InsertOption<MemberStatusCB> option) {
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
     * MemberStatus memberStatus = new MemberStatus();
     * memberStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberStatus.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberStatus.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberStatus.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberStatusBhv.<span style="color: #FD4747">update</span>(memberStatus);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param memberStatus The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final MemberStatus memberStatus) {
        doUpdate(memberStatus, null);
    }

    protected void doUpdate(MemberStatus memberStatus, final UpdateOption<MemberStatusCB> option) {
        assertObjectNotNull("memberStatus", memberStatus);
        prepareUpdateOption(option);
        helpUpdateInternally(memberStatus, new InternalUpdateCallback<MemberStatus>() {
            public int callbackDelegateUpdate(MemberStatus entity) { return delegateUpdate(entity, option); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberStatusCB> option) {
        if (option == null) { return; }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected MemberStatusCB createCBForVaryingUpdate() {
        MemberStatusCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected MemberStatusCB createCBForSpecifiedUpdate() {
        MemberStatusCB cb = newMyConditionBean();
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
     * @param memberStatus The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberStatus memberStatus) {
        doInesrtOrUpdate(memberStatus, null, null);
    }

    protected void doInesrtOrUpdate(MemberStatus memberStatus, final InsertOption<MemberStatusCB> insertOption, final UpdateOption<MemberStatusCB> updateOption) {
        helpInsertOrUpdateInternally(memberStatus, new InternalInsertOrUpdateCallback<MemberStatus, MemberStatusCB>() {
            public void callbackInsert(MemberStatus entity) { doInsert(entity, insertOption); }
            public void callbackUpdate(MemberStatus entity) { doUpdate(entity, updateOption); }
            public MemberStatusCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(MemberStatusCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdate(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<MemberStatusCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<MemberStatusCB>() : updateOption;
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
     * MemberStatus memberStatus = new MemberStatus();
     * memberStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberStatus.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberStatusBhv.<span style="color: #FD4747">delete</span>(memberStatus);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param memberStatus The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberStatus memberStatus) {
        doDelete(memberStatus, null);
    }

    protected void doDelete(MemberStatus memberStatus, final DeleteOption<MemberStatusCB> option) {
        assertObjectNotNull("memberStatus", memberStatus);
        prepareDeleteOption(option);
        helpDeleteInternally(memberStatus, new InternalDeleteCallback<MemberStatus>() {
            public int callbackDelegateDelete(MemberStatus entity) { return delegateDelete(entity, option); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberStatusCB> option) {
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
     *     MemberStatus memberStatus = new MemberStatus();
     *     memberStatus.setFooName("foo");
     *     if (...) {
     *         memberStatus.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberStatusList.add(memberStatus);
     * }
     * memberStatusBhv.<span style="color: #FD4747">batchInsert</span>(memberStatusList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberStatus> memberStatusList) {
        InsertOption<MemberStatusCB> option = createInsertUpdateOption();
        return doBatchInsert(memberStatusList, option);
    }

    protected int[] doBatchInsert(List<MemberStatus> memberStatusList, InsertOption<MemberStatusCB> option) {
        assertObjectNotNull("memberStatusList", memberStatusList);
        prepareBatchInsertOption(memberStatusList, option);
        return delegateBatchInsert(memberStatusList, option);
    }

    protected void prepareBatchInsertOption(List<MemberStatus> memberStatusList, InsertOption<MemberStatusCB> option) {
        option.xallowInsertColumnModifiedPropertiesFragmented();
        option.xacceptInsertColumnModifiedPropertiesIfNeeds(memberStatusList);
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
     *     MemberStatus memberStatus = new MemberStatus();
     *     memberStatus.setFooName("foo");
     *     if (...) {
     *         memberStatus.setFooPrice(123);
     *     } else {
     *         memberStatus.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberStatus.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberStatusList.add(memberStatus);
     * }
     * memberStatusBhv.<span style="color: #FD4747">batchUpdate</span>(memberStatusList);
     * </pre>
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberStatus> memberStatusList) {
        UpdateOption<MemberStatusCB> option = createPlainUpdateOption();
        return doBatchUpdate(memberStatusList, option);
    }

    protected int[] doBatchUpdate(List<MemberStatus> memberStatusList, UpdateOption<MemberStatusCB> option) {
        assertObjectNotNull("memberStatusList", memberStatusList);
        prepareBatchUpdateOption(memberStatusList, option);
        return delegateBatchUpdate(memberStatusList, option);
    }

    protected void prepareBatchUpdateOption(List<MemberStatus> memberStatusList, UpdateOption<MemberStatusCB> option) {
        option.xacceptUpdateColumnModifiedPropertiesIfNeeds(memberStatusList);
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
     * memberStatusBhv.<span style="color: #FD4747">batchUpdate</span>(memberStatusList, new SpecifyQuery<MemberStatusCB>() {
     *     public void specify(MemberStatusCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * memberStatusBhv.<span style="color: #FD4747">batchUpdate</span>(memberStatusList, new SpecifyQuery<MemberStatusCB>() {
     *     public void specify(MemberStatusCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberStatus> memberStatusList, SpecifyQuery<MemberStatusCB> updateColumnSpec) {
        return doBatchUpdate(memberStatusList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        return doLumpModify(ls, option);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<MemberStatus> memberStatusList) {
        return doBatchDelete(memberStatusList, null);
    }

    protected int[] doBatchDelete(List<MemberStatus> memberStatusList, DeleteOption<MemberStatusCB> option) {
        assertObjectNotNull("memberStatusList", memberStatusList);
        prepareDeleteOption(option);
        return delegateBatchDelete(memberStatusList, option);
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
     * memberStatusBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberStatus, MemberStatusCB&gt;() {
     *     public ConditionBean setup(memberStatus entity, MemberStatusCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<MemberStatus, MemberStatusCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberStatus, MemberStatusCB> setupper, InsertOption<MemberStatusCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        MemberStatus entity = new MemberStatus();
        MemberStatusCB intoCB = createCBForQueryInsert();
        ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected MemberStatusCB createCBForQueryInsert() {
        MemberStatusCB cb = newMyConditionBean();
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
     * MemberStatus memberStatus = new MemberStatus();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberStatus.setPK...(value);</span>
     * memberStatus.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberStatus.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberStatus.setVersionNo(value);</span>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * memberStatusBhv.<span style="color: #FD4747">queryUpdate</span>(memberStatus, cb);
     * </pre>
     * @param memberStatus The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberStatus memberStatus, MemberStatusCB cb) {
        return doQueryUpdate(memberStatus, cb, null);
    }

    protected int doQueryUpdate(MemberStatus memberStatus, MemberStatusCB cb, UpdateOption<MemberStatusCB> option) {
        assertObjectNotNull("memberStatus", memberStatus); assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(memberStatus, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(Entity entity, ConditionBean cb, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return queryUpdate(downcast(entity), (MemberStatusCB)cb); }
        else { return varyingQueryUpdate(downcast(entity), (MemberStatusCB)cb, downcast(option)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * memberStatusBhv.<span style="color: #FD4747">queryDelete</span>(memberStatus, cb);
     * </pre>
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberStatusCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberStatusCB cb, DeleteOption<MemberStatusCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, option) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return queryDelete((MemberStatusCB)cb); }
        else { return varyingQueryDelete((MemberStatusCB)cb, downcast(option)); }
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
     * MemberStatus memberStatus = new MemberStatus();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberStatus.setFoo...(value);
     * memberStatus.setBar...(value);
     * InsertOption<MemberStatusCB> option = new InsertOption<MemberStatusCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberStatusBhv.<span style="color: #FD4747">varyingInsert</span>(memberStatus, option);
     * ... = memberStatus.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberStatus The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(MemberStatus memberStatus, InsertOption<MemberStatusCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(memberStatus, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * MemberStatus memberStatus = new MemberStatus();
     * memberStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberStatus.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * memberStatus.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberStatusCB&gt; option = new UpdateOption&lt;MemberStatusCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberStatusCB&gt;() {
     *         public void specify(MemberStatusCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberStatusBhv.<span style="color: #FD4747">varyingUpdate</span>(memberStatus, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberStatus The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(MemberStatus memberStatus, UpdateOption<MemberStatusCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(memberStatus, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberStatus The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberStatus memberStatus, InsertOption<MemberStatusCB> insertOption, UpdateOption<MemberStatusCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(memberStatus, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberStatus The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberStatus memberStatus, DeleteOption<MemberStatusCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberStatus, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<MemberStatus> memberStatusList, InsertOption<MemberStatusCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberStatusList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<MemberStatus> memberStatusList, UpdateOption<MemberStatusCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberStatusList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<MemberStatus> memberStatusList, DeleteOption<MemberStatusCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberStatusList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<MemberStatus, MemberStatusCB> setupper, InsertOption<MemberStatusCB> option) {
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
     * MemberStatus memberStatus = new MemberStatus();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberStatus.setPK...(value);</span>
     * memberStatus.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberStatus.setVersionNo(value);</span>
     * MemberStatusCB cb = new MemberStatusCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberStatusCB&gt; option = new UpdateOption&lt;MemberStatusCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberStatusCB&gt;() {
     *     public void specify(MemberStatusCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberStatusBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(memberStatus, cb, option);
     * </pre>
     * @param memberStatus The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(MemberStatus memberStatus, MemberStatusCB cb, UpdateOption<MemberStatusCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(memberStatus, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of MemberStatus. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberStatusCB cb, DeleteOption<MemberStatusCB> option) {
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
    public OutsideSqlBasicExecutor<MemberStatusBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(MemberStatusCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(MemberStatusCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends MemberStatus> void delegateSelectCursor(MemberStatusCB cb, EntityRowHandler<ENTITY> erh, Class<ENTITY> et)
    { invoke(createSelectCursorCBCommand(cb, erh, et)); }
    protected <ENTITY extends MemberStatus> List<ENTITY> delegateSelectList(MemberStatusCB cb, Class<ENTITY> et)
    { return invoke(createSelectListCBCommand(cb, et)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(MemberStatus e, InsertOption<MemberStatusCB> op)
    { if (!processBeforeInsert(e, op)) { return 0; }
      return invoke(createInsertEntityCommand(e, op)); }
    protected int delegateUpdate(MemberStatus e, UpdateOption<MemberStatusCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return delegateUpdateNonstrict(e, op); }
    protected int delegateUpdateNonstrict(MemberStatus e, UpdateOption<MemberStatusCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(e, op)); }
    protected int delegateDelete(MemberStatus e, DeleteOption<MemberStatusCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return delegateDeleteNonstrict(e, op); }
    protected int delegateDeleteNonstrict(MemberStatus e, DeleteOption<MemberStatusCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(e, op)); }

    protected int[] delegateBatchInsert(List<MemberStatus> ls, InsertOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<MemberStatus> ls, UpdateOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<MemberStatus> ls, UpdateOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<MemberStatus> ls, DeleteOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<MemberStatus> ls, DeleteOption<MemberStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(MemberStatus e, MemberStatusCB inCB, ConditionBean resCB, InsertOption<MemberStatusCB> op)
    { if (!processBeforeQueryInsert(e, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));  }
    protected int delegateQueryUpdate(MemberStatus e, MemberStatusCB cb, UpdateOption<MemberStatusCB> op)
    { if (!processBeforeQueryUpdate(e, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(e, cb, op));  }
    protected int delegateQueryDelete(MemberStatusCB cb, DeleteOption<MemberStatusCB> op)
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
    protected MemberStatus downcast(Entity entity) {
        return helpEntityDowncastInternally(entity, MemberStatus.class);
    }

    protected MemberStatusCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, MemberStatusCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<MemberStatus> downcast(List<? extends Entity> entityList) {
        return (List<MemberStatus>)entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberStatusCB> downcast(InsertOption<? extends ConditionBean> option) {
        return (InsertOption<MemberStatusCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberStatusCB> downcast(UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<MemberStatusCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberStatusCB> downcast(DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<MemberStatusCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberStatus, MemberStatusCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<MemberStatus, MemberStatusCB>)option;
    }
}
