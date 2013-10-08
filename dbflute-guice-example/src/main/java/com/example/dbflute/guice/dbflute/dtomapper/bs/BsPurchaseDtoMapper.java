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
 * The DTO mapper of (購入)PURCHASE as TABLE. <br />
 * <pre>
 * [primary-key]
 *     PURCHASE_ID
 * 
 * [column]
 *     PURCHASE_ID, MEMBER_ID, PRODUCT_ID, PURCHASE_DATETIME, PURCHASE_COUNT, PURCHASE_PRICE, PAYMENT_COMPLETE_FLG, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     PUBLIC.SEQ_PURCHASE
 * 
 * [identity]
 *     PURCHASE_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign-table]
 *     MEMBER, PRODUCT, SUMMARY_PRODUCT, MEMBER_LOGIN(AsBizManyToOne)
 * 
 * [referrer-table]
 *     
 * 
 * [foreign-property]
 *     member, product, summaryProduct, memberLoginAsBizManyToOne
 * 
 * [referrer-property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPurchaseDtoMapper implements DtoMapper<Purchase, PurchaseDto>, Serializable {

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
    protected boolean _suppressProduct;
    protected boolean _suppressSummaryProduct;
    protected boolean _suppressMemberLoginAsBizManyToOne;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPurchaseDtoMapper() {
        _relationDtoMap = new HashMap<Entity, Object>();
        _relationEntityMap = new HashMap<Object, Entity>();
    }

    public BsPurchaseDtoMapper(Map<Entity, Object> relationDtoMap, Map<Object, Entity> relationEntityMap) {
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
    public PurchaseDto mappingToDto(Purchase entity) {
        if (entity == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Entity localKey = createInstanceKeyEntity(entity);
        Object cachedLocalDto = instanceCache ? _relationDtoMap.get(localKey) : null;
        if (cachedLocalDto != null) {
            return (PurchaseDto)cachedLocalDto;
        }
        PurchaseDto dto = new PurchaseDto();
        dto.setPurchaseId(entity.getPurchaseId());
        dto.setMemberId(entity.getMemberId());
        dto.setProductId(entity.getProductId());
        dto.setPurchaseDatetime(entity.getPurchaseDatetime());
        dto.setPurchaseCount(entity.getPurchaseCount());
        dto.setPurchasePrice(entity.getPurchasePrice());
        dto.setPaymentCompleteFlg(entity.getPaymentCompleteFlg());
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
                    relationDto.getPurchaseList().add(dto);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressPurchaseList();
                MemberDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMember(relationDto);
                if (reverseReference) {
                    relationDto.getPurchaseList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMember());
                }
            }
        };
        if (!_suppressProduct && entity.getProduct() != null) {
            Product relationEntity = entity.getProduct();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                ProductDto relationDto = (ProductDto)cachedDto;
                dto.setProduct(relationDto);
                if (reverseReference) {
                    relationDto.getPurchaseList().add(dto);
                }
            } else {
                ProductDtoMapper mapper = new ProductDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressPurchaseList();
                ProductDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setProduct(relationDto);
                if (reverseReference) {
                    relationDto.getPurchaseList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getProduct());
                }
            }
        };
        if (!_suppressSummaryProduct && entity.getSummaryProduct() != null) {
            SummaryProduct relationEntity = entity.getSummaryProduct();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                SummaryProductDto relationDto = (SummaryProductDto)cachedDto;
                dto.setSummaryProduct(relationDto);
                if (reverseReference) {
                    relationDto.getPurchaseList().add(dto);
                }
            } else {
                SummaryProductDtoMapper mapper = new SummaryProductDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressPurchaseList();
                SummaryProductDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setSummaryProduct(relationDto);
                if (reverseReference) {
                    relationDto.getPurchaseList().add(dto);
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getSummaryProduct());
                }
            }
        };
        if (!_suppressMemberLoginAsBizManyToOne && entity.getMemberLoginAsBizManyToOne() != null) {
            MemberLogin relationEntity = entity.getMemberLoginAsBizManyToOne();
            Entity relationKey = createInstanceKeyEntity(relationEntity);
            Object cachedDto = instanceCache ? _relationDtoMap.get(relationKey) : null;
            if (cachedDto != null) {
                MemberLoginDto relationDto = (MemberLoginDto)cachedDto;
                dto.setMemberLoginAsBizManyToOne(relationDto);
                if (reverseReference) {
                }
            } else {
                MemberLoginDtoMapper mapper = new MemberLoginDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                MemberLoginDto relationDto = mapper.mappingToDto(relationEntity);
                dto.setMemberLoginAsBizManyToOne(relationDto);
                if (reverseReference) {
                }
                if (instanceCache && relationEntity.hasPrimaryKeyValue()) {
                    _relationDtoMap.put(relationKey, dto.getMemberLoginAsBizManyToOne());
                }
            }
        };
        return dto;
    }

    /**
     * {@inheritDoc}
     */
    public List<PurchaseDto> mappingToDtoList(List<Purchase> entityList) {
        if (entityList == null) {
            throw new IllegalArgumentException("The argument 'entityList' should not be null.");
        }
        List<PurchaseDto> dtoList = new ArrayList<PurchaseDto>();
        for (Purchase entity : entityList) {
            PurchaseDto dto = mappingToDto(entity);
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
    public Purchase mappingToEntity(PurchaseDto dto) {
        if (dto == null) {
            return null;
        }
        boolean instanceCache = _instanceCache;
        Object localKey = createInstanceKeyDto(dto, dto.instanceHash());
        Entity cachedLocalEntity = instanceCache ? _relationEntityMap.get(localKey) : null;
        if (cachedLocalEntity != null) {
            return (Purchase)cachedLocalEntity;
        }
        Purchase entity = new Purchase();
        if (needsMapping(dto, dto.getPurchaseId(), "purchaseId")) {
            entity.setPurchaseId(dto.getPurchaseId());
        }
        if (needsMapping(dto, dto.getMemberId(), "memberId")) {
            entity.setMemberId(dto.getMemberId());
        }
        if (needsMapping(dto, dto.getProductId(), "productId")) {
            entity.setProductId(dto.getProductId());
        }
        if (needsMapping(dto, dto.getPurchaseDatetime(), "purchaseDatetime")) {
            entity.setPurchaseDatetime(dto.getPurchaseDatetime());
        }
        if (needsMapping(dto, dto.getPurchaseCount(), "purchaseCount")) {
            entity.setPurchaseCount(dto.getPurchaseCount());
        }
        if (needsMapping(dto, dto.getPurchasePrice(), "purchasePrice")) {
            entity.setPurchasePrice(dto.getPurchasePrice());
        }
        if (needsMapping(dto, dto.getPaymentCompleteFlg(), "paymentCompleteFlg")) {
            entity.setPaymentCompleteFlgAsFlg(CDef.Flg.codeOf(dto.getPaymentCompleteFlg()));
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
                    relationEntity.getPurchaseList().add(entity);
                }
            } else {
                MemberDtoMapper mapper = new MemberDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressPurchaseList();
                Member relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMember(relationEntity);
                if (reverseReference) {
                    relationEntity.getPurchaseList().add(entity);
                }
                if (instanceCache && entity.getMember().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMember());
                }
            }
        };
        if (!_suppressProduct && dto.getProduct() != null) {
            ProductDto relationDto = dto.getProduct();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                Product relationEntity = (Product)cachedEntity;
                entity.setProduct(relationEntity);
                if (reverseReference) {
                    relationEntity.getPurchaseList().add(entity);
                }
            } else {
                ProductDtoMapper mapper = new ProductDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressPurchaseList();
                Product relationEntity = mapper.mappingToEntity(relationDto);
                entity.setProduct(relationEntity);
                if (reverseReference) {
                    relationEntity.getPurchaseList().add(entity);
                }
                if (instanceCache && entity.getProduct().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getProduct());
                }
            }
        };
        if (!_suppressSummaryProduct && dto.getSummaryProduct() != null) {
            SummaryProductDto relationDto = dto.getSummaryProduct();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                SummaryProduct relationEntity = (SummaryProduct)cachedEntity;
                entity.setSummaryProduct(relationEntity);
                if (reverseReference) {
                    relationEntity.getPurchaseList().add(entity);
                }
            } else {
                SummaryProductDtoMapper mapper = new SummaryProductDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                mapper.suppressPurchaseList();
                SummaryProduct relationEntity = mapper.mappingToEntity(relationDto);
                entity.setSummaryProduct(relationEntity);
                if (reverseReference) {
                    relationEntity.getPurchaseList().add(entity);
                }
                if (instanceCache && entity.getSummaryProduct().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getSummaryProduct());
                }
            }
        };
        if (!_suppressMemberLoginAsBizManyToOne && dto.getMemberLoginAsBizManyToOne() != null) {
            MemberLoginDto relationDto = dto.getMemberLoginAsBizManyToOne();
            Object relationKey = createInstanceKeyDto(relationDto, relationDto.instanceHash());
            Entity cachedEntity = instanceCache ? _relationEntityMap.get(relationKey) : null;
            if (cachedEntity != null) {
                MemberLogin relationEntity = (MemberLogin)cachedEntity;
                entity.setMemberLoginAsBizManyToOne(relationEntity);
                if (reverseReference) {
                }
            } else {
                MemberLoginDtoMapper mapper = new MemberLoginDtoMapper(_relationDtoMap, _relationEntityMap);
                mapper.setReverseReference(reverseReference);
                if (!instanceCache) { mapper.disableInstanceCache(); }
                MemberLogin relationEntity = mapper.mappingToEntity(relationDto);
                entity.setMemberLoginAsBizManyToOne(relationEntity);
                if (reverseReference) {
                }
                if (instanceCache && entity.getMemberLoginAsBizManyToOne().hasPrimaryKeyValue()) {
                    _relationEntityMap.put(relationKey, entity.getMemberLoginAsBizManyToOne());
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
    protected boolean needsMapping(PurchaseDto dto, Object value, String propName) {
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
    public List<Purchase> mappingToEntityList(List<PurchaseDto> dtoList) {
        if (dtoList == null) {
            throw new IllegalArgumentException("The argument 'dtoList' should not be null.");
        }
        List<Purchase> entityList = new ArrayList<Purchase>();
        for (PurchaseDto dto : dtoList) {
            Purchase entity = mappingToEntity(dto);
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
    public void suppressProduct() {
        _suppressProduct = true;
    }
    public void suppressSummaryProduct() {
        _suppressSummaryProduct = true;
    }
    public void suppressMemberLoginAsBizManyToOne() {
        _suppressMemberLoginAsBizManyToOne = true;
    }
    protected void doSuppressAll() { // internal
        suppressMember();
        suppressProduct();
        suppressSummaryProduct();
        suppressMemberLoginAsBizManyToOne();
    }
    protected void doSuppressClear() { // internal
        _suppressMember = false;
        _suppressProduct = false;
        _suppressSummaryProduct = false;
        _suppressMemberLoginAsBizManyToOne = false;
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
