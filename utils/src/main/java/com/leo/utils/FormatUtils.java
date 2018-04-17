package com.leo.utils;

import java.math.BigDecimal;

/**
 * Created by leo on 2016/8/5
 * Function
 */
public class FormatUtils {

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange(float value, int scales) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange(double value, int scales) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange(float value) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange(double value) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Double
     */
    public static double formatChangeToDouble(float value, int scales) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.doubleValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Double
     */
    public static double formatChangeToDouble(double value, int scales) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.doubleValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的double
     */
    public static double formatChangeToDouble(float value) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd1.doubleValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的double
     */
    public static double formatChangeToDouble(double value) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd1.doubleValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Float
     */
    public static float formatChangeToFloat(float value, int scales) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.floatValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Float
     */
    public static float formatChangeToFloat(double value, int scales) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.floatValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange2(float value) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(0, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange2(double value) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(0, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Integer
     */
    public static int formatChangeToInteger(float value) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(0, BigDecimal.ROUND_HALF_UP);
        return bd1.intValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Integer
     */
    public static int formatChangeToInteger(double value) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(0, BigDecimal.ROUND_HALF_UP);
        return bd1.intValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的double型
     * 并指定舍入模式
     */
    public static double formatChange(double value, int newScale, int roundingMode) {
        BigDecimal bd1 = new BigDecimal(value);
        bd1 = bd1.setScale(newScale, roundingMode);
        return bd1.doubleValue();
    }

    /**
     * double型的指定位数小数相加
     */
    public static double add(double parameter1, int scales1, double parameter2, int scales2) {
        BigDecimal bd1 = new BigDecimal(parameter1);
        bd1 = bd1.setScale(scales1, BigDecimal.ROUND_HALF_UP);
        BigDecimal bd2 = new BigDecimal(parameter2);
        bd2 = bd2.setScale(scales2, BigDecimal.ROUND_HALF_UP);
        return bd1.add(bd2).doubleValue();
    }

    /**
     * double型的两位小数相加
     */
    public static double add(double parameter1, double parameter2) {
        BigDecimal bd1 = new BigDecimal(parameter1);
        bd1 = bd1.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal bd2 = new BigDecimal(parameter2);
        bd2 = bd2.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd1.add(bd2).doubleValue();
    }
}
