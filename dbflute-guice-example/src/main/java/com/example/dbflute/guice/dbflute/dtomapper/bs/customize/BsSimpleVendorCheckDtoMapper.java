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
 * The DTO mapper of SimpleVendorCheck. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     VENDOR_CHECK_ID, TYPE_OF_TEXT, TYPE_OF_BOOLEAN, TYPE_OF_NUMERIC_INTEGER, TYPE_OF_NUMERIC_BIGINT, TYPE_OF_NUMERIC_DECIMAL, TYPE_OF_NUMERIC_INTEGER_MIN, TYPE_OF_NUMERIC_INTEGER_MAX, TYPE_OF_NUMERIC_BIGINT_MIN, TYPE_OF_NUMERIC_BIGINT_MAX, TYPE_OF_NUMERIC_SUPERINT_MIN, TYPE_OF_NUMERIC_SUPERINT_MAX, TYPE_OF_NUMERIC_MAXDECIMAL, TYPE_OF_BLOB
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
public abstract class BsSimpleVendorCheckDtoMapper implements DtoMapper<SimpleVendorCheck, SimpleVendorCheckDto>, Serializable {

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
    public BsSimpleVendorCheckDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsSimpleVendorCheckDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public SimpleVendorCheckDto mappingToDto(SimpleVendorCheck entity) {
        if (entity == null) {
            return null;
        }
        SimpleVendorCheckDto dto = new SimpleVendorCheckDto();
        dto.setVendorCheckId(entity.getVendorCheckId());
        dto.setTypeOfText(entity.getTypeOfText());
        dto.setTypeOfBoolean(entity.getTypeOfBoolean());
        dto.setTypeOfNumericInteger(entity.getTypeOfNumericInteger());
        dto.setTypeOfNumericBigint(entity.getTypeOfNumericBigint());
        dto.setTypeOfNumericDecimal(entity.getTypeOfNumericDecimal());
        dto.setTypeOfNumericIntegerMin(entity.getTypeOfNumericIntegerMin());
        dto.setTypeOfNumericIntegerMax(entity.getTypeOfNumericIntegerMax());
        dto.setTypeOfNumericBigintMin(entity.getTypeOfNumericBigintMin());
        dto.setTypeOfNumericBigintMax(entity.getTypeOfNumericBigintMax());
        dto.setTypeOfNumericSuperintMin(entity.getTypeOfNumericSuperintMin());
        dto.setTypeOfNumericSuperintMax(entity.getTypeOfNumericSuperintMax());
        dto.setTypeOfNumericMaxdecimal(entity.getTypeOfNumericMaxdecimal());
        dto.setTypeOfBlob(entity.getTypeOfBlob());
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<SimpleVendorCheckDto> mappingToDtoList(List<SimpleVendorCheck> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<SimpleVendorCheckDto> dtoList = new ArrayList<SimpleVendorCheckDto>();
        for (SimpleVendorCheck entity : entityList) {
            SimpleVendorCheckDto dto = mappingToDto(entity);
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
    public SimpleVendorCheck mappingToEntity(SimpleVendorCheckDto dto) {
        if (dto == null) {
            return null;
        }
        SimpleVendorCheck entity = new SimpleVendorCheck();
        if (needsMapping(dto, dto.getVendorCheckId(), "vendorCheckId")) {
            entity.setVendorCheckId(dto.getVendorCheckId());
        }
        if (needsMapping(dto, dto.getTypeOfText(), "typeOfText")) {
            entity.setTypeOfText(dto.getTypeOfText());
        }
        if (needsMapping(dto, dto.getTypeOfBoolean(), "typeOfBoolean")) {
            entity.setTypeOfBoolean(dto.getTypeOfBoolean());
        }
        if (needsMapping(dto, dto.getTypeOfNumericInteger(), "typeOfNumericInteger")) {
            entity.setTypeOfNumericInteger(dto.getTypeOfNumericInteger());
        }
        if (needsMapping(dto, dto.getTypeOfNumericBigint(), "typeOfNumericBigint")) {
            entity.setTypeOfNumericBigint(dto.getTypeOfNumericBigint());
        }
        if (needsMapping(dto, dto.getTypeOfNumericDecimal(), "typeOfNumericDecimal")) {
            entity.setTypeOfNumericDecimal(dto.getTypeOfNumericDecimal());
        }
        if (needsMapping(dto, dto.getTypeOfNumericIntegerMin(), "typeOfNumericIntegerMin")) {
            entity.setTypeOfNumericIntegerMin(dto.getTypeOfNumericIntegerMin());
        }
        if (needsMapping(dto, dto.getTypeOfNumericIntegerMax(), "typeOfNumericIntegerMax")) {
            entity.setTypeOfNumericIntegerMax(dto.getTypeOfNumericIntegerMax());
        }
        if (needsMapping(dto, dto.getTypeOfNumericBigintMin(), "typeOfNumericBigintMin")) {
            entity.setTypeOfNumericBigintMin(dto.getTypeOfNumericBigintMin());
        }
        if (needsMapping(dto, dto.getTypeOfNumericBigintMax(), "typeOfNumericBigintMax")) {
            entity.setTypeOfNumericBigintMax(dto.getTypeOfNumericBigintMax());
        }
        if (needsMapping(dto, dto.getTypeOfNumericSuperintMin(), "typeOfNumericSuperintMin")) {
            entity.setTypeOfNumericSuperintMin(dto.getTypeOfNumericSuperintMin());
        }
        if (needsMapping(dto, dto.getTypeOfNumericSuperintMax(), "typeOfNumericSuperintMax")) {
            entity.setTypeOfNumericSuperintMax(dto.getTypeOfNumericSuperintMax());
        }
        if (needsMapping(dto, dto.getTypeOfNumericMaxdecimal(), "typeOfNumericMaxdecimal")) {
            entity.setTypeOfNumericMaxdecimal(dto.getTypeOfNumericMaxdecimal());
        }
        if (needsMapping(dto, dto.getTypeOfBlob(), "typeOfBlob")) {
            entity.setTypeOfBlob(dto.getTypeOfBlob());
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
    protected boolean needsMapping(SimpleVendorCheckDto dto, Object value, String propName) {
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
    public List<SimpleVendorCheck> mappingToEntityList(List<SimpleVendorCheckDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<SimpleVendorCheck> entityList = new ArrayList<SimpleVendorCheck>();
        for (SimpleVendorCheckDto dto : dtoList) {
            SimpleVendorCheck entity = mappingToEntity(dto);
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
