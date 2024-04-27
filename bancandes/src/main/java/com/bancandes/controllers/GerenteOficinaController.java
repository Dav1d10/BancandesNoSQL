package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.GerenteOficina;
import com.bancandes.repository.GerenteOficinaRepository;

@Controller
public class GerenteOficinaController {
    
    @Autowired
    private GerenteOficinaRepository gerenteOficinaRepository;


    
    @GetMapping("/gerentesoficinas")
    public String gerenteOficina(Model model) {
        model.addAttribute("gerentesoficinas", gerenteOficinaRepository.darGerentesOficinas());
        return "gerentesoficinas";
    }

    @GetMapping("/gerentesoficinas/new")
    public String gerenteOficinaForm(Model model) {
        model.addAttribute("gerenteoficina", new GerenteOficina());
        return "gerenteoficinaNuevo";
    }


    @PostMapping("/gerentesoficinas/new/save")
    public String gerenteOficinaGuardar(@ModelAttribute GerenteOficina gerente) {
        gerenteOficinaRepository.insertarGerenteOficina(gerente.getNum_documento(), gerente.getTelefono(), gerente.getNombre(), 
        gerente.getNacionalidad(), gerente.getDireccion_fisica(), gerente.getDireccion_electronica(), gerente.getDepartamento(), gerente.getCodigo_postal(),
        gerente.getCiudad(), gerente.getTipo_documento().name());

        return "redirect:/gerentesoficinas";
    }

    @GetMapping("/gerentesoficinas/{num_documento}/edit")
    public String gerenteOficinaEditarForm(@PathVariable("num_documento") String id, Model model) {
        GerenteOficina gerente = gerenteOficinaRepository.darGerenteOficina(id);
        if (gerente != null) {
            model.addAttribute("gerenteoficina", gerente);
            return "gerenteOficinaEditar";
        } else {
            return "redirect:/gerentesoficinas";
        }
    }

    @PostMapping("/gerentesoficinas/{num_documento}/edit/save")
    public String gerenteOficinaEditarGuardar(@PathVariable("num_documento") String id, @ModelAttribute GerenteOficina gerente) {
        gerenteOficinaRepository.actualizarGerenteOficina(gerente.getNum_documento(), 
        gerente.getTelefono(), 
        gerente.getNombre(), 
        gerente.getNacionalidad(), 
        gerente.getDireccion_fisica(),
        gerente.getDireccion_electronica(), 
        gerente.getDepartamento(), 
        gerente.getCodigo_postal(), 
        gerente.getCiudad(),
        gerente.getTipo_documento().name());
        return "redirect:/gerentesoficinas";
    }

    @GetMapping("/gerentesoficinas/{num_documento}/delete")
    public String gerenteOficinaEliminar(@PathVariable("num_documento") String id) {
        gerenteOficinaRepository.eliminarGerenteOficina(id);
        return "redirect:/gerentesoficinas";
    }
    
}


