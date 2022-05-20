package com.example.login.net;

import com.example.login.model.SemesterModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface addSemService {

    @GET("/semester/get/{fieldgroup}")
    Call<List<SemesterModel>> getSemesters(@Query("fieldgroup") int field);

    @POST("/semester/save")
    Call<SemesterModel> addSemNumber(@Body SemesterModel semester);
}
