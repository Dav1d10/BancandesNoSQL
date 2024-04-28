package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.ClienteEntity;
import com.bancandes.entities.PrestamoEntity;
import com.bancandes.repository.ClienteRepository;
import com.bancandes.repository.PideRepository;
import com.bancandes.repository.PrestamoRepository;
import com.bancandes.entities.PideEntity;
import com.bancandes.entities.PidePK;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PideController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private PideRepository pideRepository;

    @GetMapping("/pide/new")
    public String pideForm(Model model) {
        model.addAttribute("prestamos", prestamoRepository.darPrestamos());
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "pideNuevo";
    }
    
    @PostMapping("/pide/new/save")
    public String pideGuardar(@ModelAttribute("id_prestamo") int idPrestamo,
            @ModelAttribute("id_cliente") String idCliente) {

        ClienteEntity cliente = clienteRepository.darCliente(idCliente);
        PrestamoEntity prestamo = prestamoRepository.darPrestamo(idPrestamo);
        PidePK pk = new PidePK(prestamo, cliente);
        PideEntity pide = new PideEntity();
        pide.setPk(pk);
        pideRepository.insertarPide(pide.getPk().getId_cliente().getNum_documento(), pide.getPk().getId_prestamo().getId_prestamo());
        return "redirect:/clientes";
    } 
    
}
