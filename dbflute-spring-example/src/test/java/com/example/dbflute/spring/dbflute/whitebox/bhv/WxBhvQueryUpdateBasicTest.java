package com.example.dbflute.spring.dbflute.whitebox.bhv;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.ckey.ConditionKey;
import org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberDbm;
import com.example.dbflute.spring.dbflute.bsentity.dbmeta.MemberServiceDbm;
import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.spring.dbflute.cbean.MemberStatusCB;
import com.example.dbflute.spring.dbflute.cbean.PurchaseCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberLoginBhv;
import com.example.dbflute.spring.dbflute.exbhv.MemberStatusBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.dbflute.exentity.MemberLogin;
import com.example.dbflute.spring.dbflute.exentity.MemberStatus;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.8 (2010/12/21 Tuesday)
 */
public class WxBhvQueryUpdateBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;
    private MemberStatusBhv memberStatusBhv;
    private MemberLoginBhv memberLoginBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_queryUpdate_nullSet() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberStatusCode_Provisional();
        member.setFormalizedDatetime(null);

        MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_Formalized();

        // ## Act ##
        int updatedCount = memberBhv.queryUpdate(member, cb);

        // ## Assert ##
        assertNotSame(0, updatedCount);
        MemberCB actualCB = new MemberCB();
        actualCB.query().setMemberStatusCode_Equal_Provisional();
        actualCB.query().setFormalizedDatetime_IsNull();
        actualCB.query().setUpdateUser_Equal(getAccessContext().getAccessUser()); // common column
        ListResultBean<Member> actualList = memberBhv.selectList(actualCB);
        assertEquals(actualList.size(), updatedCount);
    }

    public void test_queryUpdate_outerJoin() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberStatusCode_Provisional();
        member.setFormalizedDatetime(null);

        MemberCB cb = new MemberCB();
        cb.query().queryMemberStatus().setMemberStatusCode_Equal_Formalized();

        // ## Act ##
        int updatedCount = memberBhv.queryUpdate(member, cb);

        // ## Assert ##
        assertNotSame(0, updatedCount);
        MemberCB actualCB = new MemberCB();
        actualCB.query().setMemberStatusCode_Equal_Provisional();
        actualCB.query().setFormalizedDatetime_IsNull();
        actualCB.query().setUpdateUser_Equal(getAccessContext().getAccessUser()); // common column
        ListResultBean<Member> actualList = memberBhv.selectList(actualCB);
        assertEquals(actualList.size(), updatedCount);
    }

    // ===================================================================================
    //                                                                           Non Query
    //                                                                           =========
    public void test_queryUpdate_noCondition_noQuery() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberStatusCode_Provisional();
        member.setFormalizedDatetime(null);

        MemberCB cb = new MemberCB();

        // ## Act ##
        try {
            int updated = memberBhv.queryUpdate(member, cb);

            // ## Assert ##
            fail("updated=" + updated);
        } catch (NonQueryUpdateNotAllowedException e) {
            // OK
            log(e.getMessage());
        }
    }

    public void test_queryUpdate_noCondition_invalidQuery() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberStatusCode_Provisional();
        member.setFormalizedDatetime(null);

        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(null);
        cb.query().queryMemberServiceAsOne().setServicePointCount_GreaterThan(null);

        // ## Act ##
        try {
            int updated = memberBhv.queryUpdate(member, cb);

            // ## Assert ##
            fail("updated=" + updated);
        } catch (NonQueryUpdateNotAllowedException e) {
            // OK
            String msg = e.getMessage();
            log(msg);
            assertTrue(Srl.contains(msg, MemberDbm.getInstance().columnMemberId().getColumnDbName()));
            assertTrue(Srl.contains(msg, MemberServiceDbm.getInstance().columnServicePointCount().getColumnDbName()));
            assertTrue(Srl.contains(msg, ConditionKey.CK_EQUAL.getConditionKey()));
            assertTrue(Srl.contains(msg, ConditionKey.CK_GREATER_THAN.getConditionKey()));
        }
    }

    // ===================================================================================
    //                                                                       Collaboration
    //                                                                       =============
    public void test_queryUpdate_union() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberStatusCode_Provisional();
        member.setFormalizedDatetime(null);

        MemberCB cb = new MemberCB();
        cb.query().queryMemberStatus().setMemberStatusCode_Equal_Formalized();
        cb.union(new UnionQuery<MemberCB>() {
            public void query(MemberCB unionCB) {
                unionCB.query().queryMemberStatus().setMemberStatusCode_Equal_Formalized();
            }
        });

        // ## Act ##
        int updatedCount = memberBhv.queryUpdate(member, cb);

        // ## Assert ##
        assertNotSame(0, updatedCount);
        MemberCB actualCB = new MemberCB();
        actualCB.query().setMemberStatusCode_Equal_Provisional();
        actualCB.query().setFormalizedDatetime_IsNull();
        actualCB.query().setUpdateUser_Equal(getAccessContext().getAccessUser()); // Common Column
        ListResultBean<Member> actualList = memberBhv.selectList(actualCB);
        assertEquals(actualList.size(), updatedCount);
    }

    public void test_queryUpdate_ExistsReferrer() {
        // ## Arrange ##
        Member member = new Member();
        member.setMemberStatusCode_Provisional();
        member.setFormalizedDatetime(null);

        MemberCB cb = new MemberCB();
        cb.query().setMemberStatusCode_Equal_Formalized();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().setPaymentCompleteFlg_Equal_False();
            }
        });

        // ## Act ##
        int updatedCount = memberBhv.queryUpdate(member, cb);

        // ## Assert ##
        assertNotSame(0, updatedCount);
        MemberCB actualCB = new MemberCB();
        actualCB.query().setMemberStatusCode_Equal_Formalized();
        actualCB.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().setPaymentCompleteFlg_Equal_False();
            }
        });
        actualCB.query().setMemberStatusCode_Equal_Provisional();
        actualCB.query().setFormalizedDatetime_IsNull();
        actualCB.query().setUpdateUser_Equal(getAccessContext().getAccessUser()); // Common Column
        ListResultBean<Member> actualList = memberBhv.selectList(actualCB);
        assertEquals(actualList.size(), updatedCount);
    }

    // ===================================================================================
    //                                                                              Tricky
    //                                                                              ======
    public void test_queryUpdate_PK_update() {
        // ## Arrange ##
        MemberLogin login = new MemberLogin();
        login.setMemberLoginId(99999L);
        login.setLoginMemberStatusCode_Withdrawal();

        MemberLoginCB cb = new MemberLoginCB();
        cb.query().setMemberLoginId_Equal(3L);

        // ## Act ##
        int updatedCount = memberLoginBhv.queryUpdate(login, cb);

        // ## Assert ##
        assertNotSame(0, updatedCount);
        MemberLogin deleted = memberLoginBhv.selectEntity(cb);
        assertNull(deleted);
        MemberLogin actual = memberLoginBhv.selectByPKValueWithDeletedCheck(99999L);
        assertTrue(actual.isLoginMemberStatusCodeWithdrawal());
    }

    public void test_queryUpdate_noupdate() {
        // ## Arrange ##
        MemberStatus status = new MemberStatus();
        MemberStatusCB cb = new MemberStatusCB();
        cb.query().setMemberStatusCode_Equal_Formalized();

        // ## Act ##
        int updatedCount = memberStatusBhv.queryUpdate(status, cb); // expect no exception

        // ## Assert ##
        assertEquals(0, updatedCount);
    }
}
