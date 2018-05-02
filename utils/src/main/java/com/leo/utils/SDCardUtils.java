package com.leo.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.io.File;
import java.lang.reflect.Method;

import static android.content.Context.STORAGE_SERVICE;

/**
 * Created by Leo on 2017/8/31
 * Function: sd卡工具类
 */

public class SDCardUtils {

    private static final String TAG = "SDCardUtils";
    private static final String ENV_EXTERNAL_STORAGE = "EXTERNAL_STORAGE";

    public static final String INNER_EXTERNAL_STORAGE_DIRECTORY = Environment.getExternalStorageDirectory().getPath();
//    public static final String OUTER_EXTERNAL_STORAGE_DIRECTORY = System.getenv(ENV_EXTERNAL_STORAGE);

    /**
     * @param context
     * @return
     */
    public static String getSecondaryStoragePath(Context context) {
        try {
            StorageManager sm = (StorageManager) context.getSystemService(STORAGE_SERVICE);
            Method getVolumePathsMethod = StorageManager.class.getMethod("getVolumePaths", null);
            String[] paths = (String[]) getVolumePathsMethod.invoke(sm, null);
            // second element in paths[] is secondary storage path
            return paths.length <= 1 ? null : paths[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 是否有SD卡
     */
    public static boolean ishasCard() {
        return isSDCardEnable();
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
     * 内置SD卡剩余空间大小
     */
    public static long getInnerSDFreeSize() {
        return getSDFreeSize(INNER_EXTERNAL_STORAGE_DIRECTORY);
    }

    /**
     * 外置SD卡剩余空间大小
     */
    public static long getOuterSDFreeSize(Context context) {
        String path = getSecondaryStoragePath(context);
        return TextUtils.isEmpty(path) ? 0 : getSDFreeSize(path);
    }

    /**
     * SD卡剩余空间大小
     */
    public static long getSDFreeSize(String path) {
        StatFs sf = new StatFs(path);
        //获取单个数据块的大小(Byte)
        long blockSize = sf.getBlockSizeLong();
        //空闲的数据块的数量
        long freeBlocks = sf.getAvailableBlocksLong();
        //返回SD卡空闲大小 单位MB
        return (freeBlocks * blockSize) / 1024 / 1024;
    }

    /**
     * 读/写检查
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    public static boolean isHasDir(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * 判断文件是否存在
     *
     * @param file 文件
     */
    public static boolean isFileExists(@NonNull File file) {
        return file.exists();
    }

    public static boolean isFileExists(@NonNull String path) {
        File file = new File(path);
        return isFileExists(file);
    }

    /**
     * 创建目录
     */
    public static void makeDirs(String path) {
        File file = new File(path);
        makeDirs(file);
    }

    public static void makeDirs(@NonNull File file) {
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
