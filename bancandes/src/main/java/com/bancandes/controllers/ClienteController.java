package com.bancandes.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.ClienteEntity;
import com.bancandes.repository.ClienteRepository;
import com.bancandes.repository.ClienteRepository.RespuestaInfoCliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class ClienteController {


    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/clientes")
public String clientes(Model model, @RequestParam(required = false) String num_documento) {
    if (num_documento != null && !num_documento.isEmpty()) {
        Collection<RespuestaInfoCliente> info = clienteRepository.darClientePorNumDoc(num_documento);
        if (!info.isEmpty()) {
            RespuestaInfoCliente cliente = info.iterator().next();
            model.addAttribute("nombre", cliente.getNOMBRE());
            model.addAttribute("nombreOficina", cliente.getNOMBRE_OFICINA());
            model.addAttribute("numDocumento", cliente.getNUMERO_DOC());
            model.addAttribute("saldo", cliente.getSALDO());
            model.addAttribute("tipoCliente", cliente.getTIPO_CLIENTE());
            model.addAttribute("numCuenta", cliente.getNUM_CUENTA());
            model.addAttribute("numPrestamo", cliente.getNUM_PRESTAMO());
        }
    } else {
        model.addAttribute("clientes", clienteRepository.darClientes());
    }
    return "clientes";
}

    @GetMapping("/clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new ClienteEntity());
        return "clienteNuevo";
    }


    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute ClienteEntity cliente) {
        clienteRepository.insertarCliente(cliente.getNum_documento(), cliente.getTelefono(), cliente.getNombre(), 
        cliente.getNacionalidad(), cliente.getDireccion_fisica(), cliente.getDireccion_electronica(), cliente.getDepartamento(), cliente.getCodigo_postal(),
        cliente.getCiudad(), cliente.getTipo_documento().name());

        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{num_documento}/edit")
    public String clienteEditarForm(@PathVariable("num_documento") String id, Model model) {
        ClienteEntity cliente = clienteRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEditar";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{num_documento}/edit/save")
    public String clienteEditarGuardar(@PathVariable("num_documento") String id, @ModelAttribute ClienteEntity cliente) {
        clienteRepository.actualizarCliente(cliente.getNum_documento(), 
        cliente.getTelefono(), 
        cliente.getNombre(), 
        cliente.getNacionalidad(), 
        cliente.getDireccion_fisica(),
        cliente.getDireccion_electronica(), 
        cliente.getDepartamento(), 
        cliente.getCodigo_postal(), 
        cliente.getCiudad(),
        cliente.getTipo_documento().name());
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{num_documento}/delete")
    public String clienteEliminar(@PathVariable("num_documento") String id) {
        clienteRepository.eliminarCliente(id);
        return "redirect:/clientes";
    }
    
}

