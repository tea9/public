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
public class WeilikankanTask {
    public static void start() {
        try {
            before();

            ShellUtil.slideByXyIds2(Constant.WeiLiKanKan.RES_ID_ITEM1, Constant.WeiLiKanKan.FileName.file_path1); // 第一条是置顶
//        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
            Thread.sleep(4 * 1000);
            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN2, Constant.WeiLiKanKan.FileName.file_path1); // 签到
            Thread.sleep(10 * 1000);

//////////////////////////////

            before();
            Log.e(Constant.TAG, "点击btn1");
            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1, Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
//        while (Constant.TASK_COUNT) {
            for (int i = 0; i < Constant.TASK_COUNT; i++) {
                //继续阅读框判断 cn.weli.story:id/text_ok
                slideByXyIds2(Constant.WeiLiKanKan.RES_ID_ITEM1, Constant.WeiLiKanKan.FileName.file_path1); // 第一条是置顶
                ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1, Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void before() throws InterruptedException {
        Constant.start(Constant.WeiLiKanKan.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        if (ShellUtil.checkPage(Constant.WeiLiKanKan.RES_ID_RED, Constant.WeiLiKanKan.FileName.file_path1)) {
            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_RED, Constant.WeiLiKanKan.FileName.file_path1);
            Thread.sleep(2 * 1000);
            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_RED_CLOSE, Constant.WeiLiKanKan.FileName.file_path1);
        }
        Thread.sleep(2 * 1000);

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
                while (j < 20) {

                    Log.e(Constant.TAG, "在滑动");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    j++;
                    Thread.sleep(500);

                }
                Thread.sleep(1 * 1000);
                Log.e(Constant.TAG, "返回了");
                ShellUtil.back();
                Thread.sleep(1 * 1000);
            }
        }

    }
}
