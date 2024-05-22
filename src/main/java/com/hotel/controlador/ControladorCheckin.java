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

import com.hotel.modelo.entidad.Checkin;
import com.hotel.modelo.entidad.Empleado;
import com.hotel.modelo.entidad.Huesped;
import com.hotel.modelo.servicio.ICheckinServicio;

@Controller
@RequestMapping("/vistas/checkin")
public class ControladorCheckin {
    @Autowired 
    private ICheckinServicio checkinServicio;

    @GetMapping("/")
    public String CheckIn(Model modelo) {
        List<Checkin> listadocCheckins=checkinServicio.listaTodos();
        modelo.addAttribute("checkin", listadocCheckins);
        return "/vistas/checkin/checkin";
    }
    
    @GetMapping("/create")
    public String crear(Model modelo) {
      
      //Crear el objeto de tipo contacto
      Checkin checkin=new Checkin();
      
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("checkin",checkin);
      return "/vistas/checkin/ingreso";
      
    }

     @PostMapping("/save")
     public String guardar(@ModelAttribute Checkin checkin,Model modelo) {
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("checkin",checkin);
      //Utilizar el servicio para almacenar en la BD
      checkinServicio.guardar(checkin);
      return "redirect:/vistas/checkin/";
    }

    @GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idServicio,Model modelo) {
		
		Checkin checkin=new Checkin();
		//Validar si el ID existe
		if(idServicio>0) {
			checkin=checkinServicio.buscarPorId(idServicio);
			if(checkin==null) {
				return "redirect:/vistas/checkin/";
			}
		}else {
			return "redirect:/vistas/checkin/";
		}
		
		modelo.addAttribute("titulo","Formulario: Editar Empleado");
		modelo.addAttribute("checkin",checkin);
		return "/vistas/checkin/ingreso";
	}

    @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idServicio) {
		
		Checkin checkin=new Checkin();
		//Validar si el ID existe
		if(idServicio>0) {
			checkin=checkinServicio.buscarPorId(idServicio);
			if(checkin==null) {
				return "redirect:/vistas/checkin/";
			}
		}else {
			return "redirect:/vistas/checkin/";
		}
		
		//Invocar el servicio de eliminar
		checkinServicio.eliminar(idServicio);
		return "redirect:/vistas/checkin/";
	}
	
}
