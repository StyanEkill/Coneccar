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

import org.json.JSONObject;

public class LoginAc extends AppCompatActivity {

    EditText edEmail;
    EditText edSenha;
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        edEmail = findViewById(R.id.edLogEmail);
        edSenha = findViewById(R.id.edLogSenha);
        btLogin = findViewById(R.id.btnLogin);

        Intent HomeIntent = new Intent(getApplicationContext(), HomeAc.class);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = edEmail.getText().toString();
                String senha = edSenha.getText().toString();

                UsuarioService usuarioService = new UsuarioService(LoginAc.this);


                if(validarInfo(email,senha) == true) {

                    usuarioService.usuarioLogin(email, senha, new UsuarioService.VolleyResponseListenerObject() {
                        @Override
                        public void onError(String message) {
                            showToastError(message);
                            //Toast.makeText(LoginAc.this, message, Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onResponse(JSONObject response) {
                            System.out.println(response);
                            startActivity(HomeIntent);
                        }
                    });
                }
            }
        });

    }

    private boolean validarInfo(String email, String senha) {
        if(email.length() == 0) {
            edEmail.requestFocus();
            edEmail.setError("O campo não pode estar vazio");
            return false;
        } else if(senha.length() == 0) {
            edSenha.requestFocus();
            edSenha.setError("O campo não pode estar vazio");
            return false;
        } else {
            return true;
        }
    }

    private void showToastError(String texto){
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