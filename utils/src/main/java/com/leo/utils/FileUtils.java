package com.leo.utils;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.annotation.NonNull;

/**
 * @author leo, ZhangWei
 * @date 2018/5/2
 * @function 文件的快捷的创建
 */
public class FileUtils {

    /**
     * 通过私有构造隐藏默认公共构造方法禁止该类的公共构造
     */
    private FileUtils() {
    }

    public static boolean createFile(File file) {
        if (!file.exists()) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * 将String写入文件
     *
     * @return {@code true}: success<br>{@code false}: fail
     */
    public static boolean writeFileFromString(@NonNull File file, @NonNull String content, boolean append) {
        boolean result = false;
        if (!SDCardUtils.isFileExists(file)) {
            createFile(file);
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

    /**
     * Return the string in file.
     *
     * @param file        The file.
     * @param charsetName The name of charset.
     * @return the string in file
     */
    public static String readFile2String(File file, String charsetName) {
        if (!SDCardUtils.isFileExists(file)) {
            return null;
        }
        BufferedReader reader = null;
        try {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(charsetName)) {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            } else {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charsetName));
            }
            String line;
            if ((line = reader.readLine()) != null) {
                sb.append(line);
                while ((line = reader.readLine()) != null) {
                    sb.append(System.getProperty("line.separator")).append(line);
                }
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 文件转数组
     *
     * @param file 文件参数
     * @return data byte[]
     * @throws Exception
     */
    public static byte[] readFile2Byte(File file) throws Exception {
        InputStream stream = new FileInputStream(file);
        byte[] data = inputStream2ByteArray(stream);
        stream.close();
        return data;
    }

    /**
     * 流转二进制数组
     *
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] inputStream2ByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}
