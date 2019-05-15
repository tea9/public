package com.demo.dingsheng2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.demo.dingsheng2.asynctask.AllAsyncTask;
import com.demo.dingsheng2.asynctask.WatchDog;
import com.demo.dingsheng2.service.*;
import com.demo.dingsheng2.task.XintoutiaoTask;
import com.demo.dingsheng2.util.Constant;

/**
 * created by tea9 at 2019/1/9
 * 测试TimeService服务
 */
public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(Constant.TAG,"onCreate TestActivity"+Thread.currentThread().getName());
        setContentView(R.layout.activity_test);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(Constant.TAG,"onCreate TestActivity"+Thread.currentThread().getName());
    }
    AllAsyncTask allAsyncTask;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:// 启动服务
                startService(new Intent(TestActivity.this,TimeService.class));
                break;
            case R.id.btn2:// 执行操作
                XintoutiaoTask.start();
                break;
            case R.id.btn3:
                startService(new Intent(TestActivity.this,TimeService2.class));
                break;
            case R.id.btn4:
                startService(new Intent(TestActivity.this,TimeService3.class));
                break;
            case R.id.btn5:
                startService(new Intent(TestActivity.this,TimeService4.class));
                break;
            case R.id.btn6:
                startService(new Intent(TestActivity.this,AllService.class));
                break;
            case R.id.btn7:
                allAsyncTask = new AllAsyncTask();
                allAsyncTask.execute();
                WatchDog.startTimer();
                break;
            case R.id.btn8:
                if (allAsyncTask!=null) {
                    Log.e(Constant.TAG,"btn8 allAsyncTask cancle");
                    allAsyncTask.cancel(true);
                }
                WatchDog.stopTimer();
                break;
            case R.id.btn9:
                startService(new Intent(TestActivity.this,AllService2.class));
                break;


        }
    }
}
