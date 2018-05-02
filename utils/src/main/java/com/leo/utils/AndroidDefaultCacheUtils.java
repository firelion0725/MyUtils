package com.leo.utils;

import android.content.Context;

import java.io.File;

/**
 * @author leo, ZhangWei
 * @date 2018/5/2
 * @function 操作Android默认cache
 */
public class AndroidDefaultCacheUtils {

    public static File getDefaultCache(Context context) {
        return context.getCacheDir();
    }

    public static String getDefaultCachePath(Context context) {
        return context.getCacheDir().getAbsolutePath();
    }
}
