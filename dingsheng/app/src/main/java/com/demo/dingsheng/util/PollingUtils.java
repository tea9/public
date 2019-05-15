package com.demo.dingsheng.util;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.demo.dingsheng.receiver.ScreenControlAlarmReceiver;

import static android.content.Context.ALARM_SERVICE;

/**
 * created by tea9 at 2018/12/19
 * <p>
 * setRepeating 方法api19以后就不在准确
 */
public class PollingUtils {

    public static void startPollingService2(Context context, int seconds, Class<?> cls, String action) {
        AlarmManager manager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        Intent alarmIntent = new Intent(context, ScreenControlAlarmReceiver.class).setAction("intent_alarm_log");
        long triggerAtTime = SystemClock.elapsedRealtime();
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);//通过广播接收
        manager.setRepeating(AlarmManager.ELAPSED_REALTIME, triggerAtTime,
                seconds * 1000, broadcast);
//                alarmService.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + INTERVAL, broadcast);//INTERVAL毫秒后触发
//                alarmIntent.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + INTERVAL,System.currentTimeMillis() + INTERVAL, broadcast);
    }

    //开启轮询服务
    public static void startPollingService(Context context, int seconds, Class<?> cls, String action) {
        //获取AlarmManager系统服务
        AlarmManager manager = (AlarmManager) context
                .getSystemService(ALARM_SERVICE);

        //包装需要执行Service的Intent
        Intent intent = new Intent(context, cls);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //触发服务的起始时间
        long triggerAtTime = SystemClock.elapsedRealtime();

        //使用AlarmManger的setRepeating方法设置定期执行的时间间隔（seconds秒）和需要执行的Service
        manager.setRepeating(AlarmManager.ELAPSED_REALTIME, triggerAtTime,
                seconds * 1000, pendingIntent);
    }

    //停止轮询服务
    public static void stopPollingService(Context context, Class<?> cls, String action) {
        AlarmManager manager = (AlarmManager) context
                .getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(context, cls);
        intent.setAction(action);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //取消正在执行的服务
        manager.cancel(pendingIntent);

    }
}
