package com.example.wintask.application;

import android.app.Application;

import com.example.wintask.frame.WinFrameHelper;
import com.example.wintask.task.RankManagerTask;
import com.example.wintask.task.RankManagerTask2;
import com.example.wintask.task.RankManagerTask3;
import com.example.wintask.task.RankManagerTask4;
import com.example.wintask.utils.RxTimerUtil;

/**
 * Created by Apple on 2019/1/5.
 */

public class TaskApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //启动初始化任务列表

        WinFrameHelper.getFrameImpl().initSyncTask();

        //初始化第一个任务
        new RankManagerTask().start();

        new RankManagerTask2();

        //每隔{24}小时执行下一任务组,现在是设置为1分钟
        RxTimerUtil.reactivexTimer(120, new RxTimerUtil.IRxNext() {
            @Override
            public void doNext(long number) {
                new RankManagerTask3();
            }

            @Override
            public void doFinish() {
                new RankManagerTask4();//实际可以改成for循环来取
            }
        });

    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        WinFrameHelper.getFrameImpl().clearSyncTask();

        RxTimerUtil.cancel();
    }
}
