package com.example.dbflute.guice.simpleflute.dto.bs;

import java.io.Serializable;
import java.util.*;

import net.vvakame.util.jsonpullparser.annotation.*;
import com.example.dbflute.guice.simpleflute.dto.*;

/**
 * The simple DTO of (地域)REGION as TABLE. <br />
 * <pre>
 * [primary-key]
 *     REGION_ID
 * 
 * [column]
 *     REGION_ID, REGION_NAME
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     
 * 
 * [foreign-table]
 *     
 * 
 * [referrer-table]
 *     MEMBER_ADDRESS
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberAddressList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
@JsonModel(decamelize = false)
public abstract class BsRegionDto implements Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** (地域ID)REGION_ID: {PK, NotNull, INTEGER(10)} */
    @JsonKey
    protected Integer _regionId;

    /** (地域名称)REGION_NAME: {NotNull, VARCHAR(50)} */
    @JsonKey
    protected String _regionName;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The modified properties for this DTO. */
    protected final Set<String> __modifiedProperties = new LinkedHashSet<String>();

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsRegionDto() {
    }

    // ===================================================================================
    //                                                                       Foreign Table
    //                                                                       =============
    // ===================================================================================
    //                                                                      Referrer Table
    //                                                                      ==============
    protected List<MemberAddressDto> _memberAddressList;

    public List<MemberAddressDto> getMemberAddressList() {
        if (_memberAddressList == null) { _memberAddressList = new ArrayList<MemberAddressDto>(); }
        return _memberAddressList;
    }

    public void setMemberAddressList(List<MemberAddressDto> memberAddressList) {
        this._memberAddressList = memberAddressList;
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    public Set<String> modifiedProperties() {
        return __modifiedProperties;
    }

    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    public boolean equals(Object other) {
        if (other == null || !(other instanceof BsRegionDto)) { return false; }
        final BsRegionDto otherEntity = (BsRegionDto)other;
        if (!helpComparingValue(getRegionId(), otherEntity.getRegionId())) { return false; }
        return true;
    }

    protected boolean helpComparingValue(Object value1, Object value2) {
        if (value1 == null && value2 == null) { return true; }
        return value1 != null && value2 != null && value1.equals(value2);
    }

    public int hashCode() {
        int result = 17;
        result = xCH(result, "REGION");
        result = xCH(result, getRegionId());
        return result;
    }
    protected int xCH(int result, Object value) { // calculateHashcode()
        if (value == null) {
            return result;
        }
        return (31 * result) + (value instanceof byte[] ? ((byte[]) value).length : value.hashCode());
    }

    public int instanceHash() {
        return super.hashCode();
    }

    public String toString() {
        String c = ", ";
        StringBuilder sb = new StringBuilder();
        sb.append(c).append(getRegionId());
        sb.append(c).append(getRegionName());
        if (sb.length() > 0) { sb.delete(0, c.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (地域ID)REGION_ID: {PK, NotNull, INTEGER(10)} <br />
     * @return The value of the column 'REGION_ID'. (NullAllowed)
     */
    public Integer getRegionId() {
        return _regionId;
    }

    /**
     * [set] (地域ID)REGION_ID: {PK, NotNull, INTEGER(10)} <br />
     * @param regionId The value of the column 'REGION_ID'. (NullAllowed)
     */
    public void setRegionId(Integer regionId) {
        __modifiedProperties.add("regionId");
        this._regionId = regionId;
    }

    /**
     * [get] (地域名称)REGION_NAME: {NotNull, VARCHAR(50)} <br />
     * @return The value of the column 'REGION_NAME'. (NullAllowed)
     */
    public String getRegionName() {
        return _regionName;
    }

    /**
     * [set] (地域名称)REGION_NAME: {NotNull, VARCHAR(50)} <br />
     * @param regionName The value of the column 'REGION_NAME'. (NullAllowed)
     */
    public void setRegionName(String regionName) {
        __modifiedProperties.add("regionName");
        this._regionName = regionName;
    }

}
