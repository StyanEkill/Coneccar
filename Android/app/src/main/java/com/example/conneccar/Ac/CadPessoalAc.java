package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conneccar.R;
import com.example.conneccar.services.UsuarioService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CadPessoalAc extends AppCompatActivity {

    EditText edNome, edCpf, edEmail, edIdade, edSenha, edConfirmSenhha;
    Button btCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_pessoal);

        getSupportActionBar().hide();

        edNome = findViewById(R.id.edNome);
        edCpf = findViewById(R.id.edCpf);
        edEmail = findViewById(R.id.edEmail);
        edIdade = findViewById(R.id.edIdade);
        edSenha = findViewById(R.id.edSenha);
        edConfirmSenhha = findViewById(R.id.edConfirmSenha);
        btCadastro = findViewById(R.id.btnCadPessoal);

        btCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsuarioService usuarioService = new UsuarioService(CadPessoalAc.this);

                if(edSenha.getText().toString().equals(edConfirmSenhha.getText().toString())) {

                    usuarioService.usuarioCadastro(edNome.getText().toString(),edCpf.getText().toString(),edEmail.getText().toString(),edIdade.getText().toString(),edSenha.getText().toString()
                            , new UsuarioService.VolleyResponseListener() {
                                @Override

                                public void onError(String message) {
                                    Toast.makeText(CadPessoalAc.this, message, Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onResponse(JSONArray response) {
                                    for (int i = 0; i < response.length(); i++) {
                                        String id = "";

                                        try {
                                            JSONObject user = response.getJSONObject(0);
                                            id = user.getString("id");
                                            System.out.println(id);
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }

                                    }

                                    System.out.println(response);
                                    //Toast.makeText(CadPessoalAc.this, ""+ response.toString(), Toast.LENGTH_LONG).show();
                                }
                            });
                } else {
                    Toast.makeText(CadPessoalAc.this, "As senhas não conferem", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}