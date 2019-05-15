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
public class MayitoutiaoTask {
    public static void start() {
        Log.e(Constant.TAG, "mayitoutiaoaaaaa");
//        for (int i = 0; i < Constant.TASK_COUNT; i++) {
//            Log.e(Constant.TAG, "mayitoutiaobbbbb" + i);
//        }
        try {
            before();

            Thread.sleep(3 * 1000);
            ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN2, Constant.MaYi.FileName.file_path1); //任务
            Thread.sleep(3 * 1000);
            ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
            Thread.sleep(2 * 1000);
            if (ShellUtil.checkPage(Constant.MaYi.DIALOG_RED, Constant.MaYi.FileName.file_path1)) { //check红包 好像id不一样
                ShellUtil.back();
                ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
            }
            Thread.sleep(2 * 1000);
            ShellUtil.clickMethod(833, 578); // 签到
            Thread.sleep(10 * 1000);

///////////////////////

            before();

            Thread.sleep(2 * 1000);
            ShellUtil.clickByXy(Constant.MaYi.LING_QU, Constant.MaYi.FileName.file_path1); //领取
            Thread.sleep(2 * 1000);
            ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
            Log.e(Constant.TAG, "点击btn1");
            Thread.sleep(1 * 1000);
            ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1); // 点击刷新
//            while (Constant.TASK_COUNT) {
            for (int i = 0; i < Constant.TASK_COUNT; i++) {
//                ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL, Constant.FILE_PATH);
                Thread.sleep(1000);
                Log.e(Constant.TAG, "点击item1");
                slideByXyIdsMAYI(Constant.MaYi.RES_ID_ITEM1, Constant.MaYi.FileName.file_path1); // 第一条是置顶
                ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1); // 点击刷新
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void before() throws InterruptedException {
        Constant.start(Constant.MaYi.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
        Thread.sleep(6 * 1000);
        ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
        Log.e(Constant.TAG, "点击btn1");
        if (ShellUtil.checkPage(Constant.MaYi.DIALOG_RED, Constant.MaYi.FileName.file_path1)) {
            ShellUtil.back();
            ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
        }
    }

    public static void slideByXyIdsMAYI(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");


        Map<String, Integer> aa = DOMTest.getCoordinateWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            int x1 = aa.get("x1");
            int y1 = aa.get("y1");
            ShellUtil.clickMethod(x1, y1);
            Log.e(Constant.TAG, "keyevent 1");
            Thread.sleep(2 * 1000);
            Log.e(Constant.TAG, "keyevent 2");
            // 滑动
            int j = 0;
            while (j < 20) {
                Log.e(Constant.TAG, "keyevent 20");

//                RootCmd.execRootCmd("input keyevent 20 ");
                RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
                Thread.sleep(2 * 1000);
                j++;

            }
            Log.e(Constant.TAG, "keyevent 1");
            Thread.sleep(1 * 1000);
            ShellUtil.back();
            Thread.sleep(1 * 1000);
        }


//        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
//        Log.e(Constant.TAG,"keyevent 1");
//        if (aa != null) {
//            Log.e(Constant.TAG,"keyevent 1");
//            for (int i = 0; i < aa.size(); i++) {
//                Log.e(Constant.TAG,"keyevent 1");
//                int x1 = aa.get(i+"").get("x1");
//                int y1 = aa.get(i+"").get("y1");
//                clickMethod(x1, y1);
//                Log.e(Constant.TAG,"keyevent 1");
//                Thread.sleep(2*1000);
//                Log.e(Constant.TAG,"keyevent 2");
//                // 滑动
//                int j = 0;
//                while (j<50) {
//                    Log.e(Constant.TAG,"keyevent 20");
//                    RootCmd.execRootCmd("input keyevent 20 ");
//                    j++;
//                }
//                Log.e(Constant.TAG,"keyevent 1");
//                Thread.sleep(1*1000);
//                ShellUtil.back();
//                Thread.sleep(1*1000);
//            }
//        }

    }
}
