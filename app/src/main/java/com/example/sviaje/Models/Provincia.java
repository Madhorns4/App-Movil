package com.example.sviaje.Models;

public class Provincia {
    int id_provincia;
    String nombre;
    String url;
    String pais;

    public Provincia(){


    }


    public Provincia(int id_provincia, String nombre, String url, String pais) {
        this.id_provincia = id_provincia;
        this.nombre = nombre;
        this.url = url;
        this.pais = pais;
    }

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
