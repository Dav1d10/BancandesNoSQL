package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.bancandes.entities.CuentaEntity;
import com.bancandes.repository.CuentaRepository;

@Controller
public class CuentaController {
    
    @Autowired
    private CuentaRepository cuentaRepository;


    @GetMapping("/cuentas")
    public String cuentas(Model model) {
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "cuentas";
    }

    @GetMapping("/cuentas/new")
    public String cuentaForm(Model model) {
        model.addAttribute("cuenta", new CuentaEntity());
        return "cuentaNuevo";
    }

    @PostMapping("/cuentas/new/save")
    public String cuentaGuardar(@ModelAttribute CuentaEntity cuenta) {
        cuentaRepository.insertarCuenta(cuenta.getSaldo(), 
        cuenta.getFecha_ultima_transaccion(), 
        cuenta.getFecha_creacion(), 
        cuenta.getTipo_cuenta(), 
        cuenta.getEstado_cuenta());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{numero_cuenta}/edit")
    public String cuentaEditarForm(@PathVariable("numero_cuenta") int id, Model model) {
        CuentaEntity cuenta = cuentaRepository.darCuenta(id);
        if (cuenta != null) {
            model.addAttribute("cuenta", cuenta);
            return "cuentaEditar";
        } else {
            return "redirect:/cuentas";
        }
    }

    @PostMapping("/cuentas/{numero_cuenta}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("numero_cuenta") int id, @ModelAttribute CuentaEntity cuenta) {
        cuentaRepository.actualizarCuenta(cuenta.getSaldo(), 
        cuenta.getFecha_ultima_transaccion(), 
        cuenta.getFecha_creacion(), 
        cuenta.getTipo_cuenta(), 
        cuenta.getEstado_cuenta());
        return "redirect:/cuentas";
    }

    @GetMapping("/cuentas/{numero_cuenta}/delete")
    public String cuentaEliminar(@PathVariable("numero_cuenta") int id) {
        cuentaRepository.eliminarCuenta(id);
        return "redirect:/cuentas";
    }
    
}
