package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.util.Map;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.exception.NonSpecifiedColumnAccessException;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.1.0 (2014/10/20 Monday)
 */
public class WxCBSpecifyColumnNonSpecifiedAccessTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                      BasePoint Only
    //                                                                      ==============
    public void test_NonSpecifiedAccess_basePointOnly_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.setupSelect_MemberStatus();
        cb.specify().columnMemberAccount();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            assertNotNull(member.getMemberId());
            assertNotNull(member.getMemberAccount());
            assertNotNull(member.getMemberStatusCode());
            try {
                member.getMemberName();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            assertEquals(3, member.myspecifiedProperties().size()); // PK and account and setupSelect

            log(member.toString()); // expected no exception
            log(member.getDBMeta().extractAllColumnMap(member)); // expected no exception
        }
    }

    public void test_NonSpecifiedAccess_basePointOnly_toString() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.setupSelect_MemberStatus();
        cb.specify().columnMemberAccount();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            log(member.toString()); // expected no exception (before various checking)
            assertNotNull(member.getMemberId());
            assertNotNull(member.getMemberAccount());
            assertNotNull(member.getMemberStatusCode());
            try {
                member.getMemberName();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            try {
                assertNull(member.getVersionNo());
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            assertEquals(3, member.myspecifiedProperties().size()); // PK and account and setupSelect
        }
    }

    public void test_NonSpecifiedAccess_basePointOnly_columnMap() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.setupSelect_MemberStatus();
        cb.specify().columnMemberAccount();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            // expected no exception (before various checking)
            Map<String, Object> columnMap = member.getDBMeta().extractAllColumnMap(member);
            log(columnMap);
            assertNotNull(member.getMemberId());
            assertNotNull(member.getMemberAccount());
            assertNotNull(member.getMemberStatusCode());
            try {
                member.getMemberName();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            assertEquals(3, member.myspecifiedProperties().size()); // PK and account and setupSelect
        }
    }

    // ===================================================================================
    //                                                                       Relation Only
    //                                                                       =============
    public void test_NonSpecifiedAccess_relationOnly_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.setupSelect_MemberStatus();
        cb.specify().specifyMemberStatus().columnDisplayOrder();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            // expected no exception (before various checking)
            Map<String, Object> columnMap = member.getDBMeta().extractAllColumnMap(member);
            log(columnMap);
            assertNotNull(member.getMemberId());
            assertNotNull(member.getMemberAccount());
            assertNotNull(member.getMemberStatusCode());
            assertNotNull(member.getMemberName());
            MemberStatus status = member.getMemberStatus();
            assertNotNull(status.getMemberStatusCode());
            try {
                status.getMemberStatusName();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            assertNotNull(status.getDisplayOrder());
            try {
                status.getDescription();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }

            assertEquals(2, status.myspecifiedProperties().size()); // PK and account and setupSelect

            log(member.toString()); // expected no exception
            log(member.getDBMeta().extractAllColumnMap(member)); // expected no exception

            log(status.toString()); // expected no exception
            log(status.getDBMeta().extractAllColumnMap(status)); // expected no exception
        }
    }
}
