package com.leo.utils;

/**
 * Created by Leo on 2017/9/28
 * Function:
 */

public class StringUtils {

    public static String StringAppend(String... strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static String StringAppend(Object... objs) {
        StringBuilder sb = new StringBuilder();
        for (Object str : objs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
