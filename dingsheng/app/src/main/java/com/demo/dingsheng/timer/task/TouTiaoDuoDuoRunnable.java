package com.demo.dingsheng.timer.task;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.DOMTest;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2018/12/26
 * 头条带红包的
 */
public class TouTiaoDuoDuoRunnable implements Runnable {

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
        Constant.start(Constant.TouTiaoDuoDuo.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN2, Constant.TouTiaoDuoDuo.FileName.file_path1); //赚钱
        Thread.sleep(7 * 1000);


        Constant.start(Constant.TouTiaoDuoDuo.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        // check 红包
        Log.e(Constant.TAG, "点击btn1");
        ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1, Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
        Thread.sleep(3 * 1000);
//        for (int i=0;i<30;i++){
        while (!Thread.currentThread().isInterrupted() && flag) {
            ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL,Constant.FILE_PATH);
            Thread.sleep(1000);
            slideByXyIds2(Constant.TouTiaoDuoDuo.RES_ID_ITEM1, Constant.TouTiaoDuoDuo.FileName.file_path1); // 文章需要滑到底
            Thread.sleep(2 * 1000);
            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1, Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
            Thread.sleep(3 * 1000);
//            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1,Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
//            Thread.sleep(3*1000);
//            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1,Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
//            Thread.sleep(5*1000);
        }
    }

    public void slideByXyIds2(String res_id, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            for (int i = 0; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "点击坐标");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 23 && flag && !Thread.currentThread().isInterrupted()) {
                    try {
                        Log.e(Constant.TAG, "在滑动");
                        RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                        Thread.sleep(500);
                        j++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                Thread.sleep(1 * 1000);
                Log.e(Constant.TAG, "返回了");
                ShellUtil.back();
            }
        }

    }
}
