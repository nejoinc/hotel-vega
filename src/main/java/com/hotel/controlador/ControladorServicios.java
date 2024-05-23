package com.hotel.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.modelo.entidad.Huesped;
import com.hotel.modelo.entidad.Servicios;
import com.hotel.modelo.servicio.IServiciosServicio;

@Controller 
@RequestMapping("/vistas/servicios")
public class ControladorServicios {
    @Autowired 
    private IServiciosServicio serviciosServicio; 

    @GetMapping("/")
    public String listarServicios(Model modelo) {
        List<Servicios> listadoServicios=serviciosServicio.listaTodos();
        modelo.addAttribute("servicios", listadoServicios);
        return "/vistas/servicios/servicios";
    }

    @GetMapping("/create")
    public String crear(Model modelo) {
      
      //Crear el objeto de tipo contacto
      Servicios servicios=new Servicios();
      
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("servicios",servicios);
      return "/vistas/servicios/crearservicio";
      
    }


    @PostMapping("/save") 
    public String guardar(@ModelAttribute Servicios servicios,Model modelo) {
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("servicios",servicios);
      //Utilizar el servicio para almacenar en la BD
      serviciosServicio.guardar(servicios);
      return "redirect:/vistas/servicios/";
    }
}
