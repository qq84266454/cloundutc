package com.cloud.utc.http;

import android.support.annotation.NonNull;


import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * Created by ex-lvchaofeng001 on 2017/8/10.
 */

public class OkHttpInterceptor implements Interceptor {


    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        // get connection, containing method including route,socket,handshake and protocol etc.
//        Connection connection = chain.connection();
        // if connection is null,return http_1_1 else return connection#protocol();
//        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
//        String msg = request.method() + " " + request.url() + " " + protocol;
        Response response;
        response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();
        if (!bodyEncoded(response.headers())) {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.buffer();
            if (contentLength != 0) {
            }
        }
        return response;
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && contentEncoding.equalsIgnoreCase("identity");
    }
}
