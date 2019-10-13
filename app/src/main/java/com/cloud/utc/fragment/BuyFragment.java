package com.cloud.utc.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloud.utc.R;
import com.cloud.utc.event.BusProvider;
import com.cloud.utc.event.EventBusInfo;
import com.cloud.utc.event.EventType;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class BuyFragment extends HomeBaseFragment {
    Unbinder unbinder;
    @BindView(R.id.mETNumber)
    EditText mETNumber;
    @BindView(R.id.mTvClose)
    TextView mTvClose;
    @BindView(R.id.mIvLabel1)
    ImageView mIvLabel1;
    @BindView(R.id.mTvUSDT)
    TextView mTvUSDT;
    @BindView(R.id.mIvTrans)
    ImageView mIvTrans;
    @BindView(R.id.mIvC)
    ImageView mIvC;
    @BindView(R.id.mTvTG)
    TextView mTvTG;
    @BindView(R.id.mIvAdd)
    ImageView mIvAdd;
    @BindView(R.id.mIvDecrease)
    ImageView mIvDecrease;
    @BindView(R.id.mTvAll)
    TextView mTvAll;
    @BindView(R.id.mBtnGet)
    Button mBtnGet;
    @BindView(R.id.mBtnEnter)
    Button mBtnEnter;
    @BindView(R.id.mTvAllTG)
    TextView mTvAllTG;
    @BindView(R.id.mTvAmount)
    TextView mTvAmount;

    @Override
    protected void initData() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pop_buy, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mTvClose, R.id.mBtnGet, R.id.mBtnEnter, R.id.mIvAdd, R.id.mIvDecrease, R.id.mTvAll})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvClose:
                BusProvider.post(EventType.EVENT_CLOSE_BUY_AND_GET);
                break;
            case R.id.mBtnGet:
                BusProvider.getInstance().post(new EventBusInfo<>(EventType.EVENT_OPEN_GET));
                break;
            case R.id.mBtnEnter:
                BusProvider.getInstance().post(new EventBusInfo<>(EventType.EVENT_OPEN_ENTRY, mETNumber.getText().toString()));
                break;
            case R.id.mIvAdd:
                addOrDecrease(0);
                break;
            case R.id.mIvDecrease:
                addOrDecrease(1);
                break;
            case R.id.mTvAll:
                putAllTG();
                break;
        }
    }

    private void putAllTG() {
        Double amount = Double.valueOf(mTvAmount.getText().toString());
        Double before = Double.valueOf(mETNumber.getText().toString());
        Double all = Double.valueOf(mTvAllTG.getText().toString());
        mETNumber.setText(String.valueOf(amount));
    }

    private void addOrDecrease(int flag) {
        Double before = Double.valueOf(mETNumber.getText().toString());
        Double all = Double.valueOf(mTvAmount.getText().toString());
        if (flag == 0 && before + 1 < all) {
            // 增加
            ++before;
//            --all;
        } else if (flag == 1 && before - 1 > 0) {
            --before;
//            ++all;
        } else {
            return;
        }
        mETNumber.setText(String.valueOf(before));
//        mTvAllTG.setText(String.valueOf(all));
    }

}
