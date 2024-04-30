package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bancandes.entities.CuentaEntity;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.servicios.CuentasServicio;


@Controller
public class CuentaController {
    
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private CuentasServicio cuentasServicio;


    @GetMapping("/cuentas")
    public String cuentas(Model model, Integer numero_cuenta, Integer cantidad_consignacion) {
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
        cuenta.getTipo_cuenta().name(), 
        cuenta.getEstado_cuenta().name());
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
    public String cuentaEditarGuardar(RedirectAttributes redirectAttributes, @PathVariable("numero_cuenta") int id, @ModelAttribute CuentaEntity cuenta) {

        if (cuenta.getEstado_cuenta().name() == "CERRADA" && cuenta.getSaldo() != 0) {
            return "redirect:/cuentas";
        }

        cuentaRepository.actualizarCuenta(id, 
        cuenta.getSaldo(), 
        cuenta.getFecha_ultima_transaccion(), 
        cuenta.getFecha_creacion(), 
        cuenta.getTipo_cuenta().name(), 
        cuenta.getEstado_cuenta().name());
        return "redirect:/cuentas";
    }


    @GetMapping("/cuentas/{numero_cuenta}/delete")
    public String cuentaEliminar(@PathVariable("numero_cuenta") int id) {
        cuentaRepository.eliminarCuenta(id);
        return "redirect:/cuentas";
    }


    @GetMapping("/cuentas/operacioncuentas")
    public String mostrarOperacionesCuentas(Model model) {
    return "operacionesCuentas";
}


    @PostMapping("/cuentas/operacioncuentas/save")
    public String consignacionCuentaSinFantasmas(RedirectAttributes redirectAttributes,@RequestParam("numero_cuenta")Integer numero_cuenta, @RequestParam("cantidad_consignacion")Integer cantidad_consignacion) {
        if (numero_cuenta != null && cantidad_consignacion != null) {
            try {
                cuentasServicio.consignacionCuentaSerializable(numero_cuenta, cantidad_consignacion);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo completar la transferencia.");
            }
        }
        return "redirect:/cuentas";
    }
    
}
