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
public class DaZhongKanDianRunnable implements Runnable {

    public static volatile boolean flag = true;

    @Override
    public void run() {
        if (!Thread.currentThread().isInterrupted()&&flag) {
            try {
                start();
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }

    private synchronized void start() throws InterruptedException {
        Constant.start(Constant.DaZhongKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        ShellUtil.clickMethod(696,1684);
        Thread.sleep(3*1000);
        ShellUtil.clickMethod(692,474);
        Thread.sleep(6*1000);


        Constant.start(Constant.DaZhongKanDian.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
//        Thread.sleep(2*1000);
//        Log.e(Constant.TAG,"点击btn1");
//        ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_BTN1,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
        ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_LingQu,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新

        Log.e(Constant.TAG,"点击item1");
        while (!Thread.currentThread().isInterrupted()&&flag) {
            slideByXyIds(Constant.DaZhongKanDian.RES_ID_ITEM1, Constant.DaZhongKanDian.FileName.file_path1); // 第一条是置顶
            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.DaZhongKanDian.RES_ID_ITEM1LL,Constant.ZhongQing.FileName.file_path1);
//            Log.e(Constant.TAG,"keyevent 1");
            if(a!=null)
                ShellUtil.swipe(a[1],a[0]);
//            ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_BTN1,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
        }
    }

    public synchronized void slideByXyIds(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG,"keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG,"keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG,"keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG,"keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG,"keyevent 1");
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(2*1000);
                Log.e(Constant.TAG,"keyevent 2");
                // 滑动
                int j = 0;
                while (j<30&&flag) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    try {
                    Log.e(Constant.TAG,"keyevent 20");
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                Log.e(Constant.TAG,"keyevent 1");
                ShellUtil.back();
            }
        }

    }
}
