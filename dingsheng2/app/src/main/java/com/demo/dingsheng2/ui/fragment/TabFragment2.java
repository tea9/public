package com.demo.dingsheng2.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.demo.dingsheng2.R;
import com.demo.dingsheng2.ui.view.SmoothCheckBox;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.SharedPreferencesUtils;


/**
 * created by tea9 at 2018/12/6
 */
public class TabFragment2 extends Fragment {

    private SmoothCheckBox check1,check4,check5,check6,check7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);
        check1=view.findViewById(R.id.check1);
        check4= view.findViewById(R.id.check4);
        check5=view.findViewById(R.id.check5);
        check6 = view.findViewById(R.id.check6);
        check7 = view.findViewById(R.id.check7);


        check1.setChecked(SharedPreferencesUtils.getPreferences(getContext()).getBoolean(Constant.Checka.check1,true));
        check4.setChecked(SharedPreferencesUtils.getPreferences(getContext()).getBoolean(Constant.Checka.check4,true));
        check5.setChecked(SharedPreferencesUtils.getPreferences(getContext()).getBoolean(Constant.Checka.check5,true));
        check6.setChecked(SharedPreferencesUtils.getPreferences(getContext()).getBoolean(Constant.Checka.check6,true));
        check7.setChecked(SharedPreferencesUtils.getPreferences(getContext()).getBoolean(Constant.Checka.check7,true));

        check1.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
                SharedPreferencesUtils.putInfo(getContext(),Constant.Checka.check1,isChecked);
            }
        });

        check4.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
                SharedPreferencesUtils.putInfo(getContext(),Constant.Checka.check4,isChecked);
            }
        });

        check5.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
                SharedPreferencesUtils.putInfo(getContext(),Constant.Checka.check5,isChecked);
            }
        });

        check6.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
                SharedPreferencesUtils.putInfo(getContext(),Constant.Checka.check6,isChecked);
            }
        });

        check7.setOnCheckedChangeListener(new SmoothCheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SmoothCheckBox smoothCheckBox, boolean isChecked) {
                SharedPreferencesUtils.putInfo(getContext(),Constant.Checka.check7,isChecked);
            }
        });

        return view;
    }
}
