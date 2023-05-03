package com.example.gymbooker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bundle b= getIntent().getExtras();
        Boolean b1=b.getBoolean("admin");

        if(b1){

        }else{

        }

    }
}