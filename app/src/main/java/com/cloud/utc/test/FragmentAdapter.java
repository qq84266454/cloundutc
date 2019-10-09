package com.cloud.utc.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cloud.utc.base.BaseFragment;

import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    private List<BaseFragment> list;
    public FragmentAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
    @Override
    public int getCount() {
        return list.size();
    }
}
