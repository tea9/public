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
public class HongbaotoutiaoTask {
    public static void start() throws InterruptedException {
        Constant.start(Constant.HongBaoTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4 * 1000);
        ShellUtil.clickByXy(Constant.HongBaoTouTiao.RES_ID_BTN2, Constant.HongBaoTouTiao.FileName.file_path1);
        Thread.sleep(3 * 1000);
        ShellUtil.clickByXy(Constant.HongBaoTouTiao.RES_ID_QianDao, Constant.HongBaoTouTiao.FileName.file_path1);
        Thread.sleep(6 * 1000);


        Constant.start(Constant.HongBaoTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4 * 1000);
//        Log.e(Constant.TAG,"返回");
        // TODO check 红包
//        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新

//        while (!Thread.currentThread().isInterrupted()&&flag){
        for (int i = 0; i < Constant.TASK_COUNT; i++) {
            Log.e(Constant.TAG, "点击item111111");
            slideByXyIds5(Constant.HongBaoTouTiao.RES_ID_ITEM1, Constant.HongBaoTouTiao.FileName.file_path1);
            Integer[] a = ShellUtil.getCoordinateByY1X2(Constant.HongBaoTouTiao.RES_ID_ITEM1LL, Constant.HongBaoTouTiao.FileName.file_path1);
            Log.e(Constant.TAG, "滑动坐标");
//            if (a != null)
//                ShellUtil.swipe(a[1], a[0]);
            ShellUtil.swipe(800,1490);
        }
    }

    public static void slideByXyIds5(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateWithTextHongbaoTouTiao(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
//                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(2 * 1000);
//                Log.e(Constant.TAG,"keyevent 2");
                // 滑动
                int j = 0;
                while (j < 2) {
                    for (int k = 0; k < 5; k++) {
                        RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
                        Thread.sleep(500);

                    }
                    Thread.sleep(2 * 1000);
                    j++;
                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }
}
