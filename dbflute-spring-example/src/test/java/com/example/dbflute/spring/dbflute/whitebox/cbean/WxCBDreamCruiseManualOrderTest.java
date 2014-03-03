package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.util.HashMap;
import java.util.Map;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.ManualOrderBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
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
public class WxCBDreamCruiseManualOrderTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private MemberServiceBhv memberServiceBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
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
        assertTrue(sql.contains("order by " + exp + " asc"));
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
        assertTrue(sql.contains("order by " + exp + " asc"));
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
        assertTrue(sql.contains("order by " + exp + " asc"));
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
        assertTrue(sql.contains("order by " + exp + " asc"));
        assertEquals(2, Srl.count(sql, "left outer join"));
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
        assertTrue(sql.contains("order by MEMBER_ID * SERVICE_POINT_COUNT_4 asc"));
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
        assertTrue(sql.contains("order by MEMBER_ID * SERVICE_POINT_COUNT_4 desc"));
        assertEquals(2, Srl.count(sql, "left outer join"));
    }
}
