package com.hotel.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.modelo.entidad.Empleado;
import com.hotel.modelo.entidad.Huesped;
import com.hotel.modelo.servicio.IHuespedServicio;

@Controller
@RequestMapping("/vistas/huespedes")
public class ControladorHuespued {
    
    @Autowired
    private IHuespedServicio huespedServicio;

    @GetMapping("/")
    public String listarHuespedes(Model modelo) {
        List<Huesped> listadoHuespedes=huespedServicio.listaTodos();
        modelo.addAttribute("huesped", listadoHuespedes);
        return "/vistas/huespedes/listar";
    }

      //Ruta para crear
    @GetMapping("/create")
    public String crear(Model modelo) {
      
      //Crear el objeto de tipo contacto
      Huesped huesped=new Huesped();
      
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("huesped",huesped);
      return "/vistas/huespedes/registrohuespedes";
      
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Huesped huesped,Model modelo) {
      modelo.addAttribute("titulo","Formulario: Nuevo Huesped");
      modelo.addAttribute("huesped",huesped);
      //Utilizar el servicio para almacenar en la BD
      huespedServicio.guardar(huesped);
      return "redirect:/vistas/huespedes/";
    }

     //Ruta para editar
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idHuespede,Model modelo) {
		
		Huesped huesped=new Huesped();
		if(idHuespede>0) {
			huesped=huespedServicio.buscarPorId(idHuespede);
			if(huesped==null) {
				return "redirect:/vistas/huespedes/";
			}
		}else {
			return "redirect:/vistas/huespedes/";
		}
		
		modelo.addAttribute("titulo","Formulario: Editar Empleado");
		modelo.addAttribute("huesped",huesped);
		return "/vistas/huespedes/registrohuespedes";
	}


  //Ruta para eliminar
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idHuespede) {
		
		Huesped huesped=new Huesped();
		//Validar si el ID existe
		if(idHuespede>0) {
			huesped=huespedServicio.buscarPorId(idHuespede);
			if(huesped==null) {
				return "redirect:/vistas/huespedes/";
			}
		}else {
				return "redirect:/vistas/huespedes/";
		}
		
		//Invocar el servicio de eliminar
		huespedServicio.eliminar(idHuespede);
		return "redirect:/vistas/huespedes/";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Huesped> buscarPorId(@PathVariable Integer id) {
		Huesped huesped = huespedServicio.buscarPorId(id);
		
		if(huesped != null) {
			return ResponseEntity.ok(huesped);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
