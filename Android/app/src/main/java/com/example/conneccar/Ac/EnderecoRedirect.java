package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.conneccar.R;

public class EnderecoRedirect extends AppCompatActivity {

    Button btnEndereco, btnRedDirecao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco_redirect);

        getSupportActionBar().hide();

        btnEndereco = findViewById(R.id.btnEndereco);
        btnRedDirecao = findViewById(R.id.btnRedDirecao);

        String idUsuario = getIntent().getStringExtra("id");

        btnEndereco.setOnClickListener(new View.OnClickListener() {
            Intent cadEnderecoIntent = new Intent(getApplicationContext(), CadEnderecoAc.class);
            @Override
            public void onClick(View view) {
                cadEnderecoIntent.putExtra("id", idUsuario);
                startActivity(cadEnderecoIntent);
                startActivity(cadEnderecoIntent);
            }
        });

        btnRedDirecao.setOnClickListener(new View.OnClickListener() {
            Intent redDirecaoIntent = new Intent(getApplicationContext(), DirecaoRedirect.class);
            @Override
            public void onClick(View view) {
                redDirecaoIntent.putExtra("id", idUsuario);
                startActivity(redDirecaoIntent);
                startActivity(redDirecaoIntent);
            }
        });



    }



}