package com.example.tugaspppl.service;

import com.example.tugaspppl.dao.jenisKamar.JenisKamarDao;
import com.example.tugaspppl.model.JenisKamar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;

@Service
@Transactional
public class JenisKamarService {
    @Autowired
    private JenisKamarDao jenisKamarDao;

    public Model getAllJenisKamar(Model model){
        model.addAttribute("JenisKamar",jenisKamarDao.findAll());
        return model;
    }
    public  Model manageEditJenisKamar(Model model, int id){
        model.addAttribute("JenisKamar",jenisKamarDao.findByIdJenisKamar(id));
        return model;
    }

    public String simpanJenisKamar(JenisKamar jenisKamar, Model model){
        jenisKamarDao.save(jenisKamar);
        return "redirect:/jenisKamar";
    }
}
