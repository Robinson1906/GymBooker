package com.example.gymbooker.Recyclers;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gymbooker.Adapters.UsersAdapter;
import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Class.User;
import com.example.gymbooker.Helpers.HelperPersona;
import com.example.gymbooker.MainActivity;
import com.example.gymbooker.R;
import com.example.gymbooker.UsuarioActivity;

import java.lang.reflect.Array;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {

    private ArrayList<User> listUser;

    private RecyclerView recyclerView;
    private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        recyclerView=findViewById(R.id.rvUsers);
        back=findViewById(R.id.back_users);
        LoadData();

        UsersAdapter adapter = new UsersAdapter(listUser);
        adapter.setOnItemClickListener(new UsersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User u, int posicion) {
               AlertDialog.Builder builder = new AlertDialog.Builder(UsersActivity.this);
                builder.setTitle(u.getNombre().toString())
                        .setItems(R.array.opciones, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item
                                Class c = ReservasActivity.class;
                                Intent j= new Intent(UsersActivity.this,c);

                                Boolean historial=false;
                                if(which==0) {
                                    c = ReservasActivity.class;
                                    historial = true;
                                }else if(which==1) {
                                    c = ReservasActivity.class;
                                    historial = false;
                                }else if(which==2) {
                                    c = UsuarioActivity.class;
                                    j.putExtra("user",u);
                                    historial = false;
                                }
                                j.setClass(UsersActivity.this,c);
                                j.putExtra("historial",historial);
                                startActivity(j);
                            }
                        });
                builder.create();
                builder.show();


            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        back.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backing = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(backing);
            }
        });
    }



    public void LoadData(){
        HelperPersona helperPersona=new HelperPersona();
        listUser=helperPersona.getUser();
    }
}