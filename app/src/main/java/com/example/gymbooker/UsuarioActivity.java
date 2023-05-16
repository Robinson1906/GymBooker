package com.example.gymbooker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.gymbooker.Class.Tokens;
import com.example.gymbooker.Class.User;
import com.example.gymbooker.Helpers.HelperToken;

public class UsuarioActivity extends AppCompatActivity {
    private User u;
    private TextView txtname,txtcc,txtfechanacimiento,txttelefono,txttotalreservas,txttoken,txtexpiracion;
    private Tokens token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);


        Intent i= getIntent();
        u= (User) i.getSerializableExtra("user");

        txtname=findViewById(R.id.txtNameUser);
        txtcc=findViewById(R.id.txrCedulaUser);
        txtfechanacimiento=findViewById(R.id.txtFechaUser);
        txttelefono=findViewById(R.id.txtTelefonoUser);
        txttotalreservas=findViewById(R.id.txtReservasUser);
        txttoken=findViewById(R.id.txtTokenUser);
        txtexpiracion=findViewById(R.id.txtTokenExpireUser);

        txtname.setText(u.getNombre());
        txtcc.setText(String.valueOf(u.getCedula()));
        txtfechanacimiento.setText(u.getFechaNacimiento());
        txttelefono.setText(u.getTelefono());
        //txtTotalReservas.setText(u.getNombre());

        getToken();
        if (token!=null){
            txttoken.setText(token.getTheToken());
            txtexpiracion.setText(token.getfVencimiento());
        }else{
            txttoken.setText("");
            txtexpiracion.setText("");
        }


    }

    public void getToken(){
        HelperToken helperToken =new HelperToken();
        token= helperToken.getTokenByToken(u.getToken());
    }



    }
