package com.example.gymbooker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.gymbooker.Class.Tokens;
import com.example.gymbooker.Class.User;
import com.example.gymbooker.Helpers.HelperToken;

public class UsuarioActivity extends AppCompatActivity {
    private User u;
    private TextView txtName,txtCc,txtFechaNacimiento,txtTelefono,txtTotalReservas,txtToken,txtExpiracion;
    private Tokens token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        Intent i= getIntent();
        u= (User) i.getSerializableExtra("user");

        txtName=findViewById(R.id.txtNameUser);
        txtCc=findViewById(R.id.txrCedulaUser);
        txtFechaNacimiento=findViewById(R.id.txtFechaUser);
        txtTelefono=findViewById(R.id.txtTelefonoUser);
        txtTotalReservas=findViewById(R.id.txtReservasUser);
        txtToken=findViewById(R.id.txtTokenUser);
        txtExpiracion=findViewById(R.id.txtTokenExpireUser);

        txtName.setText(u.getNombre());
        txtCc.setText(u.getCedula());
        txtFechaNacimiento.setText(u.getFechaNacimiento());
        txtTelefono.setText(u.getTelefono());
        txtTotalReservas.setText(u.getNombre());

        getToken();
        txtToken.setText(token.getTheToken());
        txtExpiracion.setText(token.getfVencimiento());

    }

    public void getToken(){
        HelperToken helperToken =new HelperToken();
        token= helperToken.getTokenByToken(u.getToken());
    }
}