package com.cloud.utc.popup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cloud.utc.R;
import com.cloud.utc.ui.GoPayActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PayConfirmDialogFragment extends BaseDialogFragment {
    @BindView(R.id.mTvClose)
    TextView mTvClose;
    @BindView(R.id.mBtnConfirm)
    Button mBtnConfirm;
    Unbinder unbinder;

    @Override
    protected View setView(@NonNull LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dialog_pay_confirm, container, false);
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

    @OnClick({R.id.mTvClose, R.id.mBtnConfirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvClose:
                dismiss();
                break;
            case R.id.mBtnConfirm:
                goPay();
                break;
        }
    }

    private void goPay() {
        getActivity().startActivity(new Intent(getActivity(), GoPayActivity.class));
    }
}
