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

public class BankSettingActivity extends BaseActivity implements EditText.OnFocusChangeListener {
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
    @BindView(R.id.mTvBankName)
    TextView mTvBankName;
    @BindView(R.id.mEtBankName)
    EditText mEtBankName;
    @BindView(R.id.mTvBankInfo)
    TextView mTvBankInfo;
    @BindView(R.id.mEtBankInfo)
    EditText mEtBankInfo;
    @BindView(R.id.mTvBankAccount)
    TextView mTvBankAccount;
    @BindView(R.id.mEtBankAccount)
    EditText mEtBankAccount;
    @BindView(R.id.mTvConfirmAccount)
    TextView mTvConfirmAccount;
    @BindView(R.id.mEtConfirmAccount)
    EditText mEtConfirmAccount;
    @BindView(R.id.mTvFundPwd)
    TextView mTvFundPwd;
    @BindView(R.id.mEtFundPwd)
    EditText mEtFundPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_setting);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {
        initStatus();
        mTvTitle.setText("Add Bank Transfer");
        tvSave.setText("DONE");
        tvSave.setVisibility(View.VISIBLE);
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
        tvSave.setTextColor(getResources().getColor(R.color.default_color));
        initEdit();

    }

    private void initEdit() {

        mEtBankAccount.setOnFocusChangeListener(this);
        mEtFundPwd.setOnFocusChangeListener(this);
        mEtName.setOnFocusChangeListener(this);
        mEtBankName.setOnFocusChangeListener(this);
        mEtBankInfo.setOnFocusChangeListener(this);
        mEtConfirmAccount.setOnFocusChangeListener(this);

    }

    @OnClick({R.id.m_iv_back, R.id.tv_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
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
            case R.id.mEtBankName:
                changeColor(mTvBankName, b);
                break;
            case R.id.mEtBankInfo:
                changeColor(mTvBankInfo, b);
                break;
            case R.id.mEtBankAccount:
                changeColor(mTvBankAccount, b);
                break;
            case R.id.mEtFundPwd:
                changeColor(mTvFundPwd, b);
                break;
            case R.id.mEtConfirmAccount:
                changeColor(mTvConfirmAccount, b);
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
