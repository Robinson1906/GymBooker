package com.example.gymbooker.Tokens;

import java.util.ArrayList;

public class HelperToken {
    ArrayList<Tokens> listToken = new ArrayList<>();
    public ArrayList<Tokens> getTokens() {

        Tokens t1=new Tokens(101,1,"abc1","2023-01-12","2023-05-16",false);
        Tokens t2=new Tokens(102,1,"abc2","2023-01-12","2023-05-16",false);
        Tokens t3=new Tokens(103,1,"abc3","2023-01-12","2023-05-16",false);
        Tokens t4=new Tokens(104,1,"abc4","2023-01-12","2023-05-16",false);
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

