package com.leo.utils;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author leo
 * @date 2017/9/28
 * @function
 */

public class StringUtils {

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private StringUtils() {
    }

    /**
     * 拼接字符串
     *
     * @param strs 需要拼接字符
     * @return 拼接完成后字符
     */
    public static String stringAppend(String... strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 拼接字符串
     *
     * @param objs 需要拼接字符
     * @return 拼接完成后字符
     */
    public static String stringAppend(Object... objs) {
        StringBuilder sb = new StringBuilder();
        for (Object str : objs) {
            sb.append(str);
        }
        return sb.toString();
    }

    /**
     * 判断是否有特殊字符
     *
     * @param string 需要判断字符
     * @return true：为正常字符（汉字+数字+大小写英文） false：有特殊字符
     */
    public static boolean isConSpeCharacters(String string) {
        // TODO Auto-generated method stub
        if (string.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() == 0) {
            //如果不包含特殊字符
            return true;
        }
        return false;
    }

    /**
     * 手机号码隐藏中间四位
     *
     * @param phoneNumber 手机号码
     * @return
     */
    public static String hidePhone(String phoneNumber) {
        return phoneNumber.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static String currencyFormat(double number, Locale locale) {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        return format.format(number);
    }

    public static String currencyFormat(long number, Locale locale) {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        return format.format(number);
    }
}
