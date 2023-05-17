package com.example.gymbooker.User;


import android.util.Log;

import java.util.ArrayList;

public class HelperPersona {
    private static final String API_Url =  "https://apex.oracle.com/pls/apex/gymbooker/RESTAPI_GYMBOOKER/";

    ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUser() {
        ArrayList<User> users = new ArrayList<>();
        User u1 = new User("1097608514", "Emilton Fabian Hernandez Mejia", 1, "faherme46@gmail.com", "3166316579", "2005-04-25", "0001abc");
        User u2 = new User("1097608514","Emilton Fabian Hernandez Mejia",1,"faherme46@gmail.com","3166316578","2005-04-25","0002abc");
        User u3 = new User("1097608514","Emilton Fabian Hernandez Mejia",1,"faherme46@gmail.com","3166316577","2005-04-25","0003abc");


        users.add(u1);
        users.add(u2);
        users.add(u3);


        return users;
    }

    static int resp=0;
    public int guardarPersona(User u){
        int s = 1;

        return s;
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
