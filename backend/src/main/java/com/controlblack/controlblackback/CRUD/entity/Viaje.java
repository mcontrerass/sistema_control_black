package com.controlblack.controlblackback.CRUD.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "control_black")
public class Viaje {
    @Id
    private int id;
    private String conductor;
    private String patente;
    private String periodo;
    private String fecha;
    private String destino;
    private String beetrack;
    private float precio;
    
    public Viaje() {
    }

    public Viaje(int id, String conductor, String patente, String periodo, String fecha, String destino, String beetrack, float precio) {
        this.id = id;
        this.conductor = conductor;
        this.patente = patente;
        this.periodo = periodo;
        this.fecha = fecha;
        this.destino = destino;
        this.beetrack = beetrack;
        this.precio = precio;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getBeetrack() {
        return beetrack;
    }

    public void setBeetrack(String beetrack) {
        this.beetrack = beetrack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
