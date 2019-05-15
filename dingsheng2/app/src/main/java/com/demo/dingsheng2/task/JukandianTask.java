package com.demo.dingsheng2.task;

import android.util.Log;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.DOMTest;
import com.demo.dingsheng2.util.RootCmd;
import com.demo.dingsheng2.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2019/1/9
 */
public class JukandianTask {

    public static void start() throws InterruptedException {
//        Constant.start(Constant.JuKanDian.ACTIVITY_PACKAGE);
//        Thread.sleep(10 * 1000);
//
//        ShellUtil.clickByXy(Constant.JuKanDian.RES_ID_QIANDAO_DIALOG,Constant.JuKanDian.FileName.file_path1); //点击签到
//        Thread.sleep(2 * 1000);
//        checkBack();
//        Thread.sleep(2 * 1000);
//        ShellUtil.clickByXy(Constant.JuKanDian.RES_ID_BTN2, Constant.JuKanDian.FileName.file_path1); // 点击任务
//        Thread.sleep(6 * 1000);


        Constant.start(Constant.JuKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(10 * 1000);
        Log.e(Constant.TAG, "返回");
//        checkBack();
//        Thread.sleep(2 * 1000);
//        checkBack();
//        Thread.sleep(2 * 1000);
//        checkBack();
//        ShellUtil.clickByXy("com.xiangzi.jukandian:id/cancel_quit",Constant.JuKanDian.FileName.file_path1);
//        Thread.sleep(2 * 1000);
//        ShellUtil.clickByXy("com.xiangzi.jukandian:id/cancel_quit",Constant.JuKanDian.FileName.file_path1);

        if (!ShellUtil.checkPage(Constant.JuKanDian.RES_ID_ITEM1,Constant.JuKanDian.FileName.file_path1)){
            ShellUtil.back();
        }
        Thread.sleep(2 * 1000);
        ShellUtil.clickByXy(Constant.JuKanDian.LINGQU, Constant.JuKanDian.FileName.file_path1); // 点击领取
        Thread.sleep(2 * 1000);
        ShellUtil.clickByXy(Constant.JuKanDian.LINGQU_CLOSE,Constant.JuKanDian.FileName.file_path1);//聚看点 close
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.JuKanDian.RES_ID_BTN1, Constant.JuKanDian.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG, "点击item1");
//        while (!Thread.currentThread().isInterrupted() && flag) {
        for (int i = 0; i < Constant.TASK_COUNT; i++) {

            slideByXyIds(Constant.JuKanDian.RES_ID_ITEM1, Constant.JuKanDian.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.JuKanDian.RES_ID_BTN1, Constant.JuKanDian.FileName.file_path1); // 点击刷新
        }
    }

    public static void slideByXyIds(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 22) {
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 1000");
                    Log.e(Constant.TAG, "keyevent 20");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 1000");
                    Thread.sleep(500);
                    RootCmd.execRootCmd("input keyevent 20 ");
                    Thread.sleep(500);
                    j++;

                }
                Log.e(Constant.TAG, "keyevent 1");
                checkBack();
            }
        }

    }

    public static void checkBack() throws InterruptedException {
        ShellUtil.back();
        if (ShellUtil.checkPage(Constant.JuKanDian.TUICHU,Constant.JuKanDian.FileName.file_path1)){
            Thread.sleep(1000);
            ShellUtil.clickByXy(Constant.JuKanDian.TUICHU,Constant.JuKanDian.FileName.file_path1);
            ShellUtil.clickByXy(Constant.JuKanDian.TUICHU,Constant.JuKanDian.FileName.file_path1);
        }
    }
}
