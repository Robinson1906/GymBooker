package com.example.gymbooker.Helpers;

import com.example.gymbooker.Class.User;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.UserService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import java.util.Calendar;
import java.util.Date;

public class HelperPersona {


    public ArrayList<User> getUser(){
        //todo traer los usuarios del api

        User u1 = new User("1097608514","Emilton",1,"faherme46@gmail.com","3166316579","25/04/2005","0001abc");
        User u2 = new User("1097608514","Emilton",1,"faherme46@gmail.com","3166316578","25/04/2005","0002abc");
        User u3 = new User("1097608514","Emilton",1,"faherme46@gmail.com","3166316577","25/04/2005","0003abc");

        ArrayList<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);
        users.add(u3);

        return users;
    }

    public void guardarPersona(User u){
        //TODO Verificar el funcionamiento


        Retrofit myRetro = APIService.getInstance();
        UserService myReservaService = myRetro.create(UserService.class);

        myReservaService.postAll(u).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });

    }
    public User getUserByCc(String cc){
        ArrayList<User> users = getUser();
        for (User u:
             users) {
            if(cc.equals(String.valueOf(u.getCedula()))){
                return u;
            }
        }
        return null;
    }

    private class RetroFit {
    }


    public HelperPersona() {
    }



    public class HelperFechaUtil {

        public static boolean verificarExpiracion(Date fecha) {
            Calendar fechaActual = Calendar.getInstance();
            Calendar fechaComparacion = Calendar.getInstance();
            fechaComparacion.setTime(fecha);

            // Comparar las fechas
            if (fechaActual.after(fechaComparacion)) {
                // La fecha ya ha pasado
                return true;
            }

            // La fecha aún no ha pasado
            return false;
        }

        public static void main(String[] args) {
            // Obtener la fecha actual
            Date fechaActual = new Date();

            // Crear una fecha de ejemplo (2 días atrás)
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -2);
            Date fechaEjemplo = cal.getTime();

            // Verificar si la fecha de ejemplo ha expirado
            boolean expirada = verificarExpiracion(fechaEjemplo);

            if (expirada) {
                System.out.println("La fecha ha expirado");
            } else {
                System.out.println("La fecha aún no ha expirado");
            }
        }
    }

    }
}
