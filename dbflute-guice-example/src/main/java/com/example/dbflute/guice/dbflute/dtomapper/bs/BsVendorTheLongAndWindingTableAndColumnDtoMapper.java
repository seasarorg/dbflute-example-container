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
 * The DTO mapper of VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN as TABLE. <br />
 * <pre>
 * [primary-key]
 *     THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID
 * 
 * [column]
 *     THE_LONG_AND_WINDING_TABLE_AND_COLUMN_ID, THE_LONG_AND_WINDING_TABLE_AND_COLUMN_NAME, SHORT_NAME, SHORT_SIZE
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
 *     VENDOR_THE_LONG_AND_WINDING_TABLE_AND_COLUMN_REF
 * 
 * [foreign-property]
 *     
 * 
 * [referrer-property]
 *     vendorTheLongAndWindingTableAndColumnRefList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsVendorTheLongAndWindingTableAndColumnDtoMapper implements DtoMapper<VendorTheLongAndWindingTableAndColumn, VendorTheLongAndWindingTableAndColumnDto>, Serializable {

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
    protected boolean _suppressVendorTheLongAndWindingTableAndColumnRefList;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsVendorTheLongAndWindingTableAndColumnDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsVendorTheLongAndWindingTableAndColumnDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public VendorTheLongAndWindingTableAndColumnDto mappingToDto(VendorTheLongAndWindingTableAndColumn entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (VendorTheLongAndWindingTableAndColumnDto)cachedLocalDto;
        }
        VendorTheLongAndWindingTableAndColumnDto dto = new VendorTheLongAndWindingTableAndColumnDto();
        dto.setTheLongAndWindingTableAndColumnId(entity.getTheLongAndWindingTableAndColumnId());
        dto.setTheLongAndWindingTableAndColumnName(entity.getTheLongAndWindingTableAndColumnName());
        dto.setShortName(entity.getShortName());
        dto.setShortSize(entity.getShortSize());
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only a DTO that has a primary key value
            _relationDtoMap.put(localKey, dto);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressVendorTheLongAndWindingTableAndColumnRefList && !entity.getVendorTheLongAndWindingTableAndColumnRefList().isEmpty()) {
            VendorTheLongAndWindingTableAndColumnRefDtoMapper mapper = new VendorTheLongAndWindingTableAndColumnRefDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressVendorTheLongAndWindingTableAndColumn();
            List<VendorTheLongAndWindingTableAndColumnRefDto> relationDtoList = mapper.mappingToDtoList(entity.getVendorTheLongAndWindingTableAndColumnRefList());
            dto.setVendorTheLongAndWindingTableAndColumnRefList(relationDtoList);
            if (reverseReference) {
                for (VendorTheLongAndWindingTableAndColumnRefDto relationDto : relationDtoList) {
                    relationDto.setVendorTheLongAndWindingTableAndColumn(dto);
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<VendorTheLongAndWindingTableAndColumnDto> mappingToDtoList(List<VendorTheLongAndWindingTableAndColumn> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<VendorTheLongAndWindingTableAndColumnDto> dtoList = new ArrayList<VendorTheLongAndWindingTableAndColumnDto>();
        for (VendorTheLongAndWindingTableAndColumn entity : entityList) {
            VendorTheLongAndWindingTableAndColumnDto dto = mappingToDto(entity);
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
    public VendorTheLongAndWindingTableAndColumn mappingToEntity(VendorTheLongAndWindingTableAndColumnDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (VendorTheLongAndWindingTableAndColumn)cachedLocalEntity;
        }
        VendorTheLongAndWindingTableAndColumn entity = new VendorTheLongAndWindingTableAndColumn();
        if (needsMapping(dto, dto.getTheLongAndWindingTableAndColumnId(), "theLongAndWindingTableAndColumnId")) {
            entity.setTheLongAndWindingTableAndColumnId(dto.getTheLongAndWindingTableAndColumnId());
        }
        if (needsMapping(dto, dto.getTheLongAndWindingTableAndColumnName(), "theLongAndWindingTableAndColumnName")) {
            entity.setTheLongAndWindingTableAndColumnName(dto.getTheLongAndWindingTableAndColumnName());
        }
        if (needsMapping(dto, dto.getShortName(), "shortName")) {
            entity.setShortName(dto.getShortName());
        }
        if (needsMapping(dto, dto.getShortSize(), "shortSize")) {
            entity.setShortSize(dto.getShortSize());
        }
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only an entity that has a primary key value
            _relationEntityMap.put(localKey, entity);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressVendorTheLongAndWindingTableAndColumnRefList && !dto.getVendorTheLongAndWindingTableAndColumnRefList().isEmpty()) {
            VendorTheLongAndWindingTableAndColumnRefDtoMapper mapper = new VendorTheLongAndWindingTableAndColumnRefDtoMapper(_relationDtoMap, _relationEntityMap);
            mapper.setReverseReference(reverseReference);
            if (!instanceCache) { mapper.disableInstanceCache(); }
            mapper.suppressVendorTheLongAndWindingTableAndColumn();
            List<VendorTheLongAndWindingTableAndColumnRef> relationEntityList = mapper.mappingToEntityList(dto.getVendorTheLongAndWindingTableAndColumnRefList());
            entity.setVendorTheLongAndWindingTableAndColumnRefList(relationEntityList);
            if (reverseReference) {
                for (VendorTheLongAndWindingTableAndColumnRef relationEntity : relationEntityList) {
                    relationEntity.setVendorTheLongAndWindingTableAndColumn(OptionalEntity.of(entity));
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
    protected boolean needsMapping(VendorTheLongAndWindingTableAndColumnDto dto, Object value, String propName) {
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
    public List<VendorTheLongAndWindingTableAndColumn> mappingToEntityList(List<VendorTheLongAndWindingTableAndColumnDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<VendorTheLongAndWindingTableAndColumn> entityList = new ArrayList<VendorTheLongAndWindingTableAndColumn>();
        for (VendorTheLongAndWindingTableAndColumnDto dto : dtoList) {
            VendorTheLongAndWindingTableAndColumn entity = mappingToEntity(dto);
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
    public void suppressVendorTheLongAndWindingTableAndColumnRefList() {
        _suppressVendorTheLongAndWindingTableAndColumnRefList = true;
    }
    protected void doSuppressAll() { // internal
        suppressVendorTheLongAndWindingTableAndColumnRefList();
    }
    protected void doSuppressClear() { // internal
        _suppressVendorTheLongAndWindingTableAndColumnRefList = false;
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
