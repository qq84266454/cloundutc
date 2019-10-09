package com.cloud.utc.test;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.cloud.utc.R;
import com.cloud.utc.base.BaseFragment;
import com.cloud.utc.fragment.BalanceFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import razerdp.basepopup.BasePopupWindow;

public class ViewPagerFragmentPopup extends BasePopupWindow {
    @BindView(R.id.pager)
    ViewPager mVp;
    FragmentActivity acticity;

    public ViewPagerFragmentPopup(Context context) {
        super(context);
        this.acticity = (AppCompatActivity) context;
        setOutSideDismiss(false);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
//        setShowAnimation(createTranslateAnimation(0f, 0f, 1f, 0f));
//        setDismissAnimation(createTranslateAnimation(0f, 0f, 0f, 1f));
        ButterKnife.bind(this, getContentView());
        initView();
    }

    private void initView() {
        ArrayList<BaseFragment> list = new ArrayList<>();
        list.add(new BalanceFragment());
        list.add(new BalanceFragment());
        mVp.setAdapter(new FragmentAdapter(acticity.getSupportFragmentManager(),list));
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop_view_pager_fragment);
    }
}
