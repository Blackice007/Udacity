package com.example.monim.udacitycourse.data.network;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public class DefaultInterceptors {

    public static HttpLoggingInterceptor getHttpBodyLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public static HttpLoggingInterceptor getHttpNoneLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        return interceptor;
    }
}
