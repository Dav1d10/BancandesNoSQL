package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.CajeroEntity;
import com.bancandes.repository.CajeroRepository;


@Controller
public class CajeroController {
    

    @Autowired
    private CajeroRepository cajeroRepository;


    @GetMapping("/cajeros")
    public String cajero(Model model) {
        model.addAttribute("cajeros", cajeroRepository.darCajeros());
        return "cajeros";
    }

    @GetMapping("/cajeros/new")
    public String cajeroForm(Model model) {
        model.addAttribute("cajero", new CajeroEntity());
        return "cajeroNuevo";
    }


    @PostMapping("/cajeros/new/save")
    public String cajeroGuardar(@ModelAttribute CajeroEntity cajero) {
        cajeroRepository.insertarCajero(cajero.getNum_documento(), cajero.getTelefono(), cajero.getNombre(), 
        cajero.getNacionalidad(), cajero.getDireccion_fisica(), cajero.getDireccion_electronica(), cajero.getDepartamento(), cajero.getCodigo_postal(),
        cajero.getCiudad(), cajero.getTipo_documento().name());

        return "redirect:/cajeros";
    }

    @GetMapping("/cajeros/{num_documento}/edit")
    public String cajeroEditarForm(@PathVariable("num_documento") String id, Model model) {
        CajeroEntity cajero = cajeroRepository.darCajero(id);
        if (cajero != null) {
            model.addAttribute("cajero", cajero);
            return "cajeroEditar";
        } else {
            return "redirect:/cajeros";
        }
    }

    @PostMapping("/cajeros/{num_documento}/edit/save")
    public String cajeroEditarGuardar(@PathVariable("num_documento") String id, @ModelAttribute CajeroEntity cajero) {
        cajeroRepository.actualizarCajero(cajero.getNum_documento(), 
        cajero.getTelefono(), 
        cajero.getNombre(), 
        cajero.getNacionalidad(), 
        cajero.getDireccion_fisica(),
        cajero.getDireccion_electronica(), 
        cajero.getDepartamento(), 
        cajero.getCodigo_postal(), 
        cajero.getCiudad(),
        cajero.getTipo_documento().name());
        return "redirect:/cajeros";
    }

    @GetMapping("/cajeros/{num_documento}/delete")
    public String cajeroEliminar(@PathVariable("num_documento") String id) {
        cajeroRepository.eliminarCajero(id);
        return "redirect:/cajeros";
    }
    
}


