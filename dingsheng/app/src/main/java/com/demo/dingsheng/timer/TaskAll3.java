package com.demo.dingsheng.timer;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.demo.dingsheng.entitiy.TabEntity;
import com.demo.dingsheng.timer.task.*;
import com.demo.dingsheng.util.Constant;

import java.util.List;

/**
 * created by tea9 at 2018/12/26
 * https://www.cnblogs.com/ccdc/p/3837798.html
 */
public class TaskAll3 {

//    private static List<TabEntity> data=new ArrayList<>();

//    private static List<TabEntity> before

    private static Handler mHandler;

//    private static Thread thread;
    private static Runnable runnable;

    private static HandlerThread thread;


    // 传递过来的得是true
    public static void init_task(int index, boolean flag, List<TabEntity> list1, List<TabEntity> list2) {

        if (list1.size()==0){
            flag = false;
        }
        if (list2.size()==0){
            flag = true;
        }

        runnable = new Runnable() {
            @Override
            public void run() {
            }
        };
//        closeAll();
//        MainService.interruptThread();

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




            if (tabEntity.flag_enum == Constant.ENUM.DONGFANGTOUTIAO) {
                runnable = new DongFangRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.ZHONGQINGKANDIAN) {
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
                runnable = new WeiLiKanKanRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.JIUCAITOUTIAO) {
                runnable = new JiuCaiTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.HONGBAOTOUTIAO) {
                runnable = new HongBaoTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.JUHETOUTIAO) {
                runnable = new JuHeTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.DAZHONGKANDIAN) {
                runnable = new DaZhongKanDianRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.JUKANDIAN) {
                runnable = new JuKanDianRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.ZHANGSHANGTOUTIAO) {
                runnable = new ZhangShangTouTiaoRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.DIANDIANXINWEN) {
                runnable = new DianDianXinWenRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.SHANDIANKANKAN) {
                runnable = new ShanDianKanKanRunnable();
            } else if (tabEntity.flag_enum == Constant.ENUM.XINTOUTIAO) {
                runnable = new XinTouTiaoRunnable();
            }
        }


//        MainService.interruptThread();
//
//        thread = new Thread(runnable);
//        thread.start();
//        MainService.map.put(thread.getName(), thread);

        if (thread==null) {
            thread = new HandlerThread("MyHandlerThread");
            thread.start();//创建一个HandlerThread并启动它
        }
        if (mHandler==null)
            mHandler = new Handler(thread.getLooper());//使用HandlerThread的looper对象创建Handler，如果使用默认的构造方法，很有可能阻塞UI线程
//        closeAll();
//        destroyThread();
        mHandler.post(runnable);//将线程post到Handler中
    }

    public static void destroyThread(){
        if (mHandler!=null&&runnable!=null)
           mHandler.removeCallbacks(runnable);
    }

    public static void closeAll() {
//        蚂蚁头条、头条多多、2345浏览器
        ZhongQingRunnable.flag=false;
//        QuTouTiaoRunnable.flag=false;
//        MaYiTouTiaoRunnable.flag=false;
//        TouTiaoDuoDuoRunnable.flag=false;
        Browser2345Runnable.flag=false;
    }


}
