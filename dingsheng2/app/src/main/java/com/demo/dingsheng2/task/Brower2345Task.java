package com.demo.dingsheng2.task;

import android.util.Log;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.DOMTest;
import com.demo.dingsheng2.util.RootCmd;
import com.demo.dingsheng2.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2019/1/9
 * <p>
 * 签到
 */
public class Brower2345Task {

    public static void start() {
        try {
            Log.e(Constant.TAG, "brower2345aaaaa" + Thread.currentThread().getName());

            Constant.start(Constant.Browser2345.ACTIVITY_PACKAGE);
            Thread.sleep(6 * 1000);
            Log.e(Constant.TAG, "brower2345aaaaa点击领红包" + Thread.currentThread().getName());
//            ShellUtil.clickMethod(936, 182);//点击领红包
//            Thread.sleep(2 * 1000);
//            Log.e(Constant.TAG, "brower2345aaaaa返回" + Thread.currentThread().getName());
//            ShellUtil.back();
            Thread.sleep(4 * 1000);
            Log.e(Constant.TAG, "brower2345aaaaa滑动" + Thread.currentThread().getName());
            ShellUtil.swipe(1150, 600);//滑动
            Thread.sleep(2 * 1000);
            Log.e(Constant.TAG, "brower2345aaaaa领钱" + Thread.currentThread().getName());


            ShellUtil.clickMethod(939,162); //领钱
            Thread.sleep(1000);
            ShellUtil.checkPage(Constant.Browser2345.RES_I_KONW,Constant.Browser2345.FileName.file_path1);//点击我知道了

            if(!ShellUtil.checkPage(Constant.Browser2345.RES_ID_ITEM1,Constant.Browser2345.FileName.file_path1)){
                Log.e(Constant.TAG, "brower2345aaaaa返回" + Thread.currentThread().getName());
                ShellUtil.back();
            }

            Thread.sleep(2 * 1000);
            if(ShellUtil.checkPage(Constant.Browser2345.RES_ID_ITEM1,Constant.Browser2345.FileName.file_path1)) {
                for (int i = 0; i < Constant.TASK_COUNT; i++) {
                    Log.e(Constant.TAG, "brower2345aaaaa刷新" + Thread.currentThread().getName());
                    ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1, Constant.Browser2345.FileName.file_path1); // 点击刷新
                    Thread.sleep(4000);
                    Log.e(Constant.TAG, "brower2345aaaaa点击item" + Thread.currentThread().getName());
                    slideByXyIds4(Constant.Browser2345.RES_ID_ITEM1, Constant.Browser2345.FileName.file_path1); // 第一条是置顶
                }
            }



//
//            Thread.sleep(6 * 1000);
//            Log.e(Constant.TAG, "brower2345aaaaa检查广告" + Thread.currentThread().getName());
//            if (ShellUtil.checkPage(Constant.Browser2345.RES_ID_LINGQIAN_CLOSE, Constant.Browser2345.FileName.file_path1)) {
//                Log.e(Constant.TAG, "close Browser2345Runnable" + Thread.currentThread().getName());
//                ShellUtil.clickByXy(Constant.Browser2345.RES_ID_LINGQIAN_CLOSE, Constant.Browser2345.FileName.file_path1);
//            }
//            Log.e(Constant.TAG, "brower2345aaaaa点击签到" + Thread.currentThread().getName());
////            ShellUtil.clickMethod(954, 169);//点击签到
//            Thread.sleep(2000);
//            ShellUtil.back();
//            if (!ShellUtil.checkPage(Constant.Browser2345.RES_ID_BTN1,Constant.Browser2345.FileName.file_path1)) {
//                ShellUtil.back();
//            }
//            Thread.sleep(2000);
//            Log.e(Constant.TAG, "brower2345aaaaa滑动" + Thread.currentThread().getName());
//            ShellUtil.swipe(1150, 500);
//            Thread.sleep(2000);
//            Log.e(Constant.TAG, "brower2345aaaaa领钱" + Thread.currentThread().getName());
//            ShellUtil.swipe(924, 148); //领钱
//            Thread.sleep(2000);
//            for (int i = 0; i < Constant.TASK_COUNT; i++) {
//                Log.e(Constant.TAG, "brower2345aaaaa刷新" + Thread.currentThread().getName());
//                ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1, Constant.Browser2345.FileName.file_path1); // 点击刷新
//                Thread.sleep(1000);
//                Log.e(Constant.TAG, "brower2345aaaaa点击item" + Thread.currentThread().getName());
//                slideByXyIds4(Constant.Browser2345.RES_ID_ITEM1, Constant.Browser2345.FileName.file_path1); // 第一条是置顶
//            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void start() {
//        Log.e(Constant.TAG, "brower2345aaaaa");
////        for (int i = 0; i < Constant.TASK_COUNT; i++) {
////            Log.e(Constant.TAG, "brower2345aaaaabbbbbb" + i);
////        }
//        try {
//            Log.e(Constant.TAG, "start Browser2345Runnable" + Thread.currentThread().getName());
//
//            Constant.start(Constant.Browser2345.ACTIVITY_PACKAGE);
//
//            Thread.sleep(6 * 1000);
//             ShellUtil.clickMethod(398,164);//点击签到
//            Thread.sleep(2000);
//
//            //input swipe 25 1150 25 400 500
//            Log.e(Constant.TAG, "swipe Browser2345Runnable" + Thread.currentThread().getName());
//            ShellUtil.swipe(1150, 500);
////        ShellUtil.swipe(1150, 500);
//            Log.e(Constant.TAG, "点击btn1222 Browser2345Runnable" + Thread.currentThread().getName());
//            ShellUtil.clickByXy(Constant.Browser2345.RES_ID_LINGQIAN, Constant.Browser2345.FileName.file_path1); //领钱
//            if (ShellUtil.checkPage(Constant.Browser2345.RES_ID_LINGQIAN_CLOSE, Constant.Browser2345.FileName.file_path1)) {
//                Log.e(Constant.TAG, "close Browser2345Runnable" + Thread.currentThread().getName());
//                ShellUtil.clickByXy(Constant.Browser2345.RES_ID_LINGQIAN_CLOSE, Constant.Browser2345.FileName.file_path1);
//            }
////        ShellUtil.back();
//            Thread.sleep(6 * 1000);
//
//
//            Log.e(Constant.TAG, "点击btn13333 Browser2345Runnable" + Thread.currentThread().getName());
//            ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1, Constant.Browser2345.FileName.file_path1); // 点击刷新
//            for (int i = 0; i < Constant.TASK_COUNT; i++) {
////        while (!Thread.currentThread().isInterrupted() ) {
////            ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL,Constant.FILE_PATH);
//                Thread.sleep(1000);
//                Log.e(Constant.TAG, "点击btn14444 Browser2345Runnable" + Thread.currentThread().getName());
//                slideByXyIds4(Constant.Browser2345.RES_ID_ITEM1, Constant.Browser2345.FileName.file_path1); // 第一条是置顶
//                ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1, Constant.Browser2345.FileName.file_path1); // 点击刷新
//            }
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void slideByXyIds4(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 11111111111 Browser2345Runnable" + Thread.currentThread().getName());
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 122222 Browser2345Runnable" + Thread.currentThread().getName());
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 13333333 Browser2345Runnable" + Thread.currentThread().getName());
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1444444 Browser2345Runnable" + Thread.currentThread().getName());
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 15555555 Browser2345Runnable" + Thread.currentThread().getName());
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 166666666 Browser2345Runnable" + Thread.currentThread().getName());
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2777777777 Browser2345Runnable" + Thread.currentThread().getName());
                // 滑动
                int j = 0;
                RootCmd.execRootCmd("input tap 349 216");
                while (j < 30) {

                    Log.e(Constant.TAG, "keyevent 2088888Browser2345" + Thread.currentThread().getName());
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                    Thread.sleep(500);

                }
                Log.e(Constant.TAG, "keyevent 1999999999 Browser2345Runnable" + Thread.currentThread().getName());
                ShellUtil.back();
            }
        }

    }
}
