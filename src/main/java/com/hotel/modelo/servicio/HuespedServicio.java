package com.hotel.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.entidad.Huesped;
import com.hotel.modelo.repositorio.HuespedRepositorio;

@Service
public class HuespedServicio implements IHuespedServicio  {
    @Autowired
    private HuespedRepositorio huespedRepositorio;

    @Override 
    public List<Huesped> listaTodos() {
		return (List<Huesped>)huespedRepositorio.findAll();
	}


    	public void guardar(Huesped huesped) {
		huespedRepositorio.save(huesped);
	}

	@Override
	public Huesped buscarPorId(Integer id) {
		return huespedRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		huespedRepositorio.deleteById(id);
	}
}
