package com.leo.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * 注册表读写类
 * Created by Leo on 2015/10/9
 */
public class SharedPreferencesUtils {

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private SharedPreferencesUtils() {
    }

    /**
     * 注册表名称
     */
    private static final String PREFERENCES_NAME = "com.zlw";

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param key     键
     * @param value   值
     */
    public static void writeToSharedPreferences(Context context, String key, String value) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param map     数据源（键值对）
     */
    public static void writeStringMapToSharedPreferences(Context context, Map<String, String> map) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            editor.putString(entry.getKey(), entry.getValue());
        }
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param key     键
     * @param value   值
     */
    public static void writeToSharedPreferences(Context context, String key, boolean value) {

        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param map     数据源（键值对）
     */
    public static void writeBooleanMapToSharedPreferences(Context context, Map<String, Boolean> map) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            editor.putBoolean(entry.getKey(), entry.getValue());
        }
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param key     键
     * @param value   值
     */
    public static void writeToSharedPreferences(Context context, String key, int value) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param map     数据源（键值对）
     */
    public static void writeIntegerMapToSharedPreferences(Context context, Map<String, Integer> map) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            editor.putInt(entry.getKey(), entry.getValue());
        }
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param key     键
     * @param value   值
     */
    public static void writeToSharedPreferences(Context context, String key, long value) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param map     数据源（键值对）
     */
    public static void writeLongMapToSharedPreferences(Context context, Map<String, Long> map) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        for (Map.Entry<String, Long> entry : map.entrySet()) {
            editor.putLong(entry.getKey(), entry.getValue());
        }
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param key     键
     * @param value   值
     */
    public static void writeToSharedPreferences(Context context, String key, float value) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * 写入注册表
     *
     * @param context 依赖环境
     * @param map     数据源（键值对）
     */
    public static void writeFloatMapToSharedPreferences(Context context, Map<String, Float> map) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        for (Map.Entry<String, Float> entry : map.entrySet()) {
            editor.putFloat(entry.getKey(), entry.getValue());
        }
        editor.apply();
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     */
    public static String readStringFromSharedPreferences(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getString(key, "");
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     * @return 默认返回false
     */
    public static boolean readBooleanFromSharedPreferencesDefaultFalse(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getBoolean(key, false);
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     * @return 默认返回true
     */
    public static boolean readBooleanFromSharedPreferencesDefaultTrue(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getBoolean(key, true);
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     */
    public static int readIntFromSharedPreferences(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getInt(key, 0);
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     */
    public static long readLongFromSharedPreferences(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getLong(key, 0);
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     */
    public static float readFloatFromSharedPreferences(Context context, String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getFloat(key, 0);
    }
}
