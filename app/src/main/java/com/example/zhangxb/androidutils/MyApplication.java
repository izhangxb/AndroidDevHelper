package com.example.zhangxb.androidutils;

import android.app.Application;

/**
 * Created by zhangxb on 2017/9/5.
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
    }

    public static Application getInstance(){
        return myApplication;
    }
}
