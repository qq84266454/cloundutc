package com.cloud.utc.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
        initCount();
    }

    private void initCount() {

        long millisInFuture = 5 * 60 * 1000;
        long minute = millisInFuture / 1000 / 60;
        long second = millisInFuture / 1000 % 60;
        mTvMin.setText(String.format("%d", minute));
        mTvSeond.setText(String.format("%d", second));
        CountDownTimer timer = new CountDownTimer(millisInFuture, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTvMin.setText(millisUntilFinished / 1000 / 60 + "");
                mTvSeond.setText(millisUntilFinished / 1000 % 60 + "");
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }

    @OnClick({R.id.m_iv_back, R.id.mIvCopy2, R.id.mIvCopy3, R.id.mIvCopy4, R.id.mIvCopy5})
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
        }
    }
}
