package com.example.monim.udacitycourse.data.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public class AppServiceFactory {

    /**
     * OkHttpClient
     */
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(Configurations.HTTP_CONNECT_TIMEOUT, TimeUnit.MINUTES)
            .writeTimeout(Configurations.HTTP_WRITE_TIMEOUT, TimeUnit.MINUTES)
            .readTimeout(Configurations.HTTP_READ_TIMEOUT, TimeUnit.MINUTES)
            .addInterceptor(Configurations.HTTP_LOGGIN_INTERCEPTOR ? DefaultInterceptors.getHttpBodyLoggingInterceptor() : DefaultInterceptors.getHttpNoneLoggingInterceptor())
            .build();

    /**
     * Retrofit client
     */
    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(Configurations.API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    /**
     * @param serviceClass Generic class
     * @param <S>          class.java
     * @return a new instance
     */
    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

    /**
     * @return Retrofit client
     */
    public static Retrofit getRetrofitClient() {
        return builder.client(httpClient).build();
    }
}
