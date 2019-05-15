package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 */
public class MaYiTouTiaoModel {

    public static void startMaYi() throws InterruptedException {
        Constant.start(Constant.MaYi.ACTIVITY_PACKAGE);
        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED,Constant.MaYi.FileName.file_path1); // 红包
        Thread.sleep(2*1000);
        ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN2,Constant.MaYi.FileName.file_path1); //任务
        Thread.sleep(2*1000);
        ShellUtil.clickMethod(833,578);
        Thread.sleep(3*1000);


        Constant.start(Constant.MaYi.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
        Thread.sleep(4*1000);
        ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED,Constant.MaYi.FileName.file_path1); // 红包
        Thread.sleep(2*1000);
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN1,Constant.MaYi.FileName.file_path1); // 点击刷新
//        while (true){
        for (int i = 0; i <30 ; i++) {
            Log.e(Constant.TAG,"点击item1");
            ShellUtil.slideByXyIdsZHONGQING(Constant.MaYi.RES_ID_ITEM1, Constant.MaYi.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN1,Constant.MaYi.FileName.file_path1); // 点击刷新
        }
    }
}
