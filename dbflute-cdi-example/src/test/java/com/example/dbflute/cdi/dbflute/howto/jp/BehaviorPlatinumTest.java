package com.example.dbflute.cdi.dbflute.howto.jp;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.bhv.EntityListSetupper;
import org.seasar.dbflute.bhv.LoadReferrerOption;
import org.seasar.dbflute.cbean.EntityRowHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.grouping.GroupingOption;
import org.seasar.dbflute.cbean.grouping.GroupingRowEndDeterminer;
import org.seasar.dbflute.cbean.grouping.GroupingRowResource;
import org.seasar.dbflute.cbean.grouping.GroupingRowSetupper;
import org.seasar.dbflute.cbean.pagenavi.group.PageGroupOption;
import org.seasar.dbflute.cbean.pagenavi.range.PageRangeOption;
import org.seasar.dbflute.exception.OutsideSqlNotFoundException;
import org.seasar.dbflute.jdbc.StatementConfig;
import org.seasar.dbflute.twowaysql.exception.BindVariableCommentNotFoundPropertyException;
import org.seasar.dbflute.twowaysql.exception.EndCommentNotFoundException;
import org.seasar.dbflute.twowaysql.exception.IfCommentNotBooleanResultException;
import org.seasar.dbflute.twowaysql.exception.IfCommentWrongExpressionException;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.allcommon.CDef;
import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.cdi.dbflute.cbean.PurchaseCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.cdi.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.cdi.dbflute.exbhv.cursor.PurchaseSummaryMemberCursor;
import com.example.dbflute.cdi.dbflute.exbhv.cursor.PurchaseSummaryMemberCursorHandler;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.PurchaseMaxPriceMemberPmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.PurchaseSummaryMemberPmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.ResolvedPackageNamePmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.UnpaidSummaryMemberPmb;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.dbflute.exentity.MemberLogin;
import com.example.dbflute.cdi.dbflute.exentity.MemberStatus;
import com.example.dbflute.cdi.dbflute.exentity.Product;
import com.example.dbflute.cdi.dbflute.exentity.Purchase;
import com.example.dbflute.cdi.dbflute.exentity.customize.PurchaseMaxPriceMember;
import com.example.dbflute.cdi.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.cdi.dbflute.exentity.customize.UnpaidSummaryMember;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * Behaviorの上級編Example実装。
 * <pre>
 * ターゲットは以下の通り：
 *   o DBFluteをとことん極めたい方
 *   o 開発中で難しい要求が出てきて実現方法がわからなくて困っている方
 *
 * コンテンツは以下の通り：
 *   o ページング検索のページングナビゲーション要素: selectPage(), pageRange(), pageGroup().
 *   o 一件ずつフェッチしながら処理する検索(大量件数対策): selectCursor().
 *   o one-to-many-to-one(子テーブルの親テーブル)の取得: loadXxxList().
 *   o one-to-many-to-many(子テーブルの子テーブル(孫テーブル))の取得: loadXxxList().
 *   o many-to-one-to-many(親テーブルの子テーブル(兄弟テーブル))の取得: pulloutXxx(), loadXxxList().
 *   o 外だしSQLでone-to-many(子テーブル)の取得: outsideSql(), loadXxxList().
 *   o バッチ登録: batchInsert().
 *   o 排他制御ありバッチ更新: batchUpdate().
 *   o 排他制御なしバッチ更新: batchUpdateNonstrict().
 *   o 排他制御ありバッチ削除: batchDelete().
 *   o 排他制御なしバッチ削除: batchDeleteNonstrict().
 *   o 外だしSQLでBehaviorQueryPathのSubDirectory機能を利用: PATH_xxx_selectXxx.
 *   o 外だしSQLでカーソルの使った検索(大量件数対策): outsideSql().cursorHandling().selectCursor().
 *   o 外だしSQLでFORコメントを使った検索(where句の先頭、and連結): FOR pmb.xxxList, NEXT
 *   o 外だしSQLでFORコメントを使った検索(二番目以降、or連結): FOR pmb.xxxList. FIRST, NEXT, LAST
 *   o 外だしSQLでStatementのコンフィグを設定: outsideSql().configure(statementConfig).
 *   o 外だしSQLでParameterBeanプロパティのPackage解決: '-- !!Date xxx!!'.
 *   o 外だしSQLでSQLファイルが見つからないときの挙動とメッセージ: OutsideSqlNotFoundException.
 *   o 外だしSQLで間違ったバインド変数コメントの場合の挙動と専用メッセージ: BindVariableCommentNotFoundPropertyException.
 *   o 外だしSQLでENDコメントがない場合の挙動と専用メッセージ: EndCommentNotFoundException.
 *   o 外だしSQLでBooleanでないIFコメントの場合の挙動と専用メッセージ: IfCommentNotBooleanResultException.
 *   o 外だしSQLで間違ったIFコメントの場合の挙動と専用メッセージ: IfCommentWrongExpressionException.
 *   o 共通カラムの自動設定を無視して明示的に登録(or 更新): disableCommonColumnAutoSetup().
 *   o ページングの超過ページ番号での検索時の再検索を無効化(ConditionBean): disablePagingReSelect().
 *   o ページングの超過ページ番号での検索時の再検索を無効化(OutsideSql): disablePagingReSelect().
 *   o Entityリストの件数ごとのグルーピング: ListResultBean.groupingList().
 *   o Entityリストのグルーピング(コントロールブレイク): ListResultBean.groupingList(), determine().
 * </pre>
 * @author jflute
 * @since 0.7.3 (2008/05/31 Saturday)
 */
public class BehaviorPlatinumTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Object) */
    @Inject
    private MemberBhv memberBhv;

    /** The behavior of MemberStatus. (Injection Object) */
    @Inject
    private MemberStatusBhv memberStatusBhv;

    /** The behavior of Purchase. (Injection Object) */
    @Inject
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * ページング検索のページングナビゲーション要素: selectPage(), pageRange(), pageGroup().
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
     *   ex) 総ページ数が「22」の場合で、前後「5」ページを表示
     *     [4]Page目を選択  - [1 2 3 '4' 5 6 7 8 9 次へ]
     *     [13]Page目を選択 - [前へ 8 9 10 11 12 '13' 14 15 16 17 18 次へ]
     *     [21]Page目を選択 - [前へ 16 17 18 19 20 '21' 22]
     *
     * {PageRange-fillLimit}
     * 前後nページだけを表示するが、固定数表示とする。
     * 端の方のページが選択されている場合で表示していないページ数の分、反対側のページを表示する。
     * デザインが崩れにくいという特徴あり。
     *   ex) 総ページ数が「22」の場合で、前後「5」ページを表示で固定数表示
     *     [4]Page目を選択  - [1 2 3 '4' 5 6 7 8 9 10 11 次へ]
     *     [13]Page目を選択 - [前へ 8 9 10 11 12 '13' 14 15 16 17 18 次へ]
     *     [21]Page目を選択 - [前へ 12 13 14 15 16 17 18 19 20 '21' 22]
     *
     * {PageGroup}
     * まとまったページ数で一つグループとみなして表示する。
     * そのグループ内のどのページが選択されても表示は変わらない。
     *   ex) 総ページ数が「22」の場合で、「10」ページで一つのグループ
     *     [4]Page目を選択  - [1 2 3 '4' 5 6 7 8 9 10 11 次へ]
     *     [13]Page目を選択 - [前へ 11 12 '13' 14 15 16 17 18 19 20 次へ]
     *     [21]Page目を選択 - [前へ '21' 22]
     * </pre>
     */
    @Test
    @Transactional
    public void test_selectPage_PageRangeOption_PageGroupOption_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();

        // ## Act ##
        cb.paging(4, 2);
        final PagingResultBean<Member> page2 = this.memberBhv.selectPage(cb);
        cb.paging(4, 3);
        final PagingResultBean<Member> page3 = this.memberBhv.selectPage(cb);

        // ## Assert ##
        assertNotSame(0, page3.size());

        this.log("{PageRange}");
        {
            final PageRangeOption pageRangeOption = new PageRangeOption();
            pageRangeOption.setPageRangeSize(2);
            page2.setPageRangeOption(pageRangeOption);
            {
                final boolean existsPre = page2.pageRange().isExistPrePageRange();
                final boolean existsNext = page2.pageRange().isExistNextPageRange();
                this.log("    page2: " + existsPre + " " + page2.pageRange().createPageNumberList() + " " + existsNext);
            }
            page3.setPageRangeOption(pageRangeOption);
            {
                final boolean existsPre = page3.pageRange().isExistPrePageRange();
                final boolean existsNext = page3.pageRange().isExistNextPageRange();
                this.log("    page3: " + existsPre + " " + page3.pageRange().createPageNumberList() + " " + existsNext);
            }
            this.log("PagingResultBean.toString():" + getLineSeparator() + " " + page2 + getLineSeparator() + " "
                    + page3);
            this.log("");
        }
        this.log("{PageRange-fillLimit}");
        {
            final PageRangeOption pageRangeOption = new PageRangeOption();
            pageRangeOption.setPageRangeSize(2);
            pageRangeOption.setFillLimit(true);
            page2.setPageRangeOption(pageRangeOption);
            {
                final boolean existsPre = page2.pageRange().isExistPrePageRange();
                final boolean existsNext = page2.pageRange().isExistNextPageRange();
                this.log("    page2: " + existsPre + " " + page2.pageRange().createPageNumberList() + " " + existsNext);
            }
            page3.setPageRangeOption(pageRangeOption);
            {
                final boolean existsPre = page3.pageRange().isExistPrePageRange();
                final boolean existsNext = page3.pageRange().isExistNextPageRange();
                this.log("    page3: " + existsPre + " " + page3.pageRange().createPageNumberList() + " " + existsNext);
            }
            this.log("PagingResultBean.toString():" + getLineSeparator() + " " + page2 + getLineSeparator() + " "
                    + page3);
            this.log("");
        }
        this.log("{PageGroup}");
        {
            final PageGroupOption pageGroupOption = new PageGroupOption();
            pageGroupOption.setPageGroupSize(2);
            page2.setPageGroupOption(pageGroupOption);
            {
                final boolean existsPre = page2.pageGroup().isExistPrePageGroup();
                final boolean existsNext = page2.pageGroup().isExistNextPageGroup();
                this.log("    page2: " + existsPre + " " + page2.pageGroup().createPageNumberList() + " " + existsNext);
            }
            page3.setPageGroupOption(pageGroupOption);
            {
                final boolean existsPre = page3.pageGroup().isExistPrePageGroup();
                final boolean existsNext = page3.pageGroup().isExistNextPageGroup();
                this.log("    page3: " + existsPre + " " + page3.pageGroup().createPageNumberList() + " " + existsNext);
            }
            this.log("PagingResultBean.toString():" + getLineSeparator() + " " + page2 + getLineSeparator() + " "
                    + page3);
            this.log("");
        }

        // [Description]
        // A. 必ずsetPageRangeOption()でOptionを設定してからpageRange()を呼び出すこと。
        //    設定する前にpageRange()を呼び出すと例外発生。
        //    (他のOption(PageGroupなど)も同様)
        //
        // B. PageRangeとPageGroupは独立した機能である。
        //    --> Rangeを使っているときに間違ってGroupのメソッドを呼び出したりしないように注意
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * 一件ずつフェッチしながら処理する検索(大量件数対策): selectCursor().
     * 大量件数を扱うときのメモリ節約のためのConditionBeanを使った検索。
     * Entityへのマッピングコストがあるため、厳密なパフォーマンスを求めるときは、
     * ResultSetからデータを直取りする(かつタイプセーフな)「外だしSQLのカーソル検索」がお奨め。
     */
    @Test
    @Transactional
    public void test_selectCursor_EntityRowHandler_Tx() {
        // ## Arrange ##
        final int allCount = this.memberBhv.selectCount(new MemberCB());
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        final Set<Integer> memberIdSet = new HashSet<Integer>();

        // ## Act ##
        this.memberBhv.selectCursor(cb, new EntityRowHandler<Member>() {
            public void handle(final Member entity) {
                memberIdSet.add(entity.getMemberId());
                BehaviorPlatinumTest.this.log(entity.getMemberName() + ", "
                        + entity.getMemberStatus().getMemberStatusName());
            }
        });

        // ## Assert ##
        assertEquals(allCount, memberIdSet.size());
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * one-to-many-to-one(子テーブルの親テーブル)の取得: loadXxxList().
     * 検索した会員リストに対して、会員毎の購入リストを購入カウントの降順でロード。
     * その時、購入から辿って商品(子テーブルの親テーブル)も取得。
     */
    @Test
    @Transactional
    public void test_LoadReferrer_setupSelect_Foreign_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Act ##
        this.memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB cb) {
                cb.setupSelect_Product();// *Point!
                cb.query().addOrderBy_PurchaseCount_Desc();
            }
        });

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            final List<Purchase> purchaseList = member.getPurchaseList();
            this.log("[MEMBER]: " + member.getMemberName());
            for (final Purchase purchase : purchaseList) {
                final Long purchaseId = purchase.getPurchaseId();
                final Product product = purchase.getProduct();// *Point!
                this.log("    [PURCHASE]: purchaseId=" + purchaseId + ", product=" + product);
                assertNotNull(product);
            }
        }
    }

    /**
     * one-to-many-to-many(子テーブルの子テーブル(孫テーブル))の取得: loadXxxList().
     * この例題は「会員ステータス」を基点テーブルとする。
     */
    @Test
    @Transactional
    public void test_LoadReferrer_loadReferrerReferrer_Tx() {
        // ## Arrange ##
        // A base table is MemberStatus at this test case.
        final MemberStatusCB cb = new MemberStatusCB();
        final ListResultBean<MemberStatus> memberStatusList = this.memberStatusBhv.selectList(cb);

        final LoadReferrerOption<MemberCB, Member> loadReferrerOption = new LoadReferrerOption<MemberCB, Member>();

        // Member
        loadReferrerOption.setConditionBeanSetupper(new ConditionBeanSetupper<MemberCB>() {
            public void setup(final MemberCB cb) {
                cb.query().addOrderBy_FormalizedDatetime_Desc();
            }
        });

        // Purchase
        loadReferrerOption.setEntityListSetupper(new EntityListSetupper<Member>() {
            public void setup(final List<Member> entityList) {
                BehaviorPlatinumTest.this.memberBhv.loadPurchaseList(entityList,
                        new ConditionBeanSetupper<PurchaseCB>() {
                            public void setup(final PurchaseCB cb) {
                                cb.query().addOrderBy_PurchaseCount_Desc();
                                cb.query().addOrderBy_ProductId_Desc();
                            }
                        });
            }
        });

        // ## Act ##
        this.memberStatusBhv.loadMemberList(memberStatusList, loadReferrerOption);

        // ## Assert ##
        boolean existsPurchase = false;
        assertNotSame(0, memberStatusList.size());
        for (final MemberStatus memberStatus : memberStatusList) {
            final List<Member> memberList = memberStatus.getMemberList();
            this.log("[MEMBER_STATUS]: " + memberStatus.getMemberStatusName());
            for (final Member member : memberList) {
                final List<Purchase> purchaseList = member.getPurchaseList();
                this.log("    [MEMBER]: " + member.getMemberName() + ", " + member.getFormalizedDatetime());
                for (final Purchase purchase : purchaseList) {
                    this.log("        [PURCHASE]: " + purchase.getPurchaseId() + ", " + purchase.getPurchaseCount());
                    existsPurchase = true;
                }
            }
            this.log("");
        }
        assertTrue(existsPurchase);
    }

    /**
     * many-to-one-to-many(親テーブルの子テーブル(兄弟テーブル))の取得: pulloutXxx(), loadXxxList().
     * この例題は「購入」を基点テーブルとする。
     * 「購入」の親テーブル「会員」の子テーブル「会員ログイン」を取得する。
     * 「会員ログイン」はモバイルフラグがtrueで絞り込んでログイン日時の降順で並べる。
     */
    @Test
    @Transactional
    public void test_LoadReferrer_pulloutMember_loadMemberLoginList_Tx() {
        // ## Arrange ##
        final PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Member();// *Point!
        final ListResultBean<Purchase> purchaseList = this.purchaseBhv.selectList(cb);

        // ## Act ##
        final List<Member> memberList = this.purchaseBhv.pulloutMember(purchaseList);// *Point!
        this.memberBhv.loadMemberLoginList(memberList, new ConditionBeanSetupper<MemberLoginCB>() {
            public void setup(final MemberLoginCB cb) {
                cb.query().setMobileLoginFlg_Equal_True();
                cb.query().addOrderBy_LoginDatetime_Desc();
            }
        });

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        boolean existsMemberLogin = false;
        this.log("");
        for (final Purchase purchase : purchaseList) {
            final Member member = purchase.getMember();
            this.log("[PURCHASE & MEMBER]: " + purchase.getPurchaseId() + ", " + member.getMemberName());
            final List<MemberLogin> memberLoginList = member.getMemberLoginList();
            for (final MemberLogin memberLogin : memberLoginList) {
                this.log("    [MEMBER_LOGIN]: " + memberLogin);
                existsMemberLogin = true;
            }
        }
        assertTrue(existsMemberLogin);

        this.log("");
        boolean existsPurchase = false;
        for (final Member member : memberList) {
            final List<Purchase> backToPurchaseList = member.getPurchaseList();
            if (!backToPurchaseList.isEmpty()) {
                existsPurchase = true;
            }
            this.log("[MEMBER]: " + member.getMemberName());
            for (final Purchase backToPurchase : backToPurchaseList) {
                this.log("    " + backToPurchase);
            }
        }
        assertTrue(existsPurchase);

        // [Description]
        // A. pulloutMember()で関連づいてる親テーブルのリストを取得。
        //    - for文で回って取り出しているだけである。
        //    - setupSelect_Xxx()し忘れると空のリストが戻る。
        //
        // B. pulloutMember()で親テーブルには基点テーブルのリストが関連付く
        //   ※例えば、Purchaseを基点としてpulloutMember()で取得したMemberで、
        //    Member.getPurchaseList()で元々のPurchaseが取得できる。
    }

    /**
     * 外だしSQLでone-to-many(子テーブル)の取得: outsideSql(), loadXxxList().
     */
    @Test
    @Transactional
    public void test_LoadReferrer_ousdieSql_paging_Tx() {
        // ## Arrange ##
        final String path = MemberBhv.PATH_selectUnpaidSummaryMember;
        final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.paging(8, 2);
        final Class<UnpaidSummaryMember> entityType = UnpaidSummaryMember.class;

        final PagingResultBean<UnpaidSummaryMember> memberPage = this.memberBhv.outsideSql().autoPaging()
                .selectPage(path, pmb, entityType);
        final List<Member> domainList = new ArrayList<Member>();
        for (final UnpaidSummaryMember member : memberPage) {
            domainList.add(member.prepareDomain());
        }

        // ## Act ##
        this.memberBhv.loadPurchaseList(domainList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB cb) {
                cb.setupSelect_Product();
                cb.query().setPaymentCompleteFlg_Equal_True();
            }
        });

        // ## Assert ##
        boolean exists = false;
        for (final UnpaidSummaryMember member : memberPage) {
            final List<Purchase> purchaseList = member.getPurchaseList();
            if (!purchaseList.isEmpty()) {
                exists = true;
            }
            this.log(member.getUnpaidManName() + ", " + member.getStatusName());
            for (final Purchase purchase : purchaseList) {
                this.log("  " + purchase);
            }
            assertTrue(member.getMemberLoginList().isEmpty());
        }
        assertTrue(exists);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * バッチ登録: batchInsert().
     */
    @Test
    @Transactional
    public void test_Batch_batchInsert_Tx() {
        // ## Arrange ##
        final List<Member> memberList = new ArrayList<Member>();
        {
            final Member member = new Member();
            member.setMemberName("testName1");
            member.setMemberAccount("testAccount1");
            member.setMemberStatusCode_正式会員();
            memberList.add(member);
        }
        {
            final Member member = new Member();
            member.setMemberName("testName2");
            member.setMemberAccount("testAccount2");
            member.setMemberStatusCode_仮会員();
            memberList.add(member);
        }
        {
            final Member member = new Member();
            member.setMemberName("testName3");
            member.setMemberAccount("testAccount3");
            member.setMemberStatusCode_退会会員();
            memberList.add(member);
        }

        // ## Act ##
        final int[] result = this.memberBhv.batchInsert(memberList);

        // ## Assert ##
        assertEquals(3, result.length);
        for (final Member member : memberList) {
            assertNull(member.getMemberId());
        }

        // [Description]
        // A. PreparedStatement.executeBatch()を利用
        //    --> 大量件数に向いている
        // B. Identityの場合は、処理後のEntityには採番値は格納されない
    }

    /**
     * 排他制御ありバッチ更新: batchUpdate().
     */
    @Test
    @Transactional
    public void test_Batch_batchUpdate_Tx() {
        // ## Arrange ##
        final List<Integer> memberIdList = new ArrayList<Integer>();
        memberIdList.add(1);
        memberIdList.add(3);
        memberIdList.add(7);
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_InScope(memberIdList);
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);
        int count = 0;
        final List<Long> expectedVersionNoList = new ArrayList<Long>();
        for (final Member member : memberList) {
            member.setMemberName("testName" + count);
            member.setMemberAccount("testAccount" + count);
            member.setMemberStatusCode_仮会員();
            member.setFormalizedDatetime(this.currentTimestamp());
            member.setBirthdate(this.currentTimestamp());
            expectedVersionNoList.add(member.getVersionNo());
            ++count;
        }

        // ## Act ##
        final int[] result = this.memberBhv.batchUpdate(memberList);

        // ## Assert ##
        assertEquals(3, result.length);

        // [Description]
        // A. PreparedStatement.executeBatch()を利用
        //    --> 大量件数に向いている
        //
        // B. 全てのカラムが更新される。
        //    --> ModifiedProperties機能はない
        //
        // C. Oracleは排他制御できない可能性がある
        //    --> OracleのJDBCドライバが結果件数を正常に戻さないため
        //    --> DBFlute-0.7.9より可能になった
        //
        // D. すれ違いが発生した場合は例外発生。{EntityAlreadyUpdatedException}
        // E. 存在しないPK値を指定された場合はすれ違いが発生した場合と同じ。
        //    --> 排他制御と区別が付かないため
        //
        // F. 一意制約違反のときは、EntityAlreadyExistsExceptionが発生。(DBFlute-0.7.7より)
        //   ※JDBCドライバ依存であることに注意
        //   ※UniqueConstraintTest参考
    }

    /**
     * 排他制御なしバッチ更新: batchUpdateNonstrict().
     */
    @Test
    @Transactional
    public void test_Batch_batchUpdateNonstrict_Tx() {
        // ## Arrange ##
        final List<Integer> memberIdList = new ArrayList<Integer>();
        memberIdList.add(1);
        memberIdList.add(3);
        memberIdList.add(7);
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_InScope(memberIdList);
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);
        int count = 0;
        for (final Member member : memberList) {
            member.setMemberName("testName" + count);
            member.setMemberAccount("testAccount" + count);
            member.setMemberStatusCode_仮会員();
            member.setFormalizedDatetime(this.currentTimestamp());
            member.setBirthdate(this.currentTimestamp());
            member.setVersionNo(null);// *Point!
            ++count;
        }
        // ## Act ##
        final int[] result = this.memberBhv.batchUpdateNonstrict(memberList);

        // ## Assert ##
        assertEquals(3, result.length);
        for (final Member member : memberList) {
            assertNull(member.getVersionNo());
        }

        // [Description]
        // A. PreparedStatement.executeBatch()を利用
        //    --> 大量件数に向いている
        //
        // B. 存在しないPK値を指定された場合は例外発生。{EntityAlreadyDeletedException}
        //
        // C. バージョンNOは設定不要(OnQueryでインクリメント「VERSION_NO = VERSION + 1」)
        // member.setVersionNo(versionNo);
        //
        // D. 更新後のEntityのVersionNoは更新前と全く同じ値がそのまま保持される。
        //
        // E. 一意制約違反のときは、EntityAlreadyExistsExceptionが発生。(DBFlute-0.7.7より)
        //   ※JDBCドライバ依存であることに注意
        //   ※UniqueConstraintTest参考
    }

    /**
     * 排他制御ありバッチ削除: batchDelete().
     */
    @Test
    @Transactional
    public void test_Batch_batchDelete_Tx() {
        // ## Arrange ##
        this.deleteMemberReferrer();

        final List<Integer> memberIdList = new ArrayList<Integer>();
        memberIdList.add(1);
        memberIdList.add(3);
        memberIdList.add(7);
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_InScope(memberIdList);
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Act ##
        final int[] result = this.memberBhv.batchDelete(memberList);

        // ## Assert ##
        assertEquals(3, result.length);

        // [Description]
        // A. PreparedStatement.executeBatch()を利用
        //    --> 大量件数に向いている
        //
        // B. Oracleは排他制御できない可能性がある
        //    --> OracleのJDBCドライバが結果件数を正常に戻さないため
        //
        // C. すれ違いが発生した場合は例外発生。{EntityAlreadyUpdatedException}
        // D. 存在しないPK値を指定された場合はすれ違いが発生した場合と同じ。
        //    --> 排他制御と区別が付かないため
    }

    /**
     * 排他制御なしバッチ削除: batchDeleteNonstrict().
     */
    @Test
    @Transactional
    public void test_Batch_batchDeleteNonstrict_Tx() {
        // ## Arrange ##
        this.deleteMemberReferrer();

        final List<Member> memberList = new ArrayList<Member>();
        {
            final Member member = new Member();
            member.setMemberId(1);
            memberList.add(member);
        }
        {
            final Member member = new Member();
            member.setMemberId(3);
            memberList.add(member);
        }
        {
            final Member member = new Member();
            member.setMemberId(7);
            memberList.add(member);
        }

        // ## Act ##
        final int[] result = this.memberBhv.batchDeleteNonstrict(memberList);

        // ## Assert ##
        assertEquals(3, result.length);

        // [Description]
        // A. PreparedStatement.executeBatch()を利用
        //    --> 大量件数に向いている
        //
        // B. 存在しないPK値を指定された場合は例外発生。{EntityAlreadyDeletedException}
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    // /- - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 基本的なselectList()に関しては、BehaviorBasicTestにて
    // - - - - - - - - - -/
    // /- - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 中級的なselectList()に関しては、BehaviorMiddleTestにて
    // - - - - - - - - - -/

    /**
     * 外だしSQLでBehaviorQueryPathのSubDirectory機能を利用: PATH_xxx_selectXxx.
     * exbhv配下の任意のSubDirectory(SubPackage)にSQLファイルを配置して利用することが可能。
     * SQLファイルの数があまりに膨大になる場合は、テーブルのカテゴリ毎にDirectoryを作成して、
     * 適度にSQLファイルをカテゴリ分けすると良い。
     */
    @Test
    @Transactional
    public void test_outsideSql_selectList_selectSubDirectory_Tx() {
        // ## Arrange ##
        // SQLのパス
        final String path = MemberBhv.PATH_subdirectory_selectSubDirectoryCheck;

        // 検索条件
        final SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName_PrefixSearch("S");

        // 戻り値Entityの型
        final Class<SimpleMember> entityType = SimpleMember.class;

        // ## Act ##
        // SQL実行！
        final List<SimpleMember> resultList = this.memberBhv.outsideSql().selectList(path, pmb, entityType);

        // ## Assert ##
        assertNotSame(0, resultList.size());
        this.log("{SimpleMember}");
        for (final SimpleMember entity : resultList) {
            final Integer memberId = entity.getMemberId();
            final String memberName = entity.getMemberName();
            final String memberStatusName = entity.getMemberStatusName();
            this.log("    " + memberId + ", " + memberName + ", " + memberStatusName);
            assertNotNull(memberId);
            assertNotNull(memberName);
            assertNotNull(memberStatusName);
            assertTrue(memberName.startsWith("S"));
        }
    }

    // -----------------------------------------------------
    //                                                Cursor
    //                                                ------
    /**
     * 外だしSQLでカーソルの使った検索(大量件数対策): outsideSql().cursorHandling().selectCursor().
     * 実処理は、MemberBhv#makeCsvPurchaseSummaryMember()にて実装しているのでそちらを参照。
     * <pre>
     * Entity定義にて以下のようにオプション「+cursor+」を付けることにより、タイプセーフカーソルが利用可能。
     * -- #PurchaseSummaryMember#
     * -- +cursor+
     * </pre>
     */
    @Test
    @Transactional
    public void test_outsideSql_selectCursor_makeCsvSummaryMember_selectPurchaseSummaryMember_Tx() {
        // ## Arrange ##
        final PurchaseSummaryMemberPmb pmb = new PurchaseSummaryMemberPmb();
        pmb.setMemberStatusCode_正式会員();
        pmb.setFormalizedDatetime(DfTypeUtil.toTimestamp("2003-08-12 12:34:56.147"));

        // ## Act & Assert ##
        this.memberBhv.makeCsvPurchaseSummaryMember(pmb);
    }

    // -----------------------------------------------------
    //                                           FOR Comment
    //                                           -----------
    /**
     * 外だしSQLでFORコメントを使った検索(where句の先頭、and連結): FOR pmb.xxxList, NEXT
     */
    @Test
    @Transactional
    public void test_outsideSql_forComment_nextAnd_Tx() {
        // ## Arrange ##
        final String path = MemberBhv.PATH_selectPurchaseSummaryMember;
        final PurchaseSummaryMemberPmb pmb = new PurchaseSummaryMemberPmb();
        pmb.setMemberNameList_ContainSearch(DfCollectionUtil.newArrayList("S", "v"));

        // ## Act & Assert ##
        final Set<String> existsSet = DfCollectionUtil.newHashSet();
        this.memberBhv.outsideSql().cursorHandling().selectCursor(path, pmb, new PurchaseSummaryMemberCursorHandler() {
            @Override
            public Object fetchCursor(final PurchaseSummaryMemberCursor cursor) throws SQLException {
                while (cursor.next()) {
                    existsSet.add("exists");
                    final Integer memberId = cursor.getMemberId();
                    final String memberName = cursor.getMemberName();
                    final Date birthdate = cursor.getBirthdate();

                    final String c = ", ";
                    BehaviorPlatinumTest.this.log(memberId + c + memberName + c + birthdate);
                    if (!memberName.contains("S") || !memberName.contains("v")) {
                        fail("memberName should have S and t: " + memberName);
                    }
                }
                return null;
            }
        });
        assertTrue(existsSet.contains("exists"));
    }

    /**
     * 外だしSQLでFORコメントを使った検索(二番目以降、or連結): FOR pmb.xxxList. FIRST, NEXT, LAST
     */
    @Test
    @Transactional
    public void test_outsideSql_forComment_nextOr_Tx() {
        // ## Arrange ##
        final PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();
        //pmb.setMemberId(3);
        pmb.setMemberNameList_PrefixSearch(DfCollectionUtil.newArrayList("S", "M"));

        // ## Act ##
        final int pageSize = 3;
        pmb.paging(pageSize, 1); // 1st page
        final PagingResultBean<PurchaseMaxPriceMember> page1 = this.memberBhv.outsideSql().manualPaging()
                .selectPage(pmb);

        // ## Assert ##
        assertNotSame(0, page1.size());
        for (final PurchaseMaxPriceMember member : page1) {
            this.log(member);
            final String memberName = member.getMemberName();

            if (!memberName.contains("S") && !memberName.contains("M")) {
                fail("memberName should have S or M: " + memberName);
            }
        }
    }

    // -----------------------------------------------------
    //                                      Statement Config
    //                                      ----------------
    /**
     * 外だしSQLでStatementのコンフィグを設定: outsideSql().configure(statementConfig).
     */
    @Test
    @Transactional
    public void test_outsideSql_configure_Tx() {
        // ## Arrange ##
        final SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName_PrefixSearch("S");

        // コンフィグ
        final StatementConfig statementConfig = new StatementConfig().typeForwardOnly().queryTimeout(7).maxRows(2);

        // ## Act ##
        final List<SimpleMember> memberList = this.memberBhv.outsideSql().configure(statementConfig).selectList(pmb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        assertEquals(2, memberList.size());
        this.log("{SimpleMember}");
        for (final SimpleMember entity : memberList) {
            final Integer memberId = entity.getMemberId();
            final String memberName = entity.getMemberName();
            final String memberStatusName = entity.getMemberStatusName();
            this.log("    " + memberId + ", " + memberName + ", " + memberStatusName);
            assertNotNull(memberId);
            assertNotNull(memberName);
            assertNotNull(memberStatusName);
            assertTrue(memberName.startsWith("S"));
        }
    }

    // -----------------------------------------------------
    //                          ParameterBean ResolvePackage
    //                          ----------------------------
    /**
     * 外だしSQLでParameterBeanプロパティのPackage解決: '-- !!Date xxx!!'.
     * MemberBhv_selectResolvedPackageName.sqlを参照。
     */
    @Test
    @Transactional
    public void test_outsideSql_selectResolvedPackageName_Tx() {
        // ## Arrange ##
        // SQLのパス
        final String path = MemberBhv.PATH_various_pmbcheck_selectResolvedPackageName;

        // 検索条件
        final ResolvedPackageNamePmb pmb = new ResolvedPackageNamePmb();
        pmb.setDate1(new java.util.Date()); // java.util.Dateで検索できることを確認
        final List<String> statusList = new ArrayList<String>();
        statusList.add(CDef.MemberStatus.正式会員.code());
        statusList.add(CDef.MemberStatus.退会会員.code());
        pmb.setList1(statusList); // java.util.Listで検索できることを確認

        // 戻り値Entityの型
        final Class<Member> entityType = Member.class;

        // ## Act ##ß
        // SQL実行！
        final List<Member> memberList = this.memberBhv.outsideSql().selectList(path, pmb, entityType);

        // ## Assert ##
        assertFalse(memberList.isEmpty());

        // [Description]
        // A. ListやDateなど良く利用されるクラスのPackageを自動で解決する。
        //    そのためParameterBeanの宣言でパッケージ名を記述する必要はない。
        //    -- !BigDecimal bigDecimal1! *java.math.BigDecimal
        //    -- !Date bigDecimal1! *java.util.Date
        //    -- !Time bigDecimal1! *java.sql.Time
        //    -- !Timestamp bigDecimal1! *java.sql.Timestamp
        //    -- !List<String> list1! * java.util.List<>
        //    -- !Map<String, String> map1! * java.util.Map<>
    }

    // -----------------------------------------------------
    //                                              NotFound
    //                                              --------
    /**
     * 外だしSQLでSQLファイルが見つからないときの挙動とメッセージ: OutsideSqlNotFoundException.
     * 専用メッセージは開発者がデバッグしやすいように。
     */
    @Test
    @Transactional
    public void test_outsideSql_NotFound_Tx() {
        try {
            this.memberBhv.outsideSql().selectList("sql/noexist/selectByNoExistSql.sql", null, Member.class);
            fail();
        } catch (final OutsideSqlNotFoundException e) {
            this.log(e.getMessage());
        }
    }

    // -----------------------------------------------------
    //                                         Wrong Comment
    //                                         -------------
    /**
     * 外だしSQLで間違ったバインド変数コメントの場合の挙動と専用メッセージ: BindVariableCommentNotFoundPropertyException.
     * 専用メッセージは開発者がデバッグしやすいように。
     */
    @Test
    @Transactional
    public void test_outsideSql_BindVariableNotFoundProperty_Tx() {
        try {
            final String path = MemberBhv.PATH_various_wrongexample_selectBindVariableNotFoundProperty;
            final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
            pmb.setMemberName_PrefixSearch("S");
            this.memberBhv.outsideSql().selectList(path, pmb, Member.class);
            fail();
        } catch (final BindVariableCommentNotFoundPropertyException e) {
            this.log(e.getMessage());
            assertTrue(e.getMessage().contains("wrongMemberId"));
        }
    }

    /**
     * 外だしSQLでENDコメントがない場合の挙動と専用メッセージ: EndCommentNotFoundException.
     * 専用メッセージは極力開発者がデバッグしやすいように。
     */
    @Test
    @Transactional
    public void test_outsideSql_EndCommentNotFound_Tx() {
        try {
            final String path = MemberBhv.PATH_various_wrongexample_selectEndCommentNotFound;
            final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
            pmb.setMemberName_PrefixSearch("S");
            this.memberBhv.outsideSql().selectList(path, pmb, Member.class);
            fail();
        } catch (final EndCommentNotFoundException e) {
            this.log(e.getMessage());
        }
    }

    /**
     * 外だしSQLでBooleanでないIFコメントの場合の挙動と専用メッセージ: IfCommentNotBooleanResultException.
     * 専用メッセージは極力開発者がデバッグしやすいように。
     */
    @Test
    @Transactional
    public void test_outsideSql_IfCommentNotBooleanResult_Tx() {
        try {
            final String path = MemberBhv.PATH_various_wrongexample_selectIfCommentNotBooleanResult;
            final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
            pmb.setMemberName_PrefixSearch("S");
            this.memberBhv.outsideSql().selectList(path, pmb, Member.class);
            fail();
        } catch (final IfCommentNotBooleanResultException e) {
            this.log(e.getMessage());
        }
    }

    /**
     * 外だしSQLで間違ったIFコメントの場合の挙動と専用メッセージ: IfCommentWrongExpressionException.
     * 専用メッセージは極力開発者がデバッグしやすいように。
     */
    @Test
    @Transactional
    public void test_outsideSql_IfCommentWrongExpression_Tx() {
        try {
            final String path = MemberBhv.PATH_various_wrongexample_selectIfCommentWrongExpression;
            final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
            pmb.setMemberName_PrefixSearch("S");
            this.memberBhv.outsideSql().selectList(path, pmb, Member.class);
            fail();
        } catch (final IfCommentWrongExpressionException e) {
            this.log(e.getMessage());
            if (!e.getMessage().contains("wrongMemberId")) {
                fail();
            }
        }
    }

    // ===================================================================================
    //                                                                       Common Column
    //                                                                       =============
    /**
     * 共通カラムの自動設定を無視して明示的に登録(or 更新): disableCommonColumnAutoSetup().
     */
    @Test
    @Transactional
    public void test_insert_disableCommonColumnAutoSetup_Tx() {
        // ## Arrange ##
        final Timestamp expectedTimestamp = new Timestamp(this.currentTimestamp().getTime() - 10000000000l);
        final Member member = new Member();
        member.setMemberName("Billy Joel");
        member.setMemberAccount("martinjoel");
        member.setBirthdate(this.currentDate());
        member.setFormalizedDatetime(this.currentTimestamp());
        member.setMemberStatusCode_正式会員();
        member.setRegisterDatetime(expectedTimestamp);
        member.setRegisterUser("suppressRegisterUser");
        member.setUpdateDatetime(expectedTimestamp);
        member.setUpdateUser("suppressUpdateUser");
        member.disableCommonColumnAutoSetup();// *Point!

        // ## Act ##
        this.memberBhv.insert(member);

        // ## Assert ##
        final MemberCB cb = new MemberCB();
        cb.acceptPrimaryKeyMap(member.getDBMeta().extractPrimaryKeyMap(member));
        final Member actualMember = this.memberBhv.selectEntityWithDeletedCheck(cb);
        final Timestamp registerDatetime = actualMember.getRegisterDatetime();
        final String registerUser = actualMember.getRegisterUser();
        final Timestamp updateDatetime = actualMember.getUpdateDatetime();
        final String updateUser = actualMember.getUpdateUser();
        this.log("registerDatetime = " + registerDatetime);
        assertNotNull(registerDatetime);
        assertEquals(expectedTimestamp, registerDatetime);
        this.log("registerUser = " + registerUser);
        assertNotNull(registerUser);
        assertEquals("suppressRegisterUser", registerUser);
        this.log("updateDatetime = " + updateDatetime);
        assertNotNull(updateDatetime);
        assertEquals(expectedTimestamp, updateDatetime);
        this.log("updateUser = " + updateUser);
        assertNotNull(updateUser);
        assertEquals("suppressUpdateUser", updateUser);
    }

    // ===================================================================================
    //                                                                    Paging Re-Select
    //                                                                    ================
    /**
     * ページングの超過ページ番号での検索時の再検索を無効化(ConditionBean): disablePagingReSelect().
     */
    @Test
    @Transactional
    public void test_conditionBean_paging_disablePagingReSelect_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        cb.paging(4, 99999);
        cb.disablePagingReSelect();

        // ## Act ##
        final PagingResultBean<Member> page99999 = this.memberBhv.selectPage(cb);

        // ## Assert ##
        assertTrue(page99999.isEmpty());
    }

    /**
     * ページングの超過ページ番号での検索時の再検索を無効化(OutsideSql): disablePagingReSelect().
     */
    @Test
    @Transactional
    public void test_outsideSql_paging_disablePagingReSelect_Tx() {
        // ## Arrange ##
        // SQLのパス
        final String path = MemberBhv.PATH_selectUnpaidSummaryMember;

        // 検索条件
        final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberStatusCode_正式会員();// 正式会員
        pmb.disablePagingReSelect();

        // 戻り値Entityの型
        final Class<UnpaidSummaryMember> entityType = UnpaidSummaryMember.class;

        // ## Act ##
        // SQL実行！
        final int pageSize = 3;
        pmb.paging(pageSize, 99999);
        final PagingResultBean<UnpaidSummaryMember> page99999 = this.memberBhv.outsideSql().autoPaging()
                .selectPage(path, pmb, entityType);

        // ## Assert ##
        assertTrue(page99999.isEmpty());
    }

    // ===================================================================================
    //                                                                    List Result Bean
    //                                                                    ================
    /**
     * Entityリストの件数ごとのグルーピング: ListResultBean.groupingList().
     * 会員リストを３件ずつのグループリストにする。
     */
    @Test
    @Transactional
    public void test_selectList_ListResultBean_groupingList_count_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);
        this.log("ListResultBean.toString():" + getLineSeparator() + " " + memberList);

        // ## Act ##
        final GroupingOption<Member> groupingOption = new GroupingOption<Member>(3);
        final List<List<Member>> groupingList = memberList.groupingList(
                new GroupingRowSetupper<List<Member>, Member>() {
                    public List<Member> setup(final GroupingRowResource<Member> groupingRowResource) {
                        return new ArrayList<Member>(groupingRowResource.getGroupingRowList());
                    }
                }, groupingOption);

        // ## Assert ##
        assertFalse(groupingList.isEmpty());
        int rowIndex = 0;
        for (final List<Member> elementList : groupingList) {
            assertTrue(elementList.size() <= 3);
            this.log("[" + rowIndex + "]");
            for (final Member member : elementList) {
                this.log("  " + member);
            }
            ++rowIndex;
        }
    }

    /**
     * Entityリストのグルーピング(コントロールブレイク): ListResultBean.groupingList(), determine().
     * 会員リストを会員名称の先頭文字ごとのグループリストにする。
     * @since 0.8.2
     */
    @Test
    @Transactional
    public void test_selectList_ListResultBean_groupingList_determine_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);
        this.log("ListResultBean.toString():" + getLineSeparator() + " " + memberList);

        // ## Act ##
        final GroupingOption<Member> groupingOption = new GroupingOption<Member>(); // The breakCount is unnecessary in this case.
        groupingOption.setGroupingRowEndDeterminer(new GroupingRowEndDeterminer<Member>() {
            public boolean determine(final GroupingRowResource<Member> rowResource, final Member nextEntity) {
                final Member currentEntity = rowResource.getCurrentEntity();
                final String currentInitChar = currentEntity.getMemberName().substring(0, 1);
                final String nextInitChar = nextEntity.getMemberName().substring(0, 1);
                return !currentInitChar.equalsIgnoreCase(nextInitChar);
            }
        });
        final List<List<Member>> groupingList = memberList.groupingList(
                new GroupingRowSetupper<List<Member>, Member>() {
                    public List<Member> setup(final GroupingRowResource<Member> groupingRowResource) {
                        return new ArrayList<Member>(groupingRowResource.getGroupingRowList());
                    }
                }, groupingOption);

        // ## Assert ##
        assertFalse(groupingList.isEmpty());
        int entityCount = 0;
        for (final List<Member> elementList : groupingList) {
            String currentInitChar = null;
            for (final Member member : elementList) {
                if (currentInitChar == null) {
                    currentInitChar = member.getMemberName().substring(0, 1);
                    this.log("[" + currentInitChar + "]");
                }
                this.log("  " + member.getMemberName() + ", " + member);
                assertEquals(currentInitChar, member.getMemberName().substring(0, 1));
                ++entityCount;
            }
        }
        assertEquals(memberList.size(), entityCount);
    }
}
