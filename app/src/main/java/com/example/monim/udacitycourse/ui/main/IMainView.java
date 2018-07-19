package com.example.monim.udacitycourse.ui.main;


import android.support.v4.app.Fragment;

import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.ui.base.MvpView;

import java.util.List;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public interface IMainView extends MvpView {

    void setAdapterData(List<Course> courses);
    MainActivity context();
}
