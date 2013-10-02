package com.example.dbflute.spring.dbflute.whitebox.cbean;

import java.util.Date;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.DerivedReferrerOption;
import org.seasar.dbflute.util.DfTypeUtil;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.6.0 (2008/01/16 Wednesday)
 */
public class WxCBDerivedReferrerOrderByTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_sepcify_derivedReferrer_orderBy_basic() {
        // ## Arrange ##
        Date defaultLoginDate = DfTypeUtil.toDate("1000/01/01");
        MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
                subCB.query().setMobileLoginFlg_Equal_False();
            }
        }, Member.ALIAS_latestLoginDatetime, new DerivedReferrerOption().coalesce(defaultLoginDate));
        cb.query().addSpecifiedDerivedOrderBy_Asc(Member.ALIAS_latestLoginDatetime);

        // ## Act ##
        {
            ListResultBean<Member> memberList = memberBhv.selectList(cb);

            // ## Assert ##
            assertFalse(memberList.isEmpty());
            Date first = memberList.get(0).getLatestLoginDatetime();
            Date last = memberList.get(memberList.size() - 1).getLatestLoginDatetime();
            assertTrue(first.before(last));
        }

        // ## Arrange ##
        cb.clearOrderBy();
        cb.query().addSpecifiedDerivedOrderBy_Desc(Member.ALIAS_latestLoginDatetime);

        // ## Act ##
        {
            ListResultBean<Member> memberList = memberBhv.selectList(cb);

            // ## Assert ##
            assertFalse(memberList.isEmpty());
            Date first = memberList.get(0).getLatestLoginDatetime();
            Date last = memberList.get(memberList.size() - 1).getLatestLoginDatetime();
            assertTrue(last.before(first));
        }
    }

    // ===================================================================================
    //                                                                            Relation
    //                                                                            ========
    public void test_sepcify_derivedReferrer_orderBy_foreign() {
        // ## Arrange ##
        Date defaultLoginDate = DfTypeUtil.toDate("1000/01/01");
        MemberCB cb = new MemberCB();
        cb.specify().specifyMemberStatus().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
                subCB.query().setMobileLoginFlg_Equal_False();
            }
        }, Member.ALIAS_latestLoginDatetime, new DerivedReferrerOption().coalesce(defaultLoginDate));
        cb.query().addSpecifiedDerivedOrderBy_Asc(Member.ALIAS_latestLoginDatetime);

        // ## Act ##
        {
            ListResultBean<Member> memberList = memberBhv.selectList(cb);

            // ## Assert ##
            assertFalse(memberList.isEmpty());
            Date first = memberList.get(0).getLatestLoginDatetime();
            Date last = memberList.get(memberList.size() - 1).getLatestLoginDatetime();
            assertTrue(first.before(last));
        }

        // ## Arrange ##
        cb.clearOrderBy();
        cb.query().queryMemberStatus().addSpecifiedDerivedOrderBy_Desc(Member.ALIAS_latestLoginDatetime);

        // ## Act ##
        {
            ListResultBean<Member> memberList = memberBhv.selectList(cb);

            // ## Assert ##
            assertFalse(memberList.isEmpty());
            Date first = memberList.get(0).getLatestLoginDatetime();
            Date last = memberList.get(memberList.size() - 1).getLatestLoginDatetime();
            assertTrue(last.before(first));
        }
    }
}
