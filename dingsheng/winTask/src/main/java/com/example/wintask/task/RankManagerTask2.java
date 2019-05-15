package com.example.wintask.task;


import android.util.Log;

import com.example.wintask.frame.WinSyncRunnable;

/**
 *
 */

public class RankManagerTask2 {

    private static final String TAG = RankManagerTask.class.getSimpleName();

    public RankManagerTask2() {
        start();
    }

    public void start() {
        new LoadDealerRankFromNet().add();
    }

   public static class LoadDealerRankFromNet extends WinSyncRunnable {

        boolean flag = true;

        @Override
        public void run() {
            Log.d(TAG, "begin test task2 loading...");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (flag) {
                Log.d(TAG, "current task2 is finish!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void finishTask() {
            flag = false;
            Log.d(TAG, "interval running finishTask");
            notifyTaskFinished();
        }
    }
}
