package com.cloud.utc.ui.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.popup.PaySelectDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayMethodActivity extends BaseActivity {
    @BindView(R.id.m_iv_back)
    ImageView mIvBack;
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.m_iv_save)
    ImageView mIvSave;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.rl_title_bar)
    RelativeLayout rlTitleBar;
    @BindView(R.id.mIvBank)
    ImageView mIvBank;
    @BindView(R.id.mIvPay)
    ImageView mIvPay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_method);
        ButterKnife.bind(this);
        initStatus();
        initView();
        setBg(R.color.general_bg);
    }

    protected void initView() {
        mTvTitle.setText("Payment Method");
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        mIvSave.setVisibility(View.VISIBLE);
        mIvSave.setImageResource(R.drawable.ic_title_add);
    }

    @OnClick({R.id.m_iv_back, R.id.m_iv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.m_iv_save:
                showPaySelectPopup();
                break;
        }
    }

    private void showPaySelectPopup() {
        PaySelectDialog dialog = new PaySelectDialog();
        dialog.setDpValue(637);
        dialog.show(getSupportFragmentManager(), "dialog");
    }
}
