package com.example.zhangxb.androidutils.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;

/**
 * @Description: 设备信息工具类
 * @Author: carl
 * @Date: 2015/12/28
 */
public class DeviceUtils {

    private DeviceUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取MAC地址
     *
     * @param context
     * @return
     */
    public static String getMacAddress(Context context) {
        WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifi.getConnectionInfo();
        return wifiInfo.getMacAddress();
    }

    /**
     * 获取IMEI信息
     *
     * @param context
     * @return
     */
    public static String getIMEI(Context context) {
        return ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
    }

    /**
     * 获取手机型号
     */
    public static String getMODEL() {
        return Build.MODEL;
    }

    /**
     * 获取制造商
     */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * 获取位置信息
     *
     * @param context
     */
    public static String getLocationInfo(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);//设置为最大精度
        criteria.setAltitudeRequired(false);//不要求海拔信息
        criteria.setBearingRequired(false);//不要求方位信息
        criteria.setCostAllowed(false);//是否允许付费
        criteria.setPowerRequirement(Criteria.POWER_LOW);//对电量的要求

        String provider = locationManager.getBestProvider(criteria, true);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager
                .PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission
                .ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return "";
        }
        Location location = locationManager.getLastKnownLocation(provider);
        return location.getLatitude() + ":" + location.getLongitude();
    }

    /**
     * 获取手机系统版本
     *
     * @return
     */
    public static String getAndoridVersion() {
        return Build.VERSION.RELEASE;
    }


}
