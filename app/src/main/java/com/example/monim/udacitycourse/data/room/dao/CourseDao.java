package com.example.monim.udacitycourse.data.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.example.monim.udacitycourse.data.room.entity.Course;

import java.util.List;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */
@Dao
public interface CourseDao {
    @Query("SELECT * FROM Course")
    List<Course> getAll();

    @Query("SELECT * FROM Course where localId=:localId ")
    Course getAddressById(int localId);

    @Insert
    long insert(Course course);

    @Insert
    List<Long> insert(List<Course> courses);

    @Delete
    int delete(List<Course> courses);

    @Delete
    int delete(Course course);

    @Query("DELETE FROM Course")
    int delete();

}
