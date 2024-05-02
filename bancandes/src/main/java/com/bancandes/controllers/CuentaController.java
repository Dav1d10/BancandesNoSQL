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
import com.bancandes.exceptions.SaldoInsuficienteException;
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

    if (cuenta.getEstado_cuenta().name().equals("CERRADA") && cuenta.getSaldo() != 0) {
        return "redirect:/cuentas";
    }
    if (cuentaRepository.darCuenta(id).getEstado_cuenta().toString().equals("CERRADA") && cuenta.getEstado_cuenta().name().equals("DESACTIVADA")) {
        return "redirect:/cuentas";
    }

    cuentaRepository.actualizarCuenta(id,
    cuenta.getSaldo(),
    cuenta.getFecha_ultima_transaccion(),
    cuenta.getFecha_creacion(),
    cuenta.getTipo_cuenta().toString(),
    cuenta.getEstado_cuenta().toString());
    
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


    @PostMapping("/cuentas/operacioncuentas/save/serializable")
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


    @PostMapping("/cuentas/operacioncuentas/save/readcommitted")
    public String consignacionCuentaConFantasmas(RedirectAttributes redirectAttributes,@RequestParam("numero_cuenta")Integer numero_cuenta, @RequestParam("cantidad_consignacion")Integer cantidad_consignacion) {
        if (numero_cuenta != null && cantidad_consignacion != null) {
            try {
                cuentasServicio.consignacionCuentaReadCommited(numero_cuenta, cantidad_consignacion);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo completar la transferencia.");
            }
        }
        return "redirect:/cuentas";
    }


    @PostMapping("/cuentas/operacioncuentas/save/serializable/retiro")
    public String retiroCuentaSinFantasmas(RedirectAttributes redirectAttributes,@RequestParam("numero_cuenta")Integer numero_cuenta, @RequestParam("cantidad_consignacion")Integer cantidad_consignacion) {
        if (numero_cuenta != null && cantidad_consignacion != null) {
            try {
                cuentasServicio.retiroCuentaSerializable(numero_cuenta, cantidad_consignacion);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo completar la transferencia.");
            }
        }
        return "redirect:/cuentas";
    }


    @PostMapping("/cuentas/operacioncuentas/save/readcommitted/retiro")
    public String retiroCuentaConFantasmas(RedirectAttributes redirectAttributes,@RequestParam("numero_cuenta")Integer numero_cuenta, @RequestParam("cantidad_consignacion")Integer cantidad_consignacion) {
        if (numero_cuenta != null && cantidad_consignacion != null) {
            try {
                cuentasServicio.retiroCuentaReadCommitted(numero_cuenta, cantidad_consignacion);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo completar la transferencia.");
            }
        }
        return "redirect:/cuentas";
    }


    @PostMapping("/cuentas/operacioncuentas/save/serializable/transferencia")
    public String transferenciaCuentaSinFantasmas(RedirectAttributes redirectAttributes, @RequestParam("numero_cuenta_origen") Integer numero_cuenta_origen, @RequestParam("numero_cuenta_destino") Integer numero_cuenta_destino, @RequestParam("cantidad_transferencia") Integer cantidad_transferencia) {
        if (numero_cuenta_origen != null && numero_cuenta_destino != null && cantidad_transferencia != null) {
            try {
                cuentasServicio.transferenciaCuentasSerializable(numero_cuenta_origen, numero_cuenta_destino, cantidad_transferencia);
            } catch (SaldoInsuficienteException e) {
                redirectAttributes.addFlashAttribute("errorMessage", "No hay suficiente saldo en al cuenta origen.");
                System.out.println("Mensaje de error agregado correctamente: " + e.getMessage());
            }
        }
        return "redirect:/cuentas/operacioncuentas";
    }


    @PostMapping("/cuentas/operacioncuentas/save/readcommitted/transferencia")
    public String transferenciaCuentaConFantasmas(RedirectAttributes redirectAttributes, @RequestParam("numero_cuenta_origen") Integer numero_cuenta_origen, @RequestParam("numero_cuenta_destino") Integer numero_cuenta_destino, @RequestParam("cantidad_transferencia") Integer cantidad_transferencia) {
        if (numero_cuenta_origen != null && numero_cuenta_destino != null && cantidad_transferencia != null) {
            try {
                cuentasServicio.transferenciaCuentasReadCommitted(numero_cuenta_origen, numero_cuenta_destino, cantidad_transferencia);
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("errorMessage", "No se pudo completar la transferencia.");
            }
        }
        return "redirect:/cuentas";
    }

    
}
