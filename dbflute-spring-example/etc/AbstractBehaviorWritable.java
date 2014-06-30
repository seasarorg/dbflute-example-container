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
package org.seasar.dbflute.bhv;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.bhv.core.CommonColumnAutoSetupper;
import org.seasar.dbflute.bhv.core.command.AbstractListEntityCommand;
import org.seasar.dbflute.bhv.core.command.BatchDeleteCommand;
import org.seasar.dbflute.bhv.core.command.BatchDeleteNonstrictCommand;
import org.seasar.dbflute.bhv.core.command.BatchInsertCommand;
import org.seasar.dbflute.bhv.core.command.BatchUpdateCommand;
import org.seasar.dbflute.bhv.core.command.BatchUpdateNonstrictCommand;
import org.seasar.dbflute.bhv.core.command.DeleteEntityCommand;
import org.seasar.dbflute.bhv.core.command.DeleteNonstrictEntityCommand;
import org.seasar.dbflute.bhv.core.command.QueryDeleteCBCommand;
import org.seasar.dbflute.bhv.core.command.QueryInsertCBCommand;
import org.seasar.dbflute.bhv.core.command.QueryUpdateCBCommand;
import org.seasar.dbflute.bhv.core.command.UpdateEntityCommand;
import org.seasar.dbflute.bhv.core.command.UpdateNonstrictEntityCommand;
import org.seasar.dbflute.cbean.AbstractConditionBean;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.info.ColumnInfo;
import org.seasar.dbflute.exception.BatchEntityAlreadyUpdatedException;
import org.seasar.dbflute.exception.EntityAlreadyDeletedException;
import org.seasar.dbflute.exception.EntityAlreadyExistsException;
import org.seasar.dbflute.exception.EntityAlreadyUpdatedException;
import org.seasar.dbflute.exception.EntityDuplicatedException;
import org.seasar.dbflute.exception.IllegalBehaviorStateException;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import org.seasar.dbflute.exception.NonQueryDeleteNotAllowedException;
import org.seasar.dbflute.exception.NonQueryUpdateNotAllowedException;
import org.seasar.dbflute.exception.OptimisticLockColumnValueNullException;
import org.seasar.dbflute.exception.factory.ExceptionMessageBuilder;
import org.seasar.dbflute.resource.ResourceContext;

/**
 * The abstract class of writable behavior.
 * @param <CB> The type of conditionBean.
 * @param <ENTITY> The type of entity.
 * @author jflute
 */
public abstract class AbstractBehaviorWritable<CB extends ConditionBean, ENTITY extends Entity>
        extends
            AbstractBehaviorReadable<CB, ENTITY> implements BehaviorWritable<CB, ENTITY> {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The auto-set-upper of common column. (NotNull) */
    protected CommonColumnAutoSetupper _commonColumnAutoSetupper;

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    // -----------------------------------------------------
    //                                                Create
    //                                                ------
    /**
     * {@inheritDoc}
     */
    public void create(ENTITY entity, InsertOption<CB> option) {
        doCreate(entity, option);
    }

    // -----------------------------------------------------
    //                                                Modify
    //                                                ------
    /**
     * {@inheritDoc}
     */
    public void modify(ENTITY entity, UpdateOption<CB> option) {
        doModify(entity, option);
    }

    /**
     * {@inheritDoc}
     */
    public void modifyNonstrict(ENTITY entity, UpdateOption<CB> option) {
        doModifyNonstrict(entity, option);
    }

    /**
     * {@inheritDoc}
     */
    public void createOrModify(ENTITY entity, InsertOption<CB> insertOption,
            UpdateOption<CB> updateOption) {
        doCreateOrModify(entity, insertOption, updateOption);
    }

    /**
     * {@inheritDoc}
     */
    public void createOrModifyNonstrict(ENTITY entity, InsertOption<CB> insertOption,
            UpdateOption<CB> updateOption) {
        doCreateOrModifyNonstrict(entity, insertOption, updateOption);
    }

    // -----------------------------------------------------
    //                                                Remove
    //                                                ------
    /**
     * {@inheritDoc}
     */
    public void remove(ENTITY entity, DeleteOption<CB> option) {
        doRemove(entity, option);
    }

    /**
     * {@inheritDoc}
     */
    public void removeNonstrict(ENTITY entity, DeleteOption<CB> option) {
        doRemoveNonstrict(entity, option);
    }

    // ===================================================================================
    //                                                       Entity Update Internal Helper
    //                                                       =============================
    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected void helpUpdateInternally(ENTITY entity,
            UpdateOption<CB> option) {
        assertEntityNotNull(entity);
        assertEntityHasOptimisticLockValue(entity);
        final int updatedCount = delegateUpdate(entity, option);
        if (updatedCount == 0) {
            throwUpdateEntityAlreadyDeletedException(entity);
        } else if (updatedCount > 1) {
            throwUpdateEntityDuplicatedException(entity, updatedCount);
        }
    }

    protected void helpUpdateNonstrictInternally(ENTITY entity,
            UpdateOption<CB> option) {
        assertEntityNotNull(entity);
        final int updatedCount = delegateUpdateNonstrict(entity, option);
        if (updatedCount == 0) {
            throwUpdateEntityAlreadyDeletedException(entity);
        } else if (updatedCount > 1) {
            throwUpdateEntityDuplicatedException(entity, updatedCount);
        }
    }

    protected static interface InternalUpdateNonstrictCallback<ENTITY> {
        public int callbackDelegateUpdateNonstrict(ENTITY entity);
    }

    protected void throwUpdateEntityAlreadyDeletedException(ENTITY entity) {
        createBhvExThrower().throwUpdateEntityAlreadyDeletedException(entity);
    }

    protected void throwUpdateEntityDuplicatedException(ENTITY entity, int count) {
        createBhvExThrower().throwUpdateEntityDuplicatedException(entity, count);
    }

    // -----------------------------------------------------
    //                                        InsertOrUpdate
    //                                        --------------
    protected void helpInsertOrUpdateInternally(ENTITY entity,
            InsertOption<CB> insOption, UpdateOption<CB> updOption) {
        assertEntityNotNull(entity);
        if (helpDetermineInsertOrUpdateDirectInsert(entity)) {
            doCreate(entity, insOption);
            return;
        }
        RuntimeException updateException = null;
        try {
            doModify(entity, updOption);
        } catch (EntityAlreadyUpdatedException e) { // already updated (or means not found)
            updateException = e;
        } catch (EntityAlreadyDeletedException e) { // means not found
            updateException = e;
        } catch (OptimisticLockColumnValueNullException e) { // means insert?
            updateException = e;
        }
        if (updateException == null) {
            return;
        }
        final CB cb = (CB) newConditionBean();
        final Set<String> uniqueDrivenProperties = entity.myuniqueDrivenProperties();
        if (uniqueDrivenProperties != null && !uniqueDrivenProperties.isEmpty()) {
            for (String prop : uniqueDrivenProperties) {
                final DBMeta dbmeta = entity.getDBMeta();
                final ColumnInfo columnInfo = dbmeta.findColumnInfo(prop);
                final Object value = columnInfo.read(entity); // already checked in update process
                cb.localCQ().invokeQueryEqual(columnInfo.getColumnDbName(), value);
            }
        } else {
            cb.acceptPrimaryKeyMap(getDBMeta().extractPrimaryKeyMap(entity));
        }
        if (readCount(cb) == 0) { // anyway if not found, insert
            doCreate(entity, insOption);
        } else {
            throw updateException;
        }
    }

    protected void helpInsertOrUpdateNonstrictInternally(ENTITY entity,
            InsertOption<CB> insOption, UpdateOption<CB> updOption) {
        assertEntityNotNull(entity);
        if (helpDetermineInsertOrUpdateDirectInsert(entity)) {
            doCreate(entity, insOption);
        } else {
            try {
                doModifyNonstrict(entity, updOption);
            } catch (EntityAlreadyDeletedException ignored) { // means not found
                doCreate(entity, insOption);
            }
        }
    }

    protected boolean helpDetermineInsertOrUpdateDirectInsert(Entity entity) {
        final Set<String> uniqueDrivenProperties = entity.myuniqueDrivenProperties();
        if (uniqueDrivenProperties != null && !uniqueDrivenProperties.isEmpty()) {
            return false;
        }
        return !entity.hasPrimaryKeyValue();
    }

    // -----------------------------------------------------
    //                                                Delete
    //                                                ------
    protected void helpDeleteInternally(ENTITY entity,
            DeleteOption<CB> option) {
        assertEntityNotNull(entity);
        assertEntityHasOptimisticLockValue(entity);
        final int deletedCount = delegateDelete(entity, option);
        if (deletedCount == 0) {
            throwUpdateEntityAlreadyDeletedException(entity);
        } else if (deletedCount > 1) {
            throwUpdateEntityDuplicatedException(entity, deletedCount);
        }
    }

    protected void helpDeleteNonstrictInternally(ENTITY entity,
            DeleteOption<CB> option) {
        assertEntityNotNull(entity);
        final int deletedCount = delegateDeleteNonstrict(entity, option);
        if (deletedCount == 0) {
            throwUpdateEntityAlreadyDeletedException(entity);
        } else if (deletedCount > 1) {
            throwUpdateEntityDuplicatedException(entity, deletedCount);
        }
    }

    protected void helpDeleteNonstrictIgnoreDeletedInternally(ENTITY entity,
            DeleteOption<CB> option) {
        assertEntityNotNull(entity);
        final int deletedCount = delegateDeleteNonstrict(entity, option);
        if (deletedCount == 0) {
            return;
        } else if (deletedCount > 1) {
            throwUpdateEntityDuplicatedException(entity, deletedCount);
        }
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * {@inheritDoc}
     */
    public int[] lumpCreate(List<ENTITY> entityList, InsertOption<CB> option) {
        final List<ENTITY> castList = entityList;
        return doLumpCreate(castList, option);
    }

    /**
     * {@inheritDoc}
     */
    public int[] lumpModify(List<ENTITY> entityList, UpdateOption<CB> option) {
        final List<ENTITY> castList = entityList;
        return doLumpModify(castList, option);
    }

    /**
     * {@inheritDoc}
     */
    public int[] lumpModifyNonstrict(List<ENTITY> entityList, UpdateOption<CB> option) {
        return doLumpModifyNonstrict(entityList, option);
    }

    /**
     * {@inheritDoc}
     */
    public int[] lumpRemove(List<ENTITY> entityList, DeleteOption<CB> option) {
        return doLumpRemove(entityList, option);
    }

    /**
     * {@inheritDoc}
     */
    public int[] lumpRemoveNonstrict(List<ENTITY> entityList, DeleteOption<CB> option) {
        return doLumpRemoveNonstrict(entityList, option);
    }

    // =====================================================================================
    //                                                                          Query Update
    //                                                                          ============
    /**
     * {@inheritDoc}
     */
    public int rangeCreate(QueryInsertSetupper<ENTITY, CB> setupper,
            InsertOption<CB> option) {
        return doRangeCreate(setupper, option);
    }

    /**
     * {@inheritDoc}
     */
    public int rangeModify(ENTITY entity, CB cb, UpdateOption<CB> option) {
        return doRangeModify(entity, cb, option);
    }

    /**
     * {@inheritDoc}
     */
    public int rangeRemove(CB cb, DeleteOption<CB> option) {
        return doRangeRemove(cb, option);
    }

    /**
     * Check record count before QueryUpdate if it needs. (against MySQL's deadlock of next-key lock)
     * @param cb The condition-bean for QueryUpdate. (NotNull)
     * @return true if record count exists or no check.
     */
    protected boolean checkCountBeforeQueryUpdateIfNeeds(CB cb) {
        final boolean countExists;
        if (cb.isCheckCountBeforeQueryUpdate()) {
            countExists = readCount(cb) > 0;
        } else {
            countExists = true; // means no check
        }
        return countExists;
    }

    // =====================================================================================
    //                                                                        Process Method
    //                                                                        ==============
    // -----------------------------------------------------
    //                                                Insert
    //                                                ------
    /**
     * Process before insert. </br >
     * You can stop the process by your extension.
     * @param entity The entity for insert. (NotNull)
     * @param option The option of insert. (NullAllowed)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeInsert(ENTITY entity, InsertOption<CB> option) {
        assertEntityNotNull(entity); // primary key is checked later
        frameworkFilterEntityOfInsert(entity, option);
        filterEntityOfInsert(entity, option);
        assertEntityOfInsert(entity, option);
        // check primary key after filtering at an insert process
        // because a primary key value may be set in filtering process
        // (for example, sequence)
        if (!entity.getDBMeta().hasIdentity()) { // identity does not need primary key value here
            assertEntityNotNullAndHasPrimaryKeyValue(entity);
        }
        return true;
    }

    /**
     * Process before query-insert. </br >
     * You can stop the process by your extension.
     * @param entity The entity for query-insert. (NotNull)
     * @param intoCB The condition-bean for inserted table. (NotNull)
     * @param resourceCB The condition-bean for resource table. (NotNull)
     * @param option The option of insert. (NullAllowed)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeQueryInsert(ENTITY entity, CB intoCB, ConditionBean resourceCB,
            InsertOption<CB> option) {
        assertEntityNotNull(entity); // query-insert doesn't need to check primary key
        assertObjectNotNull("intoCB", intoCB);
        if (resourceCB == null) {
            String msg = "The set-upper of query-insert should return a condition-bean for resource table:";
            msg = msg + " inserted=" + entity.getTableDbName();
            throw new IllegalConditionBeanOperationException(msg);
        }
        frameworkFilterEntityOfInsert(entity, option);
        setupExclusiveControlColumnOfQueryInsert(entity);
        filterEntityOfInsert(entity, option);
        assertEntityOfInsert(entity, option);
        return true;
    }

    protected void setupExclusiveControlColumnOfQueryInsert(ENTITY entity) {
        final DBMeta dbmeta = getDBMeta();
        if (dbmeta.hasVersionNo()) {
            final ColumnInfo columnInfo = dbmeta.getVersionNoColumnInfo();
            columnInfo.write(entity, InsertOption.VERSION_NO_FIRST_VALUE);
        }
        if (dbmeta.hasUpdateDate()) {
            final ColumnInfo columnInfo = dbmeta.getUpdateDateColumnInfo();
            columnInfo.write(entity, ResourceContext.getAccessTimestamp());
        }
    }

    /**
     * {Framework Method} Filter the entity of insert.
     * @param entity The entity for insert. (NotNull)
     * @param option The option of insert. (NullAllowed)
     */
    protected void frameworkFilterEntityOfInsert(Entity entity, InsertOption<CB> option) {
        injectSequenceToPrimaryKeyIfNeeds(entity);
        setupCommonColumnOfInsertIfNeeds(entity, option);
    }

    /**
     * Set up common columns of insert if it needs.
     * @param entity The entity for insert. (NotNull)
     * @param option The option of insert. (NullAllowed)
     */
    protected void setupCommonColumnOfInsertIfNeeds(Entity entity, InsertOption<CB> option) {
        if (option != null && option.isCommonColumnAutoSetupDisabled()) {
            return;
        }
        final CommonColumnAutoSetupper setupper = getCommonColumnAutoSetupper();
        assertCommonColumnAutoSetupperNotNull();
        setupper.handleCommonColumnOfInsertIfNeeds(entity);
    }

    private void assertCommonColumnAutoSetupperNotNull() {
        if (_commonColumnAutoSetupper != null) {
            return;
        }
        final ExceptionMessageBuilder br = createExceptionMessageBuilder();
        br.addNotice("Not found the auto set-upper of common column in the behavior!");
        br.addItem("Advice");
        br.addElement("Please confirm the definition of the set-upper at your component configuration of DBFlute.");
        br.addItem("Behavior");
        br.addElement("Behavior for " + getTableDbName());
        br.addItem("Attribute");
        br.addElement("behaviorCommandInvoker   : " + _behaviorCommandInvoker);
        br.addElement("behaviorSelector         : " + _behaviorSelector);
        br.addElement("commonColumnAutoSetupper : " + _commonColumnAutoSetupper);
        final String msg = br.buildExceptionMessage();
        throw new IllegalBehaviorStateException(msg);
    }

    /**
     * Filter the entity of insert. (for extension)
     * @param entity The entity for insert. (NotNull)
     * @param option The option of insert. (NullAllowed)
     */
    protected void filterEntityOfInsert(ENTITY entity, InsertOption<CB> option) {
    }

    /**
     * Assert the entity of insert. (for extension)
     * @param entity The entity for insert. (NotNull)
     * @param option The option of insert. (NullAllowed)
     */
    protected void assertEntityOfInsert(Entity entity, InsertOption<CB> option) {
    }

    /**
     * Assert that the insert option is not null.
     * @param option The option of insert. (NotNull)
     */
    protected void assertInsertOptionNotNull(InsertOption<CB> option) {
        assertObjectNotNull("option (for insert)", option);
    }

    /**
     * Assert that the insert option is legal status.
     * @param option The option of insert. (NotNull)
     */
    protected void assertInsertOptionStatus(InsertOption<CB> option) {
        if (option.isCommonColumnAutoSetupDisabled() && !getDBMeta().hasCommonColumn()) {
            String msg = "The common column auto-setup disabling was set to the table not defined common columns:";
            msg = msg + " table=" + getTableDbName() + " option=" + option;
            throw new IllegalStateException(msg);
        }
        if (option.isPrimaryKeyIdentityDisabled() && !getDBMeta().hasIdentity()) {
            String msg = "The identity disabling was set to the table not defined identity:";
            msg = msg + " table=" + getTableDbName() + " option=" + option;
            throw new IllegalStateException(msg);
        }
    }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    /**
     * Process before update. </br >
     * You can stop the process by your extension.
     * @param entity The entity for update that has primary key. (NotNull)
     * @param option The option of update. (NullAllowed)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeUpdate(ENTITY entity, UpdateOption<CB> option) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        frameworkFilterEntityOfUpdate(entity, option);
        filterEntityOfUpdate(entity, option);
        assertEntityOfUpdate(entity, option);
        return true;
    }

    /**
     * Process before query-update. </br >
     * You can stop the process by your extension.
     * @param entity The entity for update that is not needed primary key. (NotNull)
     * @param cb The condition-bean for query. (NotNull)
     * @param option The option of update. (NullAllowed)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeQueryUpdate(ENTITY entity, CB cb,
            UpdateOption<CB> option) {
        assertEntityNotNull(entity); // query-update doesn't need to check primary key
        assertCBStateValid(cb);
        frameworkFilterEntityOfUpdate(entity, option);
        filterEntityOfUpdate(entity, option);
        assertEntityOfUpdate(entity, option);
        assertQueryUpdateStatus(entity, cb, option);
        return true;
    }

    /**
     * {Framework Method} Filter the entity of update.
     * @param entity The entity for update. (NotNull)
     * @param option The option of update. (NullAllowed)
     */
    protected void frameworkFilterEntityOfUpdate(ENTITY entity, UpdateOption<CB> option) {
        setupCommonColumnOfUpdateIfNeeds(entity, option);
    }

    /**
     * Set up common columns of update if it needs.
     * @param entity The entity for update. (NotNull)
     * @param option The option of update. (NullAllowed)
     */
    protected void setupCommonColumnOfUpdateIfNeeds(ENTITY entity, UpdateOption<CB> option) {
        if (option != null && option.isCommonColumnAutoSetupDisabled()) {
            return;
        }
        final CommonColumnAutoSetupper setupper = getCommonColumnAutoSetupper();
        assertCommonColumnAutoSetupperNotNull();
        setupper.handleCommonColumnOfUpdateIfNeeds(entity);
    }

    /**
     * Filter the entity of update. (for extension)
     * @param entity The entity for update. (NotNull)
     * @param option The option of update. (NullAllowed)
     */
    protected void filterEntityOfUpdate(Entity entity, UpdateOption<CB> option) {
    }

    /**
     * Assert the entity of update. (for extension)
     * @param entity The entity for update. (NotNull)
     * @param option The option of update. (NullAllowed)
     */
    protected void assertEntityOfUpdate(Entity entity, UpdateOption<CB> option) {
    }

    /**
     * Assert that the update column specification is not null.
     * @param updateColumnSpec The SpecifyQuery implementation for update columns. (NotNull)
     */
    protected void assertUpdateColumnSpecificationNotNull(SpecifyQuery<CB> updateColumnSpec) {
        assertObjectNotNull("updateColumnSpec", updateColumnSpec);
    }

    /**
     * Assert that the update option is not null.
     * @param option The option of update. (NotNull)
     */
    protected void assertUpdateOptionNotNull(UpdateOption<CB> option) {
        assertObjectNotNull("option (for update)", option);
    }

    /**
     * Assert that the update option is legal status.
     * @param option The option of update. (NotNull)
     */
    protected void assertUpdateOptionStatus(UpdateOption<CB> option) {
        if (option.isCommonColumnAutoSetupDisabled() && !getDBMeta().hasCommonColumn()) {
            String msg = "The common column auto-setup disabling was set to the table not defined common columns:";
            msg = msg + " table=" + getTableDbName() + " option=" + option;
            throw new IllegalStateException(msg);
        }
    }

    /**
     * Assert that the query-update is legal status.
     * @param entity The entity for query-update. (NotNull)
     * @param cb The condition-bean for query-update. (NotNull)
     * @param option The option of update. (NullAllowed)
     */
    protected void assertQueryUpdateStatus(Entity entity, ConditionBean cb, UpdateOption<CB> option) {
        if (option != null && option.isNonQueryUpdateAllowed()) {
            return;
        }
        if (cb.hasSelectAllPossible()) {
            createBhvExThrower().throwNonQueryUpdateNotAllowedException(entity, cb, option);
        }
    }

    // -----------------------------------------------------
    //                                                Delete
    //                                                ------
    /**
     * Process before delete. </br >
     * You can stop the process by your extension.
     * @param entity The entity for delete that has primary key. (NotNull)
     * @param option The option of delete. (NullAllowed)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeDelete(ENTITY entity, DeleteOption<CB> option) {
        assertEntityNotNullAndHasPrimaryKeyValue(entity);
        frameworkFilterEntityOfDelete(entity, option);
        filterEntityOfDelete(entity, option);
        assertEntityOfDelete(entity, option);
        return true;
    }

    /**
     * Process before query-delete. </br >
     * You can stop the process by your extension.
     * @param cb The condition-bean for query. (NotNull)
     * @param option The option of delete. (NullAllowed)
     * @return Execution Determination. (true: execute / false: non)
     */
    protected boolean processBeforeQueryDelete(CB cb, DeleteOption<CB> option) {
        assertCBStateValid(cb);
        assertQueryDeleteStatus(cb, option);
        return true;
    }

    /**
     * {Framework Method} Filter the entity of delete. {not called if query-delete}
     * @param entity The entity for delete that has primary key. (NotNull)
     * @param option The option of delete. (NullAllowed)
     */
    protected void frameworkFilterEntityOfDelete(ENTITY entity, DeleteOption<CB> option) {
    }

    /**
     * Filter the entity of delete. (for extension) {not called if query-delete}
     * @param entity The entity for delete that has primary key. (NotNull)
     * @param option The option of delete. (NullAllowed)
     */
    protected void filterEntityOfDelete(ENTITY entity, DeleteOption<CB> option) {
    }

    /**
     * Assert the entity of delete. (for extension) {not called if query-delete}
     * @param entity The entity for delete that has primary key. (NotNull)
     * @param option The option of delete. (NullAllowed)
     */
    protected void assertEntityOfDelete(ENTITY entity, DeleteOption<CB> option) {
    }

    /**
     * Assert that the delete option is not null.
     * @param option The option of delete. (NotNull)
     */
    protected void assertDeleteOptionNotNull(DeleteOption<CB> option) {
        assertObjectNotNull("option (for delete)", option);
    }

    /**
     * Assert that the delete option is legal status.
     * @param option The option of delete. (NotNull)
     */
    protected void assertDeleteOptionStatus(DeleteOption<CB> option) {
    }

    /**
     * Assert that the query-delete is legal status.
     * @param cb The condition-bean for query-delete. (NotNull)
     * @param option The option of delete. (NullAllowed)
     */
    protected void assertQueryDeleteStatus(ConditionBean cb, DeleteOption<CB> option) {
        if (option != null && option.isNonQueryDeleteAllowed()) {
            return;
        }
        if (cb.hasSelectAllPossible()) {
            createBhvExThrower().throwNonQueryDeleteNotAllowedException(cb, option);
        }
    }

    // -----------------------------------------------------
    //                                                Common
    //                                                ------
    protected void injectSequenceToPrimaryKeyIfNeeds(Entity entity) {
        final DBMeta dbmeta = entity.getDBMeta();
        if (!dbmeta.hasSequence() || dbmeta.hasCompoundPrimaryKey() || entity.hasPrimaryKeyValue()) {
            return;
        }
        // basically property(column) type is same as next value type
        // so there is NOT type conversion cost when writing to the entity
        dbmeta.getPrimaryUniqueInfo().getFirstColumn().write(entity, readNextVal());
    }

    protected InsertOption<CB> createPlainInsertOption() {
        return new InsertOption<CB>();
    }

    protected InsertOption<CB> createInsertUpdateOption() { // for compatible
        return createPlainInsertOption();
    }

    protected UpdateOption<CB> createPlainUpdateOption() {
        return new UpdateOption<CB>();
    }

    protected UpdateOption<CB> createSpecifiedUpdateOption(SpecifyQuery<CB> updateColumnSpec) {
        assertUpdateColumnSpecificationNotNull(updateColumnSpec);
        final UpdateOption<CB> option = createPlainUpdateOption();
        option.specify(updateColumnSpec);
        return option;
    }

    protected void assertEntityHasOptimisticLockValue(ENTITY entity) {
        assertEntityHasVersionNoValue(entity);
        assertEntityHasUpdateDateValue(entity);
    }

    protected void assertEntityHasVersionNoValue(ENTITY entity) {
        if (!getDBMeta().hasVersionNo()) {
            return;
        }
        if (hasVersionNoValue(entity)) {
            return;
        }
        throwVersionNoValueNullException(entity);
    }

    protected void throwVersionNoValueNullException(Entity entity) {
        createBhvExThrower().throwVersionNoValueNullException(entity);
    }

    protected void assertEntityHasUpdateDateValue(ENTITY entity) {
        if (!getDBMeta().hasUpdateDate()) {
            return;
        }
        if (hasUpdateDateValue(entity)) {
            return;
        }
        throwUpdateDateValueNullException(entity);
    }

    protected void throwUpdateDateValueNullException(Entity entity) {
        createBhvExThrower().throwUpdateDateValueNullException(entity);
    }

    // ===================================================================================
    //                                                     Delegate Method Internal Helper
    //                                                     ===============================
    protected List<ENTITY> processBatchInternally(List<ENTITY> entityList,
            InsertOption<CB> option) {
        assertObjectNotNull("entityList", entityList);
        final List<ENTITY> filteredList = new ArrayList<ENTITY>();
        for (ENTITY entity : entityList) {
            if (!processBeforeInsert(entity, option)) {
                continue;
            }
            filteredList.add(entity);
        }
        return filteredList;
    }

    protected List<ENTITY> processBatchInternally(List<ENTITY> entityList,
            UpdateOption<CB> option, boolean nonstrict) {
        assertObjectNotNull("entityList", entityList);
        final List<ENTITY> filteredList = new ArrayList<ENTITY>();
        for (ENTITY entity : entityList) {
            if (!processBeforeUpdate(entity, option)) {
                continue;
            }
            if (!nonstrict) {
                assertEntityHasOptimisticLockValue(entity);
            }
            filteredList.add(entity);
        }
        return filteredList;
    }

    protected List<ENTITY> processBatchInternally(List<ENTITY> entityList,
            DeleteOption<CB> option, boolean nonstrict) {
        assertObjectNotNull("entityList", entityList);
        final List<ENTITY> filteredList = new ArrayList<ENTITY>();
        for (ENTITY entity : entityList) {
            if (!processBeforeDelete(entity, option)) {
                continue;
            }
            if (!nonstrict) {
                assertEntityHasOptimisticLockValue(entity);
            }
            filteredList.add(entity);
        }
        return filteredList;
    }

    // ===================================================================================
    //                                                                      Delegate Entry
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    protected int delegateInsert(ENTITY entity, InsertOption<CB> option) {
        if (!processBeforeInsert(entity, option)) {
            return 0;
        }
        return invoke(createInsertEntityCommand(entity, option));
    }

    protected int delegateUpdate(ENTITY entity, UpdateOption<CB> option) {
        if (!processBeforeUpdate(entity, option)) {
            return 0;
        }
        if (getDBMeta().hasOptimisticLock()) {
            return invoke(createUpdateEntityCommand(entity, option));
        } else {
            return delegateUpdateNonstrict(entity, option);
        }
    }

    protected int delegateUpdateNonstrict(ENTITY entity, UpdateOption<CB> option) {
        if (!processBeforeUpdate(entity, option)) {
            return 0;
        }
        return invoke(createUpdateNonstrictEntityCommand(entity, option));
    }

    protected int delegateDelete(ENTITY entity, DeleteOption<CB> option) {
        if (!processBeforeDelete(entity, option)) {
            return 0;
        }
        if (getDBMeta().hasOptimisticLock()) {
            return invoke(createDeleteEntityCommand(entity, option));
        } else {
            return delegateDeleteNonstrict(entity, option);
        }
    }

    protected int delegateDeleteNonstrict(ENTITY entity, DeleteOption<CB> option) {
        if (!processBeforeDelete(entity, option)) {
            return 0;
        }
        return invoke(createDeleteNonstrictEntityCommand(entity, option));
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    protected int[] delegateBatchInsert(List<ENTITY> ls, InsertOption<CB> option) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchInsertCommand(processBatchInternally(ls, option), option));
    }

    protected int[] delegateBatchUpdate(List<ENTITY> ls, UpdateOption<CB> option) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        if (getDBMeta().hasOptimisticLock()) {
            return invoke(createBatchUpdateCommand(processBatchInternally(ls, option, false), option));
        } else {
            return delegateBatchUpdateNonstrict(ls, option);
        }
    }

    protected int[] delegateBatchUpdateNonstrict(List<ENTITY> ls, UpdateOption<CB> option) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, option, true), option));
    }

    protected int[] delegateBatchDelete(List<ENTITY> ls, DeleteOption<CB> option) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        if (getDBMeta().hasOptimisticLock()) {
            return invoke(createBatchDeleteCommand(processBatchInternally(ls, option, false), option));
        } else {
            return delegateBatchDeleteNonstrict(ls, option);
        }
    }

    protected int[] delegateBatchDeleteNonstrict(List<ENTITY> ls, DeleteOption<CB> option) {
        if (ls.isEmpty()) {
            return new int[] {};
        }
        return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, option, true), option));
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    protected int delegateQueryInsert(ENTITY entity, CB inCB, ConditionBean resCB,
            InsertOption<CB> option) {
        if (!processBeforeQueryInsert(entity, inCB, resCB, option)) {
            return 0;
        }
        return invoke(createQueryInsertCBCommand(entity, inCB, resCB, option));
    }

    protected int delegateQueryUpdate(ENTITY entity, CB cb, UpdateOption<CB> option) {
        if (!processBeforeQueryUpdate(entity, cb, option)) {
            return 0;
        }
        return invoke(createQueryUpdateCBCommand(entity, cb, option));
    }

    protected int delegateQueryDelete(CB cb, DeleteOption<CB> option) {
        if (!processBeforeQueryDelete(cb, option)) {
            return 0;
        }
        return invoke(createQueryDeleteCBCommand(cb, option));
    }

    // ===================================================================================
    //                                                                    Behavior Command
    //                                                                    ================
    // -----------------------------------------------------
    //                                                 Basic
    //                                                 -----
    // an insert command creation is defined on the readable interface for non-primary key value

    protected UpdateEntityCommand createUpdateEntityCommand(Entity entity, UpdateOption<CB> option) {
        assertBehaviorCommandInvoker("createUpdateEntityCommand");
        final UpdateEntityCommand cmd = newUpdateEntityCommand();
        xsetupEntityCommand(cmd, entity);
        cmd.setUpdateOption(option);
        return cmd;
    }

    protected UpdateEntityCommand newUpdateEntityCommand() {
        return new UpdateEntityCommand();
    }

    protected UpdateNonstrictEntityCommand createUpdateNonstrictEntityCommand(Entity entity,
            UpdateOption<CB> option) {
        assertBehaviorCommandInvoker("createUpdateNonstrictEntityCommand");
        final UpdateNonstrictEntityCommand cmd = newUpdateNonstrictEntityCommand();
        xsetupEntityCommand(cmd, entity);
        cmd.setUpdateOption(option);
        return cmd;
    }

    protected UpdateNonstrictEntityCommand newUpdateNonstrictEntityCommand() {
        return new UpdateNonstrictEntityCommand();
    }

    protected DeleteEntityCommand createDeleteEntityCommand(Entity entity, DeleteOption<CB> option) {
        assertBehaviorCommandInvoker("createDeleteEntityCommand");
        final DeleteEntityCommand cmd = newDeleteEntityCommand();
        xsetupEntityCommand(cmd, entity);
        cmd.setDeleteOption(option);
        return cmd;
    }

    protected DeleteEntityCommand newDeleteEntityCommand() {
        return new DeleteEntityCommand();
    }

    protected DeleteNonstrictEntityCommand createDeleteNonstrictEntityCommand(Entity entity,
            DeleteOption<CB> option) {
        assertBehaviorCommandInvoker("createDeleteNonstrictEntityCommand");
        final DeleteNonstrictEntityCommand cmd = newDeleteNonstrictEntityCommand();
        xsetupEntityCommand(cmd, entity);
        cmd.setDeleteOption(option);
        return cmd;
    }

    protected DeleteNonstrictEntityCommand newDeleteNonstrictEntityCommand() {
        return new DeleteNonstrictEntityCommand();
    }

    // -----------------------------------------------------
    //                                                 Batch
    //                                                 -----
    protected BatchInsertCommand createBatchInsertCommand(List<ENTITY> entityList,
            InsertOption<CB> option) {
        assertBehaviorCommandInvoker("createBatchInsertCommand");
        final BatchInsertCommand cmd = newBatchInsertCommand();
        xsetupListEntityCommand(cmd, entityList);
        cmd.setInsertOption(option);
        return cmd;
    }

    protected BatchInsertCommand newBatchInsertCommand() {
        return new BatchInsertCommand();
    }

    protected BatchUpdateCommand createBatchUpdateCommand(List<ENTITY> entityList,
            UpdateOption<CB> option) {
        assertBehaviorCommandInvoker("createBatchUpdateCommand");
        final BatchUpdateCommand cmd = newBatchUpdateCommand();
        xsetupListEntityCommand(cmd, entityList);
        cmd.setUpdateOption(option);
        return cmd;
    }

    protected BatchUpdateCommand newBatchUpdateCommand() {
        return new BatchUpdateCommand();
    }

    protected BatchUpdateNonstrictCommand createBatchUpdateNonstrictCommand(List<ENTITY> entityList,
            UpdateOption<CB> option) {
        assertBehaviorCommandInvoker("createBatchUpdateNonstrictCommand");
        final BatchUpdateNonstrictCommand cmd = newBatchUpdateNonstrictCommand();
        xsetupListEntityCommand(cmd, entityList);
        cmd.setUpdateOption(option);
        return cmd;
    }

    protected BatchUpdateNonstrictCommand newBatchUpdateNonstrictCommand() {
        return new BatchUpdateNonstrictCommand();
    }

    protected BatchDeleteCommand createBatchDeleteCommand(List<ENTITY> entityList,
            DeleteOption<CB> option) {
        assertBehaviorCommandInvoker("createBatchDeleteCommand");
        final BatchDeleteCommand cmd = newBatchDeleteCommand();
        xsetupListEntityCommand(cmd, entityList);
        cmd.setDeleteOption(option);
        return cmd;
    }

    protected BatchDeleteCommand newBatchDeleteCommand() {
        return new BatchDeleteCommand();
    }

    protected BatchDeleteNonstrictCommand createBatchDeleteNonstrictCommand(List<ENTITY> entityList,
            DeleteOption<CB> option) {
        assertBehaviorCommandInvoker("createBatchDeleteNonstrictCommand");
        final BatchDeleteNonstrictCommand cmd = newBatchDeleteNonstrictCommand();
        xsetupListEntityCommand(cmd, entityList);
        cmd.setDeleteOption(option);
        return cmd;
    }

    protected BatchDeleteNonstrictCommand newBatchDeleteNonstrictCommand() {
        return new BatchDeleteNonstrictCommand();
    }

    /**
     * @param command The command of behavior. (NotNull)
     * @param entityList The list of entity. (NotNull, NotEmpty)
     */
    protected void xsetupListEntityCommand(AbstractListEntityCommand command, List<ENTITY> entityList) {
        if (entityList.isEmpty()) {
            String msg = "The argument 'entityList' should not be empty: " + entityList;
            throw new IllegalStateException(msg);
        }
        command.setTableDbName(getTableDbName());
        _behaviorCommandInvoker.injectComponentProperty(command);
        command.setEntityType(entityList.get(0).getClass()); // *The list should not be empty!
        command.setEntityList(entityList);
    }

    // -----------------------------------------------------
    //                                                 Query
    //                                                 -----
    protected QueryInsertCBCommand createQueryInsertCBCommand(Entity entity, ConditionBean intoCB,
            ConditionBean resourceCB, InsertOption<CB> option) {
        assertBehaviorCommandInvoker("createQueryInsertCBCommand");
        final QueryInsertCBCommand cmd = new QueryInsertCBCommand();
        cmd.setTableDbName(getTableDbName());
        _behaviorCommandInvoker.injectComponentProperty(cmd);
        cmd.setEntity(entity);
        cmd.setIntoConditionBean(intoCB);
        cmd.setConditionBean(resourceCB);
        cmd.setInsertOption(option);
        return cmd;
    }

    protected QueryUpdateCBCommand createQueryUpdateCBCommand(Entity entity, ConditionBean cb,
            UpdateOption<CB> option) {
        assertBehaviorCommandInvoker("createQueryUpdateCBCommand");
        final QueryUpdateCBCommand cmd = new QueryUpdateCBCommand();
        cmd.setTableDbName(getTableDbName());
        _behaviorCommandInvoker.injectComponentProperty(cmd);
        cmd.setEntity(entity);
        cmd.setConditionBean(cb);
        cmd.setUpdateOption(option);
        return cmd;
    }

    protected QueryDeleteCBCommand createQueryDeleteCBCommand(ConditionBean cb,
            DeleteOption<CB> option) {
        assertBehaviorCommandInvoker("createQueryDeleteCBCommand");
        final QueryDeleteCBCommand cmd = new QueryDeleteCBCommand();
        cmd.setTableDbName(getTableDbName());
        _behaviorCommandInvoker.injectComponentProperty(cmd);
        cmd.setConditionBean(cb);
        cmd.setDeleteOption(option);
        return cmd;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * Get the auto set-upper of common column.
     * @return The auto set-upper of common column. (NullAllowed: But normally NotNull)
     */
    protected CommonColumnAutoSetupper getCommonColumnAutoSetupper() {
        return _commonColumnAutoSetupper;
    }

    /**
     * Set the auto set-upper of common column.
     * @param commonColumnAutoSetupper The auto set-upper of common column. (NotNull)
     */
    public void setCommonColumnAutoSetupper(CommonColumnAutoSetupper commonColumnAutoSetupper) {
        this._commonColumnAutoSetupper = commonColumnAutoSetupper;
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * ENTITY entity = new ENTITY();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * entity.setFoo...(value);
     * entity.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//entity.set...;</span>
     * behavior.<span style="color: #DD4747">insert</span>(entity);
     * ... = entity.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param entity The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(ENTITY entity) {
        doInsert(entity, null);
    }

    protected void doInsert(ENTITY et, InsertOption<CB> op) {
        assertObjectNotNull("entity", et); prepareInsertOption(op); delegateInsert(et, op);
    }

    protected void prepareInsertOption(InsertOption<CB> op) {
        if (op == null) { return; } assertInsertOptionStatus(op);
        if (op.hasSpecifiedInsertColumn()) { op.resolveInsertColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected void doCreate(ENTITY et, InsertOption<CB> op) { doInsert(downcast(et), downcast(op)); }

    /**
     * Update the entity modified-only. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * ENTITY entity = new ENTITY();
     * entity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * entity.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//entity.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * entity.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     behavior.<span style="color: #DD4747">update</span>(entity);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param entity The entity of update. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(ENTITY entity) {
        doUpdate(entity, null);
    }

    protected void doUpdate(ENTITY et, UpdateOption<CB> op) {
        assertObjectNotNull("entity", et); prepareUpdateOption(op); helpUpdateInternally(et, op);
    }

    protected void prepareUpdateOption(UpdateOption<CB> op) {
        if (op == null) { return; } assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) { op.resolveSelfSpecification(createCBForVaryingUpdate()); }
        if (op.hasSpecifiedUpdateColumn()) { op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected CB createCBForVaryingUpdate()
    // TODO change from AbstractConditionBean to ConditionBean
    { CB cb = newConditionBean(); ((AbstractConditionBean) cb).xsetupForVaryingUpdate(); return cb; }

    protected CB createCBForSpecifiedUpdate()
    // TODO change from AbstractConditionBean to ConditionBean
    { CB cb = newConditionBean(); ((AbstractConditionBean) cb).xsetupForSpecifiedUpdate(); return cb; }

    protected void doModify(ENTITY et, UpdateOption<CB> op) { doUpdate(downcast(et), downcast(op)); }

    /**
     * Update the entity non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * ENTITY entity = new ENTITY();
     * entity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * entity.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//entity.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     * behavior.<span style="color: #DD4747">updateNonstrict</span>(entity);
     * </pre>
     * @param entity The entity of update. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(ENTITY entity) {
        doUpdateNonstrict(entity, null);
    }

    protected void doUpdateNonstrict(ENTITY et, UpdateOption<CB> op) {
        assertObjectNotNull("entity", et); prepareUpdateOption(op); helpUpdateNonstrictInternally(et, op);
    }

    protected void doModifyNonstrict(ENTITY et, UpdateOption<CB> op)
    { doUpdateNonstrict(downcast(et), downcast(op)); }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, ExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param entity The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(ENTITY entity) {
        doInsertOrUpdate(entity, null, null);
    }

    protected void doInsertOrUpdate(ENTITY et, InsertOption<CB> iop, UpdateOption<CB> uop) {
        assertObjectNotNull("entity", et); helpInsertOrUpdateInternally(et, iop, uop);
    }

    protected void doCreateOrModify(ENTITY et, InsertOption<CB> iop, UpdateOption<CB> uop)
    { doInsertOrUpdate(downcast(et), downcast(iop), downcast(uop)); }

    /**
     * Insert or update the entity non-strictly modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() }
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param entity The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(ENTITY entity) {
        doInsertOrUpdateNonstrict(entity, null, null);
    }

    protected void doInsertOrUpdateNonstrict(ENTITY et, InsertOption<CB> iop, UpdateOption<CB> uop) {
        assertObjectNotNull("entity", et); helpInsertOrUpdateNonstrictInternally(et, iop, uop);
    }

    protected void doCreateOrModifyNonstrict(ENTITY et, InsertOption<CB> iop, UpdateOption<CB> uop)
    { doInsertOrUpdateNonstrict(downcast(et), downcast(iop), downcast(uop)); }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * ENTITY entity = new ENTITY();
     * entity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * entity.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     behavior.<span style="color: #DD4747">delete</span>(entity);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param entity The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(ENTITY entity) {
        doDelete(entity, null);
    }

    protected void doDelete(ENTITY et, final DeleteOption<CB> op) {
        assertObjectNotNull("entity", et); prepareDeleteOption(op); helpDeleteInternally(et, op);
    }

    protected void prepareDeleteOption(DeleteOption<CB> op) { if (op != null) { assertDeleteOptionStatus(op); } }

    protected void doRemove(ENTITY et, DeleteOption<CB> op) { doDelete(downcast(et), downcast(op)); }

    /**
     * Delete the entity non-strictly. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * ENTITY entity = new ENTITY();
     * entity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     * behavior.<span style="color: #DD4747">deleteNonstrict</span>(entity);
     * </pre>
     * @param entity The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(ENTITY entity) {
        doDeleteNonstrict(entity, null);
    }

    protected void doDeleteNonstrict(ENTITY et, final DeleteOption<CB> op) {
        assertObjectNotNull("entity", et); prepareDeleteOption(op); helpDeleteNonstrictInternally(et, op);
    }

    protected void doRemoveNonstrict(ENTITY et, DeleteOption<CB> op)
    { doDeleteNonstrict(downcast(et), downcast(op)); }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <p><span style="color: #DD4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
     * <pre>
     * for (... : ...) {
     *     ENTITY entity = new ENTITY();
     *     entity.setFooName("foo");
     *     if (...) {
     *         entity.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     entityList.add(entity);
     * }
     * behavior.<span style="color: #DD4747">batchInsert</span>(entityList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<ENTITY> entityList) {
        return doBatchInsert(entityList, null);
    }

    protected int[] doBatchInsert(List<ENTITY> ls, InsertOption<CB> op) {
        assertObjectNotNull("entityList", ls);
        InsertOption<CB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainInsertOption(); }
        prepareBatchInsertOption(ls, rlop); // required
        return delegateBatchInsert(ls, rlop);
    }

    protected void prepareBatchInsertOption(List<ENTITY> ls, InsertOption<CB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(ls);
        prepareInsertOption(op);
    }

    protected int[] doLumpCreate(List<ENTITY> ls, InsertOption<CB> op) { return doBatchInsert(downcast(ls), downcast(op)); }

    /**
     * Batch-update the entity list modified-only of same-set columns. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     ENTITY entity = new ENTITY();
     *     entity.setFooName("foo");
     *     if (...) {
     *         entity.setFooPrice(123);
     *     } else {
     *         entity.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//entity.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     entityList.add(entity);
     * }
     * behavior.<span style="color: #DD4747">batchUpdate</span>(entityList);
     * </pre>
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<ENTITY> entityList) {
        return doBatchUpdate(entityList, null);
    }

    protected int[] doBatchUpdate(List<ENTITY> ls, UpdateOption<CB> op) {
        assertObjectNotNull("entityList", ls);
        UpdateOption<CB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop); // required
        return delegateBatchUpdate(ls, rlop);
    }

    protected void prepareBatchUpdateOption(List<ENTITY> ls, UpdateOption<CB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(ls);
        prepareUpdateOption(op);
    }

    protected int[] doLumpModify(List<ENTITY> ls, UpdateOption<CB> op) { return doBatchUpdate(downcast(ls), downcast(op)); }

    /**
     * Batch-update the entity list specified-only. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * behavior.<span style="color: #DD4747">batchUpdate</span>(entityList, new SpecifyQuery<CB>() {
     *     public void specify(CB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * behavior.<span style="color: #DD4747">batchUpdate</span>(entityList, new SpecifyQuery<CB>() {
     *     public void specify(CB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<ENTITY> entityList, SpecifyQuery<CB> updateColumnSpec) {
        return doBatchUpdate(entityList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 140%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     ENTITY entity = new ENTITY();
     *     entity.setFooName("foo");
     *     if (...) {
     *         entity.setFooPrice(123);
     *     } else {
     *         entity.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//entity.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     entityList.add(entity);
     * }
     * behavior.<span style="color: #DD4747">batchUpdate</span>(entityList);
     * </pre>
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<ENTITY> entityList) {
        return doBatchUpdateNonstrict(entityList, null);
    }

    protected int[] doBatchUpdateNonstrict(List<ENTITY> ls, UpdateOption<CB> op) {
        assertObjectNotNull("entityList", ls);
        UpdateOption<CB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop);
        return delegateBatchUpdateNonstrict(ls, rlop);
    }

    /**
     * Batch-update the entity list non-strictly specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * behavior.<span style="color: #DD4747">batchUpdateNonstrict</span>(entityList, new SpecifyQuery<CB>() {
     *     public void specify(CB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * behavior.<span style="color: #DD4747">batchUpdateNonstrict</span>(entityList, new SpecifyQuery<CB>() {
     *     public void specify(CB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).</p>
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<ENTITY> entityList, SpecifyQuery<CB> updateColumnSpec) {
        return doBatchUpdateNonstrict(entityList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    protected int[] doLumpModifyNonstrict(List<ENTITY> ls, UpdateOption<CB> op)
    { return doBatchUpdateNonstrict(downcast(ls), downcast(op)); }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(List<ENTITY> entityList) {
        return doBatchDelete(entityList, null);
    }

    protected int[] doBatchDelete(List<ENTITY> ls, DeleteOption<CB> op) {
        assertObjectNotNull("entityList", ls);
        prepareDeleteOption(op);
        return delegateBatchDelete(ls, op);
    }

    protected int[] doLumpRemove(List<ENTITY> ls, DeleteOption<CB> op) { return doBatchDelete(downcast(ls), downcast(op)); }

    /**
     * Batch-delete the entity list non-strictly. {NonExclusiveControl} <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(List<ENTITY> entityList) {
        return doBatchDeleteNonstrict(entityList, null);
    }

    protected int[] doBatchDeleteNonstrict(List<ENTITY> ls, DeleteOption<CB> op) {
        assertObjectNotNull("entityList", ls);
        prepareDeleteOption(op);
        return delegateBatchDeleteNonstrict(ls, op);
    }

    protected int[] doLumpRemoveNonstrict(List<ENTITY> ls, DeleteOption<CB> op)
    { return doBatchDeleteNonstrict(downcast(ls), downcast(op)); }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * behavior.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;ENTITY, CB&gt;() {
     *     public ConditionBean setup(entity entity, CB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     *
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<ENTITY, CB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<ENTITY, CB> sp, InsertOption<CB> op) {
        assertObjectNotNull("setupper", sp); prepareInsertOption(op);
        ENTITY et = newEntity(); CB cb = createCBForQueryInsert();
        return delegateQueryInsert(et, cb, sp.setup(et, cb), op);
    }

    protected CB createCBForQueryInsert()
    { CB cb = newConditionBean(); ((AbstractConditionBean) cb).xsetupForQueryInsert(); return cb; }

    protected int doRangeCreate(QueryInsertSetupper<ENTITY, CB> setupper, InsertOption<CB> op)
    { return doQueryInsert(downcast(setupper), downcast(op)); }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * ENTITY entity = new ENTITY();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//entity.setPK...(value);</span>
     * entity.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//entity.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     * CB cb = new CB();
     * cb.query().setFoo...(value);
     * behavior.<span style="color: #DD4747">queryUpdate</span>(entity, cb);
     * </pre>
     * @param entity The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of ENTITY. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(ENTITY entity, CB cb) {
        return doQueryUpdate(entity, cb, null);
    }

    protected int doQueryUpdate(ENTITY et, CB cb, UpdateOption<CB> op) {
        assertObjectNotNull("entity", et); assertCBStateValid(cb); prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(et, cb, op) : 0;
    }

    protected int doRangeModify(ENTITY et, CB cb, UpdateOption<CB> op)
    { return doQueryUpdate(downcast(et), downcast(cb), downcast(op)); }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * CB cb = new CB();
     * cb.query().setFoo...(value);
     * behavior.<span style="color: #DD4747">queryDelete</span>(entity, cb);
     * </pre>
     * @param cb The condition-bean of ENTITY. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(CB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(CB cb, DeleteOption<CB> op) {
        assertCBStateValid(cb); prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    protected int doRangeRemove(CB cb, DeleteOption<CB> op) { return doQueryDelete(downcast(cb), downcast(op)); }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as insert(entity).
     * <pre>
     * ENTITY entity = new ENTITY();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * entity.setFoo...(value);
     * entity.setBar...(value);
     * InsertOption<CB> option = new InsertOption<CB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * behavior.<span style="color: #DD4747">varyingInsert</span>(entity, option);
     * ... = entity.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param entity The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(ENTITY entity, InsertOption<CB> option) {
        assertInsertOptionNotNull(option);
        doInsert(entity, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, ExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * ENTITY entity = new ENTITY();
     * entity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * entity.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * entity.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;CB&gt; option = new UpdateOption&lt;CB&gt;();
     *     option.self(new SpecifyQuery&lt;CB&gt;() {
     *         public void specify(CB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     behavior.<span style="color: #DD4747">varyingUpdate</span>(entity, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param entity The entity of update. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(ENTITY entity, UpdateOption<CB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(entity, option);
    }

    /**
     * Update the entity with varying requests non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as updateNonstrict(entity).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * ENTITY entity = new ENTITY();
     * entity.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * entity.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     * UpdateOption&lt;CB&gt; option = new UpdateOption&lt;CB&gt;();
     * option.self(new SpecifyQuery&lt;CB&gt;() {
     *     public void specify(CB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * behavior.<span style="color: #DD4747">varyingUpdateNonstrict</span>(entity, option);
     * </pre>
     * @param entity The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(ENTITY entity, UpdateOption<CB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(entity, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param entity The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(ENTITY entity, InsertOption<CB> insertOption, UpdateOption<CB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdate(entity, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param entity The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(ENTITY entity, InsertOption<CB> insertOption, UpdateOption<CB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdateNonstrict(entity, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param entity The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(ENTITY entity, DeleteOption<CB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(entity, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param entity The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDeleteNonstrict(ENTITY entity, DeleteOption<CB> option) {
        assertDeleteOptionNotNull(option);
        doDeleteNonstrict(entity, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<ENTITY> entityList, InsertOption<CB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(entityList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<ENTITY> entityList, UpdateOption<CB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(entityList, option);
    }

    /**
     * Batch-update the list with varying requests non-strictly. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdateNonstrict(List<ENTITY> entityList, UpdateOption<CB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdateNonstrict(entityList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<ENTITY> entityList, DeleteOption<CB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(entityList, option);
    }

    /**
     * Batch-delete the list with varying requests non-strictly. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDeleteNonstrict(entityList).
     * @param entityList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDeleteNonstrict(List<ENTITY> entityList, DeleteOption<CB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDeleteNonstrict(entityList, option);
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as queryInsert(entity, setupper).
     * @param setupper The setup-per of query-insert. (NotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(QueryInsertSetupper<ENTITY, CB> setupper, InsertOption<CB> option) {
        assertInsertOptionNotNull(option);
        return doQueryInsert(setupper, option);
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br />
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * ENTITY entity = new ENTITY();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//entity.setPK...(value);</span>
     * entity.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     * CB cb = new CB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;CB&gt; option = new UpdateOption&lt;CB&gt;();
     * option.self(new SpecifyQuery&lt;CB&gt;() {
     *     public void specify(CB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * behavior.<span style="color: #DD4747">varyingQueryUpdate</span>(entity, cb, option);
     * </pre>
     * @param entity The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of ENTITY. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(ENTITY entity, CB cb, UpdateOption<CB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(entity, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of ENTITY. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(CB cb, DeleteOption<CB> option) {
        assertDeleteOptionNotNull(option);
        return doQueryDelete(cb, option);
    }
}
