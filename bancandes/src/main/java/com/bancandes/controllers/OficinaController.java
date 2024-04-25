package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.OficinaEntity;
import com.bancandes.repository.OficinaRepository;

@Controller
public class OficinaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @GetMapping("/oficinas")
    public String oficinas(Model model) {
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        return "oficinas";
    }

    @GetMapping("/oficinas/new")
    public String oficinaForm(Model model) {
        model.addAttribute("oficina", new OficinaEntity());
        return "oficina";
    }

    @PostMapping("/oficinas/new/save")
    public String oficinaGuardar(@ModelAttribute OficinaEntity oficina) {
        oficinaRepository.insertarOficina(oficina.getNombre(),
                                          oficina.getDireccion(),
                                          oficina.getPuntos_atencion());
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{id_oficina}/edit")
    public String oficinaEditarForm(@PathVariable("id_oficina") int id, Model model) {
        OficinaEntity oficina = oficinaRepository.darOficina(id);
        if (oficina != null) {
            model.addAttribute("oficina", oficina);
            return "oficinaEditar";
        } else {
            return "redirect:/oficinas";
        }
    }

    @PostMapping("/oficinas/{id_oficina}/edit/save")
    public String oficinaEditarGuardar(@PathVariable("id_oficina") int id, @ModelAttribute OficinaEntity oficina) {
        oficinaRepository.actualizarOficina(oficina.getNombre(),
                                            oficina.getDireccion(),
                                            oficina.getPuntos_atencion());
        return "redirect:/oficinas";
    }

    @GetMapping("/oficinas/{id_oficina}/delete")
    public String oficinaEliminar(@PathVariable("id_oficina") int id_oficina) {
        oficinaRepository.eliminarOficina(id_oficina);
        return "redirect:/oficinas";
    }

}
    

