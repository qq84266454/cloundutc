package com.cloud.utc.ui.login;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.TextView;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.HomeActivity;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.mTvSignUp)
    TextView mTvSignUp;
    @BindView(R.id.mTvForgetPwd)
    TextView mTvForgetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mTvForgetPwd.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        mTvForgetPwd.getPaint().setAntiAlias(true);//抗锯齿
    }

    @OnClick({R.id.mTvSignUp, R.id.mTvForgetPwd,R.id.mTvSignIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvSignUp:
                startActivity(new Intent(this,SignUpActivity.class));
                break;
            case R.id.mTvForgetPwd:
                startActivity(new Intent(this,PwdForgottenActivity.class));
                break;
            case R.id.mTvSignIn:
                startActivity(new Intent(this,HomeActivity.class));

                break;
        }
    }
}
