package com.example.conneccar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RedirectAc extends AppCompatActivity {

    private TextView btLogin;
    private TextView btCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);

        getSupportActionBar().hide();

        btLogin = findViewById(R.id.btLogin);
        btCadastro = findViewById(R.id.btCadastro);

        Intent LoginIntent = new Intent(getApplicationContext(),LoginAc.class);
        Intent Cadastrontent = new Intent(getApplicationContext(),CadastroAc.class);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(LoginIntent);
            }
        });

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Cadastrontent);
            }
        });

    }



}