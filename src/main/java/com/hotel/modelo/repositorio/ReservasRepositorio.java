package com.hotel.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.hotel.modelo.entidad.Reservas;

/**
 * ReservasRepositorio
 */
public interface ReservasRepositorio extends CrudRepository<Reservas, Integer>{

    
}
