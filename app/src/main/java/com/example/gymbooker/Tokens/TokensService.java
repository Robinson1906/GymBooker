package com.example.gymbooker.Tokens;

import com.example.gymbooker.Tokens.Tokens;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TokensService {
    @GET("access_token.json")
    Call<Object> getAll();

    @POST("access_token.json")
    Call<Object> postAll(@Body Tokens miToken);

    @DELETE("access_token/{key}.json")
    Call<Object> delete(@Path("key") String id);

}