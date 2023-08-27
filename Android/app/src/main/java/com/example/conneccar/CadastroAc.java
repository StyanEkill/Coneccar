package com.example.conneccar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CadastroAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        getSupportActionBar().hide();

    }
}