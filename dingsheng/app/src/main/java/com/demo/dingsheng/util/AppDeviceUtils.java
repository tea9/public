package com.demo.dingsheng.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;

import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * created by tea9 at 2018/12/7
 */
//public class AppDeviceUtils {
//
//    private static final long VIBRATOR_DEFAULT_DURATION = 1000;
//    private static final long[] VIBRATOR_DEFAULT_DURATION_PATTERN = new long[]{500, 200, 500, 200};
//    private static final int VIBRATOR_DEFAULT_NOREPEAT = -1;
//
//    public static Point getResolution(Context context) {
//        Display display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
//        Point point = new Point();
//        display.getSize(point);
//        return point;
//    }
//
//    public static void startVibrator(Context context) {
//        startVibrator(context, VIBRATOR_DEFAULT_DURATION);
//    }
//
//    public static void startVibrator(Context context, long milliseconds) {
//        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
//        if (vibrator.hasVibrator()) {
//            vibrator.vibrate(milliseconds);
//        }
//    }
//
//    public static void startVibratorPattern(Context context) {
//        startVibratorPattern(context, VIBRATOR_DEFAULT_DURATION_PATTERN, -1);
//    }
//
//    public static void startVibratorPattern(Context context, long[] pattern, int repeat) {
//        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
//        if (vibrator.hasVibrator()) {
//            vibrator.vibrate(pattern, repeat);
//        }
//    }
//
//    public static String getDeviceId(Context context) {
//        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
//    }
//
//    public static String getMacAddress(Context context) {
//        return ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
//    }
//
//    public static String getVersionName(Context context) {
//        try {
//            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
//        } catch (NameNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public static int getStatusBarHeight(Context context) {
//        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", Constants.ANDROID);
//        if (resourceId > 0) {
//            return context.getResources().getDimensionPixelSize(resourceId);
//        }
//        return 0;
//    }
//
//    public static void installAPK(Context context, File appFile) {
//        Intent intent = new Intent("android.intent.action.VIEW");
//        intent.setDataAndType(Uri.fromFile(appFile), "application/vnd.android.package-archive");
//        intent.setFlags(268435456);
//        context.startActivity(intent);
//    }
//
//    public static boolean isAInstallPackage(Context context, String packageName) {
//        List<PackageInfo> pinfo = context.getPackageManager().getInstalledPackages(0);
//        List<String> packages = new ArrayList();
//        if (pinfo != null) {
//            for (int i = 0; i < pinfo.size(); i++) {
//                packages.add(((PackageInfo) pinfo.get(i)).packageName);
//            }
//        }
//        return packages.contains(packageName);
//    }
//
//    public static boolean openApp(Context context, String packageName) {
//        try {
//            Intent i = context.getPackageManager().getLaunchIntentForPackage(packageName);
//            if (i == null) {
//                return false;
//            }
//            i.addCategory("android.intent.category.LAUNCHER");
//            context.startActivity(i);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public static void backAPP(Context context, Class clazz, int page) {
//        Intent intent = new Intent();
//        intent.putExtra(ElfinFreeActivity.class.getCanonicalName(), page);
//        intent.setClass(context, clazz);
//        intent.addFlags(2097152);
//        intent.addFlags(268435456);
//        context.startActivity(intent);
//    }
//
//    public static int getDipToPx(Context context, float dip) {
//        return (int) (((double) (context.getResources().getDisplayMetrics().density * dip)) + 0.5d);
//    }
//
//    public static int getPxToDip(Context context, float px) {
//        return (int) (((double) (px / context.getResources().getDisplayMetrics().density)) + 0.5d);
//    }
//
//    public static boolean isPackageInstalled(Context context, String packageName) {
//        if (packageName == null) {
//            return false;
//        }
//        PackageInfo packageInfo;
//        try {
//            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
//        } catch (NameNotFoundException var4) {
//            packageInfo = null;
//            var4.printStackTrace();
//        }
//        if (packageInfo != null) {
//            return true;
//        }
//        return false;
//    }
//
//    public static boolean installApplicationNormal(Context ctx, String path) {
//        Log.e("xys", "installApplicationNormal:" + ctx + ",path:" + path);
//        return installApplicationNormal(ctx, new File(path));
//    }
//
//    public static boolean installApplicationNormal(Context ctx, File mainFile) {
//        try {
//            Log.e("xys", "mainfile:" + mainFile);
//            Uri e = Uri.fromFile(mainFile);
//            Intent intent = new Intent("android.intent.action.VIEW");
//            intent.setFlags(268435456);
//            intent.setDataAndType(e, "application/vnd.android.package-archive");
//            ctx.startActivity(intent);
//        } catch (Exception var4) {
//            var4.printStackTrace();
//            Log.e("xys", "var4:" + var4.getMessage());
//        }
//        return true;
//    }
//
//    public static String getWIFIIpAddress(Context context) {
//        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
//        if (!wifiManager.isWifiEnabled()) {
//            wifiManager.setWifiEnabled(true);
//        }
//        return intToIp(wifiManager.getConnectionInfo().getIpAddress());
//    }
//
//    private static String intToIp(int i) {
//        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
//    }
//
//    public static String getLocalIpAddress() {
//        try {
//            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
//            while (en.hasMoreElements()) {
//                Enumeration<InetAddress> enumIpAddr = ((NetworkInterface) en.nextElement()).getInetAddresses();
//                while (enumIpAddr.hasMoreElements()) {
//                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
//                    if (!inetAddress.isLoopbackAddress()) {
//                        return inetAddress.getHostAddress().toString();
//                    }
//                }
//            }
//        } catch (SocketException ex) {
//            Log.e("Wifi IpAddress", ex.toString());
//        }
//        return null;
//    }
//
//    public static String phoneBrand() {
//        return Build.BRAND;
//    }
//
//    public static String getIMSI(Context context) {
//        return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
//    }
//
//    public static String getUserAgent(Context context) {
//        return new WebView(context).getSettings().getUserAgentString();
//    }
//
//    public static String getIPAddress(boolean useIPv4) {
//        try {
//            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
//            while (nis.hasMoreElements()) {
//                NetworkInterface ni = (NetworkInterface) nis.nextElement();
//                if (ni.isUp()) {
//                    Enumeration<InetAddress> addresses = ni.getInetAddresses();
//                    while (addresses.hasMoreElements()) {
//                        InetAddress inetAddress = (InetAddress) addresses.nextElement();
//                        if (!inetAddress.isLoopbackAddress()) {
//                            boolean isIPv4;
//                            String hostAddress = inetAddress.getHostAddress();
//                            if (hostAddress.indexOf(58) < 0) {
//                                isIPv4 = true;
//                            } else {
//                                isIPv4 = false;
//                            }
//                            if (useIPv4) {
//                                if (isIPv4) {
//                                    return hostAddress;
//                                }
//                            } else if (!isIPv4) {
//                                int index = hostAddress.indexOf(37);
//                                return index < 0 ? hostAddress.toUpperCase() : hostAddress.substring(0, index).toUpperCase();
//                            }
//                        }
//                    }
//                    continue;
//                }
//            }
//        } catch (SocketException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
