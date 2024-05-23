package com.hotel.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.modelo.entidad.Reservas;

@Repository
/**
 * ReservasRepostorio
 */
public interface ReservasRepostorio extends CrudRepository<Reservas, Integer>{

    
}
