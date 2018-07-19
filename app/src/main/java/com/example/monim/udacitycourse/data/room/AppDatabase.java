package com.example.monim.udacitycourse.data.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.monim.udacitycourse.data.room.dao.CourseDao;
import com.example.monim.udacitycourse.data.room.dao.InstructorDao;
import com.example.monim.udacitycourse.data.room.entity.Course;
import com.example.monim.udacitycourse.data.room.entity.Instructor;

/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

@Database(entities = {Course.class, Instructor.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CourseDao courseDao();
    public abstract InstructorDao instructorDao();

    }