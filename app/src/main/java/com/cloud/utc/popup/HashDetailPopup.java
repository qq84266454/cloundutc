package com.cloud.utc.popup;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.cloud.utc.R;
import com.cloud.utc.adapter.HashDetailAdapter;
import com.cloud.utc.base.Constants;
import com.cloud.utc.bean.HashDetail;
import com.cloud.utc.utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.basepopup.BasePopupWindow;

public class HashDetailPopup extends BasePopupWindow {
    public int DURATION = Constants.POP_DURATION;
    @BindView(R.id.mTvClose)
    TextView mTvClose;
    @BindView(R.id.mRv)
    RecyclerView mRv;

    public HashDetailPopup(Context context) {
        super(context);
        setOutSideDismiss(false);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setShowAnimation(createTranslateAnimation(0f, 0f, 1f, 0f));
        setDismissAnimation(createTranslateAnimation(0f, 0f, 0f, 1f));
        ButterKnife.bind(this, getContentView());
        initRv();
    }

    private void initRv() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRv.setLayoutManager(layoutManager);
        HashDetailAdapter mAdapter = new HashDetailAdapter();
        ArrayList<HashDetail> list = new ArrayList<>();
        for (int i = 0;i<4;i++){
            list.add(new HashDetail());
        }
        mAdapter.setNewData(list);

        mRv.setAdapter(mAdapter);
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop_hash_detail);
    }

    @Override
    protected Animation getTranslateVerticalAnimation(int start, int end, int durationMillis) {
        return createTranslateAnimation(0f, 0f, 0f, 1f);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return getTranslateVerticalAnimation(0f, 1f, DURATION);
    }

    Animation createTranslateAnimation(float fromX, float toX, float fromY, float toY) {
        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                fromX,
                Animation.RELATIVE_TO_PARENT,
                toX,
                Animation.RELATIVE_TO_PARENT,
                fromY,
                Animation.RELATIVE_TO_PARENT,
                toY);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.setDuration(DURATION);
        return animation;
    }


    @OnClick(R.id.mTvClose)
    public void onViewClicked() {
        dismiss();
    }
}
