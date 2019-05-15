package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/22
 * 没测试
 */
public class JiuCaiZiXunModel {

    public static void start() throws InterruptedException {


        Constant.start(Constant.JiuCaiZiXun.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO,Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN2,Constant.JiuCaiZiXun.FileName.file_path1); // 任务
        Thread.sleep(2*1000);
        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO,Constant.JiuCaiZiXun.FileName.file_path1); // 签到
        Thread.sleep(6*1000);
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
//        Thread.sleep(2*1000);
        Constant.start(Constant.JiuCaiZiXun.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO,Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
        Thread.sleep(3*1000);
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN1,Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG,"点击item1");
        while (true) {
            ShellUtil.slideByXyIds(Constant.JiuCaiZiXun.RES_ID_ITEM1, Constant.JiuCaiZiXun.FileName.file_path1);
            ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN1,Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
        }
    }
}
