package com.hotel.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.modelo.entidad.Empleado;
import com.hotel.modelo.entidad.Huesped;
import com.hotel.modelo.entidad.Reservas;
import com.hotel.modelo.servicio.IEmpleadoServicio;
import com.hotel.modelo.servicio.IReservasServicio;

import org.springframework.ui.Model;

@Controller 
@RequestMapping("/vistas/reservas")
public class ControladorReservas {

    @Autowired 
    private IReservasServicio reservasServicio; 

    @Autowired
    private IEmpleadoServicio empleadoServicio; 

    @GetMapping("/") 
    public String listarReservas(Model modelo) {
        List<Reservas> listadoReservas=reservasServicio.listaTodos(); 
        modelo.addAttribute("reservas", listadoReservas); 
        return "/vistas/reservas/reservas";
    }
    

    @GetMapping("/create")
    public String crear(Model modelo) {
      
      //Crear el objeto de tipo contacto
      Reservas reservas=new Reservas();
      
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("reservas",reservas);
      return "/vistas/reservas/reservar";
      
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> buscarPorId(@PathVariable Integer id) {
        Empleado empleado = empleadoServicio.buscarPorId(id);
        if (empleado != null) {
            return ResponseEntity.ok(empleado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
