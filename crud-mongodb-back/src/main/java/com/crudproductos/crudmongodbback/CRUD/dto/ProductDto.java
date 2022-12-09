package com.crudproductos.crudmongodbback.CRUD.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductDto {

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombre;
    @Min(value = 1, message = "El precio es obligatorio")
    private float precio;
    
    public ProductDto() {
    }

    public ProductDto(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
