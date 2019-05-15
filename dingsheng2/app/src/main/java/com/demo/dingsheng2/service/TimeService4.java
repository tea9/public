package com.demo.dingsheng2.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.demo.dingsheng2.R;
import com.demo.dingsheng2.TestActivity;
import com.demo.dingsheng2.task.*;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.DataCleanManager;
import com.yw.game.floatmenu.FloatItem;
import com.yw.game.floatmenu.FloatLogoMenu;
import com.yw.game.floatmenu.FloatMenuView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * created by tea9 at 2019/1/9
 * 所有app 还没测试
 */
public class TimeService4 extends Service {

    FloatLogoMenu mFloatMenu; // 悬浮窗
    ArrayList<FloatItem> itemList = new ArrayList<>();
    private int[] menuIcons = new int[]{R.drawable.yw_menu_account};
    private boolean flag=true;

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
                                Log.e("shaomiao", "create   cancel" + Thread.currentThread().getName());
                                DataCleanManager.clearAllCache(TimeService4.this); //清理缓存

                                Timer timer = new Timer();
                                TimerTask timerTask = new TimerTask() {
                                    @Override
                                    public void run() {
                                        if (flag) {
                                            mTask = new MyTask();
                                            mTask.execute();
                                        }else {
                                            myTask1 = new MyTask1();
                                            myTask1.execute();
                                        }
                                        flag=!flag;
                                    }
                                };
                                timer.schedule(timerTask, 0, 2*60*60*1000);

//                                mTask.execute();

                            } else if (position == 1) {
                                Log.e("shaomiao", "view   cancel" + Thread.currentThread().getName());
                                mTask.cancel(true);
                                myTask1.cancel(true);
                            }
                        }

                        @Override
                        public void dismiss() {

                        }
                    });
        }

    }

    private class MyTask1 extends AsyncTask<String, Integer, String> {

        // 方法1：onPreExecute（）
        // 作用：执行 线程任务前的操作
        @Override
        protected void onPreExecute() {
//            text.setText("加载中");
            // 执行前显示提示
            Log.e("shaomiao", "onPreExecute" + Thread.currentThread().getName());
        }


        // 方法2：doInBackground（）
        // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
        // 此处通过计算从而模拟“加载进度”的情况
        @Override
        protected String doInBackground(String... params) {

            try {
                int count = 0;
//                int count = 0;

                while (count < 11) {
                    count += 1;
                    Thread.sleep(50);
//                    XintoutiaoTask.start();
                    if (count == 1) {
                        Thread.sleep(1000);
                        Log.e("shaomiao","1111");
                        //微鲤看看、韭菜头条、红包头条、聚合头条、大众看点、聚看点、掌上头条、点点新闻、闪电看看
                        WeilikankanTask.start();
                        continue;
//                        mTask.cancel(true);
                    }else if (count==2){
                        Thread.sleep(1000);
                        Log.e("shaomiao","22222");
                        JiucaitoutiaoTask.start();
                        continue;
                    }else if (count==3){
                        Thread.sleep(1000);
                        Log.e("shaomiao","333333");
                        HongbaotoutiaoTask.start();
                        continue;
                    }else if (count==4) {
                        Thread.sleep(1000);
                        Log.e("shaomiao","444444");
                        JuhetoutiaoTask.start();
                        continue;
                    }else if (count==5) {
                        Thread.sleep(1000);
                        Log.e("shaomiao","5555555");
                        DazhongkandaioTask.start();
                        continue;
                    }else if (count==6){
                        Thread.sleep(1000);
                        Log.e("shaomiao","66666666"+Thread.currentThread().getName());
                        JukandianTask.start();
//                        ShellUtil.clickMethod(25,25);
                        continue;
                    }else if (count==7){
                        Thread.sleep(1000);
                        Log.e("shaomiao","7777777"+Thread.currentThread().getName());
                        ZhangshangtoutiaoTask.start();
                        continue;
                    }
                    else if (count==8){
                        Thread.sleep(1000);
                        Log.e("shaomiao","7777777"+Thread.currentThread().getName());
                        DiandianxinwenTask.start();
                        continue;
                    }
                    else if (count==9){
                        Thread.sleep(1000);
                        Log.e("shaomiao","7777777"+Thread.currentThread().getName());
                        ShandiankankanTask.start();
                        continue;
                    }

                    else {
                        Log.e("shaomiao","else else else"+count);
                        count=0;
                    }
                    Log.e("shaomiao", "doInBackground" + Thread.currentThread().getName());
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        // 方法3：onProgressUpdate（）
        // 作用：在主线程 显示线程任务执行的进度
        @Override
        protected void onProgressUpdate(Integer... progresses) {
            Log.e("shaomiao", "onProgressUpdate" + Thread.currentThread().getName());
//            progressBar.setProgress(progresses[0]);
//            text.setText("loading..." + progresses[0] + "%");

        }

        // 方法4：onPostExecute（）
        // 作用：接收线程任务执行结果、将执行结果显示到UI组件
        @Override
        protected void onPostExecute(String result) {
            Log.e("shaomiao", "onPostExecute" + Thread.currentThread().getName());
            // 执行完毕后，则更新UI
//            text.setText("加载完毕");
        }

        // 方法5：onCancelled()
        // 作用：将异步任务设置为：取消状态
        @Override
        protected void onCancelled() {
            Log.e("shaomiao", "onCancelled" + Thread.currentThread().getName());
//            text.setText("已取消");
//            progressBar.setProgress(0);

        }
    }


    private class MyTask extends AsyncTask<String, Integer, String> {

        // 方法1：onPreExecute（）
        // 作用：执行 线程任务前的操作
        @Override
        protected void onPreExecute() {
//            text.setText("加载中");
            // 执行前显示提示
            Log.e("shaomiao", "onPreExecute" + Thread.currentThread().getName());
        }


        // 方法2：doInBackground（）
        // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
        // 此处通过计算从而模拟“加载进度”的情况
        @Override
        protected String doInBackground(String... params) {

            try {
                int count = 0;
//                int count = 0;

                while (count < 8) {
                    count += 1;
                    Thread.sleep(50);
//                    XintoutiaoTask.start();
                    if (count == 1) {
                        Thread.sleep(1000);
                        Log.e("shaomiao","1111");
                        XintoutiaoTask.start();
                        continue;
//                        mTask.cancel(true);
                    }else if (count==2){
                        Thread.sleep(1000);
                        Log.e("shaomiao","22222");
                        ZhongqingkandianTask.start();
                        continue;
                    }else if (count==3){
                        Thread.sleep(1000);
                        Log.e("shaomiao","333333");
                        QutoutiaoTask.start();
                        continue;
                    }else if (count==4) {
                        Thread.sleep(1000);
                        Log.e("shaomiao","444444");
                        MayitoutiaoTask.start();
                        continue;
                    }else if (count==5) {
                        Thread.sleep(1000);
                        Log.e("shaomiao","5555555");
                        ToutiaoduoduoTask.start();
                        continue;
                    }else if (count==6){
                        Thread.sleep(1000);
                        Log.e("shaomiao","66666666"+Thread.currentThread().getName());
                        Brower2345Task.start();
//                        ShellUtil.clickMethod(25,25);
                        continue;
                    }
                    else {
                        Log.e("shaomiao","else else else"+count);
                        count=0;
                    }
                    Log.e("shaomiao", "doInBackground" + Thread.currentThread().getName());
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        // 方法3：onProgressUpdate（）
        // 作用：在主线程 显示线程任务执行的进度
        @Override
        protected void onProgressUpdate(Integer... progresses) {
            Log.e("shaomiao", "onProgressUpdate" + Thread.currentThread().getName());
//            progressBar.setProgress(progresses[0]);
//            text.setText("loading..." + progresses[0] + "%");

        }

        // 方法4：onPostExecute（）
        // 作用：接收线程任务执行结果、将执行结果显示到UI组件
        @Override
        protected void onPostExecute(String result) {
            Log.e("shaomiao", "onPostExecute" + Thread.currentThread().getName());
            // 执行完毕后，则更新UI
//            text.setText("加载完毕");
        }

        // 方法5：onCancelled()
        // 作用：将异步任务设置为：取消状态
        @Override
        protected void onCancelled() {
            Log.e("shaomiao", "onCancelled" + Thread.currentThread().getName());
//            text.setText("已取消");
//            progressBar.setProgress(0);

        }
    }

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

    MyTask mTask;
    MyTask1 myTask1;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(Constant.TAG, "TimeService onStartCommand");
        showFloatingWindow();
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


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(Constant.TAG, "TimeService onDestroy");
    }


}
