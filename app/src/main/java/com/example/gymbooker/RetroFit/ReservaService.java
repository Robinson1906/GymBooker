package com.example.gymbooker.RetroFit;

import com.example.gymbooker.Class.Reserva;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ReservaService {
    @GET("reserva.json")
    Call<Object> getAll();

    @POST("reserva.json")
    Call<Object> postAll(@Body Reserva miReserva);

    @DELETE("reserva/{key}.json")
    Call<Object> delete(@Path("key") String id);


}
