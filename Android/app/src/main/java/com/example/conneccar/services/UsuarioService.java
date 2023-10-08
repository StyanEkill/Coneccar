package com.example.conneccar.services;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.conneccar.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

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
                    String emailUsuario = "";
                    String senhaUsuario = "";
                    try {

                        JSONObject usuario = response.getJSONObject(i);
                        emailUsuario = usuario.getString("email");
                        senhaUsuario = usuario.getString("senha");

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                    if (usuario.equals(emailUsuario) && senha.equals(senhaUsuario)){

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

    public void usuarioCadastro(String nome
            ,String senha
            ,String cpf
            ,String email
            ,String idade
            ,VolleyResponseListener volleyResponseListener){

        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("nome", nome);
            jsonBody.put("cpf", cpf);
            jsonBody.put("email", email);
            jsonBody.put("senha", senha);
            jsonBody.put("idade", idade);
            JSONObject enderecoPut = new JSONObject();
            /*enderecoPut.put("id", 1);
            jsonBody.put("endereco", enderecoPut);*/
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, API_CONECCAR, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            MySingleton.getInstance(context).addToRequestQueue(stringRequest);

        } catch (JSONException e){
            e.printStackTrace();
        }

    }




}
