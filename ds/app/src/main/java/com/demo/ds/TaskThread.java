package com.demo.ds;

import android.util.Log;

/**
 * created by tea9 at 2019/1/24
 */
public class TaskThread extends Thread {

    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        super.run();
        xx();
    }

    private void xx(){
//        while (!flag){

        while (true){
            if (flag) {
                Log.e("shaomiao", "TaskThreadflag"+flag + currentThread().getName());
                yield();
//                break;
            }
            Log.e("shaomiao", "TaskThread" + currentThread().getName());
        }
    }
}
