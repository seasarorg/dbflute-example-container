package com.example.dbflute.spring.dbflute.whitebox.outsidesql;

import org.seasar.dbflute.exception.DangerousResultSizeException;
import org.seasar.dbflute.exception.EntityDuplicatedException;

import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.MemberNamePmb;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.UnpaidSummaryMemberPmb;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.spring.dbflute.exentity.customize.UnpaidSummaryMember;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 */
public class WxOutsideSqlEntityTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_outsideSql_selectEntity_typed() {
        // ## Arrange ##
        UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberId(3);

        // ## Act ##
        UnpaidSummaryMember member = memberBhv.outsideSql().entityHandling().selectEntity(pmb);

        // ## Assert ##
        log("member=" + member);
        assertNotNull(member);
        assertEquals(3, member.getUnpaidManId().intValue());
    }

    public void test_outsideSql_selectEntity_freeStyle() {
        // ## Arrange ##
        String path = MemberBhv.PATH_selectUnpaidSummaryMember;
        UnpaidSummaryMemberPmb pmb = new UnpaidSummaryMemberPmb();
        pmb.setMemberId(3);
        Class<UnpaidSummaryMember> entityType = UnpaidSummaryMember.class;

        // ## Act ##
        UnpaidSummaryMember member = memberBhv.outsideSql().entityHandling().selectEntity(path, pmb, entityType);

        // ## Assert ##
        log("member=" + member);
        assertNotNull(member);
        assertEquals(3, member.getUnpaidManId().intValue());
    }

    // ===================================================================================
    //                                                                              Scalar
    //                                                                              ======
    public void test_outsideSql_selectEntity_scalar_typed() {
        // ## Arrange ##
        Member member = memberBhv.selectByPKValueWithDeletedCheck(3);
        MemberNamePmb pmb = new MemberNamePmb();
        pmb.setMemberId(3);

        // ## Act ##
        String name = memberBhv.outsideSql().entityHandling().selectEntity(pmb);

        // ## Assert ##
        assertNotNull(name);
        assertEquals(member.getMemberName(), name);
    }

    // ===================================================================================
    //                                                                             Illegal
    //                                                                             =======
    public void test_selectEntity_duplicateResult() {
        // ## Arrange ##
        String path = MemberBhv.PATH_selectSimpleMember;
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.setMemberName_PrefixSearch("S");
        Class<SimpleMember> entityType = SimpleMember.class;

        // ## Act ##
        try {
            memberBhv.outsideSql().entityHandling().selectEntity(path, pmb, entityType);

            // ## Assert ##
            fail();
        } catch (EntityDuplicatedException e) {
            // OK
            log(e.getMessage());
            Throwable cause = e.getCause();
            assertEquals(cause.getClass(), DangerousResultSizeException.class);
        }
    }
}
