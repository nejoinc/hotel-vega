package com.hotel.modelo.servicio;

import java.util.List;

import com.hotel.modelo.entidad.Servicios;

/**
 * IServiciosServicio
 */
public interface IServiciosServicio {

    public List<Servicios> listaTodos(); 
    public void guardar(Servicios servicios);
    public Servicios buscarPorId(Integer id); 
    public void eliminar(Integer id);
}