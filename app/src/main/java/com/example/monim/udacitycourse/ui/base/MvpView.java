package com.example.monim.udacitycourse.ui.base;

import android.support.v4.app.Fragment;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */


public interface MvpView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    boolean isNetworkConnected();

    void hideKeyboard();

}
