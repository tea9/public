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
public class ZhangshangtoutiaoTask {

    public static void start() throws InterruptedException {
        Log.e(Constant.TAG, "掌上");
        Constant.start(Constant.ZhangShangTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4 * 1000);
        ShellUtil.clickByXy(Constant.ZhangShangTouTiao.RES_ID_BTN2,Constant.ZhangShangTouTiao.FileName.file_path1);//任务
        Thread.sleep(8 * 1000);

////////////////

        Constant.start(Constant.ZhangShangTouTiao.ACTIVITY_PACKAGE);
        ShellUtil.clickByXy(Constant.ZhangShangTouTiao.LINNGQU,Constant.ZhangShangTouTiao.FileName.file_path1);//领取


//        Thread.sleep(3000);
//        ShellUtil.swipe(569,1322); //刷新
//        Thread.sleep(2000);
//        ShellUtil.swipe(569, 1322); //刷新
        Thread.sleep(2000);

        for (int i = 0; i < Constant.TASK_COUNT; i++) {
            Thread.sleep(2 * 1000);
//            ShellUtil.swipe(569, 1322); //刷新
//            Thread.sleep(2000);
            ShellUtil.swipe(569, 1322); //刷新
            Thread.sleep(2 * 1000);

//            RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//            Thread.sleep(1 * 1000);

            slideByXyIds(Constant.ZhangShangTouTiao.RES_ID_ITEM1, Constant.ZhangShangTouTiao.FileName.file_path1);//点击item
        }









//        ShellUtil.clickByXy(Constant.ZhangShangTouTiao.RES_ID_BTN1, Constant.ZhangShangTouTiao.FileName.file_path1); // 点击刷新
//        while (!Thread.currentThread().isInterrupted() && flag) {
//        for (int i = 0; i < Constant.TASK_COUNT; i++) {
//
//
//            Log.e(Constant.TAG, "点击item111111");
////            ShellUtil.clickByXyIds(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
//            slideByXyIds(Constant.ZhangShangTouTiao.RES_ID_ITEM1, Constant.ZhangShangTouTiao.FileName.file_path1);
////            ShellUtil.slideByXyIdsNot(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
////            Log.e(Constant.TAG,"keyevent 1");
//            Integer[] a = ShellUtil.getCoordinateByY1X2(Constant.ZhongQing.RES_ID_ITEM1LL, Constant.ZhangShangTouTiao.FileName.file_path1);
////            Log.e(Constant.TAG,"keyevent 1");
//            if (a != null)
//                ShellUtil.swipe(a[1], a[0]);
//        }
    }

    public static void slideByXyIds(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 1; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                Thread.sleep(2000);
                int j = 0;
                while (j < 18) {
                    Log.e(Constant.TAG, "keyevent 20");
//                    RootCmd.execRootCmd("input keyevent 20 ");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 2000");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    ShellUtil.clickByXy(Constant.ZhangShangTouTiao.ZHANGKAIQUANWEN,Constant.ZhangShangTouTiao.FileName.file_path1);
//                    Thread.sleep(50);
                    j++;

                }
                int k=0;
                while (k<7){
                    RootCmd.execRootCmd("input swipe 25 450 25 1050 500");
                    Thread.sleep(100);
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    Thread.sleep(800);
                    k++;
                }
                Log.e(Constant.TAG, "keyevent 1 back");
                ShellUtil.back();
            }
        }

    }
}
