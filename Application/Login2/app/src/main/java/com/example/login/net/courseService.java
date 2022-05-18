package com.example.login.net;

import com.example.login.model.CourseModel;
import com.example.login.model.SemesterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface courseService {

    @POST("/course/save")
    Call<CourseModel> addcourse(@Body CourseModel semester);

    @GET("/course/get/{semid}")
    Call<List<CourseModel>> getcourses(@Query("semid") long semid);

}
