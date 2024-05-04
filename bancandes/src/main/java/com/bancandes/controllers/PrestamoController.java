package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.PrestamoEntity;
import com.bancandes.repository.PrestamoRepository;

@Controller
public class PrestamoController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping("/prestamos")
    public String prestamos(Model model) {
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        return "prestamos";
    }

    @GetMapping("/prestamos/new")
    public String prestamoForm(Model model) {
        model.addAttribute("prestamo", new PrestamoEntity());
        return "prestamoNuevo";
    }

    @PostMapping("/prestamos/new/save")
    public String prestamoGuardar(@ModelAttribute PrestamoEntity prestamo) {
        prestamoRepository.insertarPrestamo(
        prestamo.getMonto(),
        prestamo.getInteres(),
        prestamo.getNumero_cuotas(),
        prestamo.getDia_pago(),
        prestamo.getValor_cuota(), 
        prestamo.getEstado_prestamo().name(),
        prestamo.getCategoria().name());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id_prestamo}/edit")
    public String prestamoEditarForm(@PathVariable("id_prestamo") long id_prestamo, Model model) {
        PrestamoEntity prestamo = prestamoRepository.darPrestamo(id_prestamo);
        if (prestamo != null) {
            model.addAttribute("prestamo", prestamo);
            return "prestamoEditar";
        } else {
            return "redirect:/prestamos";
        }
    }

    @PostMapping("/prestamos/{id_prestamo}/edit/save")
    public String prestamoEditarGuardar(@PathVariable("id_prestamo") long id_prestamo, @ModelAttribute PrestamoEntity prestamo) {
        prestamoRepository.actualizarPrestamo(((long) id_prestamo),
        prestamo.getMonto(),
        prestamo.getInteres(),
        prestamo.getNumero_cuotas(),
        prestamo.getDia_pago(),
        prestamo.getValor_cuota(), 
        prestamo.getEstado_prestamo().name(),
        prestamo.getCategoria().name());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id_prestamo}/delete")
    public String prestamoEliminar(@PathVariable("id_prestamo") long id_prestamo) {
        prestamoRepository.eliminarPrestamo(id_prestamo);
        return "redirect:/prestamos";
    }
    
}
