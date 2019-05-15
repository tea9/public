package com.demo.dingsheng.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;
import com.demo.dingsheng.MainActivity;
import com.demo.dingsheng.R;
import com.demo.dingsheng.entitiy.TabEntity;
import com.demo.dingsheng.model.*;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.GsonUtil;
import com.demo.dingsheng.util.SharedPreferencesUtils;
import com.demo.dingsheng.util.ShellUtil;
import com.yw.game.floatmenu.FloatItem;
import com.yw.game.floatmenu.FloatLogoMenu;
import com.yw.game.floatmenu.FloatMenuView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by tea9 at 2018/12/23
 * 定时器
 * 两个定时器
 * 一个12小时
 * 一个半个小时
 * 还没测试
 * <p>
 * 这个式现在用的
 */

/**
 * 1、启动，停止。√
 * 2、清理后台是清理所有的（包括鼎盛软件）
 * 3、软件卡住自动重启时间100秒改成60秒。
 * 4、浏览文章是主页点击位置修改下，现在10次有7次点击到广告，没有金币奖励。
 * 5、软件运行错误，误点击到返回按键，出现是否退出或继续浏览就卡死了。
 * 6、鼎盛科技软件会崩溃。
 * 7、软件设置里面参数可以自己选择，点击启动软件，自动保存，软件界面退出，显示一个悬浮窗（和华为手机上装的那个软件操作一样），悬浮窗里带有设置功能。
 * 8、软件可能不定时有推送弹窗出现，可以做一个检测关闭吗
 *
 * 在打个包 是界面的 定时时间改成30分
 */

/**
 * 设置功能 软件内的 switch
 * 悬浮窗 设置功能
 * 浏览测试 单个
 * 清理缓存
 * 应用更新 测试
 * 授权码
 * 来电检测 设置
 */
public class TimingService extends Service {

    private long hour12 = 12 * 60 * 60 * 1000; //12小时
    private long min30=3 * 60 * 1000; // 30分钟

    FloatLogoMenu mFloatMenu;
    ArrayList<FloatItem> itemList = new ArrayList<>();
    private int[] menuIcons = new int[]{R.drawable.yw_menu_account};
//    private static boolean flag = true;

    private Timer timer1, timer2, timer3;
    private TimerTask task1, task2, task3;
    private Thread thread1, thread2, thread3,thread4;
    private Runnable runnable1, runnable2, runnable3,runnable4;


    private int index = 0;
    private List<TabEntity> belist = new ArrayList<>();

    private  boolean a_flag = true;//切换12个小时
    //SharedPreferencesUtils.getPreferences(getApplicationContext()).getBoolean(Constant.A_FLAG,true);
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 201: //12小时
                    // ui操作
                    Log.e(Constant.TAG, "handle12小时");
                    break;
                case 202: //半个小时
                    Log.e(Constant.TAG, "handle半个小时");

                    break;

            }
        }
    };

    private void initData() {
        belist.clear();
        index = 0;
        String str = SharedPreferencesUtils.getPreferences(this).getString(Constant.BEFORE_TEXT, "");
        if (!str.equals("")) {
            List<TabEntity> data = GsonUtil.changeGsonToList(str, TabEntity.class);
            List<TabEntity> result_data = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
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

    private void initData2() {
        belist.clear();
        index = 0;
        String str = SharedPreferencesUtils.getPreferences(this).getString(Constant.AFTER_TEXT, "");
        if (!str.equals("")) {
            List<TabEntity> data = GsonUtil.changeGsonToList(str, TabEntity.class);
            List<TabEntity> result_data = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).check) {
                    result_data.add(data.get(i));
                }
            }
            belist.addAll(result_data);
        } else {
            belist.add(new TabEntity("微鲤看看", Constant.ENUM.WEILIKANKAN));
            belist.add(new TabEntity("韭菜头条", Constant.ENUM.JIUCAITOUTIAO));
            belist.add(new TabEntity("红包头条", Constant.ENUM.HONGBAOTOUTIAO));
            belist.add(new TabEntity("聚合头条", Constant.ENUM.JUHETOUTIAO));
            belist.add(new TabEntity("大众看点", Constant.ENUM.DAZHONGKANDIAN));
            belist.add(new TabEntity("聚看点", Constant.ENUM.JUKANDIAN));
            belist.add(new TabEntity("掌上头条", Constant.ENUM.ZHANGSHANGTOUTIAO));
            belist.add(new TabEntity("点点新闻", Constant.ENUM.DIANDIANXINWEN));
            belist.add(new TabEntity("闪电看看", Constant.ENUM.SHANDIANKANKAN));
            belist.add(new TabEntity("薪头条", Constant.ENUM.XINTOUTIAO));
        }
    }

    private void start2() throws InterruptedException {
        for(int i=0;i<10;i++) {
            try {
//                for (int j = 0; j < belist.size(); j++) {
//                    int z =belist.get(index).flag_enum;
//                    if (z == Constant.ENUM.DONGFANGTOUTIAO) {
//
//                    }
//                }

                DongFangModel.startDongFang();
                ZhongQingModel.startZhongQing();
//                QuTouTiaoModel.startQuTouTiao();
                MaYiTouTiaoModel.startMaYi();
                TouTiaoDuoDuoModel.startTouTiaoDuoDuo();
                Browser2345Model.start();

            } catch (Exception e){}
        }
    }

    private void start1(){
        Log.e(Constant.TAG,"start1index"+index);
//        runnable4 = new Runnable() {
//            @Override
//            public void run() {

                showToastByRunnable(TimingService.this,"index"+index);
                Log.e(Constant.TAG, "zzzzzzzzz半小时start index"+index);
                //TODO 如果》 就index 等于0
                if (index < belist.size()) {
                    int z = belist.get(index).flag_enum;
                    index+=1;
                    Log.e(Constant.TAG, "zzzzzzzzz1小时startzzzzzzzzz1小时startzzzzzzzzz1小时startzzzzzzzzz1小时start" + z);
                    //东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器
                    try {
                        SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.START_CMD, true);
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
                        } else if (z == Constant.ENUM.WEILIKANKAN) {
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
                        } else if (z == Constant.ENUM.XINTOUTIAO) {//
                            XinTouTiaoModel.start();
                        }
                    }catch (Exception e){}
                } else {
                    index=0;
                }
//                index = index + 1;
//            }
//        };
//        thread4 =  new Thread(runnable4);
//        thread4.start();

    }

    @Override
    public void onCreate() {
        super.onCreate();
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
        initData();
        Log.e(Constant.TAG, "oncreate TimingService");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showFloatingWindow();
        return super.onStartCommand(intent, flags, startId);
    }

    private void startTimer1() {
        timer1 = new Timer();
        task1 = new TimerTask() {
            @Override
            public void run() {
                Log.e(Constant.TAG, "开启半小时定时器startTimer2");
//                thread2.start(); // 半个小时
                try {
                    start2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(201);
            }
        };
        runnable1 = new Runnable() {
            @Override
            public void run() {
                Log.e(Constant.TAG, "开启12小时定时器");
                SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.A_FLAG, a_flag);
//                if (a_flag) {
                    initData();
//                } else {
//                    initData2();
//                }
                a_flag = !a_flag;
                timer1.schedule(task1, 0, hour12); // 12小时
            }
        };

        thread1 = new Thread(runnable1);
        thread1.start();

    }

    private void startTimer2() {
        timer2 = new Timer();
        task2 = new TimerTask() {
            @Override
            public void run() {
                Log.e(Constant.TAG, "开启半小时定时器run");
                Log.e(Constant.TAG, "zzzzzzzzz半小时start index"+index);
                if (thread4!=null) {
                    Thread dummy = thread4;
//                    thread4.interrupt();
                    thread4 = null;
                    dummy.interrupt();
                }
                SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.START_CMD, false);

//                thread4.start();

                start1();
                handler.sendEmptyMessage(202);
            }
        };
        runnable2 = new Runnable() {
            @Override
            public void run() {
                Log.e(Constant.TAG, "开启半个小时定时器");
                timer2.schedule(task2, 0, min30); //半小时
            }
        };
        thread2 = new Thread(runnable2);
//        thread2.start();
    }

    private void startTimer3() { // 检测东方弹窗
        timer3 = new Timer();
        task3 = new TimerTask() {
            @Override
            public void run() {
//                Log.e(Constant.TAG, "开启检测弹框定时器run");
                if (ShellUtil.checkPage("com.songheng.eastnews:id/vf", Constant.DongFang.FileName.file_yaowen)) {
                    try {
                        Log.e(Constant.TAG, "检测到东方头条弹框");
                        ShellUtil.clickByXy("com.songheng.eastnews:id/un", Constant.DongFang.FileName.file_yaowen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


                handler.sendEmptyMessage(203);
            }
        };
        runnable3 = new Runnable() {
            @Override
            public void run() {
                Log.e(Constant.TAG, "开启半个小时定时器");
                timer3.schedule(task3, 0, 10 * 1000); //1分钟
            }
        };
        thread3 = new Thread(runnable3);
        thread3.start();

    }

    private void stopTimer() {
        if (null!=timer1)
            timer1.cancel();
        if (null!=timer2)
            timer2.cancel();
        if (null!=timer3) {
            timer3.cancel();
        }
        if (thread1 != null) {
            Thread dummy = thread1;
            thread1 = null;
            dummy.interrupt();
        }
        if (thread2 != null) {
            Thread dummy = thread2;
            thread2 = null;
            dummy.interrupt();
        }
        if (thread3!=null) {
            Thread dummy = thread3;
            thread3 = null;
            dummy.interrupt();
        }
        if (thread4!=null) {
            Thread dummy = thread4;
            thread4 = null;
            dummy.interrupt();
        }
//        Log.e(Constant.TAG, "线程状态1"+String.valueOf(thread1.getState()));
//        Log.e(Constant.TAG, "线程状态2"+String.valueOf(thread2.getState()));
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

    private void showFloatingWindow() {
        if (mFloatMenu == null) {
            itemList.clear();
//            itemList.add(new FloatItem(flag?"启动":"停止", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[0]), ""));
            itemList.add(new FloatItem("开启", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[0]), ""));
            itemList.add(new FloatItem("停止", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[0]), ""));
            mFloatMenu = new FloatLogoMenu.Builder()
                    .withContext(getApplicationContext())
//                    .withContext(mActivity.getApplication())//这个在7.0（包括7.0）以上以及大部分7.0以下的国产手机上需要用户授权，需要搭配<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
                    .logo(BitmapFactory.decodeResource(getResources(), R.drawable.yw_game_logo))
//                    .logo(BitmapFactory.decodeResource(getResources(), R.mipmap.icon))
                    .drawCicleMenuBg(true)
                    .backMenuColor(0xffe4e3e1)
                    .setBgDrawable(this.getResources().getDrawable(R.drawable.yw_game_float_menu_bg))
                    //这个背景色需要和logo的背景色一致
                    .setFloatItems(itemList)
                    .defaultLocation(FloatLogoMenu.RIGHT)
                    .drawRedPointNum(false)
                    .showWithListener(new FloatMenuView.OnMenuClickListener() {
                        @Override
                        public void onItemClick(int position, String title) {
//                            Toast.makeText(getApplicationContext(), "position " + position + " title:" + title + " is clicked.", Toast.LENGTH_SHORT).show();

                            if (position == 0) {
                                showToastByRunnable(TimingService.this, "正在启动");
                                SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.START_CMD, true);
                                startTimer1();
//                                startTimer2();
//                                startTimer3();

                            } else if (position == 1) {
                                try {
                                    showToastByRunnable(TimingService.this, "正在停止");
                                    SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.START_CMD, false);
                                    stopTimer();
                                } catch (Exception e){

                                }

                            }
                        }

                        @Override
                        public void dismiss() {

                        }
                    });
        }

    }


    private void showToastByRunnable(final Context context, final CharSequence text) {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
