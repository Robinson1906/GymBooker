package com.example.gymbooker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.gymbooker.Adapters.ReservasAdapter;

public class MainActivity extends AppCompatActivity {

    private Button agendar,misreservas,historial,configuraciones;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agendar=findViewById(R.id.btn_agendar);
        misreservas=findViewById(R.id.btn_registrar);
        historial=findViewById(R.id.btn_historial);
        back=findViewById(R.id.back_main);

        agendar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forward_Agendar = new Intent(getApplicationContext(),AgendarActivity.class);
                startActivity(forward_Agendar);
            }
        });

        misreservas.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forward_Reservas = new Intent(getApplicationContext(), ReservasAdapter.class);
                startActivity(forward_Reservas);
            }
        });

        historial.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent forward_Historial = new Intent(getApplicationContext(),ReservasAdapter.class);
                startActivity(forward_Historial);
            }
        });

        back.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backing = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(backing);
            }
        });

    }
}