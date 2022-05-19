package com.example.login.net;

import com.example.login.model.CourseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface courseService {

    //post course info
    @POST("/course/save")
    Call<CourseModel> signup(@Body CourseModel coursemodel); //Body

}