package com.example.dbflute.spring.dbflute.whitebox.outsidesql;

import java.util.List;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.util.DfCollectionUtil;

import com.example.dbflute.spring.dbflute.allcommon.CDef;
import com.example.dbflute.spring.dbflute.allcommon.CDef.MemberStatus;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.MemberNamePmb;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.ParameterAutoDetectPmb;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.PurchaseMaxPriceMemberPmb;
import com.example.dbflute.spring.dbflute.exentity.customize.PurchaseMaxPriceMember;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.8.0 (2011/01/30 Sunday)
 */
public class WxSql2EntityParameterBeanGenerationTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                           CDef List
    //                                                                           =========
    public void test_pmb_CDefList() {
        // ## Arrange ##
        PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();
        final List<MemberStatus> clsList = DfCollectionUtil.newArrayList(CDef.MemberStatus.Formalized,
                CDef.MemberStatus.Withdrawal);
        pmb.setMemberStatusCodeList(clsList);

        // ## Act ##
        pmb.paging(100, 1);
        PagingResultBean<PurchaseMaxPriceMember> page1 = memberBhv.outsideSql().manualPaging().selectPage(pmb);

        // ## Assert ##
        assertNotSame(0, page1.size());
        boolean existsFormalized = false;
        boolean existsWithdrawal = false;
        for (PurchaseMaxPriceMember member : page1) {
            String memberStatusName = member.getMemberStatusName();
            log(member.getMemberName() + ", " + memberStatusName);
            if (memberStatusName.equals(CDef.MemberStatus.Formalized.alias())) {
                existsFormalized = true;
            } else if (memberStatusName.equals(CDef.MemberStatus.Withdrawal.alias())) {
                existsWithdrawal = true;
            } else {
                fail("unknown = " + memberStatusName);
            }
        }
        assertTrue(existsFormalized);
        assertTrue(existsWithdrawal);
    }

    // ===================================================================================
    //                                                                          AutoDetect
    //                                                                          ==========
    @SuppressWarnings("unused")
    public void test_pmb_AutoDetect_property_basic() {
        // ## Arrange ##
        ParameterAutoDetectPmb pmb = new ParameterAutoDetectPmb();

        // ## Act & Assert ##
        String overriddenFromDate = pmb.getOverriddenFromDate();
        List<Integer> integerList = pmb.getIntegerList();
        List<MemberStatus> cdefList = pmb.getCdefList();
        List<MemberStatus> memberStatusCodeList = pmb.getMemberStatusCodeList();
        
        // LikeSearch
        pmb.setPrefixSearchOption_PrefixSearch("S");
        pmb.setSuffixSearchOption_SuffixSearch("S");
        pmb.setContainSearchOption_ContainSearch("S");

        // IF comment
        pmb.getIfCommentAndFirst();
        pmb.getIfCommentAndSecond();
        pmb.getIfCommentAndThird();
        pmb.getIfCommentOnly();

        // FOR comment
        pmb.getForCommentBasic();
        pmb.getForCommentBasicInternalLikeSearchOption();
        pmb.getNestedForList();
        pmb.getBindInIfCommentForList();
    }

    public void test_pmb_AutoDetect_alternamteBooleanMethod_basic() {
        // ## Arrange ##
        MemberNamePmb pmbAll = new MemberNamePmb();
        MemberNamePmb pmbBirth = new MemberNamePmb();
        pmbBirth.requireBirthdate();

        // ## Act ##
        ListResultBean<String> nameAllList = memberBhv.outsideSql().selectList(pmbAll);
        ListResultBean<String> nameBirthList = memberBhv.outsideSql().selectList(pmbBirth);

        // ## Assert ##
        assertTrue(nameAllList.size() > nameBirthList.size());
    }
}
