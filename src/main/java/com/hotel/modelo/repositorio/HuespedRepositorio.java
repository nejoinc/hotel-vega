package com.hotel.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.modelo.entidad.Huesped;

@Repository
public interface HuespedRepositorio extends CrudRepository<Huesped, Integer> {

    
} 
