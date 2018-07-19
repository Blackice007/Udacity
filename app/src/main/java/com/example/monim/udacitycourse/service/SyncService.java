package com.example.monim.udacitycourse.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.example.monim.udacitycourse.MyApp;
import com.example.monim.udacitycourse.data.IDataManager;
import com.example.monim.udacitycourse.cg.component.DaggerServiceComponent;
import com.example.monim.udacitycourse.cg.component.ServiceComponent;

import javax.inject.Inject;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public class SyncService extends Service {

    private static final String TAG = "SyncService";

    @Inject
    IDataManager mDataManager;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService.class);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SyncService.class);
        context.startService(starter);
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, SyncService.class));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceComponent component = DaggerServiceComponent.builder()
                .applicationComponent(((MyApp) getApplication()).getComponent())
                .build();
       // component.inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        log.d(TAG, "SyncService started");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
//        AppLogger.d(TAG, "SyncService stopped");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
