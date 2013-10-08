package com.example.dbflute.guice.dbflute.dtomapper.bs.customize;

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
import com.example.dbflute.guice.dbflute.exentity.customize.*;
import com.example.dbflute.guice.simpleflute.dto.customize.*;

/**
 * The DTO mapper of CommonColumnMember. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER
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
public abstract class BsCommonColumnMemberDtoMapper implements DtoMapper<CommonColumnMember, CommonColumnMemberDto>, Serializable {

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
    public BsCommonColumnMemberDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsCommonColumnMemberDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public CommonColumnMemberDto mappingToDto(CommonColumnMember entity) {
        if (entity == null) {
            return null;
        }
        CommonColumnMemberDto dto = new CommonColumnMemberDto();
        dto.setMemberId(entity.getMemberId());
        dto.setMemberName(entity.getMemberName());
        dto.setRegisterDatetime(entity.getRegisterDatetime());
        dto.setRegisterUser(entity.getRegisterUser());
        dto.setUpdateDatetime(entity.getUpdateDatetime());
        dto.setUpdateUser(entity.getUpdateUser());
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<CommonColumnMemberDto> mappingToDtoList(List<CommonColumnMember> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<CommonColumnMemberDto> dtoList = new ArrayList<CommonColumnMemberDto>();
        for (CommonColumnMember entity : entityList) {
            CommonColumnMemberDto dto = mappingToDto(entity);
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
    public CommonColumnMember mappingToEntity(CommonColumnMemberDto dto) {
        if (dto == null) {
            return null;
        }
        CommonColumnMember entity = new CommonColumnMember();
        if (needsMapping(dto, dto.getMemberId(), "memberId")) {
            entity.setMemberId(dto.getMemberId());
        }
        if (needsMapping(dto, dto.getMemberName(), "memberName")) {
            entity.setMemberName(dto.getMemberName());
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
    protected boolean needsMapping(CommonColumnMemberDto dto, Object value, String propName) {
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
    public List<CommonColumnMember> mappingToEntityList(List<CommonColumnMemberDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<CommonColumnMember> entityList = new ArrayList<CommonColumnMember>();
        for (CommonColumnMemberDto dto : dtoList) {
            CommonColumnMember entity = mappingToEntity(dto);
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
