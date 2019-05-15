package com.demo.dingsheng.task.frame;

import android.util.Log;
import com.demo.dingsheng.task.task.RankManagerTask;
import com.demo.dingsheng.task.task.RankManagerTask2;
import com.demo.dingsheng.task.utils.RxTimerUtil;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

import java.util.ArrayList;

/**
 */

public class WinSyncTask {
    private static final String TAG = RankManagerTask.class.getSimpleName();
    private static WinSyncTask sInstance = new WinSyncTask();
    private ArrayList<WinSyncRunnable> mTaskList = new ArrayList<>();
    private boolean mRunning = false;
    private boolean mInit = false;
    private StringBuffer mTaskLog = new StringBuffer();

    /**
     * .
     */
    public static WinSyncTask getInstance() {
        return sInstance;
    }

    /**
     * .
     */
    public synchronized void addtask(final WinSyncRunnable runnable) {
        mTaskList.add(runnable);
        start();

        //判断任务在规定时间是否执行完成,没有完成直接remvove.
        RxTimerUtil.interval(20, new RxTimerUtil.IRxNext() {
            @Override
            public void doNext(long number) {
                if (mTaskList.size() == 0) {
                    return;
                } else {
                    WinSyncRunnable winSyncRunnable = mTaskList.get(0);
                    String simpleName = winSyncRunnable.getClass().getSimpleName();
                    if (winSyncRunnable != null && winSyncRunnable.equals(runnable)) {
                        Log.d(TAG, "interval running task 超时取消测试成功.");
                        if (winSyncRunnable instanceof RankManagerTask2.LoadDealerRankFromNet) {
                            ((RankManagerTask2.LoadDealerRankFromNet) winSyncRunnable).finishTask();
                            new RankManagerTask().start();

                            new RankManagerTask().finishTask();
                        }

                        finish(winSyncRunnable);


                    } else {
                        //该任务执行完毕无需处理。
                    }
                }
            }

            @Override
            public void doFinish() {

            }
        });
    }

    /**
     * .
     */
    public synchronized void finish(WinSyncRunnable runnable) {
        mTaskList.remove(runnable);
        mRunning = false;
        start();
    }

    /**
     * .
     */
    public synchronized void start() {
        if (!mInit) {
            mTaskLog.append(1);
            return;
        }
        if (mRunning) {
            return;
        }
        if (mTaskList.size() == 0) {
            return;
        } else {
            WinSyncRunnable runnable = mTaskList.get(0);
            String simpleName = runnable.getClass().getSimpleName();
        }
        mRunning = true;
        Observable.empty().observeOn(Schedulers.newThread()).doOnComplete(new Action() {
            @Override
            public void run() {
                if (mTaskList.size() == 0) {
                    mTaskLog.append(4);
                    mRunning = false;
                } else {
                    WinSyncRunnable runnable = mTaskList.get(0);
                    runnable.run();
                    mTaskLog.append(5);
                    String simpleName = runnable.getClass().getSimpleName();
                }
                mTaskLog.delete(0, mTaskList.size());
            }
        }).subscribe();
    }

    /**
     * .
     */
    public synchronized void init() {
        mInit = true;
        start();
    }

    /**
     * .
     */
    public synchronized void clean() {
        mTaskList.clear();
        mRunning = false;
    }

    /**
     * .
     */
    public synchronized void reset() {
        mInit = true;
        mRunning = false;
    }

}
