package com.cloud.utc.ui.me;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IdentityResultActivity extends BaseActivity {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.m_general_top)
    LinearLayout mGeneralTop;
    @BindView(R.id.rl_title_bar)
    RelativeLayout rlTitleBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_result);
        ButterKnife.bind(this);
        initView();
        initStatus();
        mTvTitle.setText("Identification");
        setBg(R.color.general_bg);
//        QMUILinearLayout layout = new QMUILinearLayout(this);
//        layout.setRadiusAndShadow();
    }

    private void initView() {
        rlTitleBar.setBackgroundColor(Color.parseColor("#FFF6F8F9"));
    }

    @OnClick({R.id.m_iv_back, R.id.mIvSuccess})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mIvSuccess:
                break;
        }
    }
}
