package com.demo.dingsheng.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by tea9 at 2018/12/30
 */
public class TimeService extends Service  {

    private static Thread thread;
    private static String time = "";
    private static String startTime = "";
    private static String endTime = "";
    private static boolean isRun = true;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void start() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");// HH:mm:ss
        Date date = new Date(System.currentTimeMillis());
        time = simpleDateFormat.format(date).toString();
        thread = new Thread(new Runnable() {

            @Override
            public void run() {

            }
        });
        thread.start();
    }
}
