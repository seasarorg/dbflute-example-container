package com.example.dbflute.guice.dbflute.dtomapper.bs;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.optional.OptionalEntity;
import org.seasar.dbflute.bhv.DtoMapper;
import org.seasar.dbflute.bhv.InstanceKeyDto;
import org.seasar.dbflute.bhv.InstanceKeyEntity;
import com.example.dbflute.guice.dbflute.exentity.*;
import com.example.dbflute.guice.simpleflute.dto.*;
import com.example.dbflute.guice.dbflute.dtomapper.*;

/**
 * The DTO mapper of VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF as TABLE. <br />
 * <pre>
 * [primary-key]
 *     THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF_ID
 * 
 * [column]
 *     THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF_ID, THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF_DATE, SHORT_DATE
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
 *     VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     vendorTheLongAndWindingTableAndColumn
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVendorTheLongAndWindingTableAndColumnRefDtoMapper implements DtoMapper<VendorTheLongAndWindingTableAndColumnRef, VendorTheLongAndWindingTableAndColumnRefDto>, Serializable {

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
    protected boolean _suppressVendorTheLongAndWindingTableAndColumn;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVendorTheLongAndWindingTableAndColumnRefDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsVendorTheLongAndWindingTableAndColumnRefDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public VendorTheLongAndWindingTableAndColumnRefDto mappingToDto(VendorTheLongAndWindingTableAndColumnRef entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (VendorTheLongAndWindingTableAndColumnRefDto)cachedLocalDto;
        }
        VendorTheLongAndWindingTableAndColumnRefDto dto = new VendorTheLongAndWindingTableAndColumnRefDto();
        dto.setTheLongAndWindingTableAndColumnRefId(entity.getTheLongAndWindingTableAndColumnRefId());
        dto.setTheLongAndWindingTableAndColumnId(entity.getTheLongAndWindingTableAndColumnId());
        dto.setTheLongAndWindingTableAndColumnRefDate(entity.getTheLongAndWindingTableAndColumnRefDate());
        dto.setShortDate(entity.getShortDate());
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only a DTO that has a primary key value
            _relationDtoMap.put(localKey, dto);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressVendorTheLongAndWindingTableAndColumn && entity.getVendorTheLongAndWindingTableAndColumn().isPresent()) {
            VendorTheLongAndWindingTableAndColumn relationEntity = entity.getVendorTheLongAndWindingTableAndColumn().get();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                VendorTheLongAndWindingTableAndColumnDto relationDto = (VendorTheLongAndWindingTableAndColumnDto)cachedDto;
                dto.setVendorTheLongAndWindingTableAndColumn(relationDto);
                if (reverseReference) {
                    relationDto.getVendorTheLongAndWindingTableAndColumnRefList().add(dto);
                }
            } else {
                VendorTheLongAndWindingTableAndColumnDtoMapper mapper = new VendorTheLongAndWindingTableAndColumnDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressVendorTheLongAndWindingTableAndColumnRefList();
                VendorTheLongAndWindingTableAndColumnDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setVendorTheLongAndWindingTableAndColumn(relationDto);
                if (reverseReference) {
                    relationDto.getVendorTheLongAndWindingTableAndColumnRefList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getVendorTheLongAndWindingTableAndColumn());
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<VendorTheLongAndWindingTableAndColumnRefDto> mappingToDtoList(List<VendorTheLongAndWindingTableAndColumnRef> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<VendorTheLongAndWindingTableAndColumnRefDto> dtoList = new ArrayList<VendorTheLongAndWindingTableAndColumnRefDto>();
        for (VendorTheLongAndWindingTableAndColumnRef entity : entityList) {
            VendorTheLongAndWindingTableAndColumnRefDto dto = mappingToDto(entity);
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
    public VendorTheLongAndWindingTableAndColumnRef mappingToEntity(VendorTheLongAndWindingTableAndColumnRefDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (VendorTheLongAndWindingTableAndColumnRef)cachedLocalEntity;
        }
        VendorTheLongAndWindingTableAndColumnRef entity = new VendorTheLongAndWindingTableAndColumnRef();
        if (needsMapping(dto, dto.getTheLongAndWindingTableAndColumnRefId(), "theLongAndWindingTableAndColumnRefId")) {
            entity.setTheLongAndWindingTableAndColumnRefId(dto.getTheLongAndWindingTableAndColumnRefId());
        }
        if (needsMapping(dto, dto.getTheLongAndWindingTableAndColumnId(), "theLongAndWindingTableAndColumnId")) {
            entity.setTheLongAndWindingTableAndColumnId(dto.getTheLongAndWindingTableAndColumnId());
        }
        if (needsMapping(dto, dto.getTheLongAndWindingTableAndColumnRefDate(), "theLongAndWindingTableAndColumnRefDate")) {
            entity.setTheLongAndWindingTableAndColumnRefDate(dto.getTheLongAndWindingTableAndColumnRefDate());
        }
        if (needsMapping(dto, dto.getShortDate(), "shortDate")) {
            entity.setShortDate(dto.getShortDate());
        }
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only an entity that has a primary key value
            _relationEntityMap.put(localKey, entity);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressVendorTheLongAndWindingTableAndColumn && dto.getVendorTheLongAndWindingTableAndColumn() != null) {
            VendorTheLongAndWindingTableAndColumnDto relationDto = dto.getVendorTheLongAndWindingTableAndColumn();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                VendorTheLongAndWindingTableAndColumn relationEntity = (VendorTheLongAndWindingTableAndColumn)cachedEntity;
                entity.setVendorTheLongAndWindingTableAndColumn(OptionalEntity.of(relationEntity));
                if (reverseReference) {
                    relationEntity.getVendorTheLongAndWindingTableAndColumnRefList().add(entity);
                }
            } else {
                VendorTheLongAndWindingTableAndColumnDtoMapper mapper = new VendorTheLongAndWindingTableAndColumnDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressVendorTheLongAndWindingTableAndColumnRefList();
                VendorTheLongAndWindingTableAndColumn relationEntity = mapper.mappingToEntity(relationDto);
                entity.setVendorTheLongAndWindingTableAndColumn(OptionalEntity.of(relationEntity));
                if (reverseReference) {
                    relationEntity.getVendorTheLongAndWindingTableAndColumnRefList().add(entity);
                }
                if (instanceCache && entity.getVendorTheLongAndWindingTableAndColumn().get().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getVendorTheLongAndWindingTableAndColumn().get());
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
    protected boolean needsMapping(VendorTheLongAndWindingTableAndColumnRefDto dto, Object value, String propName) {
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
    public List<VendorTheLongAndWindingTableAndColumnRef> mappingToEntityList(List<VendorTheLongAndWindingTableAndColumnRefDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<VendorTheLongAndWindingTableAndColumnRef> entityList = new ArrayList<VendorTheLongAndWindingTableAndColumnRef>();
        for (VendorTheLongAndWindingTableAndColumnRefDto dto : dtoList) {
            VendorTheLongAndWindingTableAndColumnRef entity = mappingToEntity(dto);
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
    public void suppressVendorTheLongAndWindingTableAndColumn() {
        _suppressVendorTheLongAndWindingTableAndColumn = true;
    }
    protected void doSuppressAll() { // internal
        suppressVendorTheLongAndWindingTableAndColumn();
    }
    protected void doSuppressClear() { // internal
        _suppressVendorTheLongAndWindingTableAndColumn = false;
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
