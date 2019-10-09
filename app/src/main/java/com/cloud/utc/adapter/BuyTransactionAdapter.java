package com.cloud.utc.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cloud.utc.R;
import com.cloud.utc.bean.HashDetail;
import com.cloud.utc.ui.BuyVersion2Activity;


public class BuyTransactionAdapter extends BaseQuickAdapter<HashDetail, BaseViewHolder> {


    private FragmentActivity activity;

    public BuyTransactionAdapter() {
        super(R.layout.item_buy_transaction);
    }

    public BuyTransactionAdapter(FragmentActivity activity) {
        this();
        this.activity = activity;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HashDetail item) {
        helper.getView(R.id.mBtnBuy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBuyVersion2();
            }
        });

    }

    private void goBuyVersion2() {
//        activity.startActivity(new Intent(activity, BuyVersion2Activity.class));

    }
}
