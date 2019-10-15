package com.cloud.utc.http;


import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ex-lvchaofeng001 on 2017/8/10.
 */

public class ApiRequest {
    private static ApiRequest instance;

    private Retrofit retrofit;

    private ApiRequest() {
        OkHttpClient client;
        NetworkInterceptor mNetworkInterceptor = new NetworkInterceptor();
        Dispatcher dispatcher = new Dispatcher(Executors.newFixedThreadPool(20));
        dispatcher.setMaxRequests(20);
        dispatcher.setMaxRequestsPerHost(1);
        client = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .addInterceptor(new OkHttpInterceptor())
                .addNetworkInterceptor(mNetworkInterceptor)
                .addInterceptor(mNetworkInterceptor)
                //                .sslSocketFactory(createSSLSocketFactory())
//                    .sslSocketFactory(setCertificates(BaseApplication
//                            .getApplication()
//                            .getApplicationContext()
//                            .getAssets().open("pingan3.cer")))
//                    .hostnameVerifier(new HostnameVerifier() {
//                        @Override
//                        public boolean verify(String s, SSLSession sslSession) {
//                            return true;
//                        }
//                    })
                .retryOnConnectionFailure(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(InterfaceParameters.BASE_URL)
                .addConverterFactory(NobodyConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    public static ApiRequest getInstance() {
        if (instance == null) {
            instance = new ApiRequest();
        }
        return instance;
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

    private SSLSocketFactory createSSLSocketFactory() {
        SSLContext sc;
        SSLSocketFactory ssf = null;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

                        }

                        @Override
                        public X509Certificate[] getAcceptedIssuers() {
                            return new X509Certificate[0];
                        }
                    }
            }, new SecureRandom());
            ssf = sc.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return ssf;
    }

    private SSLSocketFactory setCertificates(InputStream... certificates) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates) {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
                if (certificate != null) {
                    certificate.close();
                }
            }
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);
            sslContext.init(
                    null,
                    tmf.getTrustManagers(),
                    new SecureRandom()
            );
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return createSSLSocketFactory();
    }
}
