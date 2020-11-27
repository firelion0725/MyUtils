package com.leo.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: leo zhangwei
 * @Description: java类作用描述
 * @CreateDate: 2020/11/27 7:13 PM
 */
public class UrlUtilsTest {

    private void show(String str) {
        System.out.println(str);
    }

    @Test
    public void appendParams() {
        String data1 = "https://leo.test.com/try/index.html";

        String data2 = "https://leo.test.com/try/index.html?";
        String data3 = "https://leo.test.com/try/index.html?name=aaa&age=25";

        String data4 = "https://leo.test.com/try/index.html#/addBankCard";
        String data5 = "https://leo.test.com/try/index.html#/addBankCard?";
        String data6 = "https://leo.test.com:443/try/index.html#/agreementPay?name=aaa&age=25";
        String data7 = "https://leo.test.com/try/index.html?name=aaa&age=25#/addBankCard";
        String data8 = "https://leo.test.com/try/index.html?#/addBankCard";


//                String data1 = "https://leo.test.com:443/try/index.html#/agreementPay?name=aaa&age=25";
//        String data2 = "https://leo.test.com/try/index.html#/addBankCard?";
//        String data3 = "https://leo.test.com/try/index.html#/addBankCard";
//        String data4 = "https://leo.test.com/try/index.html?name=aaa&age=25#/addBankCard";
//        String data5 = "https://leo.test.com/try/index.html?name=aaa&age=25/!#/addBankCard";
//        String data6 = "https://leo.test.com/try/index.html?/#addBankCard";
//        String data9 = "https://leo.test.com/try/index.html?name=aaa";

        String key = "test";
        String value = "tttttt";
//        String result = UrlUtils.appendParams(data7, key, value);


        String pre_result1 = "https://leo.test.com/try/index.html?" + key + "=" + value;

        String pre_result2 = "https://leo.test.com/try/index.html?" + key + "=" + value;
        String pre_result3 = "https://leo.test.com/try/index.html?name=aaa&age=25&" + key + "=" + value;

        String pre_result4 = "https://leo.test.com/try/index.html?" + key + "=" + value + "#/addBankCard";
        String pre_result5 = "https://leo.test.com/try/index.html#/addBankCard?" + key + "=" + value;
        String pre_result6 = "https://leo.test.com:443/try/index.html#/agreementPay?name=aaa&age=25&" + key + "=" + value;
        String pre_result7 = "https://leo.test.com/try/index.html?name=aaa&age=25&" + key + "=" + value + "#/addBankCard";
        String pre_result8 = "https://leo.test.com/try/index.html?" + key + "=" + value + "#/addBankCard";


//        String pre_result1 = "https://leo.test.com:443/try/index.html#/agreementPay?name=aaa&age=25&" + key + "=" + value;
//        String pre_result2 = "https://leo.test.com/try/index.html#/addBankCard?" + key + "=" + value;
//        String pre_result3 = "https://leo.test.com/try/index.html#/addBankCard?" + key + "=" + value;
//        String pre_result4 = "https://leo.test.com/try/index.html?" + key + "=" + value + "&name=aaa&age=25" + "#/addBankCard";
//        String pre_result5 = "https://leo.test.com/try/index.html?" + key + "=" + value + "&name=aaa&age=25" + "/!#/addBankCard";
//        String pre_result6 = "https://leo.test.com/try/index.html?"+key+"="+value+"/#addBankCard";
//        String pre_result7 = "https://leo.test.com/try/index.html?" + key + "=" + value;
//        String pre_result8 = "https://leo.test.com/try/index.html?" + key + "=" + value;
//        String pre_result9 = "https://leo.test.com/try/index.html?name=aaa&" + key + "=" + value;


//        show("result   " + result);
//        Assert.assertEquals(result, pre_result7);

//        Assert.assertEquals(UrlUtils.appendParams(data1, key, value), pre_result1);
//        Assert.assertEquals(UrlUtils.appendParams(data2, key, value), pre_result2);
//        Assert.assertEquals(UrlUtils.appendParams(data3, key, value), pre_result3);
//        Assert.assertEquals(UrlUtils.appendParams(data4, key, value), pre_result4);
//        Assert.assertEquals(UrlUtils.appendParams(data5, key, value), pre_result5);
//        Assert.assertEquals(UrlUtils.appendParams(data6, key, value), pre_result6);
//        Assert.assertEquals(UrlUtils.appendParams(data7, key, value), pre_result7);
        Assert.assertEquals(UrlUtils.appendParams(data8, key, value), pre_result8);
    }
}