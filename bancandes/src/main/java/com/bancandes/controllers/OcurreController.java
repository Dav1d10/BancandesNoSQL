package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.OperacionBancariaEntity;
import com.bancandes.entities.PuntoAtencionEntity;
import com.bancandes.repository.OperacionBancariaRepository;
import com.bancandes.repository.OcurreRepository;
import com.bancandes.repository.PuntoAtencionRepository;
import com.bancandes.entities.OcurreEntity;
import com.bancandes.entities.OcurrePK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OcurreController {

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;

    @Autowired
    private PuntoAtencionRepository puntoatencionRepository;

    @Autowired
    private OcurreRepository ocurreRepository;

    @GetMapping("/ocurre/new")
    public String ocurreForm(Model model) {
        model.addAttribute("puntoatencions", puntoatencionRepository.darPuntosAtencion());
        model.addAttribute("operacionesbancarias", operacionBancariaRepository.darOperacionesBancarias());
        return "ocurreNuevo";
    }
    
    @PostMapping("/ocurre/new/save")
    public String ocurreGuardar(@ModelAttribute("id_puntoatencion") int idPuntoatencion,
            @ModelAttribute("id_operacionbancaria") int idOperacionBancaria) {

        OperacionBancariaEntity operacionbancaria = operacionBancariaRepository.darOperacionBancaria(idOperacionBancaria);
        PuntoAtencionEntity puntoatencion = puntoatencionRepository.darPuntoAtencion(idPuntoatencion);
        OcurrePK pk = new OcurrePK(operacionbancaria, puntoatencion);
        OcurreEntity ocurre = new OcurreEntity();
        ocurre.setPk(pk);
        ocurreRepository.insertarOcurre(ocurre.getPk().getIdOperacionBancaria().getId(), ocurre.getPk().getIdPuntoAtencion().getId_punto_atencion());
        return "redirect:/operacionesbancarias";
    }
    
}
