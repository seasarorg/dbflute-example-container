package com.example.dbflute.spring.dbflute.whitebox.bhv;

import java.util.List;

import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.pagenavi.PageNumberLink;
import org.seasar.dbflute.cbean.pagenavi.PageNumberLinkSetupper;

import com.example.dbflute.spring.dbflute.cbean.MemberCB;
import com.example.dbflute.spring.dbflute.exbhv.MemberBhv;
import com.example.dbflute.spring.dbflute.exentity.Member;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.0.0 (2012/10/16 Tuesday)
 */
public class WxBhvPagingResultBeanTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_paging_noData() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_Equal("no exist");
        cb.query().addOrderBy_MemberName_Asc();
        cb.paging(4, 1);

        // ## Act ##
        PagingResultBean<Member> page = memberBhv.selectPage(cb);

        // ## Assert ##
        assertHasZeroElement(page);
        page.setPageRangeSize(2);
        List<PageNumberLink> linkList = page.pageRange().buildPageNumberLinkList(
                new PageNumberLinkSetupper<PageNumberLink>() {
                    public PageNumberLink setup(int pageNumberElement, boolean current) {
                        return new PageNumberLink().initialize(pageNumberElement, current, "...");
                    }
                });
        assertHasOnlyOneElement(linkList);
        PageNumberLink numberLink = linkList.get(0);
        log(numberLink);
        assertEquals(1, numberLink.getPageNumberElement());
        assertTrue(numberLink.isCurrent());
    }
}
