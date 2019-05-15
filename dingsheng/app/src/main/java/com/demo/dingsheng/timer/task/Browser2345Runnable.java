package com.demo.dingsheng.timer.task;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.DOMTest;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2018/12/26
 * 处理广告
 */
public class Browser2345Runnable implements Runnable {

    public static volatile boolean flag = true;

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted() && flag) {
            try {
                start();
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag=false;
            }
        }
    }

    private synchronized void start() throws InterruptedException {
//        Constant.start(Constant.Browser2345.ACTIVITY_PACKAGE);
//        Thread.sleep(3*1000);
////        ShellUtil.swipe(1150,500);
////        ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN2,Constant.Browser2345.FileName.file_path1); //领现金
////        5381684
//        ShellUtil.clickMethod(538,1684);
//        Thread.sleep(10*1000);

        Log.e(Constant.TAG, "start Browser2345Runnable" + Thread.currentThread().getName());
        Constant.start(Constant.Browser2345.ACTIVITY_PACKAGE);
        Thread.sleep(6 * 1000);
        //input swipe 25 1150 25 400 500
        Log.e(Constant.TAG, "swipe Browser2345Runnable" + Thread.currentThread().getName());
        ShellUtil.swipe(1150, 500);
//        ShellUtil.swipe(1150, 500);
        Log.e(Constant.TAG, "点击btn1222 Browser2345Runnable" + Thread.currentThread().getName());
        ShellUtil.clickByXy(Constant.Browser2345.RES_ID_LINGQIAN, Constant.Browser2345.FileName.file_path1); //领钱
        if (ShellUtil.checkPage(Constant.Browser2345.RES_ID_LINGQIAN_CLOSE, Constant.Browser2345.FileName.file_path1)) {
            Log.e(Constant.TAG, "close Browser2345Runnable" + Thread.currentThread().getName());
            ShellUtil.clickByXy(Constant.Browser2345.RES_ID_LINGQIAN_CLOSE, Constant.Browser2345.FileName.file_path1);
        }
//        ShellUtil.back();
        Thread.sleep(6 * 1000);


        Log.e(Constant.TAG, "点击btn13333 Browser2345Runnable" + Thread.currentThread().getName());
        ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1, Constant.Browser2345.FileName.file_path1); // 点击刷新
//        for(int i=0;i<30;i++){
        while (!Thread.currentThread().isInterrupted() && flag) {
            ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL,Constant.FILE_PATH);
            Thread.sleep(1000);
            Log.e(Constant.TAG, "点击btn14444 Browser2345Runnable" + Thread.currentThread().getName());
            slideByXyIds4(Constant.Browser2345.RES_ID_ITEM1, Constant.Browser2345.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1, Constant.Browser2345.FileName.file_path1); // 点击刷新
        }
    }

    public synchronized void slideByXyIds4(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 11111111111 Browser2345Runnable" + Thread.currentThread().getName());
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 122222 Browser2345Runnable" + Thread.currentThread().getName());
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 13333333 Browser2345Runnable" + Thread.currentThread().getName());
        if (aa != null && flag && !Thread.currentThread().isInterrupted()) {
            Log.e(Constant.TAG, "keyevent 1444444 Browser2345Runnable" + Thread.currentThread().getName());
            for (int i = 0; i < aa.size(); i++) {
                if (!flag || Thread.currentThread().isInterrupted()) {
                    break;
                }
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
                while (j < 30&&flag) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    try {
                        Log.e(Constant.TAG, "keyevent 2088888Browser2345" + Thread.currentThread().getName());
                        RootCmd.execRootCmd("input keyevent 20 ");
                        j++;
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                Log.e(Constant.TAG, "keyevent 1999999999 Browser2345Runnable" + Thread.currentThread().getName());
                ShellUtil.back();
            }
        }

    }
}
