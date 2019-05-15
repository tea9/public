package com.demo.dingsheng.view;

/**
 * created by tea9 at 2018/12/7
 * 记录悬浮窗的宽高，坐标等信息
 */
public class FloatViewParams {
    public int width;//窗口的宽
    public int height;//窗口的高
    public int x;//窗口的x坐标
    public int y;//窗口的y坐标
    public int contentWidth;//当前窗口content view的宽度

    public int screenWidth;//屏幕宽度
    public int screenHeight;//屏幕高度
    public int statusBarHeight;//状态栏高度
    public int mMinWidth;//初始宽度
    public int mMaxWidth;//视频最大宽度
    public float mRatio = 1.77f;//窗口高/宽比
    public int videoViewMargin;//视频距离父view的边距
}
