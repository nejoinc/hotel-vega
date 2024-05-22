package com.hotel.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.modelo.entidad.Checkin;

@Repository
public interface CheckinRepositorio extends CrudRepository<Checkin, Integer> {

    
} 
