package com.cloud.utc.popup;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import com.cloud.utc.R;

import razerdp.basepopup.BasePopupWindow;

public class QRDialog extends BasePopupWindow {
    public QRDialog(Context context) {
        super(context);
        setShowAnimation(createTranslateAnimation(0f, 0f, 1f, 0f));
        setDismissAnimation(createTranslateAnimation(0f, 0f, 0f, 1f));
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.pop_qr);
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
        animation.setDuration(400);
        return animation;
    }
}
