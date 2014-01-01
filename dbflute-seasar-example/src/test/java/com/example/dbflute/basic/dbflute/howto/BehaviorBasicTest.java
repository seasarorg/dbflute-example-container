/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
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
package com.example.dbflute.basic.dbflute.howto;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.exception.EntityAlreadyDeletedException;

import com.example.dbflute.basic.dbflute.cbean.MemberCB;
import com.example.dbflute.basic.dbflute.exbhv.MemberBhv;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.MemberChangedToWithdrawalForcedlyPmb;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.basic.dbflute.exentity.Member;
import com.example.dbflute.basic.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.basic.unit.UnitContainerTestCase;

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
public class BehaviorBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Component) */
    @Resource
    protected MemberBhv memberBhv;

    // 【補足】
    // A. Seasar-2.4の場合は、必ず変数名が "クラス名に先頭を小文字にしたもの" であること
    // B. Spring-2.5の場合は、型でインジェクションされる

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * o 一件検索: selectEntity(). <br />
     * 会員IDが'3'である会員を一件検索。
     */
    public void test_selectEntity() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);

        // ## Act ##
        Member member = memberBhv.selectEntity(cb);

        // ## Assert ##
        log(member.toString());
        assertEquals((Integer) 3, member.getMemberId());

        // [SQL]
        // where MEMBER_ID = 3

        // 【補足】
        // A. 存在しないIDを指定した場合はnullが戻る
        // B. 結果が複数件の場合は例外発生 {EntityDuplicatedException}
    }

    /**
     * o チェック付き一件検索: selectEntityWithDeletedCheck(). <br />
     * 会員IDが'99999'である会員を一件検索。存在しない場合は例外発生。
     */
    public void test_selectEntityWithDeletedCheck() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(99999);

        // ## Act & Assert ##
        try {
            memberBhv.selectEntityWithDeletedCheck(cb);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }

        // [SQL]
        // where MEMBER_ACCOUNT = 99999

        // 【補足】
        // A. 存在しないIDを指定した場合は例外発生 {EntityAlreadyDeletedException}
        // B. 結果が複数件の場合は例外発生 {EntityDuplicatedException}
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * o リスト検索: selectList(). <br />
     * 会員名称が'S'で始まる会員を会員IDの昇順でリスト検索。
     */
    public void test_selectList() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_PrefixSearch("S");
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            log(member);
            assertTrue(member.getMemberName().startsWith("S"));
        }

        // 【補足】
        // A. 検索結果が無い場合は空のList (nullは戻らない)
        // B. ListResultBeanは、java.util.Listの実装クラス

        // [SQL]
        // where MEMBER_ACCOUNT like 'S%' escape '|'
        // order by MEMBER_ID asc
    }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * o カウント検索: selectCount(). <br />
     * 会員名称が 'S' で始まる会員をカウント検索。
     */
    public void test_selectCount() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_PrefixSearch("S");

        // ## Act ##
        int count = memberBhv.selectCount(cb);

        // ## Assert ##
        log("count: " + count);
        assertNotSame(0, count);
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    // -----------------------------------------------------
    //                                                Insert
    //                                                ------
    /**
     * o 一件登録: insert(). <br />
     * 会員名称が 'testName' で、会員アカウントが 'testAccount' の正式会員を登録。
     */
    public void test_insert() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("testName");
        member.setMemberAccount("testAccount");
        member.setMemberStatusCode_正式会員();

        // ## Act ##
        memberBhv.insert(member);

        // ## Assert ##
        log(member.getMemberId()); // insert後に自動採番されたIDを取得できる
        Member afterMember = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
        assertEquals("testName", afterMember.getMemberName());

        // 【補足】
        // A. 自動採番カラム「会員ID」は設定不要
        // B. 共通カラムは設定不要 (共通カラムの値は自動設定される)
        // C. バージョンNOは設定不要 (自動インクリメント)
        // D. 会員ステータスのような区分値は、タイプセーフに設定
        // E. 一意制約違反のときは、EntityAlreadyExistsExceptionが発生。(DBFlute-0.7.7より)
    }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    /**
     * o 排他制御ありの一件更新: update(). <br />
     * 会員ID '3' の会員の名称を 'testName' に更新
     */
    public void test_update() {
        // ## Arrange ##
        Member beforeMember = memberBhv.selectByPKValueWithDeletedCheck(3);
        Long versionNo = beforeMember.getVersionNo(); // 排他制御のためにVersionNoを取得

        Member member = new Member(); // 更新用のEntityをnewする
        member.setMemberId(3); // 更新したい会員の会員ID
        member.setMemberName("testName"); // 更新する値を設定
        member.setVersionNo(versionNo); // 排他制御カラムの設定

        // ## Act ##
        memberBhv.update(member);

        // ## Assert ##
        Member afterMember = memberBhv.selectByPKValueWithDeletedCheck(3);
        log("onDatabase = " + afterMember.toString());
        log("onMemory   = " + member.toString());
        assertEquals(Long.valueOf(versionNo + 1), member.getVersionNo());
        assertEquals(afterMember.getVersionNo(), member.getVersionNo());

        // 【補足】
        // A. Setterが呼び出された項目(と自動設定項目)だけが更新される
        // B. 共通カラムは設定不要 (共通カラムの値は自動設定される)
        // C. 排他制御カラム(VERSION_NOなど)が定義されていない場合は、排他制御なし更新になる。
        // D. すれ違いが発生した場合は例外発生。{EntityAlreadyUpdatedException}
        // E. 存在しないPK値を指定された場合はすれ違いが発生した場合と同じ (排他制御の仕組み上、区別が付かないため)
        // F. 更新後のEntityにはOnMemoryでインクリメントされたVersionNoが格納される。
        // G. 一意制約違反のときは、EntityAlreadyExistsExceptionが発生。(DBFlute-0.7.7より)
    }

    /**
     * o 排他制御なし一件更新: updateNonstrict(). <br />
     * 会員ID '3' の会員の名称を 'testName' に更新
     */
    public void test_updateNonstrict() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberId(3);
        member.setMemberName("testName");

        // ## Act ##
        memberBhv.updateNonstrict(member);

        // ## Assert ##
        Member afterMember = memberBhv.selectByPKValueWithDeletedCheck(3);
        log("onDatabase = " + afterMember.toString());
        log("onMemory   = " + member.toString());
        assertNull(member.getVersionNo());
        assertNotNull(afterMember.getVersionNo());

        // 【補足】
        // A. Setterが呼び出された項目(と自動設定項目)だけが更新される
        // B. 共通カラムは設定不要 (共通カラムの値は自動設定される)
        // C. 存在しないPK値を指定された場合は例外発生 {EntityAlreadyDeletedException}
        // D. バージョンNOは設定不要、SQL上でインクリメント "VERSION_NO = VERSION + 1"
        // E. 更新後のEntityのVersionNoは更新前と全く同じ値がそのまま保持される
        // F. 一意制約違反のときは、EntityAlreadyExistsExceptionが発生 (DBFlute-0.7.7より)
    }

    // -----------------------------------------------------
    //                                                Delete
    //                                                ------
    /**
     * o 排他制御あり一件削除: delete(). <br />
     * 会員ID '3' の会員を削除。
     */
    public void test_delete() {
        // ## Arrange ##
        deleteMemberReferrer(); // 単にテストのために子テーブル(Referrer)を全部消している

        Member beforeMember = memberBhv.selectByPKValueWithDeletedCheck(3);
        Long versionNo = beforeMember.getVersionNo(); // 排他制御のためにバージョンNOを取得

        Member member = new Member();
        member.setMemberId(3); // 削除したい会員の会員ID
        member.setVersionNo(versionNo); // 排他制御カラムの設定

        // ## Act ##
        memberBhv.delete(member);

        // ## Assert ##
        try {
            memberBhv.selectByPKValueWithDeletedCheck(3);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }

        // 【補足】
        // A. PKとVersionNoのみ評価されるため、他のカラムはnullでもよい
        // B. すれ違いが発生した場合は例外発生 {EntityAlreadyUpdatedException}
        // C. 存在しないPK値を指定された場合はすれ違いが発生した場合と同じ (排他制御の仕組み上、区別が付かないため)
    }

    /**
     * o 排他制御なし一件削除: deleteNonstrict(). <br />
     * 会員ID '3' の会員を削除。
     */
    public void test_deleteNonstrict() {
        // ## Arrange ##
        deleteMemberReferrer(); // 単にテストのために子テーブル(Referrer)を全部消している

        Member member = new Member();
        member.setMemberId(3); // 削除したい会員の会員ID

        // ## Act ##
        memberBhv.deleteNonstrict(member);

        // ## Assert ##
        try {
            memberBhv.selectByPKValueWithDeletedCheck(3);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }

        // 【補足】
        // A. PKのみ評価されるため、他のカラムはnullでもよい
        // B. 存在しないPK値を指定された場合は例外発生 {EntityAlreadyDeletedException}
    }

    /**
     * o 既に削除済みであれば素通りする排他制御なし一件削除: deleteNonstrictIgnoreDeleted(). <br />
     * 存在しない会員ID '99999' の会員を削除。
     */
    public void test_deleteNonstrictIgnoreDeleted() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberId(99999); // 存在しない会員の会員ID (既に削除されたと仮定)

        // ## Act ##
        memberBhv.deleteNonstrictIgnoreDeleted(member); // 例外は発生しない

        // ## Assert ##
        try {
            memberBhv.selectByPKValueWithDeletedCheck(99999);
            fail();
        } catch (EntityAlreadyDeletedException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    /**
     * o 外だしSQL(OutsideSql)の基本的な検索: outsideSql().selectList(). <br />
     * 会員名称が'S'で始まる会員をリスト検索。<br />
     * 外だしの使い方: http://dbflute.seasar.org/ja/manual/function/ormapper/outsidesql/howto.html
     */
    public void test_outsideSql_selectList_selectSimpleMember() {
        // ## Arrange ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        List<SimpleMember> memberList = memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        log("{SimpleMember}");
        for (SimpleMember entity : memberList) {
            Integer memberId = entity.getMemberId();
            String memberName = entity.getMemberName();
            String memberStatusName = entity.getMemberStatusName();
            log("  " + memberId + ", " + memberName + ", " + memberStatusName);
            assertNotNull(memberId);
            assertNotNull(memberName);
            assertNotNull(memberStatusName);
            assertTrue(memberName.startsWith("S"));
        }

        // 【補足】
        // A. ParameterBean (XxxPmb) が "SQLのパス" と "戻り値の型" の情報を持っている
        //  -> なので、pmb だけを指定すれば実行できる
    }

    // -----------------------------------------------------
    //                                               Execute
    //                                               -------
    /**
     * o 外だしSQL(OutsideSql)の基本的な更新: outsideSql().execute(). <br />
     * 会員名称が 'S' で始まる会員を強制退会させる。
     */
    public void test_outsideSql_execute_updateMemberChangedToWithdrawalForcedly() {
        // ## Arrange ##
        MemberChangedToWithdrawalForcedlyPmb pmb = new MemberChangedToWithdrawalForcedlyPmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        int updatedCount = memberBhv.outsideSql().execute(pmb);

        // ## Assert ##
        log("updatedCount=" + updatedCount);
        assertNotSame(0, updatedCount);

        // 【補足】
        // A. 手順は外だしSQLによる検索とほぼ同じ (更新系には戻り値Entityという概念が存在しない)
        // B. insert, update に限らず、検索でないものは全て execute()。e.g. truncate
        // C. 排他制御(VERSION_NOの+1含む)と共通カラムの自動設定は実行されない (自前で処理する)
    }
}
