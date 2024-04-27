package com.bancandes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BancandesController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    
}
