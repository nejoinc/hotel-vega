package com.hotel.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.entidad.Reservas;
import com.hotel.modelo.repositorio.ReservasRepositorio;

@Service
public class ReservasServicio implements IReservasServicio {
    
    @Autowired
    private ReservasRepositorio reservasRepositorio; 

   @Override 
    public List<Reservas> listaTodos() {
		return (List<Reservas>)reservasRepositorio.findAll();
	} 

    public void guardar(Reservas reservas) {
		reservasRepositorio.save(reservas);
	}

    @Override
	public Reservas buscarPorId(Integer id) {
		return reservasRepositorio.findById(id).orElse(null);
	}

    @Override
	public void eliminar(Integer id) {
		reservasRepositorio.deleteById(id);
	}
}
