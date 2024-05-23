package com.hotel.modelo.servicio;

import java.util.List;

import com.hotel.modelo.entidad.Reservas;

/**
 * IReservasServicio
 */
public interface IReservasServicio {

    public List<Reservas> listaTodos(); 
    public void guardar(Reservas reservas); 
    public Reservas buscarPorId(Integer id); 
    public void eliminar(Integer id);
}