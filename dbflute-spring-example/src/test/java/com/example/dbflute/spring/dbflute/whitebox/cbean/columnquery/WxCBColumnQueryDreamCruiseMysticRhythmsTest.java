package com.example.dbflute.spring.dbflute.whitebox.cbean.columnquery;

import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.coption.ColumnConversionOption;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5L (2014/09/13 Saturday)
 */
public class WxCBColumnQueryDreamCruiseMysticRhythmsTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_ColumnQuery_MysticRhythms_basic() throws Exception {
        // ## Arrange ##
        {
            Member member = new Member();
            member.setBirthdate(toDate("2014/09/10"));
            UpdateOption<MemberCB> option = new UpdateOption<MemberCB>().allowNonQueryUpdate();
            memberBhv.varyingQueryUpdate(member, new MemberCB(), option);
        }
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).lessEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toDate("2015/04/05"));
            }
        }).convert(new ColumnConversionOption().addMonth(dreamCruiseCB.specify().columnVersionNo()));
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).lessThan(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toDate("2014/09/01"));
            }
        }).convert(new ColumnConversionOption().addDay(dreamCruiseCB.specify().columnMemberId()).addMinute(1));
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).greaterEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toDate("2006/09/26"));
            }
        });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            log(memberId, member.getMemberName());
            assertTrue(memberId >= 9);
            if (memberId.equals(9)) {
                markHere("exists");
            }
        }
        assertMarked("exists");
        String sql = cb.toDisplaySql();
        assertContains(sql, "where dfloc.BIRTHDATE <= dateadd(month, dfloc.VERSION_NO, '2015-04-05')");
        assertContains(sql, "and dfloc.BIRTHDATE < dateadd(minute, 1, dateadd(day, dfloc.MEMBER_ID, '2014-09-01'))");
        assertContains(sql, "and dfloc.BIRTHDATE >= '2006-09-26'");
    }

    public void test_ColumnQuery_MysticRhythms_timestamp() throws Exception {
        // ## Arrange ##
        {
            Member member = new Member();
            member.setFormalizedDatetime(toTimestamp("2014/09/10 12:34:56"));
            UpdateOption<MemberCB> option = new UpdateOption<MemberCB>().allowNonQueryUpdate();
            memberBhv.varyingQueryUpdate(member, new MemberCB(), option);
        }
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnFormalizedDatetime();
            }
        }).lessEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toTimestamp("2015/04/05 12:34:56"));
            }
        }).convert(new ColumnConversionOption().addMonth(dreamCruiseCB.specify().columnVersionNo()));
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnFormalizedDatetime();
            }
        }).lessEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toTimestamp("2014/09/01 15:00:00"));
            }
        }).convert(new ColumnConversionOption().addDay(dreamCruiseCB.specify().columnMemberId()).addHour(-3));
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnFormalizedDatetime();
            }
        }).greaterEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toTimestamp("2006/09/26 12:34:56.789"));
            }
        });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            log(member.getMemberId(), member.getMemberName());
            assertTrue(member.getMemberId() >= 10);
        }
        String sql = cb.toDisplaySql();
        assertContains(sql,
                "where dfloc.FORMALIZED_DATETIME <= dateadd(month, dfloc.VERSION_NO, '2015-04-05 12:34:56.000')");
        assertContains(sql,
                "and dfloc.FORMALIZED_DATETIME <= dateadd(hour, -3, dateadd(day, dfloc.MEMBER_ID, '2014-09-01 15:00:00.000'))");
        assertContains(sql, "and dfloc.FORMALIZED_DATETIME >= '2006-09-26 12:34:56.789'");
    }

    // ===================================================================================
    //                                                                            Subtract
    //                                                                            ========
    public void test_ColumnQuery_MysticRhythms_subtract() throws Exception {
        // ## Arrange ##
        {
            Member member = new Member();
            member.setBirthdate(toDate("2014/09/10"));
            UpdateOption<MemberCB> option = new UpdateOption<MemberCB>().allowNonQueryUpdate();
            memberBhv.varyingQueryUpdate(member, new MemberCB(), option);
        }
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).greaterEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toDate("2006/09/26"));
            }
        }).convert(new ColumnConversionOption().subtractMonth(dreamCruiseCB.specify().columnVersionNo()));
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).lessEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toDate("2014/09/20"));
            }
        }).convert(new ColumnConversionOption().subtractDay(dreamCruiseCB.specify().columnMemberId()).addMinute(-1));
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).lessEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toDate("2015/04/05"));
            }
        });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            log(memberId, member.getMemberName());
            assertTrue(memberId <= 9);
            if (memberId.equals(9)) {
                markHere("exists");
            }
        }
        assertMarked("exists");
        String sql = cb.toDisplaySql();
        assertContains(sql, "where dfloc.BIRTHDATE >= dateadd(month, -dfloc.VERSION_NO, '2006-09-26')");
        assertContains(sql, "and dfloc.BIRTHDATE <= dateadd(minute, -1, dateadd(day, -dfloc.MEMBER_ID, '2014-09-20'))");
        assertContains(sql, "and dfloc.BIRTHDATE <= '2015-04-05'");
    }
}
