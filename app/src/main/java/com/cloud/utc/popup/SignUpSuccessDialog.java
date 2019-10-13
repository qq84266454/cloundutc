package com.cloud.utc.popup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloud.utc.HomeActivity;
import com.cloud.utc.R;
import com.cloud.utc.ui.login.LoginActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class SignUpSuccessDialog extends BaseDialogFragment {
    Unbinder unbinder;

    @Override
    protected View setView(@NonNull LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dialog_sucess_sign, container, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mTvClose, R.id.mBtnCB})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvClose:
                dismiss();
                break;
            case R.id.mBtnCB:
                startActivity(new Intent(getContext(),LoginActivity.class));
                break;
        }
    }
}
