package com.hotel.modelo.servicio;

import java.util.List;

import com.hotel.modelo.entidad.Empleado;
public interface IEmpleadoServicio {

    public List<Empleado> listaTodos();
    public void guardar(Empleado empleado);
    public Empleado buscarPorId(Integer id);
    public void eliminar(Integer id);
}
