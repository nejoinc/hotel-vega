package com.hotel.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.modelo.entidad.Empleado;

@Repository

public interface EmpleadoRepositorio extends CrudRepository<Empleado, Integer> {

    
}
