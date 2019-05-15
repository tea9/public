package com.demo.dingsheng.task.frame;

public interface IFrame {
    void init();

    void startSync();

    void initSyncTask();

    void addSyncTask(WinSyncRunnable runnable);

    void setSyncTaskFinished(WinSyncRunnable runnable);

    void clearSyncTask();

    void taskReset();
}