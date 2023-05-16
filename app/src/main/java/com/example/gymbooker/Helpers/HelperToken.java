package com.example.gymbooker.Helpers;

import com.example.gymbooker.Class.Tokens;

import java.util.ArrayList;

public class HelperToken {
    private ArrayList<Tokens> listToken;

    public void getTokens(){
        //todo traer tokens del api
        //temporal tokens
        Tokens t1= new Tokens(01,"0001abc","25/04/2005","27/05/2007",1);
        Tokens t2= new Tokens(01,"0002abc","25/04/2005","27/05/2007",1);
        Tokens t3= new Tokens(01,"0003abc","25/04/2005","27/05/2007",1);
        Tokens t4= new Tokens(01,"0004abc","25/04/2005","27/05/2007",1);

        listToken=new ArrayList<>();
        listToken.add(t1);
        listToken.add(t2);
        listToken.add(t3);
        listToken.add(t4);


        //listToken=...

        //metodo para traer los tokens desde Apex
        //la clase Tokens esta ya creada, trae los tokens y los almacena en el Array listToken

    }

    //Metodo que llama la lista de tokens y busca segun el token indicado
    public Tokens getTokenByToken(String token){
        getTokens();
        for (Tokens j:
             listToken) {
            if(j.getTheToken().equals(token)){
                return j;
            }
        }
        return null;
    }
}

