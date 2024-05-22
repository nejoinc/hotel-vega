package com.hotel.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.modelo.entidad.Articulos;
import com.hotel.modelo.entidad.Habitaciones;
import com.hotel.modelo.entidad.Huesped;
import com.hotel.modelo.servicio.IArticulosServicio;
import com.hotel.modelo.servicio.IHabitacionesServicio;



@Controller 
@RequestMapping("/vistas/habitaciones")
public class ControladorHabitaciones {
    @Autowired
    private IHabitacionesServicio habitacionesServicio;
    @Autowired
    private IArticulosServicio articulosServicio;

    @GetMapping("/") 
      public String listarHabitaciones(Model modelo) {
        List<Habitaciones> listadoHabitaciones=habitacionesServicio.listaTodos();
        List<Articulos> listadoArticulos=articulosServicio.listaTodos();
        modelo.addAttribute("articulos", listadoArticulos);
        modelo.addAttribute("habitaciones", listadoHabitaciones);
        return "/vistas/habitaciones/habitaciones";
    }
    

    @GetMapping("/create")
    public String crear(Model modelo) {
      
      //Crear el objeto de tipo contacto
      Habitaciones habitaciones=new Habitaciones();
      
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("habitaciones",habitaciones);
      return "/vistas/habitaciones/crearhabitacion";
      
    }

      @PostMapping("/save")
    public String guardar(@ModelAttribute Habitaciones habitaciones,Model modelo) {
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("habitaciones",habitaciones);
      //Utilizar el servicio para almacenar en la BD
      habitacionesServicio.guardar(habitaciones);
      return "redirect:/vistas/habitaciones/";
    }


    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idHabitacion,Model modelo) {
      
      Habitaciones habitaciones=new Habitaciones();
      if(idHabitacion>0) {
        habitaciones=habitacionesServicio.buscarPorId(idHabitacion);
        if(habitaciones==null) {
          return "redirect:/vistas/habitaciones/";
        }
      }else {
        return "redirect:/vistas/habitaciones/";
      }
      
      modelo.addAttribute("titulo","Formulario: Editar Empleado");
      modelo.addAttribute("habitaciones",habitaciones);
      return "/vistas/habitaciones/crearhabitacion";
    }

     //Ruta para eliminar
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idHabitacion) {
		
		Habitaciones habitaciones=new Habitaciones();
		//Validar si el ID existe
		if(idHabitacion>0) {
			habitaciones=habitacionesServicio.buscarPorId(idHabitacion);
			if(habitaciones==null) {
				return "redirect:/vistas/habitaciones/";
			}
		}else {
				return "redirect:/vistas/habitaciones/";
		}
		
		//Invocar el servicio de eliminar
		habitacionesServicio.eliminar(idHabitacion);
		return "redirect:/vistas/habitaciones/";
	}
}
