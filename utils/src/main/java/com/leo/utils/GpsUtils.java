package com.leo.utils;

import android.content.Context;
import android.location.LocationManager;

/**
 * @author Leo.ZhangTJ
 * @time 2020/5/18
 * @function
 * @describe
 */
public class GpsUtils {

    public static boolean isOpen(Context context, String type) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(type);
    }

    public static boolean isOpen(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        boolean isGpsOpen = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetWorkOpen = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        return isGpsOpen || isNetWorkOpen;
    }

}
