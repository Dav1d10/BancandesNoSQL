package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.GerenteOficina;
import com.bancandes.repository.GerenteOficinaRepository;

@Controller
public class GerenteOficinaController {
    
    @Autowired
    private GerenteOficinaRepository gerenteOficinaRepository;


    
    @GetMapping("/gerentesOficinas/new")
    public String cajeroForm(Model model) {
        model.addAttribute("gerenteOficina", new GerenteOficina(null, null, null, null, null, null, null, null, null, null, 0));
        return "gerenteOficina";
    }
    

    @PostMapping("/gerentesOficinas/new/save")
    public String clienteGuardar(@ModelAttribute GerenteOficina gerenteOficina) {
        gerenteOficinaRepository.insertarGerenteOficina(gerenteOficina.getNumDocumento(), gerenteOficina.getTelefono(), gerenteOficina.getNombre(), 
        gerenteOficina.getNacionalidad(), gerenteOficina.getDireccionFisica(), gerenteOficina.getDireccionElectronica(), gerenteOficina.getDepartamento(), gerenteOficina.getCodigoPostal(),
        gerenteOficina.getCiudad(), gerenteOficina.getTipoDocumento());
        return "redirect:/gerentesOficinas";
    }
}

