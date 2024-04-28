package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.ClienteEntity;
import com.bancandes.repository.ClienteRepository;
import com.bancandes.repository.TieneRepository;
import com.bancandes.repository.CuentaRepository;
import com.bancandes.entities.TieneEntity;
import com.bancandes.entities.TienePK;
import com.bancandes.entities.CuentaEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TieneController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TieneRepository tieneRepository;

    @GetMapping("/tiene/new")
    public String tieneForm(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes());
        model.addAttribute("cuentas", cuentaRepository.darCuentas());
        return "tieneNuevo";
    }
    
    @PostMapping("/tiene/new/save")
    public String tieneGuardar(@ModelAttribute("id_cliente") String idCliente,
            @ModelAttribute("id_cuenta") int idCuenta) {

        CuentaEntity cuenta = cuentaRepository.darCuenta(idCuenta);
        ClienteEntity cliente = clienteRepository.darCliente(idCliente);
        TienePK pk = new TienePK(cuenta, cliente);
        TieneEntity tiene = new TieneEntity();
        tiene.setPk(pk);
        tieneRepository.insertarTiene(tiene.getPk().getNumero_cuenta().getNumero_cuenta(), tiene.getPk().getId_cliente().getNum_documento());
        return "redirect:/cuentas";
    } 
    
}
