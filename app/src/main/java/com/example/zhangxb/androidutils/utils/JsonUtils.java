package com.example.zhangxb.androidutils.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;
import java.util.Objects;

/**
 * @Description: Json的相关工具类
 * @Author: carl
 * @Date: 2015/12/28
 */
public class JsonUtils {

    private JsonUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * Map转为JSONObject格式
     *
     * @param map
     */
    public static String MapToJson(Map<String, Object> map) {
        JSONObject jsonObject = new JSONObject();
        for (String key : map.keySet()) {
            Object ob = map.get(key);
            try {
                jsonObject.put(key, ob);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject.toString();
    }
}
