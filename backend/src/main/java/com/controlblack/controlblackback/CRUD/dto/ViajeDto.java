package com.controlblack.controlblackback.CRUD.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ViajeDto {

    @NotBlank(message = "El rut del conductor es obligatorio")
    private String conductor;
    @NotBlank(message = "La patente es obligatoria")
    private String patente;
    @NotBlank(message = "El periodo es obligatorio")
    private String periodo;
    @NotBlank(message = "La fecha es obligatoria")
    private String fecha;
    @NotBlank(message = "El destino es obligatorio")
    private String destino;
    @NotBlank(message = "El beetrack es obligatorio")
    private String beetrack;
    @Min(value = 1, message = "El precio es obligatorio")
    private float precio;
    
    public ViajeDto() {
    }

    public ViajeDto(String conductor, String patente, String periodo, String fecha, String destino, String beetrack, float precio) {
        this.conductor = conductor;
        this.patente = patente;
        this.periodo = periodo;
        this.fecha = fecha;
        this.destino = destino;
        this.beetrack = beetrack;
        this.precio = precio;
    }

    /*
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    */

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getConductor() {
        return conductor;
    }

    public String getPatente() {
        return patente;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDestino() {
        return destino;
    }

    public String getBeetrack() {
        return beetrack;
    }
    
}
