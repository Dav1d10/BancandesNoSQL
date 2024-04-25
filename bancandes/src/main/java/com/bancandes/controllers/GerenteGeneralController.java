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
        gerenteRepository.insertarGerenteGeneral(gerente.getNumDocumento(), gerente.getTelefono(), gerente.getNombre(), 
        gerente.getNacionalidad(), gerente.getDireccionFisica(), gerente.getDireccionElectronica(), gerente.getDepartamento(), gerente.getCodigoPostal(),
        gerente.getCiudad(), gerente.getTipoDocumento().name());

        return "redirect:/gerentesgenerales";
    }

    @GetMapping("/gerentesgenerales/{numDocumento}/edit")
    public String gerenteGeneralEditarForm(@PathVariable("numDocumento") String id, Model model) {
        GerenteGeneral gerente = gerenteRepository.darGerenteGeneral(id);
        if (gerente != null) {
            model.addAttribute("gerente", gerente);
            return "gerenteEditar";
        } else {
            return "redirect:/gerentesgenerales";
        }
    }

    @PostMapping("/gerentesgenerales/{numDocumento}/edit/save")
    public String gerenteGeneralEditarGuardar(@PathVariable("numDocumento") String id, @ModelAttribute GerenteGeneral gerente) {
        gerenteRepository.actualizarCliente(gerente.getNumDocumento(), 
        gerente.getTelefono(), 
        gerente.getNombre(), 
        gerente.getNacionalidad(), 
        gerente.getDireccionFisica(),
        gerente.getDireccionElectronica(), 
        gerente.getDepartamento(), 
        gerente.getCodigoPostal(), 
        gerente.getCiudad(),
        gerente.getTipoDocumento().name());
        return "redirect:/gerentesgenerales";
    }

    @GetMapping("/gerentesgenerales/{numDocumento}/delete")
    public String gerenteGeneralEliminar(@PathVariable("numDocumento") String id) {
        gerenteRepository.eliminarCliente(id);
        return "redirect:/gerentesgenerales";
    }
    
}

