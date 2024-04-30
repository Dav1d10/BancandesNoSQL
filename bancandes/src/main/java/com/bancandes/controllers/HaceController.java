package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.entities.OperacionBancariaEntity;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.repository.HaceRepository;
import com.bancandes.repository.OperacionBancariaRepository;
import com.bancandes.entities.HaceEntity;
import com.bancandes.entities.HacePK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HaceController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;

    @Autowired
    private HaceRepository haceRepository;

    @GetMapping("/hace/new")
    public String haceForm(Model model) {
        model.addAttribute("operacionesbancarias", operacionBancariaRepository.darOperacionesBancarias());
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "haceNuevo";
    }
    
    @PostMapping("/hace/new/save")
    public String haceGuardar(@ModelAttribute("id_operacionbancaria") int idOperacionbancaria,
            @ModelAttribute("id_cuenta") int idCuenta) {

        CuentaEntity cuenta = cuentaRepository.darCuenta(idCuenta);
        OperacionBancariaEntity operacionBancaria = operacionBancariaRepository.darOperacionBancaria(idOperacionbancaria);
        HacePK pk = new HacePK(operacionBancaria, cuenta);
        HaceEntity hace = new HaceEntity();
        hace.setPk(pk);
        if (cuenta.getEstado_cuenta().name() != "CERRADA" && cuenta.getEstado_cuenta().name() != "CERRADA") {
        haceRepository.insertarHace(hace.getPk().getId_cuenta().getNumero_cuenta(), hace.getPk().getId_operacionbancaria().getId());
        }
        
        return "redirect:/cuentas";
    } 
}
