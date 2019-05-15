package com.demo.ds;


import com.demo.ds.test.TestRunnable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyThreadPool {

    static boolean flag=true;

    static Map<Thread, TestRunnable> threadList = new ConcurrentHashMap<>();


    public static synchronized void start() {
        if (!flag) {
            return;
        }

        TestRunnable runnable = new TestRunnable();
        Thread thread = new Thread(runnable);
        threadList.put(thread, runnable);
        thread.start();
        flag = false;
    }

    public static synchronized void stop() {
        for (Map.Entry<Thread, TestRunnable> entry : threadList.entrySet()) {
            if(entry.getKey().isInterrupted()){
                threadList.remove(entry.getKey());
            }
            entry.getKey().interrupt(); // 全部中断
            entry.getValue().setFlag(false);
        }
        flag = true;
    }

}
