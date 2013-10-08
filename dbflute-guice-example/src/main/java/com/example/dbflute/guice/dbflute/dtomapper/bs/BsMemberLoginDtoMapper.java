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
 * The DTO mapper of (会員ログイン)MEMBER_LOGIN as TABLE. <br />
 * <pre>
 * [primary-key]
 *     MEMBER_LOGIN_ID
 * 
 * [column]
 *     MEMBER_LOGIN_ID, MEMBER_ID, LOGIN_DATETIME, MOBILE_LOGIN_FLG, LOGIN_MEMBER_STATUS_CODE
 * 
 * [sequence]
 *     EXAMPLEDB.PUBLIC.SEQ_MEMBER_LOGIN
 * 
 * [identity]
 *     MEMBER_LOGIN_ID
 * 
 * [version-no]
 *     
 * 
 * [foreign-table]
 *     MEMBER, MEMBER_STATUS
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, memberStatus
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberLoginDtoMapper implements DtoMapper<MemberLogin, MemberLoginDto>, Serializable {

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
    protected boolean _suppressMemberStatus;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberLoginDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsMemberLoginDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public MemberLoginDto mappingToDto(MemberLogin entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (MemberLoginDto)cachedLocalDto;
        }
        MemberLoginDto dto = new MemberLoginDto();
        dto.setMemberLoginId(entity.getMemberLoginId());
        dto.setMemberId(entity.getMemberId());
        dto.setLoginDatetime(entity.getLoginDatetime());
        dto.setMobileLoginFlg(entity.getMobileLoginFlg());
        dto.setLoginMemberStatusCode(entity.getLoginMemberStatusCode());
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
                    relationDto.getMemberLoginList().add(dto);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberLoginList();
                MemberDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMember(relationDto);
                if (reverseReference) {
                    relationDto.getMemberLoginList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMember());
                }
            }
        };
        if (!_suppressMemberStatus && entity.getMemberStatus() != null) {
            MemberStatus relationEntity = entity.getMemberStatus();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberStatusDto relationDto = (MemberStatusDto)cachedDto;
                dto.setMemberStatus(relationDto);
                if (reverseReference) {
                    relationDto.getMemberLoginList().add(dto);
                }
            } else {
                MemberStatusDtoMapper mapper = new MemberStatusDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberLoginList();
                MemberStatusDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberStatus(relationDto);
                if (reverseReference) {
                    relationDto.getMemberLoginList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberStatus());
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<MemberLoginDto> mappingToDtoList(List<MemberLogin> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<MemberLoginDto> dtoList = new ArrayList<MemberLoginDto>();
        for (MemberLogin entity : entityList) {
            MemberLoginDto dto = mappingToDto(entity);
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
    public MemberLogin mappingToEntity(MemberLoginDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (MemberLogin)cachedLocalEntity;
        }
        MemberLogin entity = new MemberLogin();
        if (needsMapping(dto, dto.getMemberLoginId(), "memberLoginId")) {
            entity.setMemberLoginId(dto.getMemberLoginId());
        }
        if (needsMapping(dto, dto.getMemberId(), "memberId")) {
            entity.setMemberId(dto.getMemberId());
        }
        if (needsMapping(dto, dto.getLoginDatetime(), "loginDatetime")) {
            entity.setLoginDatetime(dto.getLoginDatetime());
        }
        if (needsMapping(dto, dto.getMobileLoginFlg(), "mobileLoginFlg")) {
            entity.setMobileLoginFlgAsFlg(CDef.Flg.codeOf(dto.getMobileLoginFlg()));
        }
        if (needsMapping(dto, dto.getLoginMemberStatusCode(), "loginMemberStatusCode")) {
            entity.setLoginMemberStatusCodeAsMemberStatus(CDef.MemberStatus.codeOf(dto.getLoginMemberStatusCode()));
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
                    relationEntity.getMemberLoginList().add(entity);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberLoginList();
                Member relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMember(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberLoginList().add(entity);
                }
                if (instanceCache && entity.getMember().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMember());
                }
            }
        };
        if (!_suppressMemberStatus && dto.getMemberStatus() != null) {
            MemberStatusDto relationDto = dto.getMemberStatus();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                MemberStatus relationEntity = (MemberStatus)cachedEntity;
                entity.setMemberStatus(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberLoginList().add(entity);
                }
            } else {
                MemberStatusDtoMapper mapper = new MemberStatusDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressMemberLoginList();
                MemberStatus relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberStatus(relationEntity);
                if (reverseReference) {
                    relationEntity.getMemberLoginList().add(entity);
                }
                if (instanceCache && entity.getMemberStatus().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberStatus());
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
    protected boolean needsMapping(MemberLoginDto dto, Object value, String propName) {
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
    public List<MemberLogin> mappingToEntityList(List<MemberLoginDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<MemberLogin> entityList = new ArrayList<MemberLogin>();
        for (MemberLoginDto dto : dtoList) {
            MemberLogin entity = mappingToEntity(dto);
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
    public void suppressMemberStatus() {
        _suppressMemberStatus = true;
    }
    protected void doSuppressAll() { // internal
        suppressMember();
        suppressMemberStatus();
    }
    protected void doSuppressClear() { // internal
        _suppressMember = false;
        _suppressMemberStatus = false;
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
