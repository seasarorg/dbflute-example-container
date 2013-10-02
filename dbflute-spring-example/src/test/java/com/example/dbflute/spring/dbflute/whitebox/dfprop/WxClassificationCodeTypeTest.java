package com.example.dbflute.spring.dbflute.whitebox.dfprop;

import org.seasar.dbflute.jdbc.ClassificationCodeType;
import org.seasar.dbflute.s2dao.valuetype.TnValueTypes;

import com.example.dbflute.spring.dbflute.allcommon.CDef;
import com.example.dbflute.spring.unit.UnitContainerTestCase;

/**
 * @author jflute
 * @since 0.9.5.3 (2009/08/01 Saturdayy)
 */
public class WxClassificationCodeTypeTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                          ColumnInfo
    //                                                                          ==========
    public void test_dataType() {
        // ## Arrange ##
        ClassificationCodeType numberType = ClassificationCodeType.Number;
        ClassificationCodeType stringType = ClassificationCodeType.String;

        // ## Act & Assert ##
        assertEquals(numberType, CDef.Flg.True.meta().codeType()); // as specified
        assertEquals(stringType, CDef.MemberStatus.Formalized.meta().codeType()); // as default
        assertEquals(TnValueTypes.CLASSIFICATION, TnValueTypes.getValueType(CDef.Flg.True));
    }
}