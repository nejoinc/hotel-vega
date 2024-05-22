package com.hotel.modelo.servicio;

import java.util.List;

import com.hotel.modelo.entidad.Habitaciones;

public interface IHabitacionesServicio {
        public List<Habitaciones> listaTodos();
        public void guardar(Habitaciones habitaciones);
        public Habitaciones buscarPorId(Integer id);
        public void eliminar(Integer id);
    
} 
