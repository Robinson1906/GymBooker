package com.example.gymbooker;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Helpers.HelperPersona;
import com.example.gymbooker.Helpers.HelperReservas;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.ReservaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AgendarActivity extends AppCompatActivity {
       private EditText txtrutina,txthora1,txthora2,txtfecha;
    private Button agendar;
    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_agendar);


        txtrutina = findViewById(R.id.txtrutina);
        txthora1 = findViewById(R.id.txthora1);
        txthora2 = findViewById(R.id.txthora2);
        txtfecha = findViewById(R.id.txtfecha);
        back=findViewById(R.id.back_agendar);





        back.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backing = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(backing);
            }
        });
    }
    public void guardar(View view){
        //TODO verificar que la creacion sea correcta
        Reserva r = new Reserva();
        r.setFecha(txtfecha.getText().toString());
        r.setHoraIngreso(Integer.parseInt(txthora1.getText().toString()));
        r.setHoraSalida(Integer.parseInt(txthora2.getText().toString()));

        r.setDuracion(r.getHoraSalida()-r.getHoraIngreso());

        HelperReservas helperReservas =new HelperReservas();
        helperReservas.guardarReserva(r);

    }

    private class RetroFit {
    }
}