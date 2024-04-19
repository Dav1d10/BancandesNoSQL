package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancandes.entities.PuntoAtencionEntity;
import com.bancandes.repository.PuntoAtencionRepository;

@Controller
public class PuntoAtencionController {

    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/puntosAtencion/new")
    public String puntoAtencionForm(Model model) {
        model.addAttribute("puntoAtencion", new PuntoAtencionEntity());
        return "puntoAtencionForm";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String guardarPuntoAtencion(@ModelAttribute PuntoAtencionEntity puntoAtencion, RedirectAttributes redirectAttributes) {
        try {
            puntoAtencionRepository.insertarPuntoAtencion(
                                                         puntoAtencion.getLocalizacion(),
                                                         puntoAtencion.getTipo_punto_atencion());
            redirectAttributes.addFlashAttribute("successMessage", "Punto de atención creado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error al crear el punto de atención.");
        }
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/delete/{id}")
    public String eliminarPuntoAtencion(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            puntoAtencionRepository.eliminarPuntoAtencion(id);
            redirectAttributes.addFlashAttribute("successMessage", "Punto de atención eliminado exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "No se puede eliminar el punto de atención, ya que tiene operaciones asociadas.");
        }
        return "redirect:/puntosAtencion";
    }
}
