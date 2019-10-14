package com.cloud.utc.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.bean.BaseModel;
import com.cloud.utc.bean.ErrorModel;
import com.cloud.utc.bean.SignUpReq;
import com.cloud.utc.bean.SignUpResp;
import com.cloud.utc.http.ApiRequest;
import com.cloud.utc.http.ApiService;
import com.cloud.utc.http.RequestCallback;
import com.cloud.utc.popup.SignUpSuccessDialog;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Response;

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

                break;
        }
    }

    private void doSignUp() {
        String email = mEtEmail.getText().toString();
        String pwd = mEtPwd.getText().toString();
        String pwd2 = mEtPwd2.getText().toString();
        String invitation = mEtInvitation.getText().toString();
        SignUpReq signUpReq = new SignUpReq(email, pwd, pwd2, invitation);
        QMUITipDialog signUpTip = showLoading(QMUITipDialog.Builder.ICON_TYPE_LOADING, "Signing up");
        signUpTip.show();
        ApiRequest.getInstance().create(ApiService.class).doSignUp(signUpReq).enqueue(new RequestCallback<SignUpResp>() {


            @Override
            public void onFinish() {
                signUpTip.dismiss();
            }

            @Override
            public void onFailure(int code, ErrorModel msg) {
//                LogUtils.e(code+":"+msg);
                QMUITipDialog failTip = new QMUITipDialog.Builder(SignUpActivity.this)
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_FAIL)
                        .setTipWord(code + ":" + msg)
                        .create();
                failTip.show();

            }

            @Override
            public void onSuccess(Response<SignUpResp> response) {
                dealSuccess(response);
            }

            @Override
            protected void onFailure(int code) {
                ToastUtils.showShort("cannot connect server");
            }
        });
    }


    private void dealSuccess(Response<SignUpResp> response) {
        dialog = new SignUpSuccessDialog();
        dialog.show(getSupportFragmentManager(), "dialog");
    }
}
