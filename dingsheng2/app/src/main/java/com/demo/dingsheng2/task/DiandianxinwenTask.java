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
public class DiandianxinwenTask {
    public static void start() throws InterruptedException {
        Constant.start(Constant.DianDianXinWen.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        Log.e(Constant.TAG, "返回");
        ShellUtil.back();
        Thread.sleep(2 * 1000);
        ShellUtil.clickByXy(Constant.DianDianXinWen.RES_ID_BTN2, Constant.DianDianXinWen.FileName.file_path1); // 点击刷新
        Thread.sleep(6 * 1000);


        Constant.start(Constant.DianDianXinWen.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        Log.e(Constant.TAG, "返回");
        ShellUtil.back();
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.DianDianXinWen.RES_ID_BTN1, Constant.DianDianXinWen.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG, "点击item1");
//        while (!Thread.currentThread().isInterrupted() && flag) {
        for (int i = 0; i <Constant.TASK_COUNT2 ; i++) {


            Log.e(Constant.TAG, "点击");
            slideByXyIds(Constant.DianDianXinWen.RES_ID_ITEM1, Constant.DianDianXinWen.FileName.file_path1); // 第一条是置顶
//            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.DianDianXinWen.RES_ID_ITEM1,Constant.DianDianXinWen.FileName.file_path1);
            Log.e(Constant.TAG, "滑动");
//            ShellUtil.swipe(a[1],a[0]);
//            ShellUtil.swipeDownMethod1();
            RootCmd.execRootCmd("input swipe 25 1450 25 450 700");
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
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                    Thread.sleep(500);

                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }
}
