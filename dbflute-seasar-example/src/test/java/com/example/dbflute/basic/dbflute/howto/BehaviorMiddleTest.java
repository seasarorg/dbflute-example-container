package com.example.dbflute.basic.dbflute.howto;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.ScalarQuery;
import org.seasar.dbflute.exception.EntityAlreadyDeletedException;
import org.seasar.dbflute.helper.HandyDate;

import com.example.dbflute.basic.dbflute.cbean.MemberCB;
import com.example.dbflute.basic.dbflute.cbean.PurchaseCB;
import com.example.dbflute.basic.dbflute.exbhv.MemberBhv;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.LatestFormalizedDatetimePmb;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.MemberNamePmb;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.PurchaseMaxPriceMemberPmb;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.UnpaidSummaryMemberPmb;
import com.example.dbflute.basic.dbflute.exentity.Member;
import com.example.dbflute.basic.dbflute.exentity.Purchase;
import com.example.dbflute.basic.dbflute.exentity.customize.PurchaseMaxPriceMember;
import com.example.dbflute.basic.dbflute.exentity.customize.UnpaidSummaryMember;
import com.example.dbflute.basic.unit.UnitContainerTestCase;

/**
 * Behaviorの中級編Example実装。
 * <pre>
 * ターゲットは以下の通り：
 *   o DBFluteってどういう機能があるのかを探っている方
 *   o DBFluteで実装を開始する方・実装している方
 * 
 * コンテンツは以下の通り：
 *   o ページング検索: selectPage().
 *   o 最大値や合計値だけを取るスカラ検索(ScalarSelect): scalarSelect(), max().
 *   o one-to-many, 子テーブルの検索(LoadReferrer): loadXxxList().
 *   o ConditionBeanを使った更新: queryUpdate().
 *   o ConditionBeanを使った削除: queryDelete().
 *   o 外だしSQLでカラム一つだけのリスト検索: outsideSql().selectList().
 *   o 外だしSQLの手動ページング検索: outsideSql().manualPaging().selectPage().
 *   o 外だしSQLの自動ページング検索: outsideSql().autoPaging().selectPage().
 *   o 外だしSQLで一件検索: outsideSql().entitnHandling().selectEntity().
 *   o 外だしSQLでチェック付き一件検索: outsideSql().entitnHandling().selectEntityWithDeletedCheck().
 *   o 外だしSQLでカラム一つだけの一件検索: outsideSql().entitnHandling().selectEntity().
 * </pre>
 * @author jflute
 * @since 0.7.3 (2008/05/31 Saturday)
 */
public class BehaviorMiddleTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Component) */
    @Resource
    protected MemberBhv memberBhv;

    // ===================================================================================
    //                                                                Paging (Page Select)
    //                                                                ====================
    /**
     * o ページング検索: selectPage(). <br />
     * 会員名称の昇順のリストを "１ページ４件" の "３ページ目" (９件目から１２件目) を検索。
     * <pre>
     * ConditionBean.paging(pageSize, pageNumber)にてページング条件を指定：
     *   o pageSize : ページサイズ(１ページあたりのレコード数)
     *   o pageNumber : ページ番号(検索する対象のページ)
     * 
     * selectPage()だけでページングの基本が全て実行される：
     *   1. ページングなし件数取得
     *   2. ページング実データ検索
     *   3. ページング結果計算処理
     * 
     * PagingResultBeanから様々な要素が取得可能：
     *   o ページングなし総件数
     *   o 現在ページ番号
     *   o 総ページ数
     *   o 前ページの有無判定
     *   o 次ページの有無判定
     *   o ページングナビゲーション要素 ※詳しくはBehaviorPlatinumTestにて
     *   o などなど
     * </pre>
     */
    public void test_selectPage() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        cb.paging(4, 3);

        // ## Act ##
        PagingResultBean<Member> page3 = memberBhv.selectPage(cb);

        // ## Assert ##
        assertNotSame(0, page3.size());
        for (Member member : page3) {
            log(member.toString());
        }
        log("allRecordCount=" + page3.getAllRecordCount());
        log("allPageCount=" + page3.getAllPageCount());
        log("currentPageNumber=" + page3.getCurrentPageNumber());
        log("currentStartRecordNumber=" + page3.getCurrentStartRecordNumber());
        log("currentEndRecordNumber=" + page3.getCurrentEndRecordNumber());
        log("isExistPrePage=" + page3.isExistPrePage());
        log("isExistNextPage=" + page3.isExistNextPage());
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * o 最大値や合計値だけを取るスカラ検索(ScalarSelect): scalarSelect(), max(). <br />
     * 正式会員で一番最近(最大)の誕生日を検索。
     */
    public void test_scalarSelect_max() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().columnBirthdate();
        cb.query().setMemberStatusCode_Equal_正式会員();
        cb.query().setBirthdate_IsNotNull();
        cb.query().addOrderBy_Birthdate_Desc();
        cb.fetchFirst(1);
        Date expected = memberBhv.selectEntityWithDeletedCheck(cb).getBirthdate();

        // ## Act ##
        Date birthday = memberBhv.scalarSelect(Date.class).max(new ScalarQuery<MemberCB>() {
            public void query(MemberCB cb) {
                cb.specify().columnBirthdate(); // *Point!
                cb.query().setMemberStatusCode_Equal_正式会員();
            }
        });

        // ## Assert ##
        assertEquals(expected, birthday);

        // 【補足】
        // A. max(), min(), sum(), avg()をサポート
        // B. サポートされない型を指定された場合は例外発生(例えばsum()に日付型を指定など)
        // C. コールバックのConditionBeanにて対象のカラムを指定。
        //  -> 必ず「一つだけ」を指定すること (指定なし、もしくは、複数の場合は例外発生)
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * o one-to-many, 子テーブルの検索(LoadReferrer): loadXxxList(). <br />
     * 検索した会員リストに対して、会員毎の購入カウントが２件以上の購入リストを購入カウントの降順でロード。
     * 子テーブル(Referrer)を取得する「一発」のSQLを発行してマッピングをする(SubSelectフェッチ)。
     * DBFluteではこのone-to-manyをロードする機能を「LoadReferrer」と呼ぶ。
     */
    public void test_loadReferrer() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
                cb.query().setPurchaseCount_GreaterEqual(2);
                cb.query().addOrderBy_PurchaseCount_Desc();
            }
        });

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            log("[MEMBER]: " + member.getMemberName());
            List<Purchase> purchaseList = member.getPurchaseList(); // *Point!
            for (Purchase purchase : purchaseList) {
                log("  [PURCHASE]: " + purchase.toString());
            }
        }

        // [SQL]
        // {1}: memberBhv.selectList(cb);
        // select ... 
        //   from MEMBER dflocal
        // 
        // {2}: memberBhv.loadPurchaseList(memberList, ...); 
        // select ... 
        //   from PURCHASE dflocal 
        //  where dflocal.MEMBER_ID in (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        //    and dflocal.PURCHASE_COUNT >= 2 
        //  order by dflocal.MEMBER_ID asc, dflocal.PURCHASE_COUNT desc

        // 【補足】
        // A. 基点テーブルが複合PKの場合はサポートされない。
        //  -> このExampleでは会員テーブル。もし複合PKならloadPurchaseList()メソッド自体が生成されない。
        // B. SubSelectフェッチなので「n+1問題」は発生しない。
        // C. 枝分かれの子テーブルを取得することも可能。
        // D. 子テーブルの親テーブルを取得することも可能。詳しくはBehaviorPlatinumTestにて
        // E. 子テーブルの子テーブル(孫テーブル)を取得することも可能。詳しくはBehaviorPlatinumTestにて
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * o ConditionBeanを使った更新: queryUpdate(). <br />
     * 会員ステータスが正式会員の会員を全て仮会員にする。
     * ConditionBeanで設定した条件で一括削除が可能である。(排他制御はない)
     * @since 0.7.5
     */
    public void test_queryUpdate() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberStatusCode_仮会員();
        member.setFormalizedDatetime(null);
        Date birthdate = new HandyDate("2013/07/01").getDate();
        member.setBirthdate(birthdate);

        MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_正式会員();

        // ## Act ##
        int updatedCount = memberBhv.queryUpdate(member, cb);

        // ## Assert ##
        assertNotSame(0, updatedCount);
        MemberCB actualCB = new MemberCB();
        actualCB.query().setMemberStatusCode_Equal_仮会員();
        actualCB.query().setFormalizedDatetime_IsNull();
        actualCB.query().setBirthdate_Equal(birthdate);
        actualCB.query().setUpdateUser_Equal(getAccessContext().getAccessUser()); // common column
        ListResultBean<Member> actualList = memberBhv.selectList(actualCB);
        assertEquals(actualList.size(), updatedCount);

        // 【補足】
        // A. 条件として、結合先のカラムによる条件やexists句を使ったサブクエリーなども利用可能。
        // B. setupSelect_Xxx()やaddOrderBy_Xxx()を呼び出しても意味はない。
        // C. 排他制御はせずに問答無用で更新する。(バージョンNOは自動インクリメント)
        // D. 更新結果が0件でも特に例外は発生しない。
        // E. 共通カラム(CommonColumn)の自動設定は有効。
    }

    /**
     * o ConditionBeanを使った削除: queryDelete(). <br />
     * 会員ステータスが正式会員の会員を全て削除する。
     * ConditionBeanで設定した条件で一括削除が可能である。(排他制御はない)
     */
    public void test_queryDelete() {
        // ## Arrange ##
        deleteMemberReferrer();// for Test

        MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_正式会員();// 正式会員

        // ## Act ##
        int deletedCount = memberBhv.queryDelete(cb);

        // ## Assert ##
        assertNotSame(0, deletedCount);
        assertEquals(0, memberBhv.selectCount(cb));

        // 【補足】
        // A. 条件として、結合先のカラムによる条件やexists句を使ったサブクエリーなども利用可能。
        // B. setupSelect_Xxx()やaddOrderBy_Xxx()を呼び出しても意味はない。
        // C. 排他制御はせずに問答無用で削除する。
        // D. 削除結果が0件でも特に例外は発生しない。
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    // /- - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 基本的な外だしSQL: BehaviorBasicTest
    // - - - - - - - - - -/

    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    /**
     * o 外だしSQLでカラム一つだけのリスト検索: outsideSql().selectList(). <br />
     */
    public void test_outsideSql_selectList_selectMemberName() {
        // ## Arrange ##
        MemberNamePmb pmb = new MemberNamePmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        List<String> memberNameList = memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertNotSame(0, memberNameList.size());
        assertHasAnyElement(memberNameList);
        log("{MemberName}");
        for (String memberName : memberNameList) {
            log("  " + memberName);
            assertNotNull(memberName);
            assertTrue(memberName.startsWith("S"));
        }
    }

    // -----------------------------------------------------
    //                                                Paging
    //                                                ------
    /**
     * o 外だしSQLの手動ページング検索: outsideSql().manualPaging().selectPage(). <br />
     * 最大購入価格の会員一覧を検索。
     */
    public void test_outsideSql_manualPaging_selectPage() {
        // ## Arrange ##
        PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();

        // ## Act ##
        int pageSize = 3;
        pmb.paging(pageSize, 1); // 1st page
        PagingResultBean<PurchaseMaxPriceMember> page1 = memberBhv.outsideSql().manualPaging().selectPage(pmb);

        pmb.paging(pageSize, 2); // 2nd page
        PagingResultBean<PurchaseMaxPriceMember> page2 = memberBhv.outsideSql().manualPaging().selectPage(pmb);

        pmb.paging(pageSize, 3); // 3rd page
        PagingResultBean<PurchaseMaxPriceMember> page3 = memberBhv.outsideSql().manualPaging().selectPage(pmb);

        pmb.paging(pageSize, page1.getAllPageCount()); // latest page
        PagingResultBean<PurchaseMaxPriceMember> lastPage = memberBhv.outsideSql().manualPaging().selectPage(pmb);

        // ## Assert ##
        showPage(page1, page2, page3, lastPage);
        assertEquals(3, page1.size());
        assertEquals(3, page2.size());
        assertEquals(3, page3.size());
        assertNotSame(page1.get(0).getMemberId(), page2.get(0).getMemberId());
        assertNotSame(page2.get(0).getMemberId(), page3.get(0).getMemberId());
        assertEquals(1, page1.getCurrentPageNumber());
        assertEquals(2, page2.getCurrentPageNumber());
        assertEquals(3, page3.getCurrentPageNumber());
        assertEquals(page1.getAllRecordCount(), page2.getAllRecordCount());
        assertEquals(page2.getAllRecordCount(), page3.getAllRecordCount());
        assertEquals(page1.getAllPageCount(), page2.getAllPageCount());
        assertEquals(page2.getAllPageCount(), page3.getAllPageCount());
        assertFalse(page1.isExistPrePage());
        assertTrue(page1.isExistNextPage());
        assertTrue(lastPage.isExistPrePage());
        assertFalse(lastPage.isExistNextPage());

        // 【補足】
        // A. 手動ページングでは、SQL上でページングの絞り込み条件を記述する必要あり (limit, offset など)
        // B. 自動ページングよりもパフォーマンスの面で優位になる可能性があるのでこちらがオススメ
    }

    /**
     * o 外だしSQLの自動ページング検索: outsideSql().autoPaging().selectPage(). <br />
     * 未払い合計金額の会員一覧を検索。
     */
    public void test_outsideSql_autoPaging_selectPage() {
        // ## Arrange ##
        UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberStatusCode_正式会員();

        // ## Act ##
        int pageSize = 3;
        pmb.paging(pageSize, 1); // 1st page
        PagingResultBean<UnpaidSummaryMember> page1 = memberBhv.outsideSql().autoPaging().selectPage(pmb);

        pmb.paging(pageSize, 2); // 2nd page
        PagingResultBean<UnpaidSummaryMember> page2 = memberBhv.outsideSql().autoPaging().selectPage(pmb);

        pmb.paging(pageSize, 3); // 3rd page
        PagingResultBean<UnpaidSummaryMember> page3 = memberBhv.outsideSql().autoPaging().selectPage(pmb);

        pmb.paging(pageSize, page1.getAllPageCount()); // latest page
        PagingResultBean<UnpaidSummaryMember> lastPage = memberBhv.outsideSql().autoPaging().selectPage(pmb);

        // ## Assert ##
        showPage(page1, page2, page3, lastPage);
        assertEquals(3, page1.size());
        assertEquals(3, page2.size());
        assertEquals(3, page3.size());
        assertNotSame(page1.get(0).getUnpaidManId(), page2.get(0).getUnpaidManId());
        assertNotSame(page2.get(0).getUnpaidManId(), page3.get(0).getUnpaidManId());
        assertEquals(1, page1.getCurrentPageNumber());
        assertEquals(2, page2.getCurrentPageNumber());
        assertEquals(3, page3.getCurrentPageNumber());
        assertEquals(page1.getAllRecordCount(), page2.getAllRecordCount());
        assertEquals(page2.getAllRecordCount(), page3.getAllRecordCount());
        assertEquals(page1.getAllPageCount(), page2.getAllPageCount());
        assertEquals(page2.getAllPageCount(), page3.getAllPageCount());
        assertFalse(page1.isExistPrePage());
        assertTrue(page1.isExistNextPage());
        assertTrue(lastPage.isExistPrePage());
        assertFalse(lastPage.isExistNextPage());

        // 【補足】
        // A. 自動ページングであれば、SQL上でページングの絞り込み条件が不要
        // B. ただ、パフォーマンス的には手動ページングを使うのがオススメ
    }

    // -----------------------------------------------------
    //                                                Entity
    //                                                ------
    /**
     * o 外だしSQLで一件検索: outsideSql().entitnHandling().selectEntity(). <br />
     */
    public void test_outsideSql_selectEntity_selectUnpaidSummaryMember() {
        // ## Arrange ##
        UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberId(3);

        // ## Act ##
        UnpaidSummaryMember member = memberBhv.outsideSql().entityHandling().selectEntity(pmb);

        // ## Assert ##
        log("unpaidSummaryMember=" + member);
        assertNotNull(member);
        assertEquals(3, member.getUnpaidManId().intValue());

        // 【補足】
        // A. 存在しないIDを指定した場合はnullが戻る。
        // B. 結果が複数件の場合は例外発生。{EntityDuplicatedException}
    }

    /**
     * o 外だしSQLでチェック付き一件検索: outsideSql().entitnHandling().selectEntityWithDeletedCheck(). <br />
     */
    public void test_outsideSql_selectEntityWithDeletedCheck_selectUnpaidSummaryMember() {
        // ## Arrange ##
        UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberId(99999);

        // ## Act ##
        try {
            memberBhv.outsideSql().entityHandling().selectEntityWithDeletedCheck(pmb);

            // ## Assert ##
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }

        // 【Description】
        // A. 存在しないIDを指定した場合は例外発生。{EntityAlreadyDeletedException}
        // B. 結果が複数件の場合は例外発生。{EntityDuplicatedException}
    }

    /**
     * o 外だしSQLでカラム一つだけの一件検索: outsideSql().entitnHandling().selectEntity(). <br />
     */
    public void test_outsideSql_selectEntityWithDeletedCheck_selectLatestFormalizedDatetime() {
        // ## Arrange ##
        LatestFormalizedDatetimePmb pmb = new LatestFormalizedDatetimePmb();

        // ## Act ##
        Timestamp maxValue = memberBhv.outsideSql().entityHandling().selectEntityWithDeletedCheck(pmb);

        // ## Assert ##
        log("maxValue=" + maxValue);
        assertNotNull(maxValue);
    }
}
