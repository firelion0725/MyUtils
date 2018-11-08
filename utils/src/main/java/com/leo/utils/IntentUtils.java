package com.leo.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;

import java.io.File;

/**
 * @author leo
 * @date 2017/8/31
 * @function 意图的快捷
 */

public class IntentUtils {

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private IntentUtils() {
    }

    /**
     * 获取跳至拨号界面意图
     *
     * @param phoneNumber 电话号码
     */
    public static Intent getDialIntent(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
        return intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    /**
     * 获取拍照的意图
     *
     * @param outUri 输出的uri
     * @return 拍照的意图
     */
    public static Intent getCaptureIntent(Uri outUri) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outUri);
        return intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    /**
     * 获取安装App(支持7.0)的意图
     *
     * @param file      文件
     * @param authority 7.0及以上安装需要传入清单文件中的{@code <provider>}的authorities属性
     *                  <br>参看https://developer.android.com/reference/android/support/v4/content/FileProvider.html
     * @return intent
     */
    public static Intent getInstallAppIntent(Context context, File file, String authority) {
        if (file == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri data;
        String type = "application/vnd.android.package-archive";
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            data = Uri.fromFile(file);
        } else {
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            data = FileProvider.getUriForFile(context, authority, file);
        }
        intent.setDataAndType(data, type);
        return intent;
    }

}
