package com.example.monim.udacitycourse.cg.module;


import android.app.Application;
import android.content.Context;

import com.example.monim.udacitycourse.data.DataManager;
import com.example.monim.udacitycourse.data.IDataManager;
import com.example.monim.udacitycourse.data.prefs.PreferencesHelper;
import com.example.monim.udacitycourse.data.prefs.IPreferencesHelper;
import com.example.monim.udacitycourse.data.room.DbHelper;
import com.example.monim.udacitycourse.data.room.IDbHelper;
import com.example.monim.udacitycourse.cg.ApplicationContext;
import com.example.monim.udacitycourse.cg.DatabaseInfo;
import com.example.monim.udacitycourse.cg.PreferenceInfo;
import com.example.monim.udacitycourse.utils.AppConstants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    IDataManager provideDataManager(DataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    IDbHelper provideDbHelperRoom(DbHelper appDbHelperRoom) {
        return appDbHelperRoom;
    }

    @Provides
    @Singleton
    IPreferencesHelper providePreferencesHelper(PreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }





    @Provides
    String provideBaseUrl() {
        return AppConstants.API_BASE_URL;
    }

    @Provides
    @Singleton
    Cache provideOkHttpCache() {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(mApplication.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    public static HttpLoggingInterceptor getHttpBodyLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    @Singleton
    public static HttpLoggingInterceptor getHttpNoneLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        return interceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(AppConstants.HTTP_CONNECT_TIMEOUT, TimeUnit.MINUTES)
                .writeTimeout(AppConstants.HTTP_WRITE_TIMEOUT, TimeUnit.MINUTES)
                .readTimeout(AppConstants.HTTP_READ_TIMEOUT, TimeUnit.MINUTES)
                .addInterceptor(AppConstants.HTTP_LOGGIN_INTERCEPTOR ? getHttpBodyLoggingInterceptor() : getHttpNoneLoggingInterceptor())
                .cache(provideOkHttpCache())
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(provideGson()))
                .baseUrl(provideBaseUrl())
                .client(provideOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
