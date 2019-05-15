package com.demo.dingsheng2.util;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

/**
 * created by tea9 at 2018/12/18
 */
public class HttpUtil {

    //http://47.52.41.206:8088/api/user/list?number=5
    private static final String url="http://47.52.41.206:8088/api/user/update";
//    private static final String url="http://47.52.41.206:8181/api/user/update";

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
}
