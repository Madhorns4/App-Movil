package com.example.sviaje.Models;

public class Lugares {
    private int id_lugar;
    private String nombre;
    private String descripcion;
    private String direccion;
    private String costo;
    private int id_ciudad;

    public Lugares(){

    }

    public Lugares(int id_lugar, String nombre, String descripcion, String direccion, String costo, int id_ciudad) {
        this.id_lugar = id_lugar;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.costo = costo;
        this.id_ciudad = id_ciudad;
    }

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}
