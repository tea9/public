package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/15
 * 签到写完根据坐标
 */
public class DongFangModel {

    public static void startDongFang() throws InterruptedException {
//        boolean flag= SharedPreferencesUtils.getPreferences(context).getBoolean(Constant.STOP_SERVICE,false);
//        // TODO  签到
//        if (!flag) {
        Constant.start(Constant.DongFang.ACTIVITY_PACKAGE);
        Thread.sleep(6 * 1000);

        if (ShellUtil.checkPage(Constant.DongFang.RES_ID_DIALOG, Constant.DongFang.FileName.file_path1)) {
            Log.e(Constant.TAG, "返回");
            checkBack();
            Thread.sleep(2 * 1000);
        }


        ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN2, Constant.DongFang.FileName.file_path1); //点击任务
        Thread.sleep(5 * 1000);
        ShellUtil.clickByXy(Constant.DongFang.RES_ID_JINBI_CANCLE, Constant.DongFang.FileName.file_path1); //点击金币取消
        Thread.sleep(2 * 1000);
        RootCmd.execRootCmd("input keyevent 20");
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "立即签到");
//        ShellUtil.clickByXyDesc("立即签到",Constant.DongFang.FileName.file_path1);
//        ShellUtil.clickByXyDesc("立即签到",Constant.DongFang.FileName.file_path1);
        ShellUtil.clickMethod(900, 566);
        Thread.sleep(6 * 1000);
        // 滑动页面
        Constant.start(Constant.DongFang.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        Log.e(Constant.TAG, "返回");
        checkBack();
        Thread.sleep(2 * 1000);
        //点击领取
        ShellUtil.clickByXy(Constant.DongFang.RES_ID_LINGQU, Constant.DongFang.FileName.file_path1); // 点击领取
        Thread.sleep(1 * 1000);
        checkBack();
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN1, Constant.DongFang.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG, "点击item1");
        for (int i=0;i<30;i++){
//        while (true) {
            ShellUtil.slideByXyIdsNotByDongFang(Constant.DongFang.RES_ID_ITEM1, Constant.DongFang.FileName.file_path1, 1,true); // 第一条是置顶
            ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN1, Constant.DongFang.FileName.file_path1); // 点击刷新
        }
    }

    private static void checkBack() throws InterruptedException {
        ShellUtil.back();
        Thread.sleep(1*1000);
        if (ShellUtil.checkPage("com.songheng.eastnews:id/w0",Constant.DongFang.FileName.file_path1)) { // 退出框
            ShellUtil.clickByXy("com.songheng.eastnews:id/w0",Constant.DongFang.FileName.file_path1);
        }
    }
}
