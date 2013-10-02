package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.ManualOrderBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.allcommon.CDef;
import com.example.dbflute.spring.dbflute.allcommon.CDef.MemberStatus;
import com.example.dbflute.spring.dbflute.cbean.MemberAddressCB;
import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberAddressBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberAddress;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.9.8 (2012/09/07 Friday)
 */
public class WxCBManualOrderSwitchOrderBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private MemberAddressBhv memberAddressBhv;

    // ===================================================================================
    //                                                                        Dream Cruise
    //                                                                        ============
    public void test_SwitchOrder_DreamCruise() {
        // ## Arrange ##
        adjustMemberStatusCount();
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberSecurityAsOne();
        cb.setupSelect_MemberServiceAsOne();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        cb.query().addOrderBy_MemberStatusCode_Asc();
        ManualOrderBean mob = new ManualOrderBean();
        mob.when_Equal(CDef.MemberStatus.Formalized).then(dreamCruiseCB.specify().columnMemberId());
        mob.when_Equal(CDef.MemberStatus.Provisional).then(
                dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        mob.elseEnd(dreamCruiseCB.specify().specifyMemberSecurityAsOne().columnReminderUseCount());
        cb.query().addOrderBy_MemberStatusCode_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        List<Member> fmlList = newArrayList();
        List<Member> prvList = newArrayList();
        List<Member> wdlList = newArrayList();
        String previousStatus = null;
        Set<String> statusSet = newHashSet();
        for (Member member : memberList) {
            log(member.getMemberStatusCode(), member.getMemberId(), member.getMemberServiceAsOne()
                    .getServicePointCount(), member.getMemberSecurityAsOne().getReminderUseCount());
            if (member.isMemberStatusCodeFormalized()) {
                fmlList.add(member);
            } else if (member.isMemberStatusCodeProvisional()) {
                prvList.add(member);
            } else if (member.isMemberStatusCodeWithdrawal()) {
                wdlList.add(member);
            } else { // no way
                fail();
            }
            String currentStatus = member.getMemberStatusCode();
            if (previousStatus != null && !previousStatus.equals(currentStatus)) {
                assertFalse(statusSet.contains(currentStatus));
            }
            previousStatus = currentStatus;
            statusSet.add(currentStatus);
        }
        {
            Integer previousId = null;
            assertHasPluralElement(fmlList);
            for (Member member : fmlList) {
                Integer memberId = member.getMemberId();
                assertNotNull(memberId);
                assertTrue(previousId == null || previousId < memberId);
                previousId = memberId;
            }
            assertNotNull(previousId);
        }
        {
            Integer previousPoint = null;
            assertHasPluralElement(prvList);
            for (Member member : prvList) {
                Integer point = member.getMemberServiceAsOne().getServicePointCount();
                assertNotNull(point);
                assertTrue(previousPoint == null || previousPoint < point);
                previousPoint = point;
            }
            assertNotNull(previousPoint);
        }
        {
            Integer previousCount = null;
            assertHasPluralElement(wdlList);
            for (Member member : wdlList) {
                Integer count = member.getMemberSecurityAsOne().getReminderUseCount();
                assertNotNull(count);
                assertTrue(previousCount == null || previousCount < count);
                previousCount = count;
            }
            assertNotNull(previousCount);
        }
    }

    // ===================================================================================
    //                                                                             Binding
    //                                                                             =======
    // -----------------------------------------------------
    //                                                 Basic
    //                                                 -----
    public void test_SwitchOrder_binding_basic() {
        // ## Arrange ##
        adjustMemberStatusCount();
        MemberCB cb = new MemberCB();
        // H2 needs to suppress either 'then' or 'else' binding (why?)
        // she said 'Unknown data type' (why?)
        // (cannot judge order column type by all binding?)
        ManualOrderBean mob = new ManualOrderBean().suppressElseBinding();
        mob.when_Equal(CDef.MemberStatus.Formalized).then(3);
        mob.when_Equal(CDef.MemberStatus.Provisional).then(4);
        mob.elseEnd(2);
        cb.query().addOrderBy_MemberStatusCode_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        List<CDef.MemberStatus> expectedList = newArrayList(CDef.MemberStatus.Withdrawal, CDef.MemberStatus.Formalized,
                CDef.MemberStatus.Provisional);
        Set<CDef.MemberStatus> actualSet = newLinkedHashSet();
        for (Member member : memberList) {
            actualSet.add(member.getMemberStatusCodeAsMemberStatus());
        }
        Iterator<MemberStatus> expectedIte = expectedList.iterator();
        Iterator<MemberStatus> actualIte = actualSet.iterator();
        assertEquals(expectedIte.next(), actualIte.next());
        assertEquals(expectedIte.next(), actualIte.next());
        assertEquals(expectedIte.next(), actualIte.next());
    }

    // *(not-suppress)binding test cases are on MySQL
    // because H2 with all binding is unsupported

    // -----------------------------------------------------
    //                                              Suppress
    //                                              --------
    public void test_SwitchOrder_binding_suppress_Number() {
        // ## Arrange ##
        adjustMemberStatusCount();
        MemberCB cb = new MemberCB();
        ManualOrderBean mob = new ManualOrderBean().suppressThenBinding().suppressElseBinding();
        mob.when_Equal(CDef.MemberStatus.Formalized).then(3);
        mob.when_Equal(CDef.MemberStatus.Provisional).then(4);
        mob.elseEnd(2);
        cb.query().addOrderBy_MemberStatusCode_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        List<CDef.MemberStatus> expectedList = newArrayList(CDef.MemberStatus.Withdrawal, CDef.MemberStatus.Formalized,
                CDef.MemberStatus.Provisional);
        Set<CDef.MemberStatus> actualSet = newLinkedHashSet();
        for (Member member : memberList) {
            actualSet.add(member.getMemberStatusCodeAsMemberStatus());
        }
        Iterator<CDef.MemberStatus> expectedIte = expectedList.iterator();
        Iterator<CDef.MemberStatus> actualIte = actualSet.iterator();
        assertEquals(expectedIte.next(), actualIte.next());
        assertEquals(expectedIte.next(), actualIte.next());
        assertEquals(expectedIte.next(), actualIte.next());
    }

    public void test_SwitchOrder_binding_suppress_Date() {
        // ## Arrange ##
        adjustMemberStatusCount();
        MemberCB cb = new MemberCB();
        ManualOrderBean mob = new ManualOrderBean().suppressThenBinding().suppressElseBinding();
        mob.when_Equal(CDef.MemberStatus.Formalized).then(toDate("2012/10/31"));
        mob.when_Equal(CDef.MemberStatus.Provisional).then(toDate("2001/10/31"));
        mob.elseEnd(toDate("2007/10/31"));
        cb.query().addOrderBy_MemberStatusCode_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        List<CDef.MemberStatus> expectedList = newArrayList(CDef.MemberStatus.Provisional,
                CDef.MemberStatus.Withdrawal, CDef.MemberStatus.Formalized);
        Set<CDef.MemberStatus> actualSet = newLinkedHashSet();
        for (Member member : memberList) {
            actualSet.add(member.getMemberStatusCodeAsMemberStatus());
        }
        Iterator<CDef.MemberStatus> expectedIte = expectedList.iterator();
        Iterator<CDef.MemberStatus> actualIte = actualSet.iterator();
        assertEquals(expectedIte.next(), actualIte.next());
        assertEquals(expectedIte.next(), actualIte.next());
        assertEquals(expectedIte.next(), actualIte.next());
    }

    public void test_SwitchOrder_binding_suppress_CDef_String() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberServiceAsOne();
        ManualOrderBean mob = new ManualOrderBean().suppressThenBinding().suppressElseBinding();
        mob.when_Equal(CDef.ServiceRank.Gold).then(CDef.ServiceRank.Plastic);
        mob.when_Equal(CDef.ServiceRank.Plastic).then(CDef.ServiceRank.Silver);
        mob.when_Equal(CDef.ServiceRank.Bronze).then(CDef.ServiceRank.Platinum);
        mob.when_Equal(CDef.ServiceRank.Silver).then(CDef.ServiceRank.Gold);
        mob.elseEnd(CDef.ServiceRank.Bronze);

        // ## Act ##
        try {
            cb.query().addOrderBy_MemberStatusCode_Asc().withManualOrder(mob);

            // ## Assert ##
            fail();
        } catch (IllegalConditionBeanOperationException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_SwitchOrder_binding_suppress_CDef_Integer() {
        // ## Arrange ##
        MemberAddressCB cb = new MemberAddressCB();
        ManualOrderBean mob = new ManualOrderBean().suppressThenBinding().suppressElseBinding();
        mob.when_Equal(CDef.Region.Chiba).then(CDef.Region.America);
        mob.when_Equal(CDef.Region.America).then(CDef.Region.China);
        mob.elseEnd(CDef.Region.Canada);
        cb.query().addOrderBy_RegionId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<MemberAddress> addressList = memberAddressBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(addressList);
        for (MemberAddress address : addressList) {
            log(address.getMemberAddressId(), address.getRegionId(), address.getRegionIdAsRegion().name());
        }
        // assert by whitebox
        String sql = cb.toDisplaySql();
        String chiba = CDef.Region.Chiba.code();
        String america = CDef.Region.America.code();
        String china = CDef.Region.China.code();
        String canada = CDef.Region.Canada.code();
        assertTrue(Srl.containsIgnoreCase(sql, "when dfloc.REGION_ID = " + chiba + " then " + america));
        assertTrue(Srl.containsIgnoreCase(sql, "when dfloc.REGION_ID = " + america + " then " + china));
        assertTrue(Srl.containsIgnoreCase(sql, "else " + canada));
        assertEquals(2, Srl.count(sql, "when "));
    }

    // ===================================================================================
    //                                                                         Test Helper
    //                                                                         ===========
    protected void adjustMemberStatusCount() {
        {
            MemberCB cb = new MemberCB();
            cb.query().setMemberStatusCode_Equal_Formalized();
            cb.fetchFirst(3);
            ListResultBean<Member> memberList = memberBhv.selectList(cb);
            for (Member member : memberList) {
                member.setMemberStatusCode_Provisional();
            }
            memberBhv.batchUpdate(memberList, new SpecifyQuery<MemberCB>() {
                public void specify(MemberCB cb) {
                    cb.specify().columnMemberStatusCode();
                }
            });
        }
        {
            MemberCB cb = new MemberCB();
            cb.query().setMemberStatusCode_Equal_Formalized();
            cb.fetchFirst(3);
            ListResultBean<Member> memberList = memberBhv.selectList(cb);
            for (Member member : memberList) {
                member.setMemberStatusCode_Withdrawal();
            }
            memberBhv.batchUpdate(memberList, new SpecifyQuery<MemberCB>() {
                public void specify(MemberCB cb) {
                    cb.specify().columnMemberStatusCode();
                }
            });
        }
    }
}
