/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.cdi.dbflute.exbhv;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.dbflute.cdi.dbflute.bsbhv.BsMemberBhv;
import com.example.dbflute.cdi.dbflute.exbhv.cursor.PurchaseSummaryMemberCursor;
import com.example.dbflute.cdi.dbflute.exbhv.cursor.PurchaseSummaryMemberCursorHandler;
import com.example.dbflute.cdi.dbflute.exbhv.pmbean.PurchaseSummaryMemberPmb;

/**
 * The behavior of MEMBER.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class MemberBhv extends BsMemberBhv {

    // /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // このクラスは、GenerationGapパターンにおけるExtendedクラスなため、
    // プロジェクト独自のメソッドを追加することが可能。(再自動生成時に上書きされない)
    // - - - - - - - - - -/

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Log instance for sub class. */
    private static final Log _log = LogFactory.getLog(MemberBhv.class);

    // ===================================================================================
    //                                                                          CSV Output
    //                                                                          ==========
    /**
     * 会員の購入数の集計CSVを作成する。
     * 大量件数になる可能性があるため、カーソルフェッチで実現している。
     * 「現場ソリューション DBFlute」における「大量件数」の例題。
     * @param pmb The parameter bean of Purchase Summary Member. (NotNull)
     */
    public void makeCsvPurchaseSummaryMember(final PurchaseSummaryMemberPmb pmb) {
        final String path = PATH_selectPurchaseSummaryMember;
        this.outsideSql().cursorHandling().selectCursor(path, pmb, new PurchaseSummaryMemberCursorHandler() {
            public Object fetchCursor(final PurchaseSummaryMemberCursor cursor) throws SQLException {
                while (cursor.next()) {
                    final Integer memberId = cursor.getMemberId();
                    final String memberName = cursor.getMemberName();
                    final Date birthdate = cursor.getBirthdate();
                    final Timestamp formalizedDatetime = cursor.getFormalizedDatetime();
                    final Long purchaseSummary = cursor.getPurchaseSummary();

                    // logging only here because of example
                    final String c = ", ";
                    final StringBuilder sb = new StringBuilder();
                    sb.append(memberId).append(c).append(memberName).append(c);
                    sb.append(birthdate).append(c).append(formalizedDatetime).append(c);
                    sb.append(purchaseSummary);
                    _log.debug(sb.toString());
                } // ResultSetのCloseはFrameworkが行うので必要なし
                return null; // ここで処理が完結してるので戻り値は不要
            }
        });
    }
}
