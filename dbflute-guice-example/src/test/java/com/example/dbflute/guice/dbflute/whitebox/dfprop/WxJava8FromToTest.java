package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.joda.time.LocalDateTime;
import org.seasar.dbflute.cbean.coption.FromToOption;
import org.seasar.dbflute.exception.InvalidQueryRegisteredException;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5K (2014/08/06 Wednesday)
 */
public class WxJava8FromToTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Plain
    //                                                                               =====
    public void test_FromTo_plain_basic() throws Exception {
        // ## Arrange ##
        Member updated = updateFormalizedDatetime("2011/11/18 12:34:56.789");
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(updated.getMemberId());
        LocalDateTime fromDate = toLocalDateTime("2011/11/17 12:34:56.789");
        LocalDateTime toDate = toLocalDateTime("2011/11/19 02:04:06.009");
        FromToOption option = new FromToOption();
        cb.query().setFormalizedDatetime_FromTo(fromDate, toDate, option);
        cb.query().setBirthdate_LessThan(toLocalDate("3714/08/08 12:34:56"));

        // ## Act ##
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertTrue(Srl.contains(sql, " >= '2011-11-17T12:34:56.789'"));
        assertTrue(Srl.contains(sql, " <= '2011-11-19T02:04:06.009'"));
        assertTrue(Srl.contains(sql, " < '3714-08-08'"));
        log(member.getFormalizedDatetime());
        assertEquals(updated.getFormalizedDatetime(), member.getFormalizedDatetime());
    }

    // ===================================================================================
    //                                                                           Either-Or
    //                                                                           =========
    public void test_DateFromTo_eitherOr_from() {
        try {
            // ## Arrange ##
            MemberCB cb = new MemberCB();
            // ## Act ##
            cb.query().setBirthdate_FromTo(toLocalDate("2011-01-21"), null, new FromToOption().compareAsDate());
            fail();
        } catch (InvalidQueryRegisteredException e) {
            log(e.getMessage());
        }
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        // ## Act ##
        cb.query().setBirthdate_FromTo(toLocalDate("2011-01-21"), null,
                new FromToOption().compareAsDate().allowOneSide());

        // ## Assert ##
        assertTrue(cb.hasWhereClauseOnBaseQuery());
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertTrue(Srl.contains(sql, " >= '2011-01-21'"));
    }

    public void test_DateFromTo_eitherOr_to() {
        try {
            // ## Arrange ##
            MemberCB cb = new MemberCB();
            // ## Act ##
            cb.query().setBirthdate_DateFromTo(null, toLocalDate("2011-01-21"));
            fail();
        } catch (InvalidQueryRegisteredException e) {
            log(e.getMessage());
        }
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        // ## Act ##
        cb.query().setBirthdate_FromTo(null, toLocalDate("2011-01-21"),
                new FromToOption().compareAsDate().allowOneSide());

        // ## Assert ##
        assertTrue(cb.hasWhereClauseOnBaseQuery());
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertTrue(Srl.contains(sql, " < '2011-01-22'")); // added
    }

    // ===================================================================================
    //                                                                            No Query
    //                                                                            ========
    public void test_DateFromTo_noQuery() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();

        // ## Act ##
        try {
            cb.query().setBirthdate_DateFromTo(null, null);
            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            log(e.getMessage());
        }

        // ## Act ##
        try {
            cb.query().setBirthdate_FromTo(null, null, new FromToOption().allowOneSide());
            // ## Assert ##
            fail();
        } catch (InvalidQueryRegisteredException e) {
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    protected Member updateFormalizedDatetime(String exp) {
        MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_Formalized();
        cb.fetchFirst(1);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);
        member.setFormalizedDatetime(toLocalDateTime(exp));
        memberBhv.updateNonstrict(member);
        return member;
    }
}
