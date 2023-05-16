package com.example.gymbooker.Recyclers;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gymbooker.Adapters.ReservasDiaAdapter;
import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Helpers.HelperFecha;
import com.example.gymbooker.Helpers.HelperReservas;
import com.example.gymbooker.R;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class ReservasDiaActivity extends AppCompatActivity {
    private ArrayList<Reserva> ListaReservas, listaFinal;
    private RecyclerView rvReservas;
    private EditText fechadia;
    private String fechaElegida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_dia);
        HelperFecha helperFecha = new HelperFecha();
        fechaElegida = helperFecha.getFechaActual().toString();
        listaFinal = new ArrayList<>();
        LoadData();
        fechadia = findViewById(R.id.fechaElegidaDia);
        fechadia.setText(fechaElegida);

    }

    @Override
    protected void onStart() {
        super.onStart();
        rvReservas = findViewById(R.id.rvReservasDia);


        ReservasDiaAdapter myAdapter = new ReservasDiaAdapter(listaFinal);

        myAdapter.setOnItemClickListener(new ReservasDiaAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Reserva myres, int posicion) {
                Intent intent = new Intent(ReservasDiaActivity.this, Reserva.class);
                intent.putExtra("Reserva", myres);
                startActivity(intent);
            }

            @Override
            public void onItemBtnAsisteClick(Reserva myres, int posicion) {
                ListaReservas.remove(posicion);
                myAdapter.setDataSet(ListaReservas);
                //TODO acciones al marcar asistido
                Toast.makeText(ReservasDiaActivity.this, "Asistido", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemBtnCancelaClick(Reserva myprod, int posicion) {
                ListaReservas.remove(posicion);
                myAdapter.setDataSet(ListaReservas);
                //TODO acciones al marcar cancelado
                Toast.makeText(ReservasDiaActivity.this, "Cancelado", Toast.LENGTH_SHORT).show();
            }
        });

        rvReservas.setAdapter(myAdapter);
        rvReservas.setLayoutManager(new LinearLayoutManager(this));
    }


    public void LoadData() {

        HelperReservas helperReservas = new HelperReservas();
        ListaReservas = helperReservas.getReserva();
        for (Reserva r :
                ListaReservas) {
            if (r.getFecha().equals(fechaElegida)) {
                listaFinal.add(r);
            }

        }

    }

}
