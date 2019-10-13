package com.cloud.utc.ui;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderComActivity extends BaseActivity {

    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.mIvCopy2)
    ImageView mIvCopy2;
    @BindView(R.id.mIvCopy3)
    ImageView mIvCopy3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_com);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mTvTitle.setText(getString(R.string.sellerrealse));
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
    }

    @OnClick({R.id.m_iv_back, R.id.mBtnGet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mBtnGet:
                break;
        }
    }
}
