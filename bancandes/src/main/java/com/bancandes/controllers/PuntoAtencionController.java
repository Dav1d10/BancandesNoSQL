package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


import com.bancandes.entities.PuntoAtencionEntity;
import com.bancandes.repository.PuntoAtencionRepository;

@Controller
public class PuntoAtencionController {

    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/puntosatencion")
    public String puntosAtencion(Model model) {
        model.addAttribute("puntosatencion", puntoAtencionRepository.darPuntosAtencion());
        return "puntosAtencion";
    }

    @GetMapping("/puntosatencion/new")
    public String puntoAtencionForm(Model model) {
        model.addAttribute("puntoatencion", new PuntoAtencionEntity());
        return "puntoAtencionNuevo";
    }

    @PostMapping("/puntosatencion/new/save")
    public String guardarPuntoAtencion(@ModelAttribute PuntoAtencionEntity puntoAtencion) {
        puntoAtencionRepository.insertarPuntoAtencion(puntoAtencion.getLocalizacion(),
        puntoAtencion.getTipo_punto_atencion().name());
        return "redirect:/puntosatencion";
    }

    @GetMapping("/puntosatencion/{id_punto_atencion}/edit")
    public String editarPuntoAtencion(@PathVariable("id_punto_atencion") int id, Model model) {
        PuntoAtencionEntity puntoAtencion = puntoAtencionRepository.darPuntoAtencion(id);
        if (puntoAtencion != null) {
            model.addAttribute("puntoatencion", puntoAtencion);
            return "puntoAtencionEditar";
        } else {
            return "redirect:/puntosatencion";
        }
    }

    @PostMapping("/puntosatencion/{id_punto_atencion}/edit/save")
    public String editarGuardarPuntoAtencion(@PathVariable("id_punto_atencion") int id, @ModelAttribute PuntoAtencionEntity puntoAtencion) {
        puntoAtencionRepository.actualizarPuntoAtencion(id, puntoAtencion.getLocalizacion(),
                                                        puntoAtencion.getTipo_punto_atencion().name());
        return "redirect:/puntosatencion";
    }

    @GetMapping("/puntosatencion/{id_punto_atencion}/delete")
    public String eliminarPuntoAtencion(@PathVariable("id_punto_atencion") int id) {
        puntoAtencionRepository.eliminarPuntoAtencion(id);
        return "redirect:/puntosatencion";
    }
}
