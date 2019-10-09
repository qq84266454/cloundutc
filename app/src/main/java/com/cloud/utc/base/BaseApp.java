package com.cloud.utc.base;

import android.app.Application;

import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

public class BaseApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QMUISwipeBackActivityManager.init(this);
    }

}
