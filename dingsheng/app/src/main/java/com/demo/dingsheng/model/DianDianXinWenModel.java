package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 部分红包阅读领取红包
 * 滑动不到红包
 * 没测试
 */
public class DianDianXinWenModel {

    public static void start() throws InterruptedException {
        Constant.start(Constant.DianDianXinWen.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        Log.e(Constant.TAG,"返回");
        ShellUtil.back();
        Thread.sleep(2*1000);
        ShellUtil.clickByXy(Constant.DianDianXinWen.RES_ID_BTN2,Constant.DianDianXinWen.FileName.file_path1); // 点击刷新
        Thread.sleep(6*1000);


        Constant.start(Constant.DianDianXinWen.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        Log.e(Constant.TAG,"返回");
        ShellUtil.back();
        Thread.sleep(2*1000);
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.DianDianXinWen.RES_ID_BTN1,Constant.DianDianXinWen.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG,"点击item1");
        while (true) {
            Log.e(Constant.TAG,"点击");
            ShellUtil.slideByXyIds(Constant.DianDianXinWen.RES_ID_ITEM1, Constant.DianDianXinWen.FileName.file_path1); // 第一条是置顶
//            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.DianDianXinWen.RES_ID_ITEM1,Constant.DianDianXinWen.FileName.file_path1);
            Log.e(Constant.TAG,"滑动");
//            ShellUtil.swipe(a[1],a[0]);
//            ShellUtil.swipeDownMethod1();
            RootCmd.execRootCmd("input swipe 25 1450 25 450 700");
        }
    }
}
