package com.cloud.utc.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.popup.SignUpSuccessDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseActivity {

    @BindView(R.id.mEtEmail)
    EditText mEtEmail;
    @BindView(R.id.mEtPwd)
    EditText mEtPwd;
    @BindView(R.id.mEtPwd2)
    EditText mEtPwd2;
    @BindView(R.id.mEtInvitation)
    EditText mEtInvitation;
    private SignUpSuccessDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mIvLabel1, R.id.mTvSignIn, R.id.mBtnSignUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mIvLabel1:
                break;
            case R.id.mTvSignIn:
                break;
            case R.id.mBtnSignUp:
//                if (dialog == null)
                doSignUp();
                dialog = new SignUpSuccessDialog();
                dialog.show(getSupportFragmentManager(), "dialog");
                break;
        }
    }

    private void doSignUp() {
    }
}
