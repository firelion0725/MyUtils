package com.leo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: leo zhangwei
 * @Description: java类作用描述
 * @CreateDate: 2020/11/27 7:11 PM
 */
public class UrlUtils {

    public static String appendParams(String url, String key, String value) {
        Map<String, String> map = new HashMap<>(1);
        map.put(key, value);
        return appendParams(url, map, false);
    }

    public static String appendParams(String url, String key, String value, boolean isEndAppend) {
        Map<String, String> map = new HashMap<>(1);
        map.put(key, value);
        return appendParams(url, map, isEndAppend);
    }

    public static String appendParams(String url, Map map, boolean isEndAppend) {
        if (url == null || url.length() == 0) {
            return url;
        }

        //参数标志 ？ 的位置
        int queryIndex = url.indexOf("?");
        //锚点标志 # 的位置
        int fragmentIndex = url.indexOf("#");
        StringBuffer builder = new StringBuffer(url);
        if (queryIndex == -1 && fragmentIndex == -1) {
            //既没有参数也没有锚点,单纯尾部追加参数
            return appendParamsWithNoQueryAndNoFragment(builder, map);
        }

        if (queryIndex != -1 && fragmentIndex == -1) {
            //这是尾部有参数 但是没有锚点
            return appendParamsWithNoFragment(builder, map);
        }

        if (queryIndex == -1) {
            //这是没有参数 但是有锚点
            return appendParamsWithNoQuery(builder, map, fragmentIndex, isEndAppend);
        }

        //最后处理既有参数也有锚点的URL

        return appendParamsWithQueryAndFragment(builder, map, queryIndex, fragmentIndex);
    }

    /**
     * 没有query 有fragment
     */
    public static String appendParamsWithQueryAndFragment(StringBuffer buffer, Map map, int queryIndex, int fragmentIndex) {
        if (queryIndex < fragmentIndex) {
            //参数在前锚点在后
            return appendParamsWithNoQuery(buffer, map, fragmentIndex, false);
        } else {
            //锚点在前参数在后 直接拼接
            return appendParamsWithNoFragment(buffer, map);
        }
    }

    /**
     * 没有query 有fragment
     */
    public static String appendParamsWithNoQuery(StringBuffer buffer, Map map, int fragmentIndex, boolean isEndAppend) {
        if (isEndAppend) {
            return appendParamsWithNoQueryAndNoFragment(buffer, map);
        } else {
            //有锚点无参数 通过锚点位置 将字符串截为两段， 前一部分进行query拼接，之后再拼接锚点部分
            String str1 = buffer.substring(0, fragmentIndex);
            String str2 = buffer.substring(fragmentIndex, buffer.length());
            StringBuffer sb = new StringBuffer(str1);
            str1 = appendParamsWithNoQueryAndNoFragment(sb, map);
            return str1 + str2;
        }
    }

    /**
     * 有query 没有fragment
     */
    public static String appendParamsWithNoFragment(StringBuffer buffer, Map map) {
        //有参数没有锚点
        if (buffer.charAt(buffer.length() - 1) != '?') {
            buffer.append("&");
        }
        appendWithMap(buffer, map);
        return buffer.toString();
    }

    /**
     * 没有query 没有fragment
     */
    public static String appendParamsWithNoQueryAndNoFragment(StringBuffer buffer, Map map) {
        //既没有参数也没有锚点
        if (!buffer.toString().contains("?")) {
            buffer.append("?");
        } else {
            if (buffer.charAt(buffer.length() - 1) != '?') {
                buffer.append("&");
            }
        }
        appendWithMap(buffer, map);
        return buffer.toString();
    }

    //尾部追加逻辑
    public static void appendWithMap(StringBuffer buffer, Map map) {
        for (Object key : map.keySet()) {
            buffer.append(key)
                    .append("=")
                    .append(map.get(key));
            buffer.append("&");
        }
        buffer.deleteCharAt(buffer.length() - 1);
    }

}
