package com.example.sviaje.Models;

public class Ciudad {
    private int id_ciudad;
    private String nombre;
    private int id_provincia;


    public Ciudad(){

    }

    public Ciudad(int id_ciudad, String nombre, int id_provincia) {
        this.id_ciudad = id_ciudad;
        this.nombre = nombre;
        this.id_provincia = id_provincia;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(int id_provincia) {
        this.id_provincia = id_provincia;
    }
}
