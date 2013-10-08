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
import com.example.dbflute.guice.dbflute.dtomapper.*;

/**
 * The DTO mapper of (会員フォローイング)MEMBER_FOLLOWING as TABLE. <br />
 * <pre>
 * [primary-key]
 *     MEMBER_FOLLOWING_ID
 * 
 * [column]
 *     MEMBER_FOLLOWING_ID, MY_MEMBER_ID, YOUR_MEMBER_ID, FOLLOW_DATETIME
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_FOLLOWING_ID
 * 
 * [version-no]
 *     
 * 
 * [foreign-table]
 *     MEMBER
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     memberByMyMemberId, memberByYourMemberId
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberFollowingDtoMapper implements DtoMapper<MemberFollowing, MemberFollowingDto>, Serializable {

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
    protected boolean _suppressMemberByMyMemberId;
    protected boolean _suppressMemberByYourMemberId;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberFollowingDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsMemberFollowingDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public MemberFollowingDto mappingToDto(MemberFollowing entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (MemberFollowingDto)cachedLocalDto;
        }
        MemberFollowingDto dto = new MemberFollowingDto();
        dto.setMemberFollowingId(entity.getMemberFollowingId());
        dto.setMyMemberId(entity.getMyMemberId());
        dto.setYourMemberId(entity.getYourMemberId());
        dto.setFollowDatetime(entity.getFollowDatetime());
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only a DTO that has a primary key value
            _relationDtoMap.put(localKey, dto);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressMemberByMyMemberId && entity.getMemberByMyMemberId() != null) {
            Member relationEntity = entity.getMemberByMyMemberId();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberDto relationDto = (MemberDto)cachedDto;
                dto.setMemberByMyMemberId(relationDto);
                if (reverseReference) {
                    relationDto.getMemberFollowingByMyMemberIdList().add(dto);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberFollowingByMyMemberIdList();
                MemberDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberByMyMemberId(relationDto);
                if (reverseReference) {
                    relationDto.getMemberFollowingByMyMemberIdList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberByMyMemberId());
                }
            }
        };
        if (!_suppressMemberByYourMemberId && entity.getMemberByYourMemberId() != null) {
            Member relationEntity = entity.getMemberByYourMemberId();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberDto relationDto = (MemberDto)cachedDto;
                dto.setMemberByYourMemberId(relationDto);
                if (reverseReference) {
                    relationDto.getMemberFollowingByYourMemberIdList().add(dto);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberFollowingByYourMemberIdList();
                MemberDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberByYourMemberId(relationDto);
                if (reverseReference) {
                    relationDto.getMemberFollowingByYourMemberIdList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberByYourMemberId());
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<MemberFollowingDto> mappingToDtoList(List<MemberFollowing> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<MemberFollowingDto> dtoList = new ArrayList<MemberFollowingDto>();
        for (MemberFollowing entity : entityList) {
            MemberFollowingDto dto = mappingToDto(entity);
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
    public MemberFollowing mappingToEntity(MemberFollowingDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (MemberFollowing)cachedLocalEntity;
        }
        MemberFollowing entity = new MemberFollowing();
        if (needsMapping(dto, dto.getMemberFollowingId(), "memberFollowingId")) {
            entity.setMemberFollowingId(dto.getMemberFollowingId());
        }
        if (needsMapping(dto, dto.getMyMemberId(), "myMemberId")) {
            entity.setMyMemberId(dto.getMyMemberId());
        }
        if (needsMapping(dto, dto.getYourMemberId(), "yourMemberId")) {
            entity.setYourMemberId(dto.getYourMemberId());
        }
        if (needsMapping(dto, dto.getFollowDatetime(), "followDatetime")) {
            entity.setFollowDatetime(dto.getFollowDatetime());
        }
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only an entity that has a primary key value
            _relationEntityMap.put(localKey, entity);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressMemberByMyMemberId && dto.getMemberByMyMemberId() != null) {
            MemberDto relationDto = dto.getMemberByMyMemberId();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                Member relationEntity = (Member)cachedEntity;
                entity.setMemberByMyMemberId(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberFollowingByMyMemberIdList().add(entity);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberFollowingByMyMemberIdList();
                Member relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberByMyMemberId(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberFollowingByMyMemberIdList().add(entity);
                }
                if (instanceCache && entity.getMemberByMyMemberId().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberByMyMemberId());
                }
            }
        };
        if (!_suppressMemberByYourMemberId && dto.getMemberByYourMemberId() != null) {
            MemberDto relationDto = dto.getMemberByYourMemberId();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                Member relationEntity = (Member)cachedEntity;
                entity.setMemberByYourMemberId(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberFollowingByYourMemberIdList().add(entity);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberFollowingByYourMemberIdList();
                Member relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberByYourMemberId(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberFollowingByYourMemberIdList().add(entity);
                }
                if (instanceCache && entity.getMemberByYourMemberId().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberByYourMemberId());
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
    protected boolean needsMapping(MemberFollowingDto dto, Object value, String propName) {
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
    public List<MemberFollowing> mappingToEntityList(List<MemberFollowingDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<MemberFollowing> entityList = new ArrayList<MemberFollowing>();
        for (MemberFollowingDto dto : dtoList) {
            MemberFollowing entity = mappingToEntity(dto);
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
    public void suppressMemberByMyMemberId() {
        _suppressMemberByMyMemberId = true;
    }
    public void suppressMemberByYourMemberId() {
        _suppressMemberByYourMemberId = true;
    }
    protected void doSuppressAll() { // internal
        suppressMemberByMyMemberId();
        suppressMemberByYourMemberId();
    }
    protected void doSuppressClear() { // internal
        _suppressMemberByMyMemberId = false;
        _suppressMemberByYourMemberId = false;
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
