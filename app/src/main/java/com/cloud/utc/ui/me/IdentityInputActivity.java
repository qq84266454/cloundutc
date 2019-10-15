package com.cloud.utc.ui.me;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.cloud.utc.BaseActivity;
import com.cloud.utc.R;
import com.cloud.utc.base.Constants;
import com.cloud.utc.bean.IdentificationReq;
import com.cloud.utc.bean.IdentificationResp;
import com.cloud.utc.bean.ImageUploadResp;
import com.cloud.utc.http.ApiRequest;
import com.cloud.utc.http.ApiService;
import com.cloud.utc.http.RequestCallback;
import com.cloud.utc.view.WXImgPickerPresenter;
import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;
import com.ypx.imagepicker.ImagePicker;
import com.ypx.imagepicker.bean.ImageItem;
import com.ypx.imagepicker.data.OnImagePickCompleteListener;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;

public class IdentityInputActivity extends BaseActivity {
    @BindView(R.id.m_tv_title)
    TextView mTvTitle;
    @BindView(R.id.mEtName)
    EditText mEtName;
    @BindView(R.id.mEtPwd)
    EditText mEtPwd;
    @BindView(R.id.mIvPhoto)
    ImageView mIvPhoto;
    @BindView(R.id.mIvBackCard)
    ImageView mIvBackCard;

    String frontPath;
    String backPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity_input);
        ButterKnife.bind(this);
        initStatus();
        mTvTitle.setText("Identification");
    }

    @OnClick({R.id.m_iv_back, R.id.mIvPhoto, R.id.mIvBackCard, R.id.mBtnSubmit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.m_iv_back:
                finish();
                break;
            case R.id.mIvPhoto:
                showPhotoPicker(true);
                break;
            case R.id.mIvBackCard:
                showPhotoPicker(false);
                break;
            case R.id.mBtnSubmit:
                doIdentification();
                break;
        }
    }

    private void doIdentification() {
        String name = mEtName.getText().toString();
        String pwd = mEtPwd.getText().toString();
        if (name.isEmpty()) {
            ToastUtils.showShort("name is required");
            return;
        } else if (pwd.isEmpty()) {
            ToastUtils.showShort("card number or password is required");
            return;
        }
        if (frontPath == null) {
            ToastUtils.showShort("Please upload your front of card ");
            return;
        }
        if (backPath == null) {
            ToastUtils.showShort("Please upload your back of card ");
            return;
        }

        IdentificationReq req = new IdentificationReq(name, pwd, frontPath, backPath);
        getApiService().doIdentificationTwo(req).enqueue(new RequestCallback<IdentificationResp>() {
            @Override
            public void onFinish() {

            }

            @Override
            public void onSuccess(Response<IdentificationResp> response) {
                LogUtils.e(response.body());
                startActivity(new Intent(instance, IdentityResultActivity.class));

            }
        });
    }

    private void showPhotoPicker(boolean isFront) {
        ImagePicker.withMulti(new WXImgPickerPresenter())
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
                        doImage(path, isFront);
                    }
                });
    }

    private void doImage(String path, boolean isFront) {
//        File file = new File(UriUtils.getRealPathFromUri(this, uriList.get(i)));
        File file = new File(path);
        Glide.with(this).load(file).into(isFront ? mIvPhoto : mIvBackCard);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        QMUITipDialog uploading = newTipDialog(QMUITipDialog.Builder.ICON_TYPE_LOADING, "uploading");
        uploading.show();
        ApiRequest.getInstance().create(ApiService.class).doImage(Constants.IDCARD_FRONT, filePart).enqueue(new RequestCallback<ImageUploadResp>() {
            @Override
            public void onFinish() {
                uploading.dismiss();
            }

            @Override
            public void onSuccess(Response<ImageUploadResp> response) {
                ImageUploadResp resp = response.body();
                dealSuccess(resp, isFront);
            }
        });
    }

    /**
     * @param resp
     * @param isFront
     */
    private void dealSuccess(ImageUploadResp resp, boolean isFront) {
        if (isFront) {
            frontPath = resp.getPath();
        } else {
            backPath = resp.getPath();
        }
    }
}
