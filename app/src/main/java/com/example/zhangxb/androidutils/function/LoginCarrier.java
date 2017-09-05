package com.example.zhangxb.androidutils.function;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

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
 * @Description: 登录载体，暂存目标activity相关信息.
 * @Date: 2017/5/2.
 * @Author: zhangxb.
 */

public class LoginCarrier implements Parcelable {
    public Class mTargetAction;
    public Bundle mbundle;

    public LoginCarrier(Class target, Bundle bundle) {
        mTargetAction = target;
        mbundle = bundle;
    }

    /**
     * 目标activity
     *
     * @param ctx
     */
    public void invoke(Context ctx) {
        Intent intent = new Intent(ctx, mTargetAction);
        if (mbundle != null) {
            intent.putExtras(mbundle);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        ctx.startActivity(intent);
    }

    public LoginCarrier(Parcel parcel) {
        // 按变量定义的顺序读取
        try {
            mTargetAction = Class.forName(parcel.readString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        mbundle = parcel.readParcelable(Bundle.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        // 按变量定义的顺序写入
        parcel.writeString(mTargetAction.getName());
        parcel.writeParcelable(mbundle, flags);
    }

    public static final Creator<LoginCarrier> CREATOR = new Creator<LoginCarrier>() {

        @Override
        public LoginCarrier createFromParcel(Parcel source) {
            return new LoginCarrier(source);
        }

        @Override
        public LoginCarrier[] newArray(int arg0) {
            return new LoginCarrier[arg0];
        }
    };
}
