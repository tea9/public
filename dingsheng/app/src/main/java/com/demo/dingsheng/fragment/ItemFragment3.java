package com.demo.dingsheng.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import com.demo.dingsheng.R;

/**
 * created by tea9 at 2018/12/6
 */
public class ItemFragment3 extends Fragment {

    private Switch switch1,switch2,switch3,switch4,switch5;

    private static ItemFragment3 fragment;

    public static ItemFragment3 newInstance() {
        if (null==fragment){
            fragment = new ItemFragment3();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item3,container,false);
        switch1 = view.findViewById(R.id.switch1);
        switch2 = view.findViewById(R.id.switch2);
        switch3 = view.findViewById(R.id.switch3);
        switch4 = view.findViewById(R.id.switch4);
        switch5 = view.findViewById(R.id.switch5);


        return view;
    }
}
