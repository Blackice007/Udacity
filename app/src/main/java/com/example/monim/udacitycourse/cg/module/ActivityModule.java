package com.example.monim.udacitycourse.cg.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.example.monim.udacitycourse.cg.ActivityContext;
import com.example.monim.udacitycourse.cg.PerActivity;
import com.example.monim.udacitycourse.ui.course_details.DetailsPresenter;
import com.example.monim.udacitycourse.ui.course_details.IDetailsPresenter;
import com.example.monim.udacitycourse.ui.course_details.IDetailsView;
import com.example.monim.udacitycourse.ui.course_details.InstructorAdapter;
import com.example.monim.udacitycourse.ui.main.CourseAdapter;
import com.example.monim.udacitycourse.ui.main.IMainPresenter;
import com.example.monim.udacitycourse.ui.main.IMainView;
import com.example.monim.udacitycourse.ui.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    IMainPresenter<IMainView> provideMainPresenter(MainPresenter<IMainView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    IDetailsPresenter<IDetailsView> provideDetailsPresenter(DetailsPresenter<IDetailsView> presenter) {
        return presenter;
    }

    @Provides
    CourseAdapter provideCourseAdapter() {
        return new CourseAdapter(provideContext());
    }

    @Provides
    InstructorAdapter provideInstructorAdapter() {
        return new InstructorAdapter(provideContext());
    }


}
