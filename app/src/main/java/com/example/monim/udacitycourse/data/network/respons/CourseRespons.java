package com.example.monim.udacitycourse.data.network.respons;

import com.example.monim.udacitycourse.data.room.entity.Course;

import java.util.List;

public class CourseRespons {

    List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
