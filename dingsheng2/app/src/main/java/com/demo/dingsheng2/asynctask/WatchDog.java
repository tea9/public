package com.demo.dingsheng2.asynctask;

import android.util.Log;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.ShellUtil;

import java.util.Timer;
import java.util.TimerTask;

/**
 * created by tea9 at 2018/12/28
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
//                        Log.e(Constant.TAG, "shaomiaoWatchDogWatchDog");
//                        Log.e(Constant.TAG, Thread.currentThread().getName()+"shaomiaoWatchDogWatchDog");
                        start();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        if (timer != null) {
            try {
                timer.schedule(timerTask, 0, 20000);
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
//        Log.e(Constant.TAG, "shaomiaoWatchDogWatchDogclick click");
//        Log.e(Constant.TAG, "shaomiaoWatchDogWatchDogclick click");
//        Log.e(Constant.TAG, "shaomiaoWatchDogWatchDogclick click");
//        Log.e(Constant.TAG, "shaomiaoWatchDogWatchDogclick click");
//        Log.e(Constant.TAG, "shaomiaoWatchDogWatchDogclick click");
//        Log.e(Constant.TAG, "shaomiaoWatchDogWatchDogclick click");
        Log.e(Constant.TAG, "shaomiaoWatchDogWatchDogclick click");
        if (ShellUtil.checkPageByText("抱歉", Constant.FILE_PATH)) {
            ShellUtil.back();
            Thread.sleep(2000);
            ShellUtil.clickByXy("android:id/button1", Constant.FILE_PATH);
            Log.e(Constant.TAG, "shaomiaoWatchDogWatchDogclick click");
        }

//        ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL,Constant.FILE_PATH);

    }

}
