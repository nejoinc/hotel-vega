package com.hotel.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.entidad.Habitaciones;
import com.hotel.modelo.entidad.Huesped;
import com.hotel.modelo.repositorio.HabitacionesRepositorio;
import com.hotel.modelo.repositorio.HuespedRepositorio;

@Service
public class HabitacionesServicio implements IHabitacionesServicio {

    @Autowired
    private HabitacionesRepositorio habitacionesRepositorio;

    @Override 
    public List<Habitaciones> listaTodos() {
		return (List<Habitaciones>)habitacionesRepositorio.findAll();
	}


    	public void guardar(Habitaciones habitaciones) {
		habitacionesRepositorio.save(habitaciones);
	}

	@Override
	public Habitaciones buscarPorId(Integer id) {
		return habitacionesRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		habitacionesRepositorio.deleteById(id);
	}
}
