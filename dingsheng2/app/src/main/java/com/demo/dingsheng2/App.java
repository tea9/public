package com.demo.dingsheng2;

import android.app.Application;
import android.content.Context;
import com.lzy.okgo.OkGo;
import com.tencent.bugly.Bugly;

/**
 * created by tea9 at 2018/12/15
 * bugly
 * https://bugly.qq.com/docs/user-guide/instruction-manual-android-upgrade/?v=20181014122344
 *
 * input swipe 25 1050 25 450 700
 *
 * adb shell dumpsys window w |grep \/ |grep name=
 *
 * uiautomator dump sdcard/dump.xml
 * adb pull sdcard/dump.xml ss.xml
 *
 *
 * /Users/shaomiao/Library/Android/sdk/tools/monitor
 *
 *
 * 产品简介 是什么 特点 功能简介
 * 自动阅读app
 *
 * 产品功能 1 2 3
 * 自动阅读 定时 选择
 *
 * 产品亮点
 * 定制性高
 * 专门的维护人员
 *
 * 竞品对比
 * 后续功能
 *
 * [005]创意新颖PPT模板[-树灵视觉]
 *
 *
 * 1.封号风险
 * 2.界面定制/后期维护
 * 3.版权所有/资金直达
 * 4.没有广告
 *
 * 4.界面
 * 5.没有广告
 * 6.资金直达
 *
 *
 * 趣头条
 * 闪电盒子
 * 聚看点
 *
 * 后续
 *
 * 广告联盟 增加收益
 * 功能优化/细分
 * 对接三方支付
 * 安全防护 破解
 * 行为监控 作弊 多ip 使用机型
 *  对这个app做的防护
 * 流量变现
 *  利用root静默安装流量费用，app厂商流量（可行，后台操作），静默浏览网站，黑市变卖肉鸡 ，投票， http://tech.hexun.com/2014-08-07/167334680.html
 *  app使用，虚假流量 /模拟真实用户行为（为企业拉风投），刷粉丝/水军 野鸡做 激活，肉鸡做数据，广告植入，利用原生流量推产品，刷单，
 *  变现，地理定位广告，数据（卖给美团等购物软件）变现，密码监控，静默截图，静默输入监控
 *
 *  判断是黑还是灰 斟酌 3点
 *
 *  盈利分析
 *
 *  app薅羊毛+授权码和手机+广告联盟
 *
 *  擦边球网站
 *  互联网培训 互联网思维 洗脑营销
 *
 *  盈利变现 购买软件，或者服务，或者
 *
 *  1.广告联盟接入
 *  2。功能细分及优化/最大程度增加收益
 *  3。对接三方支付/最大盈利
 *  4。安全防护/行为监控（作弊行文，一码多机）
 *  5。流量变现 更多的盈利项目推广
 *
 *
 *  聚合头条 验证码
 *
 */

/**
 * Android出现“Read-only file system”解决办法
 * http://wojiushiwolxw.spaces.eepw.com.cn/articles/article/item/97054
 */
public class App extends Application {

    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        Bugly.init(getApplicationContext(), "7718247216", false);
        OkGo.getInstance().init(this);
    }
}
