package com.example.gymbooker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymbooker.Reserva.AgendarActivity;
import com.example.gymbooker.Reserva.ReservasActivity;
import com.example.gymbooker.Reserva.ReservasDiaActivity;
import com.example.gymbooker.Tokens.HelperToken;
import com.example.gymbooker.Tokens.Tokens;
import com.example.gymbooker.User.UsersActivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;


    private Button agendar,miEntreno,historial,config,reservas,usuarios,generar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        preferences=getSharedPreferences("gym-booker",MODE_PRIVATE);
        if(preferences.getString("user","").equals("user")){
            setContentView(R.layout.activity_main);
            startUser();
        }else{
            setContentView(R.layout.activity_main_admin);
            startAdmin();
        }

    }


    private void startUser() {
        agendar = findViewById(R.id.btnReservasDia);
        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, AgendarActivity.class);
                startActivity(i);
            }
        });
        miEntreno = findViewById(R.id.btnMisEntrenamientos);
        miEntreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, ReservasActivity.class);
                i.putExtra("historial",false);
                startActivity(i);
            }
        });
        historial = findViewById(R.id.btnVerUsuarios);
        historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, ReservasActivity.class);
                i.putExtra("historial",true);
                startActivity(i);
            }
        });
    }

    private  void startAdmin(){
        generar=findViewById(R.id.btnGenerarToken);
        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token=null;
                HelperToken helperToken=new HelperToken();
                ArrayList<Tokens> listToken= helperToken.getTokens();
                do{
                    token=generarToken();
                }while (helperToken.getTokenByToken(token)!=null);
                HelperFecha helperFecha=new HelperFecha();
                Tokens t=new Tokens();
                t.setTheToken(token);
                t.setfCreacion(helperFecha.getFechaActual().toString());
                //todo cuadrar fechas con Dialog
                boolean isUnlimited=true;
                LocalDate date=null;
                if (isUnlimited){
                    t.isLimited(0);
                    t.setfVencimiento("null");
                }else {
                    t.isLimited(1);
                    t.setfVencimiento(date.toString());
                }

            }
        });
        config= findViewById(R.id.btnConfig);
        config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        usuarios= findViewById(R.id.btnVerUsuarios);
        usuarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, UsersActivity.class);
                startActivity(i);
            }
        });
        reservas= findViewById(R.id.btnReservasDia);
        reservas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, ReservasDiaActivity.class);
                startActivity(i);
            }
        });
    }
    private String generarToken(){
        String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";


        String cadena = "";
       for (int x = 0; x < 12; x++) {
           int indiceAleatorio = ThreadLocalRandom.current().nextInt(0, banco.length() + 1);
           char caracterAleatorio = banco.charAt(indiceAleatorio);
           cadena += caracterAleatorio;
       }
        return cadena;
    }

}