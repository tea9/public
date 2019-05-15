package com.demo.dingsheng2.task;

import android.util.Log;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.DOMTest;
import com.demo.dingsheng2.util.RootCmd;
import com.demo.dingsheng2.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2019/1/9
 * 判断广告
 */
public class ShandiankankanTask {
    public static void start() throws InterruptedException {
        Constant.start(Constant.ShanDianKanKan.ACTIVITY_PACKAGE);
        Thread.sleep(10 * 1000);
        Log.e(Constant.TAG, "领取");
        ShellUtil.clickByXy(Constant.ShanDianKanKan.LINGQU, Constant.ShanDianKanKan.FileName.file_path1);
        Thread.sleep(3 * 1000);


//        Thread.sleep(2 * 1000);
//        while (!Thread.currentThread().isInterrupted() && flag) {
        for (int i = 0; i < Constant.TASK_COUNT; i++) {
            Log.e(Constant.TAG, "刷新");
//            ShellUtil.clickMethod(127, 1687);//刷新
//            Thread.sleep(3 * 1000);
//            ShellUtil.clickMethod(127, 1687);//刷新
//            Thread.sleep(3 * 1000);

            Log.e(Constant.TAG, "点击");
            slideByXyIds(Constant.ShanDianKanKan.RES_ID_ITEM1, Constant.ShanDianKanKan.FileName.file_path1); // 第一条是置顶
//            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
//            ShellUtil.clickMethod(127, 1687);//刷新
            Thread.sleep(2 * 1000);
            ShellUtil.clickMethod(127, 1687);//刷新
            Thread.sleep(3 * 1000);
            RootCmd.execRootCmd("input swipe 25 900 25 550");
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
                Log.e(Constant.TAG, "闪电盒子keyevent 1"+x1+":"+y1);
                ShellUtil.clickMethod(x1, y1);
                if (ShellUtil.checkPageByText("使用以下方式打开",Constant.ShanDianKanKan.FileName.file_path1)||ShellUtil.checkPageByText("打包安装程序",Constant.ShanDianKanKan.FileName.file_path1)) {
                    ShellUtil.back();
                }
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 10) {
                    Log.e(Constant.TAG, "keyevent 20");
                    RootCmd.execRootCmd("input keyevent 20 ");
                    Thread.sleep(500);
                    j++;
                }
                Thread.sleep(1000);
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }
}
