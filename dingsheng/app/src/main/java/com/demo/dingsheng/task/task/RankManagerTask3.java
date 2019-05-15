package com.demo.dingsheng.task.task;


import android.util.Log;

import com.demo.dingsheng.task.frame.WinSyncRunnable;

/**
 *
 */

public class RankManagerTask3 {

    private static final String TAG = RankManagerTask.class.getSimpleName();

    public RankManagerTask3() {
        start();
    }

    public void start() {
        new LoadDealerRankFromNet().add();
    }

    static class LoadDealerRankFromNet extends WinSyncRunnable {
        @Override
        public void run() {
            Log.d(TAG, "begin test task3 loading...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyTaskFinished();

            Log.d(TAG, "current task3 is finish!");
        }
    }
}
