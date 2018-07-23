package com.example.monim.udacitycourse.factory;

import com.example.monim.udacitycourse.data.DataManager;
import com.example.monim.udacitycourse.data.network.AppService;
import com.example.monim.udacitycourse.data.network.respons.CourseRespons;
import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.data.room.entity.Instructor;
import com.example.monim.udacitycourse.ui.main.MainActivity;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RemotDataGenerator implements DataGenerator {
    @Override
    public void setData(final DataManager mDataManager, final MainActivity mvpView) {


        mvpView.getRetrofit().create(AppService.class).getAllCourses().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnError(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mvpView.showMessage(throwable.getMessage());
            }
        }).subscribe(new Consumer<CourseRespons>() {
            @Override
            public void accept(CourseRespons courseRespons) throws Exception {
                mvpView.setAdapterData(courseRespons.getCourses());
                mDataManager.deleteAllCourseWithInstructor();
                mDataManager.insertCourse(courseRespons.getCourses());
                List<Course> courses = mDataManager.getAllCourses();
                List<Instructor> instructors = mDataManager.getInstructor();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mvpView.showMessage(throwable.getMessage());
            }
        });
    }
}
