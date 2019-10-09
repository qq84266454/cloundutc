package com.cloud.utc.fragment;

import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.cloud.utc.R;
import com.cloud.utc.event.BusProvider;
import com.cloud.utc.event.EventBusInfo;
import com.cloud.utc.event.EventType;
import com.cloud.utc.fragment.HomeBaseFragment;
import com.cloud.utc.utils.ClipboardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class GetFragment extends HomeBaseFragment {
    @BindView(R.id.mTvClose)
    TextView mTvClose;
    @BindView(R.id.mIvInToken)
    ImageView mIvInToken;
    @BindView(R.id.mIvArrow)
    ImageView mIvArrow;
    @BindView(R.id.mIvC)
    ImageView mIvC;
    @BindView(R.id.mTvToken)
    TextView mTvToken;
    @BindView(R.id.mViewCopy)
    CardView mViewCopy;
    Unbinder unbinder;

    @Override
    protected void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_get, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mTvClose, R.id.mViewCopy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvClose:
                BusProvider.getInstance().post(new EventBusInfo<>(EventType.EVENT_CLOSE_BUY_AND_GET));
                break;
            case R.id.mViewCopy:
                copyAddress();
                break;
        }
    }

    private void copyAddress() {
        ClipboardUtils.copyText(mTvToken.getText());
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.showShort("copy Success");
    }
}
