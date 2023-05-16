package com.example.gymbooker;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.ReservaService;

import java.security.interfaces.RSAKey;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AgendarActivity extends AppCompatActivity {
    EditText date, horainicial, horafinal, area;


    private Button Agendar;
    private ImageView back;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_agendar);


        area = findViewById(R.id.txtRutina);
        horainicial = findViewById(R.id.TxtHora1);
        horafinal = findViewById(R.id.TxtHora2);
        date= findViewById(R.id.TxtFecha);


        back.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backing = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(backing);
            }
        });
    }
    public void guardar(View view){
        Reserva r = new Reserva();
        r.setFecha(date.getText().toString());
        r.setHoraIngreso(Integer.parseInt(horainicial.getText().toString()));
        r.setHoraSalida(Integer.parseInt(horafinal.getText().toString()));
        r.setId_area(Integer.parseInt(area.getText().toString()));
        r.setDuracion(r.getHoraSalida()-r.getHoraIngreso());

        Retrofit myRetro = APIService.getInstance();
        ReservaService myReservaService = myRetro.create(ReservaService.class);

        myReservaService.postAll(r).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Toast.makeText(AgendarActivity.this, "nice", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(AgendarActivity.this, "ñao ñao", Toast.LENGTH_SHORT).show();
            }
        });

    }
}