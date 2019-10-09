package com.cloud.utc.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloud.utc.R;

import butterknife.ButterKnife;

public class HashrateFragment extends HomeBaseFragment {
    @Override
    protected void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hashrate, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
}
