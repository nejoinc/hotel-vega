package com.hotel.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="reservas")
public class Reservas {
    
    @Id
    private int idHabitacion;
    private int idHuespede; 
    private int idEmpleado;
    private int idReserva;
    private String nomEmpleado;
    private String apeEmpleado;
    private String nomHuesped; 
    private String apeHuesped;
    private String habitacion;
    public int getIdHabitacion() {
        return idHabitacion;
    }
    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
    public int getIdHuespede() {
        return idHuespede;
    }
    public void setIdHuespede(int idHuespede) {
        this.idHuespede = idHuespede;
    }
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public int getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    public String getNomEmpleado() {
        return nomEmpleado;
    }
    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }
    public String getApeEmpleado() {
        return apeEmpleado;
    }
    public void setApeEmpleado(String apeEmpleado) {
        this.apeEmpleado = apeEmpleado;
    }
    public String getNomHuesped() {
        return nomHuesped;
    }
    public void setNomHuesped(String nomHuesped) {
        this.nomHuesped = nomHuesped;
    }
    public String getApeHuesped() {
        return apeHuesped;
    }
    public void setApeHuesped(String apeHuesped) {
        this.apeHuesped = apeHuesped;
    }
    public String getHabitacion() {
        return habitacion;
    }
    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }
    @Override
    public String toString() {
        return "Reservas [idHabitacion=" + idHabitacion + ", idHuespede=" + idHuespede + ", idEmpleado=" + idEmpleado
                + ", idReserva=" + idReserva + ", nomEmpleado=" + nomEmpleado + ", apeEmpleado=" + apeEmpleado
                + ", nomHuesped=" + nomHuesped + ", apeHuesped=" + apeHuesped + ", habitacion=" + habitacion + "]";
    }

    

  

    

    
}
