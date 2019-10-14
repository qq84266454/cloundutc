package com.cloud.utc;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.BarUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.cloud.utc.event.BusProvider;
import com.cloud.utc.event.EventBusInfo;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


public class BaseActivity extends AppCompatActivity {


    protected void setBg(int color) {
        View barView = findViewById(R.id.m_bar_view);
        View rl_title_bar = findViewById(R.id.rl_title_bar);
        if (barView != null) {
            ViewGroup.LayoutParams layoutParams = barView.getLayoutParams();
            layoutParams.height = BarUtils.getStatusBarHeight();
            barView.setLayoutParams(layoutParams);
            barView.setBackgroundResource(color);
        }
        if (rl_title_bar != null) {
            rl_title_bar.setBackgroundResource(color);
        }
    }


    protected BaseActivity instance;

    protected QMUITipDialog showLoading(int iconType, String msg) {
        return new QMUITipDialog.Builder(this)
                .setIconType(iconType)
                .setTipWord(msg)
                .create();
    }

    protected void initStatus() {
        View barView = findViewById(R.id.m_bar_view);
        if (barView != null) {
            ViewGroup.LayoutParams layoutParams = barView.getLayoutParams();
            layoutParams.height = BarUtils.getStatusBarHeight();
            barView.setLayoutParams(layoutParams);
            QMUIStatusBarHelper.setStatusBarLightMode(this);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
        ScreenUtils.setPortrait(this);
        instance = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        BusProvider.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        BusProvider.unregister(this);
    }

    @Override
    public Resources getResources() {
        //需要升级到 v1.1.2 及以上版本才能使用 AutoSizeCompat
        return super.getResources();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(EventBusInfo eventBusInfo) {
        switch (eventBusInfo.getType()) {
        }
    }

    protected void goActivity(Class aclass) {
        startActivity(new Intent(this, aclass));
    }
}
