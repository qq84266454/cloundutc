package com.cloud.utc.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IdentityInputActivity extends BaseActivity {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_input);
        ButterKnife.bind(this);
        initStatus();
        mTvTitle.setText("Identification");
    }

    @OnClick({R.id.m_iv_back, R.id.mIvPhoto, R.id.mIvBankCard, R.id.mBtnSubmit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mIvPhoto:
                break;
            case R.id.mIvBankCard:
                break;
            case R.id.mBtnSubmit:
                startActivity(new Intent(this,IdentityResultActivity.class));
                break;
        }
    }
}
