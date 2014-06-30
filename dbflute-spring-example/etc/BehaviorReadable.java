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

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.chelper.HpSLSFunction;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.outsidesql.executor.OutsideSqlBasicExecutor;

/**
 * The interface of behavior-readable.
 * @param <CB> The type of conditionBean.
 * @param <ENTITY> The type of entity.
 * @author jflute
 */
public interface BehaviorReadable<CB extends ConditionBean, ENTITY extends Entity> {

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /**
     * Get table DB name.
     * @return Table DB name. (NotNull)
     */
    String getTableDbName();

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * Get the instance of DBMeta.
     * @return The instance of DBMeta. (NotNull)
     */
    DBMeta getDBMeta();

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /**
     * New entity instance.
     * @return Entity. (NotNull)
     */
    ENTITY newEntity();

    /**
     * New condition-bean instance.
     * @return Condition-bean. (NotNull)
     */
    CB newConditionBean();

    Class<ENTITY> typeOfSelectedEntity();
    Class<CB> typeOfSelectedConditionBean();

    // ===================================================================================
    //                                                                    Basic Read Count
    //                                                                    ================
    /**
     * Read count by condition-bean. <br />
     * An interface dispatch for selectCount().
     * @param cb The instance of corresponding condition-bean. (NotNull)
     * @return Read count. (NotNull)
     */
    int readCount(CB cb);

    // ===================================================================================
    //                                                                   Basic Read Entity
    //                                                                   =================
    /**
     * Read entity by condition-bean. <br />
     * An interface dispatch for selectEntity().
     * @param cb The instance of corresponding condition-bean. (NotNull)
     * @return Read entity. (Nullalble)
     */
    ENTITY readEntity(CB cb);

    /**
     * Read simple entity by condition-bean with deleted check. <br />
     * An interface dispatch for selectEntityWithDeletedCheck().
     * @param cb The instance of corresponding condition-bean. (NotNull)
     * @return Read entity. (NotNull)
     */
    ENTITY readEntityWithDeletedCheck(CB cb);

    // ===================================================================================
    //                                                                     Basic Read List
    //                                                                     ===============
    /**
     * Read list as result-bean. <br />
     * An interface dispatch for selectList().
     * @param cb The instance of corresponding condition-bean. (NotNull)
     * @return The list of entity as result-bean. If the select result is zero, it returns empty list. (NotNull)
     */
    ListResultBean<ENTITY> readList(CB cb);

    /**
     * Read page as result-bean. <br />
     * An interface dispatch for selectPage().
     * @param cb The instance of corresponding condition-bean. (NotNull)
     * @return The page of entity as result-bean. (NotNull)
     */
    PagingResultBean<ENTITY> readPage(CB cb);

    // ===================================================================================
    //                                                                         Scalar Read
    //                                                                         ===========
    /**
     * Read the scalar value derived by a function from uniquely-selected records. <br />
     * An interface dispatch for scalarSelect().
     * @param <RESULT> The type of scalar result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    <RESULT> HpSLSFunction<CB, RESULT> readScalar(Class<RESULT> resultType);

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    /**
     * Read next value of sequence. <br />
     * An interface dispatch for selectNextVal().
     * @return The next value of sequence. (NotNull)
     */
    Number readNextVal();

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare an outside-SQL execution by returning an instance of the executor for outside-SQL.
     * @param <BEHAVIOR> The type of behavior.
     * @return The basic executor for outside-SQL. (NotNull)
     */
    <BEHAVIOR extends BehaviorReadable<CB, ENTITY>> OutsideSqlBasicExecutor<BEHAVIOR> readyOutsideSql();

    // ===================================================================================
    //                                                                             Warm Up
    //                                                                             =======
    /**
     * Warm up the command of behavior. {Internal}
     */
    void warmUpCommand();
}
