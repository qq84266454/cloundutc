package com.cloud.utc.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cloud.utc.R;
import com.cloud.utc.bean.HashDetail;
import com.cloud.utc.bean.PayMethod;


public class PayMethodAdapter extends BaseQuickAdapter<PayMethod, BaseViewHolder> {


    public PayMethodAdapter() {
        super(R.layout.item_pay_method);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, PayMethod item) {
        helper.setText(R.id.mTvName, item.getName());
    }
}
