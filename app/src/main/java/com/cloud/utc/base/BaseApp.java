package com.cloud.utc.base;

import android.app.Application;

import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

public class BaseApp extends Application {

    private static BaseApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        QMUISwipeBackActivityManager.init(this);

    }

    public static BaseApp getApplication() {
        return mInstance;
    }
}
