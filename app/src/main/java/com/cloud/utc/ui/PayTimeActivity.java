package com.cloud.utc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PayTimeActivity extends BaseActivity {

    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.mTvMin)
    TextView mTvMin;
    @BindView(R.id.mTvSeond)
    TextView mTvSeond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_time);
        ButterKnife.bind(this);
        initView();
        initCount();
    }

    private void initView() {
        mTvTitle.setText(getString(R.string.sellerrealse));
        mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f);
    }

    private void initCount() {

        long millisInFuture = 5 * 60 * 1000;
        mTvMin.setText(formatTime(millisInFuture, 1));
        mTvSeond.setText(formatTime(millisInFuture, 0));
        CountDownTimer timer = new CountDownTimer(millisInFuture, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTvMin.setText(formatTime(millisUntilFinished, 1));
                mTvSeond.setText(formatTime(millisUntilFinished, 0));
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }

    @OnClick({R.id.m_iv_back, R.id.mIvCopy2, R.id.mIvCopy3, R.id.mIvCopy4, R.id.mIvCopy5,R.id.mTvAppeal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                break;
            case R.id.mIvCopy2:
                break;
            case R.id.mIvCopy3:
                break;
            case R.id.mIvCopy4:
                break;
            case R.id.mIvCopy5:
                break;
            case R.id.mTvAppeal:
                startActivity(new Intent(this,OrderComActivity.class));
                finish();
                break;
        }
    }


    private String formatTime(long time, int unit) {
        long longResult;
        String result = null;
        switch (unit) {
            case 1:
                // 秒
                longResult = time / 1000 / 60;
                result = String.valueOf(longResult);
                if (longResult < 10) {
                    result = "0" + result;
                }

                break;
            case 0:
                // 分
                longResult = time / 1000 % 60;
                result = String.valueOf(longResult);
                if (longResult < 10) {
                    result = "0" + result;
                }
                break;
        }
        return result;
    }
}
