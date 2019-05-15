package com.demo.dingsheng2.util;

import android.util.Log;

import java.io.File;
import java.util.Map;

/**
 * created by tea9 at 2018/11/25
 * 封装的一些命令
 */
public class ShellUtil {

    public static final String TAG = "ShellUtil";

    /**
     * 打开app
     *
     * @param package_activity com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity
     */
    public static void startActivity(String package_activity) {
        //com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity
        RootCmd.execRootCmd("am start " + package_activity); // 打开app
    }

    /**
     * 生成文件
     * uiautomator dump /sdcard/dump.xml
     *
     * @param file_path 文件路径 /sdcard/dump.xml
     *                  修改dump文件逻辑 每个页面生成一个文件 如果文件存在就不重新生成
     */
    public static void createXMLFile(String file_path) {
        // 判断这个文件是否存在
//        File file = new File(file_path);
//        if (!file.exists())
            RootCmd.execRootCmd("uiautomator dump " + file_path); // 生成文件
    }

    /**
     * @param file_path
     * @param flag      是否要重新生成 true 是
     */
    public static void createXMLFile(String file_path, boolean flag) {
        if (flag) {
            RootCmd.execRootCmd("uiautomator dump " + file_path); // 生成文件
        } else {
            File file = new File(file_path);
            if (!file.exists())
                RootCmd.execRootCmd("uiautomator dump " + file_path); // 生成文件

        }
    }

    /**
     * 获取坐标系 根据id
     *
     * @param res_id    资源id com.songheng.eastnews:id/a8e
     * @param file_path 文件路径 /sdcard/dump.xml
     * @return
     */
    public static Integer[] getCoordinate(String res_id, String file_path) {
        /**
         * int x1 = ddddd.get("x1");
         * int y1 = ddddd.get("x2");
         * **/
        Map<String, Integer> zzz = DOMTest.getCoordinateWithResourceId(res_id, file_path);
        if (zzz != null) {
            Log.e(TAG, String.valueOf(zzz));
            int x1 = zzz.get("x1");
            int y1 = zzz.get("y1");
            Integer[] aaa = {x1, y1};
            return aaa;
        }
        return null;
    }

    public static Integer[] getCoordinateByDesc(String res_id, String file_path) {
        /**
         * int x1 = ddddd.get("x1");
         * int y1 = ddddd.get("x2");
         * **/
        Map<String, Integer> zzz = DOMTest.getCoordinateWithContentDesc(res_id, file_path);
        if (zzz != null) {
            Log.e(Constant.TAG,zzz.toString());
            Log.e(TAG, String.valueOf(zzz));
            int x1 = zzz.get("x1");
            int y1 = zzz.get("y1");
            Integer[] aaa = {x1, y1};
            return aaa;
        }
        return null;
    }

    public static Integer[] getCoordinateByY1X2(String res_id, String file_path) {
        /**
         * int x1 = ddddd.get("x1");
         * int y1 = ddddd.get("x2");
         * **/
        Map<String, Integer> zzz = DOMTest.getCoordinateWithResourceId(res_id, file_path);
        if (zzz != null) {
            Log.e(TAG, String.valueOf(zzz));
            int x1 = zzz.get("y1");
            int y1 = zzz.get("x2");
            Integer[] aaa = {x1, y1};
            return aaa;
        }
        return null;
    }

    /**
     * 根据文字获取坐标
     *
     * @param text
     * @param file_path
     * @return
     */
    public static Integer[] getCoordinateText(String text, String file_path) {
        /**
         * int x1 = ddddd.get("x1");
         * int y1 = ddddd.get("x2");
         * **/
        Map<String, Integer> zzz = DOMTest.getCoordinateWithText(text, file_path);
        if (zzz != null) {
            Log.e(TAG, String.valueOf(zzz));
            int x1 = zzz.get("x1");
            int y1 = zzz.get("y1");
            Integer[] aaa = {x1, y1};
            return aaa;
        }
        return null;
    }

    /**
     * 如果存在字符串返回 true
     *
     * @param text
     * @param file_path
     * @return
     */
    public static boolean checkCoordinateText(String[] text, String file_path) {
        /**
         * int x1 = ddddd.get("x1");
         * int y1 = ddddd.get("x2");
         * **/
        for (int i = 0; i < text.length; i++) {
            Map<String, Integer> zzz = DOMTest.getCoordinateWithText(text[i], file_path);
            if (zzz != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取一组坐标根据位置获取 某一个坐标
     *
     * @param res_id    资源id
     * @param file_path 文件路径
     * @param postion   位置坐标 从0开始
     * @return
     */
    public static Integer[] getCoordinateListByPosti(String res_id, String file_path, String postion) {
        /**
         * int x1 = ddddd.get("x1");
         * int y1 = ddddd.get("x2");
         * **/
        Map<String, Map<String, Integer>> zzz = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (zzz != null && zzz.size() > 0) {
            Log.e(TAG, "getCoordinateListByPosti" + String.valueOf(zzz));
            int x1 = zzz.get(postion).get("x1");
            int y1 = zzz.get(postion).get("y1");
            Integer[] aaa = {x1, y1};
            return aaa;
        }
        return null;
    }

    /**
     * 点击事件
     *
     * @param x
     * @param y
     */
    public static void clickMethod(int x, int y) {
        RootCmd.execRootCmd("input tap " + x + " " + y);
    }

    public static void clickByXyDesc(String res_id, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Thread.sleep(2 * 1000);
        Integer[] zzz = ShellUtil.getCoordinateByDesc(res_id, file_path);
        Log.e(Constant.TAG,"desc"+zzz.toString());
        if (null != zzz) {
            clickMethod(zzz[0], zzz[1]);
        }
    }
    public static void  clickByXy(String res_id, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Thread.sleep(2 * 1000);
        Integer[] zzz = ShellUtil.getCoordinate(res_id, file_path);
        if (null != zzz) {
            clickMethod(zzz[0], zzz[1]);
        }
    }

    public static void clickByXyText(String text, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Thread.sleep(2 * 1000);
        Integer[] zzz = ShellUtil.getCoordinateText(text, file_path);
        Log.e(Constant.TAG,"放弃提现坐标"+zzz);
        if (null != zzz) {
            clickMethod(zzz[0], zzz[1]);
        }
    }


    /**
     * 根据id获取坐标然后点击
     *
     * @param res_id
     * @param file_path
     */
    public static void getCoordinateAndClick(String res_id, String file_path) {
        Integer[] zz = getCoordinate(res_id, file_path);
        clickMethod(zz[0], zz[1]);
    }


    /**
     * 点击返回键
     */
    public static void back() {
        RootCmd.execRootCmd("input keyevent 4");
    }

    /**
     * 返回home界面
     */
    public static void home() {
        RootCmd.execRootCmd("input keyevent 3");
        RootCmd.execRootCmd("input keyevent 3");
        RootCmd.execRootCmd("input keyevent 3");
    }


    //RootCmd.execRootCmd("input swipe 100 1000 100 0  500 ");

    public static void swipeDownMethod1() {
        RootCmd.execRootCmd("input swipe 25 1000 25 550");
//        RootCmd.execRootCmd("input swipe 25 750 25 550");
//        RootCmd.execRootCmd("input swipe 25 700 25 550");
//        RootCmd.execRootCmd("input swipe 25 600 25 550 500");
//
//        RootCmd.execRootCmd("input swipe 25 1000 25 550");
//        RootCmd.execRootCmd("input swipe 25 750 25 550");
//        RootCmd.execRootCmd("input swipe 25 600 25 550 500");

    }

    public static void swipe(int y1,int y2){
        RootCmd.execRootCmd("input swipe 25 "+y1+" 25 "+y2);
    }

    /**
     * 向下滑动
     */
    public static void swipeDownMethod() throws InterruptedException {
        // TODO 优化 滑动边界
//        RootCmd.execRootCmd("input swipe 30 1000 30 0  500");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");

        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
        RootCmd.execRootCmd("input keyevent 92 ");
//        Thread.sleep(1*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(1*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(2*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(2*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(1*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(3*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(1*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(4*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(5*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(1*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(1*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
//        Thread.sleep(1*1000);
//        RootCmd.execRootCmd("input swipe 25 650 25 550 500 ");
    }

    /**
     * webview 向下滑动
     */
    public static void swipeByWebViewMethod() {
//        adb shell input keyevent 92 #向上翻页键

//        adb shell input keyevent 93 #向下翻页键
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 93 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 19 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
        RootCmd.execRootCmd("input keyevent 20 ");
    }


    /**
     * 清理后台 这个是滑动坐标 适配了 荣耀机型
     *
     * @throws InterruptedException
     */
    public static void clear() throws InterruptedException {
        RootCmd.execRootCmd("input tap 771 1852"); //方框的位置
        Thread.sleep(3 * 1000);
        RootCmd.execRootCmd("input swipe 597 1758 597 1384"); //滑动
    }


    /**
     * 检测当前页面
     *
     * @param id
     * @param file_path
     * @return
     */
    public static boolean checkPage(String id, String file_path) {
        createXMLFile(file_path);
        Integer[] map = getCoordinate(id, file_path);
        if (map != null) {
            return true;
        }
        return false;
    }

    public static boolean checkPageByText(String text, String file_path) {
        createXMLFile(file_path);
        Integer[] map = getCoordinateText(text, file_path);
        if (map != null) {
            return true;
        }
        return false;
    }


    public static boolean checkPage(String id, String file_path, Boolean flag) {
        createXMLFile(file_path,flag);
        Integer[] map = getCoordinate(id, file_path);
        if (map != null) {
            return true;
        }
        return false;
    }

//    public static void tapButton(String id, String file_path) {
//        Integer[] map = getCoordinate(id, file_path);
//        if (map != null) {
//            Log.e(TAG, map.toString());
//            int zx1 = map[0];
//            int zy1 = map[1];
//            Log.e(TAG, "x1:" + zx1 + "x2:" + zy1);
//            ShellUtil.clickMethod(zx1, zy1);
//        }
//    }


//    public static void tapButton(String id) {
//        tapButton(id, Constant.FILE_PATH);
//    }

    /**
     * 滑动刷新 由上往下滑动
     */
    public static void swipeRefresh() {
        RootCmd.execRootCmd("input swipe 100 400 100 1000  300");
    }


    /**
     * 相同resid根据位置点击
     *
     * @param res_id
     * @param file_path
     * @param position
     */
    public static void clickByXyIds(String res_id, String file_path, String position) {
        ShellUtil.createXMLFile(file_path);
        Integer[] zzz = ShellUtil.getCoordinateListByPosti(res_id, file_path, position);
        if (zzz != null) {
            clickMethod(zzz[0], zzz[1]);
        }
    }

    /**
     * 一个xml有好多相同坐标 点击
     *
     * @param res_id
     * @param file_path
     */
    public static void clickByXyIds(String res_id, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            for (int i = 0; i < aa.size(); i++) {
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                clickMethod(x1, y1);
                Thread.sleep(2*1000);
                ShellUtil.back();
            }
        }

    }



    public static void slideByXyIdsZHONGQING(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG,"keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG,"keyevent 1");


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
        Log.e(Constant.TAG,"keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG,"keyevent 1");
            for (int i = 1; i < aa.size(); i++) {
                Log.e(Constant.TAG,"keyevent 1");
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                clickMethod(x1, y1);
                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(2*1000);
                Log.e(Constant.TAG,"keyevent 2");
                // 滑动
                int j = 0;
                while (j<50) {
                    Log.e(Constant.TAG,"keyevent 20");
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                }
                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(1*1000);
                ShellUtil.back();
                Thread.sleep(1*1000);
            }
        }

    }

    public static void slideByXyIds(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG,"keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG,"keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG,"keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG,"keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG,"keyevent 1");
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                clickMethod(x1, y1);
                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(2*1000);
                Log.e(Constant.TAG,"keyevent 2");
                // 滑动
                int j = 0;
                while (j<30) {
                    Log.e(Constant.TAG,"keyevent 20");
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                }
                Log.e(Constant.TAG,"keyevent 1");
                ShellUtil.back();
            }
        }

    }

    /**
     * click 适配2345浏览器
     * @param res_id
     * @param file_path
     * @throws InterruptedException
     */
    public static void slideByXyIds4(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG,"keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG,"keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG,"keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG,"keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG,"keyevent 1");
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                clickMethod(x1, y1);
                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(2*1000);
                Log.e(Constant.TAG,"keyevent 2");
                // 滑动
                int j = 0;
                RootCmd.execRootCmd("input tap 349 216");
                while (j<30) {
                    Log.e(Constant.TAG,"keyevent 20");
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                }
                Log.e(Constant.TAG,"keyevent 1");
                ShellUtil.back();
            }
        }

    }

    /**
     * 50
     * @param res_id
     * @param file_path
     * @throws InterruptedException
     */
    public static void slideByXyIds3(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG,"keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG,"keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG,"keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG,"keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG,"keyevent 1");
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                clickMethod(x1, y1);
                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(2*1000);
                Log.e(Constant.TAG,"keyevent 2");
                // 滑动
                int j = 0;
                while (j<50) {
                    Log.e(Constant.TAG,"keyevent 20");
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                }
                Log.e(Constant.TAG,"keyevent 1");
                ShellUtil.back();
            }
        }

    }
    public static void slideByXyIds2(String res_id, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            for (int i = 0; i < aa.size(); i++) {
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                Log.e(Constant.TAG,"点击坐标");
                clickMethod(x1, y1);
                Thread.sleep(2*1000);
                // 滑动
                int j = 0;
                while (j<23) {
                    Log.e(Constant.TAG,"在滑动");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    j++;
                }
                Thread.sleep(1*1000);
                Log.e(Constant.TAG,"返回了");
                ShellUtil.back();
            }
        }

    }

    /**
     * 适配 聚合头条
     * @param res_id
     * @param file_path
     * @throws InterruptedException
     */
    public static void slideByXyIds6(String res_id, String file_path) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            for (int i = 0; i < aa.size(); i++) {
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                Log.e(Constant.TAG,"点击坐标");
                clickMethod(x1, y1);
                Thread.sleep(4*1000);
                // 滑动
                int j = 0;
                while (j<40) {
                    Log.e(Constant.TAG,"在滑动");
                    RootCmd.execRootCmd("input swipe 25 1050 25 450 1000");
//                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
                    j++;
                }
//                int k = 0;
//                while (k<23) {
//                    Log.e(Constant.TAG,"在滑动");
//                    RootCmd.execRootCmd("input swipe 25 450 25 1050 700");
////                    RootCmd.execRootCmd("input swipe 25 1050 25 450 500");
//                    k++;
//                }
                Thread.sleep(1*1000);
                Log.e(Constant.TAG,"返回了");
                ShellUtil.back();
            }
        }

    }

    /**
     * 适配红包头条 滑动一定时间
     * @param res_id
     * @param file_path
     * @throws InterruptedException
     */
    public static void slideByXyIds5(String res_id, String file_path) throws InterruptedException {
        Log.e(Constant.TAG,"keyevent 1");
        ShellUtil.createXMLFile(file_path);
        Log.e(Constant.TAG,"keyevent 1");
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        Log.e(Constant.TAG,"keyevent 1");
        if (aa != null) {
            Log.e(Constant.TAG,"keyevent 1");
            for (int i = 0; i < aa.size(); i++) {
                Log.e(Constant.TAG,"keyevent 1");
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                clickMethod(x1, y1);
//                Log.e(Constant.TAG,"keyevent 1");
                Thread.sleep(2*1000);
//                Log.e(Constant.TAG,"keyevent 2");
                // 滑动
                int j = 0;
                while (j<2) {
                    for(int k=0;k<5;k++) {
                        RootCmd.execRootCmd("input swipe 25 1050 25 450 700");
                    }
                    Thread.sleep(2*1000);
                    j++;
                }
                Log.e(Constant.TAG,"keyevent 1");
                ShellUtil.back();
            }
        }

    }


    public static void slideByXyIdsNot(String res_id, String file_path, int pos) throws InterruptedException {
        ShellUtil.createXMLFile(file_path);
        Map<String, Map<String, Integer>> aa = DOMTest.getCoordinateListWithResourceId(res_id, file_path);
        if (aa != null) {
            if (pos>aa.size()) {
                return;
            }
            for (int i = pos; i < aa.size(); i++) {
                int x1 = aa.get(i+"").get("x1");
                int y1 = aa.get(i+"").get("y1");
                clickMethod(x1, y1);
                Thread.sleep(2*1000);
                // 滑动
                int j = 0;
                while (j<35) {
                    RootCmd.execRootCmd("input keyevent 20 ");
                    j++;
                }
                ShellUtil.back();
            }
        }

    }

//    public static void clickByXyIds(String res_id,String position){
//        clickByXyIds(res_id,null,position);
//    }


    /**
     * 如果存在text点击 resid 坐标
     *
     * @param text
     * @param resid
     * @param file_path
     * @return
     */
    public static boolean clickByXyByText(String text, String resid, String file_path) {
        boolean flag = false;
        ShellUtil.createXMLFile(file_path);
        Integer[] zzz = ShellUtil.getCoordinateText(text, file_path);
        if (null != zzz) {
            flag = true;
            Integer[] bbb = ShellUtil.getCoordinateText(resid, file_path);
            if (null != bbb) {
                flag = true;
                clickMethod(bbb[0], bbb[1]);
            }
        }
        return flag;
    }

    /**
     * 点击一个xml的好几个坐标
     *
     * @param res_id
     * @param file_path
     */
    public static void clickByXy(String res_id[], String file_path) {
        ShellUtil.createXMLFile(file_path);
        for (int i = 0; i < res_id.length; i++) {
            Integer[] zzz = ShellUtil.getCoordinate(res_id[i], file_path);
            if (null != zzz) {
                clickMethod(zzz[0], zzz[1]);
            }
        }
    }

//    public static void clickByXy(String res_id) {
//        clickByXy(res_id,null);
//    }


    public static void createDir() {
        RootCmd.execRootCmd("mkdir " + Constant.PRE_DIR_NAME);
    }

    /**
     * rm sdcard/dingsheng/*
     * 删除目录下所有文件
     */
    public static void delAllFile() {
        RootCmd.execRootCmd("rm -rf " + Constant.PRE_DIR_NAME);
        createDir();
    }

}
