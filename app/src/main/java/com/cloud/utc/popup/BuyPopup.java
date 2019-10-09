package com.cloud.utc.popup;

import android.content.Context;
import android.support.annotation.NonNull;

import com.cloud.utc.R;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.util.XPopupUtils;


public class BuyPopup extends BottomPopupView {
    public BuyPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.pop_buy;
    }

    // 最大高度为Window的0.85
    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getWindowHeight(getContext()) * .85f);
    }

}
