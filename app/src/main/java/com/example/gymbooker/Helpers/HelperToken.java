package com.example.gymbooker.Helpers;

import com.example.gymbooker.Class.Tokens;

import java.util.ArrayList;

public class HelperToken {
    private ArrayList<Tokens> listToken;

    public void getTokens(){
        //listToken=...

        //metodo para traer los tokens desde Apex
        //la clase Tokens esta ya creada, trae los tokens y los almacena en el Array listToken

    }

    //Metodo que llama la lista de tokens y busca segun el token indicado
    public Tokens getTokenByToken(String token){
        getTokens();
        for (Tokens j:
             listToken) {
            if(token==j.getTheToken()){
                return j;
            }
        }
        return null;
    }
}

