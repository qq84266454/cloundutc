package com.cloud.utc.http;

import android.support.annotation.NonNull;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public abstract class RequestCallback<T> implements Callback<T> {


    public abstract void onFinish();

    // 非200错误。 404 502等等。
    public abstract void onFailure(int code, String msg);

    // 本身的错误
    public void onThrowable(Throwable t) {
    }

    public abstract void onSuccess(Response<T> response);

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.isSuccessful() && response.body() != null) {
            onSuccess(response);
        } else {
            onFailure(response.code(), String.valueOf(response.errorBody()));
        }
        onFinish();
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        onThrowable(t);
        onFinish();
    }
}
