package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 滑动不了
 * 更新了
 * 没测试
 */
public class JuKanDianModel {

    public static void start() throws InterruptedException {
        Constant.start(Constant.JuKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.back();
        Thread.sleep(2*1000);
        ShellUtil.clickByXy(Constant.JuKanDian.RES_ID_BTN2,Constant.JuKanDian.FileName.file_path1); // 点击刷新
        Thread.sleep(6*1000);


        Constant.start(Constant.JuKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        Log.e(Constant.TAG,"返回");
        ShellUtil.back();
        Thread.sleep(2*1000);
        ShellUtil.clickByXy(Constant.JuKanDian.LINGQU,Constant.JuKanDian.FileName.file_path1); // 点击刷新
        Thread.sleep(2*1000);
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.JuKanDian.RES_ID_BTN1,Constant.JuKanDian.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG,"点击item1");
        while (true) {
            ShellUtil.slideByXyIds(Constant.JuKanDian.RES_ID_ITEM1, Constant.DongFang.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN1,Constant.DongFang.FileName.file_path1); // 点击刷新
        }
    }
}
