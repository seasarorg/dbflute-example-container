package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.util.Date;
import java.util.Map;

import org.seasar.dbflute.cbean.EntityRowHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.exception.NonSpecifiedColumnAccessException;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.dbflute.exentity.MemberWithdrawal;
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
            member.isMemberStatusCodeFormalized(); // expects no exception
            member.isMemberStatusCode_ServiceAvailable(); // expects no exception
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

    public void test_NonSpecifiedAccess_basePointOnly_fkColumn_setupSelectSpecified() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.setupSelect_MemberStatus();
        cb.specify().columnMemberAccount();
        cb.specify().columnMemberStatusCode();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            assertNotNull(member.getMemberId());
            assertNotNull(member.getMemberAccount());
            assertNotNull(member.getMemberStatusCode());
            member.isMemberStatusCodeFormalized(); // expects no exception
            member.isMemberStatusCode_ServiceAvailable(); // expects no exception
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

    public void test_NonSpecifiedAccess_basePointOnly_fkColumn_withoutSetupSelect() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.specify().columnMemberAccount();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            assertNotNull(member.getMemberId());
            assertNotNull(member.getMemberAccount());
            try {
                member.getMemberStatusCode();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            try {
                member.isMemberStatusCodeFormalized();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            try {
                member.getMemberName();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            assertEquals(2, member.myspecifiedProperties().size()); // PK and account and setupSelect

            log(member.toString()); // expected no exception
            log(member.getDBMeta().extractAllColumnMap(member)); // expected no exception
        }
    }

    public void test_NonSpecifiedAccess_basePointOnly_nullColumn() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.specify().columnBirthdate();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            assertNotNull(member.getMemberId());
            try {
                member.getMemberStatusCode();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            try {
                member.isMemberStatusCodeFormalized();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            try {
                member.getMemberName();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            try {
                member.getMemberAccount();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            Date birthdate = member.getBirthdate();
            if (birthdate != null) {
                markHere("existsBirthdate");
            } else {
                markHere("notExistsBirthdate");
            }
            assertEquals(2, member.myspecifiedProperties().size()); // PK and account and setupSelect

            log(member.toString()); // expected no exception
            log(member.getDBMeta().extractAllColumnMap(member)); // expected no exception
        }
        assertMarked("existsBirthdate");
        assertMarked("notExistsBirthdate");
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

    public void test_NonSpecifiedAccess_basePointOnly_manualSet() {
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
            assertEquals(3, member.myspecifiedProperties().size());
            member.setMemberName("manual");
            assertEquals("manual", member.getMemberName());
            try {
                member.getBirthdate();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
            assertEquals(4, member.myspecifiedProperties().size());
            Date currentDate = currentDate();
            member.setBirthdate(currentDate);
            assertEquals(currentDate, member.getBirthdate());
            assertEquals(5, member.myspecifiedProperties().size());

            log(member.toString()); // expected no exception
            log(member.getDBMeta().extractAllColumnMap(member)); // expected no exception
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

    public void test_NonSpecifiedAccess_relationOnly_nullColumn() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.setupSelect_MemberWithdrawalAsOne();
        cb.specify().specifyMemberWithdrawalAsOne().columnWithdrawalReasonInputText();

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

            log(member.toString()); // expected no exception
            log(member.getDBMeta().extractAllColumnMap(member)); // expected no exception

            MemberWithdrawal withdrawal = member.getMemberWithdrawalAsOne();
            if (withdrawal != null) {
                try {
                    withdrawal.getWithdrawalDatetime();
                    fail();
                } catch (NonSpecifiedColumnAccessException e) {
                    log(e.getMessage());
                }
                String inputText = withdrawal.getWithdrawalReasonInputText();
                if (inputText != null) {
                    markHere("existsText");
                } else {
                    markHere("notExistsText");
                }
                try {
                    withdrawal.getWithdrawalReasonCode();
                    fail();
                } catch (NonSpecifiedColumnAccessException e) {
                    log(e.getMessage());
                }

                log(withdrawal.toString()); // expected no exception
                log(withdrawal.getDBMeta().extractAllColumnMap(withdrawal)); // expected no exception

                markHere("existsWithdrawal");
            }

            assertNull(member.getMemberStatus());
        }
        assertMarked("existsText");
        assertMarked("notExistsText");
        assertMarked("existsWithdrawal");

        // ## Act ##
        memberBhv.selectCursor(cb, new EntityRowHandler<Member>() {
            public void handle(Member member) {
                // expected no exception (before various checking)
                Map<String, Object> columnMap = member.getDBMeta().extractAllColumnMap(member);
                log(columnMap);
                assertNotNull(member.getMemberId());
                assertNotNull(member.getMemberAccount());
                assertNotNull(member.getMemberStatusCode());
                assertNotNull(member.getMemberName());

                log(member.toString()); // expected no exception
                log(member.getDBMeta().extractAllColumnMap(member)); // expected no exception

                MemberWithdrawal withdrawal = member.getMemberWithdrawalAsOne();
                if (withdrawal != null) {
                    try {
                        withdrawal.getWithdrawalDatetime();
                        fail();
                    } catch (NonSpecifiedColumnAccessException e) {
                        log(e.getMessage());
                    }
                    String inputText = withdrawal.getWithdrawalReasonInputText();
                    if (inputText != null) {
                        markHere("existsText");
                    } else {
                        markHere("notExistsText");
                    }
                    try {
                        withdrawal.getWithdrawalReasonCode();
                        fail();
                    } catch (NonSpecifiedColumnAccessException e) {
                        log(e.getMessage());
                    }

                    log(withdrawal.toString()); // expected no exception
                    log(withdrawal.getDBMeta().extractAllColumnMap(withdrawal)); // expected no exception

                    markHere("existsWithdrawal");
                }

                assertNull(member.getMemberStatus());
            }
        });
        assertMarked("existsText");
        assertMarked("notExistsText");
        assertMarked("existsWithdrawal");
    }

    // ===================================================================================
    //                                                                      Both Specified
    //                                                                      ==============
    public void test_NonSpecifiedAccess_bothSpecified_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.disableNonSpecifiedColumnAccess();
        cb.specify().columnMemberAccount();
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
            try {
                member.getMemberName();
                fail();
            } catch (NonSpecifiedColumnAccessException e) {
                log(e.getMessage());
            }
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
