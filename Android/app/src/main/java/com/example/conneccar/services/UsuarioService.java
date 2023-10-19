package com.example.conneccar.services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
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
    JSONArray array;

    public UsuarioService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(JSONArray response);
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
                        array = new JSONArray();
                        try {
                            JSONObject j = new JSONObject(usuario);
                            JSONObject k = new JSONObject(senha);
                            array.put(j);
                            array.put(k);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        volleyResponseListener.onResponse(array);
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
    public void usuarioCadastro(String nome,String cpf,String email,String idade,String senha,VolleyResponseListener volleyResponseListener){

        String url = API_CONECCAR;
        try {
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("nome", nome);
            jsonBody.put("cpf", cpf);
            jsonBody.put("email", email);
            jsonBody.put("senha", senha);
            jsonBody.put("idade", idade);

            /*JSONObject enderecoPut = new JSONObject();
            enderecoPut.put("id", 1);
            jsonBody.put("endereco", enderecoPut);*/

            final String requestBody = jsonBody.toString();


                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        array = new JSONArray();
                        try {
                            JSONObject aux = new JSONObject(response);
                            array.put(aux);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        volleyResponseListener.onResponse(array);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        volleyResponseListener.onError(error.toString());
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
                        JSONArray array;
                        try {
                            String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
                            return Response.success(json,HttpHeaderParser.parseCacheHeaders(response));
                        } catch (Exception e) {
                            return Response.error(new ParseError());
                        }
                    }
                };
                MySingleton.getInstance(context).addToRequestQueue(request);

            } catch(JSONException e){
                e.printStackTrace();
            }

    }





}
