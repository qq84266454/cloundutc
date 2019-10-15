package com.cloud.utc.ui.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AlipaySettingActivity extends BaseActivity implements EditText.OnFocusChangeListener {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_save)
    TextView tvSave;
    @BindView(R.id.m_bar_view)
    View mBarView;
    @BindView(R.id.m_general_top)
    LinearLayout mGeneralTop;
    @BindView(R.id.m_iv_back)
    ImageView mIvBack;
    @BindView(R.id.m_iv_save)
    ImageView mIvSave;
    @BindView(R.id.rl_title_bar)
    RelativeLayout rlTitleBar;
    @BindView(R.id.mTvName)
    TextView mTvName;
    @BindView(R.id.mEtName)
    EditText mEtName;
    @BindView(R.id.mTvAccount)
    TextView mTvAccount;
    @BindView(R.id.mEtAccount)
    EditText mEtAccount;
    @BindView(R.id.mTvFundPwd)
    TextView mTvFundPwd;
    @BindView(R.id.mEtFundPwd)
    EditText mEtFundPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alipay_setting);
        ButterKnife.bind(this);
        initView();
        setBg(R.color.general_bg);
    }

    protected void initView() {
        initStatus();
        mTvTitle.setText("Add Alipay");
        tvSave.setText("DONE");
        tvSave.setVisibility(View.VISIBLE);
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        tvSave.setTextColor(getResources().getColor(R.color.default_color));
        initEdit();
    }

    private void initEdit() {
        mEtAccount.setOnFocusChangeListener(this);
        mEtFundPwd.setOnFocusChangeListener(this);
        mEtName.setOnFocusChangeListener(this);
    }

    @OnClick({R.id.m_iv_back, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                break;
            case R.id.tv_save:
                break;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        switch (view.getId()) {
            case R.id.mEtName:
                changeColor(mTvName, b);
                break;
            case R.id.mEtAccount:
                changeColor(mTvAccount, b);
                break;
            case R.id.mEtFundPwd:
                changeColor(mTvFundPwd, b);
                break;


        }
    }


    private void changeColor(TextView tv, boolean isFocus) {
        if (isFocus) {
            tv.setTextColor(getResources().getColor(R.color.edit_text_label_color));
        } else {
            tv.setTextColor(getResources().getColor(R.color.general_black));

        }
    }
}
