package com.leo.utils;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @author leo
 * @date 2017/8/29
 * @function 设备相关工具类
 */

public class DeviceUtils {
    /**
     * 获取设备AndroidID
     */
    @SuppressLint("HardwareIds")
    public static String getAndroidID(ContentResolver resolver) {
        return Settings.Secure.getString(resolver, Settings.Secure.ANDROID_ID);
    }

    /**
     * 获取IMEI码
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.READ_PHONE_STATE"/>}</p>
     *
     * @return IMEI码
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String getIMEI(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getDeviceId() : null;
    }

    /**
     * 获取IMSI码
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.READ_PHONE_STATE"/>}</p>
     *
     * @return IMSI码
     */
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String getIMSI(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getSubscriberId() : null;
    }

    /**
     * 获取设备型号
     */
    public static String getModel() {
        String model = Build.MODEL;
        return model != null ? model.trim().replaceAll("\\s*", "") : "";
    }

    /**
     * 获取网卡地址
     */
    public static String getMac(Context mContext) {
        String mac = getMacAddress(mContext);
        return TextUtils.equals(mac, "02:00:00:00:00:00") ? getMacAddress() : mac;
    }

    /**
     * 获取MAC地址 此方法在6.0以上版本废弃 只能获取虚假的mac地址
     */
    @SuppressLint("HardwareIds")
    private static String getMacAddress(Context mContext) {
        String macStr;
        WifiManager wifiManager = (WifiManager) mContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = null;
        if (wifiManager != null) {
            wifiInfo = wifiManager.getConnectionInfo();
        }

        if (wifiInfo != null && wifiInfo.getMacAddress() != null) {
            macStr = wifiInfo.getMacAddress();
        } else {
            macStr = "";
        }

        return macStr;
    }

    /**
     * 获取MAC地址 此方法在6.0以上版本通过网卡API读取mac
     */
    private static String getMacAddress() {
        String result = "";
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                byte[] addr = networkInterface.getHardwareAddress();
                if (addr == null || addr.length == 0) {
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                for (byte b : addr) {
                    sb.append(String.format("%02X:", b));
                }

                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }

                String mac = sb.toString();
                if (TextUtils.equals(networkInterface.getName(), "wlan0")) {
                    return mac;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return result;
    }
}
