package com.example.wintask.frame;

public abstract class WinSyncRunnable implements Runnable {
    private boolean mAdded;

    public void add() {
        mAdded = true;
        WinFrameHelper.getFrameImpl().addSyncTask(this);
    }

    protected void notifyTaskFinished() {
        if (mAdded) {
            WinFrameHelper.getFrameImpl().setSyncTaskFinished(this);
            mAdded = false;
        }
    }
}