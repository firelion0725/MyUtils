package com.leo.utils;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * @author leo, ZhangWei
 * @date 2018/4/20
 * @function Toast工具类
 */
public class ToastUtils {

    private final static String TAG = "ToastUtils";

    private static Toast toast;

    private static Handler handler = new Handler();

    public static void showToastShort(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT, false);
    }

    public static void showToastLong(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG, false);
    }

    public static void showToastShortQueen(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT, true);
    }

    public static void showToastLongQueen(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG, true);
    }

    private static void showToast(Context context, String message, int duration, boolean isQueen) {
        if (!isQueen) {
            cancelToast();
        }
        if (null == toast) {
            toast = Toast.makeText(context, message, duration);
        }
        Log.i(TAG, "show");

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.show();
            }
        }, 100);

    }

    private static void cancelToast() {
        if (null != toast) {
            toast.cancel();
        }
    }

}
