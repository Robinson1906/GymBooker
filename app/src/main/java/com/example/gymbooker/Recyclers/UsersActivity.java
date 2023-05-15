package com.example.gymbooker.Recyclers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gymbooker.Adapters.UsersAdapter;
import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Class.User;
import com.example.gymbooker.MainActivity;
import com.example.gymbooker.R;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {

    private ArrayList<User> listUser;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        recyclerView=findViewById(R.id.rvUsers);
        LoadData();

        UsersAdapter adapter = new UsersAdapter(listUser);
        adapter.setOnItemClickListener(new UsersAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(User u, int posicion) {
                Intent i = new Intent(UsersActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void LoadData(){
        User u1 = new User(1097608514,"Espalda",true,"faherme46@gmail.com","318","27/05/07","T1");
        User u2 = new User(1097608514,"Abdomen",true,"faherme46@gmail.com","318","27/05/07","T1");
        User u3 = new User(1097608514,"Abdomen",true,"faherme46@gmail.com","318","27/05/07","T1");

        listUser = new ArrayList<>();
        listUser.add(u1);
        listUser.add(u2);
        listUser.add(u3);
    }
}