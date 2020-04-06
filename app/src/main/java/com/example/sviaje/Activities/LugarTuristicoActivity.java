package com.example.sviaje.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sviaje.Activities.Home.Principal;
import com.example.sviaje.Adapters.ListAdapter;
import com.example.sviaje.Adapters.ListAdapter_uno;
import com.example.sviaje.Models.Lugares;
import com.example.sviaje.Models.MyDBOpenHelper;
import com.example.sviaje.Models.Preference;
import com.example.sviaje.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LugarTuristicoActivity extends AppCompatActivity {

    private ListView lv_lugar;
    private List<Lugares> list;
    private ListAdapter_uno arrayAdapter;
    private int id_lugar_turistico;
    private int id_ciudad;
    private int id_provincia;
    private int id_pais=1;
    private Date fecha = new Date();
    private String costo;
    private String f;
    private  String h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugar_turistico);
        lv_lugar=(ListView) findViewById(R.id.lv_lugar);
        id_ciudad= getIntent().getIntExtra("id_ciudad",0);
        id_provincia=getIntent().getIntExtra("id_provincia",0);
        listarLugares("http://192.168.1.9/lugares.php");
        f = fecha.getDate()+"/"+fecha.getMonth()+"/"+fecha.getYear();
        h= fecha.getHours()+":"+fecha.getMinutes()+":"+fecha.getSeconds();


        final String n_provincia =getIntent().getStringExtra("n_provincia");
        final String n_ciudad = getIntent().getStringExtra("n_ciudad");


        lv_lugar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lugares lugares = (Lugares) parent.getItemAtPosition(position);
                id_lugar_turistico=lugares.getId_lugar();
                costo=lugares.getCosto();
                Preference p = new Preference();
                int id_usuario= p.getIdpref(LugarTuristicoActivity.this);
                Intent i = new Intent(LugarTuristicoActivity.this, Principal.class);
                ingresar("http://192.168.1.9/viaje.php");

                MyDBOpenHelper database = new MyDBOpenHelper(LugarTuristicoActivity.this, "viajes", null, 1);
                SQLiteDatabase db = database.getWritableDatabase();
                ContentValues registro = new ContentValues();
                registro.put("id_usuario",id_usuario);
                registro.put("num_viaje",1);
                registro.put("n_pais","Ecuador");
                registro.put("n_provincia",n_provincia);
                registro.put("n_ciudad",n_ciudad);
                registro.put("n_lugar", lugares.getNombre());
                registro.put("fecha", f);
                registro.put("hora",h);
                registro.put("costo",lugares.getCosto());
                db.insert("viajes", null, registro);
                db.close();
                startActivity(i);

            }
        });





    }

    private void listarLugares(String URL) {
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(!response.isEmpty()){
                    try {
                        JSONArray jsonObject = new JSONArray(response);
                        list = new ArrayList<Lugares>();

                        for(int i = 0; i<jsonObject.length();i++){
                            Lugares lugares = new Lugares();
                            lugares.setId_lugar(jsonObject.getJSONObject(i).getInt("id_lugar_turistico"));
                            lugares.setNombre(jsonObject.getJSONObject(i).getString("nombre"));
                            lugares.setDescripcion(jsonObject.getJSONObject(i).getString("descripcion"));
                            lugares.setDireccion(jsonObject.getJSONObject(i).getString("direccion"));
                            lugares.setCosto(jsonObject.getJSONObject(i).getString("costo"));
                            lugares.setId_ciudad(jsonObject.getJSONObject(i).getInt("id_ciudad"));
                            list.add(lugares);


                        }
                        arrayAdapter= new ListAdapter_uno(LugarTuristicoActivity.this,list);
                        lv_lugar.setAdapter(arrayAdapter);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }else{


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
                String id = id_ciudad+"";
                parametros.put("id_ciudad",id);
                return parametros;

            }

        };
        queue.add(stringRequest);


    }



    private void ingresar(String URL) {

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()){
                    System.out.println(response);
                    Toast.makeText(LugarTuristicoActivity.this,"correcto",Toast.LENGTH_LONG).show();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(LugarTuristicoActivity.this,error.toString(),Toast.LENGTH_LONG).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                Preference p = new Preference();
                int id_usuario= p.getIdpref(LugarTuristicoActivity.this);

                parametros.put("numero_viaje",1+"");
                parametros.put("id_usuario",id_usuario+"");
                parametros.put("id_pais",id_pais+"");
                parametros.put("id_provincia",id_provincia+"");
                parametros.put("id_ciudad",id_ciudad+"");
                parametros.put("id_lugar_turistico",id_lugar_turistico+"");
                parametros.put("fecha",f);
                parametros.put("hora",h);
                parametros.put("costo_total",costo);
                return parametros;

            }

        };
        queue.add(stringRequest);

    }
}
