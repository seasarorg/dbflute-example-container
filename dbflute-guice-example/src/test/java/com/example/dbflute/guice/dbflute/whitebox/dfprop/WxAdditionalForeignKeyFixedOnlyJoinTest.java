package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.optional.OptionalThingConsumer;

import com.example.dbflute.guice.dbflute.cbean.PurchaseCB;
import com.example.dbflute.guice.dbflute.exbhv.PurchaseBhv;
import com.example.dbflute.guice.dbflute.exbhv.WhiteDateTermBhv;
import com.example.dbflute.guice.dbflute.exentity.Purchase;
import com.example.dbflute.guice.dbflute.exentity.WhiteDateTerm;
import com.example.dbflute.guice.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 1.1.0 (2014/10/22 Wednesday)
 */
public class WxAdditionalForeignKeyFixedOnlyJoinTest extends UnitContainerTestCase {

    private PurchaseBhv purchaseBhv;
    private WhiteDateTermBhv whiteDateTermBhv;

    public void test_fixedOnlyJoin_SetupSelect_basic() throws Exception {
        // ## Arrange ##
        registerDateTerm();

        // ## Act ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_WhiteDateTermAsValid();
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (final Purchase purchase : purchaseList) {
            purchase.getWhiteDateTermAsValid().alwaysPresent(new OptionalThingConsumer<WhiteDateTerm>() {
                public void accept(WhiteDateTerm term) {
                    log(purchase.getPurchaseId(), purchase.getPurchaseDatetime(), term);
                }
            }); // expects no exception
        }
        String sql = cb.toDisplaySql();
        assertContainsAll(sql, "  on dfrel", ".BEGIN_DATE <= dfloc.PURCHASE_DATETIME");
        assertContainsAll(sql, " and dfrel", ".END_DATE >= dfloc.PURCHASE_DATETIME");
    }

    public void test_fixedOnlyJoin_QueryRelation_basic() throws Exception {
        // ## Arrange ##
        registerDateTerm();

        // ## Act ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_WhiteDateTermAsValid();
        cb.query().queryWhiteDateTermAsValid().setDateTermValue_Equal("sea");
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (final Purchase purchase : purchaseList) {
            purchase.getWhiteDateTermAsValid().alwaysPresent(new OptionalThingConsumer<WhiteDateTerm>() {
                public void accept(WhiteDateTerm term) {
                    log(purchase.getPurchaseId(), purchase.getPurchaseDatetime(), term);
                }
            }); // expects no exception
        }
    }

    protected void registerDateTerm() {
        doRegisterDateTerm(1001L, "sea", "1900/09/26", "2006/09/25");
        doRegisterDateTerm(1002L, "land", "2006/09/26", "2007/10/31");
        doRegisterDateTerm(1003L, "iks", "2007/11/01", "2007/12/31");
        doRegisterDateTerm(1004L, "amphi", "2008/01/01", "2099/08/20");
    }

    protected void doRegisterDateTerm(Long id, String value, String begin, String end) {
        WhiteDateTerm term = new WhiteDateTerm();
        term.setDateTermId(id);
        term.setDateTermValue(value);
        term.setBeginDate(toLocalDate(begin));
        term.setEndDate(toLocalDate(end));
        whiteDateTermBhv.insert(term);
    }
}
