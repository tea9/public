package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 没测试
 * 没有签到
 */
public class ShanDianKanKanModel {

    public static void start() throws InterruptedException {
//        Constant.start(Constant.ShanDianKanKan.ACTIVITY_PACKAGE);
//        Thread.sleep(3*1000);
//        ShellUtil.slideByXyIds2(Constant.WeiLiKanKan.RES_ID_ITEM1, Constant.WeiLiKanKan.FileName.file_path1); // 第一条是置顶
////        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
//        Thread.sleep(3*1000);
//        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN2,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
//        Thread.sleep(6*1000);

        Constant.start(Constant.ShanDianKanKan.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.ShanDianKanKan.LINGQU,Constant.ShanDianKanKan.FileName.file_path1);
        Log.e(Constant.TAG,"点击btn1");
//        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
        ShellUtil.clickMethod(75,1642);
        while (true){
            ShellUtil.slideByXyIds(Constant.ShanDianKanKan.RES_ID_ITEM1, Constant.ShanDianKanKan.FileName.file_path1); // 第一条是置顶
//            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
            ShellUtil.clickMethod(75,1642);
        }
    }
}
