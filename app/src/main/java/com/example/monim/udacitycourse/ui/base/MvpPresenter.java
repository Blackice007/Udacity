package com.example.monim.udacitycourse.ui.base;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

    void onDetach();

}
