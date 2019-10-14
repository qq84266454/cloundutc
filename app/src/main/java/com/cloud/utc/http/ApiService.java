package com.cloud.utc.http;


import com.cloud.utc.bean.IdentificationResp;
import com.cloud.utc.bean.LoginReq;
import com.cloud.utc.bean.LoginResp;
import com.cloud.utc.bean.NoBodyModel;
import com.cloud.utc.bean.SignUpReq;
import com.cloud.utc.bean.SignUpResp;
import com.cloud.utc.bean.UserInfoResp;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
//    @Multipart
//    @POST("api/feedback/advicefeedback")
//    Call<BaseModel> doFeedback(@Query("contactMobile") String mobile, @Query("adviceContent") String content,
//                               @Part MultipartBody.Part[] parts);
}
