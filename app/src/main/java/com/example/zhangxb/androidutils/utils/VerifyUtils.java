package com.example.zhangxb.androidutils.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 常用的验证工具类
 * @Author: carl
 * @Date: 2015/12/28
 */
public class VerifyUtils {

    private VerifyUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 验证邮箱
     *
     * @param e_mail
     * @return
     */
    public static boolean isEmail(String e_mail) {
        String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p = Pattern.compile(check);
        Matcher m = p.matcher(e_mail);
        return m.matches();
    }

    /**
     * 验证手机号
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNumber(String mobiles) {
        String check = "^(1[34578][0-9]{1})[0-9]{8}$";
        Pattern p = Pattern.compile(check);
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    /**
     * 是否为6位以上的数字加字母
     *
     * @param str
     * @return
     */
    public static boolean isNumOrChars(String str) {
        String check = "[0-9a-zA-Z]{6,32}";
        Pattern p = Pattern.compile(check);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 是否为（lowerLimit，upperLimit）位的数字加字母
     *
     * @param str
     * @param lowerLimit 下限
     * @param upperLimit 上限
     * @return
     */
    public static boolean isNumOrChars(String str, int lowerLimit, int upperLimit) {
        String check = "[0-9a-zA-Z]{" + lowerLimit + "," + upperLimit + "}";
        Pattern p = Pattern.compile(check);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 是否为数字，中文，英文字符。（1,12）
     *
     * @param str
     * @return
     */
    public static boolean isNickName(String str) {
        String check = "^[a-zA-Z0-9\u4E00-\u9FA5]{1,12}+$";
        Pattern p = Pattern.compile(check);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    /**
     * 是否为数字
     *
     * @param str
     * @return
     */
    public static boolean IsDigit(String str) {
        return str.matches("-?[0-9]+.*[0-9]*");
    }

    /**
     * 只含数字
     *
     * @param data 可能只包含数字的字符串
     * @return 是否只包含数字
     */
    public static boolean isNumber(String data) {
        String check = "^[0-9]+$";
        return data.matches(check);
    }

    /**
     * 只含字母
     *
     * @param data 可能只包含字母的字符串
     * @return 是否只包含字母
     */
    public static boolean isLetter(String data) {
        String check = "^[A-Za-z]+$";
        return data.matches(check);
    }

    /**
     * 只是中文
     *
     * @param data 可能是中文的字符串
     * @return 是否只是中文
     */
    public static boolean isChinese(String data) {
        String check = "^[\u0391-\uFFE5]+$";
        return data.matches(check);
    }

    /**
     * 包含中文
     *
     * @param data 可能包含中文的字符串
     * @return 是否包含中文
     */
    public static boolean isContainChinese(String data) {
        String check = "[\u0391-\uFFE5]";
        if (data != null) {
            for (int i = 0; i < data.length(); i++) {
                String temp = data.substring(i, i + 1);
                if (temp.matches(check)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 身份证号码验证
     *
     * @param data 可能是身份证号码的字符串
     * @return 是否是身份证号码
     */
    public static boolean isIdCard(String data) {
        String check = "^[0-9]{17}[0-9xX]$";
        return data.matches(check);
    }

    /**
     * 长度验证
     *
     * @param data   源字符串
     * @param length 期望长度
     * @return 是否是期望长度
     */
    public static boolean isLength(String data, int length) {
        return data != null && data.length() == length;
    }
}
