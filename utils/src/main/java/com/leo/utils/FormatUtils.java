package com.leo.utils;

import java.math.BigDecimal;

/**
 * @author leo
 * @date 2016/8/5
 * @function 格式化
 */
public class FormatUtils {

    /**
     * 默认两位小数
     */
    private final static int DEFAULT_SCALES = 2;

    private final static int ZERO_SCALES = 0;

    private final static int DEFAULT_VALUE = 0;

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private FormatUtils() {
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange(float value, int scales) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange(double value, int scales) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange(float value) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(DEFAULT_SCALES, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange(double value) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(DEFAULT_SCALES, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Double
     */
    public static double formatChangeToDouble(float value, int scales) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.doubleValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Double
     */
    public static double formatChangeToDouble(double value, int scales) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.doubleValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的double
     */
    public static double formatChangeToDouble(float value) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(DEFAULT_SCALES, BigDecimal.ROUND_HALF_UP);
        return bd1.doubleValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的double
     */
    public static double formatChangeToDouble(double value) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(DEFAULT_SCALES, BigDecimal.ROUND_HALF_UP);
        return bd1.doubleValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Float
     */
    public static float formatChangeToFloat(float value, int scales) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.floatValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Float
     */
    public static float formatChangeToFloat(double value, int scales) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(scales, BigDecimal.ROUND_HALF_UP);
        return bd1.floatValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange2(float value) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(ZERO_SCALES, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的String字符串
     */
    public static String formatChange2(double value) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(ZERO_SCALES, BigDecimal.ROUND_HALF_UP);
        return bd1.toString();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Integer
     */
    public static int formatChangeToInteger(float value) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(ZERO_SCALES, BigDecimal.ROUND_HALF_UP);
        return bd1.intValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的Integer
     */
    public static int formatChangeToInteger(double value) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(ZERO_SCALES, BigDecimal.ROUND_HALF_UP);
        return bd1.intValue();
    }

    /**
     * 将指定的字符串转换成制定小数点位数的double型
     * 并指定舍入模式
     */
    public static double formatChange(double value, int newScale, int roundingMode) {
        BigDecimal bd1 = BigDecimal.valueOf(value);
        bd1 = bd1.setScale(newScale, roundingMode);
        return bd1.doubleValue();
    }

    /**
     * double型的指定位数小数相加
     * 异常情况会默认为0
     *
     * @return
     */
    public static BigDecimal add(double parameter1, int scales1, double parameter2, int scales2) {
        int p = Math.max(scales1, scales2);
        BigDecimal bd1;
        BigDecimal bd2;
        try {
            bd1 = BigDecimal.valueOf(parameter1);
            bd2 = BigDecimal.valueOf(parameter2);
        } catch (Exception e) {
            bd1 = new BigDecimal(DEFAULT_VALUE);
            bd2 = new BigDecimal(DEFAULT_VALUE);
        }
        BigDecimal result = bd1.add(bd2);
        result = result.setScale(p, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    /**
     * double型的两位小数相加
     */
    public static double addToDouble(double parameter1, int scales1, double parameter2, int scales2) {
        return add(parameter1, scales1, parameter2, scales2).doubleValue();
    }

    public static BigDecimal subtract(double value1, int scales1, double value2, int scales2) {
        int p = Math.max(scales1, scales2);
        BigDecimal bd1;
        BigDecimal bd2;
        try {
            bd1 = BigDecimal.valueOf(value1);
            bd2 = BigDecimal.valueOf(value2);
        } catch (Exception e) {
            bd1 = new BigDecimal(DEFAULT_VALUE);
            bd2 = new BigDecimal(DEFAULT_VALUE);
        }
        BigDecimal result = bd1.subtract(bd2);
        result = result.setScale(p, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    public static double subtractToDouble(double parameter1, int scales1, double parameter2, int scales2) {
        return subtract(parameter1, scales1, parameter2, scales2).doubleValue();
    }

    public static BigDecimal multiply(double value1, int scales1, double value2, int scales2) {
        int p = Math.max(scales1, scales2);
        BigDecimal bd1;
        BigDecimal bd2;
        try {
            bd1 = BigDecimal.valueOf(value1);
            bd2 = BigDecimal.valueOf(value2);
        } catch (Exception e) {
            bd1 = new BigDecimal(DEFAULT_VALUE);
            bd2 = new BigDecimal(DEFAULT_VALUE);
        }
        BigDecimal result = bd1.multiply(bd2);
        result = result.setScale(p, BigDecimal.ROUND_HALF_UP);
        return result;
    }

    public static double multiplyToDouble(double parameter1, int scales1, double parameter2, int scales2) {
        return multiply(parameter1, scales1, parameter2, scales2).doubleValue();
    }

    public static BigDecimal divide(double value1, int scales1, double value2, int scales2) {
        int p = Math.max(scales1, scales2);
        BigDecimal bd1;
        BigDecimal bd2;
        try {
            bd1 = BigDecimal.valueOf(value1);
            bd2 = BigDecimal.valueOf(value2);
        } catch (Exception e) {
            bd1 = new BigDecimal(DEFAULT_VALUE);
            bd2 = new BigDecimal(DEFAULT_VALUE);
        }

        if (bd2.doubleValue() == 0) {
            return new BigDecimal(DEFAULT_VALUE);
        }
        return bd1.divide(bd2, p, BigDecimal.ROUND_HALF_UP);
    }

    public static double divideToDouble(double parameter1, int scales1, double parameter2, int scales2) {
        return divide(parameter1, scales1, parameter2, scales2).doubleValue();
    }
}
