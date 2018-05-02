package com.leo.utils;

import android.support.annotation.NonNull;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author leo, ZhangWei
 * @date 2018/5/2
 * @function
 */
public class FileUtils {
    /**
     * 将String写入文件
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean writeFileFromString(@NonNull File file, @NonNull String content, boolean append) {
        boolean result = false;
        if (!SDCardUtils.isFileExists(file)) {
            return false;
        }
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file, append));
            bufferedWriter.write(content);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
