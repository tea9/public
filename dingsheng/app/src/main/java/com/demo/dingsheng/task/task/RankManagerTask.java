package com.demo.dingsheng.task.task;


import android.util.Log;

import com.demo.dingsheng.task.frame.WinSyncRunnable;

/**
 *
 */

public class RankManagerTask {

    private static final String TAG = RankManagerTask.class.getSimpleName();

    public RankManagerTask() {

    }

    public void start() {
        new LoadDealerRankFromNet().add();
    }

    public void finishTask() {
        new RankManagerTask2();
    }

    public static class LoadDealerRankFromNet extends WinSyncRunnable {
        @Override
        public void run() {
            Log.d(TAG, "begin test task loading...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyTaskFinished();

            Log.d(TAG, "current task is finish!");

        }

    }
}
