package com.leo.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * @author leo, ZhangWei
 * @date 2018/7/3
 */
public class KeyboardUtils {

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private KeyboardUtils() {
    }

    /**
     * Show the soft input.
     *
     * @param view The view.
     */
    public static void showSoftInput(Activity activity, final View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
            imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        }
    }


    /**
     * 动态显示软键盘
     *
     * @param activity 必须是Activity的Context
     * @param view     需要获取焦点弹出软键盘的EditText
     */
    public static void showSoftKeyboard(Activity activity, View view) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.requestFocus();
    }

    /**
     * 动态隐藏软键盘
     *
     * @param activity 必须是Activity的Context
     */
    public static void hideSoftKeyboard(Activity activity) {
        View view = activity.getWindow().peekDecorView();
        InputMethodManager manager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (view != null && manager != null) {
            manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /**
     * Toggle the soft input display or not.
     */
    public static void toggleSoftInput(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }
}
