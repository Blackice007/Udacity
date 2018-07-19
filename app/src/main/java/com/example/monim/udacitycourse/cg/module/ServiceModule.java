package com.example.monim.udacitycourse.cg.module;

import android.app.Service;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }

    @Provides
    @Singleton
    Service provideSyncService() {
        return mService;
    }

}
