package com.hotel.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="servicios")
public class Servicios {
    
    @Id
    private int idServicio; 
    private String nombre; 
    private float precio; 
    private String detalle;
    public int getIdServicio() {
        return idServicio;
    }
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
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
    public String getDetalle() {
        return detalle;
    }
    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    @Override
    public String toString() {
        return "Servicios [idServicio=" + idServicio + ", nombre=" + nombre + ", precio=" + precio + ", detalle="
                + detalle + "]";
    }

    
}
