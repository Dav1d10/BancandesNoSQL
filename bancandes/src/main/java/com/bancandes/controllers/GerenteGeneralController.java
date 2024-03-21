package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.GerenteGeneral;
import com.bancandes.repository.GerenteGeneralRepository;

@Controller
public class GerenteGeneralController {
    
    @Autowired
    private GerenteGeneralRepository gerenteGereralRepository;


    
    @GetMapping("/gerentesGenerales/new")
    public String cajeroForm(Model model) {
        model.addAttribute("gerenteGeneral", new GerenteGeneral());
        return "gerenteGeneral";
    }
    

    @PostMapping("/gerentesGenerales/new/save")
    public String clienteGuardar(@ModelAttribute GerenteGeneral gerenteGeneral) {
        gerenteGereralRepository.insertarGerenteGeneral(gerenteGeneral.getNumDocumento(), gerenteGeneral.getTelefono(), gerenteGeneral.getNombre(), 
        gerenteGeneral.getNacionalidad(), gerenteGeneral.getDireccionFisica(), gerenteGeneral.getDireccionElectronica(), gerenteGeneral.getDepartamento(), gerenteGeneral.getCodigoPostal(),
        gerenteGeneral.getCiudad(), gerenteGeneral.getTipoDocumento());
        
        return "redirect:/gerentesGenerales";
    }
}
