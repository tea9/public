package com.demo.dingsheng.timer.task;

import android.util.Log;
import com.demo.dingsheng.util.Constant;
import com.demo.dingsheng.util.DOMTest;
import com.demo.dingsheng.util.RootCmd;
import com.demo.dingsheng.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2018/12/26
 * 趣头条点击政治类文章
 */
public class QuTouTiaoRunnable implements Runnable {

    public static volatile boolean flag = true;

    @Override
    public void run() {
//        while (!Thread.currentThread().isInterrupted()){
//            Log.e(Constant.TAG,"qutoutiaorunnable。。。。。。");
//        }
        if (!Thread.currentThread().isInterrupted() && flag) {
            try {
                start();
            } catch (InterruptedException e) {
                e.printStackTrace();
                flag = false;
            }
        }
    }

    private void before() throws InterruptedException {
        Log.e(Constant.TAG,"before qutoutiao"+Thread.currentThread().getName());
        Constant.start(Constant.QuTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(6 * 1000);
    }

    private void start() throws InterruptedException {
        before();
        Log.e(Constant.TAG,"before qutoutiao11111111"+Thread.currentThread().getName());
//        ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN3, Constant.QuTouTiao.FileName.file_path1); // 点击任务 自动签到
        ShellUtil.clickMethod(770,1709);//签到
        Thread.sleep(13 * 1000);
//        Log.e(Constant.TAG,"before qutoutiao222222222222"+Thread.currentThread().getName());
//        ShellUtil.clickByXy(Constant.QuTouTiao.HONGBAOTANKUANG, Constant.QuTouTiao.FileName.file_path1); // 点击红包弹框
//        Log.e(Constant.TAG,"before qutoutiao33333333333"+Thread.currentThread().getName());
//        ShellUtil.clickByXy(Constant.QuTouTiao.HONGBAOTANKUANG1, Constant.QuTouTiao.FileName.file_path1); // 点击红包弹框
//        Log.e(Constant.TAG,"before qutoutiao444444444"+Thread.currentThread().getName());
//        Thread.sleep(2 * 1000);
//        ShellUtil.clickByXy(Constant.QuTouTiao.QIANDAO, Constant.QuTouTiao.FileName.file_path1); // 点击签到
//        Log.e(Constant.TAG,"before qutoutia5555555555o"+Thread.currentThread().getName());
//        Thread.sleep(6 * 1000);

////////////////////////////////


        before();
        Log.e(Constant.TAG,"before qutoutiao666666666666"+Thread.currentThread().getName());
//        ShellUtil.clickByXy(Constant.QuTouTiao.LINGQU, Constant.QuTouTiao.FileName.file_path1); //点击领取
        ShellUtil.clickMethod(932,127); //领取
        Thread.sleep(1 * 1000);
        Log.e(Constant.TAG,"before qutoutiao777777777777777"+Thread.currentThread().getName());
        ShellUtil.clickByXy(Constant.QuTouTiao.DIALOG_WO, Constant.QuTouTiao.FileName.file_path1); // 领取之后 点击我知道了
        ShellUtil.clickByXy(Constant.QuTouTiao.DIALOG_WO1, Constant.QuTouTiao.FileName.file_path1); // 领取之后 点击我知道了
        Thread.sleep(2 * 1000);
        Log.e(Constant.TAG, "点击btn1");
        Log.e(Constant.TAG,"before qutoutiao88888888888888刷新"+Thread.currentThread().getName());
        ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN1, Constant.QuTouTiao.FileName.file_path1); // 点击刷新

//        for (int i=0;i<30;i++){
        Thread.sleep(2 * 1000);
        while (!Thread.currentThread().isInterrupted() && flag) {
            ShellUtil.clickByXy(Constant.DongFang.DONGFANG_YW_HL,Constant.FILE_PATH);
            Thread.sleep(1000);
            Log.e(Constant.TAG,"before qutoutiao99999999999999999 点击item1"+Thread.currentThread().getName());
            slideByXyIdsNot(Constant.QuTouTiao.RES_ID_ITEM1, Constant.QuTouTiao.FileName.file_path1, 2); // 第一条是置顶
            Log.e(Constant.TAG,"before qutoutiao101010101010101010 刷新"+Thread.currentThread().getName());
            ShellUtil.clickByXy(Constant.QuTouTiao.RES_ID_BTN1, Constant.QuTouTiao.FileName.file_path1); // 点击刷新
            Thread.sleep(4 * 1000);
        }
    }

    public void slideByXyIdsNot(String res_id, String file_path, int pos) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            if (pos > aa.size()) {
                return;
            }
            for (int i = pos; i < aa.size(); i++) {
                int x1 = aa.get(i + "").get("x1");
                int y1 = aa.get(i + "").get("y1");
                ShellUtil.clickMethod(x1, y1);
                Thread.sleep(2 * 1000);
                // 滑动
                int j = 0;
                while (j < 35 && flag) {
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException();
                    }
                    try {
                        Log.e(Constant.TAG,"before keyevent 20 "+Thread.currentThread().getName());
                        RootCmd.execRootCmd("input keyevent 20 ");
                        Thread.sleep(500);
                        j++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
                ShellUtil.back();
            }
        }

    }


}
