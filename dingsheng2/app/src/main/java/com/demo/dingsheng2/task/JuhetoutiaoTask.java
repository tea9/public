package com.demo.dingsheng2.task;

import android.util.Log;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.DOMTest;
import com.demo.dingsheng2.util.RootCmd;
import com.demo.dingsheng2.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2019/1/9
 * 签到
 */
public class JuhetoutiaoTask {
    public static void start() throws InterruptedException {
        Constant.start(Constant.JuHeTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        ShellUtil.clickMethod(945, 1728);
        Thread.sleep(3 * 1000);
        ShellUtil.clickMethod(376, 1577);
        Thread.sleep(3 * 1000);
        ShellUtil.clickMethod(587, 722);
        Thread.sleep(6 * 1000);


        Constant.start(Constant.JuHeTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        //领红包
        ShellUtil.clickMethod(176,1685);
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickMethod(176,1685);
        Log.e(Constant.TAG, "点击item1");
        Thread.sleep(1000);

        for (int i = 0; i < Constant.TASK_COUNT2+6; i++) { //20分钟

//        while (!Thread.currentThread().isInterrupted() && flag) {
            Log.e(Constant.TAG, "RES_ID_ITEM1");
            slideByXyIds6(Constant.JuHeTouTiao.RES_ID_ITEM1, Constant.JuHeTouTiao.FileName.file_path1);
            Log.e(Constant.TAG, "滑动聚合头条");
//            ShellUtil.clickByXy(Constant.JuHeTouTiao.RES_ID_BTN1, Constant.JuHeTouTiao.FileName.file_path1); // 点击刷新
            ShellUtil.clickMethod(176,1685);
        }
    }

//    public static void xx() throws InterruptedException {
//        ShellUtil.clickMethod(111, 111);
//
//        Thread.sleep(2000);
//
//        int j = 0;
//        while (j < 20) {
//
//            Log.e(Constant.TAG, "在滑动");
//            Log.e(Constant.TAG, "滑动聚合头条");
////            RootCmd.execRootCmd("input swipe 25 1050 25 450 2000");
//            RootCmd.execRootCmd("input swipe 25 850 25 450 2000");
////                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//            j++;
//            Thread.sleep(1000);
//
//        }
//        Thread.sleep(1 * 1000);
//        ShellUtil.back();
//    }

    public static void slideByXyIds6(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG, "slideByXyIds6");
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            Log.e(Constant.TAG, "点击坐标");
            for (int i = 0; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "点击坐标11111111111");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(5 * 1000);

                for (int k = 0; k <2 ; k++) {
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                }
                Log.e(Constant.TAG, "滑动聚合头条点击展开全文");
//                ShellUtil.clickMethod(554,1226);
                ShellUtil.clickMethod(548,942);
                ShellUtil.clickMethod(548,1144);

                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 18) {

                    Log.e(Constant.TAG, "在滑动");
                    Log.e(Constant.TAG, "滑动聚合头条");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 1000");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    j++;
                    Thread.sleep(500);

                }
//                int k = 0;
//                while (k<23) {
//                    Log.e(Constant.TAG,"在滑动");
//                    RootCmd.execRootCmd("input swipe 25 450 25 1050 700");
////                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//                    k++;
//                }
                Thread.sleep(1 * 1000);
                Log.e(Constant.TAG, "返回了");
                ShellUtil.back();
                Thread.sleep(1 * 1000);
                if (!ShellUtil.checkPage(Constant.JuHeTouTiao.RES_ID_ITEM1,Constant.JuHeTouTiao.FileName.file_path1)) {
                    ShellUtil.back();
                }
            }
        }

    }
}
