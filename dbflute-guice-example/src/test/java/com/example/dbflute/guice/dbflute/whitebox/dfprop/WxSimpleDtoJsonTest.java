package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import net.arnx.jsonic.JSON;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.util.DfTypeUtil;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.cbean.PurchaseCB;
import com.example.dbflute.guice.dbflute.dtomapper.MemberDtoMapper;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.dbflute.exentity.Purchase;
import com.example.dbflute.guice.simpleflute.dto.MemberDto;
import com.example.dbflute.guice.simpleflute.dto.PurchaseDto;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.6.1 (2009/11/17 Tuesday)
 */
public class WxSimpleDtoJsonTest extends UnitContainerTestCase {

    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                               Basic
    //                                                                               =====
    public void test_JSON_entity() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);
        String memberStatusCode = member.getMemberStatusCode();
        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberDto memberDto = mapper.mappingToDto(member);

        // ## Act ##
        String encoded = JSON.encode(memberDto, true);
        log(ln() + encoded);
        MemberDto decoded = JSON.decode(encoded, MemberDto.class);
        log(decoded);

        // ## Assert ##
        assertNotNull(decoded);
        assertEquals(Integer.valueOf(3), decoded.getMemberId());
        assertNull(decoded.getMemberStatus());

        // omake
        Member backTo = mapper.mappingToEntity(decoded);
        log(backTo);
        assertEquals(Integer.valueOf(3), backTo.getMemberId());
        assertEquals(memberStatusCode, backTo.getMemberStatusCode());
        assertNull(backTo.getMemberStatus());
    }

    public void test_JSON_list() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_PrefixSearch("S");
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        MemberDtoMapper mapper = new MemberDtoMapper();
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);

        // ## Act ##
        String encoded = JSON.encode(dtoList, true);
        log(ln() + encoded);
        MemberDto[] decodedAry = JSON.decode(encoded, MemberDto[].class);

        // ## Assert ##
        assertNotNull(decodedAry);
        List<MemberDto> decodedList = DfCollectionUtil.newArrayList(decodedAry);
        assertFalse(decodedList.isEmpty());
        for (MemberDto memberDto : decodedList) {
            log(memberDto);
            assertTrue(memberDto.getMemberName().startsWith("S"));
            assertNull(memberDto.getMemberStatus());
        }

        // omake
        List<Member> backToList = mapper.mappingToEntityList(decodedList);
        assertFalse(backToList.isEmpty());
        for (Member member : backToList) {
            assertTrue(member.getMemberName().startsWith("S"));
            assertNull(member.getMemberStatus());
        }
    }

    // ===================================================================================
    //                                                                        ForeignTable
    //                                                                        ============
    public void test_JSON_foreignTable_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().setMemberId_Equal(3);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);
        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberDto memberDto = mapper.mappingToDto(member);

        // ## Act ##
        String encoded = JSON.encode(memberDto, true);
        log(ln() + encoded);
        MemberDto decoded = JSON.decode(encoded, MemberDto.class);
        log(decoded);

        // ## Assert ##
        assertNotNull(decoded);
        assertNotNull(decoded.getMemberStatus());
        assertEquals(member.getMemberStatusCode(), decoded.getMemberStatusCode());
    }

    public void test_JSON_foreignTable_many() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberWithdrawalAsOne().withWithdrawalReason();
        cb.setupSelect_MemberAddressAsValid(currentDate()).withRegion();
        cb.query().setMemberStatusCode_Equal_Withdrawal();
        cb.query().queryMemberWithdrawalAsOne().setWithdrawalReasonCode_IsNotNull();
        cb.fetchFirst(1);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);
        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberDto memberDto = mapper.mappingToDto(member);

        // ## Act ##
        String encoded = JSON.encode(memberDto, true);
        log(ln() + encoded);
        MemberDto decoded = JSON.decode(encoded, MemberDto.class);
        log(decoded);

        // ## Assert ##
        assertNotNull(decoded);
        Member backTo = mapper.mappingToEntity(decoded);
        log(ln() + backTo.toStringWithRelation());
        assertNotNull(backTo.getMemberStatus());
        assertEquals(member.getMemberStatusCode(), backTo.getMemberStatusCode());
        assertNotNull(backTo.getMemberWithdrawalAsOne());
        assertNotNull(backTo.getMemberWithdrawalAsOne().getWithdrawalReason());
        assertNotNull(backTo.getMemberAddressAsValid());
        assertNotNull(backTo.getMemberAddressAsValid().getRegion());
    }

    // ===================================================================================
    //                                                                            Referrer
    //                                                                            ========
    public void test_JSON_referrer_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
            }
        });
        cb.fetchFirst(1);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);
        memberBhv.loadPurchaseList(member, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
                cb.query().addOrderBy_PurchaseDatetime_Desc();
            }
        });
        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberDto memberDto = mapper.mappingToDto(member);
        assertFalse(memberDto.getPurchaseList().isEmpty());
        PurchaseDto firstPurchase = memberDto.getPurchaseList().get(0);
        firstPurchase.setPurchaseDatetime(DfTypeUtil.toTimestamp("4321-12-16 12:34:56.789"));
        Timestamp purchaseDatetime = firstPurchase.getPurchaseDatetime();
        assertNotNull(purchaseDatetime);

        // ## Act ##
        String encoded = JSON.encode(memberDto, true);
        log(ln() + encoded);
        MemberDto decoded = JSON.decode(encoded, MemberDto.class);
        log(decoded);

        // ## Assert ##
        assertNotNull(decoded);
        assertFalse(decoded.getPurchaseList().isEmpty());
        assertEquals(purchaseDatetime, decoded.getPurchaseList().get(0).getPurchaseDatetime());
        Member backTo = mapper.mappingToEntity(decoded);
        log(ln() + backTo.toStringWithRelation());
        assertNull(backTo.getMemberStatus());
        assertEquals(member.getMemberStatusCode(), backTo.getMemberStatusCode());
        List<Purchase> purchaseList = backTo.getPurchaseList();
        assertFalse(purchaseList.isEmpty());
        assertEquals(purchaseDatetime, purchaseList.get(0).getPurchaseDatetime());
        for (Purchase purchase : purchaseList) {
            log(purchase);
        }
    }

    // ===================================================================================
    //                                                                          Decoration
    //                                                                          ==========
    public void test_JSON_decoration_Date_and_Timestamp() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);

        String birthdateExp = "4321-12-16";
        Date birthdate = DfTypeUtil.toDate(birthdateExp);
        member.setBirthdate(birthdate);

        String formalizedExp = "5432-12-16 12:34:56.789";
        Timestamp formalized = DfTypeUtil.toTimestamp(formalizedExp);
        member.setFormalizedDatetime(formalized);

        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberDto memberDto = mapper.mappingToDto(member);

        // ## Act ##
        String encoded = JSON.encode(memberDto, true);
        log(ln() + encoded);
        MemberDto decoded = JSON.decode(encoded, MemberDto.class);
        log(decoded);

        // ## Assert ##
        assertTrue(encoded.contains(birthdateExp));
        assertTrue(encoded.contains(formalizedExp));
        assertNotNull(decoded);
        assertEquals(birthdate, decoded.getBirthdate());
        assertEquals(formalized, decoded.getFormalizedDatetime());
    }
}
