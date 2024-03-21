package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.CajeroEntity;
import com.bancandes.repository.CajeroRepository;


@Controller
public class CajeroController {
    

    @Autowired
    private CajeroRepository cajeroRepository;


    
    @GetMapping("/cajeros/new")
    public String cajeroForm(Model model) {
        model.addAttribute("cajero", new CajeroEntity());
        return "cajero";
    }
    

    @PostMapping("/cajeros/new/save")
    public String clienteGuardar(@ModelAttribute CajeroEntity cajero) {
        cajeroRepository.insertarCajero(cajero.getNumDocumento(), cajero.getTelefono(), cajero.getNombre(), 
        cajero.getNacionalidad(), cajero.getDireccionFisica(), cajero.getDireccionElectronica(), cajero.getDepartamento(), cajero.getCodigoPostal(),
        cajero.getCiudad(), cajero.getTipoDocumento());
        
        return "redirect:/cajeros";
    }
    
}

