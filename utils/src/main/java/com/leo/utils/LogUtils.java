package com.leo.utils;

import android.util.Log;

/**
 * Created by Leo on 2017/8/30
 * Function:Log日志类
 */

public class LogUtils {

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private LogUtils() {
    }

    private static boolean showLog = true;

    public static void setShowLog(boolean showLog) {
        LogUtils.showLog = showLog;
    }

    public static boolean isShowLog() {
        return showLog;
    }

    public static void v(String tag, String msg) {
        if (showLog) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (showLog) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (showLog) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (showLog) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (showLog) {
            Log.e(tag, msg);
        }
    }

}
