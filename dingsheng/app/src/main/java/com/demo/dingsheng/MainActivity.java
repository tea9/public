package com.demo.dingsheng;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.demo.dingsheng.fragment.ItemFragment1;
import com.demo.dingsheng.fragment.ItemFragment2;
import com.demo.dingsheng.fragment.ItemFragment3;

/**
 * created by tea9 at 2018/12/6
 * check 授权成功
 * https://www.jianshu.com/p/de991ce4be8d
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView title_tv, tv1, tv2, tv3;
    private FrameLayout fl;
    private Fragment item_fragment1, item_fragment2, item_fragment3;

    private FragmentManager fm;
    private FragmentTransaction ft;

    private int mCheckId;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AActivity.check(MainActivity.this);
        setContentView(R.layout.activity_main);
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
