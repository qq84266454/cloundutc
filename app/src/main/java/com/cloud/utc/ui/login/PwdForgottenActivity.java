package com.cloud.utc.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.cloud.utc.utils.UIUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

public class PwdForgottenActivity extends BaseActivity {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.mEtEmail)
    EditText mEtEmail;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_forgotten);
        ButterKnife.bind(this);
        initStatus();
        mTvTitle.setVisibility(View.GONE);
    }


    @OnClick({R.id.m_iv_back, R.id.mBtnNext})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mBtnNext:
                doPasswordCode();

                break;
        }
    }

    private void doPasswordCode() {
        String account = mEtEmail.getText().toString();
        LoginReq loginReq = new LoginReq(account);
        loginReq.setAccount(account);
        ApiRequest.getInstance().create(ApiService.class).doPasswordCode(loginReq).enqueue(new RequestCallback<NoBodyModel>() {
            @Override
            public void onFinish() {

            }

            @Override
            protected void onFailure(int code) {
                super.onFailure(code);
                ToastUtils.showShort(code + "");
            }

            @Override
            public void onSuccess(Response<NoBodyModel> response) {
                ToastUtils.showShort("success");
                Intent intent = new Intent(instance, PwdForgottenCodeActivity.class);
                intent.putExtra(Constants.ACCOUNT, account);
                UIUtils.startActivity(instance, intent);
                finish();
            }
        });
    }
}
