package com.demo.dingsheng.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.demo.dingsheng.R;
import com.demo.dingsheng.adapter.FmPagerAdapter;
import com.demo.dingsheng.entitiy.TabEntity;
import com.demo.dingsheng.timer.MainService;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.GsonUtil;
import com.demo.dingsheng.util.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * created by tea9 at 2018/12/6
 * https://www.jianshu.com/p/fde38f367019
 * 清理进程 数据丢失
 */
public class ItemFragment1 extends Fragment {

    private String TAG = "ITEMFragment1";

    private static ItemFragment1 fragment;
    private Context context;
    private ViewPager vp;
    private TabLayout tablayout;
    private Button btn;


    private View rootView;


    private static FmPagerAdapter pagerAdapter;
    private static ArrayList<Fragment> fragments = new ArrayList<>();
    private static String[] titles = new String[]{"要阅读的平台", "参数设置"};


    public static ItemFragment1 newInstance() {
        if (null == fragment) {
            fragment = new ItemFragment1();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        Log.e(TAG, "onCreateView"+rootView);
        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_item1, null);
            context = rootView.getContext();
            vp = rootView.findViewById(R.id.vp);
            tablayout = rootView.findViewById(R.id.tablayout);
            btn = rootView.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // TODO 别忘开启功能 启动功能
//                    Intent z = new Intent(context,PollingService.class);
//                    context.startService(z);
//                    Intent z = new Intent(context, AutoService.class);
//                    context.startService(z);

                    //存数据
                    List<TabEntity> beforelist = TabFragment1.list.subList(0, 6);
                    List<TabEntity> afterlist = TabFragment1.list.subList(7, TabFragment1.list.size());

//                    for (TabEntity tab: beforelist) {
//                        Log.e(Constant.TAG,tab.check+"："+tab.flag_enum+"："+tab.text);
//                    }
//
//                    for (TabEntity tab2:afterlist) {
//                        Log.e(Constant.TAG,tab2.check+"："+tab2.flag_enum+"："+tab2.text);
//                    }

                    SharedPreferencesUtils.putInfo(context, Constant.BEFORE_TEXT, GsonUtil.createGsonString(beforelist));
                    SharedPreferencesUtils.putInfo(context, Constant.AFTER_TEXT, GsonUtil.createGsonString(afterlist));
                    SharedPreferencesUtils.putInfo(context, Constant.ALL_TEXT, GsonUtil.createGsonString(TabFragment1.list));

//                    context.startService(new Intent(context, TimingService.class));

                    context.startService(new Intent(context,MainService.class));
                }
            });
        }
        init();
        return rootView;
    }


    private void init() {
        Log.e(TAG, "init");
        fragments.clear();
//        tablayout.removeAllTabs();
        fragments.add(TabFragment1.newInstance());
        fragments.add(new TabFragment2());

        tablayout.addTab(tablayout.newTab());
        tablayout.addTab(tablayout.newTab());
        tablayout.setupWithViewPager(vp, false);
        pagerAdapter = new FmPagerAdapter(fragments,getFragmentManager());
        vp.setAdapter(pagerAdapter);

        for (int i = 0; i < titles.length; i++) {
            tablayout.getTabAt(i).setText(titles[i]);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onActivityCreated");
    }

//    onSaveInstanceState onRestoreInstanceState


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "tabfragment onSaveInstanceState");
        outState.putBoolean("flag", true);

    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(TAG, "tabfragment onViewStateRestored");
        if (savedInstanceState != null) {
            Log.e(TAG, "tabfragment onViewStateRestored not null");
            boolean flag = savedInstanceState.getBoolean("flag", false);
            Log.e(TAG, "tabfragment onViewStateRestored flag"+flag);
            try {
                if (flag) {
                    init();
                }
            } catch (Exception e) {
            }
        }
    }

}
