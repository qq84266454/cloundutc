package com.cloud.utc.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.base.Constants;
import com.cloud.utc.bean.LoginReq;
import com.cloud.utc.bean.NoBodyModel;
import com.cloud.utc.http.ApiRequest;
import com.cloud.utc.http.ApiService;
import com.cloud.utc.http.RequestCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

public class PwdForgottenCodeActivity extends BaseActivity {

    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.mEtCode)
    EditText mEtCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_forgotten_code);
        ButterKnife.bind(this);
        initStatus();
        mTvTitle.setVisibility(View.GONE);
    }

    @OnClick({R.id.m_iv_back, R.id.mBtnSend})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mBtnSend:
                doSendCode();

                break;
        }
    }

    private void doSendCode() {
        String code = mEtCode.getText().toString();
        if (code.isEmpty()) {
            ToastUtils.showShort("code is required");
            return;
        }
        LoginReq req = new LoginReq();
        req.setAccount(getIntent().getStringExtra(Constants.ACCOUNT));
        req.setCode(code);
        ApiRequest.getInstance().create(ApiService.class).doPasswordReset(req).enqueue(new RequestCallback<NoBodyModel>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void onSuccess(Response<NoBodyModel> response) {
                startActivity(new Intent(instance, PwdForgottenPwdActivity.class));
                finish();
            }
        });
    }
}
