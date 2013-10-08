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
 * The DTO mapper of (会員サービス)MEMBER_SERVICE as TABLE. <br />
 * <pre>
 * [primary-key]
 *     MEMBER_SERVICE_ID
 * 
 * [column]
 *     MEMBER_SERVICE_ID, MEMBER_ID, SERVICE_POINT_COUNT, SERVICE_RANK_CODE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_SERVICE_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER, SERVICE_RANK
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, serviceRank
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberServiceDtoMapper implements DtoMapper<MemberService, MemberServiceDto>, Serializable {

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
    protected boolean _suppressMember;
    protected boolean _suppressServiceRank;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberServiceDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsMemberServiceDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public MemberServiceDto mappingToDto(MemberService entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (MemberServiceDto)cachedLocalDto;
        }
        MemberServiceDto dto = new MemberServiceDto();
        dto.setMemberServiceId(entity.getMemberServiceId());
        dto.setMemberId(entity.getMemberId());
        dto.setServicePointCount(entity.getServicePointCount());
        dto.setServiceRankCode(entity.getServiceRankCode());
        dto.setRegisterDatetime(entity.getRegisterDatetime());
        dto.setRegisterUser(entity.getRegisterUser());
        dto.setUpdateDatetime(entity.getUpdateDatetime());
        dto.setUpdateUser(entity.getUpdateUser());
        dto.setVersionNo(entity.getVersionNo());
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only a DTO that has a primary key value
            _relationDtoMap.put(localKey, dto);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressMember && entity.getMember() != null) {
            Member relationEntity = entity.getMember();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberDto relationDto = (MemberDto)cachedDto;
                dto.setMember(relationDto);
                if (reverseReference) {
                    relationDto.setMemberServiceAsOne(dto);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberServiceAsOne();
                MemberDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMember(relationDto);
                if (reverseReference) {
                    relationDto.setMemberServiceAsOne(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMember());
                }
            }
        };
        if (!_suppressServiceRank && entity.getServiceRank() != null) {
            ServiceRank relationEntity = entity.getServiceRank();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                ServiceRankDto relationDto = (ServiceRankDto)cachedDto;
                dto.setServiceRank(relationDto);
                if (reverseReference) {
                    relationDto.getMemberServiceList().add(dto);
                }
            } else {
                ServiceRankDtoMapper mapper = new ServiceRankDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberServiceList();
                ServiceRankDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setServiceRank(relationDto);
                if (reverseReference) {
                    relationDto.getMemberServiceList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getServiceRank());
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<MemberServiceDto> mappingToDtoList(List<MemberService> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<MemberServiceDto> dtoList = new ArrayList<MemberServiceDto>();
        for (MemberService entity : entityList) {
            MemberServiceDto dto = mappingToDto(entity);
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
    public MemberService mappingToEntity(MemberServiceDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (MemberService)cachedLocalEntity;
        }
        MemberService entity = new MemberService();
        if (needsMapping(dto, dto.getMemberServiceId(), "memberServiceId")) {
            entity.setMemberServiceId(dto.getMemberServiceId());
        }
        if (needsMapping(dto, dto.getMemberId(), "memberId")) {
            entity.setMemberId(dto.getMemberId());
        }
        if (needsMapping(dto, dto.getServicePointCount(), "servicePointCount")) {
            entity.setServicePointCount(dto.getServicePointCount());
        }
        if (needsMapping(dto, dto.getServiceRankCode(), "serviceRankCode")) {
            entity.setServiceRankCodeAsServiceRank(CDef.ServiceRank.codeOf(dto.getServiceRankCode()));
        }
        if (needsMapping(dto, dto.getRegisterDatetime(), "registerDatetime")) {
            entity.setRegisterDatetime(dto.getRegisterDatetime());
        }
        if (needsMapping(dto, dto.getRegisterUser(), "registerUser")) {
            entity.setRegisterUser(dto.getRegisterUser());
        }
        if (needsMapping(dto, dto.getUpdateDatetime(), "updateDatetime")) {
            entity.setUpdateDatetime(dto.getUpdateDatetime());
        }
        if (needsMapping(dto, dto.getUpdateUser(), "updateUser")) {
            entity.setUpdateUser(dto.getUpdateUser());
        }
        if (needsMapping(dto, dto.getVersionNo(), "versionNo")) {
            entity.setVersionNo(dto.getVersionNo());
        }
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only an entity that has a primary key value
            _relationEntityMap.put(localKey, entity);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressMember && dto.getMember() != null) {
            MemberDto relationDto = dto.getMember();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                Member relationEntity = (Member)cachedEntity;
                entity.setMember(relationEntity);
                if (reverseReference) {
                    relationEntity.setMemberServiceAsOne(entity);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberServiceAsOne();
                Member relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMember(relationEntity);
                if (reverseReference) {
                    relationEntity.setMemberServiceAsOne(entity);
                }
                if (instanceCache && entity.getMember().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMember());
                }
            }
        };
        if (!_suppressServiceRank && dto.getServiceRank() != null) {
            ServiceRankDto relationDto = dto.getServiceRank();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                ServiceRank relationEntity = (ServiceRank)cachedEntity;
                entity.setServiceRank(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberServiceList().add(entity);
                }
            } else {
                ServiceRankDtoMapper mapper = new ServiceRankDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberServiceList();
                ServiceRank relationEntity = mapper.mappingToEntity(relationDto);
                entity.setServiceRank(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberServiceList().add(entity);
                }
                if (instanceCache && entity.getServiceRank().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getServiceRank());
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
    protected boolean needsMapping(MemberServiceDto dto, Object value, String propName) {
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
    public List<MemberService> mappingToEntityList(List<MemberServiceDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<MemberService> entityList = new ArrayList<MemberService>();
        for (MemberServiceDto dto : dtoList) {
            MemberService entity = mappingToEntity(dto);
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
    public void suppressMember() {
        _suppressMember = true;
    }
    public void suppressServiceRank() {
        _suppressServiceRank = true;
    }
    protected void doSuppressAll() { // internal
        suppressMember();
        suppressServiceRank();
    }
    protected void doSuppressClear() { // internal
        _suppressMember = false;
        _suppressServiceRank = false;
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
