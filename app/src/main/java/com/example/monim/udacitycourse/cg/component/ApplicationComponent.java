package com.example.monim.udacitycourse.cg.component;

import android.app.Application;
import android.content.Context;

import com.example.monim.udacitycourse.MyApp;
import com.example.monim.udacitycourse.data.DataManager;
import com.example.monim.udacitycourse.cg.ApplicationContext;
import com.example.monim.udacitycourse.cg.module.ApplicationModule;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MyApp myApp);


    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();

}