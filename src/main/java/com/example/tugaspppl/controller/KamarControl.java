package com.example.tugaspppl.controller;

import com.example.tugaspppl.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class KamarControl {

    @Autowired
    private KamarService kamarService;

    @RequestMapping(value = "/kamar", method = RequestMethod.GET)
    public String kamar(Model model){
        model=kamarService.getAllKamar(model);
        return "/admin/kamar";
    }
    @RequestMapping(value = "/editKamar/{id}",method = RequestMethod.GET)
    public String editStatus(@PathVariable int id){
        kamarService.softDeleteKamar(id);
        return "redirect:/kamar";
    }

}
