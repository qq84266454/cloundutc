package com.cloud.utc.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cloud.utc.R;
import com.cloud.utc.base.BaseFragment;
import com.cloud.utc.fragment.HomeBaseFragment;
import com.cloud.utc.popup.QRDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MeFragment extends HomeBaseFragment {
    @BindView(R.id.mViewIdentity)
    LinearLayout mViewIdentity;
    @BindView(R.id.mViewHashTop)
    LinearLayout mViewHashTop;
    @BindView(R.id.mViewPay)
    LinearLayout mViewPay;
    @BindView(R.id.mViewAds)
    LinearLayout mViewAds;
    @BindView(R.id.mIvQRCode)
    ImageView mIvQRCode;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mViewIdentity, R.id.mViewHashTop, R.id.mViewPay, R.id.mViewAds,R.id.mIvQRCode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mViewIdentity:
                startActivity(new Intent(getActivity(),IdentityCompleteActivity.class));
                break;
            case R.id.mViewHashTop:
                startActivity(new Intent(getActivity(),HashRateTeamActivity.class));
                break;
            case R.id.mViewPay:
                startActivity(new Intent(getActivity(),PayMethodActivity.class));
                break;
            case R.id.mViewAds:
                break;
            case R.id.mIvQRCode:
                new QRDialog(getActivity()).setPopupGravity(Gravity.CENTER).showPopupWindow();
                break;
        }
    }

    @Override
    protected void initData() {

    }
}
