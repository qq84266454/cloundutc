package com.cloud.utc.popup;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.blankj.utilcode.util.EncodeUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.bumptech.glide.Glide;
import com.cloud.utc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import razerdp.basepopup.BasePopupWindow;

public class QRDialog extends BasePopupWindow {
    @BindView(R.id.mIvQRCode)
    ImageView mIvQRCode;

    public QRDialog(Context context) {
        super(context);
        setShowAnimation(createTranslateAnimation(0f, 0f, 1f, 0f));
        setDismissAnimation(createTranslateAnimation(0f, 0f, 0f, 1f));
        ButterKnife.bind(this, getContentView());
        String qr_code = SPUtils.getInstance().getString("qr_code");
        LogUtils.e(qr_code);
        if (!qr_code.isEmpty())
            mIvQRCode.setImageBitmap(ImageUtils.bytes2Bitmap(EncodeUtils.base64Decode(SPUtils.getInstance().getString("qr_code"))));
    }

    @Override
    public View onCreateContentView() {
        View view = createPopupById(R.layout.pop_qr);
        return view;
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
