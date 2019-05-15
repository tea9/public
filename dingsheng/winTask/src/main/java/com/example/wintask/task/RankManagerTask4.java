package com.example.wintask.task;


import android.util.Log;

import com.example.wintask.frame.WinSyncRunnable;

/**
 *
 */

public class RankManagerTask4 {

    private static final String TAG = RankManagerTask.class.getSimpleName();

    public RankManagerTask4() {
        start();
    }

    public void start() {
        new LoadDealerRankFromNet().add();
    }

    static class LoadDealerRankFromNet extends WinSyncRunnable {
        @Override
        public void run() {
            Log.d(TAG, "begin test task4 loading...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyTaskFinished();

            Log.d(TAG, "current task4 is finish!");
        }
    }
}
