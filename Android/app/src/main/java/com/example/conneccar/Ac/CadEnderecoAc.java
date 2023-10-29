package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

        edCep.addTextChangedListener(new TextWatcher() {

            String uf = "";
            String cidade = "";
            String bairro = "";
            String rua = "";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {

                System.out.println(editable.toString().length());
                EnderecoService enderecoService = new EnderecoService(CadEnderecoAc.this);

                if (editable.toString().length() == 8) {

                    enderecoService.getCep(editable.toString(), new EnderecoService.VolleyResponseListenerObject() {

                        @Override
                        public void onError(String message) {
                            Toast.makeText(CadEnderecoAc.this, message, Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onResponse(JSONObject response) {
                            System.out.println(response);
                                try {
                                    uf = response.getString("state");
                                    cidade = response.getString("city");
                                    bairro = response.getString("neighborhood");
                                    rua = response.getString("street");
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }

                            System.out.println(rua);
                            edUF.setText(uf.toString());
                            edCidade.setText(cidade.toString());
                            edBairro.setText(bairro.toString());
                            edRua.setText(rua.toString());

                        }
                    });

                } else {
                    edUF.setText("");
                    edCidade.setText("");
                    edBairro.setText("");
                    edRua.setText("");
                }
            }
        });


        btCadEndereco.setOnClickListener(new View.OnClickListener() {

            Intent HomeIntent = new Intent(getApplicationContext(), HomeAc.class);

            @Override
            public void onClick(View view) {

                String cep = edCep.getText().toString();
                String uf = edUF.getText().toString();
                String cidade = edCidade.getText().toString();
                String bairro = edBairro.getText().toString();
                String rua = edRua.getText().toString();
                String numero = edNumero.getText().toString();
                String complemento = edComplemento.getText().toString();

                EnderecoService enderecoService = new EnderecoService(CadEnderecoAc.this);

                if(validarInfo(cep,uf,cidade,bairro,rua,numero) == true) {

                    enderecoService.enderecoCadastro(Integer.parseInt(idUsuario), cep, uf, cidade, bairro, rua, numero, complemento, new EnderecoService.VolleyResponseListener() {
                        @Override
                        public void onError(String message) {
                            showToast(message);
                        }

                        @Override
                        public void onResponse(JSONArray response) {
                            startActivity(HomeIntent);
                        }
                    });
                }
            }
        });
    }

    private boolean validarInfo(String cep, String uf, String cidade, String bairro, String rua, String numero) {

        if(cep.length() == 0){
            edCep.requestFocus();
            edCep.setError("O campo não pode estar vazio");
            return false;
        } else if (cep.length() < 8 || cep.length() > 8) {
            edCep.requestFocus();
            edCep.setError("CEP invalido");
            return false;
        } else if (uf.length() == 0) {
            edUF.requestFocus();
            edUF.setError("O campo não pode estar vazio");
            return false;
        } else if (cidade.length() == 0) {
            edCidade.requestFocus();
            edCidade.setError("O campo não pode estar vazio");
            return false;
        } else if (bairro.length() == 0) {
            edBairro.requestFocus();
            edBairro.setError("O campo não pode estar vazio");
            return false;
        } else if (rua.length() == 0) {
            edRua.requestFocus();
            edRua.setError("O campo não pode estar vazio");
            return false;
        } else if (numero.length() == 0) {
            edNumero.requestFocus();
            edNumero.setError("O campo não pode estar vazio");
            return false;
        } else {
            return true;
        }

    }

    private void showToast(String texto){
        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.base_1));
        TextView tvToast = layout.findViewById(R.id.tvToast);
        tvToast.setText(texto);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.TOP,0,100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }

}