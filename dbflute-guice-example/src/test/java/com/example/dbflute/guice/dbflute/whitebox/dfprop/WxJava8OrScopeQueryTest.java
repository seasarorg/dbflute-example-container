package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.exception.OrderByIllegalPurposeException;
import org.seasar.dbflute.exception.SetupSelectIllegalPurposeException;
import org.seasar.dbflute.exception.SpecifyIllegalPurposeException;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.5G (2014/05/27 Tuesday)
 */
public class WxJava8OrScopeQueryTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;

    public void test_orScopeQuery_normalUse() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.orScopeQuery(new OrQuery<MemberCB>() {
            public void query(MemberCB orCB) {
                orCB.query().setMemberName_PrefixSearch("S");
                orCB.query().setMemberStatusCode_Equal_Formalized();
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

    public void test_orScopeQuery_illegalPurpose() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();

        try {
            // ## Act ##
            cb.orScopeQuery(new OrQuery<MemberCB>() {
                public void query(MemberCB orCB) {
                    orCB.setupSelect_MemberStatus();
                }
            });
            // ## Assert ##
            fail();
        } catch (SetupSelectIllegalPurposeException e) {
            log(e.getMessage());
        }
        try {
            // ## Act ##
            cb.orScopeQuery(new OrQuery<MemberCB>() {
                public void query(MemberCB orCB) {
                    orCB.specify();
                }
            });
            // ## Assert ##
            fail();
        } catch (SpecifyIllegalPurposeException e) {
            log(e.getMessage());
        }
        try {
            // ## Act ##
            cb.orScopeQuery(new OrQuery<MemberCB>() {
                public void query(MemberCB orCB) {
                    orCB.query().addOrderBy_Birthdate_Asc();
                }
            });
            // ## Assert ##
            fail();
        } catch (OrderByIllegalPurposeException e) {
            log(e.getMessage());
        }
    }
}
