package com.cloud.utc.http;

import android.support.annotation.NonNull;
import android.view.Gravity;


import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cloud.utc.bean.ErrorModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class RequestCallback<T> implements Callback<T> {


    public abstract void onFinish();

    // 非200错误。 404 502等等。
    public void onFailure(int code, ErrorModel errorModel) {
        String tip = null;
        if (errorModel.getErrors() != null) {
            List<String> account = errorModel.getErrors().getAccount();
            List<String> password = errorModel.getErrors().getPassword();
            if (account != null && account.size() > 0) {
                tip = errorModel.getErrors().getAccount().get(0);
            } else if (password != null && password.size() > 0) {
                tip = errorModel.getErrors().getPassword().get(0);
            }
        } else {
            tip = errorModel.getMessage();
        }
        ToastUtils.setGravity(Gravity.CENTER, 0, 0);
        ToastUtils.showShort(tip);
    }

    // 本身的错误
    public void onThrowable(Throwable t) {
        t.printStackTrace();
    }

    public abstract void onSuccess(Response<T> response);

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        LogUtils.e(response.code() + "");
        if (response.isSuccessful()) {
            onSuccess(response);
        } else if (response.code() == 404 || response.code() >= 500) {
            onFailure(response.code());
        } else {
            try {
                String error = response.errorBody().string();
                ErrorModel errorModel = new Gson().fromJson(error, ErrorModel.class);
                LogUtils.e(errorModel);
                onFailure(response.code(), errorModel);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        onFinish();
    }

    protected void onFailure(int code) {
        ToastUtils.showShort("cannot connect server");
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        t.printStackTrace();
        onThrowable(t);
        onFinish();

    }
}
