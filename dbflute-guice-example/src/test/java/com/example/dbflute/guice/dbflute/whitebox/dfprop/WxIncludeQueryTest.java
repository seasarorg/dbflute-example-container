package com.example.dbflute.guice.dbflute.whitebox.dfprop;

import org.seasar.dbflute.dbmeta.info.ColumnInfo;
import org.seasar.dbflute.exception.ConditionInvokingFailureException;

import com.example.dbflute.guice.dbflute.bsentity.dbmeta.ProductStatusDbm;
import com.example.dbflute.guice.dbflute.cbean.MemberCB;
import com.example.dbflute.guice.dbflute.cbean.ProductCB;
import com.example.dbflute.guice.unit.PlainTestCase;

/**
 * @author jflute
 */
public class WxIncludeQueryTest extends PlainTestCase {

    public void test_exclude_revive() {
        {
            MemberCB cb = new MemberCB();
            cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
            cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Desc(); // revived
        }
        {
            ProductCB cb = new ProductCB();
            ColumnInfo displayOrder = ProductStatusDbm.getInstance().columnDisplayOrder();
            cb.query().queryProductStatus().addOrderBy_DisplayOrder_Asc();
            String columnDbName = displayOrder.getColumnDbName();
            cb.query().queryProductStatus().invokeOrderBy(columnDbName, true);
            try {
                cb.query().queryProductStatus().invokeOrderBy(columnDbName, false); // excluded
                fail();
            } catch (ConditionInvokingFailureException e) {
                log(e.getClass());
                log(e.getMessage());
            }
        }
    }
}
