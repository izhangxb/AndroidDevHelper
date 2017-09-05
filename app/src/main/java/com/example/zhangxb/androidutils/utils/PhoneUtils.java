package com.example.zhangxb.androidutils.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;

import java.util.List;

/**
 * @Description: 手机功能辅助类
 * @Author: carl
 * @Date: 2015/12/26
 */
public class PhoneUtils {

    private PhoneUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 调起系统发短信功能,跳转短信界面
     *
     * @param activity
     * @param phoneNumber 手机号码
     * @param smsContent  短信内容
     * @return 发送状态
     */
    public static void sendMessageIndirectly(Activity activity, String phoneNumber, String smsContent) {
        if (activity == null || phoneNumber == null) {
            return;
        }
        Uri uri = Uri.parse("smsto:" + phoneNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", smsContent);
        activity.startActivity(intent);
    }

    /**
     * @param phoneNumber
     * @param smsContent
     */
    public static void sendMessageDirectly(String phoneNumber, String smsContent) {
        SmsManager smsManager = SmsManager.getDefault();
        //切分短信，每七十个汉字切一个，不足七十就只有一个：返回的是字符串的List集合
        List<String> contents = smsManager.divideMessage(smsContent);
        for (String sms : contents) {
            smsManager.sendTextMessage(phoneNumber, null, sms, null, null);
        }
    }

    /**
     * 调起系统打电话功能,跳转拨号界面
     *
     * @param activity
     * @param phoneNuber 电话号码
     */
    public static void callPhoneIndirectly(Activity activity, String phoneNuber) {
        if (activity == null || phoneNuber == null) {
            return;
        }
        Uri uri = Uri.parse("tel:" + phoneNuber);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        activity.startActivity(intent);
    }

    /**
     * 直接拨号。
     *
     * @param activity
     * @param phoneNuber 电话号码
     */
    public static void callPhoneDirectly(Activity activity, String phoneNuber) {
        if (activity == null || phoneNuber == null) {
            return;
        }
        Uri uri = Uri.parse("tel:" + phoneNuber);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager
                .PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        activity.startActivity(intent);
    }
}
