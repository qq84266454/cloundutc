package com.cloud.utc.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloud.utc.R;
import com.cloud.utc.adapter.TransactionFgAdapter;
import com.cloud.utc.base.BaseFragment;
import com.cloud.utc.utils.UIUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TransactionFragment extends HomeBaseFragment implements ViewPager.OnPageChangeListener {
    Unbinder unbinder;
    @BindView(R.id.m_fragment_viewpager)
    ViewPager mFragmentViewpager;
    @BindView(R.id.mTvBuy)
    TextView mTvBuy;
    @BindView(R.id.mTvSell)
    TextView mTvSell;

    private TransactionFgAdapter adapter;
    private ArrayList<Fragment> mFragments;
    private String[] mTitles;

    @Override
    protected void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_transaction, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        initView();
        return inflate;
    }

    private void initView() {
        initTab();
        mFragmentViewpager.addOnPageChangeListener(this);
    }

    private void initTab() {
        mFragments = new ArrayList<>();
        mFragments.add(new TransBuyFragment());
        mFragments.add(new TransBuyFragment());
        mTitles = new String[]{"Buy", "SELL"};
//
        adapter = new TransactionFgAdapter(getChildFragmentManager(), mFragments, mTitles);
        mFragmentViewpager.setAdapter(adapter);
        mFragmentViewpager.setOffscreenPageLimit(mFragments.size());
////        mTab.setViewPager(mFragmentViewpager, mTitles);
//        mTab.setTabData(mTitles);
//        mTab.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                mFragmentViewpager.setCurrentItem(position);
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//
//            }
//        });
//
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mTvBuy, R.id.mTvSell})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvBuy:
                switchViewPager(0);
                break;
            case R.id.mTvSell:
                switchViewPager(1);
                break;
        }
    }

    private void switchViewPager(int position) {
        mFragmentViewpager.setCurrentItem(position);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        changeText(position);
    }

    private void changeText(int position) {
        stateButton(position);
    }

    private void stateButton(int position) {
        if (position == 0) {
            mTvBuy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            mTvBuy.setTextColor(getResources().getColor(R.color.white));
            mTvSell.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
            mTvSell.setTextColor(getResources().getColor(R.color.unselect_color));
            UIUtils.setBoldOrNot(mTvBuy,true);
            UIUtils.setBoldOrNot(mTvSell,false);
        } else {
            mTvSell.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
            mTvSell.setTextColor(getResources().getColor(R.color.white));
            mTvBuy.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
            mTvBuy.setTextColor(getResources().getColor(R.color.unselect_color));
            UIUtils.setBoldOrNot(mTvSell,true);
            UIUtils.setBoldOrNot(mTvBuy,false);
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
