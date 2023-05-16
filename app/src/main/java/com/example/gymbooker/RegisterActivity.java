package com.example.gymbooker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.gymbooker.Class.User;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.ReservaService;
import com.example.gymbooker.RetroFit.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    private Button registrar;
    private ImageButton back;
    private EditText nombre,cedula,correo,telefono,nacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registrar=findViewById(R.id.btn_registrar);
        back=findViewById(R.id.back_register);
        nombre=findViewById(R.id.ed_nombre);
        cedula=findViewById(R.id.ed_cedula);
        correo=findViewById(R.id.ed_correo);
        telefono=findViewById(R.id.ed_telefono);
        nacimiento=findViewById(R.id.ed_nacimiento);

        Bundle b= getIntent().getExtras();
        Boolean b1=b.getBoolean("admin");

        if(b1){

        }else{

        }

        back.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backing = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(backing);
            }
        });

    }

    public void registrar(View view){
        User u = new User();
        u.setNombre(nombre.getText().toString());
        u.setCedula(Long.parseLong(cedula.getText().toString()));
        u.setCorreo((correo.getText().toString()));
        u.setIsAdmin(0);
        u.setTelefono(telefono.getText().toString());
        u.setFechaNacimiento(nacimiento.getText().toString());
        u.setToken("");

        Retrofit myRetro = APIService.getInstance();
        UserService myUserService = myRetro.create(UserService.class);

        myUserService.postAll(u).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }
}