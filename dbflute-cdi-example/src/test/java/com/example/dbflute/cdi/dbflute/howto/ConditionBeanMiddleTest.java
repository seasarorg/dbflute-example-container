package com.example.dbflute.cdi.dbflute.howto;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.cdi.dbflute.cbean.PurchaseCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.dbflute.exentity.MemberWithdrawal;
import com.example.dbflute.cdi.dbflute.exentity.Product;
import com.example.dbflute.cdi.dbflute.exentity.ProductStatus;
import com.example.dbflute.cdi.dbflute.exentity.Purchase;
import com.example.dbflute.cdi.dbflute.exentity.WithdrawalReason;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * ConditionBeanの中級編Example実装。
 * <pre>
 * ターゲットは以下の通り：
 *   o DBFluteってどういう機能があるのかを探っている方
 *   o DBFluteで実装を開始する方・実装している方
 *
 * コンテンツは以下の通り：
 *   o many(one)-to-one-to-one(親の親)を結合して取得する検索: setupSelect_Xxx().withXxx().
 *   o many(one)-to-one-to-one-to-one(親の親の親)を結合して取得する検索: setupSelect_Xxx().withXxx().withXxx().
 *   o Query-Equal条件で区分値機能を使ってタイプセーフに区分値を指定: setXxx_Equal_Xxx().
 *   o Query-NotEqual条件: setXxx_NotEqual().
 *   o Query-NotEqual条件で区分値機能でタイプセーフに区分値を指定: setXxx_NotEqual_Xxx().
 *   o Query-GreaterThan条件: setXxx_GreaterThan().
 *   o Query-GreaterEqual条件: setXxx_GreaterEqual().
 *   o Query-LessThan条件: setXxx_LessThan().
 *   o Query-LessEqual条件: setXxx_LessEqual().
 *   o Query-PrefixSearch条件(前方一致): setXxx_PrefixSearch().
 *   o Query-InScope条件(in ('a', 'b')): setXxx_InScope().
 *   o Query-NotInScope条件(not in ('a', 'b')): setXxx_NotInScope().
 *   o Query-LikeSearch条件の前方一致: setXxx_LikeSearch(), option.likePrefix().
 *   o Query-LikeSearch条件の中間一致: setXxx_LikeSearch(), option.likeContain().
 *   o Query-LikeSearch条件の後方一致: setXxx_LikeSearch(), option.likeSuffix().
 *   o Query-LikeSearch条件のエスケープ付き曖昧検索: setXxx_LikeSearch().
 *   o Query-NotLikeSearch条件の前方一致: setXxx_NotLikeSearch(), option.likePrefix().
 *   o Query-ExistsReferrerで子テーブルの条件で絞り込み: cb.query().existsXxxList().
 *   o Query-ExistsReferrerでmany-to-manyの関係のテーブルの条件で絞り込み: cb.query().existsXxxList().
 *   o Query-ExistsReferrerで親テーブルの子テーブル(兄弟テーブル)の条件で絞り込み: cb.query().queryXxx().existsYyyList().
 *   o Query-NotExistsReferrerで子テーブルの条件で絞り込み: cb.query().notExistsXxxList().
 *   o Query-InScopeRelationで子テーブルの条件で絞り込み: cb.query().inScopeXxxList().
 *   o Query-InScopeRelationでmany-to-manyの関係のテーブルの条件で絞り込み: cb.query().inScopeXxxList().
 *   o Query-NotInScopeRelationで子テーブルの条件で絞り込み: cb.query().notInScopeXxxList().
 *   o Query-DateFromTo(日付の範囲検索): query().setXxx_DateFromTo().
 *   o Union(Or条件の代替): union().
 *   o UnionAll(Or条件の代替): unionAll().
 *   o ページング検索: cb.paging(pageSize, pageNumber).
 *   o 先頭のn件を検索: cb.fetchFirst(fetchSize).
 *   o 更新ロックを取得: cb.lockForUpdate().
 *   o ConditionBeanで組み立てたSQLをログに表示: toDisplaySql().
 *   o ConditionBeanで組み立てたSQLをログに表示(SubQuery含み): toDisplaySql().
 * </pre>
 * @author jflute
 * @since 0.7.3 (2008/06/01 Sunday)
 */
public class ConditionBeanMiddleTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Object) */
    @Inject
    private MemberBhv memberBhv;

    /** The behavior of Purchase. (Injection Object) */
    @Inject
    private PurchaseBhv purchaseBhv;

    // ===================================================================================
    //                                                                         SetupSelect
    //                                                                         ===========
    /**
     * many(one)-to-one-to-one(親の親)を結合して取得する検索: setupSelect_Xxx().withXxx().
     * 「会員ステータス」と「会員退会情報」ならびに「退会理由」をSetupSelectして検索。
     */
    @Test
    @Transactional
    public void test_setupSelect_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberWithdrawalAsOne().withWithdrawalReason();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        boolean existsWithdrawalReason = false;
        for (final Member member : memberList) {
            this.log("[MEMBER]: " + member.getMemberName());
            final MemberWithdrawal memberWithdrawalAsOne = member.getMemberWithdrawalAsOne();
            if (memberWithdrawalAsOne != null) {// {1 : 0...1}の関連なのでnullチェック
                final WithdrawalReason withdrawalReason = memberWithdrawalAsOne.getWithdrawalReason();
                if (withdrawalReason != null) {// NullableなFKなのでnullチェック
                    final String withdrawalReasonCode = memberWithdrawalAsOne.getWithdrawalReasonCode();
                    final String withdrawalReasonText = withdrawalReason.getWithdrawalReasonText();
                    this.log("    [WITHDRAWAL]" + withdrawalReasonCode + " - " + withdrawalReasonText);
                    existsWithdrawalReason = true;
                } else {
                    this.log("    [WITHDRAWAL]" + memberWithdrawalAsOne);
                }
            }
        }
        assertTrue(existsWithdrawalReason);

        // [Description]
        // A. setupSelect_Xxx()した後に続いてwithXxx()と指定することでさらに上の階層を指定できる。
        // B. 指定できる階層は無限階層である。(withXxx().withXxx().withXxx()...)
    }

    /**
     * many(one)-to-one-to-one-to-one(親の親の親)を結合して取得する検索: setupSelect_Xxx().withXxx().withXxx().
     * 購入から会員、会員から会員退会情報、会員退会情報から退会理由までの３階層を結合して取得。
     * 実務ではあまりこういった検索はないと思われるが、説明材料のExampleとして実装している。
     */
    @Test
    @Transactional
    public void test_setupSelect_withForeign_withForeign_Tx() {
        // ## Arrange ##
        final PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Member().withMemberWithdrawalAsOne().withWithdrawalReason();// *Point!
        cb.setupSelect_Member().withMemberStatus();
        cb.setupSelect_Product().withProductStatus();
        cb.query().addOrderBy_PurchaseDatetime_Desc().addOrderBy_PurchaseId_Asc();

        // ## Act ##
        final ListResultBean<Purchase> purchaseList = this.purchaseBhv.selectList(cb);

        // ## Assert ##
        assertNotSame(0, purchaseList.size());
        boolean existsWithdrawal = false;
        for (final Purchase purchase : purchaseList) {
            final Product product = purchase.getProduct();
            final ProductStatus productStatus = product.getProductStatus();
            assertNotNull(product);
            assertNotNull(productStatus);
            this.log("[PURCHASE]: " + purchase.getPurchaseId() + ", " + product.getProductName() + ", " + productStatus);
            final Member member = purchase.getMember();
            assertNotNull(member);
            assertNotNull(member.getMemberStatus());

            final MemberWithdrawal memberWithdrawalAsOne = member.getMemberWithdrawalAsOne();
            if (memberWithdrawalAsOne != null) {
                final WithdrawalReason withdrawalReason = memberWithdrawalAsOne.getWithdrawalReason();
                if (withdrawalReason != null) {
                    final String reasonText = withdrawalReason.getWithdrawalReasonText();
                    this.log("    [MEMBER]: " + member.getMemberId() + ", " + member.getMemberName() + ", "
                            + reasonText);
                    assertNotNull(reasonText);
                    existsWithdrawal = true;
                }
            }
        }
        assertTrue("退会者が少なくとも一人以上は存在してないとテストにならない", existsWithdrawal);
    }

    // /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // 子テーブルの取得に関しては、BehaviorMiddleTestのLoadReferrerにて
    // - - - - - - - - - -/

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    // -----------------------------------------------------
    //                                                 Equal
    //                                                 -----
    // /- - - - - - - - - - - - - - - - - - - - - - - - - - -
    // Equalの基本的な利用に関しては、ConditionBeanBasicTestにて
    // - - - - - - - - - -/
    /**
     * Query-Equal条件で区分値機能を使ってタイプセーフに区分値を指定: setXxx_Equal_Xxx().
     * 正式会員の会員を検索。
     */
    @Test
    @Transactional
    public void test_query_setMemberStatusCode_Equal_Classification_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_正式会員();// *Point!

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            assertTrue(member.isMemberStatusCode正式会員());
        }

        // [SQL]
        // where MEMBER_STATUS_CODE = 'FML'

        // [Description]
        // 区分値定義は、DBFluteプロパティ(dfprop)の
        // 「classificationDefinitionMap.dfprop」と「classificationDeploymentMap.dfprop」
        // にて
    }

    // -----------------------------------------------------
    //                                              NotEqual
    //                                              --------
    /**
     * Query-NotEqual条件: setXxx_NotEqual().
     * 会員アカウントが「Pixy」でない会員を検索。
     */
    @Test
    @Transactional
    public void test_query_NotEqual_Tx() {
        // ## Arrange ##
        final int countAll = this.memberBhv.selectCount(new MemberCB());
        final MemberCB cb = new MemberCB();
        cb.query().setMemberAccount_NotEqual("Pixy");// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        assertEquals(countAll - 1, memberList.size());
        for (final Member member : memberList) {
            assertNotSame("Pixy", member.getMemberAccount());
        }

        // [SQL]
        // where MEMBER_ACCOUNT <> 'Pixy'

        // [Description]
        // A. 別の値で二回呼び出しても上書きになるだけなので注意。
        //    --> その場合NotInScopeを利用
        //
        // B. 数値型と日付型に関しては、EMechaやDBFluteClientテンプレートにおいて、
        //    利用頻度の少なさからデフォルトで生成されないような設定になっている。
        //    --> {DBFluteClient}/dfprop/includeQueryMap.dfprop
    }

    /**
     * Query-NotEqual条件で区分値機能でタイプセーフに区分値を指定: setXxx_NotEqual_Xxx().
     * 正式会員でない会員を検索。
     */
    @Test
    @Transactional
    public void test_query_NotEqual_Classification_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_NotEqual_正式会員();// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            assertFalse(member.isMemberStatusCode正式会員());
        }

        // [SQL]
        // where MEMBER_STATUS_CODE <> 'FML'
    }

    // -----------------------------------------------------
    //                                           GreaterThan
    //                                           -----------
    /**
     * Query-GreaterThan条件: setXxx_GreaterThan().
     * 会員ID「3」より大きい会員IDを持った会員を検索。
     */
    @Test
    @Transactional
    public void test_query_GreaterThan_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_GreaterThan(3);// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            assertTrue(member.getMemberId() > 3);
        }

        // [SQL]
        // where MEMBER_ID > 3
    }

    // -----------------------------------------------------
    //                                          GreaterEqual
    //                                          ------------
    /**
     * Query-GreaterEqual条件: setXxx_GreaterEqual().
     * 会員ID「3」以上の会員IDを持った会員を検索。
     */
    @Test
    @Transactional
    public void test_query_GreaterEqual_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_GreaterEqual(3);// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            assertTrue(member.getMemberId() >= 3);
        }

        // [SQL]
        // where MEMBER_ID >= 3
    }

    // -----------------------------------------------------
    //                                              LessThan
    //                                              --------
    /**
     * Query-LessThan条件: setXxx_LessThan().
     * 会員ID「3」より小さい会員IDを持った会員を検索。
     */
    @Test
    @Transactional
    public void test_query_LessThan_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_LessThan(3);// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            assertTrue(member.getMemberId() < 3);
        }

        // [SQL]
        // where MEMBER_ID < 3
    }

    // -----------------------------------------------------
    //                                             LessEqual
    //                                             ---------
    /**
     * Query-LessEqual条件: setXxx_LessEqual().
     * 会員ID「3」以下の会員IDを持った会員を検索。
     */
    @Test
    @Transactional
    public void test_query_LessEqual_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_LessEqual(3);// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            assertTrue(member.getMemberId() <= 3);
        }

        // [SQL]
        // where MEMBER_ID <= 3
    }

    // -----------------------------------------------------
    //                                          PrefixSearch
    //                                          ------------
    /**
     * Query-PrefixSearch条件(前方一致): setXxx_PrefixSearch().
     * 会員名称が'S'で始まる会員を検索。
     */
    @Test
    @Transactional
    public void test_query_PrefixSearch_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberName_PrefixSearch("S");// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("memberName=" + member.getMemberName());
            assertTrue(member.getMemberName().startsWith("S"));
        }

        // [SQL]
        // where MEMBER_NAME like 'S%'

        // [Description]
        // A. ワイルドカード'%'は内部的に自動付与される。
        // B. 自動でエスケープ処理が施される。
        // C. 同じカラムに複数回設定を設定した場合は、設定した分条件が展開される
    }

    // -----------------------------------------------------
    //                                               InScope
    //                                               -------
    /**
     * Query-InScope条件(in ('a', 'b')): setXxx_InScope().
     * 会員ID「3」・「6」・「7」の会員を検索。
     */
    @Test
    @Transactional
    public void test_query_InScope_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        final List<Integer> expectedMemberIdList = new ArrayList<Integer>();
        expectedMemberIdList.add(3);
        expectedMemberIdList.add(6);
        expectedMemberIdList.add(7);
        cb.query().setMemberId_InScope(expectedMemberIdList);// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("memberId=" + member.getMemberId());
            assertTrue(expectedMemberIdList.contains(member.getMemberId()));
        }

        // [Description]
        // A. 空のリストが指定された場合は、その条件は無効になる。
        //    --> nullが指定された場合と同じ
        //
        // B. リストの中に同じ値が格納されている場合は、そのまま処理される。
        //    --> 例えば、'6'が二つ格納されていたら: in (3, 6, 6, 7)
        //
        // C. リストの中にnullや空文字が登録されている場合は、それら値だけ無視される。
        //    --> リストの中が全てnullや空文字なら「A」と同じ
        //
        // D. 同じカラムに複数回設定を設定した場合は、設定した分条件が展開される
    }

    // -----------------------------------------------------
    //                                            NotInScope
    //                                            ----------
    /**
     * Query-NotInScope条件(not in ('a', 'b')): setXxx_NotInScope().
     * 会員ID「3」・「6」・「7」でない会員を検索
     */
    @Test
    @Transactional
    public void test_query_NotInScope_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        final List<Integer> expectedMemberIdList = new ArrayList<Integer>();
        expectedMemberIdList.add(3);
        expectedMemberIdList.add(6);
        expectedMemberIdList.add(7);
        cb.query().setMemberId_NotInScope(expectedMemberIdList);// *Point!

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("memberId=" + member.getMemberId());
            if (expectedMemberIdList.contains(member.getMemberId())) {
                fail();
            }
        }

        // [Description]
        // A. 空のリストが指定された場合は、その条件は無効になる。
        //    --> nullが指定された場合と同じ
        //
        // B. リストの中に同じ値が格納されている場合は、そのまま処理される。
        //    --> 例えば、'6'が二つ格納されていたら: in (3, 6, 6, 7)
        //
        // C. リストの中にnullや空文字が登録されている場合は、それら値だけ無視される。
        //    --> リストの中が全てnullや空文字なら「A」と同じ
        //
        // D. 同じカラムに複数回設定を設定した場合は、設定した分条件が展開される
    }

    // -----------------------------------------------------
    //                                            LikeSearch
    //                                            ----------
    /**
     * Query-LikeSearch条件の前方一致: setXxx_LikeSearch(), option.likePrefix().
     * 会員名称が'S'で始まる会員を検索。
     */
    @Test
    @Transactional
    public void test_query_LikeSearch_likePrefix_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        final LikeSearchOption option = new LikeSearchOption().likePrefix();
        cb.query().setMemberName_LikeSearch("S", option);

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("memberName=" + member.getMemberName());
            assertTrue(member.getMemberName().startsWith("S"));
        }

        // [Description]
        // A. LikeSearchOptionの指定は必須。(nullは例外)
        // B. likeXxx()を指定すると自動でエスケープ処理が施される。
        // C. 同じカラムに複数回設定を設定した場合は、設定した分条件が展開される
    }

    /**
     * Query-LikeSearch条件の中間一致: setXxx_LikeSearch(), option.likeContain().
     * 会員名称に'v'が含まれる会員を検索。
     */
    @Test
    @Transactional
    public void test_query_LikeSearch_likeContain_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        final LikeSearchOption option = new LikeSearchOption().likeContain();
        cb.query().setMemberName_LikeSearch("v", option);

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("memberName=" + member.getMemberName());
            assertTrue(member.getMemberName().contains("v"));
        }

        // [Description]
        // A. LikeSearchOptionの指定は必須。(nullは例外)
        // B. likeXxx()を指定すると自動でエスケープ処理が施される。
        // C. 同じカラムに複数回設定を設定した場合は、設定した分条件が展開される
    }

    /**
     * Query-LikeSearch条件の後方一致: setXxx_LikeSearch(), option.likeSuffix().
     * 会員名称が'r'で終わる会員を検索。
     */
    @Test
    @Transactional
    public void test_query_LikeSearch_likeSuffix_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        final LikeSearchOption option = new LikeSearchOption().likeSuffix();
        cb.query().setMemberName_LikeSearch("r", option);

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("memberName=" + member.getMemberName());
            assertTrue(member.getMemberName().endsWith("r"));
        }

        // [Description]
        // A. LikeSearchOptionの指定は必須。(nullは例外)
        // B. likeXxx()を指定すると自動でエスケープ処理が施される。
        // C. 同じカラムに複数回設定を設定した場合は、設定した分条件が展開される
    }

    /**
     * Query-LikeSearch条件のエスケープ付き曖昧検索: setXxx_LikeSearch().
     * 会員名称に'100%ジュース|和歌山_テ'という文字が含まれる会員を検索。
     * 但し、'果汁100パーセントジュース|和歌山Aテスト'というような会員名称は検索対象になってはならない。
     * (条件値に既に含まれている'%'や'_'がワイルドカードとして扱われてはならない)
     * 想定されるSQL(Where句)は以下のような形である。
     * <pre>
     * -- 会員名称に'100%ジュース|和歌山_テ'という文字が含まれる会員
     * where MEMBER_NAME like '%100|%ジュース||和歌山|_テ%' escape '|'
     *
     * {エスケープ文字の埋め込み}
     * A. 条件値に含まれているエスケープ文字'|' → '||'
     * B. 条件値に含まれているワイルドカード文字'%' → '|%'
     * C. 条件値に含まれているワイルドカード文字'_' → '|_'
     * </pre>
     */
    @Test
    @Transactional
    public void test_query_LikeSearch_likeContain_AllEscape_Tx() {
        // ## Arrange ##
        final String keyword = "100%ジュース|和歌山_テ";
        final String expectedMemberName = "果汁" + keyword + "スト";
        final String dummyMemberName = "果汁100パーセントジュース|和歌山Aテスト";

        // escape処理の必要な会員がいなかったので、ここで一時的に登録
        final Member escapeMember = new Member();
        escapeMember.setMemberName(expectedMemberName);
        escapeMember.setMemberAccount("temporaryAccount");
        escapeMember.setMemberStatusCode_正式会員();
        this.memberBhv.insert(escapeMember);

        // escape処理をしない場合にHITする会員も登録
        final Member nonEscapeOnlyMember = new Member();
        nonEscapeOnlyMember.setMemberName(dummyMemberName);
        nonEscapeOnlyMember.setMemberAccount("temporaryAccount2");
        nonEscapeOnlyMember.setMemberStatusCode_正式会員();
        this.memberBhv.insert(nonEscapeOnlyMember);

        // 一時的に登録した会員が想定しているものかどうかをチェック
        final MemberCB checkCB = new MemberCB();

        // Check if not escape!
        checkCB.query().setMemberName_LikeSearch(keyword, new LikeSearchOption().likeContain().notEscape());
        assertEquals("escapeなしで2件ともHITすること", 2, this.memberBhv.selectList(checkCB).size());

        // /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        final MemberCB cb = new MemberCB();
        final LikeSearchOption option = new LikeSearchOption().likeContain(); // *Point!
        cb.query().setMemberName_LikeSearch(keyword, option);
        // - - - - - - - - - -/

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertEquals(1, memberList.size());// このキーワードにHITする人は１人しかいない
        final Member actualMember = memberList.get(0);
        this.log(actualMember);
        assertEquals(expectedMemberName, actualMember.getMemberName());

        // [SQL]
        // select ...
        //   from MEMBER
        //  where MEMBER_NAME like '%100|%ジュース||和歌山|_テ%' escape '|'

        // [Description]
        // A. likeXxx()を指定すると自動でエスケープ処理が施される。
        // B. likeXxx()を指定した後にnotEscape()を呼ぶとエスケープ処理が解除される。
    }

    // /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
    // [Tips]: そもそもエスケープ付き曖昧検索とは？
    //
    //    曖昧検索は、条件値に含まれているワイルドカード(%や_)を使って、
    //    前方一致・中間一致等を実現する。例えば、条件値が'ス%'であれば
    //    「スで始まるもの」、'%ス%'であれば「スを含むもの」という検索になる
    //    しかし、もしデータベース上に「100%ジュースの飲み物」という文字が
    //    格納されていて、「'100%ジュース'を含むもの」という検索をしたい場合に、
    //    条件値が'%100%ジュース%'では正確な検索をすることができない。
    //
    //        [曖昧検索-'100%ジュース'を含むもの]
    //        =============================================================
    //        -- 「'100%ジュース'を含むもの」
    //        where xxx like '%100%ジュース%'
    //        =============================================================
    //
    //    なにがまずいかというと、もしデータベース上に「100回回ってから飲むジュース」
    //    というデータが入ってたら、このデータも検索対象になってしまうのである。
    //    「'100%ジュース'を含むもの」という条件からは外れたデータである。
    //    つまりは、ワイルドカード(%や_)も通常の文字として扱いたいこともあるということ。
    //
    //    SQLでは、文字として扱いたい'%'や'_'がある場合に、それらを条件値の中でエスケープする。
    //    そのときエスケープ文字を明示的に指定する。
    //
    //        [エスケープ付き曖昧検索-ワイルドカード文字をエスケープ]
    //        =============================================================
    //        -- 「'100%ジュース'を含むもの」
    //        where xxx like '%100|%ジュース%' escape '|'
    //        =============================================================
    //
    //    こうすることで、エスケープ文字でエスケープされた'%'や'_'はワイルドカードではなく、
    //    通常の文字として扱われる。エスケープ文字をエスケープすることも可能。
    //
    //        [エスケープ付き曖昧検索-エスケープ文字をエスケープ]
    //        =============================================================
    //        -- 「'aaa|bbb'を含むもの」
    //        where xxx like '%aaa||bbb%' escape '|'
    //        =============================================================
    // = = = = = = = = = =/

    // -----------------------------------------------------
    //                                         NotLikeSearch
    //                                         -------------
    /**
     * Query-NotLikeSearch条件の前方一致: setXxx_NotLikeSearch(), option.likePrefix().
     * 会員名称が'S'で始まらない会員を検索。
     */
    @Test
    @Transactional
    public void test_query_NotLikeSearch_likePrefix_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        final LikeSearchOption option = new LikeSearchOption().likePrefix();
        cb.query().setMemberName_NotLikeSearch("S", option);

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("memberName=" + member.getMemberName());
            assertFalse(member.getMemberName().startsWith("S"));
        }

        // [Description]
        // A. LikeSearchOptionの指定は必須。(nullは例外)
        // B. likeXxx()を指定すると自動でエスケープ処理が施される。
        // C. 同じカラムに複数回設定を設定した場合は、設定した分条件が展開される
    }

    // -----------------------------------------------------
    //                                        ExistsReferrer
    //                                        --------------
    /**
     * Query-ExistsReferrerで子テーブルの条件で絞り込み: cb.query().existsXxxList().
     * 一回の購入で二点以上の購入をしたことのある会員を検索。
     * Existsの相関サブクエリを使って子テーブルの条件で絞り込む。
     */
    @Test
    @Transactional
    public void test_query_exists_ReferrerCondition_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().setPurchaseCount_GreaterThan(2);
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        this.memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB subCB) {
                subCB.setupSelect_Product();
            }
        });
        for (final Member member : memberList) {
            this.log("[MEMBER] " + member.getMemberId() + ", " + member.getMemberName());
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean existsPurchase = false;
            for (final Purchase purchase : purchaseList) {
                final Product product = purchase.getProduct();
                final Integer purchaseCount = purchase.getPurchaseCount();
                final String productName = product.getProductName();
                this.log("    [PURCHASE] " + purchase.getPurchaseId() + ", " + purchaseCount + ", " + productName);
                if (purchaseCount > 2) {
                    existsPurchase = true;
                }
            }
            assertTrue(existsPurchase);
        }

        // [SQL]
        // select ...
        //   from MEMBER dflocal
        //  where exists (select dfsublocal_0.MEMBER_ID
        //                  from PURCHASE dfsublocal_0
        //                 where dfsublocal_0.MEMBER_ID = dflocal.MEMBER_ID
        //                   and dfsublocal_0.PURCHASE_COUNT > 2
        //        )

        // [Description]
        // A. 複数回設定を設定した場合は、設定した分条件が展開される
        // X. Eclipse(3.3)でのSubQuery実装手順：
        //    X-1. cb.qu まで書いて補完してEnter!
        //         --> cb.query() になる
        //
        //    X-2. cb.query().ex まで書いて補完して子テーブルを選択してEnter!
        //         --> cb.query().existsPurchaseList(subQuery) になる
        //
        //    X-3. cb.query().existsPurchaseList(new ) まで書いて補完してEnter!
        //         --> カーソル位置から入力する文字は「new 」
        //         --> cb.query().existsPurchaseList(new SubQuery<PurchaseCB>) になる
        //
        //    X-4. cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {) まで書いて補完してEnter!
        //         --> カーソル位置から入力する文字は「() {」
        //         --> cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
        //             })
        //             になる
        //         --> [SubQuery<PurchaseCB>]部分と最後の行の[})]部分がコンパイルエラーになる
        //
        //    X-5. コンパイルエラーの[SubQuery<PurchaseCB>]にカーソルを合わせてctrl + 1を押してEnter!
        //         --> cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
        //                 public void query(PurchaseCB subCB) {
        //                     // todo Auto-generated method stub
        //                 }
        //             })
        //             になる
        //         --> 最後の行の[})]部分でセミコロンがないことでまだコンパイルエラーである
        //
        //    X-6. セミコロンも付ける
        //         --> cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
        //                 public void query(PurchaseCB subCB) {
        //                     // todo Auto-generated method stub
        //                 }
        //             });
        //
        //    X-7. TODOのコメント消して子テーブルの「絞り込み条件」を実装する
    }

    /**
     * Query-ExistsReferrerでmany-to-manyの関係のテーブルの条件で絞り込み: cb.query().existsXxxList().
     * 商品名称が'Storm'で始まる商品を購入したことのある会員を検索。
     * Existsの相関サブクエリを使って子テーブルを経由してその親テーブルの条件で絞り込む。
     */
    @Test
    @Transactional
    public void test_query_exists_ManyToManyCondition_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().queryProduct().setProductName_PrefixSearch("Storm");
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        this.memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB subCB) {
                subCB.setupSelect_Product();
            }
        });
        for (final Member member : memberList) {
            this.log("[MEMBER] " + member.getMemberId() + ", " + member.getMemberName());
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean existsProduct = false;
            for (final Purchase purchase : purchaseList) {
                final Product product = purchase.getProduct();
                final Integer purchaseCount = purchase.getPurchaseCount();
                final String productName = product.getProductName();
                this.log("    [PURCHASE] " + purchase.getPurchaseId() + ", " + purchaseCount + ", " + productName);
                if (productName.startsWith("Storm")) {
                    existsProduct = true;
                }
            }
            assertTrue(existsProduct);
        }
    }

    /**
     * Query-ExistsReferrerで親テーブルの子テーブル(兄弟テーブル)の条件で絞り込み: cb.query().queryXxx().existsYyyList().
     * モバイル(携帯)からログインしたことのある会員の購入リストを検索。
     * Existsの相関サブクエリを使って親テーブルの子テーブル(会員ログイン)を経由して絞り込む。
     */
    @Test
    @Transactional
    public void test_query_exists_ForeignReferrerCondition_Tx() {
        // ## Arrange ##
        final PurchaseCB cb = new PurchaseCB();

        // *Point!
        cb.query().queryMember().existsMemberLoginList(new SubQuery<MemberLoginCB>() {
            public void query(final MemberLoginCB subCB) {
                subCB.query().setMobileLoginFlg_Equal_True();
            }
        });
        cb.query().addOrderBy_MemberId_Asc().addOrderBy_ProductId_Asc();

        // ## Act ##
        final ListResultBean<Purchase> purchaseList = this.purchaseBhv.selectList(cb);

        // ## Assert ##
        final List<Long> purchaseIdList = new ArrayList<Long>();
        final Set<Integer> memberIdSet = new HashSet<Integer>();
        for (final Purchase purchase : purchaseList) {
            // Show only
            final Long purchaseId = purchase.getPurchaseId();
            final Integer memberId = purchase.getMemberId();
            final Integer productId = purchase.getProductId();
            final Timestamp purchaseDatetime = purchase.getPurchaseDatetime();
            this.log("[PURCHASE] " + purchaseId + ", " + memberId + ", " + productId + ", " + purchaseDatetime);
            purchaseIdList.add(purchaseId);
            memberIdSet.add(memberId);
        }
        final MemberCB memberCB = new MemberCB();
        memberCB.query().existsMemberLoginList(new SubQuery<MemberLoginCB>() {
            public void query(final MemberLoginCB subCB) {
                subCB.query().setMobileLoginFlg_Equal_True();
            }
        });
        memberCB.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
            }
        });
        final int expected = this.memberBhv.selectCount(memberCB);
        assertEquals(expected, memberIdSet.size());

        // [SQL]
        // select ...
        //   from PURCHASE dflocal
        //     left outer join MEMBER dfrelation_0 on dflocal.MEMBER_ID = dfrelation_0.MEMBER_ID
        //  where exists (select dfsublocal_0.MEMBER_ID
        //                  from MEMBER_LOGIN dfsublocal_0
        //                 where dfsublocal_0.MEMBER_ID = dfrelation_0.MEMBER_ID
        //                   and dfsublocal_0.LOGIN_MOBILE_FLG = 1
        //        )
        //  order by dflocal.MEMBER_ID asc, dflocal.PRODUCT_ID asc
    }

    /**
     * Query-NotExistsReferrerで子テーブルの条件で絞り込み: cb.query().notExistsXxxList().
     * 一回の購入で二点以上の購入をしたこと「ない」会員を検索。
     * NotExistsの相関サブクエリを使って子テーブルの条件で絞り込む。
     * @since 0.7.5
     */
    @Test
    @Transactional
    public void test_query_notExists_ReferrerCondition_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        cb.query().notExistsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().setPurchaseCount_GreaterThan(2);
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        final ConditionBeanSetupper<PurchaseCB> setuppper = new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB subCB) {
                subCB.setupSelect_Product();
            }
        };
        this.memberBhv.loadPurchaseList(memberList, setuppper);
        for (final Member member : memberList) {
            this.log("[MEMBER] " + member.getMemberId() + ", " + member.getMemberName());
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean existsPurchase = false;
            for (final Purchase purchase : purchaseList) {
                final Product product = purchase.getProduct();
                final Integer purchaseCount = purchase.getPurchaseCount();
                final String productName = product.getProductName();
                this.log("    [PURCHASE] " + purchase.getPurchaseId() + ", " + purchaseCount + ", " + productName);
                if (purchaseCount > 2) {
                    existsPurchase = true;
                }
            }
            assertFalse(existsPurchase);
        }
    }

    // -----------------------------------------------------
    //                                       InScopeRelation
    //                                       ---------------
    /**
     * Query-InScopeRelationで子テーブルの条件で絞り込み: cb.query().inScopeXxxList().
     * 一回の購入で二点以上の購入をしたことのある会員を検索。
     * InScopeのサブクエリを使って子テーブルの条件で絞り込む。
     */
    @Test
    @Transactional
    public void test_query_inScope_ReferrerCondition_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        cb.query().inScopePurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().setPurchaseCount_GreaterThan(2);
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        this.memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB subCB) {
                subCB.setupSelect_Product();
            }
        });
        for (final Member member : memberList) {
            this.log("[MEMBER] " + member.getMemberId() + ", " + member.getMemberName());
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean existsPurchase = false;
            for (final Purchase purchase : purchaseList) {
                final Product product = purchase.getProduct();
                final Integer purchaseCount = purchase.getPurchaseCount();
                final String productName = product.getProductName();
                this.log("    [PURCHASE] " + purchase.getPurchaseId() + ", " + purchaseCount + ", " + productName);
                if (purchaseCount > 2) {
                    existsPurchase = true;
                }
            }
            assertTrue(existsPurchase);
        }

        // [Description]
        // A. ExistsReferrerと結果は全く同じになる。
        //    --> 実行計画が変わる可能性あり
        // B. 複数回設定を設定した場合は、設定した分条件が展開される
    }

    /**
     * Query-InScopeRelationでmany-to-manyの関係のテーブルの条件で絞り込み: cb.query().inScopeXxxList().
     * 商品名称が'Storm'で始まる商品を購入したことのある会員を検索。
     * InScopeのサブクエリを使って子テーブルを経由してその親テーブルの条件で絞り込む。
     */
    @Test
    @Transactional
    public void test_query_inScope_ManyToManyCondition_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        cb.query().inScopePurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().queryProduct().setProductName_PrefixSearch("Storm");
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        this.memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB subCB) {
                subCB.setupSelect_Product();
            }
        });
        for (final Member member : memberList) {
            this.log("[MEMBER] " + member.getMemberId() + ", " + member.getMemberName());
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean existsProduct = false;
            for (final Purchase purchase : purchaseList) {
                final Product product = purchase.getProduct();
                final Integer purchaseCount = purchase.getPurchaseCount();
                final String productName = product.getProductName();
                this.log("    [PURCHASE] " + purchase.getPurchaseId() + ", " + purchaseCount + ", " + productName);
                if (productName.startsWith("Storm")) {
                    existsProduct = true;
                }
            }
            assertTrue(existsProduct);
        }

        // [Description]
        // A. ExistsReferrerと結果は全く同じになる。
        //    --> 実行計画が変わる可能性あり
    }

    /**
     * Query-NotInScopeRelationで子テーブルの条件で絞り込み: cb.query().notInScopeXxxList().
     * 一回の購入で二点以上の購入をしたこと「ない」会員を検索。
     * NotInScopeのサブクエリを使って子テーブルの条件で絞り込む。
     * @since 0.7.5
     */
    @Test
    @Transactional
    public void test_query_notInScope_ReferrerCondition_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();

        // *Point!
        cb.query().notInScopePurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().setPurchaseCount_GreaterThan(2);
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        this.memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB subCB) {
                subCB.setupSelect_Product();
            }
        });
        for (final Member member : memberList) {
            this.log("[MEMBER] " + member.getMemberId() + ", " + member.getMemberName());
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean existsPurchase = false;
            for (final Purchase purchase : purchaseList) {
                final Product product = purchase.getProduct();
                final Integer purchaseCount = purchase.getPurchaseCount();
                final String productName = product.getProductName();
                this.log("    [PURCHASE] " + purchase.getPurchaseId() + ", " + purchaseCount + ", " + productName);
                if (purchaseCount > 2) {
                    existsPurchase = true;
                }
            }
            assertFalse(existsPurchase);
        }

        // [Description]
        // A. NotExistsReferrerと結果は全く同じになる。
        //    --> 実行計画が変わる可能性あり
    }

    // -----------------------------------------------------
    //                                            DateFromTo
    //                                            ----------
    /**
     * Query-DateFromTo(日付の範囲検索): query().setXxx_DateFromTo().
     * '2007/11/26'から'2007/12/01'の期間正式会員になった会員を検索。
     * '2007/12/01'の日に正式会員になった人もちゃんと対象になること。
     * <p>
     * 例えば、日付で範囲検索する画面から条件を入力する場合、終了日に'2007/12/01'と
     * 入れられたら、'2007/12/01 14:23:43'のデータも対象になって欲しいことが多い。
     * しかし、入力された日付でそのままSQLの条件に組み込むと、「less equal '2007/12/01 00:00:00'」
     * となって、'2007/12/01'から一秒でも過ぎたデータが対象にならなくなってしまう。
     * そのため、入力された終了日を加工して、'2007/12/01 23:59:59'とするか、
     * 一日進めて「less than '2007/12/02 00:00:00'」とするかで対応することが多いが、
     * これを都度都度各ディベロッパーが実装すると、実装方法がバラバラになってしまうだけでなく、
     * 細かい日付操作や演算子の調整というところでバグの温床となってしまう。
     * (テストで見つけにくいバグでもあり、とてもやっかいである)
     * このDateFromToを使えば、その細かい日付操作や演算子の調整を安全に実装することができる。
     * </p>
     * <p>
     * DB側では時刻も含めた上で正確な日時として管理しておいて、画面からの検索は時刻無し日付で
     * 範囲検索をするというような状況でとても有効である。特にイベント系の日時ではそういうことが多い。
     * 運用時のいざって時のために時刻を保持しておきたいが、画面からの範囲検索は日付で絞れれば良いという場合である。
     * </p>
     */
    @Test
    @Transactional
    public void test_query_DateFromTo_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        final Calendar cal = Calendar.getInstance();
        cal.set(2007, 10, 26);// 2007/11/26
        final Date fromDate = new Date(cal.getTimeInMillis());
        cal.set(2007, 11, 1);// 2007/12/01
        final Date toDate = new Date(cal.getTimeInMillis());
        cb.query().setFormalizedDatetime_DateFromTo(fromDate, toDate);// *Point!

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log(member.getMemberName() + ", " + member.getFormalizedDatetime());
        }
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    /**
     * Union(Or条件の代替): union().
     * 「仮会員」もしくは「会員名称が'St'で始まる」会員を「会員名称の降順」で検索。
     * 関連テーブルとして会員ステータスを取得。
     */
    @Test
    @Transactional
    public void test_union_Tx() {
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().setMemberStatusCode_Equal_仮会員();
        cb.union(new UnionQuery<MemberCB>() {
            public void query(final MemberCB unionCB) {
                unionCB.query().setMemberName_PrefixSearch("St");
            }
        });
        cb.query().addOrderBy_MemberName_Desc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        for (final Member member : memberList) {
            final String memberName = member.getMemberName();
            final String memberStatusName = member.getMemberStatus().getMemberStatusName();
            if (!memberName.startsWith("St")) {
                this.log("[Provisional]: " + memberName + ", " + memberStatusName);
                assertTrue(member.isMemberStatusCode仮会員());
            } else if (!member.isMemberStatusCode仮会員()) {
                this.log("[Starts with St]: " + memberName + ", " + memberStatusName);
                assertTrue(memberName.startsWith("St"));
            } else {
                this.log("[Both]: " + memberName + ", " + memberStatusName);
            }
        }

        // [SQL]
        // select ...
        //   from MEMBER dflocal
        //  where dflocal.MEMBER_STATUS_CODE = 'PRV'
        //  union
        // select ...
        //   from MEMBER dflocal
        //  where dflocal.MEMBER_NAME like 'S%'
        //  order by MEMBER_NAME desc

        // [Description]
        // A. ConditionBeanでは自テーブル同士のUnionが可能である。
        //
        // B. Unionが指定できる回数は無限である。
        //
        // C. Or条件の代替として利用される。
        //    --> パフォーマンス考慮
        //
        // D. 条件的に取得するデータがかぶらないのであればunionAll()の方が良い。
        //    --> パフォーマンス考慮
        //
        // E. Union側のConditionBeanではsetupSelectとaddOrderByを呼び出す必要はない。
        //    --> 絞り込み条件のみ設定すること
        //    --> setupSelectは必ずunion()を呼び出す前に指定すること(フレームワークの都合)
        //    --> addOrderByは必ずunion()を呼び出した後に指定すること(フレームワークの都合)
    }

    /**
     * UnionAll(Or条件の代替): unionAll().
     * 「生年月日が1967/01/01より昔」もしくは「生年月日がnull」の会員を「生年月日の降順、会員名称の昇順」で検索。
     * 互いの条件でデータがかぶらないので、UnionAllを利用。
     */
    @Test
    @Transactional
    public void test_unionAll_Tx() {
        final MemberCB cb = new MemberCB();
        final Calendar cal = Calendar.getInstance();
        cal.set(1967, 0, 1);// 1967/01/01
        cb.query().setBirthdate_LessThan(new Date(cal.getTimeInMillis()));
        cb.unionAll(new UnionQuery<MemberCB>() {
            public void query(final MemberCB unionCB) {
                unionCB.query().setBirthdate_IsNull();
            }
        });
        cb.query().addOrderBy_Birthdate_Desc();
        cb.query().addOrderBy_MemberName_Asc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        for (final Member member : memberList) {
            this.log("[MEMBER]: " + member.getMemberName() + ", " + member.getBirthdate());
        }

        // [SQL]
        // select ...
        //   from MEMBER dflocal
        //  where dflocal.MEMBER_BIRTHDAY < '1967-01-01'
        //  union all
        // select ...
        //   from MEMBER dflocal
        //  where dflocal.MEMBER_BIRTHDAY is null
        //  order by MEMBER_BIRTHDAY desc, MEMBER_NAME asc

        // [Description]
        // A. ConditionBeanでは自テーブル同士のUnionAllが可能である。
        //
        // B. UnionAllが指定できる回数は無限である。
        //
        // C. Or条件の代替として利用される。
        //    --> パフォーマンス考慮
        //
        // D. Union側のConditionBeanではsetupSelectとaddOrderByを呼び出す必要はない。
        //    --> 絞り込み条件のみ設定すること
        //    --> setupSelectは必ずunion()を呼び出す前に指定すること(フレームワークの都合)
        //    --> addOrderByは必ずunion()を呼び出した後に指定すること(フレームワークの都合)
    }

    // ===================================================================================
    //                                                                              Paging
    //                                                                              ======
    /**
     * ページング検索: cb.paging(pageSize, pageNumber).
     * 会員名称の昇順のリストを「１ページ４件」の「３ページ目」(９件目から１２件目)を検索。
     * ※詳しくはBehaviorMiddleTestの「ページング検索: selectPage().」を参照。
     */
    @Test
    @Transactional
    public void test_paging_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_MemberName_Asc();
        cb.paging(4, 3);// The page size is 4 records per 1 page, and The page number is 3.

        // ## Act ##
        final PagingResultBean<Member> page3 = this.memberBhv.selectPage(cb);

        // ## Assert ##
        assertNotSame(0, page3.size());
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
    }

    // ===================================================================================
    //                                                                       Fetch Setting
    //                                                                       =============
    /**
     * 先頭のn件を検索: cb.fetchFirst(fetchSize).
     * 生年月日の降順で先頭の会員を検索。
     */
    @Test
    @Transactional
    public void test_fetchFirst_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_Birthdate_Desc().withNullsLast();
        cb.fetchFirst(1);// *Point!

        // ## Act ##
        final Member member = this.memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        this.log(member.getMemberName() + ", " + member.getBirthdate());

        // [Description]
        // A. DBFlute-0.7.3よりサポートされたpaging()メソッドでも同様のことが可能。
        //      paging(1, 1);
        //
        // B. 引数のfetchSizeは、マイナス値や０が指定されると例外発生
    }

    // ===================================================================================
    //                                                                        Lock Setting
    //                                                                        ============
    /**
     * 更新ロックを取得: cb.lockForUpdate().
     */
    @Test
    @Transactional
    public void test_lockForUpdate_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);
        cb.lockForUpdate();

        // ## Act ##
        final Member member = this.memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        assertNotNull(member);
    }

    // ===================================================================================
    //                                                                         Display SQL
    //                                                                         ===========
    /**
     * ConditionBeanで組み立てたSQLをログに表示: toDisplaySql().
     * ConditionBeanで実装していて、途中で外だしSQLで書かなければならないことがわかったときに、
     * その途中まで書いたConditionBeanをベースにSQLを書くことができる。
     * (スムーズに外だしへの移行が可能であり、かつ、SQLも安全に実装できる)
     */
    @Test
    @Transactional
    public void test_toDisplaySql_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().setMemberName_LikeSearch("S", new LikeSearchOption().likePrefix().escapeByAtMark());
        cb.query().addOrderBy_Birthdate_Desc().addOrderBy_MemberId_Asc();
        cb.lockForUpdate();
        cb.fetchFirst(2);
        cb.fetchPage(3);

        // ## Act ##
        final String displaySql = cb.toDisplaySql();// *Point!

        // ## Assert ##
        final StringBuilder sb = new StringBuilder();
        sb.append("{SQL}" + getLineSeparator());
        sb.append("***************************************************************");
        sb.append(getLineSeparator());
        sb.append(displaySql);
        sb.append(getLineSeparator());
        sb.append("**************************************************************");
        this.log(sb);
        assertTrue(displaySql.contains("'S%'"));
        assertTrue(displaySql.contains(" escape '@'"));
        assertTrue(displaySql.contains("for update"));
        assertTrue(displaySql.contains(" order by "));
        assertTrue(displaySql.contains(" limit "));
        assertTrue(displaySql.contains(" offset "));
    }

    /**
     * ConditionBeanで組み立てたSQLをログに表示(SubQuery含み): toDisplaySql().
     * SubQueryはSQLとしてバグリやすい部分なため、最初から外だしSQLだとわかっていても、
     * ConditionBeanで一度組み立ててからSQLのベースとなる文字列をログから取得するのも良い。
     * SubQueryを含んだSQLも見やすい形でフォーマットされる。
     */
    @Test
    @Transactional
    public void test_toDisplaySql_SubQuery_Tx() {
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().setPurchaseDatetime_LessThan(ConditionBeanMiddleTest.this.currentTimestamp());
                subCB.query().setPurchaseCount_GreaterEqual(2);
            }
        });
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.query().setPurchaseDatetime_LessThan(ConditionBeanMiddleTest.this.currentTimestamp());
                subCB.query().setPurchaseCount_GreaterEqual(6);
            }
        });

        // ## Act ##
        final String displaySql = cb.toDisplaySql();

        // ## Assert ##
        final StringBuilder sb = new StringBuilder();
        sb.append("{SQL}" + getLineSeparator());
        sb.append("*******************************************").append(getLineSeparator());
        sb.append(displaySql + getLineSeparator());
        sb.append("*******************************************");
        this.log(sb);
        assertTrue(displaySql.contains(">= 2"));
        assertTrue(displaySql.contains(" exists "));

        // [SQL]
        // select ...
        //   from MEMBER dflocal
        //     left outer join MEMBER_STATUS dfrelation_0 on dflocal.MEMBER_STATUS_CODE = dfrelation_0.MEMBER_STATUS_CODE
        //  where exists (select dfsublocal_0.MEMBER_ID
        //                  from PURCHASE dfsublocal_0
        //                 where dfsublocal_0.MEMBER_ID = dflocal.MEMBER_ID
        //                   and dfsublocal_0.PURCHASE_DATETIME < '2008-06-01 05.09.24'
        //                   and dfsublocal_0.PURCHASE_COUNT >= 2
        //        )
    }
}
