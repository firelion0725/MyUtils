package com.leo.utils;

import android.content.Context;

import java.io.File;

/**
 * @author leo, ZhangWei
 * @date 2018/5/2
 * @function 操作Android默认cache
 */
public class AndroidDefaultCacheUtils {

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private AndroidDefaultCacheUtils() {
    }


    public static File getDefaultCache(Context context) {
        return context.getCacheDir();
    }

    public static String getDefaultCachePath(Context context) {
        return context.getCacheDir().getAbsolutePath();
    }
}
