package com.example.conneccar.services;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.conneccar.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class EnderecoService {

    public static final String API_CONECCAR = "http://192.168.1.8:8080/coneccar/endereco";
    public static final String API_BRASILAPI = "https://brasilapi.com.br/api/cep/v1/";

    Context context;
    JSONArray array;

    public EnderecoService(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener{
        void onError(String message);
        void onResponse(JSONArray response);
    }

    public interface VolleyResponseListenerObject{
        void onError(String message);
        void onResponse(JSONObject response);
    }

    public void getCep(String cep, VolleyResponseListenerObject volleyResponseListenerObject){

        String url = API_BRASILAPI + cep;

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                volleyResponseListenerObject.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                volleyResponseListenerObject.onError(error+"");
            }
        });

        MySingleton.getInstance(context).addToRequestQueue(request);

    }
    public void enderecoCadastro(int idUsuario, String cep, String UF, String cidade, String bairro, String rua, String numero, String complemento, VolleyResponseListener volleyResponseListener){
        String url = API_CONECCAR;

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("cep",cep);
            jsonBody.put("uf",UF);
            jsonBody.put("cidade",cidade);
            jsonBody.put("bairro",bairro);
            jsonBody.put("rua",rua);
            jsonBody.put("numero",numero);
            jsonBody.put("complemento",complemento);
            jsonBody.put("servico","correios");
            jsonBody.put("idUsuario",idUsuario);

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
            }){

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

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

    }

}
