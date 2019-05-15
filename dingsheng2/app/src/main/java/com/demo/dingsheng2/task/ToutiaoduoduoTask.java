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
public class ToutiaoduoduoTask {
    public static void start() {
        Log.e(Constant.TAG, "toutiaoduoduoaaaa");
//        for (int i = 0; i < Constant.TASK_COUNT; i++) {
//            Log.e(Constant.TAG, "toutiaoduoduobbbbbb" + i);
//        }
        try {
            Constant.start(Constant.TouTiaoDuoDuo.ACTIVITY_PACKAGE);

            Thread.sleep(3 * 1000);

            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_DIALOG,Constant.TouTiaoDuoDuo.FileName.file_path1);//dialog
            Thread.sleep(2000);

            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN2, Constant.TouTiaoDuoDuo.FileName.file_path1); //赚钱
            Thread.sleep(2000);
            ShellUtil.clickMethod(868,190);//领宝箱
            Thread.sleep(7 * 1000);


            Constant.start(Constant.TouTiaoDuoDuo.ACTIVITY_PACKAGE);
            Thread.sleep(3 * 1000);
            // check 红包
            Log.e(Constant.TAG, "点击btn1");
            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1, Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
            Thread.sleep(3 * 1000);
            for (int i = 0; i < Constant.TASK_COUNT; i++) {
//            while () {
//                ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL, Constant.FILE_PATH);
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void slideByXyIds2(String res_id, String file_path) throws InterruptedException {
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
                while (j < 18) {

                    Log.e(Constant.TAG, "在滑动");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    Thread.sleep(500);
                    j++;

                }
                Thread.sleep(1 * 1000);
                Log.e(Constant.TAG, "返回了");
                ShellUtil.back();
            }
        }

    }
}
