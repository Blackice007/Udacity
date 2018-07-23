package com.example.monim.udacitycourse.utils;


public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "udacity_ourses";
    public static final String PREF_NAME = "udacity_courses_pref";
    public static final String API_KEY = "api_key";

    public static final String API_BASE_URL = "https://www.udacity.com/public-api/v0/";

    public static final boolean HTTP_LOGGIN_INTERCEPTOR = true;

    public static final int HTTP_CONNECT_TIMEOUT = 2;
    public static final int HTTP_WRITE_TIMEOUT = 2;
    public static final int HTTP_READ_TIMEOUT = 2;


    public static final long NULL_INDEX = -1L;

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
