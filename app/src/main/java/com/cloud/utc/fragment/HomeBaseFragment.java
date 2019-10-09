package com.cloud.utc.fragment;

import android.content.Intent;
import android.os.Bundle;

import com.cloud.utc.base.BaseFragment;
import com.cloud.utc.event.BusProvider;
import com.cloud.utc.event.EventBusInfo;

import org.greenrobot.eventbus.Subscribe;

/**
 * @author huangxinpeng
 * @date 16/7/4
 * @description 主页fragment的基类
 */
public abstract class HomeBaseFragment extends BaseFragment {

    // 标志位，标志已经初始化完成。
    private boolean isPrepared;
    protected boolean isVisible;
    protected boolean isLoad;

    /**
     * 在这里实现Fragment数据的缓加载.
     *
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        KLog.e("homebaseFragment:" + getUserVisibleHint());
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    protected void onVisible() {
        lazyLoad();
    }

    protected void lazyLoad() {
        if (!isPrepared || isLoad) {
            return;
        }
        initData();
        BusProvider.register(this);
//        if (this instanceof NewHomeAskFragment) {
//            return;
//        }
        isLoad = true;
    }

    protected void onInvisible() {
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //XXX初始化view的各控件
        isPrepared = true;
        lazyLoad();
    }

    /**
     * 数据加载的方法
     *
     * @return
     */
    protected abstract void initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
       BusProvider.unregister(this);
    }

    @Subscribe
    public void onEventMainThread(EventBusInfo eventBusInfo) {

    }

}
