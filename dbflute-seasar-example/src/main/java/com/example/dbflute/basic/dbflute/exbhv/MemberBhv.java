/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.basic.dbflute.exbhv;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.dbflute.helper.HandyDate;
import org.seasar.dbflute.helper.token.file.FileMakingCallback;
import org.seasar.dbflute.helper.token.file.FileMakingOption;
import org.seasar.dbflute.helper.token.file.FileMakingRowResource;
import org.seasar.dbflute.helper.token.file.FileMakingRowWriter;
import org.seasar.dbflute.helper.token.file.FileToken;

import com.example.dbflute.basic.dbflute.exbhv.cursor.PurchaseSummaryMemberCursor;
import com.example.dbflute.basic.dbflute.exbhv.cursor.PurchaseSummaryMemberCursorHandler;
import com.example.dbflute.basic.dbflute.exbhv.pmbean.PurchaseSummaryMemberPmb;

/**
 * The behavior of MEMBER.
 * @author DBFlute(AutoGenerator)
 * @author jflute
 */
public class MemberBhv extends com.example.dbflute.basic.dbflute.bsbhv.BsMemberBhv {

    // /- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    // このクラスは、GenerationGapパターンにおけるExtendedクラスなため、
    // プロジェクト独自のメソッドを追加することが可能。(再自動生成時に上書きされない)
    // - - - - - - - - - -/

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log _log = LogFactory.getLog(MemberBhv.class);

    // ===================================================================================
    //                                                                          CSV Output
    //                                                                          ==========
    /**
     * 会員の購入数の集計CSVを作成する。<br />
     * 大量件数になる可能性があるため、カーソルフェッチで実現している。
     * @param pmb The parameter bean of Purchase Summary Member. (NotNull)
     * @param filePath The file path for CSV. (NotNull)
     */
    public void makeCsvPurchaseSummaryMember(PurchaseSummaryMemberPmb pmb, final String filePath) {
        outsideSql().cursorHandling().selectCursor(pmb, new PurchaseSummaryMemberCursorHandler() {
            public Object fetchCursor(PurchaseSummaryMemberCursor cursor) throws SQLException {
                try {
                    doMakeCsvByCursor(filePath, cursor);
                } catch (IOException e) {
                    String msg = "Failed to make CSV: " + filePath;
                    throw new IllegalStateException(msg, e);
                }
                return null;
            }
        });
    }

    protected void doMakeCsvByCursor(String filePath, final PurchaseSummaryMemberCursor cursor) throws IOException {
        if (_log.isDebugEnabled()) {
            _log.debug("...Making CSV: " + filePath);
        }
        FileToken fileToken = new FileToken();
        List<String> columnNameList = Arrays.asList("MEMBER_ID", "MEMBER_NAME", "BIRTHDATE", "PURCHASE_SUMMARY");
        final FileMakingRowResource resource = new FileMakingRowResource();
        fileToken.make(filePath, new FileMakingCallback() {
            public void write(FileMakingRowWriter writer) throws IOException, SQLException {
                writeCursorData(cursor, writer, resource);
            }
        }, new FileMakingOption().delimitateByComma().encodeAsUTF8().separateByLf().headerInfo(columnNameList));
    }

    protected void writeCursorData(PurchaseSummaryMemberCursor cursor, FileMakingRowWriter writer,
            FileMakingRowResource resource) throws IOException, SQLException {
        while (cursor.next()) {
            Integer memberId = cursor.getMemberId();
            String memberName = cursor.getMemberName();
            Date birthdate = cursor.getBirthdate();
            Long purchaseSummary = cursor.getPurchaseSummary();

            String idDisp = memberId.toString();
            String birthDisp = birthdate != null ? new HandyDate(birthdate).toDisp("yyyy/MM/dd") : null;
            String summaryDisp = purchaseSummary != null ? purchaseSummary.toString() : null;
            List<String> valueList = Arrays.asList(idDisp, memberName, birthDisp, summaryDisp);
            if (_log.isDebugEnabled()) {
                _log.debug(" " + valueList);
            }

            writer.writeRow(valueList);
        }
    }
}
