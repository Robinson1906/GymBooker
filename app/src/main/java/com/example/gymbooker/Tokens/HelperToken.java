package com.example.gymbooker.Tokens;

import com.example.gymbooker.Tokens.Tokens;

import java.util.ArrayList;

public class HelperToken {
    ArrayList<Tokens> listToken = new ArrayList<>();
    public ArrayList<Tokens> getTokens() {
         /*Retrofit retrofit = APIService.getInstance();
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
        return Tokens;*/
        listToken=new ArrayList<>();
        Tokens t1=new Tokens(1,"abc1","2023-05-16","2023-01-12",1);
        Tokens t2=new Tokens(1,"abc2","2023-05-16","2023-01-12",1);
        Tokens t3=new Tokens(1,"abc3","2023-05-16","2023-01-12",1);
        Tokens t4=new Tokens(1,"abc4","2023-05-16","2023-01-12",1);
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

