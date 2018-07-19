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

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


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

}
