package com.cloud.utc.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PwdForgottenActivity extends BaseActivity {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwd_forgotten);
        ButterKnife.bind(this);
        initStatus();
        mTvTitle.setVisibility(View.GONE);
    }


    @OnClick({R.id.m_iv_back, R.id.mBtnNext, R.id.mIvFloat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mBtnNext:
                startActivity(new Intent(this,PwdForgottenCodeActivity.class));
                finish();
                break;
            case R.id.mIvFloat:
                break;
        }
    }
}
