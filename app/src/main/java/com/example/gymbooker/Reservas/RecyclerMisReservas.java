package com.example.gymbooker.Reservas;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.gymbooker.R;

import java.util.ArrayList;

public class RecyclerMisReservas extends AppCompatActivity {

    private ArrayList<Reserva> ListaReservas;
    private RecyclerView rvReservas;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_mis_reservas);
        setTitle("Mis Reservas");
        LoadData();
        rvReservas = findViewById(R.id.rv_reservas);
        CustomAdapter myAdapter = new CustomAdapter(ListaReservas);

        myAdapter.setOnItemClickListener(new CustomAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Reserva myres, int posicion) {
                Intent intent = new Intent(RecyclerMisReservas.this,Reserva.class);
                intent.putExtra("Reserva",myres);
                startActivity(intent);
            }
            @Override
            public void onItemBtnClick(Reserva myres, int posicion) {
                ListaReservas.remove(posicion);
                myAdapter.setDataSet(ListaReservas);
                Toast.makeText(RecyclerMisReservas.this,"hola", Toast.LENGTH_SHORT).show();
            }
        });

        rvReservas.setAdapter(myAdapter);
        rvReservas.setLayoutManager(new LinearLayoutManager(this));
    }

    public void LoadData(){
        Reserva res1 = new Reserva("02/05/23","Espalda",1600,1800);
        Reserva res2 = new Reserva("08/05/23","Abdomen",900,1100);

        ListaReservas = new ArrayList<>();
        ListaReservas.add(res1);
        ListaReservas.add(res2);
    }
}