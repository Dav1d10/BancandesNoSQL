package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.OperacionBancariaEntity;
import com.bancandes.repository.OperacionBancariaRepository;
import com.bancandes.servicios.OperacionesbancariasServicio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OperacionBancariaController {

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;

    @Autowired
    private OperacionesbancariasServicio operacionesbancariasServicio;

    @GetMapping("/operacionesbancarias")
    public String operacionesBancarias(Model model, Integer numero_cuenta) {
        if (numero_cuenta != null) {
            model.addAttribute("operacionesbancarias", operacionesbancariasServicio.darOperacionesBancariasPorCuentaEnLosUltimos30Dias(numero_cuenta));
        } else {
            model.addAttribute("operacionesbancarias", operacionBancariaRepository.darOperacionesBancarias());
        }
        return "operacionesbancarias";
    }

    @GetMapping("/operacionesbancarias/new")
    public String operacionBancariaForm(Model model) {
        model.addAttribute("operacionbancaria", new OperacionBancariaEntity());
        return "operacionbancariaNuevo";
    }

    @PostMapping("/operacionesbancarias/new/save")
    public String operacionBancariaGuardar(@ModelAttribute OperacionBancariaEntity operacionBancaria) {
        operacionBancariaRepository.insertarOperacionBancaria(operacionBancaria.getValor(), 
        operacionBancaria.getHora(),
        operacionBancaria.getFecha(),
        operacionBancaria.getProducto().name(),
        operacionBancaria.getTipo().name());
        return "redirect:/operacionesbancarias";
    }

    @GetMapping("/operacionesbancarias/{id}/edit")
    public String operacionBancariaEditarForm(@PathVariable("id") int id, Model model) {
        OperacionBancariaEntity operacionBancaria = operacionBancariaRepository.darOperacionBancaria(id);
        if (operacionBancaria != null) {
            model.addAttribute("operacionbancaria", operacionBancaria);
            return "operacionbancariaEditar";
        } else {
            return "redirect:/operacionesbancarias";
        }
    }

    @PostMapping("/operacionesbancarias/{id}/edit/save")
    public String operacionBancariaEditarGuardar(@PathVariable("id") int id, @ModelAttribute OperacionBancariaEntity operacionBancaria) {
        operacionBancariaRepository.actualizarOperacionBancaria(id,
        operacionBancaria.getValor(),
        operacionBancaria.getHora(),
        operacionBancaria.getFecha(),
        operacionBancaria.getProducto().name(),
        operacionBancaria.getTipo().name());
        return "redirect:/operacionesbancarias";
    }

    @GetMapping("/operacionesbancarias/{id}/delete")
    public String operacionBancariaEliminar(@PathVariable("id") int id) {
        operacionBancariaRepository.eliminarOperacionBancaria(id);
        return "redirect:/operacionesbancarias";
    }
    
}
