package com.bancandes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.bancandes.entities.OperacionBancariaEntity;
import com.bancandes.repository.OperacionBancariaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class OperacionBancariaController {

    @Autowired
    private OperacionBancariaRepository operacionBancariaRepository;

    @GetMapping("/operacionesbancarias")
    public String operacionesBancarias(Model model) {
        model.addAttribute("operacionesbancarias", operacionBancariaRepository.darOperacionesBancarias());
        return "operacionesbancarias";
    }

    @GetMapping("/operacionesbancarias/new")
    public String operacionBancariaForm(Model model) {
        model.addAttribute("operacionbancaria", new OperacionBancariaEntity());
        return "nuevaOperacionBancaria";
    }

    @PostMapping("/operacionesbancarias/new/save")
    public String operacionBancariaGuardar(@ModelAttribute OperacionBancariaEntity operacionBancaria) {
        operacionBancariaRepository.insertarOperacionBancaria(operacionBancaria.getValor(), 
        operacionBancaria.getHora(), 
        operacionBancaria.getFecha(),
        operacionBancaria.getProducto(),
        operacionBancaria.getTipo());
        return "redirect:/operacionesbancarias";
        
    }
    


    
}
