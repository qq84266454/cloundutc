package com.cloud.utc.popup;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.blankj.utilcode.util.ConvertUtils;
import com.cloud.utc.R;

import butterknife.ButterKnife;

public abstract class BaseDialogFragment extends DialogFragment {

    private int dpValue = 0;

    public BaseDialogFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setStyle(DialogFragment.STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
        //去出标题
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View inflate = setView(inflater, container);
        ButterKnife.bind(this, inflate);
        return inflate;
    }

    protected abstract View setView(@NonNull LayoutInflater inflater, ViewGroup container);

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
        if (dpValue != 0)
            params.height = ConvertUtils.dp2px(dpValue);
        else
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        params.dimAmount = 0.0f;
        win.setAttributes(params);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    public void setDpValue(int dpValue) {
        this.dpValue = dpValue;
    }
}