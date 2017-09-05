package com.example.zhangxb.androidutils.function;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zhangxb.androidutils.MainActivity;

/**
 * -------------------------------
 * -         ,.                  -
 * -        (_|,.                -
 * -       ,' /, )_______   _    -
 * -    __j o``-'        `.'-)'  -
 * -   (")                 \'    -
 * -    `-j                |     -   神兽保佑，永无BUG
 * -      `-._(           /      -
 * -         |_\  |--^.  /       -
 * -        /_]'|_| /_)_/        -
 * -           /_]'  /_]'        -
 * -------------------------------
 *
 * @Description: 登录拦截器，该拦截器会拦截页面跳转，判断你是否需要登录，如果已经登录，则直接跳转，
 * 如果没有登录，先跳转登录页面，执行登录操作，登录结束后，自动跳转目标activity.
 * eg:
 * 跳转到目标activity页面
 * public void starIntent(View v) {
 * Bundle bun = new Bundle();
 * bun.putString("Type", "login test");
 * LoginInterceptor.interceptor(this, SecondActivity.class, bun);
 * }
 * @Date: 2017/5/2.
 * @Author: zhangxb.
 */

public class LoginInterceptor {
    public static final String mINVOKER = "INTERCEPTOR_INVOKER";

    /**
     * 判断处理
     *
     * @param ctx    当前activity的上下文
     * @param target 目标activity的target
     * @param bundle 目标activity所需要的参数
     * @param intent 目标activity
     */
    public static void interceptor(Context ctx, Class target, Bundle bundle, Intent intent) {
        if (target != null) {
            LoginCarrier invoker = new LoginCarrier(target, bundle);
            if (getLogin()) {
                invoker.invoke(ctx);
            } else {
                if (intent == null) {
                    //TODO 将MainActivity替换为LoginActivity
                    intent = new Intent(ctx, MainActivity.class);
                }
                login(ctx, invoker, intent);
            }
        } else {
            Toast.makeText(ctx, "没有activity可以跳转", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 登录判断
     *
     * @param ctx    当前activity的上下文
     * @param target 目标activity的target
     * @param bundle 目标activity所需要的参数
     */
    public static void interceptor(Context ctx, Class target, Bundle bundle) {
        interceptor(ctx, target, bundle, null);
    }

    //TODO 这里获取登录状态，具体获取方法看项目具体的判断方法
    private static boolean getLogin() {
        return true;
    }

    private static void login(Context context, LoginCarrier invoker, Intent intent) {
        intent.putExtra(mINVOKER, invoker);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        context.startActivity(intent);
    }
}
