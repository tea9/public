package com.demo.dingsheng2.task;

import android.util.Log;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.DOMTest;
import com.demo.dingsheng2.util.RootCmd;
import com.demo.dingsheng2.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2019/1/16
 */
public class YinlizixunTask {

    public static void start() throws InterruptedException {
        Constant.start(Constant.YinLiZiXun.ACTIVITY_PACKAGE);
        Thread.sleep(10 * 1000);
        Log.e(Constant.TAG, "打开引力资讯"+Thread.currentThread().getName());
        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_ID_BTN2,Constant.YinLiZiXun.FileName.file_path1); //我的
        Thread.sleep(2 * 1000);
        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_ID_BTN2_DIALOG,Constant.YinLiZiXun.FileName.file_path1); // 弹框
        Thread.sleep(2 * 1000);
        ShellUtil.clickMethod(988,312);
        Thread.sleep(2 * 1000);
        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_QIANDAO,Constant.YinLiZiXun.FileName.file_path1);//签到
        Thread.sleep(6 * 1000);

        Constant.start(Constant.YinLiZiXun.ACTIVITY_PACKAGE);
        Thread.sleep(10 * 1000);
        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_LINGQU,Constant.YinLiZiXun.FileName.file_path1);//领取
        Thread.sleep(2000);
        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_LINGQU_CLOSE,Constant.YinLiZiXun.FileName.file_path1);

        for (int i = 0; i < Constant.TASK_COUNT; i++) {
            ShellUtil.clickByXy(Constant.YinLiZiXun.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
            Thread.sleep(2000);
            slideByXyIds(Constant.YinLiZiXun.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1,1); // 第一条是置顶
        }

    }

    public static void slideByXyIds(String res_id, String file_path,int pos) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(pos + "").get("x1");
                int y1 = aa.get(pos + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 15) {
                    Thread.sleep(3000);
                    Log.e(Constant.TAG, "input swipe 25 1000 25 550");
                    RootCmd.execRootCmd("input swipe 25 1000 25 550");
                    j++;
                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
                break;
            }
        }

    }
}
