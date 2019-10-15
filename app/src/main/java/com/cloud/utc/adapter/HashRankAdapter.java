package com.cloud.utc.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.icu.util.EthiopicCalendar;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.cloud.utc.R;
import com.cloud.utc.bean.HashDetail;


public class HashRankAdapter extends BaseQuickAdapter<HashDetail, BaseViewHolder> {
    Activity activity;

    public HashRankAdapter(Activity activity) {
        super(R.layout.item_hash_rank);
        this.activity = activity;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, HashDetail item) {
        if (helper.getLayoutPosition() == 0) {
            helper.setTextColor(R.id.mTvName, Color.parseColor("#B5B9E6FF"));

            helper.setTextColor(R.id.mTvCount, activity.getResources().getColor(R.color.white));
            helper.setTextColor(R.id.mTvShanDian, activity.getResources().getColor(R.color.white_60));
            helper.getView(R.id.mRl).setBackground(activity.getResources().getDrawable(R.drawable.bg_rank_first));
            helper.setTextColor(R.id.mTvRank, Color.parseColor("#FF3F4ABC"));
            helper.setBackgroundRes(R.id.mTvRank, R.drawable.shape_hash_rank);

        } else if (helper.getLayoutPosition() == 1) {
            helper.setBackgroundRes(R.id.mTvRank, R.drawable.shape_hash_rank);

            helper.getView(R.id.mRl).setBackground(activity.getResources().getDrawable(R.drawable.bg_rank_second));
            helper.setTextColor(R.id.mTvCount, activity.getResources().getColor(R.color.white));
            helper.setTextColor(R.id.mTvShanDian, activity.getResources().getColor(R.color.white_60));
            helper.setTextColor(R.id.mTvName,Color.parseColor("#B5B9E6FF"));
            helper.setTextColor(R.id.mTvRank, Color.parseColor("#FFA1885A"));
        } else if (helper.getLayoutPosition() == 2) {
            helper.setTextColor(R.id.mTvName, Color.parseColor("#FFFFFFFF"));

            helper.setBackgroundRes(R.id.mTvRank, R.drawable.shape_hash_rank);
            helper.getView(R.id.mRl).setBackground(activity.getResources().getDrawable(R.drawable.bg_rank_third));
            helper.setTextColor(R.id.mTvCount, activity.getResources().getColor(R.color.white));
            helper.setTextColor(R.id.mTvShanDian, activity.getResources().getColor(R.color.white_60));
            helper.setTextColor(R.id.mTvRank, Color.parseColor("#FF5C648E"));
            helper.setImageResource(R.id.mIvShanDian, R.drawable.ic_shandian);
        } else {
            helper.setTextColor(R.id.mTvName, Color.parseColor("#9EA9C3FF"));

            helper.setImageResource(R.id.mIvShanDian, R.drawable.ic_shandian_behind);
            helper.setBackgroundRes(R.id.mTvRank, R.drawable.shape_hash_rank_behind);
            helper.getView(R.id.mRl).setBackgroundColor(activity.getResources().getColor(R.color.white_60));
            helper.setTextColor(R.id.mTvCount, activity.getResources().getColor(R.color.general_black));
            helper.setTextColor(R.id.mTvShanDian, Color.parseColor("#FF9EA9C3"));
            helper.setTextColor(R.id.mTvRank, Color.parseColor("#99FFFFFF"));
        }

        helper.setText(R.id.mTvRank, formate(helper.getLayoutPosition() + 1));
    }

    private String formate(int num) {
        if (num < 10) {
            return "0" + String.valueOf(num);
        } else
            return num + "";
    }
}
