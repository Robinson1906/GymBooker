package com.example.gymbooker.Helpers;

import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.ReservaService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HelperReservas {

    public ArrayList<Reserva> getReservas(){
        //TODO traer reservas del api
        ArrayList<Reserva> listReserva= new ArrayList<>();

        Reserva res1 = new Reserva("2023-05-12","1097608514","Espalda","16:00","18:00");
        Reserva res2 = new Reserva("2023-05-13","1097608514","Abdomen","09:00","11:00");
        Reserva res3 = new Reserva("2023-05-16","1097608514","Abdomen","09:00","11:00");


        listReserva.add(res1);
        listReserva.add(res2);
        listReserva.add(res3);
        return listReserva;
    }



    public void guardarReserva(Reserva r){


        Retrofit myRetro = APIService.getInstance();
        ReservaService myReservaService = myRetro.create(ReservaService.class);

        myReservaService.postAll(r).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });

    }
}
