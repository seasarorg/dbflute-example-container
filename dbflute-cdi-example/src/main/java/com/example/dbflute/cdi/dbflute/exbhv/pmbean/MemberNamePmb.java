/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.exbhv.pmbean;

import com.example.dbflute.cdi.dbflute.bsbhv.pmbean.BsMemberNamePmb;

/**
 * <!-- df:beginClassDescription -->
 * The typed parameter-bean of MemberName. <span style="color: #AD4747">(typed to list, entity)</span><br />
 * This is related to "<span style="color: #AD4747">selectMemberName</span>" on MemberBhv, <br />
 * described as "Select句が一個だけの検索のExample".
 * <!-- df:endClassDescription -->
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class MemberNamePmb extends BsMemberNamePmb {

    // for the test of alternate boolean method
    protected boolean _existsBirthdate;

    @Override
    public boolean existsBirthdate() {
        return this._existsBirthdate; // complex logic in business
    }

    public void requireBirthdate() {
        this._existsBirthdate = true;
    }
}
