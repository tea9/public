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
import com.demo.dingsheng.MainActivity;
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
 * afs √
 * xfc
 * jjk
 */
public class AfterService extends Service {

    //微鲤看看、韭菜头条（没找到）、红包头条、聚合头条、大众看点（没下载到）、聚看点、掌上头条、点点新闻、闪电看看(没吓到)、薪头条
    private int[] list = new int[]{Constant.ENUM.WEILIKANKAN, Constant.ENUM.JIUCAITOUTIAO, Constant.ENUM.HONGBAOTOUTIAO, Constant.ENUM.JUHETOUTIAO, Constant.ENUM.DAZHONGKANDIAN, Constant.ENUM.JUKANDIAN
    ,Constant.ENUM.ZHANGSHANGTOUTIAO,Constant.ENUM.DIANDIANXINWEN,Constant.ENUM.SHANDIANKANKAN,Constant.ENUM.XINTOUTIAO};

    private List<TabEntity> afterlist= new ArrayList<>();



    private static int index = 0;

    Handler handler = new Handler() {
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

    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Log.e(Constant.TAG, "1小时");
            try {
                start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(201);
        }
    };

    private void start() throws InterruptedException {
//        int z = list[index];
        int z = afterlist.get(index).flag_enum;
        //微鲤看看、韭菜头条（没找到）、红包头条、聚合头条、大众看点（没下载到）、聚看点、掌上头条、点点新闻、闪电看看(没吓到)、薪头条
        if (z == Constant.ENUM.WEILIKANKAN) {
            WeiLiKanKanModel.start();
        } else if (z == Constant.ENUM.JIUCAITOUTIAO) {//
            JiuCaiZiXunModel.start();
        } else if (z == Constant.ENUM.HONGBAOTOUTIAO) {
            HongBaoTouTiaoModel.start();
        } else if (z == Constant.ENUM.JUHETOUTIAO) {
            JuheToutiaoModel.start();
        } else if (z == Constant.ENUM.DAZHONGKANDIAN) {
            DaZhongKanDianModel.start();
        } else if (z == Constant.ENUM.JUKANDIAN) {
            JuKanDianModel.start();
        } else if (z == Constant.ENUM.ZHANGSHANGTOUTIAO) {
            ZhangShangTouTiaoModel.start();
        } else if (z == Constant.ENUM.DIANDIANXINWEN) {
            DianDianXinWenModel.start();
        } else if (z == Constant.ENUM.SHANDIANKANKAN) {
            ShanDianKanKanModel.start();
        } else if (z == Constant.ENUM.XINTOUTIAO){//
            XinTouTiaoModel.start();
        }

        index = index+1;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 前台服务
        Intent intent = new Intent(this, MainActivity.class);
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
        SharedPreferencesUtils.putInfo(getApplicationContext(),Constant.A_FLAG,true);
        initData();
    }

    private void initData() {
        String str = SharedPreferencesUtils.getPreferences(this).getString(Constant.AFTER_TEXT,"");
        if (!str.equals("")) {
            List<TabEntity> data = GsonUtil.changeGsonToList(str,TabEntity.class);
            List<TabEntity> result_data = new ArrayList<>();
            for (int i = 0; i <data.size() ; i++) {
                if (data.get(i).check) {
                    result_data.add(data.get(i));
                }
            }
            afterlist.addAll(result_data);
        } else {
            afterlist.add(new TabEntity("微鲤看看", Constant.ENUM.WEILIKANKAN));
            afterlist.add(new TabEntity("韭菜头条", Constant.ENUM.JIUCAITOUTIAO));
            afterlist.add(new TabEntity("红包头条", Constant.ENUM.HONGBAOTOUTIAO));
            afterlist.add(new TabEntity("聚合头条", Constant.ENUM.JUHETOUTIAO));
            afterlist.add(new TabEntity("大众看点", Constant.ENUM.DAZHONGKANDIAN));
            afterlist.add(new TabEntity("聚看点", Constant.ENUM.JUKANDIAN));
            afterlist.add(new TabEntity("掌上头条", Constant.ENUM.ZHANGSHANGTOUTIAO));
            afterlist.add(new TabEntity("点点新闻", Constant.ENUM.DIANDIANXINWEN));
            afterlist.add(new TabEntity("闪电看看", Constant.ENUM.SHANDIANKANKAN));
            afterlist.add(new TabEntity("薪头条", Constant.ENUM.XINTOUTIAO));
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                timer.schedule(task, 0, 30 * 60 * 1000); // 半小时
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
