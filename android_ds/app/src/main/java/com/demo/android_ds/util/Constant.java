package com.demo.android_ds.util;

import com.demo.android_ds.entity.TabEntity;

/**
 *
 *
 *
 * 薪头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器
 * 微鲤看看、韭菜头条、红包头条、聚合头条、大众看点、聚看点、掌上头条、点点新闻、闪电看看
 *
 *
 *
 */
public class Constant {

    public static int BEFORE_TASK_COUNT=5; //前6个整体循环3 5
    public static int AFTER_TASK_COUNT=6;//后几个整体循环4 6

//    public static int TASK_COUNT=2;
    public static int TASK_COUNT=7; //每个的次数 5
    public static int TASK_COUNT2=4;//每个的次数 2

    public static String TAG = "test";
    public static String PRE_DIR_NAME = "/sdcard/";
    public static String FULL_DIR = PRE_DIR_NAME;

    public static String STOP_FLAG="STOP_FLAG";//每个应用停止标志

    public static String BEFORE_TEXT = "BEFORE_TEXT"; // 第一个服务的数据
    public static String AFTER_TEXT = "AFTER_TEXT"; //第二个服务的数据
    public static String ALL_TEXT = "ALL_TEXT"; // 全部的数据

    public static String AUTH_CODE = "AUTH_CODE"; // 授权码
    public static String AUTH_CHECK = "AUTH_CHECK"; // 授权码

    public static String FILE_PATH = "/sdcard/dump.xml";

    public static String CMD_FLAG="CMD_FLAG";//cmd停止

    public static TabEntity[] data_group = {
            new TabEntity("芝麻头条", ENUM.ZHIMATOUTIAO,1),
            new TabEntity("东方头条", Constant.ENUM.DONGFANGTOUTIAO,1),
            new TabEntity("惠头条", ENUM.HUITOUTIAO,1),
            new TabEntity("聚合头条", ENUM.JUHETOUTIAO,1),
            new TabEntity("中青看点", ENUM.ZHONGQINGKANDIAN,1),
            new TabEntity("趣头条", ENUM.QUTOUTIAO,1),
            new TabEntity("蚂蚁头条", ENUM.MAYITOUTIAO,1),
            new TabEntity("头条多多", ENUM.TOUTIAODUODUO,1),
            new TabEntity("2345浏览器", ENUM.BROWER2345,1),
            new TabEntity("微鲤看看", ENUM.WEILIKANKAN,2),
            new TabEntity("韭菜资讯", ENUM.JIUCAITOUTIAO,2),//
            new TabEntity("红包头条", ENUM.HONGBAOTOUTIAO,2),
            new TabEntity("薪头条", ENUM.XINTOUTIAO,2),
            new TabEntity("大众看点", ENUM.DAZHONGKANDIAN,2),
            new TabEntity("引力资讯", ENUM.YINLIZIXUN,2),
            new TabEntity("掌上热点", ENUM.ZHANGSHANGTOUTIAO,2),
            new TabEntity("点点新闻", ENUM.DIANDIANXINWEN,2),
            new TabEntity("闪电盒子", ENUM.SHANDIANKANKAN,2),
            new TabEntity("兔头条", ENUM.TUTOUTIAO,2)
    };

    public static class ENUM {
        public static int DONGFANGTOUTIAO = 11111111;
        public static int ZHONGQINGKANDIAN = 2222222;
        public static int QUTOUTIAO = 333333333;
        public static int MAYITOUTIAO = 444444444;
        public static int TOUTIAODUODUO = 5555555;
        public static int BROWER2345 = 66666666;

        public static int WEILIKANKAN = 7777777;
        public static int JIUCAITOUTIAO = 8888888;
        public static int HONGBAOTOUTIAO = 999999;
        public static int JUHETOUTIAO = 101010;
        public static int DAZHONGKANDIAN = 1111;
        public static int JUKANDIAN = 1212;
        public static int ZHANGSHANGTOUTIAO = 1313;
        public static int DIANDIANXINWEN = 1414;
        public static int SHANDIANKANKAN = 1515;
        public static int XINTOUTIAO = 1616;
        public static int HUITOUTIAO = 1717;
        public static int YINLIZIXUN = 1818;
        public static int TUTOUTIAO = 1919;
        public static int ZHIMATOUTIAO=20202020;
    }

//    public static void start(String activity_name) throws InterruptedException {
//        Log.e(TAG,"start home"+ Thread.currentThread().getName());
//        ShellUtil.home();
//        Thread.sleep(2 * 1000);
//        Log.e(TAG,"start clear"+ Thread.currentThread().getName());
//        ShellUtil.clear();
//        Thread.sleep(2 * 1000);
//        Log.e(TAG,"start startActivity"+ Thread.currentThread().getName());
//        ShellUtil.startActivity(activity_name);
//        Log.e(TAG,"start startActivity ssss"+ Thread.currentThread().getName());
//        Thread.sleep(10 * 1000);
//        Log.e(TAG,"start startActivity 等待成功"+ Thread.currentThread().getName());
//    }

    //  东方头条
    public static class DongFang {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "dongfang1.xml";
            public static String file_path2 = FULL_DIR + "dongfang2.xml";
            public static String file_path3 = FULL_DIR + "dongfang3.xml";
            public static String file_path4 = FULL_DIR + "dongfang4.xml";
            public static String file_path5 = FULL_DIR + "dongfang5.xml";
            public static String file_yaowen = FULL_DIR + "dongfang_yaowen.xml";
        }

        /**
         * 要闻推送框
         * 要闻推送 title id com.songheng.eastnews:id/vd
         * 要闻推送 imag com.songheng.eastnews:id/ve
         * 忽略 com.songheng.eastnews:id/un
         * 立即查看 com.songheng.eastnews:id/uo
         */
        public static String ACTIVITY_PACKAGE = "com.songheng.eastnews/com.oa.eastfirst.activity.WelcomeActivity";
        public static String PACKAGE_NAME = "com.songheng.eastnews";
        public static String RES_ID_RED = "com.songheng.eastnews:id/a8o"; // 红包页面
        public static String RES_ID_BTN1 = "com.songheng.eastnews:id/kj"; // 首页新闻按钮 刷新
        public static String RES_ID_BTN2 = "com.songheng.eastnews:id/ks"; // 首页任务按钮
        public static String RES_ID_JINBI_CANCLE = "com.songheng.eastnews:id/ut"; // 金币取消
        public static String RES_ID_LINGQU = "com.songheng.eastnews:id/arp";//点击领取

        public static String RES_ID_ITEM1 = "com.songheng.eastnews:id/pb"; // 首页item1

        public static String RES_ID_DIALOG = "com.songheng.eastnews:id/a_i";//dialog
        public static String RES_ID_DIALOG2 = "com.songheng.eastnews:id/ut";//dialog

        public static String RES_ID_BACK = "com.songheng.eastnews:id/ev";//返回

        public static String DONGFANG_YW_HL="com.songheng.eastnews:id/un";//要闻推送 忽略
        public static String LINGQU_CLOSE="com.songheng.eastnews:id/v6"; //任务 领取
        public static String WOZHIDAO="com.songheng.eastnews:id/n8"; //领取我知道了


//        public static String RES_ID = "com.songheng.eastnews:id/jn";
//        public static String RES_ID = "com.songheng.eastnews:id/a8e";


    }
    // 薪头条
    public static class XinTouTiao {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "xintoutiao.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.toutiao.news/com.toutiao.news.page.other.activity.SplashActivity";
        public static String RES_ID_BTN1 = "com.toutiao.news:id/id_layout_navigation_news_round_icon"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.toutiao.news:id/title_tv"; // 首页item1
        public static String RES_ID_BTN2 = "com.toutiao.news:id/id_layout_navigation_task_icon";//任务
        public static String RES_ID_LINGQU = "com.toutiao.news:id/id_fragment_information_datecoins_date";//领取
        public static String RES_ID_WO_ZHIDAO="com.toutiao.news:id/id_dialog_dateconins_question_btn";//时段奖励我知道了
        public static String RES_ID_WO_ZHIDAO_CLOSE="com.toutiao.news:id/id_dialog_datecoins_cancel";//时段奖励我知道了
        public static String MAIN_ACTIVITY="com.toutiao.news/com.toutiao.news.page.other.activity.MainActivity";
    }

    // 中青看点
    public static class ZhongQing {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "zhongqing1.xml";
            public static String file_path2 = FULL_DIR + "zhongqing2.xml";
            public static String file_path3 = FULL_DIR + "zhongqing4.xml";
            public static String file_hongbao = FULL_DIR + "zhongqing3.xml";
        }

        public static String ACTIVITY_PACKAGE = "cn.youth.news/com.weishang.wxrd.activity.SplashActivity";
        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_RED_CLOSE = "cn.youth.news:id/iv_close";

        public static String RES_ID_BTN1 = "cn.youth.news:id/tv_home_tab"; // 首页刷新
        public static String RES_ID_ITEM1 = "cn.youth.news:id/tv_article_title"; // 首页item1
        public static String RES_ID_ITEM1LL = "cn.youth.news:id/ll_title_layout"; // 首页item1 ll
        public static String DIALOG = "cn.youth.news:id/tv_title"; //判断dialog

        public static String RES_ID_BTN2 = "cn.youth.news:id/tv_user_tab"; // 我的
        public static String RES_RENWUZHONGXIN = "cn.youth.news:id/tv_name";//任务中心


        public static String DIALOG_TASK = "cn.youth.news:id/tv_task"; // 去拆现金
        public static String DIALOG_BACK = "cn.youth.news:id/iv_back"; // 返回
        public static String DIALOG_TEXT = "放弃提现"; // 放弃提现

        public static String DIALOG_PASS = "cn.youth.news:id/tv_pass";//新人红包已到账框
    }

    // 趣头条
    public static class QuTouTiao {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "qutoutiao1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.jifen.qukan/com.jifen.qkbase.main.MainActivity";
        public static String PACKAGE_NAME ="com.jifen.qukan";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.jifen.qukan:id/kr"; // 刷新
        public static String RES_ID_BTN11 = "com.jifen.qukan:id/l4"; // 刷新
        public static String RES_ID_BTN111 = "com.jifen.qukan:id/kq"; // 刷新
        public static String RES_ID_ITEM11 = "com.jifen.qukan:id/aas"; // 首页item1
        public static String RES_ID_ITEM1 = "com.jifen.qukan:id/abo"; // 首页item1
        public static String RES_ID_ITEM111 = "com.jifen.qukan:id/ac7"; // 首页item1
        public static String RES_ID_ITEM1111 = "com.jifen.qukan:id/a1e"; // 首页item1
        public static String RES_ID_HONGBAO = "com.jifen.qukan:id/a3p"; // 红包
        public static String RES_ID_BTN2 = "com.jifen.qukan:id/ky"; //我的
        public static String RES_ID_BTN3 = "com.jifen.qukan:id/kw"; //任务

        public static String HONGBAOTANKUANG = "com.jifen.qukan:id/q_";//红包弹框
        public static String HONGBAOTANKUANG1 = "com.jifen.qukan:id/q8";//红包弹框
        public static String QIANDAO = "com.jifen.qukan:id/a72";//签到
        public static String LINGQU = "com.jifen.qukan:id/vv";//领取

        public static String DIALOG_WO = "com.jifen.qukan:id/tx";
        public static String DIALOG_WO1= "com.jifen.qukan:id/u1";
        public static String DIALOG_WO2= "com.jifen.qukan:id/a58";

        public static String SUOPING="com.jifen.qukan:id/a33";//锁屏关闭
        public static String SUOPING1="com.jifen.qukan:id/so";//锁屏关闭
        public static String SUOPING3="com.jifen.qukan:id/ji";//锁屏关闭
        public static String QIANDAOTIXING="com.jifen.qukan:id/j5";//签到提醒
        public static String SUOPING2="com.jifen.qukan:id/a4g";//锁屏

        public static String TUISONG="com.jifen.qukan:id/a3m";//推送通知
        public static String QIANDAOTANCHUANG="com.jifen.qukan:id/j5";//签到弹窗
        public static String YAOQING="com.jifen.qukan:id/sj";//邀请
        public static String TUJI_WOZHIDAO="com.jifen.qukan:id/ii";//我知道了

    }

    // 蚂蚁头条
    public static class MaYi {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "mayi1.xml";
        }

        //com.ldzs.zhangxin/com.weishang.wxrd.activity.MainActivity
        public static String ACTIVITY_PACKAGE = "com.ldzs.zhangxin/com.weishang.wxrd.activity.SplashActivity";
        public static String PACKAGE_NAME = "com.ldzs.zhangxin";
        public static String RES_ID_RED = "com.ldzs.zhangxin:id/iv_close"; // 红包
        public static String RES_ID_BTN1 = "com.ldzs.zhangxin:id/tv_home_tab"; // 刷新
        public static String RES_ID_ITEM1 = "com.ldzs.zhangxin:id/tv_article_title"; // 首页item1
        public static String RES_ID_BTN2 = "com.ldzs.zhangxin:id/tv_task_tab"; //任务
        public static String DIALOG_RED = "com.ldzs.zhangxin:id/iv_activity";
        public static String LING_QU = "com.ldzs.zhangxin:id/time_period_sign_in";//领取
        public static String QUZHUANQIAN ="com.ldzs.zhangxin:id/iv_dismiss";//去赚钱
//        public static String HOME_PAGE="com.ldzs.zhangxin/com.weishang.wxrd.activity.MainActivity";//蚂蚁头条首页

    }

    // 头条多多
    public static class TouTiaoDuoDuo {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "toutiaoduoduo1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.lite.infoflow/com.lite.infoflow.launcher.LauncherActivity";
        public static String PACKAGE_NAME = "com.lite.infoflow";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.lite.infoflow.browser:id/ns"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.lite.infoflow.browser:id/wv"; // 首页item1
        public static String RES_ID_BTN2 = "com.lite.infoflow.browser:id/ny";//赚钱
        public static String RES_ID_DIALOG="com.lite.infoflow.browser:id/ng";//dialog

        public static String RES_ID_BTN11 = "com.lite.infoflow.browser:id/ns"; // 首页新闻
        public static String RES_ID_ITEM11 = "com.lite.infoflow.browser:id/wv"; // 首页item1
        public static String RES_ID_BTN22 = "com.lite.infoflow.browser:id/ny";//赚钱
        public static String RES_ID_JINBI="com.lite.infoflow.browser:id/a71";//金币

    }

    // 2345浏览器
    public static class Browser2345 {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "browser1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.browser2345/com.browser2345.BrowserActivity";
        public static String PACKAGE_NAME = "com.browser2345";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.browser2345:id/afd"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.browser2345:id/a36"; // 首页item1

        public static String RES_ID_BTN2 = "com.browser2345:id/ep";//领现金
        public static String RES_ID_LINGQIAN = "com.browser2345:id/a9y";//领钱
        public static String RES_ID_LINGQIAN_CLOSE = "com.browser2345:id/a9j";//领钱

        public static String RES_I_KONW="com.browser2345:id/ab7";//我知道了
    }



    // 微鲤看看
    public static class WeiLiKanKan {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "weilikankan1.xml";
        }

        public static String ACTIVITY_PACKAGE = "cn.weli.story/cn.etouch.ecalendar.LoadingActivity";
        public static String PACKAGE_NAME = "cn.weli.story";
        public static String RES_ID_RED = "cn.weli.story:id/iv_take"; //红包
        public static String RES_ID_RED_CLOSE = "cn.weli.story:id/iv_close"; //红包
        public static String RES_ID_RED_CLOSE1 = "cn.weli.story:id/image_close"; //红包
        public static String RES_ID_BTN1 = "cn.weli.story:id/iv_tab_1"; // 首页新闻
        public static String RES_ID_ITEM1 = "cn.weli.story:id/tv_title"; // 首页item1

        public static String RES_ID_BTN2 = "cn.weli.story:id/iv_check_day";// 签到
        public static String RES_ID_BTN2222 = "cn.weli.story:id/iv_tab_4";// 签到
        public static String ZHIDAOLE="cn.weli.story:id/bt_ok";//知道了
        public static String BAOZANG="cn.weli.story:id/text_ok";//宝藏
        public static String JIXUYUEDU="cn.weli.story:id/text_ok";//继续阅读

        public static String HOME_PAGE="cn.weli.story/cn.etouch.ecalendar.MainActivity";//首页
    }

    //韭菜资讯
    public static class JiuCaiZiXun {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "jiucaizixun1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.zujikandian.android/com.zujikandian.android.activity.StartActivity";
        public static String PACKAGE_NAME = "com.zujikandian.android";
        public static String TAN_KUANG = "com.zujikandian.android:id/iv2";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.zujikandian.android:id/image"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.zujikandian.android:id/titleTv"; // 首页item1

        public static String RES_ID_BTN2 = "com.zujikandian.android:id/image";
        public static String QIANDAO = "com.zujikandian.android:id/qiandao_tv";
        public static String BACK="com.zujikandian.android:id/left_btn";//韭菜文章返回
        public static String HOME_PAGE="com.zujikandian.android/com.zujikandian.android.home.HomeActivity";//首页
    }

    // 红包头条
    public static class HongBaoTouTiao {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "hongbaotoutiao1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.martian.hbnews/com.martian.hbnews.activity.MartianAppStart";
        public static String PACKAGE_NAME = "com.martian.hbnews";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.martian.hbnews:id/tab_imageview"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.martian.hbnews:id/news_summary_title_tv"; // 首页item1
        public static String RES_ID_ITEM1LL = "com.martian.hbnews:id/ll_root"; // 首页item1 LL

        public static String RES_ID_BTN2 = "com.martian.hbnews:id/tab_imageview";//任务
        public static String RES_ID_QianDao = "com.martian.hbnews:id/mc_sign";//签到
    }

    // 聚合头条
    public static class JuHeTouTiao {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "juhetoutiao1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.yooee.headline/com.yooee.headline.ui.activity.MainActivity";
        public static String PACKAGE_NAME = "com.yooee.headline";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.yooee.headline:id/icon"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.yooee.headline:id/auth"; // 首页item1
//        public static String RES_ID_BTN2="com.yooee.headline:id/icon";2
    }

    // 大众看点
    public static class DaZhongKanDian {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "dazhongkandian1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.dzkandian/com.dzkandian.mvp.common.ui.activity.SplashActivity";
        public static String PACKAGE_NAME = "com.dzkandian";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.dzkandian:id/iv_menu"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.dzkandian:id/tv_news_three_title"; // 首页item1
        public static String RES_ID_ITEM1LL = "com.dzkandian:id/tv_news_three_title"; // 首页item1

        public static String RES_ID_LingQu = "com.dzkandian:id/gold_animation";//领取
    }

    // 聚看点
    public static class JuKanDian {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "jukandian1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.xiangzi.jukandian/com.xiangzi.jukandian.activity.V2WelcomeActivity";
        public static String PACKAGE_NAME = "com.xiangzi.jukandian";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.xiangzi.jukandian:id/ll_tab1_layout"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.xiangzi.jukandian:id/item_artical_three_title_tv"; // 首页item1
        public static String RES_ID_BTN2 = "com.xiangzi.jukandian:id/image_tab3";//任务
        public static String LINGQU = "com.xiangzi.jukandian:id/icon_home_left_timer_lq";//领取
        public static String RES_ID_QIANDAO_DIALOG="com.xiangzi.jukandian:id/tosign";//签到

        public static String TUICHU="com.xiangzi.jukandian:id/cancel_quit";

        public static String LINGQU_CLOSE="com.xiangzi.jukandian:id/dialog_close";//领取金币去掉dialog
    }

    // 点点新闻
    public static class DianDianXinWen {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "diandianxinwen1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.yingliang.clicknews/com.yingliang.clicknews.module.splash.SplashActivity";
        public static String PACKAGE_NAME = "com.yingliang.clicknews";
        public static String RES_ID_BTN1 = "com.yingliang.clicknews:id/ivIconHome"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.yingliang.clicknews:id/tv_title"; // 首页item1
        public static String RES_ID_BTN2 = "com.yingliang.clicknews:id/ivIconTask";//任务
    }

    // 闪电看看
    public static class ShanDianKanKan {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "shandiankankan1.xml";
        }

        public static String ACTIVITY_PACKAGE = "c.l.a/c.l.a.views.AppBoxHomeActivity";
        public static String PACKAGE_NAME = "c.l.a";
        //        public static String RES_ID_BTN1 = "com.yingliang.clicknews:id/home"; // 首页新闻
        public static String RES_ID_ITEM1 = "c.l.a:id/title"; // 首页item1
        public static String RES_ID_ITEM2 = "c.l.a:id/content"; // 首页item2 内容
        //        public static String RES_ID_BTN2="com.xiangzi.jukandian:id/image_tab3";//任务
        public static String LINGQU = "c.l.a:id/reward_text";//领取
    }

    // 掌上头条
    public static class ZhangShangTouTiao {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "zhangshangtoutiao1.xml";
        }
        public static String ACTIVITY_PACKAGE = "com.kdlc.hnmcc/com.kdlc.hnmcc.component.MyMosSplashActivity";
        public static String PACKAGE_NAME = "com.kdlc.hnmcc";

//        public static String RES_ID_BTN1 = "com.hodanet.handnews:id/img_menu_news"; // 首页新闻
        public static String RES_ID_BTN2="com.kdlc.hnmcc:id/rb_mian_3";// 任务
        public static String RES_ID_ITEM1 = "com.kdlc.hnmcc:id/tv_title"; // 首页item1
        public static String LINNGQU="com.kdlc.hnmcc:id/iv_all_time";//领取
        public static String ZHANGKAIQUANWEN="com.kdlc.hnmcc:id/btn_openall";//展开全文button
    }

    // 惠头条
    public static class HuiTouTiao{
        public static class FileName {
            public static String file_path1 = FULL_DIR + "huitoutiao1.xml";
        }
        public static String ACTIVITY_PACKAGE="com.cashtoutiao/com.cashtoutiao.common.ui.SplashActivity";
        public static String PACKAGE_NAME="com.cashtoutiao";
        public static String RES_ID_BTN1 = "com.hodanet.handnews:id/img_menu_news"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.cashtoutiao:id/tv_title"; // 首页item1
        public static String SHIDUAN_HULUE = "com.cashtoutiao:id/tv_left"; // 时段忽略
        public static String DIALOG_CLOSE = "com.cashtoutiao:id/img_close"; // dialog close

        public static String XIAZAIQUXIAO = "com.cashtoutiao:id/confirm_cancel"; // dialog close

        public static String HOME_PAGE="com.cashtoutiao/com.cashtoutiao.account.ui.main.MainTabActivity";//惠头条首页

    }

    // 引力资讯
    public static class YinLiZiXun{
        public static class FileName {
            public static String file_path1 = FULL_DIR + "yinlizixun1.xml";
        }
        public static String ACTIVITY_PACKAGE="com.donews.firsthot/com.donews.firsthot.common.activitys.SplashActivity";
        public static String PACKAGE_NAME = "com.donews.firsthot";
        public static String RES_ID_BTN1 = "com.donews.firsthot:id/iv_main_home_tab"; // 首页新闻
        public static String RES_ID_BTN2 = "com.donews.firsthot:id/iv_main_personal_tab"; // 我的
        public static String RES_ID_BTN2_DIALOG = "com.donews.firsthot:id/iv_close_action_dialog"; // 我的 弹框
        public static String RES_ID_ITEM1 = "com.donews.firsthot:id/tv_item_news_title"; // 首页item1
        public static String RES_LINGQU = "com.donews.firsthot:id/tv_home_integral_point_time"; // 领取
        public static String RES_LINGQU_CLOSE = "com.donews.firsthot:id/iv_dialog_not_whole_point_reward_close"; // 领取
        public static String RES_QIANDAO="com.donews.firsthot:id/tv_signin";//签到
    }

    // 兔头条
    public static class TuTouTiao{
        public static class FileName {
            public static String file_path1=FULL_DIR + "tutoutiao1.xml";
        }
        public static String ACTIVITY_PACKAGE="com.news.tutoutiao/com.news.tutoutiao.ui.activity.SplashActivity";
        public static String PACKAGE_NAME = "com.news.tutoutiao";
    }

    // 芝麻头条
    public static class ZhiMaTouTiao{
        public static class FileName{
            public static String file_path1=FULL_DIR + "zhimatoutiao1.xml";
        }
        public static String ACTIVITY_PACKAGE="cn.com.funmeet.news/cn.com.funmeet.news.business.startup.launcher.LauncherActivity";
        public static String PACKAGE_NAME = "cn.com.funmeet.news";
    }



    public static class Checka {
        public static String check1 = "CHECK1";
        public static String check4 = "CHECK4";
        public static String check5 = "CHECK5";
        public static String check6 = "CHECK6";
        public static String check7 = "CHEKC7";
    }
}
