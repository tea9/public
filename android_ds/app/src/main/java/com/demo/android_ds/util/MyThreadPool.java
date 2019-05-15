package com.demo.android_ds.util;


import com.demo.android_ds.App;
import com.demo.android_ds.runnable.BaseRunnable;
import com.demo.android_ds.runnable.LeShiRunnable;
import com.demo.android_ds.runnable.TestRunnable;
import com.demo.android_ds.runnable.XiaoMiRunnable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyThreadPool {

    static boolean flag=true; //点击开始只开始一次

    static Map<Thread, Runnable> threadList = new ConcurrentHashMap<>();


    public static synchronized void start() {
        if (!flag) {
            return;
        }
        //判断手机
        Runnable runnable = null;
        if (App.getDeviceBrand().equals("Huawei")){
            runnable = new TestRunnable();
        } else if (App.getDeviceBrand().equals("Xiaomi")) {
            runnable = new XiaoMiRunnable();
        } else if (App.getDeviceBrand().equals("Letv")) {
            runnable = new LeShiRunnable();
        }



        Thread thread = new Thread( runnable);
        threadList.put(thread,
                runnable);
        thread.start();
        flag = false;
    }

    public static synchronized void stop() {
        for (Map.Entry<Thread, Runnable> entry : threadList.entrySet()) {
            if(entry.getKey().isInterrupted()){
                threadList.remove(entry.getKey());
            }
            entry.getKey().interrupt(); // 全部中断
            ((BaseRunnable)entry.getValue()).setFlag(false);
        }
        flag = true;
    }

}
