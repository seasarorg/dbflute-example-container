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
import com.example.dbflute.guice.dbflute.allcommon.CDef;
import com.example.dbflute.guice.dbflute.exentity.*;
import com.example.dbflute.guice.simpleflute.dto.*;
import com.example.dbflute.guice.dbflute.dtomapper.*;

/**
 * The DTO mapper of (購入支払)PURCHASE_PAYMENT as TABLE. <br />
 * <pre>
 * [primary-key]
 *     PURCHASE_PAYMENT_ID
 * 
 * [column]
 *     PURCHASE_PAYMENT_ID, PURCHASE_ID, PAYMENT_AMOUNT, PAYMENT_DATETIME, PAYMENT_METHOD_CODE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     PURCHASE_PAYMENT_ID
 * 
 * [version-no]
 *     
 * 
 * [foreign-table]
 *     PURCHASE
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     purchase
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPurchasePaymentDtoMapper implements DtoMapper<PurchasePayment, PurchasePaymentDto>, Serializable {

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
    protected boolean _suppressPurchase;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPurchasePaymentDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsPurchasePaymentDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public PurchasePaymentDto mappingToDto(PurchasePayment entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (PurchasePaymentDto)cachedLocalDto;
        }
        PurchasePaymentDto dto = new PurchasePaymentDto();
        dto.setPurchasePaymentId(entity.getPurchasePaymentId());
        dto.setPurchaseId(entity.getPurchaseId());
        dto.setPaymentAmount(entity.getPaymentAmount());
        dto.setPaymentDatetime(entity.getPaymentDatetime());
        dto.setPaymentMethodCode(entity.getPaymentMethodCode());
        dto.setRegisterDatetime(entity.getRegisterDatetime());
        dto.setRegisterUser(entity.getRegisterUser());
        dto.setUpdateDatetime(entity.getUpdateDatetime());
        dto.setUpdateUser(entity.getUpdateUser());
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only a DTO that has a primary key value
            _relationDtoMap.put(localKey, dto);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressPurchase && entity.getPurchase().isPresent()) {
            Purchase relationEntity = entity.getPurchase().get();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                PurchaseDto relationDto = (PurchaseDto)cachedDto;
                dto.setPurchase(relationDto);
                if (reverseReference) {
                    relationDto.getPurchasePaymentList().add(dto);
                }
            } else {
                PurchaseDtoMapper mapper = new PurchaseDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressPurchasePaymentList();
                PurchaseDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setPurchase(relationDto);
                if (reverseReference) {
                    relationDto.getPurchasePaymentList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getPurchase());
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<PurchasePaymentDto> mappingToDtoList(List<PurchasePayment> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<PurchasePaymentDto> dtoList = new ArrayList<PurchasePaymentDto>();
        for (PurchasePayment entity : entityList) {
            PurchasePaymentDto dto = mappingToDto(entity);
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
    public PurchasePayment mappingToEntity(PurchasePaymentDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (PurchasePayment)cachedLocalEntity;
        }
        PurchasePayment entity = new PurchasePayment();
        if (needsMapping(dto, dto.getPurchasePaymentId(), "purchasePaymentId")) {
            entity.setPurchasePaymentId(dto.getPurchasePaymentId());
        }
        if (needsMapping(dto, dto.getPurchaseId(), "purchaseId")) {
            entity.setPurchaseId(dto.getPurchaseId());
        }
        if (needsMapping(dto, dto.getPaymentAmount(), "paymentAmount")) {
            entity.setPaymentAmount(dto.getPaymentAmount());
        }
        if (needsMapping(dto, dto.getPaymentDatetime(), "paymentDatetime")) {
            entity.setPaymentDatetime(dto.getPaymentDatetime());
        }
        if (needsMapping(dto, dto.getPaymentMethodCode(), "paymentMethodCode")) {
            entity.setPaymentMethodCodeAsPaymentMethod(CDef.PaymentMethod.codeOf(dto.getPaymentMethodCode()));
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
        if (instanceCache && entity.hasPrimaryKeyValue()) { // caches only an entity that has a primary key value
            _relationEntityMap.put(localKey, entity);
        }
        boolean reverseReference = _reverseReference;
        if (!_suppressPurchase && dto.getPurchase() != null) {
            PurchaseDto relationDto = dto.getPurchase();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                Purchase relationEntity = (Purchase)cachedEntity;
                entity.setPurchase(OptionalEntity.of(relationEntity));
                if (reverseReference) {
                    relationEntity.getPurchasePaymentList().add(entity);
                }
            } else {
                PurchaseDtoMapper mapper = new PurchaseDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressPurchasePaymentList();
                Purchase relationEntity = mapper.mappingToEntity(relationDto);
                entity.setPurchase(OptionalEntity.of(relationEntity));
                if (reverseReference) {
                    relationEntity.getPurchasePaymentList().add(entity);
                }
                if (instanceCache && entity.getPurchase().get().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getPurchase().get());
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
    protected boolean needsMapping(PurchasePaymentDto dto, Object value, String propName) {
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
    public List<PurchasePayment> mappingToEntityList(List<PurchasePaymentDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<PurchasePayment> entityList = new ArrayList<PurchasePayment>();
        for (PurchasePaymentDto dto : dtoList) {
            PurchasePayment entity = mappingToEntity(dto);
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
    public void suppressPurchase() {
        _suppressPurchase = true;
    }
    protected void doSuppressAll() { // internal
        suppressPurchase();
    }
    protected void doSuppressClear() { // internal
        _suppressPurchase = false;
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
