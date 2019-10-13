package com.cloud.utc.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PwdForgottenCodeActivity extends BaseActivity {

    @BindView(R.id.m_tv_title)
    TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_forgotten_code);
        ButterKnife.bind(this);
        initStatus();
        mTvTitle.setVisibility(View.GONE);
    }

    @OnClick({R.id.m_iv_back, R.id.mBtnSend, R.id.mIvFloat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mBtnSend:
                startActivity(new Intent(this,PwdForgottenPwdActivity.class));
                finish();
                break;
            case R.id.mIvFloat:
                break;
        }
    }
}
