package com.demo.android_ds.util;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

/**
 *
 */
public class HttpUtil {

    //http://47.52.41.206:8088/api/user/list?number=5
//    private static final String url="http://47.52.41.206:8088/api/user/update";
//    private static final String url="http://47.52.41.206:8181/api/user/update";
    private static final String url="http://47.100.30.142:8088/api/user/update";
    private static final String url1="http://47.100.30.142:8088/api/user/list?pagesize=2000";
    private static final String url2="http://47.100.30.142:8088/api/user/addnum";

    /**
     * 验证激活码
     * @param equipmentID 设备ID
     * @param registerCode 激活码
     */
    public static void update(String equipmentID, String registerCode, StringCallback callback) {
        OkGo.<String>post(url)
                .params("equipmentID",equipmentID)
                .params("registerCode",registerCode)
                .execute(callback);
    }

    public static void get(StringCallback callback) {
        OkGo.<String>get(url1)
                .execute(callback);
    }

    public static void addnum(StringCallback callback) {
        OkGo.<String>post(url2)
                .params("num","30000")
                .params("startTime","1549166791000")
                .params("stopTime","1582128000000")
                .execute(callback);
    }
}
