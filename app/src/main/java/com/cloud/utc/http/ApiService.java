package com.cloud.utc.http;


import com.cloud.utc.base.Constants;
import com.cloud.utc.bean.IdentificationReq;
import com.cloud.utc.bean.IdentificationResp;
import com.cloud.utc.bean.ImageUploadResp;
import com.cloud.utc.bean.LoginReq;
import com.cloud.utc.bean.LoginResp;
import com.cloud.utc.bean.NoBodyModel;
import com.cloud.utc.bean.SignUpReq;
import com.cloud.utc.bean.SignUpResp;
import com.cloud.utc.bean.UserInfoResp;


import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * Created by ex-lvchaofeng001 on 2017/8/11.
 */

public interface ApiService {
    @POST("users")
    Call<SignUpResp> doSignUp(@Body SignUpReq requestBean);


    // 用户信息接口
    @GET("user")
    Call<UserInfoResp> doGetUser();

    ////
    @POST("authorizations")
    Call<LoginResp> doSignIn(@Body LoginReq req);


    // 身份识别接口
    @GET("identification")
    Call<IdentificationResp> doIdentification();
    // 身份保存接口
    @POST("identification")
    Call<IdentificationResp> doIdentificationTwo(@Body IdentificationReq req);


    // 发送邮件接口
    @POST("password/code")
    Call<NoBodyModel> doPasswordCode(@Body LoginReq req);

    @POST("password/reset")
    Call<NoBodyModel> doPasswordReset(@Body LoginReq req);
////
////    @POST("phonecheck/createcheck")
////    Call<BaseModel> createCheck(@Body CreateCheckRequestBean requestBean);
////
////    @POST("api/pushmsg/querymsgbyuseranddate")
////    Call<BaseModel<List<PushModel2>>> doRequestMsg();
////
////    @POST("api/onekeycall/applysecurityphonenumber")
////    Call<BaseModel> doRequestPhone(@Body PhoneRequestBean requestBean);
////
////    @POST("api/onekeycall/contactresult")
//    Call<BaseModel> doContactResult(@Body ContactResultRequestBean resultRequestBean);
//
//
//    @FormUrlEncoded
//    @POST("api/personalcenter/updateimage")
//    Call<BaseModel> doUpdateImage(@Field("imageBase64") String imageBase64);
//
//    @POST("api/personalcenter/resetpwd")
//    Call<BaseModel> doResetPwd(@Body PwdResetRequestBean requestBody);
//
//    @POST("api/personalcenter/forgetpwd")
//    Call<BaseModel> doForgetPwd(@Body PwdResetRequestBean resetRequestBean);
//
//    @POST("api/usermgr/checktoken")
//    Call<BaseModel> doCheckToken();
//
//    @POST("api/coreDate/queryBrand")
//    Call<BaseModel<QueryBrandResultVoList>> doQueryBrand(@Body QueryBrandRequestBean requestBean);
//
//    @POST("api/systemmgr/appversion/clientinfo")
//    Call<BaseModel<AppVersionResponseBean>> doCheckUp();
//
//    @POST("api/usermgr/getAccountInfo")
//    Call<BaseModel<LoginResponseBean>> doGetAccountInfo();
//
//    @POST("api/usermgr/firstSetGestures.do")
//    Call<BaseModel> doFirstSetGestures();
//
//    @POST("api/usermgr/getHeadImage")
//    Call<BaseModel> doGetHeadImage(@Query("fileId") String fileId);
//
//    @POST("api/feedback/advicefeedback")
//    Call<BaseModel> doFeedback(@Query("contactMobile") String mobile, @Query("adviceContent") String content);
//
//
    @Multipart
    @POST("images")
    Call<ImageUploadResp> doImage(@Query("type") String type,
                                     @Part MultipartBody.Part parts);
//    for (int i = 0; i < size; i++) {
//        if (uriList.get(i) == null) {
//            parts[i] = MultipartBody.Part.createFormData("file", "");
//        } else {
//            File file = new File(UriUtils.getRealPathFromUri(this, uriList.get(i)));
//            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//            MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
//            parts[i] = filePart;
//        }
//    }
}
