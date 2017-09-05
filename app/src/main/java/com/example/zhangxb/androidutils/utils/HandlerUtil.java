package com.example.zhangxb.androidutils.utils;

import android.content.Context;
import android.os.Handler;

import java.lang.ref.WeakReference;

/**
 * @Description: Handler工具类.
 * @Date: 2017/4/17.
 * @Author: za-zhangxiaobo.
 */

public class HandlerUtil extends Handler {

    private static HandlerUtil instance = null;
    WeakReference<Context> mActivityReference;

    public static HandlerUtil getInstance(Context context) {
        if (instance == null) {
            instance = new HandlerUtil(context.getApplicationContext());
        }
        return instance;
    }

    HandlerUtil(Context context) {
        mActivityReference = new WeakReference<>(context);
    }
}
