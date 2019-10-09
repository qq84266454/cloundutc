package com.cloud.utc.test;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;

public class TestFragmentActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_buy);
//        new XPopup.Builder(this)
////                        .asCustom(new CustomDrawerPopupView(getContext()))
////                        .hasShadowBg(false)
//                .asCustom(new PagerDrawerPopup(this))
////                        .asCustom(new ListDrawerPopupView(getContext()))
//                .show();
    }
}
