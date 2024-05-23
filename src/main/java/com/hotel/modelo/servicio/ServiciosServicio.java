package com.hotel.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.entidad.Articulos;
import com.hotel.modelo.entidad.Servicios;
import com.hotel.modelo.repositorio.ServiciosRepositorio;

@Service
public class ServiciosServicio implements IServiciosServicio {
    
    @Autowired 
    private ServiciosRepositorio serviciosRepositorio; 

   @Override 
    public List<Servicios> listaTodos() {
		return (List<Servicios>)serviciosRepositorio.findAll();
	} 

    public void guardar(Servicios servicios) {
		serviciosRepositorio.save(servicios);
	}

    @Override
	public Servicios buscarPorId(Integer id) {
		return serviciosRepositorio.findById(id).orElse(null);
	}

    @Override
	public void eliminar(Integer id) {
		serviciosRepositorio.deleteById(id);
	}
}
