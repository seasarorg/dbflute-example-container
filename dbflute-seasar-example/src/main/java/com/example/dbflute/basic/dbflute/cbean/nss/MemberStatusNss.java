/*
 * Copyright 2004-2013 the Seasar Foundation and the Others.
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
package com.example.dbflute.basic.dbflute.cbean.nss;

import com.example.dbflute.basic.dbflute.cbean.cq.MemberStatusCQ;

/**
 * The nest select set-upper of MEMBER_STATUS.
 * @author DBFlute(AutoGenerator)
 */
public class MemberStatusNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberStatusCQ _query;
    public MemberStatusNss(MemberStatusCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============

}
