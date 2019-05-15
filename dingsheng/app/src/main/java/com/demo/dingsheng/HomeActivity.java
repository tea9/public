package com.demo.dingsheng;

import android.annotation.TargetApi;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import com.demo.dingsheng.service.*;
import com.demo.dingsheng.timer.MainService;
import com.demo.dingsheng.timer.WatchDog;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.PollingUtils;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.SystemUtils;
import com.demo.dingsheng.view.*;

/**
 * created by tea9 at 2018/12/6
 */
public class HomeActivity extends AppCompatActivity {

    SmoothCheckBox xx;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item1);

        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Button btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WatchDog.startTimer();
            }
        });

        Button btn10 = findViewById(R.id.btn10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WatchDog.stopTimer();
            }
        });

        Button btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(HomeActivity.this, MainService.class));
            }
        });

        Button btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(HomeActivity.this, TimingService.class));
            }
        });

        Button btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(new Intent(HomeActivity.this, AutoService.class));
            }
        });
        Button btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(HomeActivity.this, AutoService.class));
            }
        });

        Button btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(HomeActivity.this, FloatWindowService2.class));
            }
        });

//        startService(new Intent(MainActivity.this, FloatWindowService2.class));

        Button btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RootCmd.haveRoot();
                Intent i = new Intent(HomeActivity.this,BeforeService.class);
                startService(i);
            }
        });


        Button btn2= findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("Start polling service...");
                Log.e(Constant.TAG,"Start polling service...");

                // 现在是5秒轮询 应该改成12小时
                PollingUtils.startPollingService(HomeActivity.this, 12*60*60, PollingService.class, PollingService.ACTION);
//                int INTERVAL = 3*1000;
//                AlarmManager alarmService = (AlarmManager) HomeActivity.this.getSystemService(ALARM_SERVICE);
//                Intent alarmIntent = new Intent(HomeActivity.this, ScreenControlAlarmReceiver.class).setAction("intent_alarm_log");
//                PendingIntent broadcast = PendingIntent.getBroadcast(HomeActivity.this, 0, alarmIntent, 0);//通过广播接收
//                alarmService.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + INTERVAL, broadcast);//INTERVAL毫秒后触发
//                alarmIntent.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + INTERVAL,System.currentTimeMillis() + INTERVAL, broadcast);
            }
        });

//        xx = findViewById(R.id.xx);
//        Log.e("shaomiao",xx.isChecked()+"");

        /**
         * android.useAndroidX=true
         * android.enableJetifier=true
         */
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
                UiDevice uiDevice = UiDevice.getInstance(instrumentation);
                uiDevice.pressHome();
            }
        });

//        xx.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(HomeActivity.this,xx.isChecked()+"",Toast.LENGTH_SHORT).show();
//            }
//        });

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                //当AndroidSDK>=23及Android版本6.0及以上时，需要获取OVERLAY_PERMISSION.
                //使用canDrawOverlays用于检查，下面为其源码。其中也提醒了需要在manifest文件中添加权限.
                /**
                 * Checks if the specified context can draw on top of other apps. As of API
                 * level 23, an app cannot draw on top of other apps unless it declares the
                 * {@link android.Manifest.permission#SYSTEM_ALERT_WINDOW} permission in its
                 * manifest, <em>and</em> the user specifically grants the app this
                 * capability. To prompt the user to grant this approval, the app must send an
                 * intent with the action
                 * {@link android.provider.Settings#ACTION_MANAGE_OVERLAY_PERMISSION}, which
                 * causes the system to display a permission management screen.
                 *
                 */
                if (Settings.canDrawOverlays(HomeActivity.this))
                {
//                    Intent intent = new Intent(HomeActivity.this,MainService.class);
//                    Toast.makeText(HomeActivity.this,"已开启Toucher",Toast.LENGTH_SHORT).show();
//                    startService(intent);
//                    finish();
                    xx();
                }else
                {
                    //若没有权限，提示获取.
                    Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                    Toast.makeText(HomeActivity.this,"需要取得权限以使用悬浮窗",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
//                    finish();
                }


//                wm();
//                WindowManager wmManager=(WindowManager) getSystemService(Context.WINDOW_SERVICE);
//                WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
//
//                wmParams.type = WindowManager.LayoutParams.TYPE_PHONE; // 设置window type
//                wmParams.format = PixelFormat.RGBA_8888; // 设置图片格式，效果为背景透明
//
//                wmParams.flags=WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//
//                wmParams.gravity = Gravity.RIGHT| Gravity. CENTER_VERTICAL; // 调整悬浮窗口至右侧中间
//                wmParams.x = 0;// 以屏幕左上角为原点，设置x、y初始值
//                wmParams.y = 0;
//
//                wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;// 设置悬浮窗口长宽数据
//                wmParams.height =WindowManager.LayoutParams.WRAP_CONTENT;
//                floatViewParams = initFloatViewParams(HomeActivity.this);
////                floatView = new FloatWindowView(HomeActivity.this, floatViewParams, wmParams);
//                TextView textView = new TextView(HomeActivity.this);
//                textView.setText("dfdjflkdsjfkldsjfkldsjl");
//                wmManager.addView(textView,wmParams);
            }
        });
    }
    private  String TAG="sssssss";

    private void xx() {

        final WindowManager.LayoutParams params;
        final WindowManager windowManager;
        final ConstraintLayout toucherLayout;

        ImageButton imageButton1;

        //状态栏高度.
        int statusBarHeight = -1;
        //赋值WindowManager&LayoutParam.
        params = new WindowManager.LayoutParams();
        windowManager = (WindowManager) getApplication().getSystemService(Context.WINDOW_SERVICE);
        //设置type.系统提示型窗口，一般都在应用程序窗口之上.
        //Android8.0行为变更，对8.0进行适配https://developer.android.google.cn/about/versions/oreo/android-8.0-changes#o-apps
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1)
        {
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }else {
            params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }

        if (Build.VERSION.SDK_INT >= 26) {
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        }else {
            params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
        }
        //设置效果为背景透明.
        params.format = PixelFormat.RGBA_8888;
        //设置flags.不可聚焦及不可使用按钮对悬浮窗进行操控.
        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

        //设置窗口初始停靠位置.
        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.x = 0;
        params.y = 0;

        //设置悬浮窗口长宽数据.
        params.width = 300;
        params.height = 300;

        LayoutInflater inflater = LayoutInflater.from(getApplication());
        //获取浮动窗口视图所在布局.
        toucherLayout = (ConstraintLayout) inflater.inflate(R.layout.toucherlayout,null);
        //添加toucherlayout
        windowManager.addView(toucherLayout,params);

        Log.i(TAG,"toucherlayout-->left:" + toucherLayout.getLeft());
        Log.i(TAG,"toucherlayout-->right:" + toucherLayout.getRight());
        Log.i(TAG,"toucherlayout-->top:" + toucherLayout.getTop());
        Log.i(TAG,"toucherlayout-->bottom:" + toucherLayout.getBottom());

        //主动计算出当前View的宽高信息.
        toucherLayout.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED);

        //用于检测状态栏高度.
        int resourceId = getResources().getIdentifier("status_bar_height","dimen","android");
        if (resourceId > 0)
        {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        Log.i(TAG,"状态栏高度为:" + statusBarHeight);

        //浮动窗口按钮.
        imageButton1 = (ImageButton) toucherLayout.findViewById(R.id.imageButton1);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            long[] hints = new long[2];
            @Override
            public void onClick(View v) {
                Log.i(TAG,"点击了");
                System.arraycopy(hints,1,hints,0,hints.length -1);
                hints[hints.length -1] = SystemClock.uptimeMillis();
                if (SystemClock.uptimeMillis() - hints[0] >= 700)
                {
                    Log.i(TAG,"要执行");
//                    Toast.makeText(MainServi ce.this,"连续点击两次以退出",Toast.LENGTH_SHORT).show();
                }else
                {
                    Log.i(TAG,"即将关闭");
//                    stopSelf();
                }
            }
        });

        final int finalStatusBarHeight = statusBarHeight;
        imageButton1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                params.x = (int) event.getRawX() - 150;
                params.y = (int) event.getRawY() - 150 - finalStatusBarHeight;
                windowManager.updateViewLayout(toucherLayout,params);
                return false;
            }
        });
    }

    private FloatViewParams initFloatViewParams(Context mContext) {
        FloatViewParams params = new FloatViewParams();
        int screenWidth = SystemUtils.getScreenWidth(mContext);
        int screenHeight = SystemUtils.getScreenHeight(mContext, false);
        int statusBarHeight = SystemUtils.getStatusBarHeight(mContext);
        //根据实际宽高和设计稿尺寸比例适应。
        int marginBottom = SystemUtils.dip2px(mContext, 150);
//        if (float_window_type == FW_TYPE_ROOT_VIEW) {
//            marginBottom += statusBarHeight;
//        }
        //设置窗口大小，已view、视频大小做调整
        int winWidth = LastWindowInfo.getInstance().getWidth();
        int winHeight = LastWindowInfo.getInstance().getHeight();
        int margin = SystemUtils.dip2px(mContext, 15);
        int width = 0;
        if (winWidth <= winHeight) {
            //竖屏比例
            width = (int) (screenWidth * 1.0f * 1 / 3) + margin;
        } else {//横屏比例
            width = (int) (screenWidth * 1.0f / 2) + margin;
        }
        float ratio = 1.0f * winHeight / winWidth;
        int height = (int) (width * ratio);

        //如果上次的位置不为null，则用上次的位置
//        FloatViewParams lastParams = livePlayerWrapper.getLastParams();
//        if (lastParams != null) {
//            params.width = lastParams.width;
//            params.height = lastParams.height;
//            params.x = lastParams.x;
//            params.y = lastParams.y;
//            params.contentWidth = lastParams.contentWidth;
//        } else {
            params.width = width;
            params.height = height;
            params.x = screenWidth - width;
            params.y = screenHeight - height - marginBottom;
            params.contentWidth = width;
//        }

        params.screenWidth = screenWidth;
        params.screenHeight = screenHeight;
//        if (float_window_type == FW_TYPE_ROOT_VIEW) {
//            params.screenHeight = screenHeight - statusBarHeight;// - actionBarHeight;
//        }
        params.videoViewMargin = margin;
        params.mMaxWidth = screenWidth / 2 + margin;
        params.mMinWidth = width;
        params.mRatio = ratio;
        return params;
    }
    private IFloatView floatView;
    private WindowManager windowManager;
    private FloatViewParams floatViewParams;
    private int float_window_type = 0;
    public static final int FW_TYPE_APP_DIALOG = 11;
    public static final int FW_TYPE_ALERT_WINDOW = 12;


    private void wm() {
        initFloatViewParams(this);
        windowManager = SystemUtils.getWindowManager(this);
        WindowManager.LayoutParams wmParams = new WindowManager.LayoutParams();
        wmParams.packageName = this.getPackageName();
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_SCALED
                | WindowManager.LayoutParams.FLAG_LAYOUT_INSET_DECOR
                | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

        if (float_window_type == FW_TYPE_APP_DIALOG) {
            //这个一定要activity running
            //wmParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG;//TYPE_TOAST
            //TYPE_TOAST targetSDK必须小于26
            wmParams.type = WindowManager.LayoutParams.TYPE_TOAST;
        } else if (float_window_type == FW_TYPE_ALERT_WINDOW) {
            //需要权限
            if (Build.VERSION.SDK_INT >= 26) {
                wmParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            }else {
                wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
            }
        }
        wmParams.format = PixelFormat.RGBA_8888;
        wmParams.gravity = Gravity.START | Gravity.TOP;

        wmParams.width = floatViewParams.width;
        wmParams.height = floatViewParams.height;
        wmParams.x = floatViewParams.x;
        wmParams.y = floatViewParams.y;

        floatView = new FloatWindowView(this, floatViewParams, wmParams);
        try {
            windowManager.addView((View) floatView, wmParams);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ((FloatWindowView) floatView).setWindowType(float_window_type);
    }
}
