package com.leo.utils;

/**
 * Created by Leo on 2017/9/28
 * Function:
 */

public class StringUtils {

    /**
     * 拼接字符串
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
     * @param string 需要判断字符
     * @return true：为正常字符（汉字+数字+大小写英文） false：有特殊字符
     */
    public static boolean isConSpeCharacters(String string) {
        // TODO Auto-generated method stub
        if(string.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length()==0){
            //如果不包含特殊字符
            return true;
        }
        return false;
    }
}
