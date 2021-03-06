package com.example.dbflute.spring.dbflute.whitebox.cbean.derivedreferrer;

import java.sql.Timestamp;
import java.util.Date;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.coption.FromToOption;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.spring.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.cbean.PurchasePaymentCB;
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
        }).rangeOf(fromCount, toCount);

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
        }).fromTo(fromDate, toDate, new FromToOption());

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

    public void test_query_derivedReferrer_OneToManyToMany_union_monkey() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
                subCB.query().setMobileLoginFlg_Equal_False();
                subCB.union(new UnionQuery<MemberLoginCB>() {
                    public void query(MemberLoginCB unionCB) {
                        unionCB.query().setLoginMemberStatusCode_Equal_Formalized();
                    }
                });
            }
        }).lessEqual(toDate("2014/07/12"));
        cb.query().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().derivedPurchasePaymentList().max(new SubQuery<PurchasePaymentCB>() {
                    public void query(PurchasePaymentCB subCB) {
                        subCB.specify().columnPaymentAmount();
                    }
                }, null);
                subCB.union(new UnionQuery<PurchaseCB>() {
                    public void query(PurchaseCB unionCB) {
                    }
                });
            }
        }).greaterEqual(1);

        // ## Act ##
        memberBhv.selectList(cb); // expect no exception

        // ## Assert ##
        /*
        select dfloc.MEMBER_ID as MEMBER_ID, dfloc.MEMBER_NAME as MEMBER_NAME, dfloc.MEMBER_ACCOUNT as MEMBER_ACCOUNT, dfloc.MEMBER_STATUS_CODE as MEMBER_STATUS_CODE, dfloc.FORMALIZED_DATETIME as FORMALIZED_DATETIME, dfloc.BIRTHDATE as BIRTHDATE, dfloc.REGISTER_DATETIME as REGISTER_DATETIME, dfloc.REGISTER_USER as REGISTER_USER, dfloc.UPDATE_DATETIME as UPDATE_DATETIME, dfloc.UPDATE_USER as UPDATE_USER, dfloc.VERSION_NO as VERSION_NO
          from MEMBER dfloc
         where (select max(sub1main.LOGIN_DATETIME)
                  from (select sub1loc.MEMBER_LOGIN_ID, sub1loc.MEMBER_ID, sub1loc.LOGIN_DATETIME
                          from MEMBER_LOGIN sub1loc
                         where sub1loc.MOBILE_LOGIN_FLG = 0
                         union 
                        select sub1loc.MEMBER_LOGIN_ID, sub1loc.MEMBER_ID, sub1loc.LOGIN_DATETIME 
                          from MEMBER_LOGIN sub1loc 
                         where sub1loc.LOGIN_MEMBER_STATUS_CODE = 'FML'
                       ) sub1main
                 where sub1main.MEMBER_ID = dfloc.MEMBER_ID
               ) <= '2014-07-12'
           and (select max((select max(sub2loc.PAYMENT_AMOUNT)
                              from PURCHASE_PAYMENT sub2loc 
                             where sub2loc.PURCHASE_ID = sub1main.PURCHASE_ID
                       ))
                  from (select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID
                          from PURCHASE sub1loc
                         union 
                        select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID 
                          from PURCHASE sub1loc 
                       ) sub1main
                 where sub1main.MEMBER_ID = dfloc.MEMBER_ID
               ) >= 1
        */
        String sql = cb.toDisplaySql();
        assertTrue(sql.contains("where (select max(sub1main.LOGIN_DATETIME)"));
        assertTrue(sql.contains("from (select sub1loc.MEMBER_LOGIN_ID, sub1loc.MEMBER_ID, sub1loc.LOGIN_DATETIME"));
        assertTrue(sql.contains("where sub1loc.MOBILE_LOGIN_FLG = 0"));
        assertTrue(sql.contains("where sub1loc.LOGIN_MEMBER_STATUS_CODE = 'FML'"));
        assertTrue(sql.contains("where sub1main.MEMBER_ID = dfloc.MEMBER_ID"));
        assertTrue(sql.contains(") <= '2014-07-12'"));
        assertTrue(sql.contains("and (select max((select max(sub2loc.PAYMENT_AMOUNT)"));
        assertTrue(sql.contains("where sub2loc.PURCHASE_ID = sub1main.PURCHASE_ID"));
        assertTrue(sql.contains("from (select sub1loc.PURCHASE_ID, sub1loc.MEMBER_ID"));
        assertTrue(sql.contains("where sub1main.MEMBER_ID = dfloc.MEMBER_ID"));
        assertTrue(sql.contains(") >= 1"));
    }

    // *(Query)DerivedReferrer using DreamCruise is at WxCBDerivedReferrerDreamCruiseTest
}
