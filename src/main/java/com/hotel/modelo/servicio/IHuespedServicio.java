package com.hotel.modelo.servicio;

import java.util.List;

import com.hotel.modelo.entidad.Huesped;

public interface IHuespedServicio {
    public List<Huesped> listaTodos();
    public void guardar(Huesped huesped);
    public Huesped buscarPorId(Integer id);
    public void eliminar(Integer id);
    
} 
