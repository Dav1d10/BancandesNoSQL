package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.ClienteEntity;
import com.bancandes.repository.ClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "clientes";
    }

    @GetMapping("/clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new ClienteEntity());
        return "clienteNuevo";
    }


    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute ClienteEntity cliente) {
        clienteRepository.insertarCliente(cliente.getNumDocumento(), cliente.getTelefono(), cliente.getNombre(), 
        cliente.getNacionalidad(), cliente.getDireccionFisica(), cliente.getDireccionElectronica(), cliente.getDepartamento(), cliente.getCodigoPostal(),
        cliente.getCiudad(), cliente.getTipoDocumento());

        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{numDocumento}/edit")
    public String cuentaEditarForm(@PathVariable("numDocumento") String id, Model model) {
        ClienteEntity cliente = clienteRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEditar";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{numDocumento}/edit/save")
    public String cuentaEditarGuardar(@PathVariable("numDocumento") String id, @ModelAttribute ClienteEntity cliente) {
        clienteRepository.actualizarCliente(cliente.getNumDocumento(), 
        cliente.getTelefono(), 
        cliente.getNombre(), 
        cliente.getNacionalidad(), 
        cliente.getDireccionFisica(),
        cliente.getDireccionElectronica(), 
        cliente.getDepartamento(), 
        cliente.getCodigoPostal(), 
        cliente.getCiudad(),
        cliente.getTipoDocumento());
        return "redirect:/cuentas";
    }

    @GetMapping("/clientes/{numDocumento}/delete")
    public String cuentaEliminar(@PathVariable("numDocumento") String id) {
        clienteRepository.eliminarCliente(id);
        return "redirect:/cuentas";
    }
    
}

