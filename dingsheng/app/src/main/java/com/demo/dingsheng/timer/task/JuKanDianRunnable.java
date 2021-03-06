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
public class JuKanDianRunnable implements Runnable {
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
        Constant.start(Constant.JuKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        ShellUtil.back();
        Thread.sleep(2 * 1000);
        ShellUtil.clickByXy(Constant.JuKanDian.RES_ID_BTN2, Constant.JuKanDian.FileName.file_path1); // 点击刷新
        Thread.sleep(6 * 1000);


        Constant.start(Constant.JuKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        Log.e(Constant.TAG, "返回");
        ShellUtil.back();
        Thread.sleep(2 * 1000);
        ShellUtil.clickByXy(Constant.JuKanDian.LINGQU, Constant.JuKanDian.FileName.file_path1); // 点击刷新
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.JuKanDian.RES_ID_BTN1, Constant.JuKanDian.FileName.file_path1); // 点击刷新
        Log.e(Constant.TAG, "点击item1");
        while (!Thread.currentThread().isInterrupted() && flag) {
            slideByXyIds(Constant.JuKanDian.RES_ID_ITEM1, Constant.DongFang.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN1, Constant.DongFang.FileName.file_path1); // 点击刷新
        }
    }

    public synchronized void slideByXyIds(String res_id, String file_path) throws InterruptedException {
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
                while (j < 30 && flag) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    try {
                        Log.e(Constant.TAG, "keyevent 20");
                        RootCmd.execRootCmd("input keyevent 20 ");
                        j++;
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }
}
