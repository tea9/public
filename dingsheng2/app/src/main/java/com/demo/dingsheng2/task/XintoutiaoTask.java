package com.demo.dingsheng2.task;

import android.util.Log;
import com.demo.dingsheng2.util.Constant;
import com.demo.dingsheng2.util.DOMTest;
import com.demo.dingsheng2.util.RootCmd;
import com.demo.dingsheng2.util.ShellUtil;

import java.util.Map;

/**
 * created by tea9 at 2019/1/9
 * 判断广告
 */
public class XintoutiaoTask {
    public static void start() {
        Log.e(Constant.TAG, "xintoutiaoaaaa" + Thread.currentThread().getName());
//        RootCmd.execRootCmd("input keyevent 3");
//        RootCmd.execRootCmd("input keyevent 3");
//        RootCmd.execRootCmd("input keyevent 3");
//        RootCmd.execRootCmd("input keyevent 3");
//        RootCmd.execRootCmd("input keyevent 3");
//        RootCmd.execRootCmd("input keyevent 3");
//        for (int i = 0; i < 20; i++) {
//            try {
//                RootCmd.execRootCmd("input keyevent 3");
////                ShellUtil.startActivity(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//                ShellUtil.home();
//                Thread.sleep(2 * 1000);
//                Log.e(Constant.TAG,"start clear"+Thread.currentThread().getName());
//                ShellUtil.clear();
//                Thread.sleep(2 * 1000);
//                Log.e(Constant.TAG,"start startActivity"+Thread.currentThread().getName());
//                ShellUtil.startActivity(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//                Log.e(Constant.TAG,"start startActivity ssss"+Thread.currentThread().getName());
//                Thread.sleep(5 * 1000);
//                Log.e(Constant.TAG,"start startActivity 等待成功"+Thread.currentThread().getName());
//                Thread.sleep(1*1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                Log.e(Constant.TAG, "xintoutiaobbbbb 异常了" + i);
//            }
//            Log.e(Constant.TAG, "xintoutiaobbbbb" + i);
//            RootCmd.execRootCmd("uiautomator dump /sdcard/xx.xml");
//        }


//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Log.e(Constant.TAG, "sssssssssxxxxxfdfdfdfdfdfdfdfdfdfdfdfd" + FLAG_STR+Thread.currentThread().getName());
//                        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//                        Thread.sleep(2 * 1000);
//                        Log.e(Constant.TAG, "xintoutiaoaaaa" + FLAG_STR);
//                        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//                        Thread.sleep(2 * 1000);
//                        Log.e(Constant.TAG, "xintoutiaoaaaa" + FLAG_STR);
//                        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//                        Thread.sleep(2 * 1000);
//                        Log.e(Constant.TAG, "xintoutiaoaaaa" + FLAG_STR);
//                        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }).start();
        try {
//            openActivity(true);
            aaa();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    private static boolean checkHome(String id, String path) throws InterruptedException {
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

    private static boolean openActivity(boolean flag) throws InterruptedException {
        Log.e(Constant.TAG, "打开应用" + Thread.currentThread().getName());
        Constant.start(Constant.XinTouTiao.ACTIVITY_PACKAGE);
        Thread.sleep(6*1000);
        Log.e(Constant.TAG, "检测首页" + Thread.currentThread().getName());
        if (checkHome(Constant.XinTouTiao.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1)) {
            // 进行操作
            Log.e(Constant.TAG, "进行操作" + Thread.currentThread().getName());

            return true;

        } else {
            Log.e(Constant.TAG, "判断首页失败" + Thread.currentThread().getName());
            // 判断首页失败
            if (flag) {
                Log.e(Constant.TAG, "重新判断" + Thread.currentThread().getName());
                openActivity(false);
            }
        }
        return false;
    }

    private static void aaa() throws InterruptedException {
        if (openActivity(true)) {
            Log.e(Constant.TAG, "新头条任务" + Thread.currentThread().getName());
            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN2, Constant.XinTouTiao.FileName.file_path1); //任务
            Thread.sleep(6 * 1000);
        }
        if (openActivity(true)) {
            Log.e(Constant.TAG, "新头条时段" + Thread.currentThread().getName());
            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_LINGQU, Constant.XinTouTiao.FileName.file_path1); // 时段
            Thread.sleep(2 * 1000);
            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_WO_ZHIDAO,Constant.XinTouTiao.FileName.file_path1); // 时段我知道了
            Thread.sleep(2 * 1000);

            Log.e(Constant.TAG, "新头条点击刷新" + Thread.currentThread().getName());
            ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
            for (int i = 0; i < Constant.TASK_COUNT; i++) {
                Log.e(Constant.TAG, "新头条点击置顶" + Thread.currentThread().getName());
                slideByXyIds(Constant.XinTouTiao.RES_ID_ITEM1, Constant.XinTouTiao.FileName.file_path1,1); // 第一条是置顶
                Log.e(Constant.TAG, "新头条点击刷新" + Thread.currentThread().getName());
                Thread.sleep(1000);
                ShellUtil.clickByXy(Constant.XinTouTiao.RES_ID_BTN1, Constant.XinTouTiao.FileName.file_path1); // 点击刷新
            }

        }
    }

    public static void slideByXyIds(String res_id, String file_path,int pos) throws InterruptedException {
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
                while (j < 8) {
                    Log.e(Constant.TAG, "input swipe 25 1000 25 550");
                    RootCmd.execRootCmd("input swipe 25 1000 25 550");
                    j++;
                    Thread.sleep(3000);
                }
                Log.e(Constant.TAG, "keyevent 1");
                ShellUtil.back();
                break;
            }
        }

    }
}
