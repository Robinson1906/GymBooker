package com.example.gymbooker.Recyclers;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.gymbooker.Adapters.ReservasDiaAdapter;
import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Helpers.HelperReservas;
import com.example.gymbooker.R;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



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
        rvReservas = findViewById(R.id.rv_reservas);
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




        public class SepararFechas {
            //TODO gestionar la forma en que se seleccionaran las reservas que aparezcan
            public static void main(String[] args) {
                List<LocalDate> ListaReservas = new ArrayList<>();
                ListaReservas.add(LocalDate.of(2022, 1, 1));
                ListaReservas.add(LocalDate.of(2020, 12, 31));
                ListaReservas.add(LocalDate.of(2023, 5, 16));
                ListaReservas.add(LocalDate.of(2023, 6, 1));
                ListaReservas.add(LocalDate.of(2022, 6, 30));

                List<LocalDate> fechasPasadas = new ArrayList<>();
                List<LocalDate> fechasFuturas = new ArrayList<>();

                separarFechas(ListaReservas, fechasPasadas, fechasFuturas);

                if (fechasFuturas.isEmpty()) {
                    System.out.println("No hay fechas recientes en la lista de reservas.");
                } else {
                    System.out.println("Fechas pasadas:");
                    for (LocalDate fecha : fechasPasadas) {
                        System.out.println(fecha);
                    }

                    System.out.println("Fechas futuras:");
                    for (LocalDate fecha : fechasFuturas) {
                        System.out.println(fecha);
                    }
                }
            }

            public static void separarFechas(List<LocalDate> ListaReservas, List<LocalDate> fechasPasadas, List<LocalDate> fechasFuturas) {
                LocalDate fechaActual = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    fechaActual = LocalDate.now();
                }

                for (LocalDate fecha : ListaReservas) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        if (fecha.isBefore(fechaActual)) {
                            fechasPasadas.add(fecha);
                        } else {
                            fechasFuturas.add(fecha);
                        }
                    }
                }
            }
        }
    }
}