/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.dbflute.spring.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import com.example.dbflute.spring.dbflute.allcommon.EntityDefinedCommonColumn;
import com.example.dbflute.spring.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.spring.dbflute.exentity.*;

/**
 * The entity of (会員セキュリティ情報)MEMBER_SECURITY as TABLE. <br />
 * 会員とは one-to-one で、会員一人につき必ず一つのセキュリティ情報がある
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, LOGIN_PASSWORD, REMINDER_QUESTION, REMINDER_ANSWER, REMINDER_USE_COUNT, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign table]
 *     MEMBER
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     member
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer memberId = entity.getMemberId();
 * String loginPassword = entity.getLoginPassword();
 * String reminderQuestion = entity.getReminderQuestion();
 * String reminderAnswer = entity.getReminderAnswer();
 * Integer reminderUseCount = entity.getReminderUseCount();
 * java.sql.Timestamp registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.sql.Timestamp updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setMemberId(memberId);
 * entity.setLoginPassword(loginPassword);
 * entity.setReminderQuestion(reminderQuestion);
 * entity.setReminderAnswer(reminderAnswer);
 * entity.setReminderUseCount(reminderUseCount);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberSecurity extends AbstractEntity implements EntityDefinedCommonColumn {

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
    /** (会員ID)MEMBER_ID: {PK, NotNull, INTEGER(10), FK to MEMBER} */
    protected Integer _memberId;

    /** (ログインパスワード)LOGIN_PASSWORD: {NotNull, VARCHAR(50)} */
    protected String _loginPassword;

    /** (リマインダ質問)REMINDER_QUESTION: {NotNull, VARCHAR(50)} */
    protected String _reminderQuestion;

    /** (リマインダ回答)REMINDER_ANSWER: {NotNull, VARCHAR(50)} */
    protected String _reminderAnswer;

    /** (リマインダ利用回数)REMINDER_USE_COUNT: {NotNull, INTEGER(10)} */
    protected Integer _reminderUseCount;

    /** REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _registerDatetime;

    /** REGISTER_USER: {NotNull, VARCHAR(200)} */
    protected String _registerUser;

    /** UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} */
    protected java.sql.Timestamp _updateDatetime;

    /** UPDATE_USER: {NotNull, VARCHAR(200)} */
    protected String _updateUser;

    /** VERSION_NO: {NotNull, BIGINT(19)} */
    protected Long _versionNo;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** Is common column auto set up effective? */
    protected boolean __canCommonColumnAutoSetup = true;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "MEMBER_SECURITY";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "memberSecurity";
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
        if (getMemberId() == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** (会員)MEMBER by my MEMBER_ID, named 'member'. */
    protected Member _member;

    /**
     * [get] (会員)MEMBER by my MEMBER_ID, named 'member'.
     * @return The entity of foreign property 'member'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMember() {
        return _member;
    }

    /**
     * [set] (会員)MEMBER by my MEMBER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(Member member) {
        _member = member;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
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
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsMemberSecurity) {
            BsMemberSecurity other = (BsMemberSecurity)obj;
            if (!xSV(_memberId, other._memberId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, _memberId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_member != null)
        { sb.append(li).append(xbRDS(_member, "member")); }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_memberId));
        sb.append(dm).append(xfND(_loginPassword));
        sb.append(dm).append(xfND(_reminderQuestion));
        sb.append(dm).append(xfND(_reminderAnswer));
        sb.append(dm).append(xfND(_reminderUseCount));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerUser));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateUser));
        sb.append(dm).append(xfND(_versionNo));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_member != null)
        { sb.append(dm).append("member"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public MemberSecurity clone() {
        return (MemberSecurity)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ID)MEMBER_ID: {PK, NotNull, INTEGER(10), FK to MEMBER} <br />
     * そのまま one-to-one を構成するためのFKとなる。
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMemberId() {
        checkSpecifiedProperty("memberId");
        return _memberId;
    }

    /**
     * [set] (会員ID)MEMBER_ID: {PK, NotNull, INTEGER(10), FK to MEMBER} <br />
     * そのまま one-to-one を構成するためのFKとなる。
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Integer memberId) {
        registerModifiedProperty("memberId");
        _memberId = memberId;
    }

    /**
     * [get] (ログインパスワード)LOGIN_PASSWORD: {NotNull, VARCHAR(50)} <br />
     * ログイン時に利用するパスワード。<br />
     * 本当は良くないが、Exampleなのでひとまず暗号化していない。
     * @return The value of the column 'LOGIN_PASSWORD'. (basically NotNull if selected: for the constraint)
     */
    public String getLoginPassword() {
        checkSpecifiedProperty("loginPassword");
        return _loginPassword;
    }

    /**
     * [set] (ログインパスワード)LOGIN_PASSWORD: {NotNull, VARCHAR(50)} <br />
     * ログイン時に利用するパスワード。<br />
     * 本当は良くないが、Exampleなのでひとまず暗号化していない。
     * @param loginPassword The value of the column 'LOGIN_PASSWORD'. (basically NotNull if update: for the constraint)
     */
    public void setLoginPassword(String loginPassword) {
        registerModifiedProperty("loginPassword");
        _loginPassword = loginPassword;
    }

    /**
     * [get] (リマインダ質問)REMINDER_QUESTION: {NotNull, VARCHAR(50)} <br />
     * パスワードを忘れた際のリマインダ機能における質問の内容。
     * @return The value of the column 'REMINDER_QUESTION'. (basically NotNull if selected: for the constraint)
     */
    public String getReminderQuestion() {
        checkSpecifiedProperty("reminderQuestion");
        return _reminderQuestion;
    }

    /**
     * [set] (リマインダ質問)REMINDER_QUESTION: {NotNull, VARCHAR(50)} <br />
     * パスワードを忘れた際のリマインダ機能における質問の内容。
     * @param reminderQuestion The value of the column 'REMINDER_QUESTION'. (basically NotNull if update: for the constraint)
     */
    public void setReminderQuestion(String reminderQuestion) {
        registerModifiedProperty("reminderQuestion");
        _reminderQuestion = reminderQuestion;
    }

    /**
     * [get] (リマインダ回答)REMINDER_ANSWER: {NotNull, VARCHAR(50)} <br />
     * パスワードを忘れた際のリマインダ機能における質問の答え。
     * @return The value of the column 'REMINDER_ANSWER'. (basically NotNull if selected: for the constraint)
     */
    public String getReminderAnswer() {
        checkSpecifiedProperty("reminderAnswer");
        return _reminderAnswer;
    }

    /**
     * [set] (リマインダ回答)REMINDER_ANSWER: {NotNull, VARCHAR(50)} <br />
     * パスワードを忘れた際のリマインダ機能における質問の答え。
     * @param reminderAnswer The value of the column 'REMINDER_ANSWER'. (basically NotNull if update: for the constraint)
     */
    public void setReminderAnswer(String reminderAnswer) {
        registerModifiedProperty("reminderAnswer");
        _reminderAnswer = reminderAnswer;
    }

    /**
     * [get] (リマインダ利用回数)REMINDER_USE_COUNT: {NotNull, INTEGER(10)} <br />
     * リマインダを利用した回数。<br />
     * これが多いと忘れっぽい会員と言えるが、そんなことを知ってもしょうがない。
     * @return The value of the column 'REMINDER_USE_COUNT'. (basically NotNull if selected: for the constraint)
     */
    public Integer getReminderUseCount() {
        checkSpecifiedProperty("reminderUseCount");
        return _reminderUseCount;
    }

    /**
     * [set] (リマインダ利用回数)REMINDER_USE_COUNT: {NotNull, INTEGER(10)} <br />
     * リマインダを利用した回数。<br />
     * これが多いと忘れっぽい会員と言えるが、そんなことを知ってもしょうがない。
     * @param reminderUseCount The value of the column 'REMINDER_USE_COUNT'. (basically NotNull if update: for the constraint)
     */
    public void setReminderUseCount(Integer reminderUseCount) {
        registerModifiedProperty("reminderUseCount");
        _reminderUseCount = reminderUseCount;
    }

    /**
     * [get] REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] REGISTER_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.sql.Timestamp registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'REGISTER_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterUser() {
        checkSpecifiedProperty("registerUser");
        return _registerUser;
    }

    /**
     * [set] REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * @param registerUser The value of the column 'REGISTER_USER'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterUser(String registerUser) {
        registerModifiedProperty("registerUser");
        _registerUser = registerUser;
    }

    /**
     * [get] UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] UPDATE_DATETIME: {NotNull, TIMESTAMP(23, 10)} <br />
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.sql.Timestamp updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'UPDATE_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateUser() {
        checkSpecifiedProperty("updateUser");
        return _updateUser;
    }

    /**
     * [set] UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * @param updateUser The value of the column 'UPDATE_USER'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateUser(String updateUser) {
        registerModifiedProperty("updateUser");
        _updateUser = updateUser;
    }

    /**
     * [get] VERSION_NO: {NotNull, BIGINT(19)} <br />
     * @return The value of the column 'VERSION_NO'. (basically NotNull if selected: for the constraint)
     */
    public Long getVersionNo() {
        checkSpecifiedProperty("versionNo");
        return _versionNo;
    }

    /**
     * [set] VERSION_NO: {NotNull, BIGINT(19)} <br />
     * @param versionNo The value of the column 'VERSION_NO'. (basically NotNull if update: for the constraint)
     */
    public void setVersionNo(Long versionNo) {
        registerModifiedProperty("versionNo");
        _versionNo = versionNo;
    }
}
