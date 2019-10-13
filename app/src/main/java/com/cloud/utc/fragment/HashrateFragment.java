package com.cloud.utc.fragment;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.LogUtils;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HashrateFragment extends HomeBaseFragment {
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    private Unbinder bind;

    @Override
    protected void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hashrate, container, false);
        bind = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        LogUtils.e("执行initView");
        setAnimation(progressBar,100);
    }

    private void setAnimation(final ProgressBar view, final int mProgressBar) {
        ValueAnimator animator = ValueAnimator.ofInt(0, mProgressBar).setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                LogUtils.e((int)valueAnimator.getAnimatedValue());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.setProgress((Integer) valueAnimator.getAnimatedValue(),true);
                }else {
                    view.setProgress((Integer) valueAnimator.getAnimatedValue());
                }
            }
        });
        animator.start();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
