package com.demo.dingsheng.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.demo.dingsheng.App;
import com.demo.dingsheng.R;
import com.demo.dingsheng.service.PollingService;
import com.yw.game.floatmenu.customfloat.BaseFloatDailog;

/**
 * Created by wengyiming on 2017/9/13.
 * 这个是
 */

public class MyFloatDialog extends BaseFloatDailog {


    public MyFloatDialog(Context context) {
        super(context);

    }

    @Override
    protected View getLeftView(LayoutInflater inflater, View.OnTouchListener touchListener) {
        if (getContext() != null) {
            Toast.makeText(getContext(), "haha", Toast.LENGTH_SHORT).show();
        }
        final View view = inflater.inflate(R.layout.layout_menu_left, null);
        ImageView leftLogo = (ImageView) view.findViewById(R.id.logo);
        TextView left_tv = view.findViewById(R.id.tv);
        left_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Toast.makeText(getContext(), "左边的菜单被打开了", Toast.LENGTH_SHORT).show();
//                click();

            }
        });
        leftLogo.setOnTouchListener(touchListener);
        return view;
    }

    @Override
    protected View getRightView(LayoutInflater inflater, View.OnTouchListener touchListener) {
        final View view = inflater.inflate(R.layout.layout_menu_right, null);
        ImageView rightLogo = (ImageView) view.findViewById(R.id.logo);
        TextView right_tv = view.findViewById(R.id.tv);
        right_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Toast.makeText(getContext(), "右边的菜单被打开了", Toast.LENGTH_SHORT).show();
//                click();

            }
        });
        rightLogo.setOnTouchListener(touchListener);
        return view;
    }

    @Override
    protected View getLogoView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.layout_menu_logo, null);
    }

    @Override
    protected void resetLogoViewSize(int hintLocation, View logoView) {
        logoView.clearAnimation();
        logoView.setTranslationX(0);
        logoView.setScaleX(1);
        logoView.setScaleY(1);
    }

    @Override
    protected void dragingLogoViewOffset(View logoView, boolean isDraging, boolean isResetPosition, float offset) {
        if (isDraging && offset > 0) {
            logoView.setBackgroundDrawable(null);
            logoView.setScaleX(1 + offset);
            logoView.setScaleY(1 + offset);
        } else {
            logoView.setBackgroundResource(R.drawable.yw_game_float_menu_bg);
            logoView.setTranslationX(0);
            logoView.setScaleX(1);
            logoView.setScaleY(1);
        }


        if (isResetPosition) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                logoView.setRotation(offset * 360);
            }
        } else {
            logoView.setRotation(offset * 360);
        }
    }

    @Override
    public void shrinkLeftLogoView(View smallView) {
        smallView.setTranslationX(-smallView.getWidth() / 3);
    }

    @Override
    public void shrinkRightLogoView(View smallView) {
        smallView.setTranslationX(smallView.getWidth() / 3);
    }

    @Override
    public void leftViewOpened(View leftView) {
//        Toast.makeText(getContext(), "左边的菜单被打开了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void rightViewOpened(View rightView) {
//        Toast.makeText(getContext(), "右边的菜单被打开了", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void leftOrRightViewClosed(View smallView) {
//        Toast.makeText(getContext(), "菜单被关闭了", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestoryed() {
        if(isApplictionDialog()){
            if(getContext() instanceof Activity){
                dismiss();
            }
        }
    }

    private void click() {
        PollingUtils.startPollingService(App.mContext, 12*60*60, PollingService.class, PollingService.ACTION);
    }


}
