package com.demo.dingsheng2.util;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 谷歌的Gson解析工具类
 * Created by chengzi on 2017/5/4
 * 注：先导入Gson
 */

public class GsonUtil {

    public GsonUtil() {
        // TODO Auto-generated constructor stub
    }

    public static String createGsonString(Object object) {
        Gson gson = new Gson();
        String gsonString = gson.toJson(object);
        return gsonString;
    }

    public static <T> T changeGsonToBean(String gsonString, Class<T> cls) {
        Gson gson = new Gson();
        T t = gson.fromJson(gsonString, cls);
        return t;
    }

    public static <T> List<T> changeGsonToList(String gsonString, Class<T> cls) {
        Gson gson = new Gson();
        //List<T> list = gson.fromJson(gsonString, new TypeToken<List<T>>() {}.getType());
        List<T> list = gson.fromJson(gsonString, com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, cls));
        Log.i("zc","list="+list);
//        Type type = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, cls);
//        List<T> list = gson.fromJson(gsonString, type);
        return list;
    }



    public static <T> List<Map<String, T>> changeGsonToListMaps(
            String gsonString) {
        List<Map<String, T>> list = null;
        Gson gson = new Gson();
        list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>() {
        }.getType());
        return list;
    }

    public static <T> Map<String, T> changeGsonToMaps(String gsonString) {
        Map<String, T> map = null;
        Gson gson = new Gson();
        map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
        }.getType());
        return map;
    }
}
