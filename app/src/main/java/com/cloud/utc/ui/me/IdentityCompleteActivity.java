package com.cloud.utc.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.bean.IdentificationResp;
import com.cloud.utc.bean.LoginResp;
import com.cloud.utc.http.ApiRequest;
import com.cloud.utc.http.ApiService;
import com.cloud.utc.http.RequestCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

public class IdentityCompleteActivity extends BaseActivity {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_complete);
        ButterKnife.bind(this);
        initStatus();
        mTvTitle.setText("Identification");
        initData();
        setBg(R.color.general_bg);
    }

    private void initData() {
        ApiRequest.getInstance().create(ApiService.class).doIdentification().enqueue(new RequestCallback<IdentificationResp>() {
            @Override
            public void onFinish() {
                LogUtils.e("结束");
            }

            @Override
            public void onSuccess(Response<IdentificationResp> response) {
                LogUtils.e("成功:" + response.body());
                if (response.body() != null) {
                    String idcard = response.body().getIdcard();
                    LogUtils.e(idcard);
                }
            }
        });
    }

    @OnClick({R.id.m_iv_back, R.id.mBtnComplete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mBtnComplete:
                startActivity(new Intent(this, IdentityInputActivity.class));
                break;
        }
    }
}
