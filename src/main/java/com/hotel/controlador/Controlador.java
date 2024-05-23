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
import com.hotel.modelo.servicio.IEmpleadoServicio;



@Controller
@RequestMapping("/vistas/empleados")
public class Controlador {
    
    @Autowired
    private IEmpleadoServicio empleadoServicio;


    @GetMapping("/")
    public String listarEmpleados(Model modelo) {
        List<Empleado> listadoEmpleados=empleadoServicio.listaTodos();
        modelo.addAttribute("empleado", listadoEmpleados);
        return "/vistas/empleados/listar";
    }

    //Ruta para crear
	@GetMapping("/create")
	public String crear(Model modelo) {
		
		//Crear el objeto de tipo contacto
		Empleado empleado=new Empleado();
		
		modelo.addAttribute("titulo","Formulario: Nuevo Empleado");
		modelo.addAttribute("empleado",empleado);
		return "/vistas/empleados/registroempleado";
		
	}
    	//Ruta para guardar
	@PostMapping("/save")
	public String guardar(@ModelAttribute Empleado empleado,Model modelo) {
		modelo.addAttribute("titulo","Formulario: Nuevo Empleado");
		modelo.addAttribute("empleado",empleado);
		//Utilizar el servicio para almacenar en la BD
		empleadoServicio.guardar(empleado);
		return "redirect:/vistas/empleados/";
	}

    //Ruta para editar
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idEmpleado,Model modelo) {
		
		Empleado empleado=new Empleado();
		//Validar si el ID existe
		if(idEmpleado>0) {
			empleado=empleadoServicio.buscarPorId(idEmpleado);
			if(empleado==null) {
				return "redirect:/vistas/empleados/";
			}
		}else {
			return "redirect:/vistas/empleados/";
		}
		
		modelo.addAttribute("titulo","Formulario: Editar Empleado");
		modelo.addAttribute("empleado",empleado);
		return "/vistas/empleados/registroempleado";
	}
	
	//Ruta para eliminar
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Integer idEmpleado) {
		
		Empleado empleado=new Empleado();
		//Validar si el ID existe
		if(idEmpleado>0) {
			empleado=empleadoServicio.buscarPorId(idEmpleado);
			if(empleado==null) {
				return "redirect:/vistas/empleados/";
			}
		}else {
				return "redirect:/vistas/empleados/";
		}
		
		//Invocar el servicio de eliminar
		empleadoServicio.eliminar(idEmpleado);
		return "redirect:/vistas/empleados/";
	}

	@GetMapping("/{id}")
	public ResponseEntity<Empleado> buscarPorId(@PathVariable Integer id) {
		Empleado empleado = empleadoServicio.buscarPorId(id);
		
		if(empleado != null) {
			return ResponseEntity.ok(empleado);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
	
}
