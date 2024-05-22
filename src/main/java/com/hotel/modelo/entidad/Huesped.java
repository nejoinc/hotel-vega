package com.hotel.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="huesped")
public class Huesped {

    @Id 
    private int idHuespede;
    private String nombre;
    private int edad; 
    private String direccion; 
    private String telefono;
    private String genero;
    private String motivo;
    private String acompanante;

    public int getIdHuespede() {
        return idHuespede;
    }
    public void setIdHuespede(int idHuespede) {
        this.idHuespede = idHuespede;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getAcompañante() {
        return acompanante;
    }
    public void setAcompañante(String acompanante) {
        this.acompanante = acompanante;
    }
    @Override
    public String toString() {
        return "Huesped [idHuespede=" + idHuespede + ", nombre=" + nombre + ", edad=" + edad + ", direccion="
                + direccion + ", telefono=" + telefono + ", genero=" + genero + ", motivo=" + motivo + ", acompañante="
                + acompanante + "]";
    }

    
}
