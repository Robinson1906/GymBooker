package com.example.gymbooker;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class AgendarActivity extends AppCompatActivity {

    private EditText txtRutina,TxtHora1,TxtHora2,TxtFecha;
    private Button Agendar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_agendar);

        txtRutina = findViewById(R.id.txtRutina);
        TxtHora1 = findViewById(R.id.TxtHora1);
        TxtHora2 = findViewById(R.id.TxtHora2);
        TxtFecha = findViewById(R.id.TxtFecha);

    }
}