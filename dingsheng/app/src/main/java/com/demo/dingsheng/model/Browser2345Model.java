package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 签到写完了
 */
public class Browser2345Model {

    public static void start() throws InterruptedException {
        Constant.start(Constant.Browser2345.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
//        ShellUtil.swipe(1150,500);
//        ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN2,Constant.Browser2345.FileName.file_path1); //领现金
//        5381684
        ShellUtil.clickMethod(538,1684);
        Thread.sleep(10*1000);


        Constant.start(Constant.Browser2345.ACTIVITY_PACKAGE);
        Thread.sleep(3*1000);
        //input swipe 25 1150 25 400 500
        ShellUtil.swipe(1150,500);
        ShellUtil.clickByXy(Constant.Browser2345.RES_ID_LINGQIAN,Constant.Browser2345.FileName.file_path1); //领钱
        ShellUtil.back();
        Thread.sleep(3*1000);
        Log.e(Constant.TAG,"点击btn1");
        ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1,Constant.Browser2345.FileName.file_path1); // 点击刷新
        for(int i=0;i<30;i++){
//        while (true){
            ShellUtil.slideByXyIds4(Constant.Browser2345.RES_ID_ITEM1, Constant.Browser2345.FileName.file_path1); // 第一条是置顶
            ShellUtil.clickByXy(Constant.Browser2345.RES_ID_BTN1,Constant.Browser2345.FileName.file_path1); // 点击刷新
        }
    }
}
