package com.demo.dingsheng.util;

import com.demo.dingsheng.entitiy.TabEntity;

/**
 * created by tea9 at 2018/11/25
 * adb shell dumpsys window w |grep \/ |grep name=
 */
public class Constant {

    public static String A_FLAG = "A_FLAG";  // 两个服务切换
    public static String AUTH_CODE = "AUTH_CODE"; // 授权码

    public static String BEFORE_TEXT = "BEFORE_TEXT"; // 第一个服务的数据
    public static String AFTER_TEXT = "AFTER_TEXT"; //第二个服务的数据
    public static String ALL_TEXT = "ALL_TEXT"; // 全部的数据

    public static String STOP_SERVICE = "STOP_SERVICE";
    public static String START_CMD = "START_CMD";

    public static TabEntity[] data_group = {
//            new TabEntity("东方头条", Constant.ENUM.DONGFANGTOUTIAO),
            new TabEntity("薪头条", ENUM.XINTOUTIAO),
            new TabEntity("中青看点", ENUM.ZHONGQINGKANDIAN),
            new TabEntity("趣头条", ENUM.QUTOUTIAO),
            new TabEntity("蚂蚁头条", ENUM.MAYITOUTIAO),
            new TabEntity("头条多多", ENUM.TOUTIAODUODUO),
            new TabEntity("2345浏览器", ENUM.BROWER2345),
            new TabEntity("微鲤看看", ENUM.WEILIKANKAN),
            new TabEntity("韭菜头条", ENUM.JIUCAITOUTIAO),
            new TabEntity("红包头条", ENUM.HONGBAOTOUTIAO),
            new TabEntity("聚合头条", ENUM.JUHETOUTIAO),
            new TabEntity("大众看点", ENUM.DAZHONGKANDIAN),
            new TabEntity("聚看点", ENUM.JUKANDIAN),
            new TabEntity("掌上头条", ENUM.ZHANGSHANGTOUTIAO),
            new TabEntity("点点新闻", ENUM.DIANDIANXINWEN),
            new TabEntity("闪电看看", ENUM.SHANDIANKANKAN)
            };

    public static class Checka {
        public static String check1 = "CHECK1";
        public static String check4 = "CHECK4";
        public static String check5 = "CHECK5";
        public static String check6 = "CHECK6";
        public static String check7 = "CHEKC7";
    }

    public static String FILE_PATH = "/sdcard/dump.xml";

    public static String TAG = "tea9";

    public static String PRE_DIR_NAME = "/sdcard/";
    public static String DIR_NAME = "dingsheng/";

    public static String FULL_DIR = PRE_DIR_NAME;

    public static void start(String activity_name) throws InterruptedException {
//        SharedPreferencesUtils.putInfo(App.mContext, Constant.START_CMD, true);
        ShellUtil.home();
        Thread.sleep(1 * 1000);
        ShellUtil.clear();
        Thread.sleep(2 * 1000);
//        RootCmd.execRootCmd("am force-stop com.songheng.eastnews"); //杀死东方头条
        Thread.sleep(2 * 1000);
        ShellUtil.startActivity(activity_name);
        Thread.sleep(10 * 1000);
    }

    // 判断首页
    public static boolean checkHome(String id,String path) {
        if (ShellUtil.checkPage(id,path)){
            return true;
        } else {
            ShellUtil.back();

            if (ShellUtil.checkPage(id,path)){
                return true;
            }else {
                ShellUtil.back();
                if (ShellUtil.checkPage(id,path)){
                    return true;
                }else {
                    ShellUtil.back();
                    return false;
                }
            }
        }
    }

    //    东方头条、中青看点、趣头条、蚂蚁头条、头条多多、2345浏览器，然后再运行微鲤看看、韭菜头条（没找到）、红包头条、聚合头条、大众看点（没下载到）、
    // 聚看点、掌上头条、点点新闻、闪电看看(没吓到)、、薪头条，以12个小时为分界。
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
    }

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
        public static String RES_ID_RED = "com.songheng.eastnews:id/a8o"; // 红包页面
        public static String RES_ID_BTN1 = "com.songheng.eastnews:id/ki"; // 首页新闻按钮 刷新
        public static String RES_ID_BTN2 = "com.songheng.eastnews:id/kr"; // 首页任务按钮
        public static String RES_ID_JINBI_CANCLE = "com.songheng.eastnews:id/ut"; // 金币取消
        public static String RES_ID_LINGQU = "com.songheng.eastnews:id/aqk";//点击领取

        public static String RES_ID_ITEM1 = "com.songheng.eastnews:id/oz"; // 首页item1

        public static String RES_ID_DIALOG = "com.songheng.eastnews:id/a_i";//dialog
        public static String RES_ID_DIALOG2 = "com.songheng.eastnews:id/ut";//dialog

        public static String RES_ID_BACK = "com.songheng.eastnews:id/ev";//返回

        public static String DONGFANG_YW_HL="com.songheng.eastnews:id/un";//要闻推送 忽略


//        public static String RES_ID = "com.songheng.eastnews:id/jn";
//        public static String RES_ID = "com.songheng.eastnews:id/a8e";


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
        public static String RES_ID_BTN1 = "com.jifen.qukan:id/kh"; // 刷新
        public static String RES_ID_ITEM1 = "com.jifen.qukan:id/a0g"; // 首页item1
        public static String RES_ID_BTN2 = "com.jifen.qukan:id/kn"; //我的
        public static String RES_ID_BTN3 = "com.jifen.qukan:id/kl"; //任务

        public static String HONGBAOTANKUANG = "com.jifen.qukan:id/q_";//红包弹框
        public static String HONGBAOTANKUANG1 = "com.jifen.qukan:id/q8";//红包弹框
        public static String QIANDAO = "com.jifen.qukan:id/a72";//签到
        public static String LINGQU = "com.jifen.qukan:id/vv";//领取

        public static String DIALOG_WO = "com.jifen.qukan:id/tx";
        public static String DIALOG_WO1= "com.jifen.qukan:id/u1";
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
    }

    // 2345浏览器
    public static class Browser2345 {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "browser1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.browser2345/com.browser2345.BrowserActivity";
        //        public static String RES_ID_RED = "cn.youth.news:id/iv_activity";
        public static String RES_ID_BTN1 = "com.browser2345:id/e7"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.browser2345:id/a1e"; // 首页item1
        public static String RES_ID_BTN2 = "com.browser2345:id/ep";//领现金
        public static String RES_ID_LINGQIAN = "com.browser2345:id/a9y";//领钱
        public static String RES_ID_LINGQIAN_CLOSE = "com.browser2345:id/a9j";//领钱
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
        public static String RES_ID_ITEM1 = "com.yooee.headline:id/title"; // 首页item1
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
    }

    // 点点新闻
    public static class DianDianXinWen {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "diandianxinwen1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.yingliang.clicknews/com.yingliang.clicknews.module.splash.SplashActivity";
        public static String RES_ID_BTN1 = "com.yingliang.clicknews:id/home"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.yingliang.clicknews:id/iv_reward"; // 首页item1
        public static String RES_ID_BTN2 = "com.xiangzi.jukandian:id/image_tab3";//任务
    }

    // 闪电看看
    public static class ShanDianKanKan {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "shandiankankan1.xml";
        }

        public static String ACTIVITY_PACKAGE = "c.l.a/c.l.a.views.AppBoxHomeActivity";
        //        public static String RES_ID_BTN1 = "com.yingliang.clicknews:id/home"; // 首页新闻
        public static String RES_ID_ITEM1 = "c.l.a:id/content"; // 首页item1
        //        public static String RES_ID_BTN2="com.xiangzi.jukandian:id/image_tab3";//任务
        public static String LINGQU = "c.l.a:id/reward_text";//领取
    }

    public static class XinTouTiao {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "xintoutiao.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.toutiao.news/com.toutiao.news.page.other.activity.SplashActivity";
        public static String RES_ID_BTN1 = "com.toutiao.news:id/id_layout_navigation_news_round_icon"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.toutiao.news:id/title_tv"; // 首页item1
        public static String RES_ID_BTN2 = "com.toutiao.news:id/id_layout_navigation_task_icon";//任务
        public static String SHIDUAN = "com.toutiao.news:id/id_fragment_information_datecoins_title";//领取
    }


    public static class YinLiHongBao {
        public static class FileName {
            public static String file_path1 = FULL_DIR + "yinlihongbao1.xml";
        }

        public static String ACTIVITY_PACKAGE = "com.yingliang.clicknews/com.yingliang.clicknews.module.splash.SplashActivity";
        public static String RES_ID_BTN1 = "com.yingliang.clicknews:id/home"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.yingliang.clicknews:id/iv_reward"; // 首页item1
    }

    // 海草公社
    public static class HaiCaoGongShe {
        public static String ACTIVITY_PACKAGE = "com.billionstech.grassbook/com.billionstech.grassbook.business.launcher.welcome.WelComeActivity";

//        public static String RES_ID_BTN1 = "com.cashnews.spicy:id/tv_title_news_three"; // 首页新闻
//        public static String RES_ID_ITEM1 = "com.cashnews.spicy:id/tv_title_news_three"; // 首页item1
    }

    // 掌上头条
    public static class ZhangShangTouTiao {
        public static String ACTIVITY_PACKAGE = "com.kdlc.hnmcc/com.kdlc.hnmcc.component.SplashActivity";

        public static String RES_ID_BTN1 = "com.cashnews.spicy:id/tv_title_news_three"; // 首页新闻
        public static String RES_ID_ITEM1 = "com.cashnews.spicy:id/tv_title_news_three"; // 首页item1
    }


    // 芒果看点
    public static class MangGuo {
        public static String ACTIVITY_PACKAGE = "com.kuaixun.mgkd/com.kuaixun.mgkd.module.main.start.StartActivity";
        public static String RES_ID_RED = "com.demo.android_touch:id/btn1";
    }

    // 值得看看
    public static class ZhiDeKanKan {
        public static String ACTIVITY_PACKAGE = "com.weikuai.wknews/com.weikuai.wknews.ui.activity.MainActivity";
//        public static String RES_ID_BTN1 = "com.cashnews.spicy:id/tv_title_news_three"; // 首页新闻
//        public static String RES_ID_ITEM1 = "com.cashnews.spicy:id/tv_title_news_three"; // 首页item1
    }


}
