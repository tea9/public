package com.demo.android_ds.util;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.demo.android_ds.R;
import com.demo.android_ds.service.AllService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class TestActivity extends AppCompatActivity {

    private Button start_btn, stop_btn, test_time,float_window;
    Thread xx;
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    private List<Thread> threads = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        start_btn = findViewById(R.id.start_btn);
        stop_btn = findViewById(R.id.stop_btn);
        test_time = findViewById(R.id.test_time);
        float_window = findViewById(R.id.float_window);

        float_window.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 悬浮窗
                startService(new Intent(TestActivity.this, AllService.class));
            }
        });


        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 开始
//                xx=new Thread(new TestRunnable());
//                xx.start();
//                executorService.execute(new TestRunnable());

//                Thread thread = new Thread();
//                thread.start();
//                threads.add(thread);
                MyThreadPool.start();

            }
        });

        stop_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 结束
//                xx.interrupt();
//                executorService.shutdown();
                MyThreadPool.stop();
            }
        });

        test_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 测试时间
                Calendar now = Calendar.getInstance();
                int nowDate= now.get(Calendar.HOUR_OF_DAY);

                //0 1 2 3 4 5

                if(nowDate>=0&&nowDate<=14) {
                    Log.e("test", "在区间内");
                } else{
                    Log.e("test", "不在区间内");
                }


//                String format = "HH";
//                Date nowTime = null;
//                try {
////                    nowTime = new SimpleDateFormat(format).parse("09");
//                    nowTime = new Date();
//                    Date startTime = new SimpleDateFormat(format).parse("9");
//                    Date endTime = new SimpleDateFormat(format).parse("15");
//



//
//
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }
}
