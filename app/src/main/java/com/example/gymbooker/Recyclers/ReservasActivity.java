package com.example.gymbooker.Recyclers;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.gymbooker.Adapters.ReservasAdapter;
import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Helpers.HelperReservas;
import com.example.gymbooker.R;

import java.util.ArrayList;

public class ReservasActivity extends AppCompatActivity {

    private ArrayList<Reserva> ListaReservas,listaFinal;
    private RecyclerView rvReservas;
    private int b= View.VISIBLE;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservas);

        LoadData();

        Intent i = getIntent();
        Boolean historial= i.getBooleanExtra("historial",false);
        if (historial){
            b=View.INVISIBLE;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        rvReservas = findViewById(R.id.rv_reservas);
        ReservasAdapter myAdapter = new ReservasAdapter(ListaReservas,b);

        myAdapter.setOnItemClickListener(new ReservasAdapter.onItemClickListener() {
            @Override
            public void onItemClick(Reserva myres, int posicion) {
                Intent intent = new Intent(ReservasActivity.this,Reserva.class);
                intent.putExtra("Reserva",myres);
                startActivity(intent);
            }
            //Boton cancelar
            @Override
            public void onItemBtnClick(Reserva myres, int posicion) {
                ListaReservas.remove(posicion);
                myAdapter.setDataSet(ListaReservas);
                Toast.makeText(ReservasActivity.this,"hola", Toast.LENGTH_SHORT).show();
            }
        });

        rvReservas.setAdapter(myAdapter);
        rvReservas.setLayoutManager(new LinearLayoutManager(this));
    }

    public void LoadData(){
        HelperReservas helperReservas= new HelperReservas();
        ListaReservas=helperReservas.getReservas();
    }

    public void mandarAHistorial(){
        //Todo separara cuando se mandaran a historial
    }
}