package com.cloud.utc.ui.login;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.HomeActivity;
import com.cloud.utc.R;
import com.cloud.utc.base.Constants;
import com.cloud.utc.bean.ErrorModel;
import com.cloud.utc.bean.LoginReq;
import com.cloud.utc.bean.LoginResp;
import com.cloud.utc.http.ApiRequest;
import com.cloud.utc.http.ApiService;
import com.cloud.utc.http.RequestCallback;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.mTvSignUp)
    TextView mTvSignUp;
    @BindView(R.id.mTvForgetPwd)
    TextView mTvForgetPwd;
    @BindView(R.id.mIvLabel1)
    ImageView mIvLabel1;
    @BindView(R.id.mEtEmail)
    EditText mEtEmail;
    @BindView(R.id.mIvLabel2)
    ImageView mIvLabel2;
    @BindView(R.id.mEtPwd)
    EditText mEtPwd;
    @BindView(R.id.mTvSignIn)
    Button mTvSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (!SPUtils.getInstance().getString(Constants.ACCESS_TOKEN).isEmpty()) {
//            goMain();
//            finish();
//            return;
//        }
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mTvForgetPwd.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG); //下划线
        mTvForgetPwd.getPaint().setAntiAlias(true);//抗锯齿

    }

    private void goMain() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    @OnClick({R.id.mTvSignUp, R.id.mTvForgetPwd, R.id.mTvSignIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvSignUp:
                startActivity(new Intent(this, SignUpActivity.class));
                break;
            case R.id.mTvForgetPwd:
                startActivity(new Intent(this, PwdForgottenActivity.class));
                break;
            case R.id.mTvSignIn:
                doLogin();
//                goMain();
                break;
        }
    }

    private void doLogin() {
        String email = mEtEmail.getText().toString();
        String pwd = mEtPwd.getText().toString();
        if (email.isEmpty()) {
            ToastUtils.showShort("sorry,email is required");
            return;
        }

        if (pwd.isEmpty()) {
            ToastUtils.showShort("sorry,password is required");
            return;
        }
        LoginReq loginReq = new LoginReq(email, pwd);
        QMUITipDialog signing_in = newTipDialog(QMUITipDialog.Builder.ICON_TYPE_LOADING, "Signing in");
        ApiRequest.getInstance().create(ApiService.class).doSignIn(loginReq).enqueue(new RequestCallback<LoginResp>() {
            @Override
            public void onFinish() {
                signing_in.dismiss();
            }

            @Override
            public void onFailure(int code, ErrorModel errorModel) {

            }

            @Override
            public void onSuccess(Response<LoginResp> response) {
                dealSuccess(response);
            }

        });
    }

    private void dealSuccess(Response<LoginResp> response) {
        String access_token = response.body().getAccess_token();
        ToastUtils.showShort("success");
        SPUtils.getInstance().put(Constants.ACCESS_TOKEN, access_token);
        goMain();
    }
}
