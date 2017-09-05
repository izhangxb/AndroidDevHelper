package com.example.zhangxb.androidutils.utils;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description: Json的相关工具类
 * @Author: zhangxb
 * @Date: 2015/12/28
 */
public class JsonMapConverter {

    private JsonMapConverter() {
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


    /**
     * 函数名称: parseData
     * 函数描述: 将json字符串转换为map
     *
     * @param data
     * @return
     */
    public static Map<String, String> JsonToMap(String data) {
        Map<String, String> map = null;
        try {
            map = new TreeMap<>();
            // 将json字符串转换成jsonObject
            JSONObject jasonObject = new JSONObject(data);
            Iterator ite = jasonObject.keys();
            // 遍历jsonObject数据,添加到Map对象
            while (ite.hasNext()) {
                String key = ite.next().toString();
                String value = jasonObject.get(key).toString();
                map.put(key, value);
            }
            // 或者直接将 jsonObject赋值给Map
            // data = jsonObject;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return map;
    }
}
