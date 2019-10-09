package com.cloud.utc.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cloud.utc.R;
import com.cloud.utc.bean.HashDetail;


public class HashDetailAdapter extends BaseQuickAdapter<HashDetail,BaseViewHolder> {


    public HashDetailAdapter() {
        super(R.layout.item_hash_detail);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HashDetail item) {

    }
}
