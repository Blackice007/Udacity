package com.example.monim.udacitycourse.data.room;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.monim.udacitycourse.cg.ApplicationContext;
import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.data.room.entity.Instructor;
import com.example.monim.udacitycourse.utils.AppConstants;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

@Singleton
public class DbHelper implements IDbHelper {

    private final AppDatabase db;
    private Context mContext;


    @Inject
    public DbHelper(@ApplicationContext Context context) {
        mContext = context;
        db = Room.databaseBuilder(mContext, AppDatabase.class, AppConstants.DB_NAME).allowMainThreadQueries().build();
    }

    @Override
    public Long insertCourse(Course course) {
        return db.courseDao().insert(course);
    }

    @Override
    public void insertCourse(List<Course> courses) {
        db.courseDao().insert(courses);
        int position = 0;
        for (Course course : db.courseDao().getAll()) {
                for (Instructor instructor : courses.get(position).getInstructors()) {
                    instructor.setCourseId(course.getLocalId());
                    insertInstructor(instructor);
                }
            position++;
        }
    }


    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = db.courseDao().getAll();
        for (Course item : courses) {
            item.setInstructors(getInstructorByCourseId(item.getLocalId()));
        }
        return courses;
    }

    @Override
    public void deleteAllCourseWithInstructor() {
        db.courseDao().delete();
        db.instructorDao().delete();
    }

    @Override
    public Long insertInstructor(Instructor instructor) {
        return db.instructorDao().insert(instructor);
    }

    @Override
    public void insertInstructor(List<Instructor> instructors) {
        db.instructorDao().insert(instructors);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(int id) {
        return db.instructorDao().getInstructorsByCourseId(id);
    }

    @Override
    public List<Instructor> getInstructor() {
        return db.instructorDao().getAll();
    }
}
