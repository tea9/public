package com.demo.dingsheng2.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.demo.dingsheng2.R;

/**
 * created by tea9 at 2018/12/6
 */
public class ItemFragment2 extends Fragment {

    private TextView tv;

    private static ItemFragment2 fragment;

    public static ItemFragment2 newInstance() {
        if (null==fragment){
            fragment = new ItemFragment2();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item2,container,false);
        tv = view.findViewById(R.id.tv);
        String text = getResources().getString(R.string.instructions);
        tv.setText(Html.fromHtml(text));
        return view;
    }
}
