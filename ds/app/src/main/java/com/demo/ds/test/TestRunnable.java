package com.demo.ds.test;

import android.util.Log;

import com.demo.ds.entity.TabEntity;
import com.demo.ds.util.Constant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * created by tea9 at 2019/1/25
 * 30分钟定时v
 * 开始 停止√
 * 循环运行√
 *
 * 12小时 换listabc dfg
 *
 * 每句话flag
 *
 * 每个操作都要判断时间 判断12h 判断flag停止启动
 */
public class TestRunnable implements Runnable {
    // 开始停止标志位
    volatile boolean flag=true; //
    final long min = 5 * 1000;
//    final long min = 30 * 60 * 1000;
    final String TAG="shaomiao";

    int timeFlag=0; //1是 前面的 2 是后面的

    List<TabEntity> list = new ArrayList<>();
    int listSize=0;
    int index=0;


    @Override
    public void run() {
        //在这里判断时间 12小时 执行 a b
        checkTime();
        Log.e(TAG, "runnstart" + Thread.currentThread().getName() + "AAA1" + index);
        // 3min顺序执行任务
        long startTime=System.currentTimeMillis(); //开始时间;
        // 执行30分钟任务

        while (index<listSize&&flag) {
            TabEntity entity=list.get(index);
            startTime = System.currentTimeMillis(); //开始时间
            if (entity.flag_enum==Constant.ENUM.DONGFANGTOUTIAO) {
                while (System.currentTimeMillis() - startTime < min && flag) {
                    Log.e(TAG, entity.text + Thread.currentThread().getName() + "AAA1" + index);
                }
            }
            else if (entity.flag_enum==Constant.ENUM.ZHONGQINGKANDIAN) {
                while (System.currentTimeMillis() - startTime < min && flag) {
                    Log.e(TAG, entity.text + Thread.currentThread().getName() + "AAA1" + index);
                }
            }
            else if (entity.flag_enum==Constant.ENUM.QUTOUTIAO) {
                while (System.currentTimeMillis() - startTime < min && flag) {
                    Log.e(TAG, entity.text + Thread.currentThread().getName() + "AAA1" + index);
                }
            }else if (entity.flag_enum==Constant.ENUM.MAYITOUTIAO) {
                while (System.currentTimeMillis() - startTime < min && flag) {
                    Log.e(TAG, entity.text + Thread.currentThread().getName() + "AAA1" + index);
                }
            }else if (entity.flag_enum==Constant.ENUM.TOUTIAODUODUO) {
                while (System.currentTimeMillis() - startTime < min && flag) {
                    Log.e(TAG, entity.text + Thread.currentThread().getName() + "AAA1" + index);
                }
            }
            // 判断12h
            Log.e(TAG, Thread.currentThread().getName() + "判断12h" + index);
            checkTime();
            index++;
            if (index>=listSize) {
                index=0;// 如果全部执行一遍结束之后 判断时间
            }
        }
    }

    /**
     *checkTime == true break
     */
    private void checkTime() {
        Calendar now = Calendar.getInstance();
        int nowDate= now.get(Calendar.HOUR_OF_DAY);
        // 停止的时候保存标志 点击开始的时候判断 有就修改 没有就从头
        // 根据区间判断list 数据
        if(nowDate>=0&&nowDate<=16) {
            // list 重新赋值 size 重新赋值
            initData(1);
            listSize = list.size();
            if (timeFlag!=1){ //如果现在不是1
                timeFlag =1;
                index = 0;
            }
        } else if (nowDate>=17&&nowDate<=18) {
            initData(2);
            listSize = list.size();
            if (timeFlag!=2){
                timeFlag = 2;
                index = 0;
            }
        } else {
            // 集合置空 size 给0
            listSize=0;
            list.clear();
        }
    }

    private void initData(int timeFlag) {
        if (timeFlag==1){
            list.clear();
            list.add(new TabEntity("111111", Constant.ENUM.DONGFANGTOUTIAO,1));
            list.add(new TabEntity("222222", Constant.ENUM.ZHONGQINGKANDIAN,1));
        } else if (timeFlag==2){
            list.clear();
            list.add(new TabEntity("33333", Constant.ENUM.QUTOUTIAO,2));
            list.add(new TabEntity("44444", Constant.ENUM.MAYITOUTIAO,2));
            list.add(new TabEntity("55555", Constant.ENUM.TOUTIAODUODUO,2));
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }
}
