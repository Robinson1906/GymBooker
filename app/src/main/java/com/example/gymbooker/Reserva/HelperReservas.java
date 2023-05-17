package com.example.gymbooker.Reserva;

import com.example.gymbooker.APIService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HelperReservas {

    ArrayList<Reserva> listReservas = new ArrayList<>();
    public ArrayList<Reserva> getReserva() {/*
        Retrofit retrofit = APIService.getInstance();
        ReservaService ReservaService = retrofit.create(ReservaService.class);
        ReservaService.getAll().enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                HashMap<String, ArrayList<HashMap<String, Map>>> dictionary = (HashMap<String, ArrayList<HashMap<String, Map>>>) response.body();

                // Iterating over the Dictionary (HashMap)
                for (Map.Entry<String, ArrayList<HashMap<String, Map>>> entry : dictionary.entrySet()) {
                    ArrayList<HashMap<String, Map>> arrayList = entry.getValue();
                    // Iterating over the ArrayList
                    for (HashMap<String, Map> item : arrayList) {
                        // Iterating over each Reserva
                        for (Map.Entry<String, Map> itemEntry : item.entrySet()) {
                            Reserva r = new Reserva();
                            r.setCedula((String) itemEntry.getValue().get("cedula"));
                            r.setRutina((String) itemEntry.getValue().get("id_area"));
                            r.setHoraIngreso((String) itemEntry.getValue().get("horainicio"));
                            r.setHoraSalida((String) itemEntry.getValue().get("horafin"));
                            r.setEstado((int) itemEntry.getValue().get("estado"));

                            reservas.add(r);
                        }
                    }
                }
            }




            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("myLog", t.toString());

            }
        });
        return reservas;*/
        Reserva res1 = new Reserva("2023-05-12","1097608514","Espalda","16:00","18:00");
        Reserva res2 = new Reserva("2023-05-13","1097608514","Abdomen","09:00","11:00");
        Reserva res3 = new Reserva("2023-05-17","1097608514","Abdomen","09:00","11:00");
        listReservas.add(res1);
        listReservas.add(res2);
        listReservas.add(res3);
        return listReservas;
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
