package com.demo.dingsheng.timer;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;
import com.demo.dingsheng.MainActivity;
import com.demo.dingsheng.R;
import com.demo.dingsheng.clear.DataCleanManager;
import com.demo.dingsheng.entitiy.TabEntity;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.GsonUtil;
import com.demo.dingsheng.util.SharedPreferencesUtils;
import com.yw.game.floatmenu.FloatItem;
import com.yw.game.floatmenu.FloatLogoMenu;
import com.yw.game.floatmenu.FloatMenuView;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * created by tea9 at 2018/12/26
 * 定时器停止
 * https://blog.csdn.net/dj0379/article/details/50877746
 * <p>
 * 写那个选择
 * 判断 app运行逻辑
 */
public class MainService2 extends Service {

    private int time = 5 * 60 * 1000;//30分钟
    //    private int time2 = 12*60*60*1000; //12小时
    private int time2 = 2*60*60*1000; //12小时
//    private int time2 = 10 * 60 * 1000; //12小时

    private static int index = 0;

    private static boolean flag = false; //默认式false

    FloatLogoMenu mFloatMenu; // 悬浮窗
    ArrayList<FloatItem> itemList = new ArrayList<>();
    private int[] menuIcons = new int[]{R.drawable.yw_menu_account};

    public static Map<String, Thread> map = new ConcurrentHashMap<>();

    private Timer timer = null;
    private TimerTask timerTask = null;

    private Timer timer2 = null;
    private TimerTask timerTask2 = null;

    private List<TabEntity> beforelist = new ArrayList<>();
    private List<TabEntity> afterlist = new ArrayList<>();

    private int endindex1;
    private int endindex2;

    private void init() {
        String str = SharedPreferencesUtils.getPreferences(this).getString(Constant.BEFORE_TEXT, "");
        String str1 = SharedPreferencesUtils.getPreferences(this).getString(Constant.AFTER_TEXT, "");
        if (!str.equals("")) {
            List<TabEntity> beforelist1 = GsonUtil.changeGsonToList(str, TabEntity.class);
            for (TabEntity tab : beforelist1) {
                Log.e(Constant.TAG, tab.check + "：" + tab.flag_enum + "：" + tab.text);
            }
            beforelist.clear();
            ;
            beforelist.addAll(beforelist1);
        }
        if (!str1.equals("")) {
            List<TabEntity> afterlist2 = GsonUtil.changeGsonToList(str1, TabEntity.class);
            for (TabEntity tab2 : afterlist2) {
                Log.e(Constant.TAG, tab2.check + "：" + tab2.flag_enum + "：" + tab2.text);
            }
            afterlist.clear();
            afterlist.addAll(afterlist2);
        }

        initData();
    }

    private void initData() {
        endindex1 = beforelist.size() - 1;
        endindex2 = afterlist.size() - 1;
    }

    private void showFloatingWindow() {
        if (mFloatMenu == null) {
            itemList.clear();
//            itemList.add(new FloatItem(flag?"启动":"停止", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[0]), ""));
            itemList.add(new FloatItem("启动1", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[0]), ""));
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
                                showToastByRunnable(MainService2.this, "正在启动");
                                DataCleanManager.clearAllCache(MainService2.this);
                                showToastByRunnable(MainService2.this, "正在清理缓存");
                                SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.START_CMD, true);
                                Log.e(Constant.TAG, "indexstart" + index);
                                init();
                                startTimerFor12();
//                                WatchDog.stopTimer();
                                WatchDog.startTimer();

                                Calendar cal = Calendar.getInstance();// 当前日期
                                int hour = cal.get(Calendar.HOUR_OF_DAY);// 获取小时
                                int minute = cal.get(Calendar.MINUTE);// 获取分钟
                                int minuteOfDay = hour * 60 + minute;// 从0:00分开是到目前为止的分钟数
//                                final int start = 17 * 60 + 20;// 起始时间 17:20的分钟数
                                final int start = 12 * 60;// 起始时间 17:20的分钟数
//                                final int end = 19 * 60;// 结束时间 19:00的分钟数
                                final int end = 24 * 60;// 结束时间 19:00的分钟数
                                if (minuteOfDay >= start && minuteOfDay <= end) {
                                    System.out.println("在外围内");

                                } else {
                                    System.out.println("在外围外");
                                }

                            } else if (position == 1) {
                                try {
                                    showToastByRunnable(MainService2.this, "正在停止");
                                    SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.START_CMD, false);
                                    stopTimer();
                                    interruptThread();
                                    WatchDog.stopTimer();
                                } catch (Exception e) {

                                }
                            }
                        }

                        @Override
                        public void dismiss() {

                        }
                    });
        }

    }

    private void startTimerFor12() {
        if (timer2 == null) {
            timer2 = new Timer();
        }
//        if (timerTask2==null) {
        timerTask2 = new TimerTask() {
            @Override
            public void run() {
                startTimer();
                flag = !flag;
            }
        };
//        }
        if (timer2 != null)
            timer2.schedule(timerTask2, 0, time2);
    }

    // 开启定时器
    private void startTimer() {
        if (timer == null)
            timer = new Timer();
//        if (timerTask==null) {
        timerTask = new TimerTask() {
            @Override
            public void run() {

//                    if (flag&&index > 5) {
//                        index = 0;
//                    } else if (!flag&&index>9){
//                        index = 0;
//                    } else {
//                        index++;
//                    }


                if (flag) {
                    if (index > endindex1) {
                        index = 0;
                    } else {
                        index++;
                    }
                } else {
                    if (index > endindex2) {
                        index = 0;
                    } else {
                        index++;
                    }
                }
//                    List<TabEntity> list = new ArrayList<>();
//                    list.addAll(beforelist);
//                    list.addAll(afterlist);

                SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.START_CMD, false);
                interruptThread();
                SharedPreferencesUtils.putInfo(getApplicationContext(), Constant.START_CMD, false);

                TaskAll.init_task(index, flag, checkTrueList(beforelist), checkTrueList(afterlist));

            }
        };
//        }
        if (timer != null)
            timer.schedule(timerTask, 0, time);

    }

    private List<TabEntity> checkTrueList(List<TabEntity> list) {
        List<TabEntity> beginlist = new ArrayList<>();
        for (TabEntity tab : list) {
            if (tab.check) {
                beginlist.add(tab);
            }
        }
        return beginlist;
    }

    // 停止定时器
    private void stopTimer() {

        if (timer2 != null) {
            timer2.cancel();
            timer2 = null;
        }

        if (timerTask2 != null) {
            timerTask2.cancel();
            timerTask2 = null;
        }

        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask.cancel();
            timerTask = null;
        }
        index = 0;
        flag = false;
    }

    // 中断线程
    private void interruptThread() {
        //                map.entrySet().stream().forEach(v -> v.getValue().interrupt());
//                System.out.println(map.size());
        for (Map.Entry<String, Thread> kv : map.entrySet()) {
            kv.getValue().interrupt(); //中断所有线程
        }
        Thread.currentThread().interrupt();
        map.clear();
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
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showFloatingWindow();
        return super.onStartCommand(intent, flags, startId);
    }
}
