package com.example.gymbooker;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private TextView txtnombre,txttelefono,txtcorreo,txtcedula,txtfnacimiento;
    private Button btmcontinuar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        txtnombre = findViewById(R.id.txtnombre);
        txttelefono = findViewById(R.id.txtTelefono);
        txtcorreo = findViewById(R.id.txtCorreo);
        txtcedula = findViewById(R.id.txtCedula);
        txtfnacimiento = findViewById(R.id.txtFnacimiento);


        Bundle b= getIntent().getExtras();
        Boolean b1=b.getBoolean("admin");

        if(b1){

        }else{

        }

    }
}