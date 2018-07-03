package com.leo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 注册表读写类
 * Created by Leo on 2015/10/9
 */
public class SharedPreferencesUtils {

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
    public static void writeToSharedPreferences(@NonNull Context context, @NonNull String key, @NonNull String value) {
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
    public static void writeStringMapToSharedPreferences(@NonNull Context context, @NonNull Map<String, String> map) {
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
    public static void writeToSharedPreferences(@NonNull Context context, @NonNull String key, @NonNull boolean value) {

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
    public static void writeBooleanMapToSharedPreferences(@NonNull Context context, @NonNull Map<String, Boolean> map) {
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
    public static void writeToSharedPreferences(@NonNull Context context, @NonNull String key, @NonNull int value) {
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
    public static void writeIntegerMapToSharedPreferences(@NonNull Context context, @NonNull Map<String, Integer> map) {
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
    public static void writeToSharedPreferences(@NonNull Context context, @NonNull String key, @NonNull long value) {
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
    public static void writeLongMapToSharedPreferences(@NonNull Context context, @NonNull Map<String, Long> map) {
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
    public static void writeToSharedPreferences(@NonNull Context context, @NonNull String key, @NonNull float value) {
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
    public static void writeFloatMapToSharedPreferences(@NonNull Context context, @NonNull Map<String, Float> map) {
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
    public static String readStringFromSharedPreferences(@NonNull Context context, @NonNull String key) {
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
    public static boolean readBooleanFromSharedPreferencesDefaultFalse(@NonNull Context context, @NonNull String key) {
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
    public static boolean readBooleanFromSharedPreferencesDefaultTrue(@NonNull Context context, @NonNull String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getBoolean(key, true);
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     */
    public static int readIntFromSharedPreferences(@NonNull Context context, @NonNull String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getInt(key, 0);
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     */
    public static long readLongFromSharedPreferences(@NonNull Context context, @NonNull String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getLong(key, 0);
    }

    /**
     * 读取注册表
     *
     * @param context 依赖环境
     * @param key     键
     */
    public static float readFloatFromSharedPreferences(@NonNull Context context, @NonNull String key) {
        SharedPreferences pref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return pref.getFloat(key, 0);
    }
}
