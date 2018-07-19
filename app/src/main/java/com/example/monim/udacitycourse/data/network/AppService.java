package com.example.monim.udacitycourse.data.network;

import com.example.monim.udacitycourse.data.network.respons.CourseRespons;
import io.reactivex.Single;
import retrofit2.http.GET;


/**
 * Created by Md. Mushfique Hasan Monim on 07/15/2018.
 */

public interface AppService {

    @GET("courses")
    Single<CourseRespons> getAllCourses();

}
