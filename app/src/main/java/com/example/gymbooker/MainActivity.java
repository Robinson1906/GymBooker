package com.example.gymbooker;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button AgendarM,MiEntreno,Historial,Confi;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AgendarM = findViewById(R.id.AgendarM);
        MiEntreno = findViewById(R.id.btmContinuar);
        Historial = findViewById(R.id.Historial);
        Confi = findViewById(R.id.Agendar);
    }
}