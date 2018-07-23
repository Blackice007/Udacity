package com.example.monim.udacitycourse;

import android.app.Application;

import com.example.monim.udacitycourse.cg.component.DaggerApplicationComponent;
import com.example.monim.udacitycourse.data.DataManager;
import com.example.monim.udacitycourse.cg.component.ApplicationComponent;
import com.example.monim.udacitycourse.cg.module.ApplicationModule;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class MyApp extends Application {

    @Inject
    DataManager mDataManager;

    @Inject
    Retrofit mRetrofit;


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
