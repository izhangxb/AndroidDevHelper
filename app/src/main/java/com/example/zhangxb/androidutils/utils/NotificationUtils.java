package com.example.zhangxb.androidutils.utils;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describtion: 通知栏工具类
 * @Author: zhangxb.
 * @Date: 2016/5/31.
 */
public class NotificationUtils {
    private Context mContext;
    private NotificationManager mNotificationManager = null;
    private Map<Integer, Notification> mNotifications = null;
    private NotificationCompat.Builder mBuilder = null;
    private Intent mIntent = null;


    public NotificationUtils(Context context) {
        mContext = context;
        mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifications = new HashMap<>();
        mBuilder = new NotificationCompat.Builder(context);
        mBuilder.setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL);
        mIntent = new Intent();
    }

    public NotificationCompat.Builder getBuilder() {
        return mBuilder;
    }

    /**
     * 显示通知
     *
     * @param id 通知id
     */
    public void showNotification(int id) {
        PendingIntent mPendingIntent = PendingIntent.getActivity(mContext, (int) System.currentTimeMillis() / 1000, mIntent, 0);
        mBuilder.setContentIntent(mPendingIntent);
        Notification notification = mBuilder.build();
        mNotificationManager.notify(id, notification);
        mNotifications.put(id, notification);
    }

    /**
     * 取消通知
     *
     * @param id 通知id
     */
    public void cancelNotification(int id) {
        mNotificationManager.cancel(id);
        mNotifications.remove(id);
    }

    /**
     * 更新通知进度条
     *
     * @param id
     * @param progress
     */
    public void updateNotification(int id, int progress) {
        if (mNotifications.containsKey(id)) {
            Notification notification = mNotifications.get(id);
            mBuilder.setProgress(100, progress, false);
            mNotificationManager.notify(id, notification);
        }
    }

    public NotificationCompat.Builder setClickIntent(Intent intent) {
        mIntent = intent;
        return mBuilder;
    }


}
