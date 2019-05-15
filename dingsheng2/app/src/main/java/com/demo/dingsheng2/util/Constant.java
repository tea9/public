package com.demo.dingsheng2.util;

import android.util.Log;
import com.demo.dingsheng2.entity.TabEntity;

/**
 * created by tea9 at 2019/1/9
 *
 * Users/shaomiao/Library/Android/sdk/tools/monitor
 * 薪头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器
 * 微鲤看看、韭菜头条、红包头条、聚合头条、大众看点、聚看点、掌上头条、点点新闻、闪电看看
 *
 *
 */
public class Constant {

    public static int BEFORE_TASK_COUNT=5; //前6个整体循环3 5
    public static int AFTER_TASK_COUNT=6;//后几个整体循环4 6

//    public static int TASK_COUNT=2;
    public static int TASK_COUNT=7; //每个的次数 5
    public static int TASK_COUNT2=4;//每个的次数 2

    public static String TAG = "shaomiao";
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
//            new TabEntity("东方头条", Constant.ENUM.DONGFANGTOUTIAO),
            new TabEntity("惠头条", ENUM.HUITOUTIAO),
            new TabEntity("聚合头条", ENUM.JUHETOUTIAO),
            new TabEntity("中青看点", ENUM.ZHONGQINGKANDIAN),
            new TabEntity("趣头条", ENUM.QUTOUTIAO),
            new TabEntity("蚂蚁头条", ENUM.MAYITOUTIAO),
            new TabEntity("头条多多", ENUM.TOUTIAODUODUO),
            new TabEntity("2345浏览器", ENUM.BROWER2345),
            new TabEntity("微鲤看看", ENUM.WEILIKANKAN),
            new TabEntity("韭菜头条", ENUM.JIUCAITOUTIAO),
            new TabEntity("红包头条", ENUM.HONGBAOTOUTIAO),
            new TabEntity("薪头条", ENUM.XINTOUTIAO),
            new TabEntity("大众看点", ENUM.DAZHONGKANDIAN),
            new TabEntity("引力资讯", ENUM.JUKANDIAN),
            new TabEntity("掌上头条", ENUM.ZHANGSHANGTOUTIAO),
            new TabEntity("点点新闻", ENUM.DIANDIANXINWEN),
            new TabEntity("闪电看看", ENUM.SHANDIANKANKAN)
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
    }

    public static void start(String activity_name) throws InterruptedException {
        Log.e(TAG,"start home"+Thread.currentThread().getName());
        ShellUtil.home();
        Thread.sleep(2 * 1000);
        Log.e(TAG,"start clear"+Thread.currentThread().getName());
        ShellUtil.clear();
        Thread.sleep(2 * 1000);
        Log.e(TAG,"start startActivity"+Thread.currentThread().getName());
        ShellUtil.startActivity(activity_name);
        Log.e(TAG,"start startActivity ssss"+Thread.currentThread().getName());
        Thread.sleep(10 * 1000);
        Log.e(TAG,"start startActivity 等待成功"+Thread.currentThread().getName());
    }


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
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.jifen.qukan:id/kr"; // 刷新
        public static String RES_ID_ITEM1 = "com.jifen.qukan:id/aas"; // 首页item1
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
    }

    // 蚂蚁头条
    public static class MaYi {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "mayi1.xml";
        }

        //com.ldzs.zhangxin/com.weishang.wxrd.activity.MainActivity
        public static String ACTIVITY_PACKAGE = "com.ldzs.zhangxin/com.weishang.wxrd.activity.SplashActivity";
        public static String RES_ID_RED = "com.ldzs.zhangxin:id/iv_close"; // 红包
        public static String RES_ID_BTN1 = "com.ldzs.zhangxin:id/tv_home_tab"; // 刷新
        public static String RES_ID_ITEM1 = "com.ldzs.zhangxin:id/tv_article_title"; // 首页item1
        public static String RES_ID_BTN2 = "com.ldzs.zhangxin:id/tv_task_tab"; //任务
        public static String DIALOG_RED = "com.ldzs.zhangxin:id/iv_activity";
        public static String LING_QU = "com.ldzs.zhangxin:id/time_period_sign_in";//领取

    }

    // 头条多多
    public static class TouTiaoDuoDuo {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "toutiaoduoduo1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.lite.infoflow/com.lite.infoflow.launcher.LauncherActivity";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.lite.infoflow.browser:id/nq"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.lite.infoflow.browser:id/wq"; // 首页item1
        public static String RES_ID_BTN2 = "com.lite.infoflow.browser:id/nw";//赚钱
        public static String RES_ID_DIALOG="com.lite.infoflow.browser:id/ng";//dialog
    }

    // 2345浏览器
    public static class Browser2345 {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "browser1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.browser2345/com.browser2345.BrowserActivity";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.browser2345:id/aer"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.browser2345:id/a2q"; // 首页item1

        public static String RES_ID_BTN2 = "com.browser2345:id/ep";//领现金
        public static String RES_ID_LINGQIAN = "com.browser2345:id/a9y";//领钱
        public static String RES_ID_LINGQIAN_CLOSE = "com.browser2345:id/a9j";//领钱

        public static String RES_I_KONW="com.browser2345:id/aal";//我知道了
    }



    // 微鲤看看
    public static class WeiLiKanKan {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "weilikankan1.xml";
        }

        public static String ACTIVITY_PACKAGE = "cn.weli.story/cn.etouch.ecalendar.LoadingActivity";
        public static String RES_ID_RED = "cn.weli.story:id/iv_take"; //红包
        public static String RES_ID_RED_CLOSE = "cn.weli.story:id/iv_close"; //红包
        public static String RES_ID_BTN1 = "cn.weli.story:id/iv_tab_1"; // 首页新闻
        public static String RES_ID_ITEM1 = "cn.weli.story:id/tv_title"; // 首页item1

        public static String RES_ID_BTN2 = "cn.weli.story:id/iv_check_day";// 签到
    }

    //韭菜资讯
    public static class JiuCaiZiXun {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "jiucaizixun1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.zujikandian.android/com.zujikandian.android.activity.StartActivity";
        public static String TAN_KUANG = "com.zujikandian.android:id/iv2";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.zujikandian.android:id/image"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.zujikandian.android:id/titleTv"; // 首页item1

        public static String RES_ID_BTN2 = "com.zujikandian.android:id/image";
        public static String QIANDAO = "com.zujikandian.android:id/qiandao_tv";
    }

    // 红包头条
    public static class HongBaoTouTiao {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "hongbaotoutiao1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.martian.hbnews/com.martian.hbnews.activity.MartianAppStart";
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

//        public static String RES_ID_BTN1 = "com.hodanet.handnews:id/img_menu_news"; // 首页新闻
        public static String RES_ID_BTN2="com.kdlc.hnmcc:id/rb_mian_3";// 任务
        public static String RES_ID_ITEM1 = "com.kdlc.hnmcc:id/tv_title"; // 首页item1
        public static String LINNGQU="com.kdlc.hnmcc:id/iv_all_time";//领取
        public static String ZHANGKAIQUANWEN="com.kdlc.hnmcc:id/btn_openall";//展开全文button
    }

    public static class HuiTouTiao{
        public static class FileName {
            public static String file_path1 = FULL_DIR + "huitoutiao1.xml";
        }
        public static String ACTIVITY_PACKAGE="com.cashtoutiao/com.cashtoutiao.common.ui.SplashActivity";
        public static String RES_ID_BTN1 = "com.hodanet.handnews:id/img_menu_news"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.cashtoutiao:id/tv_title"; // 首页item1
        public static String SHIDUAN_HULUE = "com.cashtoutiao:id/tv_left"; // 时段忽略
        public static String DIALOG_CLOSE = "com.cashtoutiao:id/img_close"; // dialog close


    }
    public static class YinLiZiXun{
        public static class FileName {
            public static String file_path1 = FULL_DIR + "yinlizixun1.xml";
        }
        public static String ACTIVITY_PACKAGE="com.donews.firsthot/com.donews.firsthot.common.activitys.SplashActivity";
        public static String RES_ID_BTN1 = "com.donews.firsthot:id/iv_main_home_tab"; // 首页新闻
        public static String RES_ID_BTN2 = "com.donews.firsthot:id/iv_main_personal_tab"; // 我的
        public static String RES_ID_BTN2_DIALOG = "com.donews.firsthot:id/iv_close_action_dialog"; // 我的 弹框
        public static String RES_ID_ITEM1 = "com.donews.firsthot:id/tv_item_news_title"; // 首页item1
        public static String RES_LINGQU = "com.donews.firsthot:id/tv_home_integral_point_time"; // 领取
        public static String RES_LINGQU_CLOSE = "com.donews.firsthot:id/iv_dialog_not_whole_point_reward_close"; // 领取
        public static String RES_QIANDAO="com.donews.firsthot:id/tv_signin";//签到
    }



    public static class Checka {
        public static String check1 = "CHECK1";
        public static String check4 = "CHECK4";
        public static String check5 = "CHECK5";
        public static String check6 = "CHECK6";
        public static String check7 = "CHEKC7";
    }
}
