package com.example.gymbooker;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity{


    private EditText txtUser,txtPwd;
    private Button btnLogin;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        txtUser=findViewById(R.id.txtUser);
        txtPwd=findViewById(R.id.txtPwd);

    }

    public  void clickIniciar( View view){
        String PASS="12345";
        String USER= "Fabian";

        String passUser=txtPwd.getText().toString();
        String loginUser=txtUser.getText().toString();

        if (PASS.equals(passUser)&&USER.equals(loginUser)){
            SharedPreferences.Editor editor= preferences.edit();
            editor.putBoolean("logged",true);
            editor.putString("user","admin");
            editor.apply();
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        }else {
            Toast.makeText(this, "Ole mano, credenciales incorrectas", Toast.LENGTH_SHORT).show();
        }

    }
}