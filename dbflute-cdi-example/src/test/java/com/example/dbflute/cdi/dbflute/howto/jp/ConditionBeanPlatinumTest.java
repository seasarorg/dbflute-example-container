package com.example.dbflute.cdi.dbflute.howto.jp;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.jdbc.StatementConfig;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.allcommon.CDef;
import com.example.dbflute.cdi.dbflute.cbean.MemberAddressCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.cdi.dbflute.cbean.MemberWithdrawalCB;
import com.example.dbflute.cdi.dbflute.cbean.PurchaseCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exbhv.MemberWithdrawalBhv;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.dbflute.exentity.MemberAddress;
import com.example.dbflute.cdi.dbflute.exentity.MemberWithdrawal;
import com.example.dbflute.cdi.dbflute.exentity.Product;
import com.example.dbflute.cdi.dbflute.exentity.Purchase;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * ConditionBeanの上級編Example実装。
 * <pre>
 * ターゲットは以下の通り：
 *   o DBFluteをとことん極めたい方
 *   o 開発中で難しい要求が出てきて実現方法がわからなくて困っている方
 *
 * コンテンツは以下の通り：
 *   o 空白区切りの連結曖昧検索(And条件): option.likeContain().splitBySpace().
 *   o 空白区切りの連結曖昧検索(Or条件): option.likeContain().splitBySpace().asOrSplit().
 *   o カラム同士の比較条件: columnQuery().
 *   o Exists句の中でUnion: existsXxxList(), union().
 *   o nullを最初に並べる: addOrderBy_Xxx_Asc().withNullsFirst().
 *   o nullを最後に並べる: addOrderBy_Xxx_Asc().withNullsLast().
 *   o nullを最後に並べる(Unionと共演): addOrderBy_Xxx_Asc().withNullsLast(), union().
 *   o 手動で並べる: addOrderBy_Xxx_Asc().withManualOrder().
 *   o Unionのループによる不定数設定: for { cb.union() }.
 *   o Unionを使ったページング検索: union(), selectPage().
 *   o OnClause(On句)に条件を追加: queryXxx().on().
 *   o 取得カラムの指定(SpecifyColumn): specify().columnXxx().
 *   o 子テーブル導出カラムの指定((Specify)DerivedReferrer)-Max: specify().derivedXxxList().max().
 *   o 子テーブル導出カラムで並び替え(SpecifiedDerivedOrderBy)-Count: addSpecifiedDerivedOrderBy_Desc().
 *   o 子テーブルカラムの種類数取得((Specify)DerivedReferrer)-CountDistinct: specify().derivedXxxList().countDistinct().
 *   o 子テーブル導出カラムで絞り込み((Query)DerivedReferrer)-Max: query().derivedXxx().max().greaterEqual().
 *   o 最大値レコードの検索(ScalarCondition)-Max: scalar_Equal(), max().
 *   o 固定条件を加えたone-to-oneの取得：fixedCondition, selectSelect_Xxx(target).
 *   o 固定条件を加えたone-to-oneの絞り込み：fixedCondition, queryXxx(target).
 *   o Statementのコンフィグを設定: cb.configure(statementConfig).
 *   o where句の再利用(ArrangeQuery): cb.query().arrangeXxx().
 *   o どんなにSubQueryやUnionの連打をしてもSQLが綺麗にフォーマット: toDisplaySql().
 * </pre>
 * @author jflute
 * @since 0.7.3 (2008/06/01 Sunday)
 */
public class ConditionBeanPlatinumTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Object) */
    @Inject
    private MemberBhv memberBhv;

    /** The behavior of MemberWithdrawal. (Injection Object) */
    @Inject
    private MemberWithdrawalBhv memberWithdrawalBhv;

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    // -----------------------------------------------------
    //                                            LikeSearch
    //                                            ----------
    /**
     * 空白区切りの連結曖昧検索(And条件): option.likeContain().splitBySpace().
     * 画面から空白区切りでキーワードを入力して検索する場合などに有効な機能。
     * デフォルトでは「And条件」で連結する。
     */
    @Test
    @Transactional
    public void test_query_LikeSearch_likeContain_splitBySpace_Tx() {
        // ## Arrange ##
        final String keyword = "S jko ic";
        final MemberCB cb = new MemberCB();

        // *Point!
        final LikeSearchOption option = new LikeSearchOption().likeContain().splitBySpace();
        cb.query().setMemberName_LikeSearch(keyword, option);

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log("memberName=" + member.getMemberName());
            assertTrue(member.getMemberName().contains("S"));
            assertTrue(member.getMemberName().contains("jko"));
            assertTrue(member.getMemberName().contains("ic"));
        }

        // [Description]
        // A. 全角空白も区切りとしたい場合は、splitBySpaceContainsDoubleByte()を利用。
        // new LikeSearchOption().likeContain().splitBySpaceContainsDoubleByte();
        //
        // B. スプリットする有効数を限定したい場合は、splitBySpace(int limit)を利用。
        //    --> 指定された数以降の条件要素は無視される
        // new LikeSearchOption().likeContain().splitBySpace(5);
        //
        // C. Or条件で連結したいときは、splitByXxx()の後に続いてasOrSplit()を呼び出す。
        // new LikeSearchOption().likeContain().splitBySpace().asOrSplit();
    }

    /**
     * 空白区切りの連結曖昧検索(Or条件): option.likeContain().splitBySpace().asOrSplit().
     * 画面から空白区切りでキーワードを入力して検索する場合などに有効な機能。
     * 明示的に指定することによって「Or条件」で連結することができる。
     */
    @Test
    @Transactional
    public void test_query_setMember_LikeSearch_likeContain_splitBySpace_asOrSplit_Tx() {
        // ## Arrange ##
        final String keyword = "Sto avi uke";
        final MemberCB cb = new MemberCB();

        // *Point!
        final LikeSearchOption option = new LikeSearchOption().likeContain().splitBySpace().asOrSplit();
        cb.query().setMemberName_LikeSearch(keyword, option);

        // ## Act ##
        final List<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertNotNull(memberList);
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            final String memberName = member.getMemberName();
            this.log("memberName=" + memberName);
            assertTrue(memberName.contains("Sto") || memberName.contains("avi") || memberName.contains("uke"));
        }

        // [Description]
        // A. 全角空白も区切りとしたい場合は、splitBySpaceContainsDoubleByte()を利用
    }

    //
    // 以下、LikeSearchで指定された条件値を変換して比較するオプション：
    //
    // [大文字小文字]
    // new LikeSearchOption().toLowerCase() --> 小文字に変換して比較
    // new LikeSearchOption().toUpperCase() --> 大文字に変換して比較
    //
    // ※大文字小文字を区別しない検索をする場合は、あらかじめDB上の該当カラムのデータを
    //  大文字統一もしくは小文字統一しておく必要がある。
    //  (大文字小文字を区別しない検索専用のカラムを作成)
    //
    // [半角変換]
    // new LikeSearchOption().toSingleByteSpace() --> 全角空白を半角空白に変換して比較
    // new LikeSearchOption().toSingleByteAlphabetNumber() --> 全角のアルファベットと数字を半角に変換して比較
    //
    // [日本語]
    // new LikeSearchOption().localJapanese().removeLastLongVowel() --> 例えば「オーダー」の最後の「ー」を除去して「オーダ」として比較
    // new LikeSearchOption().localJapanese().toDoubleByteKatakana() --> 半角カタカナを全角カタカナに変換して比較
    //

    // -----------------------------------------------------
    //                                          Column Query
    //                                          ------------
    /**
     * カラム同士の比較条件: columnQuery().
     * 正式会員日時が退会日時よりも昔の会員を検索。
     * @since 0.9.5.3
     */
    @Test
    @Transactional
    public void test_columnQuery_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(final MemberCB cb) {
                cb.specify().columnFormalizedDatetime();
            }
        }).lessThan(new SpecifyQuery<MemberCB>() {
            public void specify(final MemberCB cb) {
                cb.specify().specifyMemberWithdrawalAsOne().columnWithdrawalDatetime();
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log(member);
        }

        // [Description]
        // A. それぞれのSpecifyQueryで必ず一つずつカラムを指定する(無し or 複数は例外)
        // B. setupSelectやqueryForeignされてないリレーションを指定しても自動で同期する
        //    ※但し、fixedConditionでBind引数が必要なリレーションは事前にsetupSelectやqueryForeignが必要
        // C. 型の違うカラム同士の比較は正常動作するかエラーになるかはDB次第
    }

    // -----------------------------------------------------
    //                                        ExistsReferrer
    //                                        --------------
    /**
     * Exists句の中でUnion: existsXxxList(), union().
     * 商品名称に's'もしくは'a'が含まれる商品を購入したことのある会員を検索。
     */
    @Test
    @Transactional
    public void test_query_exists_union_Tx() {
        final MemberCB cb = new MemberCB();
        final LikeSearchOption option = new LikeSearchOption().likeContain();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB purchaseCB) {
                purchaseCB.query().setPurchaseCount_GreaterThan(2);
                purchaseCB.union(new UnionQuery<PurchaseCB>() {
                    public void query(final PurchaseCB purchaseUnionCB) {
                        purchaseUnionCB.query().queryProduct().setProductName_LikeSearch("s", option);
                    }
                });
                purchaseCB.union(new UnionQuery<PurchaseCB>() {
                    public void query(final PurchaseCB purchaseUnionCB) {
                        purchaseUnionCB.query().queryProduct().setProductName_LikeSearch("a", option);
                    }
                });
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        final ConditionBeanSetupper<PurchaseCB> setuppper = new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB cb) {
                cb.setupSelect_Product();
            }
        };
        this.memberBhv.loadPurchaseList(memberList, setuppper);
        for (final Member member : memberList) {
            this.log("[member] " + member.getMemberId() + ", " + member.getMemberName());
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean existsPurchase = false;
            for (final Purchase purchase : purchaseList) {
                final Product product = purchase.getProduct();
                final Integer purchaseCount = purchase.getPurchaseCount();
                final String productName = product.getProductName();
                this.log("  [purchase] " + purchase.getPurchaseId() + ", " + purchaseCount + ", " + productName);
                if (purchaseCount > 2 || productName.contains("s") || productName.contains("a")) {
                    existsPurchase = true;
                }
            }
            assertTrue(existsPurchase);
        }
    }

    // -----------------------------------------------------
    //                                      Nulls First/Last
    //                                      ----------------
    /**
     * nullを最初に並べる: addOrderBy_Xxx_Asc().withNullsFirst().
     * 生年月日の昇順でnullのものは最初に並べる。
     */
    @Test
    @Transactional
    public void test_query_addOrderBy_withNullsFirst_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_Birthdate_Asc().withNullsFirst();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        boolean nulls = true;
        for (final Member member : memberList) {
            final Date birthdate = member.getBirthdate();
            this.log(member.getMemberId() + ", " + member.getMemberName() + ", " + birthdate);
            if (nulls) {
                if (birthdate != null) {
                    nulls = false;
                    continue;
                }
                assertNull(birthdate);
            } else {
                assertNotNull(birthdate);
            }
        }
        assertFalse(nulls);
    }

    /**
     * nullを最後に並べる: addOrderBy_Xxx_Asc().withNullsLast().
     * 生年月日の昇順でnullのものは最後に並べる。
     */
    @Test
    @Transactional
    public void test_query_addOrderBy_withNullsLast_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().addOrderBy_Birthdate_Asc().withNullsLast();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        boolean nulls = false;
        for (final Member member : memberList) {
            final Date birthdate = member.getBirthdate();
            this.log(member.getMemberId() + ", " + member.getMemberName() + ", " + birthdate);
            if (nulls) {
                assertNull(birthdate);
            } else {
                if (birthdate == null) {
                    nulls = true;
                    continue;
                }
                assertNotNull(birthdate);
            }
        }
        assertTrue(nulls);
    }

    /**
     * nullを最後に並べる(Unionと共演): addOrderBy_Xxx_Asc().withNullsLast(), union().
     * 生年月日のあるなしでUnionでがっちゃんこして、生年月日の昇順でnullのものは最後に並べる。
     */
    @Test
    @Transactional
    public void test_query_addOrderBy_withNullsLast_and_union_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setBirthdate_IsNull();
        cb.union(new UnionQuery<MemberCB>() {
            public void query(final MemberCB unionCB) {
                unionCB.query().setBirthdate_IsNotNull();
            }
        });
        cb.query().addOrderBy_Birthdate_Asc().withNullsLast();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        boolean nulls = false;
        for (final Member member : memberList) {
            final Date birthday = member.getBirthdate();
            this.log(member.getMemberId() + ", " + member.getMemberName() + ", " + birthday);
            if (nulls) {
                assertNull(birthday);
            } else {
                if (birthday == null) {
                    nulls = true;
                    continue;
                }
                assertNotNull(birthday);
            }
        }
        assertTrue(nulls);
    }

    // -----------------------------------------------------
    //                                          Manual Order
    //                                          ------------
    /**
     * 手動で並べる: addOrderBy_Xxx_Asc().withManualOrder().
     * 会員ステータス「退会会員」・「正式会員」・「仮会員」の順で並べる。
     */
    @Test
    @Transactional
    public void test_query_addOrderBy_withManualOrder_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        final List<String> manualValueList = new ArrayList<String>();
        manualValueList.add(CDef.MemberStatus.退会会員.code());
        manualValueList.add(CDef.MemberStatus.正式会員.code());
        manualValueList.add(CDef.MemberStatus.仮会員.code());
        cb.query().addOrderBy_MemberStatusCode_Asc().withManualOrder(manualValueList);
        cb.query().addOrderBy_Birthdate_Desc().withNullsLast();
        cb.query().addOrderBy_MemberName_Asc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        final LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        for (final Member member : memberList) {
            final String memberStatusCode = member.getMemberStatusCode();
            this.log(member.getMemberId() + ", " + member.getMemberName() + ", " + memberStatusCode);
            linkedHashSet.add(memberStatusCode);
        }
        final List<String> list = new ArrayList<String>(linkedHashSet);
        assertEquals(CDef.MemberStatus.退会会員.code(), list.get(0));
        assertEquals(CDef.MemberStatus.正式会員.code(), list.get(1));
        assertEquals(CDef.MemberStatus.仮会員.code(), list.get(2));

        // [Description]
        // A. Unionと共演できない(UnsupportedOperationException)
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    /**
     * Unionのループによる不定数設定: for { cb.union() }.
     */
    @Test
    @Transactional
    public void test_selectList_union_LoopIndefiniteSetting_Tx() {
        // ## Arrange ##
        final String keywordDelimiterString = "S M D";
        final List<String> keywordList = Arrays.asList(keywordDelimiterString.split(" "));

        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();

        final LikeSearchOption prefixOption = new LikeSearchOption().likePrefix();
        boolean first = true;
        for (final String keyword : keywordList) {
            if (first) {
                cb.query().setMemberAccount_LikeSearch(keyword, prefixOption);
                first = false;
                continue;
            }
            cb.union(new UnionQuery<MemberCB>() {
                public void query(final MemberCB unionCB) {
                    unionCB.query().setMemberAccount_LikeSearch(keyword, prefixOption);
                }
            });
        }

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        this.log("/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            final String memberName = member.getMemberName();
            final String memberAccount = member.getMemberAccount();
            this.log(memberName + "(" + memberAccount + ")");
            assertTrue("Unexpected memberAccount = " + memberAccount,
                    memberAccount.startsWith("S") || memberAccount.startsWith("M") || memberAccount.startsWith("D"));
        }
        this.log("* * * * * * * * * */");
    }

    /**
     * Unionを使ったページング検索: union(), selectPage().
     * 絞り込み条件は「退会会員であること」もしくは「１５００円以上の購入をしたことがある」。
     * 「誕生日の降順＆会員IDの昇順」で並べて、１ページを３件としてページング検索。
     * <pre>
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
    public void test_selectPage_union_existsSubQuery_Tx() {
        // ## Arrange ##
        final int fetchSize = 3;
        final MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_退会会員();
        cb.union(new UnionQuery<MemberCB>() {
            public void query(final MemberCB unionCB) {
                unionCB.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
                    public void query(final PurchaseCB subCB) {
                        subCB.query().setPurchasePrice_GreaterEqual(1500);
                    }
                });
            }
        });
        cb.query().addOrderBy_Birthdate_Desc().addOrderBy_MemberId_Asc();

        // ## Act ##
        cb.paging(fetchSize, 1);
        final PagingResultBean<Member> page1 = this.memberBhv.selectPage(cb);
        cb.paging(fetchSize, 2);
        final PagingResultBean<Member> page2 = this.memberBhv.selectPage(cb);
        cb.paging(fetchSize, 3);
        final PagingResultBean<Member> page3 = this.memberBhv.selectPage(cb);
        cb.paging(fetchSize, page1.getAllPageCount());// Last Page
        final PagingResultBean<Member> lastPage = this.memberBhv.selectPage(cb);

        // ## Assert ##
        this.showPage(page1, page2, page3, lastPage);
        assertEquals(fetchSize, page1.size());
        assertEquals(fetchSize, page2.size());
        assertEquals(fetchSize, page3.size());
        assertNotSame(page1.get(0).getMemberId(), page2.get(0).getMemberId());
        assertNotSame(page2.get(0).getMemberId(), page3.get(0).getMemberId());
        assertNotSame(page3.get(0).getMemberId(), lastPage.get(0).getMemberId());
        assertEquals(1, page1.getCurrentPageNumber());
        assertEquals(2, page2.getCurrentPageNumber());
        assertEquals(3, page3.getCurrentPageNumber());
        assertEquals(page1.getAllPageCount(), lastPage.getCurrentPageNumber());
        assertEquals(page1.getAllRecordCount(), page2.getAllRecordCount());
        assertEquals(page2.getAllRecordCount(), page3.getAllRecordCount());
        assertEquals(page3.getAllRecordCount(), lastPage.getAllRecordCount());
        assertEquals(page1.getAllPageCount(), page2.getAllPageCount());
        assertEquals(page2.getAllPageCount(), page3.getAllPageCount());
        assertEquals(page3.getAllPageCount(), lastPage.getAllPageCount());
        assertFalse(page1.isExistPrePage());
        assertTrue(page1.isExistNextPage());
        assertTrue(lastPage.isExistPrePage());
        assertFalse(lastPage.isExistNextPage());

        final ConditionBeanSetupper<PurchaseCB> setupper = new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB cb) {
                cb.query().setPurchasePrice_GreaterEqual(1500);
            }
        };
        this.memberBhv.loadPurchaseList(page1, setupper);
        this.memberBhv.loadPurchaseList(page2, setupper);
        this.memberBhv.loadPurchaseList(page3, setupper);
        this.memberBhv.loadPurchaseList(lastPage, setupper);
        final SelectPageUnionExistsReferrerAssertBoolean bl = new SelectPageUnionExistsReferrerAssertBoolean();
        this.findTarget_of_selectPage_union_existsSubQuery(page1, bl);
        this.findTarget_of_selectPage_union_existsSubQuery(page2, bl);
        this.findTarget_of_selectPage_union_existsSubQuery(page3, bl);
        this.findTarget_of_selectPage_union_existsSubQuery(lastPage, bl);
        assertTrue(bl.isExistsWithdrawalOnly());
        assertTrue(bl.isExistsPurchasePriceOnly());

        this.log("/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * ");
        this.log(getLineSeparator() + cb.toDisplaySql());
        this.log("* * * * * * * * * */");
    }

    protected void findTarget_of_selectPage_union_existsSubQuery(final PagingResultBean<Member> memberPage,
            final SelectPageUnionExistsReferrerAssertBoolean bl) {
        for (final Member member : memberPage) {
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean existsPurchaseTarget = false;
            for (final Purchase purchase : purchaseList) {
                if (purchase.getPurchasePrice() >= 1500) {
                    existsPurchaseTarget = true;
                }
            }
            if (!existsPurchaseTarget && member.isMemberStatusCode退会会員()) {
                bl.setExistsWithdrawalOnly(true);
            } else if (existsPurchaseTarget && !member.isMemberStatusCode退会会員()) {
                bl.setExistsPurchasePriceOnly(true);
            }
        }
    }

    protected static class SelectPageUnionExistsReferrerAssertBoolean {
        protected boolean existsWithdrawalOnly = false;
        protected boolean existsPurchasePriceOnly = false;

        public boolean isExistsWithdrawalOnly() {
            return this.existsWithdrawalOnly;
        }

        public void setExistsWithdrawalOnly(final boolean existsWithdrawalOnly) {
            this.existsWithdrawalOnly = existsWithdrawalOnly;
        }

        public boolean isExistsPurchasePriceOnly() {
            return this.existsPurchasePriceOnly;
        }

        public void setExistsPurchasePriceOnly(final boolean existsPurchasePriceOnly) {
            this.existsPurchasePriceOnly = existsPurchasePriceOnly;
        }
    }

    // ===================================================================================
    //                                                                            OnClause
    //                                                                            ========
    /**
     * OnClause(On句)に条件を追加: queryXxx().on().
     * <code>{left outer join xxx on xxx = xxx and [column] = ?}</code>
     * <p>
     * 「会員退会情報が存在している会員一覧」に対して、「退会理由コードがnullでない会員退会情報」を結合して取得。
     * 会員退会情報が存在していても退会理由コードがnullの会員は、会員退会情報が取得されないようにする。
     * </p>
     * <p>
     * OnClauseに条件を追加すると「条件に合致しない結合先レコードは結合しない」という感じになる。
     * よく使われるのは「従属しない関係の結合先テーブルで論理削除されたものは結合しない」というような場合。
     * </p>
     * <p>
     * OnClauseを使わないでWhere句に条件を入れると、条件に合致しない結合先レコードを
     * 参照している基点レコードが検索対象外になってしまう。<br />
     * <code>{left outer join xxx on xxx = xxx where [column] = ?}</code>
     * </p>
     * <pre>
     * 例えば、会員{1,2,3,4,5}に対して会員退会情報{A,B,C}があり、それぞれ{1-A, 2-B, 3-C, 4-null, 5-null}
     * というような関係で、「B」が退会理由コードを持っていない会員退会情報であった場合：
     *
     * 素直に「会員 left outer join 会員退会情報 on ...」すると結果は以下のようになる。
     *
     * 　　検索結果：{1-A, 2-B, 3-C, 4-null, 5-null}
     *
     * これを「会員 left outer join 会員退会情報 on ... and 会員退会情報.退会理由コード is not null」
     * というようにOn句の中で「退会理由コードが存在すること」という条件を付与すると以下のようになる。
     *
     * 　　検索結果：{1-A, 2-null, 3-C, 4-null, 5-null}
     *
     * 退会理由コードを持っていない「B」が弾かれて結合されないのである。
     * だからといって「2」の会員自体が検索結果から外れることはない。
     *
     * これを「会員 left outer join 会員退会情報 on ... where 会員退会情報.退会理由コード is not null」
     * というようにWhere句にて「退会理由コードが存在すること」という条件を付与すると以下のようになる。
     *
     * 　　検索結果：{1-A, 3-C}
     *
     * これは今回やりたい検索とは全く違うものである。
     * </pre>
     * <p>
     * OnClauseでなくInlineViewを使っても同じ動きを実現することは可能である。
     * しかし、条件によってはInlineViewの中でフルスキャンが走ってしまう可能性もあるので、
     * パフォーマンスの観点からOnClauseの方が良いかと思われる。(実行計画が異なる)
     * 但し、これはオプティマイザ次第なので、気になったらどちらかに調整するのが良いと思われる。<br />
     * <code>{left outer join (select * from xxx where [column] = ?) xxx on xxx = xxx}</code>
     * </p>
     */
    @Test
    @Transactional
    public void test_selectList_query_queryForeign_on_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberWithdrawalAsOne();

        // 「退会理由コードがnullでない会員退会情報」のレコードは結合されてないようにする
        // left outer join xxx on xxx = xxx and WithdrawalReasonCode is not null
        cb.query().queryMemberWithdrawalAsOne().on().setWithdrawalReasonCode_IsNotNull();

        // left outer join (select * from xxx where WithdrawalReasonCode is not null) xxx on xxx = xxx
        // cb.query().queryMemberWithdrawalAsOne().inline().setWithdrawalReasonCode_IsNotNull();

        // 会員退会情報が存在する会員だけを取得するようにする
        cb.query().inScopeMemberWithdrawalAsOne(new SubQuery<MemberWithdrawalCB>() {
            public void query(final MemberWithdrawalCB subCB) {
            }
        });
        cb.query().queryMemberWithdrawalAsOne().addOrderBy_WithdrawalDatetime_Desc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        boolean existsMemberWithdrawal = false;// 会員退会情報があってWithdrawalReasonCodeも存在する会員がいるか否か
        boolean notExistsMemberWithdrawal = false;// 会員退会情報はあるけどWithdrawalReasonCodeがない会員がいるか否か
        final List<Integer> notExistsMemberIdList = new ArrayList<Integer>();
        for (final Member member : memberList) {
            final MemberWithdrawal memberWithdrawal = member.getMemberWithdrawalAsOne();
            if (memberWithdrawal != null) {
                this.log(member.getMemberName() + " -- " + memberWithdrawal.getWithdrawalReasonCode() + ", "
                        + memberWithdrawal.getWithdrawalDatetime());
                final String withdrawalReasonCode = memberWithdrawal.getWithdrawalReasonCode();
                assertNotNull(withdrawalReasonCode);
                existsMemberWithdrawal = true;
            } else {
                // 会員退会情報は存在するけどWithdrawalReasonCodeが存在しない会員も取得できていること
                this.log(member.getMemberName() + " -- " + memberWithdrawal);
                notExistsMemberWithdrawal = true;
                notExistsMemberIdList.add(member.getMemberId());
            }
        }
        // 両方のパターンのデータがないとテストにならないので確認
        assertTrue(existsMemberWithdrawal);
        assertTrue(notExistsMemberWithdrawal);
        // MemberWithdrawalを取得できなかった会員の会員退会情報がちゃんとあるかどうか確認
        for (final Integer memberId : notExistsMemberIdList) {
            this.memberWithdrawalBhv.selectByPKValueWithDeletedCheck(memberId);// Expected no exception
        }
    }

    // ===================================================================================
    //                                                                      Specify Column
    //                                                                      ==============
    /**
     * 取得カラムの指定(SpecifyColumn): specify().columnXxx().
     * 会員名称と会員ステータス名称だけの一覧を検索する。
     * <p>
     * パフォーマンス上の考慮で１ミリ秒でも速くしたいシビアな検索処理の場合のために、
     * 取得カラムを指定することができる。１テーブルのカラム数がやたら多いときに有効。
     * </p>
     * @since 0.7.4
     */
    @Test
    @Transactional
    public void test_specifyColumn_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.specify().columnMemberName();
        cb.specify().specifyMemberStatus().columnMemberStatusName();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            assertNotNull(member.getMemberId()); // PK
            assertNotNull(member.getMemberName()); // Specified
            assertNull(member.getMemberAccount());
            assertNull(member.getBirthdate());
            assertNull(member.getFormalizedDatetime());
            assertNull(member.getRegisterDatetime());
            assertNull(member.getRegisterUser());
            assertNull(member.getUpdateDatetime());
            assertNull(member.getUpdateUser());
            assertNull(member.getVersionNo());
            assertNotNull(member.getMemberStatusCode()); // SetupSelect FK
            assertNotNull(member.getMemberStatus().getMemberStatusCode()); // PK
            assertNotNull(member.getMemberStatus().getMemberStatusName()); // Specified
            assertNull(member.getMemberStatus().getDisplayOrder());
        }

        // [Description]
        // A. 結合先テーブルに関しては、setupSelect_Xxx()を呼び出すことに変わりはなく、
        //    setupSelectしたテーブルの中から取得するカラムを指定する。
        //    --> setupSelectしてないテーブルのカラムを指定すると例外となる。
        //
        // B. カラムが指定されたテーブルのみカラムが絞り込まれ、カラムが指定されないテーブルは
        //    通常通り全てのカラムが取得される。
        //    --> 例えば、ある一つの結合先テーブルだけカラム指定にすることも可能
        //
        // C. PKは、カラムが指定されなくても必ず取得される。(暗黙の指定カラム)
        // D. SetupSelectされたFKは、カラムが指定されなくても必ず取得される。(暗黙の指定カラム)
    }

    // ===================================================================================
    //                                                            (Specify)DerivedReferrer
    //                                                            ========================
    /**
     * 子テーブル導出カラムの指定((Specify)DerivedReferrer)-Max: specify().derivedXxxList().max().
     * 会員の最終ログイン日時を取得。但し、モバイル端末からのログインは除く。
     * <p>
     * 子テーブルの導出カラムを指定することができる。
     * 例えば、子テーブルのとあるカラムの合計値や最大値などを取得することが可能である。
     * 例題のSQL文のイメージは以下の通り：
     * </p>
     * <pre>
     * ex) 最終ログイン日時を取得するSQL
     * select member.*
     *      , (select max(LOGIN_DATETIME)
     *           from MEMBER_LOGIN
     *          where MEMBER_ID = member.MEMBER_ID
     *            and LOGIN_MOBILE_FLG = 0
     *        ) as LATEST_LOGIN_DATETIME
     *   from MEMBER member
     * </pre>
     * @since 0.7.4
     */
    @Test
    @Transactional
    public void test_sepcify_derivedReferrer_max_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(final MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();// *Point!
                subCB.query().setMobileLoginFlg_Equal_False();// Except Mobile
            }
        }, Member.ALIAS_latestLoginDatetime);

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        boolean existsLoginDatetime = false;
        boolean existsNullLoginDatetime = false;
        for (final Member member : memberList) {
            final String memberName = member.getMemberName();
            final Date latestLoginDatetime = member.getLatestLoginDatetime();
            if (latestLoginDatetime != null) {
                existsLoginDatetime = true;
            } else {
                // ログインを一度もしていない会員、もしくは、モバイルでしかログイン
                // したことのない会員の最終ログイン日時はnullになる。
                existsNullLoginDatetime = true;
            }
            this.log("memberName=" + memberName + ", latestLoginDatetime=" + latestLoginDatetime);
        }
        assertTrue(existsLoginDatetime);
        assertTrue(existsNullLoginDatetime);

        // [Description]
        // A. 実装前に導出カラムを受け取るためのプロパティをEntityに定義する必要がある。
        //
        //    ex) ExtendedのEntity(ExEntity)に最終ログイン日時のプロパティを手動で実装
        //    protected Date _latestLoginDatetime;
        //    public Date getLatestLoginDatetime() {
        //        return _latestLoginDatetime;
        //    }
        //    public void setLatestLoginDatetime(Date latestLoginDatetime) {
        //        _latestLoginDatetime = latestLoginDatetime;
        //    }
        //
        // B. 関数には、{max, min, sum, avg, count}が利用可能である。
        //    --> sumとavgは数値型のみ利用可能
        //    --> countの場合は子テーブルのPKを導出カラムとすることが基本
        //
        // C. 必ずSubQueryの中で導出カラムを「一つ」指定すること。
        //    --> 何も指定しない、もしくは、二つ以上の指定で例外発生
        //
        // D. 導出カラムは子テーブルのカラムのみサポートされる。
        //    --> 子テーブルの別の親テーブル(もしくはone-to-one)のカラムを導出カラムにはできない。
        //
        // E. 基点テーブルが複合主キーの場合はサポートされない。
        //
        // F. one-to-oneの子テーブルの場合はサポートされない。(そもそも不要である)
        //
        // G. SubQueryの中でsetupSelectやaddOrderByを指定しても無意味である。
        //
        // H. SpecifyColumnやUnionとも組み合わせて利用することが可能である。
        //
        // X. Eclipse(3.3)でのSubQuery実装手順：
        //    X-1. cb.sp まで書いて補完してEnter!
        //         --> cb.specify() になる
        //
        //    X-2. cb.specify().der まで書いて補完して子テーブルを選択してEnter!
        //         --> cb.specify().deriveMemberLoginList() になる
        //
        //    X-3. cb.specify().deriveMemberLoginList().ma まで書いて補完してEnter!
        //         --> cb.specify().deriveMemberLoginList().max(subQuery, aliasName) になる
        //             このとき[subQuery]部分が選択状態である
        //
        //    X-4. cb.specify().deriveMemberLoginList().max(new , aliasName) まで書いて補完してEnter!
        //         --> カーソル位置から入力する文字は「new 」
        //         --> cb.specify().deriveMemberLoginList().max(new SubQuery<MemberLoginCB>, aliasName) になる
        //
        //    X-5. cb.specify().deriveMemberLoginList().max(new SubQuery<MemberLoginCB>() {, aliasName) まで書いて補完してEnter!
        //         --> カーソル位置から入力する文字は「() {」
        //         --> cb.specify().deriveMemberLoginList().max(new SubQuery<MemberLoginCB>() {
        //             } , aliasName)
        //             になる
        //         --> [SubQuery<MemberLoginCB>]部分がコンパイルエラーになる
        //
        //    X-6. コンパイルエラーの[SubQuery<MemberLoginCB>]にカーソルを合わせてctrl + 1を押してEnter!
        //         --> cb.specify().deriveMemberLoginList().max(new SubQuery<MemberLoginCB>() {
        //                 public void query(MemberLoginCB subCB) {
        //                     // todo Auto-generated method stub
        //                 }
        //             } , aliasName)
        //             になる
        //         --> [aliasName]部分とセミコロンがないことでまだコンパイルエラーである
        //
        //    X-7. aliasNameを指定して、セミコロンも付ける
        //         --> cb.specify().deriveMemberLoginList().max(new SubQuery<MemberLoginCB>() {
        //                 public void query(MemberLoginCB subCB) {
        //                     // todo Auto-generated method stub
        //                 }
        //             } , "LATEST_LOGIN_DATETIME");
        //
        //    X-8. TODOのコメント消して子テーブルの「導出カラムの指定」と「絞り込み条件」を実装する
    }

    /**
     * 子テーブル導出カラムで並び替え(SpecifiedDerivedOrderBy)-Count: addSpecifiedDerivedOrderBy_Desc().
     * 会員のログイン回数を取得する際に、ログイン回数の多い順そして会員IDの昇順で並べる。但し、モバイル端末からのログインは除く。
     * <p>
     * 子テーブルの導出カラムで並び替えをすることができる。
     * SQL文のイメージは以下の通り：
     * </p>
     * <pre>
     * ex) ログイン回数を取得するSQL
     * select member.*
     *      , (select count(MEMBER_LOGIN_ID)
     *           from MEMBER_LOGIN
     *          where MEMBER_ID = member.MEMBER_ID
     *        ) as LOGIN_COUNT
     *   from MEMBER member
     *  order by LOGIN_COUNT desc, member.MEMBER_ID asc
     * </pre>
     * @since 0.7.4
     */
    @Test
    @Transactional
    public void test_query_addSepcifidDerivedOrderBy_count_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().count(new SubQuery<MemberLoginCB>() {
            public void query(final MemberLoginCB subCB) {
                subCB.specify().columnMemberLoginId();// *Point!
                subCB.query().setMobileLoginFlg_Equal_False();// Except Mobile
            }
        }, Member.ALIAS_loginCount);
        cb.query().addSpecifiedDerivedOrderBy_Desc(Member.ALIAS_loginCount);
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            final String memberName = member.getMemberName();
            final Integer loginCount = member.getLoginCount();
            assertNotNull(loginCount);// count()なので0件の場合は0になる(DB次第かも...)
            this.log("memberName=" + memberName + ", loginCount=" + loginCount);
        }

        // [Description]
        // A. (Specify)DerivedReferrerで指定されていないAliasNameを指定すると例外発生。
        //
        // B. withNullsFirst/Last()と組み合わせることも可能
        //    cb.query().addSpecifiedDerivedOrderBy_Desc("LOGIN_COUNT").withNullsLast();
    }

    /**
     * 子テーブルカラムの種類数取得((Specify)DerivedReferrer)-CountDisticnt: derivedXxxList(), countDistinct().
     * それぞれの会員の「購入済みプロダクトの種類数」を検索。
     * @since 0.8.8
     */
    @Test
    @Transactional
    public void test_sepcify_derivedReferrer_countDistinct_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().countDistinct(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.specify().columnProductId();
                subCB.query().setPaymentCompleteFlg_Equal_True();
            }
        }, Member.ALIAS_productKindCount);
        cb.query().addSpecifiedDerivedOrderBy_Desc(Member.ALIAS_productKindCount);
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            final String memberName = member.getMemberName();
            final Integer productKindCount = member.getProductKindCount();
            assertNotNull(productKindCount);// count()なので0件の場合は0になる(DB次第かも...)
            this.log("memberName=" + memberName + ", productKindCount=" + productKindCount);
        }
        assertTrue(cb.toDisplaySql().contains("count(distinct"));
    }

    // ===================================================================================
    //                                                              (Query)DerivedReferrer
    //                                                              ======================
    /**
     * 子テーブル導出カラムで絞り込み((Query)DerivedReferrer)-Max: derivedXxx(), max(), greaterEqual().
     * 最大購入価格が1800円以上の支払済み購入のある会員一覧を検索。
     * @since 0.8.8.1
     */
    @Test
    @Transactional
    public void test_query_derivedReferrer_max_greaterEqual_Tx() {
        // ## Arrange ##
        final Integer expected = 1800;

        final MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_正式会員();
        cb.query().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(final PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice(); // *Point!
                subCB.query().setPaymentCompleteFlg_Equal_True();
            }
        }).greaterEqual(expected); // *Don't forget!

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        this.memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(final PurchaseCB cb) {
                cb.query().setPaymentCompleteFlg_Equal_True();
            }
        });
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log(member);
            final List<Purchase> purchaseList = member.getPurchaseList();
            boolean exists = false;
            for (final Purchase purchase : purchaseList) {
                final Integer purchasePrice = purchase.getPurchasePrice();
                if (purchasePrice >= expected) {
                    exists = true;
                }
            }
            assertTrue(exists);
        }

        // [SQL]
        // select dflocal.MEMBER_NAME as MEMBER_NAME, ...
        //   from MEMBER dflocal
        //  where dflocal.MEMBER_STATUS_CODE = 'FML'
        //    and (select max(dfsublocal_0.PURCHASE_PRICE)
        //           from PURCHASE dfsublocal_0
        //          where dfsublocal_0.MEMBER_ID = dflocal.MEMBER_ID
        //            and dfsublocal_0.PAYMENT_COMPLETE_FLG = 1
        //        ) >= 1800

        // [Description]
        // A. 比較演算子には、{=, >=, >, <=, <}が利用可能である。
        //
        // B. 関数には、{max, min, sum, avg, count, countDistinct}が利用可能である。
        //    --> sumとavgとcountとcountDistinctは数値型のみ利用可能
        //    --> countの場合は子テーブルのPKを導出カラムとすることが基本
        //
        // C. 必ずSubQueryの中で導出カラムを「一つ」指定すること。
        //    --> 何も指定しない、もしくは、二つ以上の指定で例外発生
        //
        // D. 導出カラムは基点テーブルのカラムのみサポートされる。
        //
        // E. 基点テーブルが複合主キーの場合はサポートされない。
        //
        // F. 必ずカラムの型とパラメータの型を合わせること！(count()とcountDistinct()は除く)
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * 最大値レコードの検索(ScalarCondition)-Max: scalar_Equal(), max().
     * 正式会員の中で一番若い(誕生日が最大値である)会員を検索。
     * @since 0.8.8
     */
    @Test
    @Transactional
    public void test_scalarCondition_Equal_max_Tx() {
        // ## Arrange ##
        final Date expected = this.selectExpectedMaxBirthdayOn正式会員();

        final MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_正式会員();
        cb.query().scalar_Equal().max(new SubQuery<MemberCB>() {
            public void query(final MemberCB subCB) {
                subCB.specify().columnBirthdate(); // *Point!
                subCB.query().setMemberStatusCode_Equal_正式会員();
            }
        });

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            final Date Birthdate = member.getBirthdate();
            assertEquals(expected, Birthdate);
        }

        // [SQL]
        // select dflocal.MEMBER_NAME as MEMBER_NAME, ...
        //   from MEMBER dflocal
        //  where dflocal.MEMBER_STATUS_CODE = 'FML'
        //    and dflocal.MEMBER_BIRTHDAY = (select max(dfsublocal_0.MEMBER_BIRTHDAY)
        //                                     from MEMBER dfsublocal_0
        //                                    where dfsublocal_0.MEMBER_STATUS_CODE = 'FML'
        //        )

        // [Description]
        // A. 比較演算子には、{=, >=, >, <=, <}が利用可能である。
        //
        // B. 関数には、{max, min, sum, avg}が利用可能である。
        //    --> sumとavgは数値型のみ利用可能
        //
        // C. 必ずSubQueryの中で導出カラムを「一つ」指定すること。
        //    --> 何も指定しない、もしくは、二つ以上の指定で例外発生
        //
        // D. 導出カラムは基点テーブルのカラムのみサポートされる。
        //
        // E. 基点テーブルが複合主キーの場合はサポートされない。
        //
        // F. 「とあるカラムの値が平均値を超えるレコードを検索」というのも可能である。
        //    cb.query().scalar_GreaterThan().avg(new SubQuery<Xxx>) {...
    }

    protected Date selectExpectedMaxBirthdayOn正式会員() {
        Date expected = null;
        {
            final MemberCB cb = new MemberCB();
            cb.query().setMemberStatusCode_Equal_正式会員();
            final ListResultBean<Member> listAll = this.memberBhv.selectList(cb);
            for (final Member member : listAll) {
                final Date day = member.getBirthdate();
                if (day != null && (expected == null || expected.getTime() < day.getTime())) {
                    expected = day;
                }
            }
        }
        return expected;
    }

    // ===================================================================================
    //                                                                     Fixed Condition
    //                                                                     ===============
    /**
     * 固定条件を加えたone-to-oneの取得：fixedCondition, selectSelect_Xxx(target).
     * <p>
     * 会員と会員住所は構造的にはone-to-manyだが、固定条件を加えることによってone-to-oneになる
     * という業務的な制約が存在する。その業務的な制約を活用して、会員を基点に会員住所を取得。
     * </p>
     * <p>
     * 「何かしら固定条件を付与することによってone-to-manyがone-to-oneになる」というような場合、
     * 「{DBFluteClient}/dfprop/additionalForeignKeyMap.dfprop」にて固定条件付きの疑似FK
     * を設定し自動生成し直すことで、アプリケーション上でそのRelationを扱うことができる。
     * </p>
     * <pre>
     * ; FK_MEMBER_MEMBER_ADDRESS_VALID = map:{
     *     ; localTableName  = MEMBER    ; foreignTableName  = MEMBER_ADDRESS
     *     ; localColumnName = MEMBER_ID ; foreignColumnName = MEMBER_ID
     *     ; fixedCondition =
     *      $$foreignAlias$$.VALID_BEGIN_DATE <= /[*]targetDate(Date)[*]/null
     *  and $$foreignAlias$$.VALID_END_DATE >= /[*]targetDate(Date)[*]/null
     *     ; fixedSuffix = AsValid
     * }
     * ※バインド変数コメントの「/[*]」の「[]」は実際には不要。JavaDoc上での記述の都合のために付けている。
     * </pre>
     * <p>
     * localTableName/foreignTableName/localColumnName/foreignColumnNameは通常の
     * additionalForeignKeyMapでの設定方法と特に変わらないが、foreignTableが構造的には
     * one-to-manyのmany側が指定されているのが特徴的である。
     * </p>
     * <p>
     * fixedConditionが注目ポイントである。fixedConditionには固定条件を指定。
     * これは「left outer join」のon句部分の結合条件としてそのまま展開される。
     * 「$$foreignAlias$$」はforeignTableのAlias名として実行時に置換される。
     * 「/[*]targetDate(Date)[*]/null」はバインド変数コメントとして解釈され、
     * 自動生成時にsetupSelect_Xxx()やqueryXxx()の引数として展開される。
     * その際、アプリケーション上の型は「(Date)」で指定された型となる。
     * 「Date」なら「java.util.Date」、「Integer」なら「java.lang.Integer」となる。
     * (ParameterBeanの型の自動解釈と同じである)
     * <p>
     * バインド変数コメントを使わずにベタッと値を指定することも可能。
     * 今回のExampleのような「有効期間」という概念で「固定条件に動的値」というのではなく、
     * 「有効フラグがtrueのものを指定するとone-to-oneになる」というような
     * 「固定条件に固定値」というパターンの場合はバインド変数コメントを使う必要はない。
     * その場合、setupSelect_Xxx()やqueryXxx()の引数は無しで通常通りである。
     * </p>
     * <p>
     * fixedSuffixは任意ではあるが、Relation名のユニーク性を厳密にするために
     * 何かしら意味のあるSuffixを付けることが推奨される。今回のExampleだと、
     * 「(会員を基点とした場合の)有効な会員住所」ということなので、「AsValid」
     * というSuffixを付けている。
     * </p>
     * @since 0.8.7
     */
    @Test
    @Transactional
    public void test_fixedCondition_setupSelect_Tx() {
        // ## Arrange ##
        final Calendar cal = Calendar.getInstance();
        cal.set(2005, 11, 12); // 2005/12/12
        final Date targetDate = cal.getTime();

        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberAddressAsValid(targetDate);
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        boolean existsAddress = false;
        final SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        final String formattedTargetDate = fmt.format(targetDate);
        this.log("[" + formattedTargetDate + "]");
        for (final Member member : memberList) {
            final String memberName = member.getMemberName();
            final MemberAddress memberAddressAsValid = member.getMemberAddressAsValid();
            if (memberAddressAsValid != null) {
                assertNotNull(memberAddressAsValid.getValidBeginDate());
                assertNotNull(memberAddressAsValid.getValidEndDate());
                final String validBeginDate = fmt.format(memberAddressAsValid.getValidBeginDate());
                final String validEndDate = fmt.format(memberAddressAsValid.getValidEndDate());
                assertTrue(validBeginDate.compareTo(formattedTargetDate) <= 0);
                assertTrue(validEndDate.compareTo(formattedTargetDate) >= 0);
                final String address = memberAddressAsValid.getAddress();
                this.log(memberName + ", " + validBeginDate + ", " + validEndDate + ", " + address);
                existsAddress = true;
            } else {
                this.log(memberName + ", null");
            }
        }
        assertTrue(existsAddress);
        assertFalse(cb.toDisplaySql().contains("where")); // not use where clause

        // [SQL]
        // select dflocal.MEMBER_NAME as MEMBER_NAME, ...
        //   from MEMBER dflocal
        //     left outer join MEMBER_ADDRESS dfrelation_1
        //       on dflocal.MEMBER_ID = dfrelation_1.MEMBER_ID
        //         and dfrelation_1.VALID_BEGIN_DATE <= '2005-12-12'
        //         and dfrelation_1.VALID_END_DATE >= '2005-12-12'
        //  order by dflocal.MEMBER_ID asc

        // [Description]
        // A. selectSelect_Xxx(target)で別の値のtargetを指定して二回以上呼び出した時は最後の値が有効
        //    --> 「2007/01/01の会員住所」と「2008/01/01の会員住所」を同時に取り扱うことはできない
        //        (additionalForeignKeyにてSuffixだけ変えたリレーションをもう一つ設定すれば可能)
        //
        // B. fixedConditionを使ったRelationではReferrer関連のメソッドは生成されない
        //    ex) 会員住所のBehaviorにて会員に対するloadReferrerは生成されない
    }

    /**
     * 固定条件を加えたone-to-oneの絞り込み：fixedCondition, queryXxx(target).
     * <p>
     * 会員と会員住所は構造的にはone-to-manyだが、固定条件を加えることによってone-to-oneになる
     * という業務的な制約が存在する。その業務的な制約を活用して、会員を基点に会員住所にて絞り込み。
     * </p>
     * @since 0.8.7
     */
    @Test
    @Transactional
    public void test_fixedCondition_query_Tx() {
        // ## Arrange ##
        final Calendar cal = Calendar.getInstance();
        cal.set(2005, 11, 12); // 2005/12/12
        final Date targetDate = cal.getTime();
        final String targetChar = "i";

        final MemberCB cb = new MemberCB();
        final LikeSearchOption likeSearchOption = new LikeSearchOption().likeContain();
        cb.query().queryMemberAddressAsValid(targetDate).setAddress_LikeSearch(targetChar, likeSearchOption);
        cb.query().queryMemberAddressAsValid(targetDate).addOrderBy_Address_Asc();
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        this.memberBhv.loadMemberAddressList(memberList, new ConditionBeanSetupper<MemberAddressCB>() {
            public void setup(final MemberAddressCB cb) {
                cb.query().setAddress_LikeSearch(targetChar, new LikeSearchOption().likeContain());
                cb.query().setValidBeginDate_LessEqual(targetDate);
                cb.query().setValidEndDate_GreaterEqual(targetDate);
            }
        });
        final SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
        final String formattedTargetDate = fmt.format(targetDate);
        this.log("[" + formattedTargetDate + "]");
        for (final Member member : memberList) {
            final MemberAddress memberAddressAsValid = member.getMemberAddressAsValid();
            assertNull(memberAddressAsValid); // because of no setup-select.
            final List<MemberAddress> memberAddressList = member.getMemberAddressList();
            assertEquals(1, memberAddressList.size());
            final MemberAddress memberAddress = memberAddressList.get(0);
            final String memberName = member.getMemberName();
            final Date validBeginDate = memberAddress.getValidBeginDate();
            final Date validEndDate = memberAddress.getValidEndDate();
            final String address = memberAddress.getAddress();
            this.log(memberName + ", " + validBeginDate + ", " + validEndDate + ", " + address);
            assertTrue(memberAddress.getAddress().contains("a"));
        }

        // [Description]
        // A. queryXxx(target)で別の値のtargetを指定して二回以上呼び出した時は最後の値が有効
        //    --> 「2007/01/01の会員住所」と「2008/01/01の会員住所」を同時に取り扱うことはできない
        //
        // B. fixedConditionを使ったRelationではReferrer関連のメソッドは生成されない
        //    ex) 会員住所のBehaviorにて会員に対するloadReferrerは生成されない
    }

    // ===================================================================================
    //                                                                    Statement Config
    //                                                                    ================
    /**
     * Statementのコンフィグを設定: cb.configure(statementConfig).
     */
    @Test
    @Transactional
    public void test_configure_statementConfig_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.configure(new StatementConfig().typeForwardOnly().queryTimeout(7).fetchSize(4).maxRows(3));

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertEquals(3, memberList.size());
    }

    // ===================================================================================
    //                                                                        ArrangeQuery
    //                                                                        ============
    /**
     * where句の再利用(ArrangeQuery): cb.query().arrangeXxx().
     * サービス会員を検索する。サービス会員は、商品ID "3" を購入したことのある、
     * 会員名称が "S" で始まる正式会員とここでは定義する。
     * <p>
     * ConditionQueryのExクラスに業務的にまとまった単位の条件設定メソッドを定義することで、
     * その他のプロセスでも同じ条件(セット)を再利用できるようにすると、間違いが減ると同時に、
     * 業務仕様の変更にも対応しやすくなる。
     * </p>
     */
    @Test
    @Transactional
    public void test_arrangeQuery_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().arrangeServiceMember();
        cb.query().addOrderBy_MemberName_Asc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log(member.toString());
            assertTrue(member.getMemberName().startsWith("S"));
            assertTrue(member.isMemberStatusCode正式会員());
        }

        // [SQL]
        // select dflocal.MEMBER_ID as c1, ...
        //   from MEMBER dflocal
        //  where dflocal.MEMBER_NAME like 'S%' escape '|'
        //    and dflocal.MEMBER_STATUS_CODE = 'FML'
        //    and exists (select dfsublocal_0.MEMBER_ID
        //                  from PURCHASE dfsublocal_0
        //                 where dfsublocal_0.MEMBER_ID = dflocal.MEMBER_ID
        //                   and dfsublocal_0.PRODUCT_ID = 3
        //        )
        //  order by dflocal.MEMBER_NAME asc
    }

    // ===================================================================================
    //                                                                         Display SQL
    //                                                                         ===========
    /**
     * どんなにSubQueryやUnionの連打をしてもSQLが綺麗にフォーマット: toDisplaySql().
     * ログでSQLが綺麗にフォーマットされていることを確認するだけ。
     * <p>
     * デバッグのし易さの徹底と、ConditionBeanから外だしSQLへの移行時にスムーズにできるように
     * ログのフォーマットを重視している。相関サブクエリなどはConditionBeanで書いてから出力された
     * SQLをベースに実装した方が外だしSQLでありがちなケアレスバグも無くなる。
     * </p>
     */
    @Test
    @Transactional
    public void test_toDisplaySql_Check_FormattedSQL_Tx() {
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        // 単にフォーマットされていることがみたいだけなので条件はかなり無茶苦茶
        // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
        final MemberStatusCB cb = new MemberStatusCB();
        cb.query().setDisplayOrder_Equal(3);
        cb.query().existsMemberList(new SubQuery<MemberCB>() {
            public void query(final MemberCB memberCB) {
                memberCB.query().setBirthdate_LessEqual(new Date());
                memberCB.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
                    public void query(final PurchaseCB purchaseCB) {
                        purchaseCB.query().setPurchaseCount_GreaterEqual(2);
                    }
                });
                memberCB.query().existsMemberWithdrawalAsOne(new SubQuery<MemberWithdrawalCB>() {
                    public void query(final MemberWithdrawalCB subCB) {
                        final LikeSearchOption option = new LikeSearchOption().likeContain().escapeByPipeLine();
                        subCB.query().queryWithdrawalReason().setWithdrawalReasonText_LikeSearch("xxx", option);
                        subCB.union(new UnionQuery<MemberWithdrawalCB>() {
                            public void query(final MemberWithdrawalCB unionCB) {
                                unionCB.query().setWithdrawalReasonInputText_IsNotNull();
                            }
                        });
                    }
                });
            }
        });
        cb.query().setMemberStatusCode_Equal_正式会員();
        cb.query().existsMemberLoginList(new SubQuery<MemberLoginCB>() {
            public void query(final MemberLoginCB subCB) {
                subCB.query().inScopeMember(new SubQuery<MemberCB>() {
                    public void query(final MemberCB subCB) {
                        subCB.query().setBirthdate_GreaterEqual(new Date());
                    }
                });
            }
        });
        cb.query().addOrderBy_DisplayOrder_Asc().addOrderBy_MemberStatusCode_Desc();
        this.log(getLineSeparator() + cb.toDisplaySql());
    }
}
