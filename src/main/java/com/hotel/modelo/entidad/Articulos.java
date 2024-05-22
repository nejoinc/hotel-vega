package com.hotel.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="articulos")
public class Articulos {

    @Id 
    private int idArticulo; 
    private int codigo;
    private String nombreArticulo;
    private String descripcion;
    public int getIdArticulo() {
        return idArticulo;
    }
    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombreArticulo() {
        return nombreArticulo;
    }
    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "Articulos [idArticulo=" + idArticulo + ", codigo=" + codigo + ", nombreArticulo=" + nombreArticulo
                + ", descripcion=" + descripcion + "]";
    }
    
  

    
    
}
