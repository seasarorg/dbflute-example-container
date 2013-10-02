package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.sql.Timestamp;
import java.util.Date;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxCBDerivedReferrerQueryTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;
    private MemberStatusBhv memberStatusBhv;

    public void test_query_derivedReferrer_OneToManyToOne() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().specifySummaryProduct().columnLatestPurchaseDatetime();
            }
        }).lessThan(currentTimestamp());

        // ## Act ##
        // Expect no exception
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            log(member);
        }
    }

    public void test_query_derivedReferrer_OneToManyToOne_with_union() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().specifySummaryProduct().columnLatestPurchaseDatetime();
                subCB.union(new UnionQuery<PurchaseCB>() {
                    public void query(PurchaseCB unionCB) {
                    }
                });
            }
        }).lessEqual(currentTimestamp());
        cb.union(new UnionQuery<MemberCB>() {
            public void query(MemberCB unionCB) {
            }
        });

        // ## Act ##
        // Expect no exception
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertFalse(memberList.isEmpty());
        for (Member member : memberList) {
            log(member);
        }
    }

    public void test_query_derivedReferrer_in_ExistsReferrer() {
        // ## Arrange ##
        MemberStatusCB cb = new MemberStatusCB();
        cb.query().existsMemberList(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.query().setMemberId_LessThan(300);
                subCB.query().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.specify().columnPurchasePrice();
                    }
                }).greaterEqual(1234);
            }
        });
        cb.query().setDisplayOrder_LessEqual(500);

        // ## Act ##
        ListResultBean<MemberStatus> statusList = memberStatusBhv.selectList(cb);

        // ## Assert ##
        assertNotSame(0, statusList.size());
        for (MemberStatus status : statusList) {
            log(status);
        }
        String sql = cb.toDisplaySql();
        assertTrue(Srl.containsAll(sql, ") >= 1234"));
    }

    public void test_query_derivedReferrer_between_Integer() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().sum(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseCount();
            }
        }, Member.ALIAS_loginCount); // rental
        Integer fromCount = 6;
        Integer toCount = 7;
        cb.query().derivedPurchaseList().sum(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseCount();
            }
        }).between(fromCount, toCount);

        // ## Act ##
        // Expect no exception
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            Integer loginCount = member.getLoginCount();
            log(member.getMemberName() + ", " + loginCount);
            assertTrue(fromCount <= loginCount);
            assertTrue(toCount >= loginCount);
        }
    }

    public void test_query_derivedReferrer_between_Date() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseDatetime();
            }
        }, Member.ALIAS_latestLoginDatetime); // rental
        Date fromDate = toDate("2007/11/01");
        Date toDate = toDate("2007/11/02");
        cb.query().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchaseDatetime();
            }
        }).between(fromDate, toDate);

        // ## Act ##
        // Expect no exception
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            Timestamp latestDate = member.getLatestLoginDatetime();
            log(member.getMemberName() + ", " + toString(member.getLatestLoginDatetime()));
            assertTrue(fromDate.equals(latestDate) || fromDate.before(latestDate));
            assertTrue(toDate.equals(latestDate) || toDate.after(latestDate));
        }
    }
}
