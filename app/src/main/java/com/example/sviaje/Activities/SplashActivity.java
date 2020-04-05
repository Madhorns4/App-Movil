package com.example.sviaje.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.sviaje.Activities.Home.Principal;
import com.example.sviaje.Models.Preference;
import com.example.sviaje.R;

public class SplashActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable(){
            public void run(){

                Preference p = new Preference();
                int id = p.getIdpref(getApplicationContext());


                if(id==0){
                    Intent myIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                    p.saveValuePreference(SplashActivity.this, false);
                }else{

                    Intent intent = new Intent(SplashActivity.this, Principal.class);


                    startActivity(intent);
                }
                finish();


            };

        }, DURACION_SPLASH);

    }
}
