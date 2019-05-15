package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 签到写完 领取写完
 */
public class QuTouTiaoModel {

    public static void startQuTouTiao() throws InterruptedException {
        Constant.start(Constant.QuTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN3,Constant.QuTouTiao.FileName.file_path1); // 点击任务
        Thread.sleep(6*1000);
//        ShellUtil.clickByXy(Constant.QuTouTiao.HONGBAOTANKUANG,Constant.QuTouTiao.FileName.file_path1); // 点击红包弹框
//        ShellUtil.clickByXy(Constant.QuTouTiao.HONGBAOTANKUANG1,Constant.QuTouTiao.FileName.file_path1); // 点击红包弹框
//        Thread.sleep(2*1000);
//        ShellUtil.clickByXy(Constant.QuTouTiao.QIANDAO,Constant.QuTouTiao.FileName.file_path1); // 点击签到
//        Thread.sleep(6*1000);

        Constant.start(Constant.QuTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.QuTouTiao.LINGQU,Constant.QuTouTiao.FileName.file_path1); //点击领取
        Thread.sleep(3*1000);
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN1,Constant.QuTouTiao.FileName.file_path1); // 点击刷新
        for (int i=0;i<30;i++){
//        while (true){
            ShellUtil.slideByXyIdsNot(Constant.QuTouTiao.RES_ID_ITEM1, Constant.QuTouTiao.FileName.file_path1,2); // 第一条是置顶
            ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN1,Constant.QuTouTiao.FileName.file_path1); // 点击刷新
        }
    }
}
