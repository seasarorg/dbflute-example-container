package com.example.dbflute.guice.dbflute.dtomapper.bs;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.bhv.DtoMapper;
import org.seasar.dbflute.bhv.InstanceKeyDto;
import org.seasar.dbflute.bhv.InstanceKeyEntity;
import com.example.dbflute.guice.dbflute.exentity.*;
import com.example.dbflute.guice.simpleflute.dto.*;

/**
 * The DTO mapper of SUMMARY_WITHDRAWAL as VIEW. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, WITHDRAWAL_REASON_CODE, WITHDRAWAL_REASON_TEXT, WITHDRAWAL_REASON_INPUT_TEXT, WITHDRAWAL_DATETIME, MEMBER_STATUS_CODE, MEMBER_STATUS_NAME, MAX_PURCHASE_PRICE
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
 *     
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsSummaryWithdrawalDtoMapper implements DtoMapper<SummaryWithdrawal, SummaryWithdrawalDto>, Serializable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final Map<Entity, Object> _relationDtoMap;
    protected final Map<Object, Entity> _relationEntityMap;
    protected boolean _reverseReference; // default: one-way reference
    protected boolean _instanceCache = true; // default: cached

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsSummaryWithdrawalDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsSummaryWithdrawalDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
        _relationDtoMap = relationDtoMap;
        _relationEntityMap = relationEntityMap;
    }

    // ===================================================================================
    //                                                                             Mapping
    //                                                                             =======
    // -----------------------------------------------------
    //                                                to DTO
    //                                                ------
    /**
     * {@inheritDoc}
     */
    public SummaryWithdrawalDto mappingToDto(SummaryWithdrawal entity) {
        if (entity == null) {
            return null;
        }
        SummaryWithdrawalDto dto = new SummaryWithdrawalDto();
        dto.setMemberId(entity.getMemberId());
        dto.setMemberName(entity.getMemberName());
        dto.setWithdrawalReasonCode(entity.getWithdrawalReasonCode());
        dto.setWithdrawalReasonText(entity.getWithdrawalReasonText());
        dto.setWithdrawalReasonInputText(entity.getWithdrawalReasonInputText());
        dto.setWithdrawalDatetime(entity.getWithdrawalDatetime());
        dto.setMemberStatusCode(entity.getMemberStatusCode());
        dto.setMemberStatusName(entity.getMemberStatusName());
        dto.setMaxPurchasePrice(entity.getMaxPurchasePrice());
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<SummaryWithdrawalDto> mappingToDtoList(List<SummaryWithdrawal> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<SummaryWithdrawalDto> dtoList = new ArrayList<SummaryWithdrawalDto>();
        for (SummaryWithdrawal entity : entityList) {
            SummaryWithdrawalDto dto = mappingToDto(entity);
            if (dto != null) {
                dtoList.add(dto);
            } else {
                if (isAcceptNullElementOnList()) {
                    dtoList.add(null);
                }
            }
        }
        return dtoList;
    }

    // -----------------------------------------------------
    //                                             to Entity
    //                                             ---------
    /**
     * {@inheritDoc}
     */
    public SummaryWithdrawal mappingToEntity(SummaryWithdrawalDto dto) {
        if (dto == null) {
            return null;
        }
        SummaryWithdrawal entity = new SummaryWithdrawal();
        if (needsMapping(dto, dto.getMemberId(), "memberId")) {
            entity.setMemberId(dto.getMemberId());
        }
        if (needsMapping(dto, dto.getMemberName(), "memberName")) {
            entity.setMemberName(dto.getMemberName());
        }
        if (needsMapping(dto, dto.getWithdrawalReasonCode(), "withdrawalReasonCode")) {
            entity.setWithdrawalReasonCode(dto.getWithdrawalReasonCode());
        }
        if (needsMapping(dto, dto.getWithdrawalReasonText(), "withdrawalReasonText")) {
            entity.setWithdrawalReasonText(dto.getWithdrawalReasonText());
        }
        if (needsMapping(dto, dto.getWithdrawalReasonInputText(), "withdrawalReasonInputText")) {
            entity.setWithdrawalReasonInputText(dto.getWithdrawalReasonInputText());
        }
        if (needsMapping(dto, dto.getWithdrawalDatetime(), "withdrawalDatetime")) {
            entity.setWithdrawalDatetime(dto.getWithdrawalDatetime());
        }
        if (needsMapping(dto, dto.getMemberStatusCode(), "memberStatusCode")) {
            entity.setMemberStatusCode(dto.getMemberStatusCode());
        }
        if (needsMapping(dto, dto.getMemberStatusName(), "memberStatusName")) {
            entity.setMemberStatusName(dto.getMemberStatusName());
        }
        if (needsMapping(dto, dto.getMaxPurchasePrice(), "maxPurchasePrice")) {
            entity.setMaxPurchasePrice(dto.getMaxPurchasePrice());
        }
        return entity;
    }

    /**
     * Does the property need to be mapped to an entity? <br />
     * If modified info of DTO has at least one property, only modified properties are mapped.
     * And if no property is modified, all properties are mapped (but the other option exists).
     * @param dto The instance of DTO. (NotNull)
     * @param value The value of DTO's property. (NotNull)
     * @param propName The property name of DTO. (NotNull)
     * @return The determination, true or false.
     */
    protected boolean needsMapping(SummaryWithdrawalDto dto, Object value, String propName) {
        Set<String> modifiedProperties = dto.modifiedProperties();
        if (modifiedProperties.isEmpty()) {
            return isMappingToEntityContainsNull() || value != null;
        }
        return modifiedProperties.contains(propName);
    }

    /**
     * Does the mapping to an entity contain null values? (when no property is modified) <br />
     * Default is true that means a setter is called if the value is null.
     * But this method is valid only when no property is modified. 
     * @return The determination, true or false.
     */
    protected boolean isMappingToEntityContainsNull() { // for extension
        return true; // as default
    }

    /**
     * {@inheritDoc}
     */
    public List<SummaryWithdrawal> mappingToEntityList(List<SummaryWithdrawalDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<SummaryWithdrawal> entityList = new ArrayList<SummaryWithdrawal>();
        for (SummaryWithdrawalDto dto : dtoList) {
            SummaryWithdrawal entity = mappingToEntity(dto);
            if (entity != null) {
                entityList.add(entity);
            } else {
                if (isAcceptNullElementOnList()) {
                    entityList.add(null);
                }
            }
        }
        return entityList;
    }

    protected boolean isAcceptNullElementOnList() {
        return true; // as default
    }

    // -----------------------------------------------------
    //                                          Instance Key
    //                                          ------------
    protected Object createInstanceKeyDto(final Object dto, final int instanceHash) {
        return new InstanceKeyDto(dto, instanceHash);
    }

    protected InstanceKeyEntity createInstanceKeyEntity(Entity entity) {
        return new InstanceKeyEntity(entity);
    }

    public void disableInstanceCache() { // internal option
        _instanceCache = false;
    }

    // ===================================================================================
    //                                                                   Suppress Relation
    //                                                                   =================
    // (basically) to suppress infinity loop
    protected void doSuppressAll() { // internal
    }
    protected void doSuppressClear() { // internal
    }

    // ===================================================================================
    //                                                                      Mapping Option
    //                                                                      ==============
    /**
     * {@inheritDoc}
     */
    public void setBaseOnlyMapping(boolean baseOnlyMapping) {
        if (baseOnlyMapping) {
            doSuppressAll();
        } else {
            doSuppressClear();
        }
    }

    /**
     * {@inheritDoc}
     */
    public void setReverseReference(boolean reverseReference) {
        _reverseReference = reverseReference;
    }
}
