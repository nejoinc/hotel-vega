package com.hotel.modelo.servicio;

import java.util.List;

import com.hotel.modelo.entidad.Articulos;

/**
 * IArticulosServicio
 */
public interface IArticulosServicio {

    public List<Articulos> listaTodos();
    public void guardar(Articulos articulos);
    public Articulos buscarPorId(Integer id);
    public void eliminar(Integer id);
}