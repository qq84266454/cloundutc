package com.cloud.utc.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.cloud.utc.R;
import com.ypx.imagepicker.ImagePicker;
import com.ypx.imagepicker.adapter.multi.BaseItemView;
import com.ypx.imagepicker.adapter.multi.MultiGridAdapter;
import com.ypx.imagepicker.bean.ImageItem;
import com.ypx.imagepicker.bean.MultiSelectConfig;
import com.ypx.imagepicker.bean.PickerUiConfig;
import com.ypx.imagepicker.bean.SelectMode;
import com.ypx.imagepicker.presenter.IMultiPickerBindPresenter;
import com.ypx.imagepicker.utils.PCornerUtils;
import com.ypx.imagepicker.utils.PViewSizeUtils;

import java.util.ArrayList;

/**
 * Time: 2019/8/8 16:47
 * Author:ypx
 * Description: 自定义选择器列表item
 */
public class CustomPickerItem extends BaseItemView {
    private ImageView mItemImage;
    private IMultiPickerBindPresenter presenter;
    private MultiSelectConfig selectConfig;
    private View mVMask;
    private View mVSelect;
    private TextView mTvIndex;
    private TextView mTvDuration;
    private View mRectView;
    private Drawable stokeDrawable, maskDrawable;

    protected CustomPickerItem(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.item_custom;
    }

    @Override
    protected void initView(View view) {
        mItemImage = view.findViewById(R.id.iv_image);
        mVMask = view.findViewById(R.id.v_mask);
        mVSelect = view.findViewById(R.id.v_select);
        mTvIndex = view.findViewById(R.id.mTvIndex);
        mTvDuration = view.findViewById(R.id.mTvDuration);
        mRectView = view.findViewById(R.id.mRectView);
        mRectView.setBackground(PCornerUtils.cornerDrawableAndStroke(Color.TRANSPARENT, 0, dp(1.5f), Color.WHITE));

        stokeDrawable = PCornerUtils.cornerDrawableAndStroke(
                Color.parseColor("#859D7B"),
                dp(12), dp(1), Color.WHITE);
        maskDrawable = PCornerUtils.cornerDrawableAndStroke(Color.parseColor("#80859D7B"),
                0, dp(2), Color.parseColor("#859D7B"));
    }

    @Override
    public void initData(MultiSelectConfig selectConfig, IMultiPickerBindPresenter presenter, PickerUiConfig uiConfig) {
        super.initData(selectConfig, presenter, uiConfig);
        this.presenter = presenter;
        this.selectConfig = selectConfig;
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void bindData(final ImageItem imageItem, final RecyclerView.Adapter adapter,
                            final int position, final ArrayList<ImageItem> selectImageList,
                            final MultiGridAdapter.OnActionResult result) {
        //加载图片
        presenter.displayListImage(mItemImage, imageItem, 0);

        if (imageItem.getWidthHeightType() == 1) {//宽图
            PViewSizeUtils.setViewSize(mRectView, dp(12), dp(8));
        } else if (imageItem.getWidthHeightType() == -1) {//高图
            PViewSizeUtils.setViewSize(mRectView, dp(8), dp(12));
        } else {
            PViewSizeUtils.setViewSize(mRectView, dp(10), dp(10));
        }

        //在屏蔽列表中
        if (selectConfig.isShieldItem(imageItem)) {
            mVMask.setVisibility(View.VISIBLE);
            mVMask.setBackgroundColor(Color.parseColor("#80FFFFFF"));
            mVSelect.setVisibility(View.GONE);
            mTvIndex.setVisibility(View.GONE);
            mItemImage.setOnClickListener(null);
            return;
        }

        //选择框点击
        mVSelect.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != result) {
                    result.onCheckItem(imageItem);
                }
            }
        });

        //item点击
        mItemImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != result) {
                    result.onClickItem(imageItem, position);
                }
            }
        });

        //当前item是视频,显示时长，隐藏选中按钮，默认视频只能单选
        if (imageItem.isVideo()) {
            mTvDuration.setVisibility(View.VISIBLE);
            mTvDuration.setText(imageItem.getDurationFormat());
            mVSelect.setVisibility(View.GONE);
            mTvIndex.setVisibility(View.GONE);
            mRectView.setVisibility(View.GONE);
            mVMask.setVisibility(View.GONE);
            //如果当前选中列表的第一个item不是视频,或者该视频超过最大时长选择，则需要置灰该视频item
            if ((selectImageList != null && selectImageList.size() > 0 && !selectImageList.get(0).isVideo()) ||
                    imageItem.duration > ImagePicker.MAX_VIDEO_DURATION) {
                mVMask.setVisibility(View.VISIBLE);
                mVMask.setBackgroundColor(Color.parseColor("#80FFFFFF"));
                mItemImage.setOnClickListener(null);
            }
            return;
        }

        //只有在多选模式下才能显示选择框
        if (selectConfig.getSelectMode() == SelectMode.MODE_MULTI || selectConfig.getMaxCount() > 1) {
            mTvIndex.setVisibility(View.VISIBLE);
            mVSelect.setVisibility(View.VISIBLE);
        } else {
            mTvIndex.setVisibility(View.GONE);
            mVSelect.setVisibility(View.GONE);
        }
        mTvDuration.setVisibility(View.GONE);
        mRectView.setVisibility(View.VISIBLE);


        //如果当前item在选中列表里
        if (selectImageList != null && selectImageList.size() > 0) {
            for (int t = 0; t < selectImageList.size(); t++) {
                if (imageItem.equals(selectImageList.get(t))) {
                    imageItem.setSelectIndex(t);

                    mVMask.setVisibility(View.VISIBLE);
                    mVMask.setBackground(maskDrawable);
                    mTvIndex.setText(String.format("%d", imageItem.getSelectIndex() + 1));
                    mTvIndex.setBackground(stokeDrawable);
                    return;
                }
            }
        }

        if (selectImageList != null && selectImageList.size() >= selectConfig.getMaxCount()) {
            mVMask.setVisibility(View.VISIBLE);
            mVMask.setBackgroundColor(Color.parseColor("#80FFFFFF"));
            mItemImage.setOnClickListener(null);
            mTvIndex.setText("");
            mTvIndex.setBackground(null);
        } else {
            mVMask.setVisibility(View.GONE);
            mTvIndex.setText("");
            mTvIndex.setBackground(getContext().getResources().getDrawable(com.ypx.imagepicker.R.mipmap.picker_icon_unselect));
        }
    }
}