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
        model.addAttribute("opsBancarias", operacionBancariaRepository.darOperacionesBancarias());
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "haceNuevo";
    }
    
    @PostMapping("/hace/new/save")
    public String haceGuardar(@ModelAttribute("id") Integer idOpBancaria,
            @ModelAttribute("numero_cuenta") Integer numeroCuenta) {

        CuentaEntity cuenta = cuentaRepository.darCuenta(numeroCuenta);
        OperacionBancariaEntity opBancaria = operacionBancariaRepository.darOperacionBancaria(idOpBancaria);
        HacePK pk = new HacePK(opBancaria, cuenta);
        HaceEntity hace = new HaceEntity();
        hace.setPk(pk);
        haceRepository.insertarHace(hace.getPk().getIdCuenta().getNumero_cuenta(), hace.getPk().getIdOperacionBancaria().getId());
        
        return "redirect:/bebidas";
    } 
}
