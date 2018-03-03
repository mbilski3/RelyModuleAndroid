package com.pamczo.samczo.zuzaapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // znajduje button po id, R - klasa reources
        // button musial byc zaimportowany (android.widget.Button)
        final Button button = findViewById(R.id.button);
        // importowanie nowego obiektu onClickListener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // miejsce wykonania kodu kiedy klikniemy przycisk
                // spr czy text off czy on
                toggle();
                if(button.getText() == "OFF") {
                    button.setText("ON");
                } else {
                    button.setText("OFF");
                }
            }
        });
    }
    // pobranie dependencies volley do build.gradle compile 'com.android.volley:volley:1.0.0'
    // importowanie klas ktore sa na czerwone
    // programowanie eventowe (na serwerze wykonuja sie RZECZY)
    protected void toggle(){
        // tworzy kolejke requestow HTTP (queue), Volley - bibliotek do HTTP
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.1.13:4444/toggle";
        // nowy obiekt - zapytanie post json, json request - payload ktory jest nullem
        // respone listener to json object
        final Context ctx = this;
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
                    // jesli status 200 to wykona sie to co w metodzie
                    // mozna dodac sie toast (mala wiadomosc)
                    // final - deklaracja 'constant'
                    // makeText() - wyswietla text jezeli jest context
                    @Override
                    public void onResponse(JSONObject response) {
                        // wyswietla toasta
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // jak jest error to wykona sie kod napisany tu

                    }
                });
        queue.add(jsObjRequest);
    }
}
