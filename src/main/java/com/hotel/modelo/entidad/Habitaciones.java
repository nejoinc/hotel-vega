package com.hotel.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="habitaciones")
public class Habitaciones {
    @Id 
    private int idHabitacion; 
    private int numeroHabitacion; 
    private String tipoHabitacion; 
    private int piso;
    
    public int getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }
    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }
    public int getPiso() {
        return piso;
    }
    public void setPiso(int piso) {
        this.piso = piso;
    }

    
    
  

    
}
