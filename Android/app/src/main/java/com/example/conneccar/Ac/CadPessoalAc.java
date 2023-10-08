package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conneccar.R;
import com.example.conneccar.services.UsuarioService;

public class CadPessoalAc extends AppCompatActivity {

    Button btCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pessoal);

        getSupportActionBar().hide();

        btCadastro = findViewById(R.id.btnCadPessoal);

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioService usuarioService = new UsuarioService(CadPessoalAc.this);

                usuarioService.usuarioCadastro(new UsuarioService.VolleyResponseListener() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(CadPessoalAc.this, "ERRO", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(Object response) {
                        Toast.makeText(CadPessoalAc.this, "FOI", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });


    }
}