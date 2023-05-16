package com.example.gymbooker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gymbooker.Adapters.ReservasAdapter;
import com.example.gymbooker.Helpers.HelperFecha;
import com.example.gymbooker.Recyclers.ReservasActivity;

import com.example.gymbooker.Recyclers.ReservasActivity;
import com.example.gymbooker.Recyclers.ReservasDiaActivity;
import com.example.gymbooker.Recyclers.UsersActivity;

import java.time.LocalDate;

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
                Intent i=new Intent(MainActivity.this,AgendarActivity.class);
                startActivity(i);
            }
        });
        miEntreno = findViewById(R.id.btnGenerarToken);
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

            }
        });
        config= findViewById(R.id.btnConfig);
        generar.setOnClickListener(new View.OnClickListener() {
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
}