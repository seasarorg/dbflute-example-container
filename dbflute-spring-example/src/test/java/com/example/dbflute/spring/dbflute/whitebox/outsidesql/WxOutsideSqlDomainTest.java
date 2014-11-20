package com.example.dbflute.spring.dbflute.whitebox.outsidesql;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.exception.NonSpecifiedColumnAccessException;

import com.example.dbflute.spring.dbflute.allcommon.DBFluteConfig;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.DomainMemberPmb;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxOutsideSqlDomainTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_outsideSql_selectList_domain_basic() {
        // ## Arrange ##
        DomainMemberPmb pmb = new DomainMemberPmb();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            log(member.toString());
            assertNotNull(member.getMemberId());
            assertNotNull(member.getMemberName());
            assertFalse(member.hasModification());
        }
    }

    // ===================================================================================
    //                                                                Non-Specified Column
    //                                                                ====================
    public void test_outsideSql_selectList_domain_nonSpecified_configAsDefault() {
        // ## Arrange ##
        DomainMemberPmb pmb = new DomainMemberPmb();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            log(member.toString());
            assertNotNull(member.getMemberId());
            assertNotNull(member.getMemberName());
            assertFalse(member.hasModification());
            assertNull(member.getFormalizedDatetime());
            assertNull(member.getMemberStatusCode());
        }
    }

    public void test_outsideSql_selectList_domain_nonSpecified_configOn() {
        // ## Arrange ##
        DBFluteConfig.getInstance().unlock();
        boolean originally = DBFluteConfig.getInstance().isNonSpecifiedColumnAccessAllowed();
        DBFluteConfig.getInstance().setNonSpecifiedColumnAccessAllowed(false);
        try {
            DomainMemberPmb pmb = new DomainMemberPmb();

            // ## Act ##
            ListResultBean<Member> memberList = memberBhv.outsideSql().selectList(pmb);

            // ## Assert ##
            assertFalse(memberList.isEmpty());
            for (Member member : memberList) {
                log(member.toString());
                assertNotNull(member.getMemberId());
                assertNotNull(member.getMemberName());
                assertFalse(member.hasModification());
                try {
                    member.getFormalizedDatetime();
                    fail();
                } catch (NonSpecifiedColumnAccessException e) {
                    log(e.getMessage());
                }
                try {
                    member.getMemberStatusCode();
                    fail();
                } catch (NonSpecifiedColumnAccessException e) {
                    log(e.getMessage());
                }
            }
        } finally {
            DBFluteConfig.getInstance().setNonSpecifiedColumnAccessAllowed(originally);
            DBFluteConfig.getInstance().lock();
        }
    }
}
