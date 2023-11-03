package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.conneccar.R;

public class DirecaoRedirect extends AppCompatActivity {

    Button btnDirecao, btnRedHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direcao_redirect);

        getSupportActionBar().hide();

        btnDirecao = findViewById(R.id.btnDirecao);
        btnRedHome = findViewById(R.id.btnredHome);

        String idUsuario = getIntent().getStringExtra("id");

        btnDirecao.setOnClickListener(new View.OnClickListener() {
            Intent cadDirecaoIntent = new Intent(getApplicationContext(), CadDirecaoAc.class);
            @Override
            public void onClick(View view) {
                cadDirecaoIntent.putExtra("id", idUsuario);
                startActivity(cadDirecaoIntent);
                startActivity(cadDirecaoIntent);
            }
        });

        btnRedHome.setOnClickListener(new View.OnClickListener() {
            Intent homeIntent = new Intent(getApplicationContext(), HomeAc.class);
            @Override
            public void onClick(View view) {
                homeIntent.putExtra("id", idUsuario);
                startActivity(homeIntent);
                startActivity(homeIntent);
            }
        });

    }
}