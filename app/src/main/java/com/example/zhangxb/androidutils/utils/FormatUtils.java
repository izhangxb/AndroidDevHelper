package com.example.zhangxb.androidutils.utils;

import android.text.TextUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Description: 常用的格式化工具类
 * @Author: zhangxb
 * @Date: 2016/3/16
 */
public class FormatUtils {

    private FormatUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 金钱格式化，格式化为 123,456,789.12 类型
     *
     * @param num
     * @return
     */
    public static String moneyFormat(double num) {
        NumberFormat nf = new DecimalFormat(",##0.00");
        return nf.format(num);
    }


    /**
     * 金钱格式化，格式化为 123,456,789.12 类型
     *
     * @param num
     * @return
     */
    public static String moneyFormat(int num) {
        NumberFormat nf = new DecimalFormat(",##0");
        return nf.format(num);
    }

    /**
     * 除10000
     */
    public static String divide10000(String original) {
        if (TextUtils.isEmpty(original)) {
            return "";
        }
        String result = "0";
        try {
            NumberFormat nf = new DecimalFormat("0.00");
            result = nf.format(Double.parseDouble(original) / 10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 除10000,小数点保留固定位数
     */
    public static String divide10000(String original, int dotLength) {
        if (TextUtils.isEmpty(original)) {
            return "";
        }
        String result = "0";
        String format = "0.";
        for (int i = 0; i < dotLength; i++) {
            format = format + "0";
        }
        try {
            NumberFormat nf = new DecimalFormat(format);
            result = nf.format(Double.parseDouble(original) / 10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 乘以10000
     */
    public static String mulpitly10000(String original) {
        if (TextUtils.isEmpty(original)) {
            return "";
        }
        String result = "0";
        try {
            NumberFormat nf = new DecimalFormat("0.00");
            result = nf.format(Double.parseDouble(original) * 10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 分转元
     */
    public static String fengToYuan(String original) {
        if (TextUtils.isEmpty(original)) {
            return "";
        }
        String result = "0";
        try {
            NumberFormat nf = new DecimalFormat("0.00");
            result = nf.format(Double.parseDouble(original) / 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*
     * 将时间转换为时间戳（毫秒为单位）
     */
    public static String dateToStamp(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date != null ? date.getTime() : 0;
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 将时间转换为时间戳（秒为单位）
     *
     * @param time
     * @return
     */
    public static String getTimeStamp(String time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date;
        try {
            date = simpleDateFormat.parse(time);
            return date.getTime() / 1000 + "";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /*
     * 将时间戳转换为时间(秒为单位)
     */
    public static String stampToDate(String s) {
        String res;
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault());
            long lt = new Long(s);
            Date date = new Date(lt * 1000);
            res = simpleDateFormat.format(date);
        } catch (Exception e) {
            res = "";
        }
        return res;
    }

    /*
     * 将时间戳转换为时间
     * "yyyy年MM月dd日"
     */
    public static String stampToDate(String s, String pattern) {
        String res;
        if (TextUtils.isEmpty(s)) {
            return "";
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.getDefault());
            long lt = new Long(s);
            Date date = new Date(lt * 1000);
            res = simpleDateFormat.format(date);
        } catch (Exception e) {
            res = "";
        }
        return res;
    }

    /**
     * 格式化空的字符串
     */
    public static String formatNull(String s) {
        if (TextUtils.isEmpty(s)) {
            return "--";
        }
        return s;
    }

    /**
     * 格式化空的字符串(包括0)
     */
    public static String formatZero(String s, String format) {
        if (TextUtils.isEmpty(s) || TextUtils.equals("0", s) || TextUtils.equals("0.00", s) || TextUtils.equals("0.0", s)) {
            return format;
        }
        return s;
    }

    /**
     * 给电话号码加星星
     *
     * @param mobile
     * @return
     */
    public static String maskPhoneNum(String mobile) {
        if (mobile.length() != 11) {
            return "";
        }
        return mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
    }

    /**
     * 给银行卡号加星星
     *
     * @param bc
     * @return
     */
    public static String maskBankCard(String bc) {
        if (TextUtils.isEmpty(bc) || bc.length() < 4) {
            return "";
        }

        return bc.substring(0, 4) + "**********" + bc.substring(bc.length() - 4, bc.length());
    }

    /**
     * 获取银行卡号后四位
     *
     * @param bc
     * @return
     */
    public static String getBankCardLast4(String bc) {
        if (TextUtils.isEmpty(bc) || bc.length() < 4) {
            return "";
        }

        return bc.substring(bc.length() - 4, bc.length());
    }

    /**
     * 给身份证号加星星
     *
     * @param bc
     * @return
     */
    public static String maskIDCard(String bc) {
        if (TextUtils.isEmpty(bc) || bc.length() < 3) {
            return "";
        }

        return bc.substring(0, 3) + "**********" + bc.substring(bc.length() - 4, bc.length());
    }
}
