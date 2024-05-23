package com.hotel.modelo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.modelo.entidad.Reservas;
import com.hotel.modelo.repositorio.ReservasRepostorio;

@Service 
public class ReservasServicio implements IReservasServicio {


    @Autowired 
    private ReservasRepostorio reservasRepostorio; 

    @Override 
    public List<Reservas> listaTodos() {
        return (List<Reservas>)reservasRepostorio.findAll(); 
    }

    public void guardar(Reservas reservas) {
        reservasRepostorio.save(reservas);
    }

    @Override 
    public Reservas buscarPorId(Integer id) {
        return reservasRepostorio.findById(id).orElse(null);
    }

    @Override 
    public void eliminar(Integer id) {
        reservasRepostorio.deleteById(id);
    }
    
}