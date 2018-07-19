package com.example.monim.udacitycourse.data.room;

import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.data.room.entity.Instructor;

import java.util.List;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public interface IDbHelper {

    Long insertCourse(final Course course);

    void insertCourse(final List<Course> courses);

    List<Course> getAllCourses();

    void deleteAllCourseWithInstructor();

    Long insertInstructor(final Instructor instructor);

    void insertInstructor(final List<Instructor> instructors);

    List<Instructor> getInstructorByCourseId(int id);

    List<Instructor> getInstructor();
}
