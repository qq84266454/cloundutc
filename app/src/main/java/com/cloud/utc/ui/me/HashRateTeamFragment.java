package com.cloud.utc.ui.me;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloud.utc.R;
import com.cloud.utc.adapter.HashRankAdapter;
import com.cloud.utc.base.BaseFragment;
import com.cloud.utc.bean.HashDetail;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HashRateTeamFragment extends BaseFragment {
    @BindView(R.id.mRv)
    RecyclerView mRv;
    Unbinder unbinder;
    @BindView(R.id.mRefresh)
    SwipeRefreshLayout mRefresh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_recycler_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(layoutManager);
        HashRankAdapter mAdapter = new HashRankAdapter(getActivity());
        ArrayList<HashDetail> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
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
}
