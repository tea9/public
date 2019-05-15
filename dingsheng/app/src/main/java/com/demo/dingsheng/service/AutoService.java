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
import com.demo.dingsheng.model.ZhongQingModel;

/**
 * created by tea9 at 2018/12/6
 * 定时器执行 无限循环执行操作
 * ///Users/shaomiao/Library/Android/sdk/tools/monitor
 *
 * //            SharedPreferencesUtils.putInfo(HomePageActivity.this,"red_point", true);
 * //            SharedPreferencesUtils.getPreferences(this).getBoolean("red_point",true);
 * <p>
 * 1.签到 ===
 * 2.领取红包  ===
 * 3.滑动速度 时间 每个软件在判断 1.5秒 ===  滑动速度 根据没个app来的 有的app式滑动一圈 有的是 滚动到底部
 * 4.点开展开全文 === 有的app不需要展开全文 如果要加上需要时间
 * 5.注册码授权  待确认 √
 * 6.更新 弹窗更新 ===
 * 7.定时 12小时 6个 9个 待确认app列表 ===
 * 8.清理后台 ===
 * 9.循环时间 每个软件执行时间 ===
 * 10.平台卡住 不能正常运行  在执行当前卡住的 时间待确认 ===
 * 11.来电时停止运行脚本 设置 === 设置停止运行脚本 默认是运行脚本
 * 12.设置列表里的
 * 13.悬浮窗控制脚本
 * 14.随机浏览 ===
 * 15.全局延时
 * 16.软件分身
 * 17.鼎盛科技 软件名
 * 18.界面好看一点
 * <p>
 * * 东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器、
 * 海草公社、掌上头条、聚看点、芒果看点、值得看看、红包头条、聚合头条、大众看点、点点新闻、微鲤看看
 * <p>
 * 待确认
 * 微信号
 * <p>
 * 授权码 绑定手机唯一码
 * 1、注册码是绑定每台手机。
 * 2、平台卡住，不能正常运行，检测时间为60秒，超过检测时间，自动关闭，重新启动APP运行。d
 * 3、先运行东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器，然后再运行微鲤看看、韭菜头条、红包头条、聚合头条、大众看点、聚看点、掌上头条、点点新闻、闪电看看、薪头条，以12个小时为分界。
 *
 * 1、注册码是绑定每台手机。
 * 2、平台卡住，不能正常运行，检测时间为60秒，超过检测时间，自动关闭，重新启动APP运行。
 * 3、先运行东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器，然后再运行微鲤看看、韭菜头条（没找到）、红包头条、聚合头条、大众看点（没下载到）、聚看点、掌上头条(账号注册失败)、点点新闻、闪电看看(没吓到)闪电盒子、、薪头条，以12个小时为分界。
 *
 * 去广告
 *
 * 悬浮窗 https://github.com/YoungBill/Android-FloatWindow
 *
 * http://47.52.41.206:8181/api/user/update
 * equipmentID 设备ID
 * registerCode 激活码
 *
 * 9baa14d0-08b1-4ee7-9c85-f4b397935540   f8a02139-6e28-4726-8e37-12901567701b
 *
 * 定时服务
 * https://blog.csdn.net/maiduoudo/article/details/78433627
 */

//https://fir.im/jhydzszy


/**
 * TODO
 * http请求 √ 还没测试 √
 * 悬浮窗√ 还要完善 √ 还有些小问题 点击后不能回去 还有悬浮窗icon
 * icon √
 * 日志 √ 还没测试
 * 把配色改了 先不改了 √
 * 定时运行 12个小时分解 全选 传输参数 存储 service 获取√ 还没测试
 * 1webview 签到 领红包 点击坐标 √
 * 2没有下载的app测试√
 * 东方头条 弹框 杀死进程了 √
 * bugly 版本更新 √ 还没测试更新
 * 改配色√
 * 防止封号
 * app手机卡住检测
 */

/**
 * 关闭要闻推送
 * http://www.3533.com/news/7/201704/156911/1.htm
 */

/**
 * TODO
 * 平台卡住
 * 来电检测 设置
 * 悬浮窗√
 * 软件设置
 *  东方头条 要闻推送弹窗 杀死进程 杀死他 在constantstart
 *  中青看点 第一次弹窗判断
 *  息屏处理
 */

/**
 * 功能测试
 * 应用更新
 *
 */

/**
 * 悬浮窗
 * switch
 * 清理缓存
 */
public class AutoService extends Service {

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
//                    DongFangModel.startDongFang();
                    ZhongQingModel.startZhongQing();
//                    QuTouTiaoModel.startQuTouTiao();
//                    Log.e("shaomiao","趣头条");
                    Log.e("shaomiao","趣头条");
//                    MaYiTouTiaoModel.startMaYi();
//                    TouTiaoDuoDuoModel.startTouTiaoDuoDuo();
//                    Browser2345Model.start();
//                    WeiLiKanKanModel.start();
//                    JiuCaiZiXunModel.start();
//                    HongBaoTouTiaoModel.start();
//                    JuheToutiaoModel.start();
//                    DaZhongKanDianModel.start();
//                    JuKanDianModel.start();
//                    ZhangShangTouTiaoModel.start(); //账号注册失败
//                    DianDianXinWenModel.start();
//                    ShanDianKanKanMoel.start();
//                    XinTouTiaoModel.start();
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
}
