package com.hotel.modelo.servicio;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.entidad.Articulos;
import com.hotel.modelo.entidad.Habitaciones;
import com.hotel.modelo.repositorio.ArticulosRepositorio;
import com.hotel.modelo.repositorio.HabitacionesRepositorio;

@Service
public class ArticulosServicio implements IArticulosServicio {
    
    @Autowired
    private ArticulosRepositorio articulosRepositorio;

    @Override 
    public List<Articulos> listaTodos() {
		return (List<Articulos>)articulosRepositorio.findAll();
	}


    	public void guardar(Articulos articulos) {
		articulosRepositorio.save(articulos);
	}

	@Override
	public Articulos buscarPorId(Integer id) {
		return articulosRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		articulosRepositorio.deleteById(id);
	}
}
