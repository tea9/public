package com.demo.dingsheng2.asynctask;

import android.os.AsyncTask;
import android.util.Log;
import com.demo.dingsheng2.App;
import com.demo.dingsheng2.entity.TabEntity;
import com.demo.dingsheng2.task.*;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.GsonUtil;
import com.demo.dingsheng2.util.SharedPreferencesUtils;
import com.demo.dingsheng2.util.TimeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by tea9 at 2019/1/10
 * 判断广告
 * 无响应判断
 * <p>
 * 2345浏览器签到
 * 头条多多 签到领红包
 * <p>
 * <p>
 * ----
 * 蚂蚁头条 黑屏
 * <p>
 * 红包头条 广告
 * <p>
 * 聚合头条 滑动文章金币
 * <p>
 * 译文：Android中糟糕的AsyncTask
 * https://blog.csdn.net/u011484134/article/details/49515289
 * <p>
 * 详解AsyncTask的cancel的有效用法，强制停止AsyncTask异步任务
 * https://blog.csdn.net/qq_29623203/article/details/51142336
 * <p>
 * 为什么Android的AsyncTask不适合执行长时间操作的任务
 * https://blog.csdn.net/xuwenwen_2013/article/details/81808435
 * <p>
 * 凌晨12点到7点 20分钟
 */
public class AllAsyncTask extends AsyncTask<String, Integer, String> {

    static volatile boolean flag = true;

    private List<TabEntity> first_list;
    private List<TabEntity> second_list;

    // 方法1：onPreExecute（）
    // 作用：执行 线程任务前的操作
    @Override
    protected void onPreExecute() {
//        flag =true;
//            text.setText("加载中");
        // 执行前显示提示
        Log.e("shaomiao", "onPreExecute" + Thread.currentThread().getName());
        Log.e("shaomiao", "onPreExecute" + this.isCancelled() + "flag:" + flag);
    }


    // 方法2：doInBackground（）
    // 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
    // 此处通过计算从而模拟“加载进度”的情况
    @Override
    protected String doInBackground(String... params) {

        init();

        Log.e(Constant.TAG, "doinbackgrouddoinbackgrouddoinbackgroud" + this.isCancelled());
//        if (isCancelled()) {
//            return null;
//        }
        int stop_flag = SharedPreferencesUtils.getPreferences(App.mContext).getInt(Constant.STOP_FLAG, 0);
        try {
            while (flag) {
//                if (isCancelled()) {
//                    break;
//                }
                for (int i = 0; i < Constant.BEFORE_TASK_COUNT; i++) {
//                    if (isCancelled()) {
//                        break;
//                    }
                    int count = 0;
                    while (count < first_list.size()) {
//                        if (isCancelled()) {
//                            break;
//                        }
                        TabEntity tabEntity = first_list.get(count);
                        SharedPreferencesUtils.putInfo(App.mContext, Constant.STOP_FLAG, tabEntity.flag_enum);
//                        tabEntity.flag_enum = Constant.ENUM.QUTOUTIAO;
                        if (tabEntity.flag_enum == Constant.ENUM.HUITOUTIAO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "000000000" + Thread.currentThread().getName());
                            Log.e("shaomiao", "HuiToutiaoTask" + Thread.currentThread().getName());
                            HuiToutiaoTask huiToutiaoTask = new HuiToutiaoTask();
                            huiToutiaoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.JUHETOUTIAO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "444444");
                            Log.e("shaomiao", "JuhetoutiaoTask" + Thread.currentThread().getName());
                            //判断时间
                            String format1 = "HH:mm:ss";
                            Date startTime1 = new SimpleDateFormat(format1).parse("00:00:00");
                            Date endTime1 = new SimpleDateFormat(format1).parse("07:00:00");
                            if (!TimeUtil.isEffectiveDate(new Date(), startTime1, endTime1)) {
                                JuhetoutiaoTask.start();
                            }

//                        } else if (tabEntity.flag_enum==Constant.ENUM.XINTOUTIAO) {
//                            Thread.sleep(1000);
//                            Log.e("shaomiao", "1111");
//                            Log.e("shaomiao", "XintoutiaoTask" + Thread.currentThread().getName());
//                            XintoutiaoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.ZHONGQINGKANDIAN) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "22222");
                            Log.e("shaomiao", "ZhongqingkandianTask" + Thread.currentThread().getName());
                            ZhongqingkandianTask.start();

                        } else if (tabEntity.flag_enum == Constant.ENUM.QUTOUTIAO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "333333");
                            Log.e("shaomiao", "QutoutiaoTask" + Thread.currentThread().getName());
                            QutoutiaoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.MAYITOUTIAO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "444444");
                            Log.e("shaomiao", "MayitoutiaoTask" + Thread.currentThread().getName());
                            MayitoutiaoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.TOUTIAODUODUO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "5555555");
                            Log.e("shaomiao", "ToutiaoduoduoTask" + Thread.currentThread().getName());
                            ToutiaoduoduoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.BROWER2345) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "66666666" + Thread.currentThread().getName());
                            Log.e("shaomiao", "Brower2345Task" + Thread.currentThread().getName());
                            Brower2345Task.start();
                        } else {
                            Log.e("shaomiao", "else else else" + count);
//                    count=0;
                        }
                        count += 1;
                        Log.e("shaomiao", "doInBackground  countcountcount" + this.isCancelled() + ":" + Thread.currentThread().getName());
//
                    }

                }
                for (int k = 0; k < Constant.AFTER_TASK_COUNT; k++) {
//                    if (isCancelled()) {
//                        break;
//                    }
                    int count = 0;
                    while (count < second_list.size()) {
//                        if (this.isCancelled()) {
//                            break;
//                        }
                        TabEntity tabEntity = second_list.get(count);
                        SharedPreferencesUtils.putInfo(App.mContext, Constant.STOP_FLAG, tabEntity.flag_enum);
//                        tabEntity.flag_enum = Constant.ENUM.SHANDIANKANKAN;
                        if (tabEntity.flag_enum == Constant.ENUM.WEILIKANKAN) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "1111");
                            Log.e("shaomiao", "WeilikankanTask" + Thread.currentThread().getName());
                            WeilikankanTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.JIUCAITOUTIAO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "22222");
                            Log.e("shaomiao", "JiucaitoutiaoTask" + Thread.currentThread().getName());
                            JiucaitoutiaoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.HONGBAOTOUTIAO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "333333");
                            Log.e("shaomiao", "HongbaotoutiaoTask" + Thread.currentThread().getName());
                            HongbaotoutiaoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.XINTOUTIAO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "1111");
                            Log.e("shaomiao", "XintoutiaoTask" + Thread.currentThread().getName());
                            XintoutiaoTask.start();
//                        } else if (tabEntity.flag_enum==Constant.ENUM.JUHETOUTIAO) {
//                            Thread.sleep(1000);
//                            Log.e("shaomiao", "444444");
//                            Log.e("shaomiao", "JuhetoutiaoTask" + Thread.currentThread().getName());
//                            JuhetoutiaoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.DAZHONGKANDIAN) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "5555555");
                            Log.e("shaomiao", "DazhongkandaioTask" + Thread.currentThread().getName());
                            DazhongkandaioTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.JUKANDIAN) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "66666666" + Thread.currentThread().getName());
                            Log.e("shaomiao", "JukandianTask" + Thread.currentThread().getName());
//                            JukandianTask.start();
                            YinlizixunTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.ZHANGSHANGTOUTIAO) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "7777777" + Thread.currentThread().getName());
                            Log.e("shaomiao", "ZhangshangtoutiaoTask" + Thread.currentThread().getName());
                            ZhangshangtoutiaoTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.DIANDIANXINWEN) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "8888888" + Thread.currentThread().getName());
                            Log.e("shaomiao", "DiandianxinwenTask" + Thread.currentThread().getName());
                            DiandianxinwenTask.start();
                        } else if (tabEntity.flag_enum == Constant.ENUM.SHANDIANKANKAN) {
                            Thread.sleep(1000);
                            Log.e("shaomiao", "9999999" + Thread.currentThread().getName());
                            Log.e("shaomiao", "ShandiankankanTask" + Thread.currentThread().getName());
                            ShandiankankanTask.start();
                        } else {
                            Log.e("shaomiao", "else else else" + count);
                            count = 0;
                        }
                        Log.e("shaomiao", "doInBackground" + Thread.currentThread().getName());
                        count += 1;
//
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 方法3：onProgressUpdate（）
    // 作用：在主线程 显示线程任务执行的进度
    @Override
    protected void onProgressUpdate(Integer... progresses) {
        Log.e("shaomiao", "onProgressUpdate" + Thread.currentThread().getName());
//            progressBar.setProgress(progresses[0]);
//            text.setText("loading..." + progresses[0] + "%");

    }

    // 方法4：onPostExecute（）
    // 作用：接收线程任务执行结果、将执行结果显示到UI组件
    @Override
    protected void onPostExecute(String result) {
        Log.e("shaomiao", "onPostExecute" + Thread.currentThread().getName());
        Log.e("shaomiao", "onPostExecute" + this.isCancelled());
        // 执行完毕后，则更新UI
//            text.setText("加载完毕");
    }

    // 方法5：onCancelled()
    // 作用：将异步任务设置为：取消状态
    @Override
    protected void onCancelled() {
        Log.e("shaomiao", "onCancelled" + Thread.currentThread().getName());
//            text.setText("已取消");
//            progressBar.setProgress(0);
        flag = false;

    }

    private void init() {
        first_list = new ArrayList<>();
        second_list = new ArrayList<>();

        String str = SharedPreferencesUtils.getPreferences(App.mContext).getString(Constant.BEFORE_TEXT, "");
        String str1 = SharedPreferencesUtils.getPreferences(App.mContext).getString(Constant.AFTER_TEXT, "");
        if (!str.equals("")) {
            List<TabEntity> beforelist1 = GsonUtil.changeGsonToList(str, TabEntity.class);
            for (TabEntity tab : beforelist1) {
                Log.e(Constant.TAG, tab.check + "：" + tab.flag_enum + "：" + tab.text);
            }
            first_list.addAll(beforelist1);
        }
        if (!str1.equals("")) {
            List<TabEntity> afterlist2 = GsonUtil.changeGsonToList(str1, TabEntity.class);
            for (TabEntity tab2 : afterlist2) {
                Log.e(Constant.TAG, tab2.check + "：" + tab2.flag_enum + "：" + tab2.text);
            }
            second_list.addAll(afterlist2);
        }


        Log.e(Constant.TAG, "first_list size" + first_list.size());
        Log.e(Constant.TAG, "second_list size" + second_list.size());
    }

}
