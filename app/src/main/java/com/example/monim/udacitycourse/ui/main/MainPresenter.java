package com.example.monim.udacitycourse.ui.main;

import com.example.monim.udacitycourse.data.DataManager;
import com.example.monim.udacitycourse.factory.DataGenerator;
import com.example.monim.udacitycourse.factory.DataFactory;
import com.example.monim.udacitycourse.ui.base.BasePresenter;

import javax.inject.Inject;


/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */


public class MainPresenter<V extends IMainView> extends BasePresenter<V> implements IMainPresenter<V> {

    private static final String TAG = "MainPresenter";

    @Inject
    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);

        DataFactory.data(getMvpView().isNetworkConnected()).setData(getDataManager(), getMvpView().context());
    }

}
