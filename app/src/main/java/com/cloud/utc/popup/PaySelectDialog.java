package com.cloud.utc.popup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cloud.utc.R;
import com.cloud.utc.adapter.PayMethodAdapter;
import com.cloud.utc.bean.PayMethod;
import com.cloud.utc.ui.me.AlipaySettingActivity;
import com.cloud.utc.ui.me.BankSettingActivity;
import com.cloud.utc.view.RecycleViewDivider;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class PaySelectDialog extends BaseDialogFragment {
    @BindView(R.id.mTvClose)
    TextView mTvClose;
    @BindView(R.id.mRv)
    RecyclerView mRv;
    Unbinder unbinder;

    @Override
    protected View setView(@NonNull LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.dialog_pay_select, container, false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        initRv();
        return rootView;
    }

    private void initRv() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(layoutManager);
        PayMethodAdapter mAdapter = new PayMethodAdapter();
        ArrayList<PayMethod> list = new ArrayList<>();
        String[] names = {"Bank Transfer", "Alipay", "Alipay", "Alipay", "Alipay", "Alipay"};
        for (int i = 0; i < names.length; i++) {
            list.add(new PayMethod(names[i]));
        }
        mAdapter.setNewData(list);
        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            String name = mAdapter.getData().get(position).getName();
            if (name.equalsIgnoreCase("Alipay")){
                // 跳转到支付宝设置页面
                startActivity(new Intent(getContext(),AlipaySettingActivity.class));
            }else if (name.contains("Bank Transfer")){
                // 跳转到银行绑定页面
                startActivity(new Intent(getContext(),BankSettingActivity.class));
            }
        });
        mRv.setAdapter(mAdapter);
//        mRv.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL, 1, R.color.general_divider));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.mTvClose, R.id.mRv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvClose:
                dismiss();
                break;
            case R.id.mRv:
                break;
        }
    }
}
