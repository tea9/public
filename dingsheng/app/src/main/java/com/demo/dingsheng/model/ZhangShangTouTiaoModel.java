package com.demo.dingsheng.model;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.ShellUtil;

/**
 * created by tea9 at 2018/12/16
 * 账号注册失败
 */
public class ZhangShangTouTiaoModel {

    public static void start() throws InterruptedException {
        Constant.start(Constant.ZhangShangTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(4*1000);
        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新
        while (true){
            Log.e(Constant.TAG,"点击item111111");
//            ShellUtil.clickByXyIds(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
            ShellUtil.slideByXyIds(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
//            ShellUtil.slideByXyIdsNot(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
//            Log.e(Constant.TAG,"keyevent 1");
            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.ZhongQing.RES_ID_ITEM1LL,Constant.ZhongQing.FileName.file_path1);
//            Log.e(Constant.TAG,"keyevent 1");
            ShellUtil.swipe(a[1],a[0]);
        }
    }
}
