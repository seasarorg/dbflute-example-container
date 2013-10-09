package com.example.dbflute.cdi.dbflute.howto.jp;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.ScalarQuery;
import org.seasar.dbflute.exception.EntityAlreadyDeletedException;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.cbean.PurchaseCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.LatestFormalizedDatetimePmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.MemberNamePmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.OptionMemberPmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.PurchaseMaxPriceMemberPmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.UnpaidSummaryMemberPmb;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.dbflute.exentity.Purchase;
import com.example.dbflute.cdi.dbflute.exentity.customize.OptionMember;
import com.example.dbflute.cdi.dbflute.exentity.customize.PurchaseMaxPriceMember;
import com.example.dbflute.cdi.dbflute.exentity.customize.UnpaidSummaryMember;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * Behaviorの中級編Example実装。
 * <pre>
 * ターゲットは以下の通り：
 *   o DBFluteってどういう機能があるのかを探っている方
 *   o DBFluteで実装を開始する方・実装している方
 *
 * コンテンツは以下の通り：
 *   o ページング検索: selectPage().
 *   o カラムの最大値検索(ScalarSelect): scalarSelect(), max().
 *   o one-to-many検索(LoadReferrer): loadXxxList().
 *   o 一件登録もしくは排他制御ありの一件更新: insertOrUpdate().
 *   o 一件登録もしくは排他制御なし一件更新: insertOrUpdateNonstrict().
 *   o Queryを使った更新: queryUpdate().
 *   o Queryを使った削除: queryDelete().
 *   o 外だしSQLでカラム一つだけのリスト検索: outsideSql().selectList().
 *   o 外だしSQLでエスケープ付き曖昧検索: outsideSql().selectList().
 *   o 外だしSQLで日付のFromTo検索: outsideSql().selectList().
 *   o 外だしSQLの手動ページング検索: outsideSql().manualPaging().selectPage().
 *   o 外だしSQLの自動ページング検索: outsideSql().autoPaging().selectPage().
 *   o 外だしSQLで一件検索: outsideSql().entitnHandling().selectEntity().
 *   o 外だしSQLでチェック付き一件検索: outsideSql().entitnHandling().selectEntityWithDeletedCheck().
 *   o 外だしSQLでカラム一つだけの一件検索: outsideSql().entitnHandling().selectEntity().
 * </pre>
 * @author jflute
 * @since 0.7.3 (2008/05/31 Saturday)
 */
public class BehaviorMiddleTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Component) */
    @Inject
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                 Paging(Page Select)
    //                                                                 ===================
    /**
     * ページング検索: selectPage().
     * 会員名称の昇順のリストを「１ページ４件」の「３ページ目」(９件目から１２件目)を検索。
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
    @Test
    @Transactional
    public void test_selectPage_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        cb.paging(4, 3);// The page size is 4 records per 1 page, and The page number is 3.

        // ## Act ##
        final PagingResultBean<Member> page3 = this.memberBhv.selectPage(cb);

        // ## Assert ##
        assertNotSame(0, page3.size());
        this.log("PagingResultBean.toString():" + getLineSeparator() + " " + page3);
        for (final Member member : page3) {
            this.log(member.toString());
        }
        this.log("allRecordCount=" + page3.getAllRecordCount());
        this.log("allPageCount=" + page3.getAllPageCount());
        this.log("currentPageNumber=" + page3.getCurrentPageNumber());
        this.log("currentStartRecordNumber=" + page3.getCurrentStartRecordNumber());
        this.log("currentEndRecordNumber=" + page3.getCurrentEndRecordNumber());
        this.log("isExistPrePage=" + page3.isExistPrePage());
        this.log("isExistNextPage=" + page3.isExistNextPage());

        // [Description]
        // A. paging()メソッドはDBFlute-0.7.3よりサポート。
        //    DBFlute-0.7.2までは以下の通り：
        //      fetchFirst(4);
        //      fetchPage(3);
        //
        // B. paging()メソッド第一引数のpageSizeは、マイナス値や０が指定されると例外発生
        //    --> 基本的にシステムで固定で指定する値であるため
        //
        // C. paging()メソッド第二引数のpageNumberは、マイナス値や０を指定されると「１ページ目」として扱われる。
        //    --> 基本的に画面リクエストの値で、予期せぬ数値が来る可能性があるため。
        //
        //    ※関連して、総ページ数を超えるページ番号が指定された場合は「最後のページ」として扱われる。
        //     (但し、ここは厳密にはpaging()の機能ではなくselectPage()の機能である)
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * カラムの最大値検索(ScalarSelect): scalarSelect(), max().
     * 正式会員で一番最近(最大)の誕生日を検索。
     * @since 0.8.6
     */
    @Test
    @Transactional
    public void test_scalarSelect_max_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.specify().columnBirthdate();
        cb.query().setMemberStatusCode_Equal_正式会員();
        cb.query().setBirthdate_IsNotNull();
        cb.query().addOrderBy_Birthdate_Desc();
        cb.fetchFirst(1);
        final Date expected = this.memberBhv.selectEntityWithDeletedCheck(cb).getBirthdate();

        // ## Act ##
        final Date birthday = this.memberBhv.scalarSelect(Date.class).max(new ScalarQuery<MemberCB>() {
            public void query(final MemberCB cb) {
                cb.specify().columnBirthdate(); // *Point!
                cb.query().setMemberStatusCode_Equal_正式会員();
            }
        });

        // ## Assert ##
        assertEquals(expected, birthday);

        // [Description]
        // A. max()/min()/sum()/avg()をサポート
        // B. サポートされない型を指定された場合は例外発生(例えばsum()に日付型を指定など)
        // C. コールバックのConditionBeanにて対象のカラムを指定。
        //    --> 必ず「一つだけ」を指定すること(無しもしくは複数の場合は例外発生)
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * one-to-many検索(LoadReferrer): loadXxxList().
     * 検索した会員リストに対して、会員毎の購入カウントが２件以上の購入リストを購入カウントの降順でロード。
     * 子テーブル(Referrer)を取得する「一発」のSQLを発行してマッピングをする(SubSelectフェッチ)。
     * DBFluteではこのone-to-manyをロードする機能を「LoadReferrer」と呼ぶ。
     */
    @Test
    @Transactional
    public void test_loadReferrer_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // At first, it selects the list of Member.
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Act ##
        // And it loads the list of Purchase with its conditions.
        this.memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB cb) {
                cb.query().setPurchaseCount_GreaterEqual(2);
                cb.query().addOrderBy_PurchaseCount_Desc();
            }
        });

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("[MEMBER]: " + member.getMemberName());
            final List<Purchase> purchaseList = member.getPurchaseList();// *Point!
            for (final Purchase purchase : purchaseList) {
                this.log("    [PURCHASE]: " + purchase.toString());
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

        // [Description]
        // A. 基点テーブルが複合PKの場合はサポートされない。
        //    --> このExampleでは会員テーブル。もし複合PKならloadPurchaseList()メソッド自体が生成されない。
        // B. SubSelectフェッチなので「n+1問題」は発生しない。
        // C. 枝分かれの子テーブルを取得することも可能。
        // D. 子テーブルの親テーブルを取得することも可能。詳しくはBehaviorPlatinumTestにて
        // E. 子テーブルの子テーブル(孫テーブル)を取得することも可能。詳しくはBehaviorPlatinumTestにて
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    // -----------------------------------------------------
    //                                        InsertOrUpdate
    //                                        --------------
    /**
     * 一件登録もしくは排他制御ありの一件更新: insertOrUpdate().
     */
    @Test
    @Transactional
    public void test_insertOrUpdate_Tx() {
        // ## Arrange ##
        final Member member = new Member();
        member.setMemberName("testName");
        member.setMemberAccount("testAccount");
        member.setMemberStatusCode_正式会員();

        // ## Act ##
        this.memberBhv.insertOrUpdate(member);
        member.setMemberName("testName2");
        this.memberBhv.insertOrUpdate(member);

        // ## Assert ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(member.getMemberId());
        final Member actual = this.memberBhv.selectEntityWithDeletedCheck(cb);
        this.log(actual);
        assertEquals("testName2", actual.getMemberName());

        // [Description]
        // A. 登録処理はinsert()、更新処理はupdate()に委譲する。
        // B. PKの値が存在しない場合は、自動採番と判断し問答無用で登録処理となる。
        // C. PK値が存在する場合は、先に更新処理をしてから結果を判断して登録処理をする。
    }

    /**
     * 一件登録もしくは排他制御なし一件更新: insertOrUpdateNonstrict().
     */
    @Test
    @Transactional
    public void test_insertOrUpdateNonstrict_Tx() {
        // ## Arrange ##
        final Member member = new Member();
        member.setMemberName("testName");
        member.setMemberAccount("testAccount");
        member.setMemberStatusCode_正式会員();

        // ## Act ##
        this.memberBhv.insertOrUpdateNonstrict(member);
        member.setMemberName("testName2");
        member.setVersionNo(null);
        this.memberBhv.insertOrUpdateNonstrict(member);

        // ## Assert ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(member.getMemberId());
        final Member actual = this.memberBhv.selectEntityWithDeletedCheck(cb);
        this.log(actual);
        assertEquals("testName2", actual.getMemberName());

        // [Description]
        // A. 登録処理はinsert()、更新処理はupdateNonstrict()に委譲する。
        // B. PKの値が存在しない場合は、自動採番と判断し問答無用で登録処理となる。
        // C. PK値が存在する場合は、先に更新処理をしてから結果を判断して登録処理をする。
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Queryを使った更新: queryUpdate().
     * 会員ステータスが正式会員の会員を全て仮会員にする。
     * ConditionBeanで設定した条件で一括削除が可能である。(排他制御はない)
     * @since 0.7.5
     */
    @Test
    @Transactional
    public void test_queryUpdate_Tx() {
        // ## Arrange ##
        final Member member = new Member();
        member.setMemberStatusCode_仮会員();
        member.setFormalizedDatetime(null);// 正式会員日時を「null」に

        final MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_正式会員();// 正式会員

        // ## Act ##
        final int updatedCount = this.memberBhv.queryUpdate(member, cb);

        // ## Assert ##
        assertNotSame(0, updatedCount);
        final MemberCB actualCB = new MemberCB();
        actualCB.query().setMemberStatusCode_Equal_仮会員();
        actualCB.query().setFormalizedDatetime_IsNull();
        actualCB.query().setUpdateUser_Equal(this.accessUser);// Common Column
        final ListResultBean<Member> actualList = this.memberBhv.selectList(actualCB);
        assertEquals(actualList.size(), updatedCount);

        // [Description]
        // A. 条件として、結合先のカラムによる条件やexists句を使ったサブクエリーなども利用可能。
        // B. setupSelect_Xxx()やaddOrderBy_Xxx()を呼び出しても意味はない。
        // C. 排他制御はせずに問答無用で更新する。(バージョンNOは自動インクリメント)
        // D. 更新結果が0件でも特に例外は発生しない。
        // E. 共通カラム(CommonColumn)の自動設定は有効。
    }

    /**
     * Queryを使った削除: queryDelete().
     * 会員ステータスが正式会員の会員を全て削除する。
     * ConditionBeanで設定した条件で一括削除が可能である。(排他制御はない)
     */
    @Test
    @Transactional
    public void test_queryDelete_Tx() {
        // ## Arrange ##
        this.deleteMemberReferrer();// for Test

        final MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_正式会員();// 正式会員

        // ## Act ##
        final int deletedCount = this.memberBhv.queryDelete(cb);

        // ## Assert ##
        assertNotSame(0, deletedCount);
        assertEquals(0, this.memberBhv.selectCount(cb));

        // [Description]
        // A. 条件として、結合先のカラムによる条件やexists句を使ったサブクエリーなども利用可能。
        // B. setupSelect_Xxx()やaddOrderBy_Xxx()を呼び出しても意味はない。
        // C. 排他制御はせずに問答無用で削除する。
        // D. 削除結果が0件でも特に例外は発生しない。
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

    /**
     * 外だしSQLでカラム一つだけのリスト検索: outsideSql().selectList().
     */
    @Test
    @Transactional
    public void test_outsideSql_selectList_selectMemberName_Tx() {
        // ## Arrange ##
        final MemberNamePmb pmb = new MemberNamePmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        final List<String> memberNameList = this.memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertNotSame(0, memberNameList.size());
        this.log("{MemberName}");
        for (final String memberName : memberNameList) {
            this.log("    " + memberName);
            assertNotNull(memberName);
            assertTrue(memberName.startsWith("S"));
        }
    }

    // -----------------------------------------------------
    //                                                Option
    //                                                ------
    /**
     * 外だしSQLでエスケープ付き曖昧検索: outsideSql().selectList().
     * ParameterBeanの定義にて、
     * オプション「:like, :likePrefix, :likeContain, :likeSuffix」
     * のいずれかを付与すると利用可能になる。
     * <pre>
     * -- !df:pmb!
     * -- !!Integer memberId!!
     * -- !!String memberName:likePrefix!!
     * </pre>
     */
    @Test
    @Transactional
    public void test_outsideSql_selectList_selectOptionMember_LikeSearch_Tx() {
        // ## Arrange ##
        // テストのためにワイルドカード含みのテスト会員を作成
        final Member testMember1 = new Member();
        testMember1.setMemberId(1);
        testMember1.setMemberName("ストイコ100%ビッチ_その１");
        this.memberBhv.updateNonstrict(testMember1);
        final Member testMember4 = new Member();
        testMember4.setMemberId(4);
        testMember4.setMemberName("ストイコ100%ビッチ_その４");
        this.memberBhv.updateNonstrict(testMember4);

        final OptionMemberPmb pmb = new OptionMemberPmb();
        pmb.setMemberName_PrefixSearch("ストイコ100%ビッチ_その");

        // ## Act ##
        final List<OptionMember> memberList = this.memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertNotSame("テストの成立のため１件以上は必ずあること: " + memberList.size(), 0, memberList.size());
        this.log("{OptionMember}");
        for (final OptionMember member : memberList) {
            final Integer memberId = member.getMemberId();
            final String memberName = member.getMemberName();
            final String memberStatusName = member.getMemberStatusName();

            // Sql2EntityでもClassification機能が利用可能
            final boolean formalized = member.isMemberStatusCode正式会員();
            final boolean dummyFlg = member.isDummyFlgTrue();
            this.log("    " + memberId + ", " + memberName + ", " + memberStatusName + ", " + formalized + dummyFlg);
            try {
                member.getClass().getMethod("isDummyNoflgTrue", new Class[] {});
                fail("The method 'isDummyNoflgTrue' must not exist!");
            } catch (final SecurityException e) {
                throw new IllegalStateException(e);
            } catch (final NoSuchMethodException e) {
                // OK
            }
            assertNotNull(memberId);
            assertNotNull(memberName);
            assertNotNull(memberStatusName);
            assertTrue(memberName.startsWith("ストイコ100%ビッチ_その"));
        }

        // [Description]
        // A. 外だしSQLにおいては、LikeSearchOptionはlikeXxx()のみ利用可能。
        // B. likeXxx()を指定すると自動でエスケープ処理が施される。
        // C. CustomizeEntity(Sql2Entityで生成したEntity)でも区分値機能は利用可能。
    }

    /**
     * 外だしSQLで日付のFromTo検索: outsideSql().selectList().
     * ParameterBeanの定義にて、オプション「:fromDate, :toDate」を付与すると利用可能になる。
     * <pre>
     * -- !df:pmb!
     * -- !!Integer memberId!!
     * -- !!Date fromFormalizedDate:fromDate!!
     * -- !!Date toFormalizedDate:toDate!!
     * </pre>
     */
    @Test
    @Transactional
    public void test_outsideSql_selectList_selectOptionMember_DateFromTo_Tx() {
        // ## Arrange ##
        final String firstDate = "2003-02-25";
        final String lastDate = "2006-09-04";
        final String lastNextDate = "2006-09-05";
        final OptionMemberPmb pmb = new OptionMemberPmb();
        pmb.setFromFormalizedDate_FromDate(DfTypeUtil.toTimestamp("2003-02-25"));
        pmb.setToFormalizedDate_ToDate(DfTypeUtil.toTimestamp(lastDate));

        // ## Act ##
        final List<OptionMember> memberList = this.memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        boolean existsLastDate = false;
        for (final OptionMember member : memberList) {
            final String memberName = member.getMemberName();
            final Timestamp formalizedDatetime = member.getFormalizedDatetime();
            this.log(memberName + ", " + formalizedDatetime);
            if (DfTypeUtil.toString(formalizedDatetime, "yyyy-MM-dd").equals(lastDate)) {
                existsLastDate = true;
            }
        }
        assertEquals(firstDate, DfTypeUtil.toString(pmb.getFromFormalizedDate(), "yyyy-MM-dd"));
        assertEquals(lastNextDate, DfTypeUtil.toString(pmb.getToFormalizedDate(), "yyyy-MM-dd"));
        assertTrue(existsLastDate);
    }

    // -----------------------------------------------------
    //                                                Paging
    //                                                ------
    /**
     * 外だしSQLの手動ページング検索: outsideSql().manualPaging().selectPage().
     * 最大購入価格の会員一覧を検索。
     * <pre>
     * ParameterBean.paging(pageSize, pageNumber)にてページング条件を指定：
     *   o pageSize : ページサイズ(１ページあたりのレコード数)
     *   o pageNumber : ページ番号(検索する対象のページ)
     *
     *   ※SQL上のParameterBeanの定義にて、以下のようにSimplePagingBeanを継承すること。
     *      -- !XxxPmb extends SPB!
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
     *   o ページングナビゲーション要素ページリスト
     *   o などなど
     * </pre>
     */
    @Test
    @Transactional
    @SuppressWarnings("unchecked")
    public void test_outsideSql_manualPaging_selectPage_Tx() {
        // ## Arrange ##
        // 検索条件(絞り込み条件は特になし)
        final PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();

        // ## Act ##
        // SQL実行！
        final int pageSize = 3;
        pmb.paging(pageSize, 1);// 1st page
        final PagingResultBean<PurchaseMaxPriceMember> page1 = this.memberBhv.outsideSql().manualPaging()
                .selectPage(pmb);

        pmb.paging(pageSize, 2);// 2st page
        final PagingResultBean<PurchaseMaxPriceMember> page2 = this.memberBhv.outsideSql().manualPaging()
                .selectPage(pmb);

        pmb.paging(pageSize, 3);// 3st page
        final PagingResultBean<PurchaseMaxPriceMember> page3 = this.memberBhv.outsideSql().manualPaging()
                .selectPage(pmb);

        pmb.paging(pageSize, page1.getAllPageCount());// latest page
        final PagingResultBean<PurchaseMaxPriceMember> lastPage = this.memberBhv.outsideSql().manualPaging()
                .selectPage(pmb);

        // ## Assert ##
        this.showPage(page1, page2, page3, lastPage);
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

        // [Description]
        // A. paging()メソッドはDBFlute-0.7.3よりサポート。
        //    DBFlute-0.7.2までは以下の通り：
        //      pmb.fetchFirst(3);
        //      pmb.fetchPage(1);
        //
        // B. 自動ページングをしたい場合は以下の通り。
        //   1. SQL上でページング絞り条件を削除
        //   2. manualPaging()をautoPaging()に変更
        //
        // X. ConditionBeanと外だしSQLの境目ポイント！ {上級編}
        //    o ページング絞りをSQLで行うのはConditionBeanで可能
        //      --> ConditionBeanのページングはSQLでのページング絞りを実現
        //
        //    o Select句の相関サブクエリで子テーブルのmax()はConditionBeanで可能
        //      --> SpecifyDerivedReferrerを利用(詳しくはConditionBeanPlatinumTestにて)
        //
        //    o Select句の相関サブクエリで導出した値で並び替えるのはConditionBeanで可能
        //      --> SpecifyDerivedReferrerで利用(詳しくはConditionBeanPlatinumTestにて)
        //
        //        ※実はこの例題のSQLはConditionBeanで実装可能
        //        /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        //        MemberCB cb = new MemberCB();
        //        cb.setupSelect_MemberStatus();
        //        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
        //            public void query(PurchaseCB subCB) {
        //                subCB.specify().columnPurchasePrice();
        //                subCB.query().setPaymentCompleteFlg_Equal_False();
        //            }
        //        }, "PURCHASE_MAX_PRICE");
        //        cb.query().setMemberId_Equal(3);
        //        cb.query().setMemberName_PrefixSearch("S");
        //        cb.query().addSpecifiedDerivedOrderBy_Desc("PURCHASE_MAX_PRICE");
        //        cb.query().addOrderBy_MemberId_Asc();
        //        cb.paging(3, 1);
        //        PagingResultBean<Member> page = memberBhv.selectPage(cb);
        //        - - - - - - - - - -/
    }

    /**
     * 外だしSQLの自動ページング検索: outsideSql().autoPaging().selectPage().
     * 未払い合計金額の会員一覧を検索。
     * <pre>
     * ParameterBean.paging(pageSize, pageNumber)にてページング条件を指定：
     *   o pageSize : ページサイズ(１ページあたりのレコード数)
     *   o pageNumber : ページ番号(検索する対象のページ)
     *
     *   ※SQL上のParameterBeanの定義にて、以下のようにSimplePagingBeanを継承すること。
     *      -- !XxxPmb extends SPB!
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
     *   o ページングナビゲーション要素ページリスト
     *   o などなど
     * </pre>
     */
    @Test
    @Transactional
    @SuppressWarnings("unchecked")
    public void test_outsideSql_autoPaging_selectPage_Tx() {
        // ## Arrange ##
        final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberStatusCode_正式会員();// 正式会員

        // ## Act ##
        // SQL実行！
        final int pageSize = 3;
        pmb.paging(pageSize, 1);// 1st page
        final PagingResultBean<UnpaidSummaryMember> page1 = this.memberBhv.outsideSql().autoPaging().selectPage(pmb);

        pmb.paging(pageSize, 2);// 2st page
        final PagingResultBean<UnpaidSummaryMember> page2 = this.memberBhv.outsideSql().autoPaging().selectPage(pmb);

        pmb.paging(pageSize, 3);// 3st page
        final PagingResultBean<UnpaidSummaryMember> page3 = this.memberBhv.outsideSql().autoPaging().selectPage(pmb);

        pmb.paging(pageSize, page1.getAllPageCount());// latest page
        final PagingResultBean<UnpaidSummaryMember> lastPage = this.memberBhv.outsideSql().autoPaging().selectPage(pmb);

        // ## Assert ##
        this.showPage(page1, page2, page3, lastPage);
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

        // [Description]
        // A. paging()メソッドはDBFlute-0.7.3よりサポート。
        //    DBFlute-0.7.2までは以下の通り：
        //      pmb.fetchFirst(3);
        //      pmb.fetchPage(1);
        //
        // B. 手動ページングをしたい場合は以下の通り。
        //   1. SQL上でページング絞り条件を記述
        //      /*IF pmb.isPaging()*/
        //      limit /*$pmb.pageStartIndex*/80, /*$pmb.fetchSize*/20
        //      /*END*/
        //
        //   2. autoPaging()をmanualPaging()に変更
        //      memberBhv.outsideSql().manualPaging().selectPage(...);
        //
        // C. カーソルタイプは「INSENSITIVE」でスキップ処理でResultSet.absolute()を利用。
        //    --> ループでぐるぐる回すわけではない。*但しカーソルをサポートしているDBのみ
        //
        // D. ParameterBeanでも区分値機能は利用可能 {上級編}
        //    : member.isMemberStatusCode正式会員()
        //
        //    ParameterBeanにて
        //    -- !!String memberStatusCode:cls(MemberStatus)!!
        //    と指定
        //
        // X. ConditionBeanと外だしSQLの境目ポイント！ {上級編}
        //    o Select句の相関サブクエリで子テーブルのsum()はConditionBeanで可能
        //      --> SpecifyDerivedReferrerを利用(詳しくはConditionBeanPlatinumTestにて)
        //
        //    o Select句の相関サブクエリで導出した値で並び替えるのはConditionBeanで可能
        //      --> SpecifyDerivedReferrerで利用(詳しくはConditionBeanPlatinumTestにて)
        //
        //    o Where句の相関サブクエリで子テーブルの条件で絞り込みをするのはConditionBeanで可能
        //      --> ExistsSubQueryを利用(詳しくはConditionBeanMiddleTestにて)
        //
        //    o Select句の相関サブクエリで導出した値で絞り込みをするのは外だしSQL
        //      --> 今回の例題では導出値を利用した絞り込みはやっていない
        //
        //        ※実はこの例題のSQLはConditionBeanで実装可能
        //        /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        //        MemberCB cb = new MemberCB();
        //        cb.setupSelect_MemberStatus();
        //        cb.specify().derivedPurchaseList().sum(new SubQuery<PurchaseCB>() {
        //            public void query(PurchaseCB subCB) {
        //                subCB.specify().columnPurchasePrice();
        //                subCB.query().setPaymentCompleteFlg_Equal_False();
        //            }
        //        }, "UNPAID_PRICE_SUMMARY");
        //        cb.query().setMemberId_Equal(3);
        //        cb.query().setMemberName_PrefixSearch("S");
        //        cb.query().setMemberStatusCode_NotEqual_正式会員();
        //        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
        //            public void query(PurchaseCB subCB) {
        //                subCB.query().setPaymentCompleteFlg_Equal_False();
        //            }
        //        });
        //        cb.query().addSpecifiedDerivedOrderBy_Desc("UNPAID_PRICE_SUMMARY");
        //        cb.query().addOrderBy_MemberId_Asc();
        //        cb.paging(3, 1);
        //        PagingResultBean<Member> page = memberBhv.selectPage(cb);
        //        - - - - - - - - - -/
    }

    // -----------------------------------------------------
    //                                                Entity
    //                                                ------
    /**
     * 外だしSQLで一件検索: outsideSql().entitnHandling().selectEntity().
     */
    @Test
    @Transactional
    public void test_outsideSql_selectEntity_selectUnpaidSummaryMember_Tx() {
        // ## Arrange ##
        final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberId(3);

        // ## Act ##
        final UnpaidSummaryMember member = this.memberBhv.outsideSql().entityHandling().selectEntity(pmb);

        // ## Assert ##
        this.log("unpaidSummaryMember=" + member);
        assertNotNull(member);
        assertEquals(3, member.getUnpaidManId().intValue());

        // [Description]
        // A. 存在しないIDを指定した場合はnullが戻る。
        // B. 結果が複数件の場合は例外発生。{EntityDuplicatedException}
    }

    /**
     * 外だしSQLでチェック付き一件検索: outsideSql().entitnHandling().selectEntityWithDeletedCheck().
     */
    @Test
    @Transactional
    public void test_outsideSql_selectEntityWithDeletedCheck_selectUnpaidSummaryMember_Tx() {
        // ## Arrange ##
        final UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberId(99999);

        // ## Act & Assert ##
        try {
            this.memberBhv.outsideSql().entityHandling().selectEntityWithDeletedCheck(pmb);
            fail();
        } catch (final EntityAlreadyDeletedException e) {
            // OK
            this.log(e.getMessage());
        }

        // 【Description】
        // A. 存在しないIDを指定した場合は例外発生。{EntityAlreadyDeletedException}
        // B. 結果が複数件の場合は例外発生。{EntityDuplicatedException}
    }

    /**
     * 外だしSQLでカラム一つだけの一件検索: outsideSql().entitnHandling().selectEntity().
     */
    @Test
    @Transactional
    public void test_outsideSql_SelectEntityWithDeletedCheck_selectLatestFormalizedDatetime_Tx() {
        // ## Arrange ##
        final LatestFormalizedDatetimePmb pmb = new LatestFormalizedDatetimePmb();

        // ## Act ##
        final Timestamp maxValue = this.memberBhv.outsideSql().entityHandling().selectEntity(pmb);

        // ## Assert ##
        this.log("maxValue=" + maxValue);
        assertNotNull(maxValue);
    }
}
