package com.cloud.utc.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.cloud.utc.R;
import com.cloud.utc.adapter.TransBuySubFragmentAdapter;
import com.cloud.utc.base.BaseFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TransBuyFragment extends BaseFragment {
    @BindView(R.id.stl_lingyu)
    SlidingTabLayout stlLingyu;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    Unbinder unbinder;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private TransBuySubFragmentAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trans_buy, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        String[] mTitles = new String[]{"BTC", "ETH", "USDT", "XPR", "LTC"};
        for (int i = 0; i < mTitles.length; i++) {
            TransBuySubFragment fragment = new TransBuySubFragment();
            mFragments.add(fragment);
        }

        adapter = new TransBuySubFragmentAdapter(getChildFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(1);
        stlLingyu.setViewPager(mViewPager, mTitles);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
