package com.example.gymbooker.RetroFit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class APIService {

    private static final String API_Url =  "https://apex.oracle.com/pls/apex/gymbooker/RESTAPI_GYMBOOKER/";
    private static Retrofit instance = null;

    public static Retrofit getInstance(){
        if(instance == null){
            instance = new Retrofit.Builder()
                    .baseUrl(API_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return instance;
    }



}
