package com.example.dbflute.cdi.dbflute.howto.jp;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.exception.EntityAlreadyDeletedException;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.MemberChangedToWithdrawalForcedlyPmb;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * Behaviorの初級編Example実装。
 * <pre>
 * ターゲットは以下の通り：
 *   o とりあえずDBFluteのDBアクセスのやり方について知りたい方
 *   o DBFluteで開発するけど今まで全く使ったことのない方
 *
 * コンテンツは以下の通り：
 *   o 一件検索: selectEntity().
 *   o チェック付き一件検索(): selectEntityWithDeletedCheck().
 *   o リスト検索: selectList().
 *   o カウント検索: selectCount().
 *   o 一件登録: insert().
 *   o 排他制御あり一件更新: update().
 *   o 排他制御なし一件更新: updateNonstrict().
 *   o 排他制御あり一件削除: delete().
 *   o 排他制御なし一件削除: deleteNonstrict().
 *   o 既に削除済みであれば素通りする排他制御なし一件削除: deleteNonstrictIgnoreDeleted().
 *   o 外だしSQL(OutsideSql)の基本的な検索: outsideSql().selectList().
 *   o 外だしSQL(OutsideSql)の基本的な更新: outsideSql().execute().
 * </pre>
 * @author jflute
 * @since 0.7.3 (2008/05/31 Saturday)
 */
public class BehaviorBasicTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Component) */
    @Inject
    private MemberBhv memberBhv;

    // [Description]
    // A. Seasar-2.4の場合はプロパティ名が「クラス名に先頭を小文字にしたもの」であること。
    // B. Spring-2.5の場合は型でインジェクションされる。

    @Test
    public void testname() throws Exception {
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberSecurityAsOne();

        final ListResultBean<Member> selectList = this.memberBhv.selectList(cb);

        for (final Member member : selectList) {
            this.log(member.getMemberSecurityAsOne());

        }

    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * 一件検索: selectEntity().
     * 会員IDが'3'である会員を一件検索。
     */
    @Test
    @Transactional
    public void test_selectEntity_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);

        // ## Act ##
        final Member member = this.memberBhv.selectEntity(cb);

        // ## Assert ##
        this.log(member.toString());
        assertEquals((Integer) 3, member.getMemberId());

        // [SQL]
        // where MEMBER_ID = 3

        // [Description]
        // A. 存在しないIDを指定した場合はnullが戻る。
        // B. 結果が複数件の場合は例外発生。{EntityDuplicatedException}
    }

    /**
     * チェック付き一件検索: selectEntityWithDeletedCheck().
     * 会員IDが'99999'である会員を一件検索。存在しない場合は例外発生。
     */
    @Test
    @Transactional
    public void test_selectEntityWithDeletedCheck_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(99999);

        // ## Act & Assert ##
        try {
            this.memberBhv.selectEntityWithDeletedCheck(cb);
            fail();
        } catch (final EntityAlreadyDeletedException e) {
            // OK
            this.log(e.getMessage());
        }

        // [SQL]
        // where MEMBER_ACCOUNT = 99999

        // [Description]
        // A. 存在しないIDを指定した場合は例外発生。{EntityAlreadyDeletedException}
        // B. 結果が複数件の場合は例外発生。{EntityDuplicatedException}
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * リスト検索: selectList().
     * 会員名称が'S'で始まる会員を会員IDの昇順でリスト検索。
     */
    @Test
    @Transactional
    public void test_selectList_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberName_PrefixSearch("S");
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (final Member member : memberList) {
            this.log(member.toString());
            assertTrue(member.getMemberName().startsWith("S"));
        }

        // [Description]
        // A. 検索結果が無い場合は空のList。(nullは戻らない)
        // B. ListResultBeanは、java.util.Listの実装クラス。

        // [SQL]
        // where MEMBER_ACCOUNT like 'S%'
        // order by MEMBER_ID asc
    }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * カウント検索: selectCount().
     * 会員名称が'S'で始まる会員をカウント検索。
     */
    @Test
    @Transactional
    public void test_selectCount_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberName_PrefixSearch("S");

        // ## Act ##
        final int count = this.memberBhv.selectCount(cb);

        // ## Assert ##
        assertNotSame(0, count);
        this.log("count = " + count);
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    // -----------------------------------------------------
    //                                                Insert
    //                                                ------
    /**
     * 一件登録: insert().
     * 会員名称が'testName'で、会員アカウントが'testAccount'の正式会員を登録。
     */
    @Test
    @Transactional
    public void test_insert_Tx() {
        // ## Arrange ##
        final Member member = new Member();
        member.setMemberName("testName");
        member.setMemberAccount("testAccount");
        member.setMemberStatusCode_正式会員();

        // ## Act ##
        this.memberBhv.insert(member);

        // ## Assert ##
        this.log(member.getMemberId());// Insertしたときに採番されたIDを取得

        // 【Description】
        // A. 自動採番カラム「会員ID」は設定不要。
        // member.setMemberId(memberId);
        //
        // B. 共通カラムは設定不要。
        // member.setRegisterDatetime(registerDatetime);
        // member.setUpdateUser(updateUser);
        //   ※事前にDBFluteの「共通カラム自動設定」機能の準備すること
        //   --> dbflute_exampledb/dfprop/commonColumnMap.dfprop
        //
        // C. バージョンNOは設定不要。(自動インクリメント)
        // member.setVersionNo(versionNo);
        //
        // D. 会員ステータスは、タイプセーフに設定。
        // member.classifyMemberStatusCodeFormalized();
        //   ※事前にDBFluteの「区分値」機能の準備すること
        //   --> dbflute_exampledb/dfprop/classificationDefinitionMap.dfprop
        //   --> dbflute_exampledb/dfprop/classificationDeploymentMap.dfprop
        //
        // E. 一意制約違反のときは、EntityAlreadyExistsExceptionが発生。(DBFlute-0.7.7より)
        //   ※JDBCドライバ依存であることに注意
        //   ※UniqueConstraintTest参考
    }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    /**
     * 排他制御ありの一件更新: update().
     * 会員ID'3'の会員の名称を'testName'に更新
     */
    @Test
    @Transactional
    public void test_update_Tx() {
        // ## Arrange ##
        final Member beforeMember = this.memberBhv.selectByPKValueWithDeletedCheck(3);
        final Long versionNo = beforeMember.getVersionNo();// 排他制御のためにVersionNoを取得

        final Member member = new Member();
        member.setMemberId(3);// 更新したい会員の会員ID
        member.setMemberName("testName");
        member.setVersionNo(versionNo);// 排他制御カラムの設定

        // ## Act ##
        this.memberBhv.update(member);

        // ## Assert ##
        final Member afterMember = this.memberBhv.selectByPKValueWithDeletedCheck(3);
        this.log("onDatabase = " + afterMember.toString());
        this.log("onMemory   = " + member.toString());
        assertEquals(Long.valueOf(versionNo + 1), member.getVersionNo());
        assertEquals(afterMember.getVersionNo(), member.getVersionNo());

        // 【Description】
        // A. Setterが呼び出された項目(と自動設定項目)だけ更新
        // update MEMBER set MEMBER_NAME = 'testName' where ...
        //
        // B. 共通カラムは設定不要。
        // member.setRegisterDatetime(registerDatetime);
        // member.setUpdateUser(updateUser);
        //   ※事前にDBFluteの「共通カラム自動設定」機能の準備すること
        //   --> dbflute_exampledb/dfprop/commonColumnMap.dfprop
        //
        // C. 排他制御カラム(VERSION_NOなど)が定義されていない場合は、排他制御なし更新になる。
        // D. すれ違いが発生した場合は例外発生。{EntityAlreadyUpdatedException}
        // E. 存在しないPK値を指定された場合はすれ違いが発生した場合と同じ。
        //    --> 排他制御の仕組み上、区別が付かないため
        //
        // F. 更新後のEntityにはOnMemoryでインクリメントされたVersionNoが格納される。
        //
        // G. 一意制約違反のときは、EntityAlreadyExistsExceptionが発生。(DBFlute-0.7.7より)
        //   ※JDBCドライバ依存であることに注意
        //   ※UniqueConstraintTest参考
    }

    /**
     * 排他制御なし一件更新: updateNonstrict().
     * 会員ID'3'の会員の名称を'testName'に更新
     */
    @Test
    @Transactional
    public void test_updateNonstrict_Tx() {
        // ## Arrange ##
        final Member member = new Member();
        member.setMemberId(3);// 更新したい会員の会員ID
        member.setMemberName("testName");

        // ## Act ##
        this.memberBhv.updateNonstrict(member);

        // ## Assert ##
        final Member afterMember = this.memberBhv.selectByPKValueWithDeletedCheck(3);
        this.log("onDatabase = " + afterMember.toString());
        this.log("onMemory   = " + member.toString());
        assertNull(member.getVersionNo());
        assertNotNull(afterMember.getVersionNo());

        // 【Description】
        // A. Setterが呼び出された項目(と自動設定項目)だけ更新
        // update MEMBER set MEMBER_NAME = 'testName' where ...
        //
        // B. 共通カラムは設定不要。
        // member.setRegisterDatetime(registerDatetime);
        // member.setUpdateUser(updateUser);
        //   ※事前にDBFluteの「共通カラム自動設定」機能の準備すること
        //   --> dbflute_exampledb/dfprop/commonColumnMap.dfprop
        //
        // C. 存在しないPK値を指定された場合は例外発生。{EntityAlreadyDeletedException}
        //
        // D. バージョンNOは設定不要(OnQueryでインクリメント「VERSION_NO = VERSION + 1」)
        // member.setVersionNo(versionNo);
        //
        // E. 更新後のEntityのVersionNoは更新前と全く同じ値がそのまま保持される。
        //
        // F. 一意制約違反のときは、EntityAlreadyExistsExceptionが発生。(DBFlute-0.7.7より)
        //   ※JDBCドライバ依存であることに注意
        //   ※UniqueConstraintTest参考
    }

    // -----------------------------------------------------
    //                                                Delete
    //                                                ------
    /**
     * 排他制御あり一件削除: delete().
     * 会員ID'3'の会員を削除。
     */
    @Test
    @Transactional
    public void test_delete_Tx() {
        // ## Arrange ##
        this.deleteMemberReferrer();// テストのためにReferrerを全部消す

        final Member beforeMember = this.memberBhv.selectByPKValueWithDeletedCheck(3);
        final Long versionNo = beforeMember.getVersionNo();// 排他制御のためにVersionNoを取得

        final Member member = new Member();
        member.setMemberId(3);// 削除したい会員の会員ID
        member.setVersionNo(versionNo);// 排他制御カラムの設定

        // ## Act ##
        this.memberBhv.delete(member);

        // ## Assert ##
        try {
            this.memberBhv.selectByPKValueWithDeletedCheck(3);
            fail();
        } catch (final EntityAlreadyDeletedException e) {
            // OK
            this.log(e.getMessage());
        }

        // [Description]
        // A. PKとVersionNoのみ評価されるため、他のカラムはnullでもよい。
        // B. すれ違いが発生した場合は例外発生。{EntityAlreadyUpdatedException}
        // C. 存在しないPK値を指定された場合はすれ違いが発生した場合と同じ。
        //    --> 排他制御の仕組み上、区別が付かないため
    }

    /**
     * 排他制御なし一件削除: deleteNonstrict().
     * 会員ID'3'の会員を削除。
     */
    @Test
    @Transactional
    public void test_deleteNonstrict_Tx() {
        // ## Arrange ##
        this.deleteMemberReferrer();// テストのためにReferrerを全部消す

        final Member member = new Member();
        member.setMemberId(3);// 削除したい会員の会員ID

        // ## Act ##
        this.memberBhv.deleteNonstrict(member);

        // ## Assert ##
        try {
            this.memberBhv.selectByPKValueWithDeletedCheck(3);
            fail();
        } catch (final EntityAlreadyDeletedException e) {
            // OK
            this.log(e.getMessage());
        }

        // [Description]
        // A. PKのみ評価されるため、他のカラムはnullでもよい。
        // B. 存在しないPK値を指定された場合は例外発生。{EntityAlreadyDeletedException}
    }

    /**
     * 既に削除済みであれば素通りする排他制御なし一件削除: deleteNonstrictIgnoreDeleted().
     * 存在しない会員ID'99999'の会員を削除。
     */
    @Test
    @Transactional
    public void test_deleteNonstrictIgnoreDeleted_Tx() {
        // ## Arrange ##
        final Member member = new Member();
        member.setMemberId(99999);// 存在しない会員の会員ID(既に削除されたと仮定)

        // ## Act ##
        this.memberBhv.deleteNonstrictIgnoreDeleted(member);// 例外は発生しない

        // ## Assert ##
        try {
            this.memberBhv.selectByPKValueWithDeletedCheck(99999);
            fail();
        } catch (final EntityAlreadyDeletedException e) {
            // OK
            this.log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    /**
     * 外だしSQL(OutsideSql)の基本的な検索: outsideSql().selectList().
     * 会員名称が'S'で始まる会員をリスト検索。
     * <pre>
     * 【手順】
     * 1. exbhvパッケージにSQLファイルを作成する。
     *
     * 　　パッケージ：src/main/resources配下のxxx.exbhvパッケージ
     * 　　ファイル名：[Behaviorクラス名]_[SQLを表現する任意の名称].sql
     *   　　ex) xxx/exbhv/MemberBhv_selectSimpleMember.sql
     * 　　エンコーディング：UTF-8 (デフォルトの設定)
     *
     * 2. SQLファイルにSQLを2Way-SQLで実装する。
     *
     * 　　＜意識すること＞
     * 　　o 2WaySQLで実装すること
     * 　　o Sql2Entityマークを追記すること
     *
     *      e.g. CustomizeEntity(戻り値) ※検索時のみ
     * 　　　 -- #Xxx#
     *
     *      e.g. ParameterBean(検索条件) ※基本的に必須
     * 　　　 -- !df:pmb!
     * 　　　 -- !!String arg1!!
     *
     * 3. Sql2Entityを実行する。
     *
     * 　　＜生成されるもの＞
     * 　　A. CustomizeEntity(戻り値)のクラス
     * 　　B. ParameterBean(検索条件)のクラス
     * 　　C. BehaviorQueryPath(SQLへのパス)の定義
     *
     * 4. BehaviorのoutsideSql()メソッドを利用してSQLを呼び出す。
     *
     * 　　＜生成されるもの＞
     *    ParameterBean が外だしSQLへのパスや戻り値Entityの型と関連付いているため、
     *    ParameterBean だけを指定すれば呼び出すことができる。(型付けされている場合)
     *
     *    e.g. MemberBhv_selectSimpleMember.sql
     *    SimpleMemberPmb pmb = new SimpleMemberPmb();
     *    List&lt;SimpleMember&gt; memberList
     *        = memberBhv.outsideSql().selectList(pmb);
     *
     * 【特徴】
     * o SQLファイル名とプログラム上での指定が食い違うことがない。
     * 　- SQLファイル名を変更してSql2Entityを実行すると古いPath指定をコンパイルエラーで検知可能
     * 　- SQLファイル名の[Behaviorクラス名]で存在しないクラスを指定した場合は、Sql2Entityで明示的な例外
     * o SQLのSelect句定義と戻り値クラスの構造が食い違うことが無い。
     * o Sql2EntityでSQLの文法的な実行チェックが行われる。
     * </pre>
     */
    @Test
    @Transactional
    public void test_outsideSql_selectList_selectSimpleMember_Tx() {
        // ## Arrange ##
        // 検索条件
        final SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        // SQL実行！
        final List<SimpleMember> memberList = this.memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
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
    //                                               Execute
    //                                               -------
    /**
     * 外だしSQL(OutsideSql)の基本的な更新: outsideSql().execute().
     * 会員名称が'S'で始まる会員を強制退会させる。
     */
    @Test
    @Transactional
    public void test_outsideSql_execute_updateMemberChangedToWithdrawalForcedly_Tx() {
        // ## Arrange ##
        // 更新条件
        final MemberChangedToWithdrawalForcedlyPmb pmb = new MemberChangedToWithdrawalForcedlyPmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        final int updatedCount = this.memberBhv.outsideSql().execute(pmb);

        // ## Assert ##
        this.log("updatedCount=" + updatedCount);
        assertNotSame(0, updatedCount);

        // [Description]
        // A. 手順は外だしSQLによる検索とほぼ同じである。
        //    --> 更新系には戻り値Entityという概念が存在しない。
        //
        // B. insertでもupdateでもdeleteでも検索でないものは全てexecute()。
        //    --> その他truncateやmergeなど
        //
        // C. 排他制御(VERSION_NOの+1含む)と共通カラムの自動設定は実行されない。
        //    --> 必要な場合は自前で処理する必要がある。
    }
}
