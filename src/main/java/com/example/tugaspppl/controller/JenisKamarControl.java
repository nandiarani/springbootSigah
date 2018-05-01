package com.example.tugaspppl.controller;

import com.example.tugaspppl.dao.jenisKamar.JenisKamarDao;
import com.example.tugaspppl.model.JenisKamar;
import com.example.tugaspppl.service.JenisKamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Component
public class JenisKamarControl {
    @Autowired
    private JenisKamarService jenisKamarService;

    @RequestMapping(value = "/jenisKamar", method = RequestMethod.GET)
    public String tampilSemmuaJenisKamar(Model model){
        model = jenisKamarService.getAllJenisKamar(model);
        return "/admin/jenisKamar";
    }

    @RequestMapping(value = "/kamar/editHargaKamar/{id}",method = RequestMethod.GET)
    public String editHargaKamar(@PathVariable int id, Model model){
        model = jenisKamarService.manageEditJenisKamar(model, id);
        return "/admin/editJenisKamar";
    }
    @RequestMapping(value = "/kamar/editHargaKamar",method = RequestMethod.POST)
    public String editHargaJenisKamar(@ModelAttribute("jenisKamar")JenisKamar jenisKamar, Model model){

        return jenisKamarService.simpanJenisKamar(jenisKamar,model);
    }

}
