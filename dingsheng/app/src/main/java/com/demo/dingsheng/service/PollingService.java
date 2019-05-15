package com.demo.dingsheng.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.SharedPreferencesUtils;

/**
 * created by tea9 at 2018/12/19
 * 这是一个轮询服务 用于调度 BeforeService 和 AfterService
 */
public class PollingService extends Service {

    private static boolean v_flag=true;
    private static boolean stop_service=false;

    public static final String ACTION = "com.ryantang.service.PollingService";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 前台服务
//        Intent intent = new Intent(this, MainActivity.class);
//        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
//        Notification notification = new NotificationCompat.Builder(this)
//                .setContentTitle("android_touch")
//                .setContentText("android_touch")
//                .setWhen(System.currentTimeMillis())
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
//                .setContentIntent(pi)
//                .build();
//        startForeground(1, notification);
    }
    Thread thread;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(Constant.TAG,"PolingServiceonStartCommand");
        v_flag = SharedPreferencesUtils.getPreferences(getApplicationContext()).getBoolean(Constant.A_FLAG,true);
        stop_service = SharedPreferencesUtils.getPreferences(getApplicationContext()).getBoolean(Constant.STOP_SERVICE,false);
        thread=  new PollingThread();
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    class PollingThread extends Thread {
        @Override
        public void run() {
            Log.e(Constant.TAG,"PolingServiceonPollingThread"+v_flag);
            Log.e(Constant.TAG,"PolingServiceonPollingThread"+stop_service);
//            if (!stop_service) {
                if (v_flag) {
                    Log.e(Constant.TAG, "PolingServiceBeforeService");
                    Intent a = new Intent(getApplicationContext(), BeforeService.class);
                    getApplicationContext().startService(a);

                    Intent b = new Intent(getApplicationContext(), AfterService.class);
                    getApplicationContext().stopService(b);
                } else {

                    Intent a = new Intent(getApplicationContext(), AfterService.class);
                    getApplicationContext().startService(a);

                    Intent b = new Intent(getApplicationContext(), BeforeService.class);
                    getApplicationContext().stopService(b);
                }
//            }
        }
    }

    @Override
    public void onDestroy() {
        Log.e(Constant.TAG,"PolingServiceBeforeServiceonDestroy");
//        thread=null;
        super.onDestroy();
    }
}
