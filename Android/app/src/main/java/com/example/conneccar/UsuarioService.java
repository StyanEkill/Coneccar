package com.example.conneccar;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsuarioService {

    public static final String API_CONECCAR = "http://192.168.1.8:8080/coneccar/usuario";

    Context context;

    public UsuarioService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(Object response);
    }

    public void usuarioLogin(String usuario, String senha,VolleyResponseListener volleyResponseListener){

        String url = API_CONECCAR;

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    String nomeUsuario = "";
                    String senhaUsuario = "";
                    try {

                        JSONObject usuario = response.getJSONObject(i);
                        nomeUsuario = usuario.getString("nome");
                        senhaUsuario = usuario.getString("senha");

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    if (usuario.equals(nomeUsuario) && senha.equals(senhaUsuario)){

                        i = response.length();
                        volleyResponseListener.onResponse(usuario+senha);
                        //Toast.makeText(context, "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show();

                    } else {
                        volleyResponseListener.onError(usuario+senha);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Algo deu errado", Toast.LENGTH_SHORT).show();
                volleyResponseListener.onError("Algo deu errado");
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);
    }

}
