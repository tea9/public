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
public class DazhongkandaioTask {
    public static void start() throws InterruptedException {
        Constant.start(Constant.DaZhongKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        ShellUtil.clickMethod(696, 1684);
        Thread.sleep(3 * 1000);
        ShellUtil.clickMethod(692, 474);
        Thread.sleep(6 * 1000);


        Constant.start(Constant.DaZhongKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
//        Thread.sleep(2*1000);
//        Log.e(Constant.TAG,"点击btn1");
//        ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_BTN1,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
        ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_LingQu, Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新

        Log.e(Constant.TAG, "点击item1");
        for (int i = 0; i < Constant.TASK_COUNT; i++) {


//        while (!Thread.currentThread().isInterrupted()&&flag) {
            slideByXyIds(Constant.DaZhongKanDian.RES_ID_ITEM1, Constant.DaZhongKanDian.FileName.file_path1); // 第一条是置顶
            Integer[] a = ShellUtil.getCoordinateByY1X2(Constant.DaZhongKanDian.RES_ID_ITEM1LL, Constant.ZhongQing.FileName.file_path1);
//            Log.e(Constant.TAG,"keyevent 1");
            if (a != null)
                ShellUtil.swipe(a[1], a[0]);
//            ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_BTN1,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
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
                while (j < 25) {

                    Log.e(Constant.TAG, "keyevent 20");
//                        RootCmd.execRootCmd("input keyevent 20 ");
                    RootCmd.execRootCmd("input swipe 25 1000 25 550");
                    j++;
                    Thread.sleep(500);

                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }
}
