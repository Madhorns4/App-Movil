package com.example.sviaje.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sviaje.Activities.Home.Principal;
import com.example.sviaje.Models.Usuario;
import com.example.sviaje.Models.daoUsuario;
import com.example.sviaje.R;


public class MainActivity extends AppCompatActivity {



    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("");


        btn = (Button) findViewById(R.id.btn_pais_pais);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Principal.class);
                startActivity(i);


            }
        });


        /*TRAE EL ID DEL LOGIN ACTIVITY
        Bundle b = getIntent().getExtras();
        id=b.getInt("id_usuario");
        dao = new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" "+u.getApellido()) */

    }


}
