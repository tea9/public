package com.demo.ds;

import com.demo.ds.test.TestRunnable;

/**
 * created by tea9 at 2019/1/25
 */
public class Main {
    public static void main(String[] args){
        new Thread(new TestRunnable()).start();
//        TestRunnable.setFlag(true);
    }
}
