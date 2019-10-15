package com.cloud.utc.ui.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.adapter.TransBuySubFragmentAdapter;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HashRateTeamActivity extends BaseActivity {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.stlHashRate)
    SlidingTabLayout stlHashRate;
    @BindView(R.id.mViewPager)
    ViewPager mViewPager;
    private List<Fragment> mFragments = new ArrayList<>();
    private TransBuySubFragmentAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hash_rate_team);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        initStatus();
        mTvTitle.setText("Hashrate");
        String[] mTitles = new String[]{"Hashrate TOP team", "My team"};
        for (int i = 0; i < mTitles.length; i++) {
            LogUtils.e(i);
            HashRateTeamFragment fragment = new HashRateTeamFragment();
            mFragments.add(fragment);
        }

        adapter = new TransBuySubFragmentAdapter(getSupportFragmentManager(), mFragments, mTitles);
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(2);
        stlHashRate.setViewPager(mViewPager, mTitles);
    }

    @OnClick({R.id.m_iv_back, R.id.m_iv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.m_iv_save:
                break;
        }
    }
}
