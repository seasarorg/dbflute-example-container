package com.example.dbflute.guice.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.optional.OptionalEntity;
import com.example.dbflute.guice.dbflute.allcommon.EntityDefinedCommonColumn;
import com.example.dbflute.guice.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.guice.dbflute.allcommon.CDef;
import com.example.dbflute.guice.dbflute.exentity.*;

/**
 * The entity of (購入支払)PURCHASE_PAYMENT as TABLE. <br />
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
 * [foreign table]
 *     PURCHASE
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     purchase
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long purchasePaymentId = entity.getPurchasePaymentId();
 * Long purchaseId = entity.getPurchaseId();
 * java.math.BigDecimal paymentAmount = entity.getPaymentAmount();
 * org.joda.time.LocalDateTime paymentDatetime = entity.getPaymentDatetime();
 * String paymentMethodCode = entity.getPaymentMethodCode();
 * org.joda.time.LocalDateTime registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * org.joda.time.LocalDateTime updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * entity.setPurchasePaymentId(purchasePaymentId);
 * entity.setPurchaseId(purchaseId);
 * entity.setPaymentAmount(paymentAmount);
 * entity.setPaymentDatetime(paymentDatetime);
 * entity.setPaymentMethodCode(paymentMethodCode);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPurchasePayment implements EntityDefinedCommonColumn, Serializable, Cloneable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** (購入支払ID)PURCHASE_PAYMENT_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _purchasePaymentId;

    /** (購入ID)PURCHASE_ID: {IX, NotNull, BIGINT(19), FK to PURCHASE} */
    protected Long _purchaseId;

    /** (支払金額)PAYMENT_AMOUNT: {NotNull, DECIMAL(10, 2)} */
    protected java.math.BigDecimal _paymentAmount;

    /** (支払日時)PAYMENT_DATETIME: {IX+, NotNull, TIMESTAMP(23, 10)} */
    protected org.joda.time.LocalDateTime _paymentDatetime;

    /** (支払方法コード)PAYMENT_METHOD_CODE: {NotNull, CHAR(3), classification=PaymentMethod} */
    protected String _paymentMethodCode;

    /** REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} */
    protected org.joda.time.LocalDateTime _registerDatetime;

    /** REGISTER_USER: {NotNull, VARCHAR(200)} */
    protected String _registerUser;

    /** UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} */
    protected org.joda.time.LocalDateTime _updateDatetime;

    /** UPDATE_USER: {NotNull, VARCHAR(200)} */
    protected String _updateUser;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The unique-driven properties for this entity. (NotNull) */
    protected final EntityUniqueDrivenProperties __uniqueDrivenProperties = newUniqueDrivenProperties();

    /** The modified properties for this entity. (NotNull) */
    protected final EntityModifiedProperties __modifiedProperties = newModifiedProperties();

    /** Is common column auto set up effective? */
    protected boolean __canCommonColumnAutoSetup = true;

    /** Is the entity created by DBFlute select process? */
    protected boolean __createdBySelect;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "PURCHASE_PAYMENT";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "purchasePayment";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        if (getPurchasePaymentId() == null) { return false; }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public Set<String> myuniqueDrivenProperties() {
        return __uniqueDrivenProperties.getPropertyNames();
    }

    protected EntityUniqueDrivenProperties newUniqueDrivenProperties() {
        return new EntityUniqueDrivenProperties();
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of paymentMethodCode as the classification of PaymentMethod. <br />
     * (支払方法コード)PAYMENT_METHOD_CODE: {NotNull, CHAR(3), classification=PaymentMethod} <br />
     * method of payment for purchase
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.PaymentMethod getPaymentMethodCodeAsPaymentMethod() {
        return CDef.PaymentMethod.codeOf(getPaymentMethodCode());
    }

    /**
     * Set the value of paymentMethodCode as the classification of PaymentMethod. <br />
     * (支払方法コード)PAYMENT_METHOD_CODE: {NotNull, CHAR(3), classification=PaymentMethod} <br />
     * method of payment for purchase
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setPaymentMethodCodeAsPaymentMethod(CDef.PaymentMethod cdef) {
        setPaymentMethodCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of paymentMethodCode as ByHand (HAN). <br />
     * by hand: payment by hand, face-to-face
     */
    public void setPaymentMethodCode_ByHand() {
        setPaymentMethodCodeAsPaymentMethod(CDef.PaymentMethod.ByHand);
    }

    /**
     * Set the value of paymentMethodCode as BankTransfer (BAK). <br />
     * bank transfer: bank transfer payment
     */
    public void setPaymentMethodCode_BankTransfer() {
        setPaymentMethodCodeAsPaymentMethod(CDef.PaymentMethod.BankTransfer);
    }

    /**
     * Set the value of paymentMethodCode as CreditCard (CRC). <br />
     * credit card: credit card payment
     */
    public void setPaymentMethodCode_CreditCard() {
        setPaymentMethodCodeAsPaymentMethod(CDef.PaymentMethod.CreditCard);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of paymentMethodCode ByHand? <br />
     * by hand: payment by hand, face-to-face
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isPaymentMethodCodeByHand() {
        CDef.PaymentMethod cdef = getPaymentMethodCodeAsPaymentMethod();
        return cdef != null ? cdef.equals(CDef.PaymentMethod.ByHand) : false;
    }

    /**
     * Is the value of paymentMethodCode BankTransfer? <br />
     * bank transfer: bank transfer payment
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isPaymentMethodCodeBankTransfer() {
        CDef.PaymentMethod cdef = getPaymentMethodCodeAsPaymentMethod();
        return cdef != null ? cdef.equals(CDef.PaymentMethod.BankTransfer) : false;
    }

    /**
     * Is the value of paymentMethodCode CreditCard? <br />
     * credit card: credit card payment
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isPaymentMethodCodeCreditCard() {
        CDef.PaymentMethod cdef = getPaymentMethodCodeAsPaymentMethod();
        return cdef != null ? cdef.equals(CDef.PaymentMethod.CreditCard) : false;
    }

    /**
     * the most recommended method <br />
     * The group elements:[ByHand]
     * @return The determination, true or false.
     */
    public boolean isPaymentMethodCode_Recommended() {
        CDef.PaymentMethod cdef = getPaymentMethodCodeAsPaymentMethod();
        return cdef != null && cdef.isRecommended();
    }

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
    /**
     * Get the value of the column 'paymentMethodCode' as classification name.
     * @return The string of classification name. (NullAllowed: when the column value is null)
     */
    public String getPaymentMethodCodeName() {
        CDef.PaymentMethod cdef = getPaymentMethodCodeAsPaymentMethod();
        return cdef != null ? cdef.name() : null;
    }

    /**
     * Get the value of the column 'paymentMethodCode' as classification alias.
     * @return The string of classification alias. (NullAllowed: when the column value is null)
     */
    public String getPaymentMethodCodeAlias() {
        CDef.PaymentMethod cdef = getPaymentMethodCodeAsPaymentMethod();
        return cdef != null ? cdef.alias() : null;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** (購入)PURCHASE by my PURCHASE_ID, named 'purchase'. */
    protected OptionalEntity<Purchase> _purchase;

    /**
     * [get] (購入)PURCHASE by my PURCHASE_ID, named 'purchase'.
     * @return The entity of foreign property 'purchase'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<Purchase> getPurchase() {
        if (_purchase != null) { return _purchase; } else { return OptionalEntity.relationEmpty(this, "purchase"); }
    }

    /**
     * [set] (購入)PURCHASE by my PURCHASE_ID, named 'purchase'.
     * @param purchase The entity of foreign property 'purchase'. (NullAllowed)
     */
    public void setPurchase(OptionalEntity<Purchase> purchase) {
        _purchase = purchase;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    /**
     * {@inheritDoc}
     */
    public Set<String> modifiedProperties() {
        return __modifiedProperties.getPropertyNames();
    }

    /**
     * {@inheritDoc}
     */
    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    protected EntityModifiedProperties newModifiedProperties() {
        return new EntityModifiedProperties();
    }

    // ===================================================================================
    //                                                                     Birthplace Mark
    //                                                                     ===============
    /**
     * {@inheritDoc}
     */
    public void markAsSelect() {
        __createdBySelect = true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean createdBySelect() {
        return __createdBySelect;
    }

    // ===================================================================================
    //                                                                       Common Column
    //                                                                       =============
    /**
     * {@inheritDoc}
     */
    public void enableCommonColumnAutoSetup() {
        __canCommonColumnAutoSetup = true;
    }

    /**
     * {@inheritDoc}
     */
    public void disableCommonColumnAutoSetup() {
        __canCommonColumnAutoSetup = false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean canCommonColumnAutoSetup() {
        return __canCommonColumnAutoSetup;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * Determine the object is equal with this. <br />
     * If primary-keys or columns of the other are same as this one, returns true.
     * @param obj The object as other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BsPurchasePayment)) { return false; }
        BsPurchasePayment other = (BsPurchasePayment)obj;
        if (!xSV(getPurchasePaymentId(), other.getPurchasePaymentId())) { return false; }
        return true;
    }
    protected boolean xSV(Object v1, Object v2) {
        return FunCustodial.isSameValue(v1, v2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    public int hashCode() {
        int hs = 17;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, getPurchasePaymentId());
        return hs;
    }
    protected int xCH(int hs, Object vl) {
        return FunCustodial.calculateHashcode(hs, vl);
    }

    /**
     * {@inheritDoc}
     */
    public int instanceHash() {
        return super.hashCode();
    }

    /**
     * Convert to display string of entity's data. (no relation data)
     * @return The display string of all columns and relation existences. (NotNull)
     */
    public String toString() {
        return buildDisplayString(FunCustodial.toClassTitle(this), true, true);
    }

    /**
     * {@inheritDoc}
     */
    public String toStringWithRelation() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        String li = "\n  ";
        if (_purchase != null)
        { sb.append(li).append(xbRDS(_purchase, "purchase")); }
        return sb.toString();
    }
    protected String xbRDS(Entity et, String name) { // buildRelationDisplayString()
        return et.buildDisplayString(name, true, true);
    }
    protected <ET extends Entity> String xbRDS(org.seasar.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    /**
     * {@inheritDoc}
     */
    public String buildDisplayString(String name, boolean column, boolean relation) {
        StringBuilder sb = new StringBuilder();
        if (name != null) { sb.append(name).append(column || relation ? ":" : ""); }
        if (column) { sb.append(buildColumnString()); }
        if (relation) { sb.append(buildRelationString()); }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }
    protected String buildColumnString() {
        StringBuilder sb = new StringBuilder();
        String dm = ", ";
        sb.append(dm).append(getPurchasePaymentId());
        sb.append(dm).append(getPurchaseId());
        sb.append(dm).append(getPaymentAmount());
        sb.append(dm).append(getPaymentDatetime());
        sb.append(dm).append(getPaymentMethodCode());
        sb.append(dm).append(getRegisterDatetime());
        sb.append(dm).append(getRegisterUser());
        sb.append(dm).append(getUpdateDatetime());
        sb.append(dm).append(getUpdateUser());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_purchase != null) { sb.append(cm).append("purchase"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public PurchasePayment clone() {
        try {
            return (PurchasePayment)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (購入支払ID)PURCHASE_PAYMENT_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @return The value of the column 'PURCHASE_PAYMENT_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getPurchasePaymentId() {
        return _purchasePaymentId;
    }

    /**
     * [set] (購入支払ID)PURCHASE_PAYMENT_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * @param purchasePaymentId The value of the column 'PURCHASE_PAYMENT_ID'. (basically NotNull if update: for the constraint)
     */
    public void setPurchasePaymentId(Long purchasePaymentId) {
        __modifiedProperties.addPropertyName("purchasePaymentId");
        _purchasePaymentId = purchasePaymentId;
    }

    /**
     * [get] (購入ID)PURCHASE_ID: {IX, NotNull, BIGINT(19), FK to PURCHASE} <br />
     * @return The value of the column 'PURCHASE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getPurchaseId() {
        return _purchaseId;
    }

    /**
     * [set] (購入ID)PURCHASE_ID: {IX, NotNull, BIGINT(19), FK to PURCHASE} <br />
     * @param purchaseId The value of the column 'PURCHASE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setPurchaseId(Long purchaseId) {
        __modifiedProperties.addPropertyName("purchaseId");
        _purchaseId = purchaseId;
    }

    /**
     * [get] (支払金額)PAYMENT_AMOUNT: {NotNull, DECIMAL(10, 2)} <br />
     * @return The value of the column 'PAYMENT_AMOUNT'. (basically NotNull if selected: for the constraint)
     */
    public java.math.BigDecimal getPaymentAmount() {
        return _paymentAmount;
    }

    /**
     * [set] (支払金額)PAYMENT_AMOUNT: {NotNull, DECIMAL(10, 2)} <br />
     * @param paymentAmount The value of the column 'PAYMENT_AMOUNT'. (basically NotNull if update: for the constraint)
     */
    public void setPaymentAmount(java.math.BigDecimal paymentAmount) {
        __modifiedProperties.addPropertyName("paymentAmount");
        _paymentAmount = paymentAmount;
    }

    /**
     * [get] (支払日時)PAYMENT_DATETIME: {IX+, NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'PAYMENT_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public org.joda.time.LocalDateTime getPaymentDatetime() {
        return _paymentDatetime;
    }

    /**
     * [set] (支払日時)PAYMENT_DATETIME: {IX+, NotNull, TIMESTAMP(23, 10)} <br />
     * @param paymentDatetime The value of the column 'PAYMENT_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setPaymentDatetime(org.joda.time.LocalDateTime paymentDatetime) {
        __modifiedProperties.addPropertyName("paymentDatetime");
        _paymentDatetime = paymentDatetime;
    }

    /**
     * [get] (支払方法コード)PAYMENT_METHOD_CODE: {NotNull, CHAR(3), classification=PaymentMethod} <br />
     * @return The value of the column 'PAYMENT_METHOD_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getPaymentMethodCode() {
        return convertEmptyToNull(_paymentMethodCode);
    }

    /**
     * [set] (支払方法コード)PAYMENT_METHOD_CODE: {NotNull, CHAR(3), classification=PaymentMethod} <br />
     * @param paymentMethodCode The value of the column 'PAYMENT_METHOD_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setPaymentMethodCode(String paymentMethodCode) {
        checkClassificationCode("PAYMENT_METHOD_CODE", CDef.DefMeta.PaymentMethod, paymentMethodCode);
        __modifiedProperties.addPropertyName("paymentMethodCode");
        _paymentMethodCode = paymentMethodCode;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public org.joda.time.LocalDateTime getRegisterDatetime() {
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(org.joda.time.LocalDateTime registerDatetime) {
        __modifiedProperties.addPropertyName("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterUser() {
        return convertEmptyToNull(_registerUser);
    }

    /**
     * [set] REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @param registerUser The value of the column 'REGISTER_USER'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterUser(String registerUser) {
        __modifiedProperties.addPropertyName("registerUser");
        _registerUser = registerUser;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public org.joda.time.LocalDateTime getUpdateDatetime() {
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(org.joda.time.LocalDateTime updateDatetime) {
        __modifiedProperties.addPropertyName("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateUser() {
        return convertEmptyToNull(_updateUser);
    }

    /**
     * [set] UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @param updateUser The value of the column 'UPDATE_USER'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateUser(String updateUser) {
        __modifiedProperties.addPropertyName("updateUser");
        _updateUser = updateUser;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param paymentMethodCode The value of the column 'PAYMENT_METHOD_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingPaymentMethodCode(String paymentMethodCode) {
        setPaymentMethodCode(paymentMethodCode);
    }

    protected String convertEmptyToNull(String value) {
        return FunCustodial.convertEmptyToNull(value);
    }

    protected void checkClassificationCode(String columnDbName, CDef.DefMeta meta, Object value) {
        FunCustodial.checkClassificationCode(this, columnDbName, meta, value);
    }
}
