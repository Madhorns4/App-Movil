package com.example.sviaje.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sviaje.Adapters.ListAdapter;
import com.example.sviaje.Models.Ciudad;
import com.example.sviaje.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CiudadActivity extends AppCompatActivity {

    private int id_provincia;
    private ListAdapter arrayAdapter;
    private ListView lv_ciudad;
    private List<Ciudad> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad);
        final String n_provincia= getIntent().getStringExtra("n_provincia");
        id_provincia=getIntent().getIntExtra("id_provincia",0);
        lv_ciudad=(ListView)findViewById(R.id.lv_ciudad);
        listarCiudades("http://192.168.1.9/ciudad.php");

        lv_ciudad.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Ciudad ciudad =(Ciudad) parent.getItemAtPosition(position);
                Intent i = new Intent(CiudadActivity.this,LugarTuristicoActivity.class);
                i.putExtra("id_provincia", ciudad.getId_provincia());
                i.putExtra("n_provincia",n_provincia);
                i.putExtra("id_ciudad",ciudad.getId_ciudad());
                i.putExtra("n_ciudad",ciudad.getNombre());
                startActivity(i);
            }
        });

    }

    private void listarCiudades(String URL) {

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            if(!response.isEmpty()){
                try {
                    JSONArray jsonObject = new JSONArray(response);
                    System.out.println(response);

                   list = new ArrayList<Ciudad>();
                    for(int i = 0; i<jsonObject.length();i++){
                        System.out.println(i+"");
                        Ciudad c = new Ciudad();
                        c.setId_ciudad(jsonObject.getJSONObject(i).getInt("id_ciudad"));
                        c.setNombre(jsonObject.getJSONObject(i).getString("nombre"));
                        c.setId_provincia(jsonObject.getJSONObject(i).getInt("id_provincia"));
                        list.add(c);

                    }
                    arrayAdapter= new ListAdapter(CiudadActivity.this,list);
                    lv_ciudad.setAdapter(arrayAdapter);




                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }else{
                System.out.println("vacio");
            }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                String id = id_provincia+"";
                parametros.put("id_provincia",id);
                return parametros;

            }

        };
        queue.add(stringRequest);

    }
}
