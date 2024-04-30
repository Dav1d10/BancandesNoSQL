package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.OficinaEntity;
import com.bancandes.entities.GerenteOficina;
import com.bancandes.repository.OficinaRepository;
import com.bancandes.repository.ManejaRepository;
import com.bancandes.repository.GerenteOficinaRepository;
import com.bancandes.entities.ManejaEntity;
import com.bancandes.entities.ManejaPK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManejaController {

    @Autowired
    private OficinaRepository oficinaRepository;

    @Autowired
    private GerenteOficinaRepository gerenteOficinaRepository;

    @Autowired
    private ManejaRepository manejaRepository;

    @GetMapping("/maneja/new")
    public String manejaForm(Model model) {
        model.addAttribute("gerentesoficina", gerenteOficinaRepository.darGerentesOficinas());
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        return "manejaNuevo";
    }
    
    @PostMapping("/maneja/new/save")
    public String manejaGuardar(@ModelAttribute("id_gerenteoficina") String idGerenteOficina,
            @ModelAttribute("id_oficina") int idOficina) {

        OficinaEntity oficina = oficinaRepository.darOficina(idOficina);
        GerenteOficina gerenteOficina = gerenteOficinaRepository.darGerenteOficina(idGerenteOficina);
        ManejaPK pk = new ManejaPK(gerenteOficina, oficina);
        ManejaEntity maneja = new ManejaEntity();
        maneja.setPk(pk);
        manejaRepository.insertarManeja(maneja.getPk().getId_oficina().getId_oficina(), maneja.getPk().getId_gerenteoficina().getNum_documento());
        return "redirect:/oficinas";
    } 
    
}
