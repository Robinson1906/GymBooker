package com.example.gymbooker.Helpers;

import android.media.session.MediaSession;
import android.util.Log;

import com.example.gymbooker.Class.Tokens;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.TokensService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HelperToken {
    ArrayList<Tokens> Tokens = new ArrayList<>();
    public ArrayList<Tokens> getTokens() {
        Retrofit retrofit = APIService.getInstance();
        TokensService TokenService = retrofit.create(TokensService.class);
        TokenService.getAll().enqueue(new Callback<Object>() {

            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                HashMap<String, ArrayList<HashMap<String, Map>>> dictionary = (HashMap<String, ArrayList<HashMap<String, Map>>>) response.body();

                // Iterating over the Dictionary (HashMap)
                for (Map.Entry<String, ArrayList<HashMap<String, Map>>> entry : dictionary.entrySet()) {
                    ArrayList<HashMap<String, Map>> arrayList = entry.getValue();
                    // Iterating over the ArrayList
                    for (HashMap<String, Map> item : arrayList) {
                        // Iterating over each Token
                        for (Map.Entry<String, Map> itemEntry : item.entrySet()) {
                            Tokens t = new Tokens();
                            t.setIdToken((int) itemEntry.getValue().get("id_token"));
                            t.setTheToken((String) itemEntry.getValue().get("thetoken"));
                            t.setfCreacion((String) itemEntry.getValue().get("fechaCreacion"));
                            t.setfVencimiento((String) itemEntry.getValue().get("fechaLimite"));
                            t.setLimited((int) itemEntry.getValue().get("isLimited"));

                            Tokens.add(t);
                        }
                    }
                }
            }


            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.d("myLog", t.toString());

            }
        });
        return Tokens;
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

