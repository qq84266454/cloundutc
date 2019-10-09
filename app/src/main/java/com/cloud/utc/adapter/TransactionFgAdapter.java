package com.cloud.utc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author xp.h
 * @date 16/11/09  16:17
 * @描述:发现中pager的适配器
 */
public class TransactionFgAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private String[] mTitles;

    public TransactionFgAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles) {
        super(fm);
        this.mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = mFragments.get(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return mFragments != null ? mFragments.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles == null) {
            return super.getPageTitle(position);
        }
        return mTitles[position];
    }

}
