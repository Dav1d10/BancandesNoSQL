package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.PuntoAtencionEntity;
import com.bancandes.repository.PuntoAtencionRepository;

@Controller
public class PuntoAtencionController {

    @Autowired
    private PuntoAtencionRepository puntoAtencionRepository;

    @GetMapping("/puntosAtencion/new")
    public String puntoAtencionForm(Model model) {
        model.addAttribute("puntoAtencion", new PuntoAtencionEntity(null, null, null, null));
        return "puntoAtencion";
    }

    @PostMapping("/puntosAtencion/new/save")
    public String PuntoAtencionGuardar(@ModelAttribute PuntoAtencionEntity puntoAtencion) {
        puntoAtencionRepository.insertarPuntoAtencion(puntoAtencion.getLocalizacion(),
        puntoAtencion.getTipo_punto_atencion());
        
        return "redirect:/puntosAtencion";
    }
    
}
