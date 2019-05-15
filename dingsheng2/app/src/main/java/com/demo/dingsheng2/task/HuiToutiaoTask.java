package com.demo.dingsheng2.task;

import android.util.Log;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.DOMTest;
import com.demo.dingsheng2.util.RootCmd;
import com.demo.dingsheng2.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2019/1/12
 */
public class HuiToutiaoTask {

    public void start() throws InterruptedException {
        Constant.start(Constant.HuiTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        ShellUtil.clickByXy(Constant.HuiTouTiao.DIALOG_CLOSE,Constant.HuiTouTiao.FileName.file_path1);
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "惠头条点击任务中心"+Thread.currentThread().getName());
        ShellUtil.clickMethod(770,1712);//任务中心
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "惠头条点击签到"+Thread.currentThread().getName());
        ShellUtil.clickMethod(529,383);//签到
        Thread.sleep(6 * 1000);

        //////////

        Constant.start(Constant.HuiTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        ShellUtil.clickByXy(Constant.HuiTouTiao.DIALOG_CLOSE,Constant.HuiTouTiao.FileName.file_path1);
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "惠头条刷新"+Thread.currentThread().getName());
        ShellUtil.clickMethod(141,1703);//刷新
        Thread.sleep(3 * 1000);
        Log.e(Constant.TAG, "惠头条时段奖励"+Thread.currentThread().getName());
        ShellUtil.clickMethod(895,135);//时段奖励
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "惠头条时段奖励忽略"+Thread.currentThread().getName());
        ShellUtil.clickByXy(Constant.HuiTouTiao.SHIDUAN_HULUE,Constant.HuiTouTiao.FileName.file_path1);//时段奖励忽略
        Thread.sleep(2 * 1000);

        for (int i = 0; i < Constant.TASK_COUNT; i++) {
            Log.e(Constant.TAG, "惠头条刷新"+Thread.currentThread().getName());
            ShellUtil.clickMethod(141,1703);//刷新
            Log.e(Constant.TAG, "惠头条item"+Thread.currentThread().getName());
            Thread.sleep(2 * 1000);
            slideByXyIds2(Constant.HuiTouTiao.RES_ID_ITEM1,Constant.HuiTouTiao.FileName.file_path1);
            Thread.sleep(1000);
        }
    }

    public void slideByXyIds2(String res_id, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            for (int i =2; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "点击坐标");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 18) {

                    Log.e(Constant.TAG, "惠头条 在滑动");
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
