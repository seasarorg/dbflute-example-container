package com.example.dbflute.cdi.dbflute.topic;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.dbmeta.info.ColumnInfo;
import org.seasar.junitcdi.jta.Transactional;

import com.example.dbflute.cdi.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.cdi.dbflute.cbean.MemberCB;
import com.example.dbflute.cdi.dbflute.exbhv.MemberBhv;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.MapLikeSearchPmb;
import com.example.dbflute.cdi.dbflute.exentity.Member;
import com.example.dbflute.cdi.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.cdi.unit.ContainerTestCase;

/**
 * 「諸刃の刃」機能のExample実装。
 * <pre>
 * コンテンツは以下の通り：
 *   o ConditionBeanでバインド変数を利用しない検索: embedCondition().
 *   o 外だしSQLでMapParameterBeanを利用した検索: new HashMap().
 *   o ParameterBeanのMap型プロパティでLikeSearchOption: setXxxMap(map, likeSearchOption).
 *   o 固定条件one-to-oneの検索: additionalForeignKey, fixedCondition.
 * </pre>
 * ※「諸刃の刃」機能とは、いざってときに役立つが注意深く利用する必要がある機能である。
 * @author jflute
 * @since 0.7.5 (2008/06/26 Thursday)
 */
public class TwoEdgedSwordTest extends ContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Object) */
    @Inject
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                       ConditionBean
    //                                                                       =============
    /**
     * ConditionBeanでバインド変数を利用しない検索: embedCondition().
     * 時々、ほんの時々、すごくごく稀に、バインド変数を止めるとSQLが速くなることがある。
     * そういう状況でどうしても回避できず必要になった場合の機能。
     * 利用する場合は扱いにとてもとても注意すること！！！(SQLInjection対策など)
     */
    @Test
    @Transactional
    @SuppressWarnings("deprecation")
    public void test_embedCondition_Tx() {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);
        cb.query().setMemberName_PrefixSearch("Mijato");
        cb.query().setFormalizedDatetime_LessEqual(this.currentTimestamp());

        // Internal Check!
        final String before2WaySQL = cb.getSqlClause().getClause();
        this.log(getLineSeparator() + "[Before]" + getLineSeparator() + before2WaySQL);
        assertTrue(before2WaySQL.contains(" /*pmb.conditionQuery.memberId"));
        assertTrue(before2WaySQL.contains(" /*pmb.conditionQuery.memberName"));
        assertTrue(before2WaySQL.contains(" /*pmb.conditionQuery.formalizedDatetime"));
        assertFalse(before2WaySQL.contains(" /*$pmb.conditionQuery.memberId"));
        assertFalse(before2WaySQL.contains(" '/*$pmb.conditionQuery.memberName"));
        assertFalse(before2WaySQL.contains(" /*$pmb.conditionQuery.formalizedDatetime"));
        assertFalse(before2WaySQL.contains(" '/*$pmb.conditionQuery.formalizedDatetime"));

        final Set<ColumnInfo> plainSet = new HashSet<ColumnInfo>();
        plainSet.add(MemberDbm.getInstance().columnMemberId());
        cb.embedCondition(plainSet, false); // mainly number type

        final Set<ColumnInfo> quotedSet = new HashSet<ColumnInfo>();
        quotedSet.add(MemberDbm.getInstance().columnMemberName());
        cb.embedCondition(quotedSet, true); // mainly string type

        // Internal Check!
        final String after2WaySQL = cb.getSqlClause().getClause();
        this.log(getLineSeparator() + "[After]" + getLineSeparator() + after2WaySQL);
        assertFalse(after2WaySQL.contains(" /*pmb.conditionQuery.memberId"));
        assertFalse(after2WaySQL.contains(" /*pmb.conditionQuery.memberName"));
        assertTrue(after2WaySQL.contains(" /*pmb.conditionQuery.formalizedDatetime"));
        assertTrue(after2WaySQL.contains(" /*$pmb.conditionQuery.memberId"));
        assertTrue(after2WaySQL
                .contains(" /*$pmb.conditionQuery.memberName.varying.likeSearch.likeSearch0*/'dummy' escape '|'"));
        assertFalse(after2WaySQL.contains(" /*$pmb.conditionQuery.formalizedDatetime"));
        assertFalse(after2WaySQL.contains(" /*$pmb.conditionQuery.formalizedDatetime"));

        // ## Act ##
        final ListResultBean<Member> memberList = this.memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());

        // [Description]
        // A. 別の条件に同じ名前のカラムがあった場合は両方が対象になる(制限)
        //    --> カラム名だけで判断しているため
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    // -----------------------------------------------------
    //                                      MapParameterBean
    //                                      ----------------
    /**
     * 外だしSQLでMapParameterBeanを利用した検索: new HashMap().
     * ParameterBeanとしてMap(MapParameterBean)をそのまま利用。
     * <p>
     * キー値を指定しないものはOGNL上null扱いになるが、Boolean値だけは
     * 必ずtrueかfalseかの指定が必須である(OGNLが正常に判定ができないため)。
     * この例題ではBoolean値は存在していない。
     * </p>
     */
    @Test
    @Transactional
    public void test_outsideSql_selectList_selectSimpleMember_UsingMapParameterBean_Tx() {
        // ## Arrange ##
        // SQLのパス
        final String path = MemberBhv.PATH_selectSimpleMember;

        // 検索条件
        // - - - - - - - - - - - - - - - - - - - - - - - - -
        // 通常のParameterBeanではなくMapParameterBeanを利用
        // - - - - - - - - - - - - - - - - - - - - - - - - -
        // SimpleMemberPmb pmb = new SimpleMemberPmb();
        final Map<String, Object> pmb = new HashMap<String, Object>();
        pmb.put("memberName", "S%");

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

    /**
     * ParameterBeanのMap型プロパティでLikeSearchOption: setXxxMap(map, likeSearchOption).
     * ParameterBeanにMap型のプロパティを定義してLikeSearchOptionを利用。
     */
    @Test
    @Transactional
    public void test_outsideSql_selectList_selectMapLikeSearch_Tx() {
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

        // *Point!
        checkCB.query().setMemberName_LikeSearch(keyword, new LikeSearchOption().likeContain().notEscape());
        assertEquals("escapeなしで2件ともHITすること", 2, this.memberBhv.selectList(checkCB).size());

        // SQLのパス
        final String path = MemberBhv.PATH_various_pmbcheck_selectMapLikeSearch;

        // 検索条件
        final MapLikeSearchPmb pmb = new MapLikeSearchPmb();
        final Map<String, Object> conditionMap = new HashMap<String, Object>();
        conditionMap.put("memberName", keyword);
        pmb.setConditionMap(conditionMap, new LikeSearchOption().likeContain());

        // 戻り値Entityの型
        final Class<SimpleMember> entityType = SimpleMember.class;

        // ## Act ##
        // SQL実行！
        final List<SimpleMember> memberList = this.memberBhv.outsideSql().selectList(path, pmb, entityType);

        // ## Assert ##
        assertNotNull(memberList);
        assertEquals(1, memberList.size());// このキーワードにHITする人は１人しかいない
        final SimpleMember actualMember = memberList.get(0);
        this.log(actualMember);
        assertEquals(expectedMemberName, actualMember.getMemberName());
    }

    // ===================================================================================
    //                                                                     Fixed Condition
    //                                                                     ===============
    // 固定条件one-to-oneの検索: additionalForeignKey, fixedCondition.
    // は、dbflute-mysql-exampleにて
}
