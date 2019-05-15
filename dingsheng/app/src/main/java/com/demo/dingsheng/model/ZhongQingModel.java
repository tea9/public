package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/15
 * 签到写完 根据坐标
 */
public class ZhongQingModel {

    public static void startZhongQing() throws InterruptedException {
        Constant.start(Constant.ZhongQing.ACTIVITY_PACKAGE);
        Thread.sleep(4*1000);

        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED,Constant.ZhongQing.FileName.file_path1)) ShellUtil.back(); //红包页面

        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN2,Constant.ZhongQing.FileName.file_path1); // 点击我的
        Thread.sleep(2*1000);
        ShellUtil.clickByXy(Constant.ZhongQing.RES_RENWUZHONGXIN,Constant.ZhongQing.FileName.file_path1); //点击任务中心
        Thread.sleep(2*1000);
        ShellUtil.clickMethod(656,530); //点击签到
        Thread.sleep(3*1000);


        Constant.start(Constant.ZhongQing.ACTIVITY_PACKAGE);
        Thread.sleep(4*1000);
        Log.e(Constant.TAG,"返回");
        // check 红包 每次 第一次打开的时候有
        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED,Constant.ZhongQing.FileName.file_path1)) ShellUtil.back(); //红包页面

        //check弹框 提现弹框
        if(ShellUtil.checkPage(Constant.ZhongQing.DIALOG,Constant.ZhongQing.FileName.file_path3)){
            ShellUtil.clickByXy(Constant.ZhongQing.DIALOG_TASK,Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG,"去拆现金");
            Thread.sleep(2*1000);
            ShellUtil.clickByXy(Constant.ZhongQing.DIALOG_BACK,Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG,"点击返回");
//                ShellUtil.back();
            ShellUtil.clickByXyText(Constant.ZhongQing.DIALOG_TEXT,Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG,"放弃提现");
            Thread.sleep(2*1000);
            ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新
        }

        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新
//        for (int i=0;i<30;i++) {
        while (true){
            Log.e(Constant.TAG,"点击item111111");
//            ShellUtil.clickByXyIds(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
            ShellUtil.slideByXyIdsZHONGQING(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
            Thread.sleep(2*1000);
//            ShellUtil.slideByXyIdsNot(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
//            Log.e(Constant.TAG,"keyevent 1");
            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.ZhongQing.RES_ID_ITEM1LL,Constant.ZhongQing.FileName.file_path1);
//            Log.e(Constant.TAG,"keyevent 1");
            if (a!=null)
                ShellUtil.swipe(a[1],a[0]);
        }
    }
}
