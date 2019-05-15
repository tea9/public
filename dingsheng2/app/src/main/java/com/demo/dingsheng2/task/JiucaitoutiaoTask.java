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
public class JiucaitoutiaoTask {

    public static void start() throws InterruptedException {
        Constant.start(Constant.JiuCaiZiXun.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        Log.e(Constant.TAG, "韭菜头条点击弹框");
        ShellUtil.clickMethod(546,1409);//弹框
        Thread.sleep(3 * 1000);
//        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO, Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
//        Thread.sleep(3 * 1000);
//        ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN2, Constant.JiuCaiZiXun.FileName.file_path1); // 任务
        // 650 1718
        Log.e(Constant.TAG, "点击任务");
        ShellUtil.clickMethod(650,1718); //任务
        Thread.sleep(2 * 1000);
//        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO, Constant.JiuCaiZiXun.FileName.file_path1); // 签到
        Log.e(Constant.TAG, "点击签到");
        ShellUtil.clickMethod(550,391); //任务
        Thread.sleep(6 * 1000);
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
//        Thread.sleep(2*1000);
        /////////////////////

        Constant.start(Constant.JiuCaiZiXun.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        ShellUtil.clickMethod(540,1403); //弹框
//        Thread.sleep(3 * 1000);
//        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO, Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
        Thread.sleep(3 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN1, Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新

        Log.e(Constant.TAG, "点击item1");
//        while (!Thread.currentThread().isInterrupted() &&) {
        for (int i = 0; i < Constant.TASK_COUNT; i++) {
            slideByXyIds(Constant.JiuCaiZiXun.RES_ID_ITEM1, Constant.JiuCaiZiXun.FileName.file_path1);
            ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN1, Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
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
                while (j < 30) {

                    Log.e(Constant.TAG, "keyevent 20");
//                    RootCmd.execRootCmd("input keyevent 20 ");
                    RootCmd.execRootCmd("input swipe 25 1000 25 550");
                    j++;

                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }
}
