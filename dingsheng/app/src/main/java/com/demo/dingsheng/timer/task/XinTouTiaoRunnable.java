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
public class XinTouTiaoRunnable implements Runnable {
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

    private void start() throws InterruptedException {
        Log.e(Constant.TAG, "start新头条"+Thread.currentThread().getName());
        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.XinTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4 * 1000);
        ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN2, Constant.XinTouTiao.FileName.file_path1); //任务
        Thread.sleep(10 * 1000);




        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.XinTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4 * 1000);
        ShellUtil.clickByXy(Constant.XinTouTiao.SHIDUAN, Constant.MaYi.FileName.file_path1); // 时段
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
        while (!Thread.currentThread().isInterrupted() && flag) {
            Log.e(Constant.TAG, "点击item1");
            slideByXyIds(Constant.XinTouTiao.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
        }
    }

    public void slideByXyIds(String res_id, String file_path) throws InterruptedException {
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
                        Log.e(Constant.TAG, "input swipe 25 1000 25 550");
                        RootCmd.execRootCmd("input swipe 25 1000 25 550");
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
