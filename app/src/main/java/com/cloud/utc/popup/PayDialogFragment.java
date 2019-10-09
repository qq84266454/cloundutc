package com.cloud.utc.popup;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloud.utc.R;

public class PayDialogFragment extends BaseDialogFragment {
    @Override
    protected View setView(@NonNull LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dialog_pay, container, false);
    }
}
