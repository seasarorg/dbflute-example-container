package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.optional.OptionalEntity;

import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.cbean.PurchaseCB;
import com.example.dbflute.guice.dbflute.dtomapper.MemberDtoMapper;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.dbflute.exentity.MemberSecurity;
import com.example.dbflute.guice.dbflute.exentity.MemberStatus;
import com.example.dbflute.guice.dbflute.exentity.MemberWithdrawal;
import com.example.dbflute.guice.dbflute.exentity.Purchase;
import com.example.dbflute.guice.simpleflute.dto.MemberDto;
import com.example.dbflute.guice.simpleflute.dto.MemberSecurityDto;
import com.example.dbflute.guice.simpleflute.dto.MemberStatusDto;
import com.example.dbflute.guice.simpleflute.dto.MemberWithdrawalDto;
import com.example.dbflute.guice.simpleflute.dto.PurchaseDto;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.7.7 (2010/12/06 Tuesday)
 */
public class WxSimpleDtoMapperBasicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                      Mapping to DTO
    //                                                                      ==============
    // -----------------------------------------------------
    //                                               One DTO
    //                                               -------
    public void test_mappingToDto_basic() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberCB cb = new MemberCB();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        assertNotSame(0, memberList.size());
        for (Member member : memberList) {

            // ## Act ##
            MemberDto dto = mapper.mappingToDto(member);

            // ## Assert ##
            log(dto);
            assertEqualsMember(member, dto);
            assertNull(dto.getMemberStatus());
        }
    }

    public void test_mappingToDto_ManyToOne() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        assertNotSame(0, memberList.size());
        for (Member member : memberList) {
            // ## Act ##
            MemberDto dto = mapper.mappingToDto(member);

            // ## Assert ##
            MemberStatusDto memberStatus = dto.getMemberStatus();
            log(dto.getMemberId() + ", " + memberStatus);
            assertEqualsMember(member, dto);
            assertNotNull(memberStatus);
        }
    }

    public void test_mappingToDto_OneToMany() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadPurchase(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB cb) {
            }
        });
        assertNotSame(0, memberList.size());

        boolean exists = false;
        for (Member member : memberList) {

            // ## Act ##
            MemberDto dto = mapper.mappingToDto(member);

            // ## Assert ##
            log(dto.getMemberId() + ", " + dto.getPurchaseList().size());
            assertEqualsMember(member, dto);
            if (dto.getPurchaseList().isEmpty()) {
                exists = true;
            }
        }
        assertTrue(exists);
    }

    public void test_mappingToDto_null() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();

        // ## Act ##
        MemberDto dto = mapper.mappingToDto(null);

        // ## Assert ##
        log(dto);
        assertNull(dto);
    }

    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    public void test_mappingToDtoList_basic() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        final MemberCB cb = new MemberCB();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertNotSame(0, memberList.size());

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);

        // ## Assert ##
        int index = 0;
        for (MemberDto memberDto : dtoList) {
            log(memberDto);
            assertEqualsMember(memberList.get(index), memberDto);
            assertNull(memberDto.getMemberStatus());
            ++index;
        }
    }

    public void test_mappingToDtoList_relation() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertNotSame(0, memberList.size());

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);

        // ## Assert ##
        Set<MemberStatusDto> statusSet = new HashSet<MemberStatusDto>();
        int index = 0;
        for (MemberDto memberDto : dtoList) {
            log(memberDto);
            assertEqualsMember(memberList.get(index), memberDto);
            statusSet.add(memberDto.getMemberStatus());
            ++index;
        }
        for (MemberStatusDto statusDto : statusSet) {
            assertEquals(0, statusDto.getMemberList().size()); // as defaut
        }
    }

    public void test_mappingToDtoList_noPK() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberSecurityAsOne();
        cb.setupSelect_MemberWithdrawalAsOne();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertNotSame(0, memberList.size());
        for (Member member : memberList) {
            member.setMemberId(null);
            member.getMemberStatus().get().setMemberStatusCodeAsMemberStatus(null);
            member.getMemberSecurityAsOne().get().setMemberId(null);
            if (member.getMemberWithdrawalAsOne().isPresent()) {
                member.getMemberWithdrawalAsOne().get().setMemberId(null);
            }
        }

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);

        // ## Assert ##
        int index = 0;
        for (MemberDto memberDto : dtoList) {
            log(memberDto);
            Member member = memberList.get(index);
            assertEqualsMember(member, memberDto);
            assertEquals(member.getMemberName(), memberDto.getMemberName());
            MemberStatusDto statusDto = memberDto.getMemberStatus();
            assertNull(statusDto.getMemberStatusCode());
            assertEquals(member.getMemberStatus().get().getMemberStatusName(), statusDto.getMemberStatusName());
            MemberSecurityDto securityDto = memberDto.getMemberSecurityAsOne();
            assertNull(securityDto.getMemberId());
            assertEquals(member.getMemberSecurityAsOne().get().getReminderQuestion(), securityDto.getReminderQuestion());
            MemberWithdrawalDto withdrawalDto = memberDto.getMemberWithdrawalAsOne();
            if (member.isMemberStatusCodeWithdrawal()) {
                assertNull(withdrawalDto.getMemberId());
                assertEquals(member.getMemberWithdrawalAsOne().get().getWithdrawalReasonInputText(),
                        withdrawalDto.getWithdrawalReasonInputText());
            } else {
                assertNull(withdrawalDto);
            }
            ++index;
        }
    }

    public void test_mappingToDtoList_nullElement_basic() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        List<Member> entityList = new ArrayList<Member>();
        entityList.add(new Member());
        entityList.add(null);
        entityList.add(new Member());

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(entityList);

        // ## Assert ##
        assertEquals(3, dtoList.size());
        assertNotNull(dtoList.get(0));
        assertNull(dtoList.get(1));
        assertNotNull(dtoList.get(2));
    }

    public void test_mappingToDtoList_nullElement_ignore() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper() {
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean isAcceptNullElementOnList() {
                return false;
            }
        };
        List<Member> entityList = new ArrayList<Member>();
        entityList.add(new Member());
        entityList.add(null);
        entityList.add(new Member());

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(entityList);

        // ## Assert ##
        assertEquals(2, dtoList.size());
        assertNotNull(dtoList.get(0));
        assertNotNull(dtoList.get(1));
    }

    public void test_mappingToDtoList_null() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();

        // ## Act ##
        try {
            mapper.mappingToDtoList(null);

            // ## Assert ##
            fail();
        } catch (IllegalArgumentException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                   Mapping to Entity
    //                                                                   =================
    // -----------------------------------------------------
    //                                            One Entity
    //                                            ----------
    public void test_mappingToEntity_modified_basic() throws Exception {
        // ## Arrange ##
        MemberDto dto = new MemberDto();
        dto.setMemberId(3);
        dto.setBirthdate(null);

        // ## Act ##
        Member entity = new MemberDtoMapper().mappingToEntity(dto);

        // ## Assert ##
        assertEquals(dto.modifiedProperties().size(), entity.modifiedProperties().size());
        assertTrue(dto.modifiedProperties().contains("memberId"));
        assertTrue(entity.modifiedProperties().contains("memberId"));
        assertTrue(dto.modifiedProperties().contains("birthdate"));
        assertTrue(entity.modifiedProperties().contains("birthdate"));
        assertFalse(dto.modifiedProperties().contains("memberName"));
        assertFalse(entity.modifiedProperties().contains("memberName"));
        assertEquals(Integer.valueOf(3), entity.getMemberId());
        assertNull(entity.getBirthdate());
        assertNull(entity.getMemberName());

        assertTrue(entity.hasModification());
        entity.clearModifiedInfo();
        assertFalse(entity.hasModification());

        assertTrue(dto.hasModification());
        dto.clearModifiedInfo();
        assertFalse(dto.hasModification());
    }

    public void test_mappingToEntity_modified_default() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        final MemberCB cb = new MemberCB();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertNotSame(0, memberList.size());
        List<MemberDto> dtoList = new MemberDtoMapper().mappingToDtoList(memberList);
        for (MemberDto dto : dtoList) {
            dto.clearModifiedInfo();
        }

        boolean exists = false;
        for (MemberDto dto : dtoList) {
            // ## Act ##
            Member entity = mapper.mappingToEntity(dto);

            // ## Assert ##
            Set<String> propertyNames = entity.modifiedProperties();
            assertEquals(entity.getDBMeta().getColumnInfoList().size(), propertyNames.size());
            if (entity.getBirthdate() == null) {
                assertTrue(propertyNames.contains("birthdate"));
                exists = true;
            } else {
                assertTrue(propertyNames.contains("birthdate"));
            }
        }
        assertTrue(exists);
    }

    public void test_mappingToEntity_modified_notNull() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper() {
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean isMappingToEntityContainsNull() {
                return false;
            };
        };
        final MemberCB cb = new MemberCB();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertNotSame(0, memberList.size());
        List<MemberDto> dtoList = new MemberDtoMapper().mappingToDtoList(memberList);
        for (MemberDto dto : dtoList) {
            dto.clearModifiedInfo();
        }

        boolean exists = false;
        for (MemberDto dto : dtoList) {
            // ## Act ##
            Member entity = mapper.mappingToEntity(dto);

            // ## Assert ##
            Set<String> propertyNames = entity.modifiedProperties();
            if (entity.getBirthdate() == null) {
                assertFalse(propertyNames.contains("birthdate"));
                assertNotSame(entity.getDBMeta().getColumnInfoList().size(), propertyNames.size());
                exists = true;
            } else {
                assertTrue(propertyNames.contains("birthdate"));
            }
        }
        assertTrue(exists);
    }

    public void test_mappingToEntity_null() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();

        // ## Act ##
        Member entity = mapper.mappingToEntity(null);

        // ## Assert ##
        log(entity);
        assertNull(entity);
    }

    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    public void test_mappingToEntityList_basic() throws Exception {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertNotSame(0, memberList.size());
        List<MemberDto> dtoList = new MemberDtoMapper().mappingToDtoList(memberList);

        // ## Act ##
        List<Member> entityList = new MemberDtoMapper().mappingToEntityList(dtoList);

        // ## Assert ##
        assertNotSame(0, entityList.size());
        int index = 0;
        for (Member member : entityList) {
            assertEqualsMember(member, dtoList.get(index));
            ++index;
        }
    }

    public void test_mappingToEntityList_relation() throws Exception {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertNotSame(0, memberList.size());
        List<MemberDto> dtoList = new MemberDtoMapper().mappingToDtoList(memberList);

        // ## Act ##
        List<Member> entityList = new MemberDtoMapper().mappingToEntityList(dtoList);

        // ## Assert ##
        assertNotSame(0, entityList.size());
        boolean existsFormalized = false;
        MemberStatus preFormalizedStatus = null;
        int index = 0;
        for (Member member : entityList) {
            log(member);
            assertEqualsMember(member, dtoList.get(index));
            MemberStatus status = member.getMemberStatus().get();
            if (member.isMemberStatusCodeFormalized()) {
                if (preFormalizedStatus != null) {
                    existsFormalized = true;
                    assertTrue("should be the same instance", preFormalizedStatus == status);
                } else {
                    preFormalizedStatus = status;
                }
            }
            ++index;
        }
        assertTrue(existsFormalized);
    }

    public void test_mappingToEntityList_noPK() throws Exception {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberSecurityAsOne();
        cb.setupSelect_MemberWithdrawalAsOne();
        final ListResultBean<Member> memberList = memberBhv.selectList(cb);
        assertNotSame(0, memberList.size());
        List<MemberDto> dtoList = new MemberDtoMapper().mappingToDtoList(memberList);
        for (MemberDto memberDto : dtoList) {
            memberDto.setMemberId(null);
            memberDto.getMemberStatus().setMemberStatusCode(null);
            memberDto.getMemberSecurityAsOne().setMemberId(null);
            if (memberDto.getMemberWithdrawalAsOne() != null) {
                memberDto.getMemberWithdrawalAsOne().setMemberId(null);
            }
        }

        // ## Act ##
        List<Member> entityList = new MemberDtoMapper().mappingToEntityList(dtoList);

        // ## Assert ##
        assertNotSame(0, entityList.size());
        int index = 0;
        for (Member member : entityList) {
            MemberDto memberDto = dtoList.get(index);
            assertEqualsMember(member, memberDto);
            assertEquals(member.getMemberName(), memberDto.getMemberName());
            MemberStatus status = member.getMemberStatus().get();
            assertNull(status.getMemberStatusCode());
            assertEquals(status.getMemberStatusName(), status.getMemberStatusName());
            MemberSecurity security = member.getMemberSecurityAsOne().get();
            assertNull(security.getMemberId());
            assertEquals(security.getReminderQuestion(), security.getReminderQuestion());
            OptionalEntity<MemberWithdrawal> optWithdrawal = member.getMemberWithdrawalAsOne();
            if (member.isMemberStatusCodeWithdrawal()) {
                MemberWithdrawal withdrawal = optWithdrawal.get();
                assertNull(withdrawal.getMemberId());
                assertEquals(withdrawal.getWithdrawalReasonInputText(), withdrawal.getWithdrawalReasonInputText());
            } else {
                assertFalse(optWithdrawal.isPresent());
            }
            ++index;
        }
    }

    public void test_mappingToEntityList_nullElement_basic() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        List<MemberDto> dtoList = new ArrayList<MemberDto>();
        dtoList.add(new MemberDto());
        dtoList.add(null);
        dtoList.add(new MemberDto());

        // ## Act ##
        List<Member> entityList = mapper.mappingToEntityList(dtoList);

        // ## Assert ##
        assertEquals(3, entityList.size());
        assertNotNull(entityList.get(0));
        assertNull(entityList.get(1));
        assertNotNull(entityList.get(2));
    }

    public void test_mappingToEntityList_nullElement_ignore() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper() {
            private static final long serialVersionUID = 1L;

            @Override
            protected boolean isAcceptNullElementOnList() {
                return false;
            }
        };
        List<MemberDto> dtoList = new ArrayList<MemberDto>();
        dtoList.add(new MemberDto());
        dtoList.add(null);
        dtoList.add(new MemberDto());

        // ## Act ##
        List<Member> entityList = mapper.mappingToEntityList(dtoList);

        // ## Assert ##
        assertEquals(2, entityList.size());
        assertNotNull(entityList.get(0));
        assertNotNull(entityList.get(1));
    }

    public void test_mappingToEntityList_nullList() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();

        // ## Act ##
        try {
            mapper.mappingToEntityList(null);

            // ## Assert ##
            fail();
        } catch (IllegalArgumentException e) {
            // OK
            log(e.getMessage());
        }
    }

    // ===================================================================================
    //                                                                       Assert Helper
    //                                                                       =============
    protected void assertEqualsMember(Member member, MemberDto dto) {
        assertEquals(member.getMemberId(), dto.getMemberId());
        assertEquals(member.getMemberName(), dto.getMemberName());
        assertEquals(member.getMemberAccount(), dto.getMemberAccount());
        assertEquals(member.getBirthdate(), dto.getBirthdate());
        assertEquals(member.getFormalizedDatetime(), dto.getFormalizedDatetime());
        assertEquals(member.getRegisterDatetime(), dto.getRegisterDatetime());
        assertEquals(member.getUpdateDatetime(), dto.getUpdateDatetime());

        doAssertEqualsMemberStatus(member, dto);
        doAssertEqualsPurchaseList(member, dto);
    }

    protected void doAssertEqualsMemberStatus(Member member, MemberDto dto) {
        OptionalEntity<MemberStatus> optStatus = member.getMemberStatus();
        MemberStatusDto parentDto = dto.getMemberStatus();
        if (optStatus.isPresent()) {
            assertNotNull(parentDto);
            assertEquals(optStatus.get().getMemberStatusName(), parentDto.getMemberStatusName());
        } else {
            assertNull(parentDto);
        }
    }

    protected void doAssertEqualsPurchaseList(Member member, MemberDto dto) {
        List<Purchase> purchaseList = member.getPurchaseList();
        List<PurchaseDto> dtoList = dto.getPurchaseList();
        if (purchaseList.isEmpty()) {
            assertTrue(dtoList.isEmpty());
        } else {
            assertFalse(dtoList.isEmpty());
            int index = 0;
            for (PurchaseDto purchaseDto : dtoList) {
                Purchase purchase = purchaseList.get(index);
                assertEquals(purchase.getPurchaseDatetime(), purchaseDto.getPurchaseDatetime());
                ++index;
            }
        }
    }
}
