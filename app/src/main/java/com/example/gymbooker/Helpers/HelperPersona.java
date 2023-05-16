package com.example.gymbooker.Helpers;

import android.view.View;
import android.widget.Toast;

import com.example.gymbooker.AgendarActivity;
import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Class.User;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.ReservaService;
import com.example.gymbooker.RetroFit.UserService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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
}
