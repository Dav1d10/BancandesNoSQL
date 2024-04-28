package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.ClienteEntity;
import com.bancandes.repository.ClienteRepository;
import com.bancandes.repository.EjecutaRepository;
import com.bancandes.repository.OperacionBancariaRepository;
import com.bancandes.entities.EjecutaEntity;
import com.bancandes.entities.EjecutaPK;
import com.bancandes.entities.OperacionBancariaEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EjecutaController {

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EjecutaRepository ejecutaRepository;

    @GetMapping("/ejecuta/new")
    public String ejecutaForm(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes());
        model.addAttribute("operacionesbancarias", operacionBancariaRepository.darOperacionesBancarias());
        return "ejecutaNuevo";
    }
    
    @PostMapping("/ejecuta/new/save")
    public String ejecutaGuardar(@ModelAttribute("id_cliente") String idCliente,
            @ModelAttribute("id_operacionbancaria") int idOperacionBancaria) {

        OperacionBancariaEntity operacionbancaria = operacionBancariaRepository.darOperacionBancaria(idOperacionBancaria);
        ClienteEntity cliente = clienteRepository.darCliente(idCliente);
        EjecutaPK pk = new EjecutaPK(operacionbancaria, cliente);
        EjecutaEntity ejecuta = new EjecutaEntity();
        ejecuta.setPk(pk);
        ejecutaRepository.insertarEjecuta(ejecuta.getPk().getIdOperacionBancaria().getId(), ejecuta.getPk().getIdCliente().getNum_documento());
        return "redirect:/operacionesbancarias";
    } 
    
}
