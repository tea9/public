package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 */
public class WeiLiKanKanModel {

    //TODO 处理广告
    public static void start() throws InterruptedException {
        Constant.start(Constant.WeiLiKanKan.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.slideByXyIds2(Constant.WeiLiKanKan.RES_ID_ITEM1, Constant.WeiLiKanKan.FileName.file_path1); // 第一条是置顶
//        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN2,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
        Thread.sleep(6*1000);

        Constant.start(Constant.WeiLiKanKan.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
        while (true){
            ShellUtil.slideByXyIds2(Constant.WeiLiKanKan.RES_ID_ITEM1, Constant.WeiLiKanKan.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
        }
    }
}
