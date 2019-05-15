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
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.demo.dingsheng.App;
import com.demo.dingsheng.MainActivity;
import com.demo.dingsheng.R;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.PollingUtils;
import com.demo.dingsheng.util.SharedPreferencesUtils;
import com.yw.game.floatmenu.FloatItem;
import com.yw.game.floatmenu.FloatLogoMenu;
import com.yw.game.floatmenu.FloatMenuView;
import com.yw.game.floatmenu.customfloat.BaseFloatDailog;

import java.util.ArrayList;

/**
 * created by tea9 at 2018/12/18
 * https://github.com/crosg/FloatMenuSample
 * 悬浮窗 https://github.com/YoungBill/Android-FloatWindow
 * 这个是当前用的
 * 悬浮窗关闭不了
 *
 * 应用卡住60秒
 * 悬浮窗关闭
 * 进程保留
 */
public class FloatWindowService2 extends Service {

    FloatLogoMenu mFloatMenu;
    BaseFloatDailog mBaseFloatDailog;
    ArrayList<FloatItem> itemList = new ArrayList<>();
//    private int[] menuIcons = new int[]{R.drawable.yw_menu_account, R.drawable.yw_menu_fb, R.drawable.yw_menu_msg};
    private int[] menuIcons = new int[]{R.drawable.yw_menu_account};
//    String HOME = "启动";
//    String HOME1 = "点击";
//    String FEEDBACK = "客服";
//    String MESSAGE = "消息";

//    String[] MENU_ITEMS = {HOME, FEEDBACK, MESSAGE};
//    String[] MENU_ITEMS = {HOME};
    private static boolean flag= true;
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
//        for (int i = 0; i < menuIcons.length; i++) {
//            itemList.add(new FloatItem("启动", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[i]), ""));
//        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        showFloatingWindow();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void showFloatingWindow() {
        if (mFloatMenu == null) {
            itemList.clear();
            itemList.add(new FloatItem(flag?"启动":"停止", 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[0]), ""));
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
                            Toast.makeText(getApplicationContext(), "position " + position + " title:" + title + " is clicked.", Toast.LENGTH_SHORT).show();
                            if (position==0){
                                Log.e(Constant.TAG,"正在启动");
                                SharedPreferencesUtils.putInfo(getApplicationContext(),Constant.STOP_SERVICE,false);
                                showToastByRunnable(FloatWindowService2.this,"正在启动");

                                PollingUtils.startPollingService(App.mContext, 12 * 60 * 60, PollingService.class, PollingService.ACTION);
                            }else {
                                SharedPreferencesUtils.putInfo(getApplicationContext(),Constant.STOP_SERVICE,true);
                                Log.e(Constant.TAG,"正在停止");
                                try {
                                    Intent AfterService = new Intent(App.mContext, AfterService.class);
                                    Intent BeforeService = new Intent(App.mContext, BeforeService.class);
                                    App.mContext.stopService(AfterService);
                                    App.mContext.stopService(BeforeService);
                                    BeforeService service = new BeforeService();
                                    service.stop();
                                } catch (Exception e){

                                }


//                                showToastByRunnable(FloatWindowService2.this,"正在启动");
//                                PollingUtils.stopPollingService(App.mContext,  PollingService.class, PollingService.ACTION);
//                                PollingUtils.startPollingService(App.mContext, 12 * 60 * 60, PollingService.class, PollingService.ACTION);
//                                PollingUtils.stopPollingService(App.mContext,  PollingService.class, PollingService.ACTION);

//                                Intent stopIntent = new Intent(getApplicationContext(), BeforeService.class);
//                                stopIntent.putExtra("flag",true);
//                                getApplicationContext().stopService(stopIntent);
                            }
//                            Log.e(Constant.TAG,"正在启动flag"+flag);
//                            showToastByRunnable(FloatWindowService2.this,"正在启动"+flag);
//                            if (flag) {
//                                Log.e(Constant.TAG,"正在启动");
////                                SharedPreferencesUtils.putInfo(getApplicationContext(),Constant.STOP_SERVICE,false);
//                                showToastByRunnable(FloatWindowService2.this,"正在启动");
//
//                                PollingUtils.startPollingService(App.mContext, 12 * 60 * 60, PollingService.class, PollingService.ACTION);
//                            } else {
//                                Log.e(Constant.TAG,"正在停止");
//                                showToastByRunnable(FloatWindowService2.this,"正在停止");
//
//                                Intent stopIntent = new Intent(getApplicationContext(), BeforeService.class);
//                                stopIntent.putExtra("flag",true);
//
//                                getApplicationContext().stopService(stopIntent);
//                                Log.e(Constant.TAG,"正在停止555555");

//                                Intent stopIntent1 = new Intent(getApplicationContext(), AfterService.class);
//                                stopIntent1.putExtra("flag",true);
//                                getApplicationContext().stopService(stopIntent1);
//
//                                stop_service = SharedPreferencesUtils.getPreferences(getApplicationContext()).getBoolean(Constant.STOP_SERVICE,false);
//                                SharedPreferencesUtils.putInfo(getApplicationContext(),Constant.STOP_SERVICE,true);
//                                PollingUtils.stopPollingService(App.mContext,  PollingService.class, PollingService.ACTION);

//                                Intent stopIntent2 = new Intent(getApplicationContext(), PollingService.class);
//                                stopIntent2.putExtra("flag",true);
//                                getApplicationContext().stopService(stopIntent2);



//                            }
//                            try {
//                                Log.e(Constant.TAG,"正在停止111");
////                                Thread.sleep(2*1000);
////                                mFloatMenu.destoryFloat();
////                                mFloatMenu =null;
////                                Log.e(Constant.TAG,"正在停止222");
//                                flag= !flag;
//                                Thread.sleep(2*1000);
//                                Log.e(Constant.TAG,"正在停止3333");
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            Log.e(Constant.TAG,"正在停止44444");
//                            showFloatingWindow();
                        }

                        @Override
                        public void dismiss() {

                        }
                    });

            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    refreshDot();
                }
            }, 5000);

            //同时只能new一个
        }


//        if (mBaseFloatDailog != null) return;
//
//        mBaseFloatDailog = new MyFloatDialog(this);
//        mBaseFloatDailog.show();
//        mBaseFloatDailog.dismiss();
    }

    public void refreshDot() {
        for (FloatItem menuItem : itemList) {
            if (TextUtils.equals(menuItem.getTitle(), "我的")) {
                menuItem.dotNum = String.valueOf(8);
            }
        }
        mFloatMenu.setFloatItemList(itemList);
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
