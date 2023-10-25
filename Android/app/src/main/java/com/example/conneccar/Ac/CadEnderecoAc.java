package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.conneccar.R;
import com.example.conneccar.services.EnderecoService;

import org.json.JSONArray;
import org.json.JSONObject;


public class CadEnderecoAc extends AppCompatActivity {

    EditText edCep, edUF, edCidade, edBairro, edRua, edNumero, edComplemento;
    Button btCadEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_endereco);
        getSupportActionBar().hide();

        String idUsuario = getIntent().getStringExtra("id");

        edCep = findViewById(R.id.edCep);
        edUF = findViewById(R.id.edUf);
        edCidade = findViewById(R.id.edCidade);
        edBairro = findViewById(R.id.edBairro);
        edRua = findViewById(R.id.edRua);
        edNumero = findViewById(R.id.edNumero);
        edComplemento = findViewById(R.id.edComplemento);
        btCadEndereco = findViewById(R.id.btnCadEndereco);

        Intent HomeIntent = new Intent(getApplicationContext(), HomeAc.class);

        btCadEndereco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EnderecoService enderecoService = new EnderecoService(CadEnderecoAc.this);

                /*enderecoService.enderecoCadastro(Integer.parseInt(idUsuario), edCep.getText().toString(), edUF.getText().toString(), edCidade.getText().toString(), edBairro.getText().toString(), edRua.getText().toString(), edNumero.getText().toString(), edComplemento.getText().toString(), new EnderecoService.VolleyResponseListener() {
                            @Override
                            public void onError(String message) {
                                Toast.makeText(CadEnderecoAc.this, message, Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onResponse(JSONArray response) {
                                startActivity(HomeIntent);
                            }
                        });*/

                enderecoService.getCep(edCep.getText().toString(), new EnderecoService.VolleyResponseListenerObject() {
                    @Override
                    public void onError(String message) {
                        Toast.makeText(CadEnderecoAc.this, message, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(JSONObject response) {

                        response.toString();

                        String uf = null;
                        String cidade = null;
                        String bairro = null;
                        String rua = null;
                        for (int i = 0; i < response.length(); i++) {
                            uf = "";
                            cidade = "";
                            bairro = "";
                            rua = "";

                            try {
                                uf = response.getString("state");
                                cidade = response.getString("city");
                                bairro = response.getString("neighborhood");
                                rua = response.getString("street");
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }

                            Toast.makeText(CadEnderecoAc.this, rua, Toast.LENGTH_LONG).show();

                        }
                    }
                });

            }
        });



    }
}