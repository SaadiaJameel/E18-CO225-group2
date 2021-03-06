package com.example.login.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitService {

    //make retrofit object
    private Retrofit retrofit;

    //constructor
    public RetroFitService(){
        initializeRetrofit();       //initialize retrofit
    }

    //initialize retrofit
    private void initializeRetrofit() {

        //use retrofit builder
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.7:8080")           //server address
                .addConverterFactory(GsonConverterFactory.create(new Gson()))       //use json library from google
                .build();
    }

    //return retrofit object
    public Retrofit getRetrofit(){
        return retrofit;
    }
}