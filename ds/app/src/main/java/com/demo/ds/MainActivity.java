package com.demo.ds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button stop_btn,start_btn,jiaochuan;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        jiaochuan();
        stop_btn = findViewById(R.id.stop_btn);
        start_btn = findViewById(R.id.start_btn);
        jiaochuan = findViewById(R.id.jiaochuan);
//        final LooperThread looperThread = new LooperThread();
//        looperThread.start();

        final TaskThread t=new TaskThread();
//        t.start();
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.start();
//                t.setFlag(false);

//                run_flag =true;

//                Message msMessage = new Message();
//                msMessage.arg1 = 1;
//                looperThread.handler.sendMessage(msMessage);
            }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("shaomiao", "TaskThreadttttt" +t.isFlag());

                t.setFlag(true);
//                flag = false;
//                run_flag =false;

//                Message msMessage = new Message();
//                msMessage.arg1 = 2;
//                looperThread.handler.sendMessage(msMessage);
            }
        });

        jiaochuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("shaomiao","aaaa");
                jiaochuan();
            }
        });

    }























    static volatile boolean flag = true;
    static volatile boolean run_flag =false;
    public static void jiaochuan() {
        final long jiaochuanDuration = 30 * 60 * 1000;
//        final long jiaochuanDuration = 5 * 1000;

        class Jiaochuan implements Runnable {

            @Override
            public void run() {
                long jiaochuanStart = System.currentTimeMillis();
                while (System.currentTimeMillis() - jiaochuanStart < jiaochuanDuration) {
                    // TODO: 2019/1/24 jiaochuan
//                    Logger.e("jiaochuan");

                    Log.e("shaomiao","aaaa");

                }
            }
        }

        class TestRunnable implements Runnable {
            @Override
            public void run() {
                Log.e("shaomiao","Runnable run");
                if (run_flag) {
                    Log.e("shaomiao","Runnable run_flag"+run_flag);
                }
            }
        }

        Jiaochuan jiaochuan = new Jiaochuan();
//        TestRunnable jiaochuan = new TestRunnable();
        Thread thread = new Thread(jiaochuan);
        thread.start();
    }


}
