package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.OficinaEntity;
import com.bancandes.repository.OficinaRepository;

@Controller
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/oficinas/new")
    public String oficinaForm(Model model) {
        model.addAttribute("oficina", new OficinaEntity(null, null, null, null, null, null));
        return "oficina";
    }

    @PostMapping("/oficinas/new/save")
    public String PuntoAtencionGuardar(@ModelAttribute OficinaEntity oficina) {
        oficinaRepository.insertarOficina(oficina.getNombre(), oficina.getDireccion(), oficina.getPuntos_atencion());
        
        return "redirect:/oficinas";
    }
    
}
