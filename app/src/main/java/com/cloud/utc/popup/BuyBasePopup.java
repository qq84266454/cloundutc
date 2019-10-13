package com.cloud.utc.popup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.TextView;

import com.cloud.utc.R;
import com.cloud.utc.base.Constants;
import com.cloud.utc.event.BusProvider;
import com.cloud.utc.event.EventBusInfo;
import com.cloud.utc.event.EventType;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.basepopup.BasePopupWindow;

public class BuyBasePopup extends BasePopupWindow {
    public int closeType = 0;
    public int DURATION = Constants.POP_DURATION;
    @BindView(R.id.mTvClose)
    TextView mTvClose;
    @BindView(R.id.mETNumber)
    EditText mETNumber;
    @BindView(R.id.mTvAmount)
    TextView mTvAmount;
    private Context context;

    public BuyBasePopup(Context context) {
        super(context);
        this.context = context;
        setOutSideDismiss(false);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setShowAnimation(createTranslateAnimation(0f, 0f, 1f, 0f));
        setDismissAnimation(createTranslateAnimation(0f, 0f, 0f, 1f));
        ButterKnife.bind(this, getContentView());
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop_buy);
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

    @OnClick({R.id.mTvClose, R.id.mBtnGet, R.id.mBtnEnter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvClose:
                closeType = 1;
                dismiss();
                break;
            case R.id.mBtnGet:
                closeType = 1;
                setDismissAnimation(createTranslateAnimation(1f, 0f, 0f, 0f));
                BusProvider.getInstance().post(new EventBusInfo<>(EventType.EVENT_OPEN_GET_POPUP));
                break;
            case R.id.mBtnEnter:
                dismiss();
                BusProvider.getInstance().post(new EventBusInfo<>(EventType.EVENT_OPEN_ENTRY, mETNumber.getText().toString()));
                break;
        }
    }


}
