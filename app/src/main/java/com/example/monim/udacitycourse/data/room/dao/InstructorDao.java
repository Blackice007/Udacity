package com.example.monim.udacitycourse.data.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.monim.udacitycourse.data.room.entity.Instructor;

import java.util.List;

/**
 * Created by Md. Mushfique Hasan Monim on 07/16/2018.
 */

@Dao
public interface InstructorDao {

    @Query("SELECT * FROM Instructor")
    List<Instructor> getAll();

    @Query("SELECT * FROM Instructor where localId=:localId ")
    Instructor getInstructorById(int localId);

    @Query("SELECT * FROM Instructor where courseId=:courseId ")
    List<Instructor> getInstructorsByCourseId(int courseId);

    @Insert
    long insert(Instructor instructor);

    @Insert
    void insert(List<Instructor> instructors);

    @Delete
    int delete(List<Instructor> instructors);

    @Delete
    int delete(Instructor instructor);

    @Query("DELETE FROM Instructor")
    int delete();
}
