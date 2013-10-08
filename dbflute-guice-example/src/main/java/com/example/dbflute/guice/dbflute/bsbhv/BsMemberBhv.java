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
 * The behavior of (会員)MEMBER as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, MEMBER_ACCOUNT, MEMBER_STATUS_CODE, FORMALIZED_DATETIME, BIRTHDATE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     SEQ_MEMBER
 * 
 * [identity]
 *     MEMBER_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign table]
 *     MEMBER_STATUS, MEMBER_ADDRESS(AsValid), MEMBER_SECURITY(AsOne), MEMBER_SERVICE(AsOne), MEMBER_WITHDRAWAL(AsOne)
 * 
 * [referrer table]
 *     MEMBER_ADDRESS, MEMBER_FOLLOWING, MEMBER_LOGIN, PURCHASE, MEMBER_SECURITY, MEMBER_SERVICE, MEMBER_WITHDRAWAL
 * 
 * [foreign property]
 *     memberStatus, memberAddressAsValid, memberSecurityAsOne, memberServiceAsOne, memberWithdrawalAsOne
 * 
 * [referrer property]
 *     memberAddressList, memberFollowingByMyMemberIdList, memberFollowingByYourMemberIdList, memberLoginList, purchaseList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    public static final String PATH_selectLatestFormalizedDatetime = "selectLatestFormalizedDatetime";
    public static final String PATH_selectMemberName = "selectMemberName";
    public static final String PATH_selectOptionMember = "selectOptionMember";
    public static final String PATH_selectPurchaseMaxPriceMember = "selectPurchaseMaxPriceMember";
    public static final String PATH_selectPurchaseSummaryMember = "selectPurchaseSummaryMember";
    /** Simple Member Select */
    public static final String PATH_selectSimpleMember = "selectSimpleMember";
    public static final String PATH_selectUnpaidSummaryMember = "selectUnpaidSummaryMember";
    public static final String PATH_updateMemberChangedToWithdrawalForcedly = "updateMemberChangedToWithdrawalForcedly";
    public static final String PATH_subdirectory_selectSubDirectoryCheck = "subdirectory:selectSubDirectoryCheck";
    public static final String PATH_whitebox_cmentity_selectCommonColumnMember = "whitebox:cmentity:selectCommonColumnMember";
    public static final String PATH_whitebox_cmentity_selectForcedType = "whitebox:cmentity:selectForcedType";
    public static final String PATH_whitebox_pmbean_selectCompareDate = "whitebox:pmbean:selectCompareDate";
    public static final String PATH_whitebox_pmbean_selectMapLikeSearch = "whitebox:pmbean:selectMapLikeSearch";
    public static final String PATH_whitebox_pmbean_selectResolvedPackageName = "whitebox:pmbean:selectResolvedPackageName";
    public static final String PATH_whitebox_pmcomment_selectPmCommentHint = "whitebox:pmcomment:selectPmCommentHint";
    public static final String PATH_whitebox_pmcomment_selectPmCommentPossible = "whitebox:pmcomment:selectPmCommentPossible";
    public static final String PATH_whitebox_wrongexample_selectBindVariableNotFoundProperty = "whitebox:wrongexample:selectBindVariableNotFoundProperty";
    public static final String PATH_whitebox_wrongexample_selectEndCommentNotFound = "whitebox:wrongexample:selectEndCommentNotFound";
    public static final String PATH_whitebox_wrongexample_selectIfCommentNotBooleanResult = "whitebox:wrongexample:selectIfCommentNotBooleanResult";
    public static final String PATH_whitebox_wrongexample_selectIfCommentWrongExpression = "whitebox:wrongexample:selectIfCommentWrongExpression";
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "MEMBER"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return MemberDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberDbm getMyDBMeta() { return MemberDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public Member newMyEntity() { return new Member(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberCB newMyConditionBean() { return new MemberCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * int count = memberBhv.<span style="color: #FD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of Member. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberCB cb) { // called by selectCount(cb) 
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberCB cb) { // called by selectPage(cb)
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
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * Member member = memberBhv.<span style="color: #FD4747">selectEntity</span>(cb);
     * if (member != null) {
     *     ... = member.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of Member. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public Member selectEntity(MemberCB cb) {
        return doSelectEntity(cb, Member.class);
    }

    protected <ENTITY extends Member> ENTITY doSelectEntity(final MemberCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityInternally(cb, entityType, new InternalSelectEntityCallback<ENTITY, MemberCB>() {
            public List<ENTITY> callbackSelectList(MemberCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check.
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * Member member = memberBhv.<span style="color: #FD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = member.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of Member. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public Member selectEntityWithDeletedCheck(MemberCB cb) {
        return doSelectEntityWithDeletedCheck(cb, Member.class);
    }

    protected <ENTITY extends Member> ENTITY doSelectEntityWithDeletedCheck(final MemberCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb);
        return helpSelectEntityWithDeletedCheckInternally(cb, entityType, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, MemberCB>() {
            public List<ENTITY> callbackSelectList(MemberCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); } });
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
    public Member selectByPKValue(Integer memberId) {
        return doSelectByPKValue(memberId, Member.class);
    }

    protected <ENTITY extends Member> ENTITY doSelectByPKValue(Integer memberId, Class<ENTITY> entityType) {
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
    public Member selectByPKValueWithDeletedCheck(Integer memberId) {
        return doSelectByPKValueWithDeletedCheck(memberId, Member.class);
    }

    protected <ENTITY extends Member> ENTITY doSelectByPKValueWithDeletedCheck(Integer memberId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(buildPKCB(memberId), entityType);
    }

    private MemberCB buildPKCB(Integer memberId) {
        assertObjectNotNull("memberId", memberId);
        MemberCB cb = newMyConditionBean();
        cb.query().setMemberId_Equal(memberId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;Member&gt; memberList = memberBhv.<span style="color: #FD4747">selectList</span>(cb);
     * for (Member member : memberList) {
     *     ... = member.get...();
     * }
     * </pre>
     * @param cb The condition-bean of Member. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<Member> selectList(MemberCB cb) {
        return doSelectList(cb, Member.class);
    }

    protected <ENTITY extends Member> ListResultBean<ENTITY> doSelectList(MemberCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        return helpSelectListInternally(cb, entityType, new InternalSelectListCallback<ENTITY, MemberCB>() {
            public List<ENTITY> callbackSelectList(MemberCB cb, Class<ENTITY> entityType) { return delegateSelectList(cb, entityType); } });
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
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #FD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;Member&gt; page = memberBhv.<span style="color: #FD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (Member member : page) {
     *     ... = member.get...();
     * }
     * </pre>
     * @param cb The condition-bean of Member. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception org.seasar.dbflute.exception.DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<Member> selectPage(MemberCB cb) {
        return doSelectPage(cb, Member.class);
    }

    protected <ENTITY extends Member> PagingResultBean<ENTITY> doSelectPage(MemberCB cb, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", entityType);
        return helpSelectPageInternally(cb, entityType, new InternalSelectPageCallback<ENTITY, MemberCB>() {
            public int callbackSelectCount(MemberCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(MemberCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
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
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * memberBhv.<span style="color: #FD4747">selectCursor</span>(cb, new EntityRowHandler&lt;Member&gt;() {
     *     public void handle(Member entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of Member. (NotNull)
     * @param entityRowHandler The handler of entity row of Member. (NotNull)
     */
    public void selectCursor(MemberCB cb, EntityRowHandler<Member> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, Member.class);
    }

    protected <ENTITY extends Member> void doSelectCursor(MemberCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler<Member>", entityRowHandler); assertObjectNotNull("entityType", entityType);
        assertSpecifyDerivedReferrerEntityProperty(cb, entityType);
        helpSelectCursorInternally(cb, entityRowHandler, entityType, new InternalSelectCursorCallback<ENTITY, MemberCB>() {
            public void callbackSelectCursor(MemberCB cb, EntityRowHandler<ENTITY> entityRowHandler, Class<ENTITY> entityType) { delegateSelectCursor(cb, entityRowHandler, entityType); }
            public List<ENTITY> callbackSelectList(MemberCB cb, Class<ENTITY> entityType) { return doSelectList(cb, entityType); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberBhv.<span style="color: #FD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar value derived by a function. (NullAllowed)
     */
    public <RESULT> SLFunction<MemberCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends MemberCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> resultType, CB cb) {
        assertObjectNotNull("resultType", resultType); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return new SLFunction<CB, RESULT>(cb, resultType);
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
    public Integer selectNextVal() {
        return doSelectNextVal(Integer.class);
    }

    protected <RESULT> RESULT doSelectNextVal(Class<RESULT> resultType) {
        return delegateSelectNextVal(resultType);
    }

    @Override
    protected Number doReadNextVal() {
        return selectNextVal();
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberAddressList(Member member, ConditionBeanSetupper<MemberAddressCB> conditionBeanSetupper) {
        xassLRArg(member, conditionBeanSetupper);
        loadMemberAddressList(xnewLRLs(member), conditionBeanSetupper);
    }
    /**
     * Load referrer of memberAddressList with the set-upper for condition-bean of referrer. <br />
     * (会員住所情報)MEMBER_ADDRESS by MEMBER_ID, named 'memberAddressList'.
     * <pre>
     * memberBhv.<span style="color: #FD4747">loadMemberAddressList</span>(memberList, new ConditionBeanSetupper&lt;MemberAddressCB&gt;() {
     *     public void setup(MemberAddressCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (Member member : memberList) {
     *     ... = member.<span style="color: #FD4747">getMemberAddressList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setMemberId_InScope(pkList);
     * cb.query().addOrderBy_MemberId_Asc();
     * </pre>
     * @param memberList The entity list of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberAddressList(List<Member> memberList, ConditionBeanSetupper<MemberAddressCB> conditionBeanSetupper) {
        xassLRArg(memberList, conditionBeanSetupper);
        loadMemberAddressList(memberList, new LoadReferrerOption<MemberAddressCB, MemberAddress>().xinit(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberAddressList(Member member, LoadReferrerOption<MemberAddressCB, MemberAddress> loadReferrerOption) {
        xassLRArg(member, loadReferrerOption);
        loadMemberAddressList(xnewLRLs(member), loadReferrerOption);
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param memberList The entity list of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberAddressList(List<Member> memberList, LoadReferrerOption<MemberAddressCB, MemberAddress> loadReferrerOption) {
        xassLRArg(memberList, loadReferrerOption);
        if (memberList.isEmpty()) { return; }
        final MemberAddressBhv referrerBhv = xgetBSFLR().select(MemberAddressBhv.class);
        helpLoadReferrerInternally(memberList, loadReferrerOption, new InternalLoadReferrerCallback<Member, Integer, MemberAddressCB, MemberAddress>() {
            public Integer getPKVal(Member e)
            { return e.getMemberId(); }
            public void setRfLs(Member e, List<MemberAddress> ls)
            { e.setMemberAddressList(ls); }
            public MemberAddressCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(MemberAddressCB cb, List<Integer> ls)
            { cb.query().setMemberId_InScope(ls); }
            public void qyOdFKAsc(MemberAddressCB cb) { cb.query().addOrderBy_MemberId_Asc(); }
            public void spFKCol(MemberAddressCB cb) { cb.specify().columnMemberId(); }
            public List<MemberAddress> selRfLs(MemberAddressCB cb) { return referrerBhv.selectList(cb); }
            public Integer getFKVal(MemberAddress e) { return e.getMemberId(); }
            public void setlcEt(MemberAddress re, Member le)
            { re.setMember(le); }
            public String getRfPrNm() { return "memberAddressList"; }
        });
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberFollowingByMyMemberIdList(Member member, ConditionBeanSetupper<MemberFollowingCB> conditionBeanSetupper) {
        xassLRArg(member, conditionBeanSetupper);
        loadMemberFollowingByMyMemberIdList(xnewLRLs(member), conditionBeanSetupper);
    }
    /**
     * Load referrer of memberFollowingByMyMemberIdList with the set-upper for condition-bean of referrer. <br />
     * (会員フォローイング)MEMBER_FOLLOWING by MY_MEMBER_ID, named 'memberFollowingByMyMemberIdList'.
     * <pre>
     * memberBhv.<span style="color: #FD4747">loadMemberFollowingByMyMemberIdList</span>(memberList, new ConditionBeanSetupper&lt;MemberFollowingCB&gt;() {
     *     public void setup(MemberFollowingCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (Member member : memberList) {
     *     ... = member.<span style="color: #FD4747">getMemberFollowingByMyMemberIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setMyMemberId_InScope(pkList);
     * cb.query().addOrderBy_MyMemberId_Asc();
     * </pre>
     * @param memberList The entity list of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberFollowingByMyMemberIdList(List<Member> memberList, ConditionBeanSetupper<MemberFollowingCB> conditionBeanSetupper) {
        xassLRArg(memberList, conditionBeanSetupper);
        loadMemberFollowingByMyMemberIdList(memberList, new LoadReferrerOption<MemberFollowingCB, MemberFollowing>().xinit(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberFollowingByMyMemberIdList(Member member, LoadReferrerOption<MemberFollowingCB, MemberFollowing> loadReferrerOption) {
        xassLRArg(member, loadReferrerOption);
        loadMemberFollowingByMyMemberIdList(xnewLRLs(member), loadReferrerOption);
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param memberList The entity list of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberFollowingByMyMemberIdList(List<Member> memberList, LoadReferrerOption<MemberFollowingCB, MemberFollowing> loadReferrerOption) {
        xassLRArg(memberList, loadReferrerOption);
        if (memberList.isEmpty()) { return; }
        final MemberFollowingBhv referrerBhv = xgetBSFLR().select(MemberFollowingBhv.class);
        helpLoadReferrerInternally(memberList, loadReferrerOption, new InternalLoadReferrerCallback<Member, Integer, MemberFollowingCB, MemberFollowing>() {
            public Integer getPKVal(Member e)
            { return e.getMemberId(); }
            public void setRfLs(Member e, List<MemberFollowing> ls)
            { e.setMemberFollowingByMyMemberIdList(ls); }
            public MemberFollowingCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(MemberFollowingCB cb, List<Integer> ls)
            { cb.query().setMyMemberId_InScope(ls); }
            public void qyOdFKAsc(MemberFollowingCB cb) { cb.query().addOrderBy_MyMemberId_Asc(); }
            public void spFKCol(MemberFollowingCB cb) { cb.specify().columnMyMemberId(); }
            public List<MemberFollowing> selRfLs(MemberFollowingCB cb) { return referrerBhv.selectList(cb); }
            public Integer getFKVal(MemberFollowing e) { return e.getMyMemberId(); }
            public void setlcEt(MemberFollowing re, Member le)
            { re.setMemberByMyMemberId(le); }
            public String getRfPrNm() { return "memberFollowingByMyMemberIdList"; }
        });
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberFollowingByYourMemberIdList(Member member, ConditionBeanSetupper<MemberFollowingCB> conditionBeanSetupper) {
        xassLRArg(member, conditionBeanSetupper);
        loadMemberFollowingByYourMemberIdList(xnewLRLs(member), conditionBeanSetupper);
    }
    /**
     * Load referrer of memberFollowingByYourMemberIdList with the set-upper for condition-bean of referrer. <br />
     * (会員フォローイング)MEMBER_FOLLOWING by YOUR_MEMBER_ID, named 'memberFollowingByYourMemberIdList'.
     * <pre>
     * memberBhv.<span style="color: #FD4747">loadMemberFollowingByYourMemberIdList</span>(memberList, new ConditionBeanSetupper&lt;MemberFollowingCB&gt;() {
     *     public void setup(MemberFollowingCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (Member member : memberList) {
     *     ... = member.<span style="color: #FD4747">getMemberFollowingByYourMemberIdList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setYourMemberId_InScope(pkList);
     * cb.query().addOrderBy_YourMemberId_Asc();
     * </pre>
     * @param memberList The entity list of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberFollowingByYourMemberIdList(List<Member> memberList, ConditionBeanSetupper<MemberFollowingCB> conditionBeanSetupper) {
        xassLRArg(memberList, conditionBeanSetupper);
        loadMemberFollowingByYourMemberIdList(memberList, new LoadReferrerOption<MemberFollowingCB, MemberFollowing>().xinit(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberFollowingByYourMemberIdList(Member member, LoadReferrerOption<MemberFollowingCB, MemberFollowing> loadReferrerOption) {
        xassLRArg(member, loadReferrerOption);
        loadMemberFollowingByYourMemberIdList(xnewLRLs(member), loadReferrerOption);
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param memberList The entity list of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberFollowingByYourMemberIdList(List<Member> memberList, LoadReferrerOption<MemberFollowingCB, MemberFollowing> loadReferrerOption) {
        xassLRArg(memberList, loadReferrerOption);
        if (memberList.isEmpty()) { return; }
        final MemberFollowingBhv referrerBhv = xgetBSFLR().select(MemberFollowingBhv.class);
        helpLoadReferrerInternally(memberList, loadReferrerOption, new InternalLoadReferrerCallback<Member, Integer, MemberFollowingCB, MemberFollowing>() {
            public Integer getPKVal(Member e)
            { return e.getMemberId(); }
            public void setRfLs(Member e, List<MemberFollowing> ls)
            { e.setMemberFollowingByYourMemberIdList(ls); }
            public MemberFollowingCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(MemberFollowingCB cb, List<Integer> ls)
            { cb.query().setYourMemberId_InScope(ls); }
            public void qyOdFKAsc(MemberFollowingCB cb) { cb.query().addOrderBy_YourMemberId_Asc(); }
            public void spFKCol(MemberFollowingCB cb) { cb.specify().columnYourMemberId(); }
            public List<MemberFollowing> selRfLs(MemberFollowingCB cb) { return referrerBhv.selectList(cb); }
            public Integer getFKVal(MemberFollowing e) { return e.getYourMemberId(); }
            public void setlcEt(MemberFollowing re, Member le)
            { re.setMemberByYourMemberId(le); }
            public String getRfPrNm() { return "memberFollowingByYourMemberIdList"; }
        });
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberLoginList(Member member, ConditionBeanSetupper<MemberLoginCB> conditionBeanSetupper) {
        xassLRArg(member, conditionBeanSetupper);
        loadMemberLoginList(xnewLRLs(member), conditionBeanSetupper);
    }
    /**
     * Load referrer of memberLoginList with the set-upper for condition-bean of referrer. <br />
     * (会員ログイン)MEMBER_LOGIN by MEMBER_ID, named 'memberLoginList'.
     * <pre>
     * memberBhv.<span style="color: #FD4747">loadMemberLoginList</span>(memberList, new ConditionBeanSetupper&lt;MemberLoginCB&gt;() {
     *     public void setup(MemberLoginCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (Member member : memberList) {
     *     ... = member.<span style="color: #FD4747">getMemberLoginList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setMemberId_InScope(pkList);
     * cb.query().addOrderBy_MemberId_Asc();
     * </pre>
     * @param memberList The entity list of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadMemberLoginList(List<Member> memberList, ConditionBeanSetupper<MemberLoginCB> conditionBeanSetupper) {
        xassLRArg(memberList, conditionBeanSetupper);
        loadMemberLoginList(memberList, new LoadReferrerOption<MemberLoginCB, MemberLogin>().xinit(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberLoginList(Member member, LoadReferrerOption<MemberLoginCB, MemberLogin> loadReferrerOption) {
        xassLRArg(member, loadReferrerOption);
        loadMemberLoginList(xnewLRLs(member), loadReferrerOption);
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param memberList The entity list of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadMemberLoginList(List<Member> memberList, LoadReferrerOption<MemberLoginCB, MemberLogin> loadReferrerOption) {
        xassLRArg(memberList, loadReferrerOption);
        if (memberList.isEmpty()) { return; }
        final MemberLoginBhv referrerBhv = xgetBSFLR().select(MemberLoginBhv.class);
        helpLoadReferrerInternally(memberList, loadReferrerOption, new InternalLoadReferrerCallback<Member, Integer, MemberLoginCB, MemberLogin>() {
            public Integer getPKVal(Member e)
            { return e.getMemberId(); }
            public void setRfLs(Member e, List<MemberLogin> ls)
            { e.setMemberLoginList(ls); }
            public MemberLoginCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(MemberLoginCB cb, List<Integer> ls)
            { cb.query().setMemberId_InScope(ls); }
            public void qyOdFKAsc(MemberLoginCB cb) { cb.query().addOrderBy_MemberId_Asc(); }
            public void spFKCol(MemberLoginCB cb) { cb.specify().columnMemberId(); }
            public List<MemberLogin> selRfLs(MemberLoginCB cb) { return referrerBhv.selectList(cb); }
            public Integer getFKVal(MemberLogin e) { return e.getMemberId(); }
            public void setlcEt(MemberLogin re, Member le)
            { re.setMember(le); }
            public String getRfPrNm() { return "memberLoginList"; }
        });
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadPurchaseList(Member member, ConditionBeanSetupper<PurchaseCB> conditionBeanSetupper) {
        xassLRArg(member, conditionBeanSetupper);
        loadPurchaseList(xnewLRLs(member), conditionBeanSetupper);
    }
    /**
     * Load referrer of purchaseList with the set-upper for condition-bean of referrer. <br />
     * (購入)PURCHASE by MEMBER_ID, named 'purchaseList'.
     * <pre>
     * memberBhv.<span style="color: #FD4747">loadPurchaseList</span>(memberList, new ConditionBeanSetupper&lt;PurchaseCB&gt;() {
     *     public void setup(PurchaseCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...(); <span style="color: #3F7E5E">// basically you should order referrer list</span>
     *     }
     * });
     * for (Member member : memberList) {
     *     ... = member.<span style="color: #FD4747">getPurchaseList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key(and others too) is treated as case-insensitive. <br />
     * The condition-bean that the set-upper provides have settings before you touch it. It is as follows:
     * <pre>
     * cb.query().setMemberId_InScope(pkList);
     * cb.query().addOrderBy_MemberId_Asc();
     * </pre>
     * @param memberList The entity list of member. (NotNull)
     * @param conditionBeanSetupper The instance of referrer condition-bean set-upper for registering referrer condition. (NotNull)
     */
    public void loadPurchaseList(List<Member> memberList, ConditionBeanSetupper<PurchaseCB> conditionBeanSetupper) {
        xassLRArg(memberList, conditionBeanSetupper);
        loadPurchaseList(memberList, new LoadReferrerOption<PurchaseCB, Purchase>().xinit(conditionBeanSetupper));
    }
    /**
     * {Refer to overload method that has an argument of the list of entity.}
     * @param member The entity of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadPurchaseList(Member member, LoadReferrerOption<PurchaseCB, Purchase> loadReferrerOption) {
        xassLRArg(member, loadReferrerOption);
        loadPurchaseList(xnewLRLs(member), loadReferrerOption);
    }
    /**
     * {Refer to overload method that has an argument of condition-bean setupper.}
     * @param memberList The entity list of member. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     */
    public void loadPurchaseList(List<Member> memberList, LoadReferrerOption<PurchaseCB, Purchase> loadReferrerOption) {
        xassLRArg(memberList, loadReferrerOption);
        if (memberList.isEmpty()) { return; }
        final PurchaseBhv referrerBhv = xgetBSFLR().select(PurchaseBhv.class);
        helpLoadReferrerInternally(memberList, loadReferrerOption, new InternalLoadReferrerCallback<Member, Integer, PurchaseCB, Purchase>() {
            public Integer getPKVal(Member e)
            { return e.getMemberId(); }
            public void setRfLs(Member e, List<Purchase> ls)
            { e.setPurchaseList(ls); }
            public PurchaseCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(PurchaseCB cb, List<Integer> ls)
            { cb.query().setMemberId_InScope(ls); }
            public void qyOdFKAsc(PurchaseCB cb) { cb.query().addOrderBy_MemberId_Asc(); }
            public void spFKCol(PurchaseCB cb) { cb.specify().columnMemberId(); }
            public List<Purchase> selRfLs(PurchaseCB cb) { return referrerBhv.selectList(cb); }
            public Integer getFKVal(Purchase e) { return e.getMemberId(); }
            public void setlcEt(Purchase re, Member le)
            { re.setMember(le); }
            public String getRfPrNm() { return "purchaseList"; }
        });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'MemberStatus'.
     * @param memberList The list of member. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<MemberStatus> pulloutMemberStatus(List<Member> memberList) {
        return helpPulloutInternally(memberList, new InternalPulloutCallback<Member, MemberStatus>() {
            public MemberStatus getFr(Member e) { return e.getMemberStatus(); }
            public boolean hasRf() { return true; }
            public void setRfLs(MemberStatus e, List<Member> ls)
            { e.setMemberList(ls); }
        });
    }
    /**
     * Pull out the list of foreign table 'MemberAddress'.
     * @param memberList The list of member. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<MemberAddress> pulloutMemberAddressAsValid(List<Member> memberList) {
        return helpPulloutInternally(memberList, new InternalPulloutCallback<Member, MemberAddress>() {
            public MemberAddress getFr(Member e) { return e.getMemberAddressAsValid(); }
            public boolean hasRf() { return false; }
            public void setRfLs(MemberAddress e, List<Member> ls)
            { throw new UnsupportedOperationException(); }
        });
    }
    /**
     * Pull out the list of referrer-as-one table 'MemberSecurity'.
     * @param memberList The list of member. (NotNull, EmptyAllowed)
     * @return The list of referrer-as-one table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<MemberSecurity> pulloutMemberSecurityAsOne(List<Member> memberList) {
        return helpPulloutInternally(memberList, new InternalPulloutCallback<Member, MemberSecurity>() {
            public MemberSecurity getFr(Member e) { return e.getMemberSecurityAsOne(); }
            public boolean hasRf() { return true; }
            public void setRfLs(MemberSecurity e, List<Member> ls)
            { if (!ls.isEmpty()) { e.setMember(ls.get(0)); } }
        });
    }
    /**
     * Pull out the list of referrer-as-one table 'MemberService'.
     * @param memberList The list of member. (NotNull, EmptyAllowed)
     * @return The list of referrer-as-one table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<MemberService> pulloutMemberServiceAsOne(List<Member> memberList) {
        return helpPulloutInternally(memberList, new InternalPulloutCallback<Member, MemberService>() {
            public MemberService getFr(Member e) { return e.getMemberServiceAsOne(); }
            public boolean hasRf() { return true; }
            public void setRfLs(MemberService e, List<Member> ls)
            { if (!ls.isEmpty()) { e.setMember(ls.get(0)); } }
        });
    }
    /**
     * Pull out the list of referrer-as-one table 'MemberWithdrawal'.
     * @param memberList The list of member. (NotNull, EmptyAllowed)
     * @return The list of referrer-as-one table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<MemberWithdrawal> pulloutMemberWithdrawalAsOne(List<Member> memberList) {
        return helpPulloutInternally(memberList, new InternalPulloutCallback<Member, MemberWithdrawal>() {
            public MemberWithdrawal getFr(Member e) { return e.getMemberWithdrawalAsOne(); }
            public boolean hasRf() { return true; }
            public void setRfLs(MemberWithdrawal e, List<Member> ls)
            { if (!ls.isEmpty()) { e.setMember(ls.get(0)); } }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberId.
     * @param memberList The list of member. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractMemberIdList(List<Member> memberList) {
        return helpExtractListInternally(memberList, new InternalExtractCallback<Member, Integer>() {
            public Integer getCV(Member e) { return e.getMemberId(); }
        });
    }

    /**
     * Extract the value list of (single) unique key memberAccount.
     * @param memberList The list of member. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractMemberAccountList(List<Member> memberList) {
        return helpExtractListInternally(memberList, new InternalExtractCallback<Member, String>() {
            public String getCV(Member e) { return e.getMemberAccount(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * Member member = new Member();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * member.setFoo...(value);
     * member.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//member.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//member.set...;</span>
     * memberBhv.<span style="color: #FD4747">insert</span>(member);
     * ... = member.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param member The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(Member member) {
        doInsert(member, null);
    }

    protected void doInsert(Member member, InsertOption<MemberCB> option) {
        assertObjectNotNull("member", member);
        prepareInsertOption(option);
        delegateInsert(member, option);
    }

    protected void prepareInsertOption(InsertOption<MemberCB> option) {
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
     * Member member = new Member();
     * member.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * member.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//member.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//member.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * member.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberBhv.<span style="color: #FD4747">update</span>(member);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param member The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final Member member) {
        doUpdate(member, null);
    }

    protected void doUpdate(Member member, final UpdateOption<MemberCB> option) {
        assertObjectNotNull("member", member);
        prepareUpdateOption(option);
        helpUpdateInternally(member, new InternalUpdateCallback<Member>() {
            public int callbackDelegateUpdate(Member entity) { return delegateUpdate(entity, option); } });
    }

    protected void prepareUpdateOption(UpdateOption<MemberCB> option) {
        if (option == null) { return; }
        assertUpdateOptionStatus(option);
        if (option.hasSelfSpecification()) {
            option.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (option.hasSpecifiedUpdateColumn()) {
            option.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected MemberCB createCBForVaryingUpdate() {
        MemberCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected MemberCB createCBForSpecifiedUpdate() {
        MemberCB cb = newMyConditionBean();
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
     * Member member = new Member();
     * member.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * member.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//member.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//member.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//member.setVersionNo(value);</span>
     * memberBhv.<span style="color: #FD4747">updateNonstrict</span>(member);
     * </pre>
     * @param member The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(final Member member) {
        doUpdateNonstrict(member, null);
    }

    protected void doUpdateNonstrict(Member member, final UpdateOption<MemberCB> option) {
        assertObjectNotNull("member", member);
        prepareUpdateOption(option);
        helpUpdateNonstrictInternally(member, new InternalUpdateNonstrictCallback<Member>() {
            public int callbackDelegateUpdateNonstrict(Member entity) { return delegateUpdateNonstrict(entity, option); } });
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
     * @param member The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(Member member) {
        doInesrtOrUpdate(member, null, null);
    }

    protected void doInesrtOrUpdate(Member member, final InsertOption<MemberCB> insertOption, final UpdateOption<MemberCB> updateOption) {
        helpInsertOrUpdateInternally(member, new InternalInsertOrUpdateCallback<Member, MemberCB>() {
            public void callbackInsert(Member entity) { doInsert(entity, insertOption); }
            public void callbackUpdate(Member entity) { doUpdate(entity, updateOption); }
            public MemberCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(MemberCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdate(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<MemberCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<MemberCB>() : updateOption;
            varyingInsertOrUpdate(downcast(entity), downcast(insertOption), downcast(updateOption));
        }
    }

    /**
     * Insert or update the entity non-strictly modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() }
     * <p><span style="color: #FD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param member The entity of insert or update target. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(Member member) {
        doInesrtOrUpdateNonstrict(member, null, null);
    }

    protected void doInesrtOrUpdateNonstrict(Member member, final InsertOption<MemberCB> insertOption, final UpdateOption<MemberCB> updateOption) {
        helpInsertOrUpdateInternally(member, new InternalInsertOrUpdateNonstrictCallback<Member>() {
            public void callbackInsert(Member entity) { doInsert(entity, insertOption); }
            public void callbackUpdateNonstrict(Member entity) { doUpdateNonstrict(entity, updateOption); }
        });
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity entity, InsertOption<? extends ConditionBean> insertOption,
            UpdateOption<? extends ConditionBean> updateOption) {
        if (insertOption == null && updateOption == null) { insertOrUpdateNonstrict(downcast(entity)); }
        else {
            insertOption = insertOption == null ? new InsertOption<MemberCB>() : insertOption;
            updateOption = updateOption == null ? new UpdateOption<MemberCB>() : updateOption;
            varyingInsertOrUpdateNonstrict(downcast(entity), downcast(insertOption), downcast(updateOption));
        }
    }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * Member member = new Member();
     * member.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * member.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     memberBhv.<span style="color: #FD4747">delete</span>(member);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * } 
     * </pre>
     * @param member The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(Member member) {
        doDelete(member, null);
    }

    protected void doDelete(Member member, final DeleteOption<MemberCB> option) {
        assertObjectNotNull("member", member);
        prepareDeleteOption(option);
        helpDeleteInternally(member, new InternalDeleteCallback<Member>() {
            public int callbackDelegateDelete(Member entity) { return delegateDelete(entity, option); } });
    }

    protected void prepareDeleteOption(DeleteOption<MemberCB> option) {
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
     * Member member = new Member();
     * member.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//member.setVersionNo(value);</span>
     * memberBhv.<span style="color: #FD4747">deleteNonstrict</span>(member);
     * </pre>
     * @param member The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(Member member) {
        doDeleteNonstrict(member, null);
    }

    protected void doDeleteNonstrict(Member member, final DeleteOption<MemberCB> option) {
        assertObjectNotNull("member", member);
        prepareDeleteOption(option);
        helpDeleteNonstrictInternally(member, new InternalDeleteNonstrictCallback<Member>() {
            public int callbackDelegateDeleteNonstrict(Member entity) { return delegateDeleteNonstrict(entity, option); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * Member member = new Member();
     * member.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//member.setVersionNo(value);</span>
     * memberBhv.<span style="color: #FD4747">deleteNonstrictIgnoreDeleted</span>(member);
     * <span style="color: #3F7E5E">// if the target entity doesn't exist, no exception</span>
     * </pre>
     * @param member The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(Member member) {
        doDeleteNonstrictIgnoreDeleted(member, null);
    }

    protected void doDeleteNonstrictIgnoreDeleted(Member member, final DeleteOption<MemberCB> option) {
        assertObjectNotNull("member", member);
        prepareDeleteOption(option);
        helpDeleteNonstrictIgnoreDeletedInternally(member, new InternalDeleteNonstrictIgnoreDeletedCallback<Member>() {
            public int callbackDelegateDeleteNonstrict(Member entity) { return delegateDeleteNonstrict(entity, option); } });
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
     *     Member member = new Member();
     *     member.setFooName("foo");
     *     if (...) {
     *         member.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberList.add(member);
     * }
     * memberBhv.<span style="color: #FD4747">batchInsert</span>(memberList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<Member> memberList) {
        InsertOption<MemberCB> option = createInsertUpdateOption();
        return doBatchInsert(memberList, option);
    }

    protected int[] doBatchInsert(List<Member> memberList, InsertOption<MemberCB> option) {
        assertObjectNotNull("memberList", memberList);
        prepareBatchInsertOption(memberList, option);
        return delegateBatchInsert(memberList, option);
    }

    protected void prepareBatchInsertOption(List<Member> memberList, InsertOption<MemberCB> option) {
        option.xallowInsertColumnModifiedPropertiesFragmented();
        option.xacceptInsertColumnModifiedPropertiesIfNeeds(memberList);
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
     *     Member member = new Member();
     *     member.setFooName("foo");
     *     if (...) {
     *         member.setFooPrice(123);
     *     } else {
     *         member.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//member.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberList.add(member);
     * }
     * memberBhv.<span style="color: #FD4747">batchUpdate</span>(memberList);
     * </pre>
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<Member> memberList) {
        UpdateOption<MemberCB> option = createPlainUpdateOption();
        return doBatchUpdate(memberList, option);
    }

    protected int[] doBatchUpdate(List<Member> memberList, UpdateOption<MemberCB> option) {
        assertObjectNotNull("memberList", memberList);
        prepareBatchUpdateOption(memberList, option);
        return delegateBatchUpdate(memberList, option);
    }

    protected void prepareBatchUpdateOption(List<Member> memberList, UpdateOption<MemberCB> option) {
        option.xacceptUpdateColumnModifiedPropertiesIfNeeds(memberList);
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
     * memberBhv.<span style="color: #FD4747">batchUpdate</span>(memberList, new SpecifyQuery<MemberCB>() {
     *     public void specify(MemberCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * memberBhv.<span style="color: #FD4747">batchUpdate</span>(memberList, new SpecifyQuery<MemberCB>() {
     *     public void specify(MemberCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<Member> memberList, SpecifyQuery<MemberCB> updateColumnSpec) {
        return doBatchUpdate(memberList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #FD4747; font-size: 140%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     Member member = new Member();
     *     member.setFooName("foo");
     *     if (...) {
     *         member.setFooPrice(123);
     *     } else {
     *         member.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//member.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberList.add(member);
     * }
     * memberBhv.<span style="color: #FD4747">batchUpdate</span>(memberList);
     * </pre>
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<Member> memberList) {
        UpdateOption<MemberCB> option = createPlainUpdateOption();
        return doBatchUpdateNonstrict(memberList, option);
    }

    protected int[] doBatchUpdateNonstrict(List<Member> memberList, UpdateOption<MemberCB> option) {
        assertObjectNotNull("memberList", memberList);
        prepareBatchUpdateOption(memberList, option);
        return delegateBatchUpdateNonstrict(memberList, option);
    }

    /**
     * Batch-update the entity list non-strictly specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span> 
     * memberBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(memberList, new SpecifyQuery<MemberCB>() {
     *     public void specify(MemberCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #FD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #FD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span> 
     * memberBhv.<span style="color: #FD4747">batchUpdateNonstrict</span>(memberList, new SpecifyQuery<MemberCB>() {
     *     public void specify(MemberCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #FD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).</p>
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<Member> memberList, SpecifyQuery<MemberCB> updateColumnSpec) {
        return doBatchUpdateNonstrict(memberList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return batchUpdateNonstrict(downcast(ls)); }
        else { return varyingBatchUpdateNonstrict(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(List<Member> memberList) {
        return doBatchDelete(memberList, null);
    }

    protected int[] doBatchDelete(List<Member> memberList, DeleteOption<MemberCB> option) {
        assertObjectNotNull("memberList", memberList);
        prepareDeleteOption(option);
        return delegateBatchDelete(memberList, option);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(option)); }
    }

    /**
     * Batch-delete the entity list non-strictly. {NonExclusiveControl} <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(List<Member> memberList) {
        return doBatchDeleteNonstrict(memberList, null);
    }

    protected int[] doBatchDeleteNonstrict(List<Member> memberList, DeleteOption<MemberCB> option) {
        assertObjectNotNull("memberList", memberList);
        prepareDeleteOption(option);
        return delegateBatchDeleteNonstrict(memberList, option);
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
     * memberBhv.<span style="color: #FD4747">queryInsert</span>(new QueryInsertSetupper&lt;Member, MemberCB&gt;() {
     *     public ConditionBean setup(member entity, MemberCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<Member, MemberCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<Member, MemberCB> setupper, InsertOption<MemberCB> option) {
        assertObjectNotNull("setupper", setupper);
        prepareInsertOption(option);
        Member entity = new Member();
        MemberCB intoCB = createCBForQueryInsert();
        ConditionBean resourceCB = setupper.setup(entity, intoCB);
        return delegateQueryInsert(entity, intoCB, resourceCB, option);
    }

    protected MemberCB createCBForQueryInsert() {
        MemberCB cb = newMyConditionBean();
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
     * Member member = new Member();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//member.setPK...(value);</span>
     * member.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//member.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//member.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//member.setVersionNo(value);</span>
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * memberBhv.<span style="color: #FD4747">queryUpdate</span>(member, cb);
     * </pre>
     * @param member The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of Member. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(Member member, MemberCB cb) {
        return doQueryUpdate(member, cb, null);
    }

    protected int doQueryUpdate(Member member, MemberCB cb, UpdateOption<MemberCB> option) {
        assertObjectNotNull("member", member); assertCBStateValid(cb);
        prepareUpdateOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(member, cb, option) : 0;
    }

    @Override
    protected int doRangeModify(Entity entity, ConditionBean cb, UpdateOption<? extends ConditionBean> option) {
        if (option == null) { return queryUpdate(downcast(entity), (MemberCB)cb); }
        else { return varyingQueryUpdate(downcast(entity), (MemberCB)cb, downcast(option)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * memberBhv.<span style="color: #FD4747">queryDelete</span>(member, cb);
     * </pre>
     * @param cb The condition-bean of Member. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberCB cb, DeleteOption<MemberCB> option) {
        assertCBStateValid(cb);
        prepareDeleteOption(option);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, option) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> option) {
        if (option == null) { return queryDelete((MemberCB)cb); }
        else { return varyingQueryDelete((MemberCB)cb, downcast(option)); }
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
     * Member member = new Member();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * member.setFoo...(value);
     * member.setBar...(value);
     * InsertOption<MemberCB> option = new InsertOption<MemberCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberBhv.<span style="color: #FD4747">varyingInsert</span>(member, option);
     * ... = member.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param member The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(Member member, InsertOption<MemberCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(member, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, ExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * Member member = new Member();
     * member.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * member.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * member.<span style="color: #FD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberCB&gt; option = new UpdateOption&lt;MemberCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberCB&gt;() {
     *         public void specify(MemberCB cb) {
     *             cb.specify().<span style="color: #FD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberBhv.<span style="color: #FD4747">varyingUpdate</span>(member, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param member The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(Member member, UpdateOption<MemberCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(member, option);
    }

    /**
     * Update the entity with varying requests non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as updateNonstrict(entity).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * Member member = new Member();
     * member.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * member.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//member.setVersionNo(value);</span>
     * UpdateOption&lt;MemberCB&gt; option = new UpdateOption&lt;MemberCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberCB&gt;() {
     *     public void specify(MemberCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberBhv.<span style="color: #FD4747">varyingUpdateNonstrict</span>(member, option);
     * </pre>
     * @param member The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(Member member, UpdateOption<MemberCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(member, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param member The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(Member member, InsertOption<MemberCB> insertOption, UpdateOption<MemberCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(member, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param member The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     * @exception org.seasar.dbflute.exception.EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(Member member, InsertOption<MemberCB> insertOption, UpdateOption<MemberCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdateNonstrict(member, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param member The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(Member member, DeleteOption<MemberCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(member, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param member The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception org.seasar.dbflute.exception.EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception org.seasar.dbflute.exception.EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDeleteNonstrict(Member member, DeleteOption<MemberCB> option) {
        assertDeleteOptionNotNull(option);
        doDeleteNonstrict(member, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<Member> memberList, InsertOption<MemberCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<Member> memberList, UpdateOption<MemberCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberList, option);
    }

    /**
     * Batch-update the list with varying requests non-strictly. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdateNonstrict(List<Member> memberList, UpdateOption<MemberCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdateNonstrict(memberList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<Member> memberList, DeleteOption<MemberCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberList, option);
    }

    /**
     * Batch-delete the list with varying requests non-strictly. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDeleteNonstrict(entityList).
     * @param memberList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDeleteNonstrict(List<Member> memberList, DeleteOption<MemberCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDeleteNonstrict(memberList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<Member, MemberCB> setupper, InsertOption<MemberCB> option) {
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
     * Member member = new Member();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//member.setPK...(value);</span>
     * member.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//member.setVersionNo(value);</span>
     * MemberCB cb = new MemberCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberCB&gt; option = new UpdateOption&lt;MemberCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberCB&gt;() {
     *     public void specify(MemberCB cb) {
     *         cb.specify().<span style="color: #FD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberBhv.<span style="color: #FD4747">varyingQueryUpdate</span>(member, cb, option);
     * </pre>
     * @param member The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of Member. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(Member member, MemberCB cb, UpdateOption<MemberCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(member, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of Member. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberCB cb, DeleteOption<MemberCB> option) {
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
    public OutsideSqlBasicExecutor<MemberBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(MemberCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(MemberCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends Member> void delegateSelectCursor(MemberCB cb, EntityRowHandler<ENTITY> erh, Class<ENTITY> et)
    { invoke(createSelectCursorCBCommand(cb, erh, et)); }
    protected <ENTITY extends Member> List<ENTITY> delegateSelectList(MemberCB cb, Class<ENTITY> et)
    { return invoke(createSelectListCBCommand(cb, et)); }
    protected <RESULT> RESULT delegateSelectNextVal(Class<RESULT> rt) { return invoke(createSelectNextValCommand(rt)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(Member e, InsertOption<MemberCB> op)
    { if (!processBeforeInsert(e, op)) { return 0; }
      return invoke(createInsertEntityCommand(e, op)); }
    protected int delegateUpdate(Member e, UpdateOption<MemberCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateEntityCommand(e, op)); }
    protected int delegateUpdateNonstrict(Member e, UpdateOption<MemberCB> op)
    { if (!processBeforeUpdate(e, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(e, op)); }
    protected int delegateDelete(Member e, DeleteOption<MemberCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteEntityCommand(e, op)); }
    protected int delegateDeleteNonstrict(Member e, DeleteOption<MemberCB> op)
    { if (!processBeforeDelete(e, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(e, op)); }

    protected int[] delegateBatchInsert(List<Member> ls, InsertOption<MemberCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<Member> ls, UpdateOption<MemberCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchUpdateNonstrict(List<Member> ls, UpdateOption<MemberCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<Member> ls, DeleteOption<MemberCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchDeleteNonstrict(List<Member> ls, DeleteOption<MemberCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(Member e, MemberCB inCB, ConditionBean resCB, InsertOption<MemberCB> op)
    { if (!processBeforeQueryInsert(e, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(e, inCB, resCB, op));  }
    protected int delegateQueryUpdate(Member e, MemberCB cb, UpdateOption<MemberCB> op)
    { if (!processBeforeQueryUpdate(e, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(e, cb, op));  }
    protected int delegateQueryDelete(MemberCB cb, DeleteOption<MemberCB> op)
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
    protected Member downcast(Entity entity) {
        return helpEntityDowncastInternally(entity, Member.class);
    }

    protected MemberCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, MemberCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<Member> downcast(List<? extends Entity> entityList) {
        return (List<Member>)entityList;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<MemberCB> downcast(InsertOption<? extends ConditionBean> option) {
        return (InsertOption<MemberCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberCB> downcast(UpdateOption<? extends ConditionBean> option) {
        return (UpdateOption<MemberCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberCB> downcast(DeleteOption<? extends ConditionBean> option) {
        return (DeleteOption<MemberCB>)option;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<Member, MemberCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> option) {
        return (QueryInsertSetupper<Member, MemberCB>)option;
    }
}
