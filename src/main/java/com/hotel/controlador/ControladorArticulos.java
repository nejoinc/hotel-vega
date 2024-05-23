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
import com.hotel.modelo.servicio.IArticulosServicio;

@Controller 
@RequestMapping("/vistas/habitaciones")
public class ControladorArticulos {
    @Autowired 
    private IArticulosServicio articulosServicio; 




    @GetMapping("/createart")
    public String crear(Model modelo) {
      
      //Crear el objeto de tipo contacto
      Articulos articulos=new Articulos();
      
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("articulos",articulos);
      return "/vistas/habitaciones/creararticulos";
      
    }

    @PostMapping("/saveart")
    public String guardar(@ModelAttribute Articulos articulos,Model modelo) {
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("articulos",articulos);
      //Utilizar el servicio para almacenar en la BD
      articulosServicio.guardar(articulos);
      return "redirect:/vistas/habitaciones/";
    }


     @GetMapping("/editart/{id}")
    public String editar(@PathVariable("id") int idArticulo,Model modelo) {
      
      Articulos articulos=new Articulos();
      if(idArticulo>0) {
        articulos=articulosServicio.buscarPorId(idArticulo);
        if(articulos==null) {
          return "redirect:/vistas/habitaciones/";
        }
      }else {
        return "redirect:/vistas/habitaciones/";
      }
      
      modelo.addAttribute("titulo","Formulario: Editar Empleado");
      modelo.addAttribute("articulos",articulos);
      return "/vistas/habitaciones/creararticulos";
    }

     //Ruta para eliminar
	@GetMapping("/deleteart/{id}")
	public String eliminar(@PathVariable("id") Integer idArticulo) {
		
		Articulos articulos=new Articulos();
		//Validar si el ID existe
		if(idArticulo>0) {
			articulos=articulosServicio.buscarPorId(idArticulo);
			if(articulos==null) {
				return "redirect:/vistas/habitaciones/";
			}
		}else {
				return "redirect:/vistas/habitaciones/";
		}
		
		//Invocar el servicio de eliminar
		articulosServicio.eliminar(idArticulo);
		return "redirect:/vistas/habitaciones/";
	}


}
