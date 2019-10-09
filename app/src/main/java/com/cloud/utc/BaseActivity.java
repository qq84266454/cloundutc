package com.cloud.utc;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cloud.utc.event.BusProvider;
import com.cloud.utc.event.EventBusInfo;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;



public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QMUIStatusBarHelper.translucent(this);
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
}
