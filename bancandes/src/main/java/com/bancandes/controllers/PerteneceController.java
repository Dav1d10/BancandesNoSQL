package com.bancandes.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.entities.OficinaEntity;
import com.bancandes.entities.PerteneceEntity;
import com.bancandes.entities.PertenecePK;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.repository.OficinaRepository;
import com.bancandes.repository.PerteneceRepository;


@Controller
public class PerteneceController {
    @Autowired
    private CuentaRepository cuentaRepository; //bebedor

    @Autowired
    private OficinaRepository oficinaRepository; //bebida

    @Autowired
    private PerteneceRepository perteneceRepository; //gustan

    @GetMapping("/pertenece/new")
    public String perteneceForm(Model model) {
        model.addAttribute("oficinas", oficinaRepository.darOficinas());
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "perteneceNuevo";
    }

    @PostMapping("/pertenece/new/save")
    public String gustanGuardar(@ModelAttribute("id_oficina") int idOficina,
            @ModelAttribute("id_cuenta") int idCuenta) {

        CuentaEntity cuenta = cuentaRepository.darCuenta(idCuenta);
        OficinaEntity oficina = oficinaRepository.darOficina(idOficina);
        PertenecePK pk = new PertenecePK(cuenta, oficina);
        PerteneceEntity pertenece = new PerteneceEntity();
        pertenece.setPk(pk);
        perteneceRepository.insertarPertenece(pertenece.getPk().getId_cuenta().getNumero_cuenta(), pertenece.getPk().getId_oficina().getId_oficina());
        return "redirect:/oficinas";
    }
}


