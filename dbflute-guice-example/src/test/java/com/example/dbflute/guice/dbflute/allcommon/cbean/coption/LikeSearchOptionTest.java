package com.example.dbflute.guice.dbflute.allcommon.cbean.coption;


import org.seasar.dbflute.cbean.coption.LikeSearchOption;

import com.example.dbflute.guice.unit.PlainTestCase;

/**
 * The test of likeSearchOption for Basic Example.
 * 
 * @author jflute
 * @since 0.5.9 (2007/12/20 Thursday)
 */
public class LikeSearchOptionTest extends PlainTestCase {

    // ===================================================================================
    //                                                                         Rear Option
    //                                                                         ===========
    /**
     * 後ろ(Rear)のOptionを取得するメソッド。主にはescape処理である。<br />
     * 基本的には内部メソッドではあるが、単なるユーティリティとしても利用可能である。
     * 
     * @throws Exception
     */
    public void test_getRearOption() throws Exception {
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
     * 
     * @throws Exception
     */
    public void test_generateRealValue() throws Exception {
        final String inputValue = "abc%def_ghi";
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.escapeByPipeLine();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue);

            // ## Assert ##
            log("realValue=" + realValue);
            assertEquals("abc|%def|_ghi", realValue);
        }
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.likePrefix().escapeBySlash();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue);

            // ## Assert ##
            log("realValue=" + realValue);
            assertEquals("abc/%def/_ghi%", realValue);
        }
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.likeContain().escapeByAtMark();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue);

            // ## Assert ##
            log("realValue=" + realValue);
            assertEquals("%abc@%def@_ghi%", realValue);
        }
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.likeSuffix().escapeByBackSlash();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue);

            // ## Assert ##
            log("realValue=" + realValue);
            assertEquals("%abc\\%def\\_ghi", realValue);
        }
        {
            // ## Arrange ##
            final LikeSearchOption option = new LikeSearchOption();
            option.escapeByPipeLine();

            // ## Act ##
            final String realValue = option.generateRealValue(inputValue + "jk|l");

            // ## Assert ##
            log("realValue=" + realValue);
            assertEquals("abc|%def|_ghijk||l", realValue);
        }
    }
}
