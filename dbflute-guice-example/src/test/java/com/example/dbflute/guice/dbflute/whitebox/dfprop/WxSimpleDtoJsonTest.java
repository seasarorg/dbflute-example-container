package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import junit.framework.AssertionFailedError;
import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONHint;

import org.joda.time.LocalDateTime;
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
import com.example.dbflute.guice.dbflute.nogen.JodaUtil;
import com.example.dbflute.guice.simpleflute.dto.MemberDto;
import com.example.dbflute.guice.simpleflute.dto.PurchaseDto;
import com.example.dbflute.guice.unit.UnitContainerTestCase;
import com.fasterxml.jackson.annotation.JsonFormat;

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
        assertFalse(backTo.getMemberStatus().isPresent());
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
            assertFalse(member.getMemberStatus().isPresent());
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
        cb.setupSelect_MemberAddressAsValid(currentLocalDate()).withRegion();
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
        assertTrue(backTo.getMemberWithdrawalAsOne().isPresent());
        assertTrue(backTo.getMemberWithdrawalAsOne().get().getWithdrawalReason().isPresent());
        assertTrue(backTo.getMemberAddressAsValid().isPresent());
        assertTrue(backTo.getMemberAddressAsValid().get().getRegion().isPresent());
    }

    // ===================================================================================
    //                                                                            Referrer
    //                                                                            ========
    public void test_JSON_referrer_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().existsPurchase(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
            }
        });
        cb.fetchFirst(1);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);
        memberBhv.loadPurchase(member, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
                cb.query().addOrderBy_PurchaseDatetime_Desc();
            }
        });
        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberDto memberDto = mapper.mappingToDto(member);
        assertFalse(memberDto.getPurchaseList().isEmpty());
        PurchaseDto firstPurchase = memberDto.getPurchaseList().get(0);
        Timestamp expectedTm = DfTypeUtil.toTimestamp("4321-12-16 12:34:56.789");
        firstPurchase.setPurchaseDatetime(LocalDateTime.fromDateFields(expectedTm));
        LocalDateTime purchaseDatetime = firstPurchase.getPurchaseDatetime();

        // ## Act ##
        String encoded = JSON.encode(memberDto, true);
        log(ln() + encoded);
        MemberDto decoded = JSON.decode(encoded, MemberDto.class);
        log(decoded);

        // ## Assert ##
        assertNotNull(decoded);
        assertFalse(decoded.getPurchaseList().isEmpty());
        // JSONIC does not support Joda-Time
        try {
            assertEquals(purchaseDatetime, decoded.getPurchaseList().get(0).getPurchaseDatetime());
            fail();
        } catch (AssertionFailedError e) {
            log(e.getMessage());
        }
        // JSONIC joda problem
        //Member backTo = mapper.mappingToEntity(decoded);
        //log(ln() + backTo.toStringWithRelation());
        //assertFalse(backTo.getMemberStatus().isPresent());
        //assertEquals(member.getMemberStatusCode(), backTo.getMemberStatusCode());
        //List<Purchase> purchaseList = backTo.getPurchaseList();
        //assertFalse(purchaseList.isEmpty());
        //assertEquals(purchaseDatetime, purchaseList.get(0).getPurchaseDatetime());
        //for (Purchase purchase : purchaseList) {
        //    log(purchase);
        //}
    }

    // ===================================================================================
    //                                                                          Decoration
    //                                                                          ==========
    public void test_JSONIC_decoration_Date_and_Timestamp() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(3);
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);

        String birthdateExp = "4321-12-16";
        Date birthdate = DfTypeUtil.toDate(birthdateExp);
        member.setBirthdate(JodaUtil.toLocalDate(birthdate));

        String formalizedExp = "5432-12-16 12:34:56.789";
        LocalDateTime formalized = LocalDateTime.fromDateFields(DfTypeUtil.toTimestamp(formalizedExp));
        member.setFormalizedDatetime(formalized);

        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberDto memberDto = mapper.mappingToDto(member);

        // ## Act ##
        String encoded = JSON.encode(memberDto, true);
        log(ln() + encoded);
        MemberDto decoded = JSON.decode(encoded, MemberDto.class);
        log(decoded);

        // ## Assert ##
        // JSONIC does not support Joda-Time
        try {
            assertTrue(encoded.contains(birthdateExp));
            fail();
        } catch (AssertionFailedError e) {
            log(e.getMessage());
        }
        // JSONIC joda problem
        //assertTrue(encoded.contains(formalizedExp));
        //assertNotNull(decoded);
        //assertEquals(birthdate, decoded.getBirthdate());
        //assertEquals(formalized, decoded.getFormalizedDatetime());
    }

    public void test_JSONIC_annotation() throws Exception {
        // ## Arrange ##
        Method method = MemberDto.class.getMethod("getBirthdate", (Class<?>[]) null);

        // ## Act ##
        JSONHint jsonFormat = method.getAnnotation(JSONHint.class);

        // ## Assert ##
        assertEquals("yyyy-MM-dd", jsonFormat.format());
    }

    public void test_Jackson_annotation() throws Exception {
        // ## Arrange ##
        Method method = MemberDto.class.getMethod("getBirthdate", (Class<?>[]) null);

        // ## Act ##
        JsonFormat jsonFormat = method.getAnnotation(JsonFormat.class);

        // ## Assert ##
        assertEquals("yyyy-MM-dd", jsonFormat.pattern());
    }
}
