package com.cloud.utc.factory;


import com.cloud.utc.fragment.BalanceFragment;
import com.cloud.utc.fragment.HomeBaseFragment;
import com.cloud.utc.fragment.TransactionFragment;
import com.cloud.utc.ui.me.MeFragment;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xp.h
 * @date 16/7/4
 * @description 主页fragment的工厂类
 */
public class HomeFactory {

    private static Map<Integer, HomeBaseFragment> mCaches = new LinkedHashMap<>();

    public static HomeBaseFragment getFragment(int position) {

        HomeBaseFragment fragment = mCaches.get(position);

        // 判断缓存中是否有
        if (fragment != null) {
            return fragment;
        }

        switch (position) {
            case 0:
                // Balance fragment
                fragment = new BalanceFragment();
                break;
            case 1:
                fragment = new TransactionFragment();

                // 发现的 fragment
//                fragment = new NewHomeFindFragment();
                break;
            case 2:
                fragment = new TransactionFragment();

                // 提问的 fragment
//                fragment = new NewHomeAskFragment();
                break;
            case 3:
                // 消息的 fragment
                fragment = new TransactionFragment();
//                fragment = new NewHomeLookFragment();
                break;
            case 4:
                fragment = new MeFragment();
                break;
        }

        // 存储到缓存
        mCaches.put(position, fragment);
        return fragment;
    }

    public static void clearAllCache() {
        mCaches.clear();
    }

}
