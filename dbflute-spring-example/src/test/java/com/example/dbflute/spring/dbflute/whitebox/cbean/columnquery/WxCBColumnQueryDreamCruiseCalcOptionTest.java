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
 * @since 1.0.5L (2014/09/14 Sunday)
 */
public class WxCBColumnQueryDreamCruiseCalcOptionTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                         Calculation
    //                                                                         ===========
    public void test_ColumnQuery_calc_basic() throws Exception {
        // ## Arrange ##
        {
            Member member = new Member();
            member.setBirthdate(toDate("2014/09/10"));
            UpdateOption<MemberCB> option = new UpdateOption<MemberCB>().allowNonQueryUpdate();
            memberBhv.varyingQueryUpdate(member, new MemberCB(), option);
        }
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnVersionNo();
            }
        }).lessEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(123);
            }
        }).plus(cb.dreamCruiseCB().specify().columnVersionNo());
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().specifyMemberSecurityAsOne().columnReminderUseCount();
            }
        }).lessThan(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(456);
            }
        }).divide(cb.dreamCruiseCB().specify().columnMemberId()).divide(cb.dreamCruiseCB().specify().columnVersionNo());
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberId();
            }
        }).greaterEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(789L);
            }
        }).divide(cb.dreamCruiseCB().specify().columnMemberId().plus(99))
                .minus(cb.dreamCruiseCB().specify().columnVersionNo()).left()
                .plus(cb.dreamCruiseCB().specify().specifyMemberServiceAsOne().columnServicePointCount());

        // ## Act ##
        // conversion error
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        assertContains(sql, "where dfloc.VERSION_NO <= 123 + dfloc.VERSION_NO");
        assertContains(sql, "and dfrel_3.REMINDER_USE_COUNT < (456 / dfloc.MEMBER_ID) / dfloc.VERSION_NO");
        assertContains(sql,
                "and dfloc.MEMBER_ID + dfrel_4.SERVICE_POINT_COUNT >= (789 / (dfloc.MEMBER_ID + 99)) - dfloc.VERSION_NO");
    }

    // ===================================================================================
    //                                                                              Option
    //                                                                              ======
    public void test_ColumnQuery_option_basic() throws Exception {
        // ## Arrange ##
        {
            Member member = new Member();
            member.setBirthdate(toDate("2014/09/10"));
            UpdateOption<MemberCB> option = new UpdateOption<MemberCB>().allowNonQueryUpdate();
            memberBhv.varyingQueryUpdate(member, new MemberCB(), option);
        }
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        ColumnConversionOption firstOption = new ColumnConversionOption().addMonth(
                cb.dreamCruiseCB().specify().columnVersionNo()).trunc(cb.dreamCruiseCB().specify().columnMemberId());
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).lessEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toDate("2015/04/05"));
            }
        }).convert(firstOption);
        ColumnConversionOption secondOption = new ColumnConversionOption().trunc(
                cb.dreamCruiseCB().specify().columnMemberId()).round(cb.dreamCruiseCB().specify().columnVersionNo());
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().specifyMemberSecurityAsOne().columnReminderUseCount();
            }
        }).lessThan(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(1);
            }
        }).convert(secondOption);
        ColumnConversionOption onParandeOption = new ColumnConversionOption()
                .subtractDay(cb.dreamCruiseCB().specify().columnMemberId().plus(99)).addMinute(-1)
                .coalesce(cb.dreamCruiseCB().specify().columnBirthdate());
        cb.columnQuery(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnBirthdate();
            }
        }).greaterEqual(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.mysticRhythms(toDate("2006/09/26"));
            }
        }).convert(onParandeOption);

        // ## Act ##
        // conversion error
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        assertContains(sql,
                "where dfloc.BIRTHDATE <= truncate(dateadd(month, dfloc.VERSION_NO, '2015-04-05'), dfloc.MEMBER_ID)");
        assertContains(sql, "and dfrel_3.REMINDER_USE_COUNT < round(truncate(1, dfloc.MEMBER_ID), dfloc.VERSION_NO)");
        assertContains(
                sql,
                "and dfloc.BIRTHDATE >= coalesce(dateadd(minute, -1, dateadd(day, -dfloc.MEMBER_ID + 99, '2006-09-26')), dfloc.BIRTHDATE)");
    }
}
