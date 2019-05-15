package com.demo.dingsheng.test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * created by tea9 at 2018/12/25
 */
public class TestClass {

    private volatile int index = 0;
    private volatile boolean[] xx=new boolean[]{false,false,false};
    private Runnable runnable1,runnable2,runnable3;

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.init();
        testClass.startTimer();
    }

    private void init() {
        runnable1=new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("第一个任务任务11111111111111");
                }
            }
        };

        runnable2=new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("第一个任务任务2222222222222");
                }
            }
        };
        runnable3=new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("第一个任务任务333333333");
                }
            }
        };
    }

    private void start() {
        Thread thread = null;
        if (index==0) {
            thread= new Thread(runnable1);
        } else if (index==1) {
            thread= new Thread(runnable2);
        } else if(index==2){
            thread= new Thread(runnable3);
        }
        System.out.println("new thread"+thread.getName());
        System.out.println("new thread111"+Thread.currentThread().getName());
        thread.start();
    }

    private void startTimer() {

        final Timer timer = new Timer();
        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                xx=new boolean[]{false,false,false};
                xx[index] =true;
                System.out.println("定时器index"+index);
                start();
                index+=1;
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                timer.schedule(timerTask,0,1000);
            }
        };
        Thread thread = new Thread(runnable2);
        thread.start();
        System.out.println("startTimer"+Thread.currentThread().getName());
    }
}
