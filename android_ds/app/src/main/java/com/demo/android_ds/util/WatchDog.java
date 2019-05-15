package com.demo.android_ds.util;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * <p>
 * 定时器 30秒 检测app存活
 */
public class WatchDog {

//    public static void main(String[] args) {
//        startTimer();
//    }

    private static Timer timer;
    private static TimerTask timerTask;
    private static boolean flag = true;

    public static void startTimer() {
        flag = true;
        if (timer == null) {
            timer = new Timer();
        }
        timerTask = new TimerTask() {
            @Override
            public void run() {
//                while (flag)

                if (flag) {
                    try {
                        start();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        if (timer != null) {
            try {
                timer.schedule(timerTask, 0, 5000); //5秒钟
            } catch (IllegalStateException e) {
            }
        }

    }

    public static void stopTimer() {
        flag = false;
        if (timerTask != null)
            timerTask.cancel();

        if (timer != null)
            timer.cancel();
    }

    private static void start() throws InterruptedException {
        //抱歉
        //android:id/button1
        //android:id/alertTitle
        //android:id/scrollView



        Log.e(Constant.TAG, "testWatchDogWatchDogclick click");
        if (ShellUtil.checkPageByText("抱歉", Constant.FILE_PATH)) {
            ShellUtil.back();
            Thread.sleep(1000);
            ShellUtil.clickByXy("android:id/button1", Constant.FILE_PATH); //无响应
            Log.e(Constant.TAG, "testWatchDogWatchDogclick click");
        }
        ShellUtil.clickByXy("android:id/button1",Constant.FILE_PATH);

//        ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL,Constant.FILE_PATH);

    }

}
