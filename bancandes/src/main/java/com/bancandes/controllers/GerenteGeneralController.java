package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.GerenteGeneral;
import com.bancandes.repository.GerenteGeneralRepository;

@Controller
public class GerenteGeneralController {
    
   


    @Autowired
    private GerenteGeneralRepository gerenteRepository;


    @GetMapping("/gerentesgenerales")
    public String gerenteGeneral(Model model) {
        model.addAttribute("gerentesgenerales", gerenteRepository.darGerentesGenerales());
        return "gerentesgenerales";
    }

    @GetMapping("/gerentesgenerales/new")
    public String gerenteGeneralForm(Model model) {
        model.addAttribute("gerentegeneral", new GerenteGeneral());
        return "gerentegeneralNuevo";
    }


    @PostMapping("/gerentesgenerales/new/save")
    public String gerenteGeneralGuardar(@ModelAttribute GerenteGeneral gerente) {
        gerenteRepository.insertarGerenteGeneral(gerente.getNum_documento(), gerente.getTelefono(), gerente.getNombre(), 
        gerente.getNacionalidad(), gerente.getDireccion_fisica(), gerente.getDireccion_electronica(), gerente.getDepartamento(), gerente.getCodigo_postal(),
        gerente.getCiudad(), gerente.getTipo_documento().name());

        return "redirect:/gerentesgenerales";
    }

    @GetMapping("/gerentesgenerales/{num_documento}/edit")
    public String gerenteGeneralEditarForm(@PathVariable("num_documento") String id, Model model) {
        GerenteGeneral gerente = gerenteRepository.darGerenteGeneral(id);
        if (gerente != null) {
            model.addAttribute("gerentegeneral", gerente);
            return "gerenteGeneralEditar";
        } else {
            return "redirect:/gerentesgenerales";
        }
    }

    @PostMapping("/gerentesgenerales/{num_documento}/edit/save")
    public String gerenteGeneralEditarGuardar(@PathVariable("num_documento") String id, @ModelAttribute GerenteGeneral gerente) {
        gerenteRepository.actualizarGerenteGeneral(gerente.getNum_documento(), 
        gerente.getTelefono(), 
        gerente.getNombre(), 
        gerente.getNacionalidad(), 
        gerente.getDireccion_fisica(),
        gerente.getDireccion_electronica(), 
        gerente.getDepartamento(), 
        gerente.getCodigo_postal(), 
        gerente.getCiudad(),
        gerente.getTipo_documento().name());
        return "redirect:/gerentesgenerales";
    }

    @GetMapping("/gerentesgenerales/{num_documento}/delete")
    public String gerenteGeneralEliminar(@PathVariable("num_documento") String id) {
        gerenteRepository.eliminarGerenteGeneral(id);
        return "redirect:/gerentesgenerales";
    }
    
}

