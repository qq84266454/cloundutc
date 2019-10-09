package com.cloud.utc.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cloud.utc.R;
import com.cloud.utc.adapter.BuyTransactionAdapter;
import com.cloud.utc.base.BaseFragment;
import com.cloud.utc.bean.HashDetail;
import com.cloud.utc.popup.PayConfirmDialogFragment;
import com.cloud.utc.popup.PayDialogFragment;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class TransBuySubFragment extends BaseFragment {
    @BindView(R.id.mEtPurchase)
    EditText mEtPurchase;
    @BindView(R.id.mBtnBuy)
    Button mBtnBuy;
    @BindView(R.id.mRv)
    RecyclerView mRv;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_buy_sub, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(layoutManager);
        BuyTransactionAdapter mAdapter = new BuyTransactionAdapter(getActivity());
        ArrayList<HashDetail> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new HashDetail());
        }
        mAdapter.setNewData(list);

        mRv.setAdapter(mAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mBtnBuy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtnBuy:
                showPayDialog();
                break;
        }
    }

    private void showPayDialog() {
//        PayDialogFragment payDialog = new PayDialogFragment();
//        payDialog.setDpValue(300);
//        payDialog.setDpValue(463);
//        payDialog.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "dialog");

        PayConfirmDialogFragment payConfirmDialog = new PayConfirmDialogFragment();
        payConfirmDialog.show(getActivity().getSupportFragmentManager(), "dialog");

    }
}
