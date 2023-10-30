package com.example.conneccar.Ac;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conneccar.services.UsuarioService;
import com.example.conneccar.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class CadPessoalAc extends AppCompatActivity {

    EditText edNome, edCpf, edEmail, edIdade, edSenha, edConfirmSenhha;
    Button btCadPessoal;

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
        btCadPessoal = findViewById(R.id.btnCadPessoal);

        btCadPessoal.setOnClickListener(new View.OnClickListener() {

            Intent cadEndereco = new Intent(getApplicationContext(),CadEnderecoAc.class);
            @Override
            public void onClick(View view) {

                String nome = edNome.getText().toString();
                String cpf = edCpf.getText().toString();
                String email = edEmail.getText().toString();
                String idade = edIdade.getText().toString();
                String senha = edSenha.getText().toString();
                String confirmSenhha = edConfirmSenhha.getText().toString();

                UsuarioService usuarioService = new UsuarioService(CadPessoalAc.this);

                if(validarInfo(nome,cpf,email,idade,senha, confirmSenhha) == true) {

                        usuarioService.usuarioCadastro(nome, cpf, email, idade, senha
                                , new UsuarioService.VolleyResponseListener() {
                                    @Override

                                    public void onError(String message) {
                                        System.out.println(message);
                                        showToast(message);
                                    }

                                    @Override
                                    public void onResponse(JSONArray response) {
                                        String id = null;
                                        for (int i = 0; i < response.length(); i++) {
                                            id = "";

                                            try {
                                                JSONObject user = response.getJSONObject(0);
                                                id = user.getString("id");
                                                System.out.println(id);
                                            } catch (Exception e) {
                                                throw new RuntimeException(e);
                                            }

                                        }

                                        cadEndereco.putExtra("id", id);
                                        startActivity(cadEndereco);
                                        finish();
                                    }
                                });
                }
            }
        });

    }

    private boolean validarInfo(String nome, String cpf, String email, String idade, String senha, String confSenha) {
        if(nome.length() == 0){
            edNome.requestFocus();
            edNome.setError("O campo não pode estar vazio");
            return false;
        } /*else if (!nome.matches("[a-zA-Z]+")) {
            edNome.requestFocus();
            edNome.setError("Insira somente valores alfabéticos");
            return false;
        }*/ else if(cpf.length() == 0){
            edCpf.requestFocus();
            edCpf.setError("O campo não pode estar vazio");
            return false;
        } else if (cpf.length() != 11) {
            edCpf.requestFocus();
            edCpf.setError("Insira um CPF valido");
            return false;
        }
        else if(email.length() == 0){
            edEmail.requestFocus();
            edEmail.setError("O campo não pode estar vazio");
            return false;
        } else if (!email.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            edEmail.requestFocus();
            edEmail.setError("Insira um email valido");
            return false;
        } else if(idade.length() == 0) {
            edIdade.requestFocus();
            edIdade.setError("O campo não pode estar vazio");
            return false;
        } else if(senha.length() < 8){
            edSenha.requestFocus();
            edSenha.setError("Minimo de 8 caracteres requeridos");
            return false;
        } else if (!senha.equals(confSenha)) {
            edConfirmSenhha.requestFocus();
            edConfirmSenhha.setError("As senhas não conferem");
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