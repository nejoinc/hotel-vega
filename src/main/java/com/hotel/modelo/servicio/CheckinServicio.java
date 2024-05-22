package com.hotel.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.entidad.Checkin;
import com.hotel.modelo.repositorio.CheckinRepositorio;

@Service
public class CheckinServicio implements ICheckinServicio {
    @Autowired 
    private CheckinRepositorio checkinRepositorio;


    @Override 
    public List<Checkin> listaTodos() { 
        return (List<Checkin>)checkinRepositorio.findAll();
    }

    public void guardar(Checkin checkin) {
		checkinRepositorio.save(checkin);
    }

    @Override
	public Checkin buscarPorId(Integer id) {
		return checkinRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		checkinRepositorio.deleteById(id);
	}
}
