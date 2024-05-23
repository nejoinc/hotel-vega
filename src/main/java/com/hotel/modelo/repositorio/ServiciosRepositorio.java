package com.hotel.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.modelo.entidad.Servicios;

@Repository
/**
 * ServiciosRepositorio
 */
public interface ServiciosRepositorio extends CrudRepository<Servicios, Integer> {

    
}
