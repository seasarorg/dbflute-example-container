package com.example.dbflute.spring.dbflute.whitebox.outsidesql;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.exception.DangerousResultSizeException;
import org.seasar.dbflute.exception.FetchingOverSafetySizeException;
import org.seasar.dbflute.exception.PagingOverSafetySizeException;

import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.PurchaseMaxPriceMemberPmb;
import com.example.dbflute.spring.dbflute.exbhv.pmbean.SimpleMemberPmb;
import com.example.dbflute.spring.dbflute.exentity.customize.PurchaseMaxPriceMember;
import com.example.dbflute.spring.dbflute.exentity.customize.SimpleMember;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 */
public class WxOutsideSqlCheckTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                       Safety Result
    //                                                                       =============
    public void test_selectList_safetyResult_dangerous() {
        // ## Arrange ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        pmb.checkSafetyResult(7);

        // ## Act ##
        try {
            memberBhv.outsideSql().selectList(pmb);

            // ## Assert ##
            fail();
        } catch (DangerousResultSizeException e) {
            // OK
            log(e.getMessage());
            assertEquals(7, e.getSafetyMaxResultSize());
            assertEquals(FetchingOverSafetySizeException.class, e.getCause().getClass());
        }
    }

    public void test_selectList_safetyResult_safety() {
        // ## Arrange ##
        SimpleMemberPmb pmb = new SimpleMemberPmb();
        int maxSize = memberBhv.outsideSql().selectList(pmb).size();
        pmb.checkSafetyResult(maxSize);

        // ## Act & Assert ##
        // Expect no exception
        ListResultBean<SimpleMember> memberList = memberBhv.outsideSql().selectList(pmb);
        assertEquals(maxSize, memberList.size());
    }

    public void test_selectPage_safetyResult_dangerous() {
        // ## Arrange ##
        PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();
        pmb.checkSafetyResult(5);
        pmb.paging(2, 1);

        // ## Act ##
        try {
            memberBhv.outsideSql().manualPaging().selectPage(pmb);

            // ## Assert ##
            fail();
        } catch (DangerousResultSizeException e) {
            // OK
            log(e.getMessage());
            assertEquals(5, e.getSafetyMaxResultSize());
            assertEquals(PagingOverSafetySizeException.class, e.getCause().getClass());
        }
    }

    public void test_selectPage_safetyResult_safety() {
        // ## Arrange ##
        String path = MemberBhv.PATH_selectPurchaseMaxPriceMember;
        PurchaseMaxPriceMemberPmb pmb = new PurchaseMaxPriceMemberPmb();
        pmb.paging(2, 1);
        Class<PurchaseMaxPriceMember> entityType = PurchaseMaxPriceMember.class;
        int maxSize = memberBhv.outsideSql().manualPaging().selectPage(path, pmb, entityType).getAllRecordCount();
        pmb.checkSafetyResult(maxSize);

        // ## Act && Assert ##
        // Expect no exception
        PagingResultBean<PurchaseMaxPriceMember> page = memberBhv.outsideSql().manualPaging()
                .selectPage(path, pmb, entityType);
        assertEquals(maxSize, page.getAllRecordCount());
    }
}
