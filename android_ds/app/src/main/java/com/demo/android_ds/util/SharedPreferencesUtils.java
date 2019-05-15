package com.demo.android_ds.util;

import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferencesUtils {

    private static String flag="dingsheng";

    private static SharedPreferences preferences;
    public static boolean putInfo(Context context, String key, Object value) {
        if (preferences == null) {
            preferences = context.getSharedPreferences(flag, Context.MODE_PRIVATE);// 创建本地缓存
        }
        if (preferences != null) {
            SharedPreferences.Editor editor = preferences.edit();
            if (value instanceof Integer) {
                Integer v = (Integer) value;
                editor.putInt(key, v);
            } else if (value instanceof String) {
                String v = (String) value;
                editor.putString(key, v);
            } else if (value instanceof Boolean) {
                Boolean v = (Boolean) value;
                editor.putBoolean(key, v);
            } else if (value instanceof Float) {
                Float v = (Float) value;
                editor.putFloat(key, v);
            } else if (value instanceof Long) {
                Long v = (Long) value;
                editor.putLong(key, v);
            }
            editor.commit();
            return true;
        }
        return false;
    }

    public static SharedPreferences getPreferences(Context context){
        if (preferences == null) {
            preferences = context.getSharedPreferences(flag, Context.MODE_PRIVATE);// 创建本地缓存
        }
        return preferences;
    }

}
