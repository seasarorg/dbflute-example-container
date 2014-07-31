package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.util.HashMap;
import java.util.Map;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.ManualOrderBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.chelper.HpSpecifiedColumn;
import org.seasar.dbflute.cbean.coption.ColumnConversionOption;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberServiceCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberServiceBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberService;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.9.4C (2012/04/26 Wednesday)
 */
public class WxCBManualOrderDreamCruiseBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private MemberServiceBhv memberServiceBhv;

    // ===================================================================================
    //                                                                           Case When
    //                                                                           =========
    public void test_DreamCruise_ManualOrder_CaseWhen_basic() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.when_GreaterEqual(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        assertContains(sql, "when dfloc.MEMBER_ID >= dfrel_4.SERVICE_POINT_COUNT then 0");
    }

    public void test_DreamCruise_ManualOrder_CaseWhen_SpecifyCalculation_basic() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.when_GreaterEqual(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount()
                .plus(dreamCruiseCB.specify().columnVersionNo()));
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        assertContains(sql, "when dfloc.MEMBER_ID >= dfrel_4.SERVICE_POINT_COUNT + dfloc.VERSION_NO then 0");
    }

    public void test_DreamCruise_ManualOrder_CaseWhen_SpecifyCalculation_convert() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.when_GreaterEqual(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount()
                .plus(dreamCruiseCB.specify().columnVersionNo()).convert(new ColumnConversionOption().round(1)));
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        assertContains(sql, "when dfloc.MEMBER_ID >= round((dfrel_4.SERVICE_POINT_COUNT + dfloc.VERSION_NO), 1) then 0");
    }

    public void test_DreamCruise_ManualOrder_CaseWhen_SpecifyCalculation_freedom() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.when_GreaterEqual(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount()
                .multiply(dreamCruiseCB.specify().columnVersionNo().plus(1))
                .convert(new ColumnConversionOption().round(2)));
        mob.multiply(dreamCruiseCB.specify().specifyMemberSecurityAsOne().columnReminderUseCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        // when dfloc.MEMBER_ID * dfrel_3.REMINDER_USE_COUNT
        //        >= round((dfrel_4.SERVICE_POINT_COUNT + dfloc.VERSION_NO + 1), 2) then 0
        assertContains(sql, "when dfloc.MEMBER_ID * dfrel_3.REMINDER_USE_COUNT >= round((dfrel_4.SERVICE_POINT");
        assertContains(sql, "round((dfrel_4.SERVICE_POINT_COUNT * (dfloc.VERSION_NO + 1)), 2) then 0");
    }

    // ===================================================================================
    //                                                                         Calculation
    //                                                                         ===========
    public void test_DreamCruise_ManualOrder_basic() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        Integer previousSortValue = null;
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer servicePointCount = serviceMap.get(memberId).getServicePointCount();
            Integer sortValue = memberId * servicePointCount;
            log(member.getMemberId() + ", " + servicePointCount + ", " + sortValue);
            if (previousSortValue != null && previousSortValue > sortValue) {
                fail();
            }
            previousSortValue = sortValue;
        }
    }

    public void test_DreamCruise_ManualOrder_desc() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        cb.query().addOrderBy_MemberId_Desc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        Integer previousSortValue = null;
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            Integer servicePointCount = serviceMap.get(memberId).getServicePointCount();
            Integer sortValue = memberId * servicePointCount;
            log(member.getMemberId() + ", " + servicePointCount + ", " + sortValue);
            if (previousSortValue != null && previousSortValue < sortValue) {
                fail();
            }
            previousSortValue = sortValue;
        }
    }

    public void test_DreamCruise_ManualOrder_pluralColumn() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        mob.multiply(dreamCruiseCB.specify().specifyMemberSecurityAsOne().columnReminderUseCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        String exp = "(dfloc.MEMBER_ID * dfrel_4.SERVICE_POINT_COUNT) * dfrel_3.REMINDER_USE_COUNT";
        assertContains(sql, "order by " + exp + " asc");
        assertEquals(2, Srl.count(sql, "left outer join"));
    }

    public void test_DreamCruise_ManualOrder_derivedColumn_basic() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
            }
        }, Member.ALIAS_highestPurchasePrice);
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.inviteDerivedToDreamCruise(Member.ALIAS_highestPurchasePrice));
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        // H2 does not support order by column derived from select clause 
        //ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        //assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        String exp = "dfloc.MEMBER_ID * HIGHEST_PURCHASE_PRICE";
        assertContains(sql, "order by " + exp + " asc");
    }

    public void test_DreamCruise_ManualOrder_derivedColumn_twice() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
            }
        }, Member.ALIAS_highestPurchasePrice);
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseCount();
            }
        }, Member.ALIAS_loginCount);
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.inviteDerivedToDreamCruise(Member.ALIAS_highestPurchasePrice));
        mob.plus(dreamCruiseCB.inviteDerivedToDreamCruise(Member.ALIAS_loginCount));
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        // H2 does not support order by column derived from select clause 
        //ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        //assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        String exp = "(dfloc.MEMBER_ID * HIGHEST_PURCHASE_PRICE) + LOGIN_COUNT";
        assertContains(sql, "order by " + exp + " asc");
    }

    public void test_DreamCruise_ManualOrder_inlineCall() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(cb.dreamCruiseCB().specify().specifyMemberServiceAsOne().columnServicePointCount());
        mob.multiply(cb.dreamCruiseCB().specify().specifyMemberSecurityAsOne().columnReminderUseCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        String exp = "(dfloc.MEMBER_ID * dfrel_4.SERVICE_POINT_COUNT) * dfrel_3.REMINDER_USE_COUNT";
        assertContains(sql, "order by " + exp + " asc");
        assertEquals(2, Srl.count(sql, "left outer join"));
    }

    public void test_DreamCruise_ManualOrder_union_journeyLogBook_basic() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
            }
        }, Member.ALIAS_highestPurchasePrice);
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseCount();
            }
        }, Member.ALIAS_loginCount);
        cb.union(new UnionQuery<MemberCB>() {
            public void query(MemberCB unionCB) {
            }
        });
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        // H2 does not support order by column derived from select clause 
        //ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        //assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertContains(sql, "union");
        assertContains(sql, "order by MEMBER_ID * SERVICE_POINT_COUNT_4 asc");
        assertEquals(2, Srl.count(sql, ", dfrel_4.MEMBER_SERVICE_ID as MEMBER_SERVICE_ID_4"));
        assertEquals(2, Srl.count(sql, "left outer join MEMBER_SERVICE dfrel_4 on dfloc.MEMBER_ID = dfrel_4.MEMBER_ID"));
    }

    public void test_DreamCruise_ManualOrder_union_journeyLogBook_nested() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
            }
        }, Member.ALIAS_highestPurchasePrice);
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseCount();
            }
        }, Member.ALIAS_loginCount);
        cb.union(new UnionQuery<MemberCB>() {
            public void query(MemberCB unionCB) {
            }
        });
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.specify().columnVersionNo()).multiply(
                dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        // H2 does not support order by column derived from select clause 
        //ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        //assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertContains(sql, "union");
        assertContains(sql, "order by (MEMBER_ID * VERSION_NO) * SERVICE_POINT_COUNT_4 asc");
        assertEquals(2, Srl.count(sql, ", dfrel_4.MEMBER_SERVICE_ID as MEMBER_SERVICE_ID_4"));
        assertEquals(2, Srl.count(sql, "left outer join MEMBER_SERVICE dfrel_4 on dfloc.MEMBER_ID = dfrel_4.MEMBER_ID"));
    }

    // ===================================================================================
    //                                                                             Convert
    //                                                                             =======
    public void test_DreamCruise_ManualOrder_convert_basic() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.convert(new ColumnConversionOption().coalesce(0));
        mob.multiply(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        assertContains(sql, "order by (coalesce(dfloc.MEMBER_ID, 0)) * dfrel");
        assertContains(sql, ".SERVICE_POINT_COUNT asc");
    }

    public void test_DreamCruise_ManualOrder_convert_both() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.convert(new ColumnConversionOption().coalesce(1));
        HpSpecifiedColumn columnPoint = dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount();
        columnPoint.convert(new ColumnConversionOption().coalesce(2));
        mob.multiply(columnPoint);
        mob.convert(new ColumnConversionOption().coalesce(3));
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        // order by coalesce(((coalesce(dfloc.MEMBER_ID, 1)) * (coalesce(dfrel_4.SERVICE_POINT_COUNT, 2))), 3) asc
        assertContains(sql, "order by coalesce(((coalesce(dfloc.MEMBER_ID, 1)) * (coalesce(dfrel");
        assertContains(sql, ".SERVICE_POINT_COUNT, 2))), 3) asc");
    }

    public void test_DreamCruise_ManualOrder_convert_nested() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.convert(new ColumnConversionOption().coalesce(1));
        mob.multiply(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount()
                .convert(new ColumnConversionOption().coalesce(2))
                .plus(dreamCruiseCB.specify().specifyMemberSecurityAsOne().columnReminderUseCount()));
        mob.convert(new ColumnConversionOption().coalesce(3));
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        String sql = cb.toDisplaySql();
        // order by coalesce(
        //     (
        //        (coalesce(dfloc.MEMBER_ID, 1)) *
        //        ((coalesce(dfrel_4.SERVICE_POINT_COUNT, 2)) + dfrel_3.REMINDER_USE_COUNT)
        //     )
        // , 3) asc
        assertContains(sql, "order by coalesce(((coalesce(dfloc.MEMBER_ID, 1)) * ((coalesce(dfrel");
        assertContains(sql, ".SERVICE_POINT_COUNT, 2)) + dfrel_3.REMINDER_USE_COUNT)), 3");
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    public void test_DreamCruise_ManualOrder_union_basic() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        //cb.setupSelect_MemberServiceAsOne(); // auto-resolved
        cb.union(new UnionQuery<MemberCB>() {
            public void query(MemberCB unionCB) {
            }
        });
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        cb.query().addOrderBy_MemberId_Asc().withManualOrder(mob);

        // ## Act ##
        // H2 does not support ManualOrder on Union
        //ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertContains(sql, "order by MEMBER_ID * SERVICE_POINT_COUNT_4 asc");
        assertEquals(2, Srl.count(sql, "left outer join"));
    }

    public void test_DreamCruise_ManualOrder_union_desc() throws Exception {
        // ## Arrange ##
        ListResultBean<MemberService> serviceList = memberServiceBhv.selectList(new MemberServiceCB());
        Map<Integer, MemberService> serviceMap = new HashMap<Integer, MemberService>();
        for (MemberService service : serviceList) {
            serviceMap.put(service.getMemberId(), service);
        }
        MemberCB cb = new MemberCB();
        //cb.setupSelect_MemberServiceAsOne(); // auto-resolved
        cb.union(new UnionQuery<MemberCB>() {
            public void query(MemberCB unionCB) {
            }
        });
        MemberCB dreamCruiseCB = cb.dreamCruiseCB();
        ManualOrderBean mob = new ManualOrderBean();
        mob.multiply(dreamCruiseCB.specify().specifyMemberServiceAsOne().columnServicePointCount());
        cb.query().addOrderBy_MemberId_Desc().withManualOrder(mob);

        // ## Act ##
        // H2 does not support ManualOrder on Union
        //ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        String sql = cb.toDisplaySql();
        log(ln() + sql);
        assertContains(sql, "order by MEMBER_ID * SERVICE_POINT_COUNT_4 desc");
        assertEquals(2, Srl.count(sql, "left outer join"));
    }
}
