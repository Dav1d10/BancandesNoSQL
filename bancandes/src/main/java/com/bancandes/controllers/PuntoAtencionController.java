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

    @GetMapping("/puntosAtencion")
    public String puntosAtencion(Model model) {
        model.addAttribute("puntosAtencion", puntoAtencionRepository.darPuntosAtencion());
        return "puntosAtencion";
    }

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

    @GetMapping("/puntosAtencion/{id_punto_atencion}/edit")
    public String editarPuntoAtencion(@PathVariable("id_punto_atencion") int id, Model model) {
        PuntoAtencionEntity puntoAtencion = puntoAtencionRepository.darPuntoAtencion(id);
        if (puntoAtencion != null) {
            model.addAttribute("puntoAtencion", puntoAtencion);
            return "editarPuntoAtencion";
        } else {
            return "redirect:/puntosAtencion";
        }
    }

    @PostMapping("/puntosAtencion/{id_punto_atencion}/edit/save")
    public String editarGuardarPuntoAtencion(@PathVariable("id_punto_atencion") int id, @ModelAttribute PuntoAtencionEntity puntoAtencion) {
        puntoAtencionRepository.actualizarPuntoAtencion(puntoAtencion.getLocalizacion(),
                                                        puntoAtencion.getTipo_punto_atencion());
        return "redirect:/puntosAtencion";
    }

    @GetMapping("/puntosAtencion/{id_punto_atencion}/delete")
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
