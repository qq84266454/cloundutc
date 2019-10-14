package com.cloud.utc.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.view.WXImgPickerPresenter;
import com.ypx.imagepicker.ImagePicker;
import com.ypx.imagepicker.bean.ImageItem;
import com.ypx.imagepicker.data.OnImagePickCompleteListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IdentityInputActivity extends BaseActivity {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    private ImagePicker magePicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_input);
        ButterKnife.bind(this);
        initStatus();
        mTvTitle.setText("Identification");
    }

    @OnClick({R.id.m_iv_back, R.id.mIvPhoto, R.id.mIvBankCard, R.id.mBtnSubmit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mIvPhoto:
                showPhotoPicker();
                break;
            case R.id.mIvBankCard:
                break;
            case R.id.mBtnSubmit:
                startActivity(new Intent(this,IdentityResultActivity.class));
                break;
        }
    }

    private void showPhotoPicker() {
        magePicker.withMulti(new WXImgPickerPresenter())
                .setMaxCount(1)//设置最大选择数量
                .setColumnCount(4)//设置显示列数
                .showVideo(true)//设置是否加载视频
                .showGif(true)//设置是否加载GIF
                .showCamera(true)//设置是否显示拍照按钮（在列表第一个）
                .showImage(true)//设置是否加载图片
                .setMaxVideoDuration(120000)//设置视频可选择的最大时长
                //设置只能选择视频或图片
                .setSinglePickImageOrVideoType(true)
                //设置只能选择一个视频
                .setVideoSinglePick(true)
                //设置下次选择需要屏蔽的图片或视频（简单点就是不可重复选择）
                .setShieldList(new ArrayList<String>())
                //设置下次选择需要带入的图片和视频（简单点就是记录上次选择的图片，可以取消之前选择）
                .setLastImageList(new ArrayList<String>())
                //调用多选
                .pick(this, new OnImagePickCompleteListener() {
                    @Override
                    public void onImagePickComplete(ArrayList<ImageItem> items) {
                        //处理回调回来的图片信息，主线程
                        String path = items.get(0).getPath();
                        LogUtils.e(path);
                    }
                });
    }
}
