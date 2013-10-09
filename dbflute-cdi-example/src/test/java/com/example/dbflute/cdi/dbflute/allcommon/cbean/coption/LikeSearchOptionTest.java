package com.example.dbflute.cdi.dbflute.allcommon.cbean.coption;

import static org.junit.Assert.*;

import org.junit.Test;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;

import com.example.dbflute.cdi.unit.PlainTestCase;

/**
 * The test of like-search option.
 * @author jflute
 * @since 0.5.9 (2007/12/20 Thursday)
 */
public class LikeSearchOptionTest extends PlainTestCase {

    // ===================================================================================
    //                                                                         Rear Option
    //                                                                         ===========
    @Test
    public void test_getRearOption() {
        // ## Arrange ##
        final LikeSearchOption option = new LikeSearchOption();
        option.escapeByPipeLine();

        // ## Act ##
        final String rearOption = option.getRearOption();

        // ## Assert ##
        assertEquals("escape '|'", rearOption.trim());
    }

    // ===================================================================================
    //                                                                          Real Value
    //                                                                          ==========
    /**
     * OptionでValueが変化する場合の“本当の値”を生成するメソッド。<br />
     * 基本的には内部メソッドではあるが、単なるユーティリティとしても利用可能である。
     */
    @Test
    public void test_generateRealValue() {
        final String inputValue = "abc%def_ghi";
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.escapeByPipeLine();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue);

            // ## Assert ##
            this.log("realValue=" + realValue);
            assertEquals("abc|%def|_ghi", realValue);
        }
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.likePrefix().escapeBySlash();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue);

            // ## Assert ##
            this.log("realValue=" + realValue);
            assertEquals("abc/%def/_ghi%", realValue);
        }
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.likeContain().escapeByAtMark();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue);

            // ## Assert ##
            this.log("realValue=" + realValue);
            assertEquals("%abc@%def@_ghi%", realValue);
        }
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.likeSuffix().escapeByBackSlash();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue);

            // ## Assert ##
            this.log("realValue=" + realValue);
            assertEquals("%abc\\%def\\_ghi", realValue);
        }
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.escapeByPipeLine();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue + "jk|l");

            // ## Assert ##
            this.log("realValue=" + realValue);
            assertEquals("abc|%def|_ghijk||l", realValue);
        }
    }
}
