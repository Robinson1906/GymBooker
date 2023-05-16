package com.example.gymbooker.Helpers;


import android.util.Log;

import com.example.gymbooker.Class.User;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HelperPersona {
    private static final String API_Url =  "https://apex.oracle.com/pls/apex/gymbooker/RESTAPI_GYMBOOKER/";

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUser() {
        //todo traer los usuarios del api
        Retrofit retrofit = APIService.getInstance();
        UserService userService = retrofit.create(UserService.class);
        userService.getAll().enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                HashMap<String, ArrayList<HashMap<String, Map>>> dictionary = (HashMap<String, ArrayList<HashMap<String, Map>>>) response.body();

                // Iterating over the Dictionary (HashMap)
                for (Map.Entry<String, ArrayList<HashMap<String, Map>>> entry : dictionary.entrySet()) {
                    String key = entry.getKey();
                    ArrayList<HashMap<String, Map>> arrayList = entry.getValue();

                    // Iterating over the ArrayList
                    for (HashMap<String, Map> item : arrayList) {
                        // Iterating over each user
                        for (Map.Entry<String, Map> itemEntry : item.entrySet()) {
                            User u = new User();
                            u.setCedula((String) itemEntry.getValue().get("cedula"));
                            u.setTelefono((String) itemEntry.getValue().get("telefono"));
                            u.setCorreo((String) itemEntry.getValue().get("correo"));
                            u.setIsAdmin((int) itemEntry.getValue().get("isAdmin"));
                            u.setFechaNacimiento((String) itemEntry.getValue().get("fecha_nacimiento"));
                            u.setToken((String) itemEntry.getValue().get("thetoken"));

                            users.add(u);
                        }
                    }
                }
            }


            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("myLog", t.toString());

            }
        });
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
