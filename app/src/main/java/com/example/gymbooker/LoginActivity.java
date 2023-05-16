package com.example.gymbooker;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gymbooker.Helpers.HelperToken;

public class LoginActivity extends AppCompatActivity{


    private EditText txtuser;
    private Button btnlogin;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        txtuser=findViewById(R.id.txtTokenLogin);
        preferences=getSharedPreferences("gym-booker",MODE_PRIVATE);
        if (preferences.getBoolean("logged",false)){
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);
            finish();
        }




    }

    public  void clickIniciar( View view){

        HelperToken helperToken =new HelperToken();


        String loginUser=txtuser.getText().toString();

        if (helperToken.getTokenByToken(loginUser)!=null){
                SharedPreferences.Editor editor= preferences.edit();
                editor.putBoolean("logged",true);
                editor.putString("user","user");
                editor.apply();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }else {
            Toast.makeText(this, "Token Invalido", Toast.LENGTH_SHORT).show();
        }

    }

    public void clickRegistro(View view){
        SharedPreferences.Editor editor= preferences.edit();
        editor.putBoolean("logged",true);
        editor.putString("user","admin");
        editor.apply();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void dialogToken(View view){
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage(R.string.explicacion_token).setTitle(R.string.token)
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        builder.show();
    }
}