package com.example.monim.udacitycourse.factory;

import com.example.monim.udacitycourse.data.DataManager;
import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.ui.base.MvpView;
import com.example.monim.udacitycourse.ui.main.MainActivity;

import java.util.List;

public interface DataGenerator {
    void setData(DataManager mDataManager, final MainActivity mvpView);
}

