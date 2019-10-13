package com.cloud.utc.popup;

import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;

import com.blankj.utilcode.util.ConvertUtils;
import com.cloud.utc.R;
import com.cloud.utc.base.BaseFragment;
import com.cloud.utc.event.BusProvider;
import com.cloud.utc.event.EventBusInfo;
import com.cloud.utc.event.EventType;
import com.cloud.utc.fragment.BuyFragment;
import com.cloud.utc.test.FragmentAdapter;
import com.cloud.utc.fragment.GetFragment;
import com.cloud.utc.view.ViewPagerScroller;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDialogFragment extends DialogFragment {
    @BindView(R.id.pager)
    ViewPager pager;

    public MyDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
        //去出标题
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View inflate = inflater.inflate(R.layout.dialog_fragment, container, false);
        ButterKnife.bind(this, inflate);
        BusProvider.getInstance().register(this);
        return inflate;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window win = getDialog().getWindow();
        // 一定要设置Background，如果不设置，window属性设置无效
        if (win != null) {
            win.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.qmui_s_transparent)));
            win.setWindowAnimations(R.style.animation_bottom_in_bottom_out);
        }
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams params = win.getAttributes();
        params.gravity = Gravity.BOTTOM;
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ConvertUtils.dp2px(463);
        params.dimAmount = 0.0f;
        win.setAttributes(params);
        ArrayList<BaseFragment> list = new ArrayList<>();
        list.add(new BuyFragment());
        list.add(new GetFragment());
        pager.setAdapter(new FragmentAdapter(getChildFragmentManager(), list));
        pager.setOffscreenPageLimit(1);
        ViewPagerScroller pagerScroller = new ViewPagerScroller(getActivity(), new DecelerateInterpolator());
        pagerScroller.setScrollDuration(400);//设置时间，时间越长，速度越慢
        pagerScroller.initViewPagerScroll(pager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        BusProvider.unregister(this);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        BusProvider.getInstance().post(
                new EventBusInfo<>(EventType.EVENT_CLOSE_BUY_POPUP));
    }

    @Subscribe
    public void onEventMain(EventBusInfo info) {
        switch (info.getType()) {
            case EventType.EVENT_OPEN_GET:
                pager.setCurrentItem(1);
                break;
            case EventType.EVENT_CLOSE_BUY_AND_GET:
                dismiss();
                break;
        }
    }
}