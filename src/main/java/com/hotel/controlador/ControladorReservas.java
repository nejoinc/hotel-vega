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

import com.hotel.modelo.entidad.Reservas;
import com.hotel.modelo.servicio.IReservasServicio;

@Controller 
@RequestMapping("/vistas/reservas")
public class ControladorReservas {
    @Autowired 
    private IReservasServicio reservasServicio; 

    @GetMapping("/") 
    public String listarReservas(Model modelo) {
        List<Reservas> listadoReservas=reservasServicio.listaTodos(); 
        modelo.addAttribute("reservas", listadoReservas);
        return "/vistas/reservas/listar";
    }

    @GetMapping("/create") 
    public String crear(Model modelo) {
        Reservas reservas = new Reservas();

        modelo.addAttribute("titulo", "Formulario Reserva"); 
        modelo.addAttribute("reservas", reservas); 
        return "/vistas/reservas/reservar";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Reservas reservas, Model modelo) {
        modelo.addAttribute("titulo", "Fomrulario guardar reserva"); 
        modelo.addAttribute("reservas", reservas); 
        reservasServicio.guardar(reservas);
        return "redirect:/vistas/reservas/";         
    }

    @GetMapping("/edit/{id}") 
    public String editar(@PathVariable("id") int idReserva, Model modelo) {
        Reservas reservas = new Reservas();
         
        if(idReserva>0) {
            reservas=reservasServicio.buscarPorId(idReserva); 
            if(reservas==null) {
                return "redirect:/vistas/reservas/";
            } 
        } else {
            return "redirect:/vistas/reservas/";
        }

        modelo.addAttribute("titulo", "Formulario editar reserva"); 
        modelo.addAttribute("reservas", reservas); 
        return "/vistas/reservas/reservar"; 
    }

     
    @GetMapping("/delete/{id}") 
    public String eliminar(@PathVariable("id") Integer idReserva) {
        Reservas reservas = new Reservas(); 
        if(idReserva>0) {
            reservas=reservasServicio.buscarPorId(idReserva); 
            if(reservas==null) {
                return "redirect:/vistas/reservas/"; 
            } 
        } else {
            return "redirect:/vistas/reservas/";
        }

        reservasServicio.eliminar(idReserva);
        return "redirect:/vistas/reservas/";
    }

    

}
