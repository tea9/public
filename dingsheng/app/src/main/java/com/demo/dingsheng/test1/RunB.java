package com.demo.dingsheng.test1;

public class RunB implements Runnable {

    @Override
    public void run()
    {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("B");
        }
    }
}
