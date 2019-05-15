package com.demo.dingsheng.test1;

public class RunA implements Runnable {

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()){
            System.out.println("A");
        }
    }
}
