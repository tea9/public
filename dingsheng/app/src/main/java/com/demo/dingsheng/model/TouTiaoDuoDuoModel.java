package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 版本更新 需要重新判断
 * 第一次弹框
 * 签到成功
 */
public class TouTiaoDuoDuoModel {

    public static void startTouTiaoDuoDuo() throws InterruptedException {
        Constant.start(Constant.TouTiaoDuoDuo.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN2,Constant.TouTiaoDuoDuo.FileName.file_path1); //赚钱
        Thread.sleep(7*1000);


        Constant.start(Constant.TouTiaoDuoDuo.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        // check 红包
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1,Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
        for (int i=0;i<30;i++){
//        while (true){
            ShellUtil.slideByXyIds2(Constant.TouTiaoDuoDuo.RES_ID_ITEM1, Constant.TouTiaoDuoDuo.FileName.file_path1); // 文章需要滑到底
            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1,Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
            Thread.sleep(2*1000);
        }
    }
}
