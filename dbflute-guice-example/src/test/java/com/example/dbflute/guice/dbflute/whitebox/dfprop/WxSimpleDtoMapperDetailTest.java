package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.guice.dbflute.cbean.MemberAddressCB;
import com.example.dbflute.guice.dbflute.cbean.MemberCB;
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
    //                                                                      Instance Cache
    //                                                                      ==============
    public void test_mappingToDtoList_instanceCache_basic_Tx() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberAddressAsValid(currentDate());
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
                MemberStatus status = member.getMemberStatus();
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
        assertListNotEmpty(dtoList);
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
