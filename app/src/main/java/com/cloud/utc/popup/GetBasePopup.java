package com.cloud.utc.popup;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.cloud.utc.R;
import com.cloud.utc.base.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.basepopup.BasePopupWindow;

public class GetBasePopup extends BasePopupWindow {
    public int DURATION = Constants.POP_DURATION;
    @BindView(R.id.mTvClose)
    TextView mTvClose;
    @BindView(R.id.mTvToken)
    TextView mTvToken;


    public GetBasePopup(Context context) {
        super(context);
        setOutSideDismiss(false);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setShowAnimation(createTranslateAnimation(1f, 0f, 0f, 0f));
        setDismissAnimation(createTranslateAnimation(0f, 0f, 0f, 1f));
        ButterKnife.bind(this, getContentView());
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop_get);
    }

    @Override
    protected Animation getTranslateVerticalAnimation(int start, int end, int durationMillis) {
        return createTranslateAnimation(0f, 0f, 0f, 1f);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return getTranslateVerticalAnimation(0f, 1f, DURATION);
    }

    private Animation createTranslateAnimation(float fromX, float toX, float fromY, float toY) {
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

    @OnClick({R.id.mTvClose, R.id.mViewCopy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mTvClose:
                dismiss();
                break;
            case R.id.mViewCopy:
                copyAddress();
                break;
        }
    }

    private void copyAddress() {
        //获取剪贴板管理器：
        ClipboardManager cm = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        // 创建普通字符型ClipData
        ClipData mClipData = ClipData.newPlainText("Label", mTvToken.getText().toString().trim());
        // 将ClipData内容放到系统剪贴板里。
        cm.setPrimaryClip(mClipData);
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.showShort("copy Success");
    }

}
