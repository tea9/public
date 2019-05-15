package com.demo.dingsheng;

import android.app.Application;
import android.content.Context;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.LogcatHelper;
import com.demo.dingsheng.util.SharedPreferencesUtils;
import com.lzy.okgo.OkGo;
import com.tencent.bugly.Bugly;

/**
 * created by tea9 at 2018/12/15
 * bugly
 * https://bugly.qq.com/docs/user-guide/instruction-manual-android-upgrade/?v=20181014122344
 */
public class App extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        LogcatHelper.getInstance(this).start();
        initOkGo();
        SharedPreferencesUtils.putInfo(getApplicationContext(),Constant.A_FLAG,true);
        Bugly.init(getApplicationContext(), "a164339eb7", false);
    }

    private void initOkGo() {
        OkGo.getInstance().init(this);
    }
}
