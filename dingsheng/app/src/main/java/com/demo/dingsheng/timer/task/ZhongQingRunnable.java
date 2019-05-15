package com.demo.dingsheng.timer.task;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.DOMTest;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2018/12/26
 */
public class ZhongQingRunnable implements Runnable {

    public static volatile boolean flag = true;




    @Override
    public void run() {
//        while (!Thread.currentThread().isInterrupted()){
//            Log.e(Constant.TAG,"zhongqingRunnable。。。。。。");
//        }

        if (!Thread.currentThread().isInterrupted()&&flag) {
            try {
                start();
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag=false;
            }
        }
    }

    private synchronized void before() throws InterruptedException {
        Log.e(Constant.TAG,"去拆现金 zhongqingzhognqing"+Thread.currentThread().getName());
        Constant.start(Constant.ZhongQing.ACTIVITY_PACKAGE);
        Thread.sleep(6*1000);

        Log.e(Constant.TAG,"去拆现金 zhongqingzhognqing"+ Thread.currentThread().getName());
        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED,Constant.ZhongQing.FileName.file_path1)) ShellUtil.back(); //红包页面

        if (ShellUtil.checkPage(Constant.ZhongQing.DIALOG_PASS,Constant.ZhongQing.FileName.file_path1)) {
            ShellUtil.clickByXy(Constant.ZhongQing.DIALOG_PASS,Constant.ZhongQing.FileName.file_path1);
        }
        Log.e(Constant.TAG,"去拆现金 zhongqingzhognqing"+Thread.currentThread().getName());

        // 点击红包
        if (ShellUtil.checkPage(Constant.ZhongQing.RES_ID_RED_CLOSE,Constant.ZhongQing.FileName.file_path1)){
            ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_RED_CLOSE,Constant.ZhongQing.FileName.file_path1);
        }


        //check弹框 提现弹框
        if(ShellUtil.checkPage(Constant.ZhongQing.DIALOG,Constant.ZhongQing.FileName.file_path3)){
            ShellUtil.clickByXy(Constant.ZhongQing.DIALOG_TASK,Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG,"去拆现金 zhongqingzhognqing"+Thread.currentThread().getName());
            Thread.sleep(2*1000);
            ShellUtil.clickByXy(Constant.ZhongQing.DIALOG_BACK,Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG,"点击返回 zhongqingzhognqing"+Thread.currentThread().getName());
//                ShellUtil.back();
            ShellUtil.clickByXyText(Constant.ZhongQing.DIALOG_TEXT,Constant.ZhongQing.FileName.file_path3);
            Log.e(Constant.TAG,"放弃提现 zhongqingzhognqing"+Thread.currentThread().getName());
            Thread.sleep(2*1000);
            ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新
        }

    }

    private synchronized void start() throws InterruptedException {
       before();
        Log.e(Constant.TAG,"去拆现金 zhongqingzhognqing"+Thread.currentThread().getName());
        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN2,Constant.ZhongQing.FileName.file_path1); // 点击我的
        Thread.sleep(2*1000);
//        ShellUtil.clickByXy(Constant.ZhongQing.RES_RENWUZHONGXIN,Constant.ZhongQing.FileName.file_path1); //点击任务中心
        ShellUtil.clickMethod(573,834); //任务中心
        Thread.sleep(2*1000);
        Log.e(Constant.TAG,"去拆现金 zhongqingzhognqing"+Thread.currentThread().getName());
        // 判断弹框
        ShellUtil.clickMethod(455,522); //点击签到
        Thread.sleep(6*1000);


//////////////////////////////////////////////////


        before();

        ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新
//        for (int i=0;i<30;i++) {
        while (!Thread.currentThread().isInterrupted()&&flag){
            ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL,Constant.FILE_PATH);
            Thread.sleep(1000);
            Log.e(Constant.TAG,"点击item111111 zhongqingzhognqing"+Thread.currentThread().getName());
//            ShellUtil.clickByXyIds(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
            slideByXyIdsZHONGQING(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
            Thread.sleep(2*1000);
            Log.e(Constant.TAG,"去拆现金 zhongqingzhognqing"+Thread.currentThread().getName());
            ShellUtil.clickByXy(Constant.ZhongQing.RES_ID_BTN1,Constant.ZhongQing.FileName.file_path1); // 点击刷新
            Thread.sleep(2*1000);
//            ShellUtil.slideByXyIdsNot(Constant.ZhongQing.RES_ID_ITEM1,Constant.ZhongQing.FileName.file_path2);
//            Log.e(Constant.TAG,"keyevent 1");
//            Integer[] a= ShellUtil.getCoordinateByY1X2(Constant.ZhongQing.RES_ID_ITEM1LL,Constant.ZhongQing.FileName.file_path1);
//            Log.e(Constant.TAG,"keyevent 1");
//            if (a!=null)
//                ShellUtil.swipe(a[1],a[0]);
        }
    }

    public synchronized void slideByXyIdsZHONGQING(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG,"keyevent 111111 zhongqingzhognqing"+Thread.currentThread().getName());
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG,"keyevent 122222 zhongqingzhognqing"+Thread.currentThread().getName());


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


        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG,"keyevent 133333 zhongqingzhognqing"+Thread.currentThread().getName());
        if (aa != null&&flag&&!Thread.currentThread().isInterrupted()) {
            Log.e(Constant.TAG,"keyevent 14444444 zhongqingzhognqing"+Thread.currentThread().getName());
            for (int i = 1; i < aa.size(); i++) {
                if (!flag||Thread.currentThread().isInterrupted()){
                    break;
                }
                Log.e(Constant.TAG,"keyevent 1555555 zhongqingzhognqing"+Thread.currentThread().getName());
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Log.e(Constant.TAG,"keyevent 166666 zhongqingzhognqing"+Thread.currentThread().getName());
                Thread.sleep(2*1000);
                Log.e(Constant.TAG,"keyevent 277777777 zhongqingzhognqing"+Thread.currentThread().getName());
                // 滑动
                int j = 0;
                while (j<50&&flag) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    try {
                        Log.e(Constant.TAG, "keyevent 20888888 zhongqingzhognqing" + Thread.currentThread().getName());
                        RootCmd.execRootCmd("input keyevent 20 ");
                        Thread.sleep(1*1000);
                        j++;
                    }catch (InterruptedException e){
                        e.printStackTrace();
                        break;
                    }
                }
                Log.e(Constant.TAG,"keyevent 199999999 zhongqingzhognqing"+Thread.currentThread().getName());
                Thread.sleep(1*1000);
                ShellUtil.back();
                Thread.sleep(1*1000);
            }
        }

    }
}
