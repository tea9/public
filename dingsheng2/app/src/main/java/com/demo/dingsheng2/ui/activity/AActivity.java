package com.demo.dingsheng2.ui.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.demo.dingsheng2.App;
import com.demo.dingsheng2.R;
import com.demo.dingsheng2.entity.MsgEntity;
import com.demo.dingsheng2.ui.MainActivity;
import com.demo.dingsheng2.util.*;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

/**
 * created by tea9 at 2018/12/19
 * 授权码页面
 */
public class AActivity extends AppCompatActivity {

    private EditText edit;
    private Button btn;

    public static void checkAuthorizationCode(String code, final Context context) {
        SharedPreferencesUtils.putInfo(context, Constant.AUTH_CODE, code); // 保存授权码
        HttpUtil.update(DeviceUtils.getUniqueId(context), code, new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String s = response.body();
                Log.e(Constant.TAG, "shaomiao" + s);
                //{"code":400,"data":null,"msg":"激活失败"}
                //{"code":200,"data":true,"msg":"success"}
                MsgEntity entity = GsonUtil.changeGsonToBean(s, MsgEntity.class);
                if (entity.getCode() == 200) {
                    Toast.makeText(App.mContext, "授权成功！", Toast.LENGTH_SHORT).show();
                    Log.e("shaomiaoactivity", getCurrentActivityName(context));
                    if (!getCurrentActivityName(context).equals("com.demo.dingsheng.MainActivity")) {
                        context.startActivity(new Intent(context, MainActivity.class));
                    }
                } else {
                    Toast.makeText(context, entity.getMsg(), Toast.LENGTH_SHORT).show();
                    Log.e("shaomiaoactivity", getCurrentActivityName(context));
                    if (!getCurrentActivityName(context).equals("com.demo.dingsheng.AActivity")) {
                        context.startActivity(new Intent(context, AActivity.class));
                    }
                }
            }
        });
    }

    public static String getCurrentActivityName(Context context) {
        ActivityManager am = (ActivityManager) context
                .getSystemService(Activity.ACTIVITY_SERVICE);

        List<ActivityManager.RunningTaskInfo> taskInfo = am.getRunningTasks(1);

        ComponentName componentInfo = taskInfo.get(0).topActivity;
        return componentInfo.getClassName();
    }


    public static void check(Context context) {
        String code = SharedPreferencesUtils.getPreferences(context).getString(Constant.AUTH_CODE, "");
        if (code != null && !code.equals(""))
            checkAuthorizationCode(code, context);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        check(AActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_a);
        edit = findViewById(R.id.edit);
        btn = findViewById(R.id.btn);
//        edit.setText("9baa14d0-08b1-4ee7-9c85-f4b397935540");
        edit.setText("f8a02139-6e28-4726-8e37-12901567701b");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 调用接口
                String edit_text = edit.getText().toString().trim();
                if (edit_text == null || edit_text.equals("")) {
                    Toast.makeText(AActivity.this, "授权码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.e(Constant.TAG, "设备码" + DeviceUtils.getUniqueId(AActivity.this));
                checkAuthorizationCode(edit_text, AActivity.this);
            }
        });
    }
}
