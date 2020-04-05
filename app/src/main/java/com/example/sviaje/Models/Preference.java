package com.example.sviaje.Models;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class Preference {
  private String PREFS_KEY= "com.example.sviaje.preference";



  //activity de licencias o terminos de condiciones en caso de que haya
    public void saveValuePreference(Context context, Boolean mostrar) {
        SharedPreferences settings = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putBoolean("license", mostrar);
        editor.apply();
    }


    public void Saveiduser(Context c , int id, String nombre, String apellido, String usuario){
        SharedPreferences settings = c.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = settings.edit();
        editor.putInt("id_usuario", id);
        editor.putString("nombre",nombre);
        editor.putString("apellido", apellido);
        editor.putString("usuario", usuario);
        editor.apply();
    }

    //obtiene el id del usuario
    public int getIdpref(Context c){
        SharedPreferences preferences = c.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);

        return preferences.getInt("id_usuario",0);
    }

    //obtiene el nombre
    public String getNombrepref(Context c){
        SharedPreferences preferences = c.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return preferences.getString("nombre","");

    }


    public String getApellidopref(Context c){
        SharedPreferences preferences = c.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return preferences.getString("apellido","");

    }

    public String getUusariopref(Context c){
        SharedPreferences preferences = c.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return preferences.getString("usuario","");

    }
    //metodo de licencias boolean
    public boolean getValuePreference(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(PREFS_KEY, MODE_PRIVATE);
        return  preferences.getBoolean("license", true);

    }

}
