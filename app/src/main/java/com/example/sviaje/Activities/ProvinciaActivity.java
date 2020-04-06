package com.example.sviaje.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sviaje.Adapters.GridAdapter;
import com.example.sviaje.Models.Provincia;
import com.example.sviaje.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

public class ProvinciaActivity extends AppCompatActivity {
    private GridAdapter gridAdapter;
    private GridView gridView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provincia);
        gridView = (GridView)findViewById(R.id.grid_provincia);
        System.out.println("error");
        obtenerProvincia("http://192.168.1.9/Paises.php");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Provincia provinciaselect = (Provincia) parent.getItemAtPosition(position);

                Intent i = new Intent(ProvinciaActivity.this, CiudadActivity.class);
                i.putExtra("id_provincia", provinciaselect.getId_provincia());
                i.putExtra("n_provincia",provinciaselect.getId_provincia());
                startActivity(i);


            }
        });

    }



    public void obtenerProvincia(String URL){

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            if(!response.isEmpty()){
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    JSONArray jsonArray1= jsonArray.getJSONArray(0);
                    List<Provincia> p = new ArrayList<Provincia>();
                    for(int i = 0; i<jsonArray1.length(); i++){


                        Provincia provincia = new Provincia();

                        provincia.setId_provincia(jsonArray1.getJSONObject(i).getInt("id_provincia"));
                        provincia.setNombre(jsonArray1.getJSONObject(i).getString("nombre"));
                        provincia.setUrl(jsonArray1.getJSONObject(i).getString("url"));
                        provincia.setPais(jsonArray1.getJSONObject(i).getString("pais"));
                        p.add(provincia);

                    }

                    gridAdapter = new GridAdapter(ProvinciaActivity.this,p);
                    gridView.setAdapter(gridAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }else {
                System.out.println("ERROR");
            }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(stringRequest);


    }




}
