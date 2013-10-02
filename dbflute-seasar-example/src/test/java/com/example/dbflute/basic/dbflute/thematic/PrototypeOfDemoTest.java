package com.example.dbflute.basic.dbflute.thematic;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;

import com.example.dbflute.basic.dbflute.cbean.MemberCB;
import com.example.dbflute.basic.dbflute.cbean.PurchaseCB;
import com.example.dbflute.basic.dbflute.exbhv.MemberBhv;
import com.example.dbflute.basic.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.basic.dbflute.exentity.Member;
import com.example.dbflute.basic.unit.UnitContainerTestCase;

/**
 * @author jflute
 */
@SuppressWarnings("unused")
public class PrototypeOfDemoTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;
    private PurchaseBhv purchaseBhv;

    public void test_demo() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().setPaymentCompleteFlg_Equal_False();
            }
        });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            log(member);
        }
    }

    // wall
    // wall
    // wall
    // wall
    // wall
    // wall
    // wall
    // wall
}
