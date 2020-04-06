package com.example.sviaje.Models;

public class Lugares_sqlite {
    private int id_viaje;
    private int id_usuario;
    private int num_viaje;
    private String n_pais;
    private String n_provincia;
    private String n_ciudad;
    private String n_lugar;
    private String fecha;
    private String hora;
    private String costo;


    public Lugares_sqlite(){

    }

    public Lugares_sqlite(int id_viaje, int id_usuario, int num_viaje, String n_pais, String n_provincia, String n_ciudad, String n_lugar, String fecha, String hora, String costo) {
        this.id_viaje = id_viaje;
        this.id_usuario = id_usuario;
        this.num_viaje = num_viaje;
        this.n_pais = n_pais;
        this.n_provincia = n_provincia;
        this.n_ciudad = n_ciudad;
        this.n_lugar = n_lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.costo = costo;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getNum_viaje() {
        return num_viaje;
    }

    public void setNum_viaje(int num_viaje) {
        this.num_viaje = num_viaje;
    }

    public String getN_pais() {
        return n_pais;
    }

    public void setN_pais(String n_pais) {
        this.n_pais = n_pais;
    }

    public String getN_provincia() {
        return n_provincia;
    }

    public void setN_provincia(String n_provincia) {
        this.n_provincia = n_provincia;
    }

    public String getN_ciudad() {
        return n_ciudad;
    }

    public void setN_ciudad(String n_ciudad) {
        this.n_ciudad = n_ciudad;
    }

    public String getN_lugar() {
        return n_lugar;
    }

    public void setN_lugar(String n_lugar) {
        this.n_lugar = n_lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }
}
