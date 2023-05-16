package com.example.gymbooker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gymbooker.Adapters.ReservasAdapter;
import com.example.gymbooker.Recyclers.ReservasActivity;

public class MainActivity extends AppCompatActivity {


    private Button AgendarM,MiEntreno,Historial,Confi;
    private ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AgendarM = findViewById(R.id.AgendarM);
        MiEntreno = findViewById(R.id.btmContinuar);
        Historial = findViewById(R.id.Historial);
        Confi = findViewById(R.id.Agendar);

        AgendarM.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forward_Agendar = new Intent(getApplicationContext(),AgendarActivity.class);
                startActivity(forward_Agendar);
            }
        });

        MiEntreno.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forward_Reservas = new Intent(getApplicationContext(), ReservasActivity.class);
                startActivity(forward_Reservas);
            }
        });

        Historial.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forward_Historial = new Intent(getApplicationContext(),ReservasAdapter.class);
                startActivity(forward_Historial);
            }
        });

    }
}