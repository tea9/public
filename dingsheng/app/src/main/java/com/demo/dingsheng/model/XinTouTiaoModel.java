package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/22
 * 没测试
 */
public class XinTouTiaoModel {
    public static void start() throws InterruptedException {

        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.XinTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4 * 1000);
        ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN2,Constant.XinTouTiao.FileName.file_path1);


        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.XinTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4 * 1000);
        ShellUtil.clickByXy(Constant.XinTouTiao.SHIDUAN, Constant.MaYi.FileName.file_path1); // 时段
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
        while (true) {
            Log.e(Constant.TAG, "点击item1");
            ShellUtil.slideByXyIds(Constant.XinTouTiao.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
        }
    }
}
