package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.bancandes.entities.OperacionPrestamoEntity;
import com.bancandes.repository.OperacionPrestamoRepository;

@Controller
public class OperacionPrestamoController {

    @Autowired
    private OperacionPrestamoRepository operacionPrestamoRepository;


    @GetMapping("/operacionesprestamos")
    public String operacionesPrestamos(Model model) {
        model.addAttribute("operacionesprestamos", operacionPrestamoRepository.darOperacionesPrestamos());
        return "operacionesprestamos";
    }

    @GetMapping("/operacionesprestamos/new")
    public String operacionPrestamoForm(Model model) {
        model.addAttribute("operacionprestamo", new OperacionPrestamoEntity());
        return "operacionprestamoNuevo";
    }

    @PostMapping("/operacionesprestamos/new/save")
    public String operacionPrestamoGuardar(@ModelAttribute OperacionPrestamoEntity operacionPrestamo) {
        operacionPrestamoRepository.insertarOperacionPrestamo(operacionPrestamo.getValor(),
        operacionPrestamo.getFecha(),
        operacionPrestamo.getPrestamo_afectado(),
        operacionPrestamo.getTipo_operacion().name(),
        operacionPrestamo.getProducto_prestamo().name());
        return "redirect:/operacionesprestamos";
    }

    @GetMapping("/operacionesprestamos/{id}/edit")
    public String operacionPrestamoEditarForm(@PathVariable("id") int id, Model model) {
        OperacionPrestamoEntity operacionPrestamo = operacionPrestamoRepository.darOperacionPrestamo(id);
        if (operacionPrestamo != null) {
            model.addAttribute("operacionprestamo", operacionPrestamo);
            return "operacionprestamoEditar";
        } else {
            return "redirect:/operacionesprestamos";
        }
    }

    @PostMapping("/operacionesprestamos/{id}/edit/save")
    public String operacionPrestamoEditarGuardar(@PathVariable("id") int id, @ModelAttribute OperacionPrestamoEntity operacionPrestamo) {
        operacionPrestamoRepository.actualizarOperacionPrestamo(id, operacionPrestamo.getValor(),
        operacionPrestamo.getFecha(),
        operacionPrestamo.getPrestamo_afectado(),
        operacionPrestamo.getTipo_operacion().name(),
        operacionPrestamo.getProducto_prestamo().name());
        return "redirect:/operacionesprestamos";
    }

    @GetMapping("/operacionesprestamos/{id}/delete")
    public String operacionPrestamoEliminar(@PathVariable("id") int id) {
        operacionPrestamoRepository.eliminarOperacionPrestamo(id);
        return "redirect:/operacionesprestamos";
    }
}
