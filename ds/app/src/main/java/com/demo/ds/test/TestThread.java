package com.demo.ds.test;

/**
 * created by tea9 at 2019/1/25
 */
public class TestThread extends Thread {

    volatile boolean flag=true;

    @Override
    public void run() {
        super.run();
        new TestRunnable();
    }

    public void setFlag(boolean flag) {
        if(!flag){
            interrupt();
        }
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}
