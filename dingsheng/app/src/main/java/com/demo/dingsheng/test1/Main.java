package com.demo.dingsheng.test1;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    private static int index = 0;

    private static Map<String, Thread> map = new ConcurrentHashMap<>();

    private volatile Boolean flag = true;

    public static void maintest(int index) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        if (index == 1) {
            runnable = new RunA();
        } else if (index == 2) {
            runnable = new RunB();
        } else if (index == 3) {
            runnable = new RunC();
        }
        Thread thread = new Thread(runnable);
        thread.start();
        map.put(thread.getName(), thread);

    }

    private static  void startTimer() {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
//                map.entrySet().stream().forEach(v -> v.getValue().interrupt());
                System.out.println(map.size());
                for (Map.Entry<String,Thread>  kv: map.entrySet()
                     ) {
                    kv.getValue().interrupt();
                }

                map.clear();
                if (index > 3) {
                    index = 0;
                } else {
                    index++;
                }
                maintest(index);
            }
        };
        timer.schedule(timerTask, 0, 10000);
        System.out.println("startTimer" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        startTimer();
    }
}
