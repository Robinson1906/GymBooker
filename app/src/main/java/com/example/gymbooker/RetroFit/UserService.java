package com.example.gymbooker.RetroFit;

import com.example.gymbooker.Class.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {
    @GET("persona.json")
    Call<Object> getAll();

    @POST("persona.json")
    Call<Object> postAll(@Body User miUser);

    @DELETE("user/{key}.json")
    Call<Object> delete(@Path("key") String cedula);

}