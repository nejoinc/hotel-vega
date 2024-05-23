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

import com.hotel.modelo.entidad.Empleado;
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


      //Ruta para editar
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idServicio,Model modelo) {
		
		Servicios servicios=new Servicios();
		//Validar si el ID existe
		if(idServicio>0) {
			servicios=serviciosServicio.buscarPorId(idServicio);
			if(servicios==null) {
				return "redirect:/vistas/servicios/";
			}
		}else {
			return "redirect:/vistas/servicios/";
		}
		
		modelo.addAttribute("titulo","Formulario: Editar Empleado");
		modelo.addAttribute("servicios",servicios);
		return "/vistas/servicios/crearservicio";
	}
	
	//Ruta para eliminar
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idServicio) {
		
		Servicios servicios=new Servicios();
		//Validar si el ID existe
		if(idServicio>0) {
			servicios=serviciosServicio.buscarPorId(idServicio);
			if(servicios==null) {
				return "redirect:/vistas/servicios/";
			}
		}else {
				return "redirect:/vistas/servicios/";
		}
		
		//Invocar el servicio de eliminar
		serviciosServicio.eliminar(idServicio);
		return "redirect:/vistas/servicios/";
	}
}
