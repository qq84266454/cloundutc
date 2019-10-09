package com.cloud.utc.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cloud.utc.BaseActivity;


/**
 * Created by lzm on 16/4/6.
 */
public class BaseFragment extends Fragment {

    public static final String TITLE = "title";

    protected BaseActivity mBaseAct;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof BaseActivity) {
            mBaseAct = (BaseActivity) activity;
        }
    }

    /**
     * 显示loadingDialog 仍然使用Activity中的loadingDialog
     */
    public void showLoadingDialog() {
        if (mBaseAct != null) {
//            mBaseAct.showLoadDialog();
        }
    }

    public void dismissLoadingDialog() {
        if (mBaseAct != null) {
//            mBaseAct.dismissLoadDialog();
        }
    }

    public static BaseFragment newInstance(String title) {
        BaseFragment tabFragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onResume() {
        super.onResume();
//        L.e("onResume="+this.getClass().getSimpleName());
//        MobclickAgent.onPageStart(this.getClass().getSimpleName());
    }

    @Override
    public void onPause() {
        super.onPause();
//        L.e("onPause="+this.getClass().getSimpleName());
//        MobclickAgent.onPageEnd(this.getClass().getSimpleName());
    }
}
