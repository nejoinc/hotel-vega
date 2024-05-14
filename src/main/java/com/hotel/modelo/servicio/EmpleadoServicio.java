package com.hotel.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.entidad.Empleado;
import com.hotel.modelo.repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicio implements IEmpleadoServicio {
    @Autowired 
	private EmpleadoRepositorio empleadoRepositorio;


	@Override
	public List<Empleado> listaTodos() {
		return (List<Empleado>)empleadoRepositorio.findAll();
	}

	public void guardar(Empleado empleado) {
		empleadoRepositorio.save(empleado);
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		return empleadoRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		empleadoRepositorio.deleteById(id);
	}

}

