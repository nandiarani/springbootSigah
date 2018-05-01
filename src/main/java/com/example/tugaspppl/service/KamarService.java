package com.example.tugaspppl.service;

import com.example.tugaspppl.dao.kamar.KamarDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.transaction.Transactional;

@Service
@Transactional
public class KamarService {

    @Autowired
    private KamarDao kamarDao;

    public Model getAllKamar(Model model){

        model.addAttribute("kamar",kamarDao.findAll());
        return model;
    }
    public void softDeleteKamar(int id){
        kamarDao.softDelete(id);
    }
}
