package com.example.monim.udacitycourse.data;

import android.content.Context;

import com.example.monim.udacitycourse.data.prefs.PreferencesHelper;
import com.example.monim.udacitycourse.data.room.IDbHelper;
import com.example.monim.udacitycourse.cg.ApplicationContext;
import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.data.room.entity.Instructor;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

@Singleton
public class DataManager implements IDataManager {

    private final Context mContext;
    private final IDbHelper mDbHelper;
    private final PreferencesHelper mPreferencesHelper;


    @Inject
    public DataManager(@ApplicationContext Context context, IDbHelper dbHelper, PreferencesHelper preferencesHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
    }

    @Override
    public Long getCurrentUserId() {
        return mPreferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long userId) {
        mPreferencesHelper.setCurrentUserId(userId);
    }

    @Override
    public String getAccessToken() {
        return mPreferencesHelper.getAccessToken();
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPreferencesHelper.setAccessToken(accessToken);
    }

    @Override
    public Long insertCourse(Course course) {
        return mDbHelper.insertCourse(course);
    }

    @Override
    public void insertCourse(List<Course> courses) {
        mDbHelper.insertCourse(courses);
    }

    @Override
    public List<Course> getAllCourses() {
        return mDbHelper.getAllCourses();
    }

    @Override
    public void deleteAllCourseWithInstructor() {
        mDbHelper.deleteAllCourseWithInstructor();
    }

    @Override
    public Long insertInstructor(Instructor instructor) {
        return mDbHelper.insertInstructor(instructor);
    }

    @Override
    public void insertInstructor(List<Instructor> instructors) {
        mDbHelper.insertInstructor(instructors);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(int id) {
        return mDbHelper.getInstructorByCourseId(id);
    }

    @Override
    public List<Instructor> getInstructor() {
        return mDbHelper.getInstructor();
    }
}
