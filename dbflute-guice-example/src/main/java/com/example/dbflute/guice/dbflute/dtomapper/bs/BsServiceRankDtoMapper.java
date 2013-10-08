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
import com.example.dbflute.guice.dbflute.allcommon.CDef;
import com.example.dbflute.guice.dbflute.exentity.*;
import com.example.dbflute.guice.simpleflute.dto.*;
import com.example.dbflute.guice.dbflute.dtomapper.*;

/**
 * The DTO mapper of (サービスランク)SERVICE_RANK as TABLE. <br />
 * <pre>
 * [primary-key]
 *     SERVICE_RANK_CODE
 * 
 * [column]
 *     SERVICE_RANK_CODE, SERVICE_RANK_NAME, SERVICE_POINT_INCIDENCE, NEW_ACCEPTABLE_FLG, DESCRIPTION, DISPLAY_ORDER
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
 *     MEMBER_SERVICE
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     memberServiceList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsServiceRankDtoMapper implements DtoMapper<ServiceRank, ServiceRankDto>, Serializable {

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
    protected boolean _suppressMemberServiceList;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsServiceRankDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsServiceRankDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public ServiceRankDto mappingToDto(ServiceRank entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (ServiceRankDto)cachedLocalDto;
        }
        ServiceRankDto dto = new ServiceRankDto();
        dto.setServiceRankCode(entity.getServiceRankCode());
        dto.setServiceRankName(entity.getServiceRankName());
        dto.setServicePointIncidence(entity.getServicePointIncidence());
        dto.setNewAcceptableFlg(entity.getNewAcceptableFlg());
        dto.setDescription(entity.getDescription());
        dto.setDisplayOrder(entity.getDisplayOrder());
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only a DTO that has a primary key value
            _relationDtoMap.put(localKey, dto);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressMemberServiceList && !entity.getMemberServiceList().isEmpty()) {
            MemberServiceDtoMapper mapper = new MemberServiceDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressServiceRank();
            List<MemberServiceDto> relationDtoList = mapper.mappingToDtoList(entity.getMemberServiceList());
            dto.setMemberServiceList(relationDtoList);
            if (reverseReference) {
                for (MemberServiceDto relationDto : relationDtoList) {
                    relationDto.setServiceRank(dto);
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<ServiceRankDto> mappingToDtoList(List<ServiceRank> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<ServiceRankDto> dtoList = new ArrayList<ServiceRankDto>();
        for (ServiceRank entity : entityList) {
            ServiceRankDto dto = mappingToDto(entity);
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
    public ServiceRank mappingToEntity(ServiceRankDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (ServiceRank)cachedLocalEntity;
        }
        ServiceRank entity = new ServiceRank();
        if (needsMapping(dto, dto.getServiceRankCode(), "serviceRankCode")) {
            entity.setServiceRankCodeAsServiceRank(CDef.ServiceRank.codeOf(dto.getServiceRankCode()));
        }
        if (needsMapping(dto, dto.getServiceRankName(), "serviceRankName")) {
            entity.setServiceRankName(dto.getServiceRankName());
        }
        if (needsMapping(dto, dto.getServicePointIncidence(), "servicePointIncidence")) {
            entity.setServicePointIncidence(dto.getServicePointIncidence());
        }
        if (needsMapping(dto, dto.getNewAcceptableFlg(), "newAcceptableFlg")) {
            entity.setNewAcceptableFlgAsFlg(CDef.Flg.codeOf(dto.getNewAcceptableFlg()));
        }
        if (needsMapping(dto, dto.getDescription(), "description")) {
            entity.setDescription(dto.getDescription());
        }
        if (needsMapping(dto, dto.getDisplayOrder(), "displayOrder")) {
            entity.setDisplayOrder(dto.getDisplayOrder());
        }
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only an entity that has a primary key value
            _relationEntityMap.put(localKey, entity);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressMemberServiceList && !dto.getMemberServiceList().isEmpty()) {
            MemberServiceDtoMapper mapper = new MemberServiceDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressServiceRank();
            List<MemberService> relationEntityList = mapper.mappingToEntityList(dto.getMemberServiceList());
            entity.setMemberServiceList(relationEntityList);
            if (reverseReference) {
                for (MemberService relationEntity : relationEntityList) {
                    relationEntity.setServiceRank(entity);
                }
            }
        };
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
    protected boolean needsMapping(ServiceRankDto dto, Object value, String propName) {
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
    public List<ServiceRank> mappingToEntityList(List<ServiceRankDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<ServiceRank> entityList = new ArrayList<ServiceRank>();
        for (ServiceRankDto dto : dtoList) {
            ServiceRank entity = mappingToEntity(dto);
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
    public void suppressMemberServiceList() {
        _suppressMemberServiceList = true;
    }
    protected void doSuppressAll() { // internal
        suppressMemberServiceList();
    }
    protected void doSuppressClear() { // internal
        _suppressMemberServiceList = false;
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
