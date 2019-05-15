package com.demo.dingsheng.service;

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
import com.demo.dingsheng.AActivity;
import com.demo.dingsheng.R;
import com.demo.dingsheng.entitiy.TabEntity;
import com.demo.dingsheng.model.*;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.GsonUtil;
import com.demo.dingsheng.util.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by tea9 at 2018/12/19
 * 前16个服务
 * 开启一个定时30分钟 每30分钟换一个app
 * 东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器
 *
 * TODO
 * 测试定时
 */
public class BeforeService extends Service {

//    private int[] list = new int[]{Constant.ENUM.DONGFANGTOUTIAO, Constant.ENUM.ZHONGQINGKANDIAN, Constant.ENUM.QUTOUTIAO, Constant.ENUM.MAYITOUTIAO, Constant.ENUM.TOUTIAODUODUO, Constant.ENUM.BROWER2345};

    private List<TabEntity> belist=new ArrayList<>();

    private static int index = 0;

    static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 201:
                    // ui操作
                    Log.e(Constant.TAG, "zzzzzzzzz1小时");
                    break;

            }
        }
    };

    static Timer timer;
    static TimerTask task;

    private void start() throws InterruptedException {
        Log.e(Constant.TAG, "zzzzzzzzz1小时start");
//        int z = list[index] ;
//        boolean flag= SharedPreferencesUtils.getPreferences(getApplicationContext()).getBoolean(Constant.STOP_SERVICE,false);
//        if (!flag) {
            if (index<belist.size()) {
                int z = belist.get(index).flag_enum;
                //东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器
                if (z == Constant.ENUM.DONGFANGTOUTIAO) {
                    DongFangModel.startDongFang();
                } else if (z == Constant.ENUM.ZHONGQINGKANDIAN) {
                    ZhongQingModel.startZhongQing();
                } else if (z == Constant.ENUM.QUTOUTIAO) {
                    QuTouTiaoModel.startQuTouTiao();
                } else if (z == Constant.ENUM.MAYITOUTIAO) {
                    MaYiTouTiaoModel.startMaYi();
                } else if (z == Constant.ENUM.TOUTIAODUODUO) {
                    TouTiaoDuoDuoModel.startTouTiaoDuoDuo();
                } else if (z == Constant.ENUM.BROWER2345) {
                    Browser2345Model.start();
                }
                index = index + 1;
            }
//        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        stopSelf();
        // 前台服务
        Intent intent = new Intent(this, AActivity.class);
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
        SharedPreferencesUtils.putInfo(getApplicationContext(),Constant.A_FLAG,false);

        initData();
    }

    private void initData() {
        String str = SharedPreferencesUtils.getPreferences(this).getString(Constant.BEFORE_TEXT,"");
        if (!str.equals("")) {
            List<TabEntity> data = GsonUtil.changeGsonToList(str,TabEntity.class);
            List<TabEntity> result_data = new ArrayList<>();
            for (int i = 0; i <data.size() ; i++) {
                if (data.get(i).check) {
                    result_data.add(data.get(i));
                }
            }
            belist.addAll(result_data);
        } else {
            belist.add(new TabEntity("东方头条", Constant.ENUM.DONGFANGTOUTIAO));
            belist.add(new TabEntity("中青看点", Constant.ENUM.ZHONGQINGKANDIAN));
            belist.add(new TabEntity("趣头条", Constant.ENUM.QUTOUTIAO));
            belist.add(new TabEntity("蚂蚁头条", Constant.ENUM.MAYITOUTIAO));
            belist.add(new TabEntity("头条多多", Constant.ENUM.TOUTIAODUODUO));
            belist.add(new TabEntity("2345浏览器", Constant.ENUM.BROWER2345));
        }
    }

    static Thread thread;
    static Runnable mBackgroundRunnable;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(Constant.TAG,"我被停止了onStartCommand"+intent);
        if (intent.getBooleanArrayExtra("flag")!=null)
            Log.e(Constant.TAG,"我被停止了onStartCommand"+intent.getBooleanArrayExtra("flag"));
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                Log.e(Constant.TAG, "1111小时");
                try {
                    start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(201);
            }
        };
        mBackgroundRunnable =new Runnable() {
            @Override
            public void run() {
                timer.schedule(task, 0, 30 * 60 * 1000); // 半小时
            }
        };
        thread =new Thread(mBackgroundRunnable);
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.e(Constant.TAG,"我被停止了onDestroy");
        handler.removeCallbacks(mBackgroundRunnable);
        task.cancel();
        timer.cancel();

        thread.interrupt();
        thread.stop();
        thread.destroy();
        thread = null;
        super.onDestroy();
    }

    public static void stop() {
        handler.removeCallbacks(mBackgroundRunnable);
        task.cancel();
        timer.cancel();

        thread.interrupt();
        thread.stop();
        thread.destroy();
        thread = null;
    }

    @Override
    public boolean stopService(Intent name) {
        Log.e(Constant.TAG,"我被停止了");
        return super.stopService(name);
    }
}
