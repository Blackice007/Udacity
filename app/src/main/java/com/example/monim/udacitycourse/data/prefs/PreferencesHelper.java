package com.example.monim.udacitycourse.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.monim.udacitycourse.cg.ApplicationContext;
import com.example.monim.udacitycourse.cg.PreferenceInfo;
import com.example.monim.udacitycourse.utils.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

@Singleton
public class PreferencesHelper implements IPreferencesHelper {

    private static final String PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private final SharedPreferences mPrefs;

    @Inject
    public PreferencesHelper(@ApplicationContext  Context context,
                             @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public Long getCurrentUserId() {
        long userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
        return userId == AppConstants.NULL_INDEX ? null : userId;
    }

    @Override
    public void setCurrentUserId(Long userId) {
        long id = userId == null ? AppConstants.NULL_INDEX : userId;
        mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }


    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }

}
