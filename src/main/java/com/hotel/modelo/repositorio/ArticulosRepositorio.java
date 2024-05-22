package com.hotel.modelo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.modelo.entidad.Articulos;

@Repository
public interface ArticulosRepositorio extends CrudRepository<Articulos, Integer> {

    
} 
