package com.demo.ds;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/**
 * created by tea9 at 2019/1/24
 */
public class LooperThread extends Thread {

    public static Handler handler;
    @Override
    public void run() {
        super.run();
        Log.e("shaomiao","LooperThread LooperThread prepare："+currentThread().getName());
        Looper.prepare();
        Log.e("shaomiao","LooperThread LooperThread prepare："+currentThread().getName());
        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                if (msg.arg1==1) {
                    Log.e("shaomiao", "LooperThread LooperThread 消息是：" + msg.arg1 + currentThread().getName());
                    Log.e("shaomiao", "LooperThread LooperThread 消息是：开启了" + msg.arg1 + currentThread().getName());
                    while (true){
                        Log.e("shaomiao", "LooperThread LooperThread 消息是：开启了" + msg.arg1 + currentThread().getName());
                    }
                }

                if (msg.arg1==2) {
                    Log.e("shaomiao", "LooperThread LooperThread 消息是：" + msg.arg1 + currentThread().getName());
                    Log.e("shaomiao", "LooperThread LooperThread 消息是：停止了" + msg.arg1 + currentThread().getName());
                }

            }

        };
        Looper.loop();
    }
}
