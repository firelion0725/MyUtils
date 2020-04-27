package com.leo.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author leo
 * @date 2017/8/29
 * @function : 屏幕分辨率工具类
 */

public class ScreenUtils {

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private ScreenUtils() {
    }

    private static int screenWidth = -1, screenHeight = -1;

    /**
     * 获取屏幕的宽度（单位：px）
     */
    public static int getScreenWidth(Application application) {
        if (screenWidth < 0) {
            screenWidth = application.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
        }
        return screenWidth;
    }

    /**
     * 获取屏幕的高度（单位：px）
     *
     * @return 屏幕高
     */
    public static int getScreenHeight(Application application) {
        if (screenHeight < 0) {
            screenHeight = application.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
        }
        return screenHeight;
    }

    /**
     * dp转px
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dp2px(float dpValue) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float scale = displayMetrics.density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * px转dp
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dp(float pxValue) {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        float scale = displayMetrics.density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param spValue sp值
     * @return px值
     */
    public static int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param pxValue px值
     * @return sp值
     */
    public static int px2sp(Context context, float pxValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 测量视图尺寸
     *
     * @param view 视图
     * @return arr[0]: 视图宽度, arr[1]: 视图高度
     */
    public static int[] measureView(final View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp == null) {
            lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
            );
        }
        int widthSpec = ViewGroup.getChildMeasureSpec(0, 0, lp.width);
        int lpHeight = lp.height;
        int heightSpec;
        if (lpHeight > 0) {
            heightSpec = View.MeasureSpec.makeMeasureSpec(lpHeight, View.MeasureSpec.EXACTLY);
        } else {
            heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }
        view.measure(widthSpec, heightSpec);
        return new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    /**
     * 获取测量视图宽度
     *
     * @param view 视图
     * @return 视图宽度
     */
    public static int getMeasuredWidth(final View view) {
        return measureView(view)[0];
    }

    /**
     * 获取测量视图高度
     *
     * @param view 视图
     * @return 视图高度
     */
    public static int getMeasuredHeight(final View view) {
        return measureView(view)[1];
    }


    public static void adapterScreen(Activity activity, int targetDp, boolean isVertical) {
        DisplayMetrics systemDm = Resources.getSystem().getDisplayMetrics();
        DisplayMetrics appDm = activity.getApplication().getResources().getDisplayMetrics();
        DisplayMetrics activityDm = activity.getResources().getDisplayMetrics();

        //通过目标DP 算出 逻辑密度
        if (isVertical) {
            activityDm.density = activityDm.heightPixels / (float) targetDp;
        } else {
            activityDm.density = activityDm.widthPixels / (float) targetDp;
        }

        //通过逻辑密度 算出比例密度
        activityDm.scaledDensity = activityDm.density * (systemDm.scaledDensity / systemDm.density);
        //算出 密度DPI 即修改没英寸的像素点数量
        activityDm.densityDpi = (int) (DisplayMetrics.DENSITY_DEFAULT * activityDm.density);
    }
}
