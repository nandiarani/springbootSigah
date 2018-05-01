package com.example.tugaspppl.controller;

import com.example.tugaspppl.model.Fasilitas;
import com.example.tugaspppl.service.FasilitasService;
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
public class FasilitasController {
    @Autowired
    private FasilitasService fasilitasService;
    @RequestMapping(value = "/fasilitas", method = RequestMethod.GET)
    public String tampilSemmuaFasilitas(Model model){
        model = fasilitasService.getAllFasilitas(model);
        return "/admin/fasilitas";
    }

    @RequestMapping(value = "/fasilitas/editHargaFasilitas/{id}",method = RequestMethod.GET)
    public String editHargaKamar(@PathVariable int id, Model model){
        model = fasilitasService.manageEditFasilitas(model, id);
        return "/admin/editFasilitas";
    }
    @RequestMapping(value = "/fasilitas/editHargaFasilitas",method = RequestMethod.POST)
    public String editHargaJenisKamar(@ModelAttribute("fasilitas")Fasilitas fasilitas, Model model){
        return fasilitasService.simpanFasilitas(fasilitas,model);
    }
}
