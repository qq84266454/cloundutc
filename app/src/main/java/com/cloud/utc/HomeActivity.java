package com.cloud.utc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.cloud.utc.factory.HomeFactory;
import com.cloud.utc.fragment.TabEntity;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends BaseActivity {

    @BindView(R.id.m_fl_content_container)
    FrameLayout mFlContentContainer;
    @BindView(R.id.m_bottom_navigation_bar)
    CommonTabLayout mBottomNavigationBar;
    @BindView(R.id.fl_bottom)
    FrameLayout flBottom;
    @BindView(R.id.m_ll_root_view)
    RelativeLayout mLlRootView;
    private ArrayList<Fragment> mFragments;
    private String[] mTitles;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private int[] mIconUnselectedIds = {
            R.drawable.icon_qianbao, R.drawable.icon_zhuxing,
            R.drawable.icon_zhexian, R.drawable.icon_order,R.drawable.icon_me};
    private int[] mIconSelectIds = {
            R.drawable.icon_qianbao, R.drawable.icon_zhuxing,
            R.drawable.icon_get_select, R.drawable.icon_order,R.drawable.icon_me};
    private int mCurrentFragmentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        initFragment();
        mTitles = new String[]{"Balances", "Transaction", "Order", "Settings","Me"};
        initTabItem();
    }
    private void initTabItem() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectedIds[i]));
        }
        mBottomNavigationBar.setTabData(mTabEntities, this, R.id.m_fl_content_container, mFragments);

        mBottomNavigationBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mCurrentFragmentIndex = position;
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        mBottomNavigationBar.setCurrentTab(0);
    }
    private void initFragment() {
        // 添加几个fragment到集合中
        mFragments = new ArrayList<>();
        mFragments.add(HomeFactory.getFragment(0));
        mFragments.add(HomeFactory.getFragment(1));
        mFragments.add(HomeFactory.getFragment(2));
        mFragments.add(HomeFactory.getFragment(3));
        mFragments.add(HomeFactory.getFragment(4));
    }

    /**
     * 获取当前fragment的角标
     *
     * @return 当前角标
     */
    public int getCurrentFragmentIndex() {
        return mCurrentFragmentIndex;
    }
}
