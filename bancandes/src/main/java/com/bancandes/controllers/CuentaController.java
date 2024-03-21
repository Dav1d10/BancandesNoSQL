package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.repository.CuentaRepository;

@Controller
public class CuentaController {
    
    @Autowired
    private CuentaRepository cuentaRepository;

    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new CuentaEntity());
        return "cuenta";
    }

    @PostMapping("/cuentas/new/save")
    public String PuntoAtencionGuardar(@ModelAttribute CuentaEntity cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getSaldo(), cuenta.getFecha_ultima_transaccion(), cuenta.getFecha_creacion(), cuenta.getTipo_cuenta(), cuenta.getEstado_cuenta());
        
        return "redirect:/cuentas";
    }
    
}
