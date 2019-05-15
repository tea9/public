package com.example.wintask.frame;

/**
 * .
 */

public class WinFrameImpl implements IFrame {

    @Override
    public void init() {

    }

    @Override
    public void startSync() {

    }

    @Override
    public void initSyncTask() {
        WinSyncTask.getInstance().init();
    }

    @Override
    public void addSyncTask(WinSyncRunnable runnable) {
        WinSyncTask.getInstance().addtask(runnable);
    }

    @Override
    public void setSyncTaskFinished(WinSyncRunnable runnable) {
        WinSyncTask.getInstance().finish(runnable);
    }

    @Override
    public void clearSyncTask() {
        WinSyncTask.getInstance().clean();
    }

    @Override
    public void taskReset() {
        WinSyncTask.getInstance().reset();
    }
}
