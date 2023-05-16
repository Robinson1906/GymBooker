package com.example.gymbooker;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView txtNombre,txtRegistro,txtCorreo,txtCedula,txtFnacimiento;
    private Button btmContinuar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        txtNombre = findViewById(R.id.txtnombre);
        txtRegistro = findViewById(R.id.txtRegistro);
        txtCorreo = findViewById(R.id.txtCorreo);
        txtCedula = findViewById(R.id.txtCedula);
        txtFnacimiento = findViewById(R.id.txtFnacimiento);


        Bundle b= getIntent().getExtras();
        Boolean b1=b.getBoolean("admin");

        if(b1){

        }else{

        }

    }
}