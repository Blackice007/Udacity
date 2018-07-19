package com.example.monim.udacitycourse.ui.course_details;

import com.example.monim.udacitycourse.data.DataManager;
import com.example.monim.udacitycourse.ui.base.BasePresenter;
import com.example.monim.udacitycourse.ui.main.IMainPresenter;
import com.example.monim.udacitycourse.ui.main.IMainView;

import javax.inject.Inject;

public class DetailsPresenter <V extends IDetailsView> extends BasePresenter<V>
        implements IDetailsPresenter<V> {

    private static final String TAG = "CourseDetailsPresenter";

    @Inject
    public DetailsPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }
}
