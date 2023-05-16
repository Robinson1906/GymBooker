package com.example.gymbooker.Recyclers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.gymbooker.Adapters.ReservasAdapter;
import com.example.gymbooker.Adapters.ReservasDiaAdapter;
import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Helpers.HelperReservas;
import com.example.gymbooker.R;

import java.util.ArrayList;

public class ReservasDiaActivity extends AppCompatActivity {
    private ArrayList<Reserva> ListaReservas;
    private RecyclerView rvReservas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas_dia);
        LoadData();

    }

    @Override
    protected void onStart() {
        super.onStart();
        rvReservas = findViewById(R.id.rvReservasDia);
        ReservasDiaAdapter myAdapter = new ReservasDiaAdapter(ListaReservas);

        myAdapter.setOnItemClickListener(new ReservasDiaAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Reserva myres, int posicion) {
                Intent intent = new Intent(ReservasDiaActivity.this,Reserva.class);
                intent.putExtra("Reserva",myres);
                startActivity(intent);
            }
            //Boton cancelar
            @Override
            public void onItemBtnAsisteClick(Reserva myres, int posicion) {
                ListaReservas.remove(posicion);
                myAdapter.setDataSet(ListaReservas);
                //TODO acciones al marcar asistido
                Toast.makeText(ReservasDiaActivity.this,"Asistido", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemBtnCancelaClick(Reserva myprod, int posicion) {
                ListaReservas.remove(posicion);
                myAdapter.setDataSet(ListaReservas);
                //TODO acciones al marcar cancelado
                Toast.makeText(ReservasDiaActivity.this,"Cancelado", Toast.LENGTH_SHORT).show();
            }
        });

        rvReservas.setAdapter(myAdapter);
        rvReservas.setLayoutManager(new LinearLayoutManager(this));
    }


    public void LoadData(){
        //TODO añadir conexion con base de datos
        HelperReservas helperReservas=new HelperReservas();
        ListaReservas=helperReservas.getReservas();

    }

    public void selecData(){
        //TODO gestionar la forma en que se seleccionaran las reservas que aparezcan
    }
}