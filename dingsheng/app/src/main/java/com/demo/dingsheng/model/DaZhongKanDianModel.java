package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 没下载到
 * 每测试
 * 滑动文章 没写
 * 没测试
 */
public class DaZhongKanDianModel {

    public static void start() throws InterruptedException {
        Constant.start(Constant.DaZhongKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickMethod(696,1684);
        Thread.sleep(3*1000);
        ShellUtil.clickMethod(692,474);
        Thread.sleep(6*1000);


        Constant.start(Constant.DaZhongKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
//        Thread.sleep(2*1000);
//        Log.e(Constant.TAG,"点击btn1");
//        ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_BTN1,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
        ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_LingQu,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新

        Log.e(Constant.TAG,"点击item1");
        while (true) {
            ShellUtil.slideByXyIds(Constant.DaZhongKanDian.RES_ID_ITEM1, Constant.DaZhongKanDian.FileName.file_path1); // 第一条是置顶
            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.DaZhongKanDian.RES_ID_ITEM1LL,Constant.ZhongQing.FileName.file_path1);
//            Log.e(Constant.TAG,"keyevent 1");
            ShellUtil.swipe(a[1],a[0]);
//            ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_BTN1,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
        }
    }
}
