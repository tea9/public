package com.demo.dingsheng.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.demo.dingsheng.util.Constant;

/**
 * created by tea9 at 2018/12/18
 * 逻辑
 * 开启两个服务
 * 一个运行前6个
 * 一个运行后
 * 没12个小时切换
 *
 * 每个服务里 开启30分钟定时
 * 30分钟运行一个app
 *
 */
public class ScreenControlAlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //你的逻辑处理
        //如果需要实现间隔定时器功能，在重新执行1的发送步骤，实现间隔定时，间隔时间为INTERVAL
        Log.e(Constant.TAG,"这是个定时广播hhhhhhhhhhhhhhh");

    }
}
