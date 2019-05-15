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

/**
 * created by tea9 at 2019/1/9
 */
public class TimeService2copy extends Service {


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
                        Log.e("shaomiao","66666666");
                        Brower2345Task.start();
                        continue;
                    }else {
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

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(Constant.TAG, "TimeService onStartCommand");
        mTask = new MyTask();
        mTask.execute();
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
