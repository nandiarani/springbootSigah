package com.example.tugaspppl.controller;

import com.example.tugaspppl.service.PelangganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class CustomerControl {
    @Autowired
    private PelangganService pelangganService;
    @RequestMapping(value = "/pelanggan", method = RequestMethod.GET)
    public String kamar(Model model){
        model=pelangganService.getAllPelanggan(model);
        return "/admin/pelanggan";
    }
}
