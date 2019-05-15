package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 有广告
 * 每测试
 */
public class HongBaoTouTiaoModel {

    public static void start() throws InterruptedException {
        Constant.start(Constant.HongBaoTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4*1000);
        ShellUtil.clickByXy(Constant.HongBaoTouTiao.RES_ID_BTN2,Constant.HongBaoTouTiao.FileName.file_path1);
        Thread.sleep(3*1000);
        ShellUtil.clickByXy(Constant.HongBaoTouTiao.RES_ID_QianDao,Constant.HongBaoTouTiao.FileName.file_path1);
        Thread.sleep(6*1000);


        Constant.start(Constant.HongBaoTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4*1000);
//        Log.e(Constant.TAG,"返回");
        // TODO check 红包
//        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新
        while (true){
            Log.e(Constant.TAG,"点击item111111");
            ShellUtil.slideByXyIds5(Constant.HongBaoTouTiao.RES_ID_ITEM1,Constant.HongBaoTouTiao.FileName.file_path1);
            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.HongBaoTouTiao.RES_ID_ITEM1LL,Constant.HongBaoTouTiao.FileName.file_path1);
            Log.e(Constant.TAG,"滑动坐标");
            ShellUtil.swipe(a[1],a[0]);
        }
    }
}
