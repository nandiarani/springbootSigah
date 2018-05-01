package com.example.tugaspppl.service;

import com.example.tugaspppl.dao.fasilitas.FasilitasDao;
import com.example.tugaspppl.model.Fasilitas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;

@Service
@Transactional
public class FasilitasService {
    @Autowired
    private FasilitasDao fasilitasDao;

    public Model getAllFasilitas(Model model){
        model.addAttribute("fasilitas",fasilitasDao.findAll());
        return model;
    }
    public  Model manageEditFasilitas(Model model, int id){
        model.addAttribute("fasilitas",fasilitasDao.findByIdFasilitas(id));
        return model;
    }

    public String simpanFasilitas(Fasilitas fasilitas, Model model){
        fasilitasDao.save(fasilitas);
        return "redirect:/fasilitas";
    }
}
