package com.example.sviaje.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sviaje.Models.Usuario;
import com.example.sviaje.Models.daoUsuario;
import com.example.sviaje.R;


public class MainActivity extends AppCompatActivity {

    int id=0;
    Usuario u;
    daoUsuario dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*TRAE EL ID DEL LOGIN ACTIVITY
        Bundle b = getIntent().getExtras();
        id=b.getInt("id_usuario");
        dao = new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" "+u.getApellido()) */

    }


}
