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
import retrofit2.http.Query;


public interface studentService {

    @GET("/student/get/{username}")
    Call<StudentModel> getStudent(@Path("username") String username);

    @GET("/student/getid/{id}")
    Call<StudentModel> getStudentbyId(@Path("id") long id);

    //post student info
    @POST("/student/save")
    Call<StudentModel> signup(@Body StudentModel studentmodel); //Body

    @PUT("/student/put/{id}")
    Call<StudentModel> updatestudent(@Path("id") long id, @Body StudentModel student);

    @GET("/student/get/orderbyfield/{fieldgroup}")
    Call<List<StudentModel>> sortStudentsByFeild(@Query("fieldgroup") int field);

////    @PUT("/posts/{id}")
////    Call<Todo> updateTodo(@Path("id") int Id,@Body Todo todo);
//
//    @DELETE("/posts/{id}")
//    Call<Object> deleteTodo(@Path("id") int Id);

}