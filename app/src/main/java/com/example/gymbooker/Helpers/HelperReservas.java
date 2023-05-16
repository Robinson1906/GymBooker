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

        Reserva res1 = new Reserva("02/05/23","1097608514","Espalda",1600,1800);
        Reserva res2 = new Reserva("08/05/23","1097608514","Abdomen",900,1100);
        Reserva res3 = new Reserva("08/05/23","1097608514","Abdomen",900,1100);


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
