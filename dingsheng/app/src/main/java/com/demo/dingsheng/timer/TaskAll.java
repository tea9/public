package com.demo.dingsheng.timer;

import android.util.Log;
import com.demo.dingsheng.entitiy.TabEntity;
import com.demo.dingsheng.timer.task.*;
import com.demo.dingsheng.util.Constant;

import java.util.List;

/**
 * created by tea9 at 2018/12/26
 */
public class TaskAll {

//    private static List<TabEntity> data=new ArrayList<>();

//    private static List<TabEntity> before

    private static Thread thread;


    // 传递过来的得是true
    public static void init_task(int index, boolean flag, List<TabEntity> list1, List<TabEntity> list2) {

        if (list1.size()==0){
            flag = false;
        }
        if (list2.size()==0){
            flag = true;
        }

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            }
        };
        closeAll();
        MainService.interruptThread();

        Log.e(Constant.TAG, "index" + index);
        Log.e(Constant.TAG, "flag" + flag);
        if (flag) {
            TabEntity tabEntity;
            if (list1.size() <= 0) {
                return;
            }
            if (index < 1)
                tabEntity = list1.get(0);
            else {
                try {
                    tabEntity = list1.get(index - 1);
                } catch (IndexOutOfBoundsException e) {
                    tabEntity = list1.get(0);
                }
            }




//            if (tabEntity.flag_enum == Constant.ENUM.DONGFANGTOUTIAO) {
//                runnable = new DongFangRunnable();
//            } else
             if (tabEntity.flag_enum == Constant.ENUM.XINTOUTIAO) {
                XinTouTiaoRunnable.flag=true;
                runnable = new XinTouTiaoRunnable();
            }else if (tabEntity.flag_enum == Constant.ENUM.ZHONGQINGKANDIAN) {
                ZhongQingRunnable.flag=true;
                runnable = new ZhongQingRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.QUTOUTIAO) {
                QuTouTiaoRunnable.flag=true;
                runnable = new QuTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.MAYITOUTIAO) {
                MaYiTouTiaoRunnable.flag=true;
                runnable = new MaYiTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.TOUTIAODUODUO) {
                TouTiaoDuoDuoRunnable.flag=true;
                runnable = new TouTiaoDuoDuoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.BROWER2345) {
                Browser2345Runnable.flag=true;
                runnable = new Browser2345Runnable();
            }
        } else {
            TabEntity tabEntity;
            if (list2.size() <= 0) {
                return;
            }
            if (index < 1)
                tabEntity = list2.get(0);
            else {
                try {
                    tabEntity = list2.get(index - 1);
                } catch (IndexOutOfBoundsException e) {
                    tabEntity = list2.get(0);
                }
            }

            if (tabEntity.flag_enum == Constant.ENUM.WEILIKANKAN) {
                WeiLiKanKanRunnable.flag=true;
                runnable = new WeiLiKanKanRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.JIUCAITOUTIAO) {
                JiuCaiTouTiaoRunnable.flag=true;
                runnable = new JiuCaiTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.HONGBAOTOUTIAO) {
                HongBaoTouTiaoRunnable.flag=true;
                runnable = new HongBaoTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.JUHETOUTIAO) {
                JuHeTouTiaoRunnable.flag=true;
                runnable = new JuHeTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.DAZHONGKANDIAN) {
                DaZhongKanDianRunnable.flag=true;
                runnable = new DaZhongKanDianRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.JUKANDIAN) {
                JuKanDianRunnable.flag=true;
                runnable = new JuKanDianRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.ZHANGSHANGTOUTIAO) {
                ZhangShangTouTiaoRunnable.flag=true;
                runnable = new ZhangShangTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.DIANDIANXINWEN) {
                DianDianXinWenRunnable.flag=true;
                runnable = new DianDianXinWenRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.SHANDIANKANKAN) {
                ShanDianKanKanRunnable.flag=true;
                runnable = new ShanDianKanKanRunnable();
            }
        }


        MainService.interruptThread();
        if (thread==null) {
            thread = new Thread(runnable);
            thread.start();
        } else {
            thread.interrupt();
//            thread.stop();
//            thread =null;


            thread = new Thread(runnable);
            thread.start();
        }
        MainService.map.put(thread.getName(), thread);
    }

    public static void closeAll() {
//        蚂蚁头条、头条多多、2345浏览器
        DongFangRunnable.flag=false;
        ZhongQingRunnable.flag=false;
        QuTouTiaoRunnable.flag=false;
        MaYiTouTiaoRunnable.flag=false;
        TouTiaoDuoDuoRunnable.flag=false;
        Browser2345Runnable.flag=false;


//        微鲤看看、韭菜头条（没找到）、红包头条、聚合头条、大众看点（没下载到）、聚看点、掌上头条(账号注册失败)、点点新闻、闪电看看(没吓到)闪电盒子、、薪头条，以12个小时为分界。
        WeiLiKanKanRunnable.flag =false;
        JiuCaiTouTiaoRunnable.flag=false;
        HongBaoTouTiaoRunnable.flag=false;
        JuHeTouTiaoRunnable.flag=false;
        DaZhongKanDianRunnable.flag=false;
        JuKanDianRunnable.flag=false;
        ZhangShangTouTiaoRunnable.flag=false;
        DianDianXinWenRunnable.flag=false;
        ShanDianKanKanRunnable.flag=false;
        XinTouTiaoRunnable.flag=false;
    }


}
