package com.example.monim.udacitycourse.data.prefs;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public interface IPreferencesHelper {

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    String getAccessToken();

    void setAccessToken(String accessToken);

}
