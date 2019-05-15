package com.demo.dingsheng.timer;

import android.util.Log;
import com.demo.dingsheng.entitiy.TabEntity;
import com.demo.dingsheng.timer.task.QuTouTiaoRunnable;
import com.demo.dingsheng.timer.task.ZhongQingRunnable;
import com.demo.dingsheng.util.Constant;

import java.util.List;

/**
 * created by tea9 at 2018/12/26
 */
public class TaskAll2 {

//    private static List<TabEntity> data=new ArrayList<>();

//    private static List<TabEntity> before

    // 传递过来的得是true
    public static void init_task(int index, boolean flag, List<TabEntity> list1, List<TabEntity> list2) {

        if (list1.size()==0){
            flag = false;
        }
        if (list2.size()==0){
            flag = true;
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            }
        };

        Log.e(Constant.TAG, "index" + index);
        Log.e(Constant.TAG, "flag" + flag);
        if (index==1){
            runnable = new ZhongQingRunnable();
        } else if (index ==2) {
            runnable = new QuTouTiaoRunnable();
        }
        Thread thread = new Thread(runnable);
        thread.start();
        MainService.map.put(thread.getName(), thread);
    }
}
