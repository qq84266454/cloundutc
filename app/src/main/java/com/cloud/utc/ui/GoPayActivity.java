package com.cloud.utc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.basepopup.QuickPopupBuilder;
import razerdp.basepopup.QuickPopupConfig;

public class GoPayActivity extends AppCompatActivity {

    @BindView(R.id.m_bar_view)
    View mBarView;
    @BindView(R.id.m_general_top)
    LinearLayout mGeneralTop;
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
    @BindView(R.id.mBtnPay)
    Button mBtnPay;
    @BindView(R.id.mTvOne)
    TextView mTvOne;
    @BindView(R.id.mIvGray)
    ImageView mIvGray;
    @BindView(R.id.mTvTwo)
    TextView mTvTwo;
    @BindView(R.id.mIv2)
    ImageView mIv2;
    @BindView(R.id.mIvDiamond)
    ImageView mIvDiamond;
    @BindView(R.id.mIvArrow)
    ImageView mIvArrow;
    @BindView(R.id.mIvCopy3)
    ImageView mIvCopy3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_pay);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.m_iv_back, R.id.mBtnPay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                break;
            case R.id.mBtnPay:
                QuickPopupBuilder.with(this)
                        .contentView(R.layout.popup_pay_confirm)
                        .config(new QuickPopupConfig()
                                .gravity(Gravity.CENTER)
                                .withClick(R.id.tv_confirm, view1 -> {
                                    startActivity(new Intent(this, PayTimeActivity.class));
                                })
                        )
                        .show();
                break;
        }
    }
}
