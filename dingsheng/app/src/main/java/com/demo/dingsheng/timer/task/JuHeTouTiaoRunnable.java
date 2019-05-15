package com.demo.dingsheng.timer.task;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.DOMTest;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2018/12/26
 */
public class JuHeTouTiaoRunnable implements Runnable {

    public static volatile boolean flag = true;

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted() && flag) {
            try {
                start();
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }

    private synchronized void start() throws InterruptedException {
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
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.JuHeTouTiao.RES_ID_BTN1, Constant.JuHeTouTiao.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG, "点击item1");
        while (!Thread.currentThread().isInterrupted() && flag) {
            slideByXyIds6(Constant.JuHeTouTiao.RES_ID_ITEM1, Constant.JuHeTouTiao.FileName.file_path1);
            ShellUtil.clickByXy(Constant.JuHeTouTiao.RES_ID_BTN1, Constant.JuHeTouTiao.FileName.file_path1); // 点击刷新
        }
    }

    public synchronized void slideByXyIds6(String res_id, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            for (int i = 0; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "点击坐标");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(4 * 1000);
                // 滑动
                int j = 0;
                while (j < 40 && flag) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    try {
                        Log.e(Constant.TAG, "在滑动");
                        RootCmd.execRootCmd("input swipe 25 1050 25 450 1000");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                        j++;
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
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
            }
        }

    }
}
