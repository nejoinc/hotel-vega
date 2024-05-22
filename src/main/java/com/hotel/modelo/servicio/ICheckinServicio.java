package com.hotel.modelo.servicio;

import java.util.List;

import com.hotel.modelo.entidad.Checkin;

public interface ICheckinServicio {
    public List<Checkin> listaTodos();
    public void guardar(Checkin checkin);
    public Checkin buscarPorId(Integer id);
    public void eliminar(Integer id);

    
} 
