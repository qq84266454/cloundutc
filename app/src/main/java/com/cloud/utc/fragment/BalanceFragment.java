package com.cloud.utc.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.cloud.utc.R;
import com.cloud.utc.base.Constants;
import com.cloud.utc.event.EventBusInfo;
import com.cloud.utc.event.EventType;
import com.cloud.utc.popup.BuyBasePopup;
import com.cloud.utc.popup.GetBasePopup;
import com.cloud.utc.popup.MyDialogFragment;
import com.cloud.utc.ui.HashRateActivity;
import com.cloud.utc.view.MyRollText;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import razerdp.basepopup.BasePopupWindow;

public class BalanceFragment extends HomeBaseFragment {

    @BindView(R.id.mBtnBuy)
    TextView mBtnBuy;
    @BindView(R.id.root)
    View root;
    @BindView(R.id.mTvTG)
    MyRollText mTvTG;
    private FragmentActivity activity;
    private BuyBasePopup myBuyPop;
    private int px;
    private GetBasePopup getBasePopup;
    // 首页是否移动的标志 ,默认为0 ,没有移动
    private int isRootStable = 0;
    private MyDialogFragment tradeDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_balance, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = (AppCompatActivity) activity;
    }


    @OnClick({R.id.mBtnBuy, R.id.mViewHashRate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mBtnBuy:
                this.px = QMUIDisplayHelper.dp2px(getContext(),185);
                transRoot();
//                showBuyPopup();
                openTradeDialog();
                break;
            case R.id.mViewHashRate:
                goHashRate();
                break;
        }
    }

    /**
     * 打开TradeDialog
     */
    private void openTradeDialog() {
        tradeDialog = new MyDialogFragment();
        tradeDialog.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "dialog");
    }

    /**
     * 打开HashRate页面
     */
    private void goHashRate() {
        startActivity(new Intent(getActivity(), HashRateActivity.class));
        getActivity().overridePendingTransition(R.anim.slide_in_bottom, 0);
    }

    /**
     * 第一次使用PopupWindow实现,打开PopupWindow
     */
    private void showBuyPopup() {
        myBuyPop = new BuyBasePopup(activity);
        myBuyPop.setPopupGravity(Gravity.BOTTOM).setBackground(null).setOnDismissListener(new MyDismissListener());
        myBuyPop.showPopupWindow();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public class MyDismissListener extends BasePopupWindow.OnDismissListener {

        @Override
        public void onDismiss() {
            // 如果是通過點擊Get按鈕,在結束之後再打開getPopup浮窗

        }

        @Override
        public void onDismissAnimationStart() {
            super.onDismissAnimationStart();
            // 如果按下的是enter按钮,不需要移动这些.
            if (myBuyPop.closeType != 1)
                backRoot();
            if (myBuyPop.closeType == 1) {
                showGetPopup();
            }
        }

    }

    private void showGetPopup() {
        getBasePopup = new GetBasePopup(getContext());
        getBasePopup.setPopupGravity(Gravity.BOTTOM);
        getBasePopup.setBackground(null);
        getBasePopup.setOnDismissListener(new BasePopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
            }

            @Override
            public void onDismissAnimationStart() {
                super.onDismissAnimationStart();
                if (isRootStable == 1) {
                    backRoot();
                }
            }
        });
        getBasePopup.showPopupWindow();
    }

    private void backRoot() {
        if (isRootStable == 1) {
            ObjectAnimator translationY = ObjectAnimator.ofFloat(root, "translationY", -px, 0);
            ObjectAnimator animator = ObjectAnimator.ofFloat(mBtnBuy, "alpha", 0f, 1f);
            // 表示的是:
            // 动画作用对象是mButton
            // 动画作用的对象的属性是透明度alpha
            // 动画效果是:常规 - 全透明 - 常规
            animator.setDuration(Constants.POP_DURATION);
            animator.start();
            translationY.setDuration(Constants.POP_DURATION);
            mBtnBuy.setVisibility(View.VISIBLE);
            translationY.start();
            isRootStable = 0;
        }
    }

    private void transRoot() {
        ObjectAnimator startA = ObjectAnimator.ofFloat(root, "translationY", 0, -px)
                .setDuration(Constants.POP_DURATION);
        ObjectAnimator animator = ObjectAnimator.ofFloat(mBtnBuy, "alpha", 1f, 0f);
        animator.setDuration(Constants.POP_DURATION);
        animator.start();
        startA.start();
        isRootStable = 1;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onEventMainThread(EventBusInfo eventBusInfo) {
        switch (eventBusInfo.getType()) {
            case EventType.EVENT_CLOSE_BUY_POPUP:
                dismissPop(myBuyPop);
                backRoot();
                break;
            case EventType.EVENT_OPEN_GET_POPUP:
                dismissPop(myBuyPop);
                break;
            case EventType.EVENT_OPEN_ENTRY:
                displayTG((String) eventBusInfo.getData());
                if (tradeDialog != null && tradeDialog.isVisible())
                    tradeDialog.dismiss();
                break;
        }
    }

    private void dismissPop(BasePopupWindow popupWindow) {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }

    private void displayTG(String result) {
        String startString = mTvTG.getText().toString();
        LogUtils.e(startString);
        Double start = Double.parseDouble(startString);
        double add = Double.parseDouble(result);
        double end = start + add;
        mTvTG.setDuration(2000L);
        mTvTG.setNumberString(startString, String.valueOf(end));
    }
}
