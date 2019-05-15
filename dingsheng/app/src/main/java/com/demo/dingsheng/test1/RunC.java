package com.demo.dingsheng.test1;

public class RunC implements Runnable {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("C");
        }
    }
}
