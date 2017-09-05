package com.example.zhangxb.androidutils.utils;

import java.util.Random;

/**
 * @Description: 随机数工具类
 * @Author: carl
 * @Date: 2015/12/28
 */
public class RandomUtils {

    private RandomUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 生成指定长度的随机字符，包括字母和数字
     *
     * @param length 生成字符的长度
     * @return
     */
    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKMLNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成指定长度的数字随机数
     *
     * @param length 随机数长度
     * @return
     */
    public static String getRandomNumber(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(10);
            sb.append(number);
        }
        return sb.toString();
    }
}
