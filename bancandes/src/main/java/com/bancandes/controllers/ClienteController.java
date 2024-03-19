package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.ClienteEntity;
import com.bancandes.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ClienteController {
    

    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes())
        return "clientes";
    }
    
    @GetMapping("/clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new ClienteEntity(null, null, null, null, null, null, null, null, null, null));
        return "cliente";
    }
    

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute ClienteEntity cliente) {
        clienteRepository.insertarCliente(cliente.getNumDocumento(), cliente.getTelefono(), cliente.getNombre(), 
        cliente.getNacionalidad(), cliente.getDireccionFisica(), cliente.getDireccionElectronica(), cliente.getDepartamento(), cliente.getCodigoPostal(),
        cliente.getCiudad(), cliente.getTipoDocumento());
        
        return "redirect:/clientes";
    }
    
}
