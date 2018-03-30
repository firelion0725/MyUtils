package com.leo.utils;

import android.os.Environment;
import android.os.StatFs;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.File;

/**
 * Created by Leo on 2017/8/31
 * Function: sd卡工具类
 */

public class SDCardUtils {

    private static final String TAG = "SDCardUtils";

    private static boolean ishasCard;
    private static String sDCardPath;

    public SDCardUtils() {
        ishasCard = isSDCardEnable();
        sDCardPath = getPath();
    }

    /**
     * 是否有SD卡
     */
    public static boolean ishasCard() {
        return ishasCard;
    }

    /**
     * SD卡路径
     */
    public static String getSDCardPath() {
        return sDCardPath;
    }

    private static String getPath() {
        return Environment.getExternalStorageDirectory().getPath();
    }

    /**
     * 判断SD卡是否可用
     *
     * @return true : 可用<br>false : 不可用
     */
    private static boolean isSDCardEnable() {
        return TextUtils.equals(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState());
    }

    /**
     * SD卡剩余空间大小
     */
    public static long getSDFreeSize() {
        StatFs sf = new StatFs(sDCardPath);
        //获取单个数据块的大小(Byte)
        long blockSize = sf.getBlockSizeLong();
        //空闲的数据块的数量
        long freeBlocks = sf.getAvailableBlocksLong();
        //返回SD卡空闲大小 单位MB
        return (freeBlocks * blockSize) / 1024 / 1024;
    }

    private static boolean isHasDir(String path) {
        File file = new File(path);
        return file.exists();
    }

    private static boolean isFileExists(@NonNull final File file) {
        return file.exists();
    }

    /**
     * 创建目录
     */
    public static void makeDirs(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                MyLog.w(TAG, "make dirs fail!");
            }
        }
    }

    // 删除文件
    public static void deleteFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (!file.delete()) {
                MyLog.w(TAG, "delete file fail!");
            }
        }
    }
}
