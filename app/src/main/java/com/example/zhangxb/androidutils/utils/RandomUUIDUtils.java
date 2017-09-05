package com.example.zhangxb.androidutils.utils;

import java.util.UUID;

/**
 * @Description: 生成全球唯一标识码UUID
 * @Author: carl
 * @Date: 2015/12/28
 */
public class RandomUUIDUtils {

    private RandomUUIDUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 生成uuid
     *
     * @param hideLine 是否隐藏“-”
     * @return
     */
    public static String getUuid(boolean hideLine) {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
        return hideLine ? temp : str;
    }
}
