package com.demo.dingsheng2.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.demo.dingsheng2.R;
import com.demo.dingsheng2.TestActivity;
import com.demo.dingsheng2.task.*;
import com.demo.dingsheng2.util.Constant;

/**
 * created by tea9 at 2019/1/9
 * 废弃了
 */
public class TimeService extends Service {

    //    private final int delay=2*60*1000;
    private final int delay = 20 * 1000;

    private int count = 0;

    Handler handler = new Handler();
    Runnable update_thread = new Runnable() {


        @Override
        public void run() {
            Log.e("shaomiao", "thread");

            switch (count) {
                case 0:
                    Log.e("shaomiao", "thread000000" + count + Thread.currentThread().getName());
                    XintoutiaoTask.start();
                    break;
                case 1:
                    Log.e("shaomiao", "thread1111111" + count + Thread.currentThread().getName());
                    ZhongqingkandianTask.start();
                    break;
                case 2:
                    Log.e("shaomiao", "thread22222222" + count + Thread.currentThread().getName());
                    QutoutiaoTask.start();
                    break;
                case 3:
                    Log.e("shaomiao", "thread33333333" + count + Thread.currentThread().getName());
                    MayitoutiaoTask.start();
                    break;
                case 4:
                    Log.e("shaomiao", "thread444444" + count + Thread.currentThread().getName());
                    ToutiaoduoduoTask.start();
                    break;
                case 5:
                    Log.e("shaomiao", "thread5555555" + count + Thread.currentThread().getName());
                    Brower2345Task.start();
                    break;
            }
//            text_view.setText(String.valueOf(count++));
            if (count >= 10) {
                Log.e("shaomiao", "thread" + count + Thread.currentThread().getName());
                Message message = new Message();
                message.what = 1;
                handlerStop.sendMessage(message);
            }
            count++;
            handler.postDelayed(update_thread, delay);
        }
    };

    final Handler handlerStop = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    count = 0;
                    Log.e("shaomiao", "EndClickListener" + count);
                    handler.removeCallbacks(update_thread);
                    break;

            }
            super.handleMessage(msg);
        }
    };


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(Constant.TAG, "TimeService onCreate" + Thread.currentThread().getName());
        Intent intent = new Intent(this, TestActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("android_touch")
                .setContentText("android_touch")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(Constant.TAG, "TimeService onStartCommand");
        start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(Constant.TAG, "TimeService onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(Constant.TAG, "TimeService onUnbind");
        return super.onUnbind(intent);
    }

    private void start() {
        Log.e(Constant.TAG, "TimeService start " + Thread.currentThread().getName());
        if (count == 0)
            handler.post(update_thread);
    }

    private void stop() {
        count = 0;
        Log.e("shaomiao", "EndClickListener" + count);
        handler.removeCallbacks(update_thread);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(Constant.TAG, "TimeService onDestroy");
    }


}
