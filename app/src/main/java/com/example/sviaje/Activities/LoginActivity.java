package com.example.sviaje.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sviaje.Activities.Home.Principal;
import com.example.sviaje.Models.Preference;
import com.example.sviaje.Models.Usuario;
import com.example.sviaje.Models.daoUsuario;
import com.example.sviaje.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etUsuario, etClave;
    Button btnRegistrar, btnIniciar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText)findViewById(R.id.et_usuario_login);
        etClave = (EditText)findViewById(R.id.et_password_login);

        btnRegistrar = (Button)findViewById(R.id.btn_registrar_login);
        btnIniciar = (Button)findViewById(R.id.btn_iniciarsesion_login);

        btnIniciar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);

        //dao = new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_iniciarsesion_login:
                /*
                String u = etUsuario.getText().toString();
                String c = etClave.getText().toString();
                if (u.equals("")&&c.equals("")){
                    Toast.makeText(this, "ERROR: Campos vacios", Toast.LENGTH_SHORT).show();
                }if (dao.login(u,c)==1){
                    Usuario ur = dao.getUsuario(u,c);
                    Toast.makeText(this, "Datos Correctos", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("id_usuario", ur.getId_usuario());
                    startActivity(intent);
                    finish();
                }*/

                validarUsuario("http://192.168.1.9/login.php");

                break;

            case R.id.btn_registrar_login:

                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();

                break;
        }

    }

    private void validarUsuario(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    System.out.println(response);
                    String nombre=null;
                    String apellido=null;
                    String usuario=null;
                    try {
                        JSONObject json = new JSONObject(response);
                        int id = json.getInt("id_usuario");
                        nombre = json.getString("nombre");
                        apellido = json.getString("apellido");
                        usuario = json.getString("usuario");
                        Preference preference = new Preference();

                        preference.Saveiduser(LoginActivity.this,id,nombre,apellido,usuario);

                    }catch (JSONException e) {
                        e.printStackTrace();
                    }


                    Intent intentp = new Intent(getApplicationContext(), Principal.class);
                    intentp.putExtra("nombre",nombre);
                    intentp.putExtra("apellido",apellido);
                    intentp.putExtra("usuario",usuario);

                    startActivity(intentp);

                }else{
                    Toast.makeText(LoginActivity.this, "Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(LoginActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("usuario",etUsuario.getText().toString());
                parametros.put("clave", etClave.getText().toString());
                return parametros;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}
