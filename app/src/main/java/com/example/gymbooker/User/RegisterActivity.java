package com.example.gymbooker.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gymbooker.MainActivity;
import com.example.gymbooker.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private SharedPreferences preferences;

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
    }

    public void onClickGuardar(View view){
        HelperPersona bInstance = new HelperPersona();
        User u = new User();
        u.setNombre(txtnombre.getText().toString());
        u.setTelefono(txttelefono.getText().toString());
        u.setCedula(txtcedula.getText().toString());
        u.setFechaNacimiento(txtfnacimiento.getText().toString());
        int response=bInstance.guardarPersona(u);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        u.setCorreo(txtcorreo.getText().toString()) ;
        ActionCodeSettings actionCodeSettings = ActionCodeSettings.newBuilder()
                .setAndroidPackageName("com.example.yourapp", true, null)
                .setHandleCodeInApp(true)
                .setUrl("https://gymbooker-c78de.firebaseapp.com/__/auth/action?mode=action&oobCode=code")
                .build();
        auth.sendSignInLinkToEmail(String.valueOf(txtcorreo), actionCodeSettings)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("Confirmacion", "Enlace de inicio de sesión enviado.");
                            // Realiza las acciones adicionales después de enviar el enlace
                        } else {
                            Log.e("Confirmacion", "Error al enviar el enlace de inicio de sesión.", task.getException());
                        }
                    }
                });

        if(response==200){
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            preferences=getSharedPreferences("gym-booker",MODE_PRIVATE);
            SharedPreferences.Editor editor= preferences.edit();
            editor.putInt("logged",1);
            editor.putString("ccUsuario",u.getCedula());
            editor.apply();
            Intent i=new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(i);

        }else if(response==201){
            Toast.makeText(this, "Error al Conectar", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "No carga", Toast.LENGTH_SHORT).show();
        }

    }
}