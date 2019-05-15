package com.demo.android_ds.ui;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.demo.android_ds.R;
import com.demo.android_ds.ui.fragment.ItemFragment1;
import com.demo.android_ds.ui.fragment.ItemFragment2;
import com.demo.android_ds.ui.fragment.ItemFragment3;
import com.tencent.bugly.beta.Beta;

import java.lang.reflect.Method;

/**
 *
 * check 授权成功
 * https://www.jianshu.com/p/de991ce4be8d
 *
 * https://blog.csdn.net/life_s/article/details/80989579
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title_tv, tv1, tv2, tv3;
    private FrameLayout fl;
    private Fragment item_fragment1, item_fragment2, item_fragment3;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private int mCheckId;

    int CHECKPRESSMISSON_CODE=133;

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//
//        return false;
//    }

    private boolean checkFloatPermission(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {//6.0以上
            boolean result = false;
            try {
                Class clazz = Settings.class;
                Method canDrawOverlays = clazz.getDeclaredMethod("canDrawOverlays", Context.class);
                result = (boolean) canDrawOverlays.invoke(null, context);
//                Log.e(TAG, "checkFloatPermission:-->" + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4-5.1
            return getAppOps(context);
        } else {//4.4以下
            return true;
        }
    }

    private static boolean getAppOps(Context context) {
        try {
            Object object = context.getSystemService(context.APP_OPS_SERVICE);
            if (object == null) {
                return false;
            }
            Class localClass = object.getClass();
            Class[] arrayOfClass = new Class[3];
            arrayOfClass[0] = Integer.TYPE;
            arrayOfClass[1] = Integer.TYPE;
            arrayOfClass[2] = String.class;
            Method method = localClass.getMethod("checkOp", arrayOfClass);
            if (method == null) {
                return false;
            }
            Object[] arrayOfObject1 = new Object[3];
            arrayOfObject1[0] = Integer.valueOf(24);
            arrayOfObject1[1] = Integer.valueOf(Binder.getCallingUid());
            arrayOfObject1[2] = context.getPackageName();
            int m = ((Integer) method.invoke(object, arrayOfObject1)).intValue();
            return m == AppOpsManager.MODE_ALLOWED;
        } catch (Exception e) {
//            Log.e(TAG, "permissions judge: -->" + e.toString());
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Beta.checkUpgrade();//检查版本号
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        AActivity.check(MainActivity.this);
        setContentView(R.layout.activity_main);
//        HttpUtil.getAAA();
        Beta.checkUpgrade();//检查版本号
        initView();
        item_fragment1 = ItemFragment1.newInstance();
        item_fragment2 = ItemFragment2.newInstance();
        item_fragment3 = ItemFragment3.newInstance();

//        tv1.setBackground(getResources().getDrawable(R.drawable.circle_yellow));
//        fm = getSupportFragmentManager();
//        ft = fm.beginTransaction();
//        ft.replace(R.id.fl, item_fragment1);
//        ft.commit();
        mCheckId = R.id.tv1;
        addFragment(mCheckId);
        mFragmentText = createFragment(mCheckId);
        clearColor();
        tv1.setBackground(getResources().getDrawable(R.drawable.circle_yellow));
        tv1.setTextColor(Color.WHITE);

//        if (Build.VERSION.SDK_INT >= 23) {//6.0以上
//            Toast.makeText(this, "允许下悬浮窗权限", Toast.LENGTH_SHORT).show();
//            try{
//                Intent intent=new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
//                startActivityForResult(intent, CHECKPRESSMISSON_CODE);
//            }catch (Exception e)
//            {
//                e.printStackTrace();
//            }
//        }

    }

    private void initView() {
        title_tv = findViewById(R.id.title_tv);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        fl = findViewById(R.id.fl);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);

        title_tv.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHECKPRESSMISSON_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
//                    Log.e(TAG, "已经打开悬浮窗权限");
                    //进行下一步逻辑处理
                } else {
                    //提示用户需要开启
                }
            }
        }

    }

    @Override
    public void onClick(View view) {

//        fm = getSupportFragmentManager();
//        ft = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.tv1:
                mCheckId = view.getId();
                addFragment(mCheckId);
                mFragmentText = createFragment(mCheckId);
//                ft.replace(R.id.fl, item_fragment1);
                clearColor();
                tv1.setBackground(getResources().getDrawable(R.drawable.circle_yellow));
                tv1.setTextColor(Color.WHITE);
                break;
            case R.id.tv2:
                mCheckId = view.getId();
                addFragment(mCheckId);
                mFragmentText = createFragment(mCheckId);
//                ft.replace(R.id.fl, item_fragment2);
                clearColor();
                tv2.setBackground(getResources().getDrawable(R.drawable.circle_yellow));
                tv2.setTextColor(Color.WHITE);
                break;
            case R.id.tv3:
                mCheckId = view.getId();
                addFragment(mCheckId);
                mFragmentText = createFragment(mCheckId);
//                ft.replace(R.id.fl, item_fragment3);
                clearColor();
                tv3.setBackground(getResources().getDrawable(R.drawable.circle_yellow));
                tv3.setTextColor(Color.WHITE);
                break;
            case R.id.title_tv:
//                startService(new Intent(MainActivity.this, FloatWindowService2.class));
//                mFloatWindow = DraggableFloatWindow.getDraggableFloatWindow(MainActivity.this, null);
//                mFloatWindow.show();
//                mFloatWindow.setOnTouchButtonListener(new DraggableFloatView.OnTouchButtonClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, "这是click事件，你在这里可以做你想做的事情", Toast.LENGTH_SHORT).show();
//                    }
//                });
                break;
        }
//        ft.commit();
    }

    private void clearColor() {
        tv1.setBackground(getResources().getDrawable(R.drawable.circle_white));
        tv2.setBackground(getResources().getDrawable(R.drawable.circle_white));
        tv3.setBackground(getResources().getDrawable(R.drawable.circle_white));
        tv1.setTextColor(Color.BLACK);
        tv2.setTextColor(Color.BLACK);
        tv3.setTextColor(Color.BLACK);
    }

    private void addFragment(int checkId) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //如果前一个fragment实例不为空
        if (mFragmentText != null){
            if(createFragment(checkId).isAdded()) {
                transaction.hide(mFragmentText)
                        .show(createFragment(checkId))
                        .commit();
            } else {
                transaction.hide(mFragmentText)
                        .add(R.id.fl,createFragment(checkId))
                        .commit();
            }
        } else {
            transaction.add(R.id.fl,createFragment(checkId))
                    .commit();
        }
    }

    Fragment fragment = null;
    Fragment mFragmentText=null;

    private Fragment createFragment(int checkId) {
        switch (checkId) {
            case R.id.tv1:
                fragment = item_fragment1;
                break;
            case R.id.tv2:
                fragment = item_fragment2;
                break;
            case R.id.tv3:
                fragment = item_fragment3;
                break;
            default:
                fragment = item_fragment1;

        }
        return fragment;
    }


}
