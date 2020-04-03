package com.example.sviaje.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sviaje.Models.Usuario;
import com.example.sviaje.Models.daoUsuario;
import com.example.sviaje.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etNombre,etApellido, etUsuario, etClave;
    Button btnRegistrar, btnCancelar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNombre = (EditText)findViewById(R.id.et_name_register);
        etApellido = (EditText)findViewById(R.id.et_lastname_register);
        etUsuario = (EditText)findViewById(R.id.et_user_register);
        etClave = (EditText)findViewById(R.id.et_password_register);

        btnRegistrar = (Button)findViewById(R.id.btn_registrar_register);
        btnCancelar = (Button)findViewById(R.id.btn_cancelar_register);

        btnRegistrar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        dao = new daoUsuario(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_registrar_register:

                Usuario u = new Usuario();
                u.setNombre(etNombre.getText().toString());
                u.setApellido(etApellido.getText().toString());
                u.setUsuario(etUsuario.getText().toString());
                u.setClave(etClave.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this, "ERROR: Campos vacios",Toast.LENGTH_SHORT).show();
                } if (dao.insertUser(u)){
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                    Intent intent2 = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent2);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btn_cancelar_register:

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

                break;
        }
    }
}
