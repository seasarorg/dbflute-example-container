package com.example.dbflute.basic.dbflute.howto;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.bhv.EntityListSetupper;
import org.seasar.dbflute.bhv.LoadReferrerOption;
import org.seasar.dbflute.cbean.EntityRowHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.grouping.GroupingOption;
import org.seasar.dbflute.cbean.grouping.GroupingRowEndDeterminer;
import org.seasar.dbflute.cbean.grouping.GroupingRowResource;
import org.seasar.dbflute.cbean.grouping.GroupingRowSetupper;
import org.seasar.dbflute.cbean.pagenavi.group.PageGroupOption;
import org.seasar.dbflute.cbean.pagenavi.range.PageRangeOption;
import org.seasar.dbflute.helper.HandyDate;
import org.seasar.dbflute.helper.token.file.FileToken;
import org.seasar.dbflute.helper.token.file.FileTokenizingCallback;
import org.seasar.dbflute.helper.token.file.FileTokenizingOption;
import org.seasar.dbflute.helper.token.file.FileTokenizingRowResource;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.util.DfResourceUtil;

import com.example.dbflute.basic.dbflute.cbean.MemberCB;
import com.example.dbflute.basic.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.basic.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.basic.dbflute.cbean.PurchaseCB;
import com.example.dbflute.basic.dbflute.exbhv.MemberBhv;
import com.example.dbflute.basic.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.basic.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.basic.dbflute.exbhv.cursor.PurchaseSummaryMemberCursor;
import com.example.dbflute.basic.dbflute.exbhv.cursor.PurchaseSummaryMemberCursorHandler;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.PurchaseMaxPriceMemberPmb;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.PurchaseSummaryMemberPmb;
import com.example.dbflute.basic.dbflute.exentity.Member;
import com.example.dbflute.basic.dbflute.exentity.MemberLogin;
import com.example.dbflute.basic.dbflute.exentity.MemberStatus;
import com.example.dbflute.basic.dbflute.exentity.Product;
import com.example.dbflute.basic.dbflute.exentity.Purchase;
import com.example.dbflute.basic.dbflute.exentity.customize.PurchaseMaxPriceMember;
import com.example.dbflute.basic.unit.UnitContainerTestCase;

/**
 * Behaviorの上級編Example実装。
 * <pre>
 * ターゲットは以下の通り：
 *   o DBFluteをとことん極めたい方
 *   o 開発中で難しい要求が出てきて実現方法がわからなくて困っている方
 * 
 * コンテンツは以下の通り：
 *   o ページング検索のページングナビゲーション要素: selectPage(), pageRange(), pageGroup().
 *   o ConditionBeanでカーソル検索(大量件数対策): selectCursor().
 *   o one-to-many-to-one, 子テーブルの親テーブルの取得: loadXxxList().
 *   o one-to-many-to-many, 子テーブルの子テーブル(孫テーブル)の取得: loadXxxList().
 *   o many-to-one-to-many, 親テーブルの子テーブル(兄弟テーブル)の取得: pulloutXxx(), loadXxxList().
 *   o バッチ登録: batchInsert().
 *   o 排他制御ありバッチ更新: batchUpdate().
 *   o 排他制御なしバッチ更新: batchUpdateNonstrict().
 *   o 排他制御ありバッチ削除: batchDelete().
 *   o 排他制御なしバッチ削除: batchDeleteNonstrict().
 *   o 外だしSQLでカーソル検索(大量件数対策): outsideSql().cursorHandling().selectCursor().
 *   o 外だしSQLでFORコメントを使った検索(where句の先頭、and連結): FOR pmb.xxxList, NEXT.
 *   o 外だしSQLでFORコメントを使った検索(二番目以降、or連結): FOR pmb.xxxList. FIRST, NEXT, LAST.
 *   o Entityリストの件数ごとのグルーピング: ListResultBean.groupingList().
 *   o Entityリストのグルーピング(コントロールブレイク): ListResultBean.groupingList(), determine().
 * </pre>
 * @author jflute
 * @since 0.7.3 (2008/05/31 Saturday)
 */
public class BehaviorPlatinumTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberStatusBhv memberStatusBhv;

    @Resource
    protected PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                Paging (Page Select)
    //                                                                ====================
    /**
     * o ページング検索のページングナビゲーション要素: selectPage(), pageRange(), pageGroup(). <br /> 
     * 会員名称の昇順のリストを「１ページ４件」の「２ページ目」と「３ページ目」を検索。
     * <pre>
     * もし総ページ数が膨大な場合に、画面にて全てのページ番号のLinkを表示するのはあまり格好良くない。
     * 
     * [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29...]
     * 
     * その場合に「ある限られたページ番号のみ」を表示するためにDBFluteが幾つかの手法を提供している。
     * 
     * {PageRange}
     * 前後nページだけを表示する。
     *   e.g. 総ページ数が「22」の場合で、前後「5」ページを表示
     *     [4]Page目を選択  - [1 2 3 '4' 5 6 7 8 9 次へ]
     *     [13]Page目を選択 - [前へ 8 9 10 11 12 '13' 14 15 16 17 18 次へ]
     *     [21]Page目を選択 - [前へ 16 17 18 19 20 '21' 22]
     * 
     * {PageRange-fillLimit}
     * 前後nページだけを表示するが、固定数表示とする。
     * 端の方のページが選択されている場合で表示していないページ数の分、反対側のページを表示する。
     * デザインが崩れにくいという特徴あり。
     *   e.g. 総ページ数が「22」の場合で、前後「5」ページを表示で固定数表示
     *     [4]Page目を選択  - [1 2 3 '4' 5 6 7 8 9 10 11 次へ]
     *     [13]Page目を選択 - [前へ 8 9 10 11 12 '13' 14 15 16 17 18 次へ]
     *     [21]Page目を選択 - [前へ 12 13 14 15 16 17 18 19 20 '21' 22]
     * 
     * {PageGroup}
     * まとまったページ数で一つグループとみなして表示する。
     * そのグループ内のどのページが選択されても表示は変わらない。
     *   e.g. 総ページ数が「22」の場合で、「10」ページで一つのグループ
     *     [4]Page目を選択  - [1 2 3 '4' 5 6 7 8 9 10 11 次へ]
     *     [13]Page目を選択 - [前へ 11 12 '13' 14 15 16 17 18 19 20 次へ]
     *     [21]Page目を選択 - [前へ '21' 22]
     * </pre>
     */
    public void test_selectPage_PageRange_PageGroup() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();

        // ## Act ##
        cb.paging(4, 2);
        PagingResultBean<Member> page2 = memberBhv.selectPage(cb);
        cb.paging(4, 3);
        PagingResultBean<Member> page3 = memberBhv.selectPage(cb);

        // ## Assert ##
        assertNotSame(0, page3.size());

        log("{PageRange}");
        {
            PageRangeOption pageRangeOption = new PageRangeOption();
            pageRangeOption.setPageRangeSize(2);
            page2.setPageRangeOption(pageRangeOption);
            {
                boolean existsPre = page2.pageRange().isExistPrePageRange();
                boolean existsNext = page2.pageRange().isExistNextPageRange();
                log("  page2: " + existsPre + " " + page2.pageRange().createPageNumberList() + " " + existsNext);
            }
            page3.setPageRangeOption(pageRangeOption);
            {
                boolean existsPre = page3.pageRange().isExistPrePageRange();
                boolean existsNext = page3.pageRange().isExistNextPageRange();
                log("  page3: " + existsPre + " " + page3.pageRange().createPageNumberList() + " " + existsNext);
            }
            log("PagingResultBean.toString():" + ln() + " " + page2 + ln() + " " + page3);
            log("");
        }
        log("{PageRange-fillLimit}");
        {
            PageRangeOption pageRangeOption = new PageRangeOption();
            pageRangeOption.setPageRangeSize(2);
            pageRangeOption.setFillLimit(true);
            page2.setPageRangeOption(pageRangeOption);
            {
                boolean existsPre = page2.pageRange().isExistPrePageRange();
                boolean existsNext = page2.pageRange().isExistNextPageRange();
                log("  page2: " + existsPre + " " + page2.pageRange().createPageNumberList() + " " + existsNext);
            }
            page3.setPageRangeOption(pageRangeOption);
            {
                boolean existsPre = page3.pageRange().isExistPrePageRange();
                boolean existsNext = page3.pageRange().isExistNextPageRange();
                log("  page3: " + existsPre + " " + page3.pageRange().createPageNumberList() + " " + existsNext);
            }
            log("PagingResultBean.toString():" + ln() + " " + page2 + ln() + " " + page3);
            log("");
        }
        log("{PageGroup}");
        {
            PageGroupOption pageGroupOption = new PageGroupOption();
            pageGroupOption.setPageGroupSize(2);
            page2.setPageGroupOption(pageGroupOption);
            {
                boolean existsPre = page2.pageGroup().isExistPrePageGroup();
                boolean existsNext = page2.pageGroup().isExistNextPageGroup();
                log("  page2: " + existsPre + " " + page2.pageGroup().createPageNumberList() + " " + existsNext);
            }
            page3.setPageGroupOption(pageGroupOption);
            {
                boolean existsPre = page3.pageGroup().isExistPrePageGroup();
                boolean existsNext = page3.pageGroup().isExistNextPageGroup();
                log("  page3: " + existsPre + " " + page3.pageGroup().createPageNumberList() + " " + existsNext);
            }
            log("PagingResultBean.toString():" + ln() + " " + page2 + ln() + " " + page3);
            log("");
        }

        // 【補足】
        // A. 必ずsetPageRangeOption()でOptionを設定してからpageRange()を呼び出すこと
        //  -> 設定する前にpageRange()を呼び出すと例外発生 (PageGroupも同じ)
        // 
        // B. PageRangeとPageGroupは独立した機能である
        //  -> Rangeを使っているときに間違ってGroupのメソッドを呼び出したりしないように注意
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * o ConditionBeanでカーソル検索(大量件数対策): selectCursor(). <br />
     * 大量件数を扱うときのメモリ節約のためのConditionBeanを使った検索。
     */
    public void test_selectCursor_EntityRowHandler() {
        // ## Arrange ##
        int allCount = memberBhv.selectCount(new MemberCB());
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        final Set<Integer> memberIdSet = new HashSet<Integer>();

        // ## Act ##
        memberBhv.selectCursor(cb, new EntityRowHandler<Member>() {
            public void handle(Member entity) {
                memberIdSet.add(entity.getMemberId());
                log(entity.getMemberName() + ", " + entity.getMemberStatus().getMemberStatusName());
            }
        });

        // ## Assert ##
        assertEquals(allCount, memberIdSet.size());
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * o one-to-many-to-one, 子テーブルの親テーブルの取得: loadXxxList(). <br />
     * 検索した会員リストに対して、会員毎の購入リストを購入カウントの降順でロード。
     * その時、購入から辿って商品(子テーブルの親テーブル)も取得。
     */
    public void test_LoadReferrer_setupSelect_Foreign() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
                cb.setupSelect_Product();
                cb.query().addOrderBy_PurchaseCount_Desc();
            }
        });

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            List<Purchase> purchaseList = member.getPurchaseList();
            log("[MEMBER]: " + member.getMemberName());
            for (Purchase purchase : purchaseList) {
                Long purchaseId = purchase.getPurchaseId();
                Product product = purchase.getProduct();// *Point!
                log("    [PURCHASE]: purchaseId=" + purchaseId + ", product=" + product);
                assertNotNull(product);
            }
        }
    }

    /**
     * o one-to-many-to-many, 子テーブルの子テーブル(孫テーブル)の取得: loadXxxList(). <br />
     * 三階層にわたるため、ここでは "会員ステータス" を基点テーブルとしている。
     */
    public void test_LoadReferrer_loadReferrerReferrer() {
        // ## Arrange ##
        MemberStatusCB cb = new MemberStatusCB();
        ListResultBean<MemberStatus> statusList = memberStatusBhv.selectList(cb);

        LoadReferrerOption<MemberCB, Member> loadReferrerOption = new LoadReferrerOption<MemberCB, Member>();
        loadReferrerOption.setConditionBeanSetupper(new ConditionBeanSetupper<MemberCB>() {
            public void setup(MemberCB cb) { // MEMBER
                cb.query().addOrderBy_FormalizedDatetime_Desc();
            }
        });
        loadReferrerOption.setEntityListSetupper(new EntityListSetupper<Member>() {
            public void setup(List<Member> entityList) {
                memberBhv.loadPurchaseList(entityList, new ConditionBeanSetupper<PurchaseCB>() {
                    public void setup(PurchaseCB cb) { // PURCHASE
                        cb.query().addOrderBy_PurchaseCount_Desc();
                        cb.query().addOrderBy_ProductId_Desc();
                    }
                });
            }
        });

        // ## Act ##
        memberStatusBhv.loadMemberList(statusList, loadReferrerOption);

        // ## Assert ##
        boolean existsPurchase = false;
        assertNotSame(0, statusList.size());
        for (MemberStatus memberStatus : statusList) {
            List<Member> memberList = memberStatus.getMemberList();
            log("[MEMBER_STATUS]: " + memberStatus.getMemberStatusName());
            for (Member member : memberList) {
                List<Purchase> purchaseList = member.getPurchaseList();
                log("  [MEMBER]: " + member.getMemberName() + ", " + member.getFormalizedDatetime());
                for (Purchase purchase : purchaseList) {
                    log("    [PURCHASE]: " + purchase.getPurchaseId() + ", " + purchase.getPurchaseCount());
                    existsPurchase = true;
                }
            }
            log("");
        }
        assertTrue(existsPurchase);
    }

    /**
     * o many-to-one-to-many, 親テーブルの子テーブル(兄弟テーブル)の取得: pulloutXxx(), loadXxxList(). <br />
     * 三階層にわたるため、ここでは "購入" を基点テーブルとしている。<br />
     * 購入の親テーブル "会員" の子テーブル "会員ログイン" を取得する。<br />
     * 会員ログインはモバイルフラグがtrueで絞り込んで、ログイン日時の降順で並べる。
     */
    public void test_LoadReferrer_pulloutMember_loadMemberLoginList() {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Member();
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Act ##
        List<Member> memberList = purchaseBhv.pulloutMember(purchaseList);// *Point!
        memberBhv.loadMemberLoginList(memberList, new ConditionBeanSetupper<MemberLoginCB>() {
            public void setup(MemberLoginCB cb) {
                cb.query().setMobileLoginFlg_Equal_True();
                cb.query().addOrderBy_LoginDatetime_Desc();
            }
        });

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        boolean existsMemberLogin = false;
        log("");
        for (Purchase purchase : purchaseList) {
            Member member = purchase.getMember();
            log("[PURCHASE & MEMBER]: " + purchase.getPurchaseId() + ", " + member.getMemberName());
            List<MemberLogin> memberLoginList = member.getMemberLoginList();
            for (MemberLogin memberLogin : memberLoginList) {
                log("    [MEMBER_LOGIN]: " + memberLogin);
                existsMemberLogin = true;
            }
        }
        assertTrue(existsMemberLogin);

        log("");
        boolean existsPurchase = false;
        for (Member member : memberList) {
            List<Purchase> backToPurchaseList = member.getPurchaseList();
            if (!backToPurchaseList.isEmpty()) {
                existsPurchase = true;
            }
            log("[MEMBER]: " + member.getMemberName());
            for (Purchase backToPurchase : backToPurchaseList) {
                log("    " + backToPurchase);
            }
        }
        assertTrue(existsPurchase);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * o バッチ登録: batchInsert().
     */
    public void test_batchInsert() {
        // ## Arrange ##
        List<Member> memberList = new ArrayList<Member>();
        {
            Member member = new Member();
            member.setMemberName("testName1");
            member.setMemberAccount("testAccount1");
            member.setMemberStatusCode_正式会員();
            memberList.add(member);
        }
        {
            Member member = new Member();
            member.setMemberName("testName2");
            member.setMemberAccount("testAccount2");
            member.setMemberStatusCode_仮会員();
            memberList.add(member);
        }
        {
            Member member = new Member();
            member.setMemberName("testName3");
            member.setMemberAccount("testAccount3");
            member.setMemberStatusCode_退会会員();
            memberList.add(member);
        }

        // ## Act ##
        int[] result = memberBhv.batchInsert(memberList);

        // ## Assert ##
        assertEquals(3, result.length);
        for (Member member : memberList) {
            assertNull(member.getMemberId());
        }

        // 【補足】
        // A. PreparedStatement.executeBatch()を利用
        //  -> 大量件数に向いている
        //  -> ただし、SQLが固定のため全カラム列挙となり、デフォルト制約は利用不可
    }

    /**
     * o 排他制御ありバッチ更新: batchUpdate().
     */
    public void test_batchUpdate() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        List<Integer> memberIdList = newArrayList(1, 3, 7);
        cb.query().setMemberId_InScope(memberIdList);
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        int count = 0;
        for (Member member : memberList) {
            member.setMemberStatusCode_仮会員();
            member.setFormalizedDatetime(currentTimestamp());
            member.setBirthdate(currentTimestamp());
            ++count;
        }

        // ## Act ##
        int[] result = memberBhv.batchUpdate(memberList, new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberStatusCode();
                cb.specify().columnFormalizedDatetime();
                cb.specify().columnBirthdate();
            }
        });

        // ## Assert ##
        assertEquals(count, result.length);

        // 【補足】
        // A. PreparedStatement.executeBatch()を利用
        //  -> 大量件数に向いている
        //
        // B. 全てのレコードにおいて、SQL (update文) は固定となる
        //  -> 一件更新のときのようなsetterが呼ばれたものだけ更新にはならない
        //  -> 更新カラムを明示的に指定するか、もしくは、第二引数省略で全カラム更新
    }

    /**
     * o 排他制御なしバッチ更新: batchUpdateNonstrict().
     */
    public void test_batchUpdateNonstrict() {
        // ## Arrange ##
        List<Integer> memberIdList = newArrayList(1, 3, 7);
        List<Member> memberList = new ArrayList<Member>();
        int count = 0;
        for (Integer memberId : memberIdList) {
            Member member = new Member();
            member.setMemberId(memberId);
            member.setMemberStatusCode_仮会員();
            member.setFormalizedDatetime(currentTimestamp());
            member.setBirthdate(currentTimestamp());
            member.setVersionNo(null);
            memberList.add(member);
            ++count;
        }

        // ## Act ##
        int[] result = memberBhv.batchUpdateNonstrict(memberList, new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberStatusCode();
                cb.specify().columnFormalizedDatetime();
                cb.specify().columnBirthdate();
            }
        });

        // ## Assert ##
        assertEquals(count, result.length);
        for (Member member : memberList) {
            assertNull(member.getVersionNo());
        }

        // 【補足】
        // A. PreparedStatement.executeBatch()を利用
        //  -> 大量件数に向いている
        //
        // B. 全てのレコードにおいて、SQL (update文) は固定となる
        //  -> 一件更新のときのようなsetterが呼ばれたものだけ更新にはならない
        //  -> 更新カラムを明示的に指定するか、もしくは、第二引数省略で全カラム更新
    }

    /**
     * o 排他制御ありバッチ削除: batchDelete().
     */
    public void test_batchDelete() {
        // ## Arrange ##
        deleteMemberReferrer();

        List<Integer> memberIdList = new ArrayList<Integer>();
        memberIdList.add(1);
        memberIdList.add(3);
        memberIdList.add(7);
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_InScope(memberIdList);
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        int[] result = memberBhv.batchDelete(memberList);

        // ## Assert ##
        assertEquals(3, result.length);

        // 【補足】
        // A. PreparedStatement.executeBatch()を利用
        //  -> 大量件数に向いている
    }

    /**
     * o 排他制御なしバッチ削除: batchDeleteNonstrict().
     */
    public void test_batchDeleteNonstrict() {
        // ## Arrange ##
        deleteMemberReferrer();

        List<Member> memberList = new ArrayList<Member>();
        {
            Member member = new Member();
            member.setMemberId(1);
            memberList.add(member);
        }
        {
            Member member = new Member();
            member.setMemberId(3);
            memberList.add(member);
        }
        {
            Member member = new Member();
            member.setMemberId(7);
            memberList.add(member);
        }

        // ## Act ##
        int[] result = memberBhv.batchDeleteNonstrict(memberList);

        // ## Assert ##
        assertEquals(3, result.length);

        // 【補足】
        // A. PreparedStatement.executeBatch()を利用
        //  -> 大量件数に向いている
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    // /- - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 基本的な外だしSQL: BehaviorBasicTest
    // 中級的な外だしSQL: BehaviorMiddleTest
    // - - - - - - - - - -/

    // -----------------------------------------------------
    //                                                Cursor
    //                                                ------
    /**
     * o 外だしSQLでカーソル検索(大量件数対策): outsideSql().cursorHandling().selectCursor().
     */
    public void test_outsideSql_selectCursor_makeCsvSummaryMember_selectPurchaseSummaryMember() {
        // ## Arrange ##
        PurchaseSummaryMemberPmb pmb = new PurchaseSummaryMemberPmb();
        pmb.setMemberStatusCode_正式会員();
        pmb.setFormalizedDatetime(new HandyDate("2003-08-12 12:34:56.147").getTimestamp());

        // ## Act ##
        memberBhv.outsideSql().cursorHandling().selectCursor(pmb, new PurchaseSummaryMemberCursorHandler() {
            protected Object fetchCursor(PurchaseSummaryMemberCursor cursor) throws SQLException {
                while (cursor.next()) {
                    Integer memberId = cursor.getMemberId();
                    String memberName = cursor.getMemberName();
                    Date birthdate = cursor.getBirthdate();
                    Timestamp formalizedDatetime = cursor.getFormalizedDatetime();
                    Long purchaseSummary = cursor.getPurchaseSummary();

                    // ## Assert ##
                    // *logging only here because of example
                    String c = ", ";
                    StringBuilder sb = new StringBuilder();
                    sb.append(memberId).append(c).append(memberName).append(c);
                    sb.append(birthdate).append(c).append(formalizedDatetime).append(c);
                    sb.append(purchaseSummary);
                    log(sb.toString());
                }
                return null;
            }
        });
    }

    // -----------------------------------------------------
    //                                           FOR Comment
    //                                           -----------
    /**
     * o 外だしSQLでFORコメントを使った検索(where句の先頭、and連結): FOR pmb.xxxList, NEXT. <br />
     * 実処理は、処理の再利用の例として Behavior の "Exクラス" にて実装している。<br />
     * {@link MemberBhv#makeCsvPurchaseSummaryMember()}
     * @throws IOException 
     */
    public void test_outsideSql_forComment_nextAnd() throws IOException {
        // ## Arrange ##
        PurchaseSummaryMemberPmb pmb = new PurchaseSummaryMemberPmb();
        pmb.setMemberNameList_ContainSearch(DfCollectionUtil.newArrayList("S", "v"));

        File buildDir = DfResourceUtil.getBuildDir(getClass());
        String csvPath = buildDir.getCanonicalPath() + "/../test_outsideSql_forComment_nextAnd.csv";

        // ## Act ##
        memberBhv.makeCsvPurchaseSummaryMember(pmb, csvPath);

        // ## Assert ##
        final Set<String> markSet = new HashSet<String>();
        FileToken fileToken = new FileToken();
        fileToken.tokenize(csvPath, new FileTokenizingCallback() {
            public void handleRow(FileTokenizingRowResource resource) {
                log(resource.getRowNumber() + ": " + resource.getValueList());
                markSet.add("exists");
            }
        }, new FileTokenizingOption().delimitateByComma().encodeAsUTF8());
        assertTrue(markSet.contains("exists"));
    }

    /**
     * o 外だしSQLでFORコメントを使った検索(二番目以降、or連結): FOR pmb.xxxList. FIRST, NEXT, LAST.
     */
    public void test_outsideSql_forComment_nextOr() {
        // ## Arrange ##
        PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();
        pmb.setMemberNameList_PrefixSearch(DfCollectionUtil.newArrayList("S", "M"));
        pmb.paging(3, 1);

        // ## Act ##
        PagingResultBean<PurchaseMaxPriceMember> page1 = memberBhv.outsideSql().manualPaging().selectPage(pmb);

        // ## Assert ##
        assertHasAnyElement(page1);
        for (PurchaseMaxPriceMember member : page1) {
            log(member);
            String memberName = member.getMemberName();

            if (!memberName.startsWith("S") && !memberName.startsWith("M")) {
                fail("memberName should start with S or M: " + memberName);
            }
        }
    }

    // ===================================================================================
    //                                                                      ListResultBean
    //                                                                      ==============
    /**
     * o Entityリストの件数ごとのグルーピング: ListResultBean.groupingList(). <br />
     * 会員リストを３件ずつのグループリストにする。
     */
    public void test_ListResultBean_groupingList_count() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        GroupingOption<Member> groupingOption = new GroupingOption<Member>(3);
        List<List<Member>> groupingList = memberList.groupingList(new GroupingRowSetupper<List<Member>, Member>() {
            public List<Member> setup(GroupingRowResource<Member> groupingRowResource) {
                return new ArrayList<Member>(groupingRowResource.getGroupingRowList());
            }
        }, groupingOption);

        // ## Assert ##
        assertHasAnyElement(groupingList);
        int rowIndex = 0;
        for (List<Member> elementList : groupingList) {
            assertTrue(elementList.size() <= 3);
            log("[" + rowIndex + "]");
            for (Member member : elementList) {
                log("  " + member);
            }
            ++rowIndex;
        }
    }

    /**
     * Entityリストのグルーピング(コントロールブレイク): ListResultBean.groupingList(), determine(). <br />
     * 会員リストを会員名称の先頭文字ごとのグループリストにする。
     */
    public void test_ListResultBean_groupingList_determine() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        GroupingOption<Member> groupingOption = new GroupingOption<Member>(); // breakCount is unnecessary in this case
        groupingOption.setGroupingRowEndDeterminer(new GroupingRowEndDeterminer<Member>() {
            public boolean determine(GroupingRowResource<Member> rowResource, Member nextEntity) {
                Member currentEntity = rowResource.getCurrentEntity();
                String currentInitChar = currentEntity.getMemberName().substring(0, 1);
                String nextInitChar = nextEntity.getMemberName().substring(0, 1);
                return !currentInitChar.equalsIgnoreCase(nextInitChar);
            }
        });
        List<List<Member>> groupingList = memberList.groupingList(new GroupingRowSetupper<List<Member>, Member>() {
            public List<Member> setup(GroupingRowResource<Member> groupingRowResource) {
                return new ArrayList<Member>(groupingRowResource.getGroupingRowList());
            }
        }, groupingOption);

        // ## Assert ##
        assertHasAnyElement(groupingList);
        int entityCount = 0;
        for (List<Member> elementList : groupingList) {
            String currentInitChar = null;
            for (Member member : elementList) {
                if (currentInitChar == null) {
                    currentInitChar = member.getMemberName().substring(0, 1);
                    log("[" + currentInitChar + "]");
                }
                log("  " + member.getMemberName() + ", " + member);
                assertEquals(currentInitChar, member.getMemberName().substring(0, 1));
                ++entityCount;
            }
        }
        assertEquals(memberList.size(), entityCount);
    }
}
