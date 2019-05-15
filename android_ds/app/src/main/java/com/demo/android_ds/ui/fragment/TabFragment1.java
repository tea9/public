package com.demo.android_ds.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.demo.android_ds.R;
import com.demo.android_ds.entity.TabEntity;
import com.demo.android_ds.ui.view.SmoothCheckBox;
import com.demo.android_ds.util.Constant;
import com.demo.android_ds.util.GsonUtil;
import com.demo.android_ds.util.SharedPreferencesUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 这里是打对勾的
 * Fragment的状态保存和恢复
 * https://blog.csdn.net/zephyr_g/article/details/53516568
 */
public class TabFragment1 extends Fragment {

    private String TAG="TabFragment1";

    private static TabFragment1 fragment;

    public static TabFragment1 newInstance() {
        if (null==fragment){
            fragment = new TabFragment1();
        }
        return fragment;
    }

    private String line="----------------------------------------------------------------";

    private View rootView;
    private Context context;
    private RecyclerView rv;
    public static List<TabEntity> list = new ArrayList<>();
//    private TabEntity[] group = {new TabEntity("东方头条",Constant.ENUM.DONGFANGTOUTIAO)
//            ,new TabEntity("中青看点")
//            ,"中青看点","趣头条","蚂蚁头条","头条多多","2345浏览器","微鲤看看","韭菜头条","红包头条","聚合头条","大众看点","聚看点","掌上头条","点点新闻","闪电看看","薪头条"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");

        if (null != rootView) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (null != parent) {
                parent.removeView(rootView);
            }
        } else {
            rootView = inflater.inflate(R.layout.fragment_tab1, null);
            context = rootView.getContext();
            rv = rootView.findViewById(R.id.rv);
            initData();
            initRecyclerView();
        }
        return rootView;
    }



    private void initData() {
        String str = SharedPreferencesUtils.getPreferences(context).getString(Constant.ALL_TEXT,"");
        if (!str.equals("")) {
            List<TabEntity> data= GsonUtil.changeGsonToList(str,TabEntity.class);
            list.addAll(data);
        } else {
            for (int i = 0; i < Constant.data_group.length; i++) {
                list.add(Constant.data_group[i]);
            }
            list.add(9, new TabEntity(line));
        }
    }

    private void initRecyclerView() {
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(new BaseQuickAdapter(R.layout.item_tab1,list) {
            @Override
            protected void convert(BaseViewHolder helper, Object item) {

            }

            @Override
            public void onBindViewHolder(BaseViewHolder helper, final int position) {
                TabEntity item = list.get(position);
                if (item.text.equals(line)) {
                    helper.getView(R.id.xx).setVisibility(View.GONE);
                    helper.getView(R.id.text).setVisibility(View.GONE);
                } else {
                    helper.getView(R.id.xx).setVisibility(View.VISIBLE);
                    helper.getView(R.id.text).setVisibility(View.VISIBLE);
                }

                helper.setText(R.id.tv,item.text);
                SmoothCheckBox checkBox = helper.getView(R.id.xx);
                checkBox.setChecked2(item.check);

                checkBox.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
                        Log.e(Constant.TAG,"ischecked"+isChecked);
                        list.get(position).check = isChecked;
                    }
                });
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy"+list.size());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"onDestroyView"+list.size());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onResume"+list.size());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG,"onActivityCreated"+list.size());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"onActivityCreated"+list.size());
    }

//    onSaveInstanceState onRestoreInstanceState


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG,"tabfragment onSaveInstanceState"+list.size());
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(TAG,"tabfragment onViewStateRestored"+list.size());
    }
}
