package com.demo.dingsheng2.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.demo.dingsheng2.R;
import com.demo.dingsheng2.TestActivity;
import com.demo.dingsheng2.asynctask.AfterAsyncTask;
import com.demo.dingsheng2.asynctask.BeforeAsyncTask;
import com.demo.dingsheng2.util.Constant;
import com.yw.game.floatmenu.FloatItem;
import com.yw.game.floatmenu.FloatLogoMenu;
import com.yw.game.floatmenu.FloatMenuView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by tea9 at 2019/1/10
 * 做12小时调度
 * 还没测试
 * 这个是主要的
 */
public class AllService extends Service {

    FloatLogoMenu mFloatMenu; // 悬浮窗
    ArrayList<FloatItem> itemList = new ArrayList<>();
    private int[] menuIcons = new int[]{R.drawable.yw_menu_account};

    Timer timer;
    boolean flag = true;

    BeforeAsyncTask beforeAsyncTask;
    AfterAsyncTask afterAsyncTask;


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
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
        showFloatingWindow();
        return super.onStartCommand(intent, flags, startId);
    }

    private void showFloatingWindow() {
        if (mFloatMenu == null) {
            itemList.clear();
//            itemList.add(new FloatItem(flag?"启动":"停止", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[0]), ""));
            itemList.add(new FloatItem("启动", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[0]), ""));
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
                                timer = new Timer();
                                TimerTask timerTask = new TimerTask() {
                                    @Override
                                    public void run() {
                                        Log.e(Constant.TAG, "timerTask" + String.valueOf(flag) + ":" + Thread.currentThread().getName());
                                        if (flag) {
                                            try {
                                                afterAsyncTask.cancel(true);
                                            } catch (Exception e) {
                                            }
                                            beforeAsyncTask = new BeforeAsyncTask();
                                            beforeAsyncTask.execute();
                                        } else {
                                            try {
                                                beforeAsyncTask.cancel(true);
                                            } catch (Exception e) {
                                            }
                                            afterAsyncTask = new AfterAsyncTask();
                                            afterAsyncTask.execute();
                                        }
                                        flag = !flag;
                                    }
                                };
                                timer.schedule(timerTask, 0, 60*60*1000); //1小时

                            } else if (position == 1) {
                                Log.e("shaomiao", "view   cancel" + Thread.currentThread().getName());
                                if(beforeAsyncTask!=null)
                                    beforeAsyncTask.cancel(true);
                                if (afterAsyncTask!=null)
                                    afterAsyncTask.cancel(true);
                            }
                        }

                        @Override
                        public void dismiss() {

                        }
                    });
        }

    }
}
