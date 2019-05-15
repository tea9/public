package com.demo.android_ds.runnable;

import android.util.Log;

import com.demo.android_ds.App;
import com.demo.android_ds.entity.TabEntity;
import com.demo.android_ds.util.Constant;
import com.demo.android_ds.util.DOMTest;
import com.demo.android_ds.util.GsonUtil;
import com.demo.android_ds.util.RootCmd;
import com.demo.android_ds.util.SharedPreferencesUtils;
import com.demo.android_ds.util.ShellUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * 30分钟定时v
 * 开始 停止√
 * 循环运行√
 * <p>
 * 12小时 换listabc dfg
 * <p>
 * 每句话flag
 * <p>
 * 每个操作都要判断时间 判断12h 判断flag停止启动
 */
public class XiaoMiRunnable implements Runnable, BaseRunnable {
    // 开始停止标志位
    volatile boolean flag = true; //
    //    final long min = 5 * 1000;
    final long min = 15 * 60 * 1000;
    final long min10 = 10 * 60 * 1000;
    final long min15 = 15 * 60 * 1000;
//    final long min = 10 * 60 * 1000;

    final String TAG = "test";

    int timeFlag = 0; //1是 前面的 2 是后面的

    List<TabEntity> list = new ArrayList<>();
    int listSize = 0;
    int index = 0;

    /**
     * checkTimeLimit
     */
    private boolean checkTimeLimit() {
        Calendar now = Calendar.getInstance();
        int nowDate = now.get(Calendar.HOUR_OF_DAY);
        // 停止的时候保存标志 点击开始的时候判断 有就修改 没有就从头
        // 根据区间判断list 数据
//        if (nowDate >= 12 && nowDate <= 24) {
//        if (nowDate >= 20 && nowDate <= 21) {
        if (nowDate >= 11 && nowDate <= 24) {
            // list 重新赋值 size 重新赋值
            initData(1);
            listSize = list.size();
            if (timeFlag != 1) { //如果现在不是1
                timeFlag = 1;
                index = 0;
                return true;
            }
//        } else if (nowDate >= 22 && nowDate <= 24) {
        } else if (nowDate >= 0 && nowDate <= 11) {
            initData(2);
            listSize = list.size();
            if (timeFlag != 2) {
                timeFlag = 2;
                index = 0;
                return true;
            }
        } else {
            // 集合置空 size 给0
            listSize = 0;
            list.clear();
            //在这里做其他的事情
        }
        return false;
    }


    @Override
    public void run() {
        Log.e(TAG, "XiaoMiRunnable" + Thread.currentThread().getName() + "AAA1" + index);
        //在这里判断时间 12小时 执行 a b
        checkTimeLimit();
        Log.e(TAG, "runnstart" + Thread.currentThread().getName() + "AAA1" + index);
        // 3min顺序执行任务
        long startTime = System.currentTimeMillis(); //开始时间;
        // 执行30分钟任务

        while (index < listSize && flag) {
            TabEntity entity = list.get(index);
            startTime = System.currentTimeMillis(); //开始时间
            Log.e(TAG, "runnstart starttime" + startTime);
//            entity.flag_enum = Constant.ENUM.QUTOUTIAO;
            if (entity.flag_enum == Constant.ENUM.ZHIMATOUTIAO) { // 芝麻头条
                //region zhimatoutiao
                if (checkTime(startTime)) {
                    try {
                        start(Constant.ZhiMaTouTiao.ACTIVITY_PACKAGE);
                        Log.e(Constant.TAG, "芝麻头条签到");
                        Thread.sleep(5 * 1000);

                        start(Constant.ZhiMaTouTiao.ACTIVITY_PACKAGE);
                        Log.e(Constant.TAG, "芝麻头条福利中心");
                        ShellUtil.clickMethod(677, 1846); // 福利中心
                        Thread.sleep(1000);
                        Log.e(Constant.TAG, "芝麻头条签到");
                        ShellUtil.clickMethod(857, 625); // 签到
                        Thread.sleep(5000);

                        start(Constant.ZhiMaTouTiao.ACTIVITY_PACKAGE);
                        Log.e(Constant.TAG, "芝麻头条领取");
                        ShellUtil.clickMethod(962, 125); // 领取
                        Thread.sleep(5000);

                        start(Constant.ZhiMaTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(3000);
                        while ((checkTime(startTime))) {
                            Log.e(Constant.TAG, "芝麻头条刷新");
                            ShellUtil.clickMethod(186, 1847);
                            Thread.sleep(2000);
                            Log.e(Constant.TAG, "芝麻头条点击第一条");
                            slideByXyIds2ZhiMa(142, 415, startTime);
                        }


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                //endregion zhimatoutiao
            } else if (entity.flag_enum == Constant.ENUM.DONGFANGTOUTIAO) { //东方头条
                //region dongfangtoutiao
                if (checkTime(startTime)) {
                    try {
                        start(Constant.DongFang.ACTIVITY_PACKAGE);
                        Log.e(Constant.TAG, "东方头条立即签到66666");
                        Thread.sleep(5 * 1000);
                        checkBackDongFang();
                        Log.e(Constant.TAG, "东方头条立即签到222222");
                        Thread.sleep(1 * 1000);


                        ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN2, Constant.DongFang.FileName.file_path1); //点击任务
                        Thread.sleep(2 * 1000);
                        ShellUtil.clickByXy(Constant.DongFang.LINGQU_CLOSE, Constant.DongFang.FileName.file_path1); //点击金币取消
                        Thread.sleep(1 * 1000);
//                        RootCmd.execRootCmd("input keyevent 20");
                        ShellUtil.clickByXy("com.songheng.eastnews:id/v6", Constant.DongFang.FileName.file_path1);// 红包取消
                        Thread.sleep(3 * 1000);
                        Log.e(Constant.TAG, "立即签到");
//        ShellUtil.clickByXyDesc("立即签到",Constant.DongFang.FileName.file_path1);
//        ShellUtil.clickByXyDesc("立即签到",Constant.DongFang.FileName.file_path1);
                        ShellUtil.clickMethod(878, 569);
                        Thread.sleep(6 * 1000);
                        // 滑动页面
                        start(Constant.DongFang.ACTIVITY_PACKAGE);
                        Thread.sleep(1000);
                        Log.e(Constant.TAG, "返回");
                        checkBackDongFang();
                        Thread.sleep(1000);
                        //点击领取
                        ShellUtil.clickByXy(Constant.DongFang.RES_ID_LINGQU, Constant.DongFang.FileName.file_path1); // 点击领取
                        Thread.sleep(1000);
                        ShellUtil.clickByXy(Constant.DongFang.WOZHIDAO, Constant.DongFang.FileName.file_path1);//领取我知道
                        checkBackDongFang();
                        Thread.sleep(2000);
                        Log.e(Constant.TAG, "点击btn1");
                        if (!ShellUtil.checkPage(Constant.DongFang.RES_ID_BTN1, Constant.DongFang.FileName.file_path1)) {
                            ShellUtil.back();
                            Log.e(Constant.TAG, "东方头条 没检测到item1 点击返回");
                        }
//                        ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN1, Constant.DongFang.FileName.file_path1); // 点击刷新
                        Log.e(Constant.TAG, "点击item1");
                        ShellUtil.clickMethod(836, 138);//领取
                        Thread.sleep(4000);
                        start(Constant.DongFang.ACTIVITY_PACKAGE);
//                        if (ShellUtil.checkPage(Constant.DongFang.RES_ID_ITEM1, Constant.DongFang.FileName.file_path1)) {
                        while ((checkTime(startTime))) {
//                            ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN1, Constant.DongFang.FileName.file_path1); // 点击刷新
                            ShellUtil.clickMethod(106, 1859);
                            Thread.sleep(2000);
//                            slideByXyIdsNotByDongFang(Constant.DongFang.RES_ID_ITEM1, Constant.DongFang.FileName.file_path1, 1, true,startTime); // 第一条是置顶
                            slideByXyIdsNotByDongFang(50, 956, startTime); // 第一条是置顶
//                                ShellUtil.clickByXy(Constant.DongFang.RES_ID_BTN1, Constant.DongFang.FileName.file_path1); // 点击刷新
                        }
//                        } else {
//                            Log.e(Constant.TAG, "东方头条else else else else ");
//                            index++;
//                            continue;
//                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                //endregion dongfangtoutiao
            } else if (entity.flag_enum == Constant.ENUM.HUITOUTIAO) { //惠头条
                //region huitoutiao
                if (checkTime(startTime)) {
                    try {
                        start(Constant.HuiTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickByXy(Constant.HuiTouTiao.DIALOG_CLOSE, Constant.HuiTouTiao.FileName.file_path1);
                        Thread.sleep(2 * 1000);
                        Log.e(Constant.TAG, "惠头条点击任务中心" + Thread.currentThread().getName());
                        ShellUtil.clickMethod(765, 1846);//任务中心
                        Thread.sleep(2 * 1000);
                        Log.e(Constant.TAG, "惠头条点击签到" + Thread.currentThread().getName());
                        ShellUtil.clickMethod(549, 389);//签到
                        Thread.sleep(6 * 1000);
                        /////////
                        start(Constant.HuiTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(1 * 1000);
                        ShellUtil.clickByXy(Constant.HuiTouTiao.DIALOG_CLOSE, Constant.HuiTouTiao.FileName.file_path1);
                        Thread.sleep(4 * 1000);
//                        Log.e(Constant.TAG, "惠头条刷新" + Thread.currentThread().getName());
//                        ShellUtil.clickMethod(111, 1840);//刷新
//                        Thread.sleep(3 * 1000);
                        Log.e(Constant.TAG, "惠头条时段奖励" + Thread.currentThread().getName());
                        ShellUtil.clickMethod(874, 128);//时段奖励
//                        ShellUtil.clickMethod(904, 132);//时段奖励
                        Thread.sleep(2 * 1000);
                        Log.e(Constant.TAG, "惠头条时段奖励忽略" + Thread.currentThread().getName());
                        ShellUtil.clickByXy(Constant.HuiTouTiao.SHIDUAN_HULUE, Constant.HuiTouTiao.FileName.file_path1);//时段奖励忽略
                        Thread.sleep(3000);
                        String xx = RootCmd.execRootCmd("dumpsys window w |grep \\/ |grep name=");
//                        if (ShellUtil.checkPage(Constant.HuiTouTiao.RES_ID_ITEM1, Constant.HuiTouTiao.FileName.file_path1) || xx.contains("com.cashtoutiao.account.ui.main.MainTabActivity")) {
                        while ((checkTime(startTime))) {
                            Log.e(Constant.TAG, "惠头条刷新" + Thread.currentThread().getName());
                            ShellUtil.clickMethod(103, 1849);//刷新
                            Log.e(Constant.TAG, "惠头条item" + Thread.currentThread().getName());
                            Thread.sleep(2 * 1000);
//                                slideByXyIds2HuiTouTiao(Constant.HuiTouTiao.RES_ID_ITEM1, Constant.HuiTouTiao.FileName.file_path1,startTime);
                            slideByXyIds2HuiTouTiao(342, 1342, startTime);
                            Thread.sleep(1000);
                        }
//                        } else {
//                            Log.e(TAG, "check else else else else else else");
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.e(TAG, entity.text + Thread.currentThread().getName() + "AAA1" + index);
                // endregion
            } else if (entity.flag_enum == Constant.ENUM.JUHETOUTIAO) {//聚合头条 改变了不是滚动文章 改成转发了
                //region juhetoutiao
                if (checkTime(startTime)) {
                    try {
                        start(Constant.JuHeTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickMethod(945, 1728);
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickMethod(376, 1577);
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickMethod(587, 722);
                        Thread.sleep(6 * 1000);
                        /////
                        start(Constant.JuHeTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);
                        //领红包
                        ShellUtil.clickMethod(176, 1685);
                        Thread.sleep(2 * 1000);
                        Log.e(Constant.TAG, "点击btn1");
                        ShellUtil.clickMethod(176, 1685);
                        Log.e(Constant.TAG, "点击item1");
                        Thread.sleep(3000);
                        if (ShellUtil.checkPage(Constant.JuHeTouTiao.RES_ID_ITEM1, Constant.JuHeTouTiao.FileName.file_path1)) {
                            while ((checkTime(startTime))) {
                                Log.e(Constant.TAG, "RES_ID_ITEM1");
                                slideByXyIds6JuHeTouTiao(Constant.JuHeTouTiao.RES_ID_ITEM1, Constant.JuHeTouTiao.FileName.file_path1, startTime);
                                Log.e(Constant.TAG, "滑动聚合头条");
                                ShellUtil.clickMethod(176, 1685);
                            }
                        } else {
                            index++;
                            continue;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.ZHONGQINGKANDIAN) { //中青看点
                //region zhongqingkandian
                if (checkTime(startTime)) {
                    try {
                        beforeZhongQing();
                        Log.e(Constant.TAG, "点击我的 zhongqingzhognqing" + Thread.currentThread().getName());
                        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN2, Constant.ZhongQing.FileName.file_path1); // 点击我的
//                        ShellUtil.clickMethod(153, 666); //点击我的
                        Thread.sleep(2 * 1000);
//        ShellUtil.clickByXy(Constant.ZhongQing.RES_RENWUZHONGXIN,Constant.ZhongQing.FileName.file_path1); //点击任务中心
                        Log.e(Constant.TAG, "任务中心 zhongqingzhognqing" + Thread.currentThread().getName());
                        ShellUtil.clickMethod(153, 666); //任务中心
                        Thread.sleep(2 * 1000);
                        Log.e(Constant.TAG, "去拆现金 zhongqingzhognqing" + Thread.currentThread().getName());
                        // 判断弹框
                        ShellUtil.clickMethod(479, 481); //点击签到

                        Thread.sleep(6 * 1000);
                        ////////////////
                        beforeZhongQing();
                        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1, Constant.ZhongQing.FileName.file_path1); // 点击刷新
                        Thread.sleep(3 * 1000);
                        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_BTN1, Constant.ZhongQing.FileName.file_path1)) {
                            while ((checkTime(startTime))) {
//                ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL, Constant.FILE_PATH);
                                Thread.sleep(1000);
                                Log.e(Constant.TAG, "点击item111111 zhongqingzhognqing" + Thread.currentThread().getName());
//            ShellUtil.clickByXyIds(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
                                slideByXyIdsZHONGQING(Constant.ZhongQing.RES_ID_ITEM1, Constant.ZhongQing.FileName.file_path2, startTime);
                                Thread.sleep(2 * 1000);
                                Log.e(Constant.TAG, "去拆现金 zhongqingzhognqing" + Thread.currentThread().getName());
                                ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1, Constant.ZhongQing.FileName.file_path1); // 点击刷新
                                Thread.sleep(2 * 1000);
                            }
                        } else {
                            index++;
                            continue;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.QUTOUTIAO) { //趣头条
                //region qutoutiao
                if (checkTime(startTime)) {
                    try {
                        beforeQuTouTiao();
                        ShellUtil.clickMethod(759, 1858);//签到
                        Thread.sleep(6 * 1000);
                        Log.e(Constant.TAG, "before qutoutiao签到");
                        ShellUtil.clickMethod(101, 1869);//刷新
//                        com.jifen.qukan:id/j5 签到提醒
                        ShellUtil.clickByXy("com.jifen.qukan:id/j5", Constant.QuTouTiao.FileName.file_path1);// 签到提醒

                        Thread.sleep(2 * 1000);
                        ShellUtil.clickMethod(965, 129); //领取
                        Log.e(Constant.TAG, "before qutoutiao领取");
                        Thread.sleep(4 * 1000);
                        Log.e(Constant.TAG, "before qutoutiao领取");
                        ShellUtil.clickByXy("com.jifen.qukan:id/uw", Constant.QuTouTiao.FileName.file_path1); //我知道了
                        Log.e(Constant.TAG, "before qutoutiao我知道了");
                        Thread.sleep(5 * 1000);


                        beforeQuTouTiao();
//                        Thread.sleep(3000);
                        Log.e(Constant.TAG, "before qutoutiao检测首页");
                        Thread.sleep(4 * 1000);
//                        if (ShellUtil.checkPage("com.jifen.qukan:id/kq", Constant.QuTouTiao.FileName.file_path1)) {
                        while ((checkTime(startTime))) {
                            ShellUtil.clickMethod(101, 1869);//刷新
                            Thread.sleep(3000);
//                                ShellUtil.swipe(1730,550);
//                                ShellUtil.swipe(990,550);
                            slideByXyIdsNotQuTouTiao(55, 1705, startTime); // 第一条是置顶
                        }
//                        } else {
//                            Log.e(Constant.TAG, "before qutoutiaoelse else else else" + Thread.currentThread().getName());
//                            index++;
//                            continue;
//                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.MAYITOUTIAO) { //蚂蚁头条 任务是空的
                //region mayitoutiao
                if (checkTime(startTime)) {
                    try {
                        beforeMaYiTouTiao();

                        Thread.sleep(4 * 1000);
                        ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN2, Constant.MaYi.FileName.file_path1); //任务
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
                        Thread.sleep(2 * 1000);
                        if (ShellUtil.checkPage(Constant.MaYi.DIALOG_RED, Constant.MaYi.FileName.file_path1)) { //check红包 好像id不一样
                            ShellUtil.back();
                            ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
                        }
                        Thread.sleep(2 * 1000);
                        ShellUtil.clickMethod(459, 418); // 签到
                        Thread.sleep(10 * 1000);

///////////////////////
                        beforeMaYiTouTiao();

                        Thread.sleep(3000);
                        Log.e(Constant.TAG, "-------点击btn1111111");
                        ShellUtil.clickByXy(Constant.MaYi.LING_QU, Constant.MaYi.FileName.file_path1); //领取
                        Thread.sleep(1000);
                        Log.e(Constant.TAG, "-------点击btn2222222");
                        ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
                        Log.e(Constant.TAG, "-------点击btn1");
                        Thread.sleep(1 * 1000);
                        Log.e(Constant.TAG, "-------点击btn190909");
                        if (!ShellUtil.checkPage(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1)) {
                            ShellUtil.back(); //back
                        }
                        Log.e(Constant.TAG, "-------点击btn156868678768768");
//                        if (ShellUtil.checkPage(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1)) {
//                            ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1); // 点击刷新
//            while (Constant.TASK_COUNT) {
                        ShellUtil.clickByXy(Constant.MaYi.QUZHUANQIAN, Constant.MaYi.FileName.file_path1); //去赚钱
                        Thread.sleep(2 * 1000);


//////////////////////////
                        beforeMaYiTouTiao();

                        Log.e(Constant.TAG, "-------点击btn2222222");
                        ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
                        Log.e(Constant.TAG, "-------点击btn1");
                        Thread.sleep(1 * 1000);
                        Log.e(Constant.TAG, "-------点击btn190909");
                        if (!ShellUtil.checkPage(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1)) {
                            ShellUtil.back(); //back
                        }
                        Log.e(Constant.TAG, "-------点击btn156868678768768");
//                        if (ShellUtil.checkPage(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1)) {
//                            ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1); // 点击刷新
//            while (Constant.TASK_COUNT) {
                        ShellUtil.clickByXy(Constant.MaYi.QUZHUANQIAN, Constant.MaYi.FileName.file_path1); //去赚钱
                        Log.e(Constant.TAG, "-------点击hldkfdljfdf68");

                        while ((checkTime(startTime))) {
//                ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL, Constant.FILE_PATH);
                            Log.e(Constant.TAG, "蚂蚁头条----------点击刷新");
                            ShellUtil.clickByXy(Constant.MaYi.RES_ID_BTN1, Constant.MaYi.FileName.file_path1); // 点击刷新
                            Thread.sleep(2000);
                            Log.e(Constant.TAG, "蚂蚁头条----------点击item1");
                            slideByXyIdsMAYI(Constant.MaYi.RES_ID_ITEM1, Constant.MaYi.FileName.file_path1, startTime); // 第一条是置顶
                        }
//                        } else {
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.TOUTIAODUODUO) {//头条多多
                //region toutiaoduoduo
                if (checkTime(startTime)) {
                    try {
                        start(Constant.TouTiaoDuoDuo.ACTIVITY_PACKAGE);

                        Thread.sleep(1000);

                        ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_DIALOG, Constant.TouTiaoDuoDuo.FileName.file_path1);//dialog
                        Thread.sleep(1000);

                        ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN22, Constant.TouTiaoDuoDuo.FileName.file_path1); //赚钱
                        Thread.sleep(1000);
                        ShellUtil.clickMethod(954, 148);//领宝箱
                        Thread.sleep(5000);


                        start(Constant.TouTiaoDuoDuo.ACTIVITY_PACKAGE);
                        Thread.sleep(3000);
                        // check 红包
                        Log.e(Constant.TAG, "点击btn1");
//                        ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN11, Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
//                        Thread.sleep(3 * 1000);
//                        if (ShellUtil.checkPage(Constant.TouTiaoDuoDuo.RES_ID_BTN11, Constant.TouTiaoDuoDuo.FileName.file_path1)) {
                        while ((checkTime(startTime))) {
//            while () {
//                ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL, Constant.FILE_PATH);
//                                Thread.sleep(1000);
                            Log.e(Constant.TAG, "点击item");
                            slideByXyIds2TouTiaoDuoDuo(Constant.TouTiaoDuoDuo.RES_ID_ITEM11, Constant.TouTiaoDuoDuo.FileName.file_path1, startTime, 1); // 文章需要滑到底
//                                Thread.sleep(2 *1000);
                            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN11, Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
                            Thread.sleep(4000);

//            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1,Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
//            Thread.sleep(3*1000);
//            ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_BTN1,Constant.TouTiaoDuoDuo.FileName.file_path1); // 点击刷新
//            Thread.sleep(5*1000);
                        }
//                        } else {
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.BROWER2345) {//2345浏览器
                //region brower2345
                if (checkTime(startTime)) {
                    try {
                        Log.e(Constant.TAG, "brower2345aaaaa" + Thread.currentThread().getName());

                        start(Constant.Browser2345.ACTIVITY_PACKAGE);
                        Thread.sleep(4000);
                        Log.e(Constant.TAG, "brower2345aaaaa点击领红包" + Thread.currentThread().getName());
//            ShellUtil.clickMethod(936, 182);//点击领红包
//            Thread.sleep(2 * 1000);
//            Log.e(Constant.TAG, "brower2345aaaaa返回" + Thread.currentThread().getName());
//            ShellUtil.back();
                        Thread.sleep(1000);
                        Log.e(Constant.TAG, "brower2345aaaaa滑动" + Thread.currentThread().getName());
                        ShellUtil.swipe(966, 600);//滑动
                        Thread.sleep(1000);
                        Log.e(Constant.TAG, "brower2345aaaaa领钱" + Thread.currentThread().getName());


                        ShellUtil.clickMethod(970, 166); //领钱
                        Thread.sleep(1000);
                        ShellUtil.checkPage(Constant.Browser2345.RES_I_KONW, Constant.Browser2345.FileName.file_path1);//点击我知道了
                        Thread.sleep(1000);
                        if (!ShellUtil.checkPage(Constant.Browser2345.RES_ID_ITEM1, Constant.Browser2345.FileName.file_path1)) {
                            Log.e(Constant.TAG, "brower2345aaaaa返回" + Thread.currentThread().getName());
                            ShellUtil.back();
                        }

                        Log.e(Constant.TAG, "brower2345aaaaabtn111111111" + Thread.currentThread().getName());
                        Thread.sleep(3000);
//                        if (ShellUtil.checkPage(Constant.Browser2345.RES_ID_BTN1, Constant.Browser2345.FileName.file_path1)) {
                        while ((checkTime(startTime))) {
                            Log.e(Constant.TAG, "brower2345aaaaa刷新" + Thread.currentThread().getName());
                            ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1, Constant.Browser2345.FileName.file_path1); // 点击刷新
                            Thread.sleep(2000);
                            Log.e(Constant.TAG, "brower2345aaaaa点击item" + Thread.currentThread().getName());
                            slideByXyIds4Brower2345(Constant.Browser2345.RES_ID_ITEM1, Constant.Browser2345.FileName.file_path1, startTime); // 第一条是置顶
                        }
//                        } else {
//                            Log.e(Constant.TAG, "brower2345index++++++++" + Thread.currentThread().getName());
//                            index++;
//                            continue;
//                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.WEILIKANKAN) {//微鲤看看 滑动没有金币
                //region weilikankan
                if (checkTime(startTime)) {
                    try {
                        beforeWeiLiKanKan();

                        slideByXyIds2WeiLiKanKan(Constant.WeiLiKanKan.RES_ID_ITEM1, Constant.WeiLiKanKan.FileName.file_path1, startTime); // 第一条是置顶
//        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1,Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
                        Thread.sleep(4 * 1000);
//                        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN2222, Constant.WeiLiKanKan.FileName.file_path1); // 签到
                        ShellUtil.clickMethod(946, 18); //我的
                        Log.e(Constant.TAG, "微鲤看看 我的");
                        Thread.sleep(2000);
                        ShellUtil.clickMethod(913, 391); //签到
                        Log.e(Constant.TAG, "微鲤看看 签到");
                        Thread.sleep(3000);
                        ShellUtil.clickMethod(558, 289); //立即签到
                        Log.e(Constant.TAG, "微鲤看看 立即签到");
                        Thread.sleep(10 * 1000);

//////////////////////////////

                        beforeWeiLiKanKan();
                        Log.e(Constant.TAG, "点击btn1");
//                        Log.e(Constant.TAG, "点击btn1");
                        Thread.sleep(4 * 1000);
                        Log.e(Constant.TAG, "微鲤看看点击刷新111111111111");
                        Thread.sleep(2000);
                        Log.e(Constant.TAG, "微鲤看看 点击鱼11111");
                        if (ShellUtil.checkPage("cn.weli.story:id/text_open", Constant.WeiLiKanKan.FileName.file_path1)) {
                            Log.e(Constant.TAG, "微鲤看看 点击鱼22222222");
                            ShellUtil.clickByXy("cn.weli.story:id/text_open", Constant.WeiLiKanKan.FileName.file_path1); //点击鱼
                            Thread.sleep(2000);
                            Log.e(Constant.TAG, "微鲤看看 点击鱼3333333");
                            ShellUtil.clickMethod(547, 1380); //点击鱼
                            ShellUtil.clickByXy("cn.weli.story:id/bt_ok", Constant.WeiLiKanKan.FileName.file_path1);//知道了
                        }

                        ShellUtil.startActivity(Constant.WeiLiKanKan.ACTIVITY_PACKAGE);
//                        ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1, Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
//        while (Constant.TASK_COUNT) {
//                        if (ShellUtil.checkPage(Constant.WeiLiKanKan.RES_ID_BTN1, Constant.WeiLiKanKan.FileName.file_path1)) {
                        while ((checkTime(startTime))) {
                            //继续阅读框判断 cn.weli.story:id/text_ok
//                                ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1, Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
//                                if (ShellUtil.checkPage(Constant.WeiLiKanKan.RES_ID_ITEM1,Constant.WeiLiKanKan.FileName.file_path1)) {
//                                    Log.e(Constant.TAG, "微鲤看看点击刷新");
//                                    ShellUtil.clickMethod(305, 1836);
//                                } else {
//                                    Log.e(Constant.TAG, "微鲤看看点击刷新  返回");
//                                    ShellUtil.back();
//                                }

                            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_BTN1, Constant.WeiLiKanKan.FileName.file_path1); // 点击刷新
                            Thread.sleep(1000);
                            Log.e(Constant.TAG, "微鲤看看滑动");
                            slideByXyIds2WeiLiKanKan(Constant.WeiLiKanKan.RES_ID_ITEM1, Constant.WeiLiKanKan.FileName.file_path1, startTime); // 第一条是置顶


                        }
//                        } else {
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.JIUCAITOUTIAO) {//韭菜头条
                //region jiucaitoutiao
                if (checkTime15(startTime)) {
                    try {
                        start(Constant.JiuCaiZiXun.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);
                        Log.e(Constant.TAG, "韭菜头条点击弹框");
                        ShellUtil.clickMethod(550, 1472);//弹框
                        Thread.sleep(3 * 1000);
//        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO, Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
//        Thread.sleep(3 * 1000);
//        ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN2, Constant.JiuCaiZiXun.FileName.file_path1); // 任务
                        // 650 1718
                        Log.e(Constant.TAG, "点击任务");
                        ShellUtil.clickMethod(688, 1843); //任务
                        Thread.sleep(2 * 1000);
//        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO, Constant.JiuCaiZiXun.FileName.file_path1); // 签到
                        Log.e(Constant.TAG, "点击签到");
                        ShellUtil.clickMethod(555, 374); //签到
                        Thread.sleep(6 * 1000);
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
//        Thread.sleep(2*1000);
                        /////////////////////

                        start(Constant.JiuCaiZiXun.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickMethod(550, 1472);//弹框
//        Thread.sleep(3 * 1000);
//        ShellUtil.clickByXy(Constant.JiuCaiZiXun.QIANDAO, Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
                        Thread.sleep(3 * 1000);
//                        Log.e(Constant.TAG, "点击btn1");
//                        ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN1, Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新

                        Log.e(Constant.TAG, "点击item1");
                        Thread.sleep(3000);
//        while (!Thread.currentThread().isInterrupted() &&) {
//                        if (ShellUtil.checkPage(Constant.JiuCaiZiXun.RES_ID_BTN1, Constant.JiuCaiZiXun.FileName.file_path1)) {
                        Log.e(Constant.TAG, "点击item12222");
                        start(Constant.JiuCaiZiXun.ACTIVITY_PACKAGE);
                        ShellUtil.clickMethod(550, 1472);//弹框
                        Thread.sleep(3 * 1000);
                        while ((checkTime15(startTime))) {
                            ShellUtil.clickByXy(Constant.JiuCaiZiXun.RES_ID_BTN1, Constant.JiuCaiZiXun.FileName.file_path1); // 点击刷新
                            Thread.sleep(2000);
                            Log.e(Constant.TAG, "点击item13333");
                            slideByXyIdsJiuCaiTouTiao(Constant.JiuCaiZiXun.RES_ID_ITEM1, Constant.JiuCaiZiXun.FileName.file_path1, startTime);
                            Log.e(Constant.TAG, "点击item144444");
                        }
//                        } else {
//                            Log.e(Constant.TAG, "韭菜 else else else");
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.HONGBAOTOUTIAO) {//红包头条 获取不到 dump 没运行 修改成坐标
                //region hongbaotoutiao
                if (checkTime(startTime)) {
                    try {
                        start(Constant.HongBaoTouTiao.ACTIVITY_PACKAGE);
                        ShellUtil.clickMethod(545, 1830); // 任务
                        Thread.sleep(1000);
                        ShellUtil.clickMethod(854, 432); //签到
                        Thread.sleep(4 * 1000);

                        ShellUtil.startActivity(Constant.HongBaoTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(4 * 1000);
                        while ((checkTime(startTime))) {

                            ShellUtil.clickMethod(121, 1860); //首页
                            RootCmd.execRootCmd("input swipe 25 450 25 1050 700");
                            Thread.sleep(2 * 1000);
                            slideByXyIds5HongBaoTouTiao(23, 1690, startTime);

                        }


//                        Thread.sleep(3 * 1000);
//                        ShellUtil.clickByXy(Constant.HongBaoTouTiao.RES_ID_BTN2, Constant.HongBaoTouTiao.FileName.file_path1);
//                        Thread.sleep(2 * 1000);
//                        ShellUtil.clickByXy(Constant.HongBaoTouTiao.RES_ID_QianDao, Constant.HongBaoTouTiao.FileName.file_path1);
//                        Thread.sleep(5 * 1000);
//
//                        Log.e(Constant.TAG, "红包头条 RES_ID_QianDao");
//                        start(Constant.HongBaoTouTiao.ACTIVITY_PACKAGE);
//                        Log.e(Constant.TAG, "红包头条 ACTIVITY_PACKAGE");
//                        Thread.sleep(4 * 1000);
////        Log.e(Constant.TAG,"返回");
//                        // TODO check 红包
////        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新
//
////        while (!Thread.currentThread().isInterrupted()&&flag){Log.e(Constant.TAG, "点击item111111");
//                        Log.e(Constant.TAG, "点击item111111");
//                        if (ShellUtil.checkPage(Constant.HongBaoTouTiao.RES_ID_ITEM1LL, Constant.HongBaoTouTiao.FileName.file_path1)) {
//                            Log.e(Constant.TAG, "红包头条 RES_ID_BTN2");
//                            while ((checkTime(startTime))) {
//                                Log.e(Constant.TAG, "点击item111111");
//                                slideByXyIds5HongBaoTouTiao(Constant.HongBaoTouTiao.RES_ID_ITEM1LL, Constant.HongBaoTouTiao.FileName.file_path1, startTime);
//                                Log.e(Constant.TAG, "红包头条 RES_ID_ITEM1");
////                                Integer[] a = ShellUtil.getCoordinateByY1X2(Constant.HongBaoTouTiao.RES_ID_ITEM1LL, Constant.HongBaoTouTiao.FileName.file_path1);
//                                Log.e(Constant.TAG, "滑动坐标");
////            if (a != null)
////                ShellUtil.swipe(a[1], a[0]);
//                                ShellUtil.swipe(800, 1490);
//                            }
//                        } else {
//                            Log.e(Constant.TAG, "红包头条 esle esle else else");
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.XINTOUTIAO) {//新头条
                //region xintoutiao
                if (checkTime(startTime)) {
                    try {
                        if (openActivityXinTouTiao(true)) {
                            Log.e(Constant.TAG, "新头条任务" + Thread.currentThread().getName());
                            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN2, Constant.XinTouTiao.FileName.file_path1); //任务
                            Thread.sleep(6 * 1000);
                        }
                        if (openActivityXinTouTiao(true)) {
                            Log.e(Constant.TAG, "新头条时段" + Thread.currentThread().getName());
                            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_LINGQU, Constant.XinTouTiao.FileName.file_path1); // 时段
                            Thread.sleep(2 * 1000);
                            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_WO_ZHIDAO, Constant.XinTouTiao.FileName.file_path1); // 时段我知道了
                            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_WO_ZHIDAO_CLOSE, Constant.XinTouTiao.FileName.file_path1); // dialog Close
                            Thread.sleep(2 * 1000);

                            Log.e(Constant.TAG, "新头条点击刷新" + Thread.currentThread().getName());
//                            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
                            Thread.sleep(4 * 1000);
//                            if (ShellUtil.checkPage(Constant.XinTouTiao.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1)) {
                            while ((checkTime(startTime))) {
                                Log.e(Constant.TAG, "新头条点击置顶" + Thread.currentThread().getName());
                                ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
                                Thread.sleep(2000);
                                slideByXyIdsXinTouTiao(Constant.XinTouTiao.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1, 0, startTime); // 第一条是置顶
                                Log.e(Constant.TAG, "新头条点击刷新" + Thread.currentThread().getName());
                            }
//                            } else {
//                                index++;
//                                continue;
//                            }

                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.DAZHONGKANDIAN) {//大众看点 运行不了 dump 不到 修改成坐标
                //region dazhongkandian
                if (checkTime(startTime)) {
                    try {
                        start(Constant.DaZhongKanDian.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickMethod(707, 1872); //任务
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickMethod(570, 498); // 签到
                        Thread.sleep(6 * 1000);


                        start(Constant.DaZhongKanDian.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);

                        ShellUtil.clickMethod(205, 167); //领取
                        Thread.sleep(3 * 1000);
                        //点击首页
                        while ((checkTime(startTime))) {
//                            ShellUtil.clickMethod(157, 1840); //
                            ShellUtil.swipe(693, 1400); //刷新
                            Thread.sleep(1000);
                            slideByXyIdsDaZhongKanDian(718, 752, startTime); // 第一条是置顶
                        }
//        Log.e(Constant.TAG,"返回");
//        ShellUtil.back();
//        Thread.sleep(2*1000);
//        Log.e(Constant.TAG,"点击btn1");
//        ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_BTN1,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
//                        ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_LingQu, Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
//
//                        Log.e(Constant.TAG, "点击item1");
//                        Thread.sleep(1 * 1000);
//                        if (ShellUtil.checkPage(Constant.DaZhongKanDian.RES_ID_ITEM1, Constant.DaZhongKanDian.FileName.file_path1)) {
//                            while ((checkTime(startTime))) {
//
//
////        while (!Thread.currentThread().isInterrupted()&&flag) {
//                                slideByXyIdsDaZhongKanDian(Constant.DaZhongKanDian.RES_ID_ITEM1, Constant.DaZhongKanDian.FileName.file_path1,startTime); // 第一条是置顶
//                                Integer[] a = ShellUtil.getCoordinateByY1X2(Constant.DaZhongKanDian.RES_ID_ITEM1LL, Constant.ZhongQing.FileName.file_path1);
////            Log.e(Constant.TAG,"keyevent 1");
//                                if (a != null)
//                                    ShellUtil.swipe(a[1], a[0]);
////            ShellUtil.clickByXy(Constant.DaZhongKanDian.RES_ID_BTN1,Constant.DaZhongKanDian.FileName.file_path1); // 点击刷新
//                            }
//                        }else{
//                            Log.e(Constant.TAG, "大众看点 else else else");
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.YINLIZIXUN) {//引力资讯
                //region yinlizixun
                if (checkTime(startTime)) {
                    try {
                        start(Constant.YinLiZiXun.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);
                        Log.e(Constant.TAG, "打开引力资讯" + Thread.currentThread().getName());
                        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_ID_BTN2, Constant.YinLiZiXun.FileName.file_path1); //我的
                        Thread.sleep(2 * 1000);
                        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_ID_BTN2_DIALOG, Constant.YinLiZiXun.FileName.file_path1); // 弹框
                        Thread.sleep(2 * 1000);
//                        ShellUtil.clickMethod(988, 312); 这个不知道干什么的给注释了
                        Thread.sleep(2 * 1000);
                        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_QIANDAO, Constant.YinLiZiXun.FileName.file_path1);//签到
                        Thread.sleep(6 * 1000);

                        start(Constant.YinLiZiXun.ACTIVITY_PACKAGE);
                        Thread.sleep(3 * 1000);
                        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_LINGQU, Constant.YinLiZiXun.FileName.file_path1);//领取
                        Thread.sleep(1000);
                        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_LINGQU_CLOSE, Constant.YinLiZiXun.FileName.file_path1);
                        ShellUtil.clickByXy(Constant.YinLiZiXun.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
                        Log.e(Constant.TAG, "引力资讯 RES_ID_BTN1" + Thread.currentThread().getName());

                        if (ShellUtil.checkPage(Constant.YinLiZiXun.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1)) {
                            while ((checkTime(startTime))) {
                                ShellUtil.clickByXy(Constant.YinLiZiXun.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
                                Thread.sleep(2000);
                                slideByXyIdsYinLiZiXun(Constant.YinLiZiXun.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1, 1, startTime); // 第一条是置顶
                            }
                        } else {
                            Log.e(Constant.TAG, "引力资讯 else else else else" + Thread.currentThread().getName());
                            index++;
                            continue;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.ZHANGSHANGTOUTIAO) {//掌上头条
                //region zhangshangtoutiao
                if (checkTime(startTime)) {
                    try {
                        Log.e(Constant.TAG, "掌上");
                        start(Constant.ZhangShangTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(1 * 1000);
                        ShellUtil.clickByXy(Constant.ZhangShangTouTiao.RES_ID_BTN2, Constant.ZhangShangTouTiao.FileName.file_path1);//任务
                        Thread.sleep(8 * 1000);

////////////////

                        start(Constant.ZhangShangTouTiao.ACTIVITY_PACKAGE);
                        ShellUtil.clickByXy(Constant.ZhangShangTouTiao.LINNGQU, Constant.ZhangShangTouTiao.FileName.file_path1);//领取


//        Thread.sleep(3000);
//        ShellUtil.swipe(569,1322); //刷新
//        Thread.sleep(2000);
//        ShellUtil.swipe(569, 1322); //刷新
                        if (!ShellUtil.checkPage(Constant.ZhangShangTouTiao.RES_ID_ITEM1, Constant.ZhangShangTouTiao.FileName.file_path1)) {
                            ShellUtil.back();
                        }
                        Thread.sleep(3000);
//                        if (ShellUtil.checkPage(Constant.ZhangShangTouTiao.RES_ID_ITEM1, Constant.ZhangShangTouTiao.FileName.file_path1)) {
                        while ((checkTime(startTime))) {
                            Thread.sleep(2 * 1000);
//            ShellUtil.swipe(569, 1322); //刷新
//            Thread.sleep(2000);
                            ShellUtil.swipe(569, 1322); //刷新
                            Thread.sleep(2 * 1000);

//            RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//            Thread.sleep(1 * 1000);

                            slideByXyIdsZhangShangTouTiao(64, 906, startTime);//点击item
                        }
//                        } else {
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.DIANDIANXINWEN) {//点点新闻
                Log.e(Constant.TAG, "点点新新闻启动");
                //region diandianxinnwen
                if (checkTime10(startTime)) {
                    try {
                        start(Constant.DianDianXinWen.ACTIVITY_PACKAGE);
                        Thread.sleep(1 * 1000);
                        Log.e(Constant.TAG, "返回");
                        ShellUtil.back();
                        Thread.sleep(2 * 1000);
                        ShellUtil.clickByXy(Constant.DianDianXinWen.RES_ID_BTN2, Constant.DianDianXinWen.FileName.file_path1); // 点击刷新
                        Thread.sleep(5 * 1000);


                        start(Constant.DianDianXinWen.ACTIVITY_PACKAGE);
                        Thread.sleep(1 * 1000);
                        Log.e(Constant.TAG, "返回");
                        ShellUtil.back();
                        Thread.sleep(2 * 1000);
                        Log.e(Constant.TAG, "点击btn1");
                        ShellUtil.clickByXy(Constant.DianDianXinWen.RES_ID_BTN1, Constant.DianDianXinWen.FileName.file_path1); // 点击刷新
                        Log.e(Constant.TAG, "点击item1");
                        Thread.sleep(4 * 1000);
//        while (!Thread.currentThread().isInterrupted() && flag) {
//                        if (ShellUtil.checkPage(Constant.DianDianXinWen.RES_ID_ITEM1, Constant.DianDianXinWen.FileName.file_path1)) {
                        while ((checkTime10(startTime))) {


                            Log.e(Constant.TAG, "点击");
//                                slideByXyIdsDianDianXinWen(Constant.DianDianXinWen.RES_ID_ITEM1, Constant.DianDianXinWen.FileName.file_path1, startTime); // 第一条是置顶
                            slideByXyIdsDianDianXinWen(83, 351, startTime); // 第一条是置顶
//            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.DianDianXinWen.RES_ID_ITEM1,Constant.DianDianXinWen.FileName.file_path1);
                            Log.e(Constant.TAG, "滑动");
//            ShellUtil.swipe(a[1],a[0]);
//            ShellUtil.swipeDownMethod1();
                            RootCmd.execRootCmd("input swipe 25 450 25 1450 700");//刷新
                        }
//                        } else {
//                            index++;
//                            continue;
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.SHANDIANKANKAN) {//闪电看看
                //region shandiankankan
                if (checkTime(startTime)) {
                    try {
                        start(Constant.ShanDianKanKan.ACTIVITY_PACKAGE);
                        Thread.sleep(10 * 1000);
                        ShellUtil.clickMethod(779, 1837); // 任务
                        Log.e(Constant.TAG, "闪电盒子任务");
                        Thread.sleep(2000);
                        ShellUtil.clickMethod(551, 789); // 拆红包
                        Log.e(Constant.TAG, "闪电盒子拆红包");
                        Thread.sleep(1000);
                        ShellUtil.clickMethod(527, 1303); // 签到

                        ShellUtil.clickMethod(124, 1830);//刷新
                        Log.e(Constant.TAG, "闪电盒子签到");
                        Thread.sleep(2000);
                        ShellUtil.clickMethod(1012, 1391); // 领取
                        Thread.sleep(2000);
                        ShellUtil.clickMethod(1012, 1391); //领取
                        Log.e(Constant.TAG, "闪电盒子领取");
                        Thread.sleep(4 * 1000);


                        start(Constant.ShanDianKanKan.ACTIVITY_PACKAGE);
//                        ShellUtil.clickMethod(707, 142);
                        Thread.sleep(4 * 1000);
                        Thread.sleep(2000);
                        ShellUtil.clickMethod(1012, 1391); // 领取
                        Thread.sleep(2000);
                        ShellUtil.clickMethod(1012, 1391); //领取
                        Log.e(Constant.TAG, "闪电盒子领取");
                        Thread.sleep(3 * 1000);
//                        if (ShellUtil.checkPage("c.l.a:id/tab_image", Constant.ShanDianKanKan.FileName.file_path1)) {
                        Log.e(Constant.TAG, "闪电盒子tab_image");
                        while ((checkTime(startTime))) {

                            //领取红包
//                                ShellUtil.clickMethod(990,1283);
//                                Log.e(Constant.TAG, "闪电盒子 领取红包");
//                                Thread.sleep(2000);
//                                ShellUtil.clickMethod(990,1283);
//                                Log.e(Constant.TAG, "闪电盒子 领取红包");
//                                Thread.sleep(2000);

                            ShellUtil.clickMethod(124, 1830);//刷新
                            Log.e(Constant.TAG, "闪电盒子刷新");
                            Thread.sleep(1000);
//                                RootCmd.execRootCmd("input swipe 25 900 25 550"); //滑动
                            Log.e(Constant.TAG, "闪电盒子滑动");
                            slideByXyIdsShanDianKanKan(63, 785, startTime);
                            Log.e(Constant.TAG, "闪电盒子点击文章");

//                            }
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            } else if (entity.flag_enum == Constant.ENUM.TUTOUTIAO) { //兔头条
                //region tutoutiao
                if (checkTime(startTime)) {
                    try {
                        start(Constant.TuTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(5 * 1000);
                        ShellUtil.clickMethod(755, 1853); //任务
                        Thread.sleep(10 * 1000);

                        start(Constant.TuTouTiao.ACTIVITY_PACKAGE);
                        Thread.sleep(5 * 1000);
                        ShellUtil.clickMethod(157, 163); //领钱
                        Thread.sleep(2 * 1000);
                        ShellUtil.clickByXy("com.news.tutoutiao:id/brdl_tv_sure", Constant.TuTouTiao.FileName.file_path1); //我知道了
                        ShellUtil.clickMethod(545, 1554); //领钱
                        Thread.sleep(3 * 1000);

                        ShellUtil.startActivity(Constant.TuTouTiao.ACTIVITY_PACKAGE);

                        while ((checkTime(startTime))) {
//                            com.news.tutoutiao:id/three_title
//                            ShellUtil
                            ShellUtil.clickMethod(93, 1708); //刷新
//                            ShellUtil.clickMethod(103,460); //第一条
                            Thread.sleep(2000);
                            slideByXyIdsTutoutiao(103, 460, startTime);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //endregion
            }

            // 判断12h
            Log.e(TAG, Thread.currentThread().getName() + "判断12h" + index);

            index++;
            checkTimeLimit();
            if (index >= listSize) {
                Log.e(TAG, Thread.currentThread().getName() + "判断12h" + index);
                index = 0;// 如果全部执行一遍结束之后 判断时间
            }
        }
    }

    private void start(String activity_name) throws InterruptedException {
        //region start
        Log.e(TAG, "start home" + Thread.currentThread().getName());
        ShellUtil.home();
        Thread.sleep(500);
        Log.e(TAG, "start clear" + Thread.currentThread().getName());
        ShellUtil.clearXiaoMi();
        Thread.sleep(500);
        Log.e(TAG, "start startActivity" + Thread.currentThread().getName());
        ShellUtil.startActivity(activity_name);
        Log.e(TAG, "start startActivity ssss" + Thread.currentThread().getName());
        Thread.sleep(10 * 1000);
        Log.e(TAG, "start startActivity 等待成功" + Thread.currentThread().getName());
        //endregion
    }


    /////////////////////////////
    // region all

    private void slideByXyIds2ZhiMa(int x1, int y1, long startTime) throws InterruptedException {
        ShellUtil.clickMethod(x1, y1);
        Thread.sleep(5000);

        int j = 0;
        while (j < 13 && (checkTime(startTime))) {

            Log.e(Constant.TAG, "芝麻头条 在滑动");
            RootCmd.execRootCmd("input swipe 25 900 25 450 500");
            Thread.sleep(200);
            Log.e(Constant.TAG, "芝麻头条 在滑动11111");
            j++;

        }
        Thread.sleep(1 * 1000);
        ShellUtil.back();
    }

    private void slideByXyIdsNotByDongFang(int x1, int y1, long startTime) throws InterruptedException {


        ShellUtil.clickMethod(x1, y1);
        Thread.sleep(2 * 1000);
        // 滑动
        int j = 0;
        while (j < 30 && (checkTime(startTime))) {

            RootCmd.execRootCmd("input keyevent 20 ");
            j++;
        }

//                ShellUtil.clickByXy(Constant.DongFang.RES_ID_BACK,Constant.DongFang.FileName.file_path1);
        ShellUtil.back();
//                if (!ShellUtil.checkPage(Constant.DongFang.RES_ID_ITEM1,Constant.DongFang.FileName.file_path1)) {
//                    ShellUtil.back();
//                }
        Thread.sleep(500);
        if (ShellUtil.checkPage("com.songheng.eastnews:id/x_", Constant.DongFang.FileName.file_path1)) { // 退出框
            ShellUtil.clickByXy("com.songheng.eastnews:id/x_", Constant.DongFang.FileName.file_path1);
        }


    }

    private void slideByXyIdsNotByDongFang(String res_id, String file_path, int pos, boolean flag, long startTime) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateWithTextDongFang(res_id, file_path);
        if (aa != null) {
            if (pos > aa.size()) {
                return;
            }
            for (int i = pos; i < aa.size() - 1; i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 30 && (checkTime(startTime))) {

                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                }

//                ShellUtil.clickByXy(Constant.DongFang.RES_ID_BACK,Constant.DongFang.FileName.file_path1);
                ShellUtil.back();
//                if (!ShellUtil.checkPage(Constant.DongFang.RES_ID_ITEM1,Constant.DongFang.FileName.file_path1)) {
//                    ShellUtil.back();
//                }
                Thread.sleep(500);
                if (ShellUtil.checkPage("com.songheng.eastnews:id/x_", Constant.DongFang.FileName.file_path1)) { // 退出框
                    ShellUtil.clickByXy("com.songheng.eastnews:id/x_", Constant.DongFang.FileName.file_path1);
                }
                if (!flag && i >= aa.size()) {
                    break;
                }
            }
        }

    }


    private void checkBackDongFang() throws InterruptedException {
//        ShellUtil.back();
        Thread.sleep(500);
        if (ShellUtil.checkPage("com.songheng.eastnews:id/w0", Constant.DongFang.FileName.file_path1)) { // 退出框
            ShellUtil.clickByXy("com.songheng.eastnews:id/w0", Constant.DongFang.FileName.file_path1);
        }
    }

    private void slideByXyIds2HuiTouTiao(int x1, int y1, long startTime) throws InterruptedException {
        ShellUtil.clickMethod(x1, y1);
        Thread.sleep(2000);
        ShellUtil.clickByXy("com.cashtoutiao:id/toolbar_icon", Constant.HuiTouTiao.FileName.file_path1); // 网页关闭
        int j = 0;
        while (j < 18 && (checkTime(startTime))) {

            Log.e(Constant.TAG, "惠头条 在滑动");
            RootCmd.execRootCmd("input swipe 25 900 25 450 500");
//            Thread.sleep(200);
            Log.e(Constant.TAG, "惠头条 在滑动11111");
            ShellUtil.clickByXy(Constant.HuiTouTiao.XIAZAIQUXIAO, Constant.HuiTouTiao.FileName.file_path1);
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
            ShellUtil.clickMethod(500, 143); //评论框
            j++;

        }
        Thread.sleep(1 * 1000);
        Log.e(Constant.TAG, "惠头条 返回了");
        ShellUtil.back();
//        Thread.sleep(1 * 1000);
//        if (!ShellUtil.checkPage(Constant.HuiTouTiao.RES_ID_ITEM1, Constant.HuiTouTiao.FileName.file_path1) ) {
//            ShellUtil.back();
//        }
        ShellUtil.startActivity(Constant.HuiTouTiao.HOME_PAGE); //打开首页
        ShellUtil.startActivity(Constant.HuiTouTiao.PACKAGE_NAME); //打开首页
        Thread.sleep(1 * 1000);
        Log.e(Constant.TAG, "惠头条 打开首页");
    }

    private void slideByXyIds2HuiTouTiao(String res_id, String file_path, long startTime) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            for (int i = 2; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "点击坐标");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 18 && (checkTime(startTime))) {

                    Log.e(Constant.TAG, "惠头条 在滑动");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    Thread.sleep(500);
                    j++;

                }
                Thread.sleep(1 * 1000);
                Log.e(Constant.TAG, "惠头条 返回了");
                ShellUtil.back();
            }
        }

    }

    private void slideByXyIds6JuHeTouTiao(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "slideByXyIds6");
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            Log.e(Constant.TAG, "点击坐标");
            for (int i = 0; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "点击坐标11111111111");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(5 * 1000);

                for (int k = 0; k < 2; k++) {
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                }
                Log.e(Constant.TAG, "滑动聚合头条点击展开全文");
//                ShellUtil.clickMethod(554,1226);
                ShellUtil.clickMethod(548, 942);
                ShellUtil.clickMethod(548, 1144);

                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 18 && (checkTime(startTime))) {

                    Log.e(Constant.TAG, "聚合头条在滑动");
                    Log.e(Constant.TAG, "滑动聚合头条");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 1000");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    j++;
                    Thread.sleep(500);

                }
//                int k = 0;
//                while (k<23) {
//                    Log.e(Constant.TAG,"在滑动");
//                    RootCmd.execRootCmd("input swipe 25 450 25 1050 700");
////                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//                    k++;
//                }
                Thread.sleep(1 * 1000);
                Log.e(Constant.TAG, "聚合头条 返回了");
                ShellUtil.back();
                Thread.sleep(1 * 1000);
                if (!ShellUtil.checkPage(Constant.JuHeTouTiao.RES_ID_ITEM1, Constant.JuHeTouTiao.FileName.file_path1)) {
                    ShellUtil.back();
                }
            }
        }

    }

    private void beforeZhongQing() throws InterruptedException {
        Log.e(Constant.TAG, "去拆现金 zhongqingzhognqing" + Thread.currentThread().getName());
        start(Constant.ZhongQing.ACTIVITY_PACKAGE);
        Thread.sleep(6 * 1000);

        Log.e(Constant.TAG, "去拆现金 zhongqingzhognqing" + Thread.currentThread().getName());
        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED, Constant.ZhongQing.FileName.file_path1))
            ShellUtil.back(); //红包页面

        if (ShellUtil.checkPage(Constant.ZhongQing.DIALOG_PASS, Constant.ZhongQing.FileName.file_path1)) {
            ShellUtil.clickByXy(Constant.ZhongQing.DIALOG_PASS, Constant.ZhongQing.FileName.file_path1);
        }
        Log.e(Constant.TAG, "去拆现金 zhongqingzhognqing" + Thread.currentThread().getName());

        // 点击红包
        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED_CLOSE, Constant.ZhongQing.FileName.file_path1)) {
            ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_RED_CLOSE, Constant.ZhongQing.FileName.file_path1);
        }


        //check弹框 提现弹框
        if (ShellUtil.checkPage(Constant.ZhongQing.DIALOG, Constant.ZhongQing.FileName.file_path3)) {
            ShellUtil.clickByXy(Constant.ZhongQing.DIALOG_TASK, Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG, "去拆现金 zhongqingzhognqing" + Thread.currentThread().getName());
            Thread.sleep(2 * 1000);
            ShellUtil.clickByXy(Constant.ZhongQing.DIALOG_BACK, Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG, "点击返回 zhongqingzhognqing" + Thread.currentThread().getName());
//                ShellUtil.back();
            ShellUtil.clickByXyText(Constant.ZhongQing.DIALOG_TEXT, Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG, "放弃提现 zhongqingzhognqing" + Thread.currentThread().getName());
            Thread.sleep(2 * 1000);
            ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1, Constant.ZhongQing.FileName.file_path1); // 点击刷新
        }

    }

    private void slideByXyIdsZHONGQING(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 111111 zhongqingzhognqing" + Thread.currentThread().getName());
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 122222 zhongqingzhognqing" + Thread.currentThread().getName());


//       Map<String, Integer> aa = DOMTest.getCoordinateWithResourceId(res_id, file_path);
//        Log.e(Constant.TAG,"keyevent 1");
//        if (aa!=null) {
//            int x1 = aa.get("x1");
//            int y1 = aa.get("y1");
//            clickMethod(x1, y1);
//            Log.e(Constant.TAG, "keyevent 1");
//            Thread.sleep(2 * 1000);
//            Log.e(Constant.TAG, "keyevent 2");
//            // 滑动
//            int j = 0;
//            while (j < 50) {
//                Log.e(Constant.TAG, "keyevent 20");
//                RootCmd.execRootCmd("input keyevent 20 ");
//                j++;
//            }
//            Log.e(Constant.TAG, "keyevent 1");
//            Thread.sleep(1 * 1000);
//            ShellUtil.back();
//            Thread.sleep(1 * 1000);
//        }


        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateWithTextZhongQing(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 133333 zhongqingzhognqing" + Thread.currentThread().getName());
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 14444444 zhongqingzhognqing" + Thread.currentThread().getName());
            for (int i = 1; i < aa.size(); i++) {

                Log.e(Constant.TAG, "keyevent 1555555 zhongqingzhognqing" + Thread.currentThread().getName());
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 166666 zhongqingzhognqing" + Thread.currentThread().getName());
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 277777777 zhongqingzhognqing" + Thread.currentThread().getName());
                // 滑动
                int j = 0;
                while (j < 50 && (checkTime(startTime))) {
                    Log.e(Constant.TAG, "keyevent 20888888 zhongqingzhognqing" + Thread.currentThread().getName());
                    RootCmd.execRootCmd("input keyevent 20 ");
                    Thread.sleep(1 * 1000);
                    j++;

                }
                Log.e(Constant.TAG, "keyevent 199999999 zhongqingzhognqing" + Thread.currentThread().getName());
                Thread.sleep(1 * 1000);
                ShellUtil.back();
                Thread.sleep(1 * 1000);
            }
        }

    }

    private void beforeQuTouTiao() throws InterruptedException {
        Log.e(Constant.TAG, "before qutoutiao" + Thread.currentThread().getName());
        start(Constant.QuTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(5 * 1000);
    }

    private void slideByXyIdsNotQuTouTiao(String res_id, String file_path, int pos, long startTime) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "before bbbbbbbbbb" + Thread.currentThread().getName());
        if (aa == null || pos > aa.size()) {
            aa = DOMTest.getCoordinateListWithResourceId(Constant.QuTouTiao.RES_ID_ITEM111, file_path);
            Log.e(Constant.TAG, "before aa  aa aa aa aa aaaa aa aa aa aa aa aa aa aa" + Thread.currentThread().getName());
        }
        if (aa == null || pos > aa.size()) {
            aa = DOMTest.getCoordinateListWithResourceId(Constant.QuTouTiao.RES_ID_ITEM1111, file_path);
            Log.e(Constant.TAG, "before aa  aa aa aa aa aaaa aa aa aa aa aa aa aa aa" + Thread.currentThread().getName());
        }
        if (aa != null) {
            if (pos > aa.size()) {
                return;
            }
            for (int i = pos; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
//                ShellUtil.clickMethod(x1, y1);
//                Thread.sleep(1 * 1000);
                ShellUtil.clickMethod(x1, y1);

                Thread.sleep(1000);
                // 滑动
                int j = 0;
                while (j < 35 && (checkTime(startTime))) {

                    Log.e(Constant.TAG, "before keyevent 20 " + Thread.currentThread().getName());
                    RootCmd.execRootCmd("input keyevent 20 ");
                    Thread.sleep(500);
                    j++;

                }
                ShellUtil.back();
                Thread.sleep(1000);
                ShellUtil.clickByXy(Constant.QuTouTiao.SUOPING, Constant.QuTouTiao.FileName.file_path1); //锁屏
                ShellUtil.clickByXy(Constant.QuTouTiao.SUOPING3, Constant.QuTouTiao.FileName.file_path1); //锁屏
                ShellUtil.clickByXy(Constant.QuTouTiao.SUOPING1, Constant.QuTouTiao.FileName.file_path1); //锁屏
                ShellUtil.clickByXy(Constant.QuTouTiao.QIANDAOTANCHUANG, Constant.QuTouTiao.FileName.file_path1);//签到弹窗
                ShellUtil.clickByXy(Constant.QuTouTiao.YAOQING, Constant.QuTouTiao.FileName.file_path1);//邀请好友
                Thread.sleep(1000);
            }
        }

    }

    public void slideByXyIdsNotQuTouTiao(int x1, int y1, long startTime) throws InterruptedException {
//        ShellUtil.createXMLFile(file_path);
//        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
//        if (aa != null) {
//            if (pos > aa.size()) {
//                return;
//            }
//            for (int i = pos; i < aa.size(); i++) {
//                int x1 = aa.get(i + "").get("x1");
//                int y1 = aa.get(i + "").get("y1");
//                ShellUtil.clickMethod(x1, y1);
//                Thread.sleep(1 * 1000);
        ShellUtil.clickMethod(x1, y1);
        Thread.sleep(2 * 1000);
        // 滑动
        int j = 0;
        while (j < 35 && (checkTime(startTime))) {

            Log.e(Constant.TAG, "before keyevent 20 " + Thread.currentThread().getName());
            RootCmd.execRootCmd("input keyevent 20 ");
            Thread.sleep(500);
            j++;

        }
        ShellUtil.back();
        ShellUtil.clickByXy("com.jifen.qukan:id/so", Constant.QuTouTiao.FileName.file_path1);//锁屏
        ShellUtil.clickByXy(Constant.QuTouTiao.YAOQING, Constant.QuTouTiao.FileName.file_path1);//邀请好友
        Thread.sleep(1000);
        ShellUtil.startActivity(Constant.QuTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(1000);
//            }
//        }

    }

    private void beforeMaYiTouTiao() throws InterruptedException {
        start(Constant.MaYi.ACTIVITY_PACKAGE);
//        ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
        Thread.sleep(10 * 1000);
        ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
        Log.e(Constant.TAG, "点击btn1000000000");
        if (ShellUtil.checkPage(Constant.MaYi.DIALOG_RED, Constant.MaYi.FileName.file_path1)) {
            ShellUtil.back();
            ShellUtil.clickByXy(Constant.MaYi.RES_ID_RED, Constant.MaYi.FileName.file_path1); // 红包
        }
        Log.e(Constant.TAG, "点击btn1999999999999999999");
    }

    private void slideByXyIdsMAYI(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");


        Map<String, Integer> aa = DOMTest.getCoordinateWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            int x1 = aa.get("x1");
            int y1 = aa.get("y1");
            ShellUtil.clickMethod(x1, y1);
            Log.e(Constant.TAG, "keyevent 1");
            Thread.sleep(2 * 1000);
            Log.e(Constant.TAG, "keyevent 2");
            // 滑动
            int j = 0;
            while (j < 20 && (checkTime(startTime))) {
                Log.e(Constant.TAG, "keyevent 20");

//                RootCmd.execRootCmd("input keyevent 20 ");
                RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
//                Thread.sleep(2 * 1000);
                j++;

            }
            Log.e(Constant.TAG, "keyevent 1");
            Thread.sleep(1 * 1000);
            ShellUtil.back();
            Thread.sleep(1 * 1000);
            ShellUtil.startActivity(Constant.MaYi.ACTIVITY_PACKAGE);
            Log.e(Constant.TAG, "蚂蚁头条 首页");
        }
    }

    private void slideByXyIds2TouTiaoDuoDuo(String res_id, String file_path, long startTime, int index) throws InterruptedException {

        RootCmd.execRootCmd("input swipe 25 1050 25 350 500");

        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            for (int i = index; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "点击坐标");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 23 && (checkTime(startTime))) {

                    Log.e(Constant.TAG, "头条多多在滑动");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//                    Thread.sleep(20);
                    // com.lite.infoflow.browser:id/a71
//                    if (j > 10) {
//                        Log.e(Constant.TAG, "头条多多判断了刮刮卡");
//                        ShellUtil.clickByXy(Constant.TouTiaoDuoDuo.RES_ID_JINBI, Constant.TouTiaoDuoDuo.FileName.file_path1);//金币
//                    }
                    j++;

                }
                Thread.sleep(1 * 1000);
                Log.e(Constant.TAG, "头条多多 返回了");
                ShellUtil.back();
            }
        }

    }

    private void slideByXyIds4Brower2345(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 11111111111 Browser2345Runnable" + Thread.currentThread().getName());
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 122222 Browser2345Runnable" + Thread.currentThread().getName());
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 13333333 Browser2345Runnable" + Thread.currentThread().getName());
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1444444 Browser2345Runnable" + Thread.currentThread().getName());
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 15555555 Browser2345Runnable" + Thread.currentThread().getName());
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 166666666 Browser2345Runnable" + Thread.currentThread().getName());
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2777777777 Browser2345Runnable" + Thread.currentThread().getName());
                // 滑动
                int j = 0;
                RootCmd.execRootCmd("input tap 349 216");
                while (j < 30 && (checkTime(startTime))) {

                    Log.e(Constant.TAG, "keyevent 2088888Browser2345" + Thread.currentThread().getName());
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                    Thread.sleep(500);

                }
                Log.e(Constant.TAG, "keyevent 1999999999 Browser2345Runnable" + Thread.currentThread().getName());
                ShellUtil.back();
                ShellUtil.swipe(1150, 600);//滑动
                Thread.sleep(1000);
            }
        }

    }

    private void beforeWeiLiKanKan() throws InterruptedException {
        start(Constant.WeiLiKanKan.ACTIVITY_PACKAGE);
        Thread.sleep(3 * 1000);
        if (ShellUtil.checkPage(Constant.WeiLiKanKan.RES_ID_RED, Constant.WeiLiKanKan.FileName.file_path1)) {
            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_RED, Constant.WeiLiKanKan.FileName.file_path1);
            Thread.sleep(2 * 1000);
            ShellUtil.clickByXy(Constant.WeiLiKanKan.RES_ID_RED_CLOSE, Constant.WeiLiKanKan.FileName.file_path1);
        }
        Thread.sleep(2 * 1000);

    }

    private void slideByXyIds2WeiLiKanKan(String res_id, String file_path, long startTime) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null && aa.size() > 1) {
            for (int i = 0; i < 1; i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "微鲤看看 点击坐标");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(3 * 1000);
                // 滑动
                int j = 0;
                while (j < 18 && (checkTime(startTime))) {
//                    Log.e(Constant.TAG, "flag在滑动11111" + flag);
//                    Log.e(Constant.TAG, "flag在滑动11111" + (checkTime(startTime)));
                    if (!flag) break;
                    Log.e(Constant.TAG, "在滑动11111");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    j++;
//                    Thread.sleep(500);
                }
                ShellUtil.clickByXy(Constant.WeiLiKanKan.ZHIDAOLE, Constant.WeiLiKanKan.FileName.file_path1);
//                Thread.sleep(500);
                Log.e(Constant.TAG, "微鲤看看 返回了");
                ShellUtil.back();
                ShellUtil.clickByXy("cn.weli.story:id/text_ok", Constant.WeiLiKanKan.FileName.file_path1); //阅读1分钟还有

                ShellUtil.startActivity(Constant.WeiLiKanKan.HOME_PAGE);
                Log.e(Constant.TAG, "微鲤看看 打开首页");
//                Thread.sleep(500);
            }
        }

    }

    private void slideByXyIdsJiuCaiTouTiao(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 30 && (checkTime15(startTime))) {

                    Log.e(Constant.TAG, "keyevent 20");
//                    RootCmd.execRootCmd("input keyevent 20 ");
                    RootCmd.execRootCmd("input swipe 25 1000 25 550");
                    j++;

                }
                Log.e(Constant.TAG, "keyevent 1");
//                ShellUtil.back();
                ShellUtil.clickByXy(Constant.JiuCaiZiXun.BACK, Constant.JiuCaiZiXun.FileName.file_path1);
            }
        }

    }

    public void slideByXyIds5HongBaoTouTiao(int x1, int y1, long startTime) throws InterruptedException {
//        Log.e(Constant.TAG, "keyevent 1");
//        ShellUtil.createXMLFile(file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateWithTextHongbaoTouTiao(res_id, file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        if (aa != null) {
//            Log.e(Constant.TAG, "keyevent 1");
//            for (int i = 0; i < aa.size(); i++) {
//                Log.e(Constant.TAG, "keyevent 1");
//                int x1 = aa.get(i + "").get("x1");
//                int y1 = aa.get(i + "").get("y1");
        ShellUtil.clickMethod(x1, y1);
//                Log.e(Constant.TAG,"keyevent 1");
        Thread.sleep(2 * 1000);
//                Log.e(Constant.TAG,"keyevent 2");
        // 滑动
        int j = 0;
        while (j < 2 && (checkTime(startTime))) {
            for (int k = 0; k < 5; k++) {
                if ((checkTime(startTime))) {
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
                    Thread.sleep(500);
                }

            }
            Thread.sleep(2 * 1000);
            j++;
        }
//                }
//                Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.back();
        ShellUtil.startActivity(Constant.HongBaoTouTiao.ACTIVITY_PACKAGE);
//            }
    }


    public void slideByXyIds5HongBaoTouTiao(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateWithTextHongbaoTouTiao(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
//                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(2 * 1000);
//                Log.e(Constant.TAG,"keyevent 2");
                // 滑动
                int j = 0;
                while (j < 2 && (checkTime(startTime))) {
                    for (int k = 0; k < 5; k++) {
                        if ((checkTime(startTime))) {
                            RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
                            Thread.sleep(500);
                        }

                    }
                    Thread.sleep(2 * 1000);
                    j++;
                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }

    private boolean openActivityXinTouTiao(boolean flag) throws InterruptedException {
        Log.e(Constant.TAG, "打开应用" + Thread.currentThread().getName());
        start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(6 * 1000);
        Log.e(Constant.TAG, "检测首页" + Thread.currentThread().getName());
        if (checkHomeXinTouTiao(Constant.XinTouTiao.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1)) {
            // 进行操作
            Log.e(Constant.TAG, "进行操作" + Thread.currentThread().getName());

            return true;

        } else {
            Log.e(Constant.TAG, "判断首页失败" + Thread.currentThread().getName());
            // 判断首页失败
            if (flag) {
                Log.e(Constant.TAG, "重新判断" + Thread.currentThread().getName());
                openActivityXinTouTiao(false);
            }
        }
        return false;
    }

    private boolean checkHomeXinTouTiao(String id, String path) throws InterruptedException {
        /*
         * strart
         * check
         * */
        Log.e(Constant.TAG, "checkHome1" + Thread.currentThread().getName());
        if (ShellUtil.checkPage(id, path)) {
            Log.e(Constant.TAG, "checkHome1true" + Thread.currentThread().getName());
            return true;
        } else {
            Log.e(Constant.TAG, "checkHome1back" + Thread.currentThread().getName());
            Thread.sleep(1000);
            ShellUtil.back();
            Log.e(Constant.TAG, "checkHome2" + Thread.currentThread().getName());
            if (ShellUtil.checkPage(id, path)) {
                Log.e(Constant.TAG, "checkHome2true" + Thread.currentThread().getName());
                return true;
            } else {
                Log.e(Constant.TAG, "checkHome2back" + Thread.currentThread().getName());
                ShellUtil.back();
                Thread.sleep(1000);
                Log.e(Constant.TAG, "checkHome3" + Thread.currentThread().getName());
                if (ShellUtil.checkPage(id, path)) {
                    Log.e(Constant.TAG, "checkHome3true" + Thread.currentThread().getName());
                    return true;
                } else {
                    Log.e(Constant.TAG, "checkHome3false" + Thread.currentThread().getName());
                    return false;
                }
            }
        }
    }

    public void slideByXyIdsXinTouTiao(String res_id, String file_path, int pos, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(pos + "").get("x1");
                int y1 = aa.get(pos + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 8 && (checkTime(startTime))) {
                    Log.e(Constant.TAG, "input swipe 25 1000 25 550");
                    RootCmd.execRootCmd("input swipe 25 1000 25 550");
                    j++;
                    Thread.sleep(3000);
                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
                Thread.sleep(3000);
                ShellUtil.startActivity(Constant.XinTouTiao.MAIN_ACTIVITY);
                break;
            }
        }

    }

    private void slideByXyIdsDaZhongKanDian(int x1, int y1, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
//        ShellUtil.createXMLFile(file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        if (aa != null) {
        Log.e(Constant.TAG, "keyevent 1");
//            for (int i = 0; i < aa.size(); i++) {
        Log.e(Constant.TAG, "keyevent 1");
//                int x1 = aa.get(i + "").get("x1");
//                int y1 = aa.get(i + "").get("y1");
        ShellUtil.clickMethod(x1, y1);
        Log.e(Constant.TAG, "keyevent 1");
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "keyevent 2");
        // 滑动
        int j = 0;
        while (j < 25 && (checkTime(startTime))) {

            Log.e(Constant.TAG, "keyevent 20");
//                        RootCmd.execRootCmd("input keyevent 20 ");
            RootCmd.execRootCmd("input swipe 25 1000 25 550");
            j++;
            Thread.sleep(500);

        }
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.back();
//            }
//        }

    }

    private void slideByXyIdsDaZhongKanDian(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 25 && (checkTime(startTime))) {

                    Log.e(Constant.TAG, "keyevent 20");
//                        RootCmd.execRootCmd("input keyevent 20 ");
                    RootCmd.execRootCmd("input swipe 25 1000 25 550");
                    j++;
                    Thread.sleep(500);

                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }

    private void slideByXyIdsYinLiZiXun(String res_id, String file_path, int pos, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(pos + "").get("x1");
                int y1 = aa.get(pos + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 15 && (checkTime(startTime))) {
                    Thread.sleep(3000);
                    Log.e(Constant.TAG, "input swipe 25 1000 25 550");
                    RootCmd.execRootCmd("input swipe 25 1000 25 550");
                    j++;
                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
                break;
            }
        }

    }

    private void slideByXyIdsZhangShangTouTiao(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 1; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                Thread.sleep(2000);
                int j = 0;
                while (j < 18 && (checkTime(startTime))) {
                    Log.e(Constant.TAG, "keyevent 20");
//                    RootCmd.execRootCmd("input keyevent 20 ");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 2000");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    ShellUtil.clickByXy(Constant.ZhangShangTouTiao.ZHANGKAIQUANWEN, Constant.ZhangShangTouTiao.FileName.file_path1);
//                    Thread.sleep(50);
                    j++;

                }
                int k = 0;
                while (k < 7) {
                    RootCmd.execRootCmd("input swipe 25 450 25 1050 500");
                    Thread.sleep(100);
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    Thread.sleep(800);
                    k++;
                }
                Log.e(Constant.TAG, "keyevent 1 back");
                ShellUtil.back();
            }
        }

    }

    private void slideByXyIdsZhangShangTouTiao(int x1, int y1, long startTime) throws InterruptedException {
//        Log.e(Constant.TAG, "keyevent 1");
//        ShellUtil.createXMLFile(file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        if (aa != null) {
        Log.e(Constant.TAG, "keyevent 1");
//            for (int i = 1; i < aa.size(); i++) {
//                Log.e(Constant.TAG, "keyevent 1");
//                int x1 = aa.get(i + "").get("x1");
//                int y1 = aa.get(i + "").get("y1");
        ShellUtil.clickMethod(x1, y1);
        Log.e(Constant.TAG, "keyevent 1");
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "keyevent 2");
        // 滑动
        Thread.sleep(2000);
        int j = 0;
        while (j < 23 && (checkTime(startTime))) {
            Log.e(Constant.TAG, "keyevent 20");
//                    RootCmd.execRootCmd("input keyevent 20 ");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 2000");
            RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
            ShellUtil.clickByXy(Constant.ZhangShangTouTiao.ZHANGKAIQUANWEN, Constant.ZhangShangTouTiao.FileName.file_path1);
//                    Thread.sleep(50);
            j++;

        }
        int k = 0;
        while (k < 7) {
            RootCmd.execRootCmd("input swipe 25 450 25 1050 500");
            Thread.sleep(100);
            RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
            Thread.sleep(800);
            k++;
        }
        Log.e(Constant.TAG, "keyevent 1 back");
        ShellUtil.back();
//            }
//        }

    }


    private void slideByXyIdsDianDianXinWen(int x1, int y1, long startTime) throws InterruptedException {
//        Log.e(Constant.TAG, "keyevent 1");
//        ShellUtil.createXMLFile(file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        if (aa != null) {
        Log.e(Constant.TAG, "keyevent 1");
//            for (int i = 0; i < aa.size(); i++) {
        Log.e(Constant.TAG, "keyevent 1");
//                int x1 = aa.get(i + "").get("x1");
//                int y1 = aa.get(i + "").get("y1");
        ShellUtil.clickMethod(x1, y1);
        Log.e(Constant.TAG, "keyevent 1");
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "keyevent 2");
        // 滑动
        int j = 0;
        while (j < 25 && (checkTime10(startTime))) {

            Log.e(Constant.TAG, "keyevent 20");
            RootCmd.execRootCmd("input keyevent 20 ");
            j++;
//                    Thread.sleep(500);

        }
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.back();
//            }
//        }

    }

    private void slideByXyIdsDianDianXinWen(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG, "keyevent 1");
                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 25 && (checkTime(startTime))) {

                    Log.e(Constant.TAG, "keyevent 20");
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
//                    Thread.sleep(500);

                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }

    public void slideByXyIdsShanDianKanKan(String res_id, String file_path, long startTime) throws InterruptedException {
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG, "keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG, "keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG, "keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG, "keyevent 1");
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                Log.e(Constant.TAG, "闪电盒子keyevent 1" + x1 + ":" + y1);
                ShellUtil.clickMethod(x1, y1);
                if (ShellUtil.checkPageByText("使用以下方式打开", Constant.ShanDianKanKan.FileName.file_path1) || ShellUtil.checkPageByText("打包安装程序", Constant.ShanDianKanKan.FileName.file_path1)) {
                    ShellUtil.back();
                }
                Log.e(Constant.TAG, "keyevent 1");
//                Thread.sleep(2 * 1000);
                Log.e(Constant.TAG, "keyevent 2");
                // 滑动
                int j = 0;
                while (j < 40 && (checkTime(startTime))) {
                    Log.e(Constant.TAG, "keyevent 20");
//                    RootCmd.execRootCmd("input keyevent 20 ");
                    Thread.sleep(1000);
                    j++;
                }
                Thread.sleep(1000);
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
            }
        }

    }

    public void slideByXyIdsShanDianKanKan(int x1, int y1, long startTime) throws InterruptedException {
//        Log.e(Constant.TAG, "keyevent 1");
//        ShellUtil.createXMLFile(file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        if (aa != null) {
//            Log.e(Constant.TAG, "keyevent 1");
//            for (int i = 0; i < aa.size(); i++) {
//                Log.e(Constant.TAG, "keyevent 1");
//                int x1 = aa.get(i + "").get("x1");
//                int y1 = aa.get(i + "").get("y1");
//                Log.e(Constant.TAG, "闪电盒子keyevent 1" + x1 + ":" + y1);
        ShellUtil.clickMethod(x1, y1);
        if (ShellUtil.checkPageByText("使用以下方式打开", Constant.ShanDianKanKan.FileName.file_path1) || ShellUtil.checkPageByText("打包安装程序", Constant.ShanDianKanKan.FileName.file_path1)) {
            ShellUtil.back();
        }
        Log.e(Constant.TAG, "keyevent 1");
//                Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "keyevent 2");
        // 滑动
        int j = 0;
        while (j < 30 && (checkTime(startTime))) {
            Log.e(Constant.TAG, "keyevent 20");
//                    RootCmd.execRootCmd("input keyevent 20 ");
            Thread.sleep(1000);
            j++;
        }
        Thread.sleep(1000);
        Log.e(Constant.TAG, "keyevent 1");
        ShellUtil.back();
//            }
//        }

    }

    private void slideByXyIdsTutoutiao(int x1, int y1, long startTime) throws InterruptedException {
//        Log.e(Constant.TAG, "keyevent 1");
//        ShellUtil.createXMLFile(file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
//        Log.e(Constant.TAG, "keyevent 1");
//        if (aa != null) {
        Log.e(Constant.TAG, "keyevent 1");
//            for (int i = 0; i < aa.size(); i++) {
//                Log.e(Constant.TAG, "keyevent 1");
//                int x1 = aa.get(i + "").get("x1");
//                int y1 = aa.get(i + "").get("y1");
//                Log.e(Constant.TAG, "闪电盒子keyevent 1" + x1 + ":" + y1);
        ShellUtil.clickMethod(x1, y1);
        Log.e(Constant.TAG, "闪电盒子点击坐标");
//        if (ShellUtil.checkPageByText("使用以下方式打开", Constant.ShanDianKanKan.FileName.file_path1) || ShellUtil.checkPageByText("打包安装程序", Constant.ShanDianKanKan.FileName.file_path1)) {
//            ShellUtil.back();
//        }

//                Thread.sleep(2 * 1000);

        // 滑动
        int j = 0;
        while (j < 25 && (checkTime(startTime))) { //30秒获取金币
            Log.e(Constant.TAG, "闪电盒子 keyevent 20");
//            RootCmd.execRootCmd("input keyevent 20 ");
            RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//                    Thread.sleep(500);
            Thread.sleep(1000);
            j++;
        }
        while (j < 5 && (checkTime(startTime))) { //30秒获取金币
            Log.e(Constant.TAG, "闪电盒子 keyevent 20");
//            RootCmd.execRootCmd("input keyevent 20 ");
            RootCmd.execRootCmd("input swipe 25 450 25 1050 500");
//                    Thread.sleep(500);
            Thread.sleep(1000);
            j++;
        }
        while (j < 5 && (checkTime(startTime))) { //30秒获取金币
            Log.e(Constant.TAG, "闪电盒子 keyevent 20");
//            RootCmd.execRootCmd("input keyevent 20 ");
            RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//                    Thread.sleep(500);
            Thread.sleep(1000);
            j++;
        }
        Thread.sleep(1000);
        Log.e(Constant.TAG, "闪电盒子 back");
        ShellUtil.back();
//            }
//        }

    }

    // endregion
    /////////////////////////////////////
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    private void initData(int timeFlag) {

        String str = SharedPreferencesUtils.getPreferences(App.mContext).getString(Constant.BEFORE_TEXT, "");
        String str1 = SharedPreferencesUtils.getPreferences(App.mContext).getString(Constant.AFTER_TEXT, "");
//        if (!str.equals("")) {
//            List<TabEntity> beforelist1 = GsonUtil.changeGsonToList(str, TabEntity.class);
//            for (TabEntity tab : beforelist1) {
//                Log.e(Constant.TAG, tab.check + "：" + tab.flag_enum + "：" + tab.text);
//            }
////            first_list.addAll(beforelist1);
//        }
//        if (!str1.equals("")) {
//            List<TabEntity> afterlist2 = GsonUtil.changeGsonToList(str1, TabEntity.class);
//            for (TabEntity tab2 : afterlist2) {
//                Log.e(Constant.TAG, tab2.check + "：" + tab2.flag_enum + "：" + tab2.text);
//            }
////            second_list.addAll(afterlist2);
//        }

        if (timeFlag == 1) {
            list.clear();
            if (!str.equals("")) {
                List<TabEntity> beforelist1 = GsonUtil.changeGsonToList(str, TabEntity.class);
                list.addAll(beforelist1);
            }
//            list.add(new TabEntity("huitoutiao", Constant.ENUM.HUITOUTIAO, 1));
//            list.add(new TabEntity("juhetoutiao", Constant.ENUM.JUHETOUTIAO, 1));

//            list.add(new TabEntity("da", Constant.ENUM.DONGFANGTOUTIAO, 1));
//            list.add(new TabEntity("222222", Constant.ENUM.ZHONGQINGKANDIAN, 1));
        } else if (timeFlag == 2) {
            list.clear();
            if (!str1.equals("")) {
                List<TabEntity> afterlist2 = GsonUtil.changeGsonToList(str1, TabEntity.class);
                list.addAll(afterlist2);
            }
//            list.add(new TabEntity("33333", Constant.ENUM.QUTOUTIAO, 2));
//            list.add(new TabEntity("44444", Constant.ENUM.MAYITOUTIAO, 2));
//            list.add(new TabEntity("55555", Constant.ENUM.TOUTIAODUODUO, 2));
        }
    }


    private boolean checkTime(long startTime) {
        if (System.currentTimeMillis() - startTime < min && flag) {
            return true;
        }
        return false;
    }

    private boolean checkTime10(long startTime) {
        if (System.currentTimeMillis() - startTime < min10 && flag) {
            return true;
        }
        return false;
    }

    private boolean checkTime15(long startTime) {
        if (System.currentTimeMillis() - startTime < min15 && flag) {
            return true;
        }
        return false;
    }

}
