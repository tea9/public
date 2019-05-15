package com.demo.dingsheng.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.demo.dingsheng.MainActivity;
import com.demo.dingsheng.R;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.DOMTest;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2018/12/6
 * 定时器执行 无限循环执行操作
 * ///Users/shaomiao/Library/Android/sdk/tools/monitor
 *
 * 1.签到 ===
 * 2.领取红包  ===
 * 3.滑动速度 时间 每个软件在判断 1.5秒 ===
 * 4.点开展开全文 ===
 * 5.注册码授权  待确认
 * 6.更新 弹窗更新 ===
 * 7.定时 12小时 6个 9个 待确认app列表 ===
 * 8.清理后台 ===
 * 9.循环时间 每个软件执行时间 ===
 * 10.平台卡住 不能正常运行  在执行当前卡住的 时间待确认 ===
 * 11.来电时停止运行脚本 设置 ===
 * 12.设置列表里的
 * 13.悬浮窗控制脚本
 * 14.随机浏览 ===
 * 15.全局延时
 * 16.软件分身
 * 17.鼎盛科技 软件名
 * 18.界面好看一点
 *
 *  * 东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器、
 *  海草公社、掌上头条、聚看点、芒果看点、值得看看、红包头条、聚合头条、大众看点、点点新闻、微鲤看看
 *
 *  待确认
 *  微信号
 *
 *  授权码 绑定手机唯一码
 *  1、注册码是绑定每台手机。
 * 2、平台卡住，不能正常运行，检测时间为60秒，超过检测时间，自动关闭，重新启动APP运行。
 * 3、先运行东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器，然后再运行微鲤看看、韭菜头条、红包头条、聚合头条、大众看点、聚看点、掌上头条、点点新闻、闪电看看、引力红包，以12个小时为分界。
 */
public class AutoService2 extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        // 前台服务
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("android_touch")
                .setContentText("android_touch")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ShellUtil.createDir();
                    startDongFang();

//                    startZhongQing();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /**
     * 东方要闻弹框点击忽略
     * @throws InterruptedException
     */
    private void dongFangYaoWenDialog() throws InterruptedException {
        ShellUtil.createXMLFile(Constant.DongFang.FileName.file_yaowen,true);
        if (ShellUtil.checkPage("com.songheng.eastnews:id/vf",Constant.DongFang.FileName.file_yaowen)){
            ShellUtil.clickByXy("com.songheng.eastnews:id/un",Constant.DongFang.FileName.file_yaowen);
        }
    }

    /**
     * 打开东方头条 并执行程序
     * 东方头条每次刷新都会有新的文章
     * 可以进行每次点击刷新然后点击第一个item
     * @throws InterruptedException
     */
    private void startDongFang() throws InterruptedException {
        ShellUtil.delAllFile();
        Log.e(Constant.TAG,"删除所有文件");
        start(Constant.DongFang.ACTIVITY_PACKAGE);
        Log.e(Constant.TAG,"打开应用");

        Log.e(Constant.TAG,ShellUtil.checkPage(Constant.DongFang.RES_ID_RED,Constant.DongFang.FileName.file_path1)+"");
        if (ShellUtil.checkPage(Constant.DongFang.RES_ID_RED,Constant.DongFang.FileName.file_path1)) ShellUtil.back(); //红包页面
        Log.e(Constant.TAG,"红包页面返回");

        // TODO 红包和签到 因为是webview 没办法点击
//        ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN2,Constant.DongFang.FileName.file_path2); //点击任务按钮
//        Log.e(Constant.TAG,"点击任务");
//        Thread.sleep(2*1000);
//        ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN2,Constant.DongFang.FileName.file_path3); //点击任务按钮
        ////////////
        ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN1,Constant.DongFang.FileName.file_path2); //点击刷新
        Log.e(Constant.TAG,"点击刷新");
        Thread.sleep(2 * 1000);
        while (true) {
            clickItemDongFang(Constant.DongFang.FileName.file_path2);
            //滑动一屏
            RootCmd.execRootCmd("input swipe 25 1500 25 300 1000");
        }
    }
    /**
     * Constant.DongFang.FileName.file_path2
     * 点击一个item 然后滑动 在点击item
     * @param file_path
     * @throws InterruptedException
     */
    private void clickItemDongFang(String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path,true);
        Thread.sleep(1*1000);
        Map<String, Map<String, Integer>> zzz = DOMTest.getCoordinateListWithResourceId(Constant.DongFang.RES_ID_ITEM1, file_path);
        if (null!=zzz) {

            for (int i=0; i < zzz.size(); i++) {
                int x1 = zzz.get(i+"").get("x1");
                int y1 = zzz.get(i+"").get("y1");
                ShellUtil.clickMethod(x1,y1);
                //滑动
                Log.e(Constant.TAG,"开始滑动了");
                int k = 0;
                while (k<30) {
                    RootCmd.execRootCmd("input keyevent 20 ");
                    k++;
                }

                int j = 0;
                while (j<30) {
                    RootCmd.execRootCmd("input keyevent 19 ");
                    j++;
                }
                ShellUtil.back();

            }
        }
    }

    /**
     * 打开中青看点
     * 中青看点每次刷新不会有新的文章
     * 所以要滑动来浏览文章
     * 滑动的坐标根据item的坐标滑动
     * @throws InterruptedException
     */
    private void startZhongQing() throws InterruptedException {
        ShellUtil.delAllFile();
        start(Constant.ZhongQing.ACTIVITY_PACKAGE);
        Log.e(Constant.TAG,"打开应用");
        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED,Constant.ZhongQing.FileName.file_path1)) ShellUtil.back(); //红包页面
        Log.e(Constant.TAG,"红包页面返回");
        // TODO 红包和签到
        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path2); //点击刷新
        Thread.sleep(2 * 1000);
        while (true) {
            zhongqingDialog();
            ShellUtil.createXMLFile(Constant.ZhongQing.FileName.file_path2,true);
            // 点击 然后滑动
            Map<String, Map<String, Integer>> zzz = DOMTest.getCoordinateListWithResourceId(Constant.ZhongQing.RES_ID_ITEM1, Constant.ZhongQing.FileName.file_path2);
            zhongqingDialog();
            if (null!=zzz) {
                Log.e(Constant.TAG,"zzzz"+zzz.toString());
                for (int l=0;l<zzz.size()-1;l++){
                    int x1 = zzz.get(l+"").get("x1");
                    int y1 = zzz.get(l+"").get("y1");
                    Log.e(Constant.TAG,"x1:"+x1+"y1"+y1);
                    ShellUtil.clickMethod(x1,y1);
                    int i = 0;
                    while (i<20) {
                        RootCmd.execRootCmd("input keyevent 20 ");
                        i++;
                    }
                    ShellUtil.back();
                    zhongqingDialog();
                    Thread.sleep(1*1000);
                }
                Log.e(Constant.TAG,"滑动一个item");
                // 滑动一个item
                int y1=zzz.get("2").get("y1");
                int y2=zzz.get("2").get("y2");
                RootCmd.execRootCmd("input swipe 25 "+y2+" 25 "+y1);
                RootCmd.execRootCmd("input keyevent 93 ");
            }
        }
    }

    private void zhongqingDialog() {
        if (ShellUtil.checkPage(Constant.ZhongQing.DIALOG,Constant.ZhongQing.FileName.file_hongbao,true)) ShellUtil.back(); //红包页面
    }


    private void start(String activity_name) throws InterruptedException {
        ShellUtil.home();
        ShellUtil.clear();
        ShellUtil.startActivity(activity_name);
        Thread.sleep(10*1000);
    }

}
