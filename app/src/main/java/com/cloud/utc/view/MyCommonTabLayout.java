package com.cloud.utc.view;

import android.content.Context;
import android.util.AttributeSet;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

/**
 * Created by think on 2017/5/4.
 */

public class MyCommonTabLayout extends CommonTabLayout {
    public MyCommonTabLayout(Context context) {
        super(context, null, 0);
    }

    public MyCommonTabLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    OnTabSelectListener mListener;

    @Override
    public void setCurrentTab(int currentTab) {
        super.setCurrentTab(currentTab);
        if (mListener != null) {
            mListener.onTabSelect(currentTab);
        }


    }


    public void setOnTabSelectListener(OnTabSelectListener listner) {
        mListener = listner;
    }
}
