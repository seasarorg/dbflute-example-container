package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.seasar.dbflute.CallbackContext;
import org.seasar.dbflute.bhv.InsertOption;
import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.exception.EntityAlreadyExistsException;
import org.seasar.dbflute.jdbc.SqlLogHandler;
import org.seasar.dbflute.jdbc.SqlLogInfo;
import org.seasar.dbflute.jdbc.SqlResultHandler;
import org.seasar.dbflute.jdbc.SqlResultInfo;
import org.seasar.dbflute.jdbc.StatementConfig;
import org.seasar.dbflute.resource.InternalMapContext;
import org.seasar.dbflute.util.DfReflectionUtil;
import org.seasar.dbflute.util.DfTypeUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.8 (2010/12/16 Thursday)
 */
public class WxBhvVaryingInsertTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private MemberStatusBhv memberStatusBhv;

    // ===================================================================================
    //                                                                          After Care
    //                                                                          ==========
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        clearCallbackContext();
    }

    protected void clearCallbackContext() {
        CallbackContext.clearSqlLogHandlerOnThread();
        CallbackContext.clearSqlResultHandlerOnThread();
        assertFalse(CallbackContext.isExistCallbackContextOnThread());
        assertFalse(CallbackContext.isExistBehaviorCommandHookOnThread());
        assertFalse(CallbackContext.isExistSqlLogHandlerOnThread());
        assertFalse(CallbackContext.isExistSqlResultHandlerOnThread());
    }

    // ===================================================================================
    //                                                                      Varying Insert
    //                                                                      ==============
    public void test_varyingInsert_disableCommonColumnAutoSetup_basic() throws Exception {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("foo");
        member.setMemberAccount("foo");
        member.setMemberStatusCode_Formalized();
        member.setRegisterUser("testInsertMan");
        member.setRegisterDatetime(DfTypeUtil.toTimestamp("2010/12/16 18:15:56"));
        member.setUpdateUser("testUpdateMan");
        member.setUpdateDatetime(DfTypeUtil.toTimestamp("2010/12/16 18:16:12"));
        String accessUser = getAccessContext().getAccessUser();

        // ## Act ##
        memberBhv.varyingInsert(member, new InsertOption<MemberCB>().disableCommonColumnAutoSetup());

        // ## Assert ##
        {
            assertEquals("testInsertMan", member.getRegisterUser());
            assertEquals("testUpdateMan", member.getUpdateUser());
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals("testInsertMan", actual.getRegisterUser());
            assertEquals("testUpdateMan", actual.getUpdateUser());
        }

        // ## Act ##
        member.setMemberName("bar");
        member.setMemberAccount("bar");
        memberBhv.varyingInsert(member, new InsertOption<MemberCB>());

        // ## Assert ##
        {
            assertEquals(accessUser, member.getRegisterUser());
            assertEquals(accessUser, member.getUpdateUser());
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals(accessUser, actual.getRegisterUser());
            assertEquals(accessUser, actual.getUpdateUser());
        }

        // ## Act ##
        member.setMemberName("qux");
        member.setMemberAccount("qux");
        member.setRegisterUser("overridden");
        member.setUpdateUser("overridden");
        memberBhv.insert(member);

        // ## Assert ##
        {
            assertEquals(accessUser, member.getRegisterUser());
            assertEquals(accessUser, member.getUpdateUser());
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals(accessUser, actual.getRegisterUser());
            assertEquals(accessUser, actual.getUpdateUser());
        }
    }

    public void test_varyingInsert_disablePrimaryKeyIdentity_basic() throws Exception {
        // ## Arrange ##
        Integer directId = 99999;
        Member member = new Member();
        member.setMemberId(directId);
        member.setMemberName("foo");
        member.setMemberAccount("foo");
        member.setMemberStatusCode_Formalized();
        InsertOption<MemberCB> option = new InsertOption<MemberCB>().disablePrimaryKeyIdentity();

        // ## Act ##
        if (member.getDBMeta().hasIdentity()) { // mainly
            memberBhv.varyingInsert(member, option);
        } else {
            try {
                memberBhv.varyingInsert(member, option);
                fail();
            } catch (IllegalStateException e) {
                // OK
                log(e.getMessage());
                return;
            }
        }

        // ## Assert ##
        Member actual = memberBhv.selectByPKValueWithDeletedCheck(directId);
        assertEquals(directId, member.getMemberId());
        assertEquals(directId, actual.getMemberId());
        assertEquals("foo", actual.getMemberName());
        assertEquals(actual.getVersionNo(), member.getVersionNo());

        // ## Act ##
        try {
            member.setMemberName("bar");
            member.setMemberAccount("bar");
            memberBhv.varyingInsert(member, option);

            // ## Assert ##
            fail();
        } catch (EntityAlreadyExistsException e) {
            // OK
            log(e.getMessage());
        }

        // ## Act ##
        member.setMemberName("qux");
        member.setMemberAccount("qux");
        memberBhv.varyingInsert(member, new InsertOption<MemberCB>()); // back to identity

        // ## Assert ##
        assertNotNull(member.getMemberId());
        assertNotSame(directId, member.getMemberId());

        // ## Act ##
        member.setMemberName("quux");
        member.setMemberAccount("quux");
        memberBhv.insert(member); // back to identity

        // ## Assert ##
        assertNotNull(member.getMemberId());
        assertNotSame(directId, member.getMemberId());
    }

    public void test_varyingInsert_disablePrimaryKeyIdentity_nonIdentity() throws Exception {
        // ## Arrange ##
        MemberStatus status = new MemberStatus();
        status.setMemberStatusCode_Formalized();
        status.setMemberStatusName("FOO");
        status.setDisplayOrder(99);
        InsertOption<MemberStatusCB> option = new InsertOption<MemberStatusCB>().disablePrimaryKeyIdentity();

        // ## Act ##
        try {
            memberStatusBhv.varyingInsert(status, option);

            // ## Assert ##
            fail();
        } catch (IllegalStateException e) {
            // OK
            log(e.getMessage());
        }
    }

    // -----------------------------------------------------
    //                                             Configure
    //                                             ---------
    public void test_varyingInsert_statementConfig_exists() throws Exception {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberName("foo");
        member.setMemberAccount("foo");
        member.setMemberStatusCode_Formalized();
        InsertOption<MemberCB> option = new InsertOption<MemberCB>();
        option.configure(new StatementConfig().queryTimeout(7));

        // ## Act ##
        final Set<String> markSet = newHashSet();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                StatementConfig config = InternalMapContext.getUpdateStatementConfig();
                assertNotNull(config);
                assertEquals(7, config.getQueryTimeout());
                markSet.add("handle");
            }
        });
        memberBhv.varyingInsert(member, option);

        // ## Assert ##
        assertFalse(markSet.isEmpty());
        assertNotNull(member.getMemberId());
    }

    // ===================================================================================
    //                                                                Varying Batch Insert
    //                                                                ====================
    public void test_varyingBatchInsert_disablePrimaryKeyIdentity() throws Exception {
        // ## Arrange ##
        List<Member> memberList = new ArrayList<Member>();
        {
            Member member = new Member();
            member.setMemberId(99991);
            member.setMemberName("foo1");
            member.setMemberAccount("foo1");
            member.setMemberStatusCode_Formalized();
            memberList.add(member);
        }
        {
            Member member = new Member();
            member.setMemberId(99992);
            member.setMemberName("foo2");
            member.setMemberAccount("foo2");
            member.setMemberStatusCode_Formalized();
            memberList.add(member);
        }
        InsertOption<MemberCB> option = new InsertOption<MemberCB>().disablePrimaryKeyIdentity();

        // ## Act ##
        if (MemberDbm.getInstance().hasIdentity()) { // mainly
            memberBhv.varyingBatchInsert(memberList, option);
        } else {
            try {
                memberBhv.varyingBatchInsert(memberList, option);
                fail();
            } catch (IllegalStateException e) {
                // OK
                log(e.getMessage());
                return;
            }
        }

        // ## Assert ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_InScope(Arrays.asList(memberList.get(0).getMemberId(), memberList.get(1).getMemberId()));
        ListResultBean<Member> actualList = memberBhv.selectList(cb);
        assertNotSame(0, actualList.size());
        assertEquals(Integer.valueOf(99991), memberList.get(0).getMemberId());
        assertEquals(Integer.valueOf(99992), memberList.get(1).getMemberId());
        assertEquals(Integer.valueOf(99991), actualList.get(0).getMemberId());
        assertEquals(Integer.valueOf(99992), actualList.get(1).getMemberId());

        // ## Act ##
        try {
            int index = 1;
            for (Member member : memberList) {
                member.setMemberName("bar" + index);
                member.setMemberAccount("bar" + index);
                ++index;
            }
            memberBhv.varyingBatchInsert(memberList, option);

            // ## Assert ##
            fail();
        } catch (EntityAlreadyExistsException e) {
            // OK
            log(e.getMessage());
        }

        // ## Act ##
        {
            int index = 1;
            for (Member member : memberList) {
                member.setMemberName("qux" + index);
                member.setMemberAccount("qux" + index);
                ++index;
            }
            memberBhv.varyingBatchInsert(memberList, new InsertOption<MemberCB>()); // back to identity

            // ## Assert ##
            assertEquals(Integer.valueOf(99991), memberList.get(0).getMemberId());
            assertEquals(Integer.valueOf(99992), memberList.get(1).getMemberId());
            assertNotSame(Integer.valueOf(99991), actualList.get(0).getMemberId());
            assertNotSame(Integer.valueOf(99992), actualList.get(1).getMemberId());
        }

        // ## Act ##
        {
            int index = 1;
            for (Member member : memberList) {
                member.setMemberName("quux" + index);
                member.setMemberAccount("quux" + index);
                ++index;
            }
            memberBhv.batchInsert(memberList); // back to identity

            // ## Assert ##
            assertEquals(Integer.valueOf(99991), memberList.get(0).getMemberId());
            assertEquals(Integer.valueOf(99992), memberList.get(1).getMemberId());
            assertNotSame(Integer.valueOf(99991), actualList.get(0).getMemberId());
            assertNotSame(Integer.valueOf(99992), actualList.get(1).getMemberId());
        }
    }

    public void test_varyingBatchInsert_disablePrimaryKeyIdentity_nonIdentity() throws Exception {
        // ## Arrange ##
        List<MemberStatus> statusList = new ArrayList<MemberStatus>();
        {
            MemberStatus status = new MemberStatus();
            status.setMemberStatusCode_Formalized();
            status.setMemberStatusName("FOO");
            status.setDisplayOrder(99);
            statusList.add(status);
        }
        InsertOption<MemberStatusCB> option = new InsertOption<MemberStatusCB>().disablePrimaryKeyIdentity();

        // ## Act ##
        try {
            memberStatusBhv.varyingBatchInsert(statusList, option);

            // ## Assert ##
            fail();
        } catch (IllegalStateException e) {
            // OK
            log(e.getMessage());
        }
    }

    // -----------------------------------------------------
    //                                         Batch Logging
    //                                         -------------
    public void test_varyingBatchInsert_batchLogging_basic() {
        // ## Arrange ##
        List<Member> memberList = new ArrayList<Member>();
        for (int i = 0; i < 10; i++) {
            Member member = new Member();
            member.setMemberName("testName" + i);
            member.setMemberAccount("testAccount" + i);
            member.setMemberStatusCode_Formalized();
            memberList.add(member);
        }
        InsertOption<MemberCB> option = new InsertOption<MemberCB>();
        option.limitBatchInsertLogging(3);

        // ## Act ##
        final List<String> displaySqlList = new ArrayList<String>();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                displaySqlList.add(info.getDisplaySql());
            }
        });
        final List<SqlResultInfo> sqlResultList = new ArrayList<SqlResultInfo>();
        CallbackContext.setSqlResultHandlerOnThread(new SqlResultHandler() {
            public void handle(SqlResultInfo info) {
                sqlResultList.add(info);
            }
        });
        int[] result = memberBhv.varyingBatchInsert(memberList, option);

        // ## Assert ##
        assertEquals(10, result.length);
        assertEquals(3, displaySqlList.size());
        assertEquals(1, sqlResultList.size());
        String sqlResultDisplaySql = sqlResultList.get(0).getSqlLogInfo().getDisplaySql();
        assertEquals(3, Srl.count(sqlResultDisplaySql, "insert into"));
        assertFalse(Srl.startsWith(sqlResultDisplaySql, ln()));
    }

    public void test_varyingBatchInsert_batchLogging_overScope() {
        // ## Arrange ##
        List<Member> memberList = new ArrayList<Member>();
        for (int i = 0; i < 123; i++) {
            Member member = new Member();
            member.setMemberName("testName" + i);
            member.setMemberAccount("testAccount" + i);
            member.setMemberStatusCode_Formalized();
            memberList.add(member);
        }
        InsertOption<MemberCB> option = new InsertOption<MemberCB>();
        option.limitBatchInsertLogging(111);

        // ## Act ##
        final List<String> displaySqlList = new ArrayList<String>();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                displaySqlList.add(info.getDisplaySql());
            }
        });
        final List<SqlResultInfo> sqlResultList = new ArrayList<SqlResultInfo>();
        CallbackContext.setSqlResultHandlerOnThread(new SqlResultHandler() {
            public void handle(SqlResultInfo info) {
                sqlResultList.add(info);
            }
        });
        int[] result = memberBhv.varyingBatchInsert(memberList, option);

        // ## Assert ##
        assertEquals(123, result.length);
        assertEquals(111, displaySqlList.size());
        assertEquals(1, sqlResultList.size());
        String sqlResultDisplaySql = sqlResultList.get(0).getSqlLogInfo().getDisplaySql();
        assertEquals(100, Srl.count(sqlResultDisplaySql, "insert into")); // only first scope
        assertFalse(Srl.startsWith(sqlResultDisplaySql, ln()));
    }

    public void test_varyingBatchInsert_batchLogging_short() {
        // ## Arrange ##
        List<Member> memberList = new ArrayList<Member>();
        for (int i = 0; i < 1; i++) {
            Member member = new Member();
            member.setMemberName("testName" + i);
            member.setMemberAccount("testAccount" + i);
            member.setMemberStatusCode_Formalized();
            memberList.add(member);
        }
        InsertOption<MemberCB> option = new InsertOption<MemberCB>();
        option.limitBatchInsertLogging(3);

        // ## Act ##
        final List<String> displaySqlList = new ArrayList<String>();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                displaySqlList.add(info.getDisplaySql());
            }
        });
        final List<SqlResultInfo> sqlResultList = new ArrayList<SqlResultInfo>();
        CallbackContext.setSqlResultHandlerOnThread(new SqlResultHandler() {
            public void handle(SqlResultInfo info) {
                sqlResultList.add(info);
            }
        });
        int[] result = memberBhv.varyingBatchInsert(memberList, option);

        // ## Assert ##
        assertEquals(1, result.length);
        assertEquals(1, displaySqlList.size());
        assertEquals(1, sqlResultList.size());
        String sqlResultDisplaySql = sqlResultList.get(0).getSqlLogInfo().getDisplaySql();
        assertEquals(1, Srl.count(sqlResultDisplaySql, "insert into"));
        assertFalse(Srl.startsWith(sqlResultDisplaySql, ln()));
    }

    public void test_varyingBatchInsert_batchLogging_zero() {
        // ## Arrange ##
        List<Member> memberList = new ArrayList<Member>();
        for (int i = 0; i < 10; i++) {
            Member member = new Member();
            member.setMemberName("testName" + i);
            member.setMemberAccount("testAccount" + i);
            member.setMemberStatusCode_Formalized();
            memberList.add(member);
        }
        InsertOption<MemberCB> option = new InsertOption<MemberCB>();
        option.limitBatchInsertLogging(0);

        // ## Act ##
        final List<String> displaySqlList = new ArrayList<String>();
        CallbackContext.setSqlLogHandlerOnThread(new SqlLogHandler() {
            public void handle(SqlLogInfo info) {
                displaySqlList.add(info.getDisplaySql());
            }
        });
        final List<SqlResultInfo> sqlResultList = new ArrayList<SqlResultInfo>();
        CallbackContext.setSqlResultHandlerOnThread(new SqlResultHandler() {
            public void handle(SqlResultInfo info) {
                sqlResultList.add(info);
            }
        });
        int[] result = memberBhv.varyingBatchInsert(memberList, option);

        // ## Assert ##
        assertEquals(10, result.length);
        assertEquals(0, displaySqlList.size());
        assertEquals(1, sqlResultList.size());
        SqlLogInfo sqlLogInfo = sqlResultList.get(0).getSqlLogInfo();
        Field field = DfReflectionUtil.getWholeField(SqlLogInfo.class, "_cachedDisplaySql");
        assertNull(DfReflectionUtil.getValueForcedly(field, sqlLogInfo));
        assertNotNull(sqlLogInfo.getDisplaySql());
        assertNotNull(DfReflectionUtil.getValueForcedly(field, sqlLogInfo));
    }

    // ===================================================================================
    //                                                              Varying InsertOrUpdate
    //                                                              ======================
    public void test_varyingInsertOrUpdate_basic() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberId(99999);
        member.setMemberName("testName");
        member.setMemberAccount("testAccount");
        member.setMemberStatusCode_Formalized();
        InsertOption<MemberCB> insertOption = new InsertOption<MemberCB>();
        UpdateOption<MemberCB> updateOption = new UpdateOption<MemberCB>();

        // ## Act ##
        memberBhv.varyingInsertOrUpdate(member, insertOption, updateOption);

        // ## Assert ##
        {
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals(member.getMemberName(), actual.getMemberName());
            assertEquals(member.getMemberAccount(), actual.getMemberAccount());
        }

        // ## Act ##
        member.setMemberName("testNextName");
        member.setMemberAccount("testNextAccount");
        memberBhv.varyingInsertOrUpdate(member, insertOption, updateOption);

        // ## Assert ##
        {
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals(member.getMemberName(), actual.getMemberName());
            assertEquals(member.getMemberAccount(), actual.getMemberAccount());
        }

        // ## Act ##
        member.setMemberName("testNextNextName");
        member.setMemberAccount("testNextNextAccount");
        member.setVersionNo(null);
        memberBhv.varyingInsertOrUpdateNonstrict(member, insertOption, updateOption);

        // ## Assert ##
        {
            Member actual = memberBhv.selectByPKValueWithDeletedCheck(member.getMemberId());
            assertEquals(member.getMemberName(), actual.getMemberName());
            assertEquals(member.getMemberAccount(), actual.getMemberAccount());
        }
    }
}
