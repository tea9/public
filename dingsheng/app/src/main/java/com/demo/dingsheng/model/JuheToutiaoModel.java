package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 还没写完 那个圈走不满
 * 没测试
 */
public class JuheToutiaoModel {

    public static void start() throws InterruptedException {
        Constant.start(Constant.JuHeTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickMethod(945,1728);
        Thread.sleep(3*1000);
        ShellUtil.clickMethod(376,1577);
        Thread.sleep(3*1000);
        ShellUtil.clickMethod(587,722);
        Thread.sleep(6*1000);



        Constant.start(Constant.JuHeTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
        Thread.sleep(2*1000);
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.JuHeTouTiao.RES_ID_BTN1,Constant.JuHeTouTiao.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG,"点击item1");
        while (true) {
            ShellUtil.slideByXyIds6(Constant.JuHeTouTiao.RES_ID_ITEM1, Constant.JuHeTouTiao.FileName.file_path1);
            ShellUtil.clickByXy(Constant.JuHeTouTiao.RES_ID_BTN1,Constant.JuHeTouTiao.FileName.file_path1); // 点击刷新
        }
    }
}
