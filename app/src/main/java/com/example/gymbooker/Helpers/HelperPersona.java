package com.example.gymbooker.Helpers;


import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gymbooker.AgendarActivity;
import com.example.gymbooker.Class.Reserva;

import com.example.gymbooker.Class.User;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import okhttp3.Request;
import okio.Timeout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HelperPersona {
    private static final String API_Url =  "https://apex.oracle.com/pls/apex/gymbooker/RESTAPI_GYMBOOKER/";

    public ArrayList<User> getUser(){
        //todo traer los usuarios del api
        /*Retrofit retrofit= APIService.getInstance();

        UserService userService= retrofit.create(UserService.class);
        userService.getAll().enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Log.d("myLog","Success");
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("myLog",t.toString());

            }
        });
*/
        ArrayList<User> users = new ArrayList<>();
        User u1 = new User("1097608514", "Emilton Fabian Hernandez Mejia", 1, "faherme46@gmail.com", "3166316579", "25/04/2005", "0001abc");
        User u2 = new User("1097608514","Emilton Fabian Hernandez Mejia",1,"faherme46@gmail.com","3166316578","25/04/2005","0002abc");
        User u3 = new User("1097608514","Emilton Fabian Hernandez Mejia",1,"faherme46@gmail.com","3166316577","25/04/2005","0003abc");


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
