package com.example.gymbooker.Tokens;

import com.example.gymbooker.Tokens.Tokens;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TokensService {
    @GET("access_token")
    Call<HashMap> getAll();

    @POST("access_token")
    Call<Object> postAll(@Body Tokens miToken);

    @DELETE("access_token/{key}")
    Call<Object> delete(@Path("key") String id);

}