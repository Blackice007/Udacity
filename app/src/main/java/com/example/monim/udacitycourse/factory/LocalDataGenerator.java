package com.example.monim.udacitycourse.factory;

import com.example.monim.udacitycourse.data.DataManager;
import com.example.monim.udacitycourse.ui.main.MainActivity;

public class LocalDataGenerator implements DataGenerator {
    @Override
    public void setData(DataManager mDataManager, final MainActivity mvpView) {
        mvpView.setAdapterData(mDataManager.getAllCourses());
    }
}
