package com.example.gymbooker;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Class.User;
import com.example.gymbooker.Helpers.HelperPersona;

public class RegisterActivity extends AppCompatActivity {

    private TextView txtnombre,txttelefono,txtcorreo,txtcedula,txtfnacimiento;
    private Button btmcontinuar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        txtnombre = findViewById(R.id.ed_nombre);
        txttelefono = findViewById(R.id.ed_telefono);
        txtcorreo = findViewById(R.id.ed_correo);
        txtcedula = findViewById(R.id.ed_cedula);
        txtfnacimiento = findViewById(R.id.ed_nacimiento);
        btmcontinuar = findViewById(R.id.btn_registrar);


        Bundle b = getIntent().getExtras();
        Boolean b1 = b.getBoolean("admin");

        if (b1) {

        } else {

        }
    }

    public void onClicGuardar(View view){

        HelperPersona bInstance = new HelperPersona();
        User u = new User();
        u.setNombre(txtnombre.getText().toString());
        u.setTelefono(txttelefono.getText().toString());
        u.setCorreo(txtcorreo.getText().toString());
        u.setCedula(txtcedula.getText().toString());
        u.setFechaNacimiento(txtfnacimiento.getText().toString());
        btmcontinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bInstance.guardarPersona(u);
            }
        });
    }
}