package com.example.openapiexecicio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversor {
    public Pessoa getInformacao(String end){
        String json = com.example.openapiexecicio.ConexaoApi.getJsonFromApi(end);
        Pessoa retorno = parseJson(json);
        return retorno;
    }

    private Pessoa parseJson(String json){
        try {
            Pessoa pessoa = new Pessoa();

            JSONObject jsonObj = new JSONObject(json);
            pessoa.setIdade(jsonObj.getString("age"));

            return pessoa;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }
}
