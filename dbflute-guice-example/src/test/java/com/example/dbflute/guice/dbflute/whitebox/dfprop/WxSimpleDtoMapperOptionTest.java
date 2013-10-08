package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.cbean.PurchaseCB;
import com.example.dbflute.guice.dbflute.dtomapper.MemberDtoMapper;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.simpleflute.dto.MemberDto;
import com.example.dbflute.guice.simpleflute.dto.MemberSecurityDto;
import com.example.dbflute.guice.simpleflute.dto.MemberStatusDto;
import com.example.dbflute.guice.simpleflute.dto.ProductDto;
import com.example.dbflute.guice.simpleflute.dto.PurchaseDto;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.9.4B (2012/04/22 Sunday)
 */
public class WxSimpleDtoMapperOptionTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                    BaseOnly Mapping
    //                                                                    ================
    public void test_mappingToDtoList_baseOnly_basic_Tx() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        mapper.setBaseOnlyMapping(true);
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberSecurityAsOne();
        cb.setupSelect_MemberWithdrawalAsOne().withWithdrawalReason();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertListNotEmpty(memberList);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
                cb.setupSelect_Product();
            }
        });

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);

        // ## Assert ##
        for (MemberDto memberDto : dtoList) {
            log(memberDto);
            assertNull(memberDto.getMemberStatus());
            assertNull(memberDto.getMemberSecurityAsOne());
            assertNull(memberDto.getMemberWithdrawalAsOne());
            assertListEmpty(memberDto.getPurchaseList());
        }
    }

    public void test_mappingToDtoList_baseOnly_false_nothing_Tx() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        mapper.setBaseOnlyMapping(false);
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberSecurityAsOne();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertListNotEmpty(memberList);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
                cb.setupSelect_Product();
            }
        });

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);

        // ## Assert ##
        boolean existsPurchase = false;
        for (MemberDto memberDto : dtoList) {
            log(memberDto);
            assertNotNull(memberDto.getMemberStatus());
            assertNotNull(memberDto.getMemberSecurityAsOne());
            if (!memberDto.getPurchaseList().isEmpty()) {
                existsPurchase = true;
            }
        }
        assertTrue(existsPurchase);
    }

    // ===================================================================================
    //                                                                   Reverse Reference
    //                                                                   =================
    public void test_mappingToDtoList_reverse_basic_Tx() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        mapper.setReverseReference(true);
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberSecurityAsOne();
        cb.setupSelect_MemberWithdrawalAsOne().withWithdrawalReason();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertListNotEmpty(memberList);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
                cb.setupSelect_Product();
            }
        });

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);

        // ## Assert ##
        Set<MemberStatusDto> statusSet = new HashSet<MemberStatusDto>();
        boolean existsPurchase = false;
        for (MemberDto memberDto : dtoList) {
            log(memberDto);
            statusSet.add(memberDto.getMemberStatus());
            MemberSecurityDto securityDto = memberDto.getMemberSecurityAsOne();
            assertEquals(memberDto, securityDto.getMember());
            List<PurchaseDto> purchaseList = memberDto.getPurchaseList();
            for (PurchaseDto purchaseDto : purchaseList) {
                existsPurchase = true;
                assertEquals(memberDto, purchaseDto.getMember());
                ProductDto productDto = purchaseDto.getProduct();
                assertListNotEmpty(productDto.getPurchaseList());
                assertTrue(productDto.getPurchaseList().contains(purchaseDto));
            }
        }
        assertTrue(existsPurchase);
        log("[Reverse]");
        for (MemberStatusDto statusDto : statusSet) {
            log(statusDto.getMemberStatusName());
            List<MemberDto> reverseList = statusDto.getMemberList();
            assertNotSame(0, reverseList.size());
            for (MemberDto memberDto : reverseList) {
                log("  " + memberDto);
            }
        }
    }
}
