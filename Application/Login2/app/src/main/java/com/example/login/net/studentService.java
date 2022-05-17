package com.example.login.net;

import com.example.login.model.StudentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface studentService {

    @GET("/student/get/{username}")
    Call<StudentModel> getStudent(@Path("username") String username);

    //post student info
    @POST("/student/save")
    Call<StudentModel> signup(@Body StudentModel studentmodel); //Body

}