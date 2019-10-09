package com.cloud.utc.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;


/**
 * @author huangxinpeng
 * @date 16/7/5
 * @description 获取各种act值得工具类
 */
public class UIUtils {
    private static LayoutInflater layoutInflater;


    /**
     * 将一个任务放到ui主线程执行
     *
     * @param task
     */
//    public static void runOnUiThread(Runnable task) {
//        // 判断是否在主线程
//        if (BaseApplication.getMainThreadId() == Thread.currentThread().getId()) {
//            task.run();
//        } else {
//            BaseApplication.getMainThreadHandler().post(task);
//        }
//    }

    /**
     * 获取主线程id
     *
     * @return
     */
//    public static long getMainThreadId() {
//        return BaseApplication.getMainThreadId();
//    }

    /**
     * 获取主线程handler
     *
     * @return
     */
//    public static Handler getMainThreadHandler() {
//        return BaseApplication.getMainThreadHandler();
//
//    }

    /**
     * 获取本应用的包名
     *
     * @return
     */
//    public static String getPackageName() {
//        return getContext().getPackageName();
//    }

    /**
     * 获取资源对象
     *
     * @return
     */
//    public static Resources getResources() {
//        return getContext().getResources();
//    }

    /**
     * 像素转为dp
     *
     * @param px
     * @return
     */
//    public static int px2dip(int px) {
//
//        // 公式 1: px = dp * (dpi / 160)
//        // 公式 2: dp = px / density;
//
////        final float density = getResources().getDisplayMetrics().density;
////        return (int) (px / density + 0.5f);
//    }

    /**
     * dp转为像素
     *
     */
//    public static int dip2px(int dip) {
//
//        final float density = getResources().getDisplayMetrics().density;
//        return (int) (dip * density + 0.5f);
//    }

    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 开启一个activity
     *
     * @param activity
     * @param cls
     */
    public static void startActivity(AppCompatActivity activity, Class<?> cls) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


    /**
     * 开启一个activity
     *
     * @param context
     * @param intent
     */
    public static void startActivity(Context context, Intent intent) {
        context.startActivity(intent);
    }

    /**
     * 切换activity时的动画效果
     *
     * @param activity
     */
    public static void switchActivityAnim(AppCompatActivity activity) {
        //activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        activity.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    /**
     * 获取一个格式化后的字符串
     *
     * @param strResId
     * @param args
     * @return
     */
//    public static String getFormatString(int strResId, Object... args) {
//        String str = UIUtils.getResources().getString(strResId);
//        return String.format(str, args);
//    }

    /**
     * 获取一个格式化后的字符串
     *
     * @return
     */
//    public static String getResString(int strResId) {
//        String str = UIUtils.getResources().getString(strResId);
//        return str;
//    }

    public static void startActivity(AppCompatActivity act, Intent intent) {
        if (act == null) {
            return;
        }
        if (act != null) {
            act.startActivity(intent);
            act.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    public static void startActivity(AppCompatActivity act, Intent intent, int inAnim, int outAnim) {
        if (act == null) {
            return;
        }
        if (act != null) {
            act.startActivity(intent);
            act.overridePendingTransition(inAnim, outAnim);
        }
    }

    public static boolean isUIMainThred() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /**
     * 根据layout的资源id创建一个布局
     *
     * @param resId layout的id
     * @return
     */
//    public static View createView(int resId) {
//        if (layoutInflater == null) {
//            layoutInflater = LayoutInflater.from(getContext());
//        }
//        return layoutInflater.inflate(resId, null);
//    }

    /**
     * 根据layout的资源id创建一个布局
     *
     * @param resId  layout的id
     * @param parent layout的父布局
     * @return
     */
//    public static View createView(int resId, ViewGroup parent) {
//        if (layoutInflater == null) {
//            layoutInflater = LayoutInflater.from(getContext());
//        }
//        return layoutInflater.inflate(resId, parent, false);
//    }

}
