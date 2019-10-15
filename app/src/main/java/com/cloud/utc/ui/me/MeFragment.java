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
import android.widget.TextView;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.cloud.utc.R;
import com.cloud.utc.bean.UserInfoResp;
import com.cloud.utc.fragment.HomeBaseFragment;
import com.cloud.utc.http.ApiRequest;
import com.cloud.utc.http.ApiService;
import com.cloud.utc.http.RequestCallback;
import com.cloud.utc.popup.QRDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Response;

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
    @BindView(R.id.mTvName)
    TextView mTvName;
    @BindView(R.id.mIvInvCode)
    TextView mIvInvCode;
    @BindView(R.id.mTvNodeValue)
    TextView mTvNodeValue;

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

    @OnClick({R.id.mViewIdentity, R.id.mViewHashTop, R.id.mViewPay, R.id.mViewAds, R.id.mIvQRCode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mViewIdentity:
                startActivity(new Intent(getActivity(), IdentityCompleteActivity.class));
                break;
            case R.id.mViewHashTop:
                startActivity(new Intent(getActivity(), HashRateTeamActivity.class));
                break;
            case R.id.mViewPay:
                startActivity(new Intent(getActivity(), PayMethodActivity.class));
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

        LogUtils.e("获取用户信息");

        ApiRequest.getInstance().create(ApiService.class).doGetUser().enqueue(new RequestCallback<UserInfoResp>() {
            @Override
            public void onFinish() {
                LogUtils.e("获取用户信息结束");
            }

            @Override
            public void onSuccess(Response<UserInfoResp> response) {
                LogUtils.e(response.body());
                if (response.body() != null) {
                    dealSuccess(response.body());
                }
            }
        });
//        ApiRequest.getInstance().create(ApiService.class).doGetUser().enqueue(new Callback<UserInfoResp>() {
//            @Override
//            public void onResponse(Call<UserInfoResp> call, Response<UserInfoResp> response) {
//                LogUtils.e(response);
//            }
//
//            @Override
//            public void onFailure(Call<UserInfoResp> call, Throwable t) {
//                LogUtils.e(t);
//            }
//        });
    }

    private void dealSuccess(UserInfoResp resp) {
        mTvName.setText(resp.getName());
        mIvInvCode.setText(resp.getIcode());
        mTvNodeValue.setText(resp.getNode_address());
        String pre = "data:image/png;base64";
//        mIvQRCode.setImageBitmap(ImageUtils.bytes2Bitmap(EncodeUtils.base64Decode(resp.getIcode_qrcode().substring(pre.length()))));
        if (resp.getIcode_qrcode() != null)
            SPUtils.getInstance().put("qr_code", resp.getIcode_qrcode().substring(pre.length()));

    }
}
