package com.cloud.utc.http;

import android.support.annotation.NonNull;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.SpanUtils;
import com.cloud.utc.base.Constants;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ex-lvchaofeng001 on 2017/8/10.
 */

public class NetworkInterceptor implements Interceptor {
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 7;
    private static final long CACHE_AGE_SEC = 0;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    private Request request;

//    @NotNull
//    @Override
//    public Response intercept(Chain chain) throws IOException {
//        return null;
//    }

    /**
     * "deviceId": "1111-2222-3333-4444",//设备Id ios uuid  android uuid
     * "deviceType": "1",//设备平台类型
     * "os": "android",//操作系统名称
     * "osVersion": "5.0.1",//操作系统版本
     * "appType": "1",//应用类型
     * "appVersion": "1.0.1",//应用版本
     * "token":"xxxx"//token 串
     */

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        request = chain.request();
        request = request.newBuilder()
//                .header("deviceId", PushManager.getPushId(BaseApplication.getApplication()))
//                .header("deviceType", "1")
//                .header("os", "android")
//                .header("osVersion", DeviceUtils.getModel() + "")
//                .header("appType", "1")
//                .header("appVersion", AppUtils.getAppVersionCode() + "")
                .header(Constants.ACESS_TOKEN, SPUtils.getInstance().getString(Constants.ACESS_TOKEN))
                .build();
        if (NetworkUtils.isAvailable()) {
            request = request.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public,max-age=" + CACHE_AGE_SEC)
                    .build();
            Response response = chain.proceed(request);
            return response.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public,max-age=" + CACHE_AGE_SEC)
                    .build();

        } else {
            request = request.newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public,only-if-cached,max-stale=" + CACHE_STALE_SEC)
                    .build();
            return chain.proceed(request).newBuilder()
                    .removeHeader("Pragma")
                    .removeHeader("Cache-Control")
                    .header("Cache-Control", "public,only-if-cached,max-stale=" + CACHE_STALE_SEC)
                    .build();
        }

    }
}
