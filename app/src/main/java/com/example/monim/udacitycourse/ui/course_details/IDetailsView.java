package com.example.monim.udacitycourse.ui.course_details;

import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.data.room.entity.Instructor;
import com.example.monim.udacitycourse.ui.base.MvpView;

import java.util.List;

public interface IDetailsView extends MvpView {

    void setData(Course course);
    void setAdapterData(List<Instructor> instructors);
}
