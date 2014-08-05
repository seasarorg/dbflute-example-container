package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.joda.time.LocalDateTime;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;

import com.example.dbflute.guice.dbflute.cbean.MemberAddressCB;
import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.guice.dbflute.cbean.PurchaseCB;
import com.example.dbflute.guice.dbflute.dtomapper.MemberDtoMapper;
import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exentity.Member;
import com.example.dbflute.guice.dbflute.exentity.MemberStatus;
import com.example.dbflute.guice.simpleflute.dto.MemberAddressDto;
import com.example.dbflute.guice.simpleflute.dto.MemberDto;
import com.example.dbflute.guice.simpleflute.dto.MemberStatusDto;
import com.example.dbflute.guice.simpleflute.dto.RegionDto;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.9.4B (2012/04/22 Sunday)
 */
public class WxSimpleDtoMapperDetailTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private MemberBhv memberBhv;

    // ===================================================================================
    //                                                                      Mapping to DTO
    //                                                                      ==============
    public void test_mappingToDtoList_DerivedReferrer_basic() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
            }
        }, Member.PROP_latestLoginDatetime);
        cb.specify().derivedPurchaseList().countDistinct(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnProductId();
            }
        }, Member.PROP_productKindCount);
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);
        assertHasAnyElement(dtoList);
        for (MemberDto dto : dtoList) {
            // ## Assert ##
            LocalDateTime loginDatetime = dto.getLatestLoginDatetime();
            Integer loginCount = dto.getLoginCount();
            Integer productKindCount = dto.getProductKindCount();
            if (loginDatetime != null) {
                markHere("loginDatetime");
            }
            assertNull(loginCount);
            if (productKindCount != null) {
                markHere("productKindCount");
            }
            log(dto.getMemberName(), loginDatetime, loginCount, productKindCount);
            assertNull(dto.getMemberStatus());
        }
        assertMarked("loginDatetime");
        assertMarked("productKindCount");
    }

    // ===================================================================================
    //                                                                   Mapping to Entity
    //                                                                   =================
    public void test_mappingToEntityList_DerivedReferrer_basic() throws Exception {
        // ## Arrange ##
        MemberDtoMapper mapper = new MemberDtoMapper();
        List<MemberDto> dtoList;
        {
            MemberCB cb = new MemberCB();
            cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
                public void query(MemberLoginCB subCB) {
                    subCB.specify().columnLoginDatetime();
                }
            }, Member.PROP_latestLoginDatetime);
            cb.specify().derivedPurchaseList().countDistinct(new SubQuery<PurchaseCB>() {
                public void query(PurchaseCB subCB) {
                    subCB.specify().columnProductId();
                }
            }, Member.PROP_productKindCount);
            ListResultBean<Member> memberList = memberBhv.selectList(cb);
            dtoList = mapper.mappingToDtoList(memberList);
        }

        // ## Act ##
        List<Member> memberList = mapper.mappingToEntityList(dtoList);
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            // ## Assert ##
            LocalDateTime loginDatetime = member.getLatestLoginDatetime();
            Integer loginCount = member.getLoginCount();
            Integer productKindCount = member.getProductKindCount();
            if (loginDatetime != null) {
                markHere("loginDatetime");
            }
            assertNull(loginCount);
            if (productKindCount != null) {
                markHere("productKindCount");
            }
            log(member.getMemberName(), loginDatetime, loginCount, productKindCount);
            assertFalse(member.getMemberStatus().isPresent());
        }
        assertMarked("loginDatetime");
        assertMarked("productKindCount");
    }

    // ===================================================================================
    //                                                                      Instance Cache
    //                                                                      ==============
    public void test_mappingToDtoList_instanceCache_basic_Tx() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberAddressAsValid(currentLocalDate());
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadMemberAddressList(memberList, new ConditionBeanSetupper<MemberAddressCB>() {
            public void setup(MemberAddressCB cb) {
                cb.setupSelect_Region();
            }
        });
        {
            StringBuilder sb = new StringBuilder();
            Set<String> statusCodeSet = new HashSet<String>();
            Set<Integer> statusHashSet = new HashSet<Integer>();
            for (Member member : memberList) {
                MemberStatus status = member.getMemberStatus().get();
                sb.append(ln()).append(" ").append(member.getMemberName());
                sb.append(", status=").append(status.getMemberStatusName());
                sb.append("@").append(Integer.toHexString(status.instanceHash()));
                statusCodeSet.add(status.getMemberStatusCode());
                statusHashSet.add(status.instanceHash());
            }
            log(sb);
            assertEquals(statusCodeSet.size(), statusHashSet.size());
        }
        MemberDtoMapper mapper = new MemberDtoMapper();

        // ## Act ##
        List<MemberDto> dtoList = mapper.mappingToDtoList(memberList);

        // ## Assert ##
        assertHasAnyElement(dtoList);
        StringBuilder sb = new StringBuilder();
        Set<String> statusCodeSet = new HashSet<String>();
        Set<Integer> statusHashSet = new HashSet<Integer>();
        for (MemberDto memberDto : dtoList) {
            MemberStatusDto statusDto = memberDto.getMemberStatus();
            MemberAddressDto validAddressDto = memberDto.getMemberAddressAsValid();
            List<MemberAddressDto> addressList = memberDto.getMemberAddressList();
            sb.append(ln()).append(" ").append(memberDto.getMemberName());
            sb.append(ln()).append("   status: ").append(statusDto.getMemberStatusName());
            sb.append("@").append(Integer.toHexString(statusDto.instanceHash()));
            statusCodeSet.add(statusDto.getMemberStatusCode());
            statusHashSet.add(statusDto.instanceHash());
            if (validAddressDto != null) {
                sb.append(ln()).append("   valid: ").append(validAddressDto.getMemberAddressId());
                RegionDto regionDto = validAddressDto.getRegion();
                assertNull(regionDto);
                sb.append(", ").append(regionDto);
            }
            for (MemberAddressDto addressDto : addressList) {
                sb.append(ln()).append("   list: ").append(addressDto.getMemberAddressId());
                RegionDto regionDto = addressDto.getRegion();
                assertNotNull(regionDto);
                sb.append(", ").append(regionDto).append("@").append(Integer.toHexString(regionDto.instanceHash()));
            }
        }
        log(sb);
        log(statusCodeSet);
        log(statusHashSet);
        assertEquals(statusCodeSet.size(), statusHashSet.size());
    }
}
