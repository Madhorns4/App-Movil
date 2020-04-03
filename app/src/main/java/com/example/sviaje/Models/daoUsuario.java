package com.example.sviaje.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {

    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "sviajes";
    String tabla = "create table if not exists usuario(id_usuario integer primary key autoincrement, nombre text, apellido text, usuario text, clave text)";

    public daoUsuario(Context c) {
        this.c = c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();
    }

    public boolean insertUser(Usuario u) {
        if (buscar(u.getUsuario()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("nombre", u.getNombre());
            cv.put("apellido", u.getApellido());
            cv.put("usuario", u.getUsuario());
            cv.put("clave", u.getClave());
            return (sql.insert("usuario", null, cv) > 0);
        } else {
            return false;
        }
    }

    public int buscar(String u) {
        int x = 0;
        lista = selectUser();
        for (Usuario us : lista) {
            if (us.getUsuario().equals(u)) {
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUser() {

        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                Usuario u = new Usuario();
                u.setId_usuario(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setApellido(cr.getString(2));
                u.setUsuario(cr.getString(3));
                u.setClave(cr.getString(4));
                lista.add(u);
            } while (cr.moveToNext());
        }
        return lista;
    }

    public int login(String u, String c) {
        int a = 0;
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if (cr.getString(3).equals(u) && cr.getString(4).equals(c)) {
                    a++;
                }
            } while (cr.moveToNext());
        }
        return a;
    }

    public Usuario getUsuario(String u, String c) {
        lista = selectUser();
        for (Usuario us : lista) {
            if (us.getUsuario().equals(u) && us.getClave().equals(c)) {
                return us;
            }
        }
        return null;
    }

    public Usuario getUsuarioById(int id) {
        lista = selectUser();
        for (Usuario ud : lista) {
            if (ud.getId_usuario()==id) {
                return ud;
            }
        }
        return null;
    }

}
