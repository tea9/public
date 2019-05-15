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
public class QutoutiaoTask {

    public static void start() {
        Log.e(Constant.TAG, "qutoutiaoaaaaaa");
//        for (int i = 0; i < Constant.TASK_COUNT; i++) {
//            Log.e(Constant.TAG, "qutoutiaobbbbb" + i);
//        }

        try {
            before();
            Log.e(Constant.TAG, "before qutoutiao11111111" + Thread.currentThread().getName());
//        ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN3, Constant.QuTouTiao.FileName.file_path1); // 点击任务 自动签到
            ShellUtil.clickMethod(770, 1709);//签到
            Thread.sleep(13 * 1000);
//////////

            before();
            Log.e(Constant.TAG, "before qutoutiao666666666666" + Thread.currentThread().getName());
//        ShellUtil.clickByXy(Constant.QuTouTiao.LINGQU, Constant.QuTouTiao.FileName.file_path1); //点击领取
            Thread.sleep(2 * 1000);
            ShellUtil.clickMethod(932, 127); //领取
//            ShellUtil.clickMethod(932, 127); //领取
            Thread.sleep(1 * 1000);
            Log.e(Constant.TAG, "before qutoutiao777777777777777" + Thread.currentThread().getName());
            ShellUtil.clickByXy(Constant.QuTouTiao.DIALOG_WO, Constant.QuTouTiao.FileName.file_path1); // 领取之后 点击我知道了
            Thread.sleep(1 * 1000);
            ShellUtil.clickByXy(Constant.QuTouTiao.DIALOG_WO1, Constant.QuTouTiao.FileName.file_path1); // 领取之后 点击我知道了
            Thread.sleep(1 * 1000);
            ShellUtil.clickByXy(Constant.QuTouTiao.DIALOG_WO2, Constant.QuTouTiao.FileName.file_path1); // 领取之后 点击我知道了
            Thread.sleep(2 * 1000);
            Log.e(Constant.TAG, "点击btn1");
            Log.e(Constant.TAG, "before qutoutiao88888888888888刷新" + Thread.currentThread().getName());
            if (!ShellUtil.checkPage(Constant.QuTouTiao.RES_ID_BTN1, Constant.QuTouTiao.FileName.file_path1)) {
                ShellUtil.back();
                Thread.sleep(2 * 1000);
            }
//            ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN1, Constant.QuTouTiao.FileName.file_path1); // 点击刷新

//        for (int i=0;i<30;i++){
            Thread.sleep(2 * 1000);
            for (int i = 0; i < Constant.TASK_COUNT; i++) {
//            while (!Thread.currentThread().isInterrupted()) {
//                ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL,Constant.FILE_PATH);
                Thread.sleep(2000);
                Log.e(Constant.TAG, "before qutoutiao99999999999999999 点击item1" + Thread.currentThread().getName());
                slideByXyIdsNot(Constant.QuTouTiao.RES_ID_ITEM1, Constant.QuTouTiao.FileName.file_path1, 1); // 第一条是置顶
//                slideByXyIdsNot(Constant.QuTouTiao.RES_ID_ITEM1, Constant.QuTouTiao.FileName.file_path1, 2); // 第一条是置顶
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "before qutoutiao101010101010101010 刷新" + Thread.currentThread().getName());
                ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN1, Constant.QuTouTiao.FileName.file_path1); // 点击刷新
                Thread.sleep(4 * 1000);
//            }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private static void before() throws InterruptedException {
        Log.e(Constant.TAG, "before qutoutiao" + Thread.currentThread().getName());
        Constant.start(Constant.QuTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(10 * 1000);
    }

    public static void slideByXyIdsNot(String res_id, String file_path, int pos) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            if (pos > aa.size()) {
                return;
            }
            for (int i = pos; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
//                ShellUtil.clickMethod(x1, y1);
//                Thread.sleep(1 * 1000);
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 35) {

                    Log.e(Constant.TAG, "before keyevent 20 " + Thread.currentThread().getName());
                    RootCmd.execRootCmd("input keyevent 20 ");
                    Thread.sleep(500);
                    j++;

                }
                ShellUtil.back();
                Thread.sleep(1000);
                ShellUtil.clickByXy(Constant.QuTouTiao.SUOPING,Constant.QuTouTiao.FileName.file_path1); //锁屏
                Thread.sleep(1000);
            }
        }

    }
}
