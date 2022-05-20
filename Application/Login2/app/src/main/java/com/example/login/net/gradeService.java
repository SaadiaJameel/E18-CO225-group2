package com.example.login.net;

import com.example.login.model.CourseModel;
import com.example.login.model.GradesModel;
import com.example.login.model.StudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface gradeService {

    @POST("/grade/save")
    Call<GradesModel> addgrade(@Body GradesModel grade);

//    @GET("/course/get/getSem/{semid}")
//    Call<List<CourseModel>> getcourses(@Query("semid") long semid);
//
//    @GET("/course/get/{id}")
//    Call<CourseModel> getSingleCourse(@Path("id") long id);

    @GET("/grade/get/bystudent/{studentid}")
    Call<List<GradesModel>> getgrades(@Query("studentid") long studentid);

    @PUT("/grade/put/studentidandcourseid")
    Call<GradesModel> putfinalgrade(@Query("studentid") long studentid, @Query("courseid") long courseid, @Body GradesModel grade);
}