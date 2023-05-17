package com.example.gymbooker.Tokens;

import android.util.Log;

import com.example.gymbooker.APIService;
import com.example.gymbooker.Tokens.Tokens;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelperToken {
    ArrayList<Tokens> listToken = new ArrayList<>();
    public ArrayList<Tokens> getTokens() {




            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("myLog", t.toString());

            }
        });
        return Tokens;*/

        FirebaseFirestore db = FirebaseFirestore.getInstance();


        listToken=new ArrayList<>();
        Tokens t1=new Tokens(1,"abc1","2023-05-16","2023-01-12",1,false);
        Tokens t2=new Tokens(1,"abc2","2023-05-16","2023-01-12",1,false);
        Tokens t3=new Tokens(1,"abc3","2023-05-16","2023-01-12",1,false);
        Tokens t4=new Tokens(1,"abc4","2023-05-16","2023-01-12",1,false);

        listToken.add(t1);
        listToken.add(t2);
        listToken.add(t3);
        listToken.add(t4);

        return listToken;
    }

    //Metodo que llama la lista de tokens y busca segun el token indicado
    public Tokens getTokenByToken(String token){
        for (Tokens j:
                getTokens()) {
            if(j.getTheToken().equals(token)){
                return j;
            }
        }
        return null;
    }
}

