package com.example.gymbooker;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.RetroFit.APIService;
import com.example.gymbooker.RetroFit.ReservaService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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


    }
    public void guardar(View view){
        Reserva r = new Reserva();
        r.setFecha(date.getText().toString());
        r.setHoraIngreso(Integer.parseInt(horainicial.getText().toString()));
        r.setHoraSalida(Integer.parseInt(horafinal.getText().toString()));
        r.setRutina(area.getText().toString());
        r.setDuracion(r.getHoraSalida()-r.getHoraIngreso());

        RetroFit myRetro = APIService.getInstance();
        ReservaService myReservaService = myRetro.create(ReservaService.class);

        myReservaService.postAll(r).enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Toast.makeText(AgendarActivity.this, "nice", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Toast.makeText(AgendarActivity.this, "ñao ñao", Toast.LENGTH_SHORT).show();
            }
        });

    }
}