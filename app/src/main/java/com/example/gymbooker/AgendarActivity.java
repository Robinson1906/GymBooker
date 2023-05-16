package com.example.gymbooker;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Class.User;
import com.example.gymbooker.Helpers.HelperPersona;
import com.example.gymbooker.Helpers.HelperReservas;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.ReservaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AgendarActivity extends AppCompatActivity {
    EditText date, horainicial, horafinal, area;

    private EditText txtrutina,txthora1,txthora2,txtfecha;
    private Button agendar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_agendar);

        txtrutina = findViewById(R.id.txtrutina);
        txthora1 = findViewById(R.id.txthora1);
        txthora1 = findViewById(R.id.txthora2);
        txtfecha = findViewById(R.id.txtfecha);
        agendar = findViewById(R.id.btn_agendar);


    }
    public void guardar(View view){
        HelperReservas bInstance = new HelperReservas();
        Reserva r = new Reserva();
        r.setFecha(date.getText().toString());
        r.setHoraIngreso(Integer.parseInt(horainicial.getText().toString()));
        r.setHoraSalida(Integer.parseInt(horafinal.getText().toString()));
        r.setRutina(area.getText().toString());
        r.setDuracion(r.getHoraSalida()-r.getHoraIngreso());
        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bInstance.guardarReserva(r);
            }
        });

    }

    private class RetroFit {
    }
}