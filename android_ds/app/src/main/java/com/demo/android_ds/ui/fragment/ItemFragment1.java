package com.demo.android_ds.ui.fragment;

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
import android.widget.EditText;
import android.widget.Toast;

import com.demo.android_ds.App;
import com.demo.android_ds.R;
import com.demo.android_ds.entity.MsgEntity;
import com.demo.android_ds.entity.TabEntity;
import com.demo.android_ds.service.AllService;
import com.demo.android_ds.ui.adapter.FmPagerAdapter;
import com.demo.android_ds.util.Constant;
import com.demo.android_ds.util.DeviceUtils;
import com.demo.android_ds.util.GsonUtil;
import com.demo.android_ds.util.HttpUtil;
import com.demo.android_ds.util.MyThreadPool;
import com.demo.android_ds.util.SharedPreferencesUtils;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * https://www.jianshu.com/p/fde38f367019
 * 清理进程 数据丢失
 *
 */
public class ItemFragment1 extends Fragment {

    private boolean ver_code_flag = false;

    private String TAG = "ITEMFragment1";

    private static ItemFragment1 fragment;
    private Context context;
    private ViewPager vp;
    private TabLayout tablayout;
    private Button btn;
    private EditText edit;
    private Button ver_btn;


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
        Log.e(TAG, "onCreateView" + rootView);
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
            edit = rootView.findViewById(R.id.edit);
            ver_btn = rootView.findViewById(R.id.ver_btn);

            //  添加验证码
            String code = SharedPreferencesUtils.getPreferences(context).getString(Constant.AUTH_CODE, "");
            if (code != null && !code.equals(""))
                edit.setText(code);

            // 启动功能
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    startbtn();
                    checkVerCode();
                }
            });
            ver_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    check();
                    checkVerCode();
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
        pagerAdapter = new FmPagerAdapter(fragments, getFragmentManager());
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
            Log.e(TAG, "tabfragment onViewStateRestored flag" + flag);
            try {
                if (flag) {
                    init();
                }
            } catch (Exception e) {
            }
        }
    }

//    private void check() {
//        String edit_text = edit.getText().toString().trim();
//        if (edit_text == null || edit_text.equals("")) {
//            Toast.makeText(getContext(), "授权码不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        Log.e(Constant.TAG, "设备码" + DeviceUtils.getUniqueId(getContext()));
//
////        String code = DeviceUtils.getUniqueId(getContext());
//
////        edit_text="0ab6857c-a6e4-40c4-8bd2-4a4199b82dd0";
//        Log.e(Constant.TAG, "edit_text" +edit_text);
//        HttpUtil.update(DeviceUtils.getUniqueId(context), edit_text, new StringCallback() {
//            @Override
//            public void onSuccess(Response<String> response) {
//                Toast.makeText(App.mContext, "调用成功！", Toast.LENGTH_SHORT).show();
//                String s = response.body();

//                //{"code":400,"data":null,"msg":"激活失败"}
//                //{"code":200,"data":true,"msg":"success"}
//                MsgEntity entity = GsonUtil.changeGsonToBean(s, MsgEntity.class);
//                if (entity.getCode() == 200) {
//                    Toast.makeText(App.mContext, "授权成功！", Toast.LENGTH_SHORT).show();
//                    ver_code_flag = true;
//                    SharedPreferencesUtils.putInfo(context, Constant.AUTH_CHECK, ver_code_flag); // 保存授权码
//
//                } else {
//                    Toast.makeText(context, "授权失败了！", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(context, entity.getMsg(), Toast.LENGTH_SHORT).show();
//                    ver_code_flag = false;
//                    SharedPreferencesUtils.putInfo(context, Constant.AUTH_CHECK, ver_code_flag); // 保存授权码
//                }
//            }
//        });
//    }

    // 验证验证码
    private void checkVerCode() {
        String edit_text = edit.getText().toString().trim();
        if (edit_text == null || edit_text.equals("")) {
            Toast.makeText(getContext(), "授权码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.e(Constant.TAG, "设备码" + DeviceUtils.getUniqueId(getContext()));

//        String code = DeviceUtils.getUniqueId(getContext());
        SharedPreferencesUtils.putInfo(context, Constant.AUTH_CODE, edit_text); // 保存授权码
//        edit_text="86e19bd5-4fb8-46d6-9865-84f24f18086a";
//        edit_text="4d54e818-2f50-4332-bc84-3faaf815cb3d";
        Log.e(Constant.TAG, "edit_text" +edit_text);
        HttpUtil.update(DeviceUtils.getUniqueId(context), edit_text, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                Toast.makeText(App.mContext, "调用成功！", Toast.LENGTH_SHORT).show();
                String s = response.body();
                //{"code":400,"data":null,"msg":"激活失败"}
                //{"code":200,"data":true,"msg":"success"}
                MsgEntity entity = GsonUtil.changeGsonToBean(s, MsgEntity.class);
                if (entity.getCode() == 200) {
                    Toast.makeText(App.mContext, "授权成功！", Toast.LENGTH_SHORT).show();
                    ver_code_flag = true;
                    startbtn();

                } else {
                    Toast.makeText(context, "授权失败了！", Toast.LENGTH_SHORT).show();
                    Toast.makeText(context, entity.getMsg(), Toast.LENGTH_SHORT).show();
                    ver_code_flag = false;
                }
            }
        });
    }

    private void startbtn() {
        SharedPreferencesUtils.putInfo(context, Constant.AUTH_CHECK, true); // 保存授权码
         if(SharedPreferencesUtils.getPreferences(context).getBoolean(Constant.AUTH_CHECK,false)) {
             // TODO 别忘开启功能 启动功能
//                    Intent z = new Intent(context,PollingService.class);
//                    context.startService(z);
//                    Intent z = new Intent(context, AutoService.class);
//                    context.startService(z);

             //存数据 之前是8 因为2345不运行 改成了9
             List<TabEntity> beforelist = TabFragment1.list.subList(0, 9);//多加了一个

             List<TabEntity> afterlist = TabFragment1.list.subList(9, TabFragment1.list.size());


             List<TabEntity> before_check_list = new ArrayList<>();
             List<TabEntity> after_check_list = new ArrayList<>();

             // 保存check的
             for (TabEntity tab : beforelist) {
                 if (tab.check) {
                     before_check_list.add(tab);
                 }
             }

             for (TabEntity tab2 : afterlist) {
                 if (tab2.check) {
                     after_check_list.add(tab2);
                 }
             }

//             for (TabEntity tab : before_check_list) {
//                 Log.e(Constant.TAG, "before_check_list" + tab.check + "：" + tab.flag_enum + "：" + tab.text);
//             }
//
//             for (TabEntity tab : after_check_list) {
//                 Log.e(Constant.TAG, "after_check_list" + tab.check + "：" + tab.flag_enum + "：" + tab.text);
//             }


             SharedPreferencesUtils.putInfo(context, Constant.BEFORE_TEXT, GsonUtil.createGsonString(before_check_list));
             SharedPreferencesUtils.putInfo(context, Constant.AFTER_TEXT, GsonUtil.createGsonString(after_check_list));
             SharedPreferencesUtils.putInfo(context, Constant.ALL_TEXT, GsonUtil.createGsonString(TabFragment1.list));

             context.startService(new Intent(context, AllService.class));
             MyThreadPool.stop();
         }
    }

}
