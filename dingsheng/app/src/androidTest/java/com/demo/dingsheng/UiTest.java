package com.demo.dingsheng;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import junit.framework.TestCase;

/**
 * created by tea9 at 2018/12/10
 */
public class UiTest extends TestCase {

    public void testA() throws UiObjectNotFoundException {
        // 获取设备对象
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        UiDevice uiDevice = UiDevice.getInstance(instrumentation);
        uiDevice.pressHome();
//        // 获取上下文
//        Context context = instrumentation.getContext();
//
//        // 启动测试App
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.yang.designsupportdemo");
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//
//        // 打开CollapsingToolbarLayout
//        String resourceId = "com.yang.designsupportdemo:id/CollapsingToolbarLayout";
//        UiObject collapsingToolbarLayout = uiDevice.findObject(new UiSelector().resourceId(resourceId));
//        collapsingToolbarLayout.click();
//
//        for (int i = 0; i < 5; i++) {
//            // 向上移动
//            uiDevice.swipe(uiDevice.getDisplayHeight() / 2, uiDevice.getDisplayHeight(),
//                    uiDevice.getDisplayHeight() / 2, uiDevice.getDisplayHeight() / 2, 10);
//
//            // 向下移动
//            uiDevice.swipe(uiDevice.getDisplayHeight() / 2, uiDevice.getDisplayHeight() / 2,
//                    uiDevice.getDisplayHeight() / 2, uiDevice.getDisplayHeight(), 10);
//        }
//
//        // 点击应用返回按钮
//        UiObject back = uiDevice.findObject(new UiSelector().description("Navigate up"));
//        back.click();
//
//        // 点击设备返回按钮
//        uiDevice.pressBack();


    }
}
