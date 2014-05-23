package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.util.List;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.bhv.ReferrerListHandler;
import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.spring.dbflute.cbean.MemberServiceCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.cbean.ServiceRankCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberServiceBhv;
import com.example.dbflute.spring.dbflute.exbhv.ServiceRankBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberService;
import com.example.dbflute.spring.dbflute.exentity.Purchase;
import com.example.dbflute.spring.dbflute.exentity.ServiceRank;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5F (2014/05/06 Tuesday)
 */
public class WxBhvLoadReferrerNestedTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private ServiceRankBhv serviceRankBhv;
    private MemberServiceBhv memberServiceBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_loadReferrer_one_entity() {
        // ## Arrange ##
        ServiceRankCB cb = new ServiceRankCB();

        //cb.loadPurchaseList(purchaseCB -> {
        //    purchaseCB.setupSelect...
        //    purchaseCB.query()...
        //    purchaseCB.loadPurchaseDetailList(detailCB -> {
        //        detailCB.setupSelect_Xxxxxxxxxx();
        //        detailCB.setupSelect_DetailAssistInfoAsOne();
        //        detailCB.query()...
        //        detailCB.pulloutDetailAssistInfoAsOne().loadPurchase()...
        //    });
        //});

        // ## Act ##
        ListResultBean<ServiceRank> rankList = serviceRankBhv.selectList(cb);

        // ServiceRank
        //  |-MemberService -> Member
        //                      |-Purchase
        //
        // if Java8
        // serviceRankBhv.loadMemberServiceList(rankList, serviceCB -> {
        //     serviceCB.setupSelect_Member().withMemberStatus();
        //     serviceCB.query().queryMember().setMemberStatusCode_Equal_Formalized();
        // }).withNestedReferrer(serviceList -> {
        //     List<Member> memberList = memberServiceBhv.pulloutMember(serviceList);
        //     memberBhv.loadPurchaseList(memberList, purchaseCB -> {
        //         purchaseCB.query().setPurchasePrice_GreaterEqual(1000);
        //     });
        // });
        serviceRankBhv.loadMemberServiceList(rankList, new ConditionBeanSetupper<MemberServiceCB>() {
            public void setup(MemberServiceCB cb) {
                cb.setupSelect_Member().withMemberStatus();
                cb.query().queryMember().setMemberStatusCode_Equal_Formalized();
            }
        }).withNestedReferrer(new ReferrerListHandler<MemberService>() {
            public void handle(List<MemberService> referrerList) {
                List<Member> memberList = memberServiceBhv.pulloutMember(referrerList);
                memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
                    public void setup(PurchaseCB cb) {
                        cb.query().setPurchasePrice_GreaterEqual(1000);
                    }
                });
            }
        });

        // ## Assert ##
        assertHasAnyElement(rankList);
        for (ServiceRank rank : rankList) {
            log(rank.getServiceRankName());
            List<MemberService> serviceList = rank.getMemberServiceList();
            for (MemberService service : serviceList) {
                Member member = service.getMember();
                log("  " + member.getMemberId(), member.getMemberName(),
                        member.getMemberStatus().getMemberStatusName(), service.getServiceRankCode(),
                        service.getServicePointCount());
                List<Purchase> purchaseList = member.getPurchaseList();
                for (Purchase purchase : purchaseList) {
                    log("    " + purchase.getMemberId(), purchase.getPurchasePrice());
                    markHere("exists");
                }
            }
        }
        assertMarked("exists");
    }
}
